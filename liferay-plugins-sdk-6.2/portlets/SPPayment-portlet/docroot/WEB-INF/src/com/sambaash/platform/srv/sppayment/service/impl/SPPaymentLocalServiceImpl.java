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

package com.sambaash.platform.srv.sppayment.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.model.payment.ChargeStatus;
import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.sppayment.provider.PaymentProviderFactory;
import com.sambaash.platform.srv.sppayment.service.base.SPPaymentLocalServiceBaseImpl;

/**
 * The implementation of the s p payment local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.sppayment.service.SPPaymentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.sppayment.service.base.SPPaymentLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.sppayment.service.SPPaymentLocalServiceUtil
 */
public class SPPaymentLocalServiceImpl extends SPPaymentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.sppayment.service.SPPaymentLocalServiceUtil} to access the s p payment local service.
	 */
	private static Log logger = LogFactoryUtil.getLog(SPPaymentLocalServiceImpl.class);
			
    private String getProvider(PortletRequest request) {
    	return (String) request.getParameter(PaymentProvider.PAY_PROVIDER_FIELD);
    }	
	
    private String getProvider(Map<String, Object> requestMap) {
    	return (String) requestMap.get(PaymentProvider.PAY_PROVIDER_FIELD);
    }	
	
	public ChargeStatus chargePayment(PortletRequest request) {
		ChargeStatus status;
		try {
			PaymentProvider payProvider = PaymentProviderFactory.newPaymentProvider(getProvider(request), request);
			status = payProvider.chargePayment();			
		} catch (Exception e) {
			logger.error(e);
			status = new ChargeStatus(null, PaymentProvider.PAY_SYSTEM_ERROR_CODE); // System Error
		}
		return status;
	}

	public ChargeStatus refundPayment(PortletRequest request) {
		ChargeStatus status;
		try {
			PaymentProvider payProvider = PaymentProviderFactory.newPaymentProvider(getProvider(request), request);
			String refundAmountStr = payProvider.getRequestParameter(PaymentProvider.PAY_REFUND_AMOUNT_FIELD, null);
			Map<String, Object> otherParams = payProvider.getRequestMap();

			if (StringUtils.isNotEmpty(refundAmountStr)) {
				status = payProvider.partialRefund(new BigDecimal(refundAmountStr), otherParams);
			} else {
				status = payProvider.fullRefund(otherParams);
			}
		} catch (Exception e) {
			logger.error(e);
			status = new ChargeStatus(null, PaymentProvider.PAY_SYSTEM_ERROR_CODE); // System Error
		}
		return status;
	}
	
	public ChargeStatus chargePayment(Map<String, Object> requestMap) {
		ChargeStatus status;
		try {
			PaymentProvider payProvider = PaymentProviderFactory.newPaymentProvider(getProvider(requestMap), requestMap);
			status = payProvider.chargePayment();
		} catch (Exception e) {
			logger.error(e);
			status = new ChargeStatus(null, PaymentProvider.PAY_SYSTEM_ERROR_CODE); // System Error
		}
		return status;
	}

	public ChargeStatus refundPayment(Map<String, Object> requestMap) {
		ChargeStatus status;
		try {
			PaymentProvider payProvider = PaymentProviderFactory.newPaymentProvider(getProvider(requestMap), requestMap);
			String refundAmountStr = payProvider.getRequestParameter(PaymentProvider.PAY_REFUND_AMOUNT_FIELD, null);

			if (StringUtils.isNotEmpty(refundAmountStr)) {
				status = payProvider.partialRefund(new BigDecimal(refundAmountStr), payProvider.getRequestMap());
			} else {
				status = payProvider.fullRefund(payProvider.getRequestMap());
			}			
		} catch (Exception e) {
			logger.error(e);
			status = new ChargeStatus(null, PaymentProvider.PAY_SYSTEM_ERROR_CODE); // System Error
		}
		return status;
	}
	
}