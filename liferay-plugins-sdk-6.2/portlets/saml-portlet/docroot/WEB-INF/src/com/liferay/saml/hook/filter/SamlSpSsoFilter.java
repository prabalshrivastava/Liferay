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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.struts.LastPath;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.model.SamlSpSession;
import com.liferay.saml.profile.SingleLogoutProfileUtil;
import com.liferay.saml.profile.WebSsoProfileUtil;
import com.liferay.saml.service.SamlSpSessionLocalServiceUtil;
import com.liferay.saml.util.PortletWebKeys;
import com.liferay.saml.util.SamlUtil;

import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Mika Koivisto
 */
public class SamlSpSsoFilter extends SamlBaseFilter {


	public boolean isFilterEnabled(
		HttpServletRequest request, HttpServletResponse response) {
		this.getLog().debug("isFilterEnabled() -- path = " + SamlUtil.getRequestPath(request));
		try {
			if (!this.isSamlEnabled(request))
				return false;
	
			if (!SamlUtil.isRoleSp(PortalUtil.getCompanyId(request))) {
				return false;
			}

			if (PortalUtil.getUser(request) != null) {
				return true;
			}
		}
		catch (Exception e) {
			this.getLog().warn(e, e);
		}
		
		return SamlUtil.isLoginRequest(request) || SamlUtil.isLogoutRequest(request);
	}


	protected void login(
			HttpServletRequest request, HttpServletResponse response)
		throws PortalException, SystemException {
		
		this.getLog().debug("Do a SAML login");
		
		String relayState = ParamUtil.getString(request, "redirect");

		if (Validator.isNotNull(relayState)) {
			relayState = PortalUtil.escapeRedirect(relayState);
		}

		HttpSession session = request.getSession();

		LastPath lastPath = (LastPath)session.getAttribute(WebKeys.LAST_PATH);

		if (GetterUtil.getBoolean(
				PropsUtil.get(PropsKeys.AUTH_FORWARD_BY_LAST_PATH)) &&
			(lastPath != null) && Validator.isNull(relayState)) {

			StringBundler sb = new StringBundler(4);

			sb.append(PortalUtil.getPortalURL(request));
			sb.append(lastPath.getContextPath());
			sb.append(lastPath.getPath());
			sb.append(
				HttpUtil.parameterMapToString(lastPath.getParameterMap()));

			relayState = sb.toString();
		}
		else if (Validator.isNull(relayState)) {
			relayState = PortalUtil.getPathMain();
		}

		this.getLog().debug("Send a authentication request with the relay being: " + relayState);
		
		WebSsoProfileUtil.sendAuthnRequest(request, response, relayState);
	}


	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {

		if (SamlUtil.isLoginRequest(request)) {
			this.getLog().debug("This is a login request");;
			login(request, response);
		}
		else if (SamlUtil.isLogoutRequest(request) &&
				SamlUtil.isDoNotUseSamlForLogout(request)) {
			this.getLog().info("Do not use SAML for logout");

			SamlSpSession samlSpSession =
					SingleLogoutProfileUtil.getSamlSpSession(request);
			if (samlSpSession != null) {
				try {
					this.getLog().info("Delete the SAML session from the db");;
					SamlSpSessionLocalServiceUtil.deleteSamlSpSession(samlSpSession);
				} catch (Exception e) {}
			}
			
			this.getLog().info("Expire the SAML cookie");
			Cookie cookie = new Cookie(
					PortletWebKeys.SAML_SP_SESSION_KEY, StringPool.BLANK);

			cookie.setMaxAge(0);

			if (Validator.isNull(PortalUtil.getPathContext())) {
				cookie.setPath(StringPool.SLASH);
			}
			else {
				cookie.setPath(PortalUtil.getPathContext());
			}

			cookie.setSecure(request.isSecure());

			response.addCookie(cookie);
			
			filterChain.doFilter(request, response);
		}
		else if (SamlUtil.isLogoutRequest(request) &&
				 SingleLogoutProfileUtil.isSingleLogoutSupported(request)) {

			this.getLog().info("Process logout request where singleLogout is supported");
			SamlSpSession samlSpSession =
				SingleLogoutProfileUtil.getSamlSpSession(request);

			if (samlSpSession != null) {
				SingleLogoutProfileUtil.processSpLogout(request, response);
			}
			else {
				filterChain.doFilter(request, response);
			}
		}
		else {
			SamlSpSession samlSpSession =
				SingleLogoutProfileUtil.getSamlSpSession(request);

			if ((samlSpSession != null) && samlSpSession.isTerminated()) {
				this.getLog().debug("Found an expired saml session -- delete it");
				SamlSpSessionLocalServiceUtil.deleteSamlSpSession(
					samlSpSession);

				HttpSession session = request.getSession();

				session.invalidate();

				Cookie cookie = new Cookie(
					PortletWebKeys.SAML_SP_SESSION_KEY, StringPool.BLANK);

				cookie.setMaxAge(0);

				if (Validator.isNull(PortalUtil.getPathContext())) {
					cookie.setPath(StringPool.SLASH);
				}
				else {
					cookie.setPath(PortalUtil.getPathContext());
				}

				cookie.setSecure(request.isSecure());

				response.addCookie(cookie);

				response.sendRedirect(
					PortalUtil.getCurrentCompleteURL(request));
			}
			else {
				filterChain.doFilter(request, response);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.servlet.BaseFilter#getLog()
	 */
	@Override
	protected Log getLog() {
		return _log;
	}
	
	private final static Log _log = LogFactoryUtil.getLog(SamlSpSsoFilter.class);
}