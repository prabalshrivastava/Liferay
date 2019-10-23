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
public class SPFormAttachmentsSoap implements Serializable {
	public static SPFormAttachmentsSoap toSoapModel(SPFormAttachments model) {
		SPFormAttachmentsSoap soapModel = new SPFormAttachmentsSoap();

		soapModel.setSpFormAttachmentsId(model.getSpFormAttachmentsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFormStorageId(model.getFormStorageId());
		soapModel.setDataKey(model.getDataKey());
		soapModel.setName(model.getName());
		soapModel.setUrl(model.getUrl());
		soapModel.setVersion(model.getVersion());

		return soapModel;
	}

	public static SPFormAttachmentsSoap[] toSoapModels(
		SPFormAttachments[] models) {
		SPFormAttachmentsSoap[] soapModels = new SPFormAttachmentsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPFormAttachmentsSoap[][] toSoapModels(
		SPFormAttachments[][] models) {
		SPFormAttachmentsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPFormAttachmentsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPFormAttachmentsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPFormAttachmentsSoap[] toSoapModels(
		List<SPFormAttachments> models) {
		List<SPFormAttachmentsSoap> soapModels = new ArrayList<SPFormAttachmentsSoap>(models.size());

		for (SPFormAttachments model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPFormAttachmentsSoap[soapModels.size()]);
	}

	public SPFormAttachmentsSoap() {
	}

	public long getPrimaryKey() {
		return _spFormAttachmentsId;
	}

	public void setPrimaryKey(long pk) {
		setSpFormAttachmentsId(pk);
	}

	public long getSpFormAttachmentsId() {
		return _spFormAttachmentsId;
	}

	public void setSpFormAttachmentsId(long spFormAttachmentsId) {
		_spFormAttachmentsId = spFormAttachmentsId;
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

	public long getFormStorageId() {
		return _formStorageId;
	}

	public void setFormStorageId(long formStorageId) {
		_formStorageId = formStorageId;
	}

	public String getDataKey() {
		return _dataKey;
	}

	public void setDataKey(String dataKey) {
		_dataKey = dataKey;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getUrl() {
		return _url;
	}

	public void setUrl(String url) {
		_url = url;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	private long _spFormAttachmentsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _formStorageId;
	private String _dataKey;
	private String _name;
	private String _url;
	private String _version;
}