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
public class SPCartSoap implements Serializable {
	public static SPCartSoap toSoapModel(SPCart model) {
		SPCartSoap soapModel = new SPCartSoap();

		soapModel.setSpCartId(model.getSpCartId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setTotalPrice(model.getTotalPrice());
		soapModel.setUserRemarks(model.getUserRemarks());
		soapModel.setStatus(model.getStatus());
		soapModel.setTransactionDetails(model.getTransactionDetails());
		soapModel.setOrderPage(model.getOrderPage());
		soapModel.setRsvpDetailId(model.getRsvpDetailId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPCartSoap[] toSoapModels(SPCart[] models) {
		SPCartSoap[] soapModels = new SPCartSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPCartSoap[][] toSoapModels(SPCart[][] models) {
		SPCartSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPCartSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPCartSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPCartSoap[] toSoapModels(List<SPCart> models) {
		List<SPCartSoap> soapModels = new ArrayList<SPCartSoap>(models.size());

		for (SPCart model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPCartSoap[soapModels.size()]);
	}

	public SPCartSoap() {
	}

	public long getPrimaryKey() {
		return _spCartId;
	}

	public void setPrimaryKey(long pk) {
		setSpCartId(pk);
	}

	public long getSpCartId() {
		return _spCartId;
	}

	public void setSpCartId(long spCartId) {
		_spCartId = spCartId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getDiscount() {
		return _discount;
	}

	public void setDiscount(String discount) {
		_discount = discount;
	}

	public String getTotalPrice() {
		return _totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		_totalPrice = totalPrice;
	}

	public String getUserRemarks() {
		return _userRemarks;
	}

	public void setUserRemarks(String userRemarks) {
		_userRemarks = userRemarks;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getTransactionDetails() {
		return _transactionDetails;
	}

	public void setTransactionDetails(String transactionDetails) {
		_transactionDetails = transactionDetails;
	}

	public String getOrderPage() {
		return _orderPage;
	}

	public void setOrderPage(String orderPage) {
		_orderPage = orderPage;
	}

	public long getRsvpDetailId() {
		return _rsvpDetailId;
	}

	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpDetailId = rsvpDetailId;
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

	private long _spCartId;
	private long _groupId;
	private String _discount;
	private String _totalPrice;
	private String _userRemarks;
	private int _status;
	private String _transactionDetails;
	private String _orderPage;
	private long _rsvpDetailId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}