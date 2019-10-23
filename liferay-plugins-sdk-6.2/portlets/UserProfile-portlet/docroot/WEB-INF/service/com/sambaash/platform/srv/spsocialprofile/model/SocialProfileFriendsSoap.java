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

package com.sambaash.platform.srv.spsocialprofile.model;

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
public class SocialProfileFriendsSoap implements Serializable {
	public static SocialProfileFriendsSoap toSoapModel(
		SocialProfileFriends model) {
		SocialProfileFriendsSoap soapModel = new SocialProfileFriendsSoap();

		soapModel.setSocialProfileFriendsId(model.getSocialProfileFriendsId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setBelongsToUserId(model.getBelongsToUserId());
		soapModel.setSocialNetworkProfileId(model.getSocialNetworkProfileId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setBirthday(model.getBirthday());
		soapModel.setLocation(model.getLocation());
		soapModel.setPictureUrl(model.getPictureUrl());
		soapModel.setUserName(model.getUserName());
		soapModel.setGender(model.getGender());
		soapModel.setSocialNetworkType(model.getSocialNetworkType());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SocialProfileFriendsSoap[] toSoapModels(
		SocialProfileFriends[] models) {
		SocialProfileFriendsSoap[] soapModels = new SocialProfileFriendsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileFriendsSoap[][] toSoapModels(
		SocialProfileFriends[][] models) {
		SocialProfileFriendsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialProfileFriendsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialProfileFriendsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileFriendsSoap[] toSoapModels(
		List<SocialProfileFriends> models) {
		List<SocialProfileFriendsSoap> soapModels = new ArrayList<SocialProfileFriendsSoap>(models.size());

		for (SocialProfileFriends model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialProfileFriendsSoap[soapModels.size()]);
	}

	public SocialProfileFriendsSoap() {
	}

	public long getPrimaryKey() {
		return _socialProfileFriendsId;
	}

	public void setPrimaryKey(long pk) {
		setSocialProfileFriendsId(pk);
	}

	public long getSocialProfileFriendsId() {
		return _socialProfileFriendsId;
	}

	public void setSocialProfileFriendsId(long socialProfileFriendsId) {
		_socialProfileFriendsId = socialProfileFriendsId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getBelongsToUserId() {
		return _belongsToUserId;
	}

	public void setBelongsToUserId(long belongsToUserId) {
		_belongsToUserId = belongsToUserId;
	}

	public long getSocialNetworkProfileId() {
		return _socialNetworkProfileId;
	}

	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_socialNetworkProfileId = socialNetworkProfileId;
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

	public String getBirthday() {
		return _birthday;
	}

	public void setBirthday(String birthday) {
		_birthday = birthday;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public String getPictureUrl() {
		return _pictureUrl;
	}

	public void setPictureUrl(String pictureUrl) {
		_pictureUrl = pictureUrl;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public int getGender() {
		return _gender;
	}

	public void setGender(int gender) {
		_gender = gender;
	}

	public int getSocialNetworkType() {
		return _socialNetworkType;
	}

	public void setSocialNetworkType(int socialNetworkType) {
		_socialNetworkType = socialNetworkType;
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

	private long _socialProfileFriendsId;
	private long _companyId;
	private long _belongsToUserId;
	private long _socialNetworkProfileId;
	private String _firstName;
	private String _lastName;
	private String _birthday;
	private String _location;
	private String _pictureUrl;
	private String _userName;
	private int _gender;
	private int _socialNetworkType;
	private Date _createDate;
	private Date _modifiedDate;
}