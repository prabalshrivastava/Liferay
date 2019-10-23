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

package com.sambaash.platform.srv.spvoting.model;

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
public class SPVotingSoap implements Serializable {
	public static SPVotingSoap toSoapModel(SPVoting model) {
		SPVotingSoap soapModel = new SPVotingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpVotingId(model.getSpVotingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setClassName(model.getClassName());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setIp(model.getIp());

		return soapModel;
	}

	public static SPVotingSoap[] toSoapModels(SPVoting[] models) {
		SPVotingSoap[] soapModels = new SPVotingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPVotingSoap[][] toSoapModels(SPVoting[][] models) {
		SPVotingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPVotingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPVotingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPVotingSoap[] toSoapModels(List<SPVoting> models) {
		List<SPVotingSoap> soapModels = new ArrayList<SPVotingSoap>(models.size());

		for (SPVoting model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPVotingSoap[soapModels.size()]);
	}

	public SPVotingSoap() {
	}

	public long getPrimaryKey() {
		return _spVotingId;
	}

	public void setPrimaryKey(long pk) {
		setSpVotingId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpVotingId() {
		return _spVotingId;
	}

	public void setSpVotingId(long spVotingId) {
		_spVotingId = spVotingId;
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

	public String getClassName() {
		return _className;
	}

	public void setClassName(String className) {
		_className = className;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getIp() {
		return _ip;
	}

	public void setIp(String ip) {
		_ip = ip;
	}

	private String _uuid;
	private long _spVotingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _className;
	private long _classPK;
	private String _ip;
}