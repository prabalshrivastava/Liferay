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
public class SPCartPackageItemSoap implements Serializable {
	public static SPCartPackageItemSoap toSoapModel(SPCartPackageItem model) {
		SPCartPackageItemSoap soapModel = new SPCartPackageItemSoap();

		soapModel.setSpCartPackageItemId(model.getSpCartPackageItemId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setSpCartPackageId(model.getSpCartPackageId());
		soapModel.setTitle(model.getTitle());
		soapModel.setItemCode(model.getItemCode());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setEntityClassPk(model.getEntityClassPk());
		soapModel.setEntityClassName(model.getEntityClassName());
		soapModel.setTotalPrice(model.getTotalPrice());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPCartPackageItemSoap[] toSoapModels(
		SPCartPackageItem[] models) {
		SPCartPackageItemSoap[] soapModels = new SPCartPackageItemSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPCartPackageItemSoap[][] toSoapModels(
		SPCartPackageItem[][] models) {
		SPCartPackageItemSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPCartPackageItemSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPCartPackageItemSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPCartPackageItemSoap[] toSoapModels(
		List<SPCartPackageItem> models) {
		List<SPCartPackageItemSoap> soapModels = new ArrayList<SPCartPackageItemSoap>(models.size());

		for (SPCartPackageItem model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPCartPackageItemSoap[soapModels.size()]);
	}

	public SPCartPackageItemSoap() {
	}

	public long getPrimaryKey() {
		return _spCartPackageItemId;
	}

	public void setPrimaryKey(long pk) {
		setSpCartPackageItemId(pk);
	}

	public long getSpCartPackageItemId() {
		return _spCartPackageItemId;
	}

	public void setSpCartPackageItemId(long spCartPackageItemId) {
		_spCartPackageItemId = spCartPackageItemId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getSpCartPackageId() {
		return _spCartPackageId;
	}

	public void setSpCartPackageId(long spCartPackageId) {
		_spCartPackageId = spCartPackageId;
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

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public long getEntityClassPk() {
		return _entityClassPk;
	}

	public void setEntityClassPk(long entityClassPk) {
		_entityClassPk = entityClassPk;
	}

	public String getEntityClassName() {
		return _entityClassName;
	}

	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;
	}

	public String getTotalPrice() {
		return _totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		_totalPrice = totalPrice;
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

	private long _spCartPackageItemId;
	private long _groupId;
	private long _spCartPackageId;
	private String _title;
	private String _itemCode;
	private int _quantity;
	private long _entityClassPk;
	private String _entityClassName;
	private String _totalPrice;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}