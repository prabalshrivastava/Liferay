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

package com.sambaash.platform.srv.processbuilder.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.processbuilder.model.PERuleSet;

/**
 * The persistence interface for the p e rule set service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author nareshchebolu
 * @see PERuleSetPersistenceImpl
 * @see PERuleSetUtil
 * @generated
 */
public interface PERuleSetPersistence extends BasePersistence<PERuleSet> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link PERuleSetUtil} to access the p e rule set persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the p e rule sets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e rule sets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e rule sets
	* @param end the upper bound of the range of p e rule sets (not inclusive)
	* @return the range of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e rule sets where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of p e rule sets
	* @param end the upper bound of the range of p e rule sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e rule set in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Returns the first p e rule set in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e rule set in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Returns the last p e rule set in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rule sets before and after the current p e rule set in the ordered set where uuid = &#63;.
	*
	* @param spPERuleSetId the primary key of the current p e rule set
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a p e rule set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet[] findByUuid_PrevAndNext(
		long spPERuleSetId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Removes all the p e rule sets where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e rule sets where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rule set where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Returns the p e rule set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rule set where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the p e rule set where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the p e rule set that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Returns the number of p e rule sets where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e rule sets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e rule sets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e rule sets
	* @param end the upper bound of the range of p e rule sets (not inclusive)
	* @return the range of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e rule sets where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of p e rule sets
	* @param end the upper bound of the range of p e rule sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e rule set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Returns the first p e rule set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e rule set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Returns the last p e rule set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rule sets before and after the current p e rule set in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spPERuleSetId the primary key of the current p e rule set
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a p e rule set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet[] findByUuid_C_PrevAndNext(
		long spPERuleSetId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Removes all the p e rule sets where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e rule sets where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e rule sets where componentType = &#63;.
	*
	* @param componentType the component type
	* @return the matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByComponentType(
		java.lang.String componentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e rule sets where componentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentType the component type
	* @param start the lower bound of the range of p e rule sets
	* @param end the upper bound of the range of p e rule sets (not inclusive)
	* @return the range of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByComponentType(
		java.lang.String componentType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e rule sets where componentType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param componentType the component type
	* @param start the lower bound of the range of p e rule sets
	* @param end the upper bound of the range of p e rule sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findByComponentType(
		java.lang.String componentType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first p e rule set in the ordered set where componentType = &#63;.
	*
	* @param componentType the component type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet findByComponentType_First(
		java.lang.String componentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Returns the first p e rule set in the ordered set where componentType = &#63;.
	*
	* @param componentType the component type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchByComponentType_First(
		java.lang.String componentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last p e rule set in the ordered set where componentType = &#63;.
	*
	* @param componentType the component type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet findByComponentType_Last(
		java.lang.String componentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Returns the last p e rule set in the ordered set where componentType = &#63;.
	*
	* @param componentType the component type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching p e rule set, or <code>null</code> if a matching p e rule set could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchByComponentType_Last(
		java.lang.String componentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rule sets before and after the current p e rule set in the ordered set where componentType = &#63;.
	*
	* @param spPERuleSetId the primary key of the current p e rule set
	* @param componentType the component type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a p e rule set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet[] findByComponentType_PrevAndNext(
		long spPERuleSetId, java.lang.String componentType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Removes all the p e rule sets where componentType = &#63; from the database.
	*
	* @param componentType the component type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByComponentType(java.lang.String componentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e rule sets where componentType = &#63;.
	*
	* @param componentType the component type
	* @return the number of matching p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public int countByComponentType(java.lang.String componentType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the p e rule set in the entity cache if it is enabled.
	*
	* @param peRuleSet the p e rule set
	*/
	public void cacheResult(
		com.sambaash.platform.srv.processbuilder.model.PERuleSet peRuleSet);

	/**
	* Caches the p e rule sets in the entity cache if it is enabled.
	*
	* @param peRuleSets the p e rule sets
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> peRuleSets);

	/**
	* Creates a new p e rule set with the primary key. Does not add the p e rule set to the database.
	*
	* @param spPERuleSetId the primary key for the new p e rule set
	* @return the new p e rule set
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet create(
		long spPERuleSetId);

	/**
	* Removes the p e rule set with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spPERuleSetId the primary key of the p e rule set
	* @return the p e rule set that was removed
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a p e rule set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet remove(
		long spPERuleSetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	public com.sambaash.platform.srv.processbuilder.model.PERuleSet updateImpl(
		com.sambaash.platform.srv.processbuilder.model.PERuleSet peRuleSet)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the p e rule set with the primary key or throws a {@link com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException} if it could not be found.
	*
	* @param spPERuleSetId the primary key of the p e rule set
	* @return the p e rule set
	* @throws com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException if a p e rule set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet findByPrimaryKey(
		long spPERuleSetId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.processbuilder.NoSuchPERuleSetException;

	/**
	* Returns the p e rule set with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spPERuleSetId the primary key of the p e rule set
	* @return the p e rule set, or <code>null</code> if a p e rule set with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.processbuilder.model.PERuleSet fetchByPrimaryKey(
		long spPERuleSetId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the p e rule sets.
	*
	* @return the p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the p e rule sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e rule sets
	* @param end the upper bound of the range of p e rule sets (not inclusive)
	* @return the range of p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the p e rule sets.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.processbuilder.model.impl.PERuleSetModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of p e rule sets
	* @param end the upper bound of the range of p e rule sets (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.processbuilder.model.PERuleSet> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the p e rule sets from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of p e rule sets.
	*
	* @return the number of p e rule sets
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}