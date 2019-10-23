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
public class FrameworkSoap implements Serializable {
	public static FrameworkSoap toSoapModel(Framework model) {
		FrameworkSoap soapModel = new FrameworkSoap();

		soapModel.setSpFrameworkId(model.getSpFrameworkId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setFrameworkCode(model.getFrameworkCode());
		soapModel.setFrameworkName(model.getFrameworkName());
		soapModel.setFrameworkImageId(model.getFrameworkImageId());

		return soapModel;
	}

	public static FrameworkSoap[] toSoapModels(Framework[] models) {
		FrameworkSoap[] soapModels = new FrameworkSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FrameworkSoap[][] toSoapModels(Framework[][] models) {
		FrameworkSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FrameworkSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FrameworkSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FrameworkSoap[] toSoapModels(List<Framework> models) {
		List<FrameworkSoap> soapModels = new ArrayList<FrameworkSoap>(models.size());

		for (Framework model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FrameworkSoap[soapModels.size()]);
	}

	public FrameworkSoap() {
	}

	public long getPrimaryKey() {
		return _spFrameworkId;
	}

	public void setPrimaryKey(long pk) {
		setSpFrameworkId(pk);
	}

	public long getSpFrameworkId() {
		return _spFrameworkId;
	}

	public void setSpFrameworkId(long spFrameworkId) {
		_spFrameworkId = spFrameworkId;
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

	public String getFrameworkCode() {
		return _frameworkCode;
	}

	public void setFrameworkCode(String frameworkCode) {
		_frameworkCode = frameworkCode;
	}

	public String getFrameworkName() {
		return _frameworkName;
	}

	public void setFrameworkName(String frameworkName) {
		_frameworkName = frameworkName;
	}

	public Long getFrameworkImageId() {
		return _frameworkImageId;
	}

	public void setFrameworkImageId(Long frameworkImageId) {
		_frameworkImageId = frameworkImageId;
	}

	private long _spFrameworkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private String _frameworkCode;
	private String _frameworkName;
	private Long _frameworkImageId;
}