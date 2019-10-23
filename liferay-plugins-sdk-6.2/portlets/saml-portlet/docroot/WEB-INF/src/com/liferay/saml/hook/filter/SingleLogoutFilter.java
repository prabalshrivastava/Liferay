package com.liferay.saml.hook.filter;

import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.profile.SingleLogoutProfileUtil;
import com.liferay.saml.util.SamlUtil;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleLogoutFilter extends SamlBaseFilter {

	@Override
	public boolean isFilterEnabled(
		HttpServletRequest request, HttpServletResponse response) {
		
		return this.isSamlEnabled(request);
		
	}
	
	
	@Override
	protected void processFilter(
			HttpServletRequest request, HttpServletResponse response,
			FilterChain filterChain)
		throws Exception {
		
		long companyId = PortalUtil.getCompanyId(request);

		if (SamlUtil.isRoleIdp(companyId) && SamlUtil.isSingleLogoutServiceLogoutRequest(request)) {
			SingleLogoutProfileUtil.processIdpLogout(request, response);
		}
		else {
			SingleLogoutProfileUtil.processSingleLogout(request, response);
		}
	}
	
}
