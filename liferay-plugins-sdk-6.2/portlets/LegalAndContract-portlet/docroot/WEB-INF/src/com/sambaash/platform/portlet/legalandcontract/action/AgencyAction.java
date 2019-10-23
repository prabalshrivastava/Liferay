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
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.lang.WordUtils;

import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.repository.model.Folder;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.search.Field;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
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
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFileVersion;
import com.liferay.portlet.documentlibrary.service.DLAppServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileVersionLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.portlet.legalandcontract.permissions.LegalPermissionUtil;
import com.sambaash.platform.portlet.legalandcontract.reports.ReportGenerator;
import com.sambaash.platform.portlet.legalandcontract.reports.ReportPayload;
import com.sambaash.platform.portlet.legalandcontract.reports.ReportRecord;
import com.sambaash.platform.portlet.legalandcontract.search.AgencySearch;
import com.sambaash.platform.portlet.legalandcontract.search.LegalContractSearch;
import com.sambaash.platform.portlet.legalandcontract.util.AgencyBulkupload;
import com.sambaash.platform.portlet.legalandcontract.util.AgencyConstants;
import com.sambaash.platform.portlet.legalandcontract.util.DateBean;
import com.sambaash.platform.portlet.legalandcontract.util.FilesUpload;
import com.sambaash.platform.portlet.legalandcontract.util.LegalConstants;
import com.sambaash.platform.portlet.legalandcontract.util.TrademarksConstants;
import com.sambaash.platform.portlet.legalandcontract.util.Utils;
import com.sambaash.platform.srv.legalandcontract.model.Agency;
import com.sambaash.platform.srv.legalandcontract.service.AgencyLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * Portlet implementation class AgencyAction
 *
 * @author Brian Wing Shun Chan
 */
public class AgencyAction extends MVCPortlet {

