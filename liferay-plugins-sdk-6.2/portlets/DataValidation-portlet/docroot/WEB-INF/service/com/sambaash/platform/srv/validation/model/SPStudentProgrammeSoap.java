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
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.validation.service.http.SPStudentProgrammeServiceSoap}.
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.validation.service.http.SPStudentProgrammeServiceSoap
 * @generated
 */
public class SPStudentProgrammeSoap implements Serializable {
	public static SPStudentProgrammeSoap toSoapModel(SPStudentProgramme model) {
		SPStudentProgrammeSoap soapModel = new SPStudentProgrammeSoap();

		soapModel.setSpStudentCourseId(model.getSpStudentCourseId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setNric(model.getNric());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setProgramme(model.getProgramme());
		soapModel.setCourseCentre(model.getCourseCentre());
		soapModel.setCourseStartDate(model.getCourseStartDate());
		soapModel.setCourseEndDate(model.getCourseEndDate());

		return soapModel;
	}

	public static SPStudentProgrammeSoap[] toSoapModels(
		SPStudentProgramme[] models) {
		SPStudentProgrammeSoap[] soapModels = new SPStudentProgrammeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPStudentProgrammeSoap[][] toSoapModels(
		SPStudentProgramme[][] models) {
		SPStudentProgrammeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPStudentProgrammeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPStudentProgrammeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPStudentProgrammeSoap[] toSoapModels(
		List<SPStudentProgramme> models) {
		List<SPStudentProgrammeSoap> soapModels = new ArrayList<SPStudentProgrammeSoap>(models.size());

		for (SPStudentProgramme model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPStudentProgrammeSoap[soapModels.size()]);
	}

	public SPStudentProgrammeSoap() {
	}

	public long getPrimaryKey() {
		return _spStudentCourseId;
	}

	public void setPrimaryKey(long pk) {
		setSpStudentCourseId(pk);
	}

	public long getSpStudentCourseId() {
		return _spStudentCourseId;
	}

	public void setSpStudentCourseId(long spStudentCourseId) {
		_spStudentCourseId = spStudentCourseId;
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

	public String getProgramme() {
		return _programme;
	}

	public void setProgramme(String programme) {
		_programme = programme;
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

	private long _spStudentCourseId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _nric;
	private String _emailAddress;
	private String _programme;
	private String _courseCentre;
	private Date _courseStartDate;
	private Date _courseEndDate;
}