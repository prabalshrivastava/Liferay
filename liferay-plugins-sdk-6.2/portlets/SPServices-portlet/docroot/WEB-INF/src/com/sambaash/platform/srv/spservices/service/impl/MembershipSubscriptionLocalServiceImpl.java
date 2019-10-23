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
import com.sambaash.platform.srv.spservices.model.MembershipSubscription;
import com.sambaash.platform.srv.spservices.service.base.MembershipSubscriptionLocalServiceBaseImpl;
import com.sambaash.platform.srv.spservices.service.persistence.MembershipSubscriptionUtil;

/**
 * The implementation of the membership subscription local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link com.sambaash.platform.srv.spservices.service.MembershipSubscriptionLocalService}
 * interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.base.MembershipSubscriptionLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spservices.service.MembershipSubscriptionLocalServiceUtil
 */
public class MembershipSubscriptionLocalServiceImpl extends
		MembershipSubscriptionLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * com.sambaash.platform
	 * .srv.spservices.service.MembershipSubscriptionLocalServiceUtil} to access
	 * the membership subscription local service.
	 */

	public List<MembershipSubscription> findByMembershipSubscriptionName(
			String name) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionName(name);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionName(
			String name, int start, int end) throws SystemException {
		return MembershipSubscriptionUtil.findByMembershipSubscriptionName(
				name, start, end);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionGroupId(
			long groupId) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionGroupId(groupId);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionGroupId(
			long groupId, int start, int end) throws SystemException {
		return MembershipSubscriptionUtil.findByMembershipSubscriptionGroupId(
				groupId, start, end);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionUserId(
			long userId) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionUserId(userId);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionUserId(
			long userId, int start, int end) throws SystemException {
		return MembershipSubscriptionUtil.findByMembershipSubscriptionUserId(
				userId, start, end);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionMpId_1(
			String mpId_1) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionMpId_1(mpId_1);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionMpId_1(
			String mpId_1, int start, int end) throws SystemException {
		return MembershipSubscriptionUtil.findByMembershipSubscriptionMpId_1(
				mpId_1, start, end);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionSessionId(
			String userName) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionSessionId(userName);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionSessionId(
			String userName, int start, int end) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionSessionId(userName, start, end);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
			String ppPaymentStatus) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
			String ppPaymentStatus, int start, int end) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus,
						start, end);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
			String shippingEmailAddress, float nettotal) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionShippingEmailAddressAndNettotal(
						shippingEmailAddress, nettotal);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
			String shippingEmailAddress, float nettotal, int start, int end)
			throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionShippingEmailAddressAndNettotal(
						shippingEmailAddress, nettotal, start, end);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
			String shippingEmailAddress) throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
			String shippingEmailAddress, int start, int end)
			throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionShippingEmailAddress(
						shippingEmailAddress, start, end);
	}

	public List<MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
			String ppPaymentStatus, String shippingEmailAddress, float nettotal)
			throws SystemException {
		return MembershipSubscriptionUtil
				.findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
						ppPaymentStatus, shippingEmailAddress, nettotal);
	}

}