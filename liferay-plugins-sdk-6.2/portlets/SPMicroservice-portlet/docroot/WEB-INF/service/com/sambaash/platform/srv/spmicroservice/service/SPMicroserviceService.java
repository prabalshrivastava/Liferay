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

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.jsonwebservice.JSONWebService;
import com.liferay.portal.kernel.transaction.Isolation;
import com.liferay.portal.kernel.transaction.Propagation;
import com.liferay.portal.kernel.transaction.Transactional;
import com.liferay.portal.security.ac.AccessControlled;
import com.liferay.portal.service.BaseService;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service interface for SPMicroservice. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author glenn
 * @see SPMicroserviceServiceUtil
 * @see com.sambaash.platform.srv.spmicroservice.service.base.SPMicroserviceServiceBaseImpl
 * @see com.sambaash.platform.srv.spmicroservice.service.impl.SPMicroserviceServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SPMicroserviceService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SPMicroserviceServiceUtil} to access the s p microservice remote service. Add custom service methods to {@link com.sambaash.platform.srv.spmicroservice.service.impl.SPMicroserviceServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public java.lang.String getBeanIdentifier();

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public void setBeanIdentifier(java.lang.String beanIdentifier);

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray fetchListOptionByName(
		boolean fullInfo, java.lang.String[] name);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray fetchRuleSetTypes(
		boolean fullInfo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getRuleSetListing(
		boolean fullInfo);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getProcessRuleSets(
		boolean includeRules, java.lang.String ruleSetTypes);

	public com.liferay.portal.kernel.json.JSONObject saveRuleSet(
		java.lang.String ruleSetJsonString);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getRuleSet(
		java.lang.Long ruleSetId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getFormListing();

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getForm(long formId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getFormFields(long formId,
		boolean includeLayout, boolean fullInfo);

	public void addFormEvent(java.lang.String action,
		java.lang.String description);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.util.List<com.liferay.portlet.asset.model.AssetCategory> getVocabularyCategories(
		long vocabularyId, int start, int end);

	public com.liferay.portal.kernel.json.JSONObject validateCandidate(
		long scopeGroupId, java.lang.String candidateJsonString);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getPostalAddress(
		java.lang.String countryCode, java.lang.String postalCode);

	public com.liferay.portal.kernel.json.JSONObject retrieveCandidateProgrammePath(
		long scopeGroupId, java.lang.String candidateId,
		java.lang.String configJson);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getCandidateAllowedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getCandidateSchedule(
		long scopeGroupId, java.lang.Long candidateId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getCandidateFailedModules(
		long scopeGroupId, java.lang.Long candidateId,
		java.lang.String scheduleCode);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean hasResults(long scopeGroupId,
		java.lang.String programmeCode, java.lang.Long candidateId);

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public boolean isPaidInvoice(long scopeGroupId,
		java.lang.String invoiceNumbers);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.kernel.json.JSONObject updateContentJson(
		long scopeGroupId, java.lang.String modelName,
		java.lang.String storageId, java.lang.String patchJsonString);

	public com.liferay.portal.kernel.json.JSONArray allowedProgrammeScheduleToEnrol(
		long scopeGroupId, java.lang.Long candidateId);

	public boolean validateBatchSwitchEnrolmentIds(long scopeGroupId,
		java.lang.String enrolmentIds);
}