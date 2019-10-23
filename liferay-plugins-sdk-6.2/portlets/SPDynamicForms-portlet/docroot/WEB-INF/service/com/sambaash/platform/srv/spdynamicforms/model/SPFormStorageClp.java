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
import com.sambaash.platform.srv.spdynamicforms.service.SPFormStorageLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author glenn
 */
public class SPFormStorageClp extends BaseModelImpl<SPFormStorage>
	implements SPFormStorage {
	public SPFormStorageClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPFormStorage.class;
	}

	@Override
	public String getModelClassName() {
		return SPFormStorage.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _formStorageId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setFormStorageId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _formStorageId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formStorageId", getFormStorageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicationId", getApplicationId());
		attributes.put("content", getContent());
		attributes.put("htmlFormId", getHtmlFormId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formStorageId = (Long)attributes.get("formStorageId");

		if (formStorageId != null) {
			setFormStorageId(formStorageId);
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

		String applicationId = (String)attributes.get("applicationId");

		if (applicationId != null) {
			setApplicationId(applicationId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long htmlFormId = (Long)attributes.get("htmlFormId");

		if (htmlFormId != null) {
			setHtmlFormId(htmlFormId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	@Override
	public long getFormStorageId() {
		return _formStorageId;
	}

	@Override
	public void setFormStorageId(long formStorageId) {
		_formStorageId = formStorageId;

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setFormStorageId", long.class);

				method.invoke(_spFormStorageRemoteModel, formStorageId);
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

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spFormStorageRemoteModel, groupId);
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

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spFormStorageRemoteModel, companyId);
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

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spFormStorageRemoteModel, userId);
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

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spFormStorageRemoteModel, userName);
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

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spFormStorageRemoteModel, createDate);
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

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spFormStorageRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApplicationId() {
		return _applicationId;
	}

	@Override
	public void setApplicationId(String applicationId) {
		_applicationId = applicationId;

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setApplicationId", String.class);

				method.invoke(_spFormStorageRemoteModel, applicationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContent() {
		return _content;
	}

	@Override
	public void setContent(String content) {
		_content = content;

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setContent", String.class);

				method.invoke(_spFormStorageRemoteModel, content);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHtmlFormId() {
		return _htmlFormId;
	}

	@Override
	public void setHtmlFormId(long htmlFormId) {
		_htmlFormId = htmlFormId;

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setHtmlFormId", long.class);

				method.invoke(_spFormStorageRemoteModel, htmlFormId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_spFormStorageRemoteModel != null) {
			try {
				Class<?> clazz = _spFormStorageRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_spFormStorageRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPFormStorageRemoteModel() {
		return _spFormStorageRemoteModel;
	}

	public void setSPFormStorageRemoteModel(
		BaseModel<?> spFormStorageRemoteModel) {
		_spFormStorageRemoteModel = spFormStorageRemoteModel;
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

		Class<?> remoteModelClass = _spFormStorageRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spFormStorageRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPFormStorageLocalServiceUtil.addSPFormStorage(this);
		}
		else {
			SPFormStorageLocalServiceUtil.updateSPFormStorage(this);
		}
	}

	@Override
	public SPFormStorage toEscapedModel() {
		return (SPFormStorage)ProxyUtil.newProxyInstance(SPFormStorage.class.getClassLoader(),
			new Class[] { SPFormStorage.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPFormStorageClp clone = new SPFormStorageClp();

		clone.setFormStorageId(getFormStorageId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setApplicationId(getApplicationId());
		clone.setContent(getContent());
		clone.setHtmlFormId(getHtmlFormId());
		clone.setStatus(getStatus());

		return clone;
	}

	@Override
	public int compareTo(SPFormStorage spFormStorage) {
		long primaryKey = spFormStorage.getPrimaryKey();

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

		if (!(obj instanceof SPFormStorageClp)) {
			return false;
		}

		SPFormStorageClp spFormStorage = (SPFormStorageClp)obj;

		long primaryKey = spFormStorage.getPrimaryKey();

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

		sb.append("{formStorageId=");
		sb.append(getFormStorageId());
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
		sb.append(", applicationId=");
		sb.append(getApplicationId());
		sb.append(", content=");
		sb.append(getContent());
		sb.append(", htmlFormId=");
		sb.append(getHtmlFormId());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>formStorageId</column-name><column-value><![CDATA[");
		sb.append(getFormStorageId());
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
			"<column><column-name>applicationId</column-name><column-value><![CDATA[");
		sb.append(getApplicationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>content</column-name><column-value><![CDATA[");
		sb.append(getContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>htmlFormId</column-name><column-value><![CDATA[");
		sb.append(getHtmlFormId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _formStorageId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _applicationId;
	private String _content;
	private long _htmlFormId;
	private String _status;
	private BaseModel<?> _spFormStorageRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spdynamicforms.service.ClpSerializer.class;
}