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
public class PEProcessAuditSoap implements Serializable {
	public static PEProcessAuditSoap toSoapModel(PEProcessAudit model) {
		PEProcessAuditSoap soapModel = new PEProcessAuditSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpPEProcessAuditId(model.getSpPEProcessAuditId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpPEProcessStateId(model.getSpPEProcessStateId());
		soapModel.setSpPEProcessId(model.getSpPEProcessId());
		soapModel.setEntityClassId(model.getEntityClassId());
		soapModel.setEntityId(model.getEntityId());
		soapModel.setUserIdProcess(model.getUserIdProcess());
		soapModel.setStatusTypeId(model.getStatusTypeId());
		soapModel.setSpPEProcessStageId(model.getSpPEProcessStageId());
		soapModel.setNodeId(model.getNodeId());
		soapModel.setStatus(model.getStatus());
		soapModel.setUserIdSupervisor(model.getUserIdSupervisor());
		soapModel.setUserIdAgent(model.getUserIdAgent());
		soapModel.setSpPEClosedStageId(model.getSpPEClosedStageId());
		soapModel.setType(model.getType());
		soapModel.setDoneBy(model.getDoneBy());
		soapModel.setAction(model.getAction());
		soapModel.setField1(model.getField1());
		soapModel.setField2(model.getField2());
		soapModel.setField3(model.getField3());
		soapModel.setField4(model.getField4());
		soapModel.setField5(model.getField5());
		soapModel.setStorageId(model.getStorageId());
		soapModel.setData1(model.getData1());
		soapModel.setData2(model.getData2());
		soapModel.setSourceClassId(model.getSourceClassId());
		soapModel.setSourceEntityID(model.getSourceEntityID());

		return soapModel;
	}

	public static PEProcessAuditSoap[] toSoapModels(PEProcessAudit[] models) {
		PEProcessAuditSoap[] soapModels = new PEProcessAuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PEProcessAuditSoap[][] toSoapModels(PEProcessAudit[][] models) {
		PEProcessAuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PEProcessAuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PEProcessAuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PEProcessAuditSoap[] toSoapModels(List<PEProcessAudit> models) {
		List<PEProcessAuditSoap> soapModels = new ArrayList<PEProcessAuditSoap>(models.size());

		for (PEProcessAudit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PEProcessAuditSoap[soapModels.size()]);
	}

	public PEProcessAuditSoap() {
	}

	public long getPrimaryKey() {
		return _spPEProcessAuditId;
	}

	public void setPrimaryKey(long pk) {
		setSpPEProcessAuditId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpPEProcessAuditId() {
		return _spPEProcessAuditId;
	}

	public void setSpPEProcessAuditId(long spPEProcessAuditId) {
		_spPEProcessAuditId = spPEProcessAuditId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
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

	public long getSpPEProcessStateId() {
		return _spPEProcessStateId;
	}

	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_spPEProcessStateId = spPEProcessStateId;
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

	public long getNodeId() {
		return _nodeId;
	}

	public void setNodeId(long nodeId) {
		_nodeId = nodeId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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

	public long getSpPEClosedStageId() {
		return _spPEClosedStageId;
	}

	public void setSpPEClosedStageId(long spPEClosedStageId) {
		_spPEClosedStageId = spPEClosedStageId;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getDoneBy() {
		return _doneBy;
	}

	public void setDoneBy(String doneBy) {
		_doneBy = doneBy;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getField1() {
		return _field1;
	}

	public void setField1(String field1) {
		_field1 = field1;
	}

	public String getField2() {
		return _field2;
	}

	public void setField2(String field2) {
		_field2 = field2;
	}

	public String getField3() {
		return _field3;
	}

	public void setField3(String field3) {
		_field3 = field3;
	}

	public String getField4() {
		return _field4;
	}

	public void setField4(String field4) {
		_field4 = field4;
	}

	public long getField5() {
		return _field5;
	}

	public void setField5(long field5) {
		_field5 = field5;
	}

	public long getStorageId() {
		return _storageId;
	}

	public void setStorageId(long storageId) {
		_storageId = storageId;
	}

	public String getData1() {
		return _data1;
	}

	public void setData1(String data1) {
		_data1 = data1;
	}

	public String getData2() {
		return _data2;
	}

	public void setData2(String data2) {
		_data2 = data2;
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
	private long _spPEProcessAuditId;
	private long _groupId;
	private long _userId;
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
}