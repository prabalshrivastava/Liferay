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

package com.sambaash.platform.srv.spgroup.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spgroup.model.SPGroup;

/**
 * The persistence interface for the s p group service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPGroupPersistenceImpl
 * @see SPGroupUtil
 * @generated
 */
public interface SPGroupPersistence extends BasePersistence<SPGroup> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPGroupUtil} to access the s p group persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p groups where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p groups where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @return the range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p groups where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the first s p group in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the last s p group in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p groups before and after the current s p group in the ordered set where uuid = &#63;.
	*
	* @param spGroupId the primary key of the current s p group
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup[] findByUuid_PrevAndNext(
		long spGroupId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Removes all the s p groups where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p groups where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchSPGroupException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the s p group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p group where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the number of s p groups where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p groups where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p groups where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @return the range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p groups where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the first s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the last s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p groups before and after the current s p group in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spGroupId the primary key of the current s p group
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup[] findByUuid_C_PrevAndNext(
		long spGroupId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Removes all the s p groups where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p groups where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p groups where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @return the range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p groups where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the first s p group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the last s p group in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p groups before and after the current s p group in the ordered set where userId = &#63;.
	*
	* @param spGroupId the primary key of the current s p group
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup[] findByUserId_PrevAndNext(
		long spGroupId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Removes all the s p groups where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p groups where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p groups where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserIdAndStatus(
		long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p groups where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @return the range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserIdAndStatus(
		long userId, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p groups where userId = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param status the status
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByUserIdAndStatus(
		long userId, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUserIdAndStatus_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the first s p group in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUserIdAndStatus_First(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByUserIdAndStatus_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the last s p group in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByUserIdAndStatus_Last(
		long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p groups before and after the current s p group in the ordered set where userId = &#63; and status = &#63;.
	*
	* @param spGroupId the primary key of the current s p group
	* @param userId the user ID
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup[] findByUserIdAndStatus_PrevAndNext(
		long spGroupId, long userId, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Removes all the s p groups where userId = &#63; and status = &#63; from the database.
	*
	* @param userId the user ID
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserIdAndStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p groups where userId = &#63; and status = &#63;.
	*
	* @param userId the user ID
	* @param status the status
	* @return the number of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndStatus(long userId, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group where groupId = &#63; and urlTitle = &#63; or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchSPGroupException} if it could not be found.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the s p group where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group where groupId = &#63; and urlTitle = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p group where groupId = &#63; and urlTitle = &#63; from the database.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the s p group that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup removeByURLTitleAndGroupId(
		long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the number of s p groups where groupId = &#63; and urlTitle = &#63;.
	*
	* @param groupId the group ID
	* @param urlTitle the url title
	* @return the number of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByURLTitleAndGroupId(long groupId, java.lang.String urlTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p groups where type = &#63; and status = &#63;.
	*
	* @param type the type
	* @param status the status
	* @return the matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByTypeAndStatus(
		int type, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p groups where type = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param status the status
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @return the range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByTypeAndStatus(
		int type, int status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p groups where type = &#63; and status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param type the type
	* @param status the status
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findByTypeAndStatus(
		int type, int status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p group in the ordered set where type = &#63; and status = &#63;.
	*
	* @param type the type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByTypeAndStatus_First(
		int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the first s p group in the ordered set where type = &#63; and status = &#63;.
	*
	* @param type the type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByTypeAndStatus_First(
		int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p group in the ordered set where type = &#63; and status = &#63;.
	*
	* @param type the type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByTypeAndStatus_Last(
		int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the last s p group in the ordered set where type = &#63; and status = &#63;.
	*
	* @param type the type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p group, or <code>null</code> if a matching s p group could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByTypeAndStatus_Last(
		int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p groups before and after the current s p group in the ordered set where type = &#63; and status = &#63;.
	*
	* @param spGroupId the primary key of the current s p group
	* @param type the type
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup[] findByTypeAndStatus_PrevAndNext(
		long spGroupId, int type, int status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Removes all the s p groups where type = &#63; and status = &#63; from the database.
	*
	* @param type the type
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTypeAndStatus(int type, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p groups where type = &#63; and status = &#63;.
	*
	* @param type the type
	* @param status the status
	* @return the number of matching s p groups
	* @throws SystemException if a system exception occurred
	*/
	public int countByTypeAndStatus(int type, int status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p group in the entity cache if it is enabled.
	*
	* @param spGroup the s p group
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup);

	/**
	* Caches the s p groups in the entity cache if it is enabled.
	*
	* @param spGroups the s p groups
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> spGroups);

	/**
	* Creates a new s p group with the primary key. Does not add the s p group to the database.
	*
	* @param spGroupId the primary key for the new s p group
	* @return the new s p group
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup create(
		long spGroupId);

	/**
	* Removes the s p group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spGroupId the primary key of the s p group
	* @return the s p group that was removed
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup remove(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	public com.sambaash.platform.srv.spgroup.model.SPGroup updateImpl(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p group with the primary key or throws a {@link com.sambaash.platform.srv.spgroup.NoSuchSPGroupException} if it could not be found.
	*
	* @param spGroupId the primary key of the s p group
	* @return the s p group
	* @throws com.sambaash.platform.srv.spgroup.NoSuchSPGroupException if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup findByPrimaryKey(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spgroup.NoSuchSPGroupException;

	/**
	* Returns the s p group with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spGroupId the primary key of the s p group
	* @return the s p group, or <code>null</code> if a s p group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spgroup.model.SPGroup fetchByPrimaryKey(
		long spGroupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p groups.
	*
	* @return the s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @return the range of s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spgroup.model.impl.SPGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p groups
	* @param end the upper bound of the range of s p groups (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p groups
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spgroup.model.SPGroup> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p groups from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p groups.
	*
	* @return the number of s p groups
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}