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

package com.sambaash.platform.srv.extendedprofile.model;

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
public class SPCompetencySoap implements Serializable {
	public static SPCompetencySoap toSoapModel(SPCompetency model) {
		SPCompetencySoap soapModel = new SPCompetencySoap();

		soapModel.setClasspk(model.getClasspk());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setCompetencyId(model.getCompetencyId());
		soapModel.setCompetencyLevelId(model.getCompetencyLevelId());
		soapModel.setBelongsToJobRole(model.getBelongsToJobRole());
		soapModel.setPublicView(model.getPublicView());

		return soapModel;
	}

	public static SPCompetencySoap[] toSoapModels(SPCompetency[] models) {
		SPCompetencySoap[] soapModels = new SPCompetencySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPCompetencySoap[][] toSoapModels(SPCompetency[][] models) {
		SPCompetencySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPCompetencySoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPCompetencySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPCompetencySoap[] toSoapModels(List<SPCompetency> models) {
		List<SPCompetencySoap> soapModels = new ArrayList<SPCompetencySoap>(models.size());

		for (SPCompetency model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPCompetencySoap[soapModels.size()]);
	}

	public SPCompetencySoap() {
	}

	public long getPrimaryKey() {
		return _classpk;
	}

	public void setPrimaryKey(long pk) {
		setClasspk(pk);
	}

	public long getClasspk() {
		return _classpk;
	}

	public void setClasspk(long classpk) {
		_classpk = classpk;
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

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public long getCompetencyId() {
		return _competencyId;
	}

	public void setCompetencyId(long competencyId) {
		_competencyId = competencyId;
	}

	public long getCompetencyLevelId() {
		return _competencyLevelId;
	}

	public void setCompetencyLevelId(long competencyLevelId) {
		_competencyLevelId = competencyLevelId;
	}

	public long getBelongsToJobRole() {
		return _belongsToJobRole;
	}

	public void setBelongsToJobRole(long belongsToJobRole) {
		_belongsToJobRole = belongsToJobRole;
	}

	public boolean getPublicView() {
		return _publicView;
	}

	public boolean isPublicView() {
		return _publicView;
	}

	public void setPublicView(boolean publicView) {
		_publicView = publicView;
	}

	private long _classpk;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _categoryId;
	private long _competencyId;
	private long _competencyLevelId;
	private long _belongsToJobRole;
	private boolean _publicView;
}