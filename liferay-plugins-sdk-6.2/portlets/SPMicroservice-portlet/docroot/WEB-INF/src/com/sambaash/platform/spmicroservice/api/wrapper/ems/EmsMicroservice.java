	package com.sambaash.platform.spmicroservice.api.wrapper.ems;

import java.util.Date;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.spmicroservice.api.BaseEmsMicroservice;
import com.sambaash.platform.srv.spservices.model.SPSiteSetup;
import com.sambaash.platform.srv.spservices.service.SPListTypeLocalServiceUtil;
import com.sambaash.platform.srv.spservices.service.SPSiteSetupLocalServiceUtil;
import com.sambaash.platform.util.DateUtils;

/*
 * Instead of creating separate micro service wrappers, use only this one from here on.
 * Root context is empty, so that we can invoke any service from EMS micro service.
 */
public class EmsMicroservice extends BaseEmsMicroservice {

	private static final String ADDRESS_LINE2 = "addressLine2";
	private static final String ADDRESS_LINE1 = "addressLine1";

	public EmsMicroservice(long scopeGroupId) {
		super(scopeGroupId);
	}

	public EmsMicroservice(String scopeGroupId) {
		super(scopeGroupId);
	}

	private static final Log LOGGER = LogFactoryUtil.getLog(EmsMicroservice.class);
			
	@Override
	protected Log logger() {
		return LOGGER;
	}

	@Override
	protected String getClientId() {
		return "EMS";
	}

	@Override
	protected String getRootContext() {
		return "";
	}

