package com.sambaash.platform.pe.rule;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.sambaash.platform.constant.FormConstants;
import com.sambaash.platform.pe.PEDataSource;
import com.sambaash.platform.pe.constants.PEAuditConstants;
import com.sambaash.platform.pe.constants.PEConstants;
import com.sambaash.platform.pe.helpers.PEEntityHelper;
import com.sambaash.platform.srv.processbuilder.model.PERule;
import com.sambaash.platform.srv.processbuilder.model.PERuleSet;
import com.sambaash.platform.srv.processbuilder.service.PERuleLocalServiceUtil;
import com.sambaash.platform.srv.processbuilder.service.PERuleSetLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;

public class PERuleEngineImpl implements PERuleEngine {
	private long rulesetId;
	private int version = 1;

	private PEDataSource ds;
	private PERuleSet ruleset;
	private JSONObject rulesetV2;  // v2 ruleset

	private static Log _log = LogFactoryUtil.getLog(PERuleEngineImpl.class);
	
	public PERuleEngineImpl(long rulesetId, PEDataSource ds) throws PortalException, SystemException {
		this(rulesetId, ds, 1);
	}

	public PERuleEngineImpl(long rulesetId, PEDataSource ds, int version) throws PortalException, SystemException {
		this.rulesetId = rulesetId;
		this.ds = ds;
		if (version==2) {
			this.rulesetV2 = RulesMicroserviceLocalServiceUtil.getRuleSet(rulesetId);			
		} else {
			this.ruleset = PERuleSetLocalServiceUtil.getPERuleSet(rulesetId);			
		}
		this.version = version;
	}
	
	public boolean evaluateCondition(JSONObject conditon) {
		boolean result = false;
		boolean caseSensitive = GetterUtil.getBoolean(conditon.getString("caseSensitive"));
		String type = conditon.getString("type");
		String fieldName = conditon.getString("field");
		String rhv = conditon.getString("value");
		String operator = conditon.getString("operator");
		String componentType = conditon.getString("componentType");
		String entityType = conditon.getString("EntityType");

		String lhv = getData(componentType,entityType,fieldName);
		
		// returned value can be json array or normal string value
		// If the field in form is select dropdown then value is json array
		// if the field inf form is text field then value is just normal string
		JSONArray array = null;
		try {
			   array = JSONFactoryUtil.createJSONArray(lhv);
		} catch (JSONException e) {
//			_log.error("Error while creating json array from " + lhv + ". Looks it's simple string");
		}
		
		if(array != null){
			// multivalue type. so lhv stored in array of objects
			 for(int i = 0; i < array.length(); i++){
				   JSONObject obj = array.getJSONObject(i);
				   String value = obj.getString(FormConstants.KEY_VALUE);
				   result = evaluate(caseSensitive, type, value, operator, rhv);
				   if(result){
					   return result;
				   }
			   }
		}else{
			result = evaluate(caseSensitive, type, lhv, operator, rhv);
		}
		
		return result;
	}

	private boolean evaluate(boolean caseSensitive,  String type,
			String lhv, String operator, String rhv) {
		boolean result = false;
		if (PEConstants.TYPE_STRING.equalsIgnoreCase(type)) {
			result = evaluateConditionStringType(lhv, rhv, operator, caseSensitive);
		}else if (PEConstants.TYPE_NUMBER.equalsIgnoreCase(type)) {
			result = evaluateConditionNumberType(lhv, rhv, operator);
		}else if (PEConstants.TYPE_DATE.equalsIgnoreCase(type)) {
			//TODO: implementation
		}else if (PEConstants.TYPE_BOOLEAN.equalsIgnoreCase(type)) {
			boolean blhv = GetterUtil.getBoolean(lhv);
			boolean brhv = GetterUtil.getBoolean(rhv);
			result = evaluateBooleanType(blhv, brhv, operator);
		}
		return result;
	}

