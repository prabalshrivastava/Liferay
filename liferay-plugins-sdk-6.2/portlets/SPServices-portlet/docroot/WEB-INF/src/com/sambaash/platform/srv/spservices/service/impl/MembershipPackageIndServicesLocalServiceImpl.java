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
import com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices;
import com.sambaash.platform.srv.spservices.service.base.MembershipPackageIndServicesLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackageIndServicesUtil;

/**
 * The implementation of the membership package ind services local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.MembershipPackageIndServicesLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipPackageIndServicesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.MembershipPackageIndServicesLocalServiceUtil
 */
public class MembershipPackageIndServicesLocalServiceImpl extends
		MembershipPackageIndServicesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.MembershipPackageIndServicesLocalServiceUtil} to
	 * access the membership package ind services local service.
	 */

	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
			java.lang.String scId) throws SystemException {
		return MembershipPackageIndServicesUtil
				.findByMembershipPackageIndServicesScId(scId);
	}

	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesScId(
			java.lang.String scId, int start, int end) throws SystemException {
		return MembershipPackageIndServicesUtil
				.findByMembershipPackageIndServicesScId(scId, start, end);
	}

	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
			long mpId) throws SystemException {
		return membershipPackageIndServicesPersistence
				.findByMembershipPackageIndServicesMpId(mpId);
	}

	public List<MembershipPackageIndServices> findByMembershipPackageIndServicesMpId(
			long mpId, int start, int end) throws SystemException {
		return MembershipPackageIndServicesUtil
				.findByMembershipPackageIndServicesMpId(mpId, start, end);
	}

	public List<MembershipPackageIndServices> findByServiceNameMpId(long mpId,
			java.lang.String extra1) throws SystemException {
		return membershipPackageIndServicesPersistence.findByServiceNameMpId(
				mpId, extra1);
	}

}