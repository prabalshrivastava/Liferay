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

import com.sambaash.platform.srv.mail.model.SPMailLinkTracking;

/**
 * The persistence interface for the s p mail link tracking service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailLinkTrackingPersistenceImpl
 * @see SPMailLinkTrackingUtil
 * @generated
 */
public interface SPMailLinkTrackingPersistence extends BasePersistence<SPMailLinkTracking> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMailLinkTrackingUtil} to access the s p mail link tracking persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @return the matching s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param start the lower bound of the range of s p mail link trackings
	* @param end the upper bound of the range of s p mail link trackings (not inclusive)
	* @return the range of matching s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param start the lower bound of the range of s p mail link trackings
	* @param end the upper bound of the range of s p mail link trackings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail link tracking
	* @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a matching s p mail link tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking findByCampaignIdAndSubscribersId_First(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException;

	/**
	* Returns the first s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail link tracking, or <code>null</code> if a matching s p mail link tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking fetchByCampaignIdAndSubscribersId_First(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail link tracking
	* @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a matching s p mail link tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking findByCampaignIdAndSubscribersId_Last(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException;

	/**
	* Returns the last s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail link tracking, or <code>null</code> if a matching s p mail link tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking fetchByCampaignIdAndSubscribersId_Last(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail link trackings before and after the current s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailLinkTrackingId the primary key of the current s p mail link tracking
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p mail link tracking
	* @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking[] findByCampaignIdAndSubscribersId_PrevAndNext(
		long spMailLinkTrackingId, long spMailCampaignId,
		long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException;

	/**
	* Removes all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCampaignIdAndSubscribersId(long spMailCampaignId,
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @return the number of matching s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCampaignIdAndSubscribersId(long spMailCampaignId,
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p mail link tracking in the entity cache if it is enabled.
	*
	* @param spMailLinkTracking the s p mail link tracking
	*/
	public void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking);

	/**
	* Caches the s p mail link trackings in the entity cache if it is enabled.
	*
	* @param spMailLinkTrackings the s p mail link trackings
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> spMailLinkTrackings);

	/**
	* Creates a new s p mail link tracking with the primary key. Does not add the s p mail link tracking to the database.
	*
	* @param spMailLinkTrackingId the primary key for the new s p mail link tracking
	* @return the new s p mail link tracking
	*/
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking create(
		long spMailLinkTrackingId);

	/**
	* Removes the s p mail link tracking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking remove(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException;

	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p mail link tracking with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchLinkTrackingException} if it could not be found.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking
	* @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking findByPrimaryKey(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException;

	/**
	* Returns the s p mail link tracking with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking, or <code>null</code> if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.mail.model.SPMailLinkTracking fetchByPrimaryKey(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p mail link trackings.
	*
	* @return the s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p mail link trackings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail link trackings
	* @param end the upper bound of the range of s p mail link trackings (not inclusive)
	* @return the range of s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p mail link trackings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.mail.model.impl.SPMailLinkTrackingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p mail link trackings
	* @param end the upper bound of the range of s p mail link trackings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p mail link trackings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p mail link trackings.
	*
	* @return the number of s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}