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

package com.sambaash.platform.srv.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link CourseCareerLocalService}.
 *
 * @author gauravvijayvergia
 * @see CourseCareerLocalService
 * @generated
 */
public class CourseCareerLocalServiceWrapper implements CourseCareerLocalService,
	ServiceWrapper<CourseCareerLocalService> {
	public CourseCareerLocalServiceWrapper(
		CourseCareerLocalService courseCareerLocalService) {
		_courseCareerLocalService = courseCareerLocalService;
	}

	/**
	* Adds the course career to the database. Also notifies the appropriate model listeners.
	*
	* @param courseCareer the course career
	* @return the course career that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCareer addCourseCareer(
		com.sambaash.platform.srv.model.CourseCareer courseCareer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.addCourseCareer(courseCareer);
	}

	/**
	* Creates a new course career with the primary key. Does not add the course career to the database.
	*
	* @param spCourseCareerId the primary key for the new course career
	* @return the new course career
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCareer createCourseCareer(
		long spCourseCareerId) {
		return _courseCareerLocalService.createCourseCareer(spCourseCareerId);
	}

	/**
	* Deletes the course career with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseCareerId the primary key of the course career
	* @return the course career that was removed
	* @throws PortalException if a course career with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCareer deleteCourseCareer(
		long spCourseCareerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.deleteCourseCareer(spCourseCareerId);
	}

	/**
	* Deletes the course career from the database. Also notifies the appropriate model listeners.
	*
	* @param courseCareer the course career
	* @return the course career that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCareer deleteCourseCareer(
		com.sambaash.platform.srv.model.CourseCareer courseCareer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.deleteCourseCareer(courseCareer);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseCareerLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCareerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCareerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseCareer fetchCourseCareer(
		long spCourseCareerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.fetchCourseCareer(spCourseCareerId);
	}

	/**
	* Returns the course career with the primary key.
	*
	* @param spCourseCareerId the primary key of the course career
	* @return the course career
	* @throws PortalException if a course career with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCareer getCourseCareer(
		long spCourseCareerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.getCourseCareer(spCourseCareerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseCareer> getCourseCareers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.getCourseCareers(start, end);
	}

	/**
	* Returns the number of course careers.
	*
	* @return the number of course careers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCourseCareersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.getCourseCareersCount();
	}

	/**
	* Updates the course career in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseCareer the course career
	* @return the course career that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCareer updateCourseCareer(
		com.sambaash.platform.srv.model.CourseCareer courseCareer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.updateCourseCareer(courseCareer);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseCareerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseCareerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseCareerLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseCareer findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseCareerException {
		return _courseCareerLocalService.findByCourseId(courseId);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseCareer create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareerLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseCareerLocalService getWrappedCourseCareerLocalService() {
		return _courseCareerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseCareerLocalService(
		CourseCareerLocalService courseCareerLocalService) {
		_courseCareerLocalService = courseCareerLocalService;
	}

	@Override
	public CourseCareerLocalService getWrappedService() {
		return _courseCareerLocalService;
	}

	@Override
	public void setWrappedService(
		CourseCareerLocalService courseCareerLocalService) {
		_courseCareerLocalService = courseCareerLocalService;
	}

	private CourseCareerLocalService _courseCareerLocalService;
}