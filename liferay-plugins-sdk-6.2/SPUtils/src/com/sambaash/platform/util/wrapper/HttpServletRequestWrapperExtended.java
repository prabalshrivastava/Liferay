package com.sambaash.platform.util.wrapper;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.liferay.portal.kernel.util.Validator;

public class HttpServletRequestWrapperExtended extends
		HttpServletRequestWrapper {

	Map<String, String> extendedMap;

	public HttpServletRequestWrapperExtended(HttpServletRequest request) {
		super(request);
	}

	public HttpServletRequestWrapperExtended(HttpServletRequest request,
			Map<String, String> extendedMap) {
		this(request);
		this.extendedMap = extendedMap;
	}

	public String getParameter(String name) {
		if (name.equals("p_auth")) {
			String value = super.getRequest().getParameter("sp_p_auth");
			// For multipart request
			if (Validator.isNull(value) && Validator.isNotNull(extendedMap)) {
				value = extendedMap.get("sp_p_auth");
			}
			return value;
		}

		return super.getParameter(name);
	}
}