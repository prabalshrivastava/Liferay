/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.portal.action;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.UserServiceUtil;

import com.liferay.portal.struts.ActionConstants;
import com.liferay.portal.util.PortalUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import com.sambaash.platform.srv.spservices.model.SPUserType;
import com.sambaash.platform.srv.spservices.service.SPUserTypeLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 */
public class UpdateTermsOfUseAction extends Action {

	@Override
	public ActionForward execute(
			ActionMapping actionMapping, ActionForm actionForm,
			HttpServletRequest request, HttpServletResponse response)
		throws Exception {
		long userId = PortalUtil.getUserId(request);
		if(Validator.isNotNull(request.getParameter("userTypeIdfwd")) && Validator.isNotNull(request.getParameter("siteIdfwd"))) {
			long usertId = Long.parseLong((String)request.getParameter("userTypeIdfwd"));
			long siteId = Long.parseLong((String)request.getParameter("siteIdfwd"));
			SPUserType userType = SPUserTypeLocalServiceUtil.findBySpSiteIdAndUserIdAndUserTypeId(siteId,userId,usertId);
			userType.setDeclarationCompleted(true);
			SPUserTypeLocalServiceUtil.updateSPUserType(userType);
		}
		else{
			UserServiceUtil.updateAgreedToTermsOfUse(userId, true);
 		}

		return actionMapping.findForward(ActionConstants.COMMON_REFERER_JSP);
	}

}