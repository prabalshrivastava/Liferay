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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.sambaash.platform.srv.model.CourseDurationType;

import java.util.List;

/**
 * The persistence utility for the course duration type service. This utility wraps {@link CourseDurationTypePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseDurationTypePersistence
 * @see CourseDurationTypePersistenceImpl
 * @generated
 */
public class CourseDurationTypeUtil {
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
	public static void clearCache(CourseDurationType courseDurationType) {
		getPersistence().clearCache(courseDurationType);
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
	public static List<CourseDurationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CourseDurationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CourseDurationType> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CourseDurationType update(
		CourseDurationType courseDurationType) throws SystemException {
		return getPersistence().update(courseDurationType);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CourseDurationType update(
		CourseDurationType courseDurationType, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(courseDurationType, serviceContext);
	}

	/**
	* Returns all the course duration types where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(spCourseId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseId(
		long spCourseId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseId(spCourseId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseId(
		long spCourseId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseId(spCourseId, start, end, orderByComparator);
	}

	/**
	* Returns the first course duration type in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType findByCourseId_First(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException {
		return getPersistence()
				   .findByCourseId_First(spCourseId, orderByComparator);
	}

	/**
	* Returns the first course duration type in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course duration type, or <code>null</code> if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType fetchByCourseId_First(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseId_First(spCourseId, orderByComparator);
	}

	/**
	* Returns the last course duration type in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType findByCourseId_Last(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException {
		return getPersistence()
				   .findByCourseId_Last(spCourseId, orderByComparator);
	}

	/**
	* Returns the last course duration type in the ordered set where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course duration type, or <code>null</code> if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType fetchByCourseId_Last(
		long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseId_Last(spCourseId, orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.CourseDurationType[] findByCourseId_PrevAndNext(
		long spCourseDurationTypeId, long spCourseId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException {
		return getPersistence()
				   .findByCourseId_PrevAndNext(spCourseDurationTypeId,
			spCourseId, orderByComparator);
	}

	/**
	* Removes all the course duration types where spCourseId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseId(spCourseId);
	}

	/**
	* Returns the number of course duration types where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the number of matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseId(spCourseId);
	}

	/**
	* Returns all the course duration types where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @return the matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseDurationId(
		long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCourseDurationId(spCourseDurationId);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseDurationId(
		long spCourseDurationId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseDurationId(spCourseDurationId, start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseDurationId(
		long spCourseDurationId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCourseDurationId(spCourseDurationId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first course duration type in the ordered set where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType findByCourseDurationId_First(
		long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException {
		return getPersistence()
				   .findByCourseDurationId_First(spCourseDurationId,
			orderByComparator);
	}

	/**
	* Returns the first course duration type in the ordered set where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching course duration type, or <code>null</code> if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType fetchByCourseDurationId_First(
		long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseDurationId_First(spCourseDurationId,
			orderByComparator);
	}

	/**
	* Returns the last course duration type in the ordered set where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType findByCourseDurationId_Last(
		long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException {
		return getPersistence()
				   .findByCourseDurationId_Last(spCourseDurationId,
			orderByComparator);
	}

	/**
	* Returns the last course duration type in the ordered set where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching course duration type, or <code>null</code> if a matching course duration type could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType fetchByCourseDurationId_Last(
		long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCourseDurationId_Last(spCourseDurationId,
			orderByComparator);
	}

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
	public static com.sambaash.platform.srv.model.CourseDurationType[] findByCourseDurationId_PrevAndNext(
		long spCourseDurationTypeId, long spCourseDurationId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException {
		return getPersistence()
				   .findByCourseDurationId_PrevAndNext(spCourseDurationTypeId,
			spCourseDurationId, orderByComparator);
	}

	/**
	* Removes all the course duration types where spCourseDurationId = &#63; from the database.
	*
	* @param spCourseDurationId the sp course duration ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCourseDurationId(long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCourseDurationId(spCourseDurationId);
	}

	/**
	* Returns the number of course duration types where spCourseDurationId = &#63;.
	*
	* @param spCourseDurationId the sp course duration ID
	* @return the number of matching course duration types
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseDurationId(long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseDurationId(spCourseDurationId);
	}

	/**
	* Caches the course duration type in the entity cache if it is enabled.
	*
	* @param courseDurationType the course duration type
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.CourseDurationType courseDurationType) {
		getPersistence().cacheResult(courseDurationType);
	}

	/**
	* Caches the course duration types in the entity cache if it is enabled.
	*
	* @param courseDurationTypes the course duration types
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseDurationType> courseDurationTypes) {
		getPersistence().cacheResult(courseDurationTypes);
	}

	/**
	* Creates a new course duration type with the primary key. Does not add the course duration type to the database.
	*
	* @param spCourseDurationTypeId the primary key for the new course duration type
	* @return the new course duration type
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType create(
		long spCourseDurationTypeId) {
		return getPersistence().create(spCourseDurationTypeId);
	}

	/**
	* Removes the course duration type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseDurationTypeId the primary key of the course duration type
	* @return the course duration type that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType remove(
		long spCourseDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException {
		return getPersistence().remove(spCourseDurationTypeId);
	}

	public static com.sambaash.platform.srv.model.CourseDurationType updateImpl(
		com.sambaash.platform.srv.model.CourseDurationType courseDurationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(courseDurationType);
	}

	/**
	* Returns the course duration type with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseDurationTypeException} if it could not be found.
	*
	* @param spCourseDurationTypeId the primary key of the course duration type
	* @return the course duration type
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationTypeException if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType findByPrimaryKey(
		long spCourseDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationTypeException {
		return getPersistence().findByPrimaryKey(spCourseDurationTypeId);
	}

	/**
	* Returns the course duration type with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseDurationTypeId the primary key of the course duration type
	* @return the course duration type, or <code>null</code> if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDurationType fetchByPrimaryKey(
		long spCourseDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spCourseDurationTypeId);
	}

	/**
	* Returns all the course duration types.
	*
	* @return the course duration types
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the course duration types from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of course duration types.
	*
	* @return the number of course duration types
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CourseDurationTypePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CourseDurationTypePersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					CourseDurationTypePersistence.class.getName());

			ReferenceRegistry.registerReference(CourseDurationTypeUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CourseDurationTypePersistence persistence) {
	}

	private static CourseDurationTypePersistence _persistence;
}