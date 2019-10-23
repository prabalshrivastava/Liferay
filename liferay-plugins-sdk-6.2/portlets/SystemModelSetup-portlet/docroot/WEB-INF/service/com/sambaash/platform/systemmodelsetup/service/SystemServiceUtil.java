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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for System. This utility wraps
 * {@link com.sambaash.platform.systemmodelsetup.service.impl.SystemServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author biswo
 * @see SystemService
 * @see com.sambaash.platform.systemmodelsetup.service.base.SystemServiceBaseImpl
 * @see com.sambaash.platform.systemmodelsetup.service.impl.SystemServiceImpl
 * @generated
 */
public class SystemServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.sambaash.platform.systemmodelsetup.service.impl.SystemServiceImpl} and rerun ServiceBuilder to regenerate this class.
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

	public static com.liferay.portal.kernel.json.JSONArray getCategory(
		java.lang.String vocabularyName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return getService().getCategory(vocabularyName, groupId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return getService()
				   .getModelList(modelName, fieldList, groupId,
			matchJsonString, sortString);
	}

	public static com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString,
		int pageSize)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return getService()
				   .getModelList(modelName, fieldList, groupId,
			matchJsonString, sortString, pageSize);
	}

	public static com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return getService()
				   .getModelList(modelName, fieldList, groupId, matchJsonString);
	}

	public static com.liferay.portal.model.User getUserByEmail(long companyId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getUserByEmail(companyId, emailAddress);
	}

	public static java.lang.String createRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model) {
		return getService().createRecord(modeldata, userId, siteId, model);
	}

	public static java.lang.String createRecordNew(long processStateId,
		long userId, long siteId, java.lang.String model) {
		return getService()
				   .createRecordNew(processStateId, userId, siteId, model);
	}

	public static java.lang.String updateRecordFromProcessState(
		java.lang.String processStateId, java.lang.String userId) {
		return getService().updateRecordFromProcessState(processStateId, userId);
	}

	public static java.lang.String createRecordFromProcessState(
		java.lang.String processStateId) {
		return getService().createRecordFromProcessState(processStateId);
	}

	public static java.lang.String getRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId) {
		return getService().getRecord(storageId, model, userId, siteId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getActiveSchedules(
		long siteId, java.lang.String category) {
		return getService().getActiveSchedules(siteId, category);
	}

	public static com.liferay.portal.kernel.json.JSONArray getPrepareClaimSchedules(
		long siteId, java.lang.String invigilatorId) {
		return getService().getPrepareClaimSchedules(siteId, invigilatorId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getSchedulesForEnroledProgramme(
		long candidateId, long userId, long siteId) {
		return getService()
				   .getSchedulesForEnroledProgramme(candidateId, userId, siteId);
	}

	public static com.liferay.portal.kernel.json.JSONObject getProgrammeEnroled(
		long candidateId, long userId, long siteId) {
		return getService().getProgrammeEnroled(candidateId, userId, siteId);
	}

	public static java.lang.String getCandidateCurrentAto(long candidateId,
		long userId, long siteId) {
		return getService().getCandidateCurrentAto(candidateId, userId, siteId);
	}

	public static com.liferay.portal.kernel.json.JSONArray getModules(
		long candidateId, long userId, long siteId) {
		return getService().getModules(candidateId, userId, siteId);
	}

	public static com.liferay.portal.model.User createUser(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress) {
		return getService()
				   .createUser(apiKey, firstName, lastName, emailAdddress);
	}

	public static com.liferay.portal.model.Role getRoleDetails(long companyId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().getRoleDetails(companyId, name);
	}

	public static com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail) {
		return getService()
				   .addUserRecord(apiKey, firstName, lastName, emailAdddress,
			sendPasswordEmail);
	}

	public static com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail, java.lang.String userType, long virtualHostId) {
		return getService()
				   .addUserRecord(apiKey, firstName, lastName, emailAdddress,
			sendPasswordEmail, userType, virtualHostId);
	}

	public static void assignRolesToUser(long userId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().assignRolesToUser(userId, roleIds);
	}

	public static void deleteRoleFromUser(long roleId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteRoleFromUser(roleId, userId);
	}

	public static boolean checkIfUserHasRole(long userId, long companyId,
		java.lang.String name, boolean inherited)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .checkIfUserHasRole(userId, companyId, name, inherited);
	}

	public static void deleteUserRecord(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().deleteUserRecord(userId);
	}

	public static void removeTPandSCfromATO(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		getService().removeTPandSCfromATO(userId);
	}

	public static com.liferay.portal.kernel.json.JSONObject checkExemptionEligibility(
		java.lang.String candidateId, long userId, long siteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .checkExemptionEligibility(candidateId, userId, siteId);
	}

	public static com.liferay.portal.kernel.json.JSONObject checkExemptionEligibility(
		long siteId, long candidateId, java.lang.String applicationTranCode)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService()
				   .checkExemptionEligibility(siteId, candidateId,
			applicationTranCode);
	}

	public static java.lang.String addAdmissionRecord(
		java.lang.String modeldata, long userId, long siteId,
		java.lang.String model)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addAdmissionRecord(modeldata, userId, siteId, model);
	}

	public static java.lang.String addExemptionRecord(
		java.lang.String modeldata, long userId, long siteId,
		java.lang.String model)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService().addExemptionRecord(modeldata, userId, siteId, model);
	}

	public static java.lang.String createEnrolmentRecord(
		java.lang.String modeldata, long userId, long siteId,
		java.lang.String model) {
		return getService()
				   .createEnrolmentRecord(modeldata, userId, siteId, model);
	}

	public static com.liferay.portal.kernel.json.JSONArray getEntityLink(
		long groupId, java.lang.String queryByExampleJsonString,
		java.lang.String returnFieldList,
		java.lang.String retrieveModelDetails, java.lang.Boolean flatten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException {
		return getService()
				   .getEntityLink(groupId, queryByExampleJsonString,
			returnFieldList, retrieveModelDetails, flatten);
	}

	public static java.lang.String decode(java.lang.String url) {
		return getService().decode(url);
	}

	public static com.liferay.portal.kernel.json.JSONObject createUser(
		java.lang.String inputJson) {
		return getService().createUser(inputJson);
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
	public static void addTimelineActivity(java.lang.String actionLink,
		java.lang.String actionLabel, java.lang.String title,
		java.lang.String description, java.lang.String imagePath,
		java.lang.String status, long createdByUserId,
		java.lang.String activityType, java.lang.String category,
		java.lang.String subProductId, java.lang.String content,
		java.lang.String assignedTo, long groupId) {
		getService()
			.addTimelineActivity(actionLink, actionLabel, title, description,
			imagePath, status, createdByUserId, activityType, category,
			subProductId, content, assignedTo, groupId);
	}

	public static boolean updateUser(java.lang.String emailAddress) {
		return getService().updateUser(emailAddress);
	}

	public static void clearService() {
		_service = null;
	}

	public static SystemService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					SystemService.class.getName());

			if (invokableService instanceof SystemService) {
				_service = (SystemService)invokableService;
			}
			else {
				_service = new SystemServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(SystemServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(SystemService service) {
	}

	private static SystemService _service;
}