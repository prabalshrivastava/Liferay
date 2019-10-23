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

package com.sambaash.platform.srv.legalandcontract.model;

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
public class ClassMasterSoap implements Serializable {
	public static ClassMasterSoap toSoapModel(ClassMaster model) {
		ClassMasterSoap soapModel = new ClassMasterSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpClassId(model.getSpClassId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCode(model.getCode());
		soapModel.setCountry(model.getCountry());
		soapModel.setFiledBy(model.getFiledBy());
		soapModel.setCustomField1(model.getCustomField1());
		soapModel.setCustomField2(model.getCustomField2());
		soapModel.setCustomDate1(model.getCustomDate1());
		soapModel.setCustomDate2(model.getCustomDate2());
		soapModel.setVersion(model.getVersion());
		soapModel.setRootSpClassId(model.getRootSpClassId());

		return soapModel;
	}

	public static ClassMasterSoap[] toSoapModels(ClassMaster[] models) {
		ClassMasterSoap[] soapModels = new ClassMasterSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ClassMasterSoap[][] toSoapModels(ClassMaster[][] models) {
		ClassMasterSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ClassMasterSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ClassMasterSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ClassMasterSoap[] toSoapModels(List<ClassMaster> models) {
		List<ClassMasterSoap> soapModels = new ArrayList<ClassMasterSoap>(models.size());

		for (ClassMaster model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ClassMasterSoap[soapModels.size()]);
	}

	public ClassMasterSoap() {
	}

	public long getPrimaryKey() {
		return _spClassId;
	}

	public void setPrimaryKey(long pk) {
		setSpClassId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpClassId() {
		return _spClassId;
	}

	public void setSpClassId(long spClassId) {
		_spClassId = spClassId;
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

	public String getCode() {
		return _code;
	}

	public void setCode(String code) {
		_code = code;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getFiledBy() {
		return _filedBy;
	}

	public void setFiledBy(String filedBy) {
		_filedBy = filedBy;
	}

	public String getCustomField1() {
		return _customField1;
	}

	public void setCustomField1(String customField1) {
		_customField1 = customField1;
	}

	public String getCustomField2() {
		return _customField2;
	}

	public void setCustomField2(String customField2) {
		_customField2 = customField2;
	}

	public Date getCustomDate1() {
		return _customDate1;
	}

	public void setCustomDate1(Date customDate1) {
		_customDate1 = customDate1;
	}

	public Date getCustomDate2() {
		return _customDate2;
	}

	public void setCustomDate2(Date customDate2) {
		_customDate2 = customDate2;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public long getRootSpClassId() {
		return _rootSpClassId;
	}

	public void setRootSpClassId(long rootSpClassId) {
		_rootSpClassId = rootSpClassId;
	}

	private String _uuid;
	private long _spClassId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _code;
	private String _country;
	private String _filedBy;
	private String _customField1;
	private String _customField2;
	private Date _customDate1;
	private Date _customDate2;
	private String _version;
	private long _rootSpClassId;
}