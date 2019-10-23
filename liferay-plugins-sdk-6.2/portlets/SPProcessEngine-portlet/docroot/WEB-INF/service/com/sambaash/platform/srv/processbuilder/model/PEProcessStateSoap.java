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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author nareshchebolu
 * @generated
 */
public class PEProcessStateSoap implements Serializable {
	public static PEProcessStateSoap toSoapModel(PEProcessState model) {
		PEProcessStateSoap soapModel = new PEProcessStateSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpPEProcessStateId(model.getSpPEProcessStateId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpPEProcessId(model.getSpPEProcessId());
		soapModel.setEntityClassId(model.getEntityClassId());
		soapModel.setEntityId(model.getEntityId());
		soapModel.setUserIdProcess(model.getUserIdProcess());
		soapModel.setUserIdCreator(model.getUserIdCreator());
		soapModel.setStatusTypeId(model.getStatusTypeId());
		soapModel.setSpPEProcessStageId(model.getSpPEProcessStageId());
		soapModel.setStatus(model.getStatus());
		soapModel.setNodeId(model.getNodeId());
		soapModel.setNodeIdLastProcessed(model.getNodeIdLastProcessed());
		soapModel.setNodeIdLastDisplayed(model.getNodeIdLastDisplayed());
		soapModel.setNodeIdLastDataSubmitted(model.getNodeIdLastDataSubmitted());
		soapModel.setData(model.getData());
		soapModel.setLastErrorCode(model.getLastErrorCode());
		soapModel.setLastErrorMsg(model.getLastErrorMsg());
		soapModel.setLastErrorDate(model.getLastErrorDate());
		soapModel.setCurrentStatusTypeApprovers(model.getCurrentStatusTypeApprovers());
		soapModel.setCurrentNodeSubmitters(model.getCurrentNodeSubmitters());
		soapModel.setLock(model.getLock());
		soapModel.setLockDate(model.getLockDate());
		soapModel.setUserIdSupervisor(model.getUserIdSupervisor());
		soapModel.setUserIdAgent(model.getUserIdAgent());
		soapModel.setClosedStageId(model.getClosedStageId());
		soapModel.setClosedDate(model.getClosedDate());
		soapModel.setClosedReasonCatId(model.getClosedReasonCatId());
		soapModel.setClosedDescription(model.getClosedDescription());
		soapModel.setConvertedFromProcessStateId(model.getConvertedFromProcessStateId());
		soapModel.setConvertedToProcessStateId(model.getConvertedToProcessStateId());
		soapModel.setActiveStatus(model.getActiveStatus());
		soapModel.setAmount(model.getAmount());
		soapModel.setSourceClassId(model.getSourceClassId());
		soapModel.setSourceEntityID(model.getSourceEntityID());

		return soapModel;
	}

	public static PEProcessStateSoap[] toSoapModels(PEProcessState[] models) {
		PEProcessStateSoap[] soapModels = new PEProcessStateSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PEProcessStateSoap[][] toSoapModels(PEProcessState[][] models) {
		PEProcessStateSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PEProcessStateSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PEProcessStateSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PEProcessStateSoap[] toSoapModels(List<PEProcessState> models) {
		List<PEProcessStateSoap> soapModels = new ArrayList<PEProcessStateSoap>(models.size());

		for (PEProcessState model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PEProcessStateSoap[soapModels.size()]);
	}

	public PEProcessStateSoap() {
	}

	public long getPrimaryKey() {
		return _spPEProcessStateId;
	}

	public void setPrimaryKey(long pk) {
		setSpPEProcessStateId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpPEProcessStateId() {
		return _spPEProcessStateId;
	}

	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_spPEProcessStateId = spPEProcessStateId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getSpPEProcessId() {
		return _spPEProcessId;
	}

	public void setSpPEProcessId(long spPEProcessId) {
		_spPEProcessId = spPEProcessId;
	}

	public long getEntityClassId() {
		return _entityClassId;
	}

	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
	}

	public long getUserIdProcess() {
		return _userIdProcess;
	}

	public void setUserIdProcess(long userIdProcess) {
		_userIdProcess = userIdProcess;
	}

	public long getUserIdCreator() {
		return _userIdCreator;
	}

	public void setUserIdCreator(long userIdCreator) {
		_userIdCreator = userIdCreator;
	}

	public long getStatusTypeId() {
		return _statusTypeId;
	}

	public void setStatusTypeId(long statusTypeId) {
		_statusTypeId = statusTypeId;
	}

	public long getSpPEProcessStageId() {
		return _spPEProcessStageId;
	}

	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_spPEProcessStageId = spPEProcessStageId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public long getNodeId() {
		return _nodeId;
	}

	public void setNodeId(long nodeId) {
		_nodeId = nodeId;
	}

	public long getNodeIdLastProcessed() {
		return _nodeIdLastProcessed;
	}

	public void setNodeIdLastProcessed(long nodeIdLastProcessed) {
		_nodeIdLastProcessed = nodeIdLastProcessed;
	}

	public long getNodeIdLastDisplayed() {
		return _nodeIdLastDisplayed;
	}

	public void setNodeIdLastDisplayed(long nodeIdLastDisplayed) {
		_nodeIdLastDisplayed = nodeIdLastDisplayed;
	}

	public long getNodeIdLastDataSubmitted() {
		return _nodeIdLastDataSubmitted;
	}

	public void setNodeIdLastDataSubmitted(long nodeIdLastDataSubmitted) {
		_nodeIdLastDataSubmitted = nodeIdLastDataSubmitted;
	}

	public String getData() {
		return _data;
	}

	public void setData(String data) {
		_data = data;
	}

	public long getLastErrorCode() {
		return _lastErrorCode;
	}

	public void setLastErrorCode(long lastErrorCode) {
		_lastErrorCode = lastErrorCode;
	}

	public String getLastErrorMsg() {
		return _lastErrorMsg;
	}

	public void setLastErrorMsg(String lastErrorMsg) {
		_lastErrorMsg = lastErrorMsg;
	}

	public Date getLastErrorDate() {
		return _lastErrorDate;
	}

	public void setLastErrorDate(Date lastErrorDate) {
		_lastErrorDate = lastErrorDate;
	}

	public String getCurrentStatusTypeApprovers() {
		return _currentStatusTypeApprovers;
	}

	public void setCurrentStatusTypeApprovers(String currentStatusTypeApprovers) {
		_currentStatusTypeApprovers = currentStatusTypeApprovers;
	}

	public String getCurrentNodeSubmitters() {
		return _currentNodeSubmitters;
	}

	public void setCurrentNodeSubmitters(String currentNodeSubmitters) {
		_currentNodeSubmitters = currentNodeSubmitters;
	}

	public int getLock() {
		return _lock;
	}

	public void setLock(int lock) {
		_lock = lock;
	}

	public Date getLockDate() {
		return _lockDate;
	}

	public void setLockDate(Date lockDate) {
		_lockDate = lockDate;
	}

	public long getUserIdSupervisor() {
		return _userIdSupervisor;
	}

	public void setUserIdSupervisor(long userIdSupervisor) {
		_userIdSupervisor = userIdSupervisor;
	}

	public long getUserIdAgent() {
		return _userIdAgent;
	}

	public void setUserIdAgent(long userIdAgent) {
		_userIdAgent = userIdAgent;
	}

	public long getClosedStageId() {
		return _closedStageId;
	}

	public void setClosedStageId(long closedStageId) {
		_closedStageId = closedStageId;
	}

	public Date getClosedDate() {
		return _closedDate;
	}

	public void setClosedDate(Date closedDate) {
		_closedDate = closedDate;
	}

	public long getClosedReasonCatId() {
		return _closedReasonCatId;
	}

	public void setClosedReasonCatId(long closedReasonCatId) {
		_closedReasonCatId = closedReasonCatId;
	}

	public String getClosedDescription() {
		return _closedDescription;
	}

	public void setClosedDescription(String closedDescription) {
		_closedDescription = closedDescription;
	}

	public long getConvertedFromProcessStateId() {
		return _convertedFromProcessStateId;
	}

	public void setConvertedFromProcessStateId(long convertedFromProcessStateId) {
		_convertedFromProcessStateId = convertedFromProcessStateId;
	}

	public long getConvertedToProcessStateId() {
		return _convertedToProcessStateId;
	}

	public void setConvertedToProcessStateId(long convertedToProcessStateId) {
		_convertedToProcessStateId = convertedToProcessStateId;
	}

	public int getActiveStatus() {
		return _activeStatus;
	}

	public void setActiveStatus(int activeStatus) {
		_activeStatus = activeStatus;
	}

	public String getAmount() {
		return _amount;
	}

	public void setAmount(String amount) {
		_amount = amount;
	}

	public long getSourceClassId() {
		return _sourceClassId;
	}

	public void setSourceClassId(long sourceClassId) {
		_sourceClassId = sourceClassId;
	}

	public long getSourceEntityID() {
		return _sourceEntityID;
	}

	public void setSourceEntityID(long sourceEntityID) {
		_sourceEntityID = sourceEntityID;
	}

	private String _uuid;
	private long _spPEProcessStateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPEProcessId;
	private long _entityClassId;
	private long _entityId;
	private long _userIdProcess;
	private long _userIdCreator;
	private long _statusTypeId;
	private long _spPEProcessStageId;
	private String _status;
	private long _nodeId;
	private long _nodeIdLastProcessed;
	private long _nodeIdLastDisplayed;
	private long _nodeIdLastDataSubmitted;
	private String _data;
	private long _lastErrorCode;
	private String _lastErrorMsg;
	private Date _lastErrorDate;
	private String _currentStatusTypeApprovers;
	private String _currentNodeSubmitters;
	private int _lock;
	private Date _lockDate;
	private long _userIdSupervisor;
	private long _userIdAgent;
	private long _closedStageId;
	private Date _closedDate;
	private long _closedReasonCatId;
	private String _closedDescription;
	private long _convertedFromProcessStateId;
	private long _convertedToProcessStateId;
	private int _activeStatus;
	private String _amount;
	private long _sourceClassId;
	private long _sourceEntityID;
}