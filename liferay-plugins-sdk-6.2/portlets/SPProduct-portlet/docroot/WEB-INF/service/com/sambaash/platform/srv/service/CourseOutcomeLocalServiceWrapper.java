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
 * Provides a wrapper for {@link CourseOutcomeLocalService}.
 *
 * @author gauravvijayvergia
 * @see CourseOutcomeLocalService
 * @generated
 */
public class CourseOutcomeLocalServiceWrapper
	implements CourseOutcomeLocalService,
		ServiceWrapper<CourseOutcomeLocalService> {
	public CourseOutcomeLocalServiceWrapper(
		CourseOutcomeLocalService courseOutcomeLocalService) {
		_courseOutcomeLocalService = courseOutcomeLocalService;
	}

	/**
	* Adds the course outcome to the database. Also notifies the appropriate model listeners.
	*
	* @param courseOutcome the course outcome
	* @return the course outcome that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseOutcome addCourseOutcome(
		com.sambaash.platform.srv.model.CourseOutcome courseOutcome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.addCourseOutcome(courseOutcome);
	}

	/**
	* Creates a new course outcome with the primary key. Does not add the course outcome to the database.
	*
	* @param spCourseOutcomeId the primary key for the new course outcome
	* @return the new course outcome
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseOutcome createCourseOutcome(
		long spCourseOutcomeId) {
		return _courseOutcomeLocalService.createCourseOutcome(spCourseOutcomeId);
	}

	/**
	* Deletes the course outcome with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseOutcomeId the primary key of the course outcome
	* @return the course outcome that was removed
	* @throws PortalException if a course outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseOutcome deleteCourseOutcome(
		long spCourseOutcomeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.deleteCourseOutcome(spCourseOutcomeId);
	}

	/**
	* Deletes the course outcome from the database. Also notifies the appropriate model listeners.
	*
	* @param courseOutcome the course outcome
	* @return the course outcome that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseOutcome deleteCourseOutcome(
		com.sambaash.platform.srv.model.CourseOutcome courseOutcome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.deleteCourseOutcome(courseOutcome);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseOutcomeLocalService.dynamicQuery();
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
		return _courseOutcomeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseOutcomeLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseOutcomeLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
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
		return _courseOutcomeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _courseOutcomeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseOutcome fetchCourseOutcome(
		long spCourseOutcomeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.fetchCourseOutcome(spCourseOutcomeId);
	}

	/**
	* Returns the course outcome with the primary key.
	*
	* @param spCourseOutcomeId the primary key of the course outcome
	* @return the course outcome
	* @throws PortalException if a course outcome with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseOutcome getCourseOutcome(
		long spCourseOutcomeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.getCourseOutcome(spCourseOutcomeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the course outcomes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseOutcomeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course outcomes
	* @param end the upper bound of the range of course outcomes (not inclusive)
	* @return the range of course outcomes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseOutcome> getCourseOutcomes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.getCourseOutcomes(start, end);
	}

	/**
	* Returns the number of course outcomes.
	*
	* @return the number of course outcomes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCourseOutcomesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.getCourseOutcomesCount();
	}

	/**
	* Updates the course outcome in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseOutcome the course outcome
	* @return the course outcome that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseOutcome updateCourseOutcome(
		com.sambaash.platform.srv.model.CourseOutcome courseOutcome)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.updateCourseOutcome(courseOutcome);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseOutcomeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseOutcomeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseOutcomeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseOutcome> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.findByCourseIdAndGroupId(spCourseId,
			groupId);
	}

	@Override
	public void clearCache() {
		_courseOutcomeLocalService.clearCache();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseOutcome create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcomeLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseOutcomeLocalService getWrappedCourseOutcomeLocalService() {
		return _courseOutcomeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseOutcomeLocalService(
		CourseOutcomeLocalService courseOutcomeLocalService) {
		_courseOutcomeLocalService = courseOutcomeLocalService;
	}

	@Override
	public CourseOutcomeLocalService getWrappedService() {
		return _courseOutcomeLocalService;
	}

	@Override
	public void setWrappedService(
		CourseOutcomeLocalService courseOutcomeLocalService) {
		_courseOutcomeLocalService = courseOutcomeLocalService;
	}

	private CourseOutcomeLocalService _courseOutcomeLocalService;
}