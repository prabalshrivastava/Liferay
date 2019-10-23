package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONSerializer;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class SearchListActionHandler implements ServeResourceActionHandler {
	private Log _log = LogFactoryUtil.getLog(SearchListActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String userEmail = ParamUtil.getString(request, "data");
		if (userEmail != null)
			userEmail = userEmail.substring(1, userEmail.length() - 1);
		User modelData = null;
		try {
			ThemeDisplay themeDisplayOptions = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
			long companyId = themeDisplayOptions.getCompanyId();
			modelData = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, userEmail);
		} catch (Exception e) {
			_log.error(e);
		}

		try {
			JSONSerializer jsonSerializer = JSONFactoryUtil.createJSONSerializer();
			String userResult = jsonSerializer.serialize(modelData);
			response.getWriter().write(userResult);

		} catch (IOException e) {
			_log.error(e);
		}
	}

}
