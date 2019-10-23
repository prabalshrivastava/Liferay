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

package com.liferay.saml.hook.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.profile.SingleLogoutProfileUtil;
import com.liferay.saml.util.PortletWebKeys;
import com.liferay.saml.util.SamlUtil;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mika Koivisto
 * @author W. Berks
 */
public class SamlIdpSsoFilter extends SamlBaseFilter {

	@Override
	public boolean isFilterEnabled(HttpServletRequest request, HttpServletResponse response) {

		if (_log.isDebugEnabled()) {
			_log.debug("isFilterEnabled -- path = " + SamlUtil.getRequestPath(request));
		}

		try {
			if (!this.isSamlEnabled(request))
				return false;

			User user = PortalUtil.getUser(request);

			if (user != null) {
				return true;
			}
		} catch (Exception e) {
			this.getLog().warn(e, e);
		}

		return SamlUtil.isLogoutRequest(request);
	}

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws Exception {

		if (SamlUtil.isLogoutRequest(request)) {
			String samlSsoSessionId = CookieKeys.getCookie(request, PortletWebKeys.SAML_SSO_SESSION_ID);

			if (Validator.isNotNull(samlSsoSessionId)) {
				SingleLogoutProfileUtil.processIdpLogout(request, response);
			} else {
				filterChain.doFilter(request, response);
			}
		} else {
			filterChain.doFilter(request, response);
		}
	}

	private final static Log _log = LogFactoryUtil.getLog(SamlIdpSsoFilter.class);
}