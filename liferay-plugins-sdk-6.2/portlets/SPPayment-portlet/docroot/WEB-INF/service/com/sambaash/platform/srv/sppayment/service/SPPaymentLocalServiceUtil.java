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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableLocalService;

/**
 * Provides the local service utility for SPPayment. This utility wraps
 * {@link com.sambaash.platform.srv.sppayment.service.impl.SPPaymentLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author pradeep
 * @see SPPaymentLocalService
 * @see com.sambaash.platform.srv.sppayment.service.base.SPPaymentLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.sppayment.service.impl.SPPaymentLocalServiceImpl
 * @generated
 */
public class SPPaymentLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.sppayment.service.impl.SPPaymentLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.sambaash.platform.model.payment.ChargeStatus chargePayment(
		javax.portlet.PortletRequest request) {
		return getService().chargePayment(request);
	}

	public static com.sambaash.platform.model.payment.ChargeStatus refundPayment(
		javax.portlet.PortletRequest request) {
		return getService().refundPayment(request);
	}

	public static com.sambaash.platform.model.payment.ChargeStatus chargePayment(
		java.util.Map<java.lang.String, java.lang.Object> requestMap) {
		return getService().chargePayment(requestMap);
	}

	public static com.sambaash.platform.model.payment.ChargeStatus refundPayment(
		java.util.Map<java.lang.String, java.lang.Object> requestMap) {
		return getService().refundPayment(requestMap);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPPaymentLocalService getService() {
		if (_service == null) {
			InvokableLocalService invokableLocalService = (InvokableLocalService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPPaymentLocalService.class.getName());

			if (invokableLocalService instanceof SPPaymentLocalService) {
				_service = (SPPaymentLocalService)invokableLocalService;
			}
			else {
				_service = new SPPaymentLocalServiceClp(invokableLocalService);
			}

			ReferenceRegistry.registerReference(SPPaymentLocalServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPPaymentLocalService service) {
	}

	private static SPPaymentLocalService _service;
}