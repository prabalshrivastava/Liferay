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
 * Provides a wrapper for {@link CourseDurationTypeLocalService}.
 *
 * @author gauravvijayvergia
 * @see CourseDurationTypeLocalService
 * @generated
 */
public class CourseDurationTypeLocalServiceWrapper
	implements CourseDurationTypeLocalService,
		ServiceWrapper<CourseDurationTypeLocalService> {
	public CourseDurationTypeLocalServiceWrapper(
		CourseDurationTypeLocalService courseDurationTypeLocalService) {
		_courseDurationTypeLocalService = courseDurationTypeLocalService;
	}

	/**
	* Adds the course duration type to the database. Also notifies the appropriate model listeners.
	*
	* @param courseDurationType the course duration type
	* @return the course duration type that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseDurationType addCourseDurationType(
		com.sambaash.platform.srv.model.CourseDurationType courseDurationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.addCourseDurationType(courseDurationType);
	}

	/**
	* Creates a new course duration type with the primary key. Does not add the course duration type to the database.
	*
	* @param spCourseDurationTypeId the primary key for the new course duration type
	* @return the new course duration type
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseDurationType createCourseDurationType(
		long spCourseDurationTypeId) {
		return _courseDurationTypeLocalService.createCourseDurationType(spCourseDurationTypeId);
	}

	/**
	* Deletes the course duration type with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseDurationTypeId the primary key of the course duration type
	* @return the course duration type that was removed
	* @throws PortalException if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseDurationType deleteCourseDurationType(
		long spCourseDurationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.deleteCourseDurationType(spCourseDurationTypeId);
	}

	/**
	* Deletes the course duration type from the database. Also notifies the appropriate model listeners.
	*
	* @param courseDurationType the course duration type
	* @return the course duration type that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseDurationType deleteCourseDurationType(
		com.sambaash.platform.srv.model.CourseDurationType courseDurationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.deleteCourseDurationType(courseDurationType);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseDurationTypeLocalService.dynamicQuery();
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
		return _courseDurationTypeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseDurationTypeLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseDurationTypeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseDurationTypeLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
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
		return _courseDurationTypeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _courseDurationTypeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseDurationType fetchCourseDurationType(
		long spCourseDurationTypeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.fetchCourseDurationType(spCourseDurationTypeId);
	}

	/**
	* Returns the course duration type with the primary key.
	*
	* @param spCourseDurationTypeId the primary key of the course duration type
	* @return the course duration type
	* @throws PortalException if a course duration type with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseDurationType getCourseDurationType(
		long spCourseDurationTypeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.getCourseDurationType(spCourseDurationTypeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> getCourseDurationTypes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.getCourseDurationTypes(start, end);
	}

	/**
	* Returns the number of course duration types.
	*
	* @return the number of course duration types
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCourseDurationTypesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.getCourseDurationTypesCount();
	}

	/**
	* Updates the course duration type in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseDurationType the course duration type
	* @return the course duration type that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseDurationType updateCourseDurationType(
		com.sambaash.platform.srv.model.CourseDurationType courseDurationType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.updateCourseDurationType(courseDurationType);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseDurationTypeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseDurationTypeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseDurationTypeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseId(
		long courseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.findByCourseId(courseId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseDurationType> findByCourseDurationId(
		long courseDurationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.findByCourseDurationId(courseDurationId);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseDurationType create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationTypeLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseDurationTypeLocalService getWrappedCourseDurationTypeLocalService() {
		return _courseDurationTypeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseDurationTypeLocalService(
		CourseDurationTypeLocalService courseDurationTypeLocalService) {
		_courseDurationTypeLocalService = courseDurationTypeLocalService;
	}

	@Override
	public CourseDurationTypeLocalService getWrappedService() {
		return _courseDurationTypeLocalService;
	}

	@Override
	public void setWrappedService(
		CourseDurationTypeLocalService courseDurationTypeLocalService) {
		_courseDurationTypeLocalService = courseDurationTypeLocalService;
	}

	private CourseDurationTypeLocalService _courseDurationTypeLocalService;
}