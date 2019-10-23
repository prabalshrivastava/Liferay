package com.sambaash.platform.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

public class ConfigurationActionImpl extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		// TODO Auto-generated method stub
		super.processAction(portletConfig, actionRequest, actionResponse);
		
		PortletPreferences prefs = actionRequest.getPreferences();
		String maxlevels = ParamUtil.getString(actionRequest, "maxlevels");
        prefs.setValue("maxlevels", maxlevels);
        prefs.store();
	}

}