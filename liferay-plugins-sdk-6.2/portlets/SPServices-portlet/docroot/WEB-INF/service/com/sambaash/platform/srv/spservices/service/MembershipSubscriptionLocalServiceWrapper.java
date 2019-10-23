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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MembershipSubscriptionLocalService}.
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionLocalService
 * @generated
 */
public class MembershipSubscriptionLocalServiceWrapper
	implements MembershipSubscriptionLocalService,
		ServiceWrapper<MembershipSubscriptionLocalService> {
	public MembershipSubscriptionLocalServiceWrapper(
		MembershipSubscriptionLocalService membershipSubscriptionLocalService) {
		_membershipSubscriptionLocalService = membershipSubscriptionLocalService;
	}

	/**
	* Adds the membership subscription to the database. Also notifies the appropriate model listeners.
	*
	* @param membershipSubscription the membership subscription
	* @return the membership subscription that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription addMembershipSubscription(
		com.sambaash.platform.srv.spservices.model.MembershipSubscription membershipSubscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.addMembershipSubscription(membershipSubscription);
	}

	/**
	* Creates a new membership subscription with the primary key. Does not add the membership subscription to the database.
	*
	* @param msId the primary key for the new membership subscription
	* @return the new membership subscription
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription createMembershipSubscription(
		long msId) {
		return _membershipSubscriptionLocalService.createMembershipSubscription(msId);
	}

	/**
	* Deletes the membership subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param msId the primary key of the membership subscription
	* @return the membership subscription that was removed
	* @throws PortalException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription deleteMembershipSubscription(
		long msId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.deleteMembershipSubscription(msId);
	}

	/**
	* Deletes the membership subscription from the database. Also notifies the appropriate model listeners.
	*
	* @param membershipSubscription the membership subscription
	* @return the membership subscription that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription deleteMembershipSubscription(
		com.sambaash.platform.srv.spservices.model.MembershipSubscription membershipSubscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.deleteMembershipSubscription(membershipSubscription);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _membershipSubscriptionLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchMembershipSubscription(
		long msId) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.fetchMembershipSubscription(msId);
	}

	/**
	* Returns the membership subscription with the primary key.
	*
	* @param msId the primary key of the membership subscription
	* @return the membership subscription
	* @throws PortalException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription getMembershipSubscription(
		long msId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.getMembershipSubscription(msId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the membership subscriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> getMembershipSubscriptions(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.getMembershipSubscriptions(start,
			end);
	}

	/**
	* Returns the number of membership subscriptions.
	*
	* @return the number of membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMembershipSubscriptionsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.getMembershipSubscriptionsCount();
	}

	/**
	* Updates the membership subscription in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param membershipSubscription the membership subscription
	* @return the membership subscription that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription updateMembershipSubscription(
		com.sambaash.platform.srv.spservices.model.MembershipSubscription membershipSubscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.updateMembershipSubscription(membershipSubscription);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _membershipSubscriptionLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_membershipSubscriptionLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _membershipSubscriptionLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionName(name);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionName(name,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionGroupId(groupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionGroupId(groupId,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionUserId(userId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionUserId(userId,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionMpId_1(mpId_1);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionMpId_1(mpId_1,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionSessionId(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionSessionId(userName);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionSessionId(
		java.lang.String userName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionSessionId(userName,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
			nettotal);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
			nettotal, start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress,
			start, end);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _membershipSubscriptionLocalService.findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
			shippingEmailAddress, nettotal);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MembershipSubscriptionLocalService getWrappedMembershipSubscriptionLocalService() {
		return _membershipSubscriptionLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMembershipSubscriptionLocalService(
		MembershipSubscriptionLocalService membershipSubscriptionLocalService) {
		_membershipSubscriptionLocalService = membershipSubscriptionLocalService;
	}

	@Override
	public MembershipSubscriptionLocalService getWrappedService() {
		return _membershipSubscriptionLocalService;
	}

	@Override
	public void setWrappedService(
		MembershipSubscriptionLocalService membershipSubscriptionLocalService) {
		_membershipSubscriptionLocalService = membershipSubscriptionLocalService;
	}

	private MembershipSubscriptionLocalService _membershipSubscriptionLocalService;
}