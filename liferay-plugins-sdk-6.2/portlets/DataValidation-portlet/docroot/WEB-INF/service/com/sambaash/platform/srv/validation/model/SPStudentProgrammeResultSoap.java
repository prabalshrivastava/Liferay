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

package com.sambaash.platform.srv.validation.model;

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
public class SPStudentProgrammeResultSoap implements Serializable {
	public static SPStudentProgrammeResultSoap toSoapModel(
		SPStudentProgrammeResult model) {
		SPStudentProgrammeResultSoap soapModel = new SPStudentProgrammeResultSoap();

		soapModel.setSpStudentProgrammeResultId(model.getSpStudentProgrammeResultId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNric(model.getNric());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setCourseCentre(model.getCourseCentre());
		soapModel.setCourseStartDate(model.getCourseStartDate());
		soapModel.setCourseEndDate(model.getCourseEndDate());
		soapModel.setProgramme(model.getProgramme());
		soapModel.setExam(model.getExam());
		soapModel.setExamType(model.getExamType());
		soapModel.setPaper1Result(model.getPaper1Result());
		soapModel.setPaper2Result(model.getPaper2Result());
		soapModel.setOverallResult(model.getOverallResult());

		return soapModel;
	}

	public static SPStudentProgrammeResultSoap[] toSoapModels(
		SPStudentProgrammeResult[] models) {
		SPStudentProgrammeResultSoap[] soapModels = new SPStudentProgrammeResultSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPStudentProgrammeResultSoap[][] toSoapModels(
		SPStudentProgrammeResult[][] models) {
		SPStudentProgrammeResultSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPStudentProgrammeResultSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPStudentProgrammeResultSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPStudentProgrammeResultSoap[] toSoapModels(
		List<SPStudentProgrammeResult> models) {
		List<SPStudentProgrammeResultSoap> soapModels = new ArrayList<SPStudentProgrammeResultSoap>(models.size());

		for (SPStudentProgrammeResult model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPStudentProgrammeResultSoap[soapModels.size()]);
	}

	public SPStudentProgrammeResultSoap() {
	}

	public long getPrimaryKey() {
		return _spStudentProgrammeResultId;
	}

	public void setPrimaryKey(long pk) {
		setSpStudentProgrammeResultId(pk);
	}

	public long getSpStudentProgrammeResultId() {
		return _spStudentProgrammeResultId;
	}

	public void setSpStudentProgrammeResultId(long spStudentProgrammeResultId) {
		_spStudentProgrammeResultId = spStudentProgrammeResultId;
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

	public String getNric() {
		return _nric;
	}

	public void setNric(String nric) {
		_nric = nric;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getCourseCentre() {
		return _courseCentre;
	}

	public void setCourseCentre(String courseCentre) {
		_courseCentre = courseCentre;
	}

	public Date getCourseStartDate() {
		return _courseStartDate;
	}

	public void setCourseStartDate(Date courseStartDate) {
		_courseStartDate = courseStartDate;
	}

	public Date getCourseEndDate() {
		return _courseEndDate;
	}

	public void setCourseEndDate(Date courseEndDate) {
		_courseEndDate = courseEndDate;
	}

	public String getProgramme() {
		return _programme;
	}

	public void setProgramme(String programme) {
		_programme = programme;
	}

	public Date getExam() {
		return _exam;
	}

	public void setExam(Date exam) {
		_exam = exam;
	}

	public String getExamType() {
		return _examType;
	}

	public void setExamType(String examType) {
		_examType = examType;
	}

	public String getPaper1Result() {
		return _paper1Result;
	}

	public void setPaper1Result(String paper1Result) {
		_paper1Result = paper1Result;
	}

	public String getPaper2Result() {
		return _paper2Result;
	}

	public void setPaper2Result(String paper2Result) {
		_paper2Result = paper2Result;
	}

	public String getOverallResult() {
		return _overallResult;
	}

	public void setOverallResult(String overallResult) {
		_overallResult = overallResult;
	}

	private long _spStudentProgrammeResultId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nric;
	private String _emailAddress;
	private String _courseCentre;
	private Date _courseStartDate;
	private Date _courseEndDate;
	private String _programme;
	private Date _exam;
	private String _examType;
	private String _paper1Result;
	private String _paper2Result;
	private String _overallResult;
}