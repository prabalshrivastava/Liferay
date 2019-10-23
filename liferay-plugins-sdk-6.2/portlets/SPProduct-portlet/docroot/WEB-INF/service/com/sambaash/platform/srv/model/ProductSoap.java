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
public class ProductSoap implements Serializable {
	public static ProductSoap toSoapModel(Product model) {
		ProductSoap soapModel = new ProductSoap();

		soapModel.setSpProductId(model.getSpProductId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setProductCode(model.getProductCode());
		soapModel.setProductName(model.getProductName());
		soapModel.setProductDesc(model.getProductDesc());
		soapModel.setProductImageId(model.getProductImageId());
		soapModel.setSpCourseId(model.getSpCourseId());
		soapModel.setProductBrochuresFolderId(model.getProductBrochuresFolderId());
		soapModel.setProductVideoFolderId(model.getProductVideoFolderId());
		soapModel.setStatus(model.getStatus());
		soapModel.setCreditValues(model.getCreditValues());
		soapModel.setPEProcessId(model.getPEProcessId());
		soapModel.setProductTemplateName(model.getProductTemplateName());
		soapModel.setProductTemplateLanguage(model.getProductTemplateLanguage());
		soapModel.setRegistrationEnabled(model.getRegistrationEnabled());
		soapModel.setSamePageRegistration(model.getSamePageRegistration());
		soapModel.setProductFormImageId(model.getProductFormImageId());
		soapModel.setProductFormName(model.getProductFormName());
		soapModel.setProductFormButtonName(model.getProductFormButtonName());
		soapModel.setProductFormUrl(model.getProductFormUrl());
		soapModel.setProductBannerImageId(model.getProductBannerImageId());
		soapModel.setHasInventory(model.getHasInventory());
		soapModel.setBannerDetailsEnabled(model.getBannerDetailsEnabled());

		return soapModel;
	}

	public static ProductSoap[] toSoapModels(Product[] models) {
		ProductSoap[] soapModels = new ProductSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[][] toSoapModels(Product[][] models) {
		ProductSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ProductSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ProductSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ProductSoap[] toSoapModels(List<Product> models) {
		List<ProductSoap> soapModels = new ArrayList<ProductSoap>(models.size());

		for (Product model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ProductSoap[soapModels.size()]);
	}

	public ProductSoap() {
	}

	public long getPrimaryKey() {
		return _spProductId;
	}

	public void setPrimaryKey(long pk) {
		setSpProductId(pk);
	}

	public long getSpProductId() {
		return _spProductId;
	}

	public void setSpProductId(long spProductId) {
		_spProductId = spProductId;
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

	public String getCountryId() {
		return _countryId;
	}

	public void setCountryId(String countryId) {
		_countryId = countryId;
	}

	public String getProductCode() {
		return _productCode;
	}

	public void setProductCode(String productCode) {
		_productCode = productCode;
	}

	public String getProductName() {
		return _productName;
	}

	public void setProductName(String productName) {
		_productName = productName;
	}

	public String getProductDesc() {
		return _productDesc;
	}

	public void setProductDesc(String productDesc) {
		_productDesc = productDesc;
	}

	public long getProductImageId() {
		return _productImageId;
	}

	public void setProductImageId(long productImageId) {
		_productImageId = productImageId;
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	public long getProductBrochuresFolderId() {
		return _productBrochuresFolderId;
	}

	public void setProductBrochuresFolderId(long productBrochuresFolderId) {
		_productBrochuresFolderId = productBrochuresFolderId;
	}

	public long getProductVideoFolderId() {
		return _productVideoFolderId;
	}

	public void setProductVideoFolderId(long productVideoFolderId) {
		_productVideoFolderId = productVideoFolderId;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public long getCreditValues() {
		return _creditValues;
	}

	public void setCreditValues(long creditValues) {
		_creditValues = creditValues;
	}

	public long getPEProcessId() {
		return _PEProcessId;
	}

	public void setPEProcessId(long PEProcessId) {
		_PEProcessId = PEProcessId;
	}

	public String getProductTemplateName() {
		return _productTemplateName;
	}

	public void setProductTemplateName(String productTemplateName) {
		_productTemplateName = productTemplateName;
	}

	public String getProductTemplateLanguage() {
		return _productTemplateLanguage;
	}

	public void setProductTemplateLanguage(String productTemplateLanguage) {
		_productTemplateLanguage = productTemplateLanguage;
	}

	public String getRegistrationEnabled() {
		return _registrationEnabled;
	}

	public void setRegistrationEnabled(String registrationEnabled) {
		_registrationEnabled = registrationEnabled;
	}

	public String getSamePageRegistration() {
		return _samePageRegistration;
	}

	public void setSamePageRegistration(String samePageRegistration) {
		_samePageRegistration = samePageRegistration;
	}

	public long getProductFormImageId() {
		return _productFormImageId;
	}

	public void setProductFormImageId(long productFormImageId) {
		_productFormImageId = productFormImageId;
	}

	public String getProductFormName() {
		return _productFormName;
	}

	public void setProductFormName(String productFormName) {
		_productFormName = productFormName;
	}

	public String getProductFormButtonName() {
		return _productFormButtonName;
	}

	public void setProductFormButtonName(String productFormButtonName) {
		_productFormButtonName = productFormButtonName;
	}

	public String getProductFormUrl() {
		return _productFormUrl;
	}

	public void setProductFormUrl(String productFormUrl) {
		_productFormUrl = productFormUrl;
	}

	public long getProductBannerImageId() {
		return _productBannerImageId;
	}

	public void setProductBannerImageId(long productBannerImageId) {
		_productBannerImageId = productBannerImageId;
	}

	public boolean getHasInventory() {
		return _hasInventory;
	}

	public boolean isHasInventory() {
		return _hasInventory;
	}

	public void setHasInventory(boolean hasInventory) {
		_hasInventory = hasInventory;
	}

	public String getBannerDetailsEnabled() {
		return _bannerDetailsEnabled;
	}

	public void setBannerDetailsEnabled(String bannerDetailsEnabled) {
		_bannerDetailsEnabled = bannerDetailsEnabled;
	}

	private long _spProductId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _countryId;
	private String _productCode;
	private String _productName;
	private String _productDesc;
	private long _productImageId;
	private long _spCourseId;
	private long _productBrochuresFolderId;
	private long _productVideoFolderId;
	private int _status;
	private long _creditValues;
	private long _PEProcessId;
	private String _productTemplateName;
	private String _productTemplateLanguage;
	private String _registrationEnabled;
	private String _samePageRegistration;
	private long _productFormImageId;
	private String _productFormName;
	private String _productFormButtonName;
	private String _productFormUrl;
	private long _productBannerImageId;
	private boolean _hasInventory;
	private String _bannerDetailsEnabled;
}