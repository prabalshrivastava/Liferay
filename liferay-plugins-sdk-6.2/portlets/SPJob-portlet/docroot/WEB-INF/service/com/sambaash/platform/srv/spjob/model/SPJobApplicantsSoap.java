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

package com.sambaash.platform.srv.spjob.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author harini
 * @generated
 */
public class SPJobApplicantsSoap implements Serializable {
	public static SPJobApplicantsSoap toSoapModel(SPJobApplicants model) {
		SPJobApplicantsSoap soapModel = new SPJobApplicantsSoap();

		soapModel.setSpJobApplicantsId(model.getSpJobApplicantsId());
		soapModel.setJobId(model.getJobId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setYearsOfExperience(model.getYearsOfExperience());
		soapModel.setResume(model.getResume());
		soapModel.setCoverLetter(model.getCoverLetter());
		soapModel.setBriefInfos(model.getBriefInfos());
		soapModel.setExtra1(model.getExtra1());
		soapModel.setExtra2(model.getExtra2());
		soapModel.setExtra3(model.getExtra3());
		soapModel.setExtra4(model.getExtra4());
		soapModel.setExtra5(model.getExtra5());

		return soapModel;
	}

	public static SPJobApplicantsSoap[] toSoapModels(SPJobApplicants[] models) {
		SPJobApplicantsSoap[] soapModels = new SPJobApplicantsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPJobApplicantsSoap[][] toSoapModels(
		SPJobApplicants[][] models) {
		SPJobApplicantsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPJobApplicantsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPJobApplicantsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPJobApplicantsSoap[] toSoapModels(
		List<SPJobApplicants> models) {
		List<SPJobApplicantsSoap> soapModels = new ArrayList<SPJobApplicantsSoap>(models.size());

		for (SPJobApplicants model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPJobApplicantsSoap[soapModels.size()]);
	}

	public SPJobApplicantsSoap() {
	}

	public long getPrimaryKey() {
		return _spJobApplicantsId;
	}

	public void setPrimaryKey(long pk) {
		setSpJobApplicantsId(pk);
	}

	public long getSpJobApplicantsId() {
		return _spJobApplicantsId;
	}

	public void setSpJobApplicantsId(long spJobApplicantsId) {
		_spJobApplicantsId = spJobApplicantsId;
	}

	public long getJobId() {
		return _jobId;
	}

	public void setJobId(long jobId) {
		_jobId = jobId;
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

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public long getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		_updatedBy = updatedBy;
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

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		_contactNumber = contactNumber;
	}

	public String getYearsOfExperience() {
		return _yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		_yearsOfExperience = yearsOfExperience;
	}

	public String getResume() {
		return _resume;
	}

	public void setResume(String resume) {
		_resume = resume;
	}

	public String getCoverLetter() {
		return _coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		_coverLetter = coverLetter;
	}

	public String getBriefInfos() {
		return _briefInfos;
	}

	public void setBriefInfos(String briefInfos) {
		_briefInfos = briefInfos;
	}

	public String getExtra1() {
		return _extra1;
	}

	public void setExtra1(String extra1) {
		_extra1 = extra1;
	}

	public String getExtra2() {
		return _extra2;
	}

	public void setExtra2(String extra2) {
		_extra2 = extra2;
	}

	public String getExtra3() {
		return _extra3;
	}

	public void setExtra3(String extra3) {
		_extra3 = extra3;
	}

	public String getExtra4() {
		return _extra4;
	}

	public void setExtra4(String extra4) {
		_extra4 = extra4;
	}

	public String getExtra5() {
		return _extra5;
	}

	public void setExtra5(String extra5) {
		_extra5 = extra5;
	}

	private long _spJobApplicantsId;
	private long _jobId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private long _createdBy;
	private long _updatedBy;
	private Date _createDate;
	private Date _modifiedDate;
	private String _firstName;
	private String _lastName;
	private String _emailAddress;
	private String _contactNumber;
	private String _yearsOfExperience;
	private String _resume;
	private String _coverLetter;
	private String _briefInfos;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private String _extra5;
}