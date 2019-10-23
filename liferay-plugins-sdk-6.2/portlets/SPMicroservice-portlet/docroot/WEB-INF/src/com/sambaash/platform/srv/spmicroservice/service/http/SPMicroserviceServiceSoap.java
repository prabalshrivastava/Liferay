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

package com.sambaash.platform.srv.spmicroservice.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceServiceUtil} service utility. The
 * static methods of this class calls the same methods of the service utility.
 * However, the signatures are different because it is difficult for SOAP to
 * support certain types.
 *
 * <p>
 * The benefits of using the SOAP utility is that it is cross platform
 * compatible. SOAP allows different languages like Java, .NET, C++, PHP, and
 * even Perl, to call the generated services. One drawback of SOAP is that it is
 * slow because it needs to serialize all calls into a text format (XML).
 * </p>
 *
 * <p>
 * You can see a list of services at http://localhost:8080/api/axis. Set the
 * property <b>axis.servlet.hosts.allowed</b> in portal.properties to configure
 * security.
 * </p>
 *
 * <p>
 * The SOAP utility is only generated for remote services.
 * </p>
 *
 * @author glenn
 * @see SPMicroserviceServiceHttp
 * @see com.sambaash.platform.srv.spmicroservice.service.SPMicroserviceServiceUtil
 * @generated
 */
public class SPMicroserviceServiceSoap {
	public static java.lang.String fetchListOptionByName(boolean fullInfo,
		java.lang.String[] name) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.fetchListOptionByName(fullInfo,
					name);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String fetchRuleSetTypes(boolean fullInfo)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.fetchRuleSetTypes(fullInfo);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getRuleSetListing(boolean fullInfo)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.getRuleSetListing(fullInfo);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getProcessRuleSets(boolean includeRules,
		java.lang.String ruleSetTypes) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.getProcessRuleSets(includeRules,
					ruleSetTypes);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String saveRuleSet(
		java.lang.String ruleSetJsonString) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SPMicroserviceServiceUtil.saveRuleSet(ruleSetJsonString);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getRuleSet(java.lang.Long ruleSetId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SPMicroserviceServiceUtil.getRuleSet(ruleSetId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getFormListing() throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.getFormListing();

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getForm(long formId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SPMicroserviceServiceUtil.getForm(formId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getFormFields(long formId,
		boolean includeLayout, boolean fullInfo) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.getFormFields(formId,
					includeLayout, fullInfo);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void addFormEvent(java.lang.String action,
		java.lang.String description) throws RemoteException {
		try {
			SPMicroserviceServiceUtil.addFormEvent(action, description);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portlet.asset.model.AssetCategory[] getVocabularyCategories(
		long vocabularyId, int start, int end) throws RemoteException {
		try {
			java.util.List<com.liferay.portlet.asset.model.AssetCategory> returnValue =
				SPMicroserviceServiceUtil.getVocabularyCategories(vocabularyId,
					start, end);

			return returnValue.toArray(new com.liferay.portlet.asset.model.AssetCategory[returnValue.size()]);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String validateCandidate(long scopeGroupId,
		java.lang.String candidateJsonString) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SPMicroserviceServiceUtil.validateCandidate(scopeGroupId,
					candidateJsonString);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getPostalAddress(
		java.lang.String countryCode, java.lang.String postalCode)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.getPostalAddress(countryCode,
					postalCode);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String retrieveCandidateProgrammePath(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String configJson) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SPMicroserviceServiceUtil.retrieveCandidateProgrammePath(scopeGroupId,
					candidateId, configJson);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getCandidateAllowedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.getCandidateAllowedModules(scopeGroupId,
					candidateId, scheduleCode);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getCandidateSchedule(long scopeGroupId,
		java.lang.Long candidateId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.getCandidateSchedule(scopeGroupId,
					candidateId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getCandidateFailedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.getCandidateFailedModules(scopeGroupId,
					candidateId, scheduleCode);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean hasResults(long scopeGroupId,
		java.lang.String programmeCode, java.lang.Long candidateId)
		throws RemoteException {
		try {
			boolean returnValue = SPMicroserviceServiceUtil.hasResults(scopeGroupId,
					programmeCode, candidateId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean isPaidInvoice(long scopeGroupId,
		java.lang.String invoiceNumbers) throws RemoteException {
		try {
			boolean returnValue = SPMicroserviceServiceUtil.isPaidInvoice(scopeGroupId,
					invoiceNumbers);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String updateContentJson(long scopeGroupId,
		java.lang.String modelName, java.lang.String storageId,
		java.lang.String patchJsonString) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SPMicroserviceServiceUtil.updateContentJson(scopeGroupId,
					modelName, storageId, patchJsonString);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String allowedProgrammeScheduleToEnrol(
		long scopeGroupId, java.lang.Long candidateId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SPMicroserviceServiceUtil.allowedProgrammeScheduleToEnrol(scopeGroupId,
					candidateId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean validateBatchSwitchEnrolmentIds(long scopeGroupId,
		java.lang.String enrolmentIds) throws RemoteException {
		try {
			boolean returnValue = SPMicroserviceServiceUtil.validateBatchSwitchEnrolmentIds(scopeGroupId,
					enrolmentIds);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SPMicroserviceServiceSoap.class);
}