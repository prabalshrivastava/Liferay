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

package com.liferay.portal.servlet.filters.i18n;

import java.net.InetAddress;
import java.util.Collections;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

import javax.servlet.FilterChain;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts.Globals;

import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpMethods;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.Group;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.User;
import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.PropsValues;
import com.liferay.portal.util.WebKeys;
import com.maxmind.geoip2.GeoIp2Provider;
import com.maxmind.geoip2.WebServiceClient;
import com.maxmind.geoip2.model.CountryResponse;
import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.srv.spservices.service.SPIPGeoLocationLocalServiceUtil;
import com.sambaash.platform.util.SambaashUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class I18nFilter extends BasePortalFilter {

	public static final String SKIP_FILTER = I18nFilter.class.getName() + "SKIP_FILTER";

	public static Set<String> getLanguageIds() {
		return _languageIds;
	}

	public static void setLanguageIds(Set<String> languageIds) {
		_languageIds = new HashSet<String>();

		for (String languageId : languageIds) {
			languageId = languageId.substring(1);

			_languageIds.add(languageId);
		}

		_languageIds = Collections.unmodifiableSet(_languageIds);
	}

	@Override
	public boolean isFilterEnabled(HttpServletRequest request, HttpServletResponse response) {

		if (!isAlreadyFiltered(request) && !isForwardedByI18nServlet(request)) {
			return true;
		} else {
			return false;
		}
	}

	protected String getRedirect(HttpServletRequest request, HttpServletResponse response) throws Exception {
		if (PropsValues.LOCALE_PREPEND_FRIENDLY_URL_STYLE == 0) {
			return null;
		}

		String method = request.getMethod();

		if (method.equals(HttpMethods.POST)) {
			return null;
		}

		String contextPath = PortalUtil.getPathContext();

		String requestURI = request.getRequestURI();

		if (Validator.isNotNull(contextPath) && requestURI.contains(contextPath)) {

			requestURI = requestURI.substring(contextPath.length());
		}

		requestURI = StringUtil.replace(requestURI, StringPool.DOUBLE_SLASH, StringPool.SLASH);

		//

		Boolean isLocRedirectEnabled = GetterUtil
				.getBoolean(SambaashUtil.getParameter("geo-location-redirect-enabled", 0), false);
		String i18nLanguageId = null;
		if (isLocRedirectEnabled) {
			i18nLanguageId = prependI18nLanguageId(request, response, PropsValues.LOCALE_PREPEND_FRIENDLY_URL_STYLE,
					isLocRedirectEnabled);
		}

		//

		if (i18nLanguageId == null) {
			return null;
		}

		Locale locale = LocaleUtil.fromLanguageId(i18nLanguageId);

		// lithan language logic patch

		if (!isLocRedirectEnabled) {
			if (!LanguageUtil.isAvailableLocale(locale)) {
				return null;
			}
		}

		//

		String i18nPathLanguageId = PortalUtil.getI18nPathLanguageId(locale, i18nLanguageId);

		String i18nPath = StringPool.SLASH.concat(i18nPathLanguageId);

		if (requestURI.contains(i18nPath.concat(StringPool.SLASH))) {

			// lithan language logic patch
			if (isLocRedirectEnabled) {
				LanguageUtil.updateCookie(request, response, LocaleUtil.fromLanguageId(i18nLanguageId));
			}
			// End

			return null;
		}

		String redirect = contextPath + i18nPath + requestURI;

		LayoutSet layoutSet = (LayoutSet) request.getAttribute(WebKeys.VIRTUAL_HOST_LAYOUT_SET);

		if ((layoutSet != null) && requestURI.startsWith(PropsValues.LAYOUT_FRIENDLY_URL_PUBLIC_SERVLET_MAPPING)) {

			int[] groupFriendlyURLIndex = PortalUtil.getGroupFriendlyURLIndex(requestURI);

			if (groupFriendlyURLIndex != null) {
				int x = groupFriendlyURLIndex[0];
				int y = groupFriendlyURLIndex[1];

				String groupFriendlyURL = requestURI.substring(x, y);

				Group group = layoutSet.getGroup();

				if (groupFriendlyURL.equals(group.getFriendlyURL())) {
					redirect = contextPath + i18nPath + requestURI.substring(y);
				}
			}
		}

		String queryString = request.getQueryString();

		if (Validator.isNotNull(queryString)) {
			redirect += StringPool.QUESTION + request.getQueryString();
		}

		return redirect;
	}

	protected boolean isAlreadyFiltered(HttpServletRequest request) {
		if (request.getAttribute(SKIP_FILTER) != null) {
			return true;
		} else {
			return false;
		}
	}

	protected boolean isForwardedByI18nServlet(HttpServletRequest request) {
		if ((request.getAttribute(WebKeys.I18N_LANGUAGE_ID) != null)
				|| (request.getAttribute(WebKeys.I18N_PATH) != null)) {

			return true;
		} else {
			return false;
		}
	}

	protected String prependI18nLanguageId(HttpServletRequest request, HttpServletResponse response,
			int prependFriendlyUrlStyle, boolean isLocRedirectEnabled) {

		String userLanguageId = null;

		User user = (User) request.getAttribute(WebKeys.USER);

		if (user != null) {
			userLanguageId = user.getLanguageId();
		}

		String guestLanguageId = userLanguageId;

		if (Validator.isNull(guestLanguageId)) {
			guestLanguageId = CookieKeys.getCookie(request, CookieKeys.GUEST_LANGUAGE_ID, false);
		}

		String defaultLanguageId = LocaleUtil.toLanguageId(LocaleUtil.getDefault());

		//

		if (_log.isDebugEnabled()) {
			_log.debug("guestLanguageId = " + guestLanguageId + ", defaultLanguageId = " + defaultLanguageId);
		}

		String userNotFirstLogin = CookieKeys.getCookie(request, USER_NOT_FIRST_LOGIN);

		if (!isLocRedirectEnabled && Validator.isNull(guestLanguageId)) {
			guestLanguageId = defaultLanguageId;
		} else if (isLocRedirectEnabled && (Validator.isNull(guestLanguageId) || Validator.isNull(userNotFirstLogin))) {

			String locationBasedLanguageId = getLocationBasedLanguageId(request, defaultLanguageId);
			CookieKeys.addCookie(request, response, new Cookie(USER_NOT_FIRST_LOGIN, "true"));

			if (Validator.isNull(locationBasedLanguageId)) {
				guestLanguageId = defaultLanguageId;
			} else {
				guestLanguageId = locationBasedLanguageId;
			}

			if (_log.isDebugEnabled()) {
				_log.debug("after location check guestLanguageId = " + guestLanguageId + ", defaultLanguageId = "
						+ defaultLanguageId);
			}
		}

		//

		if (prependFriendlyUrlStyle == 1) {
			if (!defaultLanguageId.equals(guestLanguageId)) {
				if (isLocRedirectEnabled) {
					LanguageUtil.updateCookie(request, response, LocaleUtil.fromLanguageId(guestLanguageId));
				}
				return guestLanguageId;
			} else {
				return null;
			}
		} else if (prependFriendlyUrlStyle == 2) {
			return LocaleUtil.toLanguageId(PortalUtil.getLocale(request));
		} else if (prependFriendlyUrlStyle == 3) {
			if (user != null) {
				HttpSession session = request.getSession();

				session.setAttribute(Globals.LOCALE_KEY, user.getLocale());
			}

			return null;
		}

		return null;
	}

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws Exception {

		request.setAttribute(SKIP_FILTER, Boolean.TRUE);

		//
		String redirect = null;

		if (Validator.isNull((String) request.getAttribute(SambaashConstants.PROFILE_WITH_SCREEN_NAME))) {
			redirect = getRedirect(request, response);
		}
		//

		if (redirect == null) {
			processFilter(I18nFilter.class, request, response, filterChain);

			return;
		}

		if (_log.isDebugEnabled()) {
			_log.debug("Redirect " + redirect);
		}

		response.sendRedirect(redirect);
	}

	//

	private String getLocationBasedLanguageId(HttpServletRequest request, String defaultLanguageId) {
		try {
			String country = retreiveCountry(request);
			if (Validator.isNotNull(country)) {
				String locale = PropsUtil.get("sp.geo.locale.custom.mapping." + country);
				if (Validator.isNotNull(locale)) {
					return locale;
				} else {
					return PropsUtil.get("sp.geo.locale.custom.mapping.default");
				}
			}
		} catch (Exception e) {
			_log.warn("Error while getting country based language, WILL RETURN DEFAULT = " + defaultLanguageId);
		}
		return defaultLanguageId;
	}

	private String retreiveCountry(HttpServletRequest httpRequest) {

		try {
			String ip = getClientIpAddr(httpRequest);
			String countryCode = SPIPGeoLocationLocalServiceUtil.findCountryISOByIpAddress(ip);

			if (_log.isDebugEnabled()) {
				_log.debug("From DATABASE For IP: " + ip + " country = " + countryCode);
			}

			if (Validator.isNotNull(countryCode))
				return countryCode;

			Integer userId = GetterUtil.getInteger(SambaashUtil.getParameter("geo-location-userId", 0), 109398);
			String apiKey = GetterUtil.getString(SambaashUtil.getParameter("geo-location-api-key", 0));
			if (Validator.isNull(apiKey)) {
				apiKey = "C78ztOYHe1Yz";
			}

			GeoIp2Provider provider = new WebServiceClient.Builder(userId, apiKey).build();
			CountryResponse country = provider.country(InetAddress.getByName(ip));

			if (_log.isDebugEnabled()) {
				_log.debug("From API For IP: " + ip + " country = " + country.getCountry().getIsoCode());
			}

			SPIPGeoLocationLocalServiceUtil.addSPIPGeoLocation(ip, country.getCountry().getIsoCode());

			return country.getCountry().getIsoCode();

		} catch (Exception e) {
			_log.error("Exception while retrieving country from External API " + e.getMessage());
		} catch (Error ee) {
			_log.error("Error while retrieving coutnry from External API " + ee.getMessage());
		}
		return null;
	}

	private static String getClientIpAddr(HttpServletRequest request) {
		String ip = request.getHeader("X-Forwarded-For");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_CLIENT_IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("HTTP_X_FORWARDED_FOR");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;
	}

	//

	private static Log _log = LogFactoryUtil.getLog(I18nFilter.class);

	private static Set<String> _languageIds;

	private static final String USER_NOT_FIRST_LOGIN = "USER_NOT_FIRST_LOGIN";

}