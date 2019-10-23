package com.sambaash.platform.action.ajax;

import javax.portlet.PortletPreferences;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONObject;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class UpdateSettingsListActionHandler implements ServeResourceActionHandler {

	private Log _log = LogFactoryUtil.getLog(FetchActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		PortletPreferences preferences = request.getPreferences();
		JSONObject objMain = new JSONObject();
		try {
			preferences.setValue("select1", request.getParameter("select1"));
			preferences.setValue("select2", request.getParameter("select2"));
			preferences.setValue("select3", request.getParameter("select3"));
			preferences.setValue("select4", request.getParameter("select4"));

			_log.debug("select1=" + request.getParameter("select1") + "\nselect2=" + request.getParameter("select2")
					+ "\nselect3=" + request.getParameter("select3") + "\nselect4=" + request.getParameter("select4"));
			preferences.store();
			response.getWriter().write("" + objMain.toString());

		} catch (Exception e) {
			_log.error(e);
		}

	}

}
