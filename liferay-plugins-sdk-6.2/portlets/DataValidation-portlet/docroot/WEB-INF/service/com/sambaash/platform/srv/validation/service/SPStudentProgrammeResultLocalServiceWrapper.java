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
 * Provides a wrapper for {@link SPStudentProgrammeResultLocalService}.
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammeResultLocalService
 * @generated
 */
public class SPStudentProgrammeResultLocalServiceWrapper
	implements SPStudentProgrammeResultLocalService,
		ServiceWrapper<SPStudentProgrammeResultLocalService> {
	public SPStudentProgrammeResultLocalServiceWrapper(
		SPStudentProgrammeResultLocalService spStudentProgrammeResultLocalService) {
		_spStudentProgrammeResultLocalService = spStudentProgrammeResultLocalService;
	}

	/**
	* Adds the s p student programme result to the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentProgrammeResult the s p student programme result
	* @return the s p student programme result that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult addSPStudentProgrammeResult(
		com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult spStudentProgrammeResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResultLocalService.addSPStudentProgrammeResult(spStudentProgrammeResult);
	}

	/**
	* Creates a new s p student programme result with the primary key. Does not add the s p student programme result to the database.
	*
	* @param spStudentProgrammeResultId the primary key for the new s p student programme result
	* @return the new s p student programme result
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult createSPStudentProgrammeResult(
		long spStudentProgrammeResultId) {
		return _spStudentProgrammeResultLocalService.createSPStudentProgrammeResult(spStudentProgrammeResultId);
	}

	/**
	* Deletes the s p student programme result with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentProgrammeResultId the primary key of the s p student programme result
	* @return the s p student programme result that was removed
	* @throws PortalException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult deleteSPStudentProgrammeResult(
		long spStudentProgrammeResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResultLocalService.deleteSPStudentProgrammeResult(spStudentProgrammeResultId);
	}

	/**
	* Deletes the s p student programme result from the database. Also notifies the appropriate model listeners.
	*
	* @param spStudentProgrammeResult the s p student programme result
	* @return the s p student programme result that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult deleteSPStudentProgrammeResult(
		com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult spStudentProgrammeResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResultLocalService.deleteSPStudentProgrammeResult(spStudentProgrammeResult);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spStudentProgrammeResultLocalService.dynamicQuery();
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
		return _spStudentProgrammeResultLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spStudentProgrammeResultLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spStudentProgrammeResultLocalService.dynamicQuery(dynamicQuery,
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
		return _spStudentProgrammeResultLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spStudentProgrammeResultLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult fetchSPStudentProgrammeResult(
		long spStudentProgrammeResultId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResultLocalService.fetchSPStudentProgrammeResult(spStudentProgrammeResultId);
	}

	/**
	* Returns the s p student programme result with the primary key.
	*
	* @param spStudentProgrammeResultId the primary key of the s p student programme result
	* @return the s p student programme result
	* @throws PortalException if a s p student programme result with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult getSPStudentProgrammeResult(
		long spStudentProgrammeResultId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResultLocalService.getSPStudentProgrammeResult(spStudentProgrammeResultId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResultLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p student programme results.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeResultModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p student programme results
	* @param end the upper bound of the range of s p student programme results (not inclusive)
	* @return the range of s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> getSPStudentProgrammeResults(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResultLocalService.getSPStudentProgrammeResults(start,
			end);
	}

	/**
	* Returns the number of s p student programme results.
	*
	* @return the number of s p student programme results
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPStudentProgrammeResultsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResultLocalService.getSPStudentProgrammeResultsCount();
	}

	/**
	* Updates the s p student programme result in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spStudentProgrammeResult the s p student programme result
	* @return the s p student programme result that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult updateSPStudentProgrammeResult(
		com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult spStudentProgrammeResult)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResultLocalService.updateSPStudentProgrammeResult(spStudentProgrammeResult);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spStudentProgrammeResultLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spStudentProgrammeResultLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spStudentProgrammeResultLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPStudentProgrammeResultLocalService getWrappedSPStudentProgrammeResultLocalService() {
		return _spStudentProgrammeResultLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPStudentProgrammeResultLocalService(
		SPStudentProgrammeResultLocalService spStudentProgrammeResultLocalService) {
		_spStudentProgrammeResultLocalService = spStudentProgrammeResultLocalService;
	}

	@Override
	public SPStudentProgrammeResultLocalService getWrappedService() {
		return _spStudentProgrammeResultLocalService;
	}

	@Override
	public void setWrappedService(
		SPStudentProgrammeResultLocalService spStudentProgrammeResultLocalService) {
		_spStudentProgrammeResultLocalService = spStudentProgrammeResultLocalService;
	}

	private SPStudentProgrammeResultLocalService _spStudentProgrammeResultLocalService;
}