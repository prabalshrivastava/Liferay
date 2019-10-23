package com.sambaash.platform.systemmodelsetup.exambody;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import org.json.JSONArray;
import org.json.JSONObject;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.systemmodelsetup.action.ajax.ArchiveActionHandler;
import com.sambaash.platform.systemmodelsetup.action.ajax.CreateActionHandler;
import com.sambaash.platform.systemmodelsetup.action.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.systemmodelsetup.action.ajax.ExportListActionHandler;
import com.sambaash.platform.systemmodelsetup.action.ajax.ExportRowActionHandler;
import com.sambaash.platform.systemmodelsetup.action.ajax.FetchActionHandler;
import com.sambaash.platform.systemmodelsetup.action.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.systemmodelsetup.action.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.systemmodelsetup.action.ajax.LoadListActionHandler;
import com.sambaash.platform.systemmodelsetup.action.ajax.SearchListActionHandler;
import com.sambaash.platform.systemmodelsetup.taxcode.TaxCodePortlet;

/**
 * Portlet implementation class ExamBody
 */
public class ExamBodyPortlet extends MVCPortlet {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields", FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList", LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("archive", ArchiveActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList", SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList", ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow", ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);

	}
	/**
	 * This is an object of Log class
	 */
	private Log _log = LogFactoryUtil.getLog(TaxCodePortlet.class.getName());

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			String action = resourceRequest.getParameter("action");
			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
		} catch (Exception e) {
			_log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences preferences = actionRequest.getPreferences();
		String formId = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_HTML_FORM_ID, "0");
		String style = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_CONTAINER_STYLE, "");
		String modelName = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_MODEL_NAME, "0");
		String baseUrl = ParamUtil.getString(actionRequest, SystemSetupConstants.PREF_BASE_URL, "");
		try {
			preferences.setValue(SystemSetupConstants.PREF_HTML_FORM_ID, formId);
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME, modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			_log.error(e);
		}
		JSONCheck();
	}

	public void JSONCheck() {
		try {
			String str = "{\"ModelName\":\"ExamBody\",\"Status\":\"Active\",\"UploadThumbnail\":[],\"submit\":true,\"ExamBody\":\"SAC\",\"Description\":\"DC\",\"SelectPerson\":[\"Invigilator\",\"RELC EB Approver\"]}";
			JSONObject in = new JSONObject(str);
			JSONObject jsonModelExistingData = new JSONObject();
			if (jsonModelExistingData.toString().equals("{}")) {

				JSONObject contentJson = new JSONObject();
				contentJson.put("Status", "Active");
				jsonModelExistingData.put("contentJson", contentJson);
			}

			for (int i = 0; i < in.names().length(); i++) {

				Object json = in.get(in.names().getString(i));
				if (json instanceof JSONArray) {
					_log.debug("JSONArray = " + in.get(in.names().getString(i)));
					jsonModelExistingData.getJSONObject("contentJson").put(in.names().getString(i),
							in.getJSONArray(in.names().getString(i)));
				} else {
					jsonModelExistingData.getJSONObject("contentJson").put(in.names().getString(i),
							in.getString(in.names().getString(i)));
				}

			}
			_log.debug("modified 1data1 = " + jsonModelExistingData.toString());

		} catch (Exception e) {
			_log.error(e.getMessage());
		}

	}
}
