/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.sambaash.platform.portlet.spneo4j.action;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.liferay.portal.kernel.events.Action;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.model.LayoutSet;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.model.spneo4j.form.UserGraphForm;
import com.sambaash.platform.srv.graph.service.SPNeoforjLocalServiceUtil;
import com.sambaash.platform.util.Neo4jHelper;
import com.sambaash.platform.util.SambaashUtil;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * @author Bruno Farache
 */
public class LoginPostAction extends Action {

	private static Log _log = LogFactoryUtil.getLog(LoginPostAction.class);
	
	@Override
	public void run(HttpServletRequest request, HttpServletResponse response) {
		
		//com.liferay.portal.util.WebKeys.VIRTUAL_HOST_LAYOUT_SET
		Object obj = request.getAttribute("VIRTUAL_HOST_LAYOUT_SET");
		
		LayoutSet layoutSet = (LayoutSet) obj;
		Long groupId = layoutSet.getGroupId();
		Long companyId = layoutSet.getCompanyId();
		Long layoutSetId = layoutSet.getLayoutSetId();

		try {
			User user = PortalUtil.getUser(request);
			if (SambaashUtil.isNeo4jEnabled()) {
				long userId = user.getUserId();
				String firstName = user.getFirstName();
				String lastName = user.getLastName();
				String screenName = user.getScreenName();
				long portraitId = user.getPortraitId();
				boolean emailAddressVerified = user.getEmailAddressVerified();
				int status = user.getStatus();
				Date modifiedDate = user.getModifiedDate();

				UserGraphForm userGraphForm = new UserGraphForm();
				userGraphForm.setUserId(userId);
				userGraphForm.setFirstName(firstName);
				userGraphForm.setLastName(lastName);
				userGraphForm.setScreenName(screenName);
				userGraphForm.setPortraitId(portraitId);
				userGraphForm.setEmailAddressVerified(emailAddressVerified);
				userGraphForm.setStatus(status);
				userGraphForm.setModifiedDate(modifiedDate);
				userGraphForm.setEmailAddress(user.getEmailAddress());

				userGraphForm.setCommunityName(PropsUtil.get(PropsKeys.VIRTUAL_HOSTS_DEFAULT_SITE_NAME));
				Neo4jHelper.fillMandatoryFields(userGraphForm, companyId, groupId, layoutSetId);
				
				SPNeoforjLocalServiceUtil.updateUserGraph(userGraphForm);
			}
		} catch (Exception e) {
			_log.error(e.getMessage());
		}
	}

}