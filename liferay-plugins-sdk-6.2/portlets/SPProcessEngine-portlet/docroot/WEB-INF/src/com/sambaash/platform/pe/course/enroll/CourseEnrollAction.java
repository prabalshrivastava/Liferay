package com.sambaash.platform.pe.course.enroll;

import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.sambaash.platform.pe.PEOutput;
import com.sambaash.platform.pe.ProcessEngine;
import com.sambaash.platform.pe.ProcessEngineImpl;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.helpers.PEOutputHelper;


public class CourseEnrollAction {

	public void serveResource(ResourceRequest request,ResourceResponse response) throws IOException{
		String task = ParamUtil.getString(request, "task");
		JSONObject resonseData = JSONFactoryUtil.createJSONObject();
		if("calculateFee".equalsIgnoreCase(task)){
			resonseData = calculateFee(request, response);
			response.getWriter().write(resonseData.toString());
		}else if("calculateInstmnt".equalsIgnoreCase(task)){
			resonseData = calculateInstmnt(request);
			response.getWriter().write(resonseData.toString());
		}else if("saveRegisterInterestData".equalsIgnoreCase(task)){
			executeEngine(request, response);
		}else if("saveFeeDetails".equalsIgnoreCase(task)){
			executeEngine(request, response);
		}
	}
	
	private void executeEngine(ResourceRequest request, ResourceResponse response) throws IOException{
		ProcessEngine processEngine = new ProcessEngineImpl();
		long processStateId = ParamUtil.getLong(request, PEConstants.PARAM_PROCESS_STATE_ID);
		long requestedStatusTypeId = ParamUtil.getLong(request, PEConstants.PARAM_STATUS_TYPE_ID);
		JSONObject resonseData = JSONFactoryUtil.createJSONObject();
		try {
			PEOutput output = processEngine.executeByProcessStateId(processStateId, requestedStatusTypeId, request,
					response);
			resonseData = PEOutputHelper.convertToJson(output);
			response.getWriter().write(resonseData.toString());
		} catch (SystemException e) {
			_log.error(e);
		}
	}
	
	private JSONObject calculateFee(PortletRequest request, PortletResponse response){
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		// calculated values must be in same order of requested data
		JSONArray calculated = JSONFactoryUtil.createJSONArray();
		//TODO: check json creation
		String feeDetails = ParamUtil.getString(request,"feeDetails");
		Map<String,BigDecimal>values = new LinkedHashMap<String, BigDecimal>();
		try {
			JSONArray feeDetailArray = JSONFactoryUtil.createJSONArray(feeDetails);
			int length  = feeDetailArray.length();
			JSONObject fee;
			for(int i = 0; i < length; i++){
				fee = feeDetailArray.getJSONObject(i);
				String formula = fee.getString("formula");
				String label = fee.getString("feeLabel");
				String amount = fee.getString("feeAmount");
				
				if(values.containsKey(label)){
					responseData.put("error", "Duplicate fee label found. Please provide unique fee label for each fee type");
					break;
				}
				BigDecimal calculatedAmount ;
				if(Validator.isNull(formula)){
					calculatedAmount = InFixExpressionEvaluator.getBigDecimalWithRounding(amount);
					values.put(label,calculatedAmount );
				}else{
					String error = validateFormula(formula);
					if(Validator.isNotNull(error)){
						responseData.put("error", error);
						break;
					}
					formula = replaceVariablesInFormula(formula, values);
					InFixExpressionEvaluator infix = new InFixExpressionEvaluator(formula);
					try {
						 calculatedAmount = infix.evaluate();
						 values.put(label, calculatedAmount);
					} catch (Exception e) {
						_log.error(e);
						responseData.put("error", "Error while calculating the fee.  Label: " + label);
						break;
					}
				}
				fee.put("calculatedAmount", calculatedAmount.toPlainString());
				calculated.put(fee);
			}
			
			responseData.put("calculatedAmounts",calculated);
			
		} catch (JSONException e) {
			_log.error(e);
			responseData.put("error", "Not able to calculate.");
			return responseData;
		}
		return responseData;
	}

	private String validateFormula(String formula) {
		// Validation
		// to check if there is anything like, (A10+ B + C100) . Here A is valid
		// but following value is not valid. similarly for C)
		for (int j = 0; j < formula.length(); j++) {
			char c = formula.charAt(j);
			if (Character.isUpperCase(c)) {
				if ((j + 1) != formula.length()) {
					char c1 = formula.charAt(j + 1);
					if (Character.isDigit(c1) || c1 == '.') {
						return "Formula is not valid";

					}
				}
				if (j > 0) {
					char c1 = formula.charAt(j - 1);
					if (Character.isDigit(c1) || c1 == '.') {
						return "Formula is not valid";
					}
				}
			}
		}
		return StringPool.BLANK;
	}
	private String replaceVariablesInFormula(String formula,Map<String,BigDecimal>values){
		//replace variables in formula
		Set<Entry<String, BigDecimal>>set = values.entrySet();
		for (Entry<String, BigDecimal> entry : set) {
			String str = entry.getKey();
			formula = formula.replaceAll(str, entry.getValue().toPlainString());
		}
		return formula;
	}
	/**
	 *  Method converts the given json array to json object where key is the formula and value is corresponding json object in given array.
	 *  
	 * @param feeDetailArray
	 * @return
	 */
	private JSONObject getFeeDetailsJsonObj(JSONArray feeDetailArray){
		JSONObject feeDetailsObj = JSONFactoryUtil.createJSONObject();
		int length = feeDetailArray.length();
		for(int i = 0 ; i < length; i++){
			JSONObject temp = feeDetailArray.getJSONObject(i);
			feeDetailsObj.put(temp.getString("feeLabel"), temp);
		}
		return feeDetailsObj;
	}
	
	private JSONObject calculateInstmnt(PortletRequest request){
		JSONObject responseData = JSONFactoryUtil.createJSONObject();
		int noOfInstmnts = ParamUtil.getInteger(request, "noOfInstmnts");
		BigDecimal total = new BigDecimal(ParamUtil.getString(request, "totalAmount"));
		
		BigDecimal instmnt = total.divide(new BigDecimal(noOfInstmnts),2,RoundingMode.CEILING);
		
		responseData.put("instmntAmount", instmnt.toPlainString());
		
		return responseData;
		
	}
	private static final Log _log = LogFactoryUtil.getLog(CourseEnrollAction.class);
}
