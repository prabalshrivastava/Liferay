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

import com.sambaash.platform.srv.spservices.model.SPUserTypeConfig;

/**
 * The persistence interface for the s p user type config service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPUserTypeConfigPersistenceImpl
 * @see SPUserTypeConfigUtil
 * @generated
 */
public interface SPUserTypeConfigPersistence extends BasePersistence<SPUserTypeConfig> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPUserTypeConfigUtil} to access the s p user type config persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p user type configs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user type configs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @return the range of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user type configs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p user type config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the first s p user type config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p user type config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the last s p user type config in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type configs before and after the current s p user type config in the ordered set where uuid = &#63;.
	*
	* @param spUserTypeConfigId the primary key of the current s p user type config
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig[] findByUuid_PrevAndNext(
		long spUserTypeConfigId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Removes all the s p user type configs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user type configs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type config where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the s p user type config where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type config where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p user type config where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p user type config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the number of s p user type configs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p user type configs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user type configs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @return the range of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user type configs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the first s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the last s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type configs before and after the current s p user type config in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spUserTypeConfigId the primary key of the current s p user type config
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig[] findByUuid_C_PrevAndNext(
		long spUserTypeConfigId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Removes all the s p user type configs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user type configs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type config where userType = &#63; and virtualHostId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException} if it could not be found.
	*
	* @param userType the user type
	* @param virtualHostId the virtual host ID
	* @return the matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUserTypeAndVirtualHostId(
		java.lang.String userType, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the s p user type config where userType = &#63; and virtualHostId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userType the user type
	* @param virtualHostId the virtual host ID
	* @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUserTypeAndVirtualHostId(
		java.lang.String userType, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type config where userType = &#63; and virtualHostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userType the user type
	* @param virtualHostId the virtual host ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUserTypeAndVirtualHostId(
		java.lang.String userType, long virtualHostId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p user type config where userType = &#63; and virtualHostId = &#63; from the database.
	*
	* @param userType the user type
	* @param virtualHostId the virtual host ID
	* @return the s p user type config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig removeByUserTypeAndVirtualHostId(
		java.lang.String userType, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the number of s p user type configs where userType = &#63; and virtualHostId = &#63;.
	*
	* @param userType the user type
	* @param virtualHostId the virtual host ID
	* @return the number of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserTypeAndVirtualHostId(java.lang.String userType,
		long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type config where userTypeId = &#63; and virtualHostId = &#63; or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException} if it could not be found.
	*
	* @param userTypeId the user type ID
	* @param virtualHostId the virtual host ID
	* @return the matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUserTypeIdAndVirtualHostId(
		long userTypeId, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the s p user type config where userTypeId = &#63; and virtualHostId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userTypeId the user type ID
	* @param virtualHostId the virtual host ID
	* @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUserTypeIdAndVirtualHostId(
		long userTypeId, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type config where userTypeId = &#63; and virtualHostId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userTypeId the user type ID
	* @param virtualHostId the virtual host ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUserTypeIdAndVirtualHostId(
		long userTypeId, long virtualHostId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p user type config where userTypeId = &#63; and virtualHostId = &#63; from the database.
	*
	* @param userTypeId the user type ID
	* @param virtualHostId the virtual host ID
	* @return the s p user type config that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig removeByUserTypeIdAndVirtualHostId(
		long userTypeId, long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the number of s p user type configs where userTypeId = &#63; and virtualHostId = &#63;.
	*
	* @param userTypeId the user type ID
	* @param virtualHostId the virtual host ID
	* @return the number of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserTypeIdAndVirtualHostId(long userTypeId,
		long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p user type configs where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @return the matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByVirtualHostId(
		long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user type configs where virtualHostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param virtualHostId the virtual host ID
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @return the range of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByVirtualHostId(
		long virtualHostId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user type configs where virtualHostId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param virtualHostId the virtual host ID
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByVirtualHostId(
		long virtualHostId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p user type config in the ordered set where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByVirtualHostId_First(
		long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the first s p user type config in the ordered set where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByVirtualHostId_First(
		long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p user type config in the ordered set where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByVirtualHostId_Last(
		long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the last s p user type config in the ordered set where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByVirtualHostId_Last(
		long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type configs before and after the current s p user type config in the ordered set where virtualHostId = &#63;.
	*
	* @param spUserTypeConfigId the primary key of the current s p user type config
	* @param virtualHostId the virtual host ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig[] findByVirtualHostId_PrevAndNext(
		long spUserTypeConfigId, long virtualHostId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Removes all the s p user type configs where virtualHostId = &#63; from the database.
	*
	* @param virtualHostId the virtual host ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByVirtualHostId(long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user type configs where virtualHostId = &#63;.
	*
	* @param virtualHostId the virtual host ID
	* @return the number of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByVirtualHostId(long virtualHostId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p user type configs where userTypeId = &#63;.
	*
	* @param userTypeId the user type ID
	* @return the matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUserTypeId(
		long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user type configs where userTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userTypeId the user type ID
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @return the range of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUserTypeId(
		long userTypeId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user type configs where userTypeId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userTypeId the user type ID
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findByUserTypeId(
		long userTypeId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p user type config in the ordered set where userTypeId = &#63;.
	*
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUserTypeId_First(
		long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the first s p user type config in the ordered set where userTypeId = &#63;.
	*
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUserTypeId_First(
		long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p user type config in the ordered set where userTypeId = &#63;.
	*
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByUserTypeId_Last(
		long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the last s p user type config in the ordered set where userTypeId = &#63;.
	*
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p user type config, or <code>null</code> if a matching s p user type config could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByUserTypeId_Last(
		long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type configs before and after the current s p user type config in the ordered set where userTypeId = &#63;.
	*
	* @param spUserTypeConfigId the primary key of the current s p user type config
	* @param userTypeId the user type ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig[] findByUserTypeId_PrevAndNext(
		long spUserTypeConfigId, long userTypeId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Removes all the s p user type configs where userTypeId = &#63; from the database.
	*
	* @param userTypeId the user type ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUserTypeId(long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user type configs where userTypeId = &#63;.
	*
	* @param userTypeId the user type ID
	* @return the number of matching s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserTypeId(long userTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p user type config in the entity cache if it is enabled.
	*
	* @param spUserTypeConfig the s p user type config
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spservices.model.SPUserTypeConfig spUserTypeConfig);

	/**
	* Caches the s p user type configs in the entity cache if it is enabled.
	*
	* @param spUserTypeConfigs the s p user type configs
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> spUserTypeConfigs);

	/**
	* Creates a new s p user type config with the primary key. Does not add the s p user type config to the database.
	*
	* @param spUserTypeConfigId the primary key for the new s p user type config
	* @return the new s p user type config
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig create(
		long spUserTypeConfigId);

	/**
	* Removes the s p user type config with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spUserTypeConfigId the primary key of the s p user type config
	* @return the s p user type config that was removed
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig remove(
		long spUserTypeConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig updateImpl(
		com.sambaash.platform.srv.spservices.model.SPUserTypeConfig spUserTypeConfig)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p user type config with the primary key or throws a {@link com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException} if it could not be found.
	*
	* @param spUserTypeConfigId the primary key of the s p user type config
	* @return the s p user type config
	* @throws com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException if a s p user type config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig findByPrimaryKey(
		long spUserTypeConfigId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spservices.NoSuchSPUserTypeConfigException;

	/**
	* Returns the s p user type config with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spUserTypeConfigId the primary key of the s p user type config
	* @return the s p user type config, or <code>null</code> if a s p user type config with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig fetchByPrimaryKey(
		long spUserTypeConfigId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p user type configs.
	*
	* @return the s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p user type configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @return the range of s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p user type configs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.SPUserTypeConfigModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p user type configs
	* @param end the upper bound of the range of s p user type configs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p user type configs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p user type configs.
	*
	* @return the number of s p user type configs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}