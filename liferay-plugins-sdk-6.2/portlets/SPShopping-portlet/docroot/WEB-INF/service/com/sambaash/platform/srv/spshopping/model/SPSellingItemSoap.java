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

package com.sambaash.platform.srv.spshopping.model;

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
public class SPSellingItemSoap implements Serializable {
	public static SPSellingItemSoap toSoapModel(SPSellingItem model) {
		SPSellingItemSoap soapModel = new SPSellingItemSoap();

		soapModel.setSpSellingItemId(model.getSpSellingItemId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTitle(model.getTitle());
		soapModel.setItemCode(model.getItemCode());
		soapModel.setEntityClassPk(model.getEntityClassPk());
		soapModel.setEntityClassNameId(model.getEntityClassNameId());
		soapModel.setEntityClassName(model.getEntityClassName());
		soapModel.setShortDescription(model.getShortDescription());
		soapModel.setLongDescription(model.getLongDescription());
		soapModel.setActive(model.getActive());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPSellingItemSoap[] toSoapModels(SPSellingItem[] models) {
		SPSellingItemSoap[] soapModels = new SPSellingItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPSellingItemSoap[][] toSoapModels(SPSellingItem[][] models) {
		SPSellingItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPSellingItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPSellingItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPSellingItemSoap[] toSoapModels(List<SPSellingItem> models) {
		List<SPSellingItemSoap> soapModels = new ArrayList<SPSellingItemSoap>(models.size());

		for (SPSellingItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPSellingItemSoap[soapModels.size()]);
	}

	public SPSellingItemSoap() {
	}

	public long getPrimaryKey() {
		return _spSellingItemId;
	}

	public void setPrimaryKey(long pk) {
		setSpSellingItemId(pk);
	}

	public long getSpSellingItemId() {
		return _spSellingItemId;
	}

	public void setSpSellingItemId(long spSellingItemId) {
		_spSellingItemId = spSellingItemId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getItemCode() {
		return _itemCode;
	}

	public void setItemCode(String itemCode) {
		_itemCode = itemCode;
	}

	public long getEntityClassPk() {
		return _entityClassPk;
	}

	public void setEntityClassPk(long entityClassPk) {
		_entityClassPk = entityClassPk;
	}

	public long getEntityClassNameId() {
		return _entityClassNameId;
	}

	public void setEntityClassNameId(long entityClassNameId) {
		_entityClassNameId = entityClassNameId;
	}

	public String getEntityClassName() {
		return _entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;
	}

	public String getShortDescription() {
		return _shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		_shortDescription = shortDescription;
	}

	public String getLongDescription() {
		return _longDescription;
	}

	public void setLongDescription(String longDescription) {
		_longDescription = longDescription;
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

	private long _spSellingItemId;
	private long _groupId;
	private String _title;
	private String _itemCode;
	private long _entityClassPk;
	private long _entityClassNameId;
	private String _entityClassName;
	private String _shortDescription;
	private String _longDescription;
	private boolean _active;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}