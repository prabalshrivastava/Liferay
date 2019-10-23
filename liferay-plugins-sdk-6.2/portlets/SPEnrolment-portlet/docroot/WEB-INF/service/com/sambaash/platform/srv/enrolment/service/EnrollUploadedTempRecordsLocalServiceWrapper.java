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

package com.sambaash.platform.srv.enrolment.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link EnrollUploadedTempRecordsLocalService}.
 *
 * @author Baxture
 * @see EnrollUploadedTempRecordsLocalService
 * @generated
 */
public class EnrollUploadedTempRecordsLocalServiceWrapper
	implements EnrollUploadedTempRecordsLocalService,
		ServiceWrapper<EnrollUploadedTempRecordsLocalService> {
	public EnrollUploadedTempRecordsLocalServiceWrapper(
		EnrollUploadedTempRecordsLocalService enrollUploadedTempRecordsLocalService) {
		_enrollUploadedTempRecordsLocalService = enrollUploadedTempRecordsLocalService;
	}

	/**
	* Adds the enroll uploaded temp records to the database. Also notifies the appropriate model listeners.
	*
	* @param enrollUploadedTempRecords the enroll uploaded temp records
	* @return the enroll uploaded temp records that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords addEnrollUploadedTempRecords(
		com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords enrollUploadedTempRecords)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.addEnrollUploadedTempRecords(enrollUploadedTempRecords);
	}

	/**
	* Creates a new enroll uploaded temp records with the primary key. Does not add the enroll uploaded temp records to the database.
	*
	* @param uploadedRecId the primary key for the new enroll uploaded temp records
	* @return the new enroll uploaded temp records
	*/
	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords createEnrollUploadedTempRecords(
		long uploadedRecId) {
		return _enrollUploadedTempRecordsLocalService.createEnrollUploadedTempRecords(uploadedRecId);
	}

	/**
	* Deletes the enroll uploaded temp records with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param uploadedRecId the primary key of the enroll uploaded temp records
	* @return the enroll uploaded temp records that was removed
	* @throws PortalException if a enroll uploaded temp records with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords deleteEnrollUploadedTempRecords(
		long uploadedRecId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.deleteEnrollUploadedTempRecords(uploadedRecId);
	}

	/**
	* Deletes the enroll uploaded temp records from the database. Also notifies the appropriate model listeners.
	*
	* @param enrollUploadedTempRecords the enroll uploaded temp records
	* @return the enroll uploaded temp records that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords deleteEnrollUploadedTempRecords(
		com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords enrollUploadedTempRecords)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.deleteEnrollUploadedTempRecords(enrollUploadedTempRecords);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _enrollUploadedTempRecordsLocalService.dynamicQuery();
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
		return _enrollUploadedTempRecordsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _enrollUploadedTempRecordsLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _enrollUploadedTempRecordsLocalService.dynamicQuery(dynamicQuery,
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
		return _enrollUploadedTempRecordsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _enrollUploadedTempRecordsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords fetchEnrollUploadedTempRecords(
		long uploadedRecId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.fetchEnrollUploadedTempRecords(uploadedRecId);
	}

	/**
	* Returns the enroll uploaded temp records with the primary key.
	*
	* @param uploadedRecId the primary key of the enroll uploaded temp records
	* @return the enroll uploaded temp records
	* @throws PortalException if a enroll uploaded temp records with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords getEnrollUploadedTempRecords(
		long uploadedRecId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.getEnrollUploadedTempRecords(uploadedRecId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the enroll uploaded temp recordses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.enrolment.model.impl.EnrollUploadedTempRecordsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of enroll uploaded temp recordses
	* @param end the upper bound of the range of enroll uploaded temp recordses (not inclusive)
	* @return the range of enroll uploaded temp recordses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords> getEnrollUploadedTempRecordses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.getEnrollUploadedTempRecordses(start,
			end);
	}

	/**
	* Returns the number of enroll uploaded temp recordses.
	*
	* @return the number of enroll uploaded temp recordses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getEnrollUploadedTempRecordsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.getEnrollUploadedTempRecordsesCount();
	}

	/**
	* Updates the enroll uploaded temp records in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param enrollUploadedTempRecords the enroll uploaded temp records
	* @return the enroll uploaded temp records that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords updateEnrollUploadedTempRecords(
		com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords enrollUploadedTempRecords)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.updateEnrollUploadedTempRecords(enrollUploadedTempRecords);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _enrollUploadedTempRecordsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_enrollUploadedTempRecordsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _enrollUploadedTempRecordsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords addEnrollUploadStat(
		java.lang.String uploadTransactId, java.lang.String dob,
		java.lang.String gender, long userId, java.lang.String name,
		java.lang.String sprCode, java.lang.String title, java.lang.String email)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _enrollUploadedTempRecordsLocalService.addEnrollUploadStat(uploadTransactId,
			dob, gender, userId, name, sprCode, title, email);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public EnrollUploadedTempRecordsLocalService getWrappedEnrollUploadedTempRecordsLocalService() {
		return _enrollUploadedTempRecordsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedEnrollUploadedTempRecordsLocalService(
		EnrollUploadedTempRecordsLocalService enrollUploadedTempRecordsLocalService) {
		_enrollUploadedTempRecordsLocalService = enrollUploadedTempRecordsLocalService;
	}

	@Override
	public EnrollUploadedTempRecordsLocalService getWrappedService() {
		return _enrollUploadedTempRecordsLocalService;
	}

	@Override
	public void setWrappedService(
		EnrollUploadedTempRecordsLocalService enrollUploadedTempRecordsLocalService) {
		_enrollUploadedTempRecordsLocalService = enrollUploadedTempRecordsLocalService;
	}

	private EnrollUploadedTempRecordsLocalService _enrollUploadedTempRecordsLocalService;
}