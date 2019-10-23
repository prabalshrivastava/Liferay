package com.sambaash.platform.workspaceannouncement;

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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.announcement.action.ajax.ArchiveActionHandler;
import com.sambaash.platform.announcement.action.ajax.CreateActionHandler;
import com.sambaash.platform.announcement.action.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.announcement.action.ajax.ExportListActionHandler;
import com.sambaash.platform.announcement.action.ajax.ExportRowActionHandler;
import com.sambaash.platform.announcement.action.ajax.FetchActionHandler;
import com.sambaash.platform.announcement.action.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.announcement.action.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.announcement.action.ajax.LoadListActionHandler;
import com.sambaash.platform.announcement.action.ajax.SearchListActionHandler;
import com.sambaash.platform.constant.SystemSetupConstants;
import com.sambaash.platform.topannouncement.TopAnnouncementPortlet;

/**
 * Portlet implementation class WorkspaceAnnouncementPortlet
 */
public class WorkspaceAnnouncementPortlet extends MVCPortlet {
	private static final Log log = LogFactoryUtil.getLog(WorkspaceAnnouncementPortlet.class);

	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData",  FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields",  FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList",  LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("archive",  ArchiveActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("searchList",  SearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList",  ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("filterColumnList", FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow", ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);

	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		 try {
			    String action = resourceRequest.getParameter( "action");
				SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
		    }
		    catch (Exception e) {
		    	log.error(e);
		    }
	}

	
	
	
	
	public void savePreferences(ActionRequest actionRequest,
			ActionResponse actionResponse)  {
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
			log.error(e);
		}
		
	}

}
