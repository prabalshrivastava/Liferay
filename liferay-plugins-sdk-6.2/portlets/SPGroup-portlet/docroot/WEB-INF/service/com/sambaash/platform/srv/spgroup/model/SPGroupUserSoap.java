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

package com.sambaash.platform.srv.spgroup.model;

import com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author harini
 * @generated
 */
public class SPGroupUserSoap implements Serializable {
	public static SPGroupUserSoap toSoapModel(SPGroupUser model) {
		SPGroupUserSoap soapModel = new SPGroupUserSoap();

		soapModel.setSpGroupId(model.getSpGroupId());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setJoinDate(model.getJoinDate());
		soapModel.setRole(model.getRole());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SPGroupUserSoap[] toSoapModels(SPGroupUser[] models) {
		SPGroupUserSoap[] soapModels = new SPGroupUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPGroupUserSoap[][] toSoapModels(SPGroupUser[][] models) {
		SPGroupUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPGroupUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPGroupUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPGroupUserSoap[] toSoapModels(List<SPGroupUser> models) {
		List<SPGroupUserSoap> soapModels = new ArrayList<SPGroupUserSoap>(models.size());

		for (SPGroupUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPGroupUserSoap[soapModels.size()]);
	}

	public SPGroupUserSoap() {
	}

	public SPGroupUserPK getPrimaryKey() {
		return new SPGroupUserPK(_spGroupId, _userId);
	}

	public void setPrimaryKey(SPGroupUserPK pk) {
		setSpGroupId(pk.spGroupId);
		setUserId(pk.userId);
	}

	public long getSpGroupId() {
		return _spGroupId;
	}

	public void setSpGroupId(long spGroupId) {
		_spGroupId = spGroupId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public Date getJoinDate() {
		return _joinDate;
	}

	public void setJoinDate(Date joinDate) {
		_joinDate = joinDate;
	}

	public int getRole() {
		return _role;
	}

	public void setRole(int role) {
		_role = role;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _spGroupId;
	private long _userId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _joinDate;
	private int _role;
	private int _status;
}