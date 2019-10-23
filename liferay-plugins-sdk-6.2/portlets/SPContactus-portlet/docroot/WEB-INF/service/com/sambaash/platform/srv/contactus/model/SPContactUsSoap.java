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

package com.sambaash.platform.srv.contactus.model;

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
public class SPContactUsSoap implements Serializable {
	public static SPContactUsSoap toSoapModel(SPContactUs model) {
		SPContactUsSoap soapModel = new SPContactUsSoap();

		soapModel.setSpContactUsId(model.getSpContactUsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setCategory(model.getCategory());
		soapModel.setComment(model.getComment());
		soapModel.setCountryName(model.getCountryName());
		soapModel.setContactNumber(model.getContactNumber());
		soapModel.setCompany(model.getCompany());
		soapModel.setJobTitle(model.getJobTitle());
		soapModel.setCompanyUrl(model.getCompanyUrl());
		soapModel.setNoOfEmployee(model.getNoOfEmployee());
		soapModel.setRate(model.getRate());
		soapModel.setTypeOfEnquiry(model.getTypeOfEnquiry());
		soapModel.setLocation(model.getLocation());

		return soapModel;
	}

	public static SPContactUsSoap[] toSoapModels(SPContactUs[] models) {
		SPContactUsSoap[] soapModels = new SPContactUsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPContactUsSoap[][] toSoapModels(SPContactUs[][] models) {
		SPContactUsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPContactUsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPContactUsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPContactUsSoap[] toSoapModels(List<SPContactUs> models) {
		List<SPContactUsSoap> soapModels = new ArrayList<SPContactUsSoap>(models.size());

		for (SPContactUs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPContactUsSoap[soapModels.size()]);
	}

	public SPContactUsSoap() {
	}

	public long getPrimaryKey() {
		return _spContactUsId;
	}

	public void setPrimaryKey(long pk) {
		setSpContactUsId(pk);
	}

	public long getSpContactUsId() {
		return _spContactUsId;
	}

	public void setSpContactUsId(long spContactUsId) {
		_spContactUsId = spContactUsId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
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

	public String getCategory() {
		return _category;
	}

	public void setCategory(String category) {
		_category = category;
	}

	public String getComment() {
		return _comment;
	}

	public void setComment(String comment) {
		_comment = comment;
	}

	public String getCountryName() {
		return _countryName;
	}

	public void setCountryName(String countryName) {
		_countryName = countryName;
	}

	public long getContactNumber() {
		return _contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		_contactNumber = contactNumber;
	}

	public String getCompany() {
		return _company;
	}

	public void setCompany(String company) {
		_company = company;
	}

	public String getJobTitle() {
		return _jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		_jobTitle = jobTitle;
	}

	public String getCompanyUrl() {
		return _companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		_companyUrl = companyUrl;
	}

	public long getNoOfEmployee() {
		return _noOfEmployee;
	}

	public void setNoOfEmployee(long noOfEmployee) {
		_noOfEmployee = noOfEmployee;
	}

	public String getRate() {
		return _rate;
	}

	public void setRate(String rate) {
		_rate = rate;
	}

	public String getTypeOfEnquiry() {
		return _typeOfEnquiry;
	}

	public void setTypeOfEnquiry(String typeOfEnquiry) {
		_typeOfEnquiry = typeOfEnquiry;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	private long _spContactUsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _lastName;
	private String _emailAddress;
	private String _category;
	private String _comment;
	private String _countryName;
	private long _contactNumber;
	private String _company;
	private String _jobTitle;
	private String _companyUrl;
	private long _noOfEmployee;
	private String _rate;
	private String _typeOfEnquiry;
	private String _location;
}