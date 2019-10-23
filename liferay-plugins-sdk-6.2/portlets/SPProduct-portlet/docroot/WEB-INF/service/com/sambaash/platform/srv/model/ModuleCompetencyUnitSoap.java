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

package com.sambaash.platform.srv.model;

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
public class ModuleCompetencyUnitSoap implements Serializable {
	public static ModuleCompetencyUnitSoap toSoapModel(
		ModuleCompetencyUnit model) {
		ModuleCompetencyUnitSoap soapModel = new ModuleCompetencyUnitSoap();

		soapModel.setSpModuleCompetencyUnitId(model.getSpModuleCompetencyUnitId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpModuleId(model.getSpModuleId());
		soapModel.setSpCompetencyUnitId(model.getSpCompetencyUnitId());

		return soapModel;
	}

	public static ModuleCompetencyUnitSoap[] toSoapModels(
		ModuleCompetencyUnit[] models) {
		ModuleCompetencyUnitSoap[] soapModels = new ModuleCompetencyUnitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ModuleCompetencyUnitSoap[][] toSoapModels(
		ModuleCompetencyUnit[][] models) {
		ModuleCompetencyUnitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ModuleCompetencyUnitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ModuleCompetencyUnitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ModuleCompetencyUnitSoap[] toSoapModels(
		List<ModuleCompetencyUnit> models) {
		List<ModuleCompetencyUnitSoap> soapModels = new ArrayList<ModuleCompetencyUnitSoap>(models.size());

		for (ModuleCompetencyUnit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ModuleCompetencyUnitSoap[soapModels.size()]);
	}

	public ModuleCompetencyUnitSoap() {
	}

	public long getPrimaryKey() {
		return _spModuleCompetencyUnitId;
	}

	public void setPrimaryKey(long pk) {
		setSpModuleCompetencyUnitId(pk);
	}

	public long getSpModuleCompetencyUnitId() {
		return _spModuleCompetencyUnitId;
	}

	public void setSpModuleCompetencyUnitId(long spModuleCompetencyUnitId) {
		_spModuleCompetencyUnitId = spModuleCompetencyUnitId;
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

	public long getSpModuleId() {
		return _spModuleId;
	}

	public void setSpModuleId(long spModuleId) {
		_spModuleId = spModuleId;
	}

	public long getSpCompetencyUnitId() {
		return _spCompetencyUnitId;
	}

	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_spCompetencyUnitId = spCompetencyUnitId;
	}

	private long _spModuleCompetencyUnitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private long _spCompetencyUnitId;
}