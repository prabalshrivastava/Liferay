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
import com.liferay.saml.model.SamlSpSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mika Koivisto
 */
public class SingleLogoutProfileUtil {

	public static SamlSpSession getSamlSpSession(HttpServletRequest request)
		throws SystemException {

		return getSingleLogoutProfile().getSamlSpSession(request);
	}

	public static SingleLogoutProfile getSingleLogoutProfile() {
		return _singleLogoutProfile;
	}

	public static boolean isSingleLogoutSupported(HttpServletRequest request) {
		return getSingleLogoutProfile().isSingleLogoutSupported(request);
	}

	public static void processIdpLogout(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		getSingleLogoutProfile().processIdpLogout(request, response);
	}

	public static void processSingleLogout(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		getSingleLogoutProfile().processSingleLogout(request, response);
	}

	public static void processSpLogout(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {

		getSingleLogoutProfile().processSpLogout(request, response);
	}

	public void setSingleLogoutProfile(
		SingleLogoutProfile singleLogoutProfile) {

		_singleLogoutProfile = singleLogoutProfile;
	}

	private static SingleLogoutProfile _singleLogoutProfile;

}