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

package com.sambaash.platform.srv.startupprofile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class SPOrgContactUsSoap implements Serializable {
	public static SPOrgContactUsSoap toSoapModel(SPOrgContactUs model) {
		SPOrgContactUsSoap soapModel = new SPOrgContactUsSoap();

		soapModel.setSpContactUsId(model.getSpContactUsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSalutation(model.getSalutation());
		soapModel.setPerson(model.getPerson());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setDesignation(model.getDesignation());
		soapModel.setQualification(model.getQualification());
		soapModel.setQualificationDate(model.getQualificationDate());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setDepartment(model.getDepartment());
		soapModel.setMobileNumber(model.getMobileNumber());
		soapModel.setTelephoneNumber(model.getTelephoneNumber());
		soapModel.setFaxNumber(model.getFaxNumber());
		soapModel.setBillingContact(model.getBillingContact());
		soapModel.setOperationsContact(model.getOperationsContact());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static SPOrgContactUsSoap[] toSoapModels(SPOrgContactUs[] models) {
		SPOrgContactUsSoap[] soapModels = new SPOrgContactUsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPOrgContactUsSoap[][] toSoapModels(SPOrgContactUs[][] models) {
		SPOrgContactUsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPOrgContactUsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPOrgContactUsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPOrgContactUsSoap[] toSoapModels(List<SPOrgContactUs> models) {
		List<SPOrgContactUsSoap> soapModels = new ArrayList<SPOrgContactUsSoap>(models.size());

		for (SPOrgContactUs model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPOrgContactUsSoap[soapModels.size()]);
	}

	public SPOrgContactUsSoap() {
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

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
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

	public String getSalutation() {
		return _salutation;
	}

	public void setSalutation(String salutation) {
		_salutation = salutation;
	}

	public String getPerson() {
		return _person;
	}

	public void setPerson(String person) {
		_person = person;
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

	public String getDesignation() {
		return _designation;
	}

	public void setDesignation(String designation) {
		_designation = designation;
	}

	public String getQualification() {
		return _qualification;
	}

	public void setQualification(String qualification) {
		_qualification = qualification;
	}

	public String getQualificationDate() {
		return _qualificationDate;
	}

	public void setQualificationDate(String qualificationDate) {
		_qualificationDate = qualificationDate;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getDepartment() {
		return _department;
	}

	public void setDepartment(String department) {
		_department = department;
	}

	public long getMobileNumber() {
		return _mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		_mobileNumber = mobileNumber;
	}

	public long getTelephoneNumber() {
		return _telephoneNumber;
	}

	public void setTelephoneNumber(long telephoneNumber) {
		_telephoneNumber = telephoneNumber;
	}

	public long getFaxNumber() {
		return _faxNumber;
	}

	public void setFaxNumber(long faxNumber) {
		_faxNumber = faxNumber;
	}

	public boolean getBillingContact() {
		return _billingContact;
	}

	public boolean isBillingContact() {
		return _billingContact;
	}

	public void setBillingContact(boolean billingContact) {
		_billingContact = billingContact;
	}

	public boolean getOperationsContact() {
		return _operationsContact;
	}

	public boolean isOperationsContact() {
		return _operationsContact;
	}

	public void setOperationsContact(boolean operationsContact) {
		_operationsContact = operationsContact;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _spContactUsId;
	private long _groupId;
	private long _organizationId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _salutation;
	private String _person;
	private String _firstName;
	private String _lastName;
	private String _designation;
	private String _qualification;
	private String _qualificationDate;
	private String _emailAddress;
	private String _department;
	private long _mobileNumber;
	private long _telephoneNumber;
	private long _faxNumber;
	private boolean _billingContact;
	private boolean _operationsContact;
	private boolean _active;
}