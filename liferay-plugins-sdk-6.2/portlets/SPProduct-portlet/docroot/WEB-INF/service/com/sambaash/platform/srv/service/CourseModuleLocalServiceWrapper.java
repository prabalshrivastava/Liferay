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
 * Provides a wrapper for {@link CourseModuleLocalService}.
 *
 * @author gauravvijayvergia
 * @see CourseModuleLocalService
 * @generated
 */
public class CourseModuleLocalServiceWrapper implements CourseModuleLocalService,
	ServiceWrapper<CourseModuleLocalService> {
	public CourseModuleLocalServiceWrapper(
		CourseModuleLocalService courseModuleLocalService) {
		_courseModuleLocalService = courseModuleLocalService;
	}

	/**
	* Adds the course module to the database. Also notifies the appropriate model listeners.
	*
	* @param courseModule the course module
	* @return the course module that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseModule addCourseModule(
		com.sambaash.platform.srv.model.CourseModule courseModule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.addCourseModule(courseModule);
	}

	/**
	* Creates a new course module with the primary key. Does not add the course module to the database.
	*
	* @param spCourseModuleId the primary key for the new course module
	* @return the new course module
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseModule createCourseModule(
		long spCourseModuleId) {
		return _courseModuleLocalService.createCourseModule(spCourseModuleId);
	}

	/**
	* Deletes the course module with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseModuleId the primary key of the course module
	* @return the course module that was removed
	* @throws PortalException if a course module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseModule deleteCourseModule(
		long spCourseModuleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.deleteCourseModule(spCourseModuleId);
	}

	/**
	* Deletes the course module from the database. Also notifies the appropriate model listeners.
	*
	* @param courseModule the course module
	* @return the course module that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseModule deleteCourseModule(
		com.sambaash.platform.srv.model.CourseModule courseModule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.deleteCourseModule(courseModule);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseModuleLocalService.dynamicQuery();
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
		return _courseModuleLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseModuleLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseModuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseModuleLocalService.dynamicQuery(dynamicQuery, start, end,
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
		return _courseModuleLocalService.dynamicQueryCount(dynamicQuery);
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
		return _courseModuleLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseModule fetchCourseModule(
		long spCourseModuleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.fetchCourseModule(spCourseModuleId);
	}

	/**
	* Returns the course module with the primary key.
	*
	* @param spCourseModuleId the primary key of the course module
	* @return the course module
	* @throws PortalException if a course module with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseModule getCourseModule(
		long spCourseModuleId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.getCourseModule(spCourseModuleId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.getPersistedModel(primaryKeyObj);
	}

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
	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> getCourseModules(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.getCourseModules(start, end);
	}

	/**
	* Returns the number of course modules.
	*
	* @return the number of course modules
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCourseModulesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.getCourseModulesCount();
	}

	/**
	* Updates the course module in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseModule the course module
	* @return the course module that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseModule updateCourseModule(
		com.sambaash.platform.srv.model.CourseModule courseModule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.updateCourseModule(courseModule);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseModuleLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseModuleLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseModuleLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.findByCourseIdAndGroupId(spCourseId,
			groupId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseModule> findByModuleIdAndGroupId(
		long spModuleId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.findByModuleIdAndGroupId(spModuleId,
			groupId);
	}

	@Override
	public void clearCache() {
		_courseModuleLocalService.clearCache();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseModule create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModuleLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseModuleLocalService getWrappedCourseModuleLocalService() {
		return _courseModuleLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseModuleLocalService(
		CourseModuleLocalService courseModuleLocalService) {
		_courseModuleLocalService = courseModuleLocalService;
	}

	@Override
	public CourseModuleLocalService getWrappedService() {
		return _courseModuleLocalService;
	}

	@Override
	public void setWrappedService(
		CourseModuleLocalService courseModuleLocalService) {
		_courseModuleLocalService = courseModuleLocalService;
	}

	private CourseModuleLocalService _courseModuleLocalService;
}