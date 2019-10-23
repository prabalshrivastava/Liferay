package com.sambaash.platform.portlet.legalandcontract.action;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.WindowState;
import javax.portlet.WindowStateException;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.WordUtils;

import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.PortletURLFactoryUtil;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.model.AssetVocabulary;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.AssetVocabularyLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.reports.ReportGenerator;
import com.sambaash.platform.portlet.legalandcontract.reports.ReportPayload;
import com.sambaash.platform.portlet.legalandcontract.reports.ReportRecord;
import com.sambaash.platform.portlet.legalandcontract.schedular.RDLMailHelper;
import com.sambaash.platform.portlet.legalandcontract.schedular.RDLSchedular;
import com.sambaash.platform.portlet.legalandcontract.search.LegalContractSearch;
import com.sambaash.platform.portlet.legalandcontract.search.LitigationSearch;
import com.sambaash.platform.portlet.legalandcontract.search.TrademarksSearch;
import com.sambaash.platform.portlet.legalandcontract.util.DateBean;
import com.sambaash.platform.portlet.legalandcontract.util.FilesUpload;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.portlet.legalandcontract.util.LitigationBulkupload;
import com.sambaash.platform.portlet.legalandcontract.util.LitigationConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.UIUtils;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.Litigation;
import com.sambaash.platform.srv.legalandcontract.model.RDL;
import com.sambaash.platform.srv.legalandcontract.model.Trademarks;
import com.sambaash.platform.srv.legalandcontract.service.LitigationLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.RDLLocalServiceUtil;
import com.sambaash.platform.srv.legalandcontract.service.TrademarksLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class LitigationAction
 */
public class LitigationAction extends MVCPortlet {
	 
