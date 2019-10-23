package com.sambaash.platform.filter;

import com.liferay.portal.servlet.filters.BasePortalFilter;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
public class SPUploadFilter extends BasePortalFilter {

	@Override
	protected void processFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws Exception {
		HttpSession session = request.getSession();

		ServletContext _servletContext = session.getServletContext();

		RequestDispatcher requestDispatcher = _servletContext.getRequestDispatcher("/spupload");

		requestDispatcher.forward(request, response);
		return;

	}

}