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

package com.sambaash.platform.srv.sppayment.model;

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
public class SPPurchaseSoap implements Serializable {
	public static SPPurchaseSoap toSoapModel(SPPurchase model) {
		SPPurchaseSoap soapModel = new SPPurchaseSoap();

		soapModel.setSpPurchaseId(model.getSpPurchaseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCartId(model.getCartId());
		soapModel.setExtPaymentId(model.getExtPaymentId());
		soapModel.setExtStatus(model.getExtStatus());
		soapModel.setExtErrorCode(model.getExtErrorCode());
		soapModel.setExtErrorMsg(model.getExtErrorMsg());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPPurchaseSoap[] toSoapModels(SPPurchase[] models) {
		SPPurchaseSoap[] soapModels = new SPPurchaseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPPurchaseSoap[][] toSoapModels(SPPurchase[][] models) {
		SPPurchaseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPPurchaseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPPurchaseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPPurchaseSoap[] toSoapModels(List<SPPurchase> models) {
		List<SPPurchaseSoap> soapModels = new ArrayList<SPPurchaseSoap>(models.size());

		for (SPPurchase model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPPurchaseSoap[soapModels.size()]);
	}

	public SPPurchaseSoap() {
	}

	public long getPrimaryKey() {
		return _spPurchaseId;
	}

	public void setPrimaryKey(long pk) {
		setSpPurchaseId(pk);
	}

	public long getSpPurchaseId() {
		return _spPurchaseId;
	}

	public void setSpPurchaseId(long spPurchaseId) {
		_spPurchaseId = spPurchaseId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCartId() {
		return _cartId;
	}

	public void setCartId(long cartId) {
		_cartId = cartId;
	}

	public String getExtPaymentId() {
		return _extPaymentId;
	}

	public void setExtPaymentId(String extPaymentId) {
		_extPaymentId = extPaymentId;
	}

	public String getExtStatus() {
		return _extStatus;
	}

	public void setExtStatus(String extStatus) {
		_extStatus = extStatus;
	}

	public long getExtErrorCode() {
		return _extErrorCode;
	}

	public void setExtErrorCode(long extErrorCode) {
		_extErrorCode = extErrorCode;
	}

	public String getExtErrorMsg() {
		return _extErrorMsg;
	}

	public void setExtErrorMsg(String extErrorMsg) {
		_extErrorMsg = extErrorMsg;
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

	private long _spPurchaseId;
	private long _groupId;
	private long _cartId;
	private String _extPaymentId;
	private String _extStatus;
	private long _extErrorCode;
	private String _extErrorMsg;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}