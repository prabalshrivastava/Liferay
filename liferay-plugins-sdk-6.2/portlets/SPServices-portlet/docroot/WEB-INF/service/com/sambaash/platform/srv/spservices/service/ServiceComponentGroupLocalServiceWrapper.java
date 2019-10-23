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

package com.sambaash.platform.srv.spservices.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ServiceComponentGroupLocalService}.
 *
 * @author gauravvijayvergia
 * @see ServiceComponentGroupLocalService
 * @generated
 */
public class ServiceComponentGroupLocalServiceWrapper
	implements ServiceComponentGroupLocalService,
		ServiceWrapper<ServiceComponentGroupLocalService> {
	public ServiceComponentGroupLocalServiceWrapper(
		ServiceComponentGroupLocalService serviceComponentGroupLocalService) {
		_serviceComponentGroupLocalService = serviceComponentGroupLocalService;
	}

	/**
	* Adds the service component group to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceComponentGroup the service component group
	* @return the service component group that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup addServiceComponentGroup(
		com.sambaash.platform.srv.spservices.model.ServiceComponentGroup serviceComponentGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentGroupLocalService.addServiceComponentGroup(serviceComponentGroup);
	}

	/**
	* Creates a new service component group with the primary key. Does not add the service component group to the database.
	*
	* @param scgId the primary key for the new service component group
	* @return the new service component group
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup createServiceComponentGroup(
		long scgId) {
		return _serviceComponentGroupLocalService.createServiceComponentGroup(scgId);
	}

	/**
	* Deletes the service component group with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scgId the primary key of the service component group
	* @return the service component group that was removed
	* @throws PortalException if a service component group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup deleteServiceComponentGroup(
		long scgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentGroupLocalService.deleteServiceComponentGroup(scgId);
	}

	/**
	* Deletes the service component group from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceComponentGroup the service component group
	* @return the service component group that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup deleteServiceComponentGroup(
		com.sambaash.platform.srv.spservices.model.ServiceComponentGroup serviceComponentGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentGroupLocalService.deleteServiceComponentGroup(serviceComponentGroup);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceComponentGroupLocalService.dynamicQuery();
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
		return _serviceComponentGroupLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceComponentGroupLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceComponentGroupLocalService.dynamicQuery(dynamicQuery,
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
		return _serviceComponentGroupLocalService.dynamicQueryCount(dynamicQuery);
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
		return _serviceComponentGroupLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup fetchServiceComponentGroup(
		long scgId) throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentGroupLocalService.fetchServiceComponentGroup(scgId);
	}

	/**
	* Returns the service component group with the primary key.
	*
	* @param scgId the primary key of the service component group
	* @return the service component group
	* @throws PortalException if a service component group with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup getServiceComponentGroup(
		long scgId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentGroupLocalService.getServiceComponentGroup(scgId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentGroupLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the service component groups.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentGroupModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service component groups
	* @param end the upper bound of the range of service component groups (not inclusive)
	* @return the range of service component groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponentGroup> getServiceComponentGroups(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentGroupLocalService.getServiceComponentGroups(start,
			end);
	}

	/**
	* Returns the number of service component groups.
	*
	* @return the number of service component groups
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getServiceComponentGroupsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentGroupLocalService.getServiceComponentGroupsCount();
	}

	/**
	* Updates the service component group in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceComponentGroup the service component group
	* @return the service component group that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponentGroup updateServiceComponentGroup(
		com.sambaash.platform.srv.spservices.model.ServiceComponentGroup serviceComponentGroup)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentGroupLocalService.updateServiceComponentGroup(serviceComponentGroup);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _serviceComponentGroupLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_serviceComponentGroupLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _serviceComponentGroupLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ServiceComponentGroupLocalService getWrappedServiceComponentGroupLocalService() {
		return _serviceComponentGroupLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedServiceComponentGroupLocalService(
		ServiceComponentGroupLocalService serviceComponentGroupLocalService) {
		_serviceComponentGroupLocalService = serviceComponentGroupLocalService;
	}

	@Override
	public ServiceComponentGroupLocalService getWrappedService() {
		return _serviceComponentGroupLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceComponentGroupLocalService serviceComponentGroupLocalService) {
		_serviceComponentGroupLocalService = serviceComponentGroupLocalService;
	}

	private ServiceComponentGroupLocalService _serviceComponentGroupLocalService;
}