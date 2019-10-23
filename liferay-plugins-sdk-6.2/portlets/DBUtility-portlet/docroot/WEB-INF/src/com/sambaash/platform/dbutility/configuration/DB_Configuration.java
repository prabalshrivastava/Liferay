package com.sambaash.platform.dbutility.configuration;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;

import com.liferay.portal.kernel.portlet.DefaultConfigurationAction;
import com.liferay.portal.kernel.util.ParamUtil;

public class DB_Configuration extends DefaultConfigurationAction {

	@Override
	public void processAction(PortletConfig portletConfig, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {
		String server_URL = ParamUtil.getString(actionRequest, "preferences--server_URL_PrefKey--");
		String username = ParamUtil.getString(actionRequest, "preferences--username_PrefKey--");
		String password = ParamUtil.getString(actionRequest, "preferences--password_PrefKey--");

		PortletPreferences prefs = actionRequest.getPreferences();
		prefs.setValue("server_URL_PrefKey", server_URL);
		prefs.setValue("username_PrefKey", username);
		prefs.setValue("password_PrefKey", password);
		prefs.store();
	}

}
