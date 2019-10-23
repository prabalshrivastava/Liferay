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
public class PERuleSoap implements Serializable {
	public static PERuleSoap toSoapModel(PERule model) {
		PERuleSoap soapModel = new PERuleSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpPERuleId(model.getSpPERuleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpPERuleSetId(model.getSpPERuleSetId());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setDefinition(model.getDefinition());
		soapModel.setSequenceNO(model.getSequenceNO());

		return soapModel;
	}

	public static PERuleSoap[] toSoapModels(PERule[] models) {
		PERuleSoap[] soapModels = new PERuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PERuleSoap[][] toSoapModels(PERule[][] models) {
		PERuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PERuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PERuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PERuleSoap[] toSoapModels(List<PERule> models) {
		List<PERuleSoap> soapModels = new ArrayList<PERuleSoap>(models.size());

		for (PERule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PERuleSoap[soapModels.size()]);
	}

	public PERuleSoap() {
	}

	public long getPrimaryKey() {
		return _spPERuleId;
	}

	public void setPrimaryKey(long pk) {
		setSpPERuleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpPERuleId() {
		return _spPERuleId;
	}

	public void setSpPERuleId(long spPERuleId) {
		_spPERuleId = spPERuleId;
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

	public long getSpPERuleSetId() {
		return _spPERuleSetId;
	}

	public void setSpPERuleSetId(long spPERuleSetId) {
		_spPERuleSetId = spPERuleSetId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getDefinition() {
		return _definition;
	}

	public void setDefinition(String definition) {
		_definition = definition;
	}

	public long getSequenceNO() {
		return _sequenceNO;
	}

	public void setSequenceNO(long sequenceNO) {
		_sequenceNO = sequenceNO;
	}

	private String _uuid;
	private long _spPERuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spPERuleSetId;
	private String _name;
	private String _type;
	private String _definition;
	private long _sequenceNO;
}