package com.sambaash.platform.spdynamicforms.action;

import static com.sambaash.platform.dynamicforms.DynamicFormsConstants.LOAD_FORM_ID;
import static com.sambaash.platform.dynamicforms.DynamicFormsConstants.LOAD_FORM_READ_ONLY;
import static com.sambaash.platform.dynamicforms.DynamicFormsConstants.LOAD_FORM_STORAGE_ID;
import static com.sambaash.platform.spdynamicforms.SPDynamicFormsConstants.PREF_CONTAINER_STYLE;
import static com.sambaash.platform.spdynamicforms.SPDynamicFormsConstants.PREF_HTML_FORM_ID;

import java.io.IOException;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.spdynamicforms.action.ajax.FileUploadActionHandler;
import com.sambaash.platform.spdynamicforms.action.ajax.LoadDataActionHandler;
import com.sambaash.platform.spdynamicforms.action.ajax.PersistActionHandler;
import com.sambaash.platform.srv.spdynamicforms.service.SPDynamicFormsLocalServiceUtil;

/**
 * Portlet implementation class SPDynamicFormsAction
 */
public class SPDynamicFormsAction extends MVCPortlet {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;

	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", PersistActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData", LoadDataActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("upload", FileUploadActionHandler.class);
	}
	
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		handleLoadForm(renderRequest, renderResponse);
		super.doView(renderRequest, renderResponse);
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException {
		boolean multipart = ServletFileUpload.isMultipartContent(PortalUtil.getHttpServletRequest(resourceRequest));
		String action = ParamUtil.getString(resourceRequest, "action");
		if (multipart && org.apache.commons.lang.StringUtils.isEmpty(action)) {
			action = "upload";
		}
		SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
	}

	private void handleLoadForm(RenderRequest renderRequest, RenderResponse renderResponse) {
		JSONObject loadParam = SPDynamicFormsLocalServiceUtil.retrieveLoadParam(renderRequest);
		String action = loadParam.getString("action");
		switch (action) {
		// friendly url handling
		case "loadDynamicForm":
			renderRequest.setAttribute(LOAD_FORM_ID, loadParam.getString(LOAD_FORM_STORAGE_ID));
			break;

		case "loadDynamicFormWithData":
			renderRequest.setAttribute(LOAD_FORM_ID, loadParam.getString(LOAD_FORM_ID));
			renderRequest.setAttribute(LOAD_FORM_STORAGE_ID, loadParam.getString(LOAD_FORM_STORAGE_ID));
			renderRequest.setAttribute(LOAD_FORM_READ_ONLY, loadParam.getString(LOAD_FORM_READ_ONLY));
			break;

		default:
			// otherwise, load the form specified in the preference
			PortletPreferences preferences = renderRequest.getPreferences();
			renderRequest.setAttribute(LOAD_FORM_ID, preferences.getValue(PREF_HTML_FORM_ID, "0"));
			break;
		}
	}

	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse) throws Exception {
		PortletPreferences preferences = actionRequest.getPreferences();
		String formId = ParamUtil.getString(actionRequest, PREF_HTML_FORM_ID, "0");
		String style = ParamUtil.getString(actionRequest, PREF_CONTAINER_STYLE, "");
		preferences.setValue(PREF_HTML_FORM_ID, formId);
		preferences.setValue(PREF_CONTAINER_STYLE, style);
		preferences.store();
		actionResponse.setPortletMode(PortletMode.VIEW);
	}
	
}