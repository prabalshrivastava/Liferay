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
public class CourseDurationTypeSoap implements Serializable {
	public static CourseDurationTypeSoap toSoapModel(CourseDurationType model) {
		CourseDurationTypeSoap soapModel = new CourseDurationTypeSoap();

		soapModel.setSpCourseDurationTypeId(model.getSpCourseDurationTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpCourseDurationId(model.getSpCourseDurationId());
		soapModel.setSpCourseId(model.getSpCourseId());
		soapModel.setTitle1(model.getTitle1());
		soapModel.setDuration1(model.getDuration1());
		soapModel.setTitle2(model.getTitle2());
		soapModel.setDuration2(model.getDuration2());

		return soapModel;
	}

	public static CourseDurationTypeSoap[] toSoapModels(
		CourseDurationType[] models) {
		CourseDurationTypeSoap[] soapModels = new CourseDurationTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseDurationTypeSoap[][] toSoapModels(
		CourseDurationType[][] models) {
		CourseDurationTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseDurationTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseDurationTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseDurationTypeSoap[] toSoapModels(
		List<CourseDurationType> models) {
		List<CourseDurationTypeSoap> soapModels = new ArrayList<CourseDurationTypeSoap>(models.size());

		for (CourseDurationType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseDurationTypeSoap[soapModels.size()]);
	}

	public CourseDurationTypeSoap() {
	}

	public long getPrimaryKey() {
		return _spCourseDurationTypeId;
	}

	public void setPrimaryKey(long pk) {
		setSpCourseDurationTypeId(pk);
	}

	public long getSpCourseDurationTypeId() {
		return _spCourseDurationTypeId;
	}

	public void setSpCourseDurationTypeId(long spCourseDurationTypeId) {
		_spCourseDurationTypeId = spCourseDurationTypeId;
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

	public long getSpCourseDurationId() {
		return _spCourseDurationId;
	}

	public void setSpCourseDurationId(long spCourseDurationId) {
		_spCourseDurationId = spCourseDurationId;
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	public String getTitle1() {
		return _title1;
	}

	public void setTitle1(String title1) {
		_title1 = title1;
	}

	public String getDuration1() {
		return _duration1;
	}

	public void setDuration1(String duration1) {
		_duration1 = duration1;
	}

	public String getTitle2() {
		return _title2;
	}

	public void setTitle2(String title2) {
		_title2 = title2;
	}

	public String getDuration2() {
		return _duration2;
	}

	public void setDuration2(String duration2) {
		_duration2 = duration2;
	}

	private long _spCourseDurationTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseDurationId;
	private long _spCourseId;
	private String _title1;
	private String _duration1;
	private String _title2;
	private String _duration2;
}