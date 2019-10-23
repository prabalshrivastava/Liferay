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

import com.sambaash.platform.srv.spservices.model.SPListType;

/**
 * The persistence interface for the s p list type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPListTypePersistenceImpl
 * @see SPListTypeUtil
 * @generated
 */
public interface SPListTypePersistence extends BasePersistence<SPListType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPListTypeUtil} to access the s p list type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p list types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p list types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @return the range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p list types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p list type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the first s p list type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p list type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the last s p list type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p list types before and after the current s p list type in the ordered set where uuid = &#63;.
	*
	* @param spListTypeId the primary key of the current s p list type
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType[] findByUuid_PrevAndNext(
		long spListTypeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Removes all the s p list types where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p list types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p list type where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPListTypeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the s p list type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p list type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p list type where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p list type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the number of s p list types where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p list types where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p list types where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @return the range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p list types where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the first s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the last s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p list types before and after the current s p list type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spListTypeId the primary key of the current s p list type
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType[] findByUuid_C_PrevAndNext(
		long spListTypeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Removes all the s p list types where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p list types where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p list types where itemKey = &#63; and groupId = &#63;.
	*
	* @param itemKey the item key
	* @param groupId the group ID
	* @return the matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByItemKeys(
		java.lang.String itemKey, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p list types where itemKey = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemKey the item key
	* @param groupId the group ID
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @return the range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByItemKeys(
		java.lang.String itemKey, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p list types where itemKey = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemKey the item key
	* @param groupId the group ID
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByItemKeys(
		java.lang.String itemKey, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	*
	* @param itemKey the item key
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByItemKeys_First(
		java.lang.String itemKey, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the first s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	*
	* @param itemKey the item key
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByItemKeys_First(
		java.lang.String itemKey, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	*
	* @param itemKey the item key
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByItemKeys_Last(
		java.lang.String itemKey, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the last s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	*
	* @param itemKey the item key
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByItemKeys_Last(
		java.lang.String itemKey, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p list types before and after the current s p list type in the ordered set where itemKey = &#63; and groupId = &#63;.
	*
	* @param spListTypeId the primary key of the current s p list type
	* @param itemKey the item key
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType[] findByItemKeys_PrevAndNext(
		long spListTypeId, java.lang.String itemKey, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Removes all the s p list types where itemKey = &#63; and groupId = &#63; from the database.
	*
	* @param itemKey the item key
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemKeys(java.lang.String itemKey, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p list types where itemKey = &#63; and groupId = &#63;.
	*
	* @param itemKey the item key
	* @param groupId the group ID
	* @return the number of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemKeys(java.lang.String itemKey, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p list types where itemValue = &#63; and groupId = &#63;.
	*
	* @param itemValue the item value
	* @param groupId the group ID
	* @return the matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByItemValues(
		java.lang.String itemValue, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p list types where itemValue = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemValue the item value
	* @param groupId the group ID
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @return the range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByItemValues(
		java.lang.String itemValue, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p list types where itemValue = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param itemValue the item value
	* @param groupId the group ID
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByItemValues(
		java.lang.String itemValue, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	*
	* @param itemValue the item value
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByItemValues_First(
		java.lang.String itemValue, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the first s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	*
	* @param itemValue the item value
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByItemValues_First(
		java.lang.String itemValue, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	*
	* @param itemValue the item value
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByItemValues_Last(
		java.lang.String itemValue, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the last s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	*
	* @param itemValue the item value
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByItemValues_Last(
		java.lang.String itemValue, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p list types before and after the current s p list type in the ordered set where itemValue = &#63; and groupId = &#63;.
	*
	* @param spListTypeId the primary key of the current s p list type
	* @param itemValue the item value
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType[] findByItemValues_PrevAndNext(
		long spListTypeId, java.lang.String itemValue, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Removes all the s p list types where itemValue = &#63; and groupId = &#63; from the database.
	*
	* @param itemValue the item value
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByItemValues(java.lang.String itemValue, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p list types where itemValue = &#63; and groupId = &#63;.
	*
	* @param itemValue the item value
	* @param groupId the group ID
	* @return the number of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public int countByItemValues(java.lang.String itemValue, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p list types where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByCategoryIdGroupId(
		long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p list types where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @return the range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByCategoryIdGroupId(
		long groupId, long categoryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p list types where groupId = &#63; and categoryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findByCategoryIdGroupId(
		long groupId, long categoryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByCategoryIdGroupId_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the first s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByCategoryIdGroupId_First(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByCategoryIdGroupId_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the last s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p list type, or <code>null</code> if a matching s p list type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByCategoryIdGroupId_Last(
		long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p list types before and after the current s p list type in the ordered set where groupId = &#63; and categoryId = &#63;.
	*
	* @param spListTypeId the primary key of the current s p list type
	* @param groupId the group ID
	* @param categoryId the category ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType[] findByCategoryIdGroupId_PrevAndNext(
		long spListTypeId, long groupId, long categoryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Removes all the s p list types where groupId = &#63; and categoryId = &#63; from the database.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCategoryIdGroupId(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p list types where groupId = &#63; and categoryId = &#63;.
	*
	* @param groupId the group ID
	* @param categoryId the category ID
	* @return the number of matching s p list types
	* @throws SystemException if a system exception occurred
	*/
	public int countByCategoryIdGroupId(long groupId, long categoryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p list type in the entity cache if it is enabled.
	*
	* @param spListType the s p list type
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPListType spListType);

	/**
	* Caches the s p list types in the entity cache if it is enabled.
	*
	* @param spListTypes the s p list types
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> spListTypes);

	/**
	* Creates a new s p list type with the primary key. Does not add the s p list type to the database.
	*
	* @param spListTypeId the primary key for the new s p list type
	* @return the new s p list type
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType create(
		long spListTypeId);

	/**
	* Removes the s p list type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spListTypeId the primary key of the s p list type
	* @return the s p list type that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType remove(
		long spListTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	public com.sambaash.platform.srv.spservices.model.SPListType updateImpl(
		com.sambaash.platform.srv.spservices.model.SPListType spListType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p list type with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPListTypeException} if it could not be found.
	*
	* @param spListTypeId the primary key of the s p list type
	* @return the s p list type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPListTypeException if a s p list type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType findByPrimaryKey(
		long spListTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPListTypeException;

	/**
	* Returns the s p list type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spListTypeId the primary key of the s p list type
	* @return the s p list type, or <code>null</code> if a s p list type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPListType fetchByPrimaryKey(
		long spListTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p list types.
	*
	* @return the s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p list types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @return the range of s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p list types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPListTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p list types
	* @param end the upper bound of the range of s p list types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p list types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPListType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p list types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p list types.
	*
	* @return the number of s p list types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}