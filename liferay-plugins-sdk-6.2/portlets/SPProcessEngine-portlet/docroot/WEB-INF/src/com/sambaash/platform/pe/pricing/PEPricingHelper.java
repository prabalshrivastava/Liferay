package com.sambaash.platform.pe.pricing;

import org.apache.commons.lang3.StringUtils;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.PERequestData;
import com.sambaash.platform.pe.PESimpleOutput;
import com.sambaash.platform.pe.adapter.PEProcessStateDataAdapter;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.exception.PEException;
import com.sambaash.platform.pe.helpers.PEAuditHelper;
import com.sambaash.platform.pe.jaxb.PEPricing;
import com.sambaash.platform.srv.processbuilder.NoSuchPEProcessAuditException;
import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;

public class PEPricingHelper {
	private static final String API_RETURNED_ERROR = "error";

	private static Log logger = LogFactoryUtil.getLog(PEPricingHelper.class);
	
	protected final PEDataSource ds;
	protected final PEPricing pricingNode;
		
	public PEPricingHelper(PEDataSource ds,PEPricing pricingNode) {
		this.ds = ds;
		this.pricingNode = pricingNode;
	}
	
	public PESimpleOutput save() {
		PESimpleOutput output = new PESimpleOutput();
		PERequestData requestData = ds.getRequestData();
		JSONObject computedFeesForInvoicing; 

		try {
			PEAuditHelper auditHelper = ds.getAuditHelper();
			PEProcessAudit audit = auditHelper.create();
			computedFeesForInvoicing = JSONFactoryUtil.createJSONObject(requestData.getParameter("computedFeesForInvoicing"));
			JSONArray currentFees = computedFeesForInvoicing.getJSONObject("computedCurrentFees").getJSONArray("currentFees");
			addAddress(currentFees);
			
			long peStateId = ds.getProcessState().getSpPEProcessStateId();
			
			long subProductId = ds.getProcess().getSubProductTypeId();
			long productId = ds.getProcess().getProductTypeId();
			
			
			JSONObject txnMaster = PricingMicroserviceLocalServiceUtil.createPEInvoice(requestData.getScopeGroupId(), 
					peStateId, audit.getSpPEProcessAuditId(), 
					ds.getApplicant().getUserId(), computedFeesForInvoicing.getDouble("currentNetFees"), 
					computedFeesForInvoicing.getString("currency"), productId, subProductId, currentFees, 
					ds.getApplicant().getEmailAddress(), ds.getData("programmeCode"), ds.getData("programmeCode"));
			if (txnMaster.length() > 0) { // there is response entity, meaning invoice was processed
				if (txnMaster.has(API_RETURNED_ERROR)) {
					output.setError(new PEException("Error generating fee invoices : "+txnMaster.getString(API_RETURNED_ERROR)));
				} else {
					logger.info(String.format("PEPricingHelper saved -> %d, %s",peStateId, currentFees.toString()));
					audit.setData2(txnMaster.toString());
					PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
					dataAdapter.store("_lastPricingInvoice_", txnMaster.getString("transactionMasterCode"));
					dataAdapter.store("_lastPricingInvoiceTotalAmt_", txnMaster.getString("totalAmount"));
					dataAdapter.store("_lastPricingInvoiceExtRef_", txnMaster.getString("externalRefNumber"));
					auditHelper.logPricingInvoice(audit, pricingNode.getNodeId(), computedFeesForInvoicing.toString());					
				}
			} else {
				output.setError(new PEException("Error saving invoice entries."));
			}
		} catch (Exception e) {
			logger.error(e);
			output.setError(new PEException("Error generating fee invoices : "+e.getMessage()));
		}
		
		return output;
	}

	private void addAddress(JSONArray currentFees) {
		try {
			PEProcessStateDataAdapter dataAdapter = PEProcessStateDataAdapter.getProcessStateDataAdapter(ds.getProcessState());
	        String unit = dataAdapter.getDataFromProcessState("UnitNo", true);
	        if (StringUtils.isNotEmpty(unit)) {
	            unit = "Unit " + unit;
	        }
	        String candCountry = dataAdapter.getDataFromProcessState("CountryofStay");
	        if (StringUtils.isEmpty(candCountry)) {
	            candCountry = "Singapore";
	        }
	        String houseBlockNo = dataAdapter.getDataFromProcessState("HouseBlockNo");
	        String buildingName = dataAdapter.getDataFromProcessState("BuildingName");
	        String addressLine1 = String.format("%s%s%s", StringUtils.isNotEmpty(houseBlockNo) ? houseBlockNo + " " : "",
	        		StringUtils.isNotEmpty(buildingName) ? buildingName + " " : "",
					dataAdapter.getDataFromProcessState("StreetName"));
	        if (StringUtils.isNotEmpty(addressLine1)) {
	            String addressLine2 = String.format("%s%s(%s)", !StringUtils.isEmpty(unit) ? unit + " " : "",
	                    !StringUtils.isEmpty(candCountry) ? candCountry + " " : "",
	            		dataAdapter.getDataFromProcessState("PostalCode"));
	            currentFees.getJSONObject(0).put("addressLine1", addressLine1);
	            currentFees.getJSONObject(0).put("addressLine2", addressLine2);
	       }			
		} catch (Exception e) {
			logger.error(e);
		}
	}

	public boolean isCompleted(){
		try {
			PEProcessAudit audit = PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(ds.getProcessState().getSpPEProcessStateId(), pricingNode.getNodeId(), PEAuditConstants.ACTION_SUBMIT);
			return true;
		} catch (NoSuchPEProcessAuditException | SystemException e) {
			return false;
		}
	}
	
	public String getComponentRefNumber() {
		try {
			PEProcessAudit audit = PEProcessAuditLocalServiceUtil.findByProcessStateIdNodeIdAction(ds.getProcessState().getSpPEProcessStateId(), pricingNode.getNodeId(), PEAuditConstants.ACTION_SUBMIT);
			return String.format("PE-%d", audit.getSpPEProcessAuditId());
		} catch (Exception e) {
			return "PE-0";
		}
	}
	
	public String getConsolidateSourceId() {
		return String.format("PE-%d", ds.getProcessState().getSpPEProcessStateId());
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
		// TODO: temporarily not allow to proceed to next step
		return isCompleted();
	}

	public void audit(String data, boolean isRefund) throws PEException {
		// Audit the form submission
		PEAuditHelper auditHelper = ds.getAuditHelper();
	}
	
}
