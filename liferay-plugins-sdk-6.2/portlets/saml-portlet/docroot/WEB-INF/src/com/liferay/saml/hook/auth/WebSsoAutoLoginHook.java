/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.saml.hook.auth;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AutoLoginException;
import com.liferay.portal.security.auth.BaseAutoLogin;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.model.SamlIdpSsoSession;
import com.liferay.saml.service.SamlIdpSsoSessionLocalServiceUtil;
import com.liferay.saml.util.PortletWebKeys;
import com.liferay.saml.util.SamlUtil;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mika Koivisto
 */
public class WebSsoAutoLoginHook extends BaseAutoLogin {


	protected String[] doLogin(
			HttpServletRequest request, HttpServletResponse response)
		throws AutoLoginException {

		try {
			_log.debug("doLogin");
			long companyId = PortalUtil.getCompanyId(request);
			long groupId = SamlUtil.getGroupId(request);
			if (_log.isTraceEnabled() && (groupId == 0L)) {
				_log.trace("No groupId found");
				StringBuffer req = request.getRequestURL();
				boolean first = true;
				for (Enumeration<String> keys = request.getParameterNames(); keys.hasMoreElements(); ) {
					String key = keys.nextElement();
					String value = request.getParameter(key);
					if (first) {
						req.append('?');
						first = false;
					}
					else
						req.append('&');
					req.append(key).append('=').append(value);
				}
				_log.trace("Request = " + req.toString());
			}

			_log.debug(String.format("SAML enabled - %s, Role is SP = %s", 
					SamlUtil.isEnabled(companyId, groupId), SamlUtil.isRoleSp(companyId)));

			if (!SamlUtil.isEnabled(companyId, groupId) || SamlUtil.isRoleSp(companyId)) {
				_log.debug("Exit autologin, either SAML is not enabled or this is a service provider");
				return null;
			}

			String samlSsoSessionId = CookieKeys.getCookie(
				request, PortletWebKeys.SAML_SSO_SESSION_ID);

			if (Validator.isNull(samlSsoSessionId)) {
				_log.debug("SAML session cookie not found, exit auto login");
				return null;
			}

			SamlIdpSsoSession samlIdpSsoSession =
				SamlIdpSsoSessionLocalServiceUtil.fetchSamlIdpSso(
					samlSsoSessionId);

			if ((samlIdpSsoSession == null) || samlIdpSsoSession.isExpired()) {
				_log.debug("Session either null or expired, exit auto login");
				return null;
			}

			User user = UserLocalServiceUtil.fetchUserById(
				samlIdpSsoSession.getUserId());

			if (user == null) {
				_log.debug("Unable to find user, exit auto login");
				return null;
			}

			String[] credentials = new String[3];

			credentials[0] = String.valueOf(user.getUserId());
			credentials[1] = user.getPassword();
			credentials[2] = Boolean.TRUE.toString();

			_log.debug("Return the uesr's credentials");
			return credentials;
		}
		catch (Exception e) {
			_log.warn(e, e);

			throw new AutoLoginException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(WebSsoAutoLoginHook.class);

}