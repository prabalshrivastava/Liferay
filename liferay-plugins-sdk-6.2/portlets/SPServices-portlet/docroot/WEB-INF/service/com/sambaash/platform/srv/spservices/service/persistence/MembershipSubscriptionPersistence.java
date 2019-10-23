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

package com.sambaash.platform.srv.spservices.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spservices.model.MembershipSubscription;

/**
 * The persistence interface for the membership subscription service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionPersistenceImpl
 * @see MembershipSubscriptionUtil
 * @generated
 */
public interface MembershipSubscriptionPersistence extends BasePersistence<MembershipSubscription> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MembershipSubscriptionUtil} to access the membership subscription persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the membership subscriptions where name = &#63;.
	*
	* @param name the name
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscriptions where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions where name = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the first membership subscription in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the last membership subscription in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscriptions before and after the current membership subscription in the ordered set where name = &#63;.
	*
	* @param msId the primary key of the current membership subscription
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionName_PrevAndNext(
		long msId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Removes all the membership subscriptions where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions where name = &#63;.
	*
	* @param name the name
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscriptions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscriptions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the first membership subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the last membership subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscriptions before and after the current membership subscription in the ordered set where groupId = &#63;.
	*
	* @param msId the primary key of the current membership subscription
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionGroupId_PrevAndNext(
		long msId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Removes all the membership subscriptions where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscriptions where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscriptions where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the first membership subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the last membership subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscriptions before and after the current membership subscription in the ordered set where userId = &#63;.
	*
	* @param msId the primary key of the current membership subscription
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionUserId_PrevAndNext(
		long msId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Removes all the membership subscriptions where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscriptions where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscriptions where mpId_1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId_1 the mp id_1
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions where mpId_1 = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param mpId_1 the mp id_1
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription in the ordered set where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionMpId_1_First(
		java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the first membership subscription in the ordered set where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionMpId_1_First(
		java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription in the ordered set where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionMpId_1_Last(
		java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the last membership subscription in the ordered set where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionMpId_1_Last(
		java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscriptions before and after the current membership subscription in the ordered set where mpId_1 = &#63;.
	*
	* @param msId the primary key of the current membership subscription
	* @param mpId_1 the mp id_1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionMpId_1_PrevAndNext(
		long msId, java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Removes all the membership subscriptions where mpId_1 = &#63; from the database.
	*
	* @param mpId_1 the mp id_1
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionMpId_1(java.lang.String mpId_1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionMpId_1(java.lang.String mpId_1)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscriptions where userName = &#63;.
	*
	* @param userName the user name
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionSessionId(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscriptions where userName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionSessionId(
		java.lang.String userName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions where userName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userName the user name
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionSessionId(
		java.lang.String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionSessionId_First(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the first membership subscription in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionSessionId_First(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionSessionId_Last(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the last membership subscription in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionSessionId_Last(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscriptions before and after the current membership subscription in the ordered set where userName = &#63;.
	*
	* @param msId the primary key of the current membership subscription
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionSessionId_PrevAndNext(
		long msId, java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Removes all the membership subscriptions where userName = &#63; from the database.
	*
	* @param userName the user name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionSessionId(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions where userName = &#63;.
	*
	* @param userName the user name
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionSessionId(java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscriptions where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscriptions where ppPaymentStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ppPaymentStatus the pp payment status
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions where ppPaymentStatus = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ppPaymentStatus the pp payment status
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionPpPaymentStatus_First(
		java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatus_First(
		java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionPpPaymentStatus_Last(
		java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatus_Last(
		java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscriptions before and after the current membership subscription in the ordered set where ppPaymentStatus = &#63;.
	*
	* @param msId the primary key of the current membership subscription
	* @param ppPaymentStatus the pp payment status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionPpPaymentStatus_PrevAndNext(
		long msId, java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Removes all the membership subscriptions where ppPaymentStatus = &#63; from the database.
	*
	* @param ppPaymentStatus the pp payment status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionShippingEmailAddressAndNettotal_First(
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_First(
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionShippingEmailAddressAndNettotal_Last(
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_Last(
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscriptions before and after the current membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param msId the primary key of the current membership subscription
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionShippingEmailAddressAndNettotal_PrevAndNext(
		long msId, java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Removes all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63; from the database.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscriptions where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscriptions where shippingEmailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shippingEmailAddress the shipping email address
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions where shippingEmailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param shippingEmailAddress the shipping email address
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionShippingEmailAddress_First(
		java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddress_First(
		java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionShippingEmailAddress_Last(
		java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddress_Last(
		java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscriptions before and after the current membership subscription in the ordered set where shippingEmailAddress = &#63;.
	*
	* @param msId the primary key of the current membership subscription
	* @param shippingEmailAddress the shipping email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionShippingEmailAddress_PrevAndNext(
		long msId, java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Removes all the membership subscriptions where shippingEmailAddress = &#63; from the database.
	*
	* @param shippingEmailAddress the shipping email address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @return the range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_First(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_First(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_Last(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_Last(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscriptions before and after the current membership subscription in the ordered set where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param msId the primary key of the current membership subscription
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_PrevAndNext(
		long msId, java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Removes all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63; from the database.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @throws SystemException if a system exception occurred
	*/
	public void removeByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the membership subscription in the entity cache if it is enabled.
	*
	* @param membershipSubscription the membership subscription
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipSubscription membershipSubscription);

	/**
	* Caches the membership subscriptions in the entity cache if it is enabled.
	*
	* @param membershipSubscriptions the membership subscriptions
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> membershipSubscriptions);

	/**
	* Creates a new membership subscription with the primary key. Does not add the membership subscription to the database.
	*
	* @param msId the primary key for the new membership subscription
	* @return the new membership subscription
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription create(
		long msId);

	/**
	* Removes the membership subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param msId the primary key of the membership subscription
	* @return the membership subscription that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription remove(
		long msId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	public com.sambaash.platform.srv.spservices.model.MembershipSubscription updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipSubscription membershipSubscription)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the membership subscription with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException} if it could not be found.
	*
	* @param msId the primary key of the membership subscription
	* @return the membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription findByPrimaryKey(
		long msId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException;

	/**
	* Returns the membership subscription with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param msId the primary key of the membership subscription
	* @return the membership subscription, or <code>null</code> if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByPrimaryKey(
		long msId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the membership subscriptions.
	*
	* @return the membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the membership subscriptions.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.MembershipSubscriptionModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of membership subscriptions
	* @param end the upper bound of the range of membership subscriptions (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the membership subscriptions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of membership subscriptions.
	*
	* @return the number of membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}