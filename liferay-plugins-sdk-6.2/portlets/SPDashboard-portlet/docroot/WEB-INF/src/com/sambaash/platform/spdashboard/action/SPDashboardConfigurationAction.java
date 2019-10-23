package com.sambaash.platform.spdashboard.action;

import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;

/**
 * @author Abhinay
 */
public class SPDashboardConfigurationAction extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		PortletPreferences preferences = actionRequest.getPreferences();
		Enumeration<String> names = preferences.getNames();
		while (names.hasMoreElements()) {
			String param = (String) names.nextElement();
			preferences.reset(param);
		}

		super.processAction(portletConfig, actionRequest, actionResponse);
	}

}