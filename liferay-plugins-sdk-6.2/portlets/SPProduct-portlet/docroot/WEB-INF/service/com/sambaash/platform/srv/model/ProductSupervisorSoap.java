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

package com.sambaash.platform.srv.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class ProductSupervisorSoap implements Serializable {
	public static ProductSupervisorSoap toSoapModel(ProductSupervisor model) {
		ProductSupervisorSoap soapModel = new ProductSupervisorSoap();

		soapModel.setSpProductSupervisorId(model.getSpProductSupervisorId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryName(model.getCountryName());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setProductId(model.getProductId());
		soapModel.setSupervisorId(model.getSupervisorId());

		return soapModel;
	}

	public static ProductSupervisorSoap[] toSoapModels(
		ProductSupervisor[] models) {
		ProductSupervisorSoap[] soapModels = new ProductSupervisorSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductSupervisorSoap[][] toSoapModels(
		ProductSupervisor[][] models) {
		ProductSupervisorSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductSupervisorSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductSupervisorSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductSupervisorSoap[] toSoapModels(
		List<ProductSupervisor> models) {
		List<ProductSupervisorSoap> soapModels = new ArrayList<ProductSupervisorSoap>(models.size());

		for (ProductSupervisor model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductSupervisorSoap[soapModels.size()]);
	}

	public ProductSupervisorSoap() {
	}

	public long getPrimaryKey() {
		return _spProductSupervisorId;
	}

	public void setPrimaryKey(long pk) {
		setSpProductSupervisorId(pk);
	}

	public long getSpProductSupervisorId() {
		return _spProductSupervisorId;
	}

	public void setSpProductSupervisorId(long spProductSupervisorId) {
		_spProductSupervisorId = spProductSupervisorId;
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

	public String getCountryName() {
		return _countryName;
	}

	public void setCountryName(String countryName) {
		_countryName = countryName;
	}

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public long getProductId() {
		return _productId;
	}

	public void setProductId(long productId) {
		_productId = productId;
	}

	public long getSupervisorId() {
		return _supervisorId;
	}

	public void setSupervisorId(long supervisorId) {
		_supervisorId = supervisorId;
	}

	private long _spProductSupervisorId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _countryName;
	private long _countryId;
	private long _productId;
	private long _supervisorId;
}