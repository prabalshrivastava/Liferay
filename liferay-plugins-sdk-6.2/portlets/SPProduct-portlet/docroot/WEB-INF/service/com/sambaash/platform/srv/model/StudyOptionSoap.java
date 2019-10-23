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
public class StudyOptionSoap implements Serializable {
	public static StudyOptionSoap toSoapModel(StudyOption model) {
		StudyOptionSoap soapModel = new StudyOptionSoap();

		soapModel.setSpStudyOptionId(model.getSpStudyOptionId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpCourseId(model.getSpCourseId());
		soapModel.setTitle(model.getTitle());
		soapModel.setDesc(model.getDesc());
		soapModel.setCoverImageFileEntryId(model.getCoverImageFileEntryId());

		return soapModel;
	}

	public static StudyOptionSoap[] toSoapModels(StudyOption[] models) {
		StudyOptionSoap[] soapModels = new StudyOptionSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StudyOptionSoap[][] toSoapModels(StudyOption[][] models) {
		StudyOptionSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StudyOptionSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StudyOptionSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StudyOptionSoap[] toSoapModels(List<StudyOption> models) {
		List<StudyOptionSoap> soapModels = new ArrayList<StudyOptionSoap>(models.size());

		for (StudyOption model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StudyOptionSoap[soapModels.size()]);
	}

	public StudyOptionSoap() {
	}

	public long getPrimaryKey() {
		return _spStudyOptionId;
	}

	public void setPrimaryKey(long pk) {
		setSpStudyOptionId(pk);
	}

	public long getSpStudyOptionId() {
		return _spStudyOptionId;
	}

	public void setSpStudyOptionId(long spStudyOptionId) {
		_spStudyOptionId = spStudyOptionId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDesc() {
		return _desc;
	}

	public void setDesc(String desc) {
		_desc = desc;
	}

	public long getCoverImageFileEntryId() {
		return _coverImageFileEntryId;
	}

	public void setCoverImageFileEntryId(long coverImageFileEntryId) {
		_coverImageFileEntryId = coverImageFileEntryId;
	}

	private long _spStudyOptionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseId;
	private String _title;
	private String _desc;
	private long _coverImageFileEntryId;
}