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
 * Provides the remote service interface for System. Methods of this
 * service are expected to have security checks based on the propagated JAAS
 * credentials because this service can be accessed remotely.
 *
 * @author biswo
 * @see SystemServiceUtil
 * @see com.sambaash.platform.systemmodelsetup.service.base.SystemServiceBaseImpl
 * @see com.sambaash.platform.systemmodelsetup.service.impl.SystemServiceImpl
 * @generated
 */
@AccessControlled
@JSONWebService
@Transactional(isolation = Isolation.PORTAL, rollbackFor =  {
	PortalException.class, SystemException.class})
public interface SystemService extends BaseService, InvokableService {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SystemServiceUtil} to access the system remote service. Add custom service methods to {@link com.sambaash.platform.systemmodelsetup.service.impl.SystemServiceImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
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

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getCategory(
		java.lang.String vocabularyName, long groupId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString, java.lang.String sortString,
		int pageSize)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException;

	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getModelList(
		java.lang.String modelName, java.lang.String fieldList, long groupId,
		java.lang.String matchJsonString)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.User getUserByEmail(long companyId,
		java.lang.String emailAddress)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String createRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String createRecordNew(long processStateId, long userId,
		long siteId, java.lang.String model);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String updateRecordFromProcessState(
		java.lang.String processStateId, java.lang.String userId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String createRecordFromProcessState(
		java.lang.String processStateId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getRecord(java.lang.String storageId,
		java.lang.String model, long userId, long siteId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getActiveSchedules(
		long siteId, java.lang.String category);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getPrepareClaimSchedules(
		long siteId, java.lang.String invigilatorId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getSchedulesForEnroledProgramme(
		long candidateId, long userId, long siteId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONObject getProgrammeEnroled(
		long candidateId, long userId, long siteId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public java.lang.String getCandidateCurrentAto(long candidateId,
		long userId, long siteId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getModules(
		long candidateId, long userId, long siteId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.model.User createUser(java.lang.String apiKey,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String emailAdddress);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.model.Role getRoleDetails(long companyId,
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.model.User addUserRecord(
		java.lang.String apiKey, java.lang.String firstName,
		java.lang.String lastName, java.lang.String emailAdddress,
		boolean sendPasswordEmail, java.lang.String userType, long virtualHostId);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public void assignRolesToUser(long userId, long[] roleIds)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public void deleteRoleFromUser(long roleId, long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public boolean checkIfUserHasRole(long userId, long companyId,
		java.lang.String name, boolean inherited)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public void deleteUserRecord(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public void removeTPandSCfromATO(long userId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.kernel.json.JSONObject checkExemptionEligibility(
		java.lang.String candidateId, long userId, long siteId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public com.liferay.portal.kernel.json.JSONObject checkExemptionEligibility(
		long siteId, long candidateId, java.lang.String applicationTranCode)
		throws com.liferay.portal.kernel.exception.PortalException;

	public java.lang.String addAdmissionRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	public java.lang.String addExemptionRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException;

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public java.lang.String createEnrolmentRecord(java.lang.String modeldata,
		long userId, long siteId, java.lang.String model);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
	public com.liferay.portal.kernel.json.JSONArray getEntityLink(
		long groupId, java.lang.String queryByExampleJsonString,
		java.lang.String returnFieldList,
		java.lang.String retrieveModelDetails, java.lang.Boolean flatten)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.portal.kernel.json.JSONException, org.json.JSONException;

	public java.lang.String decode(java.lang.String url);

	@com.liferay.portal.security.ac.AccessControlled(guestAccessEnabled = true)
	public com.liferay.portal.kernel.json.JSONObject createUser(
		java.lang.String inputJson);

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
	public void addTimelineActivity(java.lang.String actionLink,
		java.lang.String actionLabel, java.lang.String title,
		java.lang.String description, java.lang.String imagePath,
		java.lang.String status, long createdByUserId,
		java.lang.String activityType, java.lang.String category,
		java.lang.String subProductId, java.lang.String content,
		java.lang.String assignedTo, long groupId);

	public boolean updateUser(java.lang.String emailAddress);
}