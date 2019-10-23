package com.sambaash.platform.pe.course.enroll;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ClassNameLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.sambaash.platform.model.payment.PaymentProvider;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PEError;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.actions.PEPaymentConfirmationInitialization;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEProcessStateHelper;
import com.sambaash.platform.pe.jaxb.PEJSP;
import com.sambaash.platform.pe.jsp.PEJSPHelper;
import com.sambaash.platform.pe.payment.PEPaymentHelper;
import com.sambaash.platform.srv.processbuilder.model.PEProcessState;
import com.sambaash.platform.srv.spshopping.service.SPShoppingLocalServiceUtil;

public class ProductsWithInventoryHelper extends PEJSPHelper {
	private static final String MODE_OF_PAYMENT = "modeOfPayment";
	public static Log logger = LogFactoryUtil.getLog(ProductsWithInventoryHelper.class);
			
	public ProductsWithInventoryHelper(PEDataSource ds, PEJSP jspNode) {
		super(ds, jspNode);
	}

	public static ProductsWithInventoryHelper getInstance(PEDataSource dataSource,PEJSP jspNode){
		return new ProductsWithInventoryHelper(dataSource, jspNode);
	}
	
	public PESimpleOutput save() throws PEException{
		PESimpleOutput output = new PESimpleOutput();
		PERequestData requestData = ds.getRequestData();
		PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
		
		String actionType = requestData.getParameter("action");
		boolean saveOk = true;
		switch (actionType) {
		case "participants":
			saveParticipantDetails(dataAdapter, requestData);			
			break;

		case "paymentMode":
			savePaymentMode(dataAdapter, requestData);			
			break;

		case "paymentConfirmation":
			savePaymentConfirmation(output, dataAdapter, requestData);			
			break;

		default:
			saveOk = false;
		}
		
		if (saveOk) {
			//Audit the save/submit
			audit();
			// Success message
			output.setSuccessMsg("Details saved successfully");
		} else {
			output.setError(new PEError("Error Handling action: " + actionType));	
		}
		
		return output;
	}

