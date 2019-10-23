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

import com.sambaash.platform.srv.model.CourseModule;

/**
 * The persistence interface for the course module service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseModulePersistenceImpl
 * @see CourseModuleUtil
 * @generated
 */
public interface CourseModulePersistence extends BasePersistence<CourseModule> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link CourseModuleUtil} to access the course module persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the course modules where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course modules where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of course modules
	* @param end the upper bound of the range of course modules (not inclusive)
	* @return the range of matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course modules where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of course modules
	* @param end the upper bound of the range of course modules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course module in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Returns the first course module in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course module, or <code>null</code> if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course module in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Returns the last course module in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course module, or <code>null</code> if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course modules before and after the current course module in the ordered set where groupId = &#63;.
	*
	* @param spCourseModuleId the primary key of the current course module
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule[] findByGroupId_PrevAndNext(
		long spCourseModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Removes all the course modules where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course modules where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course modules where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByModuleIdAndGroupId(
		long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course modules where spModuleId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param start the lower bound of the range of course modules
	* @param end the upper bound of the range of course modules (not inclusive)
	* @return the range of matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course modules where spModuleId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param start the lower bound of the range of course modules
	* @param end the upper bound of the range of course modules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByModuleIdAndGroupId(
		long spModuleId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule findByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Returns the first course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course module, or <code>null</code> if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule fetchByModuleIdAndGroupId_First(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule findByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Returns the last course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course module, or <code>null</code> if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule fetchByModuleIdAndGroupId_Last(
		long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course modules before and after the current course module in the ordered set where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spCourseModuleId the primary key of the current course module
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule[] findByModuleIdAndGroupId_PrevAndNext(
		long spCourseModuleId, long spModuleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Removes all the course modules where spModuleId = &#63; and groupId = &#63; from the database.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course modules where spModuleId = &#63; and groupId = &#63;.
	*
	* @param spModuleId the sp module ID
	* @param groupId the group ID
	* @return the number of matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public int countByModuleIdAndGroupId(long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course modules where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course modules where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of course modules
	* @param end the upper bound of the range of course modules (not inclusive)
	* @return the range of matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course modules where spCourseId = &#63; and groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param start the lower bound of the range of course modules
	* @param end the upper bound of the range of course modules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByCourseIdAndGroupId(
		long spCourseId, long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule findByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Returns the first course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course module, or <code>null</code> if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule fetchByCourseIdAndGroupId_First(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule findByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Returns the last course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course module, or <code>null</code> if a matching course module could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule fetchByCourseIdAndGroupId_Last(
		long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course modules before and after the current course module in the ordered set where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseModuleId the primary key of the current course module
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule[] findByCourseIdAndGroupId_PrevAndNext(
		long spCourseModuleId, long spCourseId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Removes all the course modules where spCourseId = &#63; and groupId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course modules where spCourseId = &#63; and groupId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param groupId the group ID
	* @return the number of matching course modules
	* @throws SystemException if a system exception occurred
	*/
	public int countByCourseIdAndGroupId(long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the course module in the entity cache if it is enabled.
	*
	* @param courseModule the course module
	*/
	public void cacheResult(
		com.sambaash.platform.srv.model.CourseModule courseModule);

	/**
	* Caches the course modules in the entity cache if it is enabled.
	*
	* @param courseModules the course modules
	*/
	public void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseModule> courseModules);

	/**
	* Creates a new course module with the primary key. Does not add the course module to the database.
	*
	* @param spCourseModuleId the primary key for the new course module
	* @return the new course module
	*/
	public com.sambaash.platform.srv.model.CourseModule create(
		long spCourseModuleId);

	/**
	* Removes the course module with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseModuleId the primary key of the course module
	* @return the course module that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule remove(
		long spCourseModuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	public com.sambaash.platform.srv.model.CourseModule updateImpl(
		com.sambaash.platform.srv.model.CourseModule courseModule)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the course module with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseModuleException} if it could not be found.
	*
	* @param spCourseModuleId the primary key of the course module
	* @return the course module
	* @throws com.sambaash.platform.srv.NoSuchCourseModuleException if a course module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule findByPrimaryKey(
		long spCourseModuleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseModuleException;

	/**
	* Returns the course module with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseModuleId the primary key of the course module
	* @return the course module, or <code>null</code> if a course module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.sambaash.platform.srv.model.CourseModule fetchByPrimaryKey(
		long spCourseModuleId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the course modules.
	*
	* @return the course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the course modules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course modules
	* @param end the upper bound of the range of course modules (not inclusive)
	* @return the range of course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the course modules.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course modules
	* @param end the upper bound of the range of course modules (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of course modules
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the course modules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of course modules.
	*
	* @return the number of course modules
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}