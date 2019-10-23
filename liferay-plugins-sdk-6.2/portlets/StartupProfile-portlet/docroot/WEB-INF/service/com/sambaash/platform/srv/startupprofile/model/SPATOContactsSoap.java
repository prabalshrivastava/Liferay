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
public class SPATOContactsSoap implements Serializable {
	public static SPATOContactsSoap toSoapModel(SPATOContacts model) {
		SPATOContactsSoap soapModel = new SPATOContactsSoap();

		soapModel.setSpATOContactId(model.getSpATOContactId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setUserId(model.getUserId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPrimaryPrincipalUserId(model.getPrimaryPrincipalUserId());
		soapModel.setSecondaryPrincipalUserId(model.getSecondaryPrincipalUserId());

		return soapModel;
	}

	public static SPATOContactsSoap[] toSoapModels(SPATOContacts[] models) {
		SPATOContactsSoap[] soapModels = new SPATOContactsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPATOContactsSoap[][] toSoapModels(SPATOContacts[][] models) {
		SPATOContactsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPATOContactsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPATOContactsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPATOContactsSoap[] toSoapModels(List<SPATOContacts> models) {
		List<SPATOContactsSoap> soapModels = new ArrayList<SPATOContactsSoap>(models.size());

		for (SPATOContacts model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPATOContactsSoap[soapModels.size()]);
	}

	public SPATOContactsSoap() {
	}

	public long getPrimaryKey() {
		return _spATOContactId;
	}

	public void setPrimaryKey(long pk) {
		setSpATOContactId(pk);
	}

	public long getSpATOContactId() {
		return _spATOContactId;
	}

	public void setSpATOContactId(long spATOContactId) {
		_spATOContactId = spATOContactId;
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

	public String getPrimaryPrincipalUserId() {
		return _primaryPrincipalUserId;
	}

	public void setPrimaryPrincipalUserId(String primaryPrincipalUserId) {
		_primaryPrincipalUserId = primaryPrincipalUserId;
	}

	public String getSecondaryPrincipalUserId() {
		return _secondaryPrincipalUserId;
	}

	public void setSecondaryPrincipalUserId(String secondaryPrincipalUserId) {
		_secondaryPrincipalUserId = secondaryPrincipalUserId;
	}

	private long _spATOContactId;
	private long _groupId;
	private long _organizationId;
	private long _userId;
	private String _firstName;
	private String _lastName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _primaryPrincipalUserId;
	private String _secondaryPrincipalUserId;
}