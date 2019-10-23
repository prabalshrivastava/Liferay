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
public class ScheduleSoap implements Serializable {
	public static ScheduleSoap toSoapModel(Schedule model) {
		ScheduleSoap soapModel = new ScheduleSoap();

		soapModel.setSpScheduleId(model.getSpScheduleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpModuleId(model.getSpModuleId());
		soapModel.setSessionNumber(model.getSessionNumber());
		soapModel.setDescription(model.getDescription());
		soapModel.setSessionType(model.getSessionType());
		soapModel.setSessionDuration(model.getSessionDuration());

		return soapModel;
	}

	public static ScheduleSoap[] toSoapModels(Schedule[] models) {
		ScheduleSoap[] soapModels = new ScheduleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ScheduleSoap[][] toSoapModels(Schedule[][] models) {
		ScheduleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ScheduleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ScheduleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ScheduleSoap[] toSoapModels(List<Schedule> models) {
		List<ScheduleSoap> soapModels = new ArrayList<ScheduleSoap>(models.size());

		for (Schedule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ScheduleSoap[soapModels.size()]);
	}

	public ScheduleSoap() {
	}

	public long getPrimaryKey() {
		return _spScheduleId;
	}

	public void setPrimaryKey(long pk) {
		setSpScheduleId(pk);
	}

	public long getSpScheduleId() {
		return _spScheduleId;
	}

	public void setSpScheduleId(long spScheduleId) {
		_spScheduleId = spScheduleId;
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

	public String getSessionNumber() {
		return _sessionNumber;
	}

	public void setSessionNumber(String sessionNumber) {
		_sessionNumber = sessionNumber;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getSessionType() {
		return _sessionType;
	}

	public void setSessionType(long sessionType) {
		_sessionType = sessionType;
	}

	public String getSessionDuration() {
		return _sessionDuration;
	}

	public void setSessionDuration(String sessionDuration) {
		_sessionDuration = sessionDuration;
	}

	private long _spScheduleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private String _sessionNumber;
	private String _description;
	private long _sessionType;
	private String _sessionDuration;
}