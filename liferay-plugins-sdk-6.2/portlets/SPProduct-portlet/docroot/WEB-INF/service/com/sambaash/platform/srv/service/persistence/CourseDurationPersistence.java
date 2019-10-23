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

import com.sambaash.platform.srv.model.CourseDuration;

/**
 * The persistence interface for the course duration service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseDurationPersistenceImpl
 * @see CourseDurationUtil
 * @generated
 */
public interface CourseDurationPersistence extends BasePersistence<CourseDuration> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseDurationUtil} to access the course duration persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the course duration where spCourseId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseDurationException} if it could not be found.
	*
	* @param spCourseId the sp course ID
	* @return the matching course duration
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a matching course duration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDuration findByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationException;

	/**
	* Returns the course duration where spCourseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCourseId the sp course ID
	* @return the matching course duration, or <code>null</code> if a matching course duration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDuration fetchByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course duration where spCourseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course duration, or <code>null</code> if a matching course duration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDuration fetchByCourseId(
		long spCourseId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the course duration where spCourseId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @return the course duration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDuration removeByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationException;

	/**
	* Returns the number of course durations where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the number of matching course durations
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the course duration in the entity cache if it is enabled.
	*
	* @param courseDuration the course duration
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.CourseDuration courseDuration);

	/**
	* Caches the course durations in the entity cache if it is enabled.
	*
	* @param courseDurations the course durations
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseDuration> courseDurations);

	/**
	* Creates a new course duration with the primary key. Does not add the course duration to the database.
	*
	* @param spCourseDurationId the primary key for the new course duration
	* @return the new course duration
	*/
	public com.sambaash.platform.srv.model.CourseDuration create(
		long spCourseDurationId);

	/**
	* Removes the course duration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseDurationId the primary key of the course duration
	* @return the course duration that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a course duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDuration remove(
		long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationException;

	public com.sambaash.platform.srv.model.CourseDuration updateImpl(
		com.sambaash.platform.srv.model.CourseDuration courseDuration)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course duration with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseDurationException} if it could not be found.
	*
	* @param spCourseDurationId the primary key of the course duration
	* @return the course duration
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a course duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDuration findByPrimaryKey(
		long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationException;

	/**
	* Returns the course duration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseDurationId the primary key of the course duration
	* @return the course duration, or <code>null</code> if a course duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDuration fetchByPrimaryKey(
		long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course durations.
	*
	* @return the course durations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDuration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course durations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course durations
	* @param end the upper bound of the range of course durations (not inclusive)
	* @return the range of course durations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDuration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course durations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course durations
	* @param end the upper bound of the range of course durations (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course durations
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDuration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course durations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course durations.
	*
	* @return the number of course durations
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}