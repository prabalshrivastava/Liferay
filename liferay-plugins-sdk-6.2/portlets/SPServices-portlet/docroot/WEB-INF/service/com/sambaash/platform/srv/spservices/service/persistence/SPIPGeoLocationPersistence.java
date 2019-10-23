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

import com.sambaash.platform.srv.spservices.model.SPIPGeoLocation;

/**
 * The persistence interface for the s p i p geo location service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPIPGeoLocationPersistenceImpl
 * @see SPIPGeoLocationUtil
 * @generated
 */
public interface SPIPGeoLocationPersistence extends BasePersistence<SPIPGeoLocation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPIPGeoLocationUtil} to access the s p i p geo location persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p i p geo locations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p i p geo location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException;

	/**
	* Returns the first s p i p geo location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p i p geo location, or <code>null</code> if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p i p geo location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException;

	/**
	* Returns the last s p i p geo location in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p i p geo location, or <code>null</code> if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation[] findByUuid_PrevAndNext(
		long spIPGeoLocationId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException;

	/**
	* Removes all the s p i p geo locations where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p i p geo locations where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p i p geo locations where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @return the matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByipPrefixLike(
		java.lang.String ipPrefix)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByipPrefixLike(
		java.lang.String ipPrefix, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findByipPrefixLike(
		java.lang.String ipPrefix, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p i p geo location in the ordered set where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByipPrefixLike_First(
		java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException;

	/**
	* Returns the first s p i p geo location in the ordered set where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p i p geo location, or <code>null</code> if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByipPrefixLike_First(
		java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p i p geo location in the ordered set where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByipPrefixLike_Last(
		java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException;

	/**
	* Returns the last s p i p geo location in the ordered set where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p i p geo location, or <code>null</code> if a matching s p i p geo location could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByipPrefixLike_Last(
		java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation[] findByipPrefixLike_PrevAndNext(
		long spIPGeoLocationId, java.lang.String ipPrefix,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException;

	/**
	* Removes all the s p i p geo locations where ipPrefix LIKE &#63; from the database.
	*
	* @param ipPrefix the ip prefix
	* @throws SystemException if a system exception occurred
	*/
	public void removeByipPrefixLike(java.lang.String ipPrefix)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p i p geo locations where ipPrefix LIKE &#63;.
	*
	* @param ipPrefix the ip prefix
	* @return the number of matching s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public int countByipPrefixLike(java.lang.String ipPrefix)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p i p geo location in the entity cache if it is enabled.
	*
	* @param spipGeoLocation the s p i p geo location
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPIPGeoLocation spipGeoLocation);

	/**
	* Caches the s p i p geo locations in the entity cache if it is enabled.
	*
	* @param spipGeoLocations the s p i p geo locations
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> spipGeoLocations);

	/**
	* Creates a new s p i p geo location with the primary key. Does not add the s p i p geo location to the database.
	*
	* @param spIPGeoLocationId the primary key for the new s p i p geo location
	* @return the new s p i p geo location
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation create(
		long spIPGeoLocationId);

	/**
	* Removes the s p i p geo location with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spIPGeoLocationId the primary key of the s p i p geo location
	* @return the s p i p geo location that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a s p i p geo location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation remove(
		long spIPGeoLocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException;

	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation updateImpl(
		com.sambaash.platform.srv.spservices.model.SPIPGeoLocation spipGeoLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p i p geo location with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException} if it could not be found.
	*
	* @param spIPGeoLocationId the primary key of the s p i p geo location
	* @return the s p i p geo location
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException if a s p i p geo location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation findByPrimaryKey(
		long spIPGeoLocationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPIPGeoLocationException;

	/**
	* Returns the s p i p geo location with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spIPGeoLocationId the primary key of the s p i p geo location
	* @return the s p i p geo location, or <code>null</code> if a s p i p geo location with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation fetchByPrimaryKey(
		long spIPGeoLocationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p i p geo locations.
	*
	* @return the s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p i p geo locations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p i p geo locations.
	*
	* @return the number of s p i p geo locations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}