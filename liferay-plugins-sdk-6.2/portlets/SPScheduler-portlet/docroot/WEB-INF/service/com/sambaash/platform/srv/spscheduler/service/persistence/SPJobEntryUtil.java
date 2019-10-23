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

package com.sambaash.platform.srv.spscheduler.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;

import java.util.List;

/**
 * The persistence utility for the s p job entry service. This utility wraps {@link SPJobEntryPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPJobEntryPersistence
 * @see SPJobEntryPersistenceImpl
 * @generated
 */
public class SPJobEntryUtil {
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
	public static void clearCache(SPJobEntry spJobEntry) {
		getPersistence().clearCache(spJobEntry);
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
	public static List<SPJobEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPJobEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPJobEntry> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPJobEntry update(SPJobEntry spJobEntry)
		throws SystemException {
		return getPersistence().update(spJobEntry);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPJobEntry update(SPJobEntry spJobEntry,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spJobEntry, serviceContext);
	}

	/**
	* Returns all the s p job entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

	/**
	* Returns a range of all the s p job entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p job entries
	* @param end the upper bound of the range of s p job entries (not inclusive)
	* @return the range of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

	/**
	* Returns an ordered range of all the s p job entries where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p job entries
	* @param end the upper bound of the range of s p job entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first s p job entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first s p job entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last s p job entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last s p job entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the s p job entries before and after the current s p job entry in the ordered set where uuid = &#63;.
	*
	* @param spJobEntryId the primary key of the current s p job entry
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry[] findByUuid_PrevAndNext(
		long spJobEntryId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spJobEntryId, uuid, orderByComparator);
	}

	/**
	* Removes all the s p job entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of s p job entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the s p job entry where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p job entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p job entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the s p job entry where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p job entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of s p job entries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the s p job entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

	/**
	* Returns a range of all the s p job entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p job entries
	* @param end the upper bound of the range of s p job entries (not inclusive)
	* @return the range of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

	/**
	* Returns an ordered range of all the s p job entries where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p job entries
	* @param end the upper bound of the range of s p job entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the s p job entries before and after the current s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spJobEntryId the primary key of the current s p job entry
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry[] findByUuid_C_PrevAndNext(
		long spJobEntryId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spJobEntryId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the s p job entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of s p job entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the s p job entries where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @return the matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByJobNameAndJobClass(
		java.lang.String jobName, java.lang.String jobClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByJobNameAndJobClass(jobName, jobClass);
	}

	/**
	* Returns a range of all the s p job entries where jobName = &#63; and jobClass = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @param start the lower bound of the range of s p job entries
	* @param end the upper bound of the range of s p job entries (not inclusive)
	* @return the range of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByJobNameAndJobClass(
		java.lang.String jobName, java.lang.String jobClass, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByJobNameAndJobClass(jobName, jobClass, start, end);
	}

	/**
	* Returns an ordered range of all the s p job entries where jobName = &#63; and jobClass = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @param start the lower bound of the range of s p job entries
	* @param end the upper bound of the range of s p job entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByJobNameAndJobClass(
		java.lang.String jobName, java.lang.String jobClass, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByJobNameAndJobClass(jobName, jobClass, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByJobNameAndJobClass_First(
		java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence()
				   .findByJobNameAndJobClass_First(jobName, jobClass,
			orderByComparator);
	}

	/**
	* Returns the first s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByJobNameAndJobClass_First(
		java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByJobNameAndJobClass_First(jobName, jobClass,
			orderByComparator);
	}

	/**
	* Returns the last s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByJobNameAndJobClass_Last(
		java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence()
				   .findByJobNameAndJobClass_Last(jobName, jobClass,
			orderByComparator);
	}

	/**
	* Returns the last s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByJobNameAndJobClass_Last(
		java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByJobNameAndJobClass_Last(jobName, jobClass,
			orderByComparator);
	}

	/**
	* Returns the s p job entries before and after the current s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	*
	* @param spJobEntryId the primary key of the current s p job entry
	* @param jobName the job name
	* @param jobClass the job class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry[] findByJobNameAndJobClass_PrevAndNext(
		long spJobEntryId, java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence()
				   .findByJobNameAndJobClass_PrevAndNext(spJobEntryId, jobName,
			jobClass, orderByComparator);
	}

	/**
	* Removes all the s p job entries where jobName = &#63; and jobClass = &#63; from the database.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByJobNameAndJobClass(java.lang.String jobName,
		java.lang.String jobClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByJobNameAndJobClass(jobName, jobClass);
	}

	/**
	* Returns the number of s p job entries where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @return the number of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countByJobNameAndJobClass(java.lang.String jobName,
		java.lang.String jobClass)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByJobNameAndJobClass(jobName, jobClass);
	}

	/**
	* Caches the s p job entry in the entity cache if it is enabled.
	*
	* @param spJobEntry the s p job entry
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spscheduler.model.SPJobEntry spJobEntry) {
		getPersistence().cacheResult(spJobEntry);
	}

	/**
	* Caches the s p job entries in the entity cache if it is enabled.
	*
	* @param spJobEntries the s p job entries
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> spJobEntries) {
		getPersistence().cacheResult(spJobEntries);
	}

	/**
	* Creates a new s p job entry with the primary key. Does not add the s p job entry to the database.
	*
	* @param spJobEntryId the primary key for the new s p job entry
	* @return the new s p job entry
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry create(
		long spJobEntryId) {
		return getPersistence().create(spJobEntryId);
	}

	/**
	* Removes the s p job entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobEntryId the primary key of the s p job entry
	* @return the s p job entry that was removed
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry remove(
		long spJobEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence().remove(spJobEntryId);
	}

	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry updateImpl(
		com.sambaash.platform.srv.spscheduler.model.SPJobEntry spJobEntry)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spJobEntry);
	}

	/**
	* Returns the s p job entry with the primary key or throws a {@link com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException} if it could not be found.
	*
	* @param spJobEntryId the primary key of the s p job entry
	* @return the s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByPrimaryKey(
		long spJobEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException {
		return getPersistence().findByPrimaryKey(spJobEntryId);
	}

	/**
	* Returns the s p job entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spJobEntryId the primary key of the s p job entry
	* @return the s p job entry, or <code>null</code> if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByPrimaryKey(
		long spJobEntryId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spJobEntryId);
	}

	/**
	* Returns all the s p job entries.
	*
	* @return the s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p job entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p job entries
	* @param end the upper bound of the range of s p job entries (not inclusive)
	* @return the range of s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p job entries.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spscheduler.model.impl.SPJobEntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p job entries
	* @param end the upper bound of the range of s p job entries (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p job entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p job entries.
	*
	* @return the number of s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPJobEntryPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPJobEntryPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spscheduler.service.ClpSerializer.getServletContextName(),
					SPJobEntryPersistence.class.getName());

			ReferenceRegistry.registerReference(SPJobEntryUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPJobEntryPersistence persistence) {
	}

	private static SPJobEntryPersistence _persistence;
}