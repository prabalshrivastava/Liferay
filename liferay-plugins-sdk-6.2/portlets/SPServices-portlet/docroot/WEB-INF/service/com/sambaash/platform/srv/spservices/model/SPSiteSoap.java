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

package com.sambaash.platform.srv.spservices.model;

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
public class SPSiteSoap implements Serializable {
	public static SPSiteSoap toSoapModel(SPSite model) {
		SPSiteSoap soapModel = new SPSiteSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpSiteId(model.getSpSiteId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setVirtualHostId(model.getVirtualHostId());
		soapModel.setLayoutSetId(model.getLayoutSetId());
		soapModel.setAuthAccessId(model.getAuthAccessId());
		soapModel.setLoginType(model.getLoginType());
		soapModel.setPassword(model.getPassword());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static SPSiteSoap[] toSoapModels(SPSite[] models) {
		SPSiteSoap[] soapModels = new SPSiteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPSiteSoap[][] toSoapModels(SPSite[][] models) {
		SPSiteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPSiteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPSiteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPSiteSoap[] toSoapModels(List<SPSite> models) {
		List<SPSiteSoap> soapModels = new ArrayList<SPSiteSoap>(models.size());

		for (SPSite model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPSiteSoap[soapModels.size()]);
	}

	public SPSiteSoap() {
	}

	public long getPrimaryKey() {
		return _spSiteId;
	}

	public void setPrimaryKey(long pk) {
		setSpSiteId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpSiteId() {
		return _spSiteId;
	}

	public void setSpSiteId(long spSiteId) {
		_spSiteId = spSiteId;
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

	public long getVirtualHostId() {
		return _virtualHostId;
	}

	public void setVirtualHostId(long virtualHostId) {
		_virtualHostId = virtualHostId;
	}

	public long getLayoutSetId() {
		return _layoutSetId;
	}

	public void setLayoutSetId(long layoutSetId) {
		_layoutSetId = layoutSetId;
	}

	public long getAuthAccessId() {
		return _authAccessId;
	}

	public void setAuthAccessId(long authAccessId) {
		_authAccessId = authAccessId;
	}

	public long getLoginType() {
		return _loginType;
	}

	public void setLoginType(long loginType) {
		_loginType = loginType;
	}

	public String getPassword() {
		return _password;
	}

	public void setPassword(String password) {
		_password = password;
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
	private long _spSiteId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _virtualHostId;
	private long _layoutSetId;
	private long _authAccessId;
	private long _loginType;
	private String _password;
	private boolean _active;
}