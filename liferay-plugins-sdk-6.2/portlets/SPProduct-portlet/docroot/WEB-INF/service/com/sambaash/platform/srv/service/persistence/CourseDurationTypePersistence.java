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

import com.sambaash.platform.srv.model.CourseDurationType;

/**
 * The persistence interface for the course duration type service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseDurationTypePersistenceImpl
 * @see CourseDurationTypeUtil
 * @generated
 */
public interface CourseDurationTypePersistence extends BasePersistence<CourseDurationType> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseDurationTypeUtil} to access the course duration type persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the course duration types where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course duration types where spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of course duration types
	* @param end the upper bound of the range of course duration types (not inclusive)
	* @return the range of matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseId(
		long spCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course duration types where spCourseId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param start the lower bound of the range of course duration types
	* @param end the upper bound of the range of course duration types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseId(
		long spCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course duration type in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType findByCourseId_First(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException;

	/**
	* Returns the first course duration type in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course duration type, or <code>null</code> if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType fetchByCourseId_First(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course duration type in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType findByCourseId_Last(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException;

	/**
	* Returns the last course duration type in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course duration type, or <code>null</code> if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType fetchByCourseId_Last(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course duration types before and after the current course duration type in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseDurationTypeId the primary key of the current course duration type
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType[] findByCourseId_PrevAndNext(
		long spCourseDurationTypeId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException;

	/**
	* Removes all the course duration types where spCourseId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course duration types where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the number of matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course duration types where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @return the matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseDurationId(
		long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course duration types where spCourseDurationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseDurationId the sp course duration ID
	* @param start the lower bound of the range of course duration types
	* @param end the upper bound of the range of course duration types (not inclusive)
	* @return the range of matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseDurationId(
		long spCourseDurationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course duration types where spCourseDurationId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseDurationId the sp course duration ID
	* @param start the lower bound of the range of course duration types
	* @param end the upper bound of the range of course duration types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseDurationId(
		long spCourseDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course duration type in the ordered set where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType findByCourseDurationId_First(
		long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException;

	/**
	* Returns the first course duration type in the ordered set where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course duration type, or <code>null</code> if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType fetchByCourseDurationId_First(
		long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course duration type in the ordered set where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType findByCourseDurationId_Last(
		long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException;

	/**
	* Returns the last course duration type in the ordered set where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course duration type, or <code>null</code> if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType fetchByCourseDurationId_Last(
		long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course duration types before and after the current course duration type in the ordered set where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationTypeId the primary key of the current course duration type
	* @param spCourseDurationId the sp course duration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType[] findByCourseDurationId_PrevAndNext(
		long spCourseDurationTypeId, long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException;

	/**
	* Removes all the course duration types where spCourseDurationId = &#63; from the database.
	*
	* @param spCourseDurationId the sp course duration ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseDurationId(long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course duration types where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @return the number of matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseDurationId(long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the course duration type in the entity cache if it is enabled.
	*
	* @param courseDurationType the course duration type
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.CourseDurationType courseDurationType);

	/**
	* Caches the course duration types in the entity cache if it is enabled.
	*
	* @param courseDurationTypes the course duration types
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseDurationType> courseDurationTypes);

	/**
	* Creates a new course duration type with the primary key. Does not add the course duration type to the database.
	*
	* @param spCourseDurationTypeId the primary key for the new course duration type
	* @return the new course duration type
	*/
	public com.sambaash.platform.srv.model.CourseDurationType create(
		long spCourseDurationTypeId);

	/**
	* Removes the course duration type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseDurationTypeId the primary key of the course duration type
	* @return the course duration type that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType remove(
		long spCourseDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException;

	public com.sambaash.platform.srv.model.CourseDurationType updateImpl(
		com.sambaash.platform.srv.model.CourseDurationType courseDurationType)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course duration type with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseDurationTypeException} if it could not be found.
	*
	* @param spCourseDurationTypeId the primary key of the course duration type
	* @return the course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType findByPrimaryKey(
		long spCourseDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException;

	/**
	* Returns the course duration type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseDurationTypeId the primary key of the course duration type
	* @return the course duration type, or <code>null</code> if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseDurationType fetchByPrimaryKey(
		long spCourseDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course duration types.
	*
	* @return the course duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course duration types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course duration types
	* @param end the upper bound of the range of course duration types (not inclusive)
	* @return the range of course duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course duration types.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course duration types
	* @param end the upper bound of the range of course duration types (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course duration types
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course duration types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course duration types.
	*
	* @return the number of course duration types
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}