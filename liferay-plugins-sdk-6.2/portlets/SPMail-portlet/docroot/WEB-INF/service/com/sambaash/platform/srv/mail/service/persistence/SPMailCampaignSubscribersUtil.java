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

package com.sambaash.platform.srv.mail.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;

import java.util.List;

/**
 * The persistence utility for the s p mail campaign subscribers service. This utility wraps {@link SPMailCampaignSubscribersPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignSubscribersPersistence
 * @see SPMailCampaignSubscribersPersistenceImpl
 * @generated
 */
public class SPMailCampaignSubscribersUtil {
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
	public static void clearCache(
		SPMailCampaignSubscribers spMailCampaignSubscribers) {
		getPersistence().clearCache(spMailCampaignSubscribers);
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
	public static List<SPMailCampaignSubscribers> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPMailCampaignSubscribers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPMailCampaignSubscribers> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPMailCampaignSubscribers update(
		SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws SystemException {
		return getPersistence().update(spMailCampaignSubscribers);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPMailCampaignSubscribers update(
		SPMailCampaignSubscribers spMailCampaignSubscribers,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spMailCampaignSubscribers, serviceContext);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(spMailCampaignId);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCampaignId(spMailCampaignId, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignId(spMailCampaignId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignId_First(spMailCampaignId, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_First(spMailCampaignId, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignId_Last(spMailCampaignId, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignId_Last(spMailCampaignId, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignId_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignId_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignId(spMailCampaignId);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCampaignId(spMailCampaignId);
	}

	/**
	* Returns all the s p mail campaign subscriberses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserId(userId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence().findByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence().findByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where userId = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByUserId_PrevAndNext(
		long spMailCampaignSubscribersId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByUserId_PrevAndNext(spMailCampaignSubscribersId,
			userId, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserId(userId);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserId(userId);
	}

	/**
	* Returns all the s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserIdAndOpened(
		long userId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdAndOpened(userId, opened);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param opened the opened
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserIdAndOpened(
		long userId, boolean opened, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUserIdAndOpened(userId, opened, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param opened the opened
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserIdAndOpened(
		long userId, boolean opened, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUserIdAndOpened(userId, opened, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByUserIdAndOpened_First(
		long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByUserIdAndOpened_First(userId, opened,
			orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByUserIdAndOpened_First(
		long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndOpened_First(userId, opened,
			orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByUserIdAndOpened_Last(
		long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByUserIdAndOpened_Last(userId, opened, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByUserIdAndOpened_Last(
		long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUserIdAndOpened_Last(userId, opened,
			orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param userId the user ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByUserIdAndOpened_PrevAndNext(
		long spMailCampaignSubscribersId, long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByUserIdAndOpened_PrevAndNext(spMailCampaignSubscribersId,
			userId, opened, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where userId = &#63; and opened = &#63; from the database.
	*
	* @param userId the user ID
	* @param opened the opened
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUserIdAndOpened(long userId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUserIdAndOpened(userId, opened);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUserIdAndOpened(long userId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUserIdAndOpened(userId, opened);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndMailType(spMailCampaignId, spMailType);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndMailType(spMailCampaignId, spMailType,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndMailType(spMailCampaignId, spMailType,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndMailType_First(
		long spMailCampaignId, int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndMailType_First(spMailCampaignId,
			spMailType, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndMailType_First(
		long spMailCampaignId, int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndMailType_First(spMailCampaignId,
			spMailType, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndMailType_Last(
		long spMailCampaignId, int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndMailType_Last(spMailCampaignId,
			spMailType, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndMailType_Last(
		long spMailCampaignId, int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndMailType_Last(spMailCampaignId,
			spMailType, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndMailType_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndMailType_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, spMailType, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdAndMailType(long spMailCampaignId,
		int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdAndMailType(spMailCampaignId, spMailType);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdAndMailType(long spMailCampaignId,
		int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdAndMailType(spMailCampaignId, spMailType);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndStatus(spMailCampaignId,
			spMailType, status);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndStatus(spMailCampaignId,
			spMailType, status, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndStatus(spMailCampaignId,
			spMailType, status, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndStatus_First(
		long spMailCampaignId, int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndStatus_First(spMailCampaignId,
			spMailType, status, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndStatus_First(
		long spMailCampaignId, int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndStatus_First(spMailCampaignId,
			spMailType, status, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndStatus_Last(
		long spMailCampaignId, int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndStatus_Last(spMailCampaignId,
			spMailType, status, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndStatus_Last(
		long spMailCampaignId, int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndStatus_Last(spMailCampaignId,
			spMailType, status, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndStatus_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndStatus_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, spMailType, status, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdMailTypeAndStatus(spMailCampaignId, spMailType,
			status);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdMailTypeAndStatus(spMailCampaignId,
			spMailType, status);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndOpened_First(
		long spMailCampaignId, int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndOpened_First(spMailCampaignId,
			spMailType, opened, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndOpened_First(
		long spMailCampaignId, int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndOpened_First(spMailCampaignId,
			spMailType, opened, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndOpened_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndOpened_Last(spMailCampaignId,
			spMailType, opened, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndOpened_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndOpened_Last(spMailCampaignId,
			spMailType, opened, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndOpened_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndOpened_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, spMailType, opened, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdMailTypeAndOpened(spMailCampaignId, spMailType,
			opened);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdMailTypeAndOpened(spMailCampaignId,
			spMailType, opened);
	}

	/**
	* Returns the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException} if it could not be found.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
			spMailType, emailAddress);
	}

	/**
	* Returns the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
			spMailType, emailAddress);
	}

	/**
	* Returns the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param emailAddress the email address
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
			spMailType, emailAddress, retrieveFromCache);
	}

	/**
	* Removes the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param emailAddress the email address
	* @return the s p mail campaign subscribers that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers removeByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .removeByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
			spMailType, emailAddress);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param emailAddress the email address
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdMailTypeAndEmailAddress(spMailCampaignId,
			spMailType, emailAddress);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndEmailAddress(spMailCampaignId,
			emailAddress);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndEmailAddress(spMailCampaignId,
			emailAddress, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, java.lang.String emailAddress, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndEmailAddress(spMailCampaignId,
			emailAddress, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndEmailAddress_First(
		long spMailCampaignId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndEmailAddress_First(spMailCampaignId,
			emailAddress, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndEmailAddress_First(
		long spMailCampaignId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndEmailAddress_First(spMailCampaignId,
			emailAddress, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndEmailAddress_Last(
		long spMailCampaignId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndEmailAddress_Last(spMailCampaignId,
			emailAddress, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndEmailAddress_Last(
		long spMailCampaignId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndEmailAddress_Last(spMailCampaignId,
			emailAddress, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndEmailAddress_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, emailAddress, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdAndEmailAddress(
		long spMailCampaignId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdAndEmailAddress(spMailCampaignId, emailAddress);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdAndEmailAddress(long spMailCampaignId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdAndEmailAddress(spMailCampaignId,
			emailAddress);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
			spMailType, opened, emailAddress);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
			spMailType, opened, emailAddress, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
			spMailType, opened, emailAddress, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndEmailAddress_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndEmailAddress_First(spMailCampaignId,
			spMailType, opened, emailAddress, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndEmailAddress_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeOpenedAndEmailAddress_First(spMailCampaignId,
			spMailType, opened, emailAddress, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndEmailAddress_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndEmailAddress_Last(spMailCampaignId,
			spMailType, opened, emailAddress, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndEmailAddress_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeOpenedAndEmailAddress_Last(spMailCampaignId,
			spMailType, opened, emailAddress, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeOpenedAndEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndEmailAddress_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, spMailType, opened, emailAddress,
			orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
			spMailType, opened, emailAddress);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdMailTypeOpenedAndEmailAddress(spMailCampaignId,
			spMailType, opened, emailAddress);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdOpenedAndEmailAddress(spMailCampaignId,
			opened, emailAddress);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdOpenedAndEmailAddress(spMailCampaignId,
			opened, emailAddress, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdOpenedAndEmailAddress(spMailCampaignId,
			opened, emailAddress, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndEmailAddress_First(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdOpenedAndEmailAddress_First(spMailCampaignId,
			opened, emailAddress, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndEmailAddress_First(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdOpenedAndEmailAddress_First(spMailCampaignId,
			opened, emailAddress, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndEmailAddress_Last(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdOpenedAndEmailAddress_Last(spMailCampaignId,
			opened, emailAddress, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndEmailAddress_Last(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdOpenedAndEmailAddress_Last(spMailCampaignId,
			opened, emailAddress, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdOpenedAndEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdOpenedAndEmailAddress_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, opened, emailAddress, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdOpenedAndEmailAddress(spMailCampaignId, opened,
			emailAddress);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdOpenedAndEmailAddress(spMailCampaignId,
			opened, emailAddress);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
			spMailType, opened, firstName);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
			spMailType, opened, firstName, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
			spMailType, opened, firstName, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndFirstName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndFirstName_First(spMailCampaignId,
			spMailType, opened, firstName, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndFirstName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeOpenedAndFirstName_First(spMailCampaignId,
			spMailType, opened, firstName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndFirstName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndFirstName_Last(spMailCampaignId,
			spMailType, opened, firstName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndFirstName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeOpenedAndFirstName_Last(spMailCampaignId,
			spMailType, opened, firstName, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeOpenedAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndFirstName_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, spMailType, opened, firstName, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
			spMailType, opened, firstName);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdMailTypeOpenedAndFirstName(spMailCampaignId,
			spMailType, opened, firstName);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndFirstName(spMailCampaignId,
			spMailType, firstName);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndFirstName(spMailCampaignId,
			spMailType, firstName, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndFirstName(spMailCampaignId,
			spMailType, firstName, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndFirstName_First(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndFirstName_First(spMailCampaignId,
			spMailType, firstName, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndFirstName_First(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndFirstName_First(spMailCampaignId,
			spMailType, firstName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndFirstName_Last(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndFirstName_Last(spMailCampaignId,
			spMailType, firstName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndFirstName_Last(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndFirstName_Last(spMailCampaignId,
			spMailType, firstName, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndFirstName_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, spMailType, firstName, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdMailTypeAndFirstName(spMailCampaignId,
			spMailType, firstName);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdMailTypeAndFirstName(spMailCampaignId,
			spMailType, firstName);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdOpenedAndFirstName(spMailCampaignId,
			opened, firstName);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdOpenedAndFirstName(spMailCampaignId,
			opened, firstName, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdOpenedAndFirstName(spMailCampaignId,
			opened, firstName, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndFirstName_First(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdOpenedAndFirstName_First(spMailCampaignId,
			opened, firstName, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndFirstName_First(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdOpenedAndFirstName_First(spMailCampaignId,
			opened, firstName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndFirstName_Last(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdOpenedAndFirstName_Last(spMailCampaignId,
			opened, firstName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndFirstName_Last(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdOpenedAndFirstName_Last(spMailCampaignId,
			opened, firstName, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdOpenedAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdOpenedAndFirstName_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, opened, firstName, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdOpenedAndFirstName(spMailCampaignId, opened,
			firstName);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdOpenedAndFirstName(spMailCampaignId,
			opened, firstName);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndFirstName(spMailCampaignId, firstName);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, java.lang.String firstName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndFirstName(spMailCampaignId, firstName,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, java.lang.String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndFirstName(spMailCampaignId, firstName,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndFirstName_First(
		long spMailCampaignId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndFirstName_First(spMailCampaignId,
			firstName, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndFirstName_First(
		long spMailCampaignId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndFirstName_First(spMailCampaignId,
			firstName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndFirstName_Last(
		long spMailCampaignId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndFirstName_Last(spMailCampaignId,
			firstName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndFirstName_Last(
		long spMailCampaignId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndFirstName_Last(spMailCampaignId,
			firstName, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndFirstName_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, firstName, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdAndFirstName(long spMailCampaignId,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdAndFirstName(spMailCampaignId, firstName);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdAndFirstName(long spMailCampaignId,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdAndFirstName(spMailCampaignId, firstName);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
			spMailType, opened, lastName);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
			spMailType, opened, lastName, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
			spMailType, opened, lastName, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndLastName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndLastName_First(spMailCampaignId,
			spMailType, opened, lastName, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndLastName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeOpenedAndLastName_First(spMailCampaignId,
			spMailType, opened, lastName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndLastName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndLastName_Last(spMailCampaignId,
			spMailType, opened, lastName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndLastName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeOpenedAndLastName_Last(spMailCampaignId,
			spMailType, opened, lastName, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeOpenedAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeOpenedAndLastName_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, spMailType, opened, lastName, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
			spMailType, opened, lastName);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdMailTypeOpenedAndLastName(spMailCampaignId,
			spMailType, opened, lastName);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndLastName(spMailCampaignId,
			spMailType, lastName);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndLastName(spMailCampaignId,
			spMailType, lastName, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndLastName(spMailCampaignId,
			spMailType, lastName, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndLastName_First(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndLastName_First(spMailCampaignId,
			spMailType, lastName, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndLastName_First(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndLastName_First(spMailCampaignId,
			spMailType, lastName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndLastName_Last(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndLastName_Last(spMailCampaignId,
			spMailType, lastName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndLastName_Last(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdMailTypeAndLastName_Last(spMailCampaignId,
			spMailType, lastName, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdMailTypeAndLastName_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, spMailType, lastName, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdMailTypeAndLastName(spMailCampaignId,
			spMailType, lastName);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdMailTypeAndLastName(spMailCampaignId,
			spMailType, lastName);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdOpenedAndLastName(spMailCampaignId, opened,
			lastName);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdOpenedAndLastName(spMailCampaignId, opened,
			lastName, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdOpenedAndLastName(spMailCampaignId, opened,
			lastName, start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndLastName_First(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdOpenedAndLastName_First(spMailCampaignId,
			opened, lastName, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndLastName_First(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdOpenedAndLastName_First(spMailCampaignId,
			opened, lastName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndLastName_Last(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdOpenedAndLastName_Last(spMailCampaignId,
			opened, lastName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndLastName_Last(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdOpenedAndLastName_Last(spMailCampaignId,
			opened, lastName, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdOpenedAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdOpenedAndLastName_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, opened, lastName, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdOpenedAndLastName(spMailCampaignId, opened,
			lastName);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdOpenedAndLastName(spMailCampaignId,
			opened, lastName);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndLastName(spMailCampaignId, lastName);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndLastName(spMailCampaignId, lastName,
			start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndLastName(spMailCampaignId, lastName,
			start, end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndLastName_First(
		long spMailCampaignId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndLastName_First(spMailCampaignId,
			lastName, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndLastName_First(
		long spMailCampaignId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndLastName_First(spMailCampaignId,
			lastName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndLastName_Last(
		long spMailCampaignId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndLastName_Last(spMailCampaignId,
			lastName, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndLastName_Last(
		long spMailCampaignId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndLastName_Last(spMailCampaignId,
			lastName, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndLastName_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, lastName, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdAndLastName(long spMailCampaignId,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdAndLastName(spMailCampaignId, lastName);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdAndLastName(long spMailCampaignId,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdAndLastName(spMailCampaignId, lastName);
	}

	/**
	* Returns all the s p mail campaign subscriberses where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailAddress(emailAddress);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByEmailAddress(emailAddress, start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where emailAddress = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param emailAddress the email address
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByEmailAddress(emailAddress, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByEmailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByEmailAddress_First(emailAddress, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByEmailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddress_First(emailAddress, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByEmailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByEmailAddress_Last(emailAddress, orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByEmailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByEmailAddress_Last(emailAddress, orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByEmailAddress_PrevAndNext(spMailCampaignSubscribersId,
			emailAddress, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByEmailAddress(emailAddress);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByEmailAddress(emailAddress);
	}

	/**
	* Returns the s p mail campaign subscribers where messageId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException} if it could not be found.
	*
	* @param messageId the message ID
	* @return the matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence().findByMessageId(messageId);
	}

	/**
	* Returns the s p mail campaign subscribers where messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param messageId the message ID
	* @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMessageId(messageId);
	}

	/**
	* Returns the s p mail campaign subscribers where messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param messageId the message ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByMessageId(
		java.lang.String messageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByMessageId(messageId, retrieveFromCache);
	}

	/**
	* Removes the s p mail campaign subscribers where messageId = &#63; from the database.
	*
	* @param messageId the message ID
	* @return the s p mail campaign subscribers that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers removeByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence().removeByMessageId(messageId);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMessageId(java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMessageId(messageId);
	}

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndOpened(spMailCampaignId, opened);
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndOpened(spMailCampaignId, opened, start,
			end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndOpened(spMailCampaignId, opened, start,
			end, orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndOpened_First(
		long spMailCampaignId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndOpened_First(spMailCampaignId, opened,
			orderByComparator);
	}

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndOpened_First(
		long spMailCampaignId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndOpened_First(spMailCampaignId, opened,
			orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndOpened_Last(
		long spMailCampaignId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndOpened_Last(spMailCampaignId, opened,
			orderByComparator);
	}

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndOpened_Last(
		long spMailCampaignId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndOpened_Last(spMailCampaignId, opened,
			orderByComparator);
	}

	/**
	* Returns the s p mail campaign subscriberses before and after the current s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignSubscribersId the primary key of the current s p mail campaign subscribers
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndOpened_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence()
				   .findByCampaignIdAndOpened_PrevAndNext(spMailCampaignSubscribersId,
			spMailCampaignId, opened, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdAndOpened(long spMailCampaignId,
		boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCampaignIdAndOpened(spMailCampaignId, opened);
	}

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdAndOpened(long spMailCampaignId,
		boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdAndOpened(spMailCampaignId, opened);
	}

	/**
	* Caches the s p mail campaign subscribers in the entity cache if it is enabled.
	*
	* @param spMailCampaignSubscribers the s p mail campaign subscribers
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers) {
		getPersistence().cacheResult(spMailCampaignSubscribers);
	}

	/**
	* Caches the s p mail campaign subscriberses in the entity cache if it is enabled.
	*
	* @param spMailCampaignSubscriberses the s p mail campaign subscriberses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> spMailCampaignSubscriberses) {
		getPersistence().cacheResult(spMailCampaignSubscriberses);
	}

	/**
	* Creates a new s p mail campaign subscribers with the primary key. Does not add the s p mail campaign subscribers to the database.
	*
	* @param spMailCampaignSubscribersId the primary key for the new s p mail campaign subscribers
	* @return the new s p mail campaign subscribers
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers create(
		long spMailCampaignSubscribersId) {
		return getPersistence().create(spMailCampaignSubscribersId);
	}

	/**
	* Removes the s p mail campaign subscribers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers remove(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence().remove(spMailCampaignSubscribersId);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spMailCampaignSubscribers);
	}

	/**
	* Returns the s p mail campaign subscribers with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException} if it could not be found.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByPrimaryKey(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException {
		return getPersistence().findByPrimaryKey(spMailCampaignSubscribersId);
	}

	/**
	* Returns the s p mail campaign subscribers with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers, or <code>null</code> if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByPrimaryKey(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spMailCampaignSubscribersId);
	}

	/**
	* Returns all the s p mail campaign subscriberses.
	*
	* @return the s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p mail campaign subscriberses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @return the range of s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p mail campaign subscriberses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailCampaignSubscribersModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail campaign subscriberses
	* @param end the upper bound of the range of s p mail campaign subscriberses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p mail campaign subscriberses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p mail campaign subscriberses.
	*
	* @return the number of s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPMailCampaignSubscribersPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPMailCampaignSubscribersPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.mail.service.ClpSerializer.getServletContextName(),
					SPMailCampaignSubscribersPersistence.class.getName());

			ReferenceRegistry.registerReference(SPMailCampaignSubscribersUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPMailCampaignSubscribersPersistence persistence) {
	}

	private static SPMailCampaignSubscribersPersistence _persistence;
}