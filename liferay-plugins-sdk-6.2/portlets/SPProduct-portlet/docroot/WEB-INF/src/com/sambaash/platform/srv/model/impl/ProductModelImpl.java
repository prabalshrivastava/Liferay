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

package com.sambaash.platform.srv.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sambaash.platform.srv.model.Product;
import com.sambaash.platform.srv.model.ProductModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the Product service. Represents a row in the &quot;SPProduct&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.model.ProductModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link ProductImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProductImpl
 * @see com.sambaash.platform.srv.model.Product
 * @see com.sambaash.platform.srv.model.ProductModel
 * @generated
 */
public class ProductModelImpl extends BaseModelImpl<Product>
	implements ProductModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a product model instance should use the {@link com.sambaash.platform.srv.model.Product} interface instead.
	 */
	public static final String TABLE_NAME = "SPProduct";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spProductId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "countryId", Types.VARCHAR },
			{ "productCode", Types.VARCHAR },
			{ "productName", Types.VARCHAR },
			{ "productDesc", Types.VARCHAR },
			{ "productImageId", Types.BIGINT },
			{ "spCourseId", Types.BIGINT },
			{ "productBrochuresFolderId", Types.BIGINT },
			{ "productVideoFolderId", Types.BIGINT },
			{ "status", Types.INTEGER },
			{ "creditValues", Types.BIGINT },
			{ "PEProcessId", Types.BIGINT },
			{ "productTemplateName", Types.VARCHAR },
			{ "productTemplateLanguage", Types.VARCHAR },
			{ "registrationEnabled", Types.VARCHAR },
			{ "samePageRegistration", Types.VARCHAR },
			{ "productFormImageId", Types.BIGINT },
			{ "productFormName", Types.VARCHAR },
			{ "productFormButtonName", Types.VARCHAR },
			{ "productFormUrl", Types.VARCHAR },
			{ "productBannerImageId", Types.BIGINT },
			{ "hasInventory", Types.BOOLEAN },
			{ "bannerDetailsEnabled", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table SPProduct (spProductId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,countryId VARCHAR(75) null,productCode VARCHAR(75) null,productName VARCHAR(500) null,productDesc LONGTEXT null,productImageId BIGINT(20),spCourseId BIGINT(20),productBrochuresFolderId BIGINT(20),productVideoFolderId BIGINT(20),status INTEGER,creditValues BIGINT(20),PEProcessId BIGINT(20),productTemplateName VARCHAR(75) null,productTemplateLanguage VARCHAR(75) null,registrationEnabled VARCHAR(75) null,samePageRegistration VARCHAR(75) null,productFormImageId BIGINT(20),productFormName VARCHAR(75) null,productFormButtonName VARCHAR(75) null,productFormUrl VARCHAR(75) null,productBannerImageId BIGINT(20),hasInventory BOOLEAN,bannerDetailsEnabled VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table SPProduct";
	public static final String ORDER_BY_JPQL = " ORDER BY product.productName ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPProduct.productName ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.model.Product"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.model.Product"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.model.Product"),
			true);
	public static long COUNTRYID_COLUMN_BITMASK = 1L;
	public static long GROUPID_COLUMN_BITMASK = 2L;
	public static long PRODUCTNAME_COLUMN_BITMASK = 4L;
	public static long SPCOURSEID_COLUMN_BITMASK = 8L;
	public static long SPPRODUCTID_COLUMN_BITMASK = 16L;
	public static long STATUS_COLUMN_BITMASK = 32L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.model.Product"));

	public ProductModelImpl() {
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

	@Override
	public long getSpProductId() {
		return _spProductId;
	}

	@Override
	public void setSpProductId(long spProductId) {
		_columnBitmask |= SPPRODUCTID_COLUMN_BITMASK;

		if (!_setOriginalSpProductId) {
			_setOriginalSpProductId = true;

			_originalSpProductId = _spProductId;
		}

		_spProductId = spProductId;
	}

	public long getOriginalSpProductId() {
		return _originalSpProductId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_columnBitmask |= GROUPID_COLUMN_BITMASK;

		if (!_setOriginalGroupId) {
			_setOriginalGroupId = true;

			_originalGroupId = _groupId;
		}

		_groupId = groupId;
	}

	public long getOriginalGroupId() {
		return _originalGroupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getCountryId() {
		if (_countryId == null) {
			return StringPool.BLANK;
		}
		else {
			return _countryId;
		}
	}

	@Override
	public void setCountryId(String countryId) {
		_columnBitmask |= COUNTRYID_COLUMN_BITMASK;

		if (_originalCountryId == null) {
			_originalCountryId = _countryId;
		}

		_countryId = countryId;
	}

	public String getOriginalCountryId() {
		return GetterUtil.getString(_originalCountryId);
	}

	@Override
	public String getProductCode() {
		if (_productCode == null) {
			return StringPool.BLANK;
		}
		else {
			return _productCode;
		}
	}

	@Override
	public void setProductCode(String productCode) {
		_productCode = productCode;
	}

	@Override
	public String getProductName() {
		if (_productName == null) {
			return StringPool.BLANK;
		}
		else {
			return _productName;
		}
	}

	@Override
	public void setProductName(String productName) {
		_columnBitmask = -1L;

		if (_originalProductName == null) {
			_originalProductName = _productName;
		}

		_productName = productName;
	}

	public String getOriginalProductName() {
		return GetterUtil.getString(_originalProductName);
	}

	@Override
	public String getProductDesc() {
		if (_productDesc == null) {
			return StringPool.BLANK;
		}
		else {
			return _productDesc;
		}
	}

	@Override
	public void setProductDesc(String productDesc) {
		_productDesc = productDesc;
	}

	@Override
	public long getProductImageId() {
		return _productImageId;
	}

	@Override
	public void setProductImageId(long productImageId) {
		_productImageId = productImageId;
	}

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_columnBitmask |= SPCOURSEID_COLUMN_BITMASK;

		if (!_setOriginalSpCourseId) {
			_setOriginalSpCourseId = true;

			_originalSpCourseId = _spCourseId;
		}

		_spCourseId = spCourseId;
	}

	public long getOriginalSpCourseId() {
		return _originalSpCourseId;
	}

	@Override
	public long getProductBrochuresFolderId() {
		return _productBrochuresFolderId;
	}

	@Override
	public void setProductBrochuresFolderId(long productBrochuresFolderId) {
		_productBrochuresFolderId = productBrochuresFolderId;
	}

	@Override
	public long getProductVideoFolderId() {
		return _productVideoFolderId;
	}

	@Override
	public void setProductVideoFolderId(long productVideoFolderId) {
		_productVideoFolderId = productVideoFolderId;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_columnBitmask |= STATUS_COLUMN_BITMASK;

		if (!_setOriginalStatus) {
			_setOriginalStatus = true;

			_originalStatus = _status;
		}

		_status = status;
	}

	public int getOriginalStatus() {
		return _originalStatus;
	}

	@Override
	public long getCreditValues() {
		return _creditValues;
	}

	@Override
	public void setCreditValues(long creditValues) {
		_creditValues = creditValues;
	}

	@Override
	public long getPEProcessId() {
		return _PEProcessId;
	}

	@Override
	public void setPEProcessId(long PEProcessId) {
		_PEProcessId = PEProcessId;
	}

	@Override
	public String getProductTemplateName() {
		if (_productTemplateName == null) {
			return StringPool.BLANK;
		}
		else {
			return _productTemplateName;
		}
	}

	@Override
	public void setProductTemplateName(String productTemplateName) {
		_productTemplateName = productTemplateName;
	}

	@Override
	public String getProductTemplateLanguage() {
		if (_productTemplateLanguage == null) {
			return StringPool.BLANK;
		}
		else {
			return _productTemplateLanguage;
		}
	}

	@Override
	public void setProductTemplateLanguage(String productTemplateLanguage) {
		_productTemplateLanguage = productTemplateLanguage;
	}

	@Override
	public String getRegistrationEnabled() {
		if (_registrationEnabled == null) {
			return StringPool.BLANK;
		}
		else {
			return _registrationEnabled;
		}
	}

	@Override
	public void setRegistrationEnabled(String registrationEnabled) {
		_registrationEnabled = registrationEnabled;
	}

	@Override
	public String getSamePageRegistration() {
		if (_samePageRegistration == null) {
			return StringPool.BLANK;
		}
		else {
			return _samePageRegistration;
		}
	}

	@Override
	public void setSamePageRegistration(String samePageRegistration) {
		_samePageRegistration = samePageRegistration;
	}

	@Override
	public long getProductFormImageId() {
		return _productFormImageId;
	}

	@Override
	public void setProductFormImageId(long productFormImageId) {
		_productFormImageId = productFormImageId;
	}

	@Override
	public String getProductFormName() {
		if (_productFormName == null) {
			return StringPool.BLANK;
		}
		else {
			return _productFormName;
		}
	}

	@Override
	public void setProductFormName(String productFormName) {
		_productFormName = productFormName;
	}

	@Override
	public String getProductFormButtonName() {
		if (_productFormButtonName == null) {
			return StringPool.BLANK;
		}
		else {
			return _productFormButtonName;
		}
	}

	@Override
	public void setProductFormButtonName(String productFormButtonName) {
		_productFormButtonName = productFormButtonName;
	}

	@Override
	public String getProductFormUrl() {
		if (_productFormUrl == null) {
			return StringPool.BLANK;
		}
		else {
			return _productFormUrl;
		}
	}

	@Override
	public void setProductFormUrl(String productFormUrl) {
		_productFormUrl = productFormUrl;
	}

	@Override
	public long getProductBannerImageId() {
		return _productBannerImageId;
	}

	@Override
	public void setProductBannerImageId(long productBannerImageId) {
		_productBannerImageId = productBannerImageId;
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
	}

	@Override
	public String getBannerDetailsEnabled() {
		if (_bannerDetailsEnabled == null) {
			return StringPool.BLANK;
		}
		else {
			return _bannerDetailsEnabled;
		}
	}

	@Override
	public void setBannerDetailsEnabled(String bannerDetailsEnabled) {
		_bannerDetailsEnabled = bannerDetailsEnabled;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Product.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Product toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Product)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		ProductImpl productImpl = new ProductImpl();

		productImpl.setSpProductId(getSpProductId());
		productImpl.setGroupId(getGroupId());
		productImpl.setCompanyId(getCompanyId());
		productImpl.setUserId(getUserId());
		productImpl.setUserName(getUserName());
		productImpl.setCreateDate(getCreateDate());
		productImpl.setModifiedDate(getModifiedDate());
		productImpl.setCountryId(getCountryId());
		productImpl.setProductCode(getProductCode());
		productImpl.setProductName(getProductName());
		productImpl.setProductDesc(getProductDesc());
		productImpl.setProductImageId(getProductImageId());
		productImpl.setSpCourseId(getSpCourseId());
		productImpl.setProductBrochuresFolderId(getProductBrochuresFolderId());
		productImpl.setProductVideoFolderId(getProductVideoFolderId());
		productImpl.setStatus(getStatus());
		productImpl.setCreditValues(getCreditValues());
		productImpl.setPEProcessId(getPEProcessId());
		productImpl.setProductTemplateName(getProductTemplateName());
		productImpl.setProductTemplateLanguage(getProductTemplateLanguage());
		productImpl.setRegistrationEnabled(getRegistrationEnabled());
		productImpl.setSamePageRegistration(getSamePageRegistration());
		productImpl.setProductFormImageId(getProductFormImageId());
		productImpl.setProductFormName(getProductFormName());
		productImpl.setProductFormButtonName(getProductFormButtonName());
		productImpl.setProductFormUrl(getProductFormUrl());
		productImpl.setProductBannerImageId(getProductBannerImageId());
		productImpl.setHasInventory(getHasInventory());
		productImpl.setBannerDetailsEnabled(getBannerDetailsEnabled());

		productImpl.resetOriginalValues();

		return productImpl;
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

		if (!(obj instanceof Product)) {
			return false;
		}

		Product product = (Product)obj;

		long primaryKey = product.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		ProductModelImpl productModelImpl = this;

		productModelImpl._originalSpProductId = productModelImpl._spProductId;

		productModelImpl._setOriginalSpProductId = false;

		productModelImpl._originalGroupId = productModelImpl._groupId;

		productModelImpl._setOriginalGroupId = false;

		productModelImpl._originalCountryId = productModelImpl._countryId;

		productModelImpl._originalProductName = productModelImpl._productName;

		productModelImpl._originalSpCourseId = productModelImpl._spCourseId;

		productModelImpl._setOriginalSpCourseId = false;

		productModelImpl._originalStatus = productModelImpl._status;

		productModelImpl._setOriginalStatus = false;

		productModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Product> toCacheModel() {
		ProductCacheModel productCacheModel = new ProductCacheModel();

		productCacheModel.spProductId = getSpProductId();

		productCacheModel.groupId = getGroupId();

		productCacheModel.companyId = getCompanyId();

		productCacheModel.userId = getUserId();

		productCacheModel.userName = getUserName();

		String userName = productCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			productCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			productCacheModel.createDate = createDate.getTime();
		}
		else {
			productCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			productCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			productCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		productCacheModel.countryId = getCountryId();

		String countryId = productCacheModel.countryId;

		if ((countryId != null) && (countryId.length() == 0)) {
			productCacheModel.countryId = null;
		}

		productCacheModel.productCode = getProductCode();

		String productCode = productCacheModel.productCode;

		if ((productCode != null) && (productCode.length() == 0)) {
			productCacheModel.productCode = null;
		}

		productCacheModel.productName = getProductName();

		String productName = productCacheModel.productName;

		if ((productName != null) && (productName.length() == 0)) {
			productCacheModel.productName = null;
		}

		productCacheModel.productDesc = getProductDesc();

		String productDesc = productCacheModel.productDesc;

		if ((productDesc != null) && (productDesc.length() == 0)) {
			productCacheModel.productDesc = null;
		}

		productCacheModel.productImageId = getProductImageId();

		productCacheModel.spCourseId = getSpCourseId();

		productCacheModel.productBrochuresFolderId = getProductBrochuresFolderId();

		productCacheModel.productVideoFolderId = getProductVideoFolderId();

		productCacheModel.status = getStatus();

		productCacheModel.creditValues = getCreditValues();

		productCacheModel.PEProcessId = getPEProcessId();

		productCacheModel.productTemplateName = getProductTemplateName();

		String productTemplateName = productCacheModel.productTemplateName;

		if ((productTemplateName != null) &&
				(productTemplateName.length() == 0)) {
			productCacheModel.productTemplateName = null;
		}

		productCacheModel.productTemplateLanguage = getProductTemplateLanguage();

		String productTemplateLanguage = productCacheModel.productTemplateLanguage;

		if ((productTemplateLanguage != null) &&
				(productTemplateLanguage.length() == 0)) {
			productCacheModel.productTemplateLanguage = null;
		}

		productCacheModel.registrationEnabled = getRegistrationEnabled();

		String registrationEnabled = productCacheModel.registrationEnabled;

		if ((registrationEnabled != null) &&
				(registrationEnabled.length() == 0)) {
			productCacheModel.registrationEnabled = null;
		}

		productCacheModel.samePageRegistration = getSamePageRegistration();

		String samePageRegistration = productCacheModel.samePageRegistration;

		if ((samePageRegistration != null) &&
				(samePageRegistration.length() == 0)) {
			productCacheModel.samePageRegistration = null;
		}

		productCacheModel.productFormImageId = getProductFormImageId();

		productCacheModel.productFormName = getProductFormName();

		String productFormName = productCacheModel.productFormName;

		if ((productFormName != null) && (productFormName.length() == 0)) {
			productCacheModel.productFormName = null;
		}

		productCacheModel.productFormButtonName = getProductFormButtonName();

		String productFormButtonName = productCacheModel.productFormButtonName;

		if ((productFormButtonName != null) &&
				(productFormButtonName.length() == 0)) {
			productCacheModel.productFormButtonName = null;
		}

		productCacheModel.productFormUrl = getProductFormUrl();

		String productFormUrl = productCacheModel.productFormUrl;

		if ((productFormUrl != null) && (productFormUrl.length() == 0)) {
			productCacheModel.productFormUrl = null;
		}

		productCacheModel.productBannerImageId = getProductBannerImageId();

		productCacheModel.hasInventory = getHasInventory();

		productCacheModel.bannerDetailsEnabled = getBannerDetailsEnabled();

		String bannerDetailsEnabled = productCacheModel.bannerDetailsEnabled;

		if ((bannerDetailsEnabled != null) &&
				(bannerDetailsEnabled.length() == 0)) {
			productCacheModel.bannerDetailsEnabled = null;
		}

		return productCacheModel;
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

	private static ClassLoader _classLoader = Product.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Product.class
		};
	private long _spProductId;
	private long _originalSpProductId;
	private boolean _setOriginalSpProductId;
	private long _groupId;
	private long _originalGroupId;
	private boolean _setOriginalGroupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _countryId;
	private String _originalCountryId;
	private String _productCode;
	private String _productName;
	private String _originalProductName;
	private String _productDesc;
	private long _productImageId;
	private long _spCourseId;
	private long _originalSpCourseId;
	private boolean _setOriginalSpCourseId;
	private long _productBrochuresFolderId;
	private long _productVideoFolderId;
	private int _status;
	private int _originalStatus;
	private boolean _setOriginalStatus;
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
	private long _columnBitmask;
	private Product _escapedModel;
}