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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.service.ClpSerializer;
import com.sambaash.platform.srv.service.ProductLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ProductClp extends BaseModelImpl<Product> implements Product {
	public ProductClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Product.class;
	}

	@Override
	public String getModelClassName() {
		return Product.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spProductId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpProductId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spProductId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spProductId", getSpProductId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("productCode", getProductCode());
		attributes.put("productName", getProductName());
		attributes.put("productDesc", getProductDesc());
		attributes.put("productImageId", getProductImageId());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("productBrochuresFolderId", getProductBrochuresFolderId());
		attributes.put("productVideoFolderId", getProductVideoFolderId());
		attributes.put("status", getStatus());
		attributes.put("creditValues", getCreditValues());
		attributes.put("PEProcessId", getPEProcessId());
		attributes.put("productTemplateName", getProductTemplateName());
		attributes.put("productTemplateLanguage", getProductTemplateLanguage());
		attributes.put("registrationEnabled", getRegistrationEnabled());
		attributes.put("samePageRegistration", getSamePageRegistration());
		attributes.put("productFormImageId", getProductFormImageId());
		attributes.put("productFormName", getProductFormName());
		attributes.put("productFormButtonName", getProductFormButtonName());
		attributes.put("productFormUrl", getProductFormUrl());
		attributes.put("productBannerImageId", getProductBannerImageId());
		attributes.put("hasInventory", getHasInventory());
		attributes.put("bannerDetailsEnabled", getBannerDetailsEnabled());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spProductId = (Long)attributes.get("spProductId");

		if (spProductId != null) {
			setSpProductId(spProductId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String countryId = (String)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String productCode = (String)attributes.get("productCode");

		if (productCode != null) {
			setProductCode(productCode);
		}

		String productName = (String)attributes.get("productName");

		if (productName != null) {
			setProductName(productName);
		}

		String productDesc = (String)attributes.get("productDesc");

		if (productDesc != null) {
			setProductDesc(productDesc);
		}

		Long productImageId = (Long)attributes.get("productImageId");

		if (productImageId != null) {
			setProductImageId(productImageId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}

		Long productBrochuresFolderId = (Long)attributes.get(
				"productBrochuresFolderId");

		if (productBrochuresFolderId != null) {
			setProductBrochuresFolderId(productBrochuresFolderId);
		}

		Long productVideoFolderId = (Long)attributes.get("productVideoFolderId");

		if (productVideoFolderId != null) {
			setProductVideoFolderId(productVideoFolderId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long creditValues = (Long)attributes.get("creditValues");

		if (creditValues != null) {
			setCreditValues(creditValues);
		}

		Long PEProcessId = (Long)attributes.get("PEProcessId");

		if (PEProcessId != null) {
			setPEProcessId(PEProcessId);
		}

		String productTemplateName = (String)attributes.get(
				"productTemplateName");

		if (productTemplateName != null) {
			setProductTemplateName(productTemplateName);
		}

		String productTemplateLanguage = (String)attributes.get(
				"productTemplateLanguage");

		if (productTemplateLanguage != null) {
			setProductTemplateLanguage(productTemplateLanguage);
		}

		String registrationEnabled = (String)attributes.get(
				"registrationEnabled");

		if (registrationEnabled != null) {
			setRegistrationEnabled(registrationEnabled);
		}

		String samePageRegistration = (String)attributes.get(
				"samePageRegistration");

		if (samePageRegistration != null) {
			setSamePageRegistration(samePageRegistration);
		}

		Long productFormImageId = (Long)attributes.get("productFormImageId");

		if (productFormImageId != null) {
			setProductFormImageId(productFormImageId);
		}

		String productFormName = (String)attributes.get("productFormName");

		if (productFormName != null) {
			setProductFormName(productFormName);
		}

		String productFormButtonName = (String)attributes.get(
				"productFormButtonName");

		if (productFormButtonName != null) {
			setProductFormButtonName(productFormButtonName);
		}

		String productFormUrl = (String)attributes.get("productFormUrl");

		if (productFormUrl != null) {
			setProductFormUrl(productFormUrl);
		}

		Long productBannerImageId = (Long)attributes.get("productBannerImageId");

		if (productBannerImageId != null) {
			setProductBannerImageId(productBannerImageId);
		}

		Boolean hasInventory = (Boolean)attributes.get("hasInventory");

		if (hasInventory != null) {
			setHasInventory(hasInventory);
		}

		String bannerDetailsEnabled = (String)attributes.get(
				"bannerDetailsEnabled");

		if (bannerDetailsEnabled != null) {
			setBannerDetailsEnabled(bannerDetailsEnabled);
		}
	}

	@Override
	public long getSpProductId() {
		return _spProductId;
	}

	@Override
	public void setSpProductId(long spProductId) {
		_spProductId = spProductId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setSpProductId", long.class);

				method.invoke(_productRemoteModel, spProductId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_productRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_productRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_productRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_productRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_productRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_productRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(String countryId) {
		_countryId = countryId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", String.class);

				method.invoke(_productRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductCode() {
		return _productCode;
	}

	@Override
	public void setProductCode(String productCode) {
		_productCode = productCode;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductCode", String.class);

				method.invoke(_productRemoteModel, productCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductName() {
		return _productName;
	}

	@Override
	public void setProductName(String productName) {
		_productName = productName;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductName", String.class);

				method.invoke(_productRemoteModel, productName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductDesc() {
		return _productDesc;
	}

	@Override
	public void setProductDesc(String productDesc) {
		_productDesc = productDesc;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductDesc", String.class);

				method.invoke(_productRemoteModel, productDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductImageId() {
		return _productImageId;
	}

	@Override
	public void setProductImageId(long productImageId) {
		_productImageId = productImageId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductImageId", long.class);

				method.invoke(_productRemoteModel, productImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_productRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductBrochuresFolderId() {
		return _productBrochuresFolderId;
	}

	@Override
	public void setProductBrochuresFolderId(long productBrochuresFolderId) {
		_productBrochuresFolderId = productBrochuresFolderId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductBrochuresFolderId",
						long.class);

				method.invoke(_productRemoteModel, productBrochuresFolderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductVideoFolderId() {
		return _productVideoFolderId;
	}

	@Override
	public void setProductVideoFolderId(long productVideoFolderId) {
		_productVideoFolderId = productVideoFolderId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductVideoFolderId",
						long.class);

				method.invoke(_productRemoteModel, productVideoFolderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_productRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreditValues() {
		return _creditValues;
	}

	@Override
	public void setCreditValues(long creditValues) {
		_creditValues = creditValues;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditValues", long.class);

				method.invoke(_productRemoteModel, creditValues);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPEProcessId() {
		return _PEProcessId;
	}

	@Override
	public void setPEProcessId(long PEProcessId) {
		_PEProcessId = PEProcessId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setPEProcessId", long.class);

				method.invoke(_productRemoteModel, PEProcessId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductTemplateName() {
		return _productTemplateName;
	}

	@Override
	public void setProductTemplateName(String productTemplateName) {
		_productTemplateName = productTemplateName;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductTemplateName",
						String.class);

				method.invoke(_productRemoteModel, productTemplateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductTemplateLanguage() {
		return _productTemplateLanguage;
	}

	@Override
	public void setProductTemplateLanguage(String productTemplateLanguage) {
		_productTemplateLanguage = productTemplateLanguage;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductTemplateLanguage",
						String.class);

				method.invoke(_productRemoteModel, productTemplateLanguage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegistrationEnabled() {
		return _registrationEnabled;
	}

	@Override
	public void setRegistrationEnabled(String registrationEnabled) {
		_registrationEnabled = registrationEnabled;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setRegistrationEnabled",
						String.class);

				method.invoke(_productRemoteModel, registrationEnabled);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSamePageRegistration() {
		return _samePageRegistration;
	}

	@Override
	public void setSamePageRegistration(String samePageRegistration) {
		_samePageRegistration = samePageRegistration;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setSamePageRegistration",
						String.class);

				method.invoke(_productRemoteModel, samePageRegistration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductFormImageId() {
		return _productFormImageId;
	}

	@Override
	public void setProductFormImageId(long productFormImageId) {
		_productFormImageId = productFormImageId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductFormImageId",
						long.class);

				method.invoke(_productRemoteModel, productFormImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductFormName() {
		return _productFormName;
	}

	@Override
	public void setProductFormName(String productFormName) {
		_productFormName = productFormName;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductFormName",
						String.class);

				method.invoke(_productRemoteModel, productFormName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductFormButtonName() {
		return _productFormButtonName;
	}

	@Override
	public void setProductFormButtonName(String productFormButtonName) {
		_productFormButtonName = productFormButtonName;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductFormButtonName",
						String.class);

				method.invoke(_productRemoteModel, productFormButtonName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProductFormUrl() {
		return _productFormUrl;
	}

	@Override
	public void setProductFormUrl(String productFormUrl) {
		_productFormUrl = productFormUrl;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductFormUrl",
						String.class);

				method.invoke(_productRemoteModel, productFormUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProductBannerImageId() {
		return _productBannerImageId;
	}

	@Override
	public void setProductBannerImageId(long productBannerImageId) {
		_productBannerImageId = productBannerImageId;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setProductBannerImageId",
						long.class);

				method.invoke(_productRemoteModel, productBannerImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getHasInventory() {
		return _hasInventory;
	}

	@Override
	public boolean isHasInventory() {
		return _hasInventory;
	}

	@Override
	public void setHasInventory(boolean hasInventory) {
		_hasInventory = hasInventory;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setHasInventory", boolean.class);

				method.invoke(_productRemoteModel, hasInventory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBannerDetailsEnabled() {
		return _bannerDetailsEnabled;
	}

	@Override
	public void setBannerDetailsEnabled(String bannerDetailsEnabled) {
		_bannerDetailsEnabled = bannerDetailsEnabled;

		if (_productRemoteModel != null) {
			try {
				Class<?> clazz = _productRemoteModel.getClass();

				Method method = clazz.getMethod("setBannerDetailsEnabled",
						String.class);

				method.invoke(_productRemoteModel, bannerDetailsEnabled);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProductRemoteModel() {
		return _productRemoteModel;
	}

	public void setProductRemoteModel(BaseModel<?> productRemoteModel) {
		_productRemoteModel = productRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _productRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_productRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProductLocalServiceUtil.addProduct(this);
		}
		else {
			ProductLocalServiceUtil.updateProduct(this);
		}
	}

	@Override
	public Product toEscapedModel() {
		return (Product)ProxyUtil.newProxyInstance(Product.class.getClassLoader(),
			new Class[] { Product.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProductClp clone = new ProductClp();

		clone.setSpProductId(getSpProductId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryId(getCountryId());
		clone.setProductCode(getProductCode());
		clone.setProductName(getProductName());
		clone.setProductDesc(getProductDesc());
		clone.setProductImageId(getProductImageId());
		clone.setSpCourseId(getSpCourseId());
		clone.setProductBrochuresFolderId(getProductBrochuresFolderId());
		clone.setProductVideoFolderId(getProductVideoFolderId());
		clone.setStatus(getStatus());
		clone.setCreditValues(getCreditValues());
		clone.setPEProcessId(getPEProcessId());
		clone.setProductTemplateName(getProductTemplateName());
		clone.setProductTemplateLanguage(getProductTemplateLanguage());
		clone.setRegistrationEnabled(getRegistrationEnabled());
		clone.setSamePageRegistration(getSamePageRegistration());
		clone.setProductFormImageId(getProductFormImageId());
		clone.setProductFormName(getProductFormName());
		clone.setProductFormButtonName(getProductFormButtonName());
		clone.setProductFormUrl(getProductFormUrl());
		clone.setProductBannerImageId(getProductBannerImageId());
		clone.setHasInventory(getHasInventory());
		clone.setBannerDetailsEnabled(getBannerDetailsEnabled());

		return clone;
	}

	@Override
	public int compareTo(Product product) {
		int value = 0;

		value = getProductName().compareTo(product.getProductName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductClp)) {
			return false;
		}

		ProductClp product = (ProductClp)obj;

		long primaryKey = product.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(59);

		sb.append("{spProductId=");
		sb.append(getSpProductId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", productCode=");
		sb.append(getProductCode());
		sb.append(", productName=");
		sb.append(getProductName());
		sb.append(", productDesc=");
		sb.append(getProductDesc());
		sb.append(", productImageId=");
		sb.append(getProductImageId());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append(", productBrochuresFolderId=");
		sb.append(getProductBrochuresFolderId());
		sb.append(", productVideoFolderId=");
		sb.append(getProductVideoFolderId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", creditValues=");
		sb.append(getCreditValues());
		sb.append(", PEProcessId=");
		sb.append(getPEProcessId());
		sb.append(", productTemplateName=");
		sb.append(getProductTemplateName());
		sb.append(", productTemplateLanguage=");
		sb.append(getProductTemplateLanguage());
		sb.append(", registrationEnabled=");
		sb.append(getRegistrationEnabled());
		sb.append(", samePageRegistration=");
		sb.append(getSamePageRegistration());
		sb.append(", productFormImageId=");
		sb.append(getProductFormImageId());
		sb.append(", productFormName=");
		sb.append(getProductFormName());
		sb.append(", productFormButtonName=");
		sb.append(getProductFormButtonName());
		sb.append(", productFormUrl=");
		sb.append(getProductFormUrl());
		sb.append(", productBannerImageId=");
		sb.append(getProductBannerImageId());
		sb.append(", hasInventory=");
		sb.append(getHasInventory());
		sb.append(", bannerDetailsEnabled=");
		sb.append(getBannerDetailsEnabled());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(91);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Product");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spProductId</column-name><column-value><![CDATA[");
		sb.append(getSpProductId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productCode</column-name><column-value><![CDATA[");
		sb.append(getProductCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productName</column-name><column-value><![CDATA[");
		sb.append(getProductName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productDesc</column-name><column-value><![CDATA[");
		sb.append(getProductDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productImageId</column-name><column-value><![CDATA[");
		sb.append(getProductImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productBrochuresFolderId</column-name><column-value><![CDATA[");
		sb.append(getProductBrochuresFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productVideoFolderId</column-name><column-value><![CDATA[");
		sb.append(getProductVideoFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditValues</column-name><column-value><![CDATA[");
		sb.append(getCreditValues());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>PEProcessId</column-name><column-value><![CDATA[");
		sb.append(getPEProcessId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productTemplateName</column-name><column-value><![CDATA[");
		sb.append(getProductTemplateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productTemplateLanguage</column-name><column-value><![CDATA[");
		sb.append(getProductTemplateLanguage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>registrationEnabled</column-name><column-value><![CDATA[");
		sb.append(getRegistrationEnabled());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>samePageRegistration</column-name><column-value><![CDATA[");
		sb.append(getSamePageRegistration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productFormImageId</column-name><column-value><![CDATA[");
		sb.append(getProductFormImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productFormName</column-name><column-value><![CDATA[");
		sb.append(getProductFormName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productFormButtonName</column-name><column-value><![CDATA[");
		sb.append(getProductFormButtonName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productFormUrl</column-name><column-value><![CDATA[");
		sb.append(getProductFormUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>productBannerImageId</column-name><column-value><![CDATA[");
		sb.append(getProductBannerImageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hasInventory</column-name><column-value><![CDATA[");
		sb.append(getHasInventory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bannerDetailsEnabled</column-name><column-value><![CDATA[");
		sb.append(getBannerDetailsEnabled());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spProductId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _productRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}