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

package com.sambaash.platform.srv.startupprofile.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ReAccreditationLocalService}.
 *
 * @author pradeep
 * @see ReAccreditationLocalService
 * @generated
 */
public class ReAccreditationLocalServiceWrapper
	implements ReAccreditationLocalService,
		ServiceWrapper<ReAccreditationLocalService> {
	public ReAccreditationLocalServiceWrapper(
		ReAccreditationLocalService reAccreditationLocalService) {
		_reAccreditationLocalService = reAccreditationLocalService;
	}

	/**
	* Adds the re accreditation to the database. Also notifies the appropriate model listeners.
	*
	* @param reAccreditation the re accreditation
	* @return the re accreditation that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation addReAccreditation(
		com.sambaash.platform.srv.startupprofile.model.ReAccreditation reAccreditation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reAccreditationLocalService.addReAccreditation(reAccreditation);
	}

	/**
	* Creates a new re accreditation with the primary key. Does not add the re accreditation to the database.
	*
	* @param accreditationId the primary key for the new re accreditation
	* @return the new re accreditation
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation createReAccreditation(
		long accreditationId) {
		return _reAccreditationLocalService.createReAccreditation(accreditationId);
	}

	/**
	* Deletes the re accreditation with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param accreditationId the primary key of the re accreditation
	* @return the re accreditation that was removed
	* @throws PortalException if a re accreditation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation deleteReAccreditation(
		long accreditationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reAccreditationLocalService.deleteReAccreditation(accreditationId);
	}

	/**
	* Deletes the re accreditation from the database. Also notifies the appropriate model listeners.
	*
	* @param reAccreditation the re accreditation
	* @return the re accreditation that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation deleteReAccreditation(
		com.sambaash.platform.srv.startupprofile.model.ReAccreditation reAccreditation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reAccreditationLocalService.deleteReAccreditation(reAccreditation);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _reAccreditationLocalService.dynamicQuery();
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
		return _reAccreditationLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _reAccreditationLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _reAccreditationLocalService.dynamicQuery(dynamicQuery, start,
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
		return _reAccreditationLocalService.dynamicQueryCount(dynamicQuery);
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
		return _reAccreditationLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation fetchReAccreditation(
		long accreditationId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reAccreditationLocalService.fetchReAccreditation(accreditationId);
	}

	/**
	* Returns the re accreditation with the primary key.
	*
	* @param accreditationId the primary key of the re accreditation
	* @return the re accreditation
	* @throws PortalException if a re accreditation with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation getReAccreditation(
		long accreditationId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reAccreditationLocalService.getReAccreditation(accreditationId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _reAccreditationLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the re accreditations.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of re accreditations
	* @param end the upper bound of the range of re accreditations (not inclusive)
	* @return the range of re accreditations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> getReAccreditations(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reAccreditationLocalService.getReAccreditations(start, end);
	}

	/**
	* Returns the number of re accreditations.
	*
	* @return the number of re accreditations
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getReAccreditationsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reAccreditationLocalService.getReAccreditationsCount();
	}

	/**
	* Updates the re accreditation in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param reAccreditation the re accreditation
	* @return the re accreditation that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation updateReAccreditation(
		com.sambaash.platform.srv.startupprofile.model.ReAccreditation reAccreditation)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _reAccreditationLocalService.updateReAccreditation(reAccreditation);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _reAccreditationLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_reAccreditationLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _reAccreditationLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ReAccreditationLocalService getWrappedReAccreditationLocalService() {
		return _reAccreditationLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedReAccreditationLocalService(
		ReAccreditationLocalService reAccreditationLocalService) {
		_reAccreditationLocalService = reAccreditationLocalService;
	}

	@Override
	public ReAccreditationLocalService getWrappedService() {
		return _reAccreditationLocalService;
	}

	@Override
	public void setWrappedService(
		ReAccreditationLocalService reAccreditationLocalService) {
		_reAccreditationLocalService = reAccreditationLocalService;
	}

	private ReAccreditationLocalService _reAccreditationLocalService;
}