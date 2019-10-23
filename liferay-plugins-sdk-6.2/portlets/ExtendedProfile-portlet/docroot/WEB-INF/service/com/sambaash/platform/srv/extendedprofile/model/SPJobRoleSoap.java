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
public class SPJobRoleSoap implements Serializable {
	public static SPJobRoleSoap toSoapModel(SPJobRole model) {
		SPJobRoleSoap soapModel = new SPJobRoleSoap();

		soapModel.setSpJobRoleId(model.getSpJobRoleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFunctionalGroupId(model.getFunctionalGroupId());
		soapModel.setJobLevelId(model.getJobLevelId());
		soapModel.setCareerPathId(model.getCareerPathId());

		return soapModel;
	}

	public static SPJobRoleSoap[] toSoapModels(SPJobRole[] models) {
		SPJobRoleSoap[] soapModels = new SPJobRoleSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPJobRoleSoap[][] toSoapModels(SPJobRole[][] models) {
		SPJobRoleSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPJobRoleSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPJobRoleSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPJobRoleSoap[] toSoapModels(List<SPJobRole> models) {
		List<SPJobRoleSoap> soapModels = new ArrayList<SPJobRoleSoap>(models.size());

		for (SPJobRole model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPJobRoleSoap[soapModels.size()]);
	}

	public SPJobRoleSoap() {
	}

	public long getPrimaryKey() {
		return _spJobRoleId;
	}

	public void setPrimaryKey(long pk) {
		setSpJobRoleId(pk);
	}

	public long getSpJobRoleId() {
		return _spJobRoleId;
	}

	public void setSpJobRoleId(long spJobRoleId) {
		_spJobRoleId = spJobRoleId;
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

	public long getFunctionalGroupId() {
		return _functionalGroupId;
	}

	public void setFunctionalGroupId(long functionalGroupId) {
		_functionalGroupId = functionalGroupId;
	}

	public long getJobLevelId() {
		return _JobLevelId;
	}

	public void setJobLevelId(long JobLevelId) {
		_JobLevelId = JobLevelId;
	}

	public long getCareerPathId() {
		return _careerPathId;
	}

	public void setCareerPathId(long careerPathId) {
		_careerPathId = careerPathId;
	}

	private long _spJobRoleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _functionalGroupId;
	private long _JobLevelId;
	private long _careerPathId;
}