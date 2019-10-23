package com.sambaash.platform.pe.payment;

import static com.sambaash.platform.model.payment.PaymentProvider.*;

import java.io.InputStream;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.User;
import com.sambaash.platform.model.payment.ChargeStatus;
import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PEPaymentV2;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.sppayment.service.SPPaymentLocalServiceUtil;
import com.sambaash.platform.util.ConvertUtil;
import com.sambaash.platform.util.DateUtils;
import com.sambaash.platform.util.SambaashUtil;

public class PEPaymentV2Helper {
	private static Log logger = LogFactoryUtil.getLog(PEPaymentV2Helper.class);
			
	public static final String PUBLIC_KEY_PARAM_SUFFIX = ".public.key";
	public static final String SECRET_KEY_PARAM_SUFFIX = ".secret.key";
	
	protected final PEDataSource ds;
	protected final PEPaymentV2 paymentNode;
	protected JSONObject paymentInfo = JSONFactoryUtil.createJSONObject();
	protected JSONObject refundInfo = JSONFactoryUtil.createJSONObject();
		
	public PEPaymentV2Helper(PEDataSource ds,PEPaymentV2 payPaymentNode) {
		this.ds = ds;
		this.paymentNode = payPaymentNode;
	}
	
	public PESimpleOutput save() throws PEException{
		PESimpleOutput output = new PESimpleOutput();
		PERequestData requestData = ds.getRequestData();
		String payAction = requestData.getParameter("paymentAction");
		String paidTranCodes = requestData.getParameter(PaymentProvider.CART_ID);
		PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
		PEProcessAudit completedPaymentAudit = retrievePaymentAudit();
		PEProcessAudit refundedPaymentAudit = retrieveRefundAudit();
		boolean isCompleted = completedPaymentAudit != null || refundedPaymentAudit != null;
		
		String existingChargeId = null;
		String existingRefundId = null;
		
		if (isCompleted) {
			try {
				paymentInfo = JSONFactoryUtil.createJSONObject(completedPaymentAudit.getData1());
				existingChargeId = paymentInfo.getString(PaymentProvider.PAY_CHARGE_ID);
				if (refundedPaymentAudit != null) {
					refundInfo = JSONFactoryUtil.createJSONObject(refundedPaymentAudit.getData1());
					existingRefundId = refundInfo.getString(PaymentProvider.PAY_REFUND_ID);					
				}
			} catch (Exception e) {
				throw new PEException("Error retrieving completed payment information.");
			}
		}

		if (StringUtils.isNotEmpty(existingRefundId)) {
			logger.debug("The payment "+existingChargeId+" had been refunded with reference code "+existingRefundId);
		}
			
		boolean isRefundAlreadyInProgress = "true".equalsIgnoreCase(dataAdapter.getDataFromProcessState(PAY_REFUND_IN_PROGRESS, true));
		if (isRefundAlreadyInProgress && StringUtils.isNotEmpty(payAction)) {
			throw new PEException("Refund is in progress. Action is invalid.");
		}
		
		String payStatus = "";
		String payError = "";
		
		switch (payAction) {
		case "pay":
			if (StringUtils.isEmpty(existingChargeId)) {
				Map<String, Object> paramMap = convertMap(requestData.getRequestParams());
				if (!paramMap.containsKey(PaymentProvider.CART_ID)) {
					paramMap.put(PaymentProvider.CART_ID, paidTranCodes);
				}
				ChargeStatus status = SPPaymentLocalServiceUtil.chargePayment(paramMap);
				logger.debug("Payment Successful ? "+status.isSuccess());
				if (status.isSuccess()) {
					logger.error("Charge Info: "+status.getChargeInfo());
					String ccy = (String) paramMap.get(PAY_CURRENCY_FIELD);
					double paidAmount = Double.parseDouble((String) paramMap.get(PAY_AMOUNT_FIELD));
					payStatus = PAY_SUCCESS_STATUS;
					paymentInfo.put(PAY_CHARGE_ID, status.getChargeId());
					paymentInfo.put(PAY_STATUS_FIELD, payStatus);
					paymentInfo.put(PAY_ERROR_FIELD, payError);
					paymentInfo.put(CART_ID, paidTranCodes);
					paymentInfo.put(PAY_TRAN_DATETIME_FIELD, DateUtils.toDateTimeString(new Date()));
					String pricingNodeId = dataAdapter.getDataFromProcessState("_lastPricingNodeSubmitted_");
					paymentInfo.put("pricingNodeId", pricingNodeId);
					paymentInfo.put("paidTranCodes", ConvertUtil.Json.stringListToJsonArray(paidTranCodes));
					JSONObject payDetails = JSONFactoryUtil.createJSONObject();
					payDetails.put("totalFee", paidAmount);
					payDetails.put("currency", ccy);
					paymentInfo.put("payDetails", payDetails);
					
					dataAdapter.store(PAY_CHARGE_ID, status.getChargeId());
					dataAdapter.store(CART_ID, paidTranCodes);
					audit(paymentInfo.toString(), false);
					User user = (User)paramMap.get("payor");
					if (!SambaashUtil.isStripeWebhookOn()) {
						JSONObject stripeEvent = getSampleStripeEvent();
						JSONObject stripeEventObject = stripeEvent.getJSONObject("object");
						stripeEventObject.getJSONObject("metadata").put("cartId", status.getCartId());
						stripeEventObject.getJSONObject("metadata").put("payerName", user.getFirstName()+" "+user.getLastName());
						stripeEventObject.put("id", status.getChargeId());
						stripeEventObject.put("amount", new BigDecimal(paidAmount).multiply(DEFAULT_AMOUNT_MULTIPLIER).longValue());
						stripeEventObject.put("currency", ccy);
						stripeEventObject.put("description", (String) paramMap.get(PAY_DESC_FIELD));
						logger.error("simulated stripe event ==> " + stripeEvent.toString());
						PricingMicroserviceLocalServiceUtil.publishStripeEvent(requestData.getScopeGroupId(), "charge/succeed", stripeEvent.toString());					
					}
				} else {
					payStatus = PAY_FAILED_STATUS;
					payError = status.getErrorCode();
					paymentInfo.put(PAY_STATUS_FIELD, payStatus);
					paymentInfo.put(PAY_ERROR_FIELD, payError);
				}
			} else {
				logger.debug("Payment already done : " + existingChargeId);
				payStatus = ALREADY_FULLY_PAID_STATUS;
				payError = ALREADY_FULLY_PAID_STATUS;
				paymentInfo.put(PAY_STATUS_FIELD, payStatus);
				paymentInfo.put(PAY_ERROR_FIELD, payError);
			}
			break;

		case "refund":
			if (StringUtils.isEmpty(existingRefundId)) {
				PEProcessState state = ds.getProcessState();
				refundInfo = paymentInfo; // initially set payment info
				// store previous state that will be restored after successful refund
				// restoration will be done by PEStatusHandler
				PEPaymentUtil.storeRefundInfo(dataAdapter, state);
				
				Map<String, Object> paramMap = convertMap(requestData.getRequestParams());
				paramMap.put(PaymentProvider.CART_ID, refundInfo.getString(CART_ID));
				ChargeStatus status = SPPaymentLocalServiceUtil.refundPayment(paramMap);
				logger.debug("Refund Successful ? "+status.isSuccess());
				if (status.isSuccess()) {
					logger.debug("Refund Info: "+status.getChargeInfo());
					payStatus = REFUND_SUCCESS_STATUS;
					refundInfo.put(PAY_REFUND_ID, status.getChargeId());	
					refundInfo.put(PAY_STATUS_FIELD, payStatus);
					refundInfo.put(PAY_ERROR_FIELD, payError);
					refundInfo.put(PAY_REFUND_REASON_FIELD, requestData.getRequestParams().get(PAY_REFUND_REASON_FIELD)[0]);
					dataAdapter.store(PAY_REFUND_ID, status.getChargeId());
					audit(refundInfo.toString(), true);
					User user = (User)paramMap.get("payor");
					if (!SambaashUtil.isStripeWebhookOn()) {
						JSONObject stripeEvent = getSampleStripeEvent();
						JSONObject stripeEventObject = stripeEvent.getJSONObject("object");
						stripeEventObject.getJSONObject("metadata").put("cartId", refundInfo.getString(CART_ID));
						stripeEventObject.getJSONObject("metadata").put("payerName", user.getFirstName()+" "+user.getLastName());
						stripeEventObject.put("id", status.getChargeId());
						logger.error("simulated stripe event ==> " + stripeEvent.toString());
						PricingMicroserviceLocalServiceUtil.publishStripeEvent(requestData.getScopeGroupId(), "charge/refund", stripeEvent.toString());					
					}
				} else {
					payStatus = REFUND_FAILED_STATUS;
					payError = status.getErrorCode();
					refundInfo.put(PAY_ERROR_FIELD, payError);	
					refundInfo.put(PAY_STATUS_FIELD, payStatus);
					// on error, clear the saved state information
					PEPaymentUtil.clearRefundInfo(dataAdapter);
				}
			} else {
				// only full refund for now
				logger.debug("Full Refund already done : " + existingRefundId);
				payStatus = ALREADY_FULLY_REFUNDED_STATUS;
				payError = ALREADY_FULLY_REFUNDED_STATUS;
				refundInfo.put(PAY_STATUS_FIELD, payStatus);
				refundInfo.put(PAY_ERROR_FIELD, payError);
			}
			break;
		case "paymentCancel":
			logger.debug("payment cancel in progress.");
			payStatus = PAYMENT_CANCELLED;
			break;
			
		case "payOffline":
			logger.debug("offline payment in progress.");
			payStatus = PAY_OFFLINE;
			break;

		default:
			break;
		}

		if (StringUtils.isNotEmpty(payStatus)) {
			dataAdapter.store(PAY_STATUS_FIELD, payStatus);
			dataAdapter.store(PAY_ERROR_FIELD, payError);
			PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());			
		}
		
		output.setSuccessMsg("Payment was successful");
		return output;
	}

	private JSONObject getSampleStripeEvent() {
		JSONObject stripeEvent;
		try {
			InputStream is = this.getClass().getResourceAsStream("/stripeChargeSuccessEventSample.json");
			stripeEvent = JSONFactoryUtil.createJSONObject(IOUtils.toString(is));
		} catch (Exception e) {
			stripeEvent = JSONFactoryUtil.createJSONObject();
		}
		return stripeEvent;
	}
	
	private Map<String, Object> addMetadata(Map<String, Object> convertMap) {
		for (String metaKey : this.paymentNode.getDatamapKeys()) {
			convertMap.put(METADATA_PREFIX+metaKey, this.paymentNode.getDatamap(ds, metaKey));
		}
		return convertMap;
	}

	private Map<String, Object> convertMap(Map<String, String[]> origMap) {
		Map<String, Object> newMap = new HashMap<String, Object>(origMap.size());
		for(Map.Entry<String, String[]> entry : origMap.entrySet()) {
			newMap.put(entry.getKey(), entry.getValue()[0]);
		}
		User payor = ds.getRequestData().getUser();
		newMap.put("payor", payor);
		return addMetadata(newMap);
	}
	
//	public void audit(boolean isRefund) throws PEException{
//		audit(ds.getFormJspData(), isRefund);
//	}

	public void audit(String data, boolean isRefund) throws PEException {
		// Audit the form submission
		PEAuditHelper auditHelper = ds.getAuditHelper();
		if(ds.isSubmitRequest() || ds.isForceSubmit()){
			auditHelper.logPayment(String.valueOf(ds.getRequestData().getUserId()), paymentNode.getRuleSetId(), paymentNode.getNodeId(),data, isRefund ? PEAuditConstants.ACTION_REFUND : PEAuditConstants.ACTION_SUBMIT);
		}else{
			auditHelper.logPayment(String.valueOf(ds.getRequestData().getUserId()), paymentNode.getRuleSetId(), paymentNode.getNodeId(),data, PEAuditConstants.ACTION_SAVE);
		}
	}
	
	public boolean isCompleted(){
		try {
			PEProcessAudit audit = PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(ds.getProcessState().getSpPEProcessStateId(), paymentNode.getNodeId(), PEAuditConstants.ACTION_SUBMIT);
			return true;
		} catch (NoSuchPEProcessAuditException | SystemException e) {
			return false;
		}
	}
	
	public void preprocess(){
		
	}
	
	public void extraCallBackAfterSubmit(){
		
	}
	
	/**
	 * To check if underlying jsp data submission is to external system.
	 * For example, if your jsp has iframe containing link to some external system. In such cases, submit can not be audited and has to be handled 
	 * by underlying jsp handler.
	 * 
	 * 
	 * @return
	 */
	public boolean isExternalDataSubmission(){
		return false;
	}
	
	public void auditExternalDataSubmission() throws PEException{
		audit(StringPool.BLANK, false);
	}
		
	public void setForceSubmit(){
		
	}

	public boolean canProceedToNextStep() {
		return true;
	}
	
	public PEProcessAudit retrievePaymentAudit(){
		try {
			return PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(ds.getProcessState().getSpPEProcessStateId(), paymentNode.getNodeId(), PEAuditConstants.ACTION_SUBMIT);
		} catch (NoSuchPEProcessAuditException | SystemException e) {
			return null;
		}
	}
	
	public PEProcessAudit retrieveRefundAudit(){
		try {
			return PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(ds.getProcessState().getSpPEProcessStateId(), paymentNode.getNodeId(), PEAuditConstants.ACTION_REFUND);
		} catch (NoSuchPEProcessAuditException | SystemException e) {
			return null;
		}
	}
	
	public PEProcessAudit retrievePricingAudit(long pricingNodeId){
		try {
			return PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(ds.getProcessState().getSpPEProcessStateId(), pricingNodeId, PEAuditConstants.ACTION_SUBMIT);
		} catch (NoSuchPEProcessAuditException | SystemException e) {
			return null; // should never be null as pricing node should be over upon reaching payment node
		}
	}
	
	
}
