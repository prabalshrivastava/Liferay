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

package com.sambaash.platform.systemmodelsetup.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SystemService}.
 *
 * @author biswo
 * @see SystemService
 * @generated
 */
public class SystemServiceWrapper implements SystemService,
	ServiceWrapper<SystemService> {
	public SystemServiceWrapper(SystemService systemService) {
		_systemService = systemService;
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _systemService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_systemService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _systemService.invokeMethod(name, parameterTypes, arguments);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getCategory(
		java.lang.String vocabularyName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return _systemService.getCategory(vocabularyName, groupId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return _systemService.getModelList(modelName, fieldList, groupId,
			matchJsonString, sortString);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString,
		int pageSize)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return _systemService.getModelList(modelName, fieldList, groupId,
			matchJsonString, sortString, pageSize);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return _systemService.getModelList(modelName, fieldList, groupId,
			matchJsonString);
	}

	@Override
	public com.liferay.portal.model.User getUserByEmail(long companyId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _systemService.getUserByEmail(companyId, emailAddress);
	}

	@Override
	public java.lang.String createRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model) {
		return _systemService.createRecord(modeldata, userId, siteId, model);
	}

	@Override
	public java.lang.String createRecordNew(long processStateId, long userId,
		long siteId, java.lang.String model) {
		return _systemService.createRecordNew(processStateId, userId, siteId,
			model);
	}

	@Override
	public java.lang.String updateRecordFromProcessState(
		java.lang.String processStateId, java.lang.String userId) {
		return _systemService.updateRecordFromProcessState(processStateId,
			userId);
	}

	@Override
	public java.lang.String createRecordFromProcessState(
		java.lang.String processStateId) {
		return _systemService.createRecordFromProcessState(processStateId);
	}

	@Override
	public java.lang.String getRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId) {
		return _systemService.getRecord(storageId, model, userId, siteId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getActiveSchedules(
		long siteId, java.lang.String category) {
		return _systemService.getActiveSchedules(siteId, category);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getPrepareClaimSchedules(
		long siteId, java.lang.String invigilatorId) {
		return _systemService.getPrepareClaimSchedules(siteId, invigilatorId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getSchedulesForEnroledProgramme(
		long candidateId, long userId, long siteId) {
		return _systemService.getSchedulesForEnroledProgramme(candidateId,
			userId, siteId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject getProgrammeEnroled(
		long candidateId, long userId, long siteId) {
		return _systemService.getProgrammeEnroled(candidateId, userId, siteId);
	}

	@Override
	public java.lang.String getCandidateCurrentAto(long candidateId,
		long userId, long siteId) {
		return _systemService.getCandidateCurrentAto(candidateId, userId, siteId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getModules(
		long candidateId, long userId, long siteId) {
		return _systemService.getModules(candidateId, userId, siteId);
	}

	@Override
	public com.liferay.portal.model.User createUser(java.lang.String apiKey,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAdddress) {
		return _systemService.createUser(apiKey, firstName, lastName,
			emailAdddress);
	}

	@Override
	public com.liferay.portal.model.Role getRoleDetails(long companyId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _systemService.getRoleDetails(companyId, name);
	}

	@Override
	public com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail) {
		return _systemService.addUserRecord(apiKey, firstName, lastName,
			emailAdddress, sendPasswordEmail);
	}

	@Override
	public com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail, java.lang.String userType, long virtualHostId) {
		return _systemService.addUserRecord(apiKey, firstName, lastName,
			emailAdddress, sendPasswordEmail, userType, virtualHostId);
	}

	@Override
	public void assignRolesToUser(long userId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_systemService.assignRolesToUser(userId, roleIds);
	}

	@Override
	public void deleteRoleFromUser(long roleId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_systemService.deleteRoleFromUser(roleId, userId);
	}

	@Override
	public boolean checkIfUserHasRole(long userId, long companyId,
		java.lang.String name, boolean inherited)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _systemService.checkIfUserHasRole(userId, companyId, name,
			inherited);
	}

	@Override
	public void deleteUserRecord(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_systemService.deleteUserRecord(userId);
	}

	@Override
	public void removeTPandSCfromATO(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		_systemService.removeTPandSCfromATO(userId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject checkExemptionEligibility(
		java.lang.String candidateId, long userId, long siteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _systemService.checkExemptionEligibility(candidateId, userId,
			siteId);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject checkExemptionEligibility(
		long siteId, long candidateId, java.lang.String applicationTranCode)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _systemService.checkExemptionEligibility(siteId, candidateId,
			applicationTranCode);
	}

	@Override
	public java.lang.String addAdmissionRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _systemService.addAdmissionRecord(modeldata, userId, siteId,
			model);
	}

	@Override
	public java.lang.String addExemptionRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _systemService.addExemptionRecord(modeldata, userId, siteId,
			model);
	}

	@Override
	public java.lang.String createEnrolmentRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model) {
		return _systemService.createEnrolmentRecord(modeldata, userId, siteId,
			model);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONArray getEntityLink(
		long groupId, java.lang.String queryByExampleJsonString,
		java.lang.String returnFieldList,
		java.lang.String retrieveModelDetails, java.lang.Boolean flatten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return _systemService.getEntityLink(groupId, queryByExampleJsonString,
			returnFieldList, retrieveModelDetails, flatten);
	}

	@Override
	public java.lang.String decode(java.lang.String url) {
		return _systemService.decode(url);
	}

	@Override
	public com.liferay.portal.kernel.json.JSONObject createUser(
		java.lang.String inputJson) {
		return _systemService.createUser(inputJson);
	}

	/**
	* @param actionLink a String type. Upon action will lead to this link.
	* @param actionLabel a String type. Label to be displayed on Timeline.
	* @param title a String type. Title to be displayed on Timeline Activity.
	* @param description a String type. Description to be displayed on Timeline Activity. Not used currently.
	* @param imagePath a String type. Image to be displayed on Timeline Activity. Not used currently.
	* @param status a String type. Status to be displayed on Timeline Activity.
	* @param createdByUserId a long type. Person who is creating this Activity..
	* @param activityType a String type. ActivityType to be displayed on Timeline Activity.
	* @param category a String type. Category to be displayed on Timeline Activity.
	* @param subProductId a String type. Should be fetched from SPSiteSetup subProductId.
	* @param content a String type. Not used currently. Can be set blank.
	* @param assignedTo a String type. Person whom this activity should be assigned to and can see it on his/her Timeline.
	* @param groupId a long type.
	*/
	@Override
	public void addTimelineActivity(java.lang.String actionLink,
		java.lang.String actionLabel, java.lang.String title,
		java.lang.String description, java.lang.String imagePath,
		java.lang.String status, long createdByUserId,
		java.lang.String activityType, java.lang.String category,
		java.lang.String subProductId, java.lang.String content,
		java.lang.String assignedTo, long groupId) {
		_systemService.addTimelineActivity(actionLink, actionLabel, title,
			description, imagePath, status, createdByUserId, activityType,
			category, subProductId, content, assignedTo, groupId);
	}

	@Override
	public boolean updateUser(java.lang.String emailAddress) {
		return _systemService.updateUser(emailAddress);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public SystemService getWrappedSystemService() {
		return _systemService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedSystemService(SystemService systemService) {
		_systemService = systemService;
	}

	@Override
	public SystemService getWrappedService() {
		return _systemService;
	}

	@Override
	public void setWrappedService(SystemService systemService) {
		_systemService = systemService;
	}

	private SystemService _systemService;
}