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
public class ActivitySoap implements Serializable {
	public static ActivitySoap toSoapModel(Activity model) {
		ActivitySoap soapModel = new ActivitySoap();

		soapModel.setSpActivityId(model.getSpActivityId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpModuleId(model.getSpModuleId());
		soapModel.setSpScheduleId(model.getSpScheduleId());
		soapModel.setDescription(model.getDescription());
		soapModel.setActivityTiming(model.getActivityTiming());
		soapModel.setActivityPerformer(model.getActivityPerformer());
		soapModel.setActivityDuration(model.getActivityDuration());

		return soapModel;
	}

	public static ActivitySoap[] toSoapModels(Activity[] models) {
		ActivitySoap[] soapModels = new ActivitySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ActivitySoap[][] toSoapModels(Activity[][] models) {
		ActivitySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ActivitySoap[models.length][models[0].length];
		}
		else {
			soapModels = new ActivitySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ActivitySoap[] toSoapModels(List<Activity> models) {
		List<ActivitySoap> soapModels = new ArrayList<ActivitySoap>(models.size());

		for (Activity model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ActivitySoap[soapModels.size()]);
	}

	public ActivitySoap() {
	}

	public long getPrimaryKey() {
		return _spActivityId;
	}

	public void setPrimaryKey(long pk) {
		setSpActivityId(pk);
	}

	public long getSpActivityId() {
		return _spActivityId;
	}

	public void setSpActivityId(long spActivityId) {
		_spActivityId = spActivityId;
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

	public long getSpScheduleId() {
		return _spScheduleId;
	}

	public void setSpScheduleId(long spScheduleId) {
		_spScheduleId = spScheduleId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getActivityTiming() {
		return _activityTiming;
	}

	public void setActivityTiming(String activityTiming) {
		_activityTiming = activityTiming;
	}

	public String getActivityPerformer() {
		return _activityPerformer;
	}

	public void setActivityPerformer(String activityPerformer) {
		_activityPerformer = activityPerformer;
	}

	public String getActivityDuration() {
		return _activityDuration;
	}

	public void setActivityDuration(String activityDuration) {
		_activityDuration = activityDuration;
	}

	private long _spActivityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private long _spScheduleId;
	private String _description;
	private String _activityTiming;
	private String _activityPerformer;
	private String _activityDuration;
}