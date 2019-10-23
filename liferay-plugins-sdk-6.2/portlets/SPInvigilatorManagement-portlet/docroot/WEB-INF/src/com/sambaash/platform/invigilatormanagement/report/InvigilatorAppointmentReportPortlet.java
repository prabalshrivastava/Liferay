package com.sambaash.platform.invigilatormanagement.report;

import java.io.IOException;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.sambaash.platform.action.DefaultServeResourceManager;
import com.sambaash.platform.action.ServeResourceActionManager;
import com.sambaash.platform.invigilatormanagement.action.ajax.ArchiveActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.CheckEmailActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.CreateActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.ExportListActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.ExportReportActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.ExportRowActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FetchActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FetchFormFieldsActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FetchGroupActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FetchUpcommingFacilityScheduleActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FileDownloadActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.FilterColumnListActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.LoadListActionHandler;
import com.sambaash.platform.invigilatormanagement.action.ajax.SearchListActionHandler;

/**
 * Portlet implementation class InvigilatorAppointmentReportPortlet
 */
public class InvigilatorAppointmentReportPortlet extends MVCPortlet {
 
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
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("fileDownload", FileDownloadActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("checkEmail",  CheckEmailActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("groupName", FetchGroupActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("uocommingFacilitySchedule",FetchUpcommingFacilityScheduleActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("exportReport",ExportReportActionHandler.class);
	}
	/**
     * This is an object of Log class
     */
    private Log log = LogFactoryUtil.getLog(InvigilatorAppointmentReportPortlet.class.getName());
    
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
}
