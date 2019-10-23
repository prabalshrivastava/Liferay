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

package com.sambaash.platform.srv.spjob.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.spjob.model.SPJob;

/**
 * The persistence interface for the s p job service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobPersistenceImpl
 * @see SPJobUtil
 * @generated
 */
public interface SPJobPersistence extends BasePersistence<SPJob> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPJobUtil} to access the s p job persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p jobs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where uuid = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByUuid_PrevAndNext(
		long spJobId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p job where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spjob.NoSuchSPJobException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the s p job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the s p job where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p job that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the number of s p jobs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByUuid_C_PrevAndNext(
		long spJobId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCommunityId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCommunityId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCommunityId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCommunityId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCommunityId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCommunityId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCommunityId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where groupId = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByCommunityId_PrevAndNext(
		long spJobId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllJobsByCommunityId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllJobsByCommunityId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByTitle(
		java.lang.String jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where jobTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobTitle the job title
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByTitle(
		java.lang.String jobTitle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where jobTitle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobTitle the job title
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByTitle(
		java.lang.String jobTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByTitle_First(
		java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByTitle_First(
		java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByTitle_Last(
		java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByTitle_Last(
		java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where jobTitle = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param jobTitle the job title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByTitle_PrevAndNext(
		long spJobId, java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where jobTitle = &#63; from the database.
	*
	* @param jobTitle the job title
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllJobsByTitle(java.lang.String jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllJobsByTitle(java.lang.String jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs where jobType = &#63;.
	*
	* @param jobType the job type
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByType(
		java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where jobType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobType the job type
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByType(
		java.lang.String jobType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where jobType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobType the job type
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByType(
		java.lang.String jobType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByType_First(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByType_First(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByType_Last(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByType_Last(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where jobType = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByType_PrevAndNext(
		long spJobId, java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where jobType = &#63; from the database.
	*
	* @param jobType the job type
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllJobsByType(java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where jobType = &#63;.
	*
	* @param jobType the job type
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllJobsByType(java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByLocation(
		java.lang.String jobLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where jobLocation = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobLocation the job location
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByLocation(
		java.lang.String jobLocation, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where jobLocation = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobLocation the job location
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByLocation(
		java.lang.String jobLocation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByLocation_First(
		java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByLocation_First(
		java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByLocation_Last(
		java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByLocation_Last(
		java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where jobLocation = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param jobLocation the job location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByLocation_PrevAndNext(
		long spJobId, java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where jobLocation = &#63; from the database.
	*
	* @param jobLocation the job location
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllJobsByLocation(java.lang.String jobLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllJobsByLocation(java.lang.String jobLocation)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs where status = &#63;.
	*
	* @param status the status
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByJobStatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByJobStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where status = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param status the status
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByJobStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByJobStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByJobStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByJobStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByJobStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where status = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByJobStatus_PrevAndNext(
		long spJobId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllJobsByJobStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where status = &#63;.
	*
	* @param status the status
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllJobsByJobStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCompanyName(
		java.lang.String corporateName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where corporateName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corporateName the corporate name
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCompanyName(
		java.lang.String corporateName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where corporateName = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corporateName the corporate name
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCompanyName(
		java.lang.String corporateName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCompanyName_First(
		java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCompanyName_First(
		java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCompanyName_Last(
		java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCompanyName_Last(
		java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where corporateName = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param corporateName the corporate name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByCompanyName_PrevAndNext(
		long spJobId, java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where corporateName = &#63; from the database.
	*
	* @param corporateName the corporate name
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllJobsByCompanyName(java.lang.String corporateName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllJobsByCompanyName(java.lang.String corporateName)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByUserId(
		long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByUserId(
		long createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where createdBy = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param createdBy the created by
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByUserId(
		long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByUserId_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByUserId_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByUserId_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByUserId_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where createdBy = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByUserId_PrevAndNext(
		long spJobId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllJobsByUserId(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllJobsByUserId(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCorporateId(
		long corporateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs where corporateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corporateId the corporate ID
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCorporateId(
		long corporateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs where corporateId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param corporateId the corporate ID
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCorporateId(
		long corporateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job in the ordered set where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCorporateId_First(
		long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the first s p job in the ordered set where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCorporateId_First(
		long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job in the ordered set where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCorporateId_Last(
		long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the last s p job in the ordered set where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCorporateId_Last(
		long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p jobs before and after the current s p job in the ordered set where corporateId = &#63;.
	*
	* @param spJobId the primary key of the current s p job
	* @param corporateId the corporate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByCorporateId_PrevAndNext(
		long spJobId, long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Removes all the s p jobs where corporateId = &#63; from the database.
	*
	* @param corporateId the corporate ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllJobsByCorporateId(long corporateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllJobsByCorporateId(long corporateId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p job in the entity cache if it is enabled.
	*
	* @param spJob the s p job
	*/
	public void cacheResult(com.sambaash.platform.srv.spjob.model.SPJob spJob);

	/**
	* Caches the s p jobs in the entity cache if it is enabled.
	*
	* @param spJobs the s p jobs
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> spJobs);

	/**
	* Creates a new s p job with the primary key. Does not add the s p job to the database.
	*
	* @param spJobId the primary key for the new s p job
	* @return the new s p job
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob create(long spJobId);

	/**
	* Removes the s p job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job that was removed
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob remove(long spJobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	public com.sambaash.platform.srv.spjob.model.SPJob updateImpl(
		com.sambaash.platform.srv.spjob.model.SPJob spJob)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p job with the primary key or throws a {@link com.sambaash.platform.srv.spjob.NoSuchSPJobException} if it could not be found.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob findByPrimaryKey(
		long spJobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException;

	/**
	* Returns the s p job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job, or <code>null</code> if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJob fetchByPrimaryKey(
		long spJobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p jobs.
	*
	* @return the s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the s p jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @return the range of s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the s p jobs.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p jobs
	* @param end the upper bound of the range of s p jobs (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p jobs.
	*
	* @return the number of s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}