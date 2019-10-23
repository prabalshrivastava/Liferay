package com.sambaash.platform.spmicroservice.api.wrapper;

import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.sambaash.platform.spmicroservice.api.BaseSPMicroservice;
import com.sambaash.platform.spmicroservice.api.MicroserviceConstants;

public class RuleMicroservice extends BaseSPMicroservice {
	private static final Log LOGGER = LogFactoryUtil.getLog(RuleMicroservice.class);
				
	@Override
	protected Log logger() {
		return LOGGER;
	}
	
	@Override
	protected String clientIdKey() {
		return MicroserviceConstants.RULE_SERVICE_CLIENT_ID;
	}

	@Override
	protected String clientSecretKey() {
		return MicroserviceConstants.RULE_SERVICE_CLIENT_SECRET;
	}

	@Override
	protected String rootContextKey() {
		return MicroserviceConstants.RULE_SERVICE_ROOT_CONTEXT;
	}

	public JSONArray fetchRuleSetTypes(boolean fullInfo) {
		String url = constructGatewayUrl(String.format("/RuleSetTypes?fullInfo=%s", fullInfo));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}
	
	public JSONArray fetchListOptionByName(boolean fullInfo, String ... name) {
		String apiUrl = String.format("/ListOptionByName?fullInfo=%s", fullInfo);
		if (name.length > 0) {
			apiUrl += String.format("&name=%s", StringUtils.join(name,","));
		}
		String url = constructGatewayUrl(apiUrl);
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	
	public JSONArray getPERuleSets(boolean includeRules, String ruleSetTypes) {
		String apiUrl = String.format("/PERuleSets?includeRules=%s&ruleSetTypes=%s", includeRules, ruleSetTypes);
		String url = constructGatewayUrl(apiUrl);
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public JSONArray getRuleSetListing(boolean fullInfo) {
		String apiUrl = String.format("/RuleSets?fullInfo=%s", fullInfo);
		String url = constructGatewayUrl(apiUrl);
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public JSONObject getRuleSet(String ruleSetId) {
		String url = constructGatewayUrl("/RuleSet/"+ruleSetId);
		return toJsonObject(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.GET, null));
	}

	public JSONObject deleteRuleSet(String ruleSetId) {
		String url = constructGatewayUrl("/RuleSet/"+ruleSetId);
		return toJsonObject(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.DELETE, null));
	}
	
	public JSONArray evaluateRuleSet(long ruleSetId, JSONObject dataMapToEvalTheRuleset) {
		String url = constructGatewayUrl(String.format("/RuleSet/%d/evaluate", ruleSetId));
		return toJsonArray(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.POST, dataMapToEvalTheRuleset.toString()));
	}

	public JSONObject saveRuleSet(JSONObject ruleSetJson) {
		String url = constructGatewayUrl("/RuleSet");
		return toJsonObject(execServiceApi(false, url, MediaType.APPLICATION_JSON, HttpMethod.POST, ruleSetJson.toString(), true));
	}

	
}
