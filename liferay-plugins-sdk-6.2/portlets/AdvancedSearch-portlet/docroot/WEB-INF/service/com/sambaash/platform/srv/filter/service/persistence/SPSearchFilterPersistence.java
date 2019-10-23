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

package com.sambaash.platform.srv.filter.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.filter.model.SPSearchFilter;

/**
 * The persistence interface for the s p search filter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPSearchFilterPersistenceImpl
 * @see SPSearchFilterUtil
 * @generated
 */
public interface SPSearchFilterPersistence extends BasePersistence<SPSearchFilter> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPSearchFilterUtil} to access the s p search filter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p search filters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p search filters where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p search filters
	* @param end the upper bound of the range of s p search filters (not inclusive)
	* @return the range of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p search filters where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p search filters
	* @param end the upper bound of the range of s p search filters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p search filter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Returns the first s p search filter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p search filter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Returns the last s p search filter in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p search filters before and after the current s p search filter in the ordered set where uuid = &#63;.
	*
	* @param spSearchFilterId the primary key of the current s p search filter
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter[] findByUuid_PrevAndNext(
		long spSearchFilterId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Removes all the s p search filters where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p search filters where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p search filter where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Returns the s p search filter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p search filter where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p search filter where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p search filter that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Returns the number of s p search filters where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p search filters where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p search filters where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p search filters
	* @param end the upper bound of the range of s p search filters (not inclusive)
	* @return the range of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p search filters where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p search filters
	* @param end the upper bound of the range of s p search filters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Returns the first s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Returns the last s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p search filters before and after the current s p search filter in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spSearchFilterId the primary key of the current s p search filter
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter[] findByUuid_C_PrevAndNext(
		long spSearchFilterId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Removes all the s p search filters where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p search filters where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p search filters where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findByuserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p search filters where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p search filters
	* @param end the upper bound of the range of s p search filters (not inclusive)
	* @return the range of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findByuserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p search filters where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p search filters
	* @param end the upper bound of the range of s p search filters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findByuserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p search filter in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter findByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Returns the first s p search filter in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter fetchByuserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p search filter in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter findByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Returns the last s p search filter in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p search filter, or <code>null</code> if a matching s p search filter could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter fetchByuserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p search filters before and after the current s p search filter in the ordered set where userId = &#63;.
	*
	* @param spSearchFilterId the primary key of the current s p search filter
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter[] findByuserId_PrevAndNext(
		long spSearchFilterId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Removes all the s p search filters where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p search filters where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public int countByuserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p search filter in the entity cache if it is enabled.
	*
	* @param spSearchFilter the s p search filter
	*/
	public void cacheResult(
		com.sambaash.platform.srv.filter.model.SPSearchFilter spSearchFilter);

	/**
	* Caches the s p search filters in the entity cache if it is enabled.
	*
	* @param spSearchFilters the s p search filters
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> spSearchFilters);

	/**
	* Creates a new s p search filter with the primary key. Does not add the s p search filter to the database.
	*
	* @param spSearchFilterId the primary key for the new s p search filter
	* @return the new s p search filter
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter create(
		long spSearchFilterId);

	/**
	* Removes the s p search filter with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSearchFilterId the primary key of the s p search filter
	* @return the s p search filter that was removed
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter remove(
		long spSearchFilterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	public com.sambaash.platform.srv.filter.model.SPSearchFilter updateImpl(
		com.sambaash.platform.srv.filter.model.SPSearchFilter spSearchFilter)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p search filter with the primary key or throws a {@link com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException} if it could not be found.
	*
	* @param spSearchFilterId the primary key of the s p search filter
	* @return the s p search filter
	* @throws com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException if a s p search filter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter findByPrimaryKey(
		long spSearchFilterId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.filter.NoSuchSPSearchFilterException;

	/**
	* Returns the s p search filter with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spSearchFilterId the primary key of the s p search filter
	* @return the s p search filter, or <code>null</code> if a s p search filter with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.filter.model.SPSearchFilter fetchByPrimaryKey(
		long spSearchFilterId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p search filters.
	*
	* @return the s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p search filters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p search filters
	* @param end the upper bound of the range of s p search filters (not inclusive)
	* @return the range of s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p search filters.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.filter.model.impl.SPSearchFilterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p search filters
	* @param end the upper bound of the range of s p search filters (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.filter.model.SPSearchFilter> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p search filters from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p search filters.
	*
	* @return the number of s p search filters
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}