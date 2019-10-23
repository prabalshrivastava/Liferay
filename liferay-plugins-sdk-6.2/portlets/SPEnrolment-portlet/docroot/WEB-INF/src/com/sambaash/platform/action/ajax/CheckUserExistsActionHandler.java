package com.sambaash.platform.action.ajax;

import java.io.IOException;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.action.ServeResourceActionHandler;

public class CheckUserExistsActionHandler implements ServeResourceActionHandler {

	private Log _log = LogFactoryUtil.getLog(CreateActionHandler.class.getName());

	@Override
	public void handle(ResourceRequest request, ResourceResponse response) {
		String email = request.getParameter("data");
		User user;
		String result;
		long companyId = PortalUtil.getDefaultCompanyId();
		try {
			user = UserLocalServiceUtil.fetchUserByEmailAddress(companyId, email);
			if (user == null) {
				result = "true";
			} else {
				result = "false";
			}
			response.getWriter().write(result);
		} catch (SystemException | IOException e) {
			_log.error(e);
		}

	}
}