	public JSONArray getPEPriceSchemeLOV() {
		String url = constructGatewayUrl("/pricescheme/pe/schemesLOV");
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public JSONArray getPEPriceSubSchemeLOV(String priceSchemeCode) {
		String url = constructGatewayUrl(String.format("/pricescheme/pe/scheme/%s/subSchemeLOV",priceSchemeCode));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public JSONArray getPEPriceSchemeDetails(String priceSchemeCode) {
		String url = constructGatewayUrl(String.format("/pricescheme/pe/scheme/%s/details",priceSchemeCode));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public JSONObject createPEInvoice(long processStateId, long processAuditId, long applicantId, 
			Double amount, String currency, long productTypeId, long productSubTypeId,
			JSONArray feeDetails, String applicantName, String title, String description
	) {
		JSONObject model = JSONFactoryUtil.createJSONObject();
		JSONObject invoice = JSONFactoryUtil.createJSONObject();
		
		String producTypetName = StringPool.BLANK;
		String subProductTypeName = StringPool.BLANK;

		model.put("contentJson", invoice);
		
		try {	
			if (productSubTypeId > 0){
				SPSiteSetup spSiteSetup = SPSiteSetupLocalServiceUtil.findByProductIdAndSubProductId(productTypeId, productSubTypeId);
					producTypetName = spSiteSetup.getProductName();
					subProductTypeName = spSiteSetup.getSubProductName();
					LOGGER.info(String.format("producTypetName : %s : subProductTypeName %s ", producTypetName, subProductTypeName));
			}

			String todayStr = DateUtils.toString(new Date(), "dd/MM/yyyy");
			if(Validator.isNull(title)){
				title = "PE-"+processStateId;
			}
			
			if(Validator.isNull(description)){
				title = "PE-"+processStateId;
			}
			
			invoice.put("TransactionMasterCode", String.format("PE-%d-%d", processStateId,processAuditId));
			invoice.put("ProductType", productTypeId);
			invoice.put("ProductSubType", productSubTypeId);
			invoice.put("FunctionalComponent", "F");
			invoice.put("CategoryType", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.referencenumber.categorytype", getNumericScopeGroupId()).get("IN").getSpListTypeId());
			invoice.put("Type", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.accountingtable.clienttype", getNumericScopeGroupId()).get("Individual").getSpListTypeId());
			invoice.put("TxnDate", todayStr);
			invoice.put("Source", "PE-"+processStateId);
			invoice.put("ComponentRefNumber", "PE-"+processAuditId);		
			invoice.put("TxnType", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.accountingtable.transactiontype", getNumericScopeGroupId()).get("Invoice").getSpListTypeId());
			invoice.put("Title", title);
			invoice.put("Description", description);
			invoice.put("DueDate", todayStr);
			invoice.put("ApprovalStatus", "Approved");
			invoice.put("RequestType", "New Invoice");
			invoice.put("TransactionStatus", "Confirmed");
			invoice.put("CreditTerm", 0);
			invoice.put("Currency", currency);
			invoice.put("NameOfPayer", applicantId);
			invoice.put("Amount", amount);
			invoice.put("ReceiptTxnType", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.accountingtable.transactiontype", getNumericScopeGroupId()).get("Receipt").getSpListTypeId());
			invoice.put("RefundTxnType", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.accountingtable.transactiontype", getNumericScopeGroupId()).get("Refund").getSpListTypeId());
			invoice.put("ReceiptCategoryType", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.referencenumber.categorytype", getNumericScopeGroupId()).get("RE").getSpListTypeId());
			invoice.put("RefundCategoryType", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.referencenumber.categorytype", getNumericScopeGroupId()).get("RF").getSpListTypeId());
			invoice.put("PaymentMode", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.transaction.paymentmode", getNumericScopeGroupId()).get("DC").getSpListTypeId());
			invoice.put("SourceType", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.transaction.sourcetype", getNumericScopeGroupId()).get("CB").getSpListTypeId());
			invoice.put("CreditToBalance", false);
			// since applicantName is not used, re-used it for email address instead
			invoice.put("EmailAddress", applicantName);
			
			JSONArray transactionDetails = JSONFactoryUtil.createJSONArray();
			invoice.put("TransactionDetails", transactionDetails);
			for (int i=0; i<feeDetails.length(); i++) {
				JSONObject feeDtl = feeDetails.getJSONObject(i);
				if (i==0 && feeDtl.has(ADDRESS_LINE1)) {
					// address was set in first element
					invoice.put(ADDRESS_LINE1, feeDtl.getString(ADDRESS_LINE1));
					invoice.put(ADDRESS_LINE2, feeDtl.getString(ADDRESS_LINE2));
				}
				double origAmount = feeDtl.has("basePrice") ? feeDtl.getDouble("basePrice") : feeDtl.getDouble("amount");
				double discountAmt = feeDtl.getDouble("discountAmount");
				double taxAmount = feeDtl.getDouble("taxAmount");
				JSONObject txnDtl = JSONFactoryUtil.createJSONObject();
				transactionDetails.put(txnDtl);
				txnDtl.put("userId", applicantId);
				txnDtl.put("title", feeDtl.getString("priceSubSchemeCode"));
				txnDtl.put("description", feeDtl.getString("priceSubSchemeName"));
				txnDtl.put("amountType", feeDtl.getString("priceSubType"));
				txnDtl.put("currency", feeDtl.getString("currency"));
				txnDtl.put("unitPrice", origAmount);
				txnDtl.put("quantity", 1);
				txnDtl.put("amount", origAmount - discountAmt);
				txnDtl.put("baseCurrency", currency);
				txnDtl.put("amountAtBaseCurrency", origAmount - discountAmt);
				txnDtl.put("roundingOff", "0.0");
				txnDtl.put("tax", taxAmount);
				txnDtl.put("taxable", feeDtl.getBoolean("taxable")?"Yes":"No");
				txnDtl.put("taxAtBaseCurrency", taxAmount);
				txnDtl.put("taxCode", feeDtl.getString("taxCode"));
				boolean isWaived = feeDtl.has("isWaived") && feeDtl.getBoolean("isWaived");
				txnDtl.put("transactionStatus", isWaived ? "Waived" : "Confirmed");
			}
		} catch (Exception e) {
			LOGGER.error("Unable to construct invoicing parameter", e);
		}
		String url = constructGatewayUrl("/invoicing/new");
		return toJsonObject(execServiceApi(true, url, MediaType.APPLICATION_JSON, HttpMethod.POST, model.toString()));
	}
	
	public JSONObject getUserFees(long userId, String componentRef, boolean includeOutstanding, String consolidateSourceId, boolean fullInfo) {
		String url = constructGatewayUrl(String.format("/transactionmaster/pe/computeUserFees/%d/%s?includeOutstanding=%s&consolidateSourceId=%s&fullInfo=%s", userId, componentRef, includeOutstanding, consolidateSourceId, fullInfo));
		return toJsonObject(execServiceApi(true, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public JSONObject getTransactionFees(boolean confirmedOnly, String... transactionMasterCode) {
		String url = constructGatewayUrl(String.format("/transactionmaster/pe/computeTransactionFees?confirmedOnly=%s&transactionMasterCode=%s", confirmedOnly, StringUtils.join(transactionMasterCode,",")));
		return toJsonObject(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public void publishStripeEvent(String eventUri, String eventData) {
		String url = constructGatewayUrl(String.format("/stripe/webhook/%s", eventUri));
		execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.POST, eventData, true);
	}
	
	public JSONObject computeSchemeFees(String priceSchemeCode, String ... priceSubSchemeCode) {
		String url = constructGatewayUrl(String.format("/pricescheme/pe/compute/%s/%s", priceSchemeCode, StringUtils.join(priceSubSchemeCode,",")));
		return toJsonObject(execServiceApi(true, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public JSONObject computeCandidateSchemeFees(String candidateId, String priceSchemeCode, String ... priceSubSchemeCode) {
		String url = constructGatewayUrl(String.format("/pricescheme/pe/fees/candidate/%s/scheme/%s/sub/%s", candidateId, priceSchemeCode, StringUtils.join(priceSubSchemeCode,",")));
		return toJsonObject(execServiceApi(true, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public JSONObject retrieveTransactionStatus(String ... transactionMasterCode) {
		String url = constructGatewayUrl(String.format("/transactionmaster/pe/check/status/%s", StringUtils.join(transactionMasterCode,",")));
		return toJsonObject(execServiceApi(true, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public JSONArray getPostalAddress(String countryCode, String postalCode) {
		String url = constructGatewayUrl(String.format("location/%s/%s",countryCode,postalCode));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public JSONObject retrieveCandidateProgrammePath(String candidateId, String configJson) {
		String url = constructGatewayUrl(String.format("/programmepath/candidate/%s", candidateId));
		return toJsonObject(execServiceApi(true, url, MediaType.APPLICATION_JSON, HttpMethod.POST, configJson));
	}	

	public JSONObject retrievePEProgrammePriceSchemeByScheduleAndModule(String programmeCode, String schedModulesParamJson) {
		String url = constructGatewayUrl(String.format("/pricescheme/pe/programme/%s", programmeCode));
		return toJsonObject(execServiceApi(true, url, MediaType.APPLICATION_JSON, HttpMethod.POST, schedModulesParamJson));
	}	
	
	public JSONArray getCandidateSchedule(Long candidateId) {
		String url = constructGatewayUrl(String.format("/schedule/candidate/%d",candidateId));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public JSONArray getCandidateAllowedModules(Long candidateId, String scheduleCode) {
		String url = constructGatewayUrl(String.format("/enrolment/candidate/%d/schedule/%s/validModules",candidateId, scheduleCode));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public JSONArray getCandidateFailedModules(Long candidateId, String scheduleCode) {
		String url = constructGatewayUrl(String.format("/resultmaster/modules/schedule/%s/candidate/%d/failed",scheduleCode, candidateId));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public boolean hasResults(String programmeCode, Long candidateId) {
		String url = constructGatewayUrl(String.format("/resultmaster/programme/%s/candidate/%d/hasResults",programmeCode, candidateId));
		return toBoolean(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public boolean isPaidInvoice(String invoiceNumbers) {
		try {
			JSONObject jsonBody = JSONFactoryUtil.createJSONObject();
			jsonBody.put("storageIds", invoiceNumbers);
			jsonBody.put("receiptCategoryId", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.referencenumber.categorytype", getNumericScopeGroupId()).get("RE").getSpListTypeId());
			String url = constructGatewayUrl("/invoicing/invoice/receipt");
			return toBoolean(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.POST, jsonBody.toString()));			
		} catch (Exception e) {
			return false;
		}
	}

	public JSONObject updateContentJson(String modelName, String storageId, String patchJsonString) {
		String url = constructGatewayUrl(String.format("/%s/contentJson/update/%s", modelName.toLowerCase(), storageId));
		return toJsonObject(execServiceApi(true, url, MediaType.APPLICATION_JSON, HttpMethod.PUT, patchJsonString));
	}
	
	public JSONArray allowedProgrammeScheduleToEnrol(Long candidateId) {
		String url = constructGatewayUrl(String.format("/enrolment/candidate/%d/allowedProgrammeScheduleToEnrol",candidateId));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public boolean validateBatchSwitchEnrolmentIds(String enrolmentIds) {
		try {
			JSONObject jsonBody = JSONFactoryUtil.createJSONObject();
			jsonBody.put("enrolmentIds", enrolmentIds);
			jsonBody.put("receiptCategoryId", SPListTypeLocalServiceUtil.mapListTypeByItemValue("finance.referencenumber.categorytype", getNumericScopeGroupId()).get("RE").getSpListTypeId());
			String url = constructGatewayUrl("/enrolment/batch/switch/validate");
			return toBoolean(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.POST, jsonBody.toString()));			
		} catch (Exception e) {
			return false;
		}
	}
	
}
