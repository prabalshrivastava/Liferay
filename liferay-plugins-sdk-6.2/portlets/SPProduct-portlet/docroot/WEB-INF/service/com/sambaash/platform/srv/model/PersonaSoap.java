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
public class PersonaSoap implements Serializable {
	public static PersonaSoap toSoapModel(Persona model) {
		PersonaSoap soapModel = new PersonaSoap();

		soapModel.setSpPersonaId(model.getSpPersonaId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setPersonaType(model.getPersonaType());
		soapModel.setAgeGroup(model.getAgeGroup());
		soapModel.setPersonaDesc(model.getPersonaDesc());
		soapModel.setPersonaImageId(model.getPersonaImageId());
		soapModel.setSpCourseId(model.getSpCourseId());

		return soapModel;
	}

	public static PersonaSoap[] toSoapModels(Persona[] models) {
		PersonaSoap[] soapModels = new PersonaSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonaSoap[][] toSoapModels(Persona[][] models) {
		PersonaSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersonaSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonaSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonaSoap[] toSoapModels(List<Persona> models) {
		List<PersonaSoap> soapModels = new ArrayList<PersonaSoap>(models.size());

		for (Persona model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonaSoap[soapModels.size()]);
	}

	public PersonaSoap() {
	}

	public long getPrimaryKey() {
		return _spPersonaId;
	}

	public void setPrimaryKey(long pk) {
		setSpPersonaId(pk);
	}

	public long getSpPersonaId() {
		return _spPersonaId;
	}

	public void setSpPersonaId(long spPersonaId) {
		_spPersonaId = spPersonaId;
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

	public long getPersonaType() {
		return _personaType;
	}

	public void setPersonaType(long personaType) {
		_personaType = personaType;
	}

	public String getAgeGroup() {
		return _ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		_ageGroup = ageGroup;
	}

	public String getPersonaDesc() {
		return _personaDesc;
	}

	public void setPersonaDesc(String personaDesc) {
		_personaDesc = personaDesc;
	}

	public long getPersonaImageId() {
		return _personaImageId;
	}

	public void setPersonaImageId(long personaImageId) {
		_personaImageId = personaImageId;
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	private long _spPersonaId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _personaType;
	private String _ageGroup;
	private String _personaDesc;
	private long _personaImageId;
	private long _spCourseId;
}