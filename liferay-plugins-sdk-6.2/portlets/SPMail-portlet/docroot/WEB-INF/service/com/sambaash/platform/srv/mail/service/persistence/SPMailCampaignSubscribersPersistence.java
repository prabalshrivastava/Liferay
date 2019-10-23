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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;

/**
 * The persistence interface for the s p mail campaign subscribers service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignSubscribersPersistenceImpl
 * @see SPMailCampaignSubscribersUtil
 * @generated
 */
public interface SPMailCampaignSubscribersPersistence extends BasePersistence<SPMailCampaignSubscribers> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMailCampaignSubscribersUtil} to access the s p mail campaign subscribers persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignId(
		long spMailCampaignId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignId_First(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignId_Last(
		long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignId_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignId(long spMailCampaignId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByUserId_PrevAndNext(
		long spMailCampaignSubscribersId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserIdAndOpened(
		long userId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserIdAndOpened(
		long userId, boolean opened, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByUserIdAndOpened(
		long userId, boolean opened, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByUserIdAndOpened_First(
		long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByUserIdAndOpened_First(
		long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByUserIdAndOpened_Last(
		long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByUserIdAndOpened_Last(
		long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByUserIdAndOpened_PrevAndNext(
		long spMailCampaignSubscribersId, long userId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where userId = &#63; and opened = &#63; from the database.
	*
	* @param userId the user ID
	* @param opened the opened
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndOpened(long userId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where userId = &#63; and opened = &#63;.
	*
	* @param userId the user ID
	* @param opened the opened
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndOpened(long userId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndMailType(
		long spMailCampaignId, int spMailType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndMailType_First(
		long spMailCampaignId, int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndMailType_First(
		long spMailCampaignId, int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndMailType_Last(
		long spMailCampaignId, int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndMailType_Last(
		long spMailCampaignId, int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndMailType_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdAndMailType(long spMailCampaignId,
		int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndMailType(long spMailCampaignId,
		int spMailType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndStatus(
		long spMailCampaignId, int spMailType, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndStatus_First(
		long spMailCampaignId, int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndStatus_First(
		long spMailCampaignId, int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndStatus_Last(
		long spMailCampaignId, int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndStatus_Last(
		long spMailCampaignId, int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndStatus_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdMailTypeAndStatus(long spMailCampaignId,
		int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and status = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param status the status
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdMailTypeAndStatus(long spMailCampaignId,
		int spMailType, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndOpened(
		long spMailCampaignId, int spMailType, boolean opened, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndOpened_First(
		long spMailCampaignId, int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndOpened_First(
		long spMailCampaignId, int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndOpened_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndOpened_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndOpened_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdMailTypeAndOpened(long spMailCampaignId,
		int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdMailTypeAndOpened(long spMailCampaignId,
		int spMailType, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail campaign subscribers where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param emailAddress the email address
	* @return the s p mail campaign subscribers that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers removeByCampaignIdMailTypeAndEmailAddress(
		long spMailCampaignId, int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param emailAddress the email address
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdMailTypeAndEmailAddress(long spMailCampaignId,
		int spMailType, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndEmailAddress(
		long spMailCampaignId, java.lang.String emailAddress, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndEmailAddress_First(
		long spMailCampaignId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndEmailAddress_First(
		long spMailCampaignId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndEmailAddress_Last(
		long spMailCampaignId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndEmailAddress_Last(
		long spMailCampaignId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdAndEmailAddress(long spMailCampaignId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param emailAddress the email address
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndEmailAddress(long spMailCampaignId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndEmailAddress_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndEmailAddress_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndEmailAddress_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndEmailAddress_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeOpenedAndEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and emailAddress = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCampaignIdMailTypeOpenedAndEmailAddress(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndEmailAddress(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndEmailAddress_First(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndEmailAddress_First(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndEmailAddress_Last(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndEmailAddress_Last(
		long spMailCampaignId, boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdOpenedAndEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdOpenedAndEmailAddress(long spMailCampaignId,
		boolean opened, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and emailAddress = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param emailAddress the email address
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdOpenedAndEmailAddress(long spMailCampaignId,
		boolean opened, java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndFirstName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndFirstName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndFirstName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndFirstName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeOpenedAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and firstName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCampaignIdMailTypeOpenedAndFirstName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndFirstName(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndFirstName_First(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndFirstName_First(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndFirstName_Last(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndFirstName_Last(
		long spMailCampaignId, int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdMailTypeAndFirstName(long spMailCampaignId,
		int spMailType, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param firstName the first name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdMailTypeAndFirstName(long spMailCampaignId,
		int spMailType, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndFirstName(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndFirstName_First(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndFirstName_First(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndFirstName_Last(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndFirstName_Last(
		long spMailCampaignId, boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdOpenedAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdOpenedAndFirstName(long spMailCampaignId,
		boolean opened, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param firstName the first name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdOpenedAndFirstName(long spMailCampaignId,
		boolean opened, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, java.lang.String firstName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndFirstName(
		long spMailCampaignId, java.lang.String firstName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndFirstName_First(
		long spMailCampaignId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndFirstName_First(
		long spMailCampaignId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndFirstName_Last(
		long spMailCampaignId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndFirstName_Last(
		long spMailCampaignId, java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndFirstName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		java.lang.String firstName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdAndFirstName(long spMailCampaignId,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and firstName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param firstName the first name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndFirstName(long spMailCampaignId,
		java.lang.String firstName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndLastName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndLastName_First(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeOpenedAndLastName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeOpenedAndLastName_Last(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeOpenedAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and opened = &#63; and lastName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param opened the opened
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public int countByCampaignIdMailTypeOpenedAndLastName(
		long spMailCampaignId, int spMailType, boolean opened,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdMailTypeAndLastName(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndLastName_First(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndLastName_First(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdMailTypeAndLastName_Last(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdMailTypeAndLastName_Last(
		long spMailCampaignId, int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdMailTypeAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		int spMailType, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdMailTypeAndLastName(long spMailCampaignId,
		int spMailType, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and spMailType = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailType the sp mail type
	* @param lastName the last name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdMailTypeAndLastName(long spMailCampaignId,
		int spMailType, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdOpenedAndLastName(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndLastName_First(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndLastName_First(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdOpenedAndLastName_Last(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdOpenedAndLastName_Last(
		long spMailCampaignId, boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdOpenedAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdOpenedAndLastName(long spMailCampaignId,
		boolean opened, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param lastName the last name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdOpenedAndLastName(long spMailCampaignId,
		boolean opened, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, java.lang.String lastName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndLastName(
		long spMailCampaignId, java.lang.String lastName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndLastName_First(
		long spMailCampaignId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndLastName_First(
		long spMailCampaignId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndLastName_Last(
		long spMailCampaignId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndLastName_Last(
		long spMailCampaignId, java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndLastName_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		java.lang.String lastName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdAndLastName(long spMailCampaignId,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and lastName = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param lastName the last name
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndLastName(long spMailCampaignId,
		java.lang.String lastName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByEmailAddress(
		java.lang.String emailAddress, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByEmailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByEmailAddress_First(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByEmailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByEmailAddress_Last(
		java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByEmailAddress_PrevAndNext(
		long spMailCampaignSubscribersId, java.lang.String emailAddress,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where emailAddress = &#63; from the database.
	*
	* @param emailAddress the email address
	* @throws SystemException if a system exception occurred
	*/
	public void removeByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where emailAddress = &#63;.
	*
	* @param emailAddress the email address
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByEmailAddress(java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign subscribers where messageId = &#63; or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException} if it could not be found.
	*
	* @param messageId the message ID
	* @return the matching s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the s p mail campaign subscribers where messageId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param messageId the message ID
	* @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign subscribers where messageId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param messageId the message ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByMessageId(
		java.lang.String messageId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p mail campaign subscribers where messageId = &#63; from the database.
	*
	* @param messageId the message ID
	* @return the s p mail campaign subscribers that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers removeByMessageId(
		java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the number of s p mail campaign subscriberses where messageId = &#63;.
	*
	* @param messageId the message ID
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByMessageId(java.lang.String messageId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @return the matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findByCampaignIdAndOpened(
		long spMailCampaignId, boolean opened, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndOpened_First(
		long spMailCampaignId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the first s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndOpened_First(
		long spMailCampaignId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByCampaignIdAndOpened_Last(
		long spMailCampaignId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the last s p mail campaign subscribers in the ordered set where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail campaign subscribers, or <code>null</code> if a matching s p mail campaign subscribers could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByCampaignIdAndOpened_Last(
		long spMailCampaignId, boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers[] findByCampaignIdAndOpened_PrevAndNext(
		long spMailCampaignSubscribersId, long spMailCampaignId,
		boolean opened,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Removes all the s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdAndOpened(long spMailCampaignId,
		boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses where spMailCampaignId = &#63; and opened = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param opened the opened
	* @return the number of matching s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndOpened(long spMailCampaignId, boolean opened)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p mail campaign subscribers in the entity cache if it is enabled.
	*
	* @param spMailCampaignSubscribers the s p mail campaign subscribers
	*/
	public void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers);

	/**
	* Caches the s p mail campaign subscriberses in the entity cache if it is enabled.
	*
	* @param spMailCampaignSubscriberses the s p mail campaign subscriberses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> spMailCampaignSubscriberses);

	/**
	* Creates a new s p mail campaign subscribers with the primary key. Does not add the s p mail campaign subscribers to the database.
	*
	* @param spMailCampaignSubscribersId the primary key for the new s p mail campaign subscribers
	* @return the new s p mail campaign subscribers
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers create(
		long spMailCampaignSubscribersId);

	/**
	* Removes the s p mail campaign subscribers with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers remove(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail campaign subscribers with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException} if it could not be found.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers
	* @throws com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers findByPrimaryKey(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchCampaignSubscribersException;

	/**
	* Returns the s p mail campaign subscribers with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailCampaignSubscribersId the primary key of the s p mail campaign subscribers
	* @return the s p mail campaign subscribers, or <code>null</code> if a s p mail campaign subscribers with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers fetchByPrimaryKey(
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail campaign subscriberses.
	*
	* @return the s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p mail campaign subscriberses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail campaign subscriberses.
	*
	* @return the number of s p mail campaign subscriberses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}