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

import com.sambaash.platform.srv.model.CourseCareer;

/**
 * The persistence interface for the course career service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseCareerPersistenceImpl
 * @see CourseCareerUtil
 * @generated
 */
public interface CourseCareerPersistence extends BasePersistence<CourseCareer> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseCareerUtil} to access the course career persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the course career where spCourseId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseCareerException} if it could not be found.
	*
	* @param spCourseId the sp course ID
	* @return the matching course career
	* @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a matching course career could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseCareer findByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseCareerException;

	/**
	* Returns the course career where spCourseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCourseId the sp course ID
	* @return the matching course career, or <code>null</code> if a matching course career could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseCareer fetchByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course career where spCourseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course career, or <code>null</code> if a matching course career could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseCareer fetchByCourseId(
		long spCourseId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the course career where spCourseId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @return the course career that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseCareer removeByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseCareerException;

	/**
	* Returns the number of course careers where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the number of matching course careers
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the course career in the entity cache if it is enabled.
	*
	* @param courseCareer the course career
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.CourseCareer courseCareer);

	/**
	* Caches the course careers in the entity cache if it is enabled.
	*
	* @param courseCareers the course careers
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseCareer> courseCareers);

	/**
	* Creates a new course career with the primary key. Does not add the course career to the database.
	*
	* @param spCourseCareerId the primary key for the new course career
	* @return the new course career
	*/
	public com.sambaash.platform.srv.model.CourseCareer create(
		long spCourseCareerId);

	/**
	* Removes the course career with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseCareerId the primary key of the course career
	* @return the course career that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a course career with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseCareer remove(
		long spCourseCareerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseCareerException;

	public com.sambaash.platform.srv.model.CourseCareer updateImpl(
		com.sambaash.platform.srv.model.CourseCareer courseCareer)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course career with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseCareerException} if it could not be found.
	*
	* @param spCourseCareerId the primary key of the course career
	* @return the course career
	* @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a course career with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseCareer findByPrimaryKey(
		long spCourseCareerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseCareerException;

	/**
	* Returns the course career with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseCareerId the primary key of the course career
	* @return the course career, or <code>null</code> if a course career with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseCareer fetchByPrimaryKey(
		long spCourseCareerId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course careers.
	*
	* @return the course careers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseCareer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course careers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCareerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course careers
	* @param end the upper bound of the range of course careers (not inclusive)
	* @return the range of course careers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseCareer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course careers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCareerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course careers
	* @param end the upper bound of the range of course careers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course careers
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseCareer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course careers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course careers.
	*
	* @return the number of course careers
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}