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
 * Provides a wrapper for {@link SPPaymentLocalService}.
 *
 * @author pradeep
 * @see SPPaymentLocalService
 * @generated
 */
public class SPPaymentLocalServiceWrapper implements SPPaymentLocalService,
	ServiceWrapper<SPPaymentLocalService> {
	public SPPaymentLocalServiceWrapper(
		SPPaymentLocalService spPaymentLocalService) {
		_spPaymentLocalService = spPaymentLocalService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spPaymentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spPaymentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spPaymentLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.sambaash.platform.model.payment.ChargeStatus chargePayment(
		javax.portlet.PortletRequest request) {
		return _spPaymentLocalService.chargePayment(request);
	}

	@Override
	public com.sambaash.platform.model.payment.ChargeStatus refundPayment(
		javax.portlet.PortletRequest request) {
		return _spPaymentLocalService.refundPayment(request);
	}

	@Override
	public com.sambaash.platform.model.payment.ChargeStatus chargePayment(
		java.util.Map<java.lang.String, java.lang.Object> requestMap) {
		return _spPaymentLocalService.chargePayment(requestMap);
	}

	@Override
	public com.sambaash.platform.model.payment.ChargeStatus refundPayment(
		java.util.Map<java.lang.String, java.lang.Object> requestMap) {
		return _spPaymentLocalService.refundPayment(requestMap);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPPaymentLocalService getWrappedSPPaymentLocalService() {
		return _spPaymentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPPaymentLocalService(
		SPPaymentLocalService spPaymentLocalService) {
		_spPaymentLocalService = spPaymentLocalService;
	}

	@Override
	public SPPaymentLocalService getWrappedService() {
		return _spPaymentLocalService;
	}

	@Override
	public void setWrappedService(SPPaymentLocalService spPaymentLocalService) {
		_spPaymentLocalService = spPaymentLocalService;
	}

	private SPPaymentLocalService _spPaymentLocalService;
}