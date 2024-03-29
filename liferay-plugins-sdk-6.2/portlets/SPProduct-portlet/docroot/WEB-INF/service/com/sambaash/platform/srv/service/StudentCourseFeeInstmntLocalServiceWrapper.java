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
 * Provides a wrapper for {@link StudentCourseFeeInstmntLocalService}.
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeeInstmntLocalService
 * @generated
 */
public class StudentCourseFeeInstmntLocalServiceWrapper
	implements StudentCourseFeeInstmntLocalService,
		ServiceWrapper<StudentCourseFeeInstmntLocalService> {
	public StudentCourseFeeInstmntLocalServiceWrapper(
		StudentCourseFeeInstmntLocalService studentCourseFeeInstmntLocalService) {
		_studentCourseFeeInstmntLocalService = studentCourseFeeInstmntLocalService;
	}

	/**
	* Adds the student course fee instmnt to the database. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFeeInstmnt the student course fee instmnt
	* @return the student course fee instmnt that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt addStudentCourseFeeInstmnt(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.addStudentCourseFeeInstmnt(studentCourseFeeInstmnt);
	}

	/**
	* Creates a new student course fee instmnt with the primary key. Does not add the student course fee instmnt to the database.
	*
	* @param spStudentCourseFeeInstmntId the primary key for the new student course fee instmnt
	* @return the new student course fee instmnt
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt createStudentCourseFeeInstmnt(
		long spStudentCourseFeeInstmntId) {
		return _studentCourseFeeInstmntLocalService.createStudentCourseFeeInstmnt(spStudentCourseFeeInstmntId);
	}

	/**
	* Deletes the student course fee instmnt with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	* @return the student course fee instmnt that was removed
	* @throws PortalException if a student course fee instmnt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt deleteStudentCourseFeeInstmnt(
		long spStudentCourseFeeInstmntId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.deleteStudentCourseFeeInstmnt(spStudentCourseFeeInstmntId);
	}

	/**
	* Deletes the student course fee instmnt from the database. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFeeInstmnt the student course fee instmnt
	* @return the student course fee instmnt that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt deleteStudentCourseFeeInstmnt(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.deleteStudentCourseFeeInstmnt(studentCourseFeeInstmnt);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentCourseFeeInstmntLocalService.dynamicQuery();
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
		return _studentCourseFeeInstmntLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _studentCourseFeeInstmntLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _studentCourseFeeInstmntLocalService.dynamicQuery(dynamicQuery,
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
		return _studentCourseFeeInstmntLocalService.dynamicQueryCount(dynamicQuery);
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
		return _studentCourseFeeInstmntLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt fetchStudentCourseFeeInstmnt(
		long spStudentCourseFeeInstmntId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.fetchStudentCourseFeeInstmnt(spStudentCourseFeeInstmntId);
	}

	/**
	* Returns the student course fee instmnt with the primary key.
	*
	* @param spStudentCourseFeeInstmntId the primary key of the student course fee instmnt
	* @return the student course fee instmnt
	* @throws PortalException if a student course fee instmnt with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt getStudentCourseFeeInstmnt(
		long spStudentCourseFeeInstmntId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.getStudentCourseFeeInstmnt(spStudentCourseFeeInstmntId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the student course fee instmnts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeInstmntModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student course fee instmnts
	* @param end the upper bound of the range of student course fee instmnts (not inclusive)
	* @return the range of student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> getStudentCourseFeeInstmnts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.getStudentCourseFeeInstmnts(start,
			end);
	}

	/**
	* Returns the number of student course fee instmnts.
	*
	* @return the number of student course fee instmnts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStudentCourseFeeInstmntsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.getStudentCourseFeeInstmntsCount();
	}

	/**
	* Updates the student course fee instmnt in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFeeInstmnt the student course fee instmnt
	* @return the student course fee instmnt that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt updateStudentCourseFeeInstmnt(
		com.sambaash.platform.srv.model.StudentCourseFeeInstmnt studentCourseFeeInstmnt)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.updateStudentCourseFeeInstmnt(studentCourseFeeInstmnt);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _studentCourseFeeInstmntLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_studentCourseFeeInstmntLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _studentCourseFeeInstmntLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.create();
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.StudentCourseFeeInstmnt> findByProcessStateId(
		long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeInstmntLocalService.findByProcessStateId(processStateId);
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFeeInstmnt findByProcessStateIdInstmntNo(
		long processStateId, int instmntNo)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeInstmntException {
		return _studentCourseFeeInstmntLocalService.findByProcessStateIdInstmntNo(processStateId,
			instmntNo);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StudentCourseFeeInstmntLocalService getWrappedStudentCourseFeeInstmntLocalService() {
		return _studentCourseFeeInstmntLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStudentCourseFeeInstmntLocalService(
		StudentCourseFeeInstmntLocalService studentCourseFeeInstmntLocalService) {
		_studentCourseFeeInstmntLocalService = studentCourseFeeInstmntLocalService;
	}

	@Override
	public StudentCourseFeeInstmntLocalService getWrappedService() {
		return _studentCourseFeeInstmntLocalService;
	}

	@Override
	public void setWrappedService(
		StudentCourseFeeInstmntLocalService studentCourseFeeInstmntLocalService) {
		_studentCourseFeeInstmntLocalService = studentCourseFeeInstmntLocalService;
	}

	private StudentCourseFeeInstmntLocalService _studentCourseFeeInstmntLocalService;
}