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

package com.sambaash.platform.systemmodelsetup.service.http;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil;

import java.rmi.RemoteException;

/**
 * Provides the SOAP utility for the
 * {@link com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil} service utility. The
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
 * @author biswo
 * @see SystemServiceHttp
 * @see com.sambaash.platform.systemmodelsetup.service.SystemServiceUtil
 * @generated
 */
public class SystemServiceSoap {
	public static java.lang.String getCategory(
		java.lang.String vocabularyName, long groupId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SystemServiceUtil.getCategory(vocabularyName,
					groupId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getModelList(java.lang.String modelName,
		java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SystemServiceUtil.getModelList(modelName,
					fieldList, groupId, matchJsonString, sortString);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getModelList(java.lang.String modelName,
		java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString,
		int pageSize) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SystemServiceUtil.getModelList(modelName,
					fieldList, groupId, matchJsonString, sortString, pageSize);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getModelList(java.lang.String modelName,
		java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SystemServiceUtil.getModelList(modelName,
					fieldList, groupId, matchJsonString);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User getUserByEmail(long companyId,
		java.lang.String emailAddress) throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SystemServiceUtil.getUserByEmail(companyId,
					emailAddress);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String createRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model)
		throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.createRecord(modeldata,
					userId, siteId, model);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String createRecordNew(long processStateId,
		long userId, long siteId, java.lang.String model)
		throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.createRecordNew(processStateId,
					userId, siteId, model);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String updateRecordFromProcessState(
		java.lang.String processStateId, java.lang.String userId)
		throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.updateRecordFromProcessState(processStateId,
					userId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String createRecordFromProcessState(
		java.lang.String processStateId) throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.createRecordFromProcessState(processStateId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId)
		throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.getRecord(storageId,
					model, userId, siteId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getActiveSchedules(long siteId,
		java.lang.String category) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SystemServiceUtil.getActiveSchedules(siteId,
					category);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getPrepareClaimSchedules(long siteId,
		java.lang.String invigilatorId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SystemServiceUtil.getPrepareClaimSchedules(siteId,
					invigilatorId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getSchedulesForEnroledProgramme(
		long candidateId, long userId, long siteId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SystemServiceUtil.getSchedulesForEnroledProgramme(candidateId,
					userId, siteId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getProgrammeEnroled(long candidateId,
		long userId, long siteId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SystemServiceUtil.getProgrammeEnroled(candidateId,
					userId, siteId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getCandidateCurrentAto(long candidateId,
		long userId, long siteId) throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.getCandidateCurrentAto(candidateId,
					userId, siteId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getModules(long candidateId, long userId,
		long siteId) throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SystemServiceUtil.getModules(candidateId,
					userId, siteId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User createUser(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress)
		throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SystemServiceUtil.createUser(apiKey,
					firstName, lastName, emailAdddress);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.Role getRoleDetails(long companyId,
		java.lang.String name) throws RemoteException {
		try {
			com.liferay.portal.model.Role returnValue = SystemServiceUtil.getRoleDetails(companyId,
					name);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail) throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SystemServiceUtil.addUserRecord(apiKey,
					firstName, lastName, emailAdddress, sendPasswordEmail);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail, java.lang.String userType, long virtualHostId)
		throws RemoteException {
		try {
			com.liferay.portal.model.User returnValue = SystemServiceUtil.addUserRecord(apiKey,
					firstName, lastName, emailAdddress, sendPasswordEmail,
					userType, virtualHostId);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void assignRolesToUser(long userId, long[] roleIds)
		throws RemoteException {
		try {
			SystemServiceUtil.assignRolesToUser(userId, roleIds);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteRoleFromUser(long roleId, long userId)
		throws RemoteException {
		try {
			SystemServiceUtil.deleteRoleFromUser(roleId, userId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean checkIfUserHasRole(long userId, long companyId,
		java.lang.String name, boolean inherited) throws RemoteException {
		try {
			boolean returnValue = SystemServiceUtil.checkIfUserHasRole(userId,
					companyId, name, inherited);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void deleteUserRecord(long userId) throws RemoteException {
		try {
			SystemServiceUtil.deleteUserRecord(userId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static void removeTPandSCfromATO(long userId)
		throws RemoteException {
		try {
			SystemServiceUtil.removeTPandSCfromATO(userId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String checkExemptionEligibility(
		java.lang.String candidateId, long userId, long siteId)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SystemServiceUtil.checkExemptionEligibility(candidateId,
					userId, siteId);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String checkExemptionEligibility(long siteId,
		long candidateId, java.lang.String applicationTranCode)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SystemServiceUtil.checkExemptionEligibility(siteId,
					candidateId, applicationTranCode);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String addAdmissionRecord(
		java.lang.String modeldata, long userId, long siteId,
		java.lang.String model) throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.addAdmissionRecord(modeldata,
					userId, siteId, model);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String addExemptionRecord(
		java.lang.String modeldata, long userId, long siteId,
		java.lang.String model) throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.addExemptionRecord(modeldata,
					userId, siteId, model);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String createEnrolmentRecord(
		java.lang.String modeldata, long userId, long siteId,
		java.lang.String model) throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.createEnrolmentRecord(modeldata,
					userId, siteId, model);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String getEntityLink(long groupId,
		java.lang.String queryByExampleJsonString,
		java.lang.String returnFieldList,
		java.lang.String retrieveModelDetails, java.lang.Boolean flatten)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONArray returnValue = SystemServiceUtil.getEntityLink(groupId,
					queryByExampleJsonString, returnFieldList,
					retrieveModelDetails, flatten);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String decode(java.lang.String url)
		throws RemoteException {
		try {
			java.lang.String returnValue = SystemServiceUtil.decode(url);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static java.lang.String createUser(java.lang.String inputJson)
		throws RemoteException {
		try {
			com.liferay.portal.kernel.json.JSONObject returnValue = SystemServiceUtil.createUser(inputJson);

			return returnValue.toString();
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
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
		java.lang.String assignedTo, long groupId) throws RemoteException {
		try {
			SystemServiceUtil.addTimelineActivity(actionLink, actionLabel,
				title, description, imagePath, status, createdByUserId,
				activityType, category, subProductId, content, assignedTo,
				groupId);
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	public static boolean updateUser(java.lang.String emailAddress)
		throws RemoteException {
		try {
			boolean returnValue = SystemServiceUtil.updateUser(emailAddress);

			return returnValue;
		}
		catch (Exception e) {
			_log.error(e, e);

			throw new RemoteException(e.getMessage());
		}
	}

	private static Log _log = LogFactoryUtil.getLog(SystemServiceSoap.class);
}