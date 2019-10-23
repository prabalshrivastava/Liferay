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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spservices.model.MembershipSubscription;

import java.util.List;

/**
 * The persistence utility for the membership subscription service. This utility wraps {@link MembershipSubscriptionPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionPersistence
 * @see MembershipSubscriptionPersistenceImpl
 * @generated
 */
public class MembershipSubscriptionUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(MembershipSubscription membershipSubscription) {
		getPersistence().clearCache(membershipSubscription);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MembershipSubscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MembershipSubscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MembershipSubscription> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MembershipSubscription update(
		MembershipSubscription membershipSubscription)
		throws SystemException {
		return getPersistence().update(membershipSubscription);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MembershipSubscription update(
		MembershipSubscription membershipSubscription,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(membershipSubscription, serviceContext);
	}

	/**
	* Returns all the membership subscriptions where name = &#63;.
	*
	* @param name the name
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipSubscriptionName(name);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionName(name, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionName(name, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionName_First(name,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionName_First(name,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionName_Last(name,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where name = &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionName_Last(name,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionName_PrevAndNext(
		long msId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionName_PrevAndNext(msId, name,
			orderByComparator);
	}

	/**
	* Removes all the membership subscriptions where name = &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipSubscriptionName(name);
	}

	/**
	* Returns the number of membership subscriptions where name = &#63;.
	*
	* @param name the name
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipSubscriptionName(name);
	}

	/**
	* Returns all the membership subscriptions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipSubscriptionGroupId(groupId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionGroupId(groupId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionGroupId(groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionGroupId_First(groupId,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionGroupId_First(groupId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionGroupId_Last(groupId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionGroupId_Last(groupId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionGroupId_PrevAndNext(
		long msId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionGroupId_PrevAndNext(msId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the membership subscriptions where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipSubscriptionGroupId(groupId);
	}

	/**
	* Returns the number of membership subscriptions where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipSubscriptionGroupId(groupId);
	}

	/**
	* Returns all the membership subscriptions where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipSubscriptionUserId(userId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionUserId(userId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionUserId(userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionUserId_First(userId,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionUserId_First(userId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionUserId_Last(userId,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionUserId_Last(userId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionUserId_PrevAndNext(
		long msId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionUserId_PrevAndNext(msId,
			userId, orderByComparator);
	}

	/**
	* Removes all the membership subscriptions where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipSubscriptionUserId(userId);
	}

	/**
	* Returns the number of membership subscriptions where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipSubscriptionUserId(userId);
	}

	/**
	* Returns all the membership subscriptions where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipSubscriptionMpId_1(mpId_1);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionMpId_1(mpId_1, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionMpId_1(mpId_1, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionMpId_1_First(
		java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionMpId_1_First(mpId_1,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionMpId_1_First(
		java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionMpId_1_First(mpId_1,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionMpId_1_Last(
		java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionMpId_1_Last(mpId_1,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionMpId_1_Last(
		java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionMpId_1_Last(mpId_1,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionMpId_1_PrevAndNext(
		long msId, java.lang.String mpId_1,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionMpId_1_PrevAndNext(msId,
			mpId_1, orderByComparator);
	}

	/**
	* Removes all the membership subscriptions where mpId_1 = &#63; from the database.
	*
	* @param mpId_1 the mp id_1
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipSubscriptionMpId_1(mpId_1);
	}

	/**
	* Returns the number of membership subscriptions where mpId_1 = &#63;.
	*
	* @param mpId_1 the mp id_1
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionMpId_1(
		java.lang.String mpId_1)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipSubscriptionMpId_1(mpId_1);
	}

	/**
	* Returns all the membership subscriptions where userName = &#63;.
	*
	* @param userName the user name
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionSessionId(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMembershipSubscriptionSessionId(userName);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionSessionId(
		java.lang.String userName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionSessionId(userName, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionSessionId(
		java.lang.String userName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionSessionId(userName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionSessionId_First(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionSessionId_First(userName,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionSessionId_First(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionSessionId_First(userName,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionSessionId_Last(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionSessionId_Last(userName,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where userName = &#63;.
	*
	* @param userName the user name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionSessionId_Last(
		java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionSessionId_Last(userName,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionSessionId_PrevAndNext(
		long msId, java.lang.String userName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionSessionId_PrevAndNext(msId,
			userName, orderByComparator);
	}

	/**
	* Removes all the membership subscriptions where userName = &#63; from the database.
	*
	* @param userName the user name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionSessionId(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMembershipSubscriptionSessionId(userName);
	}

	/**
	* Returns the number of membership subscriptions where userName = &#63;.
	*
	* @param userName the user name
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionSessionId(
		java.lang.String userName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMembershipSubscriptionSessionId(userName);
	}

	/**
	* Returns all the membership subscriptions where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus,
			start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus,
			start, end, orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionPpPaymentStatus_First(
		java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatus_First(ppPaymentStatus,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatus_First(
		java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionPpPaymentStatus_First(ppPaymentStatus,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionPpPaymentStatus_Last(
		java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatus_Last(ppPaymentStatus,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatus_Last(
		java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionPpPaymentStatus_Last(ppPaymentStatus,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionPpPaymentStatus_PrevAndNext(
		long msId, java.lang.String ppPaymentStatus,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatus_PrevAndNext(msId,
			ppPaymentStatus, orderByComparator);
	}

	/**
	* Removes all the membership subscriptions where ppPaymentStatus = &#63; from the database.
	*
	* @param ppPaymentStatus the pp payment status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus);
	}

	/**
	* Returns the number of membership subscriptions where ppPaymentStatus = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionPpPaymentStatus(
		java.lang.String ppPaymentStatus)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMembershipSubscriptionPpPaymentStatus(ppPaymentStatus);
	}

	/**
	* Returns all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
			nettotal);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
			nettotal, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
			nettotal, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionShippingEmailAddressAndNettotal_First(
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddressAndNettotal_First(shippingEmailAddress,
			nettotal, orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_First(
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_First(shippingEmailAddress,
			nettotal, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionShippingEmailAddressAndNettotal_Last(
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddressAndNettotal_Last(shippingEmailAddress,
			nettotal, orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_Last(
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionShippingEmailAddressAndNettotal_Last(shippingEmailAddress,
			nettotal, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionShippingEmailAddressAndNettotal_PrevAndNext(
		long msId, java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddressAndNettotal_PrevAndNext(msId,
			shippingEmailAddress, nettotal, orderByComparator);
	}

	/**
	* Removes all the membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63; from the database.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
			nettotal);
	}

	/**
	* Returns the number of membership subscriptions where shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionShippingEmailAddressAndNettotal(
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMembershipSubscriptionShippingEmailAddressAndNettotal(shippingEmailAddress,
			nettotal);
	}

	/**
	* Returns all the membership subscriptions where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress,
			start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress,
			start, end, orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionShippingEmailAddress_First(
		java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddress_First(shippingEmailAddress,
			orderByComparator);
	}

	/**
	* Returns the first membership subscription in the ordered set where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddress_First(
		java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionShippingEmailAddress_First(shippingEmailAddress,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionShippingEmailAddress_Last(
		java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddress_Last(shippingEmailAddress,
			orderByComparator);
	}

	/**
	* Returns the last membership subscription in the ordered set where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching membership subscription, or <code>null</code> if a matching membership subscription could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionShippingEmailAddress_Last(
		java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionShippingEmailAddress_Last(shippingEmailAddress,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionShippingEmailAddress_PrevAndNext(
		long msId, java.lang.String shippingEmailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionShippingEmailAddress_PrevAndNext(msId,
			shippingEmailAddress, orderByComparator);
	}

	/**
	* Removes all the membership subscriptions where shippingEmailAddress = &#63; from the database.
	*
	* @param shippingEmailAddress the shipping email address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress);
	}

	/**
	* Returns the number of membership subscriptions where shippingEmailAddress = &#63;.
	*
	* @param shippingEmailAddress the shipping email address
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionShippingEmailAddress(
		java.lang.String shippingEmailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMembershipSubscriptionShippingEmailAddress(shippingEmailAddress);
	}

	/**
	* Returns all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @return the matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
			shippingEmailAddress, nettotal);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
			shippingEmailAddress, nettotal, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
			shippingEmailAddress, nettotal, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_First(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_First(ppPaymentStatus,
			shippingEmailAddress, nettotal, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_First(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_First(ppPaymentStatus,
			shippingEmailAddress, nettotal, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_Last(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_Last(ppPaymentStatus,
			shippingEmailAddress, nettotal, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_Last(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_Last(ppPaymentStatus,
			shippingEmailAddress, nettotal, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription[] findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_PrevAndNext(
		long msId, java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence()
				   .findByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal_PrevAndNext(msId,
			ppPaymentStatus, shippingEmailAddress, nettotal, orderByComparator);
	}

	/**
	* Removes all the membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63; from the database.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
			shippingEmailAddress, nettotal);
	}

	/**
	* Returns the number of membership subscriptions where ppPaymentStatus = &#63; and shippingEmailAddress = &#63; and nettotal = &#63;.
	*
	* @param ppPaymentStatus the pp payment status
	* @param shippingEmailAddress the shipping email address
	* @param nettotal the nettotal
	* @return the number of matching membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(
		java.lang.String ppPaymentStatus,
		java.lang.String shippingEmailAddress, float nettotal)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByMembershipSubscriptionPpPaymentStatusEmailAddressAndNettotal(ppPaymentStatus,
			shippingEmailAddress, nettotal);
	}

	/**
	* Caches the membership subscription in the entity cache if it is enabled.
	*
	* @param membershipSubscription the membership subscription
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.MembershipSubscription membershipSubscription) {
		getPersistence().cacheResult(membershipSubscription);
	}

	/**
	* Caches the membership subscriptions in the entity cache if it is enabled.
	*
	* @param membershipSubscriptions the membership subscriptions
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> membershipSubscriptions) {
		getPersistence().cacheResult(membershipSubscriptions);
	}

	/**
	* Creates a new membership subscription with the primary key. Does not add the membership subscription to the database.
	*
	* @param msId the primary key for the new membership subscription
	* @return the new membership subscription
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription create(
		long msId) {
		return getPersistence().create(msId);
	}

	/**
	* Removes the membership subscription with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param msId the primary key of the membership subscription
	* @return the membership subscription that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription remove(
		long msId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence().remove(msId);
	}

	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription updateImpl(
		com.sambaash.platform.srv.spservices.model.MembershipSubscription membershipSubscription)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(membershipSubscription);
	}

	/**
	* Returns the membership subscription with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException} if it could not be found.
	*
	* @param msId the primary key of the membership subscription
	* @return the membership subscription
	* @throws com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription findByPrimaryKey(
		long msId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchMembershipSubscriptionException {
		return getPersistence().findByPrimaryKey(msId);
	}

	/**
	* Returns the membership subscription with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param msId the primary key of the membership subscription
	* @return the membership subscription, or <code>null</code> if a membership subscription with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.MembershipSubscription fetchByPrimaryKey(
		long msId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(msId);
	}

	/**
	* Returns all the membership subscriptions.
	*
	* @return the membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spservices.model.MembershipSubscription> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the membership subscriptions from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of membership subscriptions.
	*
	* @return the number of membership subscriptions
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MembershipSubscriptionPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MembershipSubscriptionPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					MembershipSubscriptionPersistence.class.getName());

			ReferenceRegistry.registerReference(MembershipSubscriptionUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MembershipSubscriptionPersistence persistence) {
	}

	private static MembershipSubscriptionPersistence _persistence;
}