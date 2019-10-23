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

package com.wtberks.configuration.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author liferay
 * @generated
 */
public class ConfigurationPropertySoap implements Serializable {
	public static ConfigurationPropertySoap toSoapModel(
		ConfigurationProperty model) {
		ConfigurationPropertySoap soapModel = new ConfigurationPropertySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setConfigurationPropertyId(model.getConfigurationPropertyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setKey(model.getKey());
		soapModel.setValue(model.getValue());

		return soapModel;
	}

	public static ConfigurationPropertySoap[] toSoapModels(
		ConfigurationProperty[] models) {
		ConfigurationPropertySoap[] soapModels = new ConfigurationPropertySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ConfigurationPropertySoap[][] toSoapModels(
		ConfigurationProperty[][] models) {
		ConfigurationPropertySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ConfigurationPropertySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ConfigurationPropertySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ConfigurationPropertySoap[] toSoapModels(
		List<ConfigurationProperty> models) {
		List<ConfigurationPropertySoap> soapModels = new ArrayList<ConfigurationPropertySoap>(models.size());

		for (ConfigurationProperty model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ConfigurationPropertySoap[soapModels.size()]);
	}

	public ConfigurationPropertySoap() {
	}

	public long getPrimaryKey() {
		return _configurationPropertyId;
	}

	public void setPrimaryKey(long pk) {
		setConfigurationPropertyId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getConfigurationPropertyId() {
		return _configurationPropertyId;
	}

	public void setConfigurationPropertyId(long configurationPropertyId) {
		_configurationPropertyId = configurationPropertyId;
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

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	private String _uuid;
	private long _configurationPropertyId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _key;
	private String _value;
}