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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.processbuilder.service.ClpSerializer;
import com.sambaash.platform.srv.processbuilder.service.PEProcessStateLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class PEProcessStateClp extends BaseModelImpl<PEProcessState>
	implements PEProcessState {
	public PEProcessStateClp() {
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
	public long getPrimaryKey() {
		return _spPEProcessStateId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPEProcessStateId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPEProcessStateId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_peProcessStateRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessStateId() {
		return _spPEProcessStateId;
	}

	@Override
	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_spPEProcessStateId = spPEProcessStateId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStateId",
						long.class);

				method.invoke(_peProcessStateRemoteModel, spPEProcessStateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_peProcessStateRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_peProcessStateRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_peProcessStateRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_peProcessStateRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_peProcessStateRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_peProcessStateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessId() {
		return _spPEProcessId;
	}

	@Override
	public void setSpPEProcessId(long spPEProcessId) {
		_spPEProcessId = spPEProcessId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessId", long.class);

				method.invoke(_peProcessStateRemoteModel, spPEProcessId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityClassId() {
		return _entityClassId;
	}

	@Override
	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassId", long.class);

				method.invoke(_peProcessStateRemoteModel, entityClassId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		_entityId = entityId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityId", long.class);

				method.invoke(_peProcessStateRemoteModel, entityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserIdProcess() {
		return _userIdProcess;
	}

	@Override
	public void setUserIdProcess(long userIdProcess) {
		_userIdProcess = userIdProcess;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdProcess", long.class);

				method.invoke(_peProcessStateRemoteModel, userIdProcess);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserIdCreator() {
		return _userIdCreator;
	}

	@Override
	public void setUserIdCreator(long userIdCreator) {
		_userIdCreator = userIdCreator;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdCreator", long.class);

				method.invoke(_peProcessStateRemoteModel, userIdCreator);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusTypeId() {
		return _statusTypeId;
	}

	@Override
	public void setStatusTypeId(long statusTypeId) {
		_statusTypeId = statusTypeId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusTypeId", long.class);

				method.invoke(_peProcessStateRemoteModel, statusTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessStageId() {
		return _spPEProcessStageId;
	}

	@Override
	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_spPEProcessStageId = spPEProcessStageId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStageId",
						long.class);

				method.invoke(_peProcessStateRemoteModel, spPEProcessStageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_peProcessStateRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNodeId() {
		return _nodeId;
	}

	@Override
	public void setNodeId(long nodeId) {
		_nodeId = nodeId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setNodeId", long.class);

				method.invoke(_peProcessStateRemoteModel, nodeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNodeIdLastProcessed() {
		return _nodeIdLastProcessed;
	}

	@Override
	public void setNodeIdLastProcessed(long nodeIdLastProcessed) {
		_nodeIdLastProcessed = nodeIdLastProcessed;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setNodeIdLastProcessed",
						long.class);

				method.invoke(_peProcessStateRemoteModel, nodeIdLastProcessed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNodeIdLastDisplayed() {
		return _nodeIdLastDisplayed;
	}

	@Override
	public void setNodeIdLastDisplayed(long nodeIdLastDisplayed) {
		_nodeIdLastDisplayed = nodeIdLastDisplayed;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setNodeIdLastDisplayed",
						long.class);

				method.invoke(_peProcessStateRemoteModel, nodeIdLastDisplayed);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNodeIdLastDataSubmitted() {
		return _nodeIdLastDataSubmitted;
	}

	@Override
	public void setNodeIdLastDataSubmitted(long nodeIdLastDataSubmitted) {
		_nodeIdLastDataSubmitted = nodeIdLastDataSubmitted;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setNodeIdLastDataSubmitted",
						long.class);

				method.invoke(_peProcessStateRemoteModel,
					nodeIdLastDataSubmitted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getData() {
		return _data;
	}

	@Override
	public void setData(String data) {
		_data = data;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setData", String.class);

				method.invoke(_peProcessStateRemoteModel, data);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLastErrorCode() {
		return _lastErrorCode;
	}

	@Override
	public void setLastErrorCode(long lastErrorCode) {
		_lastErrorCode = lastErrorCode;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setLastErrorCode", long.class);

				method.invoke(_peProcessStateRemoteModel, lastErrorCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastErrorMsg() {
		return _lastErrorMsg;
	}

	@Override
	public void setLastErrorMsg(String lastErrorMsg) {
		_lastErrorMsg = lastErrorMsg;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setLastErrorMsg", String.class);

				method.invoke(_peProcessStateRemoteModel, lastErrorMsg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLastErrorDate() {
		return _lastErrorDate;
	}

	@Override
	public void setLastErrorDate(Date lastErrorDate) {
		_lastErrorDate = lastErrorDate;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setLastErrorDate", Date.class);

				method.invoke(_peProcessStateRemoteModel, lastErrorDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentStatusTypeApprovers() {
		return _currentStatusTypeApprovers;
	}

	@Override
	public void setCurrentStatusTypeApprovers(String currentStatusTypeApprovers) {
		_currentStatusTypeApprovers = currentStatusTypeApprovers;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentStatusTypeApprovers",
						String.class);

				method.invoke(_peProcessStateRemoteModel,
					currentStatusTypeApprovers);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentNodeSubmitters() {
		return _currentNodeSubmitters;
	}

	@Override
	public void setCurrentNodeSubmitters(String currentNodeSubmitters) {
		_currentNodeSubmitters = currentNodeSubmitters;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentNodeSubmitters",
						String.class);

				method.invoke(_peProcessStateRemoteModel, currentNodeSubmitters);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLock() {
		return _lock;
	}

	@Override
	public void setLock(int lock) {
		_lock = lock;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setLock", int.class);

				method.invoke(_peProcessStateRemoteModel, lock);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getLockDate() {
		return _lockDate;
	}

	@Override
	public void setLockDate(Date lockDate) {
		_lockDate = lockDate;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setLockDate", Date.class);

				method.invoke(_peProcessStateRemoteModel, lockDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserIdSupervisor() {
		return _userIdSupervisor;
	}

	@Override
	public void setUserIdSupervisor(long userIdSupervisor) {
		_userIdSupervisor = userIdSupervisor;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdSupervisor",
						long.class);

				method.invoke(_peProcessStateRemoteModel, userIdSupervisor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserIdAgent() {
		return _userIdAgent;
	}

	@Override
	public void setUserIdAgent(long userIdAgent) {
		_userIdAgent = userIdAgent;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdAgent", long.class);

				method.invoke(_peProcessStateRemoteModel, userIdAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClosedStageId() {
		return _closedStageId;
	}

	@Override
	public void setClosedStageId(long closedStageId) {
		_closedStageId = closedStageId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setClosedStageId", long.class);

				method.invoke(_peProcessStateRemoteModel, closedStageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getClosedDate() {
		return _closedDate;
	}

	@Override
	public void setClosedDate(Date closedDate) {
		_closedDate = closedDate;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setClosedDate", Date.class);

				method.invoke(_peProcessStateRemoteModel, closedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClosedReasonCatId() {
		return _closedReasonCatId;
	}

	@Override
	public void setClosedReasonCatId(long closedReasonCatId) {
		_closedReasonCatId = closedReasonCatId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setClosedReasonCatId",
						long.class);

				method.invoke(_peProcessStateRemoteModel, closedReasonCatId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getClosedDescription() {
		return _closedDescription;
	}

	@Override
	public void setClosedDescription(String closedDescription) {
		_closedDescription = closedDescription;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setClosedDescription",
						String.class);

				method.invoke(_peProcessStateRemoteModel, closedDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConvertedFromProcessStateId() {
		return _convertedFromProcessStateId;
	}

	@Override
	public void setConvertedFromProcessStateId(long convertedFromProcessStateId) {
		_convertedFromProcessStateId = convertedFromProcessStateId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setConvertedFromProcessStateId",
						long.class);

				method.invoke(_peProcessStateRemoteModel,
					convertedFromProcessStateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getConvertedToProcessStateId() {
		return _convertedToProcessStateId;
	}

	@Override
	public void setConvertedToProcessStateId(long convertedToProcessStateId) {
		_convertedToProcessStateId = convertedToProcessStateId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setConvertedToProcessStateId",
						long.class);

				method.invoke(_peProcessStateRemoteModel,
					convertedToProcessStateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getActiveStatus() {
		return _activeStatus;
	}

	@Override
	public void setActiveStatus(int activeStatus) {
		_activeStatus = activeStatus;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveStatus", int.class);

				method.invoke(_peProcessStateRemoteModel, activeStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAmount() {
		return _amount;
	}

	@Override
	public void setAmount(String amount) {
		_amount = amount;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setAmount", String.class);

				method.invoke(_peProcessStateRemoteModel, amount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSourceClassId() {
		return _sourceClassId;
	}

	@Override
	public void setSourceClassId(long sourceClassId) {
		_sourceClassId = sourceClassId;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setSourceClassId", long.class);

				method.invoke(_peProcessStateRemoteModel, sourceClassId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSourceEntityID() {
		return _sourceEntityID;
	}

	@Override
	public void setSourceEntityID(long sourceEntityID) {
		_sourceEntityID = sourceEntityID;

		if (_peProcessStateRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessStateRemoteModel.getClass();

				Method method = clazz.getMethod("setSourceEntityID", long.class);

				method.invoke(_peProcessStateRemoteModel, sourceEntityID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PEProcessState.class.getName()));
	}

	public BaseModel<?> getPEProcessStateRemoteModel() {
		return _peProcessStateRemoteModel;
	}

	public void setPEProcessStateRemoteModel(
		BaseModel<?> peProcessStateRemoteModel) {
		_peProcessStateRemoteModel = peProcessStateRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _peProcessStateRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_peProcessStateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PEProcessStateLocalServiceUtil.addPEProcessState(this);
		}
		else {
			PEProcessStateLocalServiceUtil.updatePEProcessState(this);
		}
	}

	@Override
	public PEProcessState toEscapedModel() {
		return (PEProcessState)ProxyUtil.newProxyInstance(PEProcessState.class.getClassLoader(),
			new Class[] { PEProcessState.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PEProcessStateClp clone = new PEProcessStateClp();

		clone.setUuid(getUuid());
		clone.setSpPEProcessStateId(getSpPEProcessStateId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpPEProcessId(getSpPEProcessId());
		clone.setEntityClassId(getEntityClassId());
		clone.setEntityId(getEntityId());
		clone.setUserIdProcess(getUserIdProcess());
		clone.setUserIdCreator(getUserIdCreator());
		clone.setStatusTypeId(getStatusTypeId());
		clone.setSpPEProcessStageId(getSpPEProcessStageId());
		clone.setStatus(getStatus());
		clone.setNodeId(getNodeId());
		clone.setNodeIdLastProcessed(getNodeIdLastProcessed());
		clone.setNodeIdLastDisplayed(getNodeIdLastDisplayed());
		clone.setNodeIdLastDataSubmitted(getNodeIdLastDataSubmitted());
		clone.setData(getData());
		clone.setLastErrorCode(getLastErrorCode());
		clone.setLastErrorMsg(getLastErrorMsg());
		clone.setLastErrorDate(getLastErrorDate());
		clone.setCurrentStatusTypeApprovers(getCurrentStatusTypeApprovers());
		clone.setCurrentNodeSubmitters(getCurrentNodeSubmitters());
		clone.setLock(getLock());
		clone.setLockDate(getLockDate());
		clone.setUserIdSupervisor(getUserIdSupervisor());
		clone.setUserIdAgent(getUserIdAgent());
		clone.setClosedStageId(getClosedStageId());
		clone.setClosedDate(getClosedDate());
		clone.setClosedReasonCatId(getClosedReasonCatId());
		clone.setClosedDescription(getClosedDescription());
		clone.setConvertedFromProcessStateId(getConvertedFromProcessStateId());
		clone.setConvertedToProcessStateId(getConvertedToProcessStateId());
		clone.setActiveStatus(getActiveStatus());
		clone.setAmount(getAmount());
		clone.setSourceClassId(getSourceClassId());
		clone.setSourceEntityID(getSourceEntityID());

		return clone;
	}

	@Override
	public int compareTo(PEProcessState peProcessState) {
		long primaryKey = peProcessState.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PEProcessStateClp)) {
			return false;
		}

		PEProcessStateClp peProcessState = (PEProcessStateClp)obj;

		long primaryKey = peProcessState.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(81);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spPEProcessStateId=");
		sb.append(getSpPEProcessStateId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", spPEProcessId=");
		sb.append(getSpPEProcessId());
		sb.append(", entityClassId=");
		sb.append(getEntityClassId());
		sb.append(", entityId=");
		sb.append(getEntityId());
		sb.append(", userIdProcess=");
		sb.append(getUserIdProcess());
		sb.append(", userIdCreator=");
		sb.append(getUserIdCreator());
		sb.append(", statusTypeId=");
		sb.append(getStatusTypeId());
		sb.append(", spPEProcessStageId=");
		sb.append(getSpPEProcessStageId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", nodeId=");
		sb.append(getNodeId());
		sb.append(", nodeIdLastProcessed=");
		sb.append(getNodeIdLastProcessed());
		sb.append(", nodeIdLastDisplayed=");
		sb.append(getNodeIdLastDisplayed());
		sb.append(", nodeIdLastDataSubmitted=");
		sb.append(getNodeIdLastDataSubmitted());
		sb.append(", data=");
		sb.append(getData());
		sb.append(", lastErrorCode=");
		sb.append(getLastErrorCode());
		sb.append(", lastErrorMsg=");
		sb.append(getLastErrorMsg());
		sb.append(", lastErrorDate=");
		sb.append(getLastErrorDate());
		sb.append(", currentStatusTypeApprovers=");
		sb.append(getCurrentStatusTypeApprovers());
		sb.append(", currentNodeSubmitters=");
		sb.append(getCurrentNodeSubmitters());
		sb.append(", lock=");
		sb.append(getLock());
		sb.append(", lockDate=");
		sb.append(getLockDate());
		sb.append(", userIdSupervisor=");
		sb.append(getUserIdSupervisor());
		sb.append(", userIdAgent=");
		sb.append(getUserIdAgent());
		sb.append(", closedStageId=");
		sb.append(getClosedStageId());
		sb.append(", closedDate=");
		sb.append(getClosedDate());
		sb.append(", closedReasonCatId=");
		sb.append(getClosedReasonCatId());
		sb.append(", closedDescription=");
		sb.append(getClosedDescription());
		sb.append(", convertedFromProcessStateId=");
		sb.append(getConvertedFromProcessStateId());
		sb.append(", convertedToProcessStateId=");
		sb.append(getConvertedToProcessStateId());
		sb.append(", activeStatus=");
		sb.append(getActiveStatus());
		sb.append(", amount=");
		sb.append(getAmount());
		sb.append(", sourceClassId=");
		sb.append(getSourceClassId());
		sb.append(", sourceEntityID=");
		sb.append(getSourceEntityID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(124);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.processbuilder.model.PEProcessState");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessStateId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassId</column-name><column-value><![CDATA[");
		sb.append(getEntityClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdProcess</column-name><column-value><![CDATA[");
		sb.append(getUserIdProcess());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdCreator</column-name><column-value><![CDATA[");
		sb.append(getUserIdCreator());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>statusTypeId</column-name><column-value><![CDATA[");
		sb.append(getStatusTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessStageId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nodeId</column-name><column-value><![CDATA[");
		sb.append(getNodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nodeIdLastProcessed</column-name><column-value><![CDATA[");
		sb.append(getNodeIdLastProcessed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nodeIdLastDisplayed</column-name><column-value><![CDATA[");
		sb.append(getNodeIdLastDisplayed());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nodeIdLastDataSubmitted</column-name><column-value><![CDATA[");
		sb.append(getNodeIdLastDataSubmitted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data</column-name><column-value><![CDATA[");
		sb.append(getData());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastErrorCode</column-name><column-value><![CDATA[");
		sb.append(getLastErrorCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastErrorMsg</column-name><column-value><![CDATA[");
		sb.append(getLastErrorMsg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastErrorDate</column-name><column-value><![CDATA[");
		sb.append(getLastErrorDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentStatusTypeApprovers</column-name><column-value><![CDATA[");
		sb.append(getCurrentStatusTypeApprovers());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentNodeSubmitters</column-name><column-value><![CDATA[");
		sb.append(getCurrentNodeSubmitters());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lock</column-name><column-value><![CDATA[");
		sb.append(getLock());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lockDate</column-name><column-value><![CDATA[");
		sb.append(getLockDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdSupervisor</column-name><column-value><![CDATA[");
		sb.append(getUserIdSupervisor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userIdAgent</column-name><column-value><![CDATA[");
		sb.append(getUserIdAgent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closedStageId</column-name><column-value><![CDATA[");
		sb.append(getClosedStageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closedDate</column-name><column-value><![CDATA[");
		sb.append(getClosedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closedReasonCatId</column-name><column-value><![CDATA[");
		sb.append(getClosedReasonCatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>closedDescription</column-name><column-value><![CDATA[");
		sb.append(getClosedDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>convertedFromProcessStateId</column-name><column-value><![CDATA[");
		sb.append(getConvertedFromProcessStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>convertedToProcessStateId</column-name><column-value><![CDATA[");
		sb.append(getConvertedToProcessStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeStatus</column-name><column-value><![CDATA[");
		sb.append(getActiveStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amount</column-name><column-value><![CDATA[");
		sb.append(getAmount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sourceClassId</column-name><column-value><![CDATA[");
		sb.append(getSourceClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sourceEntityID</column-name><column-value><![CDATA[");
		sb.append(getSourceEntityID());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spPEProcessStateId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _peProcessStateRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class;
}