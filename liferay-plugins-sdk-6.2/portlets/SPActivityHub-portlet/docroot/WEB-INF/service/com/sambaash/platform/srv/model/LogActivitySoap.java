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
 * @author aishwarya
 * @generated
 */
public class LogActivitySoap implements Serializable {
	public static LogActivitySoap toSoapModel(LogActivity model) {
		LogActivitySoap soapModel = new LogActivitySoap();

		soapModel.setSpLogActivityId(model.getSpLogActivityId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEntityClassId(model.getEntityClassId());
		soapModel.setEntityClassName(model.getEntityClassName());
		soapModel.setEntityId(model.getEntityId());
		soapModel.setSavedByUserId(model.getSavedByUserId());
		soapModel.setActivityTitle(model.getActivityTitle());
		soapModel.setActivityType(model.getActivityType());
		soapModel.setActivityOutcome(model.getActivityOutcome());
		soapModel.setActivityDate(model.getActivityDate());
		soapModel.setActivityTime(model.getActivityTime());
		soapModel.setActivityContent(model.getActivityContent());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setAssociatedWith(model.getAssociatedWith());
		soapModel.setStatus(model.getStatus());
		soapModel.setParentLogActivityId(model.getParentLogActivityId());

		return soapModel;
	}

	public static LogActivitySoap[] toSoapModels(LogActivity[] models) {
		LogActivitySoap[] soapModels = new LogActivitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LogActivitySoap[][] toSoapModels(LogActivity[][] models) {
		LogActivitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LogActivitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new LogActivitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LogActivitySoap[] toSoapModels(List<LogActivity> models) {
		List<LogActivitySoap> soapModels = new ArrayList<LogActivitySoap>(models.size());

		for (LogActivity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LogActivitySoap[soapModels.size()]);
	}

	public LogActivitySoap() {
	}

	public long getPrimaryKey() {
		return _spLogActivityId;
	}

	public void setPrimaryKey(long pk) {
		setSpLogActivityId(pk);
	}

	public long getSpLogActivityId() {
		return _spLogActivityId;
	}

	public void setSpLogActivityId(long spLogActivityId) {
		_spLogActivityId = spLogActivityId;
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

	public long getEntityClassId() {
		return _entityClassId;
	}

	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;
	}

	public String getEntityClassName() {
		return _entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;
	}

	public long getEntityId() {
		return _entityId;
	}

	public void setEntityId(long entityId) {
		_entityId = entityId;
	}

	public long getSavedByUserId() {
		return _savedByUserId;
	}

	public void setSavedByUserId(long savedByUserId) {
		_savedByUserId = savedByUserId;
	}

	public String getActivityTitle() {
		return _activityTitle;
	}

	public void setActivityTitle(String activityTitle) {
		_activityTitle = activityTitle;
	}

	public String getActivityType() {
		return _activityType;
	}

	public void setActivityType(String activityType) {
		_activityType = activityType;
	}

	public String getActivityOutcome() {
		return _activityOutcome;
	}

	public void setActivityOutcome(String activityOutcome) {
		_activityOutcome = activityOutcome;
	}

	public Date getActivityDate() {
		return _activityDate;
	}

	public void setActivityDate(Date activityDate) {
		_activityDate = activityDate;
	}

	public String getActivityTime() {
		return _activityTime;
	}

	public void setActivityTime(String activityTime) {
		_activityTime = activityTime;
	}

	public String getActivityContent() {
		return _activityContent;
	}

	public void setActivityContent(String activityContent) {
		_activityContent = activityContent;
	}

	public String getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(String fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getAssociatedWith() {
		return _associatedWith;
	}

	public void setAssociatedWith(long associatedWith) {
		_associatedWith = associatedWith;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getParentLogActivityId() {
		return _parentLogActivityId;
	}

	public void setParentLogActivityId(long parentLogActivityId) {
		_parentLogActivityId = parentLogActivityId;
	}

	private long _spLogActivityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _entityClassId;
	private String _entityClassName;
	private long _entityId;
	private long _savedByUserId;
	private String _activityTitle;
	private String _activityType;
	private String _activityOutcome;
	private Date _activityDate;
	private String _activityTime;
	private String _activityContent;
	private String _fileEntryId;
	private long _associatedWith;
	private int _status;
	private long _parentLogActivityId;
}