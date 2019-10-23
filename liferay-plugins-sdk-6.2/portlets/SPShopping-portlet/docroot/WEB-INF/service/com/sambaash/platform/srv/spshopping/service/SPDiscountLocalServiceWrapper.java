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
 * Provides a wrapper for {@link SPDiscountLocalService}.
 *
 * @author pradeep
 * @see SPDiscountLocalService
 * @generated
 */
public class SPDiscountLocalServiceWrapper implements SPDiscountLocalService,
	ServiceWrapper<SPDiscountLocalService> {
	public SPDiscountLocalServiceWrapper(
		SPDiscountLocalService spDiscountLocalService) {
		_spDiscountLocalService = spDiscountLocalService;
	}

	/**
	* Adds the s p discount to the database. Also notifies the appropriate model listeners.
	*
	* @param spDiscount the s p discount
	* @return the s p discount that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount addSPDiscount(
		com.sambaash.platform.srv.spshopping.model.SPDiscount spDiscount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.addSPDiscount(spDiscount);
	}

	/**
	* Creates a new s p discount with the primary key. Does not add the s p discount to the database.
	*
	* @param spDiscountId the primary key for the new s p discount
	* @return the new s p discount
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount createSPDiscount(
		long spDiscountId) {
		return _spDiscountLocalService.createSPDiscount(spDiscountId);
	}

	/**
	* Deletes the s p discount with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param spDiscountId the primary key of the s p discount
	* @return the s p discount that was removed
	* @throws PortalException if a s p discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount deleteSPDiscount(
		long spDiscountId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.deleteSPDiscount(spDiscountId);
	}

	/**
	* Deletes the s p discount from the database. Also notifies the appropriate model listeners.
	*
	* @param spDiscount the s p discount
	* @return the s p discount that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount deleteSPDiscount(
		com.sambaash.platform.srv.spshopping.model.SPDiscount spDiscount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.deleteSPDiscount(spDiscount);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _spDiscountLocalService.dynamicQuery();
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
		return _spDiscountLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spDiscountLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _spDiscountLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _spDiscountLocalService.dynamicQueryCount(dynamicQuery);
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
		return _spDiscountLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount fetchSPDiscount(
		long spDiscountId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.fetchSPDiscount(spDiscountId);
	}

	/**
	* Returns the s p discount with the primary key.
	*
	* @param spDiscountId the primary key of the s p discount
	* @return the s p discount
	* @throws PortalException if a s p discount with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount getSPDiscount(
		long spDiscountId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.getSPDiscount(spDiscountId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the s p discounts.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.sambaash.platform.srv.spshopping.model.impl.SPDiscountModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of s p discounts
	* @param end the upper bound of the range of s p discounts (not inclusive)
	* @return the range of s p discounts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> getSPDiscounts(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.getSPDiscounts(start, end);
	}

	/**
	* Returns the number of s p discounts.
	*
	* @return the number of s p discounts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getSPDiscountsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.getSPDiscountsCount();
	}

	/**
	* Updates the s p discount in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param spDiscount the s p discount
	* @return the s p discount that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.sambaash.platform.srv.spshopping.model.SPDiscount updateSPDiscount(
		com.sambaash.platform.srv.spshopping.model.SPDiscount spDiscount)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.updateSPDiscount(spDiscount);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spDiscountLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spDiscountLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spDiscountLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findDiscountsByPackageId(
		long packageId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.sambaash.platform.srv.spshopping.NoSuchSPSellingPriceException {
		return _spDiscountLocalService.findDiscountsByPackageId(packageId);
	}

	@Override
	public java.util.List<com.sambaash.platform.srv.spshopping.model.SPDiscount> findSPDiscounts(
		boolean active)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spDiscountLocalService.findSPDiscounts(active);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPDiscountLocalService getWrappedSPDiscountLocalService() {
		return _spDiscountLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPDiscountLocalService(
		SPDiscountLocalService spDiscountLocalService) {
		_spDiscountLocalService = spDiscountLocalService;
	}

	@Override
	public SPDiscountLocalService getWrappedService() {
		return _spDiscountLocalService;
	}

	@Override
	public void setWrappedService(SPDiscountLocalService spDiscountLocalService) {
		_spDiscountLocalService = spDiscountLocalService;
	}

	private SPDiscountLocalService _spDiscountLocalService;
}