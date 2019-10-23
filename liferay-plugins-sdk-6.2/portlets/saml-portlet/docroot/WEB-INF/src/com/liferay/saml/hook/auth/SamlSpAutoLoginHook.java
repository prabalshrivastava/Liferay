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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.Company;
import com.liferay.portal.model.User;
import com.liferay.portal.security.auth.AutoLoginException;
import com.liferay.portal.security.auth.BaseAutoLogin;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.model.SamlSpSession;
import com.liferay.saml.profile.WebSsoProfileUtil;
import com.liferay.saml.util.SamlUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mika Koivisto
 */
public class SamlSpAutoLoginHook extends BaseAutoLogin {


	protected String[] doLogin(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		_log.debug("doLogin");
		if (!SamlUtil.isAuthRedirectRequest(request)) {
			_log.debug("This is not an authentication redirect request -- exit");
			return null;
		}
		
		_log.debug("Auth redirect request");

		Company company = PortalUtil.getCompany(request);
		long groupId = SamlUtil.getGroupId(request);
		if (groupId == 0l) {
			groupId = company.getGroup().getGroupId();
		}
		
		try {
			if (!SamlUtil.isEnabled(company.getCompanyId(), groupId) || 
					!SamlUtil.isRoleSp(company.getCompanyId())) {
				_log.debug("not enabled");
				return null;
			}

			SamlSpSession samlSpSession = WebSsoProfileUtil.getSamlSpSession(
				request);

			if (samlSpSession == null) {
				_log.debug("No sp session");
				return null;
			}

			User user = UserLocalServiceUtil.fetchUser(
				samlSpSession.getUserId());

			if (user == null) {
				_log.debug("No user");
				return null;
			}

			String[] credentials = new String[3];

			credentials[0] = String.valueOf(user.getUserId());
			credentials[1] = user.getPassword();
			credentials[2] = Boolean.TRUE.toString();

			_log.debug("Return credentials");
			return credentials;
		}
		catch (Exception e) {
			_log.warn(e, e);

			throw new AutoLoginException(e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SamlSpAutoLoginHook.class);

}