	private static Log _log = LogFactoryUtil.getLog(LitigationAction.class);
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		RDLSchedular rdlsl = new RDLSchedular();
		try {
		//	rdlsl.sendMails();
		} catch (Exception e1) {
			_log.error(e1.getMessage());
		}
		setAddPermission(renderRequest);
		boolean prefsAvailable = checkPreferences(renderRequest);
		renderRequest.setAttribute("prefsAvailable", prefsAvailable);
		if(prefsAvailable){
			long litigationId = GetterUtil.getLong(renderRequest.getParameter(LitigationConstants.LITIGATION_ID));
			String action = renderRequest.getParameter("actionp");
			if (litigationId != 0
					&& "displayLitigationDetails".equalsIgnoreCase(action)) {
				try {
					displayLitigationDetails(litigationId, renderRequest,
							renderResponse);
					include("/html/litigation/details.jsp", renderRequest,
							renderResponse);
				} catch (Exception e) {
				}
			}else if ("displayAddLitigation".equalsIgnoreCase(action)) {
				try {
					prepareUIElements(renderRequest, renderResponse);
					String rootTMId = renderRequest.getParameter("trademarkId");
					renderRequest.setAttribute(LitigationConstants.TRADEMARKS_ID, rootTMId);
					
					TrademarksSearch search = new TrademarksSearch(renderRequest, renderResponse);
					String latestTmId = getLatestTrademarkId(rootTMId, search);
					renderRequest.setAttribute(LitigationConstants.TRADEMARK_TEXT, getTrademarkString(rootTMId, renderRequest, search, true));
					String tmUrl = Utils.getTrademarkDetailsFriendlyUrl(latestTmId);
					renderRequest.setAttribute(LitigationConstants.TRADEMARK_URL, tmUrl);
					
					include("/html/litigation/addLitigation.jsp", renderRequest,
							renderResponse);
				} catch (Exception e) {
				}
			} else {
			try {
				LegalPermissionUtil.authorize(renderRequest,LitigationConstants.PORTLET_ID,
						LitigationConstants. ACTION_KEY_BULKUPLOAD_LITIGATION); 
				renderRequest.setAttribute("bulkuploadLitigaitonPermission", true);
			} catch (Exception e) {
				_log.error(e);
			}
			
			LitigationSearch search = new LitigationSearch(renderRequest, renderResponse);
			try {
				renderRequest.setAttribute("searchContainer", search.search());
				setAddLitigationUrl(search, renderRequest);
			} catch (PortalException e) {
			}
			super.doView(renderRequest, renderResponse);
			}
		}
	}
	private void setAddPermission(PortletRequest request){
		try {
			LegalPermissionUtil.authorize(request,LitigationConstants.PORTLET_ID,
					LitigationConstants. ACTION_KEY_ADD_LITIGATION); 
			request.setAttribute("addLitigaitonPermission", true);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	private boolean checkPreferences(PortletRequest request){
		PortletPreferences preferences = request.getPreferences();
		String proceedingTypVocId = preferences.getValue(LitigationConstants.PROCEEDING_TYPE_VOC_ID, "");
		//String filedAtCountryVocId = preferences.getValue(LitigationConstants.FILED_AT_COUNTRY_VOC_ID, "");
		String alerBeforeVocId = preferences.getValue(LitigationConstants.ALERT_BEFORE_VOC_ID, "");
		boolean prefsAvailable = true;
		if(Validator.isNull(proceedingTypVocId) ||  Validator.isNull(alerBeforeVocId)){
			prefsAvailable = false;
		}
		return prefsAvailable;
	}
	
	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {
			PortletPreferences preferences = renderRequest.getPreferences();
			String proceedingTypVocId = preferences.getValue(LitigationConstants.PROCEEDING_TYPE_VOC_ID, "0");
			//String filedAtCountryVocId = preferences.getValue(LitigationConstants.FILED_AT_COUNTRY_VOC_ID, "0");
			String alerBeforeVocId = preferences.getValue(LitigationConstants.ALERT_BEFORE_VOC_ID, "0");
			/*String customList1VocId = preferences.getValue(LitigationConstants.CUSTOM_LIST_1_VOC_ID, "0");
			String customList2VocId = preferences.getValue(LitigationConstants.CUSTOM_LIST_2_VOC_ID, "0");
			String customList3VocId = preferences.getValue(LitigationConstants.CUSTOM_LIST_3_VOC_ID, "0"); */

			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil
					.getAssetVocabularies(-1, -1);

			renderRequest.setAttribute(LitigationConstants.ASSET_VOCABULARIES, assetVocabularies);
			renderRequest.setAttribute(LitigationConstants.PROCEEDING_TYPE_VOC_ID,proceedingTypVocId);
			//renderRequest.setAttribute(LitigationConstants.FILED_AT_COUNTRY_VOC_ID,filedAtCountryVocId);
			renderRequest.setAttribute(LitigationConstants.ALERT_BEFORE_VOC_ID,alerBeforeVocId);
			/*renderRequest.setAttribute(LitigationConstants.CUSTOM_LIST_1_VOC_ID, customList1VocId);
			renderRequest.setAttribute(LitigationConstants.CUSTOM_LIST_2_VOC_ID, customList2VocId);
			renderRequest.setAttribute(LitigationConstants.CUSTOM_LIST_3_VOC_ID, customList3VocId); */
			} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}
		super.doEdit(renderRequest, renderResponse);
	}
	
	public void upload(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		try {
			LegalPermissionUtil.authorize(actionRequest,
					LitigationConstants.PORTLET_ID,
					LitigationConstants.ACTION_KEY_BULKUPLOAD_LITIGATION);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "unauthorized.litigation.bulkupload");
			throw e;
		}

		try {
			LitigationBulkupload bu = new LitigationBulkupload(actionRequest,
					actionResponse);
			bu.process();
		} catch (Exception e) {
			_log.error(e);
		}
	}
	
	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		PortletPreferences preferences = actionRequest.getPreferences();
		String proceedingTypVocId = ParamUtil.getString(actionRequest,	LitigationConstants.PROCEEDING_TYPE_VOC_ID);
		//String filedAtCountryVocId = ParamUtil.getString(actionRequest,	LitigationConstants.FILED_AT_COUNTRY_VOC_ID);
		String alerBeforeVocId = ParamUtil.getString(actionRequest,	LitigationConstants.ALERT_BEFORE_VOC_ID);
		/*String customList1VocId = ParamUtil.getString(actionRequest, LitigationConstants.CUSTOM_LIST_1_VOC_ID);
		String customList2VocId = ParamUtil.getString(actionRequest, LitigationConstants.CUSTOM_LIST_2_VOC_ID);
		String customList3VocId = ParamUtil.getString(actionRequest, LitigationConstants.CUSTOM_LIST_3_VOC_ID);
*/
		try {
			preferences.setValue(LitigationConstants.PROCEEDING_TYPE_VOC_ID, proceedingTypVocId);
			//preferences.setValue(LitigationConstants.FILED_AT_COUNTRY_VOC_ID, filedAtCountryVocId);
			preferences.setValue(LitigationConstants.ALERT_BEFORE_VOC_ID, alerBeforeVocId);
			/*preferences.setValue(LitigationConstants.CUSTOM_LIST_1_VOC_ID, customList1VocId);
			preferences.setValue(LitigationConstants.CUSTOM_LIST_2_VOC_ID, customList2VocId);
			preferences.setValue(LitigationConstants.CUSTOM_LIST_3_VOC_ID, customList3VocId); */
			preferences.store();
			
			Utils.saveSPParameter(SambaashConstants.LITIGATION_PROCEEDING_TYPE_VOC_ID, proceedingTypVocId);
		//	Utils.saveSPParameter(SambaashConstants.LITIGATION_FILED_AT_COUNTRY_VOC_ID, filedAtCountryVocId);
			Utils.saveSPParameter(SambaashConstants.LITIGATION_ALERT_BEFOR_VOC_ID, alerBeforeVocId);
			/*Utils.saveSPParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_1_VOC_ID, customList1VocId);
			Utils.saveSPParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_2_VOC_ID, customList2VocId);
			Utils.saveSPParameter(SambaashConstants.LITIGATION_CUSTOM_LIST_3_VOC_ID, customList3VocId); */

			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}
	
	
	public void displayAddLitigation(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		try {
			LegalPermissionUtil.authorize(actionRequest,
					LitigationConstants.PORTLET_ID,
					LitigationConstants.ACTION_KEY_ADD_LITIGATION);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "unauthorized.litigation.add");
			throw e;
		}
		DateBean dateBean = Utils.getDateBean(null);
		actionRequest.setAttribute(LitigationConstants.FILED_ON_DATE,dateBean);
		actionRequest.setAttribute(LitigationConstants.RESPONSE_DEADLINE,dateBean);
	//	actionRequest.setAttribute(LitigationConstants.ACTUAL_RESPONSE_DATE,dateBean);
	/*	actionRequest.setAttribute(LitigationConstants.CUSTOM_DATE_1,dateBean);
		actionRequest.setAttribute(LitigationConstants.CUSTOM_DATE_2,dateBean);
		actionRequest.setAttribute(LitigationConstants.CUSTOM_DATE_3,dateBean); */
		fillCategoryLists(actionRequest,actionResponse);

		setFilesList(actionRequest, 0,false);
		
		actionResponse.setRenderParameter("jspPage",
				"/html/litigation/addLitigation.jsp");
		
		setRegionPermission(actionRequest);
		
		actionRequest.setAttribute(LitigationConstants.RDLS_COUNT, 0);
		
		//First Value is blank, so correponding Trademark text and url must be 
		actionRequest.setAttribute(LitigationConstants.TRADEMARK_TEXT, StringPool.BLANK);
		actionRequest.setAttribute(LitigationConstants.TRADEMARK_URL, StringPool.BLANK);
		
		LegalContractSearch.copySearchParamsToResponse(actionRequest, actionResponse);
	}
	
	public void prepareUIElements(PortletRequest request,
			PortletResponse response) throws Exception {
		try {
			LegalPermissionUtil.authorize(request,
					LitigationConstants.PORTLET_ID,
					LitigationConstants.ACTION_KEY_ADD_LITIGATION);
		} catch (Exception e) {
			SessionErrors.add(request, "unauthorized.litigation.add");
			throw e;
		}
		DateBean dateBean = Utils.getDateBean(new Date());
		request.setAttribute(LitigationConstants.FILED_ON_DATE,dateBean);
		request.setAttribute(LitigationConstants.RESPONSE_DEADLINE,dateBean);
/*		request.setAttribute(LitigationConstants.CUSTOM_DATE_1,dateBean);
		request.setAttribute(LitigationConstants.CUSTOM_DATE_2,dateBean);
		request.setAttribute(LitigationConstants.CUSTOM_DATE_3,dateBean); */
		fillCategoryLists(request,response);

		setFilesList(request, 0,false);
		setRegionPermission(request);
	}
	
	@SuppressWarnings("unchecked")
	public void serveResource(ResourceRequest resourceRequest,
	        ResourceResponse resourceResponse)
	    throws  IOException, PortletException {
		
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			String action = ParamUtil.getString(resourceRequest, "action");
			JSONObject data = JSONFactoryUtil.createJSONObject();
			String errMsg = "success";
			if ("getTrademark".equals(action)) {
				String rootTmId = ParamUtil.getString(resourceRequest, "tmId");
				TrademarksSearch search = new TrademarksSearch(resourceRequest, resourceResponse);
				String latestTmId = getLatestTrademarkId(rootTmId, search);
				String str = this.getTrademarkString(rootTmId, resourceRequest, search, true);
				data.put(LitigationConstants.TRADEMARK_TEXT, str);
				String tmUrl = Utils.getTrademarkDetailsFriendlyUrl(latestTmId);
				data.put(LitigationConstants.TRADEMARK_URL, tmUrl);
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			} else if("removeFile".equals(action)){
				long fileEntryId = ParamUtil.getLong(resourceRequest, "fileEntryId");
				try{
					DLAppServiceUtil.deleteFileEntry(fileEntryId);
				}catch(Exception ex){
					errMsg = "File Deletion Failed.";
					_log.error(ex);
				}
				data.put("errorMsg", errMsg);
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}else if("exportListPdf".equals(action)){
				try{
					String path = exportLitigationList(resourceRequest, resourceResponse);
					data.put("fileName", path);
				}catch(Exception ex){
					data.put("errorMsg", "Error while generating the report");
				}
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}else if("exportDetailsPdf".equals(action)){
				try{
					String path = exportLitigationDetails(resourceRequest, resourceResponse);
					data.put("fileName", path);
				}catch(Exception ex){
					data.put("errorMsg", "Error while generating the report");
				}
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}else if("exportListXls".equals(action)){
				try{
					String path = exportLitigationListXls(resourceRequest, resourceResponse);
					data.put("fileName", path);
				}catch(Exception ex){
					data.put("errorMsg", "Error while generating the report");
				}
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}else if("exportDetailsXls".equals(action)){
				try{
					String path = exportLitigationDetailsXls(resourceRequest, resourceResponse);
					data.put("fileName", path);
				}catch(Exception ex){
					data.put("errorMsg", "Error while generating the report");
				}
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}
			else{
				try{
					Object objs[] = Utils.parseRequest(resourceRequest, resourceResponse);
					Map<String, String> paramMap = (Map<String, String>) objs[0];
					List<FileItem> files = (List<FileItem>) objs[1];
					Object temp[] = seperateAttachements(files);
					String folderName = Utils.getUserFolderName(themeDisplay.getUserId());
					long[] folderIds = LitigationSearch.getFolderIds(resourceRequest, folderName);
					FilesUpload fu;
					List<FileEntry>fileList;
					
					List<FileItem> attachments = (List<FileItem>)temp[0];
					if(attachments.size() > 0 ){
						 fu = new FilesUpload(); 
						fileList = fu.uploadDocuments(resourceRequest,attachments ,folderIds[0]);
						if(fu.getFailedCount() > 0 ){
							errMsg = fu.getErrorMessage(attachments.get(0));
						}
						if(fileList.size() > 0){ 
							data.put("fileEntryId",fileList.get(0).getFileEntryId() );
						}
					}
					List<FileItem> confAttachments = (List<FileItem>)temp[1];
					if(confAttachments.size() > 0){
						 fu = new FilesUpload();
						fileList = fu.uploadDocuments(resourceRequest, confAttachments ,folderIds[1]);
						if(fu.getFailedCount() > 0 ){
							errMsg = fu.getErrorMessage(confAttachments.get(0));
						}
						if(fileList.size() > 0){ 
							data.put("fileEntryId",fileList.get(0).getFileEntryId() );
						}
					}
					
				}catch(Exception ex){
					_log.error(ex.getMessage(), ex);
					 errMsg = "File upload failed" ;
				}
				data.put("errorMsg", errMsg);
				resourceResponse.setContentType("application/json");
				resourceResponse.setCharacterEncoding("utf-8");
				resourceResponse.getWriter().write(data.toString());
			}
			//super.serveResource(resourceRequest, resourceResponse);

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}
	
	private Object[] seperateAttachements(List<FileItem> files){
		Object [] objs = new Object[2];
		List<FileItem> attachments = new ArrayList<FileItem>();
		List<FileItem> confAttachments = new ArrayList<FileItem>();
		String fieldName ;
		for (FileItem fileItem : files) {
			if(!Utils.nullOrEmpty(fileItem.getName())){
				fieldName = fileItem.getFieldName();
				if(fieldName.endsWith(TrademarksConstants.CONF_ATTACHMENTS)){
					confAttachments.add(fileItem);
				}else if(fieldName.endsWith(TrademarksConstants.ATTACHMENTS)){
					attachments.add(fileItem);
				}
			}
		}
		objs[0] = attachments;
		objs[1] = confAttachments;
		return objs;
	}
	
	public String exportLitigationListXls(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse){
		String fileName = Utils.generateExportFileName(resourceRequest, "contentious_proceedings" , ".xlsx");
		ReportGenerator generator = ReportGenerator.getExcelGenerator();
		generateListReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}
	
	public String exportLitigationList(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse){
		String fileName = Utils.generateExportFileName(resourceRequest, "contentious_proceedings" , ".pdf");
		ReportGenerator generator = ReportGenerator.getPdfGenerator("litigations", "litigationList", (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY));
		generateListReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}
	
	private void generateListReport(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, String fileName, ReportGenerator generator) {
		LitigationSearch search = new LitigationSearch(resourceRequest,
				resourceResponse);
		
		TrademarksSearch tmsearch = new TrademarksSearch(resourceRequest,
				resourceResponse);
		
		List<Document> litigations = search.getLitigations();
		List<ReportRecord> list = new ArrayList<ReportRecord>();
		long proceedingVocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_PROCEEDING_TYPE_VOC_ID, 0));
