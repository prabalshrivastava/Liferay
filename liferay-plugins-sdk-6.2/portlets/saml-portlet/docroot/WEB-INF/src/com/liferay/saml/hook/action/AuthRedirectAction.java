/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.liferay.saml.hook.action;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.util.SamlUtil;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Tomas Polesovsky
 */
public class AuthRedirectAction extends BaseSamlStrutsAction {


	public boolean isEnabled(long companyId, long groupId) {
		if (_log.isDebugEnabled()) {
			Boolean enabled = SamlUtil.isEnabled(companyId, groupId) && SamlUtil.isRoleSp(companyId);
			_log.debug(String.format("isEnabled = %s", enabled));
			return enabled;
		}
		return SamlUtil.isEnabled(companyId, groupId) && SamlUtil.isRoleSp(companyId);
	}


	protected String doExecute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		String redirect = ParamUtil.getString(request, "redirect");
		_log.debug(String.format("doExecute: redirect = %s", redirect));
		
//		redirect = PortalUtil.escapeRedirect(redirect);
//		_log.debug(String.format("doExecute: redirect = %s", redirect));

		if (Validator.isNull(redirect)) {
			redirect = PortalUtil.getHomeURL(request);
			_log.debug(String.format("doExecute: redirect = %s", redirect));
		}

		try {
			response.sendRedirect(redirect);
		}
		catch (IOException ioe) {
			throw new SystemException(ioe);
		}

		return null;
	}
	
	private final static Log _log = LogFactoryUtil.getLog(AuthRedirectAction.class);

}