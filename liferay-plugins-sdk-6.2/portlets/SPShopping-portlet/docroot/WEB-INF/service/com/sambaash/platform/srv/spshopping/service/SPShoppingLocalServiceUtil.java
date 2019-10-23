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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPShopping. This utility wraps
 * {@link com.sambaash.platform.srv.spshopping.service.impl.SPShoppingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pradeep
 * @see SPShoppingLocalService
 * @see com.sambaash.platform.srv.spshopping.service.base.SPShoppingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spshopping.service.impl.SPShoppingLocalServiceImpl
 * @generated
 */
public class SPShoppingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spshopping.service.impl.SPShoppingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static long addProductCatalog(long companyId, long groupId,
		long userId, java.lang.String userName, long classNameId, long classPk,
		java.lang.String title, java.lang.String itemCode,
		java.lang.String shortDesc, java.lang.String longDesc) {
		return getService()
				   .addProductCatalog(companyId, groupId, userId, userName,
			classNameId, classPk, title, itemCode, shortDesc, longDesc);
	}

	public static void addProductInventory(long companyId, long groupId,
		long userId, java.lang.String userName, long classNameId, long classPk,
		java.util.Date startDate, java.util.Date endDate, int quantity) {
		getService()
			.addProductInventory(companyId, groupId, userId, userName,
			classNameId, classPk, startDate, endDate, quantity);
	}

	public static com.liferay.portal.kernel.json.JSONArray retrieveProductInventory(
		long classNameId, long classPk) {
		return getService().retrieveProductInventory(classNameId, classPk);
	}

	public static int retrieveRemainingInventory(long classNameId, long classPk) {
		return getService().retrieveRemainingInventory(classNameId, classPk);
	}

	public static boolean hasEnoughInventory(long classNameId, long classPk,
		int inventoryNeeded) {
		return getService()
				   .hasEnoughInventory(classNameId, classPk, inventoryNeeded);
	}

	public static long addProductPrice(long companyId, long groupId,
		long userId, java.lang.String userName, long classNameId, long classPk,
		java.lang.String currencyCode, java.math.BigDecimal price) {
		return getService()
				   .addProductPrice(companyId, groupId, userId, userName,
			classNameId, classPk, currencyCode, price);
	}

	public static long createPaymentCart(long companyId, long groupId,
		long userId, java.lang.String userName,
		java.lang.String payItemClassName, long payItemClassPk,
		java.math.BigDecimal payAmount, java.lang.String payCcy) {
		return getService()
				   .createPaymentCart(companyId, groupId, userId, userName,
			payItemClassName, payItemClassPk, payAmount, payCcy);
	}

	public static long createPaymentCart(long companyId, long groupId,
		long userId, java.lang.String userName,
		java.lang.String payItemClassName, long payItemClassPk,
		java.math.BigDecimal payAmount, java.lang.String payCcy, int quantity) {
		return getService()
				   .createPaymentCart(companyId, groupId, userId, userName,
			payItemClassName, payItemClassPk, payAmount, payCcy, quantity);
	}

	public static long retrievePakageWithEnoughInventory(long classNameId,
		long classPk, int qty) {
		return getService()
				   .retrievePakageWithEnoughInventory(classNameId, classPk, qty);
	}

	public static void confirmPayment(long cartId, int confirmedQty) {
		getService().confirmPayment(cartId, confirmedQty);
	}

	public static void rejectPayment(long cartId) {
		getService().rejectPayment(cartId);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPShoppingLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPShoppingLocalService.class.getName());

			if (invokableLocalService instanceof SPShoppingLocalService) {
				_service = (SPShoppingLocalService)invokableLocalService;
			}
			else {
				_service = new SPShoppingLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPShoppingLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPShoppingLocalService service) {
	}

	private static SPShoppingLocalService _service;
}