//		long alertVocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.LITIGATION_ALERT_BEFOR_VOC_ID, 0));
		for (Document doc : litigations) {
			long litigationId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			ReportRecord wrap = new ReportRecord();
			String logoId = getTrademarksLogoFileEntryId(doc.get(TrademarksConstants.TRADEMARKS_ID), resourceRequest, tmsearch);
			wrap.addExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID,logoId);
			Map<String, String> map = new LinkedHashMap<String, String>();
			List<Long>	catIds = Utils.getCategoryIds(doc);   
			
			TrademarksSearch tsearch = new TrademarksSearch(resourceRequest,resourceResponse);
			String tmId = GetterUtil.getString(doc.get(TrademarksConstants.TRADEMARKS_ID));
			map.put(LitigationConstants.TRADEMARK_APPNO_COUNTRY,tsearch.getTrademarkApplicationNumCountryByRootTrademarkId(tmId));
			map.put(TrademarksConstants.TRADEMARK_COLUMN, getTrademarkString(tmId, resourceRequest,tsearch, false));
			map.put(LitigationConstants.PROCEEDING_TYPE_COLUMN, Utils.getCategoryName(proceedingVocId,catIds));
			map.put(LitigationConstants.FILED_BY_COLUMN,doc.get(LitigationConstants.FILED_BY));
			map.put(LitigationConstants.FILED_ON_COLUMN,Utils.getDateStrYMD(doc, LitigationConstants.FILED_ON_DATE));
			map.put(LitigationConstants.THRID_PARTY_APP_NUMBER_COLUMN,doc.get(LitigationConstants.THRID_PARTY_APP_NUMBER));
			
			RDL rdl = LitigationSearch.getLatestRDL(litigationId);
			if(Validator.isNotNull(rdl)){
				//map.put(LitigationConstants.CLAIMS_REMARKS_COLUMN, rdl.getClaimsRemarks());
				map.put(LitigationConstants.RESPONSE_DEADLINE_COLUMN,Utils.getDateStrYMD(rdl.getResponseDeadline()));
			//	map.put(LitigationConstants.ALERT_BEFORE_COLUMN, Utils.getCategoryName(rdl.getAlertBefore()));
				
			}else{
				//map.put(LitigationConstants.CLAIMS_REMARKS_COLUMN, "");
				map.put(LitigationConstants.RESPONSE_DEADLINE_COLUMN,"");
			//	map.put(LitigationConstants.ALERT_BEFORE_COLUMN, "");
			}
			
			map.put(LitigationConstants.STATUS_COLUMN,doc.get(LitigationConstants.STATUS));
			map.put(WordUtils.capitalize(LitigationConstants.VERSION), doc.get(LitigationConstants.VERSION));
			String latestTmId = getLatestTrademarkId(tmId, tsearch);
			String tmUrl = Utils.getTrademarkDetailsFriendlyUrl(latestTmId);
			map.put(LitigationConstants.DETAILS_LINK + "_TM", tmUrl);
			
			map.put(LitigationConstants.DETAILS_LINK,Utils.getLitigationDetailsFriendlyUrl(litigationId));
			
			
//			map.put(LitigationConstants.CUSTOM_FIELD_1,getEscapedString(doc.get(LitigationConstants.CUSTOM_FIELD_1)));
//			map.put(LitigationConstants.CUSTOM_FIELD_2,getEscapedString(doc.get(LitigationConstants.CUSTOM_FIELD_2)));
//			map.put(LitigationConstants.CUSTOM_FIELD_3,getEscapedString(doc.get(LitigationConstants.CUSTOM_FIELD_3)));
//			map.put(LitigationConstants.CUSTOM_DATE_1,Utils.getDateStrYMD(doc, LitigationConstants.CUSTOM_DATE_1));
//			map.put(LitigationConstants.CUSTOM_DATE_2,Utils.getDateStrYMD(doc, LitigationConstants.CUSTOM_DATE_2));
//			map.put(LitigationConstants.CUSTOM_DATE_3,Utils.getDateStrYMD(doc, LitigationConstants.CUSTOM_DATE_3));
//			map.put(LitigationConstants.CUSTOM_LIST_1,getEscapedString(Utils.getCategoryName(catIds[3])));
//			map.put(LitigationConstants.CUSTOM_LIST_2,getEscapedString(Utils.getCategoryName(catIds[4])));
//			map.put(LitigationConstants.CUSTOM_LIST_3,getEscapedString(Utils.getCategoryName(catIds[5])));
//			map.put(LitigationConstants.LATEST, getEscapedString(doc.get(LitigationConstants.LATEST)));
//			map.put(LitigationConstants.ROOT_LITIGATION_ID, getEscapedString(doc.get(LitigationConstants.ROOT_LITIGATION_ID)));
			wrap.setDataMap(map);
			list.add(wrap);
		}
		ReportPayload payload = new ReportPayload();
		payload.useDefaultMap();
		payload.setRecList(list);
		payload.setType(ReportGenerator.LITIGATION_LISTING);
		try {
			generator.generateReport(payload, new File(fileName));
		} catch (Exception e) {
			_log.error("Error while creating pdf file", e);
		}
	}
	
	private void generateDetailsReport(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, String fileName, ReportGenerator generator) {
		long litigationId = ParamUtil.getLong(resourceRequest,
				LitigationConstants.LITIGATION_ID);
		LitigationSearch search = new LitigationSearch(resourceRequest,
				resourceResponse);
		TrademarksSearch tsearch = new TrademarksSearch(resourceRequest,
				resourceResponse);
		
		Litigation litigation1;
		try {
			litigation1 = LitigationLocalServiceUtil.getLitigation(litigationId);
			Map<String, String> litigation = search.getLitigationMap(litigation1,false);
		Map<String, String> map = new LinkedHashMap<String, String>();
//		map.put(LitigationConstants.LITIGATION_ID,getEscapedString(litigation.get(LitigationConstants.LITIGATION_ID)));
		map.put(LitigationConstants.TRADEMARK_APPNO_COUNTRY,litigation.get(TrademarksConstants.TRADEMARK));
		map.put(TrademarksConstants.TRADEMARK_COLUMN, getTrademarkString(String.valueOf(litigation1.getSpTrademarksId()),resourceRequest,tsearch, false));
		map.put(LitigationConstants.PROCEEDING_TYPE_COLUMN, GetterUtil.getString(litigation.get(LitigationConstants.PROCEEDING_TYPE)));
		map.put(LitigationConstants.STATUS_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.STATUS)));
		map.put(LitigationConstants.VERSION,GetterUtil.getString(litigation.get(LitigationConstants.VERSION)));
		map.put(LitigationConstants.FILED_BY_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.FILED_BY)));
		map.put(LitigationConstants.FILED_ON_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.FILED_ON_DATE)));
//		map.put(LitigationConstants.CLAIMS_REMARKS_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.CLAIMS_REMARKS)));
//		map.put(LitigationConstants.RESPONSE_DEADLINE_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.RESPONSE_DEADLINE)));
//		map.put(LitigationConstants.ALERT_BEFORE_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.ALERT_BEFORE)));
		map.put(LitigationConstants.LAW_FIRM_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.LAW_FIRM)));
		map.put(LitigationConstants.THRID_PARTY_APP_NUMBER_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.THRID_PARTY_APP_NUMBER)));
		map.put(LitigationConstants.UPDATE_BY_COLUMN, GetterUtil.getString(litigation.get(TrademarksConstants.UPDATE_BY)));
		map.put(LitigationConstants.MODIFIED_DATE_COLUMN, GetterUtil.getString(litigation.get(TrademarksConstants.MODIFIED_DATE)));
		map.put(LegalConstants.INTERNAL_REF_NUM, String.valueOf(litigationId));
		//map.put(LitigationConstants.CUSTOM_FIELD_3_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.CUSTOM_FIELD_3)));
	/*	map.put(LitigationConstants.CUSTOM_DATE_1_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.CUSTOM_DATE_1)));
		map.put(LitigationConstants.CUSTOM_DATE_2_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.CUSTOM_DATE_2)));
		map.put(LitigationConstants.CUSTOM_DATE_3_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.CUSTOM_DATE_3)));
		map.put(LitigationConstants.CUSTOM_LIST_1_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.CUSTOM_LIST_1)));
		map.put(LitigationConstants.CUSTOM_LIST_2_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.CUSTOM_LIST_2)));
		map.put(LitigationConstants.CUSTOM_LIST_3_COLUMN,GetterUtil.getString(litigation.get(LitigationConstants.CUSTOM_LIST_3))); */
