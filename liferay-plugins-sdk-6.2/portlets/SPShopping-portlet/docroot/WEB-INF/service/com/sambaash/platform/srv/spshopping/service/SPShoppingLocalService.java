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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.service.BaseLocalService;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service interface for SPShopping. Methods of this
 * service will not have security checks based on the propagated JAAS
 * credentials because this service can only be accessed from within the same
 * VM.
 *
 * @author pradeep
 * @see SPShoppingLocalServiceUtil
 * @see com.sambaash.platform.srv.spshopping.service.base.SPShoppingLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spshopping.service.impl.SPShoppingLocalServiceImpl
 * @generated
 */
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPShoppingLocalService extends BaseLocalService,
	InvokableLocalService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPShoppingLocalServiceUtil} to access the s p shopping local service. Add custom service methods to {@link com.sambaash.platform.srv.spshopping.service.impl.SPShoppingLocalServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	public long addProductCatalog(long companyId, long groupId, long userId,
		java.lang.String userName, long classNameId, long classPk,
		java.lang.String title, java.lang.String itemCode,
		java.lang.String shortDesc, java.lang.String longDesc);

	public void addProductInventory(long companyId, long groupId, long userId,
		java.lang.String userName, long classNameId, long classPk,
		java.util.Date startDate, java.util.Date endDate, int quantity);

	public com.liferay.portal.kernel.json.JSONArray retrieveProductInventory(
		long classNameId, long classPk);

	public int retrieveRemainingInventory(long classNameId, long classPk);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasEnoughInventory(long classNameId, long classPk,
		int inventoryNeeded);

	public long addProductPrice(long companyId, long groupId, long userId,
		java.lang.String userName, long classNameId, long classPk,
		java.lang.String currencyCode, java.math.BigDecimal price);

	public long createPaymentCart(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String payItemClassName,
		long payItemClassPk, java.math.BigDecimal payAmount,
		java.lang.String payCcy);

	public long createPaymentCart(long companyId, long groupId, long userId,
		java.lang.String userName, java.lang.String payItemClassName,
		long payItemClassPk, java.math.BigDecimal payAmount,
		java.lang.String payCcy, int quantity);

	public long retrievePakageWithEnoughInventory(long classNameId,
		long classPk, int qty);

	public void confirmPayment(long cartId, int confirmedQty);

	public void rejectPayment(long cartId);
}