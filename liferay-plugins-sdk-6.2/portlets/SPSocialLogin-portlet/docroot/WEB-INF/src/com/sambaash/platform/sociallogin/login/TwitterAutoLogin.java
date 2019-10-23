package com.sambaash.platform.sociallogin.login;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.BaseAutoLogin;
import com.liferay.portal.service.UserLocalServiceUtil;

public class TwitterAutoLogin extends BaseAutoLogin {
	private static Log _log = LogFactoryUtil.getLog(TwitterAutoLogin.class);

	public String[] doLogin(HttpServletRequest request,
			HttpServletResponse response) {
		String[] credentials = null;
		try {

			HttpSession session = request.getSession();

			Long userId = (Long) session.getAttribute("TWITTER_USER_ID");

			if (userId == null) {
				return null;
			}

			session.removeAttribute("TWITTER_USER_ID");

			User user = UserLocalServiceUtil.getUserById(userId.longValue());

			_log.debug("Do TwitterAutoLogin");

			credentials = new String[3];

			credentials[0] = String.valueOf(user.getUserId());
			credentials[1] = user.getPassword();
			credentials[2] = Boolean.TRUE.toString();

			_log.debug("End TwitterAutoLogin");
		} catch (Exception e) {
			_log.error(e, e);
		}

		return credentials;
	}
}