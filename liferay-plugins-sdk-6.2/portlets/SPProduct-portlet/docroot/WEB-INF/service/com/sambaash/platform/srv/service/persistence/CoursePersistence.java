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

import com.sambaash.platform.srv.model.Course;

/**
 * The persistence interface for the course service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CoursePersistenceImpl
 * @see CourseUtil
 * @generated
 */
public interface CoursePersistence extends BasePersistence<Course> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseUtil} to access the course persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the courses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Course> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Course> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courses where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Course> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.sambaash.platform.srv.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	/**
	* Returns the first course in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.sambaash.platform.srv.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	/**
	* Returns the last course in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the courses before and after the current course in the ordered set where groupId = &#63;.
	*
	* @param spCourseId the primary key of the current course
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws com.sambaash.platform.srv.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course[] findByGroupId_PrevAndNext(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	/**
	* Removes all the courses where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courses where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the courses where countryId = &#63;.
	*
	* @param countryId the country ID
	* @return the matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Course> findByCountryId(
		java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courses where countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Course> findByCountryId(
		java.lang.String countryId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courses where countryId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param countryId the country ID
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Course> findByCountryId(
		java.lang.String countryId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course in the ordered set where countryId = &#63;.
	*
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course
	* @throws com.sambaash.platform.srv.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course findByCountryId_First(
		java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	/**
	* Returns the first course in the ordered set where countryId = &#63;.
	*
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course fetchByCountryId_First(
		java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course in the ordered set where countryId = &#63;.
	*
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course
	* @throws com.sambaash.platform.srv.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course findByCountryId_Last(
		java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	/**
	* Returns the last course in the ordered set where countryId = &#63;.
	*
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course fetchByCountryId_Last(
		java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the courses before and after the current course in the ordered set where countryId = &#63;.
	*
	* @param spCourseId the primary key of the current course
	* @param countryId the country ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course
	* @throws com.sambaash.platform.srv.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course[] findByCountryId_PrevAndNext(
		long spCourseId, java.lang.String countryId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	/**
	* Removes all the courses where countryId = &#63; from the database.
	*
	* @param countryId the country ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCountryId(java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courses where countryId = &#63;.
	*
	* @param countryId the country ID
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCountryId(java.lang.String countryId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course where courseCode = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseException} if it could not be found.
	*
	* @param courseCode the course code
	* @return the matching course
	* @throws com.sambaash.platform.srv.NoSuchCourseException if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course findByCourseCode(
		java.lang.String courseCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	/**
	* Returns the course where courseCode = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param courseCode the course code
	* @return the matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course fetchByCourseCode(
		java.lang.String courseCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course where courseCode = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param courseCode the course code
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course, or <code>null</code> if a matching course could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course fetchByCourseCode(
		java.lang.String courseCode, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the course where courseCode = &#63; from the database.
	*
	* @param courseCode the course code
	* @return the course that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course removeByCourseCode(
		java.lang.String courseCode)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	/**
	* Returns the number of courses where courseCode = &#63;.
	*
	* @param courseCode the course code
	* @return the number of matching courses
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseCode(java.lang.String courseCode)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the course in the entity cache if it is enabled.
	*
	* @param course the course
	*/
	public void cacheResult(com.sambaash.platform.srv.model.Course course);

	/**
	* Caches the courses in the entity cache if it is enabled.
	*
	* @param courses the courses
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.Course> courses);

	/**
	* Creates a new course with the primary key. Does not add the course to the database.
	*
	* @param spCourseId the primary key for the new course
	* @return the new course
	*/
	public com.sambaash.platform.srv.model.Course create(long spCourseId);

	/**
	* Removes the course with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseId the primary key of the course
	* @return the course that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course remove(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	public com.sambaash.platform.srv.model.Course updateImpl(
		com.sambaash.platform.srv.model.Course course)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseException} if it could not be found.
	*
	* @param spCourseId the primary key of the course
	* @return the course
	* @throws com.sambaash.platform.srv.NoSuchCourseException if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course findByPrimaryKey(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseException;

	/**
	* Returns the course with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseId the primary key of the course
	* @return the course, or <code>null</code> if a course with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.Course fetchByPrimaryKey(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the courses.
	*
	* @return the courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Course> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @return the range of courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Course> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the courses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of courses
	* @param end the upper bound of the range of courses (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of courses
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.Course> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the courses from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of courses.
	*
	* @return the number of courses
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}