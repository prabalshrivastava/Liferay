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
public class SPLdapProfileSoap implements Serializable {
	public static SPLdapProfileSoap toSoapModel(SPLdapProfile model) {
		SPLdapProfileSoap soapModel = new SPLdapProfileSoap();

		soapModel.setSpLdapProfileId(model.getSpLdapProfileId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setDepartmentId(model.getDepartmentId());
		soapModel.setGivenName(model.getGivenName());
		soapModel.setSn(model.getSn());
		soapModel.setDisplayName(model.getDisplayName());
		soapModel.setCompany(model.getCompany());
		soapModel.setDivision(model.getDivision());
		soapModel.setTitle(model.getTitle());
		soapModel.setMail(model.getMail());
		soapModel.setSamAccountName(model.getSamAccountName());
		soapModel.setEmployeeId(model.getEmployeeId());
		soapModel.setManager(model.getManager());
		soapModel.setTelephoneNumber(model.getTelephoneNumber());
		soapModel.setMobile(model.getMobile());
		soapModel.setFacsimileTelephoneNumber(model.getFacsimileTelephoneNumber());

		return soapModel;
	}

	public static SPLdapProfileSoap[] toSoapModels(SPLdapProfile[] models) {
		SPLdapProfileSoap[] soapModels = new SPLdapProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPLdapProfileSoap[][] toSoapModels(SPLdapProfile[][] models) {
		SPLdapProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPLdapProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPLdapProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPLdapProfileSoap[] toSoapModels(List<SPLdapProfile> models) {
		List<SPLdapProfileSoap> soapModels = new ArrayList<SPLdapProfileSoap>(models.size());

		for (SPLdapProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPLdapProfileSoap[soapModels.size()]);
	}

	public SPLdapProfileSoap() {
	}

	public long getPrimaryKey() {
		return _spLdapProfileId;
	}

	public void setPrimaryKey(long pk) {
		setSpLdapProfileId(pk);
	}

	public long getSpLdapProfileId() {
		return _spLdapProfileId;
	}

	public void setSpLdapProfileId(long spLdapProfileId) {
		_spLdapProfileId = spLdapProfileId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getGivenName() {
		return _givenName;
	}

	public void setGivenName(String givenName) {
		_givenName = givenName;
	}

	public String getSn() {
		return _sn;
	}

	public void setSn(String sn) {
		_sn = sn;
	}

	public String getDisplayName() {
		return _displayName;
	}

	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getDivision() {
		return _division;
	}

	public void setDivision(String division) {
		_division = division;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getMail() {
		return _mail;
	}

	public void setMail(String mail) {
		_mail = mail;
	}

	public String getSamAccountName() {
		return _samAccountName;
	}

	public void setSamAccountName(String samAccountName) {
		_samAccountName = samAccountName;
	}

	public String getEmployeeId() {
		return _employeeId;
	}

	public void setEmployeeId(String employeeId) {
		_employeeId = employeeId;
	}

	public String getManager() {
		return _manager;
	}

	public void setManager(String manager) {
		_manager = manager;
	}

	public String getTelephoneNumber() {
		return _telephoneNumber;
	}

	public void setTelephoneNumber(String telephoneNumber) {
		_telephoneNumber = telephoneNumber;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getFacsimileTelephoneNumber() {
		return _facsimileTelephoneNumber;
	}

	public void setFacsimileTelephoneNumber(String facsimileTelephoneNumber) {
		_facsimileTelephoneNumber = facsimileTelephoneNumber;
	}

	private long _spLdapProfileId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private long _countryId;
	private long _departmentId;
	private String _givenName;
	private String _sn;
	private String _displayName;
	private String _company;
	private String _division;
	private String _title;
	private String _mail;
	private String _samAccountName;
	private String _employeeId;
	private String _manager;
	private String _telephoneNumber;
	private String _mobile;
	private String _facsimileTelephoneNumber;
}