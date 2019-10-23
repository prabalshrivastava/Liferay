package com.sambaash.platform.filter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.wrapper.XSSHttpServletRequestWrapper;

public class ProfileImageFilter extends BasePortalFilter {

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws Exception {

		XSSHttpServletRequestWrapper requestWrapper = new XSSHttpServletRequestWrapper(PortalUtil.getOriginalServletRequest(request));
		filterChain.doFilter(requestWrapper, response);
	}

	private static Log _log = LogFactoryUtil.getLog(ProfileImageFilter.class);

}
