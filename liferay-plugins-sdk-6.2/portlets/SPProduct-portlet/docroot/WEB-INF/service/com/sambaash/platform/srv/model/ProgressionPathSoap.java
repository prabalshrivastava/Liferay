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
public class ProgressionPathSoap implements Serializable {
	public static ProgressionPathSoap toSoapModel(ProgressionPath model) {
		ProgressionPathSoap soapModel = new ProgressionPathSoap();

		soapModel.setSpProgressionPathId(model.getSpProgressionPathId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCareerLevel(model.getCareerLevel());
		soapModel.setLevel(model.getLevel());
		soapModel.setProgressionType(model.getProgressionType());
		soapModel.setProgressionCategory(model.getProgressionCategory());
		soapModel.setStartMonth(model.getStartMonth());
		soapModel.setEndMonth(model.getEndMonth());
		soapModel.setDuration(model.getDuration());
		soapModel.setOptionalMandatory(model.getOptionalMandatory());
		soapModel.setSpCourseId(model.getSpCourseId());

		return soapModel;
	}

	public static ProgressionPathSoap[] toSoapModels(ProgressionPath[] models) {
		ProgressionPathSoap[] soapModels = new ProgressionPathSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProgressionPathSoap[][] toSoapModels(
		ProgressionPath[][] models) {
		ProgressionPathSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProgressionPathSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProgressionPathSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProgressionPathSoap[] toSoapModels(
		List<ProgressionPath> models) {
		List<ProgressionPathSoap> soapModels = new ArrayList<ProgressionPathSoap>(models.size());

		for (ProgressionPath model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProgressionPathSoap[soapModels.size()]);
	}

	public ProgressionPathSoap() {
	}

	public long getPrimaryKey() {
		return _spProgressionPathId;
	}

	public void setPrimaryKey(long pk) {
		setSpProgressionPathId(pk);
	}

	public long getSpProgressionPathId() {
		return _spProgressionPathId;
	}

	public void setSpProgressionPathId(long spProgressionPathId) {
		_spProgressionPathId = spProgressionPathId;
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

	public long getCareerLevel() {
		return _careerLevel;
	}

	public void setCareerLevel(long careerLevel) {
		_careerLevel = careerLevel;
	}

	public int getLevel() {
		return _level;
	}

	public void setLevel(int level) {
		_level = level;
	}

	public long getProgressionType() {
		return _progressionType;
	}

	public void setProgressionType(long progressionType) {
		_progressionType = progressionType;
	}

	public long getProgressionCategory() {
		return _progressionCategory;
	}

	public void setProgressionCategory(long progressionCategory) {
		_progressionCategory = progressionCategory;
	}

	public String getStartMonth() {
		return _startMonth;
	}

	public void setStartMonth(String startMonth) {
		_startMonth = startMonth;
	}

	public String getEndMonth() {
		return _endMonth;
	}

	public void setEndMonth(String endMonth) {
		_endMonth = endMonth;
	}

	public String getDuration() {
		return _duration;
	}

	public void setDuration(String duration) {
		_duration = duration;
	}

	public String getOptionalMandatory() {
		return _optionalMandatory;
	}

	public void setOptionalMandatory(String optionalMandatory) {
		_optionalMandatory = optionalMandatory;
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	private long _spProgressionPathId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _careerLevel;
	private int _level;
	private long _progressionType;
	private long _progressionCategory;
	private String _startMonth;
	private String _endMonth;
	private String _duration;
	private String _optionalMandatory;
	private long _spCourseId;
}