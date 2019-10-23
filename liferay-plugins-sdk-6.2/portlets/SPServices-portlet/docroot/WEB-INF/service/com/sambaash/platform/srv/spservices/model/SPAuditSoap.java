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

package com.sambaash.platform.srv.spservices.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class SPAuditSoap implements Serializable {
	public static SPAuditSoap toSoapModel(SPAudit model) {
		SPAuditSoap soapModel = new SPAuditSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSPAuditId(model.getSPAuditId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDoneByUserId(model.getDoneByUserId());
		soapModel.setEntityClassNameId(model.getEntityClassNameId());
		soapModel.setEntityId(model.getEntityId());
		soapModel.setAction(model.getAction());
		soapModel.setField1Str(model.getField1Str());
		soapModel.setField1Long(model.getField1Long());
		soapModel.setField2Str(model.getField2Str());
		soapModel.setField2Long(model.getField2Long());
		soapModel.setData1(model.getData1());
		soapModel.setData2(model.getData2());

		return soapModel;
	}

	public static SPAuditSoap[] toSoapModels(SPAudit[] models) {
		SPAuditSoap[] soapModels = new SPAuditSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPAuditSoap[][] toSoapModels(SPAudit[][] models) {
		SPAuditSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPAuditSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPAuditSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPAuditSoap[] toSoapModels(List<SPAudit> models) {
		List<SPAuditSoap> soapModels = new ArrayList<SPAuditSoap>(models.size());

		for (SPAudit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPAuditSoap[soapModels.size()]);
	}

	public SPAuditSoap() {
	}

	public long getPrimaryKey() {
		return _SPAuditId;
	}

	public void setPrimaryKey(long pk) {
		setSPAuditId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSPAuditId() {
		return _SPAuditId;
	}

	public void setSPAuditId(long SPAuditId) {
		_SPAuditId = SPAuditId;
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

	public long getDoneByUserId() {
		return _doneByUserId;
	}

	public void setDoneByUserId(long doneByUserId) {
		_doneByUserId = doneByUserId;
	}

	public long getEntityClassNameId() {
		return _entityClassNameId;
	}

	public void setEntityClassNameId(long entityClassNameId) {
		_entityClassNameId = entityClassNameId;
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
	}

	public String getAction() {
		return _action;
	}

	public void setAction(String action) {
		_action = action;
	}

	public String getField1Str() {
		return _field1Str;
	}

	public void setField1Str(String field1Str) {
		_field1Str = field1Str;
	}

	public long getField1Long() {
		return _field1Long;
	}

	public void setField1Long(long field1Long) {
		_field1Long = field1Long;
	}

	public String getField2Str() {
		return _field2Str;
	}

	public void setField2Str(String field2Str) {
		_field2Str = field2Str;
	}

	public long getField2Long() {
		return _field2Long;
	}

	public void setField2Long(long field2Long) {
		_field2Long = field2Long;
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

	private String _uuid;
	private long _SPAuditId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _doneByUserId;
	private long _entityClassNameId;
	private long _entityId;
	private String _action;
	private String _field1Str;
	private long _field1Long;
	private String _field2Str;
	private long _field2Long;
	private String _data1;
	private String _data2;
}