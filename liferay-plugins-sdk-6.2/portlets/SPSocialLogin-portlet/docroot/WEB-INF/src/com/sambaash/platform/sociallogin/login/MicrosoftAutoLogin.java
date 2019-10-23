package com.sambaash.platform.sociallogin.login;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.BaseAutoLogin;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class MicrosoftAutoLogin extends BaseAutoLogin {
	private static Log _log = LogFactoryUtil.getLog(MicrosoftAutoLogin.class);

	protected String[] doLogin(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		long companyId = PortalUtil.getCompanyId(request);

		User user = getUserBySession(request, companyId);

		if (Validator.isNull(user)) {
			return null;
		}

		_log.debug("Do MicrosoftAutoLogin");

		String[] credentials = new String[3];

		credentials[0] = String.valueOf(user.getUserId());
		credentials[1] = user.getPassword();
		credentials[2] = Boolean.TRUE.toString();

		_log.debug("End MicrosoftAutoLogin");

		return credentials;
	}

	protected User getUserBySession(HttpServletRequest request, long companyId)
			throws PortalException, SystemException {
		HttpSession session = request.getSession();

		String emailAddress = GetterUtil.getString(session
				.getAttribute("MICROSOFT_USER_EMAIL_ADDRESS"));

		if (Validator.isNull(emailAddress)) {
			return null;
		}

		session.removeAttribute("MICROSOFT_USER_EMAIL_ADDRESS");

		User user = UserLocalServiceUtil.getUserByEmailAddress(companyId,
				emailAddress);

		return user;
	}
}