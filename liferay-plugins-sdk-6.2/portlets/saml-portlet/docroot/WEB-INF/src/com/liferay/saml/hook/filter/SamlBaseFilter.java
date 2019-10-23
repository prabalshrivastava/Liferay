/**
 * 
 */
package com.liferay.saml.hook.filter;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.BaseFilter;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.util.SamlUtil;

import javax.servlet.http.HttpServletRequest;

/**
 * @author bill
 *
 */
public class SamlBaseFilter extends BaseFilter {
	
	@Override
	public boolean isFilterEnabled() {
		return true;
	}

	/* (non-Javadoc)
	 * @see com.liferay.portal.kernel.servlet.BaseFilter#getLog()
	 */
	@Override
	protected Log getLog() {
		return _log;
	}
	
	protected boolean isSamlEnabled(HttpServletRequest request) {
		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);
		
		return SamlUtil.isEnabled(companyId, groupId);
	}
	
	private final static Log _log = LogFactoryUtil.getLog(SamlBaseFilter.class);

}
