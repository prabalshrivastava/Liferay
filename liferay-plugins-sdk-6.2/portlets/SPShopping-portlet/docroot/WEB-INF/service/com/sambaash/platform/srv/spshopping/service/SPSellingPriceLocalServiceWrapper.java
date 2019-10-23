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

package com.sambaash.platform.srv.spshopping.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPSellingPriceLocalService}.
 *
 * @author pradeep
 * @see SPSellingPriceLocalService
 * @generated
 */
public class SPSellingPriceLocalServiceWrapper
	implements SPSellingPriceLocalService,
		ServiceWrapper<SPSellingPriceLocalService> {
	public SPSellingPriceLocalServiceWrapper(
		SPSellingPriceLocalService spSellingPriceLocalService) {
		_spSellingPriceLocalService = spSellingPriceLocalService;
	}

	/**
	* Adds the s p selling price to the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPrice the s p selling price
	* @return the s p selling price that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice addSPSellingPrice(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.addSPSellingPrice(spSellingPrice);
	}

	/**
	* Creates a new s p selling price with the primary key. Does not add the s p selling price to the database.
	*
	* @param spSellingPriceId the primary key for the new s p selling price
	* @return the new s p selling price
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice createSPSellingPrice(
		long spSellingPriceId) {
		return _spSellingPriceLocalService.createSPSellingPrice(spSellingPriceId);
	}

	/**
	* Deletes the s p selling price with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price that was removed
	* @throws PortalException if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice deleteSPSellingPrice(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.deleteSPSellingPrice(spSellingPriceId);
	}

	/**
	* Deletes the s p selling price from the database. Also notifies the appropriate model listeners.
	*
	* @param spSellingPrice the s p selling price
	* @return the s p selling price that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice deleteSPSellingPrice(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.deleteSPSellingPrice(spSellingPrice);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spSellingPriceLocalService.dynamicQuery();
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
		return _spSellingPriceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSellingPriceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spSellingPriceLocalService.dynamicQuery(dynamicQuery, start,
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
		return _spSellingPriceLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spSellingPriceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice fetchSPSellingPrice(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.fetchSPSellingPrice(spSellingPriceId);
	}

	/**
	* Returns the s p selling price with the primary key.
	*
	* @param spSellingPriceId the primary key of the s p selling price
	* @return the s p selling price
	* @throws PortalException if a s p selling price with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice getSPSellingPrice(
		long spSellingPriceId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.getSPSellingPrice(spSellingPriceId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p selling prices.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPSellingPriceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p selling prices
	* @param end the upper bound of the range of s p selling prices (not inclusive)
	* @return the range of s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> getSPSellingPrices(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.getSPSellingPrices(start, end);
	}

	/**
	* Returns the number of s p selling prices.
	*
	* @return the number of s p selling prices
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPSellingPricesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.getSPSellingPricesCount();
	}

	/**
	* Updates the s p selling price in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spSellingPrice the s p selling price
	* @return the s p selling price that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice updateSPSellingPrice(
		com.sambaash.platform.srv.spshopping.model.SPSellingPrice spSellingPrice)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.updateSPSellingPrice(spSellingPrice);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spSellingPriceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spSellingPriceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spSellingPriceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPSellingPrice> findPriceByItemId(
		long spSellingItemId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSellingPriceLocalService.findPriceByItemId(spSellingItemId);
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPSellingPrice findPriceByPackageId(
		long spSellingPackageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return _spSellingPriceLocalService.findPriceByPackageId(spSellingPackageId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPSellingPriceLocalService getWrappedSPSellingPriceLocalService() {
		return _spSellingPriceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPSellingPriceLocalService(
		SPSellingPriceLocalService spSellingPriceLocalService) {
		_spSellingPriceLocalService = spSellingPriceLocalService;
	}

	@Override
	public SPSellingPriceLocalService getWrappedService() {
		return _spSellingPriceLocalService;
	}

	@Override
	public void setWrappedService(
		SPSellingPriceLocalService spSellingPriceLocalService) {
		_spSellingPriceLocalService = spSellingPriceLocalService;
	}

	private SPSellingPriceLocalService _spSellingPriceLocalService;
}