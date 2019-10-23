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
public class SocialProfileDetailSoap implements Serializable {
	public static SocialProfileDetailSoap toSoapModel(SocialProfileDetail model) {
		SocialProfileDetailSoap soapModel = new SocialProfileDetailSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSocialProfileDetailId(model.getSocialProfileDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserJobId(model.getUserJobId());
		soapModel.setCompanyName(model.getCompanyName());

		return soapModel;
	}

	public static SocialProfileDetailSoap[] toSoapModels(
		SocialProfileDetail[] models) {
		SocialProfileDetailSoap[] soapModels = new SocialProfileDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileDetailSoap[][] toSoapModels(
		SocialProfileDetail[][] models) {
		SocialProfileDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialProfileDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialProfileDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileDetailSoap[] toSoapModels(
		List<SocialProfileDetail> models) {
		List<SocialProfileDetailSoap> soapModels = new ArrayList<SocialProfileDetailSoap>(models.size());

		for (SocialProfileDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialProfileDetailSoap[soapModels.size()]);
	}

	public SocialProfileDetailSoap() {
	}

	public long getPrimaryKey() {
		return _socialProfileDetailId;
	}

	public void setPrimaryKey(long pk) {
		setSocialProfileDetailId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSocialProfileDetailId() {
		return _socialProfileDetailId;
	}

	public void setSocialProfileDetailId(long socialProfileDetailId) {
		_socialProfileDetailId = socialProfileDetailId;
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

	public String getUserJobId() {
		return _userJobId;
	}

	public void setUserJobId(String userJobId) {
		_userJobId = userJobId;
	}

	public String getCompanyName() {
		return _companyName;
	}

	public void setCompanyName(String companyName) {
		_companyName = companyName;
	}

	private String _uuid;
	private long _socialProfileDetailId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _userJobId;
	private String _companyName;
}