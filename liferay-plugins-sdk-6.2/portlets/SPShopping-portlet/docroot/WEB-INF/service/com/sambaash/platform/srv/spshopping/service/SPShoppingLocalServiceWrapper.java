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
 * Provides a wrapper for {@link SPShoppingLocalService}.
 *
 * @author pradeep
 * @see SPShoppingLocalService
 * @generated
 */
public class SPShoppingLocalServiceWrapper implements SPShoppingLocalService,
	ServiceWrapper<SPShoppingLocalService> {
	public SPShoppingLocalServiceWrapper(
		SPShoppingLocalService spShoppingLocalService) {
		_spShoppingLocalService = spShoppingLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spShoppingLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spShoppingLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spShoppingLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public long addProductCatalog(long companyId, long groupId, long userId,
		java.lang.String userName, long classNameId, long classPk,
		java.lang.String title, java.lang.String itemCode,
		java.lang.String shortDesc, java.lang.String longDesc) {
		return _spShoppingLocalService.addProductCatalog(companyId, groupId,
			userId, userName, classNameId, classPk, title, itemCode, shortDesc,
			longDesc);
	}

	@Override
	public void addProductInventory(long companyId, long groupId, long userId,
		java.lang.String userName, long classNameId, long classPk,
		java.util.Date startDate, java.util.Date endDate, int quantity) {
		_spShoppingLocalService.addProductInventory(companyId, groupId, userId,
			userName, classNameId, classPk, startDate, endDate, quantity);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray retrieveProductInventory(
		long classNameId, long classPk) {
		return _spShoppingLocalService.retrieveProductInventory(classNameId,
			classPk);
	}

	@Override
	public int retrieveRemainingInventory(long classNameId, long classPk) {
		return _spShoppingLocalService.retrieveRemainingInventory(classNameId,
			classPk);
	}

	@Override
	public boolean hasEnoughInventory(long classNameId, long classPk,
		int inventoryNeeded) {
		return _spShoppingLocalService.hasEnoughInventory(classNameId, classPk,
			inventoryNeeded);
	}

	@Override
	public long addProductPrice(long companyId, long groupId, long userId,
		java.lang.String userName, long classNameId, long classPk,
		java.lang.String currencyCode, java.math.BigDecimal price) {
		return _spShoppingLocalService.addProductPrice(companyId, groupId,
			userId, userName, classNameId, classPk, currencyCode, price);
	}

	@Override
	public long createPaymentCart(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String payItemClassName,
		long payItemClassPk, java.math.BigDecimal payAmount,
		java.lang.String payCcy) {
		return _spShoppingLocalService.createPaymentCart(companyId, groupId,
			userId, userName, payItemClassName, payItemClassPk, payAmount,
			payCcy);
	}

	@Override
	public long createPaymentCart(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String payItemClassName,
		long payItemClassPk, java.math.BigDecimal payAmount,
		java.lang.String payCcy, int quantity) {
		return _spShoppingLocalService.createPaymentCart(companyId, groupId,
			userId, userName, payItemClassName, payItemClassPk, payAmount,
			payCcy, quantity);
	}

	@Override
	public long retrievePakageWithEnoughInventory(long classNameId,
		long classPk, int qty) {
		return _spShoppingLocalService.retrievePakageWithEnoughInventory(classNameId,
			classPk, qty);
	}

	@Override
	public void confirmPayment(long cartId, int confirmedQty) {
		_spShoppingLocalService.confirmPayment(cartId, confirmedQty);
	}

	@Override
	public void rejectPayment(long cartId) {
		_spShoppingLocalService.rejectPayment(cartId);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPShoppingLocalService getWrappedSPShoppingLocalService() {
		return _spShoppingLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPShoppingLocalService(
		SPShoppingLocalService spShoppingLocalService) {
		_spShoppingLocalService = spShoppingLocalService;
	}

	@Override
	public SPShoppingLocalService getWrappedService() {
		return _spShoppingLocalService;
	}

	@Override
	public void setWrappedService(SPShoppingLocalService spShoppingLocalService) {
		_spShoppingLocalService = spShoppingLocalService;
	}

	private SPShoppingLocalService _spShoppingLocalService;
}