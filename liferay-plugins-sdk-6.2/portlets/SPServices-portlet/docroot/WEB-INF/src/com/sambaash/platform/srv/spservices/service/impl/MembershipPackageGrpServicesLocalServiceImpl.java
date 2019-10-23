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
import com.sambaash.platform.srv.spservices.model.MembershipPackageGrpServices;
import com.sambaash.platform.srv.spservices.service.base.MembershipPackageGrpServicesLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackageGrpServicesUtil;

/**
 * The implementation of the membership package grp services local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.MembershipPackageGrpServicesLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipPackageGrpServicesLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.MembershipPackageGrpServicesLocalServiceUtil
 */
public class MembershipPackageGrpServicesLocalServiceImpl extends
		MembershipPackageGrpServicesLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.MembershipPackageGrpServicesLocalServiceUtil} to
	 * access the membership package grp services local service.
	 */

	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
			java.lang.String scgId) throws SystemException {
		return MembershipPackageGrpServicesUtil
				.findByMembershipPackageGrpServicesScgId(scgId);
	}

	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScgId(
			java.lang.String scgId, int start, int end) throws SystemException {
		return MembershipPackageGrpServicesUtil
				.findByMembershipPackageGrpServicesScgId(scgId, start, end);
	}

	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
			java.lang.String scId) throws SystemException {
		return MembershipPackageGrpServicesUtil
				.findByMembershipPackageGrpServicesScId(scId);
	}

	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesScId(
			java.lang.String scId, int start, int end) throws SystemException {
		return MembershipPackageGrpServicesUtil
				.findByMembershipPackageGrpServicesScId(scId, start, end);
	}

	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
			long mpId) throws SystemException {
		return membershipPackageGrpServicesPersistence
				.findByMembershipPackageGrpServicesMpId(mpId);
	}

	public List<MembershipPackageGrpServices> findByMembershipPackageGrpServicesMpId(
			long mpId, int start, int end) throws SystemException {
		return MembershipPackageGrpServicesUtil
				.findByMembershipPackageGrpServicesMpId(mpId, start, end);
	}

	public List<MembershipPackageGrpServices> findByServiceNameMpId(long mpId,
			java.lang.String extra2) throws SystemException {
		return membershipPackageGrpServicesPersistence.findByServiceNameMpId(
				mpId, extra2);
	}

}