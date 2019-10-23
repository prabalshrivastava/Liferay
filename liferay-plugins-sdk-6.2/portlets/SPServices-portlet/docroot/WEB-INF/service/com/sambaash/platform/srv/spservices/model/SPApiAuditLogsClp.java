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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.SPApiAuditLogsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPApiAuditLogsClp extends BaseModelImpl<SPApiAuditLogs>
	implements SPApiAuditLogs {
	public SPApiAuditLogsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPApiAuditLogs.class;
	}

	@Override
	public String getModelClassName() {
		return SPApiAuditLogs.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spApiAuditLogsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpApiAuditLogsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spApiAuditLogsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spApiAuditLogsId", getSpApiAuditLogsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("apiName", getApiName());
		attributes.put("parameters", getParameters());
		attributes.put("result", getResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spApiAuditLogsId = (Long)attributes.get("spApiAuditLogsId");

		if (spApiAuditLogsId != null) {
			setSpApiAuditLogsId(spApiAuditLogsId);
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

		String apiName = (String)attributes.get("apiName");

		if (apiName != null) {
			setApiName(apiName);
		}

		String parameters = (String)attributes.get("parameters");

		if (parameters != null) {
			setParameters(parameters);
		}

		String result = (String)attributes.get("result");

		if (result != null) {
			setResult(result);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spApiAuditLogsRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpApiAuditLogsId() {
		return _spApiAuditLogsId;
	}

	@Override
	public void setSpApiAuditLogsId(long spApiAuditLogsId) {
		_spApiAuditLogsId = spApiAuditLogsId;

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setSpApiAuditLogsId",
						long.class);

				method.invoke(_spApiAuditLogsRemoteModel, spApiAuditLogsId);
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

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spApiAuditLogsRemoteModel, groupId);
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

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spApiAuditLogsRemoteModel, companyId);
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

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spApiAuditLogsRemoteModel, userId);
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

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spApiAuditLogsRemoteModel, userName);
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

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spApiAuditLogsRemoteModel, createDate);
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

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spApiAuditLogsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApiName() {
		return _apiName;
	}

	@Override
	public void setApiName(String apiName) {
		_apiName = apiName;

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setApiName", String.class);

				method.invoke(_spApiAuditLogsRemoteModel, apiName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getParameters() {
		return _parameters;
	}

	@Override
	public void setParameters(String parameters) {
		_parameters = parameters;

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setParameters", String.class);

				method.invoke(_spApiAuditLogsRemoteModel, parameters);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getResult() {
		return _result;
	}

	@Override
	public void setResult(String result) {
		_result = result;

		if (_spApiAuditLogsRemoteModel != null) {
			try {
				Class<?> clazz = _spApiAuditLogsRemoteModel.getClass();

				Method method = clazz.getMethod("setResult", String.class);

				method.invoke(_spApiAuditLogsRemoteModel, result);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPApiAuditLogs.class.getName()));
	}

	public BaseModel<?> getSPApiAuditLogsRemoteModel() {
		return _spApiAuditLogsRemoteModel;
	}

	public void setSPApiAuditLogsRemoteModel(
		BaseModel<?> spApiAuditLogsRemoteModel) {
		_spApiAuditLogsRemoteModel = spApiAuditLogsRemoteModel;
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

		Class<?> remoteModelClass = _spApiAuditLogsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spApiAuditLogsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPApiAuditLogsLocalServiceUtil.addSPApiAuditLogs(this);
		}
		else {
			SPApiAuditLogsLocalServiceUtil.updateSPApiAuditLogs(this);
		}
	}

	@Override
	public SPApiAuditLogs toEscapedModel() {
		return (SPApiAuditLogs)ProxyUtil.newProxyInstance(SPApiAuditLogs.class.getClassLoader(),
			new Class[] { SPApiAuditLogs.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPApiAuditLogsClp clone = new SPApiAuditLogsClp();

		clone.setUuid(getUuid());
		clone.setSpApiAuditLogsId(getSpApiAuditLogsId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setApiName(getApiName());
		clone.setParameters(getParameters());
		clone.setResult(getResult());

		return clone;
	}

	@Override
	public int compareTo(SPApiAuditLogs spApiAuditLogs) {
		long primaryKey = spApiAuditLogs.getPrimaryKey();

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

		if (!(obj instanceof SPApiAuditLogsClp)) {
			return false;
		}

		SPApiAuditLogsClp spApiAuditLogs = (SPApiAuditLogsClp)obj;

		long primaryKey = spApiAuditLogs.getPrimaryKey();

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
		sb.append(", spApiAuditLogsId=");
		sb.append(getSpApiAuditLogsId());
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
		sb.append(", apiName=");
		sb.append(getApiName());
		sb.append(", parameters=");
		sb.append(getParameters());
		sb.append(", result=");
		sb.append(getResult());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPApiAuditLogs");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spApiAuditLogsId</column-name><column-value><![CDATA[");
		sb.append(getSpApiAuditLogsId());
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
			"<column><column-name>apiName</column-name><column-value><![CDATA[");
		sb.append(getApiName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parameters</column-name><column-value><![CDATA[");
		sb.append(getParameters());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>result</column-name><column-value><![CDATA[");
		sb.append(getResult());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spApiAuditLogsId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _apiName;
	private String _parameters;
	private String _result;
	private BaseModel<?> _spApiAuditLogsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}