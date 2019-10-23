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
public class SPJobSoap implements Serializable {
	public static SPJobSoap toSoapModel(SPJob model) {
		SPJobSoap soapModel = new SPJobSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpJobId(model.getSpJobId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUpdatedBy(model.getUpdatedBy());
		soapModel.setYearsOfExperience(model.getYearsOfExperience());
		soapModel.setCorporateName(model.getCorporateName());
		soapModel.setCorporateId(model.getCorporateId());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setJobType(model.getJobType());
		soapModel.setJobLocation(model.getJobLocation());
		soapModel.setJobDescription(model.getJobDescription());
		soapModel.setStatus(model.getStatus());
		soapModel.setAutoMatch(model.getAutoMatch());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setSalary(model.getSalary());
		soapModel.setRate(model.getRate());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setClosingDate(model.getClosingDate());
		soapModel.setExtra1(model.getExtra1());
		soapModel.setExtra2(model.getExtra2());
		soapModel.setExtra3(model.getExtra3());
		soapModel.setExtra4(model.getExtra4());
		soapModel.setExtra5(model.getExtra5());
		soapModel.setNotefto(model.getNotefto());

		return soapModel;
	}

	public static SPJobSoap[] toSoapModels(SPJob[] models) {
		SPJobSoap[] soapModels = new SPJobSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPJobSoap[][] toSoapModels(SPJob[][] models) {
		SPJobSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPJobSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPJobSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPJobSoap[] toSoapModels(List<SPJob> models) {
		List<SPJobSoap> soapModels = new ArrayList<SPJobSoap>(models.size());

		for (SPJob model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPJobSoap[soapModels.size()]);
	}

	public SPJobSoap() {
	}

	public long getPrimaryKey() {
		return _spJobId;
	}

	public void setPrimaryKey(long pk) {
		setSpJobId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpJobId() {
		return _spJobId;
	}

	public void setSpJobId(long spJobId) {
		_spJobId = spJobId;
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

	public long getUpdatedBy() {
		return _updatedBy;
	}

	public void setUpdatedBy(long updatedBy) {
		_updatedBy = updatedBy;
	}

	public String getYearsOfExperience() {
		return _yearsOfExperience;
	}

	public void setYearsOfExperience(String yearsOfExperience) {
		_yearsOfExperience = yearsOfExperience;
	}

	public String getCorporateName() {
		return _corporateName;
	}

	public void setCorporateName(String corporateName) {
		_corporateName = corporateName;
	}

	public long getCorporateId() {
		return _corporateId;
	}

	public void setCorporateId(long corporateId) {
		_corporateId = corporateId;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getJobType() {
		return _jobType;
	}

	public void setJobType(String jobType) {
		_jobType = jobType;
	}

	public String getJobLocation() {
		return _jobLocation;
	}

	public void setJobLocation(String jobLocation) {
		_jobLocation = jobLocation;
	}

	public String getJobDescription() {
		return _jobDescription;
	}

	public void setJobDescription(String jobDescription) {
		_jobDescription = jobDescription;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public boolean getAutoMatch() {
		return _autoMatch;
	}

	public boolean isAutoMatch() {
		return _autoMatch;
	}

	public void setAutoMatch(boolean autoMatch) {
		_autoMatch = autoMatch;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public double getSalary() {
		return _salary;
	}

	public void setSalary(double salary) {
		_salary = salary;
	}

	public String getRate() {
		return _rate;
	}

	public void setRate(String rate) {
		_rate = rate;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public Date getClosingDate() {
		return _closingDate;
	}

	public void setClosingDate(Date closingDate) {
		_closingDate = closingDate;
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

	public String getNotefto() {
		return _notefto;
	}

	public void setNotefto(String notefto) {
		_notefto = notefto;
	}

	private String _uuid;
	private long _spJobId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private long _createdBy;
	private Date _createDate;
	private Date _modifiedDate;
	private long _updatedBy;
	private String _yearsOfExperience;
	private String _corporateName;
	private long _corporateId;
	private String _jobTitle;
	private String _jobType;
	private String _jobLocation;
	private String _jobDescription;
	private String _status;
	private boolean _autoMatch;
	private String _currency;
	private double _salary;
	private String _rate;
	private Date _startDate;
	private Date _endDate;
	private Date _closingDate;
	private String _extra1;
	private String _extra2;
	private String _extra3;
	private String _extra4;
	private String _extra5;
	private String _notefto;
}