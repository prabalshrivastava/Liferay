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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spshopping.service.ClpSerializer;
import com.sambaash.platform.srv.spshopping.service.SPSellingPriceLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPSellingPriceClp extends BaseModelImpl<SPSellingPrice>
	implements SPSellingPrice {
	public SPSellingPriceClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPSellingPrice.class;
	}

	@Override
	public String getModelClassName() {
		return SPSellingPrice.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spSellingPriceId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpSellingPriceId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spSellingPriceId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spSellingPriceId", getSpSellingPriceId());
		attributes.put("groupId", getGroupId());
		attributes.put("priceRefId", getPriceRefId());
		attributes.put("priceRefTypeId", getPriceRefTypeId());
		attributes.put("currencyCode", getCurrencyCode());
		attributes.put("basePrice", getBasePrice());
		attributes.put("taxName", getTaxName());
		attributes.put("taxValue", getTaxValue());
		attributes.put("totalPrice", getTotalPrice());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spSellingPriceId = (Long)attributes.get("spSellingPriceId");

		if (spSellingPriceId != null) {
			setSpSellingPriceId(spSellingPriceId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long priceRefId = (Long)attributes.get("priceRefId");

		if (priceRefId != null) {
			setPriceRefId(priceRefId);
		}

		Long priceRefTypeId = (Long)attributes.get("priceRefTypeId");

		if (priceRefTypeId != null) {
			setPriceRefTypeId(priceRefTypeId);
		}

		String currencyCode = (String)attributes.get("currencyCode");

		if (currencyCode != null) {
			setCurrencyCode(currencyCode);
		}

		String basePrice = (String)attributes.get("basePrice");

		if (basePrice != null) {
			setBasePrice(basePrice);
		}

		String taxName = (String)attributes.get("taxName");

		if (taxName != null) {
			setTaxName(taxName);
		}

		String taxValue = (String)attributes.get("taxValue");

		if (taxValue != null) {
			setTaxValue(taxValue);
		}

		String totalPrice = (String)attributes.get("totalPrice");

		if (totalPrice != null) {
			setTotalPrice(totalPrice);
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
	public long getSpSellingPriceId() {
		return _spSellingPriceId;
	}

	@Override
	public void setSpSellingPriceId(long spSellingPriceId) {
		_spSellingPriceId = spSellingPriceId;

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setSpSellingPriceId",
						long.class);

				method.invoke(_spSellingPriceRemoteModel, spSellingPriceId);
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

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spSellingPriceRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPriceRefId() {
		return _priceRefId;
	}

	@Override
	public void setPriceRefId(long priceRefId) {
		_priceRefId = priceRefId;

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setPriceRefId", long.class);

				method.invoke(_spSellingPriceRemoteModel, priceRefId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPriceRefTypeId() {
		return _priceRefTypeId;
	}

	@Override
	public void setPriceRefTypeId(long priceRefTypeId) {
		_priceRefTypeId = priceRefTypeId;

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setPriceRefTypeId", long.class);

				method.invoke(_spSellingPriceRemoteModel, priceRefTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrencyCode() {
		return _currencyCode;
	}

	@Override
	public void setCurrencyCode(String currencyCode) {
		_currencyCode = currencyCode;

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrencyCode", String.class);

				method.invoke(_spSellingPriceRemoteModel, currencyCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBasePrice() {
		return _basePrice;
	}

	@Override
	public void setBasePrice(String basePrice) {
		_basePrice = basePrice;

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setBasePrice", String.class);

				method.invoke(_spSellingPriceRemoteModel, basePrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTaxName() {
		return _taxName;
	}

	@Override
	public void setTaxName(String taxName) {
		_taxName = taxName;

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxName", String.class);

				method.invoke(_spSellingPriceRemoteModel, taxName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTaxValue() {
		return _taxValue;
	}

	@Override
	public void setTaxValue(String taxValue) {
		_taxValue = taxValue;

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxValue", String.class);

				method.invoke(_spSellingPriceRemoteModel, taxValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTotalPrice() {
		return _totalPrice;
	}

	@Override
	public void setTotalPrice(String totalPrice) {
		_totalPrice = totalPrice;

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalPrice", String.class);

				method.invoke(_spSellingPriceRemoteModel, totalPrice);
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

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spSellingPriceRemoteModel, companyId);
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

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spSellingPriceRemoteModel, userId);
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

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spSellingPriceRemoteModel, userName);
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

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spSellingPriceRemoteModel, createDate);
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

		if (_spSellingPriceRemoteModel != null) {
			try {
				Class<?> clazz = _spSellingPriceRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spSellingPriceRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setTotalPriceAmount(java.math.BigDecimal totalPriceAmount) {
		try {
			String methodName = "setTotalPriceAmount";

			Class<?>[] parameterTypes = new Class<?>[] {
					java.math.BigDecimal.class
				};

			Object[] parameterValues = new Object[] { totalPriceAmount };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.math.BigDecimal getBasePriceAmount() {
		try {
			String methodName = "getBasePriceAmount";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.math.BigDecimal returnObj = (java.math.BigDecimal)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.math.BigDecimal getTotalPriceAmount() {
		try {
			String methodName = "getTotalPriceAmount";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.math.BigDecimal returnObj = (java.math.BigDecimal)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setTaxValueAmount(java.lang.String taxValueAmount) {
		try {
			String methodName = "setTaxValueAmount";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { taxValueAmount };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.math.BigDecimal getTaxValueAmount() {
		try {
			String methodName = "getTaxValueAmount";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.math.BigDecimal returnObj = (java.math.BigDecimal)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setBasePriceAmount(java.math.BigDecimal basePriceAmount) {
		try {
			String methodName = "setBasePriceAmount";

			Class<?>[] parameterTypes = new Class<?>[] {
					java.math.BigDecimal.class
				};

			Object[] parameterValues = new Object[] { basePriceAmount };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getSPSellingPriceRemoteModel() {
		return _spSellingPriceRemoteModel;
	}

	public void setSPSellingPriceRemoteModel(
		BaseModel<?> spSellingPriceRemoteModel) {
		_spSellingPriceRemoteModel = spSellingPriceRemoteModel;
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

		Class<?> remoteModelClass = _spSellingPriceRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spSellingPriceRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPSellingPriceLocalServiceUtil.addSPSellingPrice(this);
		}
		else {
			SPSellingPriceLocalServiceUtil.updateSPSellingPrice(this);
		}
	}

	@Override
	public SPSellingPrice toEscapedModel() {
		return (SPSellingPrice)ProxyUtil.newProxyInstance(SPSellingPrice.class.getClassLoader(),
			new Class[] { SPSellingPrice.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPSellingPriceClp clone = new SPSellingPriceClp();

		clone.setSpSellingPriceId(getSpSellingPriceId());
		clone.setGroupId(getGroupId());
		clone.setPriceRefId(getPriceRefId());
		clone.setPriceRefTypeId(getPriceRefTypeId());
		clone.setCurrencyCode(getCurrencyCode());
		clone.setBasePrice(getBasePrice());
		clone.setTaxName(getTaxName());
		clone.setTaxValue(getTaxValue());
		clone.setTotalPrice(getTotalPrice());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPSellingPrice spSellingPrice) {
		long primaryKey = spSellingPrice.getPrimaryKey();

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

		if (!(obj instanceof SPSellingPriceClp)) {
			return false;
		}

		SPSellingPriceClp spSellingPrice = (SPSellingPriceClp)obj;

		long primaryKey = spSellingPrice.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{spSellingPriceId=");
		sb.append(getSpSellingPriceId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", priceRefId=");
		sb.append(getPriceRefId());
		sb.append(", priceRefTypeId=");
		sb.append(getPriceRefTypeId());
		sb.append(", currencyCode=");
		sb.append(getCurrencyCode());
		sb.append(", basePrice=");
		sb.append(getBasePrice());
		sb.append(", taxName=");
		sb.append(getTaxName());
		sb.append(", taxValue=");
		sb.append(getTaxValue());
		sb.append(", totalPrice=");
		sb.append(getTotalPrice());
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
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spshopping.model.SPSellingPrice");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spSellingPriceId</column-name><column-value><![CDATA[");
		sb.append(getSpSellingPriceId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priceRefId</column-name><column-value><![CDATA[");
		sb.append(getPriceRefId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>priceRefTypeId</column-name><column-value><![CDATA[");
		sb.append(getPriceRefTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currencyCode</column-name><column-value><![CDATA[");
		sb.append(getCurrencyCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>basePrice</column-name><column-value><![CDATA[");
		sb.append(getBasePrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxName</column-name><column-value><![CDATA[");
		sb.append(getTaxName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxValue</column-name><column-value><![CDATA[");
		sb.append(getTaxValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalPrice</column-name><column-value><![CDATA[");
		sb.append(getTotalPrice());
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
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spSellingPriceRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spshopping.service.ClpSerializer.class;
}