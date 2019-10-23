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
import com.sambaash.platform.srv.service.ModuleCompetencyUnitLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ModuleCompetencyUnitClp extends BaseModelImpl<ModuleCompetencyUnit>
	implements ModuleCompetencyUnit {
	public ModuleCompetencyUnitClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ModuleCompetencyUnit.class;
	}

	@Override
	public String getModelClassName() {
		return ModuleCompetencyUnit.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spModuleCompetencyUnitId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpModuleCompetencyUnitId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spModuleCompetencyUnitId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spModuleCompetencyUnitId", getSpModuleCompetencyUnitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("spCompetencyUnitId", getSpCompetencyUnitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spModuleCompetencyUnitId = (Long)attributes.get(
				"spModuleCompetencyUnitId");

		if (spModuleCompetencyUnitId != null) {
			setSpModuleCompetencyUnitId(spModuleCompetencyUnitId);
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

		Long spCompetencyUnitId = (Long)attributes.get("spCompetencyUnitId");

		if (spCompetencyUnitId != null) {
			setSpCompetencyUnitId(spCompetencyUnitId);
		}
	}

	@Override
	public long getSpModuleCompetencyUnitId() {
		return _spModuleCompetencyUnitId;
	}

	@Override
	public void setSpModuleCompetencyUnitId(long spModuleCompetencyUnitId) {
		_spModuleCompetencyUnitId = spModuleCompetencyUnitId;

		if (_moduleCompetencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _moduleCompetencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setSpModuleCompetencyUnitId",
						long.class);

				method.invoke(_moduleCompetencyUnitRemoteModel,
					spModuleCompetencyUnitId);
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

		if (_moduleCompetencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _moduleCompetencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_moduleCompetencyUnitRemoteModel, groupId);
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

		if (_moduleCompetencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _moduleCompetencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_moduleCompetencyUnitRemoteModel, companyId);
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

		if (_moduleCompetencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _moduleCompetencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_moduleCompetencyUnitRemoteModel, userId);
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

		if (_moduleCompetencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _moduleCompetencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_moduleCompetencyUnitRemoteModel, userName);
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

		if (_moduleCompetencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _moduleCompetencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_moduleCompetencyUnitRemoteModel, createDate);
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

		if (_moduleCompetencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _moduleCompetencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_moduleCompetencyUnitRemoteModel, modifiedDate);
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

		if (_moduleCompetencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _moduleCompetencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setSpModuleId", long.class);

				method.invoke(_moduleCompetencyUnitRemoteModel, spModuleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCompetencyUnitId() {
		return _spCompetencyUnitId;
	}

	@Override
	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_spCompetencyUnitId = spCompetencyUnitId;

		if (_moduleCompetencyUnitRemoteModel != null) {
			try {
				Class<?> clazz = _moduleCompetencyUnitRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCompetencyUnitId",
						long.class);

				method.invoke(_moduleCompetencyUnitRemoteModel,
					spCompetencyUnitId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getModuleCompetencyUnitRemoteModel() {
		return _moduleCompetencyUnitRemoteModel;
	}

	public void setModuleCompetencyUnitRemoteModel(
		BaseModel<?> moduleCompetencyUnitRemoteModel) {
		_moduleCompetencyUnitRemoteModel = moduleCompetencyUnitRemoteModel;
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

		Class<?> remoteModelClass = _moduleCompetencyUnitRemoteModel.getClass();

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

		Object returnValue = method.invoke(_moduleCompetencyUnitRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ModuleCompetencyUnitLocalServiceUtil.addModuleCompetencyUnit(this);
		}
		else {
			ModuleCompetencyUnitLocalServiceUtil.updateModuleCompetencyUnit(this);
		}
	}

	@Override
	public ModuleCompetencyUnit toEscapedModel() {
		return (ModuleCompetencyUnit)ProxyUtil.newProxyInstance(ModuleCompetencyUnit.class.getClassLoader(),
			new Class[] { ModuleCompetencyUnit.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ModuleCompetencyUnitClp clone = new ModuleCompetencyUnitClp();

		clone.setSpModuleCompetencyUnitId(getSpModuleCompetencyUnitId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpModuleId(getSpModuleId());
		clone.setSpCompetencyUnitId(getSpCompetencyUnitId());

		return clone;
	}

	@Override
	public int compareTo(ModuleCompetencyUnit moduleCompetencyUnit) {
		int value = 0;

		if (getSpModuleId() < moduleCompetencyUnit.getSpModuleId()) {
			value = -1;
		}
		else if (getSpModuleId() > moduleCompetencyUnit.getSpModuleId()) {
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

		if (!(obj instanceof ModuleCompetencyUnitClp)) {
			return false;
		}

		ModuleCompetencyUnitClp moduleCompetencyUnit = (ModuleCompetencyUnitClp)obj;

		long primaryKey = moduleCompetencyUnit.getPrimaryKey();

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

		sb.append("{spModuleCompetencyUnitId=");
		sb.append(getSpModuleCompetencyUnitId());
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
		sb.append(", spCompetencyUnitId=");
		sb.append(getSpCompetencyUnitId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.ModuleCompetencyUnit");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spModuleCompetencyUnitId</column-name><column-value><![CDATA[");
		sb.append(getSpModuleCompetencyUnitId());
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
			"<column><column-name>spCompetencyUnitId</column-name><column-value><![CDATA[");
		sb.append(getSpCompetencyUnitId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spModuleCompetencyUnitId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private long _spCompetencyUnitId;
	private BaseModel<?> _moduleCompetencyUnitRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}