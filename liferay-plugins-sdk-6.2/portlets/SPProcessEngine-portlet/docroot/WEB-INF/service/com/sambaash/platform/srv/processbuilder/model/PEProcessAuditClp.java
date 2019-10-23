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
import com.sambaash.platform.srv.processbuilder.service.PEProcessAuditLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class PEProcessAuditClp extends BaseModelImpl<PEProcessAudit>
	implements PEProcessAudit {
	public PEProcessAuditClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PEProcessAudit.class;
	}

	@Override
	public String getModelClassName() {
		return PEProcessAudit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPEProcessAuditId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPEProcessAuditId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPEProcessAuditId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEProcessAuditId", getSpPEProcessAuditId());
		attributes.put("groupId", getGroupId());
		attributes.put("userId", getUserId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spPEProcessStateId", getSpPEProcessStateId());
		attributes.put("spPEProcessId", getSpPEProcessId());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("entityId", getEntityId());
		attributes.put("userIdProcess", getUserIdProcess());
		attributes.put("statusTypeId", getStatusTypeId());
		attributes.put("spPEProcessStageId", getSpPEProcessStageId());
		attributes.put("nodeId", getNodeId());
		attributes.put("status", getStatus());
		attributes.put("userIdSupervisor", getUserIdSupervisor());
		attributes.put("userIdAgent", getUserIdAgent());
		attributes.put("spPEClosedStageId", getSpPEClosedStageId());
		attributes.put("type", getType());
		attributes.put("doneBy", getDoneBy());
		attributes.put("action", getAction());
		attributes.put("field1", getField1());
		attributes.put("field2", getField2());
		attributes.put("field3", getField3());
		attributes.put("field4", getField4());
		attributes.put("field5", getField5());
		attributes.put("storageId", getStorageId());
		attributes.put("data1", getData1());
		attributes.put("data2", getData2());
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

		Long spPEProcessAuditId = (Long)attributes.get("spPEProcessAuditId");

		if (spPEProcessAuditId != null) {
			setSpPEProcessAuditId(spPEProcessAuditId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long spPEProcessStateId = (Long)attributes.get("spPEProcessStateId");

		if (spPEProcessStateId != null) {
			setSpPEProcessStateId(spPEProcessStateId);
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

		Long statusTypeId = (Long)attributes.get("statusTypeId");

		if (statusTypeId != null) {
			setStatusTypeId(statusTypeId);
		}

		Long spPEProcessStageId = (Long)attributes.get("spPEProcessStageId");

		if (spPEProcessStageId != null) {
			setSpPEProcessStageId(spPEProcessStageId);
		}

		Long nodeId = (Long)attributes.get("nodeId");

		if (nodeId != null) {
			setNodeId(nodeId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long userIdSupervisor = (Long)attributes.get("userIdSupervisor");

		if (userIdSupervisor != null) {
			setUserIdSupervisor(userIdSupervisor);
		}

		Long userIdAgent = (Long)attributes.get("userIdAgent");

		if (userIdAgent != null) {
			setUserIdAgent(userIdAgent);
		}

		Long spPEClosedStageId = (Long)attributes.get("spPEClosedStageId");

		if (spPEClosedStageId != null) {
			setSpPEClosedStageId(spPEClosedStageId);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String doneBy = (String)attributes.get("doneBy");

		if (doneBy != null) {
			setDoneBy(doneBy);
		}

		String action = (String)attributes.get("action");

		if (action != null) {
			setAction(action);
		}

		String field1 = (String)attributes.get("field1");

		if (field1 != null) {
			setField1(field1);
		}

		String field2 = (String)attributes.get("field2");

		if (field2 != null) {
			setField2(field2);
		}

		String field3 = (String)attributes.get("field3");

		if (field3 != null) {
			setField3(field3);
		}

		String field4 = (String)attributes.get("field4");

		if (field4 != null) {
			setField4(field4);
		}

		Long field5 = (Long)attributes.get("field5");

		if (field5 != null) {
			setField5(field5);
		}

		Long storageId = (Long)attributes.get("storageId");

		if (storageId != null) {
			setStorageId(storageId);
		}

		String data1 = (String)attributes.get("data1");

		if (data1 != null) {
			setData1(data1);
		}

		String data2 = (String)attributes.get("data2");

		if (data2 != null) {
			setData2(data2);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_peProcessAuditRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessAuditId() {
		return _spPEProcessAuditId;
	}

	@Override
	public void setSpPEProcessAuditId(long spPEProcessAuditId) {
		_spPEProcessAuditId = spPEProcessAuditId;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessAuditId",
						long.class);

				method.invoke(_peProcessAuditRemoteModel, spPEProcessAuditId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_peProcessAuditRemoteModel, groupId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_peProcessAuditRemoteModel, userId);
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
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_peProcessAuditRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_peProcessAuditRemoteModel, userName);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_peProcessAuditRemoteModel, createDate);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_peProcessAuditRemoteModel, modifiedDate);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStateId",
						long.class);

				method.invoke(_peProcessAuditRemoteModel, spPEProcessStateId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessId", long.class);

				method.invoke(_peProcessAuditRemoteModel, spPEProcessId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassId", long.class);

				method.invoke(_peProcessAuditRemoteModel, entityClassId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityId", long.class);

				method.invoke(_peProcessAuditRemoteModel, entityId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdProcess", long.class);

				method.invoke(_peProcessAuditRemoteModel, userIdProcess);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusTypeId", long.class);

				method.invoke(_peProcessAuditRemoteModel, statusTypeId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStageId",
						long.class);

				method.invoke(_peProcessAuditRemoteModel, spPEProcessStageId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setNodeId", long.class);

				method.invoke(_peProcessAuditRemoteModel, nodeId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_peProcessAuditRemoteModel, status);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdSupervisor",
						long.class);

				method.invoke(_peProcessAuditRemoteModel, userIdSupervisor);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setUserIdAgent", long.class);

				method.invoke(_peProcessAuditRemoteModel, userIdAgent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEClosedStageId() {
		return _spPEClosedStageId;
	}

	@Override
	public void setSpPEClosedStageId(long spPEClosedStageId) {
		_spPEClosedStageId = spPEClosedStageId;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEClosedStageId",
						long.class);

				method.invoke(_peProcessAuditRemoteModel, spPEClosedStageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_peProcessAuditRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDoneBy() {
		return _doneBy;
	}

	@Override
	public void setDoneBy(String doneBy) {
		_doneBy = doneBy;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setDoneBy", String.class);

				method.invoke(_peProcessAuditRemoteModel, doneBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAction() {
		return _action;
	}

	@Override
	public void setAction(String action) {
		_action = action;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setAction", String.class);

				method.invoke(_peProcessAuditRemoteModel, action);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getField1() {
		return _field1;
	}

	@Override
	public void setField1(String field1) {
		_field1 = field1;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setField1", String.class);

				method.invoke(_peProcessAuditRemoteModel, field1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getField2() {
		return _field2;
	}

	@Override
	public void setField2(String field2) {
		_field2 = field2;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setField2", String.class);

				method.invoke(_peProcessAuditRemoteModel, field2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getField3() {
		return _field3;
	}

	@Override
	public void setField3(String field3) {
		_field3 = field3;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setField3", String.class);

				method.invoke(_peProcessAuditRemoteModel, field3);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getField4() {
		return _field4;
	}

	@Override
	public void setField4(String field4) {
		_field4 = field4;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setField4", String.class);

				method.invoke(_peProcessAuditRemoteModel, field4);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getField5() {
		return _field5;
	}

	@Override
	public void setField5(long field5) {
		_field5 = field5;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setField5", long.class);

				method.invoke(_peProcessAuditRemoteModel, field5);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStorageId() {
		return _storageId;
	}

	@Override
	public void setStorageId(long storageId) {
		_storageId = storageId;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setStorageId", long.class);

				method.invoke(_peProcessAuditRemoteModel, storageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getData1() {
		return _data1;
	}

	@Override
	public void setData1(String data1) {
		_data1 = data1;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setData1", String.class);

				method.invoke(_peProcessAuditRemoteModel, data1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getData2() {
		return _data2;
	}

	@Override
	public void setData2(String data2) {
		_data2 = data2;

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setData2", String.class);

				method.invoke(_peProcessAuditRemoteModel, data2);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSourceClassId", long.class);

				method.invoke(_peProcessAuditRemoteModel, sourceClassId);
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

		if (_peProcessAuditRemoteModel != null) {
			try {
				Class<?> clazz = _peProcessAuditRemoteModel.getClass();

				Method method = clazz.getMethod("setSourceEntityID", long.class);

				method.invoke(_peProcessAuditRemoteModel, sourceEntityID);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PEProcessAudit.class.getName()));
	}

	public BaseModel<?> getPEProcessAuditRemoteModel() {
		return _peProcessAuditRemoteModel;
	}

	public void setPEProcessAuditRemoteModel(
		BaseModel<?> peProcessAuditRemoteModel) {
		_peProcessAuditRemoteModel = peProcessAuditRemoteModel;
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

		Class<?> remoteModelClass = _peProcessAuditRemoteModel.getClass();

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

		Object returnValue = method.invoke(_peProcessAuditRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PEProcessAuditLocalServiceUtil.addPEProcessAudit(this);
		}
		else {
			PEProcessAuditLocalServiceUtil.updatePEProcessAudit(this);
		}
	}

	@Override
	public PEProcessAudit toEscapedModel() {
		return (PEProcessAudit)ProxyUtil.newProxyInstance(PEProcessAudit.class.getClassLoader(),
			new Class[] { PEProcessAudit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PEProcessAuditClp clone = new PEProcessAuditClp();

		clone.setUuid(getUuid());
		clone.setSpPEProcessAuditId(getSpPEProcessAuditId());
		clone.setGroupId(getGroupId());
		clone.setUserId(getUserId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpPEProcessStateId(getSpPEProcessStateId());
		clone.setSpPEProcessId(getSpPEProcessId());
		clone.setEntityClassId(getEntityClassId());
		clone.setEntityId(getEntityId());
		clone.setUserIdProcess(getUserIdProcess());
		clone.setStatusTypeId(getStatusTypeId());
		clone.setSpPEProcessStageId(getSpPEProcessStageId());
		clone.setNodeId(getNodeId());
		clone.setStatus(getStatus());
		clone.setUserIdSupervisor(getUserIdSupervisor());
		clone.setUserIdAgent(getUserIdAgent());
		clone.setSpPEClosedStageId(getSpPEClosedStageId());
		clone.setType(getType());
		clone.setDoneBy(getDoneBy());
		clone.setAction(getAction());
		clone.setField1(getField1());
		clone.setField2(getField2());
		clone.setField3(getField3());
		clone.setField4(getField4());
		clone.setField5(getField5());
		clone.setStorageId(getStorageId());
		clone.setData1(getData1());
		clone.setData2(getData2());
		clone.setSourceClassId(getSourceClassId());
		clone.setSourceEntityID(getSourceEntityID());

		return clone;
	}

	@Override
	public int compareTo(PEProcessAudit peProcessAudit) {
		long primaryKey = peProcessAudit.getPrimaryKey();

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

		if (!(obj instanceof PEProcessAuditClp)) {
			return false;
		}

		PEProcessAuditClp peProcessAudit = (PEProcessAuditClp)obj;

		long primaryKey = peProcessAudit.getPrimaryKey();

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
		StringBundler sb = new StringBundler(67);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spPEProcessAuditId=");
		sb.append(getSpPEProcessAuditId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", spPEProcessStateId=");
		sb.append(getSpPEProcessStateId());
		sb.append(", spPEProcessId=");
		sb.append(getSpPEProcessId());
		sb.append(", entityClassId=");
		sb.append(getEntityClassId());
		sb.append(", entityId=");
		sb.append(getEntityId());
		sb.append(", userIdProcess=");
		sb.append(getUserIdProcess());
		sb.append(", statusTypeId=");
		sb.append(getStatusTypeId());
		sb.append(", spPEProcessStageId=");
		sb.append(getSpPEProcessStageId());
		sb.append(", nodeId=");
		sb.append(getNodeId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", userIdSupervisor=");
		sb.append(getUserIdSupervisor());
		sb.append(", userIdAgent=");
		sb.append(getUserIdAgent());
		sb.append(", spPEClosedStageId=");
		sb.append(getSpPEClosedStageId());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", doneBy=");
		sb.append(getDoneBy());
		sb.append(", action=");
		sb.append(getAction());
		sb.append(", field1=");
		sb.append(getField1());
		sb.append(", field2=");
		sb.append(getField2());
		sb.append(", field3=");
		sb.append(getField3());
		sb.append(", field4=");
		sb.append(getField4());
		sb.append(", field5=");
		sb.append(getField5());
		sb.append(", storageId=");
		sb.append(getStorageId());
		sb.append(", data1=");
		sb.append(getData1());
		sb.append(", data2=");
		sb.append(getData2());
		sb.append(", sourceClassId=");
		sb.append(getSourceClassId());
		sb.append(", sourceEntityID=");
		sb.append(getSourceEntityID());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(103);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.processbuilder.model.PEProcessAudit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessAuditId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessAuditId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
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
			"<column><column-name>spPEProcessStateId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStateId());
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
			"<column><column-name>statusTypeId</column-name><column-value><![CDATA[");
		sb.append(getStatusTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessStageId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nodeId</column-name><column-value><![CDATA[");
		sb.append(getNodeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
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
			"<column><column-name>spPEClosedStageId</column-name><column-value><![CDATA[");
		sb.append(getSpPEClosedStageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>doneBy</column-name><column-value><![CDATA[");
		sb.append(getDoneBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>action</column-name><column-value><![CDATA[");
		sb.append(getAction());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field1</column-name><column-value><![CDATA[");
		sb.append(getField1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field2</column-name><column-value><![CDATA[");
		sb.append(getField2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field3</column-name><column-value><![CDATA[");
		sb.append(getField3());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field4</column-name><column-value><![CDATA[");
		sb.append(getField4());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>field5</column-name><column-value><![CDATA[");
		sb.append(getField5());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>storageId</column-name><column-value><![CDATA[");
		sb.append(getStorageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data1</column-name><column-value><![CDATA[");
		sb.append(getData1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>data2</column-name><column-value><![CDATA[");
		sb.append(getData2());
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
	private long _spPEProcessAuditId;
	private long _groupId;
	private long _userId;
	private String _userUuid;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPEProcessStateId;
	private long _spPEProcessId;
	private long _entityClassId;
	private long _entityId;
	private long _userIdProcess;
	private long _statusTypeId;
	private long _spPEProcessStageId;
	private long _nodeId;
	private String _status;
	private long _userIdSupervisor;
	private long _userIdAgent;
	private long _spPEClosedStageId;
	private String _type;
	private String _doneBy;
	private String _action;
	private String _field1;
	private String _field2;
	private String _field3;
	private String _field4;
	private long _field5;
	private long _storageId;
	private String _data1;
	private String _data2;
	private long _sourceClassId;
	private long _sourceEntityID;
	private BaseModel<?> _peProcessAuditRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class;
}