	private static Log _log = LogFactoryUtil.getLog(AgencyAction.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {

		setAddPermission(renderRequest);
		boolean prefsAvailable = checkPreferences(renderRequest);
		renderRequest.setAttribute("prefsAvailable", prefsAvailable);
		if (prefsAvailable) {
			long agencyId = GetterUtil.getLong(renderRequest.getParameter(AgencyConstants.AGENCY_ID));
			String action = renderRequest.getParameter("actionp");
			if (agencyId != 0
					&& "displayAgencyDetails".equalsIgnoreCase(action)) {
				try {
					displayAgencyDetails(agencyId, renderRequest,
							renderResponse);
					include("/html/agency/details.jsp", renderRequest,
							renderResponse);
				} catch (Exception e) {
				}
			} else {

				try {
					LegalPermissionUtil.authorize(renderRequest,
							AgencyConstants.PORTLET_ID,
							AgencyConstants.ACTION_KEY_BULKUPLOAD_AGENCY);
					renderRequest.setAttribute("bulkuploadAgencyPermission",
							true);
				} catch (Exception e) {
					// _log.error(e);
				}

				AgencySearch search = new AgencySearch(renderRequest,
						renderResponse);
				SearchContainer searchContainer;
				try {
					searchContainer = search.search();
					renderRequest.setAttribute("searchContainer",
							searchContainer);
					setAddAgencyUrl(search, renderRequest);
				} catch (PortalException e) {
				}
				super.doView(renderRequest, renderResponse);
			}
			
		}
	}

	private void setAddPermission(PortletRequest request) {
		try {
			LegalPermissionUtil.authorize(request, AgencyConstants.PORTLET_ID,
					AgencyConstants.ACTION_KEY_ADD_AGENCY);
			request.setAttribute("addAgencyPermission", true);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private boolean checkPreferences(PortletRequest request) {
		PortletPreferences preferences = request.getPreferences();
		String classificaionTypeId = preferences.getValue(
				AgencyConstants.TYPE_VOC_ID, "");
		String countryId = preferences.getValue(AgencyConstants.COUNTRY_VOC_ID,
				"");
		boolean prefsAvailable = true;
		if (Validator.isNull(classificaionTypeId)
				|| Validator.isNull(countryId)) {
			prefsAvailable = false;
		}
		return prefsAvailable;
	}

	public void search(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {
		boolean prefsAvailable = checkPreferences(actionRequest);
		actionRequest.setAttribute("prefsAvailable", prefsAvailable);
		if (prefsAvailable) {
			setAddPermission(actionRequest);
			AgencySearch search = new AgencySearch(actionRequest,
					actionResponse);
			SearchContainer searchContainer = search.search();
			actionRequest.setAttribute("searchContainer", searchContainer);
			actionResponse.setRenderParameter("jspPage",
					"/html/agency/view.jsp");
			setAddAgencyUrl(search, actionRequest);
			PortalUtil.copyRequestParameters(actionRequest, actionResponse);
		}
	}

	public void setAddAgencyUrl(AgencySearch search,PortletRequest request){
		ThemeDisplay themeDisplay = (ThemeDisplay)request.getAttribute(WebKeys.THEME_DISPLAY);
		PortletURL actionUrl = PortletURLFactoryUtil.create(request, AgencyConstants.PORTLET_ID,
				themeDisplay.getPlid(), PortletRequest.ACTION_PHASE); // renderResponse.createActionURL();
		try {
			actionUrl.setWindowState(WindowState.MAXIMIZED);
			actionUrl.setParameter("javax.portlet.action", "displayAddAgency");
			search.addSearchParams(actionUrl);
			request.setAttribute("displayAddAgencyURL", actionUrl);
		} catch (WindowStateException e) {
			_log.error("Error whiel setting window state",e) ;
		}
	}
	public void displayAddAgency(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {

		try {
			LegalPermissionUtil.authorize(actionRequest, AgencyConstants.PORTLET_ID,
					AgencyConstants.ACTION_KEY_ADD_AGENCY);
		} catch (Exception e) {
			throw e;
		}
		fillCategoryLists(actionRequest);
		if (SessionErrors.get(actionRequest, "agency.add.errors.exists") == null) {
		//	Date now = new Date();
		//	DateBean dateBean = Utils.getDateBean(null);
		//	actionRequest.setAttribute("startDate", dateBean);
		//	actionRequest.setAttribute("endDate", dateBean);
			/*actionRequest.setAttribute("customDate1", dateBean);
			actionRequest.setAttribute("customDate2", dateBean);
			actionRequest.setAttribute("customDate3", dateBean);*/
		}
		actionResponse.setRenderParameter("jspPage",
				"/html/agency/addAgency.jsp");
		setPreviousAttachments(actionRequest);
		LegalContractSearch.copySearchParamsToResponse(actionRequest, actionResponse);
	}

	public void setAgencyAttachments(PortletRequest request,
			String agencyFolderName,boolean convertNltoBr) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		long folderId;
		try {
			folderId = getFolderId(request, agencyFolderName);
			
			List<Map<String, String>> files = Utils.getFiles4mIndexer(
					themeDisplay.getCompanyId(), folderId,convertNltoBr); 
			request.setAttribute(AgencyConstants.FILES, files);
		} catch (Exception e) {
			_log.error(e);
		}
	}
	private void setPreviousAttachments(PortletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		String folderName = Utils.getUserFolderName(themeDisplay.getUserId());
		long folderId;
		try {
			folderId = getFolderId(request, folderName);
			List<Map<String, String>> files = Utils.getFiles4mIndexer(
					themeDisplay.getCompanyId(), folderId,false);
			request.setAttribute(AgencyConstants.PREVIOUS_FILES, files);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	private void displayAgencyDetails(long agencyId, PortletRequest request,
			PortletResponse response) throws IOException, PortletException,
			PrincipalException, PortalException, SystemException {
		AgencySearch search = new AgencySearch(request, response);
		Agency agency = AgencyLocalServiceUtil
				.getAgency(agencyId); 
		Map<String, String> map = search.getAgencyMap(agency,true);
		request.setAttribute(AgencyConstants.AGENCY, map);
		request.setAttribute(AgencyConstants.AGENCY_ID, agencyId);
		_log.error(" Displaying Law Firm Details: Law Firm Id: " + agencyId + ",  Root Law Firm " + agency.getRootSpAgencyId());
		String folderName = AgencySearch.getAgencyFolderName(agency.getRootSpAgencyId());
		_log.error(" Law Firm Folder Name " + folderName);
		setAgencyAttachments(request, folderName,true);
		request.setAttribute(LegalConstants.CAN_DOWNLOAD_FILE, canDownLoadFile(request));
	}

	private boolean canDownLoadFile(PortletRequest request){
		boolean authorized = false;
		try {
			LegalPermissionUtil.authorize(request, AgencyConstants.PORTLET_ID,
					AgencyConstants.ACTION_KEY_DOWNLOAD_FILE);
			authorized = true;
		} catch (Exception ex) {
			_log.error("Download file Permission check failed ");
		}
		return authorized;
	}
	public void displayAgencyDetails(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {

		long agencyId = ParamUtil.getLong(
				actionRequest, AgencyConstants.AGENCY_ID); 
		displayAgencyDetails(agencyId, actionRequest,actionResponse);
		actionResponse
				.setRenderParameter("jspPage", "/html/agency/details.jsp");
		LegalContractSearch.copySearchParamsToResponse(actionRequest, actionResponse);
	}
	public void displayAgencyDetailsAfterAddUpdate(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PrincipalException, PortalException,
			SystemException {
		
		long agencyId = GetterUtil.getLong(
				actionRequest.getAttribute(AgencyConstants.AGENCY_ID)); 
		displayAgencyDetails(agencyId, actionRequest,actionResponse);
		actionResponse
		.setRenderParameter("jspPage", "/html/agency/details.jsp");
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			String action = ParamUtil.getString(resourceRequest, "action");
			JSONObject data = JSONFactoryUtil.createJSONObject();
			String errMsg = "success";
			if ("removeFile".equals(action)) {
				long fileEntryId = ParamUtil.getLong(resourceRequest,
						"fileEntryId");
				try {
					DLAppServiceUtil.deleteFileEntry(fileEntryId);
				} catch (Exception ex) {
					errMsg = "File Deletion Failed.";
					_log.error(ex);
				}
			} else if ("exportListPdf".equals(action)) {
				try {
					String path = exportAgencyList(resourceRequest,
							resourceResponse);
					data.put("fileName", path);
					// dont send
					errMsg = null;
				} catch (Exception ex) {
					data.put("errorMsg", "Error while generating the report");
					errMsg = "Error creating pdf";
				}
			}  else if ("exportListXls".equals(action)) {
				try {
					String path = exportAgencyListXls(resourceRequest,
							resourceResponse);
					data.put("fileName", path);
					// dont send
					errMsg = null;
				} catch (Exception ex) {
					data.put("errorMsg", "Error while generating the report");
					errMsg = "Error creating Excel";
				}
			} else if ("exportDetailsPdf".equals(action)) {
				try{
					String path = exportAgencyDetails(resourceRequest, resourceResponse);
					data.put("fileName", path);
					errMsg = null;
				}catch(Exception ex){
					data.put("errorMsg", "Error while generating the report");
					errMsg = "Error creating details pdf";
				}
			} else if ("exportDetailsXls".equals(action)) {
				try{
					String path = exportAgencyDetailsXls(resourceRequest, resourceResponse);
					data.put("fileName", path);
					errMsg = null;
				}catch(Exception ex){
					data.put("errorMsg", "Error while generating the report");
					errMsg = "Error creating details pdf";
				}
			} else {
				try {
					Object objs[] = Utils.parseRequest(resourceRequest,
							resourceResponse);
					Map<String, String> paramMap = (Map<String, String>) objs[0];
					List<FileItem> files = (List<FileItem>) objs[1];
					String folderName = Utils.getUserFolderName(themeDisplay
							.getUserId());
					long folderId = getFolderId(resourceRequest, folderName);
					FilesUpload fu = new FilesUpload();
					List<FileEntry> fileList = fu.uploadDocuments(
							resourceRequest, files, folderId);
					if (fu.getFailedCount() > 0) {
						errMsg = fu.getErrorMessage(files.get(0));
					}
					if (fileList.size() > 0) {
						data.put("fileEntryId", fileList.get(0)
								.getFileEntryId());
					}
				} catch (Exception ex) {
					_log.error(ex.getMessage(), ex);
					errMsg = "File upload failed";
				}
			}
			if (errMsg != null)
				data.put("errorMsg", errMsg);
			resourceResponse.setContentType("application/json");
			resourceResponse.setCharacterEncoding("utf-8");
			resourceResponse.getWriter().write(data.toString());

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}
	
	private void generateListReport(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, String fileName, ReportGenerator generator) {
		AgencySearch search = new AgencySearch(resourceRequest,
				resourceResponse);
		List<Document> agencies = search.getAgencies();
		List<ReportRecord> list = new ArrayList<ReportRecord>();
		long countryVocId = GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_COUNTRY_VOC_ID, 0));
		long typeVocId= GetterUtil.getLong(SambaashUtil.getParameter(SambaashConstants.AGENCY_TYPE_VOC_ID, 0));
		for (Document doc : agencies) {
			long agencyId = GetterUtil.getLong(doc.get(Field.ENTRY_CLASS_PK));
			ReportRecord wrap = new ReportRecord();
			Map<String, String> map = new LinkedHashMap<String, String>();
			List<Long> catIds = Utils.getCategoryIds(doc);
			map.put(AgencyConstants.NUMBER_COLUMN,
					GetterUtil.getString(doc.get(AgencyConstants.NUMBER)));
			map.put(AgencyConstants.NAME_COLUMN,
					GetterUtil.getString(doc.get(AgencyConstants.NAME)));
			map.put(AgencyConstants.COUNTRY_COLUMN, GetterUtil.getString(Utils
					.getCategoryName(countryVocId, catIds)));
			map.put(AgencyConstants.REFERENCE_COLUMN,
					GetterUtil.getString(doc.get(AgencyConstants.REFERENCE)));
			map.put(AgencyConstants.START_DATE_COLUMN,
					GetterUtil.getString(doc.get(AgencyConstants.START_DATE)));
			map.put(AgencyConstants.END_DATE_COLUMN,
					GetterUtil.getString(doc.get(AgencyConstants.END_DATE)));
			map.put(AgencyConstants.TYPE_COLUMN,
					GetterUtil.getString(Utils.getCategoryName(typeVocId, catIds)));
			map.put(AgencyConstants.ADDRESS_COLUMN,
					GetterUtil.getString(doc.get(AgencyConstants.ADDRESS)));
			/*map.put(AgencyConstants.REMARKS_COLUMN,
					GetterUtil.getString(doc.get(AgencyConstants.REMARKS)));*/
			map.put(AgencyConstants.STATUS_COLUMN,
					GetterUtil.getString(doc.get(AgencyConstants.STATUS)));
			map.put(AgencyConstants.DETAILS_LINK,
					Utils.getAgencyDetailsFriendlyUrl(resourceRequest,agencyId));

			wrap.setDataMap(map);
			list.add(wrap);
		}
		ReportPayload payload = new ReportPayload();
		payload.useDefaultMap();
		payload.setType("Agency List");
		payload.setRecList(list);
		try {
			generator.generateReport(payload, new File(fileName));
		} catch (Exception e) {
			_log.error("Error while creating pdf file", e);
		}
	}

	private String exportAgencyList(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {

		String fileName = Utils.generateExportFileName(resourceRequest, "lawfirms" , ".pdf");
		ReportGenerator generator = ReportGenerator.getPdfGenerator("agencies", "agenciesList", (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY));
		generateListReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}
	
	private String exportAgencyListXls(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String fileName = Utils.generateExportFileName(resourceRequest, "lawfirms" , ".xlsx");
		ReportGenerator generator = ReportGenerator.getExcelGenerator();
		generateListReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}
	
	private void generateDetailsReport(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse, String fileName, ReportGenerator generator) {
		long agencyId = ParamUtil.getLong(resourceRequest,
				AgencyConstants.AGENCY_ID);
		AgencySearch search = new AgencySearch(resourceRequest,
				resourceResponse);
		Map<String, String> agency;
		try {
			agency = search.getAgencyMap(AgencyLocalServiceUtil.getAgency(agencyId),false);
			Map<String, String> map = new LinkedHashMap<String, String>();
//			map.put(AgencyConstants.AGENCY_ID,
//					GetterUtil.getString(agency.get(AgencyConstants.AGENCY_ID)));
			map.put(AgencyConstants.NAME_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.NAME)));
			map.put(AgencyConstants.NUMBER_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.NUMBER)));
			map.put(AgencyConstants.COUNTRY_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.COUNTRY)));
			map.put(AgencyConstants.ADDRESS_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.ADDRESS)));
			map.put(AgencyConstants.STATUS_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.STATUS)));
			map.put(WordUtils.capitalize(LegalConstants.VERSION),
					GetterUtil.getString(agency.get(LegalConstants.VERSION)));
			map.put(AgencyConstants.REFERENCE_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.REFERENCE)));
			map.put(AgencyConstants.START_DATE_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.START_DATE)));
			map.put(AgencyConstants.END_DATE_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.END_DATE)));
			map.put(AgencyConstants.TYPE_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.TYPE)));
			map.put(TrademarksConstants.UPDATE_BY_COLUMN,
					agency.get(TrademarksConstants.UPDATE_BY));
			map.put(TrademarksConstants.MODIFIED_DATE_COLUMN,
					agency.get(TrademarksConstants.MODIFIED_DATE));
			/*map.put(AgencyConstants.CUSTOM_FIELD_1_COLUMN, GetterUtil
					.getString(agency.get(AgencyConstants.CUSTOM_FIELD_1)));
			map.put(AgencyConstants.CUSTOM_FIELD_2_COLUMN, GetterUtil
					.getString(agency.get(AgencyConstants.CUSTOM_FIELD_2)));
			map.put(AgencyConstants.CUSTOM_FIELD_3_COLUMN, GetterUtil
					.getString(agency.get(AgencyConstants.CUSTOM_FIELD_3)));
			map.put(AgencyConstants.CUSTOM_DATE_1_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.CUSTOM_DATE_1)));
			map.put(AgencyConstants.CUSTOM_DATE_2_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.CUSTOM_DATE_2)));
			map.put(AgencyConstants.CUSTOM_DATE_3_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.CUSTOM_DATE_3)));
			map.put(AgencyConstants.CUSTOM_LIST_1_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.CUSTOM_LIST_1)));
			map.put(AgencyConstants.CUSTOM_LIST_2_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.CUSTOM_LIST_2)));
			map.put(AgencyConstants.CUSTOM_LIST_3_COLUMN, 
					GetterUtil.getString(agency.get(AgencyConstants.CUSTOM_LIST_3))); */
			map.put(AgencyConstants.REMARKS_COLUMN,
					GetterUtil.getString(agency.get(AgencyConstants.REMARKS)));
