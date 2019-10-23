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

package com.liferay.saml.hook.action;

import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.metadata.MetadataManagerUtil;
import com.liferay.saml.model.SamlIdpSpSession;
import com.liferay.saml.model.SamlIdpSsoSession;
import com.liferay.saml.service.SamlIdpSpSessionLocalServiceUtil;
import com.liferay.saml.service.SamlIdpSsoSessionLocalServiceUtil;
import com.liferay.saml.util.PortletWebKeys;
import com.liferay.saml.util.SamlUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mika Koivisto
 */
public class SessionKeepAliveAction extends BaseSamlStrutsAction {


	protected String doExecute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);
		
		if (SamlUtil.isRoleIdp(companyId)) {
			executeIdpSessionKeepAlive(request, response);
		}
		else if (SamlUtil.isRoleSp(companyId)) {
			executeSpSessionKeepAlive(request, response);
		}

		return null;
	}

	protected void executeIdpSessionKeepAlive(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		List<String> sessionKeepAliveURLs = getSessionKeepAliveURLs(request);

		response.addHeader(
			HttpHeaders.CACHE_CONTROL,
			HttpHeaders.CACHE_CONTROL_NO_CACHE_VALUE);
		response.addHeader(
			HttpHeaders.PRAGMA, HttpHeaders.PRAGMA_NO_CACHE_VALUE);

		response.setContentType(ContentTypes.TEXT_JAVASCRIPT);

		request.setAttribute(
			PortletWebKeys.SAML_SESSION_KEEP_ALIVE_URLS, sessionKeepAliveURLs);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(
			"/html/portal/saml/keep_alive.jsp");

		requestDispatcher.include(request, response);
	}

	protected void executeSpSessionKeepAlive(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		response.setHeader(
			HttpHeaders.CACHE_CONTROL,
			HttpHeaders.CACHE_CONTROL_NO_CACHE_VALUE);
		response.setHeader(
			HttpHeaders.PRAGMA, HttpHeaders.PRAGMA_NO_CACHE_VALUE);

		RequestDispatcher requestDispatcher = request.getRequestDispatcher(
			"/html/themes/_unstyled/spacer.png");

		requestDispatcher.forward(request, response);
	}

	protected List<String> getSessionKeepAliveURLs(HttpServletRequest request)
		throws Exception {

		String samlSsoSessionId = CookieKeys.getCookie(
			request, PortletWebKeys.SAML_SSO_SESSION_ID);

		SamlIdpSsoSession samlIdpSsoSession =
			SamlIdpSsoSessionLocalServiceUtil.fetchSamlIdpSso(samlSsoSessionId);

		if (samlIdpSsoSession == null) {
			return Collections.emptyList();
		}
		
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);

		List<String> sessionKeepAliveURLs = new ArrayList<String>();

		String entityId = ParamUtil.getString(request, "entityId");

		List<SamlIdpSpSession> samlIdpSpSessions =
			SamlIdpSpSessionLocalServiceUtil.getSamlIdpSpSessions(
				samlIdpSsoSession.getSamlIdpSsoSessionId());

		for (SamlIdpSpSession samlIdpSpSession : samlIdpSpSessions) {
			if (entityId.equals(samlIdpSpSession.getSamlSpEntityId())) {
				continue;
			}

			String sessionKeepAliveURL =
				MetadataManagerUtil.getSessionKeepAliveURL(
					companyId, groupId,
					samlIdpSpSession.getSamlSpEntityId());

			if (Validator.isNotNull(sessionKeepAliveURL)) {
				sessionKeepAliveURLs.add(sessionKeepAliveURL);
			}
		}

		return sessionKeepAliveURLs;
	}

}