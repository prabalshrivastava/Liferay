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

package com.sambaash.platform.srv.processbuilder.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.processbuilder.service.ClpSerializer;
import com.sambaash.platform.srv.processbuilder.service.PECustomActionInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author nareshchebolu
 */
public class PECustomActionInfoClp extends BaseModelImpl<PECustomActionInfo>
	implements PECustomActionInfo {
	public PECustomActionInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PECustomActionInfo.class;
	}

	@Override
	public String getModelClassName() {
		return PECustomActionInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spPEActionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpPEActionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spPEActionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spPEActionId", getSpPEActionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("actionClassName", getActionClassName());
		attributes.put("title", getTitle());
		attributes.put("defaultConfiguration", getDefaultConfiguration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spPEActionId = (Long)attributes.get("spPEActionId");

		if (spPEActionId != null) {
			setSpPEActionId(spPEActionId);
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

		String actionClassName = (String)attributes.get("actionClassName");

		if (actionClassName != null) {
			setActionClassName(actionClassName);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String defaultConfiguration = (String)attributes.get(
				"defaultConfiguration");

		if (defaultConfiguration != null) {
			setDefaultConfiguration(defaultConfiguration);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_peCustomActionInfoRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEActionId() {
		return _spPEActionId;
	}

	@Override
	public void setSpPEActionId(long spPEActionId) {
		_spPEActionId = spPEActionId;

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEActionId", long.class);

				method.invoke(_peCustomActionInfoRemoteModel, spPEActionId);
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

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_peCustomActionInfoRemoteModel, groupId);
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

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_peCustomActionInfoRemoteModel, companyId);
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

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_peCustomActionInfoRemoteModel, userId);
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

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_peCustomActionInfoRemoteModel, userName);
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

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_peCustomActionInfoRemoteModel, createDate);
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

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_peCustomActionInfoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActionClassName() {
		return _actionClassName;
	}

	@Override
	public void setActionClassName(String actionClassName) {
		_actionClassName = actionClassName;

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setActionClassName",
						String.class);

				method.invoke(_peCustomActionInfoRemoteModel, actionClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_peCustomActionInfoRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDefaultConfiguration() {
		return _defaultConfiguration;
	}

	@Override
	public void setDefaultConfiguration(String defaultConfiguration) {
		_defaultConfiguration = defaultConfiguration;

		if (_peCustomActionInfoRemoteModel != null) {
			try {
				Class<?> clazz = _peCustomActionInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDefaultConfiguration",
						String.class);

				method.invoke(_peCustomActionInfoRemoteModel,
					defaultConfiguration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				PECustomActionInfo.class.getName()));
	}

	public BaseModel<?> getPECustomActionInfoRemoteModel() {
		return _peCustomActionInfoRemoteModel;
	}

	public void setPECustomActionInfoRemoteModel(
		BaseModel<?> peCustomActionInfoRemoteModel) {
		_peCustomActionInfoRemoteModel = peCustomActionInfoRemoteModel;
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

		Class<?> remoteModelClass = _peCustomActionInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_peCustomActionInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PECustomActionInfoLocalServiceUtil.addPECustomActionInfo(this);
		}
		else {
			PECustomActionInfoLocalServiceUtil.updatePECustomActionInfo(this);
		}
	}

	@Override
	public PECustomActionInfo toEscapedModel() {
		return (PECustomActionInfo)ProxyUtil.newProxyInstance(PECustomActionInfo.class.getClassLoader(),
			new Class[] { PECustomActionInfo.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PECustomActionInfoClp clone = new PECustomActionInfoClp();

		clone.setUuid(getUuid());
		clone.setSpPEActionId(getSpPEActionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setActionClassName(getActionClassName());
		clone.setTitle(getTitle());
		clone.setDefaultConfiguration(getDefaultConfiguration());

		return clone;
	}

	@Override
	public int compareTo(PECustomActionInfo peCustomActionInfo) {
		int value = 0;

		value = getTitle().compareTo(peCustomActionInfo.getTitle());

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

		if (!(obj instanceof PECustomActionInfoClp)) {
			return false;
		}

		PECustomActionInfoClp peCustomActionInfo = (PECustomActionInfoClp)obj;

		long primaryKey = peCustomActionInfo.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spPEActionId=");
		sb.append(getSpPEActionId());
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
		sb.append(", actionClassName=");
		sb.append(getActionClassName());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", defaultConfiguration=");
		sb.append(getDefaultConfiguration());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEActionId</column-name><column-value><![CDATA[");
		sb.append(getSpPEActionId());
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
			"<column><column-name>actionClassName</column-name><column-value><![CDATA[");
		sb.append(getActionClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultConfiguration</column-name><column-value><![CDATA[");
		sb.append(getDefaultConfiguration());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spPEActionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _actionClassName;
	private String _title;
	private String _defaultConfiguration;
	private BaseModel<?> _peCustomActionInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.processbuilder.service.ClpSerializer.class;
}