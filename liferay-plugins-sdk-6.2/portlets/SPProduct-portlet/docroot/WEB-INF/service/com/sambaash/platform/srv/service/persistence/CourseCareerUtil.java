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

import com.sambaash.platform.srv.model.CourseCareer;

import java.util.List;

/**
 * The persistence utility for the course career service. This utility wraps {@link CourseCareerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseCareerPersistence
 * @see CourseCareerPersistenceImpl
 * @generated
 */
public class CourseCareerUtil {
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
	public static void clearCache(CourseCareer courseCareer) {
		getPersistence().clearCache(courseCareer);
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
	public static List<CourseCareer> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CourseCareer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CourseCareer> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CourseCareer update(CourseCareer courseCareer)
		throws SystemException {
		return getPersistence().update(courseCareer);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CourseCareer update(CourseCareer courseCareer,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(courseCareer, serviceContext);
	}

	/**
	* Returns the course career where spCourseId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseCareerException} if it could not be found.
	*
	* @param spCourseId the sp course ID
	* @return the matching course career
	* @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a matching course career could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseCareer findByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseCareerException {
		return getPersistence().findByCourseId(spCourseId);
	}

	/**
	* Returns the course career where spCourseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCourseId the sp course ID
	* @return the matching course career, or <code>null</code> if a matching course career could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseCareer fetchByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseId(spCourseId);
	}

	/**
	* Returns the course career where spCourseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course career, or <code>null</code> if a matching course career could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseCareer fetchByCourseId(
		long spCourseId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseId(spCourseId, retrieveFromCache);
	}

	/**
	* Removes the course career where spCourseId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @return the course career that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseCareer removeByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseCareerException {
		return getPersistence().removeByCourseId(spCourseId);
	}

	/**
	* Returns the number of course careers where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the number of matching course careers
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseId(spCourseId);
	}

	/**
	* Caches the course career in the entity cache if it is enabled.
	*
	* @param courseCareer the course career
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.CourseCareer courseCareer) {
		getPersistence().cacheResult(courseCareer);
	}

	/**
	* Caches the course careers in the entity cache if it is enabled.
	*
	* @param courseCareers the course careers
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseCareer> courseCareers) {
		getPersistence().cacheResult(courseCareers);
	}

	/**
	* Creates a new course career with the primary key. Does not add the course career to the database.
	*
	* @param spCourseCareerId the primary key for the new course career
	* @return the new course career
	*/
	public static com.sambaash.platform.srv.model.CourseCareer create(
		long spCourseCareerId) {
		return getPersistence().create(spCourseCareerId);
	}

	/**
	* Removes the course career with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseCareerId the primary key of the course career
	* @return the course career that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a course career with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseCareer remove(
		long spCourseCareerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseCareerException {
		return getPersistence().remove(spCourseCareerId);
	}

	public static com.sambaash.platform.srv.model.CourseCareer updateImpl(
		com.sambaash.platform.srv.model.CourseCareer courseCareer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(courseCareer);
	}

	/**
	* Returns the course career with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseCareerException} if it could not be found.
	*
	* @param spCourseCareerId the primary key of the course career
	* @return the course career
	* @throws com.sambaash.platform.srv.NoSuchCourseCareerException if a course career with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseCareer findByPrimaryKey(
		long spCourseCareerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseCareerException {
		return getPersistence().findByPrimaryKey(spCourseCareerId);
	}

	/**
	* Returns the course career with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseCareerId the primary key of the course career
	* @return the course career, or <code>null</code> if a course career with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseCareer fetchByPrimaryKey(
		long spCourseCareerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spCourseCareerId);
	}

	/**
	* Returns all the course careers.
	*
	* @return the course careers
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseCareer> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseCareer> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseCareer> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the course careers from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of course careers.
	*
	* @return the number of course careers
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CourseCareerPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CourseCareerPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					CourseCareerPersistence.class.getName());

			ReferenceRegistry.registerReference(CourseCareerUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CourseCareerPersistence persistence) {
	}

	private static CourseCareerPersistence _persistence;
}