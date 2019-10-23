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

package com.sambaash.platform.srv.spdynamicforms.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spdynamicforms.service.ClpSerializer;
import com.sambaash.platform.srv.spdynamicforms.service.SPFormAttachmentsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author glenn
 */
public class SPFormAttachmentsClp extends BaseModelImpl<SPFormAttachments>
	implements SPFormAttachments {
	public SPFormAttachmentsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPFormAttachments.class;
	}

	@Override
	public String getModelClassName() {
		return SPFormAttachments.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spFormAttachmentsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpFormAttachmentsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spFormAttachmentsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFormAttachmentsId", getSpFormAttachmentsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("formStorageId", getFormStorageId());
		attributes.put("dataKey", getDataKey());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("version", getVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFormAttachmentsId = (Long)attributes.get("spFormAttachmentsId");

		if (spFormAttachmentsId != null) {
			setSpFormAttachmentsId(spFormAttachmentsId);
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

		Long formStorageId = (Long)attributes.get("formStorageId");

		if (formStorageId != null) {
			setFormStorageId(formStorageId);
		}

		String dataKey = (String)attributes.get("dataKey");

		if (dataKey != null) {
			setDataKey(dataKey);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}
	}

	@Override
	public long getSpFormAttachmentsId() {
		return _spFormAttachmentsId;
	}

	@Override
	public void setSpFormAttachmentsId(long spFormAttachmentsId) {
		_spFormAttachmentsId = spFormAttachmentsId;

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setSpFormAttachmentsId",
						long.class);

				method.invoke(_spFormAttachmentsRemoteModel, spFormAttachmentsId);
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

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spFormAttachmentsRemoteModel, groupId);
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

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spFormAttachmentsRemoteModel, companyId);
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

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spFormAttachmentsRemoteModel, userId);
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

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spFormAttachmentsRemoteModel, userName);
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

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spFormAttachmentsRemoteModel, createDate);
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

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spFormAttachmentsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFormStorageId() {
		return _formStorageId;
	}

	@Override
	public void setFormStorageId(long formStorageId) {
		_formStorageId = formStorageId;

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setFormStorageId", long.class);

				method.invoke(_spFormAttachmentsRemoteModel, formStorageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDataKey() {
		return _dataKey;
	}

	@Override
	public void setDataKey(String dataKey) {
		_dataKey = dataKey;

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setDataKey", String.class);

				method.invoke(_spFormAttachmentsRemoteModel, dataKey);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_spFormAttachmentsRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUrl() {
		return _url;
	}

	@Override
	public void setUrl(String url) {
		_url = url;

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setUrl", String.class);

				method.invoke(_spFormAttachmentsRemoteModel, url);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVersion() {
		return _version;
	}

	@Override
	public void setVersion(String version) {
		_version = version;

		if (_spFormAttachmentsRemoteModel != null) {
			try {
				Class<?> clazz = _spFormAttachmentsRemoteModel.getClass();

				Method method = clazz.getMethod("setVersion", String.class);

				method.invoke(_spFormAttachmentsRemoteModel, version);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPFormAttachmentsRemoteModel() {
		return _spFormAttachmentsRemoteModel;
	}

	public void setSPFormAttachmentsRemoteModel(
		BaseModel<?> spFormAttachmentsRemoteModel) {
		_spFormAttachmentsRemoteModel = spFormAttachmentsRemoteModel;
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

		Class<?> remoteModelClass = _spFormAttachmentsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spFormAttachmentsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPFormAttachmentsLocalServiceUtil.addSPFormAttachments(this);
		}
		else {
			SPFormAttachmentsLocalServiceUtil.updateSPFormAttachments(this);
		}
	}

	@Override
	public SPFormAttachments toEscapedModel() {
		return (SPFormAttachments)ProxyUtil.newProxyInstance(SPFormAttachments.class.getClassLoader(),
			new Class[] { SPFormAttachments.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPFormAttachmentsClp clone = new SPFormAttachmentsClp();

		clone.setSpFormAttachmentsId(getSpFormAttachmentsId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFormStorageId(getFormStorageId());
		clone.setDataKey(getDataKey());
		clone.setName(getName());
		clone.setUrl(getUrl());
		clone.setVersion(getVersion());

		return clone;
	}

	@Override
	public int compareTo(SPFormAttachments spFormAttachments) {
		long primaryKey = spFormAttachments.getPrimaryKey();

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

		if (!(obj instanceof SPFormAttachmentsClp)) {
			return false;
		}

		SPFormAttachmentsClp spFormAttachments = (SPFormAttachmentsClp)obj;

		long primaryKey = spFormAttachments.getPrimaryKey();

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

		sb.append("{spFormAttachmentsId=");
		sb.append(getSpFormAttachmentsId());
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
		sb.append(", formStorageId=");
		sb.append(getFormStorageId());
		sb.append(", dataKey=");
		sb.append(getDataKey());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", url=");
		sb.append(getUrl());
		sb.append(", version=");
		sb.append(getVersion());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spdynamicforms.model.SPFormAttachments");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spFormAttachmentsId</column-name><column-value><![CDATA[");
		sb.append(getSpFormAttachmentsId());
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
			"<column><column-name>formStorageId</column-name><column-value><![CDATA[");
		sb.append(getFormStorageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dataKey</column-name><column-value><![CDATA[");
		sb.append(getDataKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>url</column-name><column-value><![CDATA[");
		sb.append(getUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>version</column-name><column-value><![CDATA[");
		sb.append(getVersion());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spFormAttachmentsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _formStorageId;
	private String _dataKey;
	private String _name;
	private String _url;
	private String _version;
	private BaseModel<?> _spFormAttachmentsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spdynamicforms.service.ClpSerializer.class;
}