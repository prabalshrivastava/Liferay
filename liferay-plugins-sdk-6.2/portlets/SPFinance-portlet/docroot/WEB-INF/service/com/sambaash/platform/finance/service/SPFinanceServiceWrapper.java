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

package com.sambaash.platform.finance.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPFinanceService}.
 *
 * @author abhishek.upadhyay
 * @see SPFinanceService
 * @generated
 */
public class SPFinanceServiceWrapper implements SPFinanceService,
	ServiceWrapper<SPFinanceService> {
	public SPFinanceServiceWrapper(SPFinanceService spFinanceService) {
		_spFinanceService = spFinanceService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spFinanceService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spFinanceService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spFinanceService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public java.lang.String generateReferenceNumber(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType) {
		return _spFinanceService.generateReferenceNumber(scopeGroupId,
			productType, productSubType, functionalComponent, categoryType,
			clientType);
	}

	@Override
	public java.lang.String saveTransactionData(long scopeGroupId,
		java.lang.String productType, java.lang.String productSubType,
		java.lang.String functionalComponent, java.lang.String categoryType,
		java.lang.String clientType, java.lang.String txnDate,
		java.lang.String source, java.lang.String componentRefNumber,
		java.lang.String txnType, java.lang.String title,
		java.lang.String description, java.lang.String dueDate,
		java.lang.String valueDate, java.lang.String creditDate,
		java.lang.String transactionDetailJson,
		java.lang.String paymentDetailJson) {
		return _spFinanceService.saveTransactionData(scopeGroupId, productType,
			productSubType, functionalComponent, categoryType, clientType,
			txnDate, source, componentRefNumber, txnType, title, description,
			dueDate, valueDate, creditDate, transactionDetailJson,
			paymentDetailJson);
	}

	@Override
	public java.lang.String saveCreditBalance(long scopeGroupId,
		java.lang.Long creditBalanceAmt, java.lang.String status,
		java.lang.String usereId, java.lang.String userName,
		java.lang.String userType) {
		return _spFinanceService.saveCreditBalance(scopeGroupId,
			creditBalanceAmt, status, usereId, userName, userType);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPFinanceService getWrappedSPFinanceService() {
		return _spFinanceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPFinanceService(SPFinanceService spFinanceService) {
		_spFinanceService = spFinanceService;
	}

	@Override
	public SPFinanceService getWrappedService() {
		return _spFinanceService;
	}

	@Override
	public void setWrappedService(SPFinanceService spFinanceService) {
		_spFinanceService = spFinanceService;
	}

	private SPFinanceService _spFinanceService;
}