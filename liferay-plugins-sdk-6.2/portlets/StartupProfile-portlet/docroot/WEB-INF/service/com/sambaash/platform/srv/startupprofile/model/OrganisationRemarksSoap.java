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
public class OrganisationRemarksSoap implements Serializable {
	public static OrganisationRemarksSoap toSoapModel(OrganisationRemarks model) {
		OrganisationRemarksSoap soapModel = new OrganisationRemarksSoap();

		soapModel.setRemarksId(model.getRemarksId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setRemarkType(model.getRemarkType());
		soapModel.setRemarks(model.getRemarks());
		soapModel.setNotes(model.getNotes());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static OrganisationRemarksSoap[] toSoapModels(
		OrganisationRemarks[] models) {
		OrganisationRemarksSoap[] soapModels = new OrganisationRemarksSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganisationRemarksSoap[][] toSoapModels(
		OrganisationRemarks[][] models) {
		OrganisationRemarksSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganisationRemarksSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganisationRemarksSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganisationRemarksSoap[] toSoapModels(
		List<OrganisationRemarks> models) {
		List<OrganisationRemarksSoap> soapModels = new ArrayList<OrganisationRemarksSoap>(models.size());

		for (OrganisationRemarks model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganisationRemarksSoap[soapModels.size()]);
	}

	public OrganisationRemarksSoap() {
	}

	public long getPrimaryKey() {
		return _remarksId;
	}

	public void setPrimaryKey(long pk) {
		setRemarksId(pk);
	}

	public long getRemarksId() {
		return _remarksId;
	}

	public void setRemarksId(long remarksId) {
		_remarksId = remarksId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getRemarkType() {
		return _remarkType;
	}

	public void setRemarkType(String remarkType) {
		_remarkType = remarkType;
	}

	public String getRemarks() {
		return _Remarks;
	}

	public void setRemarks(String Remarks) {
		_Remarks = Remarks;
	}

	public String getNotes() {
		return _Notes;
	}

	public void setNotes(String Notes) {
		_Notes = Notes;
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

	private long _remarksId;
	private long _organizationId;
	private String _remarkType;
	private String _Remarks;
	private String _Notes;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}