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
public class GraduationCriteriaSoap implements Serializable {
	public static GraduationCriteriaSoap toSoapModel(GraduationCriteria model) {
		GraduationCriteriaSoap soapModel = new GraduationCriteriaSoap();

		soapModel.setSpGraduationCriteriaId(model.getSpGraduationCriteriaId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCriteriaType(model.getCriteriaType());
		soapModel.setCriteriaLevel(model.getCriteriaLevel());
		soapModel.setCriteriaValueRange(model.getCriteriaValueRange());
		soapModel.setCriteriaDesc(model.getCriteriaDesc());
		soapModel.setSpCourseId(model.getSpCourseId());

		return soapModel;
	}

	public static GraduationCriteriaSoap[] toSoapModels(
		GraduationCriteria[] models) {
		GraduationCriteriaSoap[] soapModels = new GraduationCriteriaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GraduationCriteriaSoap[][] toSoapModels(
		GraduationCriteria[][] models) {
		GraduationCriteriaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GraduationCriteriaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GraduationCriteriaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GraduationCriteriaSoap[] toSoapModels(
		List<GraduationCriteria> models) {
		List<GraduationCriteriaSoap> soapModels = new ArrayList<GraduationCriteriaSoap>(models.size());

		for (GraduationCriteria model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GraduationCriteriaSoap[soapModels.size()]);
	}

	public GraduationCriteriaSoap() {
	}

	public long getPrimaryKey() {
		return _spGraduationCriteriaId;
	}

	public void setPrimaryKey(long pk) {
		setSpGraduationCriteriaId(pk);
	}

	public long getSpGraduationCriteriaId() {
		return _spGraduationCriteriaId;
	}

	public void setSpGraduationCriteriaId(long spGraduationCriteriaId) {
		_spGraduationCriteriaId = spGraduationCriteriaId;
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

	public long getCriteriaType() {
		return _criteriaType;
	}

	public void setCriteriaType(long criteriaType) {
		_criteriaType = criteriaType;
	}

	public long getCriteriaLevel() {
		return _criteriaLevel;
	}

	public void setCriteriaLevel(long criteriaLevel) {
		_criteriaLevel = criteriaLevel;
	}

	public String getCriteriaValueRange() {
		return _criteriaValueRange;
	}

	public void setCriteriaValueRange(String criteriaValueRange) {
		_criteriaValueRange = criteriaValueRange;
	}

	public String getCriteriaDesc() {
		return _criteriaDesc;
	}

	public void setCriteriaDesc(String criteriaDesc) {
		_criteriaDesc = criteriaDesc;
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	private long _spGraduationCriteriaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _criteriaType;
	private long _criteriaLevel;
	private String _criteriaValueRange;
	private String _criteriaDesc;
	private long _spCourseId;
}