//		map.put(LitigationConstants.LATEST, getEscapedString(litigation.get(LitigationConstants.LATEST)));
//		map.put(LitigationConstants.ROOT_LITIGATION_ID, getEscapedString(litigation.get(LitigationConstants.ROOT_LITIGATION_ID)));

		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		boolean authorized = false;
		try {
			authorized = LegalPermissionUtil
					.isUserHavingRegionalRole(themeDisplay.getUserId());
			if (authorized)
				map.put(TrademarksConstants.LEGAL_CONF_REMARKS_COLUMN,
						litigation.get(TrademarksConstants.LEGAL_CONF_REMARKS));
		} catch (Exception e) {
		}
		
		List<Map<String, String>> deadlineFields = ToListofMap(RDLLocalServiceUtil.findBylitigationId(litigationId), false);
		
		int i = 1;
		for (Map<String, String> dlMap : deadlineFields) {
			map.put(LitigationConstants.RESPONSE_DEADLINE_COLUMN + " #" + i,
					dlMap.get(LitigationConstants.RESPONSE_DEADLINE)
							+ "~~"
							+ dlMap.get(LitigationConstants.ALERT_BEFORE));
			map.put(LitigationConstants.CLAIMS_REMARKS_COLUMN + " #" + i++,
					dlMap.get(LitigationConstants.CLAIMS_REMARKS));
		}

		ReportRecord rec = new ReportRecord();
		rec.setDataMap(map);
		String logoId = getTrademarksLogoFileEntryId(String.valueOf(litigation1.getSpTrademarksId()), resourceRequest, tsearch);
		rec.addExtraData(TrademarksConstants.LOGO_FILE_ENTRY_ID,logoId);
		
		List<ReportRecord> list = new ArrayList<ReportRecord>();
		list.add(rec);
		
		ReportPayload payload = new ReportPayload();
		payload.useDefaultMap();
		payload.setRecList(list);
		payload.setType(ReportGenerator.LITIGATION_DETAILS);
		try {
			generator.generateReport(payload, new File(fileName));
		} catch (Exception e) {
			_log.error("Error while creating pdf file", e);
		}
		} catch (PortalException | SystemException e1) {
			_log.error(e1.getMessage());
		}
		
	}
	public String exportLitigationDetails(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String fileName = Utils.generateExportFileName(resourceRequest, "contentious_proceeding_details", ".pdf");
		ReportGenerator generator = ReportGenerator.getPdfGenerator("litigationDetails", "litigation", (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY));
		this.generateDetailsReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}
	
	public String exportLitigationDetailsXls(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String fileName = Utils.generateExportFileName(resourceRequest, "contentious_proceeding_details", ".xlsx");
		ReportGenerator generator = ReportGenerator.getExcelGenerator();
		this.generateDetailsReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}
	

	public void displayEditLitigation(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		try {
			LegalPermissionUtil.authorize(actionRequest,
					LitigationConstants.PORTLET_ID,
					LitigationConstants.ACTION_KEY_EDIT_LITIGATION);
		} catch (Exception e) {
			SessionErrors.add(actionRequest, "unauthorized.litigation.edit");
			throw e;
		}		
		fillCategoryLists(actionRequest,actionResponse);
		long litigationId = ParamUtil.getLong(actionRequest, LitigationConstants.LITIGATION_ID);
		Litigation litigation = LitigationLocalServiceUtil.getLitigation(litigationId);
		//litigation.setClaimsRemarks("");
		actionRequest.setAttribute(LitigationConstants.TRADEMARKS_ID, String.valueOf(litigation.getSpTrademarksId()));
		TrademarksSearch search = new TrademarksSearch(actionRequest,actionResponse);
		String latestTmId = getLatestTrademarkId(String.valueOf(litigation.getSpTrademarksId()), search);
		actionRequest.setAttribute(LitigationConstants.TRADEMARK_TEXT, getTrademarkString(String.valueOf(litigation.getSpTrademarksId()), actionRequest, search, true));
		String tmUrl = Utils.getTrademarkDetailsFriendlyUrl(latestTmId);
		actionRequest.setAttribute(LitigationConstants.TRADEMARK_URL, tmUrl);
		actionRequest.setAttribute(LitigationConstants.LITIGATION, litigation);
		actionRequest.setAttribute(LitigationConstants.LITIGATION_ID, litigationId);
		actionRequest.setAttribute(LitigationConstants.FILED_ON_DATE,Utils.getDateBean(litigation.getFiledOn()));
		actionRequest.setAttribute(LitigationConstants.RESPONSE_DEADLINE,Utils.getDateBean(null));
		//actionRequest.setAttribute(LitigationConstants.ACTUAL_RESPONSE_DATE,Utils.getDateBean(litigation.getActualResponseDate()));
	/*	actionRequest.setAttribute(LitigationConstants.CUSTOM_DATE_1,Utils.getDateBean(litigation.getCustomDate1()));
		actionRequest.setAttribute(LitigationConstants.CUSTOM_DATE_2,Utils.getDateBean(litigation.getCustomDate2()));
		actionRequest.setAttribute(LitigationConstants.CUSTOM_DATE_3,Utils.getDateBean(litigation.getCustomDate3())); */
		List<RDL>rdls = RDLLocalServiceUtil.findBylitigationId(litigationId);
		
		List<Map<String, String>> lm= ToListofMap(rdls, false);
		actionRequest.setAttribute(LitigationConstants.RDLS, lm);
		//It's not necessarly be  rdls.size() + 5, it can be anything > rdls.size(). Used in jsp to generate new index.
		actionRequest.setAttribute(LitigationConstants.RDLS_COUNT, rdls.size() + 5);
	
		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
				Litigation.class.getName(), litigationId);
		long categoryIds[] = assetEntry.getCategoryIds();
	//	categoryIds = LitigationSearch.reorderCategoryIds(actionRequest.getPreferences(), categoryIds);
	//	actionRequest.setAttribute(LitigationConstants.CATEGORY_IDS, categoryIds);

		PortletPreferences prefs = actionRequest.getPreferences();
		actionRequest.setAttribute("proceddingsCatId", Utils.getCategoryId(prefs, LitigationConstants.PROCEEDING_TYPE_VOC_ID, categoryIds));
		//actionRequest.setAttribute("alertBeforeCatId", Utils.getCategoryId(prefs, LitigationConstants.ALERT_BEFORE_VOC_ID, categoryIds));
