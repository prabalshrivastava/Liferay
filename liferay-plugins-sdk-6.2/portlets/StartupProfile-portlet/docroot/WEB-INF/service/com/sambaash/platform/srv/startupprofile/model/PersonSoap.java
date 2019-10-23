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
public class PersonSoap implements Serializable {
	public static PersonSoap toSoapModel(Person model) {
		PersonSoap soapModel = new PersonSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setPersonId(model.getPersonId());
		soapModel.setName(model.getName());
		soapModel.setTitle(model.getTitle());
		soapModel.setApiPath(model.getApiPath());
		soapModel.setEmailId(model.getEmailId());
		soapModel.setDescription(model.getDescription());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setMobile(model.getMobile());
		soapModel.setSkype(model.getSkype());
		soapModel.setMemberUserId(model.getMemberUserId());
		soapModel.setExtras(model.getExtras());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static PersonSoap[] toSoapModels(Person[] models) {
		PersonSoap[] soapModels = new PersonSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static PersonSoap[][] toSoapModels(Person[][] models) {
		PersonSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new PersonSoap[models.length][models[0].length];
		}
		else {
			soapModels = new PersonSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static PersonSoap[] toSoapModels(List<Person> models) {
		List<PersonSoap> soapModels = new ArrayList<PersonSoap>(models.size());

		for (Person model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new PersonSoap[soapModels.size()]);
	}

	public PersonSoap() {
	}

	public long getPrimaryKey() {
		return _personId;
	}

	public void setPrimaryKey(long pk) {
		setPersonId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getPersonId() {
		return _personId;
	}

	public void setPersonId(long personId) {
		_personId = personId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getApiPath() {
		return _apiPath;
	}

	public void setApiPath(String apiPath) {
		_apiPath = apiPath;
	}

	public String getEmailId() {
		return _emailId;
	}

	public void setEmailId(String emailId) {
		_emailId = emailId;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getSkype() {
		return _skype;
	}

	public void setSkype(String skype) {
		_skype = skype;
	}

	public long getMemberUserId() {
		return _memberUserId;
	}

	public void setMemberUserId(long memberUserId) {
		_memberUserId = memberUserId;
	}

	public String getExtras() {
		return _extras;
	}

	public void setExtras(String extras) {
		_extras = extras;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private String _uuid;
	private long _personId;
	private String _name;
	private String _title;
	private String _apiPath;
	private String _emailId;
	private String _description;
	private String _imageUrl;
	private String _mobile;
	private String _skype;
	private long _memberUserId;
	private String _extras;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
}