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
public class CompetencyUnitSoap implements Serializable {
	public static CompetencyUnitSoap toSoapModel(CompetencyUnit model) {
		CompetencyUnitSoap soapModel = new CompetencyUnitSoap();

		soapModel.setSpCompetencyUnitId(model.getSpCompetencyUnitId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setSpFrameworkId(model.getSpFrameworkId());
		soapModel.setCompetencyUnitCode(model.getCompetencyUnitCode());
		soapModel.setCompetencyUnitDesc(model.getCompetencyUnitDesc());
		soapModel.setJobFamily(model.getJobFamily());
		soapModel.setCompetencyLevel(model.getCompetencyLevel());
		soapModel.setCreditValue(model.getCreditValue());

		return soapModel;
	}

	public static CompetencyUnitSoap[] toSoapModels(CompetencyUnit[] models) {
		CompetencyUnitSoap[] soapModels = new CompetencyUnitSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CompetencyUnitSoap[][] toSoapModels(CompetencyUnit[][] models) {
		CompetencyUnitSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CompetencyUnitSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CompetencyUnitSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CompetencyUnitSoap[] toSoapModels(List<CompetencyUnit> models) {
		List<CompetencyUnitSoap> soapModels = new ArrayList<CompetencyUnitSoap>(models.size());

		for (CompetencyUnit model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CompetencyUnitSoap[soapModels.size()]);
	}

	public CompetencyUnitSoap() {
	}

	public long getPrimaryKey() {
		return _spCompetencyUnitId;
	}

	public void setPrimaryKey(long pk) {
		setSpCompetencyUnitId(pk);
	}

	public long getSpCompetencyUnitId() {
		return _spCompetencyUnitId;
	}

	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_spCompetencyUnitId = spCompetencyUnitId;
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

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public long getSpFrameworkId() {
		return _spFrameworkId;
	}

	public void setSpFrameworkId(long spFrameworkId) {
		_spFrameworkId = spFrameworkId;
	}

	public String getCompetencyUnitCode() {
		return _competencyUnitCode;
	}

	public void setCompetencyUnitCode(String competencyUnitCode) {
		_competencyUnitCode = competencyUnitCode;
	}

	public String getCompetencyUnitDesc() {
		return _competencyUnitDesc;
	}

	public void setCompetencyUnitDesc(String competencyUnitDesc) {
		_competencyUnitDesc = competencyUnitDesc;
	}

	public long getJobFamily() {
		return _jobFamily;
	}

	public void setJobFamily(long jobFamily) {
		_jobFamily = jobFamily;
	}

	public long getCompetencyLevel() {
		return _competencyLevel;
	}

	public void setCompetencyLevel(long competencyLevel) {
		_competencyLevel = competencyLevel;
	}

	public long getCreditValue() {
		return _creditValue;
	}

	public void setCreditValue(long creditValue) {
		_creditValue = creditValue;
	}

	private long _spCompetencyUnitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private long _spFrameworkId;
	private String _competencyUnitCode;
	private String _competencyUnitDesc;
	private long _jobFamily;
	private long _competencyLevel;
	private long _creditValue;
}