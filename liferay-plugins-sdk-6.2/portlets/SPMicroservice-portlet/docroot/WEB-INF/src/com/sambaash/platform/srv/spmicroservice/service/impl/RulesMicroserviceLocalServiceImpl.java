/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.sambaash.platform.srv.spmicroservice.service.impl;

import java.util.Map;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONObject;
import com.sambaash.platform.spmicroservice.api.wrapper.RuleMicroservice;
import com.sambaash.platform.srv.spmicroservice.service.base.RulesMicroserviceLocalServiceBaseImpl;

/**
 * The implementation of the rules microservice local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spmicroservice.service.base.RulesMicroserviceLocalServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil
 */
public class RulesMicroserviceLocalServiceImpl
	extends RulesMicroserviceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil} to access the rules microservice local service.
	 */
	private RuleMicroservice ruleService = new RuleMicroservice();
	
	public JSONArray fetchRuleSetTypes(boolean fullInfo) {
		return ruleService.fetchRuleSetTypes(fullInfo);
	}
	
	public JSONArray fetchListOptionByName(boolean fullInfo, String[] name) {
		return ruleService.fetchListOptionByName(fullInfo, name);
	}

	public JSONArray getRuleSetListing(boolean fullInfo) {
		return ruleService.getRuleSetListing(fullInfo);
	}
	
	public JSONArray getPERuleSets(boolean includeRules, String ruleSetTypes) {
		return ruleService.getPERuleSets(includeRules, ruleSetTypes);
	}
	
	public JSONObject getRuleSet(Long ruleSetId) {
		return ruleService.getRuleSet(ruleSetId.toString());
	}
	
	public JSONObject deleteRuleSet(Long ruleSetId) {
		return ruleService.deleteRuleSet(ruleSetId.toString());
	}
	
	public JSONArray evaluateRuleSet(long ruleSetId, JSONObject dataMapToEvalTheRuleset) {
		return ruleService.evaluateRuleSet(ruleSetId, dataMapToEvalTheRuleset);
	}
	
	public JSONObject saveRuleSet(JSONObject ruleSetJson) {
		return ruleService.saveRuleSet(ruleSetJson);
	}
}