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
import com.sambaash.platform.srv.service.LogActivityLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aishwarya
 */
public class LogActivityClp extends BaseModelImpl<LogActivity>
	implements LogActivity {
	public LogActivityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return LogActivity.class;
	}

	@Override
	public String getModelClassName() {
		return LogActivity.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spLogActivityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpLogActivityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spLogActivityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spLogActivityId", getSpLogActivityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("entityClassName", getEntityClassName());
		attributes.put("entityId", getEntityId());
		attributes.put("savedByUserId", getSavedByUserId());
		attributes.put("activityTitle", getActivityTitle());
		attributes.put("activityType", getActivityType());
		attributes.put("activityOutcome", getActivityOutcome());
		attributes.put("activityDate", getActivityDate());
		attributes.put("activityTime", getActivityTime());
		attributes.put("activityContent", getActivityContent());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("associatedWith", getAssociatedWith());
		attributes.put("status", getStatus());
		attributes.put("parentLogActivityId", getParentLogActivityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spLogActivityId = (Long)attributes.get("spLogActivityId");

		if (spLogActivityId != null) {
			setSpLogActivityId(spLogActivityId);
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

		Long entityClassId = (Long)attributes.get("entityClassId");

		if (entityClassId != null) {
			setEntityClassId(entityClassId);
		}

		String entityClassName = (String)attributes.get("entityClassName");

		if (entityClassName != null) {
			setEntityClassName(entityClassName);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long savedByUserId = (Long)attributes.get("savedByUserId");

		if (savedByUserId != null) {
			setSavedByUserId(savedByUserId);
		}

		String activityTitle = (String)attributes.get("activityTitle");

		if (activityTitle != null) {
			setActivityTitle(activityTitle);
		}

		String activityType = (String)attributes.get("activityType");

		if (activityType != null) {
			setActivityType(activityType);
		}

		String activityOutcome = (String)attributes.get("activityOutcome");

		if (activityOutcome != null) {
			setActivityOutcome(activityOutcome);
		}

		Date activityDate = (Date)attributes.get("activityDate");

		if (activityDate != null) {
			setActivityDate(activityDate);
		}

		String activityTime = (String)attributes.get("activityTime");

		if (activityTime != null) {
			setActivityTime(activityTime);
		}

		String activityContent = (String)attributes.get("activityContent");

		if (activityContent != null) {
			setActivityContent(activityContent);
		}

		String fileEntryId = (String)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long associatedWith = (Long)attributes.get("associatedWith");

		if (associatedWith != null) {
			setAssociatedWith(associatedWith);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long parentLogActivityId = (Long)attributes.get("parentLogActivityId");

		if (parentLogActivityId != null) {
			setParentLogActivityId(parentLogActivityId);
		}
	}

	@Override
	public long getSpLogActivityId() {
		return _spLogActivityId;
	}

	@Override
	public void setSpLogActivityId(long spLogActivityId) {
		_spLogActivityId = spLogActivityId;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setSpLogActivityId", long.class);

				method.invoke(_logActivityRemoteModel, spLogActivityId);
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

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_logActivityRemoteModel, groupId);
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

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_logActivityRemoteModel, companyId);
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

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_logActivityRemoteModel, userId);
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

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_logActivityRemoteModel, userName);
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

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_logActivityRemoteModel, createDate);
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

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_logActivityRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityClassId() {
		return _entityClassId;
	}

	@Override
	public void setEntityClassId(long entityClassId) {
		_entityClassId = entityClassId;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassId", long.class);

				method.invoke(_logActivityRemoteModel, entityClassId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEntityClassName() {
		return _entityClassName;
	}

	@Override
	public void setEntityClassName(String entityClassName) {
		_entityClassName = entityClassName;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityClassName",
						String.class);

				method.invoke(_logActivityRemoteModel, entityClassName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEntityId() {
		return _entityId;
	}

	@Override
	public void setEntityId(long entityId) {
		_entityId = entityId;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setEntityId", long.class);

				method.invoke(_logActivityRemoteModel, entityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSavedByUserId() {
		return _savedByUserId;
	}

	@Override
	public void setSavedByUserId(long savedByUserId) {
		_savedByUserId = savedByUserId;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setSavedByUserId", long.class);

				method.invoke(_logActivityRemoteModel, savedByUserId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSavedByUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getSavedByUserId(), "uuid",
			_savedByUserUuid);
	}

	@Override
	public void setSavedByUserUuid(String savedByUserUuid) {
		_savedByUserUuid = savedByUserUuid;
	}

	@Override
	public String getActivityTitle() {
		return _activityTitle;
	}

	@Override
	public void setActivityTitle(String activityTitle) {
		_activityTitle = activityTitle;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityTitle", String.class);

				method.invoke(_logActivityRemoteModel, activityTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActivityType() {
		return _activityType;
	}

	@Override
	public void setActivityType(String activityType) {
		_activityType = activityType;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityType", String.class);

				method.invoke(_logActivityRemoteModel, activityType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActivityOutcome() {
		return _activityOutcome;
	}

	@Override
	public void setActivityOutcome(String activityOutcome) {
		_activityOutcome = activityOutcome;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityOutcome",
						String.class);

				method.invoke(_logActivityRemoteModel, activityOutcome);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getActivityDate() {
		return _activityDate;
	}

	@Override
	public void setActivityDate(Date activityDate) {
		_activityDate = activityDate;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityDate", Date.class);

				method.invoke(_logActivityRemoteModel, activityDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActivityTime() {
		return _activityTime;
	}

	@Override
	public void setActivityTime(String activityTime) {
		_activityTime = activityTime;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityTime", String.class);

				method.invoke(_logActivityRemoteModel, activityTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActivityContent() {
		return _activityContent;
	}

	@Override
	public void setActivityContent(String activityContent) {
		_activityContent = activityContent;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityContent",
						String.class);

				method.invoke(_logActivityRemoteModel, activityContent);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(String fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", String.class);

				method.invoke(_logActivityRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAssociatedWith() {
		return _associatedWith;
	}

	@Override
	public void setAssociatedWith(long associatedWith) {
		_associatedWith = associatedWith;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setAssociatedWith", long.class);

				method.invoke(_logActivityRemoteModel, associatedWith);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_logActivityRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentLogActivityId() {
		return _parentLogActivityId;
	}

	@Override
	public void setParentLogActivityId(long parentLogActivityId) {
		_parentLogActivityId = parentLogActivityId;

		if (_logActivityRemoteModel != null) {
			try {
				Class<?> clazz = _logActivityRemoteModel.getClass();

				Method method = clazz.getMethod("setParentLogActivityId",
						long.class);

				method.invoke(_logActivityRemoteModel, parentLogActivityId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getLogActivityRemoteModel() {
		return _logActivityRemoteModel;
	}

	public void setLogActivityRemoteModel(BaseModel<?> logActivityRemoteModel) {
		_logActivityRemoteModel = logActivityRemoteModel;
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

		Class<?> remoteModelClass = _logActivityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_logActivityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			LogActivityLocalServiceUtil.addLogActivity(this);
		}
		else {
			LogActivityLocalServiceUtil.updateLogActivity(this);
		}
	}

	@Override
	public LogActivity toEscapedModel() {
		return (LogActivity)ProxyUtil.newProxyInstance(LogActivity.class.getClassLoader(),
			new Class[] { LogActivity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		LogActivityClp clone = new LogActivityClp();

		clone.setSpLogActivityId(getSpLogActivityId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setEntityClassId(getEntityClassId());
		clone.setEntityClassName(getEntityClassName());
		clone.setEntityId(getEntityId());
		clone.setSavedByUserId(getSavedByUserId());
		clone.setActivityTitle(getActivityTitle());
		clone.setActivityType(getActivityType());
		clone.setActivityOutcome(getActivityOutcome());
		clone.setActivityDate(getActivityDate());
		clone.setActivityTime(getActivityTime());
		clone.setActivityContent(getActivityContent());
		clone.setFileEntryId(getFileEntryId());
		clone.setAssociatedWith(getAssociatedWith());
		clone.setStatus(getStatus());
		clone.setParentLogActivityId(getParentLogActivityId());

		return clone;
	}

	@Override
	public int compareTo(LogActivity logActivity) {
		long primaryKey = logActivity.getPrimaryKey();

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

		if (!(obj instanceof LogActivityClp)) {
			return false;
		}

		LogActivityClp logActivity = (LogActivityClp)obj;

		long primaryKey = logActivity.getPrimaryKey();

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
		StringBundler sb = new StringBundler(43);

		sb.append("{spLogActivityId=");
		sb.append(getSpLogActivityId());
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
		sb.append(", entityClassId=");
		sb.append(getEntityClassId());
		sb.append(", entityClassName=");
		sb.append(getEntityClassName());
		sb.append(", entityId=");
		sb.append(getEntityId());
		sb.append(", savedByUserId=");
		sb.append(getSavedByUserId());
		sb.append(", activityTitle=");
		sb.append(getActivityTitle());
		sb.append(", activityType=");
		sb.append(getActivityType());
		sb.append(", activityOutcome=");
		sb.append(getActivityOutcome());
		sb.append(", activityDate=");
		sb.append(getActivityDate());
		sb.append(", activityTime=");
		sb.append(getActivityTime());
		sb.append(", activityContent=");
		sb.append(getActivityContent());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", associatedWith=");
		sb.append(getAssociatedWith());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", parentLogActivityId=");
		sb.append(getParentLogActivityId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(67);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.LogActivity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spLogActivityId</column-name><column-value><![CDATA[");
		sb.append(getSpLogActivityId());
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
			"<column><column-name>entityClassId</column-name><column-value><![CDATA[");
		sb.append(getEntityClassId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityClassName</column-name><column-value><![CDATA[");
		sb.append(getEntityClassName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>entityId</column-name><column-value><![CDATA[");
		sb.append(getEntityId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>savedByUserId</column-name><column-value><![CDATA[");
		sb.append(getSavedByUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityTitle</column-name><column-value><![CDATA[");
		sb.append(getActivityTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityType</column-name><column-value><![CDATA[");
		sb.append(getActivityType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityOutcome</column-name><column-value><![CDATA[");
		sb.append(getActivityOutcome());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityDate</column-name><column-value><![CDATA[");
		sb.append(getActivityDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityTime</column-name><column-value><![CDATA[");
		sb.append(getActivityTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityContent</column-name><column-value><![CDATA[");
		sb.append(getActivityContent());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>associatedWith</column-name><column-value><![CDATA[");
		sb.append(getAssociatedWith());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentLogActivityId</column-name><column-value><![CDATA[");
		sb.append(getParentLogActivityId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spLogActivityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _entityClassId;
	private String _entityClassName;
	private long _entityId;
	private long _savedByUserId;
	private String _savedByUserUuid;
	private String _activityTitle;
	private String _activityType;
	private String _activityOutcome;
	private Date _activityDate;
	private String _activityTime;
	private String _activityContent;
	private String _fileEntryId;
	private long _associatedWith;
	private int _status;
	private long _parentLogActivityId;
	private BaseModel<?> _logActivityRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}