	private void savePaymentConfirmation(PESimpleOutput output, PEProcessStateDataAdapter dataAdapter,
			PERequestData requestData) {
		
		String confirmStatus = requestData.getParameter("confirmStatus");
		String validateInventory = requestData.getParameter("validateInventory");
		long paymentNodeId = Long.parseLong(dataAdapter.getDataFromProcessState(PEPaymentConfirmationInitialization.CONFIRM_PAYMENT_NODE_ID));	
		long offlineCartId = createOfflineEntryAsNeeded(paymentNodeId);

		long cartId = (offlineCartId>0) ? offlineCartId : Long.parseLong(PEPaymentHelper.retrieveNodeData(paymentNodeId, dataAdapter, PaymentProvider.CART_ID));
		boolean saveStateData = true;
		if ("Approved".equalsIgnoreCase(confirmStatus)) {
			boolean doValidation = "true".equalsIgnoreCase(validateInventory);
			boolean valid = !doValidation
					|| SPShoppingLocalServiceUtil.hasEnoughInventory(ds.getProcessState().getEntityClassId()
					, ds.getProcessState().getEntityId()
					, getPaymentQuantity(dataAdapter));
			if (valid) {
				int confirmedQty = Integer.parseInt(PEPaymentHelper.retrieveNodeData(paymentNodeId, dataAdapter, PaymentProvider.PAY_QUANTITY_FIELD));
				SPShoppingLocalServiceUtil.confirmPayment(cartId, confirmedQty);
			} else if (doValidation) {
				output.addValidationMsg("Available seats is not sufficient for this update");
				saveStateData = false;
			}
		} else {
			SPShoppingLocalServiceUtil.rejectPayment(cartId);
		}
		
		if (saveStateData) {
			String remarks = requestData.getParameter("remarks");
			dataAdapter.store("paymentConfirmationRemarks", remarks);
			dataAdapter.store("paymentConfirmationStatus", confirmStatus);
			PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());								
		}
		
	}
	
	private long createOfflineEntryAsNeeded(long paymentNodeId) {
		long cartId = 0;
		try {
			PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
			String modeOfPayment = dataAdapter.getDataFromProcessState(MODE_OF_PAYMENT);
			String cartIdStr = PEPaymentHelper.retrieveNodeData(paymentNodeId, dataAdapter, PaymentProvider.CART_ID);
			if ("Offline".equalsIgnoreCase(modeOfPayment) && StringUtils.isEmpty(cartIdStr)) {
				PEProcessState state = ds.getProcessState();
				User payor = UserLocalServiceUtil.fetchUser(state.getUserIdProcess());
				Map<String, String> m = getPayAmount(paymentNodeId, dataAdapter);
				cartId = SPShoppingLocalServiceUtil.createPaymentCart(
						payor.getCompanyId(), 
						payor.getGroupId(), 
						payor.getUserId(), 
						payor.getFullName(),
						ClassNameLocalServiceUtil.getClassName(state.getEntityClassId()).getClassName(), 
						state.getEntityId(),
						new BigDecimal(m.get(PaymentProvider.PAY_AMOUNT_FIELD)),
						m.get(PaymentProvider.PAY_CURRENCY_FIELD)
				);
				PEPaymentHelper.storeNodeData(paymentNodeId, dataAdapter, PaymentProvider.CART_ID, String.valueOf(cartId));
				PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());
			}
		} catch (Exception e) {
			logger.error("Unable to create offline payment entry.",e);
		}
		return cartId;
	}

	private int getPaymentQuantity(PEProcessStateDataAdapter dataAdapter) {
		int qty = 1;
		try {
			//String payQtyStr = PEPaymentHelper.retrieveNodeData(jspNode.getNodeId(), dataAdapter, PaymentProvider.PAY_QUANTITY_FIELD);
			String payQtyStr = dataAdapter.getDataFromProcessState(PaymentProvider.PAY_QUANTITY_FIELD);
			qty = Integer.parseInt(payQtyStr);
		} catch (Exception e) {
			// default to 1
		}
		return qty;
	}
	
	private Map<String, String> getPayAmount(long paymentNodeId, PEProcessStateDataAdapter dataAdapter) {
		Map<String, String> retMap = new HashMap<String, String>();
		String payAmount = "0";
		String payCcy = "";
		try {
			JSONArray feeDtlArray = CourseEnrollFeeHelper.getCourseFeeDetails(ds);
			JSONObject otherInfo = CourseEnrollFeeHelper.getOtherCourseFeeInfo(ds);
			payCcy = otherInfo.getString("ccy");
			String payAmountType = dataAdapter.getDataFromProcessState(PEPaymentConfirmationInitialization.PAY_OFFLINE_AMT_FEE_TYPE);

			for (int i=0; i < feeDtlArray.length(); i++) {
				JSONObject feeDtl = feeDtlArray.getJSONObject(i);
				if (feeDtl.getString("feeType").equals(payAmountType)) {
					payAmount = feeDtl.getString("feeAmount");
					break;
				}
			}			
		} catch (Exception e) {
			logger.error(e);
		}
		retMap.put(PaymentProvider.PAY_CURRENCY_FIELD, payCcy);
		String payQtyStr = PEPaymentHelper.retrieveNodeData(paymentNodeId, dataAdapter, PaymentProvider.PAY_QUANTITY_FIELD);
		payQtyStr = StringUtils.isEmpty(payQtyStr) ? "1" : payQtyStr;
		
		BigDecimal amt = new BigDecimal(payAmount);
		BigDecimal qty = new BigDecimal(payQtyStr);
		payAmount = amt.multiply(qty).toString();
		
		retMap.put(PaymentProvider.PAY_AMOUNT_FIELD, payAmount);
		return retMap;
	}

	private void saveParticipantDetails(PEProcessStateDataAdapter dataAdapter,
			PERequestData requestData) {
		int numberOfParticipants = 0;
		try {
			numberOfParticipants = Integer.parseInt(requestData.getParameter("numberOfParticipants"));
		} catch (Exception e) {
			// defaults to 0
		}
		dataAdapter.store("numberOfParticipants", String.valueOf(numberOfParticipants));
		
		
		JSONArray participantsJsonArr = JSONFactoryUtil.createJSONArray();
		for (int i=1; i<numberOfParticipants+1; i++) {
			try {
				JSONObject participant = JSONFactoryUtil.createJSONObject();
				participant.put("firstName", getParticipantData(requestData, "firstName", i));
				participant.put("lastName", getParticipantData(requestData, "lastName", i));
				participant.put("email", getParticipantData(requestData, "email", i));
				participant.put("mobile", getParticipantData(requestData, "mobileNumber", i));
				participant.put("designation", getParticipantData(requestData, "designation", i));
				participantsJsonArr.put(participant);
			} catch (Exception e) {
				logger.error(e);
			}
		}
		dataAdapter.store("participantDetails", participantsJsonArr.toString());
		PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());
	}
	
	private String getParticipantData(PERequestData requestData, String key, int index) {
		try {
			return requestData.getParameter(key+"_"+index);			
		} catch (Exception e) {
			return "";
		}
	}

	private void savePaymentMode(PEProcessStateDataAdapter dataAdapter,
			PERequestData requestData) {
		String modeOfPayment = requestData.getParameter("mode_of_payment");
		dataAdapter.store(MODE_OF_PAYMENT, modeOfPayment);
		PEProcessStateHelper.updateProcessStateSafe(ds.getProcessState(), ds.getRequestData());
	}
	
}
