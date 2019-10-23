package com.liferay.saml.hook.filter;

import com.liferay.portal.kernel.util.ParamUtil;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class StatusFilter extends SamlBaseFilter {

	@Override
	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {
		
		if (ParamUtil.getBoolean(request, "samlError", false)) {
			StringBuffer sb = new StringBuffer(2);
			sb.append(SAML_ERROR);
			sb.append(ParamUtil.getString(request, "exception"));
			response.sendRedirect(sb.toString());
			
		}
		else
			filterChain.doFilter(request, response);
	}

	private final static String SAML_ERROR = "/saml-portlet/status/view.jsp?status=500&exception=";
}
