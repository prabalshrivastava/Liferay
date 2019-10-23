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
 * Provides a wrapper for {@link ServiceComponentsLocalService}.
 *
 * @author gauravvijayvergia
 * @see ServiceComponentsLocalService
 * @generated
 */
public class ServiceComponentsLocalServiceWrapper
	implements ServiceComponentsLocalService,
		ServiceWrapper<ServiceComponentsLocalService> {
	public ServiceComponentsLocalServiceWrapper(
		ServiceComponentsLocalService serviceComponentsLocalService) {
		_serviceComponentsLocalService = serviceComponentsLocalService;
	}

	/**
	* Adds the service components to the database. Also notifies the appropriate model listeners.
	*
	* @param serviceComponents the service components
	* @return the service components that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponents addServiceComponents(
		com.sambaash.platform.srv.spservices.model.ServiceComponents serviceComponents)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentsLocalService.addServiceComponents(serviceComponents);
	}

	/**
	* Creates a new service components with the primary key. Does not add the service components to the database.
	*
	* @param scId the primary key for the new service components
	* @return the new service components
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponents createServiceComponents(
		long scId) {
		return _serviceComponentsLocalService.createServiceComponents(scId);
	}

	/**
	* Deletes the service components with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param scId the primary key of the service components
	* @return the service components that was removed
	* @throws PortalException if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponents deleteServiceComponents(
		long scId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentsLocalService.deleteServiceComponents(scId);
	}

	/**
	* Deletes the service components from the database. Also notifies the appropriate model listeners.
	*
	* @param serviceComponents the service components
	* @return the service components that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponents deleteServiceComponents(
		com.sambaash.platform.srv.spservices.model.ServiceComponents serviceComponents)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentsLocalService.deleteServiceComponents(serviceComponents);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _serviceComponentsLocalService.dynamicQuery();
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
		return _serviceComponentsLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceComponentsLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _serviceComponentsLocalService.dynamicQuery(dynamicQuery, start,
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
		return _serviceComponentsLocalService.dynamicQueryCount(dynamicQuery);
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
		return _serviceComponentsLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponents fetchServiceComponents(
		long scId) throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentsLocalService.fetchServiceComponents(scId);
	}

	/**
	* Returns the service components with the primary key.
	*
	* @param scId the primary key of the service components
	* @return the service components
	* @throws PortalException if a service components with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponents getServiceComponents(
		long scId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentsLocalService.getServiceComponents(scId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentsLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the service componentses.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spservices.model.impl.ServiceComponentsModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of service componentses
	* @param end the upper bound of the range of service componentses (not inclusive)
	* @return the range of service componentses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spservices.model.ServiceComponents> getServiceComponentses(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentsLocalService.getServiceComponentses(start, end);
	}

	/**
	* Returns the number of service componentses.
	*
	* @return the number of service componentses
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getServiceComponentsesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentsLocalService.getServiceComponentsesCount();
	}

	/**
	* Updates the service components in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param serviceComponents the service components
	* @return the service components that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spservices.model.ServiceComponents updateServiceComponents(
		com.sambaash.platform.srv.spservices.model.ServiceComponents serviceComponents)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _serviceComponentsLocalService.updateServiceComponents(serviceComponents);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _serviceComponentsLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_serviceComponentsLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _serviceComponentsLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ServiceComponentsLocalService getWrappedServiceComponentsLocalService() {
		return _serviceComponentsLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedServiceComponentsLocalService(
		ServiceComponentsLocalService serviceComponentsLocalService) {
		_serviceComponentsLocalService = serviceComponentsLocalService;
	}

	@Override
	public ServiceComponentsLocalService getWrappedService() {
		return _serviceComponentsLocalService;
	}

	@Override
	public void setWrappedService(
		ServiceComponentsLocalService serviceComponentsLocalService) {
		_serviceComponentsLocalService = serviceComponentsLocalService;
	}

	private ServiceComponentsLocalService _serviceComponentsLocalService;
}