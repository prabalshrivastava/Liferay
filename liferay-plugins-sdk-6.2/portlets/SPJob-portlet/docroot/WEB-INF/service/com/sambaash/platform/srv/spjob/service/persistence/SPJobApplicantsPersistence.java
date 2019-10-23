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

import com.sambaash.platform.srv.spjob.model.SPJobApplicants;

/**
 * The persistence interface for the s p job applicants service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author harini
 * @see SPJobApplicantsPersistenceImpl
 * @see SPJobApplicantsUtil
 * @generated
 */
public interface SPJobApplicantsPersistence extends BasePersistence<SPJobApplicants> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPJobApplicantsUtil} to access the s p job applicants persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the s p job applicantses where jobId = &#63;.
	*
	* @param jobId the job ID
	* @return the matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByJobId(
		long jobId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByJobId(
		long jobId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByJobId(
		long jobId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job applicants in the ordered set where jobId = &#63;.
	*
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByJobId_First(
		long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Returns the first s p job applicants in the ordered set where jobId = &#63;.
	*
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByJobId_First(
		long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job applicants in the ordered set where jobId = &#63;.
	*
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByJobId_Last(
		long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Returns the last s p job applicants in the ordered set where jobId = &#63;.
	*
	* @param jobId the job ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByJobId_Last(
		long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants[] findByAllAppliedJobsByJobId_PrevAndNext(
		long spJobApplicantsId, long jobId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Removes all the s p job applicantses where jobId = &#63; from the database.
	*
	* @param jobId the job ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllAppliedJobsByJobId(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job applicantses where jobId = &#63;.
	*
	* @param jobId the job ID
	* @return the number of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllAppliedJobsByJobId(long jobId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p job applicantses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByUserId(
		long userId) throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByUserId(
		long userId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByUserId(
		long userId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job applicants in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Returns the first s p job applicants in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByUserId_First(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job applicants in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Returns the last s p job applicants in the ordered set where userId = &#63;.
	*
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByUserId_Last(
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants[] findByAllAppliedJobsByUserId_PrevAndNext(
		long spJobApplicantsId, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Removes all the s p job applicantses where userId = &#63; from the database.
	*
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllAppliedJobsByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job applicantses where userId = &#63;.
	*
	* @param userId the user ID
	* @return the number of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllAppliedJobsByUserId(long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p job applicantses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByCommunity(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByCommunity(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findByAllAppliedJobsByCommunity(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first s p job applicants in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByCommunity_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Returns the first s p job applicants in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByCommunity_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last s p job applicants in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants findByAllAppliedJobsByCommunity_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Returns the last s p job applicants in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching s p job applicants, or <code>null</code> if a matching s p job applicants could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByAllAppliedJobsByCommunity_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants[] findByAllAppliedJobsByCommunity_PrevAndNext(
		long spJobApplicantsId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Removes all the s p job applicantses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByAllAppliedJobsByCommunity(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job applicantses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public int countByAllAppliedJobsByCommunity(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the s p job applicants in the entity cache if it is enabled.
	*
	* @param spJobApplicants the s p job applicants
	*/
	public void cacheResult(
		com.sambaash.platform.srv.spjob.model.SPJobApplicants spJobApplicants);

	/**
	* Caches the s p job applicantses in the entity cache if it is enabled.
	*
	* @param spJobApplicantses the s p job applicantses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> spJobApplicantses);

	/**
	* Creates a new s p job applicants with the primary key. Does not add the s p job applicants to the database.
	*
	* @param spJobApplicantsId the primary key for the new s p job applicants
	* @return the new s p job applicants
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants create(
		long spJobApplicantsId);

	/**
	* Removes the s p job applicants with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spJobApplicantsId the primary key of the s p job applicants
	* @return the s p job applicants that was removed
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants remove(
		long spJobApplicantsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	public com.sambaash.platform.srv.spjob.model.SPJobApplicants updateImpl(
		com.sambaash.platform.srv.spjob.model.SPJobApplicants spJobApplicants)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the s p job applicants with the primary key or throws a {@link com.sambaash.platform.srv.spjob.NoSuchApplicantsException} if it could not be found.
	*
	* @param spJobApplicantsId the primary key of the s p job applicants
	* @return the s p job applicants
	* @throws com.sambaash.platform.srv.spjob.NoSuchApplicantsException if a s p job applicants with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants findByPrimaryKey(
		long spJobApplicantsId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spjob.NoSuchApplicantsException;

	/**
	* Returns the s p job applicants with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spJobApplicantsId the primary key of the s p job applicants
	* @return the s p job applicants, or <code>null</code> if a s p job applicants with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants fetchByPrimaryKey(
		long spJobApplicantsId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the s p job applicantses.
	*
	* @return the s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.sambaash.platform.srv.spjob.model.SPJobApplicants> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the s p job applicantses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of s p job applicantses.
	*
	* @return the number of s p job applicantses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}