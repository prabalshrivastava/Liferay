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
public class PERuleSetSoap implements Serializable {
	public static PERuleSetSoap toSoapModel(PERuleSet model) {
		PERuleSetSoap soapModel = new PERuleSetSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpPERuleSetId(model.getSpPERuleSetId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setComponentType(model.getComponentType());
		soapModel.setComponentId(model.getComponentId());
		soapModel.setStatus(model.getStatus());
		soapModel.setFormVersion(model.getFormVersion());

		return soapModel;
	}

	public static PERuleSetSoap[] toSoapModels(PERuleSet[] models) {
		PERuleSetSoap[] soapModels = new PERuleSetSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PERuleSetSoap[][] toSoapModels(PERuleSet[][] models) {
		PERuleSetSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PERuleSetSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PERuleSetSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PERuleSetSoap[] toSoapModels(List<PERuleSet> models) {
		List<PERuleSetSoap> soapModels = new ArrayList<PERuleSetSoap>(models.size());

		for (PERuleSet model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PERuleSetSoap[soapModels.size()]);
	}

	public PERuleSetSoap() {
	}

	public long getPrimaryKey() {
		return _spPERuleSetId;
	}

	public void setPrimaryKey(long pk) {
		setSpPERuleSetId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpPERuleSetId() {
		return _spPERuleSetId;
	}

	public void setSpPERuleSetId(long spPERuleSetId) {
		_spPERuleSetId = spPERuleSetId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getComponentType() {
		return _componentType;
	}

	public void setComponentType(String componentType) {
		_componentType = componentType;
	}

	public String getComponentId() {
		return _componentId;
	}

	public void setComponentId(String componentId) {
		_componentId = componentId;
	}

	public long getStatus() {
		return _status;
	}

	public void setStatus(long status) {
		_status = status;
	}

	public String getFormVersion() {
		return _formVersion;
	}

	public void setFormVersion(String formVersion) {
		_formVersion = formVersion;
	}

	private String _uuid;
	private long _spPERuleSetId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _componentType;
	private String _componentId;
	private long _status;
	private String _formVersion;
}