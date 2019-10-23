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
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.spservices.service.http.SPListTypeServiceSoap}.
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spservices.service.http.SPListTypeServiceSoap
 * @generated
 */
public class SPListTypeSoap implements Serializable {
	public static SPListTypeSoap toSoapModel(SPListType model) {
		SPListTypeSoap soapModel = new SPListTypeSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpListTypeId(model.getSpListTypeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setItemKey(model.getItemKey());
		soapModel.setItemValue(model.getItemValue());
		soapModel.setDisplayName(model.getDisplayName());
		soapModel.setDisplayOrder(model.getDisplayOrder());
		soapModel.setCategoryId(model.getCategoryId());
		soapModel.setModeldata(model.getModeldata());

		return soapModel;
	}

	public static SPListTypeSoap[] toSoapModels(SPListType[] models) {
		SPListTypeSoap[] soapModels = new SPListTypeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPListTypeSoap[][] toSoapModels(SPListType[][] models) {
		SPListTypeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPListTypeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPListTypeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPListTypeSoap[] toSoapModels(List<SPListType> models) {
		List<SPListTypeSoap> soapModels = new ArrayList<SPListTypeSoap>(models.size());

		for (SPListType model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPListTypeSoap[soapModels.size()]);
	}

	public SPListTypeSoap() {
	}

	public long getPrimaryKey() {
		return _spListTypeId;
	}

	public void setPrimaryKey(long pk) {
		setSpListTypeId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpListTypeId() {
		return _spListTypeId;
	}

	public void setSpListTypeId(long spListTypeId) {
		_spListTypeId = spListTypeId;
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

	public String getItemKey() {
		return _itemKey;
	}

	public void setItemKey(String itemKey) {
		_itemKey = itemKey;
	}

	public String getItemValue() {
		return _itemValue;
	}

	public void setItemValue(String itemValue) {
		_itemValue = itemValue;
	}

	public String getDisplayName() {
		return _displayName;
	}

	public void setDisplayName(String displayName) {
		_displayName = displayName;
	}

	public int getDisplayOrder() {
		return _displayOrder;
	}

	public void setDisplayOrder(int displayOrder) {
		_displayOrder = displayOrder;
	}

	public long getCategoryId() {
		return _categoryId;
	}

	public void setCategoryId(long categoryId) {
		_categoryId = categoryId;
	}

	public String getModeldata() {
		return _modeldata;
	}

	public void setModeldata(String modeldata) {
		_modeldata = modeldata;
	}

	private String _uuid;
	private long _spListTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _itemKey;
	private String _itemValue;
	private String _displayName;
	private int _displayOrder;
	private long _categoryId;
	private String _modeldata;
}