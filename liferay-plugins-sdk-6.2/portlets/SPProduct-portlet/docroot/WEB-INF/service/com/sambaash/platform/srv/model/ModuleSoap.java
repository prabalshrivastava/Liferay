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
public class ModuleSoap implements Serializable {
	public static ModuleSoap toSoapModel(Module model) {
		ModuleSoap soapModel = new ModuleSoap();

		soapModel.setSpModuleId(model.getSpModuleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setModuleCode(model.getModuleCode());
		soapModel.setModuleName(model.getModuleName());
		soapModel.setModuleDesc(model.getModuleDesc());
		soapModel.setModuleType(model.getModuleType());
		soapModel.setCreditValue(model.getCreditValue());
		soapModel.setModuleDuration(model.getModuleDuration());
		soapModel.setNoOfSessions(model.getNoOfSessions());
		soapModel.setGeneralDesc(model.getGeneralDesc());

		return soapModel;
	}

	public static ModuleSoap[] toSoapModels(Module[] models) {
		ModuleSoap[] soapModels = new ModuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ModuleSoap[][] toSoapModels(Module[][] models) {
		ModuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ModuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ModuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ModuleSoap[] toSoapModels(List<Module> models) {
		List<ModuleSoap> soapModels = new ArrayList<ModuleSoap>(models.size());

		for (Module model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ModuleSoap[soapModels.size()]);
	}

	public ModuleSoap() {
	}

	public long getPrimaryKey() {
		return _spModuleId;
	}

	public void setPrimaryKey(long pk) {
		setSpModuleId(pk);
	}

	public long getSpModuleId() {
		return _spModuleId;
	}

	public void setSpModuleId(long spModuleId) {
		_spModuleId = spModuleId;
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

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getModuleCode() {
		return _moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		_moduleCode = moduleCode;
	}

	public String getModuleName() {
		return _moduleName;
	}

	public void setModuleName(String moduleName) {
		_moduleName = moduleName;
	}

	public String getModuleDesc() {
		return _moduleDesc;
	}

	public void setModuleDesc(String moduleDesc) {
		_moduleDesc = moduleDesc;
	}

	public long getModuleType() {
		return _moduleType;
	}

	public void setModuleType(long moduleType) {
		_moduleType = moduleType;
	}

	public long getCreditValue() {
		return _creditValue;
	}

	public void setCreditValue(long creditValue) {
		_creditValue = creditValue;
	}

	public String getModuleDuration() {
		return _moduleDuration;
	}

	public void setModuleDuration(String moduleDuration) {
		_moduleDuration = moduleDuration;
	}

	public long getNoOfSessions() {
		return _noOfSessions;
	}

	public void setNoOfSessions(long noOfSessions) {
		_noOfSessions = noOfSessions;
	}

	public String getGeneralDesc() {
		return _generalDesc;
	}

	public void setGeneralDesc(String generalDesc) {
		_generalDesc = generalDesc;
	}

	private long _spModuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private String _moduleCode;
	private String _moduleName;
	private String _moduleDesc;
	private long _moduleType;
	private long _creditValue;
	private String _moduleDuration;
	private long _noOfSessions;
	private String _generalDesc;
}