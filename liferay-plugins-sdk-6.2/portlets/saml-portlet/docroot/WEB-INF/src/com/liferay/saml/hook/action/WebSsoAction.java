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

import com.liferay.saml.profile.WebSsoProfileUtil;
import com.liferay.saml.util.SamlUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mika Koivisto
 */
public class WebSsoAction extends BaseSamlStrutsAction {


	public boolean isEnabled(long companyId, long groupId) {
		return SamlUtil.isEnabled(companyId, groupId) && SamlUtil.isRoleIdp(companyId);
	}


	protected String doExecute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		WebSsoProfileUtil.processAuthnRequest(request, response);

		return null;
	}

}