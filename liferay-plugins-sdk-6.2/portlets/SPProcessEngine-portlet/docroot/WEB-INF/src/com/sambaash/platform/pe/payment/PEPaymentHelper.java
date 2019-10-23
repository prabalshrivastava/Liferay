package com.sambaash.platform.pe.payment;

import static com.sambaash.platform.model.payment.PaymentProvider.ALREADY_FULLY_PAID_STATUS;
import static com.sambaash.platform.model.payment.PaymentProvider.ALREADY_FULLY_REFUNDED_STATUS;
import static com.sambaash.platform.model.payment.PaymentProvider.METADATA_PREFIX;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_CHARGE_ID;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_ERROR_FIELD;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_FAILED_STATUS;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_REFUND_ID;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_REFUND_IN_PROGRESS;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_REFUND_REASON_FIELD;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_STATUS_FIELD;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_TRAN_DATETIME_FIELD;
import static com.sambaash.platform.model.payment.PaymentProvider.PAY_SUCCESS_STATUS;
import static com.sambaash.platform.model.payment.PaymentProvider.REFUND_FAILED_STATUS;
import static com.sambaash.platform.model.payment.PaymentProvider.REFUND_SUCCESS_STATUS;
import static com.sambaash.platform.model.payment.PaymentProvider.CART_ID;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.liferay.portal.kernel.exception.SystemException;
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
import com.sambaash.platform.pe.jaxb.PEPayment;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.sppayment.service.SPPaymentLocalServiceUtil;
import com.sambaash.platform.util.DateUtils;

public class PEPaymentHelper {
	private static Log logger = LogFactoryUtil.getLog(PEPaymentHelper.class);
			
	public static final String PUBLIC_KEY_PARAM_SUFFIX = ".public.key";
	public static final String SECRET_KEY_PARAM_SUFFIX = ".secret.key";
	
	protected final PEDataSource ds;
	protected final PEPayment payPaymentNode;
		
	public PEPaymentHelper(PEDataSource ds,PEPayment payPaymentNode) {
		this.ds = ds;
		this.payPaymentNode = payPaymentNode;
	}
	
