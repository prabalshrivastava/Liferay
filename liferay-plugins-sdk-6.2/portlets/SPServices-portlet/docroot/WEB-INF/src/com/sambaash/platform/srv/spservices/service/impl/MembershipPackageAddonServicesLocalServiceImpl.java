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
import com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices;
import com.sambaash.platform.srv.spservices.service.base.MembershipPackageAddonServicesLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackageAddonServicesUtil;

/**
 * The implementation of the membership package addon services local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.MembershipPackageAddonServicesLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipPackageAddonServicesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.MembershipPackageAddonServicesLocalServiceUtil
 */
public class MembershipPackageAddonServicesLocalServiceImpl extends
		MembershipPackageAddonServicesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.MembershipPackageAddonServicesLocalServiceUtil}
	 * to access the membership package addon services local service.
	 */

	public List<MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
			java.lang.String scId) throws SystemException {
		return MembershipPackageAddonServicesUtil
				.findByMembershipPackageAddonServicesScId(scId);
	}

	public List<MembershipPackageAddonServices> findByMembershipPackageAddonServicesScId(
			java.lang.String scId, int start, int end) throws SystemException {
		return MembershipPackageAddonServicesUtil
				.findByMembershipPackageAddonServicesScId(scId, start, end);
	}

	public List<MembershipPackageAddonServices> findByServiceNameMpId(
			java.lang.String extra1, java.lang.String scName)
			throws SystemException {
		return membershipPackageAddonServicesPersistence.findByServiceNameMpId(
				extra1, scName);
	}

}