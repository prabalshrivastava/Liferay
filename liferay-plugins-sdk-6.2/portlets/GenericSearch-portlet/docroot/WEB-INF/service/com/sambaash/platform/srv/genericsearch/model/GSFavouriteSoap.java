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

package com.sambaash.platform.srv.genericsearch.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author nareshchebolu
 * @generated
 */
public class GSFavouriteSoap implements Serializable {
	public static GSFavouriteSoap toSoapModel(GSFavourite model) {
		GSFavouriteSoap soapModel = new GSFavouriteSoap();

		soapModel.setSPGSFavouriteId(model.getSPGSFavouriteId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setLayoutId(model.getLayoutId());
		soapModel.setPortletInstanceId(model.getPortletInstanceId());
		soapModel.setConfig(model.getConfig());
		soapModel.setPermissionType(model.getPermissionType());

		return soapModel;
	}

	public static GSFavouriteSoap[] toSoapModels(GSFavourite[] models) {
		GSFavouriteSoap[] soapModels = new GSFavouriteSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GSFavouriteSoap[][] toSoapModels(GSFavourite[][] models) {
		GSFavouriteSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GSFavouriteSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GSFavouriteSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GSFavouriteSoap[] toSoapModels(List<GSFavourite> models) {
		List<GSFavouriteSoap> soapModels = new ArrayList<GSFavouriteSoap>(models.size());

		for (GSFavourite model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GSFavouriteSoap[soapModels.size()]);
	}

	public GSFavouriteSoap() {
	}

	public long getPrimaryKey() {
		return _SPGSFavouriteId;
	}

	public void setPrimaryKey(long pk) {
		setSPGSFavouriteId(pk);
	}

	public long getSPGSFavouriteId() {
		return _SPGSFavouriteId;
	}

	public void setSPGSFavouriteId(long SPGSFavouriteId) {
		_SPGSFavouriteId = SPGSFavouriteId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public long getLayoutId() {
		return _layoutId;
	}

	public void setLayoutId(long layoutId) {
		_layoutId = layoutId;
	}

	public String getPortletInstanceId() {
		return _portletInstanceId;
	}

	public void setPortletInstanceId(String portletInstanceId) {
		_portletInstanceId = portletInstanceId;
	}

	public String getConfig() {
		return _config;
	}

	public void setConfig(String config) {
		_config = config;
	}

	public int getPermissionType() {
		return _permissionType;
	}

	public void setPermissionType(int permissionType) {
		_permissionType = permissionType;
	}

	private long _SPGSFavouriteId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _createdBy;
	private long _layoutId;
	private String _portletInstanceId;
	private String _config;
	private int _permissionType;
}