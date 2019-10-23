/**
 * 
 */
package com.liferay.saml.hook.filter;

import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.profile.WebSsoProfileUtil;
import com.liferay.saml.util.SamlUtil;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author W. Berks
 *
 */
public class AssertionConsumerServiceFilter extends SamlBaseFilter {

	@Override
	public boolean isFilterEnabled(
			HttpServletRequest request, HttpServletResponse response) {

		if (this.isSamlEnabled(request))
			return SamlUtil.isAssertionConsumerServiceRequest(request);
		else
			return false;
	}
	
	@Override
	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {
		
		if (SamlUtil.isAssertionConsumerServiceRequest(request))
			try {
				WebSsoProfileUtil.processResponse(request, response);
			} catch (Exception e) {
				if (SamlUtil.isDebugEnabled(
						PortalUtil.getCompanyId(request), 
						SamlUtil.getGroupId(request))) {
					
					SamlUtil.sendError(500, e, request, response);
//					
//					request.getSession().setAttribute("LOGIN_ERROR", e);
//					RequestDispatcher requestDispatcher = request.getRequestDispatcher(PortalUtil.getPortalURL(request) + LOGIN_DEBUG);
//					requestDispatcher.forward(request, response);
//					
//					response.sendRedirect(PortalUtil.getPortalURL(request) + LOGIN_DEBUG);
				}
			}
		else
			filterChain.doFilter(request, response);
	}
	
	private final static String LOGIN_DEBUG = "/saml-portlet/debug/error.jsp";
	
}
