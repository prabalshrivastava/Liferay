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

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.sambaash.platform.srv.spservices.model.MembershipPackage;
import com.sambaash.platform.srv.spservices.service.base.MembershipPackageLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackageUtil;

/**
 * The implementation of the membership package local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.MembershipPackageLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipPackageLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.MembershipPackageLocalServiceUtil
 */
public class MembershipPackageLocalServiceImpl extends
		MembershipPackageLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.MembershipPackageLocalServiceUtil} to access the
	 * membership package local service.
	 */

	public List<MembershipPackage> findByMembershipPackageName(
			java.lang.String name) throws SystemException {
		return MembershipPackageUtil.findByMembershipPackageName(name);
	}

	public List<MembershipPackage> findByMembershipPackageName(
			java.lang.String name, int start, int end) throws SystemException {
		return MembershipPackageUtil.findByMembershipPackageName(name, start,
				end);
	}

	public List<MembershipPackage> findByRoleId(java.lang.String extra1)
			throws SystemException {
		return MembershipPackageUtil.findByRoleId(extra1);
	}

	public List<MembershipPackage> findByRoleId(java.lang.String extra1,
			int start, int end) throws SystemException {
		return MembershipPackageUtil.findByRoleId(extra1, start, end);
	}

	public List<MembershipPackage> findByMembershipPackageType(
			java.lang.String type) throws SystemException {
		return MembershipPackageUtil.findByMembershipPackageType(type);
	}

	public List<MembershipPackage> findByMembershipPackageType(
			java.lang.String type, int start, int end) throws SystemException {
		return MembershipPackageUtil.findByMembershipPackageType(type, start,
				end);
	}

}