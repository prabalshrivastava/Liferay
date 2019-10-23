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

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;

/**
 * The persistence interface for the s p job entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author pradeep
 * @see SPJobEntryPersistenceImpl
 * @see SPJobEntryUtil
 * @generated
 */
public interface SPJobEntryPersistence extends BasePersistence<SPJobEntry> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPJobEntryUtil} to access the s p job entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p job entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Returns the first s p job entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Returns the last s p job entry in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry[] findByUuid_PrevAndNext(
		long spJobEntryId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Removes all the s p job entries where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job entries where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p job entry where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Returns the s p job entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p job entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p job entry where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p job entry that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Returns the number of s p job entries where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p job entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Returns the first s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Returns the last s p job entry in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry[] findByUuid_C_PrevAndNext(
		long spJobEntryId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Removes all the s p job entries where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job entries where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p job entries where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @return the matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByJobNameAndJobClass(
		java.lang.String jobName, java.lang.String jobClass)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByJobNameAndJobClass(
		java.lang.String jobName, java.lang.String jobClass, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findByJobNameAndJobClass(
		java.lang.String jobName, java.lang.String jobClass, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByJobNameAndJobClass_First(
		java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Returns the first s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByJobNameAndJobClass_First(
		java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByJobNameAndJobClass_Last(
		java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Returns the last s p job entry in the ordered set where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job entry, or <code>null</code> if a matching s p job entry could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByJobNameAndJobClass_Last(
		java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry[] findByJobNameAndJobClass_PrevAndNext(
		long spJobEntryId, java.lang.String jobName, java.lang.String jobClass,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Removes all the s p job entries where jobName = &#63; and jobClass = &#63; from the database.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @throws SystemException if a system exception occurred
	*/
	public void removeByJobNameAndJobClass(java.lang.String jobName,
		java.lang.String jobClass)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job entries where jobName = &#63; and jobClass = &#63;.
	*
	* @param jobName the job name
	* @param jobClass the job class
	* @return the number of matching s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public int countByJobNameAndJobClass(java.lang.String jobName,
		java.lang.String jobClass)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p job entry in the entity cache if it is enabled.
	*
	* @param spJobEntry the s p job entry
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spscheduler.model.SPJobEntry spJobEntry);

	/**
	* Caches the s p job entries in the entity cache if it is enabled.
	*
	* @param spJobEntries the s p job entries
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> spJobEntries);

	/**
	* Creates a new s p job entry with the primary key. Does not add the s p job entry to the database.
	*
	* @param spJobEntryId the primary key for the new s p job entry
	* @return the new s p job entry
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry create(
		long spJobEntryId);

	/**
	* Removes the s p job entry with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobEntryId the primary key of the s p job entry
	* @return the s p job entry that was removed
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry remove(
		long spJobEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry updateImpl(
		com.sambaash.platform.srv.spscheduler.model.SPJobEntry spJobEntry)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p job entry with the primary key or throws a {@link com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException} if it could not be found.
	*
	* @param spJobEntryId the primary key of the s p job entry
	* @return the s p job entry
	* @throws com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry findByPrimaryKey(
		long spJobEntryId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spscheduler.NoSuchSPJobEntryException;

	/**
	* Returns the s p job entry with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spJobEntryId the primary key of the s p job entry
	* @return the s p job entry, or <code>null</code> if a s p job entry with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry fetchByPrimaryKey(
		long spJobEntryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p job entries.
	*
	* @return the s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p job entries from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job entries.
	*
	* @return the number of s p job entries
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}