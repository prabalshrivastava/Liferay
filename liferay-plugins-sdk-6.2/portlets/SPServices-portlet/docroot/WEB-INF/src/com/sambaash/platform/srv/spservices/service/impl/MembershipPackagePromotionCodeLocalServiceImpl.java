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
import com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode;
import com.sambaash.platform.srv.spservices.service.base.MembershipPackagePromotionCodeLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipPackagePromotionCodeUtil;

/**
 * The implementation of the membership package promotion code local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.MembershipPackagePromotionCodeLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipPackagePromotionCodeLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.MembershipPackagePromotionCodeLocalServiceUtil
 */
public class MembershipPackagePromotionCodeLocalServiceImpl extends
		MembershipPackagePromotionCodeLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.MembershipPackagePromotionCodeLocalServiceUtil}
	 * to access the membership package promotion code local service.
	 */

	public List<MembershipPackagePromotionCode> findBymembershipPackage_Id(
			long membershipPackage_id) throws SystemException {
		return MembershipPackagePromotionCodeUtil
				.findBymembershipPackage_Id(membershipPackage_id);
	}

	public List<MembershipPackagePromotionCode> findBymembershipPackage_Id(
			long membershipPackage_id, int start, int end)
			throws SystemException {
		return MembershipPackagePromotionCodeUtil.findBymembershipPackage_Id(
				membershipPackage_id, start, end);
	}

	public List<MembershipPackagePromotionCode> findBypromotionCode(
			java.lang.String promotionCode) throws SystemException {
		return MembershipPackagePromotionCodeUtil
				.findBypromotionCode(promotionCode);
	}

	public List<MembershipPackagePromotionCode> findBypromotionCode(
			java.lang.String promotionCode, int start, int end)
			throws SystemException {
		return MembershipPackagePromotionCodeUtil.findBypromotionCode(
				promotionCode, start, end);
	}

}