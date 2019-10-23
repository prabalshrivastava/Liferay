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

package com.sambaash.platform.srv.spservices.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Role;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.sambaash.platform.srv.spservices.model.MembershipPackageServicesRoles;
import com.sambaash.platform.srv.spservices.service.MembershipPackageServicesRolesLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.base.MembershipPackageServicesRolesLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackageServicesRolesUtil;

/**
 * The implementation of the membership package services roles local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.MembershipPackageServicesRolesLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipPackageServicesRolesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.MembershipPackageServicesRolesLocalServiceUtil
 */
public class MembershipPackageServicesRolesLocalServiceImpl extends
		MembershipPackageServicesRolesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.MembershipPackageServicesRolesLocalServiceUtil}
	 * to access the membership package services roles local service.
	 */

	public List<MembershipPackageServicesRoles> findBygetMembershipPackageServiceRoles(
			long mpId, long classNameId, long serviceId) throws SystemException {
		return MembershipPackageServicesRolesUtil.findBympIdClassNameIdSvcId(
				mpId, classNameId, serviceId);
	}

	public List<MembershipPackageServicesRoles> findByMembershipPackage(
			long mpId) throws SystemException {
		return MembershipPackageServicesRolesUtil.findBympId(mpId);
	}

	public List<MembershipPackageServicesRoles> findByMembershipPackageId(
			long mpId) throws SystemException {
		return membershipPackageServicesRolesPersistence.findBympId(mpId);
	}

	public List<MembershipPackageServicesRoles> findByMembershipPackageRole(
			long mpId, long roleId) throws SystemException {
		return membershipPackageServicesRolesPersistence
				.findByMembershipPackageAndRole(mpId, roleId);
	}

	public List<MembershipPackageServicesRoles> findByRoleId(long roleId)
			throws SystemException {
		return membershipPackageServicesRolesPersistence.findByRoleId(roleId);
	}

	public List<MembershipPackageServicesRoles> findByServiceId(long serviceId)
			throws SystemException {
		return membershipPackageServicesRolesPersistence
				.findByServiceId(serviceId);
	}

	public List<MembershipPackageServicesRoles> findByServiceNameMpId(
			long mpId, java.lang.String extra1) throws SystemException {
		return membershipPackageServicesRolesPersistence.findByServiceNameMpId(
				mpId, extra1);
	}

	public List<Role> getUserMembershipRoles(long userId)
			throws SystemException {

		long mpId = 0;
		MembershipPackageServicesRoles mpServiceRoles = null;
		Role roles = null;
		List<Role> roleList = new ArrayList<Role>();
		long roleId = 0;
		List<MembershipPackageServicesRoles> mpgList = MembershipPackageServicesRolesLocalServiceUtil
				.findByMembershipPackageId(mpId);
		Iterator<MembershipPackageServicesRoles> mpgItr = mpgList.iterator();

		while (mpgItr.hasNext()) {
			mpServiceRoles = mpgItr.next();
			roleId = mpServiceRoles.getRoleId();
			try {
				roles = RoleLocalServiceUtil.getRole(roleId);
			} catch (Exception e) {
			}
			if (roles != null) {
				if (!roleList.contains(roles)) {
					roleList.add(roles);
				}
			}
		}
		return roleList;
	}

}