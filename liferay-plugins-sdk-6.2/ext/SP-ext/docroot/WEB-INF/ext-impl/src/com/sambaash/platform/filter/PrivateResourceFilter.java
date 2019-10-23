package com.sambaash.platform.filter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.liferay.portal.NoSuchLayoutException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.servlet.filters.BasePortalFilter;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portal.util.WebKeys;

public class PrivateResourceFilter extends BasePortalFilter  {

	@Override
	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {
		try {
			User u = PortalUtil.getUser(request);
			if ( u != null) {
				_log.error("Got Logged in User : "+u.getEmailAddress());				
			}
		} catch (Exception e) {
			_log.error("USER NOT FOUND", e);
		}
		if (getUserId(request) <= 0) {
			// not login, so not allowed
			_log.error("Must login to access : " + request.getRequestURI());

			PortalUtil.sendError(
				HttpServletResponse.SC_NOT_FOUND, new NoSuchLayoutException(),
				request, response);
		} else {
			filterChain.doFilter(request, response);
		}

	}

	public long getUserId(HttpServletRequest request) {
		Long userIdObj = (Long)request.getAttribute(WebKeys.USER_ID);

		if (userIdObj != null) {
			return userIdObj.longValue();
		}
		HttpSession session = request.getSession();

		userIdObj = (Long)session.getAttribute(WebKeys.USER_ID);

		if (userIdObj != null) {
			request.setAttribute(WebKeys.USER_ID, userIdObj);

			return userIdObj.longValue();
		}
		else {
			return 0;
		}
	}
	
	private static Log _log = LogFactoryUtil.getLog(PrivateResourceFilter.class);		
	
}
