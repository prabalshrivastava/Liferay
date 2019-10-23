package com.sambaash.platform.timeline;

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
import com.sambaash.platform.timeline.ajax.ElasticSearchListActionHandler;
import com.sambaash.platform.timeline.ajax.FetchProcessListActionHandler;

/**
 * Portlet implementation class Timeline
 */
public class Timeline extends MVCPortlet {
	private static final ServeResourceActionManager SERVE_RESOURCE_MANAGER;
	static {
		SERVE_RESOURCE_MANAGER = new DefaultServeResourceManager();
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("processList", FetchProcessListActionHandler.class);
		SERVE_RESOURCE_MANAGER.registerResourceActionHandler("elasticSearch", ElasticSearchListActionHandler.class);
	}

	private Log log = LogFactoryUtil.getLog(Timeline.class.getName());

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		try {
			String action = resourceRequest.getParameter("action");

			SERVE_RESOURCE_MANAGER.newHandler(action).handle(resourceRequest, resourceResponse);
		} catch (Exception e) {
			log.error(e);
		}
	}

	public void savePreferences(ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences preferences = actionRequest.getPreferences();

		String specialRequestProcessId = ParamUtil.getString(actionRequest, "SpecialRequestProcessId", "");
		String enquiryProcessId = ParamUtil.getString(actionRequest, "EnquiryProcessId", "");
		String feedbackProcessId = ParamUtil.getString(actionRequest, "FeedbackProcessId", "");

		try {
			long[] roleIdList = ParamUtil.getLongValues(actionRequest, "roles");
			String[] strRoleList = new String[roleIdList.length];
			for (int i = 0; i < roleIdList.length; i++) {
				try {
					preferences.setValue("RoleID_" + i, "" + roleIdList[i]);
				} catch (ReadOnlyException e) {
					log.error(e);
				}
			}
			
			preferences.setValue("SpecialRequestProcessId", specialRequestProcessId);
			preferences.setValue("EnquiryProcessId", enquiryProcessId);
			preferences.setValue("FeedbackProcessId", "" + feedbackProcessId);
			preferences.setValue("RoleSize", "" + strRoleList.length);
			preferences.store();

			actionResponse.setPortletMode(PortletMode.VIEW);
		} catch (ReadOnlyException | ValidatorException | IOException | PortletModeException e) {
			log.error(e);
		}

	}

}
