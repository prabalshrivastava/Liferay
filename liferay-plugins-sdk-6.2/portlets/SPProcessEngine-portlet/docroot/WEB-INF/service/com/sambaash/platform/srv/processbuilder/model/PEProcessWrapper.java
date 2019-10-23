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

package com.sambaash.platform.srv.processbuilder.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PEProcess}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcess
 * @generated
 */
public class PEProcessWrapper implements PEProcess, ModelWrapper<PEProcess> {
	public PEProcessWrapper(PEProcess peProcess) {
		_peProcess = peProcess;
	}

	@Override
	public Class<?> getModelClass() {
		return PEProcess.class;
	}

	@Override
	public String getModelClassName() {
		return PEProcess.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEProcessId", getSpPEProcessId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("definiton", getDefiniton());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("agentEnabled", getAgentEnabled());
		attributes.put("agentRoleIds", getAgentRoleIds());
		attributes.put("approveRoleIds", getApproveRoleIds());
		attributes.put("miscData", getMiscData());
		attributes.put("diagramData", getDiagramData());
		attributes.put("entityTitle", getEntityTitle());
		attributes.put("approverPageName", getApproverPageName());
		attributes.put("userPageName", getUserPageName());
		attributes.put("agentPageName", getAgentPageName());
		attributes.put("status", getStatus());
		attributes.put("applicantRoleId", getApplicantRoleId());
		attributes.put("supervisorRoleIds", getSupervisorRoleIds());
		attributes.put("supervisorPageName", getSupervisorPageName());
		attributes.put("closedReasonVocId", getClosedReasonVocId());
		attributes.put("accountCreationEmailEnabled",
			getAccountCreationEmailEnabled());
		attributes.put("enableAssignment", getEnableAssignment());
		attributes.put("editFeeDetails", getEditFeeDetails());
		attributes.put("scheduleModelId", getScheduleModelId());
		attributes.put("enableSingleSubmission", getEnableSingleSubmission());
		attributes.put("orientation", getOrientation());
		attributes.put("showHeader", getShowHeader());
		attributes.put("enableFirstStepProgress", getEnableFirstStepProgress());
		attributes.put("subProductTypeId", getSubProductTypeId());
		attributes.put("productTypeId", getProductTypeId());
		attributes.put("singleSubmissionErrorMsg", getSingleSubmissionErrorMsg());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEProcessId = (Long)attributes.get("spPEProcessId");

		if (spPEProcessId != null) {
			setSpPEProcessId(spPEProcessId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String definiton = (String)attributes.get("definiton");

		if (definiton != null) {
			setDefiniton(definiton);
		}

		Long entityClassId = (Long)attributes.get("entityClassId");

		if (entityClassId != null) {
			setEntityClassId(entityClassId);
		}

		Boolean agentEnabled = (Boolean)attributes.get("agentEnabled");

		if (agentEnabled != null) {
			setAgentEnabled(agentEnabled);
		}

		String agentRoleIds = (String)attributes.get("agentRoleIds");

		if (agentRoleIds != null) {
			setAgentRoleIds(agentRoleIds);
		}

		String approveRoleIds = (String)attributes.get("approveRoleIds");

		if (approveRoleIds != null) {
			setApproveRoleIds(approveRoleIds);
		}

		String miscData = (String)attributes.get("miscData");

		if (miscData != null) {
			setMiscData(miscData);
		}

		String diagramData = (String)attributes.get("diagramData");

		if (diagramData != null) {
			setDiagramData(diagramData);
		}

		String entityTitle = (String)attributes.get("entityTitle");

		if (entityTitle != null) {
			setEntityTitle(entityTitle);
		}

		String approverPageName = (String)attributes.get("approverPageName");

		if (approverPageName != null) {
			setApproverPageName(approverPageName);
		}

		String userPageName = (String)attributes.get("userPageName");

		if (userPageName != null) {
			setUserPageName(userPageName);
		}

		String agentPageName = (String)attributes.get("agentPageName");

		if (agentPageName != null) {
			setAgentPageName(agentPageName);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long applicantRoleId = (Long)attributes.get("applicantRoleId");

		if (applicantRoleId != null) {
			setApplicantRoleId(applicantRoleId);
		}

		String supervisorRoleIds = (String)attributes.get("supervisorRoleIds");

		if (supervisorRoleIds != null) {
			setSupervisorRoleIds(supervisorRoleIds);
		}

		String supervisorPageName = (String)attributes.get("supervisorPageName");

		if (supervisorPageName != null) {
			setSupervisorPageName(supervisorPageName);
		}

		Long closedReasonVocId = (Long)attributes.get("closedReasonVocId");

		if (closedReasonVocId != null) {
			setClosedReasonVocId(closedReasonVocId);
		}

		Boolean accountCreationEmailEnabled = (Boolean)attributes.get(
				"accountCreationEmailEnabled");

		if (accountCreationEmailEnabled != null) {
			setAccountCreationEmailEnabled(accountCreationEmailEnabled);
		}

		Boolean enableAssignment = (Boolean)attributes.get("enableAssignment");

		if (enableAssignment != null) {
			setEnableAssignment(enableAssignment);
		}

		Boolean editFeeDetails = (Boolean)attributes.get("editFeeDetails");

		if (editFeeDetails != null) {
			setEditFeeDetails(editFeeDetails);
		}

		Long scheduleModelId = (Long)attributes.get("scheduleModelId");

		if (scheduleModelId != null) {
			setScheduleModelId(scheduleModelId);
		}

		Boolean enableSingleSubmission = (Boolean)attributes.get(
				"enableSingleSubmission");

		if (enableSingleSubmission != null) {
			setEnableSingleSubmission(enableSingleSubmission);
		}

		String orientation = (String)attributes.get("orientation");

		if (orientation != null) {
			setOrientation(orientation);
		}

		Boolean showHeader = (Boolean)attributes.get("showHeader");

		if (showHeader != null) {
			setShowHeader(showHeader);
		}

		Boolean enableFirstStepProgress = (Boolean)attributes.get(
				"enableFirstStepProgress");

		if (enableFirstStepProgress != null) {
			setEnableFirstStepProgress(enableFirstStepProgress);
		}

		Long subProductTypeId = (Long)attributes.get("subProductTypeId");

		if (subProductTypeId != null) {
			setSubProductTypeId(subProductTypeId);
		}

		Long productTypeId = (Long)attributes.get("productTypeId");

		if (productTypeId != null) {
			setProductTypeId(productTypeId);
		}

		String singleSubmissionErrorMsg = (String)attributes.get(
				"singleSubmissionErrorMsg");

		if (singleSubmissionErrorMsg != null) {
			setSingleSubmissionErrorMsg(singleSubmissionErrorMsg);
		}
	}

	/**
	* Returns the primary key of this p e process.
	*
	* @return the primary key of this p e process
	*/
	@Override
	public long getPrimaryKey() {
		return _peProcess.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e process.
	*
	* @param primaryKey the primary key of this p e process
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peProcess.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e process.
	*
	* @return the uuid of this p e process
	*/
	@Override
	public java.lang.String getUuid() {
		return _peProcess.getUuid();
	}

	/**
	* Sets the uuid of this p e process.
	*
	* @param uuid the uuid of this p e process
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peProcess.setUuid(uuid);
	}

	/**
	* Returns the sp p e process ID of this p e process.
	*
	* @return the sp p e process ID of this p e process
	*/
	@Override
	public long getSpPEProcessId() {
		return _peProcess.getSpPEProcessId();
	}

	/**
	* Sets the sp p e process ID of this p e process.
	*
	* @param spPEProcessId the sp p e process ID of this p e process
	*/
	@Override
	public void setSpPEProcessId(long spPEProcessId) {
		_peProcess.setSpPEProcessId(spPEProcessId);
	}

	/**
	* Returns the group ID of this p e process.
	*
	* @return the group ID of this p e process
	*/
	@Override
	public long getGroupId() {
		return _peProcess.getGroupId();
	}

	/**
	* Sets the group ID of this p e process.
	*
	* @param groupId the group ID of this p e process
	*/
	@Override
	public void setGroupId(long groupId) {
		_peProcess.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this p e process.
	*
	* @return the company ID of this p e process
	*/
	@Override
	public long getCompanyId() {
		return _peProcess.getCompanyId();
	}

	/**
	* Sets the company ID of this p e process.
	*
	* @param companyId the company ID of this p e process
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peProcess.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this p e process.
	*
	* @return the user ID of this p e process
	*/
	@Override
	public long getUserId() {
		return _peProcess.getUserId();
	}

	/**
	* Sets the user ID of this p e process.
	*
	* @param userId the user ID of this p e process
	*/
	@Override
	public void setUserId(long userId) {
		_peProcess.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e process.
	*
	* @return the user uuid of this p e process
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcess.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e process.
	*
	* @param userUuid the user uuid of this p e process
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peProcess.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this p e process.
	*
	* @return the user name of this p e process
	*/
	@Override
	public java.lang.String getUserName() {
		return _peProcess.getUserName();
	}

	/**
	* Sets the user name of this p e process.
	*
	* @param userName the user name of this p e process
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peProcess.setUserName(userName);
	}

	/**
	* Returns the create date of this p e process.
	*
	* @return the create date of this p e process
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peProcess.getCreateDate();
	}

	/**
	* Sets the create date of this p e process.
	*
	* @param createDate the create date of this p e process
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peProcess.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e process.
	*
	* @return the modified date of this p e process
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peProcess.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e process.
	*
	* @param modifiedDate the modified date of this p e process
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peProcess.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this p e process.
	*
	* @return the name of this p e process
	*/
	@Override
	public java.lang.String getName() {
		return _peProcess.getName();
	}

	/**
	* Sets the name of this p e process.
	*
	* @param name the name of this p e process
	*/
	@Override
	public void setName(java.lang.String name) {
		_peProcess.setName(name);
	}

	/**
	* Returns the definiton of this p e process.
	*
	* @return the definiton of this p e process
	*/
	@Override
	public java.lang.String getDefiniton() {
		return _peProcess.getDefiniton();
	}

	/**
	* Sets the definiton of this p e process.
	*
	* @param definiton the definiton of this p e process
	*/
	@Override
	public void setDefiniton(java.lang.String definiton) {
		_peProcess.setDefiniton(definiton);
	}

	/**
	* Returns the entity class ID of this p e process.
	*
	* @return the entity class ID of this p e process
	*/
	@Override
	public long getEntityClassId() {
		return _peProcess.getEntityClassId();
	}

	/**
	* Sets the entity class ID of this p e process.
	*
	* @param entityClassId the entity class ID of this p e process
	*/
	@Override
	public void setEntityClassId(long entityClassId) {
		_peProcess.setEntityClassId(entityClassId);
	}

	/**
	* Returns the agent enabled of this p e process.
	*
	* @return the agent enabled of this p e process
	*/
	@Override
	public boolean getAgentEnabled() {
		return _peProcess.getAgentEnabled();
	}

	/**
	* Returns <code>true</code> if this p e process is agent enabled.
	*
	* @return <code>true</code> if this p e process is agent enabled; <code>false</code> otherwise
	*/
	@Override
	public boolean isAgentEnabled() {
		return _peProcess.isAgentEnabled();
	}

	/**
	* Sets whether this p e process is agent enabled.
	*
	* @param agentEnabled the agent enabled of this p e process
	*/
	@Override
	public void setAgentEnabled(boolean agentEnabled) {
		_peProcess.setAgentEnabled(agentEnabled);
	}

	/**
	* Returns the agent role IDs of this p e process.
	*
	* @return the agent role IDs of this p e process
	*/
	@Override
	public java.lang.String getAgentRoleIds() {
		return _peProcess.getAgentRoleIds();
	}

	/**
	* Sets the agent role IDs of this p e process.
	*
	* @param agentRoleIds the agent role IDs of this p e process
	*/
	@Override
	public void setAgentRoleIds(java.lang.String agentRoleIds) {
		_peProcess.setAgentRoleIds(agentRoleIds);
	}

	/**
	* Returns the approve role IDs of this p e process.
	*
	* @return the approve role IDs of this p e process
	*/
	@Override
	public java.lang.String getApproveRoleIds() {
		return _peProcess.getApproveRoleIds();
	}

	/**
	* Sets the approve role IDs of this p e process.
	*
	* @param approveRoleIds the approve role IDs of this p e process
	*/
	@Override
	public void setApproveRoleIds(java.lang.String approveRoleIds) {
		_peProcess.setApproveRoleIds(approveRoleIds);
	}

	/**
	* Returns the misc data of this p e process.
	*
	* @return the misc data of this p e process
	*/
	@Override
	public java.lang.String getMiscData() {
		return _peProcess.getMiscData();
	}

	/**
	* Sets the misc data of this p e process.
	*
	* @param miscData the misc data of this p e process
	*/
	@Override
	public void setMiscData(java.lang.String miscData) {
		_peProcess.setMiscData(miscData);
	}

	/**
	* Returns the diagram data of this p e process.
	*
	* @return the diagram data of this p e process
	*/
	@Override
	public java.lang.String getDiagramData() {
		return _peProcess.getDiagramData();
	}

	/**
	* Sets the diagram data of this p e process.
	*
	* @param diagramData the diagram data of this p e process
	*/
	@Override
	public void setDiagramData(java.lang.String diagramData) {
		_peProcess.setDiagramData(diagramData);
	}

	/**
	* Returns the entity title of this p e process.
	*
	* @return the entity title of this p e process
	*/
	@Override
	public java.lang.String getEntityTitle() {
		return _peProcess.getEntityTitle();
	}

	/**
	* Sets the entity title of this p e process.
	*
	* @param entityTitle the entity title of this p e process
	*/
	@Override
	public void setEntityTitle(java.lang.String entityTitle) {
		_peProcess.setEntityTitle(entityTitle);
	}

	/**
	* Returns the approver page name of this p e process.
	*
	* @return the approver page name of this p e process
	*/
	@Override
	public java.lang.String getApproverPageName() {
		return _peProcess.getApproverPageName();
	}

	/**
	* Sets the approver page name of this p e process.
	*
	* @param approverPageName the approver page name of this p e process
	*/
	@Override
	public void setApproverPageName(java.lang.String approverPageName) {
		_peProcess.setApproverPageName(approverPageName);
	}

	/**
	* Returns the user page name of this p e process.
	*
	* @return the user page name of this p e process
	*/
	@Override
	public java.lang.String getUserPageName() {
		return _peProcess.getUserPageName();
	}

	/**
	* Sets the user page name of this p e process.
	*
	* @param userPageName the user page name of this p e process
	*/
	@Override
	public void setUserPageName(java.lang.String userPageName) {
		_peProcess.setUserPageName(userPageName);
	}

	/**
	* Returns the agent page name of this p e process.
	*
	* @return the agent page name of this p e process
	*/
	@Override
	public java.lang.String getAgentPageName() {
		return _peProcess.getAgentPageName();
	}

	/**
	* Sets the agent page name of this p e process.
	*
	* @param agentPageName the agent page name of this p e process
	*/
	@Override
	public void setAgentPageName(java.lang.String agentPageName) {
		_peProcess.setAgentPageName(agentPageName);
	}

	/**
	* Returns the status of this p e process.
	*
	* @return the status of this p e process
	*/
	@Override
	public int getStatus() {
		return _peProcess.getStatus();
	}

	/**
	* Sets the status of this p e process.
	*
	* @param status the status of this p e process
	*/
	@Override
	public void setStatus(int status) {
		_peProcess.setStatus(status);
	}

	/**
	* Returns the applicant role ID of this p e process.
	*
	* @return the applicant role ID of this p e process
	*/
	@Override
	public long getApplicantRoleId() {
		return _peProcess.getApplicantRoleId();
	}

	/**
	* Sets the applicant role ID of this p e process.
	*
	* @param applicantRoleId the applicant role ID of this p e process
	*/
	@Override
	public void setApplicantRoleId(long applicantRoleId) {
		_peProcess.setApplicantRoleId(applicantRoleId);
	}

	/**
	* Returns the supervisor role IDs of this p e process.
	*
	* @return the supervisor role IDs of this p e process
	*/
	@Override
	public java.lang.String getSupervisorRoleIds() {
		return _peProcess.getSupervisorRoleIds();
	}

	/**
	* Sets the supervisor role IDs of this p e process.
	*
	* @param supervisorRoleIds the supervisor role IDs of this p e process
	*/
	@Override
	public void setSupervisorRoleIds(java.lang.String supervisorRoleIds) {
		_peProcess.setSupervisorRoleIds(supervisorRoleIds);
	}

	/**
	* Returns the supervisor page name of this p e process.
	*
	* @return the supervisor page name of this p e process
	*/
	@Override
	public java.lang.String getSupervisorPageName() {
		return _peProcess.getSupervisorPageName();
	}

	/**
	* Sets the supervisor page name of this p e process.
	*
	* @param supervisorPageName the supervisor page name of this p e process
	*/
	@Override
	public void setSupervisorPageName(java.lang.String supervisorPageName) {
		_peProcess.setSupervisorPageName(supervisorPageName);
	}

	/**
	* Returns the closed reason voc ID of this p e process.
	*
	* @return the closed reason voc ID of this p e process
	*/
	@Override
	public long getClosedReasonVocId() {
		return _peProcess.getClosedReasonVocId();
	}

	/**
	* Sets the closed reason voc ID of this p e process.
	*
	* @param closedReasonVocId the closed reason voc ID of this p e process
	*/
	@Override
	public void setClosedReasonVocId(long closedReasonVocId) {
		_peProcess.setClosedReasonVocId(closedReasonVocId);
	}

	/**
	* Returns the account creation email enabled of this p e process.
	*
	* @return the account creation email enabled of this p e process
	*/
	@Override
	public boolean getAccountCreationEmailEnabled() {
		return _peProcess.getAccountCreationEmailEnabled();
	}

	/**
	* Returns <code>true</code> if this p e process is account creation email enabled.
	*
	* @return <code>true</code> if this p e process is account creation email enabled; <code>false</code> otherwise
	*/
	@Override
	public boolean isAccountCreationEmailEnabled() {
		return _peProcess.isAccountCreationEmailEnabled();
	}

	/**
	* Sets whether this p e process is account creation email enabled.
	*
	* @param accountCreationEmailEnabled the account creation email enabled of this p e process
	*/
	@Override
	public void setAccountCreationEmailEnabled(
		boolean accountCreationEmailEnabled) {
		_peProcess.setAccountCreationEmailEnabled(accountCreationEmailEnabled);
	}

	/**
	* Returns the enable assignment of this p e process.
	*
	* @return the enable assignment of this p e process
	*/
	@Override
	public boolean getEnableAssignment() {
		return _peProcess.getEnableAssignment();
	}

	/**
	* Returns <code>true</code> if this p e process is enable assignment.
	*
	* @return <code>true</code> if this p e process is enable assignment; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnableAssignment() {
		return _peProcess.isEnableAssignment();
	}

	/**
	* Sets whether this p e process is enable assignment.
	*
	* @param enableAssignment the enable assignment of this p e process
	*/
	@Override
	public void setEnableAssignment(boolean enableAssignment) {
		_peProcess.setEnableAssignment(enableAssignment);
	}

	/**
	* Returns the edit fee details of this p e process.
	*
	* @return the edit fee details of this p e process
	*/
	@Override
	public boolean getEditFeeDetails() {
		return _peProcess.getEditFeeDetails();
	}

	/**
	* Returns <code>true</code> if this p e process is edit fee details.
	*
	* @return <code>true</code> if this p e process is edit fee details; <code>false</code> otherwise
	*/
	@Override
	public boolean isEditFeeDetails() {
		return _peProcess.isEditFeeDetails();
	}

	/**
	* Sets whether this p e process is edit fee details.
	*
	* @param editFeeDetails the edit fee details of this p e process
	*/
	@Override
	public void setEditFeeDetails(boolean editFeeDetails) {
		_peProcess.setEditFeeDetails(editFeeDetails);
	}

	/**
	* Returns the schedule model ID of this p e process.
	*
	* @return the schedule model ID of this p e process
	*/
	@Override
	public long getScheduleModelId() {
		return _peProcess.getScheduleModelId();
	}

	/**
	* Sets the schedule model ID of this p e process.
	*
	* @param scheduleModelId the schedule model ID of this p e process
	*/
	@Override
	public void setScheduleModelId(long scheduleModelId) {
		_peProcess.setScheduleModelId(scheduleModelId);
	}

	/**
	* Returns the enable single submission of this p e process.
	*
	* @return the enable single submission of this p e process
	*/
	@Override
	public boolean getEnableSingleSubmission() {
		return _peProcess.getEnableSingleSubmission();
	}

	/**
	* Returns <code>true</code> if this p e process is enable single submission.
	*
	* @return <code>true</code> if this p e process is enable single submission; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnableSingleSubmission() {
		return _peProcess.isEnableSingleSubmission();
	}

	/**
	* Sets whether this p e process is enable single submission.
	*
	* @param enableSingleSubmission the enable single submission of this p e process
	*/
	@Override
	public void setEnableSingleSubmission(boolean enableSingleSubmission) {
		_peProcess.setEnableSingleSubmission(enableSingleSubmission);
	}

	/**
	* Returns the orientation of this p e process.
	*
	* @return the orientation of this p e process
	*/
	@Override
	public java.lang.String getOrientation() {
		return _peProcess.getOrientation();
	}

	/**
	* Sets the orientation of this p e process.
	*
	* @param orientation the orientation of this p e process
	*/
	@Override
	public void setOrientation(java.lang.String orientation) {
		_peProcess.setOrientation(orientation);
	}

	/**
	* Returns the show header of this p e process.
	*
	* @return the show header of this p e process
	*/
	@Override
	public boolean getShowHeader() {
		return _peProcess.getShowHeader();
	}

	/**
	* Returns <code>true</code> if this p e process is show header.
	*
	* @return <code>true</code> if this p e process is show header; <code>false</code> otherwise
	*/
	@Override
	public boolean isShowHeader() {
		return _peProcess.isShowHeader();
	}

	/**
	* Sets whether this p e process is show header.
	*
	* @param showHeader the show header of this p e process
	*/
	@Override
	public void setShowHeader(boolean showHeader) {
		_peProcess.setShowHeader(showHeader);
	}

	/**
	* Returns the enable first step progress of this p e process.
	*
	* @return the enable first step progress of this p e process
	*/
	@Override
	public boolean getEnableFirstStepProgress() {
		return _peProcess.getEnableFirstStepProgress();
	}

	/**
	* Returns <code>true</code> if this p e process is enable first step progress.
	*
	* @return <code>true</code> if this p e process is enable first step progress; <code>false</code> otherwise
	*/
	@Override
	public boolean isEnableFirstStepProgress() {
		return _peProcess.isEnableFirstStepProgress();
	}

	/**
	* Sets whether this p e process is enable first step progress.
	*
	* @param enableFirstStepProgress the enable first step progress of this p e process
	*/
	@Override
	public void setEnableFirstStepProgress(boolean enableFirstStepProgress) {
		_peProcess.setEnableFirstStepProgress(enableFirstStepProgress);
	}

	/**
	* Returns the sub product type ID of this p e process.
	*
	* @return the sub product type ID of this p e process
	*/
	@Override
	public long getSubProductTypeId() {
		return _peProcess.getSubProductTypeId();
	}

	/**
	* Sets the sub product type ID of this p e process.
	*
	* @param subProductTypeId the sub product type ID of this p e process
	*/
	@Override
	public void setSubProductTypeId(long subProductTypeId) {
		_peProcess.setSubProductTypeId(subProductTypeId);
	}

	/**
	* Returns the product type ID of this p e process.
	*
	* @return the product type ID of this p e process
	*/
	@Override
	public long getProductTypeId() {
		return _peProcess.getProductTypeId();
	}

	/**
	* Sets the product type ID of this p e process.
	*
	* @param productTypeId the product type ID of this p e process
	*/
	@Override
	public void setProductTypeId(long productTypeId) {
		_peProcess.setProductTypeId(productTypeId);
	}

	/**
	* Returns the single submission error msg of this p e process.
	*
	* @return the single submission error msg of this p e process
	*/
	@Override
	public java.lang.String getSingleSubmissionErrorMsg() {
		return _peProcess.getSingleSubmissionErrorMsg();
	}

	/**
	* Sets the single submission error msg of this p e process.
	*
	* @param singleSubmissionErrorMsg the single submission error msg of this p e process
	*/
	@Override
	public void setSingleSubmissionErrorMsg(
		java.lang.String singleSubmissionErrorMsg) {
		_peProcess.setSingleSubmissionErrorMsg(singleSubmissionErrorMsg);
	}

	@Override
	public boolean isNew() {
		return _peProcess.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peProcess.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peProcess.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peProcess.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peProcess.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peProcess.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peProcess.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peProcess.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peProcess.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peProcess.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peProcess.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PEProcessWrapper((PEProcess)_peProcess.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PEProcess peProcess) {
		return _peProcess.compareTo(peProcess);
	}

	@Override
	public int hashCode() {
		return _peProcess.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PEProcess> toCacheModel() {
		return _peProcess.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcess toEscapedModel() {
		return new PEProcessWrapper(_peProcess.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcess toUnescapedModel() {
		return new PEProcessWrapper(_peProcess.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peProcess.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peProcess.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peProcess.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PEProcessWrapper)) {
			return false;
		}

		PEProcessWrapper peProcessWrapper = (PEProcessWrapper)obj;

		if (Validator.equals(_peProcess, peProcessWrapper._peProcess)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peProcess.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PEProcess getWrappedPEProcess() {
		return _peProcess;
	}

	@Override
	public PEProcess getWrappedModel() {
		return _peProcess;
	}

	@Override
	public void resetOriginalValues() {
		_peProcess.resetOriginalValues();
	}

	private PEProcess _peProcess;
}