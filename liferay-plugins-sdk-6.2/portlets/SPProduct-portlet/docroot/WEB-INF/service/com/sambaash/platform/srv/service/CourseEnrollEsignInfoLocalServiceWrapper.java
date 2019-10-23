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
 * Provides a wrapper for {@link CourseEnrollEsignInfoLocalService}.
 *
 * @author gauravvijayvergia
 * @see CourseEnrollEsignInfoLocalService
 * @generated
 */
public class CourseEnrollEsignInfoLocalServiceWrapper
	implements CourseEnrollEsignInfoLocalService,
		ServiceWrapper<CourseEnrollEsignInfoLocalService> {
	public CourseEnrollEsignInfoLocalServiceWrapper(
		CourseEnrollEsignInfoLocalService courseEnrollEsignInfoLocalService) {
		_courseEnrollEsignInfoLocalService = courseEnrollEsignInfoLocalService;
	}

	/**
	* Adds the course enroll esign info to the database. Also notifies the appropriate model listeners.
	*
	* @param courseEnrollEsignInfo the course enroll esign info
	* @return the course enroll esign info that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo addCourseEnrollEsignInfo(
		com.sambaash.platform.srv.model.CourseEnrollEsignInfo courseEnrollEsignInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.addCourseEnrollEsignInfo(courseEnrollEsignInfo);
	}

	/**
	* Creates a new course enroll esign info with the primary key. Does not add the course enroll esign info to the database.
	*
	* @param spEsignInfoId the primary key for the new course enroll esign info
	* @return the new course enroll esign info
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo createCourseEnrollEsignInfo(
		long spEsignInfoId) {
		return _courseEnrollEsignInfoLocalService.createCourseEnrollEsignInfo(spEsignInfoId);
	}

	/**
	* Deletes the course enroll esign info with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spEsignInfoId the primary key of the course enroll esign info
	* @return the course enroll esign info that was removed
	* @throws PortalException if a course enroll esign info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo deleteCourseEnrollEsignInfo(
		long spEsignInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.deleteCourseEnrollEsignInfo(spEsignInfoId);
	}

	/**
	* Deletes the course enroll esign info from the database. Also notifies the appropriate model listeners.
	*
	* @param courseEnrollEsignInfo the course enroll esign info
	* @return the course enroll esign info that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo deleteCourseEnrollEsignInfo(
		com.sambaash.platform.srv.model.CourseEnrollEsignInfo courseEnrollEsignInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.deleteCourseEnrollEsignInfo(courseEnrollEsignInfo);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseEnrollEsignInfoLocalService.dynamicQuery();
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
		return _courseEnrollEsignInfoLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseEnrollEsignInfoLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseEnrollEsignInfoLocalService.dynamicQuery(dynamicQuery,
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
		return _courseEnrollEsignInfoLocalService.dynamicQueryCount(dynamicQuery);
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
		return _courseEnrollEsignInfoLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo fetchCourseEnrollEsignInfo(
		long spEsignInfoId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.fetchCourseEnrollEsignInfo(spEsignInfoId);
	}

	/**
	* Returns the course enroll esign info with the primary key.
	*
	* @param spEsignInfoId the primary key of the course enroll esign info
	* @return the course enroll esign info
	* @throws PortalException if a course enroll esign info with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo getCourseEnrollEsignInfo(
		long spEsignInfoId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.getCourseEnrollEsignInfo(spEsignInfoId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the course enroll esign infos.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseEnrollEsignInfoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course enroll esign infos
	* @param end the upper bound of the range of course enroll esign infos (not inclusive)
	* @return the range of course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseEnrollEsignInfo> getCourseEnrollEsignInfos(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.getCourseEnrollEsignInfos(start,
			end);
	}

	/**
	* Returns the number of course enroll esign infos.
	*
	* @return the number of course enroll esign infos
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCourseEnrollEsignInfosCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.getCourseEnrollEsignInfosCount();
	}

	/**
	* Updates the course enroll esign info in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseEnrollEsignInfo the course enroll esign info
	* @return the course enroll esign info that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo updateCourseEnrollEsignInfo(
		com.sambaash.platform.srv.model.CourseEnrollEsignInfo courseEnrollEsignInfo)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.updateCourseEnrollEsignInfo(courseEnrollEsignInfo);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseEnrollEsignInfoLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseEnrollEsignInfoLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseEnrollEsignInfoLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseEnrollEsignInfoLocalService.create();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo findBySignerId(
		java.lang.String signerId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException {
		return _courseEnrollEsignInfoLocalService.findBySignerId(signerId);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo findByPackageId(
		java.lang.String PackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException {
		return _courseEnrollEsignInfoLocalService.findByPackageId(PackageId);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo findByDocumentId(
		java.lang.String DocumentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException {
		return _courseEnrollEsignInfoLocalService.findByDocumentId(DocumentId);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseEnrollEsignInfo findByProcessStateId(
		long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchCourseEnrollEsignInfoException {
		return _courseEnrollEsignInfoLocalService.findByProcessStateId(processStateId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseEnrollEsignInfoLocalService getWrappedCourseEnrollEsignInfoLocalService() {
		return _courseEnrollEsignInfoLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseEnrollEsignInfoLocalService(
		CourseEnrollEsignInfoLocalService courseEnrollEsignInfoLocalService) {
		_courseEnrollEsignInfoLocalService = courseEnrollEsignInfoLocalService;
	}

	@Override
	public CourseEnrollEsignInfoLocalService getWrappedService() {
		return _courseEnrollEsignInfoLocalService;
	}

	@Override
	public void setWrappedService(
		CourseEnrollEsignInfoLocalService courseEnrollEsignInfoLocalService) {
		_courseEnrollEsignInfoLocalService = courseEnrollEsignInfoLocalService;
	}

	private CourseEnrollEsignInfoLocalService _courseEnrollEsignInfoLocalService;
}