	@Override
	public boolean evaluateRule(PERule rule) {
		boolean result = false;
		try {
			if (PEConstants.RULE_SIMPLE.equalsIgnoreCase(rule.getType())) {
				return evaluateSimpleRule(rule);
			}else if (PEConstants.RULE_COMPLEX.equalsIgnoreCase(rule.getType())) {
				//TODO: implementation pending
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return result;
	}

	/**
	 * Evaluating simple rule
	 *
	 * Rule contains condition sets.
	 * Operator between condition sets is OR ( || ). So if one condition set is true, rule said to satisfied and processing further condition set can be stopped.
	 *
	 * Condition set contains one or more conditions.
	 * Operator between conditions is AND ( && ). So to condition set to pass, all conditions in condition set must be evaluated to true.
	 *
	 * Simple Rule Format:  Stored in json
	 *
	 * 	  [ [{},{},{}], [{}] , [{},{}] ]
	 *
	 *    In above above example: rule contains three condition sets,
	 *    First condition set contains  three conditions,
	 *    second condition set contains one condition
	 *    third condition set contains two conditions
	 *
	 *    Format of condition
	 *    {
	 *     	type : string,
	 * 	  	field : qualification,
	 *    	value : graduation,
	 *    	operator : equals
	 *    }
	 *
	 * @param rule
	 * @return
	 */
	private boolean evaluateSimpleRule(PERule rule) {
		boolean result = false;
		try {
			if (Validator.isNotNull(rule.getDefinition())) {
				JSONArray rulej = JSONFactoryUtil.createJSONArray(rule.getDefinition());

				for (int i = 0; i < rulej.length(); i++) {
					JSONArray conditions = rulej.getJSONArray(i);

					if ( i == 0) {
						result = evaulateConditions(conditions);
					}else {
						result = result || evaulateConditions(conditions);
					}

					if (result) {
						break;
					}
				}
			}
		} catch (Exception e) {
			_log.error(e);
		}

		return result;
	}

	@Override
	public long evaluateRuleset() throws PortalException, SystemException {
		return (version == 1) ? evaluateRulesetV1() : evaluateRulesetV2();
	}
	
	private JSONObject v2EvalParams() throws Exception {
		JSONObject param = JSONFactoryUtil.createJSONObject();
		param.put("FORM_DATA", ds.getFormDataAdapter().fetchFormData(this.rulesetV2.getLong("componentId")));
		param.put("STATE_DATA", JSONFactoryUtil.createJSONObject(ds.getProcessState().getData()));
		param.put("USER_DATA", retrieveUserData());
		param.put("ENTITY_DATA", retrieveEntityData());
		return param;
	}

	private JSONObject retrieveEntityData() {
		JSONObject entityData = JSONFactoryUtil.createJSONObject();
		try {
			entityData.put("entityType", ds.getProcessState().getEntityClassId());
			entityData.put("entityId", ds.getProcessState().getEntityId());
		} catch (Exception e) {
			_log.error(e);
		}
		return entityData;
	}

	private JSONObject retrieveUserData() {
		JSONObject userData = JSONFactoryUtil.createJSONObject();
		try {
			userData.put("loggedInUserId", ds.getLoggedInUserId());
			JSONArray luRoles = JSONFactoryUtil.createJSONArray();
			for(Long rid : ds.getLoggedInUser().getRoleIds()) {
				luRoles.put(rid);
			}
			userData.put("loggedInUserRoles", luRoles);
			userData.put("applicantUserId", ds.getApplicant().getUserId());
			
			JSONArray applicantRoles = JSONFactoryUtil.createJSONArray();
			for(Long rid : ds.getApplicant().getRoleIds()) {
				applicantRoles.put(rid);
			}
			userData.put("applicantUserRoles", applicantRoles);
		} catch (Exception e) {
			_log.error("Unable to retrieve user info from PE datasource : "+e.getMessage());
		}
		return userData;
	}

	private long evaluateRulesetV2() {
		long satisfiedRuleId = PEConstants.RULE_ID_DEFAULT;
		try {
			JSONArray arr = RulesMicroserviceLocalServiceUtil.evaluateRuleSet(rulesetId, v2EvalParams());
			if (arr.length()>0) {
				satisfiedRuleId = arr.getJSONObject(0).getLong("id");
			}
		} catch (Exception e) {
			_log.info("Error evaluating ruleset version 2 with id: "+rulesetId, e);
		}
		return satisfiedRuleId;
	}

	private long evaluateRulesetV1() throws SystemException {
		List<PERule> rules = PERuleLocalServiceUtil.findByRuleSetId(rulesetId);

		for (PERule rule : rules) {
			boolean success = evaluateRule(rule);

			if (success) {
				return rule.getSpPERuleId();
			}
		}

		return PEConstants.RULE_ID_DEFAULT;
	}

	private String getData(String componentType,String entityType,String fieldName) {
		String lhv = StringPool.BLANK;

		if (PEConstants.FIELD_SIGNED_IN.equalsIgnoreCase(fieldName)) {
			return String.valueOf(ds.isSignedInUser());
		}else if (PEConstants.FIELD_FIRST_LOGIN.equalsIgnoreCase(fieldName)) {
			User applicant = ds.getApplicant();
			return String.valueOf(Validator.isNull(applicant.getLastLoginDate()));
		}
		
		if(PEConstants.RULE_COMPONENT_TYPE_ENTITY.equalsIgnoreCase(componentType)){
			lhv = PEEntityHelper.getPEEntityFieldValue(GetterUtil.getLong(entityType), ds.getProcessState().getEntityId(), fieldName);
		}else if (PEAuditConstants.TYPE_FORM.equalsIgnoreCase(ruleset.getComponentType())) {
			lhv = ds.getFormDataAdapter().getDataFromForm(ruleset.getComponentId(), fieldName);
		}else if (PEAuditConstants.TYPE_PROCESS.equalsIgnoreCase(ruleset.getComponentType())) {
			lhv = ds.getDataFromProcessState(fieldName);
		} else {	// else, treat them all as comparing from state data
			lhv = ds.getDataFromProcessState(fieldName);
		}

		return lhv;
	}

	/**
	 * Evaluating conditions in simple rule
	 * Default operator between conditions is AND (&&)
	 *
	 *
	 * @param conditions
	 * @return
	 */
	public boolean evaulateConditions(JSONArray conditions) {
		boolean result = false;

		if (Validator.isNotNull(conditions)) {

			for (int i = 0; i < conditions.length(); i++) {
				JSONObject conditon = conditions.getJSONObject(i);
				if(i == 0){ // first condition
					result = evaluateCondition(conditon);
				}else{
					result = result && evaluateCondition(conditon);
				}

				if (!result) {
					break;
				}
			}
		}

		return result;
	}

	
	private boolean evaluateConditionStringType(String lhv, String rhv, String operator, boolean caseSensitive) {
		boolean result = false;
		rhv = GetterUtil.getString(rhv);
		lhv = GetterUtil.getString(lhv);

		if (PEConstants.OPERATION_EQUALS.equalsIgnoreCase(operator)) {
			if (caseSensitive) {
				result = lhv.equals(rhv);
			}else {
				result = lhv.equalsIgnoreCase(rhv);
			}
		}else if (PEConstants.OPERATION_NOT_EQUALS.equalsIgnoreCase(operator)) {
			if (caseSensitive) {
				result = !lhv.equals(rhv);
			}else {
				result = !lhv.equalsIgnoreCase(rhv);
			}
		}else if (PEConstants.OPERATION_IN.equalsIgnoreCase(operator)){
			String vals[] = rhv.split(StringPool.COMMA);
			for (String val : vals) {
				if(Validator.isNull(val)){
					continue;
				}
				if (caseSensitive) {
					result = lhv.equals(val);
				}else {
					result = lhv.equalsIgnoreCase(val);
				}
				if(result){
					break;
				}
			}
		}else if (PEConstants.OPERATION_NOT_IN.equalsIgnoreCase(operator)){
			result = false;
			String vals[] = rhv.split(StringPool.COMMA);
			for (String val : vals) {
				if(Validator.isNull(val)){
					continue;
				}
				if (caseSensitive) {
					result = lhv.equals(val);
				}else {
					result = lhv.equalsIgnoreCase(val);
				}
				if(result){
					break;
				}
			}
			result = !result;
		}else if (PEConstants.OPERATION_IS_EMPTY.equalsIgnoreCase(operator)){
			result = Validator.isNull(lhv);
		}else if (PEConstants.OPERATION_IS_NOT_EMPTY.equalsIgnoreCase(operator)){
			result = Validator.isNotNull(lhv);
		}else if (PEConstants.OPERATION_CONTAINS.equalsIgnoreCase(operator)) {
			if (caseSensitive) {
				result = lhv.contains(rhv);
			}else {
				result = lhv.toLowerCase().contains(rhv.toLowerCase());
			}
		}else if (PEConstants.OPERATION_NOT_CONTAINS.equalsIgnoreCase(operator)) {
			if (caseSensitive) {
				result = !lhv.contains(rhv);
			}else {
				result = !lhv.toLowerCase().contains(rhv.toLowerCase());
			}
		}else if (PEConstants.OPERATION_STARTS_WITH.equalsIgnoreCase(operator)) {
			if (caseSensitive) {
				result = lhv.startsWith(rhv);
			}else {
				result = lhv.toLowerCase().startsWith(rhv.toLowerCase());
			}
		}

		return result;
	}

	// this method is introduced to accomodate IN operator
	private boolean evaluateConditionNumberType(String lhv, String rhv, String operator) {
		boolean result = false;
		Double dlhv = GetterUtil.getDouble(lhv);
		if(PEConstants.OPERATION_IN.equalsIgnoreCase(operator)){
			String vals[] = GetterUtil.getString(rhv).split(StringPool.COMMA);
			for (String val : vals) {
				Double temp = GetterUtil.getDouble(val);
				if( dlhv.equals(temp)){
				  result = true;
				  break;
				}
			}
		}else if(PEConstants.OPERATION_NOT_IN.equalsIgnoreCase(operator)){
			result = false;
			String vals[] = GetterUtil.getString(rhv).split(StringPool.COMMA);
			for (String val : vals) {
				Double temp = GetterUtil.getDouble(val);
				if( dlhv.equals(temp)){
				  result = true;
				  break;
				}
			}
			return !result;
		}else{
			double drhv = GetterUtil.getDouble(rhv);
			result = evaluateConditionNumberType(dlhv, drhv, operator);
		}
		
		return result;
	}
	private boolean evaluateConditionNumberType(double lhv, double rhv, String operator) {
		boolean result = false;
		Double lhvO = Double.valueOf(lhv);
		Double rhvO = Double.valueOf(rhv);

		if (PEConstants.OPERATION_EQUALS.equalsIgnoreCase(operator)) {
			result = lhvO.equals(rhvO);
		}else if (PEConstants.OPERATION_NOT_EQUALS.equalsIgnoreCase(operator)) {
			result = !lhvO.equals(rhvO);
		}else if (PEConstants.OPERATION_GREATER_THAN.equalsIgnoreCase(operator)) {
			result = lhvO > rhvO;
		}else if (PEConstants.OPERATION_LESS_THAN.equalsIgnoreCase(operator)) {
			result = lhvO < rhvO;
		}else if (PEConstants.OPERATION_GREATER_THAN_OR_EQUAL.equalsIgnoreCase(operator)) {
			result = lhvO >= rhvO;
		}else if (PEConstants.OPERATION_LESS_THAN_OR_EQUAL.equalsIgnoreCase(operator)) {
			result = lhvO <= rhvO;
		}

		return result;
	}

	private boolean evaluateBooleanType(boolean lhv, boolean rhv, String operator) {
		boolean result = false;

		if (PEConstants.OPERATION_EQUALS.equalsIgnoreCase(operator)) {
			result = ( lhv == rhv);
		}else if (PEConstants.OPERATION_NOT_EQUALS.equalsIgnoreCase(operator)) {
			result = ( lhv != rhv);
		}

		return result;
	}
	
	public int getVersion() {
		return version;
	}
}