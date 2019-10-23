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

package com.sambaash.platform.srv.spshopping.model.impl;

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

import com.sambaash.platform.srv.spshopping.model.SPCartPackage;
import com.sambaash.platform.srv.spshopping.model.SPCartPackageModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SPCartPackage service. Represents a row in the &quot;SPCartPackage&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.spshopping.model.SPCartPackageModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SPCartPackageImpl}.
 * </p>
 *
 * @author pradeep
 * @see SPCartPackageImpl
 * @see com.sambaash.platform.srv.spshopping.model.SPCartPackage
 * @see com.sambaash.platform.srv.spshopping.model.SPCartPackageModel
 * @generated
 */
public class SPCartPackageModelImpl extends BaseModelImpl<SPCartPackage>
	implements SPCartPackageModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s p cart package model instance should use the {@link com.sambaash.platform.srv.spshopping.model.SPCartPackage} interface instead.
	 */
	public static final String TABLE_NAME = "SPCartPackage";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spCartPackageId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "cartId", Types.BIGINT },
			{ "packageId", Types.BIGINT },
			{ "selectedCurrency", Types.VARCHAR },
			{ "usedDiscountRefId", Types.BIGINT },
			{ "usedDiscountRefPCId", Types.BIGINT },
			{ "discount", Types.VARCHAR },
			{ "initialPrice", Types.VARCHAR },
			{ "totalPrice", Types.VARCHAR },
			{ "remarks", Types.VARCHAR },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP }
		};
	public static final String TABLE_SQL_CREATE = "create table SPCartPackage (spCartPackageId BIGINT(20) not null primary key,groupId BIGINT(20),cartId BIGINT(20),packageId BIGINT(20),selectedCurrency VARCHAR(75) null,usedDiscountRefId BIGINT(20),usedDiscountRefPCId BIGINT(20),discount VARCHAR(75) null,initialPrice VARCHAR(75) null,totalPrice VARCHAR(75) null,remarks VARCHAR(75) null,companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null)";
	public static final String TABLE_SQL_DROP = "drop table SPCartPackage";
	public static final String ORDER_BY_JPQL = " ORDER BY spCartPackage.spCartPackageId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPCartPackage.spCartPackageId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.spshopping.model.SPCartPackage"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.spshopping.model.SPCartPackage"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.spshopping.model.SPCartPackage"),
			true);
	public static long CARTID_COLUMN_BITMASK = 1L;
	public static long PACKAGEID_COLUMN_BITMASK = 2L;
	public static long SPCARTPACKAGEID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.spshopping.model.SPCartPackage"));

	public SPCartPackageModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spCartPackageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCartPackageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCartPackageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return SPCartPackage.class;
	}

	@Override
	public String getModelClassName() {
		return SPCartPackage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCartPackageId", getSpCartPackageId());
		attributes.put("groupId", getGroupId());
		attributes.put("cartId", getCartId());
		attributes.put("packageId", getPackageId());
		attributes.put("selectedCurrency", getSelectedCurrency());
		attributes.put("usedDiscountRefId", getUsedDiscountRefId());
		attributes.put("usedDiscountRefPCId", getUsedDiscountRefPCId());
		attributes.put("discount", getDiscount());
		attributes.put("initialPrice", getInitialPrice());
		attributes.put("totalPrice", getTotalPrice());
		attributes.put("remarks", getRemarks());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCartPackageId = (Long)attributes.get("spCartPackageId");

		if (spCartPackageId != null) {
			setSpCartPackageId(spCartPackageId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		Long packageId = (Long)attributes.get("packageId");

		if (packageId != null) {
			setPackageId(packageId);
		}

		String selectedCurrency = (String)attributes.get("selectedCurrency");

		if (selectedCurrency != null) {
			setSelectedCurrency(selectedCurrency);
		}

		Long usedDiscountRefId = (Long)attributes.get("usedDiscountRefId");

		if (usedDiscountRefId != null) {
			setUsedDiscountRefId(usedDiscountRefId);
		}

		Long usedDiscountRefPCId = (Long)attributes.get("usedDiscountRefPCId");

		if (usedDiscountRefPCId != null) {
			setUsedDiscountRefPCId(usedDiscountRefPCId);
		}

		String discount = (String)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		String initialPrice = (String)attributes.get("initialPrice");

		if (initialPrice != null) {
			setInitialPrice(initialPrice);
		}

		String totalPrice = (String)attributes.get("totalPrice");

		if (totalPrice != null) {
			setTotalPrice(totalPrice);
		}

		String remarks = (String)attributes.get("remarks");

		if (remarks != null) {
			setRemarks(remarks);
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
	}

	@Override
	public long getSpCartPackageId() {
		return _spCartPackageId;
	}

	@Override
	public void setSpCartPackageId(long spCartPackageId) {
		_spCartPackageId = spCartPackageId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCartId() {
		return _cartId;
	}

	@Override
	public void setCartId(long cartId) {
		_columnBitmask |= CARTID_COLUMN_BITMASK;

		if (!_setOriginalCartId) {
			_setOriginalCartId = true;

			_originalCartId = _cartId;
		}

		_cartId = cartId;
	}

	public long getOriginalCartId() {
		return _originalCartId;
	}

	@Override
	public long getPackageId() {
		return _packageId;
	}

	@Override
	public void setPackageId(long packageId) {
		_columnBitmask |= PACKAGEID_COLUMN_BITMASK;

		if (!_setOriginalPackageId) {
			_setOriginalPackageId = true;

			_originalPackageId = _packageId;
		}

		_packageId = packageId;
	}

	public long getOriginalPackageId() {
		return _originalPackageId;
	}

	@Override
	public String getSelectedCurrency() {
		if (_selectedCurrency == null) {
			return StringPool.BLANK;
		}
		else {
			return _selectedCurrency;
		}
	}

	@Override
	public void setSelectedCurrency(String selectedCurrency) {
		_selectedCurrency = selectedCurrency;
	}

	@Override
	public long getUsedDiscountRefId() {
		return _usedDiscountRefId;
	}

	@Override
	public void setUsedDiscountRefId(long usedDiscountRefId) {
		_usedDiscountRefId = usedDiscountRefId;
	}

	@Override
	public long getUsedDiscountRefPCId() {
		return _usedDiscountRefPCId;
	}

	@Override
	public void setUsedDiscountRefPCId(long usedDiscountRefPCId) {
		_usedDiscountRefPCId = usedDiscountRefPCId;
	}

	@Override
	public String getDiscount() {
		if (_discount == null) {
			return StringPool.BLANK;
		}
		else {
			return _discount;
		}
	}

	@Override
	public void setDiscount(String discount) {
		_discount = discount;
	}

	@Override
	public String getInitialPrice() {
		if (_initialPrice == null) {
			return StringPool.BLANK;
		}
		else {
			return _initialPrice;
		}
	}

	@Override
	public void setInitialPrice(String initialPrice) {
		_initialPrice = initialPrice;
	}

	@Override
	public String getTotalPrice() {
		if (_totalPrice == null) {
			return StringPool.BLANK;
		}
		else {
			return _totalPrice;
		}
	}

	@Override
	public void setTotalPrice(String totalPrice) {
		_totalPrice = totalPrice;
	}

	@Override
	public String getRemarks() {
		if (_remarks == null) {
			return StringPool.BLANK;
		}
		else {
			return _remarks;
		}
	}

	@Override
	public void setRemarks(String remarks) {
		_remarks = remarks;
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

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			SPCartPackage.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SPCartPackage toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SPCartPackage)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SPCartPackageImpl spCartPackageImpl = new SPCartPackageImpl();

		spCartPackageImpl.setSpCartPackageId(getSpCartPackageId());
		spCartPackageImpl.setGroupId(getGroupId());
		spCartPackageImpl.setCartId(getCartId());
		spCartPackageImpl.setPackageId(getPackageId());
		spCartPackageImpl.setSelectedCurrency(getSelectedCurrency());
		spCartPackageImpl.setUsedDiscountRefId(getUsedDiscountRefId());
		spCartPackageImpl.setUsedDiscountRefPCId(getUsedDiscountRefPCId());
		spCartPackageImpl.setDiscount(getDiscount());
		spCartPackageImpl.setInitialPrice(getInitialPrice());
		spCartPackageImpl.setTotalPrice(getTotalPrice());
		spCartPackageImpl.setRemarks(getRemarks());
		spCartPackageImpl.setCompanyId(getCompanyId());
		spCartPackageImpl.setUserId(getUserId());
		spCartPackageImpl.setUserName(getUserName());
		spCartPackageImpl.setCreateDate(getCreateDate());
		spCartPackageImpl.setModifiedDate(getModifiedDate());

		spCartPackageImpl.resetOriginalValues();

		return spCartPackageImpl;
	}

	@Override
	public int compareTo(SPCartPackage spCartPackage) {
		long primaryKey = spCartPackage.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPCartPackage)) {
			return false;
		}

		SPCartPackage spCartPackage = (SPCartPackage)obj;

		long primaryKey = spCartPackage.getPrimaryKey();

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
		SPCartPackageModelImpl spCartPackageModelImpl = this;

		spCartPackageModelImpl._originalCartId = spCartPackageModelImpl._cartId;

		spCartPackageModelImpl._setOriginalCartId = false;

		spCartPackageModelImpl._originalPackageId = spCartPackageModelImpl._packageId;

		spCartPackageModelImpl._setOriginalPackageId = false;

		spCartPackageModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SPCartPackage> toCacheModel() {
		SPCartPackageCacheModel spCartPackageCacheModel = new SPCartPackageCacheModel();

		spCartPackageCacheModel.spCartPackageId = getSpCartPackageId();

		spCartPackageCacheModel.groupId = getGroupId();

		spCartPackageCacheModel.cartId = getCartId();

		spCartPackageCacheModel.packageId = getPackageId();

		spCartPackageCacheModel.selectedCurrency = getSelectedCurrency();

		String selectedCurrency = spCartPackageCacheModel.selectedCurrency;

		if ((selectedCurrency != null) && (selectedCurrency.length() == 0)) {
			spCartPackageCacheModel.selectedCurrency = null;
		}

		spCartPackageCacheModel.usedDiscountRefId = getUsedDiscountRefId();

		spCartPackageCacheModel.usedDiscountRefPCId = getUsedDiscountRefPCId();

		spCartPackageCacheModel.discount = getDiscount();

		String discount = spCartPackageCacheModel.discount;

		if ((discount != null) && (discount.length() == 0)) {
			spCartPackageCacheModel.discount = null;
		}

		spCartPackageCacheModel.initialPrice = getInitialPrice();

		String initialPrice = spCartPackageCacheModel.initialPrice;

		if ((initialPrice != null) && (initialPrice.length() == 0)) {
			spCartPackageCacheModel.initialPrice = null;
		}

		spCartPackageCacheModel.totalPrice = getTotalPrice();

		String totalPrice = spCartPackageCacheModel.totalPrice;

		if ((totalPrice != null) && (totalPrice.length() == 0)) {
			spCartPackageCacheModel.totalPrice = null;
		}

		spCartPackageCacheModel.remarks = getRemarks();

		String remarks = spCartPackageCacheModel.remarks;

		if ((remarks != null) && (remarks.length() == 0)) {
			spCartPackageCacheModel.remarks = null;
		}

		spCartPackageCacheModel.companyId = getCompanyId();

		spCartPackageCacheModel.userId = getUserId();

		spCartPackageCacheModel.userName = getUserName();

		String userName = spCartPackageCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			spCartPackageCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			spCartPackageCacheModel.createDate = createDate.getTime();
		}
		else {
			spCartPackageCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			spCartPackageCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			spCartPackageCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		return spCartPackageCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{spCartPackageId=");
		sb.append(getSpCartPackageId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", cartId=");
		sb.append(getCartId());
		sb.append(", packageId=");
		sb.append(getPackageId());
		sb.append(", selectedCurrency=");
		sb.append(getSelectedCurrency());
		sb.append(", usedDiscountRefId=");
		sb.append(getUsedDiscountRefId());
		sb.append(", usedDiscountRefPCId=");
		sb.append(getUsedDiscountRefPCId());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", initialPrice=");
		sb.append(getInitialPrice());
		sb.append(", totalPrice=");
		sb.append(getTotalPrice());
		sb.append(", remarks=");
		sb.append(getRemarks());
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spshopping.model.SPCartPackage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCartPackageId</column-name><column-value><![CDATA[");
		sb.append(getSpCartPackageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>cartId</column-name><column-value><![CDATA[");
		sb.append(getCartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>packageId</column-name><column-value><![CDATA[");
		sb.append(getPackageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>selectedCurrency</column-name><column-value><![CDATA[");
		sb.append(getSelectedCurrency());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usedDiscountRefId</column-name><column-value><![CDATA[");
		sb.append(getUsedDiscountRefId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>usedDiscountRefPCId</column-name><column-value><![CDATA[");
		sb.append(getUsedDiscountRefPCId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>initialPrice</column-name><column-value><![CDATA[");
		sb.append(getInitialPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalPrice</column-name><column-value><![CDATA[");
		sb.append(getTotalPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>remarks</column-name><column-value><![CDATA[");
		sb.append(getRemarks());
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

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = SPCartPackage.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SPCartPackage.class
		};
	private long _spCartPackageId;
	private long _groupId;
	private long _cartId;
	private long _originalCartId;
	private boolean _setOriginalCartId;
	private long _packageId;
	private long _originalPackageId;
	private boolean _setOriginalPackageId;
	private String _selectedCurrency;
	private long _usedDiscountRefId;
	private long _usedDiscountRefPCId;
	private String _discount;
	private String _initialPrice;
	private String _totalPrice;
	private String _remarks;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _columnBitmask;
	private SPCartPackage _escapedModel;
}