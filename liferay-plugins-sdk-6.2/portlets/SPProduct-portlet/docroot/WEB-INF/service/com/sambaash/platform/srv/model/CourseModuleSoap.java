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
public class CourseModuleSoap implements Serializable {
	public static CourseModuleSoap toSoapModel(CourseModule model) {
		CourseModuleSoap soapModel = new CourseModuleSoap();

		soapModel.setSpCourseModuleId(model.getSpCourseModuleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpCourseId(model.getSpCourseId());
		soapModel.setSpModuleId(model.getSpModuleId());

		return soapModel;
	}

	public static CourseModuleSoap[] toSoapModels(CourseModule[] models) {
		CourseModuleSoap[] soapModels = new CourseModuleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseModuleSoap[][] toSoapModels(CourseModule[][] models) {
		CourseModuleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseModuleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseModuleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseModuleSoap[] toSoapModels(List<CourseModule> models) {
		List<CourseModuleSoap> soapModels = new ArrayList<CourseModuleSoap>(models.size());

		for (CourseModule model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseModuleSoap[soapModels.size()]);
	}

	public CourseModuleSoap() {
	}

	public long getPrimaryKey() {
		return _spCourseModuleId;
	}

	public void setPrimaryKey(long pk) {
		setSpCourseModuleId(pk);
	}

	public long getSpCourseModuleId() {
		return _spCourseModuleId;
	}

	public void setSpCourseModuleId(long spCourseModuleId) {
		_spCourseModuleId = spCourseModuleId;
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

	public long getSpModuleId() {
		return _spModuleId;
	}

	public void setSpModuleId(long spModuleId) {
		_spModuleId = spModuleId;
	}

	private long _spCourseModuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseId;
	private long _spModuleId;
}