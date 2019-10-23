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
public class CourseLearningSoap implements Serializable {
	public static CourseLearningSoap toSoapModel(CourseLearning model) {
		CourseLearningSoap soapModel = new CourseLearningSoap();

		soapModel.setSpCourseLearningId(model.getSpCourseLearningId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpCourseId(model.getSpCourseId());
		soapModel.setIntro(model.getIntro());
		soapModel.setOptionTitle(model.getOptionTitle());
		soapModel.setOption1(model.getOption1());
		soapModel.setOption2(model.getOption2());
		soapModel.setNote(model.getNote());

		return soapModel;
	}

	public static CourseLearningSoap[] toSoapModels(CourseLearning[] models) {
		CourseLearningSoap[] soapModels = new CourseLearningSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseLearningSoap[][] toSoapModels(CourseLearning[][] models) {
		CourseLearningSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseLearningSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseLearningSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseLearningSoap[] toSoapModels(List<CourseLearning> models) {
		List<CourseLearningSoap> soapModels = new ArrayList<CourseLearningSoap>(models.size());

		for (CourseLearning model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseLearningSoap[soapModels.size()]);
	}

	public CourseLearningSoap() {
	}

	public long getPrimaryKey() {
		return _spCourseLearningId;
	}

	public void setPrimaryKey(long pk) {
		setSpCourseLearningId(pk);
	}

	public long getSpCourseLearningId() {
		return _spCourseLearningId;
	}

	public void setSpCourseLearningId(long spCourseLearningId) {
		_spCourseLearningId = spCourseLearningId;
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

	public String getIntro() {
		return _intro;
	}

	public void setIntro(String intro) {
		_intro = intro;
	}

	public String getOptionTitle() {
		return _optionTitle;
	}

	public void setOptionTitle(String optionTitle) {
		_optionTitle = optionTitle;
	}

	public String getOption1() {
		return _option1;
	}

	public void setOption1(String option1) {
		_option1 = option1;
	}

	public String getOption2() {
		return _option2;
	}

	public void setOption2(String option2) {
		_option2 = option2;
	}

	public String getNote() {
		return _note;
	}

	public void setNote(String note) {
		_note = note;
	}

	private long _spCourseLearningId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseId;
	private String _intro;
	private String _optionTitle;
	private String _option1;
	private String _option2;
	private String _note;
}