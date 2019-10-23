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

package com.sambaash.platform.srv.spservices.model;

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
public class SPLdapMappingSoap implements Serializable {
	public static SPLdapMappingSoap toSoapModel(SPLdapMapping model) {
		SPLdapMappingSoap soapModel = new SPLdapMappingSoap();

		soapModel.setSpLdapMappingId(model.getSpLdapMappingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setCountryDepartmentId(model.getCountryDepartmentId());
		soapModel.setLdapCountry(model.getLdapCountry());
		soapModel.setLdapDepartment(model.getLdapDepartment());
		soapModel.setLdapCompany(model.getLdapCompany());
		soapModel.setDefaultRoleId(model.getDefaultRoleId());

		return soapModel;
	}

	public static SPLdapMappingSoap[] toSoapModels(SPLdapMapping[] models) {
		SPLdapMappingSoap[] soapModels = new SPLdapMappingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPLdapMappingSoap[][] toSoapModels(SPLdapMapping[][] models) {
		SPLdapMappingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPLdapMappingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPLdapMappingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPLdapMappingSoap[] toSoapModels(List<SPLdapMapping> models) {
		List<SPLdapMappingSoap> soapModels = new ArrayList<SPLdapMappingSoap>(models.size());

		for (SPLdapMapping model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPLdapMappingSoap[soapModels.size()]);
	}

	public SPLdapMappingSoap() {
	}

	public long getPrimaryKey() {
		return _spLdapMappingId;
	}

	public void setPrimaryKey(long pk) {
		setSpLdapMappingId(pk);
	}

	public long getSpLdapMappingId() {
		return _spLdapMappingId;
	}

	public void setSpLdapMappingId(long spLdapMappingId) {
		_spLdapMappingId = spLdapMappingId;
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

	public long getDepartmentId() {
		return _departmentId;
	}

	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;
	}

	public long getCountryDepartmentId() {
		return _countryDepartmentId;
	}

	public void setCountryDepartmentId(long countryDepartmentId) {
		_countryDepartmentId = countryDepartmentId;
	}

	public String getLdapCountry() {
		return _ldapCountry;
	}

	public void setLdapCountry(String ldapCountry) {
		_ldapCountry = ldapCountry;
	}

	public String getLdapDepartment() {
		return _ldapDepartment;
	}

	public void setLdapDepartment(String ldapDepartment) {
		_ldapDepartment = ldapDepartment;
	}

	public String getLdapCompany() {
		return _ldapCompany;
	}

	public void setLdapCompany(String ldapCompany) {
		_ldapCompany = ldapCompany;
	}

	public long getDefaultRoleId() {
		return _defaultRoleId;
	}

	public void setDefaultRoleId(long defaultRoleId) {
		_defaultRoleId = defaultRoleId;
	}

	private long _spLdapMappingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private long _departmentId;
	private long _countryDepartmentId;
	private String _ldapCountry;
	private String _ldapDepartment;
	private String _ldapCompany;
	private long _defaultRoleId;
}