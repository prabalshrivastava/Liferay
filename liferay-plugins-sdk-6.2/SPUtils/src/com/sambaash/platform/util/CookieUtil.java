package com.sambaash.platform.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CookieKeys;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Time;

public class CookieUtil extends CookieKeys {
	public static String get(HttpServletRequest request, String name) {
		Map<String, Cookie> cookieMap = _getCookieMap(request);

		Cookie cookie = cookieMap.get(name.toUpperCase());

		if (cookie == null) {
			return null;
		} else {
			return cookie.getValue();
		}
	}

	private static Map<String, Cookie> _getCookieMap(HttpServletRequest request) {

		@SuppressWarnings("unchecked")
		Map<String, Cookie> cookieMap = (Map<String, Cookie>) request.getAttribute(CookieUtil.class.getName());

		if (cookieMap != null) {
			return cookieMap;
		}

		Cookie[] cookies = request.getCookies();

		if (cookies == null) {
			cookieMap = Collections.emptyMap();
		} else {
			cookieMap = new HashMap<String, Cookie>(cookies.length * 4 / 3);

			for (Cookie cookie : cookies) {
				String cookieName = GetterUtil.getString(cookie.getName());

				cookieName = cookieName.toUpperCase();

				cookieMap.put(cookieName, cookie);
			}
		}

		request.setAttribute(CookieUtil.class.getName(), cookieMap);

		return cookieMap;
	}

	public static void addTrackingCookie(HttpServletRequest request, HttpServletResponse response, boolean secure,
			String trackingUserId) {
		Cookie tCookie = new Cookie("t_u_id", trackingUserId);
		addCookie(request, response, tCookie, secure);
	}

	public static void addCookie(HttpServletRequest request, HttpServletResponse response, Cookie cookie,
			boolean secure) {
		cookie.setSecure(secure);
		cookie.setVersion(VERSION);
		cookie.setHttpOnly(true);
		response.addCookie(cookie);
	}

	public static final int MAX_AGE = (int) Time.YEAR;

	public static final int VERSION = 0;

	private static Log _log = LogFactoryUtil.getLog(CookieUtil.class);
}
