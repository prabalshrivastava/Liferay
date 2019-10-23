package com.sambaash.platform.action.ajax;

import java.io.IOException;
import com.sambaash.platform.systemmodelsetup.service.SystemLocalServiceUtil;

import javax.portlet.PortletMode;
import javax.portlet.PortletModeException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;

import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;
import com.sambaash.platform.constant.SystemSetupConstants;

public class SavePreferenceActionHandler implements ServeResourceActionHandler {

	private Log log = LogFactoryUtil.getLog(SavePreferenceActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {

		PortletPreferences preferences = request.getPreferences();
		String data = ParamUtil.getString(request, "data", "0");
		try {
			JSONObject datajson = JSONFactoryUtil.createJSONObject(data);

			preferences.setValue("preference", data);
			preferences.setValue("baseUrlPref", datajson.getString("baseUrl"));
			preferences.setValue(SystemSetupConstants.PREF_CONTAINER_STYLE, datajson.getString("containerStyle"));

			preferences.store();

		} catch (JSONException | ReadOnlyException | ValidatorException | IOException e) {
			log.error(e);
		}

		try {
			response.getWriter().write("done");

		} catch (IOException e) {
			log.error(e);
		}

	}

}
