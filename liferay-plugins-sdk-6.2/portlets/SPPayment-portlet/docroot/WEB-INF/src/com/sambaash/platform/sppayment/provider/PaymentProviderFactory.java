package com.sambaash.platform.sppayment.provider;

import java.util.Map;

import javax.portlet.PortletRequest;

import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.sppayment.provider.stripe.StripePaymentProvider;

public class PaymentProviderFactory {
	public static final String STRIPE_PAYMENT = "stripe";
	
	public static final PaymentProvider newPaymentProvider(String providerName, PortletRequest request) {
		switch (providerName) {
		case STRIPE_PAYMENT:
			return new StripePaymentProvider(request);
		default:
			return null;
		}
	}

	public static final PaymentProvider newPaymentProvider(String providerName, Map<String, Object> requestMap) {
		switch (providerName) {
		case STRIPE_PAYMENT:
			return new StripePaymentProvider(requestMap);
		default:
			return null;
		}
	}

}
