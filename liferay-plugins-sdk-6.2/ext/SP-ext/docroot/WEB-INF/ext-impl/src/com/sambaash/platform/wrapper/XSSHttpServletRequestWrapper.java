package com.sambaash.platform.wrapper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class XSSHttpServletRequestWrapper extends HttpServletRequestWrapper {

	private final String EVENTS = "((?i)onload|onunload|onchange|onsubmit|onreset"
			+ "|onselect|onblur|onfocus|onkeydown|onkeypress|onkeyup"
			+ "|onclick|ondblclick|onmousedown|onmousemove|onmouseout|onmouseover|onmouseup)";

	private final String XSS_HTML_TAG = "\\n\\r|(%3C)|(%3E)|[<>]+";

	private final String XSS_INJECTION = "(%22|’)(\\s|%20)\\w.*|(\\s|%20)" + EVENTS + ".*|(%3D)|(%7C)";

	private final String XSS_REGEX = XSS_HTML_TAG + "|" + XSS_INJECTION;

	private final String SQL_REGEX = "(‘.+–)|(–)|(\\|)|(%7C)";

	private static Log _log = LogFactoryUtil.getLog(XSSHttpServletRequestWrapper.class);

	public XSSHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
	}

	public String getParameter(String name) {
		String value = super.getParameter(name);
		_log.error("name : " + name + " : value : " + value);
		return cleanXSS(value);
	}

	public Map<String, String[]> getParameterMap() {
		Map<String, String[]> rawMap = super.getParameterMap();
		Map<String, String[]> filteredMap = new HashMap<String, String[]>(rawMap.size());
		Set<String> keys = rawMap.keySet();
		for (String key : keys) {
			String[] rawValue = rawMap.get(key);
			String[] filteredValue = filterStringArray(rawValue);
			filteredMap.put(key, filteredValue);
			
			_log.error("name1 : " + key + " : filteredValue1 : " + Arrays.toString(filteredValue));
			
		}
		return filteredMap;
	}

	protected String[] filterStringArray(String[] rawValue) {
		String[] filteredArray = new String[rawValue.length];
		for (int i = 0; i < rawValue.length; i++) {
			filteredArray[i] = cleanXSS(rawValue[i]);
		}
		return filteredArray;
	}

	public String[] getParameterValues(String name) {
		String[] rawValues = super.getParameterValues(name);
		if (rawValues == null)
			return null;
		String[] filteredValues = new String[rawValues.length];
		for (int i = 0; i < rawValues.length; i++) {
			filteredValues[i] = cleanXSS(rawValues[i]);
		}
		return filteredValues;
	}

	protected String cleanXSS(String rawValue) {
		if (rawValue == null) {
			return null;
		}
		rawValue = rawValue.replaceAll(XSS_REGEX, "").replaceAll(SQL_REGEX, "");

		// Avoud all events
		rawValue = rawValue.replaceAll(EVENTS, "");
		
		// Avoid anything between script tags
		Pattern scriptPattern = Pattern.compile("<@script>(.*?)</@script>", Pattern.CASE_INSENSITIVE);
		rawValue = scriptPattern.matcher(rawValue).replaceAll("");

		// Avoid iframe tags
		scriptPattern = Pattern.compile("<@iframe>(.*?)", Pattern.CASE_INSENSITIVE);
		rawValue = scriptPattern.matcher(rawValue).replaceAll("");

		// Avoid anything in a src=’…’ type of expression
		scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\'(.*?)\\\'", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
				| Pattern.DOTALL);
		rawValue = scriptPattern.matcher(rawValue).replaceAll("");

		scriptPattern = Pattern.compile("src[\r\n]*=[\r\n]*\\\"(.*?)\\\"", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
				| Pattern.DOTALL);
		rawValue = scriptPattern.matcher(rawValue).replaceAll("");

		// Avoid expression(…) expressions
		scriptPattern = Pattern.compile("expression\\((.*?)\\)", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE
				| Pattern.DOTALL);
		rawValue = scriptPattern.matcher(rawValue).replaceAll("");

		// Avoid javascript:… expressions
		scriptPattern = Pattern.compile("javascript:", Pattern.CASE_INSENSITIVE);
		rawValue = scriptPattern.matcher(rawValue).replaceAll("");
		
		// Avoid onload= expressions
		scriptPattern = Pattern.compile("onload(.*?)=", Pattern.CASE_INSENSITIVE | Pattern.MULTILINE | Pattern.DOTALL);
		rawValue = scriptPattern.matcher(rawValue).replaceAll("");

		
		return rawValue;
	}
}
