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

package com.sambaash.platform.srv.spdynamicforms.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author glenn
 * @generated
 */
public class SPFormStorageSoap implements Serializable {
	public static SPFormStorageSoap toSoapModel(SPFormStorage model) {
		SPFormStorageSoap soapModel = new SPFormStorageSoap();

		soapModel.setFormStorageId(model.getFormStorageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApplicationId(model.getApplicationId());
		soapModel.setContent(model.getContent());
		soapModel.setHtmlFormId(model.getHtmlFormId());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SPFormStorageSoap[] toSoapModels(SPFormStorage[] models) {
		SPFormStorageSoap[] soapModels = new SPFormStorageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPFormStorageSoap[][] toSoapModels(SPFormStorage[][] models) {
		SPFormStorageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPFormStorageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPFormStorageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPFormStorageSoap[] toSoapModels(List<SPFormStorage> models) {
		List<SPFormStorageSoap> soapModels = new ArrayList<SPFormStorageSoap>(models.size());

		for (SPFormStorage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPFormStorageSoap[soapModels.size()]);
	}

	public SPFormStorageSoap() {
	}

	public long getPrimaryKey() {
		return _formStorageId;
	}

	public void setPrimaryKey(long pk) {
		setFormStorageId(pk);
	}

	public long getFormStorageId() {
		return _formStorageId;
	}

	public void setFormStorageId(long formStorageId) {
		_formStorageId = formStorageId;
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

	public String getApplicationId() {
		return _applicationId;
	}

	public void setApplicationId(String applicationId) {
		_applicationId = applicationId;
	}

	public String getContent() {
		return _content;
	}

	public void setContent(String content) {
		_content = content;
	}

	public long getHtmlFormId() {
		return _htmlFormId;
	}

	public void setHtmlFormId(long htmlFormId) {
		_htmlFormId = htmlFormId;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _formStorageId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _applicationId;
	private String _content;
	private long _htmlFormId;
	private String _status;
}