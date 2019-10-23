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
public class SPApiAuditLogsSoap implements Serializable {
	public static SPApiAuditLogsSoap toSoapModel(SPApiAuditLogs model) {
		SPApiAuditLogsSoap soapModel = new SPApiAuditLogsSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpApiAuditLogsId(model.getSpApiAuditLogsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setApiName(model.getApiName());
		soapModel.setParameters(model.getParameters());
		soapModel.setResult(model.getResult());

		return soapModel;
	}

	public static SPApiAuditLogsSoap[] toSoapModels(SPApiAuditLogs[] models) {
		SPApiAuditLogsSoap[] soapModels = new SPApiAuditLogsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPApiAuditLogsSoap[][] toSoapModels(SPApiAuditLogs[][] models) {
		SPApiAuditLogsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPApiAuditLogsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPApiAuditLogsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPApiAuditLogsSoap[] toSoapModels(List<SPApiAuditLogs> models) {
		List<SPApiAuditLogsSoap> soapModels = new ArrayList<SPApiAuditLogsSoap>(models.size());

		for (SPApiAuditLogs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPApiAuditLogsSoap[soapModels.size()]);
	}

	public SPApiAuditLogsSoap() {
	}

	public long getPrimaryKey() {
		return _spApiAuditLogsId;
	}

	public void setPrimaryKey(long pk) {
		setSpApiAuditLogsId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpApiAuditLogsId() {
		return _spApiAuditLogsId;
	}

	public void setSpApiAuditLogsId(long spApiAuditLogsId) {
		_spApiAuditLogsId = spApiAuditLogsId;
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

	public String getApiName() {
		return _apiName;
	}

	public void setApiName(String apiName) {
		_apiName = apiName;
	}

	public String getParameters() {
		return _parameters;
	}

	public void setParameters(String parameters) {
		_parameters = parameters;
	}

	public String getResult() {
		return _result;
	}

	public void setResult(String result) {
		_result = result;
	}

	private String _uuid;
	private long _spApiAuditLogsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _apiName;
	private String _parameters;
	private String _result;
}