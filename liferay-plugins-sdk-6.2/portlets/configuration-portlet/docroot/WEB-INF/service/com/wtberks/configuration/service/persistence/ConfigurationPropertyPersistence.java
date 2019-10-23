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

package com.wtberks.configuration.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.wtberks.configuration.model.ConfigurationProperty;

/**
 * The persistence interface for the configuration property service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author liferay
 * @see ConfigurationPropertyPersistenceImpl
 * @see ConfigurationPropertyUtil
 * @generated
 */
public interface ConfigurationPropertyPersistence extends BasePersistence<ConfigurationProperty> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ConfigurationPropertyUtil} to access the configuration property persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the configuration properties where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configuration properties where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of configuration properties
	* @param end the upper bound of the range of configuration properties (not inclusive)
	* @return the range of matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configuration properties where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of configuration properties
	* @param end the upper bound of the range of configuration properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first configuration property in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the first configuration property in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last configuration property in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the last configuration property in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration properties before and after the current configuration property in the ordered set where uuid = &#63;.
	*
	* @param configurationPropertyId the primary key of the current configuration property
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty[] findByUuid_PrevAndNext(
		long configurationPropertyId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Removes all the configuration properties where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configuration properties where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration property where uuid = &#63; and groupId = &#63; or throws a {@link com.wtberks.configuration.NoSuchConfigurationPropertyException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the configuration property where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration property where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the configuration property where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the configuration property that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the number of configuration properties where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the configuration properties where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configuration properties where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of configuration properties
	* @param end the upper bound of the range of configuration properties (not inclusive)
	* @return the range of matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configuration properties where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of configuration properties
	* @param end the upper bound of the range of configuration properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the first configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the last configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration properties before and after the current configuration property in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param configurationPropertyId the primary key of the current configuration property
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty[] findByUuid_C_PrevAndNext(
		long configurationPropertyId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Removes all the configuration properties where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configuration properties where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration property where companyId = &#63; and groupId = &#63; and key = &#63; or throws a {@link com.wtberks.configuration.NoSuchConfigurationPropertyException} if it could not be found.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @return the matching configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty findByKey(
		long companyId, long groupId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the configuration property where companyId = &#63; and groupId = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByKey(
		long companyId, long groupId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration property where companyId = &#63; and groupId = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByKey(
		long companyId, long groupId, java.lang.String key,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the configuration property where companyId = &#63; and groupId = &#63; and key = &#63; from the database.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @return the configuration property that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty removeByKey(
		long companyId, long groupId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the number of configuration properties where companyId = &#63; and groupId = &#63; and key = &#63;.
	*
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @return the number of matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByKey(long companyId, long groupId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration property where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63; or throws a {@link com.wtberks.configuration.NoSuchConfigurationPropertyException} if it could not be found.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @return the matching configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty findByUserIdAndKey(
		long userId, long companyId, long groupId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the configuration property where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByUserIdAndKey(
		long userId, long companyId, long groupId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration property where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching configuration property, or <code>null</code> if a matching configuration property could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByUserIdAndKey(
		long userId, long companyId, long groupId, java.lang.String key,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the configuration property where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63; from the database.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @return the configuration property that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty removeByUserIdAndKey(
		long userId, long companyId, long groupId, java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the number of configuration properties where userId = &#63; and companyId = &#63; and groupId = &#63; and key = &#63;.
	*
	* @param userId the user ID
	* @param companyId the company ID
	* @param groupId the group ID
	* @param key the key
	* @return the number of matching configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public int countByUserIdAndKey(long userId, long companyId, long groupId,
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the configuration property in the entity cache if it is enabled.
	*
	* @param configurationProperty the configuration property
	*/
	public void cacheResult(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty);

	/**
	* Caches the configuration properties in the entity cache if it is enabled.
	*
	* @param configurationProperties the configuration properties
	*/
	public void cacheResult(
		java.util.List<com.wtberks.configuration.model.ConfigurationProperty> configurationProperties);

	/**
	* Creates a new configuration property with the primary key. Does not add the configuration property to the database.
	*
	* @param configurationPropertyId the primary key for the new configuration property
	* @return the new configuration property
	*/
	public com.wtberks.configuration.model.ConfigurationProperty create(
		long configurationPropertyId);

	/**
	* Removes the configuration property with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param configurationPropertyId the primary key of the configuration property
	* @return the configuration property that was removed
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty remove(
		long configurationPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	public com.wtberks.configuration.model.ConfigurationProperty updateImpl(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the configuration property with the primary key or throws a {@link com.wtberks.configuration.NoSuchConfigurationPropertyException} if it could not be found.
	*
	* @param configurationPropertyId the primary key of the configuration property
	* @return the configuration property
	* @throws com.wtberks.configuration.NoSuchConfigurationPropertyException if a configuration property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty findByPrimaryKey(
		long configurationPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.wtberks.configuration.NoSuchConfigurationPropertyException;

	/**
	* Returns the configuration property with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param configurationPropertyId the primary key of the configuration property
	* @return the configuration property, or <code>null</code> if a configuration property with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.wtberks.configuration.model.ConfigurationProperty fetchByPrimaryKey(
		long configurationPropertyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the configuration properties.
	*
	* @return the configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the configuration properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of configuration properties
	* @param end the upper bound of the range of configuration properties (not inclusive)
	* @return the range of configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the configuration properties.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.wtberks.configuration.model.impl.ConfigurationPropertyModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of configuration properties
	* @param end the upper bound of the range of configuration properties (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.wtberks.configuration.model.ConfigurationProperty> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the configuration properties from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of configuration properties.
	*
	* @return the number of configuration properties
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}