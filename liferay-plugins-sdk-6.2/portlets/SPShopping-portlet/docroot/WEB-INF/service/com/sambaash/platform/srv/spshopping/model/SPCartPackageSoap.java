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
public class SPCartPackageSoap implements Serializable {
	public static SPCartPackageSoap toSoapModel(SPCartPackage model) {
		SPCartPackageSoap soapModel = new SPCartPackageSoap();

		soapModel.setSpCartPackageId(model.getSpCartPackageId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCartId(model.getCartId());
		soapModel.setPackageId(model.getPackageId());
		soapModel.setSelectedCurrency(model.getSelectedCurrency());
		soapModel.setUsedDiscountRefId(model.getUsedDiscountRefId());
		soapModel.setUsedDiscountRefPCId(model.getUsedDiscountRefPCId());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setInitialPrice(model.getInitialPrice());
		soapModel.setTotalPrice(model.getTotalPrice());
		soapModel.setRemarks(model.getRemarks());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPCartPackageSoap[] toSoapModels(SPCartPackage[] models) {
		SPCartPackageSoap[] soapModels = new SPCartPackageSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPCartPackageSoap[][] toSoapModels(SPCartPackage[][] models) {
		SPCartPackageSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPCartPackageSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPCartPackageSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPCartPackageSoap[] toSoapModels(List<SPCartPackage> models) {
		List<SPCartPackageSoap> soapModels = new ArrayList<SPCartPackageSoap>(models.size());

		for (SPCartPackage model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPCartPackageSoap[soapModels.size()]);
	}

	public SPCartPackageSoap() {
	}

	public long getPrimaryKey() {
		return _spCartPackageId;
	}

	public void setPrimaryKey(long pk) {
		setSpCartPackageId(pk);
	}

	public long getSpCartPackageId() {
		return _spCartPackageId;
	}

	public void setSpCartPackageId(long spCartPackageId) {
		_spCartPackageId = spCartPackageId;
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

	public long getPackageId() {
		return _packageId;
	}

	public void setPackageId(long packageId) {
		_packageId = packageId;
	}

	public String getSelectedCurrency() {
		return _selectedCurrency;
	}

	public void setSelectedCurrency(String selectedCurrency) {
		_selectedCurrency = selectedCurrency;
	}

	public long getUsedDiscountRefId() {
		return _usedDiscountRefId;
	}

	public void setUsedDiscountRefId(long usedDiscountRefId) {
		_usedDiscountRefId = usedDiscountRefId;
	}

	public long getUsedDiscountRefPCId() {
		return _usedDiscountRefPCId;
	}

	public void setUsedDiscountRefPCId(long usedDiscountRefPCId) {
		_usedDiscountRefPCId = usedDiscountRefPCId;
	}

	public String getDiscount() {
		return _discount;
	}

	public void setDiscount(String discount) {
		_discount = discount;
	}

	public String getInitialPrice() {
		return _initialPrice;
	}

	public void setInitialPrice(String initialPrice) {
		_initialPrice = initialPrice;
	}

	public String getTotalPrice() {
		return _totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		_totalPrice = totalPrice;
	}

	public String getRemarks() {
		return _remarks;
	}

	public void setRemarks(String remarks) {
		_remarks = remarks;
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

	private long _spCartPackageId;
	private long _groupId;
	private long _cartId;
	private long _packageId;
	private String _selectedCurrency;
	private long _usedDiscountRefId;
	private long _usedDiscountRefPCId;
	private String _discount;
	private String _initialPrice;
	private String _totalPrice;
	private String _remarks;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}