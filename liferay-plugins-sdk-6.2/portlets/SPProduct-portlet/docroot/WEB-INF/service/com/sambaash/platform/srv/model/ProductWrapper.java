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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Product}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Product
 * @generated
 */
public class ProductWrapper implements Product, ModelWrapper<Product> {
	public ProductWrapper(Product product) {
		_product = product;
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

	/**
	* Returns the primary key of this product.
	*
	* @return the primary key of this product
	*/
	@Override
	public long getPrimaryKey() {
		return _product.getPrimaryKey();
	}

	/**
	* Sets the primary key of this product.
	*
	* @param primaryKey the primary key of this product
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_product.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp product ID of this product.
	*
	* @return the sp product ID of this product
	*/
	@Override
	public long getSpProductId() {
		return _product.getSpProductId();
	}

	/**
	* Sets the sp product ID of this product.
	*
	* @param spProductId the sp product ID of this product
	*/
	@Override
	public void setSpProductId(long spProductId) {
		_product.setSpProductId(spProductId);
	}

	/**
	* Returns the group ID of this product.
	*
	* @return the group ID of this product
	*/
	@Override
	public long getGroupId() {
		return _product.getGroupId();
	}

	/**
	* Sets the group ID of this product.
	*
	* @param groupId the group ID of this product
	*/
	@Override
	public void setGroupId(long groupId) {
		_product.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this product.
	*
	* @return the company ID of this product
	*/
	@Override
	public long getCompanyId() {
		return _product.getCompanyId();
	}

	/**
	* Sets the company ID of this product.
	*
	* @param companyId the company ID of this product
	*/
	@Override
	public void setCompanyId(long companyId) {
		_product.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this product.
	*
	* @return the user ID of this product
	*/
	@Override
	public long getUserId() {
		return _product.getUserId();
	}

	/**
	* Sets the user ID of this product.
	*
	* @param userId the user ID of this product
	*/
	@Override
	public void setUserId(long userId) {
		_product.setUserId(userId);
	}

	/**
	* Returns the user uuid of this product.
	*
	* @return the user uuid of this product
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _product.getUserUuid();
	}

	/**
	* Sets the user uuid of this product.
	*
	* @param userUuid the user uuid of this product
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_product.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this product.
	*
	* @return the user name of this product
	*/
	@Override
	public java.lang.String getUserName() {
		return _product.getUserName();
	}

	/**
	* Sets the user name of this product.
	*
	* @param userName the user name of this product
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_product.setUserName(userName);
	}

	/**
	* Returns the create date of this product.
	*
	* @return the create date of this product
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _product.getCreateDate();
	}

	/**
	* Sets the create date of this product.
	*
	* @param createDate the create date of this product
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_product.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this product.
	*
	* @return the modified date of this product
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _product.getModifiedDate();
	}

	/**
	* Sets the modified date of this product.
	*
	* @param modifiedDate the modified date of this product
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_product.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country ID of this product.
	*
	* @return the country ID of this product
	*/
	@Override
	public java.lang.String getCountryId() {
		return _product.getCountryId();
	}

	/**
	* Sets the country ID of this product.
	*
	* @param countryId the country ID of this product
	*/
	@Override
	public void setCountryId(java.lang.String countryId) {
		_product.setCountryId(countryId);
	}

	/**
	* Returns the product code of this product.
	*
	* @return the product code of this product
	*/
	@Override
	public java.lang.String getProductCode() {
		return _product.getProductCode();
	}

	/**
	* Sets the product code of this product.
	*
	* @param productCode the product code of this product
	*/
	@Override
	public void setProductCode(java.lang.String productCode) {
		_product.setProductCode(productCode);
	}

	/**
	* Returns the product name of this product.
	*
	* @return the product name of this product
	*/
	@Override
	public java.lang.String getProductName() {
		return _product.getProductName();
	}

	/**
	* Sets the product name of this product.
	*
	* @param productName the product name of this product
	*/
	@Override
	public void setProductName(java.lang.String productName) {
		_product.setProductName(productName);
	}

	/**
	* Returns the product desc of this product.
	*
	* @return the product desc of this product
	*/
	@Override
	public java.lang.String getProductDesc() {
		return _product.getProductDesc();
	}

	/**
	* Sets the product desc of this product.
	*
	* @param productDesc the product desc of this product
	*/
	@Override
	public void setProductDesc(java.lang.String productDesc) {
		_product.setProductDesc(productDesc);
	}

	/**
	* Returns the product image ID of this product.
	*
	* @return the product image ID of this product
	*/
	@Override
	public long getProductImageId() {
		return _product.getProductImageId();
	}

	/**
	* Sets the product image ID of this product.
	*
	* @param productImageId the product image ID of this product
	*/
	@Override
	public void setProductImageId(long productImageId) {
		_product.setProductImageId(productImageId);
	}

	/**
	* Returns the sp course ID of this product.
	*
	* @return the sp course ID of this product
	*/
	@Override
	public long getSpCourseId() {
		return _product.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this product.
	*
	* @param spCourseId the sp course ID of this product
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_product.setSpCourseId(spCourseId);
	}

	/**
	* Returns the product brochures folder ID of this product.
	*
	* @return the product brochures folder ID of this product
	*/
	@Override
	public long getProductBrochuresFolderId() {
		return _product.getProductBrochuresFolderId();
	}

	/**
	* Sets the product brochures folder ID of this product.
	*
	* @param productBrochuresFolderId the product brochures folder ID of this product
	*/
	@Override
	public void setProductBrochuresFolderId(long productBrochuresFolderId) {
		_product.setProductBrochuresFolderId(productBrochuresFolderId);
	}

	/**
	* Returns the product video folder ID of this product.
	*
	* @return the product video folder ID of this product
	*/
	@Override
	public long getProductVideoFolderId() {
		return _product.getProductVideoFolderId();
	}

	/**
	* Sets the product video folder ID of this product.
	*
	* @param productVideoFolderId the product video folder ID of this product
	*/
	@Override
	public void setProductVideoFolderId(long productVideoFolderId) {
		_product.setProductVideoFolderId(productVideoFolderId);
	}

	/**
	* Returns the status of this product.
	*
	* @return the status of this product
	*/
	@Override
	public int getStatus() {
		return _product.getStatus();
	}

	/**
	* Sets the status of this product.
	*
	* @param status the status of this product
	*/
	@Override
	public void setStatus(int status) {
		_product.setStatus(status);
	}

	/**
	* Returns the credit values of this product.
	*
	* @return the credit values of this product
	*/
	@Override
	public long getCreditValues() {
		return _product.getCreditValues();
	}

	/**
	* Sets the credit values of this product.
	*
	* @param creditValues the credit values of this product
	*/
	@Override
	public void setCreditValues(long creditValues) {
		_product.setCreditValues(creditValues);
	}

	/**
	* Returns the p e process ID of this product.
	*
	* @return the p e process ID of this product
	*/
	@Override
	public long getPEProcessId() {
		return _product.getPEProcessId();
	}

	/**
	* Sets the p e process ID of this product.
	*
	* @param PEProcessId the p e process ID of this product
	*/
	@Override
	public void setPEProcessId(long PEProcessId) {
		_product.setPEProcessId(PEProcessId);
	}

	/**
	* Returns the product template name of this product.
	*
	* @return the product template name of this product
	*/
	@Override
	public java.lang.String getProductTemplateName() {
		return _product.getProductTemplateName();
	}

	/**
	* Sets the product template name of this product.
	*
	* @param productTemplateName the product template name of this product
	*/
	@Override
	public void setProductTemplateName(java.lang.String productTemplateName) {
		_product.setProductTemplateName(productTemplateName);
	}

	/**
	* Returns the product template language of this product.
	*
	* @return the product template language of this product
	*/
	@Override
	public java.lang.String getProductTemplateLanguage() {
		return _product.getProductTemplateLanguage();
	}

	/**
	* Sets the product template language of this product.
	*
	* @param productTemplateLanguage the product template language of this product
	*/
	@Override
	public void setProductTemplateLanguage(
		java.lang.String productTemplateLanguage) {
		_product.setProductTemplateLanguage(productTemplateLanguage);
	}

	/**
	* Returns the registration enabled of this product.
	*
	* @return the registration enabled of this product
	*/
	@Override
	public java.lang.String getRegistrationEnabled() {
		return _product.getRegistrationEnabled();
	}

	/**
	* Sets the registration enabled of this product.
	*
	* @param registrationEnabled the registration enabled of this product
	*/
	@Override
	public void setRegistrationEnabled(java.lang.String registrationEnabled) {
		_product.setRegistrationEnabled(registrationEnabled);
	}

	/**
	* Returns the same page registration of this product.
	*
	* @return the same page registration of this product
	*/
	@Override
	public java.lang.String getSamePageRegistration() {
		return _product.getSamePageRegistration();
	}

	/**
	* Sets the same page registration of this product.
	*
	* @param samePageRegistration the same page registration of this product
	*/
	@Override
	public void setSamePageRegistration(java.lang.String samePageRegistration) {
		_product.setSamePageRegistration(samePageRegistration);
	}

	/**
	* Returns the product form image ID of this product.
	*
	* @return the product form image ID of this product
	*/
	@Override
	public long getProductFormImageId() {
		return _product.getProductFormImageId();
	}

	/**
	* Sets the product form image ID of this product.
	*
	* @param productFormImageId the product form image ID of this product
	*/
	@Override
	public void setProductFormImageId(long productFormImageId) {
		_product.setProductFormImageId(productFormImageId);
	}

	/**
	* Returns the product form name of this product.
	*
	* @return the product form name of this product
	*/
	@Override
	public java.lang.String getProductFormName() {
		return _product.getProductFormName();
	}

	/**
	* Sets the product form name of this product.
	*
	* @param productFormName the product form name of this product
	*/
	@Override
	public void setProductFormName(java.lang.String productFormName) {
		_product.setProductFormName(productFormName);
	}

	/**
	* Returns the product form button name of this product.
	*
	* @return the product form button name of this product
	*/
	@Override
	public java.lang.String getProductFormButtonName() {
		return _product.getProductFormButtonName();
	}

	/**
	* Sets the product form button name of this product.
	*
	* @param productFormButtonName the product form button name of this product
	*/
	@Override
	public void setProductFormButtonName(java.lang.String productFormButtonName) {
		_product.setProductFormButtonName(productFormButtonName);
	}

	/**
	* Returns the product form url of this product.
	*
	* @return the product form url of this product
	*/
	@Override
	public java.lang.String getProductFormUrl() {
		return _product.getProductFormUrl();
	}

	/**
	* Sets the product form url of this product.
	*
	* @param productFormUrl the product form url of this product
	*/
	@Override
	public void setProductFormUrl(java.lang.String productFormUrl) {
		_product.setProductFormUrl(productFormUrl);
	}

	/**
	* Returns the product banner image ID of this product.
	*
	* @return the product banner image ID of this product
	*/
	@Override
	public long getProductBannerImageId() {
		return _product.getProductBannerImageId();
	}

	/**
	* Sets the product banner image ID of this product.
	*
	* @param productBannerImageId the product banner image ID of this product
	*/
	@Override
	public void setProductBannerImageId(long productBannerImageId) {
		_product.setProductBannerImageId(productBannerImageId);
	}

	/**
	* Returns the has inventory of this product.
	*
	* @return the has inventory of this product
	*/
	@Override
	public boolean getHasInventory() {
		return _product.getHasInventory();
	}

	/**
	* Returns <code>true</code> if this product is has inventory.
	*
	* @return <code>true</code> if this product is has inventory; <code>false</code> otherwise
	*/
	@Override
	public boolean isHasInventory() {
		return _product.isHasInventory();
	}

	/**
	* Sets whether this product is has inventory.
	*
	* @param hasInventory the has inventory of this product
	*/
	@Override
	public void setHasInventory(boolean hasInventory) {
		_product.setHasInventory(hasInventory);
	}

	/**
	* Returns the banner details enabled of this product.
	*
	* @return the banner details enabled of this product
	*/
	@Override
	public java.lang.String getBannerDetailsEnabled() {
		return _product.getBannerDetailsEnabled();
	}

	/**
	* Sets the banner details enabled of this product.
	*
	* @param bannerDetailsEnabled the banner details enabled of this product
	*/
	@Override
	public void setBannerDetailsEnabled(java.lang.String bannerDetailsEnabled) {
		_product.setBannerDetailsEnabled(bannerDetailsEnabled);
	}

	@Override
	public boolean isNew() {
		return _product.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_product.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _product.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_product.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _product.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _product.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_product.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _product.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_product.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_product.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_product.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProductWrapper((Product)_product.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Product product) {
		return _product.compareTo(product);
	}

	@Override
	public int hashCode() {
		return _product.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Product> toCacheModel() {
		return _product.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Product toEscapedModel() {
		return new ProductWrapper(_product.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Product toUnescapedModel() {
		return new ProductWrapper(_product.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _product.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _product.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_product.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProductWrapper)) {
			return false;
		}

		ProductWrapper productWrapper = (ProductWrapper)obj;

		if (Validator.equals(_product, productWrapper._product)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Product getWrappedProduct() {
		return _product;
	}

	@Override
	public Product getWrappedModel() {
		return _product;
	}

	@Override
	public void resetOriginalValues() {
		_product.resetOriginalValues();
	}

	private Product _product;
}