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

package com.sambaash.platform.srv.sppayment.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.sppayment.service.ClpSerializer;
import com.sambaash.platform.srv.sppayment.service.SPPurchaseLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPPurchaseClp extends BaseModelImpl<SPPurchase>
	implements SPPurchase {
	public SPPurchaseClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPPurchase.class;
	}

	@Override
	public String getModelClassName() {
		return SPPurchase.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPurchaseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPurchaseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPurchaseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPurchaseId", getSpPurchaseId());
		attributes.put("groupId", getGroupId());
		attributes.put("cartId", getCartId());
		attributes.put("extPaymentId", getExtPaymentId());
		attributes.put("extStatus", getExtStatus());
		attributes.put("extErrorCode", getExtErrorCode());
		attributes.put("extErrorMsg", getExtErrorMsg());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPurchaseId = (Long)attributes.get("spPurchaseId");

		if (spPurchaseId != null) {
			setSpPurchaseId(spPurchaseId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long cartId = (Long)attributes.get("cartId");

		if (cartId != null) {
			setCartId(cartId);
		}

		String extPaymentId = (String)attributes.get("extPaymentId");

		if (extPaymentId != null) {
			setExtPaymentId(extPaymentId);
		}

		String extStatus = (String)attributes.get("extStatus");

		if (extStatus != null) {
			setExtStatus(extStatus);
		}

		Long extErrorCode = (Long)attributes.get("extErrorCode");

		if (extErrorCode != null) {
			setExtErrorCode(extErrorCode);
		}

		String extErrorMsg = (String)attributes.get("extErrorMsg");

		if (extErrorMsg != null) {
			setExtErrorMsg(extErrorMsg);
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
	public long getSpPurchaseId() {
		return _spPurchaseId;
	}

	@Override
	public void setSpPurchaseId(long spPurchaseId) {
		_spPurchaseId = spPurchaseId;

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPurchaseId", long.class);

				method.invoke(_spPurchaseRemoteModel, spPurchaseId);
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

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spPurchaseRemoteModel, groupId);
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

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setCartId", long.class);

				method.invoke(_spPurchaseRemoteModel, cartId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtPaymentId() {
		return _extPaymentId;
	}

	@Override
	public void setExtPaymentId(String extPaymentId) {
		_extPaymentId = extPaymentId;

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setExtPaymentId", String.class);

				method.invoke(_spPurchaseRemoteModel, extPaymentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtStatus() {
		return _extStatus;
	}

	@Override
	public void setExtStatus(String extStatus) {
		_extStatus = extStatus;

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setExtStatus", String.class);

				method.invoke(_spPurchaseRemoteModel, extStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getExtErrorCode() {
		return _extErrorCode;
	}

	@Override
	public void setExtErrorCode(long extErrorCode) {
		_extErrorCode = extErrorCode;

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setExtErrorCode", long.class);

				method.invoke(_spPurchaseRemoteModel, extErrorCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtErrorMsg() {
		return _extErrorMsg;
	}

	@Override
	public void setExtErrorMsg(String extErrorMsg) {
		_extErrorMsg = extErrorMsg;

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setExtErrorMsg", String.class);

				method.invoke(_spPurchaseRemoteModel, extErrorMsg);
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

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spPurchaseRemoteModel, companyId);
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

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spPurchaseRemoteModel, userId);
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

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spPurchaseRemoteModel, userName);
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

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spPurchaseRemoteModel, createDate);
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

		if (_spPurchaseRemoteModel != null) {
			try {
				Class<?> clazz = _spPurchaseRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spPurchaseRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPPurchaseRemoteModel() {
		return _spPurchaseRemoteModel;
	}

	public void setSPPurchaseRemoteModel(BaseModel<?> spPurchaseRemoteModel) {
		_spPurchaseRemoteModel = spPurchaseRemoteModel;
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

		Class<?> remoteModelClass = _spPurchaseRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spPurchaseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPPurchaseLocalServiceUtil.addSPPurchase(this);
		}
		else {
			SPPurchaseLocalServiceUtil.updateSPPurchase(this);
		}
	}

	@Override
	public SPPurchase toEscapedModel() {
		return (SPPurchase)ProxyUtil.newProxyInstance(SPPurchase.class.getClassLoader(),
			new Class[] { SPPurchase.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPPurchaseClp clone = new SPPurchaseClp();

		clone.setSpPurchaseId(getSpPurchaseId());
		clone.setGroupId(getGroupId());
		clone.setCartId(getCartId());
		clone.setExtPaymentId(getExtPaymentId());
		clone.setExtStatus(getExtStatus());
		clone.setExtErrorCode(getExtErrorCode());
		clone.setExtErrorMsg(getExtErrorMsg());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPPurchase spPurchase) {
		long primaryKey = spPurchase.getPrimaryKey();

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

		if (!(obj instanceof SPPurchaseClp)) {
			return false;
		}

		SPPurchaseClp spPurchase = (SPPurchaseClp)obj;

		long primaryKey = spPurchase.getPrimaryKey();

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
		StringBundler sb = new StringBundler(25);

		sb.append("{spPurchaseId=");
		sb.append(getSpPurchaseId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", cartId=");
		sb.append(getCartId());
		sb.append(", extPaymentId=");
		sb.append(getExtPaymentId());
		sb.append(", extStatus=");
		sb.append(getExtStatus());
		sb.append(", extErrorCode=");
		sb.append(getExtErrorCode());
		sb.append(", extErrorMsg=");
		sb.append(getExtErrorMsg());
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
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.sppayment.model.SPPurchase");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spPurchaseId</column-name><column-value><![CDATA[");
		sb.append(getSpPurchaseId());
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
			"<column><column-name>extPaymentId</column-name><column-value><![CDATA[");
		sb.append(getExtPaymentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extStatus</column-name><column-value><![CDATA[");
		sb.append(getExtStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extErrorCode</column-name><column-value><![CDATA[");
		sb.append(getExtErrorCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extErrorMsg</column-name><column-value><![CDATA[");
		sb.append(getExtErrorMsg());
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

	private long _spPurchaseId;
	private long _groupId;
	private long _cartId;
	private String _extPaymentId;
	private String _extStatus;
	private long _extErrorCode;
	private String _extErrorMsg;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spPurchaseRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.sppayment.service.ClpSerializer.class;
}