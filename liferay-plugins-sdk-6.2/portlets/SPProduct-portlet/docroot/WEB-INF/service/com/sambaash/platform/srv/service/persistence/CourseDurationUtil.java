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

import com.sambaash.platform.srv.model.CourseDuration;

import java.util.List;

/**
 * The persistence utility for the course duration service. This utility wraps {@link CourseDurationPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseDurationPersistence
 * @see CourseDurationPersistenceImpl
 * @generated
 */
public class CourseDurationUtil {
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
	public static void clearCache(CourseDuration courseDuration) {
		getPersistence().clearCache(courseDuration);
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
	public static List<CourseDuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<CourseDuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<CourseDuration> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static CourseDuration update(CourseDuration courseDuration)
		throws SystemException {
		return getPersistence().update(courseDuration);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static CourseDuration update(CourseDuration courseDuration,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(courseDuration, serviceContext);
	}

	/**
	* Returns the course duration where spCourseId = &#63; or throws a {@link com.sambaash.platform.srv.NoSuchCourseDurationException} if it could not be found.
	*
	* @param spCourseId the sp course ID
	* @return the matching course duration
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a matching course duration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDuration findByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationException {
		return getPersistence().findByCourseId(spCourseId);
	}

	/**
	* Returns the course duration where spCourseId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param spCourseId the sp course ID
	* @return the matching course duration, or <code>null</code> if a matching course duration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDuration fetchByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseId(spCourseId);
	}

	/**
	* Returns the course duration where spCourseId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param spCourseId the sp course ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching course duration, or <code>null</code> if a matching course duration could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDuration fetchByCourseId(
		long spCourseId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByCourseId(spCourseId, retrieveFromCache);
	}

	/**
	* Removes the course duration where spCourseId = &#63; from the database.
	*
	* @param spCourseId the sp course ID
	* @return the course duration that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDuration removeByCourseId(
		long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationException {
		return getPersistence().removeByCourseId(spCourseId);
	}

	/**
	* Returns the number of course durations where spCourseId = &#63;.
	*
	* @param spCourseId the sp course ID
	* @return the number of matching course durations
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCourseId(long spCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCourseId(spCourseId);
	}

	/**
	* Caches the course duration in the entity cache if it is enabled.
	*
	* @param courseDuration the course duration
	*/
	public static void cacheResult(
		com.sambaash.platform.srv.model.CourseDuration courseDuration) {
		getPersistence().cacheResult(courseDuration);
	}

	/**
	* Caches the course durations in the entity cache if it is enabled.
	*
	* @param courseDurations the course durations
	*/
	public static void cacheResult(
		java.util.List<com.sambaash.platform.srv.model.CourseDuration> courseDurations) {
		getPersistence().cacheResult(courseDurations);
	}

	/**
	* Creates a new course duration with the primary key. Does not add the course duration to the database.
	*
	* @param spCourseDurationId the primary key for the new course duration
	* @return the new course duration
	*/
	public static com.sambaash.platform.srv.model.CourseDuration create(
		long spCourseDurationId) {
		return getPersistence().create(spCourseDurationId);
	}

	/**
	* Removes the course duration with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseDurationId the primary key of the course duration
	* @return the course duration that was removed
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a course duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDuration remove(
		long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationException {
		return getPersistence().remove(spCourseDurationId);
	}

	public static com.sambaash.platform.srv.model.CourseDuration updateImpl(
		com.sambaash.platform.srv.model.CourseDuration courseDuration)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(courseDuration);
	}

	/**
	* Returns the course duration with the primary key or throws a {@link com.sambaash.platform.srv.NoSuchCourseDurationException} if it could not be found.
	*
	* @param spCourseDurationId the primary key of the course duration
	* @return the course duration
	* @throws com.sambaash.platform.srv.NoSuchCourseDurationException if a course duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDuration findByPrimaryKey(
		long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseDurationException {
		return getPersistence().findByPrimaryKey(spCourseDurationId);
	}

	/**
	* Returns the course duration with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param spCourseDurationId the primary key of the course duration
	* @return the course duration, or <code>null</code> if a course duration with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.sambaash.platform.srv.model.CourseDuration fetchByPrimaryKey(
		long spCourseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(spCourseDurationId);
	}

	/**
	* Returns all the course durations.
	*
	* @return the course durations
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.sambaash.platform.srv.model.CourseDuration> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseDuration> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.sambaash.platform.srv.model.CourseDuration> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the course durations from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of course durations.
	*
	* @return the number of course durations
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static CourseDurationPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (CourseDurationPersistence)PortletBeanLocatorUtil.locate(com.sambaash.platform.srv.service.ClpSerializer.getServletContextName(),
					CourseDurationPersistence.class.getName());

			ReferenceRegistry.registerReference(CourseDurationUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(CourseDurationPersistence persistence) {
	}

	private static CourseDurationPersistence _persistence;
}