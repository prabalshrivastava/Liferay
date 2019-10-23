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
import com.sambaash.platform.srv.service.ScheduleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ScheduleClp extends BaseModelImpl<Schedule> implements Schedule {
	public ScheduleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Schedule.class;
	}

	@Override
	public String getModelClassName() {
		return Schedule.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spScheduleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpScheduleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spScheduleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spScheduleId", getSpScheduleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("sessionNumber", getSessionNumber());
		attributes.put("description", getDescription());
		attributes.put("sessionType", getSessionType());
		attributes.put("sessionDuration", getSessionDuration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spScheduleId = (Long)attributes.get("spScheduleId");

		if (spScheduleId != null) {
			setSpScheduleId(spScheduleId);
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

		String sessionNumber = (String)attributes.get("sessionNumber");

		if (sessionNumber != null) {
			setSessionNumber(sessionNumber);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long sessionType = (Long)attributes.get("sessionType");

		if (sessionType != null) {
			setSessionType(sessionType);
		}

		String sessionDuration = (String)attributes.get("sessionDuration");

		if (sessionDuration != null) {
			setSessionDuration(sessionDuration);
		}
	}

	@Override
	public long getSpScheduleId() {
		return _spScheduleId;
	}

	@Override
	public void setSpScheduleId(long spScheduleId) {
		_spScheduleId = spScheduleId;

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setSpScheduleId", long.class);

				method.invoke(_scheduleRemoteModel, spScheduleId);
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

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_scheduleRemoteModel, groupId);
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

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_scheduleRemoteModel, companyId);
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

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_scheduleRemoteModel, userId);
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

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_scheduleRemoteModel, userName);
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

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_scheduleRemoteModel, createDate);
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

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_scheduleRemoteModel, modifiedDate);
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

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setSpModuleId", long.class);

				method.invoke(_scheduleRemoteModel, spModuleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSessionNumber() {
		return _sessionNumber;
	}

	@Override
	public void setSessionNumber(String sessionNumber) {
		_sessionNumber = sessionNumber;

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setSessionNumber", String.class);

				method.invoke(_scheduleRemoteModel, sessionNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_scheduleRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSessionType() {
		return _sessionType;
	}

	@Override
	public void setSessionType(long sessionType) {
		_sessionType = sessionType;

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setSessionType", long.class);

				method.invoke(_scheduleRemoteModel, sessionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSessionDuration() {
		return _sessionDuration;
	}

	@Override
	public void setSessionDuration(String sessionDuration) {
		_sessionDuration = sessionDuration;

		if (_scheduleRemoteModel != null) {
			try {
				Class<?> clazz = _scheduleRemoteModel.getClass();

				Method method = clazz.getMethod("setSessionDuration",
						String.class);

				method.invoke(_scheduleRemoteModel, sessionDuration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getScheduleRemoteModel() {
		return _scheduleRemoteModel;
	}

	public void setScheduleRemoteModel(BaseModel<?> scheduleRemoteModel) {
		_scheduleRemoteModel = scheduleRemoteModel;
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

		Class<?> remoteModelClass = _scheduleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_scheduleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ScheduleLocalServiceUtil.addSchedule(this);
		}
		else {
			ScheduleLocalServiceUtil.updateSchedule(this);
		}
	}

	@Override
	public Schedule toEscapedModel() {
		return (Schedule)ProxyUtil.newProxyInstance(Schedule.class.getClassLoader(),
			new Class[] { Schedule.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ScheduleClp clone = new ScheduleClp();

		clone.setSpScheduleId(getSpScheduleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpModuleId(getSpModuleId());
		clone.setSessionNumber(getSessionNumber());
		clone.setDescription(getDescription());
		clone.setSessionType(getSessionType());
		clone.setSessionDuration(getSessionDuration());

		return clone;
	}

	@Override
	public int compareTo(Schedule schedule) {
		int value = 0;

		if (getSpScheduleId() < schedule.getSpScheduleId()) {
			value = -1;
		}
		else if (getSpScheduleId() > schedule.getSpScheduleId()) {
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

		if (!(obj instanceof ScheduleClp)) {
			return false;
		}

		ScheduleClp schedule = (ScheduleClp)obj;

		long primaryKey = schedule.getPrimaryKey();

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

		sb.append("{spScheduleId=");
		sb.append(getSpScheduleId());
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
		sb.append(", sessionNumber=");
		sb.append(getSessionNumber());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", sessionType=");
		sb.append(getSessionType());
		sb.append(", sessionDuration=");
		sb.append(getSessionDuration());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(40);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Schedule");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spScheduleId</column-name><column-value><![CDATA[");
		sb.append(getSpScheduleId());
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
			"<column><column-name>sessionNumber</column-name><column-value><![CDATA[");
		sb.append(getSessionNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionType</column-name><column-value><![CDATA[");
		sb.append(getSessionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sessionDuration</column-name><column-value><![CDATA[");
		sb.append(getSessionDuration());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spScheduleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private String _sessionNumber;
	private String _description;
	private long _sessionType;
	private String _sessionDuration;
	private BaseModel<?> _scheduleRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}