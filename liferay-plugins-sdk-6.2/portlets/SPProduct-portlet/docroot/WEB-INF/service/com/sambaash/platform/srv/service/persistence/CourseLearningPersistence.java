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

package com.sambaash.platform.srv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.sambaash.platform.srv.model.CourseLearning;

/**
 * The persistence interface for the course learning service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseLearningPersistenceImpl
 * @see CourseLearningUtil
 * @generated
 */
public interface CourseLearningPersistence extends BasePersistence<CourseLearning> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseLearningUtil} to access the course learning persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the course learning where spCourseId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseLearningException} if it could not be found.
	*
	* @param spCourseId the sp course ID
	* @return the matching course learning
	* @throws com.sambaash.platform.srv.NoSuchCourseLearningException if a matching course learning could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseLearning findByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseLearningException;

	/**
	* Returns the course learning where spCourseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCourseId the sp course ID
	* @return the matching course learning, or <code>null</code> if a matching course learning could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseLearning fetchByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course learning where spCourseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course learning, or <code>null</code> if a matching course learning could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseLearning fetchByCourseId(
		long spCourseId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the course learning where spCourseId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @return the course learning that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseLearning removeByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseLearningException;

	/**
	* Returns the number of course learnings where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the number of matching course learnings
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the course learning in the entity cache if it is enabled.
	*
	* @param courseLearning the course learning
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.CourseLearning courseLearning);

	/**
	* Caches the course learnings in the entity cache if it is enabled.
	*
	* @param courseLearnings the course learnings
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseLearning> courseLearnings);

	/**
	* Creates a new course learning with the primary key. Does not add the course learning to the database.
	*
	* @param spCourseLearningId the primary key for the new course learning
	* @return the new course learning
	*/
	public com.sambaash.platform.srv.model.CourseLearning create(
		long spCourseLearningId);

	/**
	* Removes the course learning with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseLearningId the primary key of the course learning
	* @return the course learning that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseLearningException if a course learning with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseLearning remove(
		long spCourseLearningId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseLearningException;

	public com.sambaash.platform.srv.model.CourseLearning updateImpl(
		com.sambaash.platform.srv.model.CourseLearning courseLearning)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course learning with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseLearningException} if it could not be found.
	*
	* @param spCourseLearningId the primary key of the course learning
	* @return the course learning
	* @throws com.sambaash.platform.srv.NoSuchCourseLearningException if a course learning with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseLearning findByPrimaryKey(
		long spCourseLearningId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseLearningException;

	/**
	* Returns the course learning with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseLearningId the primary key of the course learning
	* @return the course learning, or <code>null</code> if a course learning with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseLearning fetchByPrimaryKey(
		long spCourseLearningId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course learnings.
	*
	* @return the course learnings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseLearning> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course learnings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseLearningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course learnings
	* @param end the upper bound of the range of course learnings (not inclusive)
	* @return the range of course learnings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseLearning> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course learnings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseLearningModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course learnings
	* @param end the upper bound of the range of course learnings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course learnings
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseLearning> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course learnings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course learnings.
	*
	* @return the number of course learnings
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}