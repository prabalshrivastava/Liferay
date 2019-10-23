package com.sambaash.platform.sppayment.provider;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.portlet.PortletRequest;

import org.apache.commons.lang.StringUtils;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.sambaash.platform.model.payment.ChargeStatus;
import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.model.payment.exception.PaymentException;
import com.sambaash.platform.srv.sppayment.model.SPPurchase;
import com.sambaash.platform.srv.sppayment.service.SPPurchaseLocalServiceUtil;
import com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil;

public abstract class AbstractPaymentProvider implements PaymentProvider {
	private static Log logger = LogFactoryUtil.getLog(AbstractPaymentProvider.class);
			
	abstract protected String getId();
	abstract protected String getName();
	abstract protected String createProviderCustomer(String emailAddress) throws PaymentException;
	abstract protected ChargeStatus charge(String cartId, Map<String, Object> metadata) throws PaymentException;
	
	private String providerSecretKey;
	private String providerPublicKey;
	
	protected Map<String, Object> requestMap;
	
	public AbstractPaymentProvider(PortletRequest request) {
		this.requestMap = new HashMap<>();
		requestMap.put(PAY_PROVIDER_FIELD, (String) request.getParameter(PAY_PROVIDER_FIELD));
		requestMap.put(PAY_AMOUNT_FIELD, (String) request.getParameter(PAY_AMOUNT_FIELD));
		requestMap.put(PAY_CURRENCY_FIELD, (String) request.getParameter(PAY_CURRENCY_FIELD));
		requestMap.put(PAY_DESC_FIELD, (String) request.getParameter(PAY_DESC_FIELD));
		requestMap.put(PAY_EMAIL_FIELD, (String) request.getParameter(PAY_EMAIL_FIELD));
		requestMap.put(PAY_CHARGE_ID, (String) request.getParameter(PAY_CHARGE_ID));
		requestMap.put(PAY_REFUND_AMOUNT_FIELD, (String) request.getParameter(PAY_REFUND_AMOUNT_FIELD));
		requestMap.put(PAY_REFUND_REASON_FIELD, (String) request.getParameter(PAY_REFUND_REASON_FIELD));
		int quantity = 1;
		try {
			quantity = Integer.parseInt((String) request.getParameter(PAY_QUANTITY_FIELD));			
		} catch (Exception e) {
			// default quantity to 1
		}
		requestMap.put(PAY_QUANTITY_FIELD, String.valueOf(quantity));
		setProviderKeys();
	}
	
	public AbstractPaymentProvider(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
		int quantity = 1;
		try {
			quantity = Integer.parseInt((String) requestMap.get(PAY_QUANTITY_FIELD));			
		} catch (Exception e) {
			// default quantity to 1
		}
		requestMap.put(PAY_QUANTITY_FIELD, String.valueOf(quantity));
		setProviderKeys();
	}
	
	public Map<String, Object> getRequestMap() {
		if (requestMap==null) {
			this.requestMap = new HashMap<>();
		}
		return requestMap;
	}
	
	private void setProviderKeys() {
		long groupId = Long.parseLong(getRequestParameter(PaymentProvider.GROUP_ID_FIELD, "0"));
		providerPublicKey = PaymentProviderUtil.getPublicKey(groupId, getId());
		providerSecretKey = PaymentProviderUtil.getSecretKey(groupId, getId());
	}
	
	@Override
	public String getRequestParameter(String paramName, String defaultValue) {
		String paramValue = (String) requestMap.get(paramName);
		if (StringUtils.isEmpty(paramValue)) {
			paramValue = defaultValue;
		}
		return paramValue;
	}

	@Override
	public String getProviderId() {
		return getId();
	}

	@Override
	public String getProviderName() {
		return getName();
	}
	
	@Override
	public String getProviderSecretKey() {
		return providerSecretKey;
	}

	@Override
	public String getProviderPublicKey() {
		return providerPublicKey;
	}

	
	@Override
	public String createCustomer() throws PaymentException {
		String emailAddress = getRequestParameter(PAY_EMAIL_FIELD, null);
		if (StringUtils.isEmpty(emailAddress)) {
			throw new PaymentException("Customer email address not specified.");
		}
		return createProviderCustomer(emailAddress);
	}

