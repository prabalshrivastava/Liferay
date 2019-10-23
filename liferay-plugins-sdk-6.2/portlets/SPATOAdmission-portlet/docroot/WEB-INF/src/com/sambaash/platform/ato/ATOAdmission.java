package com.sambaash.platform.ato;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import com.liferay.compat.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.PortletResponseUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.ato.ajax.CreateActionHandler;
import com.sambaash.platform.ato.ajax.DownloadPdfActionHandler;
import com.sambaash.platform.ato.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.ato.ajax.ExportListActionHandler;
import com.sambaash.platform.ato.ajax.ExportPdfActionHandler;
import com.sambaash.platform.ato.ajax.ExportRowActionHandler;
import com.sambaash.platform.ato.ajax.FetchActionHandler;
import com.sambaash.platform.ato.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.ato.ajax.FileDownloadActionHandler;
import com.sambaash.platform.ato.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.ato.ajax.LoadListActionHandler;
import com.sambaash.platform.ato.ajax.ScannedDataActionHandler;
import com.sambaash.platform.ato.ajax.SearchListActionHandler;
import com.sambaash.platform.ato.ajax.SendInvoiceActionHandler;
import com.sambaash.platform.ato.service.SPATOAdmissionLocalServiceUtil;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.srv.startupprofile.model.Organization;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;

public class ATOAdmission extends MVCPortlet {

	private Log log = LogFactoryUtil.getLog(ATOAdmission.class.getName());
	
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields", FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList", LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList", SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow", ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload", FileDownloadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("scanedData", ScannedDataActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportPdf", ExportPdfActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("downloadPdf", DownloadPdfActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendInvoice", SendInvoiceActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("scanedData", ScannedDataActionHandler.class);
	}

	/**
	 * This is an object of Log class
	 * 
	 * @throws PortletException
	 * @throws IOException
	 */

	private JSONArray jsonArr=null;
	String creditTerms=null;
	

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Map<String, String> resultComp = getValueOfDD(Long.valueOf("0"), "ato.admission.component");
		org.json.JSONObject jsonComp = new org.json.JSONObject(resultComp);
		org.json.JSONObject jsonAto = new org.json.JSONObject(getValueOfDD());

		renderRequest.setAttribute("component", jsonComp.toString());
		renderRequest.setAttribute("ato", jsonAto.toString());

