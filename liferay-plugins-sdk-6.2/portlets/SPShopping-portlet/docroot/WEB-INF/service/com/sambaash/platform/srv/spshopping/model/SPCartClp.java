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
import com.sambaash.platform.srv.spshopping.service.SPCartLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPCartClp extends BaseModelImpl<SPCart> implements SPCart {
	public SPCartClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPCart.class;
	}

	@Override
	public String getModelClassName() {
		return SPCart.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCartId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCartId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCartId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCartId", getSpCartId());
		attributes.put("groupId", getGroupId());
		attributes.put("discount", getDiscount());
		attributes.put("totalPrice", getTotalPrice());
		attributes.put("userRemarks", getUserRemarks());
		attributes.put("status", getStatus());
		attributes.put("transactionDetails", getTransactionDetails());
		attributes.put("orderPage", getOrderPage());
		attributes.put("rsvpDetailId", getRsvpDetailId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCartId = (Long)attributes.get("spCartId");

		if (spCartId != null) {
			setSpCartId(spCartId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String discount = (String)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		String totalPrice = (String)attributes.get("totalPrice");

		if (totalPrice != null) {
			setTotalPrice(totalPrice);
		}

		String userRemarks = (String)attributes.get("userRemarks");

		if (userRemarks != null) {
			setUserRemarks(userRemarks);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String transactionDetails = (String)attributes.get("transactionDetails");

		if (transactionDetails != null) {
			setTransactionDetails(transactionDetails);
		}

		String orderPage = (String)attributes.get("orderPage");

		if (orderPage != null) {
			setOrderPage(orderPage);
		}

		Long rsvpDetailId = (Long)attributes.get("rsvpDetailId");

		if (rsvpDetailId != null) {
			setRsvpDetailId(rsvpDetailId);
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
	public long getSpCartId() {
		return _spCartId;
	}

	@Override
	public void setSpCartId(long spCartId) {
		_spCartId = spCartId;

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCartId", long.class);

				method.invoke(_spCartRemoteModel, spCartId);
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

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spCartRemoteModel, groupId);
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

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setDiscount", String.class);

				method.invoke(_spCartRemoteModel, discount);
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

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalPrice", String.class);

				method.invoke(_spCartRemoteModel, totalPrice);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserRemarks() {
		return _userRemarks;
	}

	@Override
	public void setUserRemarks(String userRemarks) {
		_userRemarks = userRemarks;

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setUserRemarks", String.class);

				method.invoke(_spCartRemoteModel, userRemarks);
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

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_spCartRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTransactionDetails() {
		return _transactionDetails;
	}

	@Override
	public void setTransactionDetails(String transactionDetails) {
		_transactionDetails = transactionDetails;

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setTransactionDetails",
						String.class);

				method.invoke(_spCartRemoteModel, transactionDetails);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOrderPage() {
		return _orderPage;
	}

	@Override
	public void setOrderPage(String orderPage) {
		_orderPage = orderPage;

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderPage", String.class);

				method.invoke(_spCartRemoteModel, orderPage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpDetailId() {
		return _rsvpDetailId;
	}

	@Override
	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpDetailId = rsvpDetailId;

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpDetailId", long.class);

				method.invoke(_spCartRemoteModel, rsvpDetailId);
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

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spCartRemoteModel, companyId);
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

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spCartRemoteModel, userId);
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

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spCartRemoteModel, userName);
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

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spCartRemoteModel, createDate);
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

		if (_spCartRemoteModel != null) {
			try {
				Class<?> clazz = _spCartRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spCartRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setDiscountAmount(java.math.BigDecimal discountAmount) {
		try {
			String methodName = "setDiscountAmount";

			Class<?>[] parameterTypes = new Class<?>[] {
					java.math.BigDecimal.class
				};

			Object[] parameterValues = new Object[] { discountAmount };

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

	public BaseModel<?> getSPCartRemoteModel() {
		return _spCartRemoteModel;
	}

	public void setSPCartRemoteModel(BaseModel<?> spCartRemoteModel) {
		_spCartRemoteModel = spCartRemoteModel;
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

		Class<?> remoteModelClass = _spCartRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spCartRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPCartLocalServiceUtil.addSPCart(this);
		}
		else {
			SPCartLocalServiceUtil.updateSPCart(this);
		}
	}

	@Override
	public SPCart toEscapedModel() {
		return (SPCart)ProxyUtil.newProxyInstance(SPCart.class.getClassLoader(),
			new Class[] { SPCart.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPCartClp clone = new SPCartClp();

		clone.setSpCartId(getSpCartId());
		clone.setGroupId(getGroupId());
		clone.setDiscount(getDiscount());
		clone.setTotalPrice(getTotalPrice());
		clone.setUserRemarks(getUserRemarks());
		clone.setStatus(getStatus());
		clone.setTransactionDetails(getTransactionDetails());
		clone.setOrderPage(getOrderPage());
		clone.setRsvpDetailId(getRsvpDetailId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPCart spCart) {
		long primaryKey = spCart.getPrimaryKey();

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

		if (!(obj instanceof SPCartClp)) {
			return false;
		}

		SPCartClp spCart = (SPCartClp)obj;

		long primaryKey = spCart.getPrimaryKey();

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

		sb.append("{spCartId=");
		sb.append(getSpCartId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", discount=");
		sb.append(getDiscount());
		sb.append(", totalPrice=");
		sb.append(getTotalPrice());
		sb.append(", userRemarks=");
		sb.append(getUserRemarks());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", transactionDetails=");
		sb.append(getTransactionDetails());
		sb.append(", orderPage=");
		sb.append(getOrderPage());
		sb.append(", rsvpDetailId=");
		sb.append(getRsvpDetailId());
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
		sb.append("com.sambaash.platform.srv.spshopping.model.SPCart");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCartId</column-name><column-value><![CDATA[");
		sb.append(getSpCartId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>discount</column-name><column-value><![CDATA[");
		sb.append(getDiscount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalPrice</column-name><column-value><![CDATA[");
		sb.append(getTotalPrice());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userRemarks</column-name><column-value><![CDATA[");
		sb.append(getUserRemarks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>transactionDetails</column-name><column-value><![CDATA[");
		sb.append(getTransactionDetails());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderPage</column-name><column-value><![CDATA[");
		sb.append(getOrderPage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpDetailId</column-name><column-value><![CDATA[");
		sb.append(getRsvpDetailId());
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

	private long _spCartId;
	private long _groupId;
	private String _discount;
	private String _totalPrice;
	private String _userRemarks;
	private int _status;
	private String _transactionDetails;
	private String _orderPage;
	private long _rsvpDetailId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spCartRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spshopping.service.ClpSerializer.class;
}