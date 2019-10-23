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
public class CourseDurationSoap implements Serializable {
	public static CourseDurationSoap toSoapModel(CourseDuration model) {
		CourseDurationSoap soapModel = new CourseDurationSoap();

		soapModel.setSpCourseDurationId(model.getSpCourseDurationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpCourseId(model.getSpCourseId());
		soapModel.setSpCourseLearningId(model.getSpCourseLearningId());
		soapModel.setTitle(model.getTitle());

		return soapModel;
	}

	public static CourseDurationSoap[] toSoapModels(CourseDuration[] models) {
		CourseDurationSoap[] soapModels = new CourseDurationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseDurationSoap[][] toSoapModels(CourseDuration[][] models) {
		CourseDurationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseDurationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseDurationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseDurationSoap[] toSoapModels(List<CourseDuration> models) {
		List<CourseDurationSoap> soapModels = new ArrayList<CourseDurationSoap>(models.size());

		for (CourseDuration model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseDurationSoap[soapModels.size()]);
	}

	public CourseDurationSoap() {
	}

	public long getPrimaryKey() {
		return _spCourseDurationId;
	}

	public void setPrimaryKey(long pk) {
		setSpCourseDurationId(pk);
	}

	public long getSpCourseDurationId() {
		return _spCourseDurationId;
	}

	public void setSpCourseDurationId(long spCourseDurationId) {
		_spCourseDurationId = spCourseDurationId;
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

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	public long getSpCourseLearningId() {
		return _spCourseLearningId;
	}

	public void setSpCourseLearningId(long spCourseLearningId) {
		_spCourseLearningId = spCourseLearningId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	private long _spCourseDurationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseId;
	private long _spCourseLearningId;
	private String _title;
}