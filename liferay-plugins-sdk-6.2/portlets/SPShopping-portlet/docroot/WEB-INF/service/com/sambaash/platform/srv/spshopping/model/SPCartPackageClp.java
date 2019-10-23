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
import com.sambaash.platform.srv.spshopping.service.SPCartPackageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPCartPackageClp extends BaseModelImpl<SPCartPackage>
	implements SPCartPackage {
	public SPCartPackageClp() {
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

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCartPackageId", long.class);

				method.invoke(_spCartPackageRemoteModel, spCartPackageId);
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

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spCartPackageRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCartId() {
		return _cartId;
	}

	@Override
	public void setCartId(long cartId) {
		_cartId = cartId;

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCartId", long.class);

				method.invoke(_spCartPackageRemoteModel, cartId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPackageId() {
		return _packageId;
	}

	@Override
	public void setPackageId(long packageId) {
		_packageId = packageId;

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setPackageId", long.class);

				method.invoke(_spCartPackageRemoteModel, packageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSelectedCurrency() {
		return _selectedCurrency;
	}

	@Override
	public void setSelectedCurrency(String selectedCurrency) {
		_selectedCurrency = selectedCurrency;

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setSelectedCurrency",
						String.class);

				method.invoke(_spCartPackageRemoteModel, selectedCurrency);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUsedDiscountRefId() {
		return _usedDiscountRefId;
	}

	@Override
	public void setUsedDiscountRefId(long usedDiscountRefId) {
		_usedDiscountRefId = usedDiscountRefId;

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setUsedDiscountRefId",
						long.class);

				method.invoke(_spCartPackageRemoteModel, usedDiscountRefId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUsedDiscountRefPCId() {
		return _usedDiscountRefPCId;
	}

	@Override
	public void setUsedDiscountRefPCId(long usedDiscountRefPCId) {
		_usedDiscountRefPCId = usedDiscountRefPCId;

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setUsedDiscountRefPCId",
						long.class);

				method.invoke(_spCartPackageRemoteModel, usedDiscountRefPCId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDiscount() {
		return _discount;
	}

	@Override
	public void setDiscount(String discount) {
		_discount = discount;

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", String.class);

				method.invoke(_spCartPackageRemoteModel, discount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInitialPrice() {
		return _initialPrice;
	}

	@Override
	public void setInitialPrice(String initialPrice) {
		_initialPrice = initialPrice;

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setInitialPrice", String.class);

				method.invoke(_spCartPackageRemoteModel, initialPrice);
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

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalPrice", String.class);

				method.invoke(_spCartPackageRemoteModel, totalPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRemarks() {
		return _remarks;
	}

	@Override
	public void setRemarks(String remarks) {
		_remarks = remarks;

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setRemarks", String.class);

				method.invoke(_spCartPackageRemoteModel, remarks);
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

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spCartPackageRemoteModel, companyId);
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

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spCartPackageRemoteModel, userId);
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

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spCartPackageRemoteModel, userName);
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

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spCartPackageRemoteModel, createDate);
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

		if (_spCartPackageRemoteModel != null) {
			try {
				Class<?> clazz = _spCartPackageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spCartPackageRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setDiscountAmount(java.math.BigDecimal discount) {
		try {
			String methodName = "setDiscountAmount";

			Class<?>[] parameterTypes = new Class<?>[] {
					java.math.BigDecimal.class
				};

			Object[] parameterValues = new Object[] { discount };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.math.BigDecimal getDiscountAmount() {
		try {
			String methodName = "getDiscountAmount";

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
	public java.math.BigDecimal getInitialPriceAmount() {
		try {
			String methodName = "getInitialPriceAmount";

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
	public void setInitialPriceAmount(java.math.BigDecimal initialPriceAmount) {
		try {
			String methodName = "setInitialPriceAmount";

			Class<?>[] parameterTypes = new Class<?>[] {
					java.math.BigDecimal.class
				};

			Object[] parameterValues = new Object[] { initialPriceAmount };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
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

	public BaseModel<?> getSPCartPackageRemoteModel() {
		return _spCartPackageRemoteModel;
	}

	public void setSPCartPackageRemoteModel(
		BaseModel<?> spCartPackageRemoteModel) {
		_spCartPackageRemoteModel = spCartPackageRemoteModel;
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

		Class<?> remoteModelClass = _spCartPackageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spCartPackageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPCartPackageLocalServiceUtil.addSPCartPackage(this);
		}
		else {
			SPCartPackageLocalServiceUtil.updateSPCartPackage(this);
		}
	}

	@Override
	public SPCartPackage toEscapedModel() {
		return (SPCartPackage)ProxyUtil.newProxyInstance(SPCartPackage.class.getClassLoader(),
			new Class[] { SPCartPackage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPCartPackageClp clone = new SPCartPackageClp();

		clone.setSpCartPackageId(getSpCartPackageId());
		clone.setGroupId(getGroupId());
		clone.setCartId(getCartId());
		clone.setPackageId(getPackageId());
		clone.setSelectedCurrency(getSelectedCurrency());
		clone.setUsedDiscountRefId(getUsedDiscountRefId());
		clone.setUsedDiscountRefPCId(getUsedDiscountRefPCId());
		clone.setDiscount(getDiscount());
		clone.setInitialPrice(getInitialPrice());
		clone.setTotalPrice(getTotalPrice());
		clone.setRemarks(getRemarks());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
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

		if (!(obj instanceof SPCartPackageClp)) {
			return false;
		}

		SPCartPackageClp spCartPackage = (SPCartPackageClp)obj;

		long primaryKey = spCartPackage.getPrimaryKey();

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
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spCartPackageRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spshopping.service.ClpSerializer.class;
}