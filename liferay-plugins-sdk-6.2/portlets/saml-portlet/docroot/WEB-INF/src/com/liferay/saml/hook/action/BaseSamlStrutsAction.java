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

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.struts.BaseStrutsAction;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.saml.util.JspUtil;
import com.liferay.saml.util.SamlUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Mika Koivisto
 */
public abstract class BaseSamlStrutsAction extends BaseStrutsAction {


	public String execute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		long companyId = PortalUtil.getCompanyId(request);
		long groupId = SamlUtil.getGroupId(request);
		if (_log.isTraceEnabled()) {
			String path = SamlUtil.getRequestPath(request);
			_log.trace(path + "?groupId=" + groupId);
		}
		
		if (SamlUtil.isRoleSp(companyId) && !isEnabled(companyId, groupId)) {
			return "/common/referer_js.jsp";
		}

		try {
			return doExecute(request, response);
		}
		catch (Exception e) {
			_log.error(e, e);

			SessionErrors.add(request, e.getClass().getName());

			JspUtil.dispatch(
				request, response, JspUtil.PATH_PORTAL_SAML_ERROR, "status", e.getMessage());
		}

		return null;
	}

	public boolean isEnabled(long companyId, long groupId) {
		return SamlUtil.isEnabled(companyId, groupId);
	}

	protected abstract String doExecute(
			HttpServletRequest request, HttpServletResponse response)
		throws Exception;

	private static Log _log = LogFactoryUtil.getLog(BaseSamlStrutsAction.class);

}