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
 * Provides a wrapper for {@link SPShoppingService}.
 *
 * @author pradeep
 * @see SPShoppingService
 * @generated
 */
public class SPShoppingServiceWrapper implements SPShoppingService,
	ServiceWrapper<SPShoppingService> {
	public SPShoppingServiceWrapper(SPShoppingService spShoppingService) {
		_spShoppingService = spShoppingService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spShoppingService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spShoppingService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spShoppingService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public boolean hasEnoughInventory(long classNameId, long classPk,
		int inventoryNeeded) {
		return _spShoppingService.hasEnoughInventory(classNameId, classPk,
			inventoryNeeded);
	}

	@Override
	public int remainingInventory(long classNameId, long classPk) {
		return _spShoppingService.remainingInventory(classNameId, classPk);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPShoppingService getWrappedSPShoppingService() {
		return _spShoppingService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPShoppingService(SPShoppingService spShoppingService) {
		_spShoppingService = spShoppingService;
	}

	@Override
	public SPShoppingService getWrappedService() {
		return _spShoppingService;
	}

	@Override
	public void setWrappedService(SPShoppingService spShoppingService) {
		_spShoppingService = spShoppingService;
	}

	private SPShoppingService _spShoppingService;
}