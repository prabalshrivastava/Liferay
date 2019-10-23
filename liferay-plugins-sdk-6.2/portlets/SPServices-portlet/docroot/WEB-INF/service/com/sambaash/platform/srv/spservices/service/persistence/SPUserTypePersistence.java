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

import com.sambaash.platform.srv.spservices.model.SPUserType;

/**
 * The persistence interface for the s p user type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPUserTypePersistenceImpl
 * @see SPUserTypeUtil
 * @generated
 */
public interface SPUserTypePersistence extends BasePersistence<SPUserType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPUserTypeUtil} to access the s p user type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p user types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @return the range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user types where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p user type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the first s p user type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p user type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the last s p user type in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user types before and after the current s p user type in the ordered set where uuid = &#63;.
	*
	* @param spUserTypeId the primary key of the current s p user type
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType[] findByUuid_PrevAndNext(
		long spUserTypeId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Removes all the s p user types where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user types where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the s p user type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p user type where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p user type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the number of s p user types where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p user types where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user types where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @return the range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user types where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the first s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the last s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user types before and after the current s p user type in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spUserTypeId the primary key of the current s p user type
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType[] findByUuid_C_PrevAndNext(
		long spUserTypeId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Removes all the s p user types where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user types where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p user types where spSiteId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @return the matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteId(
		long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user types where spSiteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spSiteId the sp site ID
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @return the range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteId(
		long spSiteId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user types where spSiteId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spSiteId the sp site ID
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteId(
		long spSiteId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p user type in the ordered set where spSiteId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findBySpSiteId_First(
		long spSiteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the first s p user type in the ordered set where spSiteId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchBySpSiteId_First(
		long spSiteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p user type in the ordered set where spSiteId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findBySpSiteId_Last(
		long spSiteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the last s p user type in the ordered set where spSiteId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchBySpSiteId_Last(
		long spSiteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user types before and after the current s p user type in the ordered set where spSiteId = &#63;.
	*
	* @param spUserTypeId the primary key of the current s p user type
	* @param spSiteId the sp site ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType[] findBySpSiteId_PrevAndNext(
		long spUserTypeId, long spSiteId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Removes all the s p user types where spSiteId = &#63; from the database.
	*
	* @param spSiteId the sp site ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySpSiteId(long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user types where spSiteId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @return the number of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public int countBySpSiteId(long spSiteId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type where spSiteId = &#63; and userId = &#63; and userTypeId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException} if it could not be found.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param userTypeId the user type ID
	* @return the matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findBySpSiteIdAndUserIdAndUserTypeId(
		long spSiteId, long userId, long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the s p user type where spSiteId = &#63; and userId = &#63; and userTypeId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param userTypeId the user type ID
	* @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchBySpSiteIdAndUserIdAndUserTypeId(
		long spSiteId, long userId, long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type where spSiteId = &#63; and userId = &#63; and userTypeId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param userTypeId the user type ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchBySpSiteIdAndUserIdAndUserTypeId(
		long spSiteId, long userId, long userTypeId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p user type where spSiteId = &#63; and userId = &#63; and userTypeId = &#63; from the database.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param userTypeId the user type ID
	* @return the s p user type that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType removeBySpSiteIdAndUserIdAndUserTypeId(
		long spSiteId, long userId, long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the number of s p user types where spSiteId = &#63; and userId = &#63; and userTypeId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param userTypeId the user type ID
	* @return the number of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public int countBySpSiteIdAndUserIdAndUserTypeId(long spSiteId,
		long userId, long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p user types where spSiteId = &#63; and userId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @return the matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserId(
		long spSiteId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user types where spSiteId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @return the range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserId(
		long spSiteId, long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user types where spSiteId = &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserId(
		long spSiteId, long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findBySpSiteIdAndUserId_First(
		long spSiteId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the first s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchBySpSiteIdAndUserId_First(
		long spSiteId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findBySpSiteIdAndUserId_Last(
		long spSiteId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the last s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchBySpSiteIdAndUserId_Last(
		long spSiteId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user types before and after the current s p user type in the ordered set where spSiteId = &#63; and userId = &#63;.
	*
	* @param spUserTypeId the primary key of the current s p user type
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType[] findBySpSiteIdAndUserId_PrevAndNext(
		long spUserTypeId, long spSiteId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Removes all the s p user types where spSiteId = &#63; and userId = &#63; from the database.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySpSiteIdAndUserId(long spSiteId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user types where spSiteId = &#63; and userId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userId the user ID
	* @return the number of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public int countBySpSiteIdAndUserId(long spSiteId, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p user types where spSiteId = &#63; and userTypeId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @return the matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserTypeId(
		long spSiteId, long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user types where spSiteId = &#63; and userTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @return the range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserTypeId(
		long spSiteId, long userTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user types where spSiteId = &#63; and userTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findBySpSiteIdAndUserTypeId(
		long spSiteId, long userTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findBySpSiteIdAndUserTypeId_First(
		long spSiteId, long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the first s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchBySpSiteIdAndUserTypeId_First(
		long spSiteId, long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findBySpSiteIdAndUserTypeId_Last(
		long spSiteId, long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the last s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type, or <code>null</code> if a matching s p user type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchBySpSiteIdAndUserTypeId_Last(
		long spSiteId, long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user types before and after the current s p user type in the ordered set where spSiteId = &#63; and userTypeId = &#63;.
	*
	* @param spUserTypeId the primary key of the current s p user type
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType[] findBySpSiteIdAndUserTypeId_PrevAndNext(
		long spUserTypeId, long spSiteId, long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Removes all the s p user types where spSiteId = &#63; and userTypeId = &#63; from the database.
	*
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeBySpSiteIdAndUserTypeId(long spSiteId, long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user types where spSiteId = &#63; and userTypeId = &#63;.
	*
	* @param spSiteId the sp site ID
	* @param userTypeId the user type ID
	* @return the number of matching s p user types
	* @throws SystemException if a system exception occurred
	*/
	public int countBySpSiteIdAndUserTypeId(long spSiteId, long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p user type in the entity cache if it is enabled.
	*
	* @param spUserType the s p user type
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType);

	/**
	* Caches the s p user types in the entity cache if it is enabled.
	*
	* @param spUserTypes the s p user types
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> spUserTypes);

	/**
	* Creates a new s p user type with the primary key. Does not add the s p user type to the database.
	*
	* @param spUserTypeId the primary key for the new s p user type
	* @return the new s p user type
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType create(
		long spUserTypeId);

	/**
	* Removes the s p user type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserTypeId the primary key of the s p user type
	* @return the s p user type that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType remove(
		long spUserTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	public com.sambaash.platform.srv.spservices.model.SPUserType updateImpl(
		com.sambaash.platform.srv.spservices.model.SPUserType spUserType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException} if it could not be found.
	*
	* @param spUserTypeId the primary key of the s p user type
	* @return the s p user type
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType findByPrimaryKey(
		long spUserTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeException;

	/**
	* Returns the s p user type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spUserTypeId the primary key of the s p user type
	* @return the s p user type, or <code>null</code> if a s p user type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserType fetchByPrimaryKey(
		long spUserTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p user types.
	*
	* @return the s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @return the range of s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p user types
	* @param end the upper bound of the range of s p user types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p user types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p user types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user types.
	*
	* @return the number of s p user types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}