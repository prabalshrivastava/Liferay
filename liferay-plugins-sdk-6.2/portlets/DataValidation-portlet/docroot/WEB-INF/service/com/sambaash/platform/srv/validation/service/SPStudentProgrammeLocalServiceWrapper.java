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

package com.sambaash.platform.srv.validation.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPStudentProgrammeLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammeLocalService
 * @generated
 */
public class SPStudentProgrammeLocalServiceWrapper
	implements SPStudentProgrammeLocalService,
		ServiceWrapper<SPStudentProgrammeLocalService> {
	public SPStudentProgrammeLocalServiceWrapper(
		SPStudentProgrammeLocalService spStudentProgrammeLocalService) {
		_spStudentProgrammeLocalService = spStudentProgrammeLocalService;
	}

	/**
	* Adds the s p student programme to the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentProgramme the s p student programme
	* @return the s p student programme that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme addSPStudentProgramme(
		com.sambaash.platform.srv.validation.model.SPStudentProgramme spStudentProgramme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeLocalService.addSPStudentProgramme(spStudentProgramme);
	}

	/**
	* Creates a new s p student programme with the primary key. Does not add the s p student programme to the database.
	*
	* @param spStudentCourseId the primary key for the new s p student programme
	* @return the new s p student programme
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme createSPStudentProgramme(
		long spStudentCourseId) {
		return _spStudentProgrammeLocalService.createSPStudentProgramme(spStudentCourseId);
	}

	/**
	* Deletes the s p student programme with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentCourseId the primary key of the s p student programme
	* @return the s p student programme that was removed
	* @throws PortalException if a s p student programme with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme deleteSPStudentProgramme(
		long spStudentCourseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeLocalService.deleteSPStudentProgramme(spStudentCourseId);
	}

	/**
	* Deletes the s p student programme from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentProgramme the s p student programme
	* @return the s p student programme that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme deleteSPStudentProgramme(
		com.sambaash.platform.srv.validation.model.SPStudentProgramme spStudentProgramme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeLocalService.deleteSPStudentProgramme(spStudentProgramme);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spStudentProgrammeLocalService.dynamicQuery();
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
		return _spStudentProgrammeLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spStudentProgrammeLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spStudentProgrammeLocalService.dynamicQuery(dynamicQuery,
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
		return _spStudentProgrammeLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spStudentProgrammeLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme fetchSPStudentProgramme(
		long spStudentCourseId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeLocalService.fetchSPStudentProgramme(spStudentCourseId);
	}

	/**
	* Returns the s p student programme with the primary key.
	*
	* @param spStudentCourseId the primary key of the s p student programme
	* @return the s p student programme
	* @throws PortalException if a s p student programme with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme getSPStudentProgramme(
		long spStudentCourseId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeLocalService.getSPStudentProgramme(spStudentCourseId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p student programmes.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p student programmes
	* @param end the upper bound of the range of s p student programmes (not inclusive)
	* @return the range of s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgramme> getSPStudentProgrammes(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeLocalService.getSPStudentProgrammes(start, end);
	}

	/**
	* Returns the number of s p student programmes.
	*
	* @return the number of s p student programmes
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPStudentProgrammesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeLocalService.getSPStudentProgrammesCount();
	}

	/**
	* Updates the s p student programme in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spStudentProgramme the s p student programme
	* @return the s p student programme that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme updateSPStudentProgramme(
		com.sambaash.platform.srv.validation.model.SPStudentProgramme spStudentProgramme)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeLocalService.updateSPStudentProgramme(spStudentProgramme);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spStudentProgrammeLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spStudentProgrammeLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spStudentProgrammeLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getStudentProgramme(
		java.lang.Long scopeGroupId, java.lang.String programmeCode,
		java.lang.String nric) {
		return _spStudentProgrammeLocalService.getStudentProgramme(scopeGroupId,
			programmeCode, nric);
	}

	@Override
	public java.lang.String getStudentProgramme(java.lang.Long scopeGroupId,
		java.lang.String programmeCode, java.lang.String nric,
		java.lang.String emailAddress, java.util.Date programmeEndDate,
		boolean validationRequired) {
		return _spStudentProgrammeLocalService.getStudentProgramme(scopeGroupId,
			programmeCode, nric, emailAddress, programmeEndDate,
			validationRequired);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPStudentProgrammeLocalService getWrappedSPStudentProgrammeLocalService() {
		return _spStudentProgrammeLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPStudentProgrammeLocalService(
		SPStudentProgrammeLocalService spStudentProgrammeLocalService) {
		_spStudentProgrammeLocalService = spStudentProgrammeLocalService;
	}

	@Override
	public SPStudentProgrammeLocalService getWrappedService() {
		return _spStudentProgrammeLocalService;
	}

	@Override
	public void setWrappedService(
		SPStudentProgrammeLocalService spStudentProgrammeLocalService) {
		_spStudentProgrammeLocalService = spStudentProgrammeLocalService;
	}

	private SPStudentProgrammeLocalService _spStudentProgrammeLocalService;
}