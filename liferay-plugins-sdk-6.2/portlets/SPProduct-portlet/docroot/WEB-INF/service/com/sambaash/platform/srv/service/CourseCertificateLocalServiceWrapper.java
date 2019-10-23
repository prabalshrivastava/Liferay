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
 * Provides a wrapper for {@link CourseCertificateLocalService}.
 *
 * @author gauravvijayvergia
 * @see CourseCertificateLocalService
 * @generated
 */
public class CourseCertificateLocalServiceWrapper
	implements CourseCertificateLocalService,
		ServiceWrapper<CourseCertificateLocalService> {
	public CourseCertificateLocalServiceWrapper(
		CourseCertificateLocalService courseCertificateLocalService) {
		_courseCertificateLocalService = courseCertificateLocalService;
	}

	/**
	* Adds the course certificate to the database. Also notifies the appropriate model listeners.
	*
	* @param courseCertificate the course certificate
	* @return the course certificate that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCertificate addCourseCertificate(
		com.sambaash.platform.srv.model.CourseCertificate courseCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.addCourseCertificate(courseCertificate);
	}

	/**
	* Creates a new course certificate with the primary key. Does not add the course certificate to the database.
	*
	* @param spCourseCertificateId the primary key for the new course certificate
	* @return the new course certificate
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCertificate createCourseCertificate(
		long spCourseCertificateId) {
		return _courseCertificateLocalService.createCourseCertificate(spCourseCertificateId);
	}

	/**
	* Deletes the course certificate with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spCourseCertificateId the primary key of the course certificate
	* @return the course certificate that was removed
	* @throws PortalException if a course certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCertificate deleteCourseCertificate(
		long spCourseCertificateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.deleteCourseCertificate(spCourseCertificateId);
	}

	/**
	* Deletes the course certificate from the database. Also notifies the appropriate model listeners.
	*
	* @param courseCertificate the course certificate
	* @return the course certificate that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCertificate deleteCourseCertificate(
		com.sambaash.platform.srv.model.CourseCertificate courseCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.deleteCourseCertificate(courseCertificate);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _courseCertificateLocalService.dynamicQuery();
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
		return _courseCertificateLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseCertificateLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _courseCertificateLocalService.dynamicQuery(dynamicQuery, start,
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
		return _courseCertificateLocalService.dynamicQueryCount(dynamicQuery);
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
		return _courseCertificateLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.CourseCertificate fetchCourseCertificate(
		long spCourseCertificateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.fetchCourseCertificate(spCourseCertificateId);
	}

	/**
	* Returns the course certificate with the primary key.
	*
	* @param spCourseCertificateId the primary key of the course certificate
	* @return the course certificate
	* @throws PortalException if a course certificate with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCertificate getCourseCertificate(
		long spCourseCertificateId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.getCourseCertificate(spCourseCertificateId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the course certificates.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.CourseCertificateModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of course certificates
	* @param end the upper bound of the range of course certificates (not inclusive)
	* @return the range of course certificates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseCertificate> getCourseCertificates(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.getCourseCertificates(start, end);
	}

	/**
	* Returns the number of course certificates.
	*
	* @return the number of course certificates
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getCourseCertificatesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.getCourseCertificatesCount();
	}

	/**
	* Updates the course certificate in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param courseCertificate the course certificate
	* @return the course certificate that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.CourseCertificate updateCourseCertificate(
		com.sambaash.platform.srv.model.CourseCertificate courseCertificate)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.updateCourseCertificate(courseCertificate);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _courseCertificateLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_courseCertificateLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _courseCertificateLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.CourseCertificate> findByCourseIdAndGroupId(
		long spCourseId, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.findByCourseIdAndGroupId(spCourseId,
			groupId);
	}

	@Override
	public void clearCache() {
		_courseCertificateLocalService.clearCache();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseCertificate create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCertificateLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public CourseCertificateLocalService getWrappedCourseCertificateLocalService() {
		return _courseCertificateLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedCourseCertificateLocalService(
		CourseCertificateLocalService courseCertificateLocalService) {
		_courseCertificateLocalService = courseCertificateLocalService;
	}

	@Override
	public CourseCertificateLocalService getWrappedService() {
		return _courseCertificateLocalService;
	}

	@Override
	public void setWrappedService(
		CourseCertificateLocalService courseCertificateLocalService) {
		_courseCertificateLocalService = courseCertificateLocalService;
	}

	private CourseCertificateLocalService _courseCertificateLocalService;
}