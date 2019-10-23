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
import com.sambaash.platform.srv.service.ModuleFrameworkLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ModuleFrameworkClp extends BaseModelImpl<ModuleFramework>
	implements ModuleFramework {
	public ModuleFrameworkClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ModuleFramework.class;
	}

	@Override
	public String getModelClassName() {
		return ModuleFramework.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spModuleFrameworkId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpModuleFrameworkId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spModuleFrameworkId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spModuleFrameworkId", getSpModuleFrameworkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("spFrameworkId", getSpFrameworkId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spModuleFrameworkId = (Long)attributes.get("spModuleFrameworkId");

		if (spModuleFrameworkId != null) {
			setSpModuleFrameworkId(spModuleFrameworkId);
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

		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
		}

		Long spFrameworkId = (Long)attributes.get("spFrameworkId");

		if (spFrameworkId != null) {
			setSpFrameworkId(spFrameworkId);
		}
	}

	@Override
	public long getSpModuleFrameworkId() {
		return _spModuleFrameworkId;
	}

	@Override
	public void setSpModuleFrameworkId(long spModuleFrameworkId) {
		_spModuleFrameworkId = spModuleFrameworkId;

		if (_moduleFrameworkRemoteModel != null) {
			try {
				Class<?> clazz = _moduleFrameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setSpModuleFrameworkId",
						long.class);

				method.invoke(_moduleFrameworkRemoteModel, spModuleFrameworkId);
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

		if (_moduleFrameworkRemoteModel != null) {
			try {
				Class<?> clazz = _moduleFrameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_moduleFrameworkRemoteModel, groupId);
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

		if (_moduleFrameworkRemoteModel != null) {
			try {
				Class<?> clazz = _moduleFrameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_moduleFrameworkRemoteModel, companyId);
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

		if (_moduleFrameworkRemoteModel != null) {
			try {
				Class<?> clazz = _moduleFrameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_moduleFrameworkRemoteModel, userId);
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

		if (_moduleFrameworkRemoteModel != null) {
			try {
				Class<?> clazz = _moduleFrameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_moduleFrameworkRemoteModel, userName);
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

		if (_moduleFrameworkRemoteModel != null) {
			try {
				Class<?> clazz = _moduleFrameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_moduleFrameworkRemoteModel, createDate);
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

		if (_moduleFrameworkRemoteModel != null) {
			try {
				Class<?> clazz = _moduleFrameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_moduleFrameworkRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpModuleId() {
		return _spModuleId;
	}

	@Override
	public void setSpModuleId(long spModuleId) {
		_spModuleId = spModuleId;

		if (_moduleFrameworkRemoteModel != null) {
			try {
				Class<?> clazz = _moduleFrameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setSpModuleId", long.class);

				method.invoke(_moduleFrameworkRemoteModel, spModuleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpFrameworkId() {
		return _spFrameworkId;
	}

	@Override
	public void setSpFrameworkId(long spFrameworkId) {
		_spFrameworkId = spFrameworkId;

		if (_moduleFrameworkRemoteModel != null) {
			try {
				Class<?> clazz = _moduleFrameworkRemoteModel.getClass();

				Method method = clazz.getMethod("setSpFrameworkId", long.class);

				method.invoke(_moduleFrameworkRemoteModel, spFrameworkId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getModuleFrameworkRemoteModel() {
		return _moduleFrameworkRemoteModel;
	}

	public void setModuleFrameworkRemoteModel(
		BaseModel<?> moduleFrameworkRemoteModel) {
		_moduleFrameworkRemoteModel = moduleFrameworkRemoteModel;
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

		Class<?> remoteModelClass = _moduleFrameworkRemoteModel.getClass();

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

		Object returnValue = method.invoke(_moduleFrameworkRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ModuleFrameworkLocalServiceUtil.addModuleFramework(this);
		}
		else {
			ModuleFrameworkLocalServiceUtil.updateModuleFramework(this);
		}
	}

	@Override
	public ModuleFramework toEscapedModel() {
		return (ModuleFramework)ProxyUtil.newProxyInstance(ModuleFramework.class.getClassLoader(),
			new Class[] { ModuleFramework.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ModuleFrameworkClp clone = new ModuleFrameworkClp();

		clone.setSpModuleFrameworkId(getSpModuleFrameworkId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpModuleId(getSpModuleId());
		clone.setSpFrameworkId(getSpFrameworkId());

		return clone;
	}

	@Override
	public int compareTo(ModuleFramework moduleFramework) {
		int value = 0;

		if (getSpModuleId() < moduleFramework.getSpModuleId()) {
			value = -1;
		}
		else if (getSpModuleId() > moduleFramework.getSpModuleId()) {
			value = 1;
		}
		else {
			value = 0;
		}

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

		if (!(obj instanceof ModuleFrameworkClp)) {
			return false;
		}

		ModuleFrameworkClp moduleFramework = (ModuleFrameworkClp)obj;

		long primaryKey = moduleFramework.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{spModuleFrameworkId=");
		sb.append(getSpModuleFrameworkId());
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
		sb.append(", spModuleId=");
		sb.append(getSpModuleId());
		sb.append(", spFrameworkId=");
		sb.append(getSpFrameworkId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.ModuleFramework");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spModuleFrameworkId</column-name><column-value><![CDATA[");
		sb.append(getSpModuleFrameworkId());
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
			"<column><column-name>spModuleId</column-name><column-value><![CDATA[");
		sb.append(getSpModuleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spFrameworkId</column-name><column-value><![CDATA[");
		sb.append(getSpFrameworkId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spModuleFrameworkId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private long _spFrameworkId;
	private BaseModel<?> _moduleFrameworkRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}