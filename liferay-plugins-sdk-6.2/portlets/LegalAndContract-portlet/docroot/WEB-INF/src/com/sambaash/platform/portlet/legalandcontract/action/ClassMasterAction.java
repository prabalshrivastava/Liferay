package com.sambaash.platform.portlet.legalandcontract.action;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.search.ClassSearch;
import com.sambaash.platform.portlet.legalandcontract.util.ClassMasterBulkupload;
import com.sambaash.platform.portlet.legalandcontract.util.ClassMasterConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;
import com.sambaash.platform.srv.legalandcontract.service.ClassMasterLocalServiceUtil;


/**
 * Portlet implementation class ClassMasterAction
 */
public class ClassMasterAction extends MVCPortlet {
 

	 
	private static Log _log = LogFactoryUtil.getLog(ClassMasterAction.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		boolean editPermission = false;
		try {
			LegalPermissionUtil.authorize(renderRequest,ClassMasterConstants.PORTLET_ID,
					ClassMasterConstants.ACTION_KEY_ADD_CLASS);
			renderRequest.setAttribute("addClassPermission", true);
		} catch (Exception e) {
			_log.error(e);
		}
		ClassSearch search = new ClassSearch(renderRequest,renderResponse);
		SearchContainer searchContainer;
		try {
			searchContainer = search.search();
			renderRequest.setAttribute("searchContainer", searchContainer);
		} catch (PortalException e) {
		} 
		super.doView(renderRequest, renderResponse);
	}
	

	
	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String countryId = preferences.getValue(ClassMasterConstants.COUNTRY_VOC_ID, "0");
			String descriptionId = preferences.getValue(
					ClassMasterConstants.DESCRIPTION_VOC_ID, "0");
			String customList1Id = preferences.getValue(ClassMasterConstants.CUSTOM_LIST_1_VOC_ID,
					"0");
			String customList2Id = preferences.getValue(ClassMasterConstants.CUSTOM_LIST_2_VOC_ID,
					"0");

			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil
					.getAssetVocabularies(-1, -1);

