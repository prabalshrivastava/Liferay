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

import com.sambaash.platform.srv.spjob.model.SPJobApplicants;

import java.util.List;

/**
 * The persistence utility for the s p job applicants service. This utility wraps {@link SPJobApplicantsPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobApplicantsPersistence
 * @see SPJobApplicantsPersistenceImpl
 * @generated
 */
public class SPJobApplicantsUtil {
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
	public static void clearCache(SPJobApplicants spJobApplicants) {
		getPersistence().clearCache(spJobApplicants);
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
	public static List<SPJobApplicants> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<SPJobApplicants> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<SPJobApplicants> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static SPJobApplicants update(SPJobApplicants spJobApplicants)
		throws SystemException {
		return getPersistence().update(spJobApplicants);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static SPJobApplicants update(SPJobApplicants spJobApplicants,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(spJobApplicants, serviceContext);
	}

	/**
	* Returns all the s p job applicantses where jobId = &#63;.
	*
	* @param jobId the job ID
	* @return the matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByJobId(
		long jobId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllAppliedJobsByJobId(jobId);
	}

	/**
	* Returns a range of all the s p job applicantses where jobId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobId the job ID
	* @param start the lower bound of the range of s p job applicantses
	* @param end the upper bound of the range of s p job applicantses (not inclusive)
	* @return the range of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByJobId(
		long jobId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllAppliedJobsByJobId(jobId, start, end);
	}

	/**
	* Returns an ordered range of all the s p job applicantses where jobId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param jobId the job ID
	* @param start the lower bound of the range of s p job applicantses
	* @param end the upper bound of the range of s p job applicantses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByJobId(
		long jobId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllAppliedJobsByJobId(jobId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job applicants in the ordered set where jobId = &#63;.
	*
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByJobId_First(
		long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence()
				   .findByAllAppliedJobsByJobId_First(jobId, orderByComparator);
	}

	/**
	* Returns the first s p job applicants in the ordered set where jobId = &#63;.
	*
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByJobId_First(
		long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllAppliedJobsByJobId_First(jobId, orderByComparator);
	}

	/**
	* Returns the last s p job applicants in the ordered set where jobId = &#63;.
	*
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByJobId_Last(
		long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence()
				   .findByAllAppliedJobsByJobId_Last(jobId, orderByComparator);
	}

	/**
	* Returns the last s p job applicants in the ordered set where jobId = &#63;.
	*
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByJobId_Last(
		long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllAppliedJobsByJobId_Last(jobId, orderByComparator);
	}

	/**
	* Returns the s p job applicantses before and after the current s p job applicants in the ordered set where jobId = &#63;.
	*
	* @param spJobApplicantsId the primary key of the current s p job applicants
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants[] findByAllAppliedJobsByJobId_PrevAndNext(
		long spJobApplicantsId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence()
				   .findByAllAppliedJobsByJobId_PrevAndNext(spJobApplicantsId,
			jobId, orderByComparator);
	}

	/**
	* Removes all the s p job applicantses where jobId = &#63; from the database.
	*
	* @param jobId the job ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllAppliedJobsByJobId(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllAppliedJobsByJobId(jobId);
	}

	/**
	* Returns the number of s p job applicantses where jobId = &#63;.
	*
	* @param jobId the job ID
	* @return the number of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllAppliedJobsByJobId(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllAppliedJobsByJobId(jobId);
	}

	/**
	* Returns all the s p job applicantses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllAppliedJobsByUserId(userId);
	}

	/**
	* Returns a range of all the s p job applicantses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p job applicantses
	* @param end the upper bound of the range of s p job applicantses (not inclusive)
	* @return the range of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllAppliedJobsByUserId(userId, start, end);
	}

	/**
	* Returns an ordered range of all the s p job applicantses where userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param userId the user ID
	* @param start the lower bound of the range of s p job applicantses
	* @param end the upper bound of the range of s p job applicantses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllAppliedJobsByUserId(userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job applicants in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence()
				   .findByAllAppliedJobsByUserId_First(userId, orderByComparator);
	}

	/**
	* Returns the first s p job applicants in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllAppliedJobsByUserId_First(userId,
			orderByComparator);
	}

	/**
	* Returns the last s p job applicants in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence()
				   .findByAllAppliedJobsByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the last s p job applicants in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllAppliedJobsByUserId_Last(userId, orderByComparator);
	}

	/**
	* Returns the s p job applicantses before and after the current s p job applicants in the ordered set where userId = &#63;.
	*
	* @param spJobApplicantsId the primary key of the current s p job applicants
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants[] findByAllAppliedJobsByUserId_PrevAndNext(
		long spJobApplicantsId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence()
				   .findByAllAppliedJobsByUserId_PrevAndNext(spJobApplicantsId,
			userId, orderByComparator);
	}

	/**
	* Removes all the s p job applicantses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllAppliedJobsByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllAppliedJobsByUserId(userId);
	}

	/**
	* Returns the number of s p job applicantses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllAppliedJobsByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllAppliedJobsByUserId(userId);
	}

	/**
	* Returns all the s p job applicantses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByCommunity(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByAllAppliedJobsByCommunity(groupId);
	}

	/**
	* Returns a range of all the s p job applicantses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of s p job applicantses
	* @param end the upper bound of the range of s p job applicantses (not inclusive)
	* @return the range of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByCommunity(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllAppliedJobsByCommunity(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the s p job applicantses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of s p job applicantses
	* @param end the upper bound of the range of s p job applicantses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByCommunity(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByAllAppliedJobsByCommunity(groupId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first s p job applicants in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByCommunity_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence()
				   .findByAllAppliedJobsByCommunity_First(groupId,
			orderByComparator);
	}

	/**
	* Returns the first s p job applicants in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByCommunity_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllAppliedJobsByCommunity_First(groupId,
			orderByComparator);
	}

	/**
	* Returns the last s p job applicants in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByCommunity_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence()
				   .findByAllAppliedJobsByCommunity_Last(groupId,
			orderByComparator);
	}

	/**
	* Returns the last s p job applicants in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByCommunity_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByAllAppliedJobsByCommunity_Last(groupId,
			orderByComparator);
	}

	/**
	* Returns the s p job applicantses before and after the current s p job applicants in the ordered set where groupId = &#63;.
	*
	* @param spJobApplicantsId the primary key of the current s p job applicants
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants[] findByAllAppliedJobsByCommunity_PrevAndNext(
		long spJobApplicantsId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence()
				   .findByAllAppliedJobsByCommunity_PrevAndNext(spJobApplicantsId,
			groupId, orderByComparator);
	}

	/**
	* Removes all the s p job applicantses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByAllAppliedJobsByCommunity(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByAllAppliedJobsByCommunity(groupId);
	}

	/**
	* Returns the number of s p job applicantses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static int countByAllAppliedJobsByCommunity(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByAllAppliedJobsByCommunity(groupId);
	}

	/**
	* Caches the s p job applicants in the entity cache if it is enabled.
	*
	* @param spJobApplicants the s p job applicants
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.spjob.model.SPJobApplicants spJobApplicants) {
		getPersistence().cacheResult(spJobApplicants);
	}

	/**
	* Caches the s p job applicantses in the entity cache if it is enabled.
	*
	* @param spJobApplicantses the s p job applicantses
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> spJobApplicantses) {
		getPersistence().cacheResult(spJobApplicantses);
	}

	/**
	* Creates a new s p job applicants with the primary key. Does not add the s p job applicants to the database.
	*
	* @param spJobApplicantsId the primary key for the new s p job applicants
	* @return the new s p job applicants
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants create(
		long spJobApplicantsId) {
		return getPersistence().create(spJobApplicantsId);
	}

	/**
	* Removes the s p job applicants with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobApplicantsId the primary key of the s p job applicants
	* @return the s p job applicants that was removed
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants remove(
		long spJobApplicantsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence().remove(spJobApplicantsId);
	}

	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants updateImpl(
		com.sambaash.platform.srv.spjob.model.SPJobApplicants spJobApplicants)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(spJobApplicants);
	}

	/**
	* Returns the s p job applicants with the primary key or throws a {@link com.sambaash.platform.srv.spjob.NoSuchApplicantsException} if it could not be found.
	*
	* @param spJobApplicantsId the primary key of the s p job applicants
	* @return the s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants findByPrimaryKey(
		long spJobApplicantsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException {
		return getPersistence().findByPrimaryKey(spJobApplicantsId);
	}

	/**
	* Returns the s p job applicants with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spJobApplicantsId the primary key of the s p job applicants
	* @return the s p job applicants, or <code>null</code> if a s p job applicants with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByPrimaryKey(
		long spJobApplicantsId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spJobApplicantsId);
	}

	/**
	* Returns all the s p job applicantses.
	*
	* @return the s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the s p job applicantses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p job applicantses
	* @param end the upper bound of the range of s p job applicantses (not inclusive)
	* @return the range of s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the s p job applicantses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p job applicantses
	* @param end the upper bound of the range of s p job applicantses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the s p job applicantses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of s p job applicantses.
	*
	* @return the number of s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static SPJobApplicantsPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (SPJobApplicantsPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.spjob.service.ClpSerializer.getServletContextName(),
					SPJobApplicantsPersistence.class.getName());

			ReferenceRegistry.registerReference(SPJobApplicantsUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(SPJobApplicantsPersistence persistence) {
	}

	private static SPJobApplicantsPersistence _persistence;
}