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

package com.liferay.saml.profile;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.saml.model.SamlSpSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mika Koivisto
 */
public class WebSsoProfileUtil {

	public static SamlSpSession getSamlSpSession(HttpServletRequest request)
		throws SystemException {

		return getWebSsoProfile().getSamlSpSession(request);
	}

	public static WebSsoProfile getWebSsoProfile() {
		return _webSsoProfile;
	}

	public static void processAuthnRequest(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		getWebSsoProfile().processAuthnRequest(request, response);
	}

	public static void processResponse(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		getWebSsoProfile().processResponse(request, response);
	}

	public static void sendAuthnRequest(
			HttpServletRequest request, HttpServletResponse response,
			String relayState)
		throws PortalException, SystemException {

		getWebSsoProfile().sendAuthnRequest(request, response, relayState);
	}

	public void setWebSsoProfile(WebSsoProfile webSsoProfile) {
		_webSsoProfile = webSsoProfile;
	}

	private static WebSsoProfile _webSsoProfile;
	private final static Log _log = LogFactoryUtil.getLog(WebSsoProfileUtil.class);

}