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
 * Provides a wrapper for {@link StudentCourseFeeLocalService}.
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeeLocalService
 * @generated
 */
public class StudentCourseFeeLocalServiceWrapper
	implements StudentCourseFeeLocalService,
		ServiceWrapper<StudentCourseFeeLocalService> {
	public StudentCourseFeeLocalServiceWrapper(
		StudentCourseFeeLocalService studentCourseFeeLocalService) {
		_studentCourseFeeLocalService = studentCourseFeeLocalService;
	}

	/**
	* Adds the student course fee to the database. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFee the student course fee
	* @return the student course fee that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee addStudentCourseFee(
		com.sambaash.platform.srv.model.StudentCourseFee studentCourseFee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.addStudentCourseFee(studentCourseFee);
	}

	/**
	* Creates a new student course fee with the primary key. Does not add the student course fee to the database.
	*
	* @param spStudentCourseFeeId the primary key for the new student course fee
	* @return the new student course fee
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee createStudentCourseFee(
		long spStudentCourseFeeId) {
		return _studentCourseFeeLocalService.createStudentCourseFee(spStudentCourseFeeId);
	}

	/**
	* Deletes the student course fee with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentCourseFeeId the primary key of the student course fee
	* @return the student course fee that was removed
	* @throws PortalException if a student course fee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee deleteStudentCourseFee(
		long spStudentCourseFeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.deleteStudentCourseFee(spStudentCourseFeeId);
	}

	/**
	* Deletes the student course fee from the database. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFee the student course fee
	* @return the student course fee that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee deleteStudentCourseFee(
		com.sambaash.platform.srv.model.StudentCourseFee studentCourseFee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.deleteStudentCourseFee(studentCourseFee);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _studentCourseFeeLocalService.dynamicQuery();
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
		return _studentCourseFeeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _studentCourseFeeLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _studentCourseFeeLocalService.dynamicQuery(dynamicQuery, start,
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
		return _studentCourseFeeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _studentCourseFeeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee fetchStudentCourseFee(
		long spStudentCourseFeeId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.fetchStudentCourseFee(spStudentCourseFeeId);
	}

	/**
	* Returns the student course fee with the primary key.
	*
	* @param spStudentCourseFeeId the primary key of the student course fee
	* @return the student course fee
	* @throws PortalException if a student course fee with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee getStudentCourseFee(
		long spStudentCourseFeeId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.getStudentCourseFee(spStudentCourseFeeId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the student course fees.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.StudentCourseFeeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of student course fees
	* @param end the upper bound of the range of student course fees (not inclusive)
	* @return the range of student course fees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.StudentCourseFee> getStudentCourseFees(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.getStudentCourseFees(start, end);
	}

	/**
	* Returns the number of student course fees.
	*
	* @return the number of student course fees
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getStudentCourseFeesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.getStudentCourseFeesCount();
	}

	/**
	* Updates the student course fee in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param studentCourseFee the student course fee
	* @return the student course fee that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee updateStudentCourseFee(
		com.sambaash.platform.srv.model.StudentCourseFee studentCourseFee)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.updateStudentCourseFee(studentCourseFee);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _studentCourseFeeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_studentCourseFeeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _studentCourseFeeLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.model.StudentCourseFee> findByProcessStateId(
		long processStateId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.findByProcessStateId(processStateId);
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee findByProcessStateIdFeeType(
		long processStateId, java.lang.String feeType)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.NoSuchStudentCourseFeeException {
		return _studentCourseFeeLocalService.findByProcessStateIdFeeType(processStateId,
			feeType);
	}

	@Override
	public com.sambaash.platform.srv.model.StudentCourseFee create()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studentCourseFeeLocalService.create();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public StudentCourseFeeLocalService getWrappedStudentCourseFeeLocalService() {
		return _studentCourseFeeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedStudentCourseFeeLocalService(
		StudentCourseFeeLocalService studentCourseFeeLocalService) {
		_studentCourseFeeLocalService = studentCourseFeeLocalService;
	}

	@Override
	public StudentCourseFeeLocalService getWrappedService() {
		return _studentCourseFeeLocalService;
	}

	@Override
	public void setWrappedService(
		StudentCourseFeeLocalService studentCourseFeeLocalService) {
		_studentCourseFeeLocalService = studentCourseFeeLocalService;
	}

	private StudentCourseFeeLocalService _studentCourseFeeLocalService;
}