	@Override
	public ChargeStatus chargePayment() throws PaymentException {
		ChargeStatus status = null;
		try {
			String cartId = getCartId();
			// In payment v2, cart id is always supplied and is not numeric
			boolean isVersion2 = StringUtils.isNotEmpty(cartId) && !StringUtils.isNumeric(cartId);
			if (StringUtils.isEmpty(cartId)) {
				cartId = createCart();  // version 1
			}
			debug("Charging Payment for Cart : "+cartId);
			
			Map<String, Object> metadata = new HashMap<String, Object>();
			metadata.put("cartId", cartId);
			addOtherMetadataInfo(metadata);
			
			status = charge(cartId, metadata);
			if (status.isSuccess()) {
				debug("Payment successful with reference id "+status.getChargeId());
				status.setCartId(cartId);
				if (!isVersion2) {
					// add only for version 1
					addPurchasedCartEntry(status);
				}
			} else {
				debug("Payment failed with error code "+status.getErrorCode());
			}
		} catch (Exception e) {
			throw new PaymentException("Unable to successfully charge the transaction");
		}
		return status;
	}
	
    private void addPurchasedCartEntry(ChargeStatus chargeStatus) {
    	try {
    		long cartId = Long.parseLong(chargeStatus.getCartId());
    		User payor = (User) getRequestMap().get("payor");
    		long purchaseId = CounterLocalServiceUtil.increment("SPPurchase");
    		SPPurchase spPurchase = SPPurchaseLocalServiceUtil.createSPPurchase(purchaseId);
    		Date now = new Date();
    		spPurchase.setCreateDate(now);
    		spPurchase.setModifiedDate(now);
    		setPayorData(spPurchase);
    		spPurchase.setCartId(cartId);
    		spPurchase.setExtPaymentId(chargeStatus.getChargeId());
			SPPurchaseLocalServiceUtil.addSPPurchase(spPurchase);
		} catch (Exception e) {
			logger.error("Error adding to SPPurchase - "+chargeStatus.getCartId(), e);
		}		
	}
	private void setPayorData(SPPurchase spPurchase) {
		User payor = (User) getRequestMap().get("payor");
		spPurchase.setCompanyId(payor.getCompanyId());
		spPurchase.setUserId(payor.getUserId());
		spPurchase.setUserName(payor.getScreenName());
		try {
			spPurchase.setGroupId(payor.getGroupId());	
		} catch (Exception e) {
			// handle Guest payment which will not have a groupId
			spPurchase.setGroupId(0);
		}
	}	
	private void addOtherMetadataInfo(Map<String, Object> metadata) {
		for(Map.Entry<String, Object> entry: requestMap.entrySet()) {
			String key = entry.getKey();
			if (key.startsWith(METADATA_PREFIX)) {
				key = key.substring(METADATA_PREFIX.length());
				metadata.put(key, entry.getValue());
			}
		}
	}
    
	private String createCart() {
		// TODO add creation of cart entry
		Map<String, Object> m = getRequestMap(); 
		if (m.containsKey(PAY_ITEM_CLASS_NAME)) {			
			try {
				String payItemClassName = (String) m.get(PAY_ITEM_CLASS_NAME);
				String payItemClassPk = (String) m.get(PAY_ITEM_CLASS_PK);
				long pk = StringUtils.isEmpty(payItemClassPk) ? 0 : Long.parseLong(payItemClassPk);
				String payCcy = getRequestParameter(PAY_CURRENCY_FIELD, "");
				BigDecimal payAmount = new BigDecimal(getRequestParameter(PAY_AMOUNT_FIELD, "0"));
				User payor = (User) m.get("payor");
				long cartId = SPShoppingLocalServiceUtil.createPaymentCart(payor.getCompanyId(), payor.getGroupId(), payor.getUserId(), payor.getScreenName(), payItemClassName, pk, payAmount, payCcy);
				return String.valueOf(cartId);
			} catch (Exception e) {
				logger.error("Error creating payment cart.");
			}
		}
		return "-1";
	}
	protected String dataFieldNameToJavaFieldName(String dataFieldName) {
        return String.format(dataFieldName.replaceAll("\\-(.)", "%S"), dataFieldName.replaceAll("[^-]*-(.)[^-]*", "$1-").split("-"));
    }
    
    protected String getCartId() {
		return getRequestParameter(CART_ID, "");
	}  
    
    private static void debug(String debugMsg) {
    	if (logger.isDebugEnabled()) {
    		logger.debug(debugMsg);
    	}
    }
}
