package com.sambaash.platform.sppayment.provider.stripe;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.model.payment.ChargeStatus;
import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.model.payment.StripeConstants;
import com.sambaash.platform.model.payment.exception.PaymentException;
import com.sambaash.platform.sppayment.provider.AbstractPaymentProvider;
import com.stripe.Stripe;
import com.stripe.exception.APIConnectionException;
import com.stripe.exception.APIException;
import com.stripe.exception.AuthenticationException;
import com.stripe.exception.CardException;
import com.stripe.exception.InvalidRequestException;
import com.stripe.model.Charge;
import com.stripe.model.Customer;
import com.stripe.model.Refund;
import com.stripe.net.RequestOptions;

public class StripePaymentProvider extends AbstractPaymentProvider {
	private static Log logger = LogFactoryUtil.getLog(StripePaymentProvider.class);

	private static final String STRIPE_PUBLIC_KEY = "stripe.public.key";
	private static final String STRIPE_SECRET_KEY = "stripe.secret.key";

	public StripePaymentProvider(Map<String, Object> requestMap) {
		super(requestMap);
		requestMap.put(PAY_PROVIDER_FIELD, getId());
//		Stripe.apiKey = getProviderSecretKey();
	}

	public StripePaymentProvider(PortletRequest request) {
		super(request);
		requestMap.put(PAY_PROVIDER_FIELD, getId());
		requestMap.put(StripeConstants.STRIPE_CHECKOUT_TOKEN, (String) request.getParameter(StripeConstants.STRIPE_CHECKOUT_TOKEN));
		requestMap.put(StripeConstants.STRIPE_PAY_LOCALE_FIELD, (String) request.getParameter(StripeConstants.STRIPE_PAY_LOCALE_FIELD));
		requestMap.put(StripeConstants.STRIPE_SITE_LOGO_FIELD, (String) request.getParameter(StripeConstants.STRIPE_SITE_LOGO_FIELD));
		requestMap.put(StripeConstants.STRIPE_SITE_NAME_FIELD, (String) request.getParameter(StripeConstants.STRIPE_SITE_NAME_FIELD));	
//		Stripe.apiKey = getProviderSecretKey();
	}
	
	@Override
	protected String getId() {
		return "stripe";
	}

	@Override
	protected String getName() {
		return "Stripe online payment";
	}
	
