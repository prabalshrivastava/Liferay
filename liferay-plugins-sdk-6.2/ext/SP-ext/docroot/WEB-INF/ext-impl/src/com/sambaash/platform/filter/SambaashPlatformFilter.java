package com.sambaash.platform.filter;

import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.util.PortalUtil;

public class SambaashPlatformFilter extends BasePortalFilter {

	@SuppressWarnings("unused")
	private ServletContext _servletContext;

	private static Log _log = LogFactoryUtil.getLog(SambaashPlatformFilter.class);

	public void init(FilterConfig filterConfig) {
		super.init(filterConfig);
		_servletContext = filterConfig.getServletContext();
	}

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws Exception {

		_log.info(" SambaashPlatformFilter ");
		HttpSession session = request.getSession();
		String value = StringPool.BLANK;
		String redirect = StringPool.BLANK;
		Map<String, String[]> originalParams = request.getParameterMap();
		if (originalParams.get("requestTokenId") != null) {
			value = originalParams.get("requestTokenId")[0];
		}

		if (originalParams.get("redirect") != null) {
			redirect = originalParams.get("redirect")[0];
		}

		String profile = StringPool.FORWARD_SLASH
				+ SambaashUtil.getParameter(SambaashConstants.URL.PROFILE_IND_PRIVATE,
						PortalUtil.getScopeGroupId(request));
		String signinPage = StringPool.FORWARD_SLASH
				+ SambaashUtil.getParameter(SambaashConstants.SIGNIN_PAGE, PortalUtil.getScopeGroupId(request));
		String signupPage = StringPool.FORWARD_SLASH
				+ SambaashUtil.getParameter(SambaashConstants.ACCOUNT_CREATION_PAGE,
						PortalUtil.getScopeGroupId(request));

		String userName = (String) session.getAttribute("j_username");
		String password = (String) session.getAttribute("j_password");

		boolean isSignedin = false;
		if (Validator.isNotNull(userName) && Validator.isNotNull(password)) {
			isSignedin = true;
		}

		if (Validator.isNotNull(redirect)
				&& (request.getRequestURL().toString().endsWith(signinPage) || request.getRequestURL().toString()
						.endsWith(signupPage))) {
			if (isSignedin) {
				if (redirect.contains(SambaashUtil.getVirtualHost(PortalUtil.getScopeGroupId(request)))
						|| redirect.startsWith(StringPool.FORWARD_SLASH)) {
					response.sendRedirect(redirect);

				} else {
					response.sendRedirect(SambaashUtil.getDashboardUrl(PortalUtil.getScopeGroupId(request),
							Long.parseLong(userName)));
				}
				return;
			}
		}

		if (Validator.isNull(redirect) && request.getRequestURL().toString().endsWith(profile)) {

			if (!isSignedin) {
				redirect = PortalUtil.getPortalURL(request) + signinPage + "?redirect="
						+ PortalUtil.getPortalURL(request) + profile;
				response.sendRedirect(redirect);
			}

		}

		if ("accountsettings".equalsIgnoreCase(value)) {

			if (Validator.isNotNull(userName) && Validator.isNotNull(password)) {
				isSignedin = true;
			}

			if (!isSignedin) {
				String loginUrl = PortalUtil.getPortalURL(request) + "/signin?redirect="
						+ PortalUtil.getPortalURL(request) + "/account-settings";

				response.sendRedirect(loginUrl);

				return;

			} else {
				String accountSettingsUrl = PortalUtil.getPortalURL(request) + "/account-settings";
				response.sendRedirect(accountSettingsUrl);

				return;
			}
		}

		filterChain.doFilter(request, response);

	}
}