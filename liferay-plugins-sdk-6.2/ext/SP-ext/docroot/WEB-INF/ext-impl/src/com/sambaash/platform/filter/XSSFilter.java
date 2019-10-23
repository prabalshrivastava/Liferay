package com.sambaash.platform.filter;

import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringEscapeUtils;

import com.sambaash.platform.constant.SambaashConstants;
import com.sambaash.platform.util.SambaashUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.servlet.filters.BasePortalFilter;

public class XSSFilter extends BasePortalFilter {
	private static final String EVENTS = "((?i)onload|onunload|onchange|onsubmit|onreset"
			+ "|onselect|onblur|onfocus|onkeydown|onkeypress|onkeyup"
			+ "|onclick|ondblclick|onmousedown|onmousemove|onmouseout|onmouseover|onmouseup"
			+ "|prompt%28|javascript%3A|%3Cscript%3E|%3Cstyle%3E|eval%28(.*)%29|alert%28(.*)%29|%28|%29|%A0|%9D|%90|%8F|%8D|%7F|%81|%0A|%0B|%0D|confirm%28(.*)%29"
			+ "|onafterprint|onbeforeprint|onbeforeunload|onerror|onhashchange|onmessage|onoffline|ononline|onpagehide|onpageshow|onpopstate|onresize|onstorage"
			+ "|oncontextmenu|onfocus|oninput|oninvalid|onreset|onsearch|onselect|onsubmit|ondrag|ondragend|ondragenter|ondragleave|ondragover|ondragstart|ondrop"
			+ "|onmousewheel|onscroll|onwheel|oncopy|oncut|onpaste|onabort|oncanplay|oncanplaythrough|oncuechange|ondurationchange|onemptied|onended|onerror|onloadeddata"
			+ "|onloadedmetadata|onloadstart|onpause|onplay|onplaying|onprogress|onratechange|onseeked|onseeking|onstalled|onsuspend|ontimeupdate|onvolumechange|onwaiting"
			+ "|onerror|onshow|ontoggle|encodeURI|decodeURI|escape|unescape|%2Fscript|vbscript%3A|u0028|u0029|u003C|u003E|u0027|u0022|\\(|\\))";

	// ( ) < > ' "
	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws Exception {

		String queryString = request.getQueryString();
		boolean admin = isAdminUser(request);

		if (_log.isDebugEnabled()) {
			_log.debug("admin : " + admin);
		}

		if (Validator.isNotNull(queryString) && !admin) {
			String encodedString = urlEncodeUTF8(request.getParameterMap());

			if (_log.isDebugEnabled()) {
				_log.debug("queryString : " + queryString);
				_log.debug("encodedString : " + encodedString);
			}

			if (Validator.isNotNull(encodedString) && encodedString.matches("(.*)" + EVENTS + "(.*)")) {
				encodedString = encodedString.replaceAll(EVENTS, "");
				encodedString = encodedString.replaceAll("%27[^a-z^A-Z]*%27", "");
				encodedString = encodedString.replaceAll("%3C%3E", "");
				String url = request.getScheme()
						+ "://"
						+ request.getServerName()
						+ ("http".equals(request.getScheme()) && request.getServerPort() == 80
								|| "https".equals(request.getScheme()) && request.getServerPort() == 443 ? "" : ":"
								+ request.getServerPort()) + request.getRequestURI() + "?" + encodedString;
				_log.error(" filteredString -->> " + encodedString);
				response.sendRedirect(url);
			}
		}

		super.processFilter(XSSFilter.class, request, response, filterChain);
	}

	private boolean isAdminUser(HttpServletRequest request) {
		HttpSession session = request.getSession();
		if (Validator.isNull(session))
			return false;
		Object userId = session.getAttribute(WebKeys.USER_ID);
		if (Validator.isNull(userId))
			return false;
		try {
			if (SambaashUtil.isAdmin(Integer.parseInt(SambaashConstants.DEFAULT_GROUP_ID), GetterUtil.getLong(userId)))
				return true;
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	private String urlEncodeUTF8(Map<String, String[]> map) throws Exception {
		StringBuilder sb = new StringBuilder();
		for (Map.Entry<String, String[]> entry : map.entrySet()) {
			String[] arr = entry.getValue();
			for (int i = 0; i < arr.length; i++) {
				sb.append(String.format("%s=%s",
						URLEncoder.encode(StringEscapeUtils.unescapeJava(entry.getKey()), "UTF-8"),
						URLEncoder.encode(StringEscapeUtils.unescapeJava(arr[i]), "UTF-8")));
			}
			sb.append("&");
		}
		return sb.toString().substring(0, sb.length() - 1);
	}

	private static Log _log = LogFactoryUtil.getLog(XSSFilter.class);

}
