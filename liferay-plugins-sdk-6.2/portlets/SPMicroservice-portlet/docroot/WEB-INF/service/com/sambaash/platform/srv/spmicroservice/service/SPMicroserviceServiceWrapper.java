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

package com.sambaash.platform.srv.spmicroservice.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SPMicroserviceService}.
 *
 * @author glenn
 * @see SPMicroserviceService
 * @generated
 */
public class SPMicroserviceServiceWrapper implements SPMicroserviceService,
	ServiceWrapper<SPMicroserviceService> {
	public SPMicroserviceServiceWrapper(
		SPMicroserviceService spMicroserviceService) {
		_spMicroserviceService = spMicroserviceService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _spMicroserviceService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_spMicroserviceService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _spMicroserviceService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray fetchListOptionByName(
		boolean fullInfo, java.lang.String[] name) {
		return _spMicroserviceService.fetchListOptionByName(fullInfo, name);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray fetchRuleSetTypes(
		boolean fullInfo) {
		return _spMicroserviceService.fetchRuleSetTypes(fullInfo);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getRuleSetListing(
		boolean fullInfo) {
		return _spMicroserviceService.getRuleSetListing(fullInfo);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getProcessRuleSets(
		boolean includeRules, java.lang.String ruleSetTypes) {
		return _spMicroserviceService.getProcessRuleSets(includeRules,
			ruleSetTypes);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject saveRuleSet(
		java.lang.String ruleSetJsonString) {
		return _spMicroserviceService.saveRuleSet(ruleSetJsonString);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getRuleSet(
		java.lang.Long ruleSetId) {
		return _spMicroserviceService.getRuleSet(ruleSetId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getFormListing() {
		return _spMicroserviceService.getFormListing();
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getForm(long formId) {
		return _spMicroserviceService.getForm(formId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getFormFields(long formId,
		boolean includeLayout, boolean fullInfo) {
		return _spMicroserviceService.getFormFields(formId, includeLayout,
			fullInfo);
	}

	@Override
	public void addFormEvent(java.lang.String action,
		java.lang.String description) {
		_spMicroserviceService.addFormEvent(action, description);
	}

	@Override
	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getVocabularyCategories(
		long vocabularyId, int start, int end) {
		return _spMicroserviceService.getVocabularyCategories(vocabularyId,
			start, end);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject validateCandidate(
		long scopeGroupId, java.lang.String candidateJsonString) {
		return _spMicroserviceService.validateCandidate(scopeGroupId,
			candidateJsonString);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPostalAddress(
		java.lang.String countryCode, java.lang.String postalCode) {
		return _spMicroserviceService.getPostalAddress(countryCode, postalCode);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject retrieveCandidateProgrammePath(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String configJson) {
		return _spMicroserviceService.retrieveCandidateProgrammePath(scopeGroupId,
			candidateId, configJson);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCandidateAllowedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) {
		return _spMicroserviceService.getCandidateAllowedModules(scopeGroupId,
			candidateId, scheduleCode);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCandidateSchedule(
		long scopeGroupId, java.lang.Long candidateId) {
		return _spMicroserviceService.getCandidateSchedule(scopeGroupId,
			candidateId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCandidateFailedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) {
		return _spMicroserviceService.getCandidateFailedModules(scopeGroupId,
			candidateId, scheduleCode);
	}

	@Override
	public boolean hasResults(long scopeGroupId,
		java.lang.String programmeCode, java.lang.Long candidateId) {
		return _spMicroserviceService.hasResults(scopeGroupId, programmeCode,
			candidateId);
	}

	@Override
	public boolean isPaidInvoice(long scopeGroupId,
		java.lang.String invoiceNumbers) {
		return _spMicroserviceService.isPaidInvoice(scopeGroupId, invoiceNumbers);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject updateContentJson(
		long scopeGroupId, java.lang.String modelName,
		java.lang.String storageId, java.lang.String patchJsonString) {
		return _spMicroserviceService.updateContentJson(scopeGroupId,
			modelName, storageId, patchJsonString);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray allowedProgrammeScheduleToEnrol(
		long scopeGroupId, java.lang.Long candidateId) {
		return _spMicroserviceService.allowedProgrammeScheduleToEnrol(scopeGroupId,
			candidateId);
	}

	@Override
	public boolean validateBatchSwitchEnrolmentIds(long scopeGroupId,
		java.lang.String enrolmentIds) {
		return _spMicroserviceService.validateBatchSwitchEnrolmentIds(scopeGroupId,
			enrolmentIds);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SPMicroserviceService getWrappedSPMicroserviceService() {
		return _spMicroserviceService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSPMicroserviceService(
		SPMicroserviceService spMicroserviceService) {
		_spMicroserviceService = spMicroserviceService;
	}

	@Override
	public SPMicroserviceService getWrappedService() {
		return _spMicroserviceService;
	}

	@Override
	public void setWrappedService(SPMicroserviceService spMicroserviceService) {
		_spMicroserviceService = spMicroserviceService;
	}

	private SPMicroserviceService _spMicroserviceService;
}