			renderRequest.setAttribute(ClassMasterConstants.ASSET_VOCABULARIES, assetVocabularies);
			renderRequest.setAttribute(ClassMasterConstants.COUNTRY_VOC_ID,countryId);
			renderRequest.setAttribute(ClassMasterConstants.DESCRIPTION_VOC_ID,descriptionId);
			renderRequest.setAttribute(ClassMasterConstants.CUSTOM_LIST_1_VOC_ID, customList1Id);
			renderRequest.setAttribute(ClassMasterConstants.CUSTOM_LIST_2_VOC_ID, customList2Id);

		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}
		super.doEdit(renderRequest, renderResponse);
	}
	
	public void upload(ActionRequest actionRequest, ActionResponse actionResponse){
			try {
				ClassMasterBulkupload bu = new ClassMasterBulkupload(actionRequest, actionResponse);
                  bu.process();
			} catch (Exception e) {
				_log.error(e);
			}
	  }
	
	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		PortletPreferences preferences = actionRequest.getPreferences();
		String countryId = ParamUtil
				.getString(actionRequest, ClassMasterConstants.COUNTRY_VOC_ID);
		String descriptionId = ParamUtil.getString(actionRequest,
				ClassMasterConstants.DESCRIPTION_VOC_ID);
		String customList1Id = ParamUtil
				.getString(actionRequest, ClassMasterConstants.CUSTOM_LIST_1_VOC_ID);
		String customList2Id = ParamUtil
				.getString(actionRequest, ClassMasterConstants.CUSTOM_LIST_2_VOC_ID);

		try {
			preferences.setValue(ClassMasterConstants.COUNTRY_VOC_ID, countryId);
			preferences.setValue(ClassMasterConstants.DESCRIPTION_VOC_ID, descriptionId);
			preferences.setValue(ClassMasterConstants.CUSTOM_LIST_1_VOC_ID, customList1Id);
			preferences.setValue(ClassMasterConstants.CUSTOM_LIST_2_VOC_ID, customList2Id);
			preferences.store();
			Utils.saveSPParameter(SambaashConstants.CLASS_COUNTRY_VOC_ID, countryId);
			Utils.saveSPParameter(SambaashConstants.CLASS_DESCRIPTION_VOC_ID, descriptionId);
			Utils.saveSPParameter(SambaashConstants.CLASS_CUSTOM_LIST_1_VOC_ID, customList1Id);
			Utils.saveSPParameter(SambaashConstants.CLASS_CUSTOM_LIST_2_VOC_ID, customList2Id);
			
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}
	
	
	public void displayAddCLass(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {

		LegalPermissionUtil.authorize(actionRequest,ClassMasterConstants.PORTLET_ID,
				ClassMasterConstants.ACTION_KEY_ADD_CLASS); 
		fillCategoryLists(actionRequest);
		actionResponse.setRenderParameter("jspPage",
				"/html/spclass/addClass.jsp");
	}
	
	public void search(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {

		ClassSearch search = new ClassSearch(actionRequest, actionResponse); 
		SearchContainer searchContainer = search.search();
		actionRequest.setAttribute("searchContainer", searchContainer);
		actionResponse.setRenderParameter("jspPage",
				"/html/spclass/view.jsp");
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}
	
	public void displayEditClass(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {

		LegalPermissionUtil.authorize(actionRequest,ClassMasterConstants.PORTLET_ID,
				ClassMasterConstants.ACTION_KEY_EDIT_CLASS); 
		fillCategoryLists(actionRequest);
		long classId = ParamUtil.getLong(actionRequest, ClassMasterConstants.CLASS_ID);
		ClassMaster classMaster = ClassMasterLocalServiceUtil.getClassMaster(classId);
		actionRequest.setAttribute(ClassMasterConstants.CLASS_MASTER, classMaster);
		actionRequest.setAttribute(ClassMasterConstants.CUSTOM_DATE_1,Utils.getDateBean(classMaster.getCustomDate1()));
		actionRequest.setAttribute(ClassMasterConstants.CUSTOM_DATE_2,Utils.getDateBean(classMaster.getCustomDate2()));
	
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
				ClassMaster.class.getName(), classId);
		long categoryIds[] = assetEntry.getCategoryIds();
		categoryIds = ClassSearch.reorderCategoryIds(actionRequest.getPreferences(), categoryIds);
		actionRequest.setAttribute(ClassMasterConstants.CATEGORY_IDS, categoryIds);

		actionResponse.setRenderParameter("jspPage",
				"/html/spclass/editClass.jsp");
	}
	public void displayClassDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {
		
		long classId = ParamUtil.getLong(actionRequest, ClassMasterConstants.CLASS_ID);
		ClassSearch search = new ClassSearch(actionRequest,actionResponse);
		Map<String,String> map = search.getClassMap(classId);
		actionRequest.setAttribute(ClassMasterConstants.CLASS_MASTER, map);
		
		actionResponse.setRenderParameter("jspPage",
				"/html/spclass/details.jsp");
	}
		
    public void addClass(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception{

		try {
			LegalPermissionUtil.authorize(actionRequest,ClassMasterConstants.PORTLET_ID,
					ClassMasterConstants.ACTION_KEY_ADD_CLASS);
		} catch (Exception ex) {
			SessionErrors.add(actionRequest, "unauthorized.class.add");
			throw ex;
		} 
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			ClassMaster classMaster = ClassMasterLocalServiceUtil.getNewClassMaster();
			long[] categoryIds = getCategoryIds(actionRequest);
			fillClassMasterObject(classMaster, categoryIds[0],actionRequest);
			ClassMasterLocalServiceUtil.addNewClass(themeDisplay.getUserId(), classMaster,
					categoryIds);
			SessionMessages.add(actionRequest, "request_processed",
					"Class has been added");
			//TODO: Remove
		//	addClasses(classMaster, categoryIds, themeDisplay.getUserId(), actionRequest);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}
    
    private void addClasses(ClassMaster classMaster, long[] categoryId, long userId,
			ActionRequest actionRequest) throws Exception {
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ClassMaster.class.getName(), actionRequest);
		long groupId = serviceContext.getScopeGroupId();
		Date now = new Date();
		for (int i = 10; i < 100; i++) {
			ClassMaster newClass = ClassMasterLocalServiceUtil.getNewClassMaster();
			newClass.setCode(classMaster.getCode() + "  " + i);
			newClass.setFiledBy(classMaster.getFiledBy() + "  " + i);
			newClass.setCustomField1(classMaster.getCustomField1() + "  " + i);
			newClass.setCustomField2(classMaster.getCustomField2());
			newClass.setCustomDate1(classMaster.getCustomDate1());
			newClass.setCustomDate2(classMaster.getCustomDate2());
			newClass.setUuid(serviceContext.getUuid());
			newClass.setGroupId(groupId);
			newClass.setCreateDate(serviceContext.getCreateDate(now));
			newClass.setModifiedDate(serviceContext.getModifiedDate(now));

			// AgencyLocalServiceUtil.updateAgency(agency);

			ClassMasterLocalServiceUtil.addClass(userId, newClass,
					categoryId);	
			}
	}
    public void updateClass(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception{

    		try {
    			LegalPermissionUtil.authorize(actionRequest,ClassMasterConstants.PORTLET_ID,
    					ClassMasterConstants.ACTION_KEY_EDIT_CLASS);
    		} catch (Exception ex) {
    			SessionErrors.add(actionRequest, "unauthorized.class.edit");
    			throw ex;
    		} 
    		try {
    			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
    					.getAttribute(WebKeys.THEME_DISPLAY);
    			long oldClassId = ParamUtil.getLong(actionRequest, ClassMasterConstants.CLASS_ID);
    			ClassMaster newClassMaster =  ClassMasterLocalServiceUtil.getNewClassMaster();//ClassMasterLocalServiceUtil.getClassMaster(classId);
    			long[] categoryIds = getCategoryIds(actionRequest);
    			fillClassMasterObject(newClassMaster, categoryIds[0],actionRequest);
    			ClassMasterLocalServiceUtil.addNewClassVersion(themeDisplay.getUserId(), oldClassId,newClassMaster,
    					categoryIds);
    			SessionMessages.add(actionRequest, "request_processed",
    					"Class has been updated");
    		} catch (Exception e) {
    			_log.error(e.getMessage(), e);
    		}
    	}
    
    private long[] getCategoryIds(ActionRequest actionRequest){
    	long[] categoryIds = new long[ClassMasterConstants.CATEGORIES_IDS_SIZE];
    	categoryIds[0] = ParamUtil.getLong(actionRequest,ClassMasterConstants.COUNTRY_LIST);
    	categoryIds[1] = ParamUtil.getLong(actionRequest,ClassMasterConstants.DESCRIPTION);
    	categoryIds[2] = ParamUtil.getLong(actionRequest,ClassMasterConstants.CUSTOM_LIST_1);
    	categoryIds[3] = ParamUtil.getLong(actionRequest,ClassMasterConstants.CUSTOM_LIST_2);
    	
    	return categoryIds;
    	
    }

    private void fillClassMasterObject(ClassMaster classMaster, long countryCatId,ActionRequest actionRequest) throws PortalException, SystemException{
    	
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
    	
    	String classCode = ParamUtil.getString(actionRequest, ClassMasterConstants.CLASS_CODE);
    	String filedBy = ParamUtil.getString(actionRequest, ClassMasterConstants.FILED_BY);
    	String customField1 = ParamUtil.getString(actionRequest, ClassMasterConstants.CUSTOM_FIELD_1);
    	String customField2 = ParamUtil.getString(actionRequest, ClassMasterConstants.CUSTOM_FIELD_2);
    	
    	int customDay1 = ParamUtil.getInteger(actionRequest,ClassMasterConstants.CUSTOM_DATE_1_DAY );
		int customMonth1 = ParamUtil.getInteger(actionRequest,ClassMasterConstants.CUSTOM_DATE_1_MONTH );
		int customYear1 = ParamUtil.getInteger(actionRequest,ClassMasterConstants.CUSTOM_DATE_1_YEAR );
		Calendar customCal1 = Utils.getCalendar(themeDisplay, customDay1,
				customMonth1, customYear1);
		
		int customDay2 = ParamUtil.getInteger(actionRequest,ClassMasterConstants.CUSTOM_DATE_2_DAY );
		int customMonth2 = ParamUtil.getInteger(actionRequest,ClassMasterConstants.CUSTOM_DATE_2_MONTH );
		int customYear2 = ParamUtil.getInteger(actionRequest,ClassMasterConstants.CUSTOM_DATE_2_YEAR );
		Calendar customCal2 = Utils.getCalendar(themeDisplay, customDay2,
				customMonth2, customYear2);
		Date now = new Date();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				ClassMaster.class.getName(), actionRequest);
		String countryName = Utils.getCategoryName( countryCatId);

		classMaster.setCode(classCode);
		classMaster.setCountry(countryName);
		classMaster.setFiledBy(filedBy);
		classMaster.setCustomField1(customField1);
		classMaster.setCustomField2(customField2);
		classMaster.setCustomDate1(customCal1.getTime());
		classMaster.setCustomDate2(customCal2.getTime());
		
		if(classMaster.isNew()){
			classMaster.setUuid(serviceContext.getUuid());
		}
		classMaster.setGroupId(serviceContext.getScopeGroupId());
		classMaster.setModifiedDate(serviceContext.getModifiedDate(now));
    }
    
    private void fillCategoryLists(ActionRequest actionRequest) {
		PortletPreferences preferences = actionRequest.getPreferences();

		String countrVocId = preferences.getValue(ClassMasterConstants.COUNTRY_VOC_ID, "0");
		String descriptionVocId = preferences.getValue(ClassMasterConstants.DESCRIPTION_VOC_ID, "0");
		String customList1VocId = preferences.getValue(ClassMasterConstants.CUSTOM_LIST_1_VOC_ID, "0");
		String customList2VocId = preferences.getValue(ClassMasterConstants.CUSTOM_LIST_2_VOC_ID, "0");

		if (Validator.isNull(descriptionVocId)) {
			_log.info("Setup incomplete. Please ask admin to configure Description list");
		} else {

			List<AssetCategory> countryList = Utils.getCategories(Long
					.parseLong(countrVocId));
			List<AssetCategory> descriptionList = Utils.getCategories(Long
					.parseLong(descriptionVocId));
			List<AssetCategory> customList1 = Utils.getCategories(Long
					.parseLong(customList1VocId));
			List<AssetCategory> customList2 = Utils.getCategories(Long
					.parseLong(customList2VocId));
		
			actionRequest.setAttribute(ClassMasterConstants.COUNTRY_LIST, countryList);
			actionRequest.setAttribute(ClassMasterConstants.DESCRIPTION_LIST,
					descriptionList);
			actionRequest.setAttribute(ClassMasterConstants.CUSTOM_LIST_1, customList1);
			actionRequest.setAttribute(ClassMasterConstants.CUSTOM_LIST_2, customList2);
		
		}
	}
    


}
