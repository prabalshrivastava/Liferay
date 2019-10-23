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
public class SPSellingPriceSoap implements Serializable {
	public static SPSellingPriceSoap toSoapModel(SPSellingPrice model) {
		SPSellingPriceSoap soapModel = new SPSellingPriceSoap();

		soapModel.setSpSellingPriceId(model.getSpSellingPriceId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setPriceRefId(model.getPriceRefId());
		soapModel.setPriceRefTypeId(model.getPriceRefTypeId());
		soapModel.setCurrencyCode(model.getCurrencyCode());
		soapModel.setBasePrice(model.getBasePrice());
		soapModel.setTaxName(model.getTaxName());
		soapModel.setTaxValue(model.getTaxValue());
		soapModel.setTotalPrice(model.getTotalPrice());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPSellingPriceSoap[] toSoapModels(SPSellingPrice[] models) {
		SPSellingPriceSoap[] soapModels = new SPSellingPriceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPSellingPriceSoap[][] toSoapModels(SPSellingPrice[][] models) {
		SPSellingPriceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPSellingPriceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPSellingPriceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPSellingPriceSoap[] toSoapModels(List<SPSellingPrice> models) {
		List<SPSellingPriceSoap> soapModels = new ArrayList<SPSellingPriceSoap>(models.size());

		for (SPSellingPrice model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPSellingPriceSoap[soapModels.size()]);
	}

	public SPSellingPriceSoap() {
	}

	public long getPrimaryKey() {
		return _spSellingPriceId;
	}

	public void setPrimaryKey(long pk) {
		setSpSellingPriceId(pk);
	}

	public long getSpSellingPriceId() {
		return _spSellingPriceId;
	}

	public void setSpSellingPriceId(long spSellingPriceId) {
		_spSellingPriceId = spSellingPriceId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getPriceRefId() {
		return _priceRefId;
	}

	public void setPriceRefId(long priceRefId) {
		_priceRefId = priceRefId;
	}

	public long getPriceRefTypeId() {
		return _priceRefTypeId;
	}

	public void setPriceRefTypeId(long priceRefTypeId) {
		_priceRefTypeId = priceRefTypeId;
	}

	public String getCurrencyCode() {
		return _currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		_currencyCode = currencyCode;
	}

	public String getBasePrice() {
		return _basePrice;
	}

	public void setBasePrice(String basePrice) {
		_basePrice = basePrice;
	}

	public String getTaxName() {
		return _taxName;
	}

	public void setTaxName(String taxName) {
		_taxName = taxName;
	}

	public String getTaxValue() {
		return _taxValue;
	}

	public void setTaxValue(String taxValue) {
		_taxValue = taxValue;
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

	private long _spSellingPriceId;
	private long _groupId;
	private long _priceRefId;
	private long _priceRefTypeId;
	private String _currencyCode;
	private String _basePrice;
	private String _taxName;
	private String _taxValue;
	private String _totalPrice;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}