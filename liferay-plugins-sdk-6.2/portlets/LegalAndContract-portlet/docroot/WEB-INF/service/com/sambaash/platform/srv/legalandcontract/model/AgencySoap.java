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
public class AgencySoap implements Serializable {
	public static AgencySoap toSoapModel(Agency model) {
		AgencySoap soapModel = new AgencySoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpAgencyId(model.getSpAgencyId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNumber(model.getNumber());
		soapModel.setCountry(model.getCountry());
		soapModel.setName(model.getName());
		soapModel.setReference(model.getReference());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setAddress(model.getAddress());
		soapModel.setRemarks(model.getRemarks());
		soapModel.setStatus(model.getStatus());
		soapModel.setCustomField1(model.getCustomField1());
		soapModel.setCustomField2(model.getCustomField2());
		soapModel.setCustomField3(model.getCustomField3());
		soapModel.setCustomDate1(model.getCustomDate1());
		soapModel.setCustomDate2(model.getCustomDate2());
		soapModel.setCustomDate3(model.getCustomDate3());
		soapModel.setVersion(model.getVersion());
		soapModel.setRootSpAgencyId(model.getRootSpAgencyId());

		return soapModel;
	}

	public static AgencySoap[] toSoapModels(Agency[] models) {
		AgencySoap[] soapModels = new AgencySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AgencySoap[][] toSoapModels(Agency[][] models) {
		AgencySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AgencySoap[models.length][models[0].length];
		}
		else {
			soapModels = new AgencySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AgencySoap[] toSoapModels(List<Agency> models) {
		List<AgencySoap> soapModels = new ArrayList<AgencySoap>(models.size());

		for (Agency model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AgencySoap[soapModels.size()]);
	}

	public AgencySoap() {
	}

	public long getPrimaryKey() {
		return _spAgencyId;
	}

	public void setPrimaryKey(long pk) {
		setSpAgencyId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpAgencyId() {
		return _spAgencyId;
	}

	public void setSpAgencyId(long spAgencyId) {
		_spAgencyId = spAgencyId;
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

	public String getNumber() {
		return _number;
	}

	public void setNumber(String number) {
		_number = number;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getReference() {
		return _reference;
	}

	public void setReference(String reference) {
		_reference = reference;
	}

	public String getStartDate() {
		return _startDate;
	}

	public void setStartDate(String startDate) {
		_startDate = startDate;
	}

	public String getEndDate() {
		return _endDate;
	}

	public void setEndDate(String endDate) {
		_endDate = endDate;
	}

	public String getAddress() {
		return _address;
	}

	public void setAddress(String address) {
		_address = address;
	}

	public String getRemarks() {
		return _remarks;
	}

	public void setRemarks(String remarks) {
		_remarks = remarks;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
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

	public String getCustomField3() {
		return _customField3;
	}

	public void setCustomField3(String customField3) {
		_customField3 = customField3;
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

	public Date getCustomDate3() {
		return _customDate3;
	}

	public void setCustomDate3(Date customDate3) {
		_customDate3 = customDate3;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public long getRootSpAgencyId() {
		return _rootSpAgencyId;
	}

	public void setRootSpAgencyId(long rootSpAgencyId) {
		_rootSpAgencyId = rootSpAgencyId;
	}

	private String _uuid;
	private long _spAgencyId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _number;
	private String _country;
	private String _name;
	private String _reference;
	private String _startDate;
	private String _endDate;
	private String _address;
	private String _remarks;
	private String _status;
	private String _customField1;
	private String _customField2;
	private String _customField3;
	private Date _customDate1;
	private Date _customDate2;
	private Date _customDate3;
	private String _version;
	private long _rootSpAgencyId;
}