package com.sambaash.platform.filter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.util.PortalUtil;

public class ComplaintFilter extends BasePortalFilter {
	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws Exception {

		HttpSession session = request.getSession();

		ServletContext _servletContext = session.getServletContext();

		RequestDispatcher requestDispatcher = _servletContext.getRequestDispatcher(PortalUtil.getCurrentURL(request));
		requestDispatcher.forward(request, response);

	}

}