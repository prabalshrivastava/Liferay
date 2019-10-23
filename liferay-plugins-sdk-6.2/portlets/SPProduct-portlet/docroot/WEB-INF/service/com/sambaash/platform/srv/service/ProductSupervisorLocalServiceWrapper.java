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
 * Provides a wrapper for {@link ProductSupervisorLocalService}.
 *
 * @author gauravvijayvergia
 * @see ProductSupervisorLocalService
 * @generated
 */
public class ProductSupervisorLocalServiceWrapper
	implements ProductSupervisorLocalService,
		ServiceWrapper<ProductSupervisorLocalService> {
	public ProductSupervisorLocalServiceWrapper(
		ProductSupervisorLocalService productSupervisorLocalService) {
		_productSupervisorLocalService = productSupervisorLocalService;
	}

	/**
	* Adds the product supervisor to the database. Also notifies the appropriate model listeners.
	*
	* @param productSupervisor the product supervisor
	* @return the product supervisor that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductSupervisor addProductSupervisor(
		com.sambaash.platform.srv.model.ProductSupervisor productSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.addProductSupervisor(productSupervisor);
	}

	/**
	* Creates a new product supervisor with the primary key. Does not add the product supervisor to the database.
	*
	* @param spProductSupervisorId the primary key for the new product supervisor
	* @return the new product supervisor
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductSupervisor createProductSupervisor(
		long spProductSupervisorId) {
		return _productSupervisorLocalService.createProductSupervisor(spProductSupervisorId);
	}

	/**
	* Deletes the product supervisor with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spProductSupervisorId the primary key of the product supervisor
	* @return the product supervisor that was removed
	* @throws PortalException if a product supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductSupervisor deleteProductSupervisor(
		long spProductSupervisorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.deleteProductSupervisor(spProductSupervisorId);
	}

	/**
	* Deletes the product supervisor from the database. Also notifies the appropriate model listeners.
	*
	* @param productSupervisor the product supervisor
	* @return the product supervisor that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductSupervisor deleteProductSupervisor(
		com.sambaash.platform.srv.model.ProductSupervisor productSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.deleteProductSupervisor(productSupervisor);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _productSupervisorLocalService.dynamicQuery();
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
		return _productSupervisorLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _productSupervisorLocalService.dynamicQuery(dynamicQuery, start,
			end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _productSupervisorLocalService.dynamicQuery(dynamicQuery, start,
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
		return _productSupervisorLocalService.dynamicQueryCount(dynamicQuery);
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
		return _productSupervisorLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.model.ProductSupervisor fetchProductSupervisor(
		long spProductSupervisorId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.fetchProductSupervisor(spProductSupervisorId);
	}

	/**
	* Returns the product supervisor with the primary key.
	*
	* @param spProductSupervisorId the primary key of the product supervisor
	* @return the product supervisor
	* @throws PortalException if a product supervisor with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductSupervisor getProductSupervisor(
		long spProductSupervisorId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.getProductSupervisor(spProductSupervisorId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the product supervisors.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.model.impl.ProductSupervisorModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of product supervisors
	* @param end the upper bound of the range of product supervisors (not inclusive)
	* @return the range of product supervisors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.model.ProductSupervisor> getProductSupervisors(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.getProductSupervisors(start, end);
	}

	/**
	* Returns the number of product supervisors.
	*
	* @return the number of product supervisors
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getProductSupervisorsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.getProductSupervisorsCount();
	}

	/**
	* Updates the product supervisor in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param productSupervisor the product supervisor
	* @return the product supervisor that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.model.ProductSupervisor updateProductSupervisor(
		com.sambaash.platform.srv.model.ProductSupervisor productSupervisor)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.updateProductSupervisor(productSupervisor);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _productSupervisorLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_productSupervisorLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _productSupervisorLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	* This method returns the supervisor id using the parameteres passed.
	*
	*    If countryName is empty it will be ignored
	*    If countryId is 0, it will be ignored
	*    If productId is 0, it will be ignored.
	*
	*    Atleast one of the three parameteres must have valid value
	*
	* @param countryName
	* @param countryId
	* @param productId
	* @return
	* @throws SystemException
	*/
	@Override
	public long getSupervisor(java.lang.String countryName, long countryId,
		long productId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _productSupervisorLocalService.getSupervisor(countryName,
			countryId, productId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ProductSupervisorLocalService getWrappedProductSupervisorLocalService() {
		return _productSupervisorLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedProductSupervisorLocalService(
		ProductSupervisorLocalService productSupervisorLocalService) {
		_productSupervisorLocalService = productSupervisorLocalService;
	}

	@Override
	public ProductSupervisorLocalService getWrappedService() {
		return _productSupervisorLocalService;
	}

	@Override
	public void setWrappedService(
		ProductSupervisorLocalService productSupervisorLocalService) {
		_productSupervisorLocalService = productSupervisorLocalService;
	}

	private ProductSupervisorLocalService _productSupervisorLocalService;
}