/*		actionRequest.setAttribute("customList1CatId", Utils.getCategoryId(prefs, LitigationConstants.CUSTOM_LIST_1_VOC_ID, categoryIds));
		actionRequest.setAttribute("customList2CatId", Utils.getCategoryId(prefs, LitigationConstants.CUSTOM_LIST_2_VOC_ID, categoryIds));
		actionRequest.setAttribute("customList3CatId", Utils.getCategoryId(prefs, LitigationConstants.CUSTOM_LIST_3_VOC_ID, categoryIds)); */
		
		setFilesList(actionRequest, litigation.getRootSpLitigationId(),false);
		setRegionPermission(actionRequest);
		actionResponse.setRenderParameter("jspPage",
				"/html/litigation/editLitigation.jsp");
		
		LegalContractSearch.copySearchParamsToResponse(actionRequest, actionResponse);
	}
	
	private List<Map<String, String>> ToListofMap(List<RDL> rdls,boolean convertNLToBr){
		List<Map<String, String>> lm = new ArrayList<Map<String,String>>();
		Map<String, String> map;
		String remarks;
	//	List<RDL>copiedList = new ArrayList<RDL>();
		if(Validator.isNotNull(rdls)){
		//	Collections.sort(rdls,new RdlComparator());
			for (int i =0 ; i < rdls.size(); i++) {
				RDL rdl = rdls.get(i);
				map = new HashMap<String, String>();
				map.put(LitigationConstants.RESPONSE_DEADLINE, Utils.getDateStrYMD(rdl.getResponseDeadline()));
				map.put(LitigationConstants.ALERT_BEFORE, Utils.getCategoryName(rdl.getAlertBefore()));
				remarks = rdl.getClaimsRemarks();
				//Conversion requiered in view page but not update
				if(convertNLToBr){
					remarks = Utils.toHtmlTags(remarks);
				}
				map.put(LitigationConstants.CLAIMS_REMARKS,remarks );
				Date date = rdl.getResponseDeadline();//Utils.getDate4rDDMMMYYYY(obj.getString(LitigationConstants.RESPONSE_DEADLINE));
				
				DateBean db = Utils.getDateBean(date);
				map.put(LitigationConstants.RESPONSE_DEADLINE_DAY, String.valueOf(db.getDate()));
				map.put(LitigationConstants.RESPONSE_DEADLINE_MONTH, String.valueOf(db.getMonth()));
				map.put(LitigationConstants.RESPONSE_DEADLINE_YEAR, String.valueOf(db.getYear()));
				map.put("counter", String.valueOf(i));
				lm.add(map);
			}
		}
		return lm;
	}
	
	private void displayLitigationDetails(long litigationId, PortletRequest request,
			PortletResponse response) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {
		LitigationSearch search = new LitigationSearch(request, response);
		Litigation litigation = LitigationLocalServiceUtil.getLitigation(litigationId);
		Map<String,String>map = search.getLitigationMap(litigation,true);
		request.setAttribute(LitigationConstants.LITIGATION, map);
		String rootTmId = String.valueOf(litigation.getSpTrademarksId());
		TrademarksSearch tmSearch = new TrademarksSearch(request, response);
		String latestTmId = getLatestTrademarkId(rootTmId, tmSearch);
		String tmText = getTrademarkString(rootTmId, request, tmSearch, true);
		String tmUrl = Utils.getTrademarkDetailsFriendlyUrl(latestTmId);
		request.setAttribute(LitigationConstants.TRADEMARK_TEXT, tmText);
		request.setAttribute(LitigationConstants.TRADEMARK_URL, tmUrl);
		setFilesList(request, GetterUtil.getLong(map.get(LitigationConstants.ROOT_LITIGATION_ID)),true);
		setRegionPermission(request);
		request.setAttribute(LitigationConstants.LITIGATION_ID, litigationId);
		request.setAttribute(LegalConstants.CAN_DOWNLOAD_FILE, canDownLoadFile(request));
		List<RDL>rdls = RDLLocalServiceUtil.findBylitigationId(litigationId);
		request.setAttribute(LitigationConstants.RDLS, ToListofMap(rdls, true));
		
		
	}
	
	public void displayLitigationDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {
		
		long litigationId = ParamUtil.getLong(actionRequest, LitigationConstants.LITIGATION_ID);
		displayLitigationDetails(litigationId, actionRequest, actionResponse);
		actionResponse.setRenderParameter("jspPage",
				"/html/litigation/details.jsp");
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
	}
	public void displayLitigationDetailsAfterAddUpdate(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {
		
		long litigationId = GetterUtil.getLong(actionRequest.getAttribute(LitigationConstants.LITIGATION_ID));
		displayLitigationDetails(litigationId, actionRequest, actionResponse);
		actionResponse.setRenderParameter("jspPage",
				"/html/litigation/details.jsp");
	}
	public void search(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {
		boolean prefsAvailable = checkPreferences(actionRequest);
		actionRequest.setAttribute("prefsAvailable", prefsAvailable);
		if(prefsAvailable){
			setAddPermission(actionRequest);
			LitigationSearch search = new LitigationSearch(actionRequest, actionResponse);
			SearchContainer searchContainer ;
			searchContainer = search.search();
			actionRequest.setAttribute("searchContainer", searchContainer);
			actionResponse.setRenderParameter("jspPage",
					"/html/litigation/view.jsp");
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
			setAddLitigationUrl(search, actionRequest);
		}
	}
	
	public void setAddLitigationUrl(LitigationSearch search,PortletRequest request){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL actionUrl = PortletURLFactoryUtil.create(request, LitigationConstants.PORTLET_ID,
				themeDisplay.getPlid(), PortletRequest.ACTION_PHASE); // renderResponse.createActionURL();
		try {
			actionUrl.setWindowState(WindowState.MAXIMIZED);
			actionUrl.setParameter("javax.portlet.action", "displayAddLitigation");
			search.addSearchParams(actionUrl);
			request.setAttribute("displayAddLitigationURL", actionUrl);
		} catch (WindowStateException e) {
			_log.error("Error whiel setting window state",e) ;
		}
	}
		
    public void addLitigation(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception{

		try {
			Utils.logTheRequest(actionRequest, _log);
			LegalPermissionUtil.authorize(actionRequest,LitigationConstants.PORTLET_ID,
					LitigationConstants. ACTION_KEY_ADD_LITIGATION);
		} catch (Exception ex) {
			SessionErrors.add(actionRequest, "unauthorized.litigation.add");
			throw ex;
		} 
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			Map<String,DateBean>dates = getDateBeanMap(themeDisplay, actionRequest);
			boolean valid = validate(actionRequest,"add",dates);
			if(!valid){
				onAddFail(actionRequest, actionResponse,dates);
			}else{
				
				Litigation litigation = null;
				try{
					litigation = LitigationLocalServiceUtil.getNewLitigation();
					long[] categoryIds = getCategoryIds(actionRequest);
					fillLitigationObject(litigation, actionRequest,actionResponse,dates);
					String trademarksId = ParamUtil.getString(actionRequest, LitigationConstants.TRADEMARKS_ID_DD);
					//TrademarksSearch search = new TrademarksSearch(actionRequest,actionResponse);
					//Document doc = search.getDocumentByPK(GetterUtil.getLong(trademarksId));
					Trademarks trademarks = TrademarksLocalServiceUtil.getTrademarks(GetterUtil.getLong(trademarksId));
					litigation.setCountry(GetterUtil.getString(trademarks.getCountry()));
					litigation.setSpTrademarksId(GetterUtil.getLong(trademarksId));
					
					LitigationLocalServiceUtil.addNewLitigation(themeDisplay.getUserId(), litigation,
							categoryIds);
					
					List<RDL>rdls = getRDLList(actionRequest);
					if(Validator.isNotNull(rdls)){
						for(RDL rdl: rdls){
							rdl.setSpLitigationId(litigation.getSpLitigationId());
							rdl.setGroupId(litigation.getGroupId());
							
							RDLLocalServiceUtil.addRDL(rdl, themeDisplay.getUserId(), new long[]{rdl.getAlertBefore()});
						}
					}
					
				}catch(Exception ex){
					litigation = null;
					_log.error(ex);
					onAddFail(actionRequest, actionResponse,dates);
					return;
				}
				
				if(Validator.isNotNull(litigation)){
					boolean result = moveDocuments(actionRequest, actionResponse, litigation,dates);
					if(result){
						SessionMessages.add(actionRequest, "request_processed",
								"Contentious Proceedings has been added");
						actionRequest.setAttribute(LitigationConstants.LITIGATION_ID, litigation.getSpLitigationId());
	    				displayLitigationDetailsAfterAddUpdate(actionRequest,actionResponse);	
					}
				}
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}
    
    
    
    private boolean moveDocuments(ActionRequest actionRequest, ActionResponse actionResponse,Litigation litigation,Map<String,DateBean>dates){
    	boolean result = true;;
    	try{
    		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			String desFolderName = getLitigationFolderName(litigation);
			long[] destFolderIds = LitigationSearch.getFolderIds(actionRequest, desFolderName);

			String srcFolderName = Utils.getUserFolderName(themeDisplay.getUserId());
			long[] srcFolderIds = LitigationSearch.getFolderIds(actionRequest, srcFolderName);
			
			FilesUpload fu = new FilesUpload(themeDisplay.getUserId(), actionRequest);
			fu.updateFileInfo();
			if(srcFolderIds[0] != 0 && destFolderIds[0] != 0){
				fu.moveDocuments(srcFolderIds[0],destFolderIds[0]);
			}
			if(srcFolderIds[1] != 0 && destFolderIds[1] != 0){
				//fu.updateFileInfo();
				fu.moveDocuments(srcFolderIds[1],destFolderIds[1]);
			}
		}catch(Exception ex){
			_log.error(ex.getMessage(),ex);
			SessionErrors.add(actionRequest, "trademarks.file.upload.error");
			result = false;
			onAddFail(actionRequest, actionResponse,dates);
		}
    	return result;
    }
    private String getLitigationFolderName(Litigation litigation){
		return LitigationSearch.getLitigationFolderName(litigation.getRootSpLitigationId());
	}
    
    private void onAddFail(ActionRequest request,ActionResponse response,Map<String,DateBean>dates){

    	ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PortalUtil.copyRequestParameters(request, response);
		setDatesToReqObj(request, themeDisplay,dates);
		fillCategoryLists(request,response);
		response.setRenderParameter("jspPage",
				"/html/litigation/addLitigation.jsp");
		setRegionPermission(request);
		
		List<Map<String,String>> rdlsByUser = getUserSubmitedRDLs(request);
		request.setAttribute(LitigationConstants.RDLS, rdlsByUser);
		request.setAttribute(LitigationConstants.RDLS_COUNT, rdlsByUser.size() + 5);

		String rootTmId = ParamUtil.getString(request, LitigationConstants.TRADEMARKS_ID_DD);
		TrademarksSearch search = new TrademarksSearch(request, response);
		String latestTmId = getLatestTrademarkId(rootTmId, search);
		request.setAttribute(LitigationConstants.TRADEMARK_TEXT, getTrademarkString(rootTmId, request, search, true));
		String tmUrl = Utils.getTrademarkDetailsFriendlyUrl(latestTmId);
		request.setAttribute(LitigationConstants.TRADEMARK_URL, tmUrl);
	
    }
    
    private void setDatesToReqObj(PortletRequest request,ThemeDisplay themeDisplay,Map<String,DateBean>dates){
    	if(Validator.isNotNull(dates)){
    		request.setAttribute(LitigationConstants.FILED_ON_DATE, dates.get(LitigationConstants.FILED_ON_DATE));
    		//request.setAttribute(LitigationConstants.RESPONSE_DEADLINE, UIUtils.getDate(themeDisplay,dates.get(LitigationConstants.FILED_ON_DATE)));
    		//request.setAttribute(LitigationConstants.ACTUAL_RESPONSE_DATE, Utils.getDateBean(getActualResponseDate(themeDisplay, request)));
    		/*request.setAttribute(LitigationConstants.CUSTOM_DATE_1, dates.get(LitigationConstants.CUSTOM_DATE_1));
    		request.setAttribute(LitigationConstants.CUSTOM_DATE_2, dates.get(LitigationConstants.CUSTOM_DATE_2));
    		request.setAttribute(LitigationConstants.CUSTOM_DATE_3, dates.get(LitigationConstants.CUSTOM_DATE_3));*/
    	}
    }
    
    private boolean validate(PortletRequest request, String action,Map<String,DateBean>dates ){
    //	String filedBy = ParamUtil.getString(request, LitigationConstants.FILED_BY);
    //	String claimsRemarks = ParamUtil.getString(request, LitigationConstants.CLAIMS_REMARKS);
    //	String status = ParamUtil.getString(request, LitigationConstants.STATUS);
    	boolean valid = true;
    	//long[] categoryIds = getCategoryIds(request);
    	if("add".equals(action)){
    		String trademarksId = ParamUtil.getString(request, LitigationConstants.TRADEMARKS_ID_DD);
    		if(Validator.isNull(trademarksId) || GetterUtil.getLong(trademarksId) == 0){
    			SessionErrors.add(request, "litigaiton.trademarkId.required");
        		valid = false;
    		}
    	}
    /*	if(categoryIds[0] == 0){
    		SessionErrors.add(request, "litigaiton.proceddingType.required");
    		valid = false;
    	}
    	if(categoryIds[1] == 0){
    		SessionErrors.add(request, "litigaiton.filed.country.required");
    		valid = false;
    	}
    	if(categoryIds[2] == 0){
    		SessionErrors.add(request, "litigaiton.alert.before.required");
    		valid = false;
    	} 
    	if(Validator.isNull(filedBy)){
    		SessionErrors.add(request, "litigaiton.filedby.required");
    		valid = false;
    	}
    	if(Validator.isNull(claimsRemarks)){
    		SessionErrors.add(request, "litigaiton.claimsRemarks.required");
    		valid = false;
    	}
    	if(Validator.isNull(status)){
    		SessionErrors.add(request, "litigaiton.status.required");
    		valid = false;
    	} *///
    	
    	boolean dateValid = UIUtils.validateDate(dates.get(LitigationConstants.FILED_ON_DATE));
		if(!dateValid){
			valid = false;
			SessionErrors.add(request, "Litigation.filedon.date");
		}
		
		try {
			List<Map<String,String>> rdlsByUser = getUserSubmitedRDLs(request);
			for (Map<String, String> map : rdlsByUser) {
				String day = map.get(LitigationConstants.RESPONSE_DEADLINE_DAY);
	    		String month = map.get(LitigationConstants.RESPONSE_DEADLINE_MONTH);
	    		String year = map.get(LitigationConstants.RESPONSE_DEADLINE_YEAR);
	    		if(Validator.isNotNull(map.get(LitigationConstants.ALERT_BEFORE))){
	    			if(UIUtils.isDateIgnoreCase(day, month, year)){
	    				SessionErrors.add(request, "Litigation.rdl.date.empty");
	    				valid = false;
	    				break;
	    			}
	    		}
				if(!UIUtils.validateDate(month,day,year)){
					SessionErrors.add(request, "Litigation.rdl.date");
					valid = false;
					break;
				}
			}
		} catch (Exception e) {
		}
		
		
		/* dateValid = UIUtils.validateDate(dates.get(LitigationConstants.CUSTOM_DATE_1));
		if(!dateValid){
			valid = false;
			SessionErrors.add(request, "Litigation.custom.date1");
		}
		 dateValid = UIUtils.validateDate(dates.get(LitigationConstants.CUSTOM_DATE_2));
		if(!dateValid){
			valid = false;
			SessionErrors.add(request, "Litigation.custom.date2");
		}
		 dateValid = UIUtils.validateDate(dates.get(LitigationConstants.CUSTOM_DATE_3));
		if(!dateValid){
			valid = false;
			SessionErrors.add(request, "Litigation.custom.date3");
		}*/
    	
    	return valid;
    }
    
    public void updateLitigation(ActionRequest actionRequest,ActionResponse actionResponse) throws Exception{

    		try {
    			Utils.logTheRequest(actionRequest, _log);
    			LegalPermissionUtil.authorize(actionRequest,LitigationConstants.PORTLET_ID,
    					LitigationConstants. ACTION_KEY_EDIT_LITIGATION);
    		} catch (Exception ex) {
    			SessionErrors.add(actionRequest, "unauthorized.litigation.add");
    			throw ex;
    		} 
    		try {
    			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
    					.getAttribute(WebKeys.THEME_DISPLAY);
    			Map<String,DateBean>dates = getDateBeanMap(themeDisplay, actionRequest);
    			long oldLitigationId = ParamUtil.getLong(actionRequest, LitigationConstants.LITIGATION_ID);
    			//Document oldLitigation = LegalContractSearch.getDocumentByPK(oldLitigationId, themeDisplay.getCompanyId(), Litigation.class.getName());
    			Litigation oldLitigation = LitigationLocalServiceUtil.getLitigation(oldLitigationId);
    			boolean isLatest = LitigationSearch.isLitigationLatest(oldLitigation);
    			if(!isLatest){
    				onUpdateFail(actionRequest, actionResponse, oldLitigationId,dates);
    				SessionErrors.add(actionRequest, "Litigation.not.working.copy");
    				return;
    			}
    			boolean valid = validate(actionRequest,"update",dates);
    			if(!valid){
    				onUpdateFail(actionRequest, actionResponse, oldLitigationId,dates);
    			}else{
    				Litigation newLitigation = null;
    				try{
    					newLitigation = LitigationLocalServiceUtil.getNewLitigation();//getLitigation(oldLitigationId);
    					boolean authorized = LegalPermissionUtil.isUserHavingRegionalRole(themeDisplay.getUserId());
    					if(!authorized){
    						newLitigation.setLegalConfRemarks(oldLitigation.getLegalConfRemarks());
    					}
    					long[] categoryIds = getCategoryIds(actionRequest);
    					fillLitigationObject(newLitigation, actionRequest,actionResponse,dates);
    					LitigationLocalServiceUtil.addNewLitigationVersion(themeDisplay.getUserId(),oldLitigationId, newLitigation,
    							categoryIds);
    					
    					List<RDL>rdls = getRDLList(actionRequest);
    					if(Validator.isNotNull(rdls)){
    						for(RDL rdl: rdls){
    							rdl.setSpLitigationId(newLitigation.getSpLitigationId());
    							rdl.setGroupId(newLitigation.getGroupId());
    							RDLLocalServiceUtil.addRDL(rdl, themeDisplay.getUserId(), new long[]{rdl.getAlertBefore()});
    						}
    					}
    					
    				}catch(Exception ex){
    					newLitigation = null;
    					onUpdateFail(actionRequest, actionResponse, oldLitigationId,dates);
    					return;
    				}
    				if(Validator.isNotNull(newLitigation)){
    					String idsStr = ParamUtil.getString(actionRequest,"hiddenFileList");
    					Utils.markAsDeletedFiles(idsStr, actionRequest);
    					moveDocuments(actionRequest, actionResponse, newLitigation,dates);
    				}
    				SessionMessages.add(actionRequest, "request_processed",
    						"Contentious Proceedings has been updated");
    				actionRequest.setAttribute(LitigationConstants.LITIGATION_ID, newLitigation.getSpLitigationId());
    				displayLitigationDetailsAfterAddUpdate(actionRequest,actionResponse);
    			}
    			
    		} catch (Exception e) {
    			_log.error(e.getMessage(), e);
    		}
    	}
    
	private void setFilesList(PortletRequest actionRequest,long litigationId,boolean convertNLToBr) throws PortalException{
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		// Logic to fetch files attached to the litigation
		String folderName = "";  
		long[] folderIds;

		if(litigationId != 0){
			folderName = LitigationSearch.getLitigationFolderName(litigationId);
			folderIds = LitigationSearch.getFolderIds(actionRequest, folderName);
			if(folderIds[0] != 0){
				List<Map<String, String>> attachments = Utils.getFiles4mIndexer(
						themeDisplay.getCompanyId(), folderIds[0],convertNLToBr);
				actionRequest.setAttribute(TrademarksConstants.ATTACHMENTS, attachments);
			}
			if(folderIds[1] != 0){
				List<Map<String, String>> confAttachments = Utils.getFiles4mIndexer(
						themeDisplay.getCompanyId(), folderIds[1],convertNLToBr); 
				actionRequest.setAttribute(TrademarksConstants.CONF_ATTACHMENTS, confAttachments);
			}
		}
		
		// Logic to fetch files uploaded using drag and drop and cancel the transaction.Those file wil be in user_<id> folder
		folderName = Utils.getUserFolderName(themeDisplay.getUserId());
		folderIds = LitigationSearch.getFolderIds(actionRequest, folderName);
		if(folderIds[0] != 0){
			List<Map<String, String>> files = Utils.getFiles4mIndexer(
					themeDisplay.getCompanyId(), folderIds[0],convertNLToBr);
			actionRequest.setAttribute(TrademarksConstants.PREV_ATTACHMENTS, files);
		}
		if(folderIds[1] != 0){
			List<Map<String, String>> files = Utils.getFiles4mIndexer(
					themeDisplay.getCompanyId(), folderIds[1],convertNLToBr);
			actionRequest.setAttribute(TrademarksConstants.PREV_CONF_ATTACHMENTS, files);
		}
	}
    private void onUpdateFail(ActionRequest actionRequest, ActionResponse actionResponse,long oldLitigationId,Map<String,DateBean>dates){
    	ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		setDatesToReqObj(actionRequest, themeDisplay,dates);
		fillCategoryLists(actionRequest, actionResponse);
		actionRequest.setAttribute(LitigationConstants.LITIGATION_ID, oldLitigationId);
		actionResponse.setRenderParameter(actionResponse.getNamespace() + LitigationConstants.TRADEMARKS_ID_DD, oldLitigationId + "");
		actionResponse.setRenderParameter("jspPage",
				"/html/litigation/editLitigation.jsp");
		setRegionPermission(actionRequest);
		List<Map<String,String>> rdlsByUser = getUserSubmitedRDLs(actionRequest);
		actionRequest.setAttribute(LitigationConstants.RDLS, rdlsByUser);
		actionRequest.setAttribute(LitigationConstants.RDLS_COUNT, rdlsByUser.size() + 5);
		
    }
    private void setRegionPermission(PortletRequest request){
    	boolean authorized;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
			authorized = LegalPermissionUtil.isUserHavingRegionalRole(themeDisplay.getUserId());
			request.setAttribute(TrademarksConstants.REGIONAL_ROLE_NAME,authorized);
		} catch (PortalException e) {
		} catch (SystemException e) {
		}	
    }
/*    private long[] getCategoryIds(PortletRequest actionRequest){
    	long[] categoryIds = new long[LitigationConstants.CATEGORIES_IDS_SIZE];
    	categoryIds[0] = ParamUtil.getLong(actionRequest,LitigationConstants.PROCEEDING_TYPE);
    	//categoryIds[1] = ParamUtil.getLong(actionRequest,LitigationConstants.FILED_AT_COUNTRY);
    	categoryIds[2] = ParamUtil.getLong(actionRequest,LitigationConstants.ALERT_BEFORE);
    	categoryIds[3] = ParamUtil.getLong(actionRequest,LitigationConstants.CUSTOM_LIST_1);
    	categoryIds[4] = ParamUtil.getLong(actionRequest,LitigationConstants.CUSTOM_LIST_2);
    	categoryIds[5] = ParamUtil.getLong(actionRequest,LitigationConstants.CUSTOM_LIST_3);
    	
    	return categoryIds;
    	
    } */
    
    public long[] getCategoryIds(PortletRequest actionRequest) {
		long[] categoryIds = null; 
		List<Long>list = new ArrayList<Long>();
		try{
			list.add(ParamUtil.getLong(actionRequest,LitigationConstants.PROCEEDING_TYPE));
			//list.add(ParamUtil.getLong(actionRequest,LitigationConstants.ALERT_BEFORE));
		/*	list.add(ParamUtil.getLong(actionRequest,LitigationConstants.CUSTOM_LIST_1));
			list.add(ParamUtil.getLong(actionRequest,LitigationConstants.CUSTOM_LIST_2));
			list.add(ParamUtil.getLong(actionRequest,LitigationConstants.CUSTOM_LIST_3)); */
			categoryIds = new long[list.size()];
			for(int i=0; i<list.size();i++){
				categoryIds[i] = list.get(i);
			}
			
		}catch(Exception e){
			_log.error(e);
		}

		return categoryIds;
	}

    private void fillLitigationObject(Litigation litigation, ActionRequest actionRequest,ActionResponse actionResponse,Map<String,DateBean>dates) throws PortalException, SystemException{
    	
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
    	
    	String filedBy = ParamUtil.getString(actionRequest, LitigationConstants.FILED_BY);
    	//String claimsRemarks = ParamUtil.getString(actionRequest, LitigationConstants.CLAIMS_REMARKS);
    	String status = ParamUtil.getString(actionRequest, LitigationConstants.STATUS);
    	String customField1 = ParamUtil.getString(actionRequest, LitigationConstants.LAW_FIRM);
    	String customField2 = ParamUtil.getString(actionRequest, LitigationConstants.THRID_PARTY_APP_NUMBER);
    	//String customField3 = ParamUtil.getString(actionRequest, LitigationConstants.CUSTOM_FIELD_3);
    	
		Date now = new Date();
		ServiceContext serviceContext = ServiceContextFactory.getInstance(
				Litigation.class.getName(), actionRequest);
		
		litigation.setFiledBy(filedBy);
		//litigation.setClaimsRemarks(claimsRemarks);
		//litigation.setActualResponseDate(getActualResponseDate(themeDisplay, actionRequest));
		litigation.setStatus(status);
		litigation.setCustomField1(customField1);
		litigation.setCustomField2(customField2);
		//litigation.setCustomField3(customField3);
		litigation.setLegalConfRemarks(ParamUtil.getString(actionRequest, TrademarksConstants.LEGAL_CONF_REMARKS));
		
		if(litigation.isNew()){
			litigation.setUuid(serviceContext.getUuid());
		}
		litigation.setGroupId(serviceContext.getScopeGroupId());
		litigation.setModifiedDate(serviceContext.getModifiedDate(now));
		if(Validator.isNotNull(dates)){
			litigation.setFiledOn(UIUtils.getDate(themeDisplay, dates.get(LitigationConstants.FILED_ON_DATE)));
			litigation.setResponseDeadline(UIUtils.getDate(themeDisplay, dates.get(LitigationConstants.RESPONSE_DEADLINE)));
			/*litigation.setCustomDate1(UIUtils.getDate(themeDisplay, dates.get(LitigationConstants.CUSTOM_DATE_1)));
			litigation.setCustomDate2(UIUtils.getDate(themeDisplay, dates.get(LitigationConstants.CUSTOM_DATE_2)));
			litigation.setCustomDate3(UIUtils.getDate(themeDisplay, dates.get(LitigationConstants.CUSTOM_DATE_3)));*/
		}
    }
    
  
    private List<RDL> getRDLList(PortletRequest request) throws SystemException{
    	Set<String>params = request.getParameterMap().keySet();
    	List<RDL> list = new ArrayList<RDL>();
    	RDL rdl;
    	ThemeDisplay themeDisplay =(ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
    	List<Map<String,String>> rdlsByUser = getUserSubmitedRDLs(request);
    	String day,month,year;
    	for (Map<String,String> map: rdlsByUser) {
    		
    		rdl = RDLLocalServiceUtil.getNewRDL();
    		day = map.get(LitigationConstants.RESPONSE_DEADLINE_DAY);
    		month = map.get(LitigationConstants.RESPONSE_DEADLINE_MONTH);
    		year = map.get(LitigationConstants.RESPONSE_DEADLINE_YEAR);
			rdl.setResponseDeadline(UIUtils.getDate(themeDisplay, new DateBean(day,month,year)));
			rdl.setAlertBefore(GetterUtil.getLong(map.get(LitigationConstants.ALERT_BEFORE)));
			rdl.setClaimsRemarks(map.get(LitigationConstants.CLAIMS_REMARKS));
			list.add(rdl);
			
    	/*	if(param.startsWith(LitigationConstants.ALERT_BEFORE) && !LitigationConstants.ALERT_BEFORE.equalsIgnoreCase(param)){
    			String index = param.substring(LitigationConstants.ALERT_BEFORE.length());
    			String remarks = ParamUtil.getString(request, LitigationConstants.CLAIMS_REMARKS + index);
    			long alertBefore = ParamUtil.getLong(request, LitigationConstants.ALERT_BEFORE + index);
    			DateBean db = getResponseDeadlineDateBean(request, GetterUtil.getLong(index));
    			
    			
    			//jsonArray.put(data);
    		} */
    	}
    	return list;
    }
    
    private List<Map<String,String>> getUserSubmitedRDLs(PortletRequest request){
    	Set<String>params = request.getParameterMap().keySet();
    	List<Map<String,String>> list = new ArrayList<Map<String,String>>();
    	Map<String,String> map ;
    	int counter = 0;
    	for (String param : params) {
    		if(param.startsWith(LitigationConstants.ALERT_BEFORE) && !LitigationConstants.ALERT_BEFORE.equalsIgnoreCase(param)){
    			String index = param.substring(LitigationConstants.ALERT_BEFORE.length());
    			String remarks = ParamUtil.getString(request, LitigationConstants.CLAIMS_REMARKS + index);
    			String alertBefore = ParamUtil.getString(request, LitigationConstants.ALERT_BEFORE + index);
    			DateBean db = getResponseDeadlineDateBean(request, GetterUtil.getLong(index));
    			
    			map = new HashMap<String, String>();
    			map.put(LitigationConstants.RESPONSE_DEADLINE_DAY, db.getDate());
    			map.put(LitigationConstants.RESPONSE_DEADLINE_MONTH, db.getMonth());
    			map.put(LitigationConstants.RESPONSE_DEADLINE_YEAR , db.getYear());
    			map.put(LitigationConstants.CLAIMS_REMARKS, remarks);
    			map.put(LitigationConstants.ALERT_BEFORE, alertBefore);
    			map.put("counter", String.valueOf(counter));
    			counter ++;
    			list.add(map);
    		}
    	}
    	return list;
    
    }
    
    private JSONArray getJsonArray(List<Map<String,String>> list){
    	JSONObject data ; 
		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();
		for (Map<String, String> map : list) {
			data = JSONFactoryUtil.createJSONObject();
			data.put(LitigationConstants.RESPONSE_DEADLINE, map.get(LitigationConstants.RESPONSE_DEADLINE));
			data.put(LitigationConstants.ALERT_BEFORE, map.get(LitigationConstants.ALERT_BEFORE));
			data.put(LitigationConstants.CLAIMS_REMARKS, map.get(LitigationConstants.CLAIMS_REMARKS));
			
			jsonArray.put(data);
			
		}
		return jsonArray;
    }
    
    private DateBean getResponseDeadlineDateBean(PortletRequest actionRequest, long counter){
    	String day = ParamUtil.getString(actionRequest,LitigationConstants.RESPONSE_DEADLINE_DAY  + counter);
    	String month = ParamUtil.getString(actionRequest,LitigationConstants.RESPONSE_DEADLINE_MONTH + counter);
    	String year = ParamUtil.getString(actionRequest,LitigationConstants.RESPONSE_DEADLINE_YEAR + counter );
    	DateBean db = new DateBean(day,month,year);
    	return db;
    }

    private Map<String,DateBean > getDateBeanMap(ThemeDisplay themeDisplay,PortletRequest actionRequest){
		Map<String,DateBean > map = new HashMap<String, DateBean>();
		try{
			String day = ParamUtil.getString(actionRequest,LitigationConstants.FILED_ON_DATE_DAY );
			String mon = ParamUtil.getString(actionRequest,LitigationConstants.FILED_ON_DATE_MONTH );
			String year = ParamUtil.getString(actionRequest,LitigationConstants.FILED_ON_DATE_YEAR );
			DateBean db = new DateBean(day, mon, year);
			map.put(LitigationConstants.FILED_ON_DATE, db);

			/* day = ParamUtil.getString(actionRequest,LitigationConstants.CUSTOM_DATE_1_DAY );
			 mon = ParamUtil.getString(actionRequest,LitigationConstants.CUSTOM_DATE_1_MONTH );
			 year = ParamUtil.getString(actionRequest,LitigationConstants.CUSTOM_DATE_1_YEAR );
			 db = new DateBean(day, mon, year);
			map.put(LitigationConstants.CUSTOM_DATE_1, db);
		
			day = ParamUtil.getString(actionRequest,LitigationConstants.CUSTOM_DATE_2_DAY );
			mon = ParamUtil.getString(actionRequest,LitigationConstants.CUSTOM_DATE_2_MONTH );
			year = ParamUtil.getString(actionRequest,LitigationConstants.CUSTOM_DATE_2_YEAR );
			db = new DateBean(day, mon, year);
			map.put(LitigationConstants.CUSTOM_DATE_2, db);
			
			day = ParamUtil.getString(actionRequest,LitigationConstants.CUSTOM_DATE_3_DAY );
			mon = ParamUtil.getString(actionRequest,LitigationConstants.CUSTOM_DATE_3_MONTH );
			year = ParamUtil.getString(actionRequest,LitigationConstants.CUSTOM_DATE_3_YEAR );
			db = new DateBean(day, mon, year);
			map.put(LitigationConstants.CUSTOM_DATE_3, db);*/
			
		

		}catch(Exception ex){
			
		}
		return map;
	}
//    private Date getCustomDate1(ThemeDisplay themeDisplay,PortletRequest actionRequest){
//    	int customDay1 = ParamUtil.getInteger(actionRequest,LitigationConstants.CUSTOM_DATE_1_DAY );
//		int customMonth1 = ParamUtil.getInteger(actionRequest,LitigationConstants.CUSTOM_DATE_1_MONTH );
//		int customYear1 = ParamUtil.getInteger(actionRequest,LitigationConstants.CUSTOM_DATE_1_YEAR );
//		Calendar customCal1 = Utils.getCalendar(themeDisplay, customDay1-1,
//				customMonth1, customYear1);
//		return customCal1.getTime();
//    }
//    private Date getCustomDate2(ThemeDisplay themeDisplay,PortletRequest actionRequest){
//    	int customDay2 = ParamUtil.getInteger(actionRequest,LitigationConstants.CUSTOM_DATE_2_DAY );
//		int customMonth2 = ParamUtil.getInteger(actionRequest,LitigationConstants.CUSTOM_DATE_2_MONTH );
//		int customYear2 = ParamUtil.getInteger(actionRequest,LitigationConstants.CUSTOM_DATE_2_YEAR );
//		Calendar customCal2 = Utils.getCalendar(themeDisplay, customDay2-1,
//				customMonth2, customYear2);
//		return customCal2.getTime();
//    }
//    private Date getCustomDate3(ThemeDisplay themeDisplay,PortletRequest actionRequest){
//    	int customDay3 = ParamUtil.getInteger(actionRequest,LitigationConstants.CUSTOM_DATE_3_DAY );
//		int customMonth3 = ParamUtil.getInteger(actionRequest,LitigationConstants.CUSTOM_DATE_3_MONTH );
//		int customYear3 = ParamUtil.getInteger(actionRequest,LitigationConstants.CUSTOM_DATE_3_YEAR );
//		Calendar customCal3 = Utils.getCalendar(themeDisplay, customDay3-1,
//				customMonth3, customYear3);
//		return customCal3.getTime();	
//    }
    
    private String getTrademarkString(String rootTmId, PortletRequest actionRequest,TrademarksSearch search, boolean fromScreen) {
		String temp = "" ;
		try{
			Map<String, String> map = search.getLatestTrademarksByRootTrademarksId(
					rootTmId, false);
			String tmType = map.get(TrademarksConstants.TRADEMARK_TYPE);
			if (TrademarksConstants.LOGO.equalsIgnoreCase(tmType)) {
				
				if(fromScreen){
					temp = search.getTrademarkLogoUrl(search.getRequest(),rootTmId);
					String imageHtml =  TrademarksConstants.TRADEMARK_LOGO_IMG_FORMAT;//"<img border='2' src='%s' width='100px' height='50px'>";
					return String.format(imageHtml, temp);
				}else{
					return search.getTrademarksLogoDLUrl(actionRequest,rootTmId);
				}
			}else{
				temp = map.get(TrademarksConstants.TRADEMARK);
			}
		}catch(Exception ex){
			_log.error("Error while getting trademarks logo/Text" + ex);
		}
		return temp;
    }
    private String getTrademarksLogoFileEntryId(String rootTmId, PortletRequest actionRequest,TrademarksSearch search) {
    	String temp = "" ;
    	try{
    		Map<String, String> map = search.getLatestTrademarksByRootTrademarksId(
    				rootTmId, false);
    		String tmType = map.get(TrademarksConstants.TRADEMARK_TYPE);
    		if (TrademarksConstants.LOGO.equalsIgnoreCase(tmType)) {
    			temp = map.get(TrademarksConstants.LOGO_FILE_ENTRY_ID);
    		}
    	}catch(Exception ex){
    		_log.error("Error while getting trademarks logo/Text" + ex);
    	}
    	return temp;
    }
    
    private void fillCategoryLists(PortletRequest actionRequest,PortletResponse actionResponse) {
    	
    	TrademarksSearch search = new TrademarksSearch(actionRequest, actionResponse);
		Map<String,String>trademarks = search.getTrademarksIdAdnRegNum();
		actionRequest.setAttribute(LitigationConstants.TRADEMARKS, trademarks);
		try {
			String rootTmId = trademarks.entrySet().iterator().next().getKey();
			String latestTmId = getLatestTrademarkId(rootTmId, search);
			actionRequest.setAttribute(LitigationConstants.TRADEMARK_TEXT, getTrademarkString(rootTmId, actionRequest, search, true));
			String tmUrl = Utils.getTrademarkDetailsFriendlyUrl(latestTmId);
			actionRequest.setAttribute(LitigationConstants.TRADEMARK_URL, tmUrl);
		} catch (Exception e) {
			_log.error("2error getting logo/tmName", e);
		}
		PortletPreferences preferences = actionRequest.getPreferences();
		String proceedingTypVocId = preferences.getValue(LitigationConstants.PROCEEDING_TYPE_VOC_ID, "0");
		//String filedAtCountryVocId = preferences.getValue(LitigationConstants.FILED_AT_COUNTRY_VOC_ID, "0");
		String alerBeforeVocId = preferences.getValue(LitigationConstants.ALERT_BEFORE_VOC_ID, "0");
		/*String customList1VocId = preferences.getValue(LitigationConstants.CUSTOM_LIST_1_VOC_ID, "0");
		String customList2VocId = preferences.getValue(LitigationConstants.CUSTOM_LIST_2_VOC_ID, "0");
		String customList3VocId = preferences.getValue(LitigationConstants.CUSTOM_LIST_3_VOC_ID, "0"); */

		if (Validator.isNull(proceedingTypVocId)) {
			_log.info("Setup incomplete. Please ask admin to configure Description list");
		} else {
			List<AssetCategory> procTypList = Utils.getCategories(Long
					.parseLong(proceedingTypVocId));
		//	List<AssetCategory> filedCountryList = Utils.getCategories(Long
		//			.parseLong(filedAtCountryVocId));
			List<AssetCategory> alertBeforeList = Utils.getCategories(Long
					.parseLong(alerBeforeVocId),LegalConstants.SORT_INT);
		/*	List<AssetCategory> customList1 = Utils.getCategories(Long
					.parseLong(customList1VocId));
			List<AssetCategory> customList2 = Utils.getCategories(Long
					.parseLong(customList2VocId));
			List<AssetCategory> customList3 = Utils.getCategories(Long
					.parseLong(customList3VocId)); */
		
			actionRequest.setAttribute(LitigationConstants.PROCEEDING_TYPE, procTypList);
			//actionRequest.setAttribute(LitigationConstants.FILED_AT_COUNTRY, filedCountryList);
			actionRequest.setAttribute(LitigationConstants.ALERT_BEFORE, alertBeforeList);
		/*	actionRequest.setAttribute(LitigationConstants.CUSTOM_LIST_1, customList1);
			actionRequest.setAttribute(LitigationConstants.CUSTOM_LIST_2, customList2);
			actionRequest.setAttribute(LitigationConstants.CUSTOM_LIST_3, customList3); */
		
		}
	}
    
	public static String getEscapedString(String str) {
		return StringEscapeUtils.escapeHtml(GetterUtil.getString(str));
	}
	
	private boolean canDownLoadFile(PortletRequest request){
		boolean authorized = false;
		try {
			LegalPermissionUtil.authorize(request, LitigationConstants.PORTLET_ID,
					LitigationConstants.ACTION_KEY_DOWNLOAD_FILE);
			authorized = true;
		} catch (Exception ex) {
			//_log.error("Litigation - Download file Permission check failed ");
		}
		return authorized;
	}
	
	private String getLatestTrademarkId(String rootTmId, TrademarksSearch search) {
		Map<String, String> map = search.getLatestTrademarksByRootTrademarksId(
				rootTmId, false);
		if (Validator.isNotNull(map.get(TrademarksConstants.TRADEMARKS_ID)))
			return map.get(TrademarksConstants.TRADEMARKS_ID);
		else
			return rootTmId;
	}
	
	private String getTrademarkTextOrLogo(String rootTmId, TrademarksSearch search) {
		String temp = "" ;
		try{
			Map<String, String> map = search.getLatestTrademarksByRootTrademarksId(
					rootTmId, false);
			String tmType = map.get(TrademarksConstants.TRADEMARK_TYPE);
			if (TrademarksConstants.LOGO.equalsIgnoreCase(tmType)) {
				temp = search.getTrademarkLogoUrl(search.getRequest(),rootTmId);
			}else{
				temp = map.get(TrademarksConstants.TRADEMARK);
			}
		}catch(Exception ex){
			_log.error("Error while getting trademarks logo/Text" + ex);
		}
		return temp;
	}

	// For sending mail alerts to given roles.This
	// action can be triggered Litigation Preferences page.
	// This is a manual approach for triggering mails. We have Schedular job
	// which actually triggers mails.
	public void sendMailsForRoles(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		User user = themeDisplay.getUser();
		String roleNames = ParamUtil.getString(actionRequest, "roleNames");
		RDLMailHelper.sendMailsToUsersHavingRole(themeDisplay.getCompanyId(), roleNames);
	}

	// For sending mail alerts  to users having
	// permissions.This action can be triggered Litigation Preferences page.
	// This is a manual approach for triggering mails. We have Schedular job
	// which actually triggers mails.
	public void sendMailsToUsersHavingPermissions(ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		RDLMailHelper.sendMails();
	}
}
