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

package com.sambaash.platform.srv.roles.model;

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
public class SPRolesSoap implements Serializable {
	public static SPRolesSoap toSoapModel(SPRoles model) {
		SPRolesSoap soapModel = new SPRolesSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpRoleId(model.getSpRoleId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRoleId(model.getRoleId());
		soapModel.setCategoryId1(model.getCategoryId1());
		soapModel.setCategoryId2(model.getCategoryId2());
		soapModel.setCountryCategoryId(model.getCountryCategoryId());
		soapModel.setDepartmentCategoryId(model.getDepartmentCategoryId());

		return soapModel;
	}

	public static SPRolesSoap[] toSoapModels(SPRoles[] models) {
		SPRolesSoap[] soapModels = new SPRolesSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPRolesSoap[][] toSoapModels(SPRoles[][] models) {
		SPRolesSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPRolesSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPRolesSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPRolesSoap[] toSoapModels(List<SPRoles> models) {
		List<SPRolesSoap> soapModels = new ArrayList<SPRolesSoap>(models.size());

		for (SPRoles model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPRolesSoap[soapModels.size()]);
	}

	public SPRolesSoap() {
	}

	public long getPrimaryKey() {
		return _spRoleId;
	}

	public void setPrimaryKey(long pk) {
		setSpRoleId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpRoleId() {
		return _spRoleId;
	}

	public void setSpRoleId(long spRoleId) {
		_spRoleId = spRoleId;
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

	public long getRoleId() {
		return _roleId;
	}

	public void setRoleId(long roleId) {
		_roleId = roleId;
	}

	public long getCategoryId1() {
		return _categoryId1;
	}

	public void setCategoryId1(long categoryId1) {
		_categoryId1 = categoryId1;
	}

	public long getCategoryId2() {
		return _categoryId2;
	}

	public void setCategoryId2(long categoryId2) {
		_categoryId2 = categoryId2;
	}

	public long getCountryCategoryId() {
		return _countryCategoryId;
	}

	public void setCountryCategoryId(long countryCategoryId) {
		_countryCategoryId = countryCategoryId;
	}

	public long getDepartmentCategoryId() {
		return _departmentCategoryId;
	}

	public void setDepartmentCategoryId(long departmentCategoryId) {
		_departmentCategoryId = departmentCategoryId;
	}

	private String _uuid;
	private long _spRoleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _roleId;
	private long _categoryId1;
	private long _categoryId2;
	private long _countryCategoryId;
	private long _departmentCategoryId;
}