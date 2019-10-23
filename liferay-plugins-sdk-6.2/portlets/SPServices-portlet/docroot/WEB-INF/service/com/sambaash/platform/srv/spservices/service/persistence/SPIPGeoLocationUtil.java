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

import com.sambaash.platform.srv.spservices.model.SPIPGeoLocation;

import java.util.List;

/**
 * The persistence utility for the s p i p geo location service. This utility wraps {@link SPIPGeoLocationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPIPGeoLocationPersistence
 * @see SPIPGeoLocationPersistenceImpl
 * @generated
 */
public class SPIPGeoLocationUtil {
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
	public static void clearCache(SPIPGeoLocation spipGeoLocation) {
		getPersistence().clearCache(spipGeoLocation);
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
	public static List<SPIPGeoLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPIPGeoLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPIPGeoLocation> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPIPGeoLocation update(SPIPGeoLocation spipGeoLocation)
		throws SystemException {
		return getPersistence().update(spipGeoLocation);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPIPGeoLocation update(SPIPGeoLocation spipGeoLocation,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spipGeoLocation, serviceContext);
	}

	/**
	* Returns all the s p i p geo locations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the s p i p geo locations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p i p geo locations
	* @param end the upper bound of the range of s p i p geo locations (not inclusive)
	* @return the range of matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the s p i p geo locations where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p i p geo locations
	* @param end the upper bound of the range of s p i p geo locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first s p i p geo location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first s p i p geo location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p i p geo location, or <code>null</code> if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last s p i p geo location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last s p i p geo location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p i p geo location, or <code>null</code> if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the s p i p geo locations before and after the current s p i p geo location in the ordered set where uuid = &#63;.
	*
	* @param spIPGeoLocationId the primary key of the current s p i p geo location
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a s p i p geo location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation[] findByUuid_PrevAndNext(
		long spIPGeoLocationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spIPGeoLocationId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the s p i p geo locations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of s p i p geo locations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns all the s p i p geo locations where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @return the matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByipPrefixLike(
		java.lang.String ipPrefix)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByipPrefixLike(ipPrefix);
	}

	/**
	* Returns a range of all the s p i p geo locations where ipPrefix LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ipPrefix the ip prefix
	* @param start the lower bound of the range of s p i p geo locations
	* @param end the upper bound of the range of s p i p geo locations (not inclusive)
	* @return the range of matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByipPrefixLike(
		java.lang.String ipPrefix, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByipPrefixLike(ipPrefix, start, end);
	}

	/**
	* Returns an ordered range of all the s p i p geo locations where ipPrefix LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param ipPrefix the ip prefix
	* @param start the lower bound of the range of s p i p geo locations
	* @param end the upper bound of the range of s p i p geo locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByipPrefixLike(
		java.lang.String ipPrefix, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByipPrefixLike(ipPrefix, start, end, orderByComparator);
	}

	/**
	* Returns the first s p i p geo location in the ordered set where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByipPrefixLike_First(
		java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException {
		return getPersistence()
				   .findByipPrefixLike_First(ipPrefix, orderByComparator);
	}

	/**
	* Returns the first s p i p geo location in the ordered set where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p i p geo location, or <code>null</code> if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByipPrefixLike_First(
		java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByipPrefixLike_First(ipPrefix, orderByComparator);
	}

	/**
	* Returns the last s p i p geo location in the ordered set where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByipPrefixLike_Last(
		java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException {
		return getPersistence()
				   .findByipPrefixLike_Last(ipPrefix, orderByComparator);
	}

	/**
	* Returns the last s p i p geo location in the ordered set where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p i p geo location, or <code>null</code> if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByipPrefixLike_Last(
		java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByipPrefixLike_Last(ipPrefix, orderByComparator);
	}

	/**
	* Returns the s p i p geo locations before and after the current s p i p geo location in the ordered set where ipPrefix LIKE &#63;.
	*
	* @param spIPGeoLocationId the primary key of the current s p i p geo location
	* @param ipPrefix the ip prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a s p i p geo location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation[] findByipPrefixLike_PrevAndNext(
		long spIPGeoLocationId, java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException {
		return getPersistence()
				   .findByipPrefixLike_PrevAndNext(spIPGeoLocationId, ipPrefix,
			orderByComparator);
	}

	/**
	* Removes all the s p i p geo locations where ipPrefix LIKE &#63; from the database.
	*
	* @param ipPrefix the ip prefix
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByipPrefixLike(java.lang.String ipPrefix)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByipPrefixLike(ipPrefix);
	}

	/**
	* Returns the number of s p i p geo locations where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @return the number of matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByipPrefixLike(java.lang.String ipPrefix)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByipPrefixLike(ipPrefix);
	}

	/**
	* Caches the s p i p geo location in the entity cache if it is enabled.
	*
	* @param spipGeoLocation the s p i p geo location
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPIPGeoLocation spipGeoLocation) {
		getPersistence().cacheResult(spipGeoLocation);
	}

	/**
	* Caches the s p i p geo locations in the entity cache if it is enabled.
	*
	* @param spipGeoLocations the s p i p geo locations
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> spipGeoLocations) {
		getPersistence().cacheResult(spipGeoLocations);
	}

	/**
	* Creates a new s p i p geo location with the primary key. Does not add the s p i p geo location to the database.
	*
	* @param spIPGeoLocationId the primary key for the new s p i p geo location
	* @return the new s p i p geo location
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation create(
		long spIPGeoLocationId) {
		return getPersistence().create(spIPGeoLocationId);
	}

	/**
	* Removes the s p i p geo location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spIPGeoLocationId the primary key of the s p i p geo location
	* @return the s p i p geo location that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a s p i p geo location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation remove(
		long spIPGeoLocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException {
		return getPersistence().remove(spIPGeoLocationId);
	}

	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation updateImpl(
		com.sambaash.platform.srv.spservices.model.SPIPGeoLocation spipGeoLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spipGeoLocation);
	}

	/**
	* Returns the s p i p geo location with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException} if it could not be found.
	*
	* @param spIPGeoLocationId the primary key of the s p i p geo location
	* @return the s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a s p i p geo location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByPrimaryKey(
		long spIPGeoLocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException {
		return getPersistence().findByPrimaryKey(spIPGeoLocationId);
	}

	/**
	* Returns the s p i p geo location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spIPGeoLocationId the primary key of the s p i p geo location
	* @return the s p i p geo location, or <code>null</code> if a s p i p geo location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByPrimaryKey(
		long spIPGeoLocationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spIPGeoLocationId);
	}

	/**
	* Returns all the s p i p geo locations.
	*
	* @return the s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p i p geo locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p i p geo locations
	* @param end the upper bound of the range of s p i p geo locations (not inclusive)
	* @return the range of s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p i p geo locations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p i p geo locations
	* @param end the upper bound of the range of s p i p geo locations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p i p geo locations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p i p geo locations.
	*
	* @return the number of s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPIPGeoLocationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPIPGeoLocationPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spservices.service.ClpSerializer.getServletContextName(),
					SPIPGeoLocationPersistence.class.getName());

			ReferenceRegistry.registerReference(SPIPGeoLocationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPIPGeoLocationPersistence persistence) {
	}

	private static SPIPGeoLocationPersistence _persistence;
}