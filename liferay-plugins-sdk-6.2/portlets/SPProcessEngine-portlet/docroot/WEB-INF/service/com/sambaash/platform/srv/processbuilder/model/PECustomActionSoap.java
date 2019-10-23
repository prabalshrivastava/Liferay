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
public class PECustomActionSoap implements Serializable {
	public static PECustomActionSoap toSoapModel(PECustomAction model) {
		PECustomActionSoap soapModel = new PECustomActionSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpPEActionId(model.getSpPEActionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActionClassName(model.getActionClassName());
		soapModel.setTitle(model.getTitle());
		soapModel.setDefaultConfiguration(model.getDefaultConfiguration());

		return soapModel;
	}

	public static PECustomActionSoap[] toSoapModels(PECustomAction[] models) {
		PECustomActionSoap[] soapModels = new PECustomActionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PECustomActionSoap[][] toSoapModels(PECustomAction[][] models) {
		PECustomActionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PECustomActionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PECustomActionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PECustomActionSoap[] toSoapModels(List<PECustomAction> models) {
		List<PECustomActionSoap> soapModels = new ArrayList<PECustomActionSoap>(models.size());

		for (PECustomAction model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PECustomActionSoap[soapModels.size()]);
	}

	public PECustomActionSoap() {
	}

	public long getPrimaryKey() {
		return _spPEActionId;
	}

	public void setPrimaryKey(long pk) {
		setSpPEActionId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpPEActionId() {
		return _spPEActionId;
	}

	public void setSpPEActionId(long spPEActionId) {
		_spPEActionId = spPEActionId;
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

	public String getActionClassName() {
		return _actionClassName;
	}

	public void setActionClassName(String actionClassName) {
		_actionClassName = actionClassName;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDefaultConfiguration() {
		return _defaultConfiguration;
	}

	public void setDefaultConfiguration(String defaultConfiguration) {
		_defaultConfiguration = defaultConfiguration;
	}

	private String _uuid;
	private long _spPEActionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _actionClassName;
	private String _title;
	private String _defaultConfiguration;
}