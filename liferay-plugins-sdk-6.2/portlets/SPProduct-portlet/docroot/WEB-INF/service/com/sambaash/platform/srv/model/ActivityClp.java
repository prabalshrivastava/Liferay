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

import com.sambaash.platform.srv.service.ActivityLocalServiceUtil;
import com.sambaash.platform.srv.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ActivityClp extends BaseModelImpl<Activity> implements Activity {
	public ActivityClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Activity.class;
	}

	@Override
	public String getModelClassName() {
		return Activity.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spActivityId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpActivityId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spActivityId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spActivityId", getSpActivityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("spScheduleId", getSpScheduleId());
		attributes.put("description", getDescription());
		attributes.put("activityTiming", getActivityTiming());
		attributes.put("activityPerformer", getActivityPerformer());
		attributes.put("activityDuration", getActivityDuration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spActivityId = (Long)attributes.get("spActivityId");

		if (spActivityId != null) {
			setSpActivityId(spActivityId);
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

		Long spScheduleId = (Long)attributes.get("spScheduleId");

		if (spScheduleId != null) {
			setSpScheduleId(spScheduleId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String activityTiming = (String)attributes.get("activityTiming");

		if (activityTiming != null) {
			setActivityTiming(activityTiming);
		}

		String activityPerformer = (String)attributes.get("activityPerformer");

		if (activityPerformer != null) {
			setActivityPerformer(activityPerformer);
		}

		String activityDuration = (String)attributes.get("activityDuration");

		if (activityDuration != null) {
			setActivityDuration(activityDuration);
		}
	}

	@Override
	public long getSpActivityId() {
		return _spActivityId;
	}

	@Override
	public void setSpActivityId(long spActivityId) {
		_spActivityId = spActivityId;

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setSpActivityId", long.class);

				method.invoke(_activityRemoteModel, spActivityId);
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

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_activityRemoteModel, groupId);
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

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_activityRemoteModel, companyId);
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

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_activityRemoteModel, userId);
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

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_activityRemoteModel, userName);
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

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_activityRemoteModel, createDate);
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

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_activityRemoteModel, modifiedDate);
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

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setSpModuleId", long.class);

				method.invoke(_activityRemoteModel, spModuleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpScheduleId() {
		return _spScheduleId;
	}

	@Override
	public void setSpScheduleId(long spScheduleId) {
		_spScheduleId = spScheduleId;

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setSpScheduleId", long.class);

				method.invoke(_activityRemoteModel, spScheduleId);
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

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_activityRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActivityTiming() {
		return _activityTiming;
	}

	@Override
	public void setActivityTiming(String activityTiming) {
		_activityTiming = activityTiming;

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityTiming",
						String.class);

				method.invoke(_activityRemoteModel, activityTiming);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActivityPerformer() {
		return _activityPerformer;
	}

	@Override
	public void setActivityPerformer(String activityPerformer) {
		_activityPerformer = activityPerformer;

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityPerformer",
						String.class);

				method.invoke(_activityRemoteModel, activityPerformer);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActivityDuration() {
		return _activityDuration;
	}

	@Override
	public void setActivityDuration(String activityDuration) {
		_activityDuration = activityDuration;

		if (_activityRemoteModel != null) {
			try {
				Class<?> clazz = _activityRemoteModel.getClass();

				Method method = clazz.getMethod("setActivityDuration",
						String.class);

				method.invoke(_activityRemoteModel, activityDuration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getActivityRemoteModel() {
		return _activityRemoteModel;
	}

	public void setActivityRemoteModel(BaseModel<?> activityRemoteModel) {
		_activityRemoteModel = activityRemoteModel;
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

		Class<?> remoteModelClass = _activityRemoteModel.getClass();

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

		Object returnValue = method.invoke(_activityRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ActivityLocalServiceUtil.addActivity(this);
		}
		else {
			ActivityLocalServiceUtil.updateActivity(this);
		}
	}

	@Override
	public Activity toEscapedModel() {
		return (Activity)ProxyUtil.newProxyInstance(Activity.class.getClassLoader(),
			new Class[] { Activity.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ActivityClp clone = new ActivityClp();

		clone.setSpActivityId(getSpActivityId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpModuleId(getSpModuleId());
		clone.setSpScheduleId(getSpScheduleId());
		clone.setDescription(getDescription());
		clone.setActivityTiming(getActivityTiming());
		clone.setActivityPerformer(getActivityPerformer());
		clone.setActivityDuration(getActivityDuration());

		return clone;
	}

	@Override
	public int compareTo(Activity activity) {
		int value = 0;

		if (getSpActivityId() < activity.getSpActivityId()) {
			value = -1;
		}
		else if (getSpActivityId() > activity.getSpActivityId()) {
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

		if (!(obj instanceof ActivityClp)) {
			return false;
		}

		ActivityClp activity = (ActivityClp)obj;

		long primaryKey = activity.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{spActivityId=");
		sb.append(getSpActivityId());
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
		sb.append(", spScheduleId=");
		sb.append(getSpScheduleId());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", activityTiming=");
		sb.append(getActivityTiming());
		sb.append(", activityPerformer=");
		sb.append(getActivityPerformer());
		sb.append(", activityDuration=");
		sb.append(getActivityDuration());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Activity");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spActivityId</column-name><column-value><![CDATA[");
		sb.append(getSpActivityId());
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
			"<column><column-name>spScheduleId</column-name><column-value><![CDATA[");
		sb.append(getSpScheduleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityTiming</column-name><column-value><![CDATA[");
		sb.append(getActivityTiming());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityPerformer</column-name><column-value><![CDATA[");
		sb.append(getActivityPerformer());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activityDuration</column-name><column-value><![CDATA[");
		sb.append(getActivityDuration());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spActivityId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spModuleId;
	private long _spScheduleId;
	private String _description;
	private String _activityTiming;
	private String _activityPerformer;
	private String _activityDuration;
	private BaseModel<?> _activityRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}