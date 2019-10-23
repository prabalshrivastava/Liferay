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
public class SPTaxSoap implements Serializable {
	public static SPTaxSoap toSoapModel(SPTax model) {
		SPTaxSoap soapModel = new SPTaxSoap();

		soapModel.setSpTaxId(model.getSpTaxId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCurrencyCode(model.getCurrencyCode());
		soapModel.setTaxName(model.getTaxName());
		soapModel.setTaxValue(model.getTaxValue());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPTaxSoap[] toSoapModels(SPTax[] models) {
		SPTaxSoap[] soapModels = new SPTaxSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPTaxSoap[][] toSoapModels(SPTax[][] models) {
		SPTaxSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPTaxSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPTaxSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPTaxSoap[] toSoapModels(List<SPTax> models) {
		List<SPTaxSoap> soapModels = new ArrayList<SPTaxSoap>(models.size());

		for (SPTax model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPTaxSoap[soapModels.size()]);
	}

	public SPTaxSoap() {
	}

	public long getPrimaryKey() {
		return _spTaxId;
	}

	public void setPrimaryKey(long pk) {
		setSpTaxId(pk);
	}

	public long getSpTaxId() {
		return _spTaxId;
	}

	public void setSpTaxId(long spTaxId) {
		_spTaxId = spTaxId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public String getCurrencyCode() {
		return _currencyCode;
	}

	public void setCurrencyCode(String currencyCode) {
		_currencyCode = currencyCode;
	}

	public String getTaxName() {
		return _taxName;
	}

	public void setTaxName(String taxName) {
		_taxName = taxName;
	}

	public long getTaxValue() {
		return _taxValue;
	}

	public void setTaxValue(long taxValue) {
		_taxValue = taxValue;
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

	private long _spTaxId;
	private long _groupId;
	private String _currencyCode;
	private String _taxName;
	private long _taxValue;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
}