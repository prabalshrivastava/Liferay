package com.sambaash.platform.spperiscopedata.action;

import java.util.Enumeration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;


public class SPPeriscopeDataConfigAction extends DefaultConfigurationAction {
	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		// clear old values
		PortletPreferences preferences = actionRequest.getPreferences();
		Enumeration<String> names = preferences.getNames();
		while (names.hasMoreElements()) {
			String param = (String) names.nextElement();
			preferences.reset(param);
		}
		super.processAction(portletConfig, actionRequest, actionResponse);
	}
}
