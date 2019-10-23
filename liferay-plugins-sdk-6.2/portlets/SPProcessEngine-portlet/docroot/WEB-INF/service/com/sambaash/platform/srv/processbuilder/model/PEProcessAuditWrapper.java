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
 * This class is a wrapper for {@link PEProcessAudit}.
 * </p>
 *
 * @author nareshchebolu
 * @see PEProcessAudit
 * @generated
 */
public class PEProcessAuditWrapper implements PEProcessAudit,
	ModelWrapper<PEProcessAudit> {
	public PEProcessAuditWrapper(PEProcessAudit peProcessAudit) {
		_peProcessAudit = peProcessAudit;
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

	/**
	* Returns the primary key of this p e process audit.
	*
	* @return the primary key of this p e process audit
	*/
	@Override
	public long getPrimaryKey() {
		return _peProcessAudit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this p e process audit.
	*
	* @param primaryKey the primary key of this p e process audit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_peProcessAudit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this p e process audit.
	*
	* @return the uuid of this p e process audit
	*/
	@Override
	public java.lang.String getUuid() {
		return _peProcessAudit.getUuid();
	}

	/**
	* Sets the uuid of this p e process audit.
	*
	* @param uuid the uuid of this p e process audit
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_peProcessAudit.setUuid(uuid);
	}

	/**
	* Returns the sp p e process audit ID of this p e process audit.
	*
	* @return the sp p e process audit ID of this p e process audit
	*/
	@Override
	public long getSpPEProcessAuditId() {
		return _peProcessAudit.getSpPEProcessAuditId();
	}

	/**
	* Sets the sp p e process audit ID of this p e process audit.
	*
	* @param spPEProcessAuditId the sp p e process audit ID of this p e process audit
	*/
	@Override
	public void setSpPEProcessAuditId(long spPEProcessAuditId) {
		_peProcessAudit.setSpPEProcessAuditId(spPEProcessAuditId);
	}

	/**
	* Returns the group ID of this p e process audit.
	*
	* @return the group ID of this p e process audit
	*/
	@Override
	public long getGroupId() {
		return _peProcessAudit.getGroupId();
	}

	/**
	* Sets the group ID of this p e process audit.
	*
	* @param groupId the group ID of this p e process audit
	*/
	@Override
	public void setGroupId(long groupId) {
		_peProcessAudit.setGroupId(groupId);
	}

	/**
	* Returns the user ID of this p e process audit.
	*
	* @return the user ID of this p e process audit
	*/
	@Override
	public long getUserId() {
		return _peProcessAudit.getUserId();
	}

	/**
	* Sets the user ID of this p e process audit.
	*
	* @param userId the user ID of this p e process audit
	*/
	@Override
	public void setUserId(long userId) {
		_peProcessAudit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this p e process audit.
	*
	* @return the user uuid of this p e process audit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _peProcessAudit.getUserUuid();
	}

	/**
	* Sets the user uuid of this p e process audit.
	*
	* @param userUuid the user uuid of this p e process audit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_peProcessAudit.setUserUuid(userUuid);
	}

	/**
	* Returns the company ID of this p e process audit.
	*
	* @return the company ID of this p e process audit
	*/
	@Override
	public long getCompanyId() {
		return _peProcessAudit.getCompanyId();
	}

	/**
	* Sets the company ID of this p e process audit.
	*
	* @param companyId the company ID of this p e process audit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_peProcessAudit.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this p e process audit.
	*
	* @return the user name of this p e process audit
	*/
	@Override
	public java.lang.String getUserName() {
		return _peProcessAudit.getUserName();
	}

	/**
	* Sets the user name of this p e process audit.
	*
	* @param userName the user name of this p e process audit
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_peProcessAudit.setUserName(userName);
	}

	/**
	* Returns the create date of this p e process audit.
	*
	* @return the create date of this p e process audit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _peProcessAudit.getCreateDate();
	}

	/**
	* Sets the create date of this p e process audit.
	*
	* @param createDate the create date of this p e process audit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_peProcessAudit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this p e process audit.
	*
	* @return the modified date of this p e process audit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _peProcessAudit.getModifiedDate();
	}

	/**
	* Sets the modified date of this p e process audit.
	*
	* @param modifiedDate the modified date of this p e process audit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_peProcessAudit.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp p e process state ID of this p e process audit.
	*
	* @return the sp p e process state ID of this p e process audit
	*/
	@Override
	public long getSpPEProcessStateId() {
		return _peProcessAudit.getSpPEProcessStateId();
	}

	/**
	* Sets the sp p e process state ID of this p e process audit.
	*
	* @param spPEProcessStateId the sp p e process state ID of this p e process audit
	*/
	@Override
	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_peProcessAudit.setSpPEProcessStateId(spPEProcessStateId);
	}

	/**
	* Returns the sp p e process ID of this p e process audit.
	*
	* @return the sp p e process ID of this p e process audit
	*/
	@Override
	public long getSpPEProcessId() {
		return _peProcessAudit.getSpPEProcessId();
	}

	/**
	* Sets the sp p e process ID of this p e process audit.
	*
	* @param spPEProcessId the sp p e process ID of this p e process audit
	*/
	@Override
	public void setSpPEProcessId(long spPEProcessId) {
		_peProcessAudit.setSpPEProcessId(spPEProcessId);
	}

	/**
	* Returns the entity class ID of this p e process audit.
	*
	* @return the entity class ID of this p e process audit
	*/
	@Override
	public long getEntityClassId() {
		return _peProcessAudit.getEntityClassId();
	}

	/**
	* Sets the entity class ID of this p e process audit.
	*
	* @param entityClassId the entity class ID of this p e process audit
	*/
	@Override
	public void setEntityClassId(long entityClassId) {
		_peProcessAudit.setEntityClassId(entityClassId);
	}

	/**
	* Returns the entity ID of this p e process audit.
	*
	* @return the entity ID of this p e process audit
	*/
	@Override
	public long getEntityId() {
		return _peProcessAudit.getEntityId();
	}

	/**
	* Sets the entity ID of this p e process audit.
	*
	* @param entityId the entity ID of this p e process audit
	*/
	@Override
	public void setEntityId(long entityId) {
		_peProcessAudit.setEntityId(entityId);
	}

	/**
	* Returns the user ID process of this p e process audit.
	*
	* @return the user ID process of this p e process audit
	*/
	@Override
	public long getUserIdProcess() {
		return _peProcessAudit.getUserIdProcess();
	}

	/**
	* Sets the user ID process of this p e process audit.
	*
	* @param userIdProcess the user ID process of this p e process audit
	*/
	@Override
	public void setUserIdProcess(long userIdProcess) {
		_peProcessAudit.setUserIdProcess(userIdProcess);
	}

	/**
	* Returns the status type ID of this p e process audit.
	*
	* @return the status type ID of this p e process audit
	*/
	@Override
	public long getStatusTypeId() {
		return _peProcessAudit.getStatusTypeId();
	}

	/**
	* Sets the status type ID of this p e process audit.
	*
	* @param statusTypeId the status type ID of this p e process audit
	*/
	@Override
	public void setStatusTypeId(long statusTypeId) {
		_peProcessAudit.setStatusTypeId(statusTypeId);
	}

	/**
	* Returns the sp p e process stage ID of this p e process audit.
	*
	* @return the sp p e process stage ID of this p e process audit
	*/
	@Override
	public long getSpPEProcessStageId() {
		return _peProcessAudit.getSpPEProcessStageId();
	}

	/**
	* Sets the sp p e process stage ID of this p e process audit.
	*
	* @param spPEProcessStageId the sp p e process stage ID of this p e process audit
	*/
	@Override
	public void setSpPEProcessStageId(long spPEProcessStageId) {
		_peProcessAudit.setSpPEProcessStageId(spPEProcessStageId);
	}

	/**
	* Returns the node ID of this p e process audit.
	*
	* @return the node ID of this p e process audit
	*/
	@Override
	public long getNodeId() {
		return _peProcessAudit.getNodeId();
	}

	/**
	* Sets the node ID of this p e process audit.
	*
	* @param nodeId the node ID of this p e process audit
	*/
	@Override
	public void setNodeId(long nodeId) {
		_peProcessAudit.setNodeId(nodeId);
	}

	/**
	* Returns the status of this p e process audit.
	*
	* @return the status of this p e process audit
	*/
	@Override
	public java.lang.String getStatus() {
		return _peProcessAudit.getStatus();
	}

	/**
	* Sets the status of this p e process audit.
	*
	* @param status the status of this p e process audit
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_peProcessAudit.setStatus(status);
	}

	/**
	* Returns the user ID supervisor of this p e process audit.
	*
	* @return the user ID supervisor of this p e process audit
	*/
	@Override
	public long getUserIdSupervisor() {
		return _peProcessAudit.getUserIdSupervisor();
	}

	/**
	* Sets the user ID supervisor of this p e process audit.
	*
	* @param userIdSupervisor the user ID supervisor of this p e process audit
	*/
	@Override
	public void setUserIdSupervisor(long userIdSupervisor) {
		_peProcessAudit.setUserIdSupervisor(userIdSupervisor);
	}

	/**
	* Returns the user ID agent of this p e process audit.
	*
	* @return the user ID agent of this p e process audit
	*/
	@Override
	public long getUserIdAgent() {
		return _peProcessAudit.getUserIdAgent();
	}

	/**
	* Sets the user ID agent of this p e process audit.
	*
	* @param userIdAgent the user ID agent of this p e process audit
	*/
	@Override
	public void setUserIdAgent(long userIdAgent) {
		_peProcessAudit.setUserIdAgent(userIdAgent);
	}

	/**
	* Returns the sp p e closed stage ID of this p e process audit.
	*
	* @return the sp p e closed stage ID of this p e process audit
	*/
	@Override
	public long getSpPEClosedStageId() {
		return _peProcessAudit.getSpPEClosedStageId();
	}

	/**
	* Sets the sp p e closed stage ID of this p e process audit.
	*
	* @param spPEClosedStageId the sp p e closed stage ID of this p e process audit
	*/
	@Override
	public void setSpPEClosedStageId(long spPEClosedStageId) {
		_peProcessAudit.setSpPEClosedStageId(spPEClosedStageId);
	}

	/**
	* Returns the type of this p e process audit.
	*
	* @return the type of this p e process audit
	*/
	@Override
	public java.lang.String getType() {
		return _peProcessAudit.getType();
	}

	/**
	* Sets the type of this p e process audit.
	*
	* @param type the type of this p e process audit
	*/
	@Override
	public void setType(java.lang.String type) {
		_peProcessAudit.setType(type);
	}

	/**
	* Returns the done by of this p e process audit.
	*
	* @return the done by of this p e process audit
	*/
	@Override
	public java.lang.String getDoneBy() {
		return _peProcessAudit.getDoneBy();
	}

	/**
	* Sets the done by of this p e process audit.
	*
	* @param doneBy the done by of this p e process audit
	*/
	@Override
	public void setDoneBy(java.lang.String doneBy) {
		_peProcessAudit.setDoneBy(doneBy);
	}

	/**
	* Returns the action of this p e process audit.
	*
	* @return the action of this p e process audit
	*/
	@Override
	public java.lang.String getAction() {
		return _peProcessAudit.getAction();
	}

	/**
	* Sets the action of this p e process audit.
	*
	* @param action the action of this p e process audit
	*/
	@Override
	public void setAction(java.lang.String action) {
		_peProcessAudit.setAction(action);
	}

	/**
	* Returns the field1 of this p e process audit.
	*
	* @return the field1 of this p e process audit
	*/
	@Override
	public java.lang.String getField1() {
		return _peProcessAudit.getField1();
	}

	/**
	* Sets the field1 of this p e process audit.
	*
	* @param field1 the field1 of this p e process audit
	*/
	@Override
	public void setField1(java.lang.String field1) {
		_peProcessAudit.setField1(field1);
	}

	/**
	* Returns the field2 of this p e process audit.
	*
	* @return the field2 of this p e process audit
	*/
	@Override
	public java.lang.String getField2() {
		return _peProcessAudit.getField2();
	}

	/**
	* Sets the field2 of this p e process audit.
	*
	* @param field2 the field2 of this p e process audit
	*/
	@Override
	public void setField2(java.lang.String field2) {
		_peProcessAudit.setField2(field2);
	}

	/**
	* Returns the field3 of this p e process audit.
	*
	* @return the field3 of this p e process audit
	*/
	@Override
	public java.lang.String getField3() {
		return _peProcessAudit.getField3();
	}

	/**
	* Sets the field3 of this p e process audit.
	*
	* @param field3 the field3 of this p e process audit
	*/
	@Override
	public void setField3(java.lang.String field3) {
		_peProcessAudit.setField3(field3);
	}

	/**
	* Returns the field4 of this p e process audit.
	*
	* @return the field4 of this p e process audit
	*/
	@Override
	public java.lang.String getField4() {
		return _peProcessAudit.getField4();
	}

	/**
	* Sets the field4 of this p e process audit.
	*
	* @param field4 the field4 of this p e process audit
	*/
	@Override
	public void setField4(java.lang.String field4) {
		_peProcessAudit.setField4(field4);
	}

	/**
	* Returns the field5 of this p e process audit.
	*
	* @return the field5 of this p e process audit
	*/
	@Override
	public long getField5() {
		return _peProcessAudit.getField5();
	}

	/**
	* Sets the field5 of this p e process audit.
	*
	* @param field5 the field5 of this p e process audit
	*/
	@Override
	public void setField5(long field5) {
		_peProcessAudit.setField5(field5);
	}

	/**
	* Returns the storage ID of this p e process audit.
	*
	* @return the storage ID of this p e process audit
	*/
	@Override
	public long getStorageId() {
		return _peProcessAudit.getStorageId();
	}

	/**
	* Sets the storage ID of this p e process audit.
	*
	* @param storageId the storage ID of this p e process audit
	*/
	@Override
	public void setStorageId(long storageId) {
		_peProcessAudit.setStorageId(storageId);
	}

	/**
	* Returns the data1 of this p e process audit.
	*
	* @return the data1 of this p e process audit
	*/
	@Override
	public java.lang.String getData1() {
		return _peProcessAudit.getData1();
	}

	/**
	* Sets the data1 of this p e process audit.
	*
	* @param data1 the data1 of this p e process audit
	*/
	@Override
	public void setData1(java.lang.String data1) {
		_peProcessAudit.setData1(data1);
	}

	/**
	* Returns the data2 of this p e process audit.
	*
	* @return the data2 of this p e process audit
	*/
	@Override
	public java.lang.String getData2() {
		return _peProcessAudit.getData2();
	}

	/**
	* Sets the data2 of this p e process audit.
	*
	* @param data2 the data2 of this p e process audit
	*/
	@Override
	public void setData2(java.lang.String data2) {
		_peProcessAudit.setData2(data2);
	}

	/**
	* Returns the source class ID of this p e process audit.
	*
	* @return the source class ID of this p e process audit
	*/
	@Override
	public long getSourceClassId() {
		return _peProcessAudit.getSourceClassId();
	}

	/**
	* Sets the source class ID of this p e process audit.
	*
	* @param sourceClassId the source class ID of this p e process audit
	*/
	@Override
	public void setSourceClassId(long sourceClassId) {
		_peProcessAudit.setSourceClassId(sourceClassId);
	}

	/**
	* Returns the source entity i d of this p e process audit.
	*
	* @return the source entity i d of this p e process audit
	*/
	@Override
	public long getSourceEntityID() {
		return _peProcessAudit.getSourceEntityID();
	}

	/**
	* Sets the source entity i d of this p e process audit.
	*
	* @param sourceEntityID the source entity i d of this p e process audit
	*/
	@Override
	public void setSourceEntityID(long sourceEntityID) {
		_peProcessAudit.setSourceEntityID(sourceEntityID);
	}

	@Override
	public boolean isNew() {
		return _peProcessAudit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_peProcessAudit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _peProcessAudit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_peProcessAudit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _peProcessAudit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _peProcessAudit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_peProcessAudit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _peProcessAudit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_peProcessAudit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_peProcessAudit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_peProcessAudit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PEProcessAuditWrapper((PEProcessAudit)_peProcessAudit.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.processbuilder.model.PEProcessAudit peProcessAudit) {
		return _peProcessAudit.compareTo(peProcessAudit);
	}

	@Override
	public int hashCode() {
		return _peProcessAudit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.processbuilder.model.PEProcessAudit> toCacheModel() {
		return _peProcessAudit.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit toEscapedModel() {
		return new PEProcessAuditWrapper(_peProcessAudit.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.processbuilder.model.PEProcessAudit toUnescapedModel() {
		return new PEProcessAuditWrapper(_peProcessAudit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _peProcessAudit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _peProcessAudit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_peProcessAudit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PEProcessAuditWrapper)) {
			return false;
		}

		PEProcessAuditWrapper peProcessAuditWrapper = (PEProcessAuditWrapper)obj;

		if (Validator.equals(_peProcessAudit,
					peProcessAuditWrapper._peProcessAudit)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _peProcessAudit.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PEProcessAudit getWrappedPEProcessAudit() {
		return _peProcessAudit;
	}

	@Override
	public PEProcessAudit getWrappedModel() {
		return _peProcessAudit;
	}

	@Override
	public void resetOriginalValues() {
		_peProcessAudit.resetOriginalValues();
	}

	private PEProcessAudit _peProcessAudit;
}