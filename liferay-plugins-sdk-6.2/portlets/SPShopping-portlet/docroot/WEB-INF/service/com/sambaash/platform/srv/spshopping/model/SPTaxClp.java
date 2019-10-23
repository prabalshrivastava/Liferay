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
import com.sambaash.platform.srv.spshopping.service.SPTaxLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPTaxClp extends BaseModelImpl<SPTax> implements SPTax {
	public SPTaxClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPTax.class;
	}

	@Override
	public String getModelClassName() {
		return SPTax.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spTaxId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpTaxId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spTaxId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spTaxId", getSpTaxId());
		attributes.put("groupId", getGroupId());
		attributes.put("currencyCode", getCurrencyCode());
		attributes.put("taxName", getTaxName());
		attributes.put("taxValue", getTaxValue());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spTaxId = (Long)attributes.get("spTaxId");

		if (spTaxId != null) {
			setSpTaxId(spTaxId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String currencyCode = (String)attributes.get("currencyCode");

		if (currencyCode != null) {
			setCurrencyCode(currencyCode);
		}

		String taxName = (String)attributes.get("taxName");

		if (taxName != null) {
			setTaxName(taxName);
		}

		Long taxValue = (Long)attributes.get("taxValue");

		if (taxValue != null) {
			setTaxValue(taxValue);
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
	public long getSpTaxId() {
		return _spTaxId;
	}

	@Override
	public void setSpTaxId(long spTaxId) {
		_spTaxId = spTaxId;

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setSpTaxId", long.class);

				method.invoke(_spTaxRemoteModel, spTaxId);
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

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spTaxRemoteModel, groupId);
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

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrencyCode", String.class);

				method.invoke(_spTaxRemoteModel, currencyCode);
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

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxName", String.class);

				method.invoke(_spTaxRemoteModel, taxName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTaxValue() {
		return _taxValue;
	}

	@Override
	public void setTaxValue(long taxValue) {
		_taxValue = taxValue;

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxValue", long.class);

				method.invoke(_spTaxRemoteModel, taxValue);
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

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spTaxRemoteModel, companyId);
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

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spTaxRemoteModel, userId);
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

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spTaxRemoteModel, userName);
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

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spTaxRemoteModel, createDate);
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

		if (_spTaxRemoteModel != null) {
			try {
				Class<?> clazz = _spTaxRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spTaxRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPTaxRemoteModel() {
		return _spTaxRemoteModel;
	}

	public void setSPTaxRemoteModel(BaseModel<?> spTaxRemoteModel) {
		_spTaxRemoteModel = spTaxRemoteModel;
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

		Class<?> remoteModelClass = _spTaxRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spTaxRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPTaxLocalServiceUtil.addSPTax(this);
		}
		else {
			SPTaxLocalServiceUtil.updateSPTax(this);
		}
	}

	@Override
	public SPTax toEscapedModel() {
		return (SPTax)ProxyUtil.newProxyInstance(SPTax.class.getClassLoader(),
			new Class[] { SPTax.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPTaxClp clone = new SPTaxClp();

		clone.setSpTaxId(getSpTaxId());
		clone.setGroupId(getGroupId());
		clone.setCurrencyCode(getCurrencyCode());
		clone.setTaxName(getTaxName());
		clone.setTaxValue(getTaxValue());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPTax spTax) {
		long primaryKey = spTax.getPrimaryKey();

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

		if (!(obj instanceof SPTaxClp)) {
			return false;
		}

		SPTaxClp spTax = (SPTaxClp)obj;

		long primaryKey = spTax.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{spTaxId=");
		sb.append(getSpTaxId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", currencyCode=");
		sb.append(getCurrencyCode());
		sb.append(", taxName=");
		sb.append(getTaxName());
		sb.append(", taxValue=");
		sb.append(getTaxValue());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spshopping.model.SPTax");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spTaxId</column-name><column-value><![CDATA[");
		sb.append(getSpTaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currencyCode</column-name><column-value><![CDATA[");
		sb.append(getCurrencyCode());
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

	private long _spTaxId;
	private long _groupId;
	private String _currencyCode;
	private String _taxName;
	private long _taxValue;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _spTaxRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spshopping.service.ClpSerializer.class;
}