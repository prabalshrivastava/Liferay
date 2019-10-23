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
public class PersonaAttendeeSoap implements Serializable {
	public static PersonaAttendeeSoap toSoapModel(PersonaAttendee model) {
		PersonaAttendeeSoap soapModel = new PersonaAttendeeSoap();

		soapModel.setSpPersonaAttendeeId(model.getSpPersonaAttendeeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageId(model.getImageId());
		soapModel.setSpPersonaId(model.getSpPersonaId());
		soapModel.setSpCourseId(model.getSpCourseId());

		return soapModel;
	}

	public static PersonaAttendeeSoap[] toSoapModels(PersonaAttendee[] models) {
		PersonaAttendeeSoap[] soapModels = new PersonaAttendeeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonaAttendeeSoap[][] toSoapModels(
		PersonaAttendee[][] models) {
		PersonaAttendeeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersonaAttendeeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonaAttendeeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonaAttendeeSoap[] toSoapModels(
		List<PersonaAttendee> models) {
		List<PersonaAttendeeSoap> soapModels = new ArrayList<PersonaAttendeeSoap>(models.size());

		for (PersonaAttendee model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonaAttendeeSoap[soapModels.size()]);
	}

	public PersonaAttendeeSoap() {
	}

	public long getPrimaryKey() {
		return _spPersonaAttendeeId;
	}

	public void setPrimaryKey(long pk) {
		setSpPersonaAttendeeId(pk);
	}

	public long getSpPersonaAttendeeId() {
		return _spPersonaAttendeeId;
	}

	public void setSpPersonaAttendeeId(long spPersonaAttendeeId) {
		_spPersonaAttendeeId = spPersonaAttendeeId;
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

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getImageId() {
		return _imageId;
	}

	public void setImageId(long imageId) {
		_imageId = imageId;
	}

	public long getSpPersonaId() {
		return _spPersonaId;
	}

	public void setSpPersonaId(long spPersonaId) {
		_spPersonaId = spPersonaId;
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	private long _spPersonaAttendeeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _description;
	private long _imageId;
	private long _spPersonaId;
	private long _spCourseId;
}