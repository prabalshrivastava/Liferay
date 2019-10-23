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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for SPMicroservice. This utility wraps
 * {@link com.sambaash.platform.srv.spmicroservice.service.impl.SPMicroserviceServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author glenn
 * @see SPMicroserviceService
 * @see com.sambaash.platform.srv.spmicroservice.service.base.SPMicroserviceServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.impl.SPMicroserviceServiceImpl
 * @generated
 */
public class SPMicroserviceServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.srv.spmicroservice.service.impl.SPMicroserviceServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.portal.kernel.json.JSONArray fetchListOptionByName(
		boolean fullInfo, java.lang.String[] name) {
		return getService().fetchListOptionByName(fullInfo, name);
	}

	public static com.liferay.portal.kernel.json.JSONArray fetchRuleSetTypes(
		boolean fullInfo) {
		return getService().fetchRuleSetTypes(fullInfo);
	}

	public static com.liferay.portal.kernel.json.JSONArray getRuleSetListing(
		boolean fullInfo) {
		return getService().getRuleSetListing(fullInfo);
	}

	public static com.liferay.portal.kernel.json.JSONArray getProcessRuleSets(
		boolean includeRules, java.lang.String ruleSetTypes) {
		return getService().getProcessRuleSets(includeRules, ruleSetTypes);
	}

	public static com.liferay.portal.kernel.json.JSONObject saveRuleSet(
		java.lang.String ruleSetJsonString) {
		return getService().saveRuleSet(ruleSetJsonString);
	}

	public static com.liferay.portal.kernel.json.JSONObject getRuleSet(
		java.lang.Long ruleSetId) {
		return getService().getRuleSet(ruleSetId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getFormListing() {
		return getService().getFormListing();
	}

	public static com.liferay.portal.kernel.json.JSONObject getForm(long formId) {
		return getService().getForm(formId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getFormFields(
		long formId, boolean includeLayout, boolean fullInfo) {
		return getService().getFormFields(formId, includeLayout, fullInfo);
	}

	public static void addFormEvent(java.lang.String action,
		java.lang.String description) {
		getService().addFormEvent(action, description);
	}

	public static java.util.List<com.liferay.portlet.asset.model.AssetCategory> getVocabularyCategories(
		long vocabularyId, int start, int end) {
		return getService().getVocabularyCategories(vocabularyId, start, end);
	}

	public static com.liferay.portal.kernel.json.JSONObject validateCandidate(
		long scopeGroupId, java.lang.String candidateJsonString) {
		return getService().validateCandidate(scopeGroupId, candidateJsonString);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPostalAddress(
		java.lang.String countryCode, java.lang.String postalCode) {
		return getService().getPostalAddress(countryCode, postalCode);
	}

	public static com.liferay.portal.kernel.json.JSONObject retrieveCandidateProgrammePath(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String configJson) {
		return getService()
				   .retrieveCandidateProgrammePath(scopeGroupId, candidateId,
			configJson);
	}

	public static com.liferay.portal.kernel.json.JSONArray getCandidateAllowedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) {
		return getService()
				   .getCandidateAllowedModules(scopeGroupId, candidateId,
			scheduleCode);
	}

	public static com.liferay.portal.kernel.json.JSONArray getCandidateSchedule(
		long scopeGroupId, java.lang.Long candidateId) {
		return getService().getCandidateSchedule(scopeGroupId, candidateId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getCandidateFailedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) {
		return getService()
				   .getCandidateFailedModules(scopeGroupId, candidateId,
			scheduleCode);
	}

	public static boolean hasResults(long scopeGroupId,
		java.lang.String programmeCode, java.lang.Long candidateId) {
		return getService().hasResults(scopeGroupId, programmeCode, candidateId);
	}

	public static boolean isPaidInvoice(long scopeGroupId,
		java.lang.String invoiceNumbers) {
		return getService().isPaidInvoice(scopeGroupId, invoiceNumbers);
	}

	public static com.liferay.portal.kernel.json.JSONObject updateContentJson(
		long scopeGroupId, java.lang.String modelName,
		java.lang.String storageId, java.lang.String patchJsonString) {
		return getService()
				   .updateContentJson(scopeGroupId, modelName, storageId,
			patchJsonString);
	}

	public static com.liferay.portal.kernel.json.JSONArray allowedProgrammeScheduleToEnrol(
		long scopeGroupId, java.lang.Long candidateId) {
		return getService()
				   .allowedProgrammeScheduleToEnrol(scopeGroupId, candidateId);
	}

	public static boolean validateBatchSwitchEnrolmentIds(long scopeGroupId,
		java.lang.String enrolmentIds) {
		return getService()
				   .validateBatchSwitchEnrolmentIds(scopeGroupId, enrolmentIds);
	}

	public static void clearService() {
		_service = null;
	}

	public static SPMicroserviceService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SPMicroserviceService.class.getName());

			if (invokableService instanceof SPMicroserviceService) {
				_service = (SPMicroserviceService)invokableService;
			}
			else {
				_service = new SPMicroserviceServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SPMicroserviceServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SPMicroserviceService service) {
	}

	private static SPMicroserviceService _service;
}