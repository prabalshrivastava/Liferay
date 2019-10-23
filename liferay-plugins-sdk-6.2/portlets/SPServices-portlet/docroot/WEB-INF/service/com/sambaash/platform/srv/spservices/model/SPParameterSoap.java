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
public class SPParameterSoap implements Serializable {
	public static SPParameterSoap toSoapModel(SPParameter model) {
		SPParameterSoap soapModel = new SPParameterSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpParameterId(model.getSpParameterId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategory(model.getCategory());
		soapModel.setDescription(model.getDescription());
		soapModel.setName(model.getName());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static SPParameterSoap[] toSoapModels(SPParameter[] models) {
		SPParameterSoap[] soapModels = new SPParameterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPParameterSoap[][] toSoapModels(SPParameter[][] models) {
		SPParameterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPParameterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPParameterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPParameterSoap[] toSoapModels(List<SPParameter> models) {
		List<SPParameterSoap> soapModels = new ArrayList<SPParameterSoap>(models.size());

		for (SPParameter model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPParameterSoap[soapModels.size()]);
	}

	public SPParameterSoap() {
	}

	public long getPrimaryKey() {
		return _spParameterId;
	}

	public void setPrimaryKey(long pk) {
		setSpParameterId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpParameterId() {
		return _spParameterId;
	}

	public void setSpParameterId(long spParameterId) {
		_spParameterId = spParameterId;
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

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private String _uuid;
	private long _spParameterId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _category;
	private String _description;
	private String _name;
	private String _value;
}