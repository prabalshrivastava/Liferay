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
public class AssessmentSoap implements Serializable {
	public static AssessmentSoap toSoapModel(Assessment model) {
		AssessmentSoap soapModel = new AssessmentSoap();

		soapModel.setSpAssessmentId(model.getSpAssessmentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpModuleId(model.getSpModuleId());
		soapModel.setAssessmentDesc(model.getAssessmentDesc());
		soapModel.setAssessmentType(model.getAssessmentType());
		soapModel.setAssessmentMethod(model.getAssessmentMethod());
		soapModel.setAssessmentMode(model.getAssessmentMode());
		soapModel.setLocationType(model.getLocationType());
		soapModel.setEligibility(model.getEligibility());
		soapModel.setGradingType(model.getGradingType());
		soapModel.setMaximumMarks(model.getMaximumMarks());
		soapModel.setPassingMarks(model.getPassingMarks());

		return soapModel;
	}

	public static AssessmentSoap[] toSoapModels(Assessment[] models) {
		AssessmentSoap[] soapModels = new AssessmentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static AssessmentSoap[][] toSoapModels(Assessment[][] models) {
		AssessmentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new AssessmentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new AssessmentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static AssessmentSoap[] toSoapModels(List<Assessment> models) {
		List<AssessmentSoap> soapModels = new ArrayList<AssessmentSoap>(models.size());

		for (Assessment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new AssessmentSoap[soapModels.size()]);
	}

	public AssessmentSoap() {
	}

	public long getPrimaryKey() {
		return _spAssessmentId;
	}

	public void setPrimaryKey(long pk) {
		setSpAssessmentId(pk);
	}

	public long getSpAssessmentId() {
		return _spAssessmentId;
	}

	public void setSpAssessmentId(long spAssessmentId) {
		_spAssessmentId = spAssessmentId;
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

	public String getAssessmentDesc() {
		return _assessmentDesc;
	}

	public void setAssessmentDesc(String assessmentDesc) {
		_assessmentDesc = assessmentDesc;
	}

	public long getAssessmentType() {
		return _assessmentType;
	}

	public void setAssessmentType(long assessmentType) {
		_assessmentType = assessmentType;
	}

	public long getAssessmentMethod() {
		return _assessmentMethod;
	}

	public void setAssessmentMethod(long assessmentMethod) {
		_assessmentMethod = assessmentMethod;
	}

	public long getAssessmentMode() {
		return _assessmentMode;
	}

	public void setAssessmentMode(long assessmentMode) {
		_assessmentMode = assessmentMode;
	}

	public long getLocationType() {
		return _locationType;
	}

	public void setLocationType(long locationType) {
		_locationType = locationType;
	}

	public String getEligibility() {
		return _eligibility;
	}

	public void setEligibility(String eligibility) {
		_eligibility = eligibility;
	}

	public long getGradingType() {
		return _gradingType;
	}

	public void setGradingType(long gradingType) {
		_gradingType = gradingType;
	}

	public String getMaximumMarks() {
		return _maximumMarks;
	}

	public void setMaximumMarks(String maximumMarks) {
		_maximumMarks = maximumMarks;
	}

	public String getPassingMarks() {
		return _passingMarks;
	}

	public void setPassingMarks(String passingMarks) {
		_passingMarks = passingMarks;
	}

	private long _spAssessmentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private String _assessmentDesc;
	private long _assessmentType;
	private long _assessmentMethod;
	private long _assessmentMode;
	private long _locationType;
	private String _eligibility;
	private long _gradingType;
	private String _maximumMarks;
	private String _passingMarks;
}