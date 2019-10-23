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
public class SPPackageItemsSoap implements Serializable {
	public static SPPackageItemsSoap toSoapModel(SPPackageItems model) {
		SPPackageItemsSoap soapModel = new SPPackageItemsSoap();

		soapModel.setSpPackageItemsId(model.getSpPackageItemsId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setPackageId(model.getPackageId());
		soapModel.setItemId(model.getItemId());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPPackageItemsSoap[] toSoapModels(SPPackageItems[] models) {
		SPPackageItemsSoap[] soapModels = new SPPackageItemsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPPackageItemsSoap[][] toSoapModels(SPPackageItems[][] models) {
		SPPackageItemsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPPackageItemsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPPackageItemsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPPackageItemsSoap[] toSoapModels(List<SPPackageItems> models) {
		List<SPPackageItemsSoap> soapModels = new ArrayList<SPPackageItemsSoap>(models.size());

		for (SPPackageItems model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPPackageItemsSoap[soapModels.size()]);
	}

	public SPPackageItemsSoap() {
	}

	public long getPrimaryKey() {
		return _spPackageItemsId;
	}

	public void setPrimaryKey(long pk) {
		setSpPackageItemsId(pk);
	}

	public long getSpPackageItemsId() {
		return _spPackageItemsId;
	}

	public void setSpPackageItemsId(long spPackageItemsId) {
		_spPackageItemsId = spPackageItemsId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getPackageId() {
		return _packageId;
	}

	public void setPackageId(long packageId) {
		_packageId = packageId;
	}

	public long getItemId() {
		return _itemId;
	}

	public void setItemId(long itemId) {
		_itemId = itemId;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
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

	private long _spPackageItemsId;
	private long _groupId;
	private long _packageId;
	private long _itemId;
	private int _quantity;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}