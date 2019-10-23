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

import java.util.List;

import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portlet.asset.model.AssetCategory;
import com.sambaash.platform.srv.spmicroservice.service.CandidateMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.EnrolmentMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.FormsMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.PricingMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.RulesMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.SystemSetupMicroserviceLocalServiceUtil;
import com.sambaash.platform.srv.spmicroservice.service.base.SPMicroserviceServiceBaseImpl;

/**
 * The implementation of the s p microservice remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author glenn
 * @see com.sambaash.platform.srv.spmicroservice.service.base.SPMicroserviceServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceServiceUtil
 */
public class SPMicroserviceServiceImpl extends SPMicroserviceServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceServiceUtil} to access the s p microservice remote service.
	 */
	
	public JSONArray fetchListOptionByName(boolean fullInfo, String[] name) {
		return RulesMicroserviceLocalServiceUtil.fetchListOptionByName(fullInfo, name);
	}
	
	public JSONArray fetchRuleSetTypes(boolean fullInfo) {
		return RulesMicroserviceLocalServiceUtil.fetchRuleSetTypes(fullInfo);
	}
	
	public JSONArray getRuleSetListing(boolean fullInfo) {
		return RulesMicroserviceLocalServiceUtil.getRuleSetListing(fullInfo);
	}
	
	public JSONArray getProcessRuleSets(boolean includeRules, String ruleSetTypes) {
		return RulesMicroserviceLocalServiceUtil.getPERuleSets(includeRules, ruleSetTypes);
	}
	
	public JSONObject saveRuleSet(String ruleSetJsonString) {
		return RulesMicroserviceLocalServiceUtil.saveRuleSet(stringToJsonObject(ruleSetJsonString));
	}
	
	public JSONObject getRuleSet(Long ruleSetId) {
		return RulesMicroserviceLocalServiceUtil.getRuleSet(ruleSetId);
	}
	
	public JSONArray getFormListing() {
		return FormsMicroserviceLocalServiceUtil.getFormListing();
	}
	
	public JSONObject getForm(long formId) {
		return FormsMicroserviceLocalServiceUtil.getForm(formId);
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public JSONArray getFormFields(long formId, boolean includeLayout, boolean fullInfo) {
		return FormsMicroserviceLocalServiceUtil.getFormFields(formId, includeLayout, fullInfo);
	}
	
	public void addFormEvent(String action, String description) {
		FormsMicroserviceLocalServiceUtil.addFormEvent(action, description);
	}

	public List<AssetCategory> getVocabularyCategories(long vocabularyId, int start, int end) {
		return SPMicroserviceLocalServiceUtil.getVocabularyCategories(vocabularyId, start, end);
	}

	public JSONObject validateCandidate(long scopeGroupId, String candidateJsonString) {
		return CandidateMicroserviceLocalServiceUtil.validate(scopeGroupId, stringToJsonObject(candidateJsonString));
	}

	@AccessControlled(guestAccessEnabled=true)
	public JSONArray getPostalAddress(String countryCode, String postalCode) {
		return SystemSetupMicroserviceLocalServiceUtil.getPostalAddress(countryCode, postalCode);
	}
	
	private JSONObject stringToJsonObject(String jsonObjectString) {
		JSONObject jsonObject;
		try {
			jsonObject = JSONFactoryUtil.createJSONObject(jsonObjectString);
		} catch (Exception e) {
			jsonObject = JSONFactoryUtil.createJSONObject();
		}
		return jsonObject;
	}
	
	public JSONObject retrieveCandidateProgrammePath(long scopeGroupId, String candidateId, String configJson) {
		return CandidateMicroserviceLocalServiceUtil.retrieveCandidateProgrammePath(scopeGroupId, candidateId, configJson);
	}

	public JSONArray getCandidateAllowedModules(long scopeGroupId, Long candidateId, String scheduleCode) {
		return CandidateMicroserviceLocalServiceUtil.getCandidateAllowedModules(scopeGroupId, candidateId, "__EMPTY__".equals(scheduleCode) ? StringPool.SPACE : scheduleCode);
	}
	
	public JSONArray getCandidateSchedule(long scopeGroupId, Long candidateId) {
		return CandidateMicroserviceLocalServiceUtil.getCandidateSchedule(scopeGroupId, candidateId);
	}
	
	public JSONArray getCandidateFailedModules(long scopeGroupId, Long candidateId, String scheduleCode) {
		return CandidateMicroserviceLocalServiceUtil.getCandidateFailedModules(scopeGroupId, candidateId, scheduleCode);
	}
	
	public boolean hasResults(long scopeGroupId, String programmeCode, Long candidateId) {
		return CandidateMicroserviceLocalServiceUtil.hasResults(scopeGroupId, programmeCode, candidateId);
	}
	
	public boolean isPaidInvoice(long scopeGroupId, String invoiceNumbers) {
		return PricingMicroserviceLocalServiceUtil.isPaidInvoice(scopeGroupId, invoiceNumbers);
	}
	
	@AccessControlled(guestAccessEnabled=true)
	public JSONObject updateContentJson(long scopeGroupId, String modelName, String storageId, String patchJsonString) {
		return SystemSetupMicroserviceLocalServiceUtil.updateContentJson(scopeGroupId, modelName, storageId, patchJsonString);
	}
	
	public JSONArray allowedProgrammeScheduleToEnrol(long scopeGroupId, Long candidateId) {
		return CandidateMicroserviceLocalServiceUtil.allowedProgrammeScheduleToEnrol(scopeGroupId, candidateId);
	}
	
	public boolean validateBatchSwitchEnrolmentIds(long scopeGroupId, String enrolmentIds) {
		return EnrolmentMicroserviceLocalServiceUtil.validateBatchSwitchEnrolmentIds(scopeGroupId, enrolmentIds);
	}
	
}