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
 * Provides a wrapper for {@link OrganisationRemarksLocalService}.
 *
 * @author pradeep
 * @see OrganisationRemarksLocalService
 * @generated
 */
public class OrganisationRemarksLocalServiceWrapper
	implements OrganisationRemarksLocalService,
		ServiceWrapper<OrganisationRemarksLocalService> {
	public OrganisationRemarksLocalServiceWrapper(
		OrganisationRemarksLocalService organisationRemarksLocalService) {
		_organisationRemarksLocalService = organisationRemarksLocalService;
	}

	/**
	* Adds the organisation remarks to the database. Also notifies the appropriate model listeners.
	*
	* @param organisationRemarks the organisation remarks
	* @return the organisation remarks that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks addOrganisationRemarks(
		com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks organisationRemarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarksLocalService.addOrganisationRemarks(organisationRemarks);
	}

	/**
	* Creates a new organisation remarks with the primary key. Does not add the organisation remarks to the database.
	*
	* @param remarksId the primary key for the new organisation remarks
	* @return the new organisation remarks
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks createOrganisationRemarks(
		long remarksId) {
		return _organisationRemarksLocalService.createOrganisationRemarks(remarksId);
	}

	/**
	* Deletes the organisation remarks with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param remarksId the primary key of the organisation remarks
	* @return the organisation remarks that was removed
	* @throws PortalException if a organisation remarks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks deleteOrganisationRemarks(
		long remarksId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarksLocalService.deleteOrganisationRemarks(remarksId);
	}

	/**
	* Deletes the organisation remarks from the database. Also notifies the appropriate model listeners.
	*
	* @param organisationRemarks the organisation remarks
	* @return the organisation remarks that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks deleteOrganisationRemarks(
		com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks organisationRemarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarksLocalService.deleteOrganisationRemarks(organisationRemarks);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _organisationRemarksLocalService.dynamicQuery();
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
		return _organisationRemarksLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organisationRemarksLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _organisationRemarksLocalService.dynamicQuery(dynamicQuery,
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
		return _organisationRemarksLocalService.dynamicQueryCount(dynamicQuery);
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
		return _organisationRemarksLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks fetchOrganisationRemarks(
		long remarksId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarksLocalService.fetchOrganisationRemarks(remarksId);
	}

	/**
	* Returns the organisation remarks with the primary key.
	*
	* @param remarksId the primary key of the organisation remarks
	* @return the organisation remarks
	* @throws PortalException if a organisation remarks with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks getOrganisationRemarks(
		long remarksId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarksLocalService.getOrganisationRemarks(remarksId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarksLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the organisation remarkses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of organisation remarkses
	* @param end the upper bound of the range of organisation remarkses (not inclusive)
	* @return the range of organisation remarkses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks> getOrganisationRemarkses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarksLocalService.getOrganisationRemarkses(start,
			end);
	}

	/**
	* Returns the number of organisation remarkses.
	*
	* @return the number of organisation remarkses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getOrganisationRemarksesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarksLocalService.getOrganisationRemarksesCount();
	}

	/**
	* Updates the organisation remarks in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param organisationRemarks the organisation remarks
	* @return the organisation remarks that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks updateOrganisationRemarks(
		com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks organisationRemarks)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organisationRemarksLocalService.updateOrganisationRemarks(organisationRemarks);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _organisationRemarksLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_organisationRemarksLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _organisationRemarksLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public OrganisationRemarksLocalService getWrappedOrganisationRemarksLocalService() {
		return _organisationRemarksLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedOrganisationRemarksLocalService(
		OrganisationRemarksLocalService organisationRemarksLocalService) {
		_organisationRemarksLocalService = organisationRemarksLocalService;
	}

	@Override
	public OrganisationRemarksLocalService getWrappedService() {
		return _organisationRemarksLocalService;
	}

	@Override
	public void setWrappedService(
		OrganisationRemarksLocalService organisationRemarksLocalService) {
		_organisationRemarksLocalService = organisationRemarksLocalService;
	}

	private OrganisationRemarksLocalService _organisationRemarksLocalService;
}