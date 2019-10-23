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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.spjob.model.SPJob;

import java.util.List;

/**
 * The persistence utility for the s p job service. This utility wraps {@link SPJobPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobPersistence
 * @see SPJobPersistenceImpl
 * @generated
 */
public class SPJobUtil {
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
	public static void clearCache(SPJob spJob) {
		getPersistence().clearCache(spJob);
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
	public static List<SPJob> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPJob> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPJob> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPJob update(SPJob spJob) throws SystemException {
		return getPersistence().update(spJob);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPJob update(SPJob spJob, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(spJob, serviceContext);
	}

	/**
	* Returns all the s p jobs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid(
		java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid(
		java.lang.String uuid, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid(
		java.lang.String uuid, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByUuid_First(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByUuid_Last(
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByUuid_PrevAndNext(
		long spJobId, java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByUuid_PrevAndNext(spJobId, uuid, orderByComparator);
	}

	/**
	* Removes all the s p jobs where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of s p jobs where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid(java.lang.String uuid)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the s p job where uuid = &#63; and groupId = &#63; or throws a {@link com.sambaash.platform.srv.spjob.NoSuchSPJobException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the s p job where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByUUID_G(
		java.lang.String uuid, long groupId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the s p job where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the s p job that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob removeByUUID_G(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of s p jobs where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the s p jobs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid_C(
		java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByUuid_C(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob findByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByUuid_C_First(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob findByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByUuid_C_Last(
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByUuid_C_PrevAndNext(
		long spJobId, java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(spJobId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the s p jobs where uuid = &#63; and companyId = &#63; from the database.
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
	* Returns the number of s p jobs where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the s p jobs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCommunityId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByCommunityId(groupId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCommunityId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByCommunityId(groupId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCommunityId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByCommunityId(groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCommunityId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByCommunityId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCommunityId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByCommunityId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCommunityId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByCommunityId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCommunityId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByCommunityId_Last(groupId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByCommunityId_PrevAndNext(
		long spJobId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByCommunityId_PrevAndNext(spJobId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the s p jobs where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllJobsByCommunityId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllJobsByCommunityId(groupId);
	}

	/**
	* Returns the number of s p jobs where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllJobsByCommunityId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllJobsByCommunityId(groupId);
	}

	/**
	* Returns all the s p jobs where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByTitle(
		java.lang.String jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByTitle(jobTitle);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByTitle(
		java.lang.String jobTitle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByTitle(jobTitle, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByTitle(
		java.lang.String jobTitle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByTitle(jobTitle, start, end, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByTitle_First(
		java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByTitle_First(jobTitle, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByTitle_First(
		java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByTitle_First(jobTitle, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByTitle_Last(
		java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByTitle_Last(jobTitle, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByTitle_Last(
		java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByTitle_Last(jobTitle, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByTitle_PrevAndNext(
		long spJobId, java.lang.String jobTitle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByTitle_PrevAndNext(spJobId, jobTitle,
			orderByComparator);
	}

	/**
	* Removes all the s p jobs where jobTitle = &#63; from the database.
	*
	* @param jobTitle the job title
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllJobsByTitle(java.lang.String jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllJobsByTitle(jobTitle);
	}

	/**
	* Returns the number of s p jobs where jobTitle = &#63;.
	*
	* @param jobTitle the job title
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllJobsByTitle(java.lang.String jobTitle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllJobsByTitle(jobTitle);
	}

	/**
	* Returns all the s p jobs where jobType = &#63;.
	*
	* @param jobType the job type
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByType(
		java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByType(jobType);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByType(
		java.lang.String jobType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByType(jobType, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByType(
		java.lang.String jobType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByType(jobType, start, end, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByType_First(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByType_First(jobType, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByType_First(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByType_First(jobType, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByType_Last(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByType_Last(jobType, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where jobType = &#63;.
	*
	* @param jobType the job type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByType_Last(
		java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByType_Last(jobType, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByType_PrevAndNext(
		long spJobId, java.lang.String jobType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByType_PrevAndNext(spJobId, jobType,
			orderByComparator);
	}

	/**
	* Removes all the s p jobs where jobType = &#63; from the database.
	*
	* @param jobType the job type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllJobsByType(java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllJobsByType(jobType);
	}

	/**
	* Returns the number of s p jobs where jobType = &#63;.
	*
	* @param jobType the job type
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllJobsByType(java.lang.String jobType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllJobsByType(jobType);
	}

	/**
	* Returns all the s p jobs where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByLocation(
		java.lang.String jobLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByLocation(jobLocation);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByLocation(
		java.lang.String jobLocation, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByLocation(jobLocation, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByLocation(
		java.lang.String jobLocation, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByLocation(jobLocation, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByLocation_First(
		java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByLocation_First(jobLocation, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByLocation_First(
		java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByLocation_First(jobLocation,
			orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByLocation_Last(
		java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByLocation_Last(jobLocation, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByLocation_Last(
		java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByLocation_Last(jobLocation, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByLocation_PrevAndNext(
		long spJobId, java.lang.String jobLocation,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByLocation_PrevAndNext(spJobId, jobLocation,
			orderByComparator);
	}

	/**
	* Removes all the s p jobs where jobLocation = &#63; from the database.
	*
	* @param jobLocation the job location
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllJobsByLocation(java.lang.String jobLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllJobsByLocation(jobLocation);
	}

	/**
	* Returns the number of s p jobs where jobLocation = &#63;.
	*
	* @param jobLocation the job location
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllJobsByLocation(java.lang.String jobLocation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllJobsByLocation(jobLocation);
	}

	/**
	* Returns all the s p jobs where status = &#63;.
	*
	* @param status the status
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByJobStatus(
		java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByJobStatus(status);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByJobStatus(
		java.lang.String status, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByJobStatus(status, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByJobStatus(
		java.lang.String status, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByJobStatus(status, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByJobStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByJobStatus_First(status, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByJobStatus_First(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByJobStatus_First(status, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByJobStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByJobStatus_Last(status, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where status = &#63;.
	*
	* @param status the status
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByJobStatus_Last(
		java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByJobStatus_Last(status, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByJobStatus_PrevAndNext(
		long spJobId, java.lang.String status,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByJobStatus_PrevAndNext(spJobId, status,
			orderByComparator);
	}

	/**
	* Removes all the s p jobs where status = &#63; from the database.
	*
	* @param status the status
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllJobsByJobStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllJobsByJobStatus(status);
	}

	/**
	* Returns the number of s p jobs where status = &#63;.
	*
	* @param status the status
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllJobsByJobStatus(java.lang.String status)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllJobsByJobStatus(status);
	}

	/**
	* Returns all the s p jobs where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCompanyName(
		java.lang.String corporateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByCompanyName(corporateName);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCompanyName(
		java.lang.String corporateName, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByCompanyName(corporateName, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCompanyName(
		java.lang.String corporateName, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByCompanyName(corporateName, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCompanyName_First(
		java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByCompanyName_First(corporateName,
			orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCompanyName_First(
		java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByCompanyName_First(corporateName,
			orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCompanyName_Last(
		java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByCompanyName_Last(corporateName,
			orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCompanyName_Last(
		java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByCompanyName_Last(corporateName,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByCompanyName_PrevAndNext(
		long spJobId, java.lang.String corporateName,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByCompanyName_PrevAndNext(spJobId,
			corporateName, orderByComparator);
	}

	/**
	* Removes all the s p jobs where corporateName = &#63; from the database.
	*
	* @param corporateName the corporate name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllJobsByCompanyName(
		java.lang.String corporateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllJobsByCompanyName(corporateName);
	}

	/**
	* Returns the number of s p jobs where corporateName = &#63;.
	*
	* @param corporateName the corporate name
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllJobsByCompanyName(
		java.lang.String corporateName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllJobsByCompanyName(corporateName);
	}

	/**
	* Returns all the s p jobs where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByUserId(
		long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByUserId(createdBy);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByUserId(
		long createdBy, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByUserId(createdBy, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByUserId(
		long createdBy, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByUserId(createdBy, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByUserId_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByUserId_First(createdBy, orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByUserId_First(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByUserId_First(createdBy, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByUserId_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByUserId_Last(createdBy, orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByUserId_Last(
		long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByUserId_Last(createdBy, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByUserId_PrevAndNext(
		long spJobId, long createdBy,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByUserId_PrevAndNext(spJobId, createdBy,
			orderByComparator);
	}

	/**
	* Removes all the s p jobs where createdBy = &#63; from the database.
	*
	* @param createdBy the created by
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllJobsByUserId(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllJobsByUserId(createdBy);
	}

	/**
	* Returns the number of s p jobs where createdBy = &#63;.
	*
	* @param createdBy the created by
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllJobsByUserId(long createdBy)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllJobsByUserId(createdBy);
	}

	/**
	* Returns all the s p jobs where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @return the matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCorporateId(
		long corporateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllJobsByCorporateId(corporateId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCorporateId(
		long corporateId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByCorporateId(corporateId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findByAllJobsByCorporateId(
		long corporateId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllJobsByCorporateId(corporateId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCorporateId_First(
		long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByCorporateId_First(corporateId,
			orderByComparator);
	}

	/**
	* Returns the first s p job in the ordered set where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCorporateId_First(
		long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByCorporateId_First(corporateId,
			orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByAllJobsByCorporateId_Last(
		long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByCorporateId_Last(corporateId,
			orderByComparator);
	}

	/**
	* Returns the last s p job in the ordered set where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job, or <code>null</code> if a matching s p job could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByAllJobsByCorporateId_Last(
		long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllJobsByCorporateId_Last(corporateId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.spjob.model.SPJob[] findByAllJobsByCorporateId_PrevAndNext(
		long spJobId, long corporateId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence()
				   .findByAllJobsByCorporateId_PrevAndNext(spJobId,
			corporateId, orderByComparator);
	}

	/**
	* Removes all the s p jobs where corporateId = &#63; from the database.
	*
	* @param corporateId the corporate ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllJobsByCorporateId(long corporateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllJobsByCorporateId(corporateId);
	}

	/**
	* Returns the number of s p jobs where corporateId = &#63;.
	*
	* @param corporateId the corporate ID
	* @return the number of matching s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllJobsByCorporateId(long corporateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllJobsByCorporateId(corporateId);
	}

	/**
	* Caches the s p job in the entity cache if it is enabled.
	*
	* @param spJob the s p job
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spjob.model.SPJob spJob) {
		getPersistence().cacheResult(spJob);
	}

	/**
	* Caches the s p jobs in the entity cache if it is enabled.
	*
	* @param spJobs the s p jobs
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> spJobs) {
		getPersistence().cacheResult(spJobs);
	}

	/**
	* Creates a new s p job with the primary key. Does not add the s p job to the database.
	*
	* @param spJobId the primary key for the new s p job
	* @return the new s p job
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob create(
		long spJobId) {
		return getPersistence().create(spJobId);
	}

	/**
	* Removes the s p job with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job that was removed
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob remove(
		long spJobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence().remove(spJobId);
	}

	public static com.sambaash.platform.srv.spjob.model.SPJob updateImpl(
		com.sambaash.platform.srv.spjob.model.SPJob spJob)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spJob);
	}

	/**
	* Returns the s p job with the primary key or throws a {@link com.sambaash.platform.srv.spjob.NoSuchSPJobException} if it could not be found.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job
	* @throws com.sambaash.platform.srv.spjob.NoSuchSPJobException if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob findByPrimaryKey(
		long spJobId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchSPJobException {
		return getPersistence().findByPrimaryKey(spJobId);
	}

	/**
	* Returns the s p job with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spJobId the primary key of the s p job
	* @return the s p job, or <code>null</code> if a s p job with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJob fetchByPrimaryKey(
		long spJobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spJobId);
	}

	/**
	* Returns all the s p jobs.
	*
	* @return the s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJob> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p jobs from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p jobs.
	*
	* @return the number of s p jobs
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPJobPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPJobPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spjob.service.ClpSerializer.getServletContextName(),
					SPJobPersistence.class.getName());

			ReferenceRegistry.registerReference(SPJobUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPJobPersistence persistence) {
	}

	private static SPJobPersistence _persistence;
}