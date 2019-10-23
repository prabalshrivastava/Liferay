/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portlet.login.action;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletConfig;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletURL;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.WindowState;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.liferay.portal.CompanyMaxUsersException;
import com.liferay.portal.CookieNotSupportedException;
import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.PasswordExpiredException;
import com.liferay.portal.UserEmailAddressException;
import com.liferay.portal.UserIdException;
import com.liferay.portal.UserLockoutException;
import com.liferay.portal.UserPasswordException;
import com.liferay.portal.UserScreenNameException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Http;
import com.liferay.portal.kernel.util.HttpUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Layout;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.security.auth.AuthException;
import com.liferay.portal.struts.PortletAction;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PortletKeys;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.liferay.portlet.PortletPreferencesFactoryUtil;
import com.liferay.portlet.PortletURLImpl;
import com.liferay.portlet.login.util.LoginUtil;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.thread.SPThreadLocal;
import com.sambaash.platform.util.SambaashUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class LoginAction extends PortletAction {

	@Override
	public void processAction(ActionMapping actionMapping, ActionForm actionForm, PortletConfig portletConfig,
			ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (PropsValues.AUTH_LOGIN_DISABLED) {
			actionResponse.sendRedirect(themeDisplay.getPathMain() + PropsValues.AUTH_LOGIN_DISABLED_PATH);

			return;
		}

		/*
		 * if (actionRequest.getRemoteUser() != null) {
		 * actionResponse.sendRedirect(themeDisplay.getPathMain());
		 * 
		 * return; }
		 */

		try {
			login(themeDisplay, actionRequest, actionResponse);

			boolean doActionAfterLogin = ParamUtil.getBoolean(actionRequest, "doActionAfterLogin");

			if (doActionAfterLogin) {
				setForward(actionRequest, "portlet.login.login_redirect");
			}
		} catch (Exception e) {
			if (e instanceof AuthException) {
				
				if(_log.isDebugEnabled()){
					_log.error(e);
				}
				
				Throwable cause = e.getCause();

				if (cause instanceof PasswordExpiredException || cause instanceof UserLockoutException) {

					SessionErrors.add(actionRequest, cause.getClass());
				} else {
					if (_log.isInfoEnabled()) {
						_log.info("Authentication failed");
					}

					SessionErrors.add(actionRequest, e.getClass());
				}
			} else if (e instanceof CompanyMaxUsersException || e instanceof CookieNotSupportedException
					|| e instanceof NoSuchUserException || e instanceof PasswordExpiredException
					|| e instanceof UserEmailAddressException || e instanceof UserIdException
					|| e instanceof UserLockoutException || e instanceof UserPasswordException
					|| e instanceof UserScreenNameException) {

				SessionErrors.add(actionRequest, e.getClass());
			} else {
				_log.error(e, e);

				PortalUtil.sendError(e, actionRequest, actionResponse);

				return;
			}

			postProcessAuthFailure(actionRequest, actionResponse);
		}
	}

	@Override
	public ActionForward render(ActionMapping actionMapping, ActionForm actionForm, PortletConfig portletConfig,
			RenderRequest renderRequest, RenderResponse renderResponse) throws Exception {

		return actionMapping.findForward(getForward(renderRequest, "portlet.login.login"));
	}

	protected String getCompleteRedirectURL(HttpServletRequest request, String redirect) {

		HttpSession session = request.getSession();

		Boolean httpsInitial = (Boolean) session.getAttribute(WebKeys.HTTPS_INITIAL);

		String portalURL = null;

		if (PropsValues.COMPANY_SECURITY_AUTH_REQUIRES_HTTPS && !PropsValues.SESSION_ENABLE_PHISHING_PROTECTION
				&& (httpsInitial != null) && !httpsInitial.booleanValue()) {

			portalURL = PortalUtil.getPortalURL(request, false);
		} else {
			portalURL = PortalUtil.getPortalURL(request);
		}

		return portalURL.concat(redirect);
	}

	@Override
	protected boolean isCheckMethodOnProcessAction() {
		return _CHECK_METHOD_ON_PROCESS_ACTION;
	}

	protected void login(ThemeDisplay themeDisplay, ActionRequest actionRequest, ActionResponse actionResponse)
			throws Exception {

		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		HttpServletResponse response = PortalUtil.getHttpServletResponse(actionResponse);

		String login = ParamUtil.getString(actionRequest, "login");
		if (_log.isDebugEnabled()) {
			_log.debug("User screen name - " + login + " is trying to login");
		}
		String password = actionRequest.getParameter("password");
		boolean rememberMe = ParamUtil.getBoolean(actionRequest, "rememberMe");

		if (!themeDisplay.isSignedIn()) {
			PortletPreferences portletPreferences = PortletPreferencesFactoryUtil.getPortletSetup(actionRequest);

			String authType = portletPreferences.getValue("authType", null);
			String jssessionId = request.getSession().getId();
			_log.error(">>>>> Session ID in LoginAction: " + jssessionId);
			addSPAuthenticationScope(themeDisplay.getCompanyId(), actionRequest);
			LoginUtil.login(request, response, login, password, rememberMe, authType);
		}

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		if(redirect.isEmpty()){
			redirect = ParamUtil.getString(actionRequest, "_58_redirect");
		}
		if (Validator.isNotNull(redirect)) {

			redirect = PortalUtil.escapeRedirect(redirect);

			if (Validator.isNotNull(redirect) && !redirect.startsWith(Http.HTTP)) {

				redirect = getCompleteRedirectURL(request, redirect);
			}
		}

		String mainPath = themeDisplay.getPathMain();

		if (PropsValues.PORTAL_JAAS_ENABLE) {
			if (Validator.isNotNull(redirect)) {
				redirect = mainPath.concat("/portal/protected?redirect=").concat(HttpUtil.encodeURL(redirect));
			} else {
				redirect = mainPath.concat("/portal/protected");
			}

			actionResponse.sendRedirect(redirect);
		} else {
			HttpSession session = request.getSession();
			long userId = GetterUtil.getLong((String) session.getAttribute("j_username"));
			// here themedisplay does not actual user id.. and points to guest
			// user. So we need to get from session
			redirect = getRedirect(redirect, themeDisplay, userId, actionRequest, actionResponse);
			if (Validator.isNotNull(redirect)) {
				actionResponse.sendRedirect(redirect);
			} else {
				boolean doActionAfterLogin = ParamUtil.getBoolean(actionRequest, "doActionAfterLogin");

				if (doActionAfterLogin) {
					return;
				} else {
					actionResponse.sendRedirect(mainPath);
				}
			}
		}
	}

	/**
	 * Calculating redirect value
	 * 
	 * If redirect is not empty return same. if redirect is null/empty, read the
	 * logged in user roles and redirect to page configured for his role. If
	 * user has multiple roles, then order the roles by order property then
	 * retrieve the redirect from the role that contains valid redirect. if
	 * redirect is still empty then look for any configured value in sp
	 * parameteres.If so , redirect to the configured value
	 * 
	 * @param redirect
	 * @return
	 */
	private String getRedirect(String redirect, ThemeDisplay themeDisplay, long userId, ActionRequest actionRequest,
			ActionResponse actionResponse) {

		if (_log.isDebugEnabled()) {
			_log.error("redirect : " + redirect);
			_log.error("themeDisplay.getURLCurrent() : " + themeDisplay.getURLCurrent());
			_log.error("lastActionPath : "
					+ CookieKeys.getCookie(PortalUtil.getHttpServletRequest(actionRequest), "lastActionPath"));
		}

		if (Validator.isNull(redirect)) {

			if (!themeDisplay.getURLCurrent().contains("/portal/")) {
				String lastAction = CookieKeys.getCookie(PortalUtil.getHttpServletRequest(actionRequest),
						"lastActionPath");
				if (Validator.isNotNull(lastAction)) {
					redirect = lastAction;

					String domain = CookieKeys.getDomain(PortalUtil.getHttpServletRequest(actionRequest));
					Cookie lastActionCookie = new Cookie("lastActionPath", StringPool.BLANK);

					if (Validator.isNotNull(domain)) {
						lastActionCookie.setDomain(domain);
					}

					lastActionCookie.setMaxAge(0);
					lastActionCookie.setPath(StringPool.SLASH);
					CookieKeys.addCookie(PortalUtil.getHttpServletRequest(actionRequest),
							PortalUtil.getHttpServletResponse(actionResponse), lastActionCookie, false, false);

					_log.error("Erased the lastActionCookie cookie.");
				}
			}

			if (Validator.isNull(redirect)) {
				redirect = SambaashUtil.getPostLoginRedirectUrl(themeDisplay, userId);
			}
		}
		return redirect;
	}

	protected void postProcessAuthFailure(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {

		Layout layout = (Layout) actionRequest.getAttribute(WebKeys.LAYOUT);

		PortletURL portletURL = new PortletURLImpl(actionRequest, PortletKeys.LOGIN, layout.getPlid(),
				PortletRequest.RENDER_PHASE);

		portletURL.setParameter("saveLastPath", Boolean.FALSE.toString());

		String redirect = ParamUtil.getString(actionRequest, "redirect");

		if (Validator.isNotNull(redirect)) {
			portletURL.setParameter("redirect", redirect);
		}

		portletURL.setWindowState(WindowState.MAXIMIZED);

		actionResponse.sendRedirect(portletURL.toString());
	}

	protected String decodeRedirectUrl(String redirect) {
		int count = 1;
		try {
			while (redirect.contains("%") && count < 4) {
				redirect = URLDecoder.decode(redirect, "utf-8");

				if (_log.isDebugEnabled()) {
					_log.debug("redirect url pass : " + count + " : " + redirect);
				}

				count = count + 1;
			}
		} catch (UnsupportedEncodingException e) {
			_log.error("Failed to decode redirect url : " + redirect);
		}

		return redirect;
	}

	private void addSPAuthenticationScope(long companyId, ActionRequest actionRequest) {
		HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
		HttpSession loginSession = request.getSession();
		SPThreadLocal.setValue(SPThreadLocal.Key.LOGIN_SESSION, loginSession);
		String spLoginType = SambaashUtil.getSPLoginType(companyId);
		if (SambaashConstants.SP_USER_BY_DOMAIN_LOGIN.equals(spLoginType)
			|| SambaashConstants.SP_USER_BY_SPSITE_LOGIN.equals(spLoginType)
		){
			long virtualHostId = 0;
			long layoutSetId = 0;
			try {
				LayoutSet layoutSet = SambaashUtil.getLayoutSet(request);
				layoutSetId = layoutSet.getLayoutSetId();
				virtualHostId = SambaashUtil.getVirtualHostId(layoutSet);
			} catch (Exception e) {
				_log.error("Failed to get virtualhost id!", e);
			}
			SPThreadLocal.setValue(SPThreadLocal.Key.SP_LOGIN_LAYOUTSET_ID, layoutSetId);
			SPThreadLocal.setValue(SPThreadLocal.Key.SP_VIRTUALHOST_ID, virtualHostId);
			String subProductIds = "";
			try {
				subProductIds = SambaashUtil.getPageSubProductSettings(request);	
				_log.error("Got Login Param siteSubProducts -> "+subProductIds);
				SPThreadLocal.setValue(SPThreadLocal.Key.SP_SUB_PRODUCT_IDS, subProductIds);
			} catch (Exception e) {
				_log.error("Failed to get product info!", e);
			}
		}
	}

	private static final boolean _CHECK_METHOD_ON_PROCESS_ACTION = false;

	private static Log _log = LogFactoryUtil.getLog(LoginAction.class);

}
