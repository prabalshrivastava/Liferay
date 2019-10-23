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

package com.liferay.saml.hook.events;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.profile.SingleLogoutProfileUtil;
import com.liferay.saml.util.SamlUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mika Koivisto
 * @deprecated
 */
public class SingleLogoutAction extends Action {


	public void run(HttpServletRequest request, HttpServletResponse response) {
		
		_log.error("!!!!!! events.SingleLogoutAction.run()");
		
		try {
			long companyId = PortalUtil.getCompanyId(request);
			long groupId = PortalUtil.getScopeGroupId(request);
	
			if (!SamlUtil.isEnabled(companyId, groupId) || !SamlUtil.isRoleIdp(companyId)) {
				return;
			}

			SingleLogoutProfileUtil.processIdpLogout(request, response);
		}
		catch (Exception e) {
			_log.warn("Unable to perform single logout", e);
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SingleLogoutAction.class);

}