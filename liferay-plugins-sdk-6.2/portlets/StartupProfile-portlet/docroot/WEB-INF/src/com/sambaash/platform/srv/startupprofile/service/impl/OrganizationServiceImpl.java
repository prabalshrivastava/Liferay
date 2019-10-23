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

package com.sambaash.platform.srv.startupprofile.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.sambaash.platform.srv.startupprofile.service.base.OrganizationServiceBaseImpl;

/**
 * The implementation of the organization remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.startupprofile.service.OrganizationService}
 * interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have
 * security checks based on the propagated JAAS credentials because this service
 * can be accessed remotely.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.base.OrganizationServiceBaseImpl
 * @see com.sambaash.platform.srv.startupprofile.service.OrganizationServiceUtil
 */
public class OrganizationServiceImpl extends OrganizationServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform.srv.startupprofile.service.OrganizationServiceUtil}
	 * to access the organization remote service.
	 */

	//
	public List<User> getUsersByRole(String roleName) {
		List<User> users = new ArrayList<User>();
		try {
			Role role = RoleLocalServiceUtil.getRole(
					PortalUtil.getDefaultCompanyId(), roleName);
			users = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
		} catch (Exception e) {

		}
		return users;
	}
}