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
import com.sambaash.platform.srv.service.FrameworkLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class FrameworkClp extends BaseModelImpl<Framework> implements Framework {
	public FrameworkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Framework.class;
	}

	@Override
	public String getModelClassName() {
		return Framework.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spFrameworkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpFrameworkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spFrameworkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFrameworkId", getSpFrameworkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("frameworkCode", getFrameworkCode());
		attributes.put("frameworkName", getFrameworkName());
		attributes.put("frameworkImageId", getFrameworkImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFrameworkId = (Long)attributes.get("spFrameworkId");

		if (spFrameworkId != null) {
			setSpFrameworkId(spFrameworkId);
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

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String frameworkCode = (String)attributes.get("frameworkCode");

		if (frameworkCode != null) {
			setFrameworkCode(frameworkCode);
		}

		String frameworkName = (String)attributes.get("frameworkName");

		if (frameworkName != null) {
			setFrameworkName(frameworkName);
		}

		Long frameworkImageId = (Long)attributes.get("frameworkImageId");

		if (frameworkImageId != null) {
			setFrameworkImageId(frameworkImageId);
		}
	}

	@Override
	public long getSpFrameworkId() {
		return _spFrameworkId;
	}

	@Override
	public void setSpFrameworkId(long spFrameworkId) {
		_spFrameworkId = spFrameworkId;

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setSpFrameworkId", long.class);

				method.invoke(_frameworkRemoteModel, spFrameworkId);
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

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_frameworkRemoteModel, groupId);
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

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_frameworkRemoteModel, companyId);
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

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_frameworkRemoteModel, userId);
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

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_frameworkRemoteModel, userName);
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

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_frameworkRemoteModel, createDate);
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

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_frameworkRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_frameworkRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFrameworkCode() {
		return _frameworkCode;
	}

	@Override
	public void setFrameworkCode(String frameworkCode) {
		_frameworkCode = frameworkCode;

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setFrameworkCode", String.class);

				method.invoke(_frameworkRemoteModel, frameworkCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFrameworkName() {
		return _frameworkName;
	}

	@Override
	public void setFrameworkName(String frameworkName) {
		_frameworkName = frameworkName;

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setFrameworkName", String.class);

				method.invoke(_frameworkRemoteModel, frameworkName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Long getFrameworkImageId() {
		return _frameworkImageId;
	}

	@Override
	public void setFrameworkImageId(Long frameworkImageId) {
		_frameworkImageId = frameworkImageId;

		if (_frameworkRemoteModel != null) {
			try {
				Class<?> clazz = _frameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setFrameworkImageId",
						Long.class);

				method.invoke(_frameworkRemoteModel, frameworkImageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFrameworkRemoteModel() {
		return _frameworkRemoteModel;
	}

	public void setFrameworkRemoteModel(BaseModel<?> frameworkRemoteModel) {
		_frameworkRemoteModel = frameworkRemoteModel;
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

		Class<?> remoteModelClass = _frameworkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_frameworkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FrameworkLocalServiceUtil.addFramework(this);
		}
		else {
			FrameworkLocalServiceUtil.updateFramework(this);
		}
	}

	@Override
	public Framework toEscapedModel() {
		return (Framework)ProxyUtil.newProxyInstance(Framework.class.getClassLoader(),
			new Class[] { Framework.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FrameworkClp clone = new FrameworkClp();

		clone.setSpFrameworkId(getSpFrameworkId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryId(getCountryId());
		clone.setFrameworkCode(getFrameworkCode());
		clone.setFrameworkName(getFrameworkName());
		clone.setFrameworkImageId(getFrameworkImageId());

		return clone;
	}

	@Override
	public int compareTo(Framework framework) {
		int value = 0;

		value = getFrameworkName().compareTo(framework.getFrameworkName());

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

		if (!(obj instanceof FrameworkClp)) {
			return false;
		}

		FrameworkClp framework = (FrameworkClp)obj;

		long primaryKey = framework.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{spFrameworkId=");
		sb.append(getSpFrameworkId());
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
		sb.append(", frameworkCode=");
		sb.append(getFrameworkCode());
		sb.append(", frameworkName=");
		sb.append(getFrameworkName());
		sb.append(", frameworkImageId=");
		sb.append(getFrameworkImageId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Framework");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spFrameworkId</column-name><column-value><![CDATA[");
		sb.append(getSpFrameworkId());
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
			"<column><column-name>frameworkCode</column-name><column-value><![CDATA[");
		sb.append(getFrameworkCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frameworkName</column-name><column-value><![CDATA[");
		sb.append(getFrameworkName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frameworkImageId</column-name><column-value><![CDATA[");
		sb.append(getFrameworkImageId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spFrameworkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private String _frameworkCode;
	private String _frameworkName;
	private Long _frameworkImageId;
	private BaseModel<?> _frameworkRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}