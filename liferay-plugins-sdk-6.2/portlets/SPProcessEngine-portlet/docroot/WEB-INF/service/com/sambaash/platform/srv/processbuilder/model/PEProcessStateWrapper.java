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
 * This class is a wrapper for {@link PEProcessState}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessState
 * @generated
 */
public class PEProcessStateWrapper implements PEProcessState,
	ModelWrapper<PEProcessState> {
	public PEProcessStateWrapper(PEProcessState peProcessState) {
		_peProcessState = peProcessState;
	}

	@Override
	public Class<?> getModelClass() {
		return PEProcessState.class;
	}

	@Override
	public String getModelClassName() {
		return PEProcessState.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEProcessStateId", getSpPEProcessStateId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessId", getSpPEProcessId());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("entityId", getEntityId());
		attributes.put("userIdProcess", getUserIdProcess());
		attributes.put("userIdCreator", getUserIdCreator());
		attributes.put("statusTypeId", getStatusTypeId());
		attributes.put("spPEProcessStageId", getSpPEProcessStageId());
		attributes.put("status", getStatus());
		attributes.put("nodeId", getNodeId());
		attributes.put("nodeIdLastProcessed", getNodeIdLastProcessed());
		attributes.put("nodeIdLastDisplayed", getNodeIdLastDisplayed());
		attributes.put("nodeIdLastDataSubmitted", getNodeIdLastDataSubmitted());
		attributes.put("data", getData());
		attributes.put("lastErrorCode", getLastErrorCode());
		attributes.put("lastErrorMsg", getLastErrorMsg());
		attributes.put("lastErrorDate", getLastErrorDate());
		attributes.put("currentStatusTypeApprovers",
			getCurrentStatusTypeApprovers());
		attributes.put("currentNodeSubmitters", getCurrentNodeSubmitters());
		attributes.put("lock", getLock());
		attributes.put("lockDate", getLockDate());
		attributes.put("userIdSupervisor", getUserIdSupervisor());
		attributes.put("userIdAgent", getUserIdAgent());
		attributes.put("closedStageId", getClosedStageId());
		attributes.put("closedDate", getClosedDate());
		attributes.put("closedReasonCatId", getClosedReasonCatId());
		attributes.put("closedDescription", getClosedDescription());
		attributes.put("convertedFromProcessStateId",
			getConvertedFromProcessStateId());
		attributes.put("convertedToProcessStateId",
			getConvertedToProcessStateId());
		attributes.put("activeStatus", getActiveStatus());
		attributes.put("amount", getAmount());
		attributes.put("sourceClassId", getSourceClassId());
		attributes.put("sourceEntityID", getSourceEntityID());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEProcessStateId = (Long)attributes.get("spPEProcessStateId");

		if (spPEProcessStateId != null) {
			setSpPEProcessStateId(spPEProcessStateId);
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

		Long spPEProcessId = (Long)attributes.get("spPEProcessId");

		if (spPEProcessId != null) {
			setSpPEProcessId(spPEProcessId);
		}

		Long entityClassId = (Long)attributes.get("entityClassId");

		if (entityClassId != null) {
			setEntityClassId(entityClassId);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long userIdProcess = (Long)attributes.get("userIdProcess");

		if (userIdProcess != null) {
			setUserIdProcess(userIdProcess);
		}

		Long userIdCreator = (Long)attributes.get("userIdCreator");

		if (userIdCreator != null) {
			setUserIdCreator(userIdCreator);
		}

		Long statusTypeId = (Long)attributes.get("statusTypeId");

		if (statusTypeId != null) {
			setStatusTypeId(statusTypeId);
		}

		Long spPEProcessStageId = (Long)attributes.get("spPEProcessStageId");

		if (spPEProcessStageId != null) {
			setSpPEProcessStageId(spPEProcessStageId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long nodeId = (Long)attributes.get("nodeId");

		if (nodeId != null) {
			setNodeId(nodeId);
		}

		Long nodeIdLastProcessed = (Long)attributes.get("nodeIdLastProcessed");

		if (nodeIdLastProcessed != null) {
			setNodeIdLastProcessed(nodeIdLastProcessed);
		}

		Long nodeIdLastDisplayed = (Long)attributes.get("nodeIdLastDisplayed");

		if (nodeIdLastDisplayed != null) {
			setNodeIdLastDisplayed(nodeIdLastDisplayed);
		}

		Long nodeIdLastDataSubmitted = (Long)attributes.get(
				"nodeIdLastDataSubmitted");

		if (nodeIdLastDataSubmitted != null) {
			setNodeIdLastDataSubmitted(nodeIdLastDataSubmitted);
		}

		String data = (String)attributes.get("data");

		if (data != null) {
			setData(data);
		}

		Long lastErrorCode = (Long)attributes.get("lastErrorCode");

		if (lastErrorCode != null) {
			setLastErrorCode(lastErrorCode);
		}

		String lastErrorMsg = (String)attributes.get("lastErrorMsg");

		if (lastErrorMsg != null) {
			setLastErrorMsg(lastErrorMsg);
		}

		Date lastErrorDate = (Date)attributes.get("lastErrorDate");

		if (lastErrorDate != null) {
			setLastErrorDate(lastErrorDate);
		}

		String currentStatusTypeApprovers = (String)attributes.get(
				"currentStatusTypeApprovers");

		if (currentStatusTypeApprovers != null) {
			setCurrentStatusTypeApprovers(currentStatusTypeApprovers);
		}

		String currentNodeSubmitters = (String)attributes.get(
				"currentNodeSubmitters");

		if (currentNodeSubmitters != null) {
			setCurrentNodeSubmitters(currentNodeSubmitters);
		}

		Integer lock = (Integer)attributes.get("lock");

		if (lock != null) {
			setLock(lock);
		}

		Date lockDate = (Date)attributes.get("lockDate");

		if (lockDate != null) {
			setLockDate(lockDate);
		}

		Long userIdSupervisor = (Long)attributes.get("userIdSupervisor");

		if (userIdSupervisor != null) {
			setUserIdSupervisor(userIdSupervisor);
		}

		Long userIdAgent = (Long)attributes.get("userIdAgent");

		if (userIdAgent != null) {
			setUserIdAgent(userIdAgent);
		}

		Long closedStageId = (Long)attributes.get("closedStageId");

		if (closedStageId != null) {
			setClosedStageId(closedStageId);
		}

		Date closedDate = (Date)attributes.get("closedDate");

		if (closedDate != null) {
			setClosedDate(closedDate);
		}

		Long closedReasonCatId = (Long)attributes.get("closedReasonCatId");

		if (closedReasonCatId != null) {
			setClosedReasonCatId(closedReasonCatId);
		}

		String closedDescription = (String)attributes.get("closedDescription");

		if (closedDescription != null) {
			setClosedDescription(closedDescription);
		}

		Long convertedFromProcessStateId = (Long)attributes.get(
				"convertedFromProcessStateId");

		if (convertedFromProcessStateId != null) {
			setConvertedFromProcessStateId(convertedFromProcessStateId);
		}

		Long convertedToProcessStateId = (Long)attributes.get(
				"convertedToProcessStateId");

		if (convertedToProcessStateId != null) {
			setConvertedToProcessStateId(convertedToProcessStateId);
		}

		Integer activeStatus = (Integer)attributes.get("activeStatus");

		if (activeStatus != null) {
			setActiveStatus(activeStatus);
		}

		String amount = (String)attributes.get("amount");

		if (amount != null) {
			setAmount(amount);
		}

		Long sourceClassId = (Long)attributes.get("sourceClassId");

		if (sourceClassId != null) {
			setSourceClassId(sourceClassId);
		}

		Long sourceEntityID = (Long)attributes.get("sourceEntityID");

		if (sourceEntityID != null) {
			setSourceEntityID(sourceEntityID);
		}
	}

	/**
	* Returns the primary key of this p e process state.
	*
	* @return the primary key of this p e process state
	*/
	@Override
	public long getPrimaryKey() {
		return _peProcessState.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e process state.
	*
	* @param primaryKey the primary key of this p e process state
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peProcessState.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e process state.
	*
	* @return the uuid of this p e process state
	*/
	@Override
	public java.lang.String getUuid() {
		return _peProcessState.getUuid();
	}

	/**
	* Sets the uuid of this p e process state.
	*
	* @param uuid the uuid of this p e process state
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peProcessState.setUuid(uuid);
	}

	/**
	* Returns the sp p e process state ID of this p e process state.
	*
	* @return the sp p e process state ID of this p e process state
	*/
	@Override
	public long getSpPEProcessStateId() {
		return _peProcessState.getSpPEProcessStateId();
	}

	/**
	* Sets the sp p e process state ID of this p e process state.
	*
	* @param spPEProcessStateId the sp p e process state ID of this p e process state
	*/
	@Override
	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_peProcessState.setSpPEProcessStateId(spPEProcessStateId);
	}

	/**
	* Returns the group ID of this p e process state.
	*
	* @return the group ID of this p e process state
	*/
	@Override
	public long getGroupId() {
		return _peProcessState.getGroupId();
	}

	/**
	* Sets the group ID of this p e process state.
	*
	* @param groupId the group ID of this p e process state
	*/
	@Override
	public void setGroupId(long groupId) {
		_peProcessState.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this p e process state.
	*
	* @return the company ID of this p e process state
	*/
	@Override
	public long getCompanyId() {
		return _peProcessState.getCompanyId();
	}

	/**
	* Sets the company ID of this p e process state.
	*
	* @param companyId the company ID of this p e process state
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peProcessState.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this p e process state.
	*
	* @return the user ID of this p e process state
	*/
	@Override
	public long getUserId() {
		return _peProcessState.getUserId();
	}

	/**
	* Sets the user ID of this p e process state.
	*
	* @param userId the user ID of this p e process state
	*/
	@Override
	public void setUserId(long userId) {
		_peProcessState.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e process state.
	*
	* @return the user uuid of this p e process state
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessState.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e process state.
	*
	* @param userUuid the user uuid of this p e process state
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peProcessState.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this p e process state.
	*
	* @return the user name of this p e process state
	*/
	@Override
	public java.lang.String getUserName() {
		return _peProcessState.getUserName();
	}

	/**
	* Sets the user name of this p e process state.
	*
	* @param userName the user name of this p e process state
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peProcessState.setUserName(userName);
	}

	/**
	* Returns the create date of this p e process state.
	*
	* @return the create date of this p e process state
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peProcessState.getCreateDate();
	}

	/**
	* Sets the create date of this p e process state.
	*
	* @param createDate the create date of this p e process state
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peProcessState.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e process state.
	*
	* @return the modified date of this p e process state
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peProcessState.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e process state.
	*
	* @param modifiedDate the modified date of this p e process state
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peProcessState.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp p e process ID of this p e process state.
	*
	* @return the sp p e process ID of this p e process state
	*/
	@Override
	public long getSpPEProcessId() {
		return _peProcessState.getSpPEProcessId();
	}

	/**
	* Sets the sp p e process ID of this p e process state.
	*
	* @param spPEProcessId the sp p e process ID of this p e process state
	*/
	@Override
	public void setSpPEProcessId(long spPEProcessId) {
		_peProcessState.setSpPEProcessId(spPEProcessId);
	}

	/**
	* Returns the entity class ID of this p e process state.
	*
	* @return the entity class ID of this p e process state
	*/
	@Override
	public long getEntityClassId() {
		return _peProcessState.getEntityClassId();
	}

	/**
	* Sets the entity class ID of this p e process state.
	*
	* @param entityClassId the entity class ID of this p e process state
	*/
	@Override
	public void setEntityClassId(long entityClassId) {
		_peProcessState.setEntityClassId(entityClassId);
	}

	/**
	* Returns the entity ID of this p e process state.
	*
	* @return the entity ID of this p e process state
	*/
	@Override
	public long getEntityId() {
		return _peProcessState.getEntityId();
	}

	/**
	* Sets the entity ID of this p e process state.
	*
	* @param entityId the entity ID of this p e process state
	*/
	@Override
	public void setEntityId(long entityId) {
		_peProcessState.setEntityId(entityId);
	}

	/**
	* Returns the user ID process of this p e process state.
	*
	* @return the user ID process of this p e process state
	*/
	@Override
	public long getUserIdProcess() {
		return _peProcessState.getUserIdProcess();
	}

	/**
	* Sets the user ID process of this p e process state.
	*
	* @param userIdProcess the user ID process of this p e process state
	*/
	@Override
	public void setUserIdProcess(long userIdProcess) {
		_peProcessState.setUserIdProcess(userIdProcess);
	}

	/**
	* Returns the user ID creator of this p e process state.
	*
	* @return the user ID creator of this p e process state
	*/
	@Override
	public long getUserIdCreator() {
		return _peProcessState.getUserIdCreator();
	}

	/**
	* Sets the user ID creator of this p e process state.
	*
	* @param userIdCreator the user ID creator of this p e process state
	*/
	@Override
	public void setUserIdCreator(long userIdCreator) {
		_peProcessState.setUserIdCreator(userIdCreator);
	}

	/**
	* Returns the status type ID of this p e process state.
	*
	* @return the status type ID of this p e process state
	*/
	@Override
	public long getStatusTypeId() {
		return _peProcessState.getStatusTypeId();
	}

	/**
	* Sets the status type ID of this p e process state.
	*
	* @param statusTypeId the status type ID of this p e process state
	*/
	@Override
	public void setStatusTypeId(long statusTypeId) {
		_peProcessState.setStatusTypeId(statusTypeId);
	}

	/**
	* Returns the sp p e process stage ID of this p e process state.
	*
	* @return the sp p e process stage ID of this p e process state
	*/
	@Override
	public long getSpPEProcessStageId() {
		return _peProcessState.getSpPEProcessStageId();
	}

	/**
	* Sets the sp p e process stage ID of this p e process state.
	*
	* @param spPEProcessStageId the sp p e process stage ID of this p e process state
	*/
	@Override
	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_peProcessState.setSpPEProcessStageId(spPEProcessStageId);
	}

	/**
	* Returns the status of this p e process state.
	*
	* @return the status of this p e process state
	*/
	@Override
	public java.lang.String getStatus() {
		return _peProcessState.getStatus();
	}

	/**
	* Sets the status of this p e process state.
	*
	* @param status the status of this p e process state
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_peProcessState.setStatus(status);
	}

	/**
	* Returns the node ID of this p e process state.
	*
	* @return the node ID of this p e process state
	*/
	@Override
	public long getNodeId() {
		return _peProcessState.getNodeId();
	}

	/**
	* Sets the node ID of this p e process state.
	*
	* @param nodeId the node ID of this p e process state
	*/
	@Override
	public void setNodeId(long nodeId) {
		_peProcessState.setNodeId(nodeId);
	}

	/**
	* Returns the node ID last processed of this p e process state.
	*
	* @return the node ID last processed of this p e process state
	*/
	@Override
	public long getNodeIdLastProcessed() {
		return _peProcessState.getNodeIdLastProcessed();
	}

	/**
	* Sets the node ID last processed of this p e process state.
	*
	* @param nodeIdLastProcessed the node ID last processed of this p e process state
	*/
	@Override
	public void setNodeIdLastProcessed(long nodeIdLastProcessed) {
		_peProcessState.setNodeIdLastProcessed(nodeIdLastProcessed);
	}

	/**
	* Returns the node ID last displayed of this p e process state.
	*
	* @return the node ID last displayed of this p e process state
	*/
	@Override
	public long getNodeIdLastDisplayed() {
		return _peProcessState.getNodeIdLastDisplayed();
	}

	/**
	* Sets the node ID last displayed of this p e process state.
	*
	* @param nodeIdLastDisplayed the node ID last displayed of this p e process state
	*/
	@Override
	public void setNodeIdLastDisplayed(long nodeIdLastDisplayed) {
		_peProcessState.setNodeIdLastDisplayed(nodeIdLastDisplayed);
	}

	/**
	* Returns the node ID last data submitted of this p e process state.
	*
	* @return the node ID last data submitted of this p e process state
	*/
	@Override
	public long getNodeIdLastDataSubmitted() {
		return _peProcessState.getNodeIdLastDataSubmitted();
	}

	/**
	* Sets the node ID last data submitted of this p e process state.
	*
	* @param nodeIdLastDataSubmitted the node ID last data submitted of this p e process state
	*/
	@Override
	public void setNodeIdLastDataSubmitted(long nodeIdLastDataSubmitted) {
		_peProcessState.setNodeIdLastDataSubmitted(nodeIdLastDataSubmitted);
	}

	/**
	* Returns the data of this p e process state.
	*
	* @return the data of this p e process state
	*/
	@Override
	public java.lang.String getData() {
		return _peProcessState.getData();
	}

	/**
	* Sets the data of this p e process state.
	*
	* @param data the data of this p e process state
	*/
	@Override
	public void setData(java.lang.String data) {
		_peProcessState.setData(data);
	}

	/**
	* Returns the last error code of this p e process state.
	*
	* @return the last error code of this p e process state
	*/
	@Override
	public long getLastErrorCode() {
		return _peProcessState.getLastErrorCode();
	}

	/**
	* Sets the last error code of this p e process state.
	*
	* @param lastErrorCode the last error code of this p e process state
	*/
	@Override
	public void setLastErrorCode(long lastErrorCode) {
		_peProcessState.setLastErrorCode(lastErrorCode);
	}

	/**
	* Returns the last error msg of this p e process state.
	*
	* @return the last error msg of this p e process state
	*/
	@Override
	public java.lang.String getLastErrorMsg() {
		return _peProcessState.getLastErrorMsg();
	}

	/**
	* Sets the last error msg of this p e process state.
	*
	* @param lastErrorMsg the last error msg of this p e process state
	*/
	@Override
	public void setLastErrorMsg(java.lang.String lastErrorMsg) {
		_peProcessState.setLastErrorMsg(lastErrorMsg);
	}

	/**
	* Returns the last error date of this p e process state.
	*
	* @return the last error date of this p e process state
	*/
	@Override
	public java.util.Date getLastErrorDate() {
		return _peProcessState.getLastErrorDate();
	}

	/**
	* Sets the last error date of this p e process state.
	*
	* @param lastErrorDate the last error date of this p e process state
	*/
	@Override
	public void setLastErrorDate(java.util.Date lastErrorDate) {
		_peProcessState.setLastErrorDate(lastErrorDate);
	}

	/**
	* Returns the current status type approvers of this p e process state.
	*
	* @return the current status type approvers of this p e process state
	*/
	@Override
	public java.lang.String getCurrentStatusTypeApprovers() {
		return _peProcessState.getCurrentStatusTypeApprovers();
	}

	/**
	* Sets the current status type approvers of this p e process state.
	*
	* @param currentStatusTypeApprovers the current status type approvers of this p e process state
	*/
	@Override
	public void setCurrentStatusTypeApprovers(
		java.lang.String currentStatusTypeApprovers) {
		_peProcessState.setCurrentStatusTypeApprovers(currentStatusTypeApprovers);
	}

	/**
	* Returns the current node submitters of this p e process state.
	*
	* @return the current node submitters of this p e process state
	*/
	@Override
	public java.lang.String getCurrentNodeSubmitters() {
		return _peProcessState.getCurrentNodeSubmitters();
	}

	/**
	* Sets the current node submitters of this p e process state.
	*
	* @param currentNodeSubmitters the current node submitters of this p e process state
	*/
	@Override
	public void setCurrentNodeSubmitters(java.lang.String currentNodeSubmitters) {
		_peProcessState.setCurrentNodeSubmitters(currentNodeSubmitters);
	}

	/**
	* Returns the lock of this p e process state.
	*
	* @return the lock of this p e process state
	*/
	@Override
	public int getLock() {
		return _peProcessState.getLock();
	}

	/**
	* Sets the lock of this p e process state.
	*
	* @param lock the lock of this p e process state
	*/
	@Override
	public void setLock(int lock) {
		_peProcessState.setLock(lock);
	}

	/**
	* Returns the lock date of this p e process state.
	*
	* @return the lock date of this p e process state
	*/
	@Override
	public java.util.Date getLockDate() {
		return _peProcessState.getLockDate();
	}

	/**
	* Sets the lock date of this p e process state.
	*
	* @param lockDate the lock date of this p e process state
	*/
	@Override
	public void setLockDate(java.util.Date lockDate) {
		_peProcessState.setLockDate(lockDate);
	}

	/**
	* Returns the user ID supervisor of this p e process state.
	*
	* @return the user ID supervisor of this p e process state
	*/
	@Override
	public long getUserIdSupervisor() {
		return _peProcessState.getUserIdSupervisor();
	}

	/**
	* Sets the user ID supervisor of this p e process state.
	*
	* @param userIdSupervisor the user ID supervisor of this p e process state
	*/
	@Override
	public void setUserIdSupervisor(long userIdSupervisor) {
		_peProcessState.setUserIdSupervisor(userIdSupervisor);
	}

	/**
	* Returns the user ID agent of this p e process state.
	*
	* @return the user ID agent of this p e process state
	*/
	@Override
	public long getUserIdAgent() {
		return _peProcessState.getUserIdAgent();
	}

	/**
	* Sets the user ID agent of this p e process state.
	*
	* @param userIdAgent the user ID agent of this p e process state
	*/
	@Override
	public void setUserIdAgent(long userIdAgent) {
		_peProcessState.setUserIdAgent(userIdAgent);
	}

	/**
	* Returns the closed stage ID of this p e process state.
	*
	* @return the closed stage ID of this p e process state
	*/
	@Override
	public long getClosedStageId() {
		return _peProcessState.getClosedStageId();
	}

	/**
	* Sets the closed stage ID of this p e process state.
	*
	* @param closedStageId the closed stage ID of this p e process state
	*/
	@Override
	public void setClosedStageId(long closedStageId) {
		_peProcessState.setClosedStageId(closedStageId);
	}

	/**
	* Returns the closed date of this p e process state.
	*
	* @return the closed date of this p e process state
	*/
	@Override
	public java.util.Date getClosedDate() {
		return _peProcessState.getClosedDate();
	}

	/**
	* Sets the closed date of this p e process state.
	*
	* @param closedDate the closed date of this p e process state
	*/
	@Override
	public void setClosedDate(java.util.Date closedDate) {
		_peProcessState.setClosedDate(closedDate);
	}

	/**
	* Returns the closed reason cat ID of this p e process state.
	*
	* @return the closed reason cat ID of this p e process state
	*/
	@Override
	public long getClosedReasonCatId() {
		return _peProcessState.getClosedReasonCatId();
	}

	/**
	* Sets the closed reason cat ID of this p e process state.
	*
	* @param closedReasonCatId the closed reason cat ID of this p e process state
	*/
	@Override
	public void setClosedReasonCatId(long closedReasonCatId) {
		_peProcessState.setClosedReasonCatId(closedReasonCatId);
	}

	/**
	* Returns the closed description of this p e process state.
	*
	* @return the closed description of this p e process state
	*/
	@Override
	public java.lang.String getClosedDescription() {
		return _peProcessState.getClosedDescription();
	}

	/**
	* Sets the closed description of this p e process state.
	*
	* @param closedDescription the closed description of this p e process state
	*/
	@Override
	public void setClosedDescription(java.lang.String closedDescription) {
		_peProcessState.setClosedDescription(closedDescription);
	}

	/**
	* Returns the converted from process state ID of this p e process state.
	*
	* @return the converted from process state ID of this p e process state
	*/
	@Override
	public long getConvertedFromProcessStateId() {
		return _peProcessState.getConvertedFromProcessStateId();
	}

	/**
	* Sets the converted from process state ID of this p e process state.
	*
	* @param convertedFromProcessStateId the converted from process state ID of this p e process state
	*/
	@Override
	public void setConvertedFromProcessStateId(long convertedFromProcessStateId) {
		_peProcessState.setConvertedFromProcessStateId(convertedFromProcessStateId);
	}

	/**
	* Returns the converted to process state ID of this p e process state.
	*
	* @return the converted to process state ID of this p e process state
	*/
	@Override
	public long getConvertedToProcessStateId() {
		return _peProcessState.getConvertedToProcessStateId();
	}

	/**
	* Sets the converted to process state ID of this p e process state.
	*
	* @param convertedToProcessStateId the converted to process state ID of this p e process state
	*/
	@Override
	public void setConvertedToProcessStateId(long convertedToProcessStateId) {
		_peProcessState.setConvertedToProcessStateId(convertedToProcessStateId);
	}

	/**
	* Returns the active status of this p e process state.
	*
	* @return the active status of this p e process state
	*/
	@Override
	public int getActiveStatus() {
		return _peProcessState.getActiveStatus();
	}

	/**
	* Sets the active status of this p e process state.
	*
	* @param activeStatus the active status of this p e process state
	*/
	@Override
	public void setActiveStatus(int activeStatus) {
		_peProcessState.setActiveStatus(activeStatus);
	}

	/**
	* Returns the amount of this p e process state.
	*
	* @return the amount of this p e process state
	*/
	@Override
	public java.lang.String getAmount() {
		return _peProcessState.getAmount();
	}

	/**
	* Sets the amount of this p e process state.
	*
	* @param amount the amount of this p e process state
	*/
	@Override
	public void setAmount(java.lang.String amount) {
		_peProcessState.setAmount(amount);
	}

	/**
	* Returns the source class ID of this p e process state.
	*
	* @return the source class ID of this p e process state
	*/
	@Override
	public long getSourceClassId() {
		return _peProcessState.getSourceClassId();
	}

	/**
	* Sets the source class ID of this p e process state.
	*
	* @param sourceClassId the source class ID of this p e process state
	*/
	@Override
	public void setSourceClassId(long sourceClassId) {
		_peProcessState.setSourceClassId(sourceClassId);
	}

	/**
	* Returns the source entity i d of this p e process state.
	*
	* @return the source entity i d of this p e process state
	*/
	@Override
	public long getSourceEntityID() {
		return _peProcessState.getSourceEntityID();
	}

	/**
	* Sets the source entity i d of this p e process state.
	*
	* @param sourceEntityID the source entity i d of this p e process state
	*/
	@Override
	public void setSourceEntityID(long sourceEntityID) {
		_peProcessState.setSourceEntityID(sourceEntityID);
	}

	@Override
	public boolean isNew() {
		return _peProcessState.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peProcessState.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peProcessState.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peProcessState.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peProcessState.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peProcessState.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peProcessState.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peProcessState.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peProcessState.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peProcessState.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peProcessState.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PEProcessStateWrapper((PEProcessState)_peProcessState.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PEProcessState peProcessState) {
		return _peProcessState.compareTo(peProcessState);
	}

	@Override
	public int hashCode() {
		return _peProcessState.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PEProcessState> toCacheModel() {
		return _peProcessState.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState toEscapedModel() {
		return new PEProcessStateWrapper(_peProcessState.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessState toUnescapedModel() {
		return new PEProcessStateWrapper(_peProcessState.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peProcessState.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peProcessState.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peProcessState.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PEProcessStateWrapper)) {
			return false;
		}

		PEProcessStateWrapper peProcessStateWrapper = (PEProcessStateWrapper)obj;

		if (Validator.equals(_peProcessState,
					peProcessStateWrapper._peProcessState)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peProcessState.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PEProcessState getWrappedPEProcessState() {
		return _peProcessState;
	}

	@Override
	public PEProcessState getWrappedModel() {
		return _peProcessState;
	}

	@Override
	public void resetOriginalValues() {
		_peProcessState.resetOriginalValues();
	}

	private PEProcessState _peProcessState;
}