	@Override
	protected String createProviderCustomer(String emailAddress)
			throws PaymentException {
		String customerCode = null;
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("email", emailAddress);

			Customer customer = Customer.create(params);
			customerCode = customer.getId();
		} catch (Exception e) {
			throw new PaymentException(e);
		}
		return customerCode;
	}

	@Override
	public String subscribePayment()
			throws PaymentException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected ChargeStatus charge(String cartId, Map metadata) throws PaymentException {
		// Token is created using Stripe.js or Checkout
		// Get the payment token ID submitted by the form:
		String token = getRequestParameter(StripeConstants.STRIPE_CHECKOUT_TOKEN, "");
		String amountStr = getRequestParameter(PAY_AMOUNT_FIELD, "0");
		String ccy = getRequestParameter(PAY_CURRENCY_FIELD, "");
		String desc = getRequestParameter(PAY_DESC_FIELD, "");

		// Charge the user's card:
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("amount", new BigDecimal(amountStr).multiply(DEFAULT_AMOUNT_MULTIPLIER).longValue());
		params.put("currency", ccy);
		params.put("description", desc);
		params.put("source", token);
		if (metadata != null) {
			params.put("metadata", metadata);			
		}
		ChargeStatus status = null;
		String chargeRefId = null;
		Charge charge;
		try {
			RequestOptions options = getRequestOption(metadata);
			charge = Charge.create(params, options);
			chargeRefId = charge.getId();
			if (StripeConstants.CHARGE_SUCCEEDED.equals(charge.getStatus())) {
				status = new StripeChargeStatus(chargeRefId);
				status.setCartId(cartId);
				status.setChargeInfo(charge.toJson());
			} else {
				status = new StripeChargeStatus(chargeRefId, charge.getOutcome().getReason());
				status.setErrorMessage(charge.getOutcome().getSellerMessage());
			}
		} catch (AuthenticationException e) {
			throw new PaymentException("There was an Authentication exception.", e);
		} catch (APIConnectionException | InvalidRequestException e) {
			status = new StripeChargeStatus(null, String.valueOf(e.getStatusCode()));
			status.setErrorMessage(e.getMessage());
		} catch (CardException e) {
			status = new StripeChargeStatus(null, e.getCode());
			status.setErrorMessage(String.format("[%s] %s", e.getDeclineCode(), e.getMessage()));
		} catch (APIException e) {
			throw new PaymentException("There was an API exception.", e);
		} catch (Exception e) {
			throw new PaymentException(e);
		}
		return status;
	}

	private RequestOptions getRequestOption(Map metadata) {
		String sk = getProviderSecretKey();
		if (metadata != null && metadata.containsKey(STRIPE_SECRET_KEY)) {
			sk = (String) metadata.remove(STRIPE_SECRET_KEY);
			metadata.remove(STRIPE_PUBLIC_KEY);
		}
		return new RequestOptions.RequestOptionsBuilder().setApiKey(sk)
				.setStripeVersion(Stripe.apiVersion)
				.setConnectTimeout(Stripe.getConnectTimeout())
				.setReadTimeout(Stripe.getReadTimeout())
			.build();
	}

	@Override
	public void addProviderCheckout(PortletRequest request,
			BigDecimal payAmount, String currency, String locale,
			String logoUrl, String payDesc, String siteName, String payEmail) {
		request.setAttribute(PAY_AMOUNT_FIELD, payAmount);
		request.setAttribute(PAY_CURRENCY_FIELD, currency);
		request.setAttribute(StripeConstants.STRIPE_PAY_LOCALE_FIELD, locale);
		request.setAttribute(StripeConstants.STRIPE_SITE_LOGO_FIELD, logoUrl);
		request.setAttribute(PAY_DESC_FIELD, payDesc);
		request.setAttribute(StripeConstants.STRIPE_SITE_NAME_FIELD, siteName);
		request.setAttribute(PAY_EMAIL_FIELD, payEmail);
		request.setAttribute(StripeConstants.STRIPE_CHECKOUT_AMT_FIELD, payAmount.multiply(DEFAULT_AMOUNT_MULTIPLIER).longValue());
	}

	@Override
	public ChargeStatus fullRefund(Map<String, Object> otherParams) throws PaymentException {
		return doRefund(null, otherParams);
	}

	@Override
	public ChargeStatus partialRefund(BigDecimal refundAmount, Map<String, Object> otherParams) throws PaymentException {
		return doRefund(refundAmount, otherParams);
	}

	private ChargeStatus doRefund(BigDecimal refundAmount, Map<String, Object> otherParams) throws PaymentException {
		String chargeId = getRequestParameter(PAY_CHARGE_ID, "");
		Map<String, Object> params = new HashMap<>();
		params.put("charge", chargeId);
		if (refundAmount != null && refundAmount.compareTo(BigDecimal.ZERO)!=0) {
			long refundAmt = refundAmount.multiply(DEFAULT_AMOUNT_MULTIPLIER).longValue();
			params.put("amount", refundAmt);
		}
		if (otherParams != null) {
			Map<String, Object> metadata = new HashMap<>();
			if (otherParams.containsKey(PAY_REFUND_REASON_FIELD)) {
				metadata.put("refund_reason", (String) otherParams.get(PAY_REFUND_REASON_FIELD));				
			}
			if (otherParams.containsKey(PaymentProvider.CART_ID)) {
				metadata.put(PaymentProvider.CART_ID, (String) otherParams.get(PaymentProvider.CART_ID));				
			}
			params.put("reason", "requested_by_customer");
			params.put("metadata", metadata);
		}
		ChargeStatus status = null;
		String refundId = null;
		try {
			RequestOptions options = getRequestOption(otherParams);
			Refund refund = Refund.create(params, options);	
			refundId = refund.getId();
			if (StripeConstants.REFUND_SUCCEEDED.equals(refund.getStatus())) {
				status = new StripeChargeStatus(refundId);
				status.setChargeInfo(refund.toJson());
			} else {
				status = new StripeChargeStatus(refundId, "refund_failed");
				status.setErrorMessage(refund.getReason());
			}
		} catch (Exception e) {
			throw new PaymentException(e);
		}
		return status;
	}

	
}
