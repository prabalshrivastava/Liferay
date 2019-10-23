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
public class SPDiscountSoap implements Serializable {
	public static SPDiscountSoap toSoapModel(SPDiscount model) {
		SPDiscountSoap soapModel = new SPDiscountSoap();

		soapModel.setSpDiscountId(model.getSpDiscountId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setTitle(model.getTitle());
		soapModel.setPercent(model.getPercent());
		soapModel.setPackageId(model.getPackageId());
		soapModel.setValue(model.getValue());
		soapModel.setCouponCode(model.getCouponCode());
		soapModel.setDescription(model.getDescription());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setMinQuantity(model.getMinQuantity());
		soapModel.setMaxQuantity(model.getMaxQuantity());
		soapModel.setActive(model.getActive());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPDiscountSoap[] toSoapModels(SPDiscount[] models) {
		SPDiscountSoap[] soapModels = new SPDiscountSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPDiscountSoap[][] toSoapModels(SPDiscount[][] models) {
		SPDiscountSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPDiscountSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPDiscountSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPDiscountSoap[] toSoapModels(List<SPDiscount> models) {
		List<SPDiscountSoap> soapModels = new ArrayList<SPDiscountSoap>(models.size());

		for (SPDiscount model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPDiscountSoap[soapModels.size()]);
	}

	public SPDiscountSoap() {
	}

	public long getPrimaryKey() {
		return _spDiscountId;
	}

	public void setPrimaryKey(long pk) {
		setSpDiscountId(pk);
	}

	public long getSpDiscountId() {
		return _spDiscountId;
	}

	public void setSpDiscountId(long spDiscountId) {
		_spDiscountId = spDiscountId;
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

	public boolean getPercent() {
		return _percent;
	}

	public boolean isPercent() {
		return _percent;
	}

	public void setPercent(boolean percent) {
		_percent = percent;
	}

	public long getPackageId() {
		return _packageId;
	}

	public void setPackageId(long packageId) {
		_packageId = packageId;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public String getCouponCode() {
		return _couponCode;
	}

	public void setCouponCode(String couponCode) {
		_couponCode = couponCode;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public int getMinQuantity() {
		return _minQuantity;
	}

	public void setMinQuantity(int minQuantity) {
		_minQuantity = minQuantity;
	}

	public int getMaxQuantity() {
		return _maxQuantity;
	}

	public void setMaxQuantity(int maxQuantity) {
		_maxQuantity = maxQuantity;
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

	private long _spDiscountId;
	private long _groupId;
	private String _title;
	private boolean _percent;
	private long _packageId;
	private String _value;
	private String _couponCode;
	private String _description;
	private Date _startDate;
	private Date _endDate;
	private int _minQuantity;
	private int _maxQuantity;
	private boolean _active;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}