		super.doView(renderRequest, renderResponse);
	}


	@Override
	public void render(RenderRequest request, RenderResponse response)
			throws PortletException, IOException {

		ThemeDisplay themeDisplay = (ThemeDisplay) request
				.getAttribute(WebKeys.THEME_DISPLAY);

		Map<String, String> resultComp = getValueOfDD(Long.valueOf("0"),
				"ato.admission.component");
		org.json.JSONObject jsonComp = new org.json.JSONObject(resultComp);


		org.json.JSONObject jsonAto = new org.json.JSONObject(getValueOfDD());

		request.setAttribute("component", jsonComp.toString());
		request.setAttribute("ato", jsonAto.toString());
		super.render(request, response);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {

		try {
			exportCSVData(resourceRequest, resourceResponse);
		} catch (Exception e) {
			log.error(e);
		}
		super.serveResource(resourceRequest, resourceResponse);
	}
	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences preferences = actionRequest.getPreferences();
		String formId = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_HTML_FORM_ID, "0");
		String style = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_CONTAINER_STYLE, "");
		String modelName = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_MODEL_NAME, "0");
		String baseUrl = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_BASE_URL, "");
		String selectedUserType = ParamUtil.getString(actionRequest, "userType", "");
		creditTerms = ParamUtil.getString(actionRequest, "creditTerms", "");

		try {
			preferences.setValue(SystemSetupConstants.PREF_HTML_FORM_ID, formId);
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME, modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.setValue("selectedUserType", selectedUserType);
			preferences.setValue("creditTerms" , creditTerms);

			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			log.error(e);
		}
	}

	public Map<String, String> getValueOfDD(Long groupId, String key) {
		return SPATOAdmissionLocalServiceUtil.getListOfComponent(groupId, key);
	}

	public Map<String, String> getValueOfDD() {
		List<Organization> organizations = OrganizationLocalServiceUtil.getAllActiveOrganizations();
		Map<String, String> map = new HashMap<String, String>();
		for (Organization organization : organizations) {

			map.put(String.valueOf(organization.getOrganizationId()), organization.getName());
		}
		return map;
	}

	public void uploadFiles(ActionRequest actionRequest, ActionResponse actionResponse) {

		try {
		
		    String response = SPATOAdmissionLocalServiceUtil.handleBatchUploadFile(actionRequest, actionResponse,creditTerms);
			JSONObject data = null;
			String totalRecords = "0";
			String successfulRecords = "0";
			String failedRecords = "0";
			JSONArray invalidRecords = JSONFactoryUtil.createJSONArray();

			JSONObject heading = JSONFactoryUtil.createJSONObject();
			JSONObject sequence = JSONFactoryUtil.createJSONObject();
			try {
				data = JSONFactoryUtil.createJSONObject(response).getJSONObject("data");
			} catch (JSONException e) {
				log.error(e.getMessage());
			}
			totalRecords = data.getString("totalRecords");
			successfulRecords = data.getString("successfulRecords");
			failedRecords = data.getString("failedRecords");
			invalidRecords = data.getJSONArray("invalidRecords");
			jsonArr = data.getJSONArray("invalidRecords");
			actionResponse.setRenderParameter("totalRecords", String.valueOf(totalRecords));
			actionResponse.setRenderParameter("successfulRecords", String.valueOf(successfulRecords));
			actionResponse.setRenderParameter("failedRecords", String.valueOf(failedRecords));
			actionResponse.setRenderParameter("invalidRecords", invalidRecords.toString());
			actionResponse.setRenderParameter("heading", heading.toString());
			actionResponse.setRenderParameter("sequence", sequence.toString());
			actionResponse.setRenderParameter("pendingProcessing", "0");

			actionResponse.setRenderParameter("responsee", response);
			actionResponse.setRenderParameter("mvcPath", "/html/atoadmission/uploadFileStatus.jsp");
		} catch (Exception ex) {
			log.error(ex.getMessage());
		}
	}

	protected void exportCSVData(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws Exception {
		List<JSONObject> usersList = new ArrayList<JSONObject>();
		JSONArray jArray = (JSONArray) jsonArr;
		if (jArray != null) {
			for (int i = 0; i < jArray.length(); i++) {
				usersList.add(jArray.getJSONObject(i));
			}
		}
		String[] columnNames = { "RowNo", "firstName", "lastName", "nirc", "telephone1", "telephone2", "email",
				"gender", "currentPrograme", "Salutation", "enrolmentStatus", "programSemester", "programmeCode",
				"scheduleCode", "feeType", "dueDate", "subjectList", "priceTypeCode", "Reason" };
		String CSV_SEPARATOR = ",";
		StringBundler sb = new StringBundler();
		for (String columnName : columnNames) {
			sb.append(getCSVFormattedValue(columnName));
			sb.append(CSV_SEPARATOR);
		}
		sb.setIndex(sb.index() - 1);
		sb.append(CharPool.NEW_LINE);

		for (JSONObject user : usersList) {
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("RowNo"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("firstName"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("lastName"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("IDNumber"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("telephone1"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("telephone2"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("email"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("gender"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("currentPrograme"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("salutation"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("enrolmentStatus"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("programSemester"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("programmeCode"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("scheduleCode"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("feeType"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("dueDate"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("subjectList"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("priceSchemeCode"))));
			sb.append(CSV_SEPARATOR);
			sb.append(getCSVFormattedValue(String.valueOf(user.getString("Reason"))));
			sb.append(CSV_SEPARATOR);
			sb.setIndex(sb.index() - 1);
			sb.append(CharPool.NEW_LINE);
		}
		String fileName = "ATOAdmissonUsers.csv";
		byte[] bytes = sb.toString().getBytes();
		String contentType = ContentTypes.APPLICATION_TEXT;
		PortletResponseUtil.sendFile(resourceRequest, resourceResponse, fileName, bytes, contentType);
	}

	protected String getCSVFormattedValue(String value) {
		StringBundler sb = new StringBundler(3);
		sb.append(CharPool.QUOTE);
		sb.append(StringUtil.replace(value, CharPool.QUOTE, StringPool.DOUBLE_QUOTE));
		sb.append(CharPool.QUOTE);
		return sb.toString();
	}

}
