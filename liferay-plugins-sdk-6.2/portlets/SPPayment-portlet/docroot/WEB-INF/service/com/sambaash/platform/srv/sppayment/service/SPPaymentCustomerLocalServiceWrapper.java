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

package com.sambaash.platform.srv.sppayment.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPPaymentCustomerLocalService}.
 *
 * @author pradeep
 * @see SPPaymentCustomerLocalService
 * @generated
 */
public class SPPaymentCustomerLocalServiceWrapper
	implements SPPaymentCustomerLocalService,
		ServiceWrapper<SPPaymentCustomerLocalService> {
	public SPPaymentCustomerLocalServiceWrapper(
		SPPaymentCustomerLocalService spPaymentCustomerLocalService) {
		_spPaymentCustomerLocalService = spPaymentCustomerLocalService;
	}

	/**
	* Adds the s p payment customer to the database. Also notifies the appropriate model listeners.
	*
	* @param spPaymentCustomer the s p payment customer
	* @return the s p payment customer that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer addSPPaymentCustomer(
		com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer spPaymentCustomer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomerLocalService.addSPPaymentCustomer(spPaymentCustomer);
	}

	/**
	* Creates a new s p payment customer with the primary key. Does not add the s p payment customer to the database.
	*
	* @param sPPaymentCustomerId the primary key for the new s p payment customer
	* @return the new s p payment customer
	*/
	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer createSPPaymentCustomer(
		long sPPaymentCustomerId) {
		return _spPaymentCustomerLocalService.createSPPaymentCustomer(sPPaymentCustomerId);
	}

	/**
	* Deletes the s p payment customer with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param sPPaymentCustomerId the primary key of the s p payment customer
	* @return the s p payment customer that was removed
	* @throws PortalException if a s p payment customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer deleteSPPaymentCustomer(
		long sPPaymentCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomerLocalService.deleteSPPaymentCustomer(sPPaymentCustomerId);
	}

	/**
	* Deletes the s p payment customer from the database. Also notifies the appropriate model listeners.
	*
	* @param spPaymentCustomer the s p payment customer
	* @return the s p payment customer that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer deleteSPPaymentCustomer(
		com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer spPaymentCustomer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomerLocalService.deleteSPPaymentCustomer(spPaymentCustomer);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spPaymentCustomerLocalService.dynamicQuery();
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
		return _spPaymentCustomerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPaymentCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spPaymentCustomerLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPaymentCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spPaymentCustomerLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spPaymentCustomerLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spPaymentCustomerLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer fetchSPPaymentCustomer(
		long sPPaymentCustomerId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomerLocalService.fetchSPPaymentCustomer(sPPaymentCustomerId);
	}

	/**
	* Returns the s p payment customer with the primary key.
	*
	* @param sPPaymentCustomerId the primary key of the s p payment customer
	* @return the s p payment customer
	* @throws PortalException if a s p payment customer with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer getSPPaymentCustomer(
		long sPPaymentCustomerId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomerLocalService.getSPPaymentCustomer(sPPaymentCustomerId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p payment customers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.sppayment.model.impl.SPPaymentCustomerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p payment customers
	* @param end the upper bound of the range of s p payment customers (not inclusive)
	* @return the range of s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer> getSPPaymentCustomers(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomerLocalService.getSPPaymentCustomers(start, end);
	}

	/**
	* Returns the number of s p payment customers.
	*
	* @return the number of s p payment customers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPPaymentCustomersCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomerLocalService.getSPPaymentCustomersCount();
	}

	/**
	* Updates the s p payment customer in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spPaymentCustomer the s p payment customer
	* @return the s p payment customer that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer updateSPPaymentCustomer(
		com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer spPaymentCustomer)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spPaymentCustomerLocalService.updateSPPaymentCustomer(spPaymentCustomer);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spPaymentCustomerLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spPaymentCustomerLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spPaymentCustomerLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPPaymentCustomerLocalService getWrappedSPPaymentCustomerLocalService() {
		return _spPaymentCustomerLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPPaymentCustomerLocalService(
		SPPaymentCustomerLocalService spPaymentCustomerLocalService) {
		_spPaymentCustomerLocalService = spPaymentCustomerLocalService;
	}

	@Override
	public SPPaymentCustomerLocalService getWrappedService() {
		return _spPaymentCustomerLocalService;
	}

	@Override
	public void setWrappedService(
		SPPaymentCustomerLocalService spPaymentCustomerLocalService) {
		_spPaymentCustomerLocalService = spPaymentCustomerLocalService;
	}

	private SPPaymentCustomerLocalService _spPaymentCustomerLocalService;
}