	public PESimpleOutput save() throws PEException{
		PESimpleOutput output = new PESimpleOutput();
		PERequestData requestData = ds.getRequestData();
		String payAction = requestData.getParameter("paymentAction");
		PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
		
		String existingChargeId = retrieveNodeData(dataAdapter, PAY_CHARGE_ID);
		String existingRefundId = retrieveNodeData(dataAdapter, PAY_REFUND_ID);

		if (StringUtils.isNotEmpty(existingRefundId)) {
			logger.debug("The payment "+existingChargeId+" had been refunded with reference code "+existingRefundId);
		}
			
		boolean isRefundAlreadyInProgress = "true".equalsIgnoreCase(dataAdapter.getDataFromProcessState(PAY_REFUND_IN_PROGRESS, true));
		if (isRefundAlreadyInProgress && StringUtils.isNotEmpty(payAction)) {
			throw new PEException("Refund is in progress. Action is invalid.");
		}
		
		switch (payAction) {
		case "pay":
			if (StringUtils.isEmpty(existingChargeId)) {
				ChargeStatus status = SPPaymentLocalServiceUtil.chargePayment(convertMap(requestData.getRequestParams()));
				logger.debug("Payment Successful ? "+status.isSuccess());
				if (status.isSuccess()) {
					storeNodeData(dataAdapter, PAY_CHARGE_ID, status.getChargeId());
					dataAdapter.store(PAY_CHARGE_ID, status.getChargeId());
					storeNodeData(dataAdapter, PAY_STATUS_FIELD, PAY_SUCCESS_STATUS);
					storeNodeData(dataAdapter, PAY_ERROR_FIELD, "");
					storeNodeData(dataAdapter, CART_ID, status.getCartId());
					storeNodeData(dataAdapter, PAY_TRAN_DATETIME_FIELD, DateUtils.toDateTimeString(new Date()));
					PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());
					audit(false);			
				} else {
					storeNodeData(dataAdapter, PAY_ERROR_FIELD, status.getErrorCode());	
					storeNodeData(dataAdapter, PAY_STATUS_FIELD, PAY_FAILED_STATUS);
				}
			} else {
				logger.debug("Payment already done : " + existingChargeId);
				storeNodeData(dataAdapter, PAY_STATUS_FIELD, ALREADY_FULLY_PAID_STATUS);
				storeNodeData(dataAdapter, PAY_ERROR_FIELD, ALREADY_FULLY_PAID_STATUS);
			}
			break;

		case "refund":
			if (StringUtils.isEmpty(existingRefundId)) {
				PEProcessState state = ds.getProcessState();
				// store previous state that will be restored after successful refund
				// restoration will be done by PEStatusHandler
				PEPaymentUtil.storeRefundInfo(dataAdapter, state);
				
				ChargeStatus status = SPPaymentLocalServiceUtil.refundPayment(convertMap(requestData.getRequestParams()));
				logger.debug("Refund Successful ? "+status.isSuccess());
				if (status.isSuccess()) {
					storeNodeData(dataAdapter, PAY_REFUND_ID, status.getChargeId());
					dataAdapter.store(PAY_REFUND_ID, status.getChargeId());
					storeNodeData(dataAdapter, PAY_STATUS_FIELD, REFUND_SUCCESS_STATUS);
					storeNodeData(dataAdapter, PAY_ERROR_FIELD, "");
					storeNodeData(dataAdapter, PAY_REFUND_REASON_FIELD, requestData.getRequestParams().get(PAY_REFUND_REASON_FIELD)[0]);
					PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());
					audit(true);
				} else {
					storeNodeData(dataAdapter, PAY_ERROR_FIELD, status.getErrorCode());	
					storeNodeData(dataAdapter, PAY_STATUS_FIELD, REFUND_FAILED_STATUS);
					// on error, clear the saved state information
					PEPaymentUtil.clearRefundInfo(dataAdapter);
				}
				audit(true);
			} else {
				// only full refund for now
				logger.debug("Full Refund already done : " + existingRefundId);
				storeNodeData(dataAdapter, PAY_STATUS_FIELD, ALREADY_FULLY_REFUNDED_STATUS);
				storeNodeData(dataAdapter, PAY_ERROR_FIELD, ALREADY_FULLY_REFUNDED_STATUS);
			}
			break;
		case "paymentCancel":
			logger.debug("payent cancel inprogress........");
			storeNodeData(dataAdapter, PAY_STATUS_FIELD, "payment_cancelled");
			storeNodeData(dataAdapter, PAY_ERROR_FIELD, "");
			PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());
			
			break;

		default:
			break;
		}
		output.setSuccessMsg("Payment was successful");
		return output;
	}

	private void storeNodeData(PEProcessStateDataAdapter dataAdapter, String dataKey, String dataValue) {
		storeNodeData(payPaymentNode.getNodeId(), dataAdapter, dataKey, dataValue);
	}

	public static final void storeNodeData(long nodeId, PEProcessStateDataAdapter dataAdapter, String dataKey, String dataValue) {
		String key = String.format("%s_%d", dataKey, nodeId);
		dataAdapter.store(key, dataValue);
	}
	
	private String retrieveNodeData(PEProcessStateDataAdapter dataAdapter, String dataKey) {
		return retrieveNodeData(payPaymentNode.getNodeId(), dataAdapter, dataKey);
	}

	public static final String retrieveNodeData(long nodeId, PEProcessStateDataAdapter dataAdapter, String dataKey) {
		String key = String.format("%s_%d", dataKey, nodeId);
		return dataAdapter.getDataFromProcessState(key);
	}
	
	private Map<String, Object> addMetadata(Map<String, Object> convertMap) {
		for (String metaKey : this.payPaymentNode.getDatamapKeys()) {
			convertMap.put(METADATA_PREFIX+metaKey, this.payPaymentNode.getDatamap(ds, metaKey));
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
	
	public void audit(boolean isRefund) throws PEException{
		audit(ds.getFormJspData(), isRefund);
	}

	public void audit(String data, boolean isRefund) throws PEException {
		// Audit the form submission
		PEAuditHelper auditHelper = ds.getAuditHelper();
		if(ds.isSubmitRequest() || ds.isForceSubmit()){
			auditHelper.logPayment(String.valueOf(ds.getRequestData().getUserId()), payPaymentNode.getRuleSetId(), payPaymentNode.getNodeId(),data, isRefund ? PEAuditConstants.ACTION_REFUND : PEAuditConstants.ACTION_SUBMIT);
		}else{
			auditHelper.logPayment(String.valueOf(ds.getRequestData().getUserId()), payPaymentNode.getRuleSetId(), payPaymentNode.getNodeId(),data, PEAuditConstants.ACTION_SAVE);
		}
	}
	
	public boolean isCompleted(){
		try {
			PEProcessAudit audit = PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(ds.getProcessState().getSpPEProcessStateId(), payPaymentNode.getNodeId(), PEAuditConstants.ACTION_SUBMIT);
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
	
	
}