//			map.put(AgencyConstants.LATEST,
//					GetterUtil.getString(agency.get(AgencyConstants.LATEST)));

			ReportRecord rec = new ReportRecord();
			rec.setDataMap(map);
			
			List<ReportRecord> list = new ArrayList<ReportRecord>();
			list.add(rec);
			
			ReportPayload payload = new ReportPayload();
			payload.useDefaultMap();
			payload.setRecList(list);
			payload.setType("Agency Details");
			
			try {
				generator.generateReport(payload, new File(fileName));
			} catch (Exception e) {
				_log.error("Error while creating pdf file", e);
			}
		} catch (PortalException e1) {
		} catch (SystemException e1) {
		} catch (Exception e) {
		}
		
	}
	private String exportAgencyDetails(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String fileName = Utils.generateExportFileName(resourceRequest, "lawfirm_details", ".pdf");
		ReportGenerator generator = ReportGenerator.getPdfGenerator("agencyDetails", "agency", (ThemeDisplay) resourceRequest
				.getAttribute(WebKeys.THEME_DISPLAY));
		this.generateDetailsReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}
	
	private String exportAgencyDetailsXls(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) {
		String fileName = Utils.generateExportFileName(resourceRequest, "lawfirm_details", ".xlsx");
		ReportGenerator generator = ReportGenerator.getExcelGenerator();
		this.generateDetailsReport(resourceRequest, resourceResponse, fileName, generator);
		return fileName;
	}

	public void displayEditAgency(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PrincipalException,
			PortalException {

		LegalPermissionUtil.authorize(actionRequest, AgencyConstants.PORTLET_ID,
				AgencyConstants.ACTION_KEY_EDIT_AGENCY);
		fillCategoryLists(actionRequest);

		
		long agencyId = ParamUtil.getLong(actionRequest,
				AgencyConstants.AGENCY_ID);
		Agency agency = AgencyLocalServiceUtil.fetchAgency(agencyId);
		boolean canEdit = Utils.checkUserPermissionOnCountry(actionRequest,
				GetterUtil.getLong(actionRequest.getPreferences().getValue(
						AgencyConstants.COUNTRY_VOC_ID, "0")), agency.getCountry());
		if (!canEdit) {
			SessionErrors.add(actionRequest,
					"unauthorized.agency.update");
			return;
		}

		actionRequest.setAttribute(AgencyConstants.AGENCY, agency);
		actionRequest.setAttribute(AgencyConstants.AGENCY_ID, agencyId);
	/*	actionRequest.setAttribute(AgencyConstants.START_DATE,
				Utils.getDateBean(agency.getStartDate()));
		actionRequest.setAttribute(AgencyConstants.END_DATE,
				Utils.getDateBean(agency.getEndDate())); */
	/*	actionRequest.setAttribute(AgencyConstants.CUSTOM_DATE_1,
				Utils.getDateBean(agency.getCustomDate1()));
		actionRequest.setAttribute(AgencyConstants.CUSTOM_DATE_2,
				Utils.getDateBean(agency.getCustomDate2()));
		actionRequest.setAttribute(AgencyConstants.CUSTOM_DATE_3,
				Utils.getDateBean(agency.getCustomDate3())); */

		AssetEntry assetEntry = AssetEntryLocalServiceUtil.fetchEntry(
				Agency.class.getName(), agencyId);
		long categoryIds[] = assetEntry.getCategoryIds();
		
		PortletPreferences prefs = actionRequest.getPreferences();
		actionRequest.setAttribute("countryCatId", Utils.getCategoryId(prefs, AgencyConstants.COUNTRY_VOC_ID, categoryIds));
		actionRequest.setAttribute("typeCatId", Utils.getCategoryId(prefs, AgencyConstants.TYPE_VOC_ID, categoryIds));
	/*	actionRequest.setAttribute("customList1CatId", Utils.getCategoryId(prefs, AgencyConstants.CUSTOM_LIST_1_VOC_ID, categoryIds));
		actionRequest.setAttribute("customList2CatId", Utils.getCategoryId(prefs, AgencyConstants.CUSTOM_LIST_2_VOC_ID, categoryIds));
		actionRequest.setAttribute("customList3CatId", Utils.getCategoryId(prefs, AgencyConstants.CUSTOM_LIST_3_VOC_ID, categoryIds)); */
		
		
		//actionRequest.setAttribute("categoryIds", categoryIds);
		actionResponse.setRenderParameter("jspPage",
				"/html/agency/editAgency.jsp");

		setAgencyAttachments(actionRequest,
				AgencySearch.getAgencyFolderName(agency.getRootSpAgencyId()),false);
		setPreviousAttachments(actionRequest);
		LegalContractSearch.copySearchParamsToResponse(actionRequest, actionResponse);
	}

	protected String getPath(PortletRequest portletRequest) {
		String mvcPath = portletRequest.getParameter("mvcPath");
		// Check deprecated parameter
		if (mvcPath == null) {
			mvcPath = portletRequest.getParameter("jspPage");
		}

		return mvcPath;
	}

	public void fillAgencyObject(Agency agency, Map<String, String> paramMap,
			ActionRequest actionRequest, Map<String,DateBean>dates) {
		try {

			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			String name = paramMap.get(AgencyConstants.NAME);
			String reference = paramMap.get(AgencyConstants.REFERENCE);
			String address = paramMap.get(AgencyConstants.ADDRESS);
			String remarks = paramMap.get(AgencyConstants.REMARKS);
			String status = paramMap.get(AgencyConstants.STATUS);
			/*String customField1 = paramMap.get(AgencyConstants.CUSTOM_FIELD_1);
			String customField2 = paramMap.get(AgencyConstants.CUSTOM_FIELD_2);
			String customField3 = paramMap.get(AgencyConstants.CUSTOM_FIELD_3);*/

			ServiceContext serviceContext = ServiceContextFactory.getInstance(
					Agency.class.getName(), actionRequest);
			long groupId = serviceContext.getScopeGroupId();

			Date now = new Date();

			agency.setName(name);
			agency.setReference(reference);
			agency.setStartDate(paramMap.get(AgencyConstants.START_DATE));
			agency.setEndDate(paramMap.get(AgencyConstants.END_DATE));
			agency.setAddress(address);
			agency.setRemarks(remarks);
			agency.setStatus(status);
			/*agency.setCustomField1(customField1);
			agency.setCustomField2(customField2);
			agency.setCustomField3(customField3);
			if(Validator.isNotNull(dates)){
				agency.setCustomDate1(UIUtils.getDate(themeDisplay,dates.get(AgencyConstants.CUSTOM_DATE_1)));
				agency.setCustomDate2(UIUtils.getDate(themeDisplay,dates.get(AgencyConstants.CUSTOM_DATE_2)));
				agency.setCustomDate3(UIUtils.getDate(themeDisplay,dates.get(AgencyConstants.CUSTOM_DATE_3)));
			}*/
			if (agency.isNew()) {
				agency.setUuid(serviceContext.getUuid());
			}
			agency.setGroupId(groupId);
			agency.setModifiedDate(serviceContext.getModifiedDate(now));

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

/*	private Date getAgencyStartDate(ThemeDisplay themeDisplay,
			Map<String, String> paramMap) {
		int startDay = Integer.parseInt((paramMap.get("startDay")));
		int startMonth = Integer.parseInt((paramMap.get("startMonth")));
		int startYear = Integer.parseInt((paramMap.get("startYear")));
		Calendar startValueCalendar = Utils.getCalendar(themeDisplay, startDay-1,
				startMonth, startYear);
		return startValueCalendar.getTime();
	}

	private Date getAgencyEndDate(ThemeDisplay themeDisplay,
			Map<String, String> paramMap) {
		int endDay = Integer.parseInt((paramMap.get("endDay")));
		int endMonth = Integer.parseInt((paramMap.get("endMonth")));
		int endYear = Integer.parseInt((paramMap.get("endYear")));
		Calendar endValueCalendar = Utils.getCalendar(themeDisplay, endDay-1,
				endMonth, endYear);
		return endValueCalendar.getTime();
	}

	private Date getCustomDate1(ThemeDisplay themeDisplay,
			Map<String, String> paramMap) {
		int customDay1 = Integer.parseInt((paramMap.get("customDay1")));
		int customMonth1 = Integer.parseInt((paramMap.get("customMonth1")));
		int customYear1 = Integer.parseInt((paramMap.get("customYear1")));
		Calendar customCal1 = Utils.getCalendar(themeDisplay, customDay1-1,
				customMonth1, customYear1);
		return customCal1.getTime();
	}
	private Date getCustomDate2(ThemeDisplay themeDisplay,
			Map<String, String> paramMap) {
		int customDay2 = Integer.parseInt((paramMap.get("customDay2")));
		int customMonth2 = Integer.parseInt((paramMap.get("customMonth2")));
		int customYear2 = Integer.parseInt((paramMap.get("customYear2")));
		Calendar customCal2 = Utils.getCalendar(themeDisplay, customDay2-1,
				customMonth2, customYear2);
		return customCal2.getTime();
	}
	private Date getCustomDate3(ThemeDisplay themeDisplay,
			Map<String, String> paramMap) {
		int customDay3 = Integer.parseInt((paramMap.get("customDay3")));
		int customMonth3 = Integer.parseInt((paramMap.get("customMonth3")));
		int customYear3 = Integer.parseInt((paramMap.get("customYear3")));
		Calendar customCal3 = Utils.getCalendar(themeDisplay, customDay3-1,
				customMonth3, customYear3);
		return customCal3.getTime();
	} */

	public long[] getCategoryIds(Map<String, String> paramMap) {
		long[] categoryIds = new long[AgencyConstants.CATEGORIES_IDS_SIZE];
		categoryIds[0] = GetterUtil.getLong(paramMap
				.get(AgencyConstants.COUNTRY_LIST));
		categoryIds[1] = GetterUtil.getLong(paramMap.get(AgencyConstants.TYPE));
	/*	categoryIds[2] = GetterUtil.getLong(paramMap
				.get(AgencyConstants.CUSTOM_LIST_1));
		categoryIds[3] = GetterUtil.getLong(paramMap
				.get(AgencyConstants.CUSTOM_LIST_2));
		categoryIds[4] = GetterUtil.getLong(paramMap
				.get(AgencyConstants.CUSTOM_LIST_3)); */

		return categoryIds;
	}

	public void addAgency(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		Map<String,DateBean>dates = null;
		try {
			Utils.logTheRequest(actionRequest, _log);
			LegalPermissionUtil.authorize(actionRequest, AgencyConstants.PORTLET_ID,
					AgencyConstants.ACTION_KEY_ADD_AGENCY);
		} catch (Exception ex) {
			SessionErrors.add(actionRequest, "unauthorized.agency.add");
			throw ex;
		}
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);

			Map<String, String> paramMap = Utils.getParameterMap(actionRequest);
			long[] categoryIds = getCategoryIds(paramMap);
			String number = paramMap.get(AgencyConstants.NUMBER);
			String countryName = Utils.getCategoryName(categoryIds[0]);
			dates = getDateBeanMap(themeDisplay, paramMap);
			boolean canAdd = Utils.checkUserPermissionOnCountry(
					actionRequest,
					GetterUtil.getLong(actionRequest.getPreferences().getValue(
							AgencyConstants.COUNTRY_VOC_ID, "0")), countryName);
			if (!canAdd) {
				SessionErrors.add(actionRequest,
						"unauthorized.agency.country.add");
				onAddAgencyFail(actionRequest, actionResponse,dates);
				return;
			} 

			boolean valid = validate(actionRequest, paramMap, "add",dates);
			if (!valid) {
				onAddAgencyFail(actionRequest, actionResponse,dates);
			} else {
				Agency agency = AgencyLocalServiceUtil.getNewAgency();
				fillAgencyObject(agency, paramMap, actionRequest,dates);
				agency.setNumber(number);
				agency.setCountry(countryName);
				AgencyLocalServiceUtil.addNewAgency(themeDisplay.getUserId(),
						agency, categoryIds);
				
				SessionMessages.add(actionRequest, "request_processed",
						"Agency has been added");
				long destFolderId = getAgencyFolderId(actionRequest, agency);
				updateAndMoveDocuments(actionRequest, agency.getSpAgencyId(),
						destFolderId);
				actionRequest.setAttribute(AgencyConstants.AGENCY_ID, agency.getSpAgencyId());
				displayAgencyDetailsAfterAddUpdate(actionRequest,actionResponse);
			}
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			SessionMessages.add(actionRequest, "agency.add.failed");
			onAddAgencyFail(actionRequest, actionResponse,dates);
		}
	}
	private void onAddAgencyFail(ActionRequest request, ActionResponse response,Map<String,DateBean>dates)
			throws Exception {

		SessionErrors.add(request, "agency.add.errors.exists");
		Map<String, String> paramMap = Utils.getParameterMap(request);
		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		Set<String> keys = paramMap.keySet();
		for (String key : keys) {
			response.setRenderParameter(key, paramMap.get(key));
		}
//		request.setAttribute(AgencyConstants.START_DATE,
//				Utils.getDateBean(getAgencyStartDate(themeDisplay, paramMap)));
//		request.setAttribute(AgencyConstants.END_DATE,
//				Utils.getDateBean(getAgencyEndDate(themeDisplay, paramMap)));
//		request.setAttribute(AgencyConstants.CUSTOM_DATE_1,
//				Utils.getDateBean(getCustomDate1(themeDisplay, paramMap)));
//		request.setAttribute(AgencyConstants.CUSTOM_DATE_2,
//				Utils.getDateBean(getCustomDate2(themeDisplay, paramMap)));
//		request.setAttribute(AgencyConstants.CUSTOM_DATE_3,
//				Utils.getDateBean(getCustomDate3(themeDisplay, paramMap)));
		setDatesToRequest(request, dates);
		displayAddAgency(request, response);
	}
	private void setDatesToRequest(ActionRequest actionRequest,Map<String,DateBean>dates){
		if(Validator.isNotNull(dates)){
/*			actionRequest.setAttribute(AgencyConstants.CUSTOM_DATE_1,dates.get(AgencyConstants.CUSTOM_DATE_1));
			actionRequest.setAttribute(AgencyConstants.CUSTOM_DATE_2,dates.get(AgencyConstants.CUSTOM_DATE_2));
			actionRequest.setAttribute(AgencyConstants.CUSTOM_DATE_3,dates.get(AgencyConstants.CUSTOM_DATE_3)); */
		}
	}
	private void updateAndMoveDocuments(PortletRequest request, long agencyId,
			long destFolderId) {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String userFodlerName = Utils.getUserFolderName(themeDisplay
					.getUserId());
			long userFolderId = getFolderId(request, userFodlerName);
			FilesUpload fu = new FilesUpload(agencyId, request);
			fu.updateAndMoveDocuments(userFolderId, destFolderId);
		} catch (Exception ex) {
		}
	}

	private boolean validate(PortletRequest request,
			Map<String, String> paramMap, String action,Map<String,DateBean>dates) {
		boolean valid = true;
		String name = paramMap.get(AgencyConstants.NAME);
		String reference = paramMap.get(AgencyConstants.REFERENCE);
		String address = paramMap.get(AgencyConstants.ADDRESS);
		String remarks = paramMap.get(AgencyConstants.REMARKS);
		String status = paramMap.get(AgencyConstants.STATUS);
		String number = paramMap.get(AgencyConstants.NUMBER);
		long[] categoryIds = getCategoryIds(paramMap);

		if ("add".equalsIgnoreCase(action)) {
			if (Validator.isNull(number)) {
				valid = false;
				SessionErrors.add(request, "agency.number.required");
			}
			if (categoryIds[0] == 0) {
				SessionErrors.add(request, "agency.country.required");
			}
			String countryName = Utils.getCategoryName(categoryIds[0]);
			Agency agencyTemp = AgencyLocalServiceUtil.findByNumberCountry(
					number, countryName);
			if (agencyTemp != null) {
				valid = false;
				SessionErrors.add(request, "agency.duplicate");
			}
		}
		//
		// if(categoryIds[1] == 0){
		// SessionErrors.add(request, "agency.type.required");
		// }
		//
//		if (Validator.isNull(name)) {
//			valid = false;
//			SessionErrors.add(request, "agency.name.required");
//		}
		// if(Validator.isNull(reference)){
		// valid = false;
		// SessionErrors.add(request, "agency.reference.required");
		// }
		// if(Validator.isNull(address)){
		// valid = false;
		// SessionErrors.add(request, "agency.address.required");
		// }
		// if(Validator.isNull(remarks)){
		// valid = false;
		// SessionErrors.add(request, "agency.remarks.required");
		// }
		// if(Validator.isNull(status)){
		// valid = false;
		// SessionErrors.add(request, "agency.status.required");
		// }
		
	/*	boolean dateValid = UIUtils.validateDate(dates.get(AgencyConstants.CUSTOM_DATE_1));
		if(!dateValid){
			valid = false;
			SessionErrors.add(request, "agency.custom.date1");
		}
		 dateValid = UIUtils.validateDate(dates.get(AgencyConstants.CUSTOM_DATE_2));
		if(!dateValid){
			valid = false;
			SessionErrors.add(request, "agency.custom.date2");
		}
		 dateValid = UIUtils.validateDate(dates.get(AgencyConstants.CUSTOM_DATE_3));
		if(!dateValid){
			valid = false;
			SessionErrors.add(request, "agency.custom.date3");
		} */
		return valid;
	}
	
	private Map<String,DateBean > getDateBeanMap(ThemeDisplay themeDisplay, Map<String,String>paramMap){
		Map<String,DateBean > map = new HashMap<String, DateBean>();
		try{
			
		/*	String day = paramMap.get("customDay1");
			String mon = paramMap.get("customMonth1");
			String year = paramMap.get("customYear1");
			DateBean db = new DateBean(day, mon, year);
			map.put(AgencyConstants.CUSTOM_DATE_1, db);
			
			day = paramMap.get("customDay2");
			mon = paramMap.get("customMonth2");
			year = paramMap.get("customYear2");
			db = new DateBean(day, mon, year);
			map.put(AgencyConstants.CUSTOM_DATE_2, db);

			day = paramMap.get("customDay3");
			mon = paramMap.get("customMonth3");
			year = paramMap.get("customYear3");
			db = new DateBean(day, mon, year);
			map.put(AgencyConstants.CUSTOM_DATE_3, db); */
		}catch(Exception ex){
			
		}
		return map;
	}

	private Object[] parseRequest(ActionRequest actionRequest,
			ActionResponse actionResponse) throws FileUploadException {
		Object[] objs = new Object[2];
		Map<String, String> paramMap = new HashMap<String, String>();
		List<FileItem> files = new ArrayList<FileItem>();

		HttpServletRequest request_ = PortalUtil
				.getHttpServletRequest(actionRequest);
		HttpServletRequest httpRequest = PortalUtil
				.getOriginalServletRequest(request_);
		try {
			List<FileItem> items = new ServletFileUpload(
					new DiskFileItemFactory()).parseRequest(httpRequest);
			String key;
			for (FileItem item : items) {
				if (item.isFormField()) {
					key = item.getFieldName();
					key = key.substring(actionResponse.getNamespace().length());
					paramMap.put(key, item.getString());
				} else {
					files.add(item);
				}
			}

		} catch (FileUploadException e) {
			_log.error(e.getMessage(), e);
			throw e;
		}

		objs[0] = paramMap;
		objs[1] = files;

		return objs;
	}

	private void markFileVersionsAsDelete(List<Long> fileEntryIds) {
		DLFileVersion dlFileVersion;
		for (long fileEntryId : fileEntryIds) {
			try {
				dlFileVersion = DLFileVersionLocalServiceUtil
						.getLatestFileVersion(fileEntryId, false);
				dlFileVersion.setStatus(WorkflowConstants.STATUS_INACTIVE);
				DLFileVersionLocalServiceUtil
						.updateDLFileVersion(dlFileVersion);
			} catch (Exception e) {
				_log.error(e.getMessage(), e);
			}
		}
	}
	public long getAgencyFolderId(PortletRequest request, Agency agency)
			throws Exception {
		String folderName = AgencySearch.getAgencyFolderName(agency.getRootSpAgencyId());
		return getFolderId(request, folderName);
	}

	
	public long getFolderId(PortletRequest request, String folderName)
			throws Exception {
		Folder folder = getFolder(request, folderName);
		long folderId = folder.getFolderId();
		return folderId;
	}
	public Folder getFolder(PortletRequest actionRequest, String folderName){
		Folder folder = null;
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);
		try {
			String folderPath = LegalConstants.LEGAL_ROOT_FOLDER_NAME + "/" + AgencyConstants.AGENCY_ROOT_FOLDER_NAME  + "/" + folderName;
			_log.debug("Law Firm folder path " + folderPath);
			folder = (Folder) Utils.createGetFileOrFolder(actionRequest, themeDisplay.getUser(), LegalConstants.DL_ROOT_FOLDER_ID, folderPath, 
					LegalConstants.FOLDER, false, true, true);
			_log.debug("Law Firm folder path " + folderPath + " Folder Id " + folder.getFolderId());
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}

		return folder;
	
	}
	
	public void updateAgency(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		Map<String,DateBean>dates = null;
		try {
			Utils.logTheRequest(actionRequest, _log);
			LegalPermissionUtil.authorize(actionRequest, AgencyConstants.PORTLET_ID,
					AgencyConstants.ACTION_KEY_EDIT_AGENCY);
		} catch (Exception ex) {
			SessionErrors.add(actionRequest, "unauthorized.agency.update");
			throw ex;
		}
		Map<String, String> paramMap = Utils.getParameterMap(actionRequest);;
		long[] categoryIds = getCategoryIds(paramMap);
		String agencyNumber = StringPool.BLANK;
		long oldAgencyId = ParamUtil.getLong(actionRequest,
				AgencyConstants.AGENCY_ID);
		long countryId = 0;
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
					.getAttribute(WebKeys.THEME_DISPLAY);
			PortletPreferences preferences = actionRequest.getPreferences();
			Agency oldAgency = AgencyLocalServiceUtil.getAgency(oldAgencyId);
			if(!AgencySearch.isAgencyLatest(oldAgency)){
				onUpdateFailed(paramMap, actionRequest, actionResponse, agencyNumber, oldAgencyId, countryId, dates);
				SessionErrors.add(actionRequest, "agency.not.working.copy");
				return;
			}
			countryId = Utils.getCategoryId(GetterUtil.getLong(preferences
					.getValue(AgencyConstants.COUNTRY_VOC_ID, "0")), oldAgency.getCountry());
			categoryIds[0] = countryId;
			dates = getDateBeanMap(themeDisplay, paramMap);
			boolean valid = validate(actionRequest, paramMap, "update",dates);
			agencyNumber = GetterUtil.getString(oldAgency.getNumber());
			String country = Utils.getCategoryName(countryId);
			long rootAgencyId = oldAgency.getRootSpAgencyId();

			boolean canEdit = Utils.checkUserPermissionOnCountry(actionRequest,
					GetterUtil.getLong(preferences.getValue(
							AgencyConstants.COUNTRY_VOC_ID, "0")), country);
			if (!canEdit) {
				SessionErrors.add(actionRequest,
						"unauthorized.agency.country.update");
				onUpdateFailed(paramMap, actionRequest, actionResponse,
						agencyNumber, oldAgencyId, countryId,dates);
				return;
			}

			if (!valid) {
				onUpdateFailed(paramMap, actionRequest, actionResponse,
						agencyNumber, oldAgencyId, countryId,dates);
			} else {
				Agency newAgency = AgencyLocalServiceUtil.getNewAgency();
				fillAgencyObject(newAgency, paramMap, actionRequest,dates);
				AgencyLocalServiceUtil.addNewAgencyVersion(
						themeDisplay.getUserId(), oldAgencyId, newAgency,
						categoryIds);

				String agencyFolderName = AgencySearch.getAgencyFolderName(rootAgencyId);
				long destFolderId = getFolderId(actionRequest, agencyFolderName);
				updateAndMoveDocuments(actionRequest, newAgency.getSpAgencyId(),
						destFolderId);

				String idsStr = paramMap.get("hiddenFileList");
				if (idsStr != null && !idsStr.equals("")) {
					String[] idsArray = idsStr.split(",");
					List<Long> fileEntryIds = new ArrayList<Long>();
					for (String id : idsArray) {
						try {
							fileEntryIds.add(Long.parseLong(id));
						} catch (Exception ex) {
							_log.error(ex.getCause(), ex);
						}
					}
					markFileVersionsAsDelete(fileEntryIds);
					DynamicQuery dynaQuery = DynamicQueryFactoryUtil.forClass(
							DLFileEntry.class,
							PortalClassLoaderUtil.getClassLoader());
					Criterion criterion = RestrictionsFactoryUtil.in(
							LegalConstants.FILE_ENTRY_ID, (List) fileEntryIds);
					dynaQuery.add(criterion);
					List<DLFileEntry> filesToReindx = DLFileEntryLocalServiceUtil
							.dynamicQuery(dynaQuery);
					Indexer indexer = IndexerRegistryUtil
							.getIndexer(DLFileEntry.class.getName());
					for (DLFileEntry dlFileEntry : filesToReindx) {
						indexer.reindex(dlFileEntry);
					}
				}
				actionRequest.setAttribute(AgencyConstants.AGENCY_ID, newAgency.getSpAgencyId());
				displayAgencyDetailsAfterAddUpdate(actionRequest,actionResponse);
				SessionMessages.add(actionRequest, "request_processed",
						"Agency has been updated");
			}

		} catch (Exception e) {
			_log.error(e.getMessage(), e);
			SessionErrors.add(actionRequest, "agency.update.failed");
			onUpdateFailed(paramMap, actionRequest, actionResponse,
					agencyNumber, oldAgencyId, countryId,dates);
		}
	}

	public void onUpdateFailed(Map<String, String> paramMap,
			ActionRequest actionRequest, ActionResponse actionResponse,
			String agencyNumber, long oldAgencyId, long countryId,Map<String,DateBean>dates) {

		Set<String> keys = paramMap.keySet();
		for (String key : keys) {
			actionResponse.setRenderParameter(key, paramMap.get(key));
		}
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		actionResponse.setRenderParameter(actionResponse.getNamespace()
				+ AgencyConstants.NUMBER, agencyNumber);
		actionResponse.setRenderParameter(actionResponse.getNamespace()
				+ AgencyConstants.COUNTRY_LIST, countryId + "");
//		actionRequest.setAttribute(AgencyConstants.START_DATE,
//				Utils.getDateBean(getAgencyStartDate(themeDisplay, paramMap)));
//		actionRequest.setAttribute(AgencyConstants.END_DATE,
//				Utils.getDateBean(getAgencyEndDate(themeDisplay, paramMap)));
//		actionRequest.setAttribute(AgencyConstants.CUSTOM_DATE_1,
//				Utils.getDateBean(getCustomDate1(themeDisplay, paramMap)));
//		actionRequest.setAttribute(AgencyConstants.CUSTOM_DATE_2,
//				Utils.getDateBean(getCustomDate2(themeDisplay, paramMap)));
//		actionRequest.setAttribute(AgencyConstants.CUSTOM_DATE_3,
//				Utils.getDateBean(getCustomDate3(themeDisplay, paramMap)));
		fillCategoryLists(actionRequest);
		actionRequest.setAttribute(AgencyConstants.AGENCY_ID, oldAgencyId);
		actionResponse.setRenderParameter("jspPage",
				"/html/agency/editAgency.jsp");
		setDatesToRequest(actionRequest, dates);
	}

	public void upload(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		try {
			LegalPermissionUtil.authorize(actionRequest, AgencyConstants.PORTLET_ID,
					AgencyConstants.ACTION_KEY_BULKUPLOAD_AGENCY);
		} catch (Exception ex) {
			SessionErrors.add(actionRequest, "unauthorized.agency.bulkupload");
			throw ex;
		}
		try {
			AgencyBulkupload bu = new AgencyBulkupload(actionRequest,
					actionResponse);
			bu.process();
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse) {

		PortletPreferences preferences = actionRequest.getPreferences();
		String classificaionTypeId = ParamUtil.getString(actionRequest,
				AgencyConstants.TYPE_VOC_ID);
		String countryId = ParamUtil.getString(actionRequest,
				AgencyConstants.COUNTRY_VOC_ID);
	/*	String customList1Id = ParamUtil.getString(actionRequest,
				AgencyConstants.CUSTOM_LIST_1_VOC_ID);
		String customList2Id = ParamUtil.getString(actionRequest,
				AgencyConstants.CUSTOM_LIST_2_VOC_ID);
		String customList3Id = ParamUtil.getString(actionRequest,
				AgencyConstants.CUSTOM_LIST_3_VOC_ID);*/

		try {
			preferences.setValue(AgencyConstants.TYPE_VOC_ID,
					classificaionTypeId);
			preferences.setValue(AgencyConstants.COUNTRY_VOC_ID, countryId);
	/*		preferences.setValue(AgencyConstants.CUSTOM_LIST_1_VOC_ID,
					customList1Id);
			preferences.setValue(AgencyConstants.CUSTOM_LIST_2_VOC_ID,
					customList2Id);
			preferences.setValue(AgencyConstants.CUSTOM_LIST_3_VOC_ID,
					customList3Id); */
			preferences.store();

			Utils.saveSPParameter(SambaashConstants.AGENCY_TYPE_VOC_ID,
					classificaionTypeId);
			Utils.saveSPParameter(SambaashConstants.AGENCY_COUNTRY_VOC_ID,
					countryId);
		/*	Utils.saveSPParameter(
					SambaashConstants.AGENCY_CUSTOM_LIST_1_VOC_ID,
					customList1Id);
			Utils.saveSPParameter(
					SambaashConstants.AGENCY_CUSTOM_LIST_2_VOC_ID,
					customList2Id);
			Utils.saveSPParameter(
					SambaashConstants.AGENCY_CUSTOM_LIST_3_VOC_ID,
					customList3Id); */

			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (Exception e) {
			_log.error(e.getMessage(), e);
		}
	}

	@Override
	public void doEdit(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {

			PortletPreferences preferences = renderRequest.getPreferences();
			String classificaionTypeId = preferences.getValue(
					AgencyConstants.TYPE_VOC_ID, "0");
			String countryId = preferences.getValue(
					AgencyConstants.COUNTRY_VOC_ID, "0");
		/*	String customList1Id = preferences.getValue(
					AgencyConstants.CUSTOM_LIST_1_VOC_ID, "0");
			String customList2Id = preferences.getValue(
					AgencyConstants.CUSTOM_LIST_2_VOC_ID, "0");
			String customList3Id = preferences.getValue(
					AgencyConstants.CUSTOM_LIST_3_VOC_ID, "0");
*/
			List<AssetVocabulary> assetVocabularies = AssetVocabularyLocalServiceUtil
					.getAssetVocabularies(-1, -1);
			renderRequest.setAttribute("assetVocabularies", assetVocabularies);
			renderRequest.setAttribute(AgencyConstants.TYPE_VOC_ID,
					classificaionTypeId);
			renderRequest.setAttribute(AgencyConstants.COUNTRY_VOC_ID,
					countryId);
			/*renderRequest.setAttribute(AgencyConstants.CUSTOM_LIST_1_VOC_ID,
					customList1Id);
			renderRequest.setAttribute(AgencyConstants.CUSTOM_LIST_2_VOC_ID,
					customList2Id);
			renderRequest.setAttribute(AgencyConstants.CUSTOM_LIST_3_VOC_ID,
					customList3Id);*/

		} catch (SystemException e) {
			_log.error(e.getMessage(), e);
		}
		super.doEdit(renderRequest, renderResponse);
	}

	private void fillCategoryLists(ActionRequest actionRequest) {
		PortletPreferences preferences = actionRequest.getPreferences();
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest
				.getAttribute(WebKeys.THEME_DISPLAY);

		String classificaionTypeVocId = preferences.getValue(
				AgencyConstants.TYPE_VOC_ID, StringPool.BLANK);

		long countryVocId = GetterUtil.getLong(preferences.getValue(
				AgencyConstants.COUNTRY_VOC_ID, "0"));
	/*	String customList1VocId = preferences.getValue(
				AgencyConstants.CUSTOM_LIST_1_VOC_ID, "0");
		String customList2VocId = preferences.getValue(
				AgencyConstants.CUSTOM_LIST_2_VOC_ID, "0");
		String customList3VocId = preferences.getValue(
				AgencyConstants.CUSTOM_LIST_3_VOC_ID, "0");
*/
		if (Validator.isNull(classificaionTypeVocId)) {
			_log.info("Setup incomplete. Please ask admin to configure classification and country list");
		} else {

			List<AssetCategory> classificationTypeList = Utils
					.getCategories(Long.parseLong(classificaionTypeVocId));
			/*List<AssetCategory> customList1 = Utils.getCategories(Long
					.parseLong(customList1VocId));
			List<AssetCategory> customList2 = Utils.getCategories(Long
					.parseLong(customList2VocId));
			List<AssetCategory> customList3 = Utils.getCategories(Long
					.parseLong(customList3VocId)); */

			LegalPermissionUtil pu = new LegalPermissionUtil();
			List<AssetCategory> countryList = pu.getPermissionedCountries(
					themeDisplay.getUserId(), themeDisplay.getScopeGroupId(),
					countryVocId); 
		//	List<AssetCategory>countryList = Utils.getCategories(countryVocId);
			actionRequest.setAttribute("countryList", countryList);
			actionRequest.setAttribute("classificationTypeList",
					classificationTypeList);
			/*actionRequest.setAttribute("customList1", customList1);
			actionRequest.setAttribute("customList2", customList2);
			actionRequest.setAttribute("customList3", customList3);*/

		}
	}
}