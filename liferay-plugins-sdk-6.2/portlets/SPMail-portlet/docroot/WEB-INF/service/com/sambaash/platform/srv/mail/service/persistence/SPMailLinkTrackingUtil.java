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

import com.sambaash.platform.srv.mail.model.SPMailLinkTracking;

import java.util.List;

/**
 * The persistence utility for the s p mail link tracking service. This utility wraps {@link SPMailLinkTrackingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailLinkTrackingPersistence
 * @see SPMailLinkTrackingPersistenceImpl
 * @generated
 */
public class SPMailLinkTrackingUtil {
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
	public static void clearCache(SPMailLinkTracking spMailLinkTracking) {
		getPersistence().clearCache(spMailLinkTracking);
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
	public static List<SPMailLinkTracking> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPMailLinkTracking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPMailLinkTracking> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPMailLinkTracking update(
		SPMailLinkTracking spMailLinkTracking) throws SystemException {
		return getPersistence().update(spMailLinkTracking);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPMailLinkTracking update(
		SPMailLinkTracking spMailLinkTracking, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spMailLinkTracking, serviceContext);
	}

	/**
	* Returns all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @return the matching s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndSubscribersId(spMailCampaignId,
			spMailCampaignSubscribersId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndSubscribersId(spMailCampaignId,
			spMailCampaignSubscribersId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCampaignIdAndSubscribersId(spMailCampaignId,
			spMailCampaignSubscribersId, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking findByCampaignIdAndSubscribersId_First(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException {
		return getPersistence()
				   .findByCampaignIdAndSubscribersId_First(spMailCampaignId,
			spMailCampaignSubscribersId, orderByComparator);
	}

	/**
	* Returns the first s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p mail link tracking, or <code>null</code> if a matching s p mail link tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking fetchByCampaignIdAndSubscribersId_First(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndSubscribersId_First(spMailCampaignId,
			spMailCampaignSubscribersId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking findByCampaignIdAndSubscribersId_Last(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException {
		return getPersistence()
				   .findByCampaignIdAndSubscribersId_Last(spMailCampaignId,
			spMailCampaignSubscribersId, orderByComparator);
	}

	/**
	* Returns the last s p mail link tracking in the ordered set where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p mail link tracking, or <code>null</code> if a matching s p mail link tracking could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking fetchByCampaignIdAndSubscribersId_Last(
		long spMailCampaignId, long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCampaignIdAndSubscribersId_Last(spMailCampaignId,
			spMailCampaignSubscribersId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking[] findByCampaignIdAndSubscribersId_PrevAndNext(
		long spMailLinkTrackingId, long spMailCampaignId,
		long spMailCampaignSubscribersId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException {
		return getPersistence()
				   .findByCampaignIdAndSubscribersId_PrevAndNext(spMailLinkTrackingId,
			spMailCampaignId, spMailCampaignSubscribersId, orderByComparator);
	}

	/**
	* Removes all the s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63; from the database.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCampaignIdAndSubscribersId(
		long spMailCampaignId, long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence()
			.removeByCampaignIdAndSubscribersId(spMailCampaignId,
			spMailCampaignSubscribersId);
	}

	/**
	* Returns the number of s p mail link trackings where spMailCampaignId = &#63; and spMailCampaignSubscribersId = &#63;.
	*
	* @param spMailCampaignId the sp mail campaign ID
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID
	* @return the number of matching s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCampaignIdAndSubscribersId(long spMailCampaignId,
		long spMailCampaignSubscribersId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .countByCampaignIdAndSubscribersId(spMailCampaignId,
			spMailCampaignSubscribersId);
	}

	/**
	* Caches the s p mail link tracking in the entity cache if it is enabled.
	*
	* @param spMailLinkTracking the s p mail link tracking
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking) {
		getPersistence().cacheResult(spMailLinkTracking);
	}

	/**
	* Caches the s p mail link trackings in the entity cache if it is enabled.
	*
	* @param spMailLinkTrackings the s p mail link trackings
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> spMailLinkTrackings) {
		getPersistence().cacheResult(spMailLinkTrackings);
	}

	/**
	* Creates a new s p mail link tracking with the primary key. Does not add the s p mail link tracking to the database.
	*
	* @param spMailLinkTrackingId the primary key for the new s p mail link tracking
	* @return the new s p mail link tracking
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking create(
		long spMailLinkTrackingId) {
		return getPersistence().create(spMailLinkTrackingId);
	}

	/**
	* Removes the s p mail link tracking with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking that was removed
	* @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking remove(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException {
		return getPersistence().remove(spMailLinkTrackingId);
	}

	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking updateImpl(
		com.sambaash.platform.srv.mail.model.SPMailLinkTracking spMailLinkTracking)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spMailLinkTracking);
	}

	/**
	* Returns the s p mail link tracking with the primary key or throws a {@link com.sambaash.platform.srv.mail.NoSuchLinkTrackingException} if it could not be found.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking
	* @throws com.sambaash.platform.srv.mail.NoSuchLinkTrackingException if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking findByPrimaryKey(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.mail.NoSuchLinkTrackingException {
		return getPersistence().findByPrimaryKey(spMailLinkTrackingId);
	}

	/**
	* Returns the s p mail link tracking with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spMailLinkTrackingId the primary key of the s p mail link tracking
	* @return the s p mail link tracking, or <code>null</code> if a s p mail link tracking with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.mail.model.SPMailLinkTracking fetchByPrimaryKey(
		long spMailLinkTrackingId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spMailLinkTrackingId);
	}

	/**
	* Returns all the s p mail link trackings.
	*
	* @return the s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.mail.model.SPMailLinkTracking> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p mail link trackings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p mail link trackings.
	*
	* @return the number of s p mail link trackings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPMailLinkTrackingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPMailLinkTrackingPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.mail.service.ClpSerializer.getServletContextName(),
					SPMailLinkTrackingPersistence.class.getName());

			ReferenceRegistry.registerReference(SPMailLinkTrackingUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPMailLinkTrackingPersistence persistence) {
	}

	private static SPMailLinkTrackingPersistence _persistence;
}