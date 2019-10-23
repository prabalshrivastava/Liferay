package com.sambaash.platform;

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
import com.sambaash.platform.action.ajax.CreateActionHandler;
import com.sambaash.platform.action.ajax.ElasticSearchCandidateListActionHandler;
import com.sambaash.platform.action.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.action.ajax.ExportListActionHandler;
import com.sambaash.platform.action.ajax.ExportRowActionHandler;
import com.sambaash.platform.action.ajax.FetchActionHandler;
import com.sambaash.platform.action.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.action.ajax.FetchScreenNameActionHandler;
import com.sambaash.platform.action.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.action.ajax.LoadListActionHandler;
import com.sambaash.platform.action.ajax.SendNotificationActionHandler;
import com.sambaash.platform.action.ajax.SendRequestActionHandler;
import com.sambaash.platform.constant.SystemSetupConstants;

/**
 * Portlet implementation class EnrolmentListingPortlet
 */
public class EnrolmentListingPortlet extends MVCPortlet {
 
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("persist", CreateActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadData",  FetchActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchFormFields",  FetchFormFieldsActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("loadList",  LoadListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchList",  ElasticSearchListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("filterColumnList",  FilterColumnListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fetchScreenName",  FetchScreenNameActionHandler.class); 
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elastiSearchCandidateList",  ElasticSearchCandidateListActionHandler.class); 
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendRequest", SendRequestActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("sendNotification", SendNotificationActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportRow", ExportRowActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportList", ExportListActionHandler.class);
	
	}
	/**
     * This is an object of Log class
     */
    private Log log = LogFactoryUtil.getLog(EnrolmentListingPortlet.class.getName());
    
    
    
    @Override
    public void serveResource(ResourceRequest resourceRequest,ResourceResponse resourceResponse)throws  IOException, PortletException {
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
		
		String documentUrlPref = ParamUtil.getString(actionRequest, "documentUrlPref", "");
		String switchProgrammeUrlPref = ParamUtil.getString(actionRequest, "switchProgrammeUrlPref", "0");
		String switchSubjectUrlPref = ParamUtil.getString(actionRequest, "switchSubjectUrlPref", "");
		String processEnrollmentUrlPref = ParamUtil.getString(actionRequest, "processEnrollmentUrlPref", "0");
		String sendNotificationUrlPref = ParamUtil.getString(actionRequest, "sendNotificationUrlPref", "");
		try {
			preferences.setValue(SystemSetupConstants.PREF_HTML_FORM_ID, formId);
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, style);
			preferences.setValue(SystemSetupConstants.PREF_MODEL_NAME, modelName);
			preferences.setValue(SystemSetupConstants.PREF_BASE_URL, baseUrl);
			
			preferences.setValue("documentUrlPref", documentUrlPref);
			preferences.setValue("switchProgrammeUrlPref", switchProgrammeUrlPref);
			preferences.setValue("switchSubjectUrlPref", switchSubjectUrlPref);
			preferences.setValue("processEnrollmentUrlPref", processEnrollmentUrlPref);
			preferences.setValue("sendNotificationUrlPref", sendNotificationUrlPref);
			preferences.store();
			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			log.error(e);
		}
		
	}
}
