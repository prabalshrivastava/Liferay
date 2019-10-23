package com.sambaash.platform.model.payment;


import java.math.BigDecimal;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.sambaash.platform.model.payment.exception.PaymentException;

public interface PaymentProvider {
	static final String GROUP_ID_FIELD = "groupId";

	public static final String PAY_CHARGE_ID = "charge_ref_code";
	public static final String PAY_REFUND_ID = "refund_ref_code";
	
	public static final String PAY_PROVIDER_FIELD = "pay_provider";
	public static final String PAY_AMOUNT_FIELD = "pay_amount";
	public static final String PAY_QUANTITY_FIELD = "pay_quantity";
	public static final String PAY_CURRENCY_FIELD = "pay_currency";
	public static final String PAY_DESC_FIELD = "pay_description";
	public static final String PAY_EMAIL_FIELD = "pay_email";
	public static final String PAY_REFUND_AMOUNT_FIELD = "pay_refund_amount";
	public static final String PAY_REFUND_REASON_FIELD = "pay_refund_reason";
	public static final String PAY_TRAN_DATETIME_FIELD = "pay_tran_datetime";
	
	public static final String PAY_STATUS_FIELD = "pay_status";
	public static final String PAY_ERROR_FIELD = "pay_error_code";
	public static final String PAY_SYSTEM_ERROR_CODE = "pay_syserr_999";
	
	public static final String PAY_SUCCESS_STATUS = "success";
	public static final String PAY_FAILED_STATUS = "failed";
	public static final String ALREADY_FULLY_PAID_STATUS = "fully_paid";
	public static final String REFUND_SUCCESS_STATUS = "refund_success";
	public static final String REFUND_FAILED_STATUS = "refund_failed";
	public static final String ALREADY_FULLY_REFUNDED_STATUS = "fully_refunded";
	public static final String PAYMENT_CANCELLED = "payment_cancelled";
	public static final String PAY_OFFLINE = "payOffline";

	public static final String DEFAULT_PAID_MESSAGE = "The payment had been received with reference code [$"+PAY_CHARGE_ID+"$]";
	public static final String DEFAULT_REFUNDED_MESSAGE = "The payment had been refunded with reference code [$"+PAY_REFUND_ID+"$]";
	
	public static final String PROVIDER_LIST_KEY = "online.payment.providers";
	
	public static final BigDecimal DEFAULT_AMOUNT_MULTIPLIER = new BigDecimal("100");

	public static final String METADATA_PREFIX = "metadata_";
	
	static final String PUBLIC_KEY_PARAM_SUFFIX = ".public.key";
	static final String SECRET_KEY_PARAM_SUFFIX = ".secret.key";

	// used for querying the shopping catalog and creating cart package
	public static final String PAY_ITEM_CLASS_NAME = "pay_item_className";
	public static final String PAY_ITEM_CLASS_PK = "pay_item_classPk";
	public static final String PAY_ITEM_CLASSLIST = "pay_item_classList";

	// request data fields
	static final String PRODUCT_TYPE 	= "data-product-type";
	static final String PRODUCT_ID 		= "data-product-id";
	static final String CHARGE_TO	 	= "data-charge-to";
	static final String CART_ID		 	= "data-cart-id";
	
	// refund status
	public static final String PAY_REFUND_IN_PROGRESS = "pay_refund_in_progress";
	public static final String PAY_REFUND_RESUME_STATE = "pay_refund_resume_state";
	
	// cart status used for payment confirmation
	public static final int PAYMENT_NO_CONFIRMATION_STATUS = 0;
	public static final int PAYMENT_CONFIRMED_STATUS = 1;
	public static final int PAYMENT_REJECTED_STATUS = 2;
	
	public String getRequestParameter(String paramName, String defaultValue);
	
	String getProviderId();
	String getProviderName();
	String getProviderSecretKey();
	String getProviderPublicKey();
	
	String createCustomer() throws PaymentException;
	ChargeStatus chargePayment() throws PaymentException;
	String subscribePayment() throws PaymentException;
	void addProviderCheckout(PortletRequest request,
			BigDecimal payAmount, String currency, String locale,
			String logoUrl, String payDesc, String siteName, String payEmail); 
	ChargeStatus fullRefund(Map<String, Object> otherParams) throws PaymentException;
	ChargeStatus partialRefund(BigDecimal refundAmount, Map<String, Object> otherParams) throws PaymentException;
	public Map<String, Object> getRequestMap();
}
