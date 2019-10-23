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

package com.sambaash.platform.srv.spsocialprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer;
import com.sambaash.platform.srv.spsocialprofile.service.UserAvailabilityCalendarLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class UserAvailabilityCalendarClp extends BaseModelImpl<UserAvailabilityCalendar>
	implements UserAvailabilityCalendar {
	public UserAvailabilityCalendarClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return UserAvailabilityCalendar.class;
	}

	@Override
	public String getModelClassName() {
		return UserAvailabilityCalendar.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userAvailabilityCalendarId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserAvailabilityCalendarId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userAvailabilityCalendarId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userAvailabilityCalendarId",
			getUserAvailabilityCalendarId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("availableFor", getAvailableFor());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userAvailabilityCalendarId = (Long)attributes.get(
				"userAvailabilityCalendarId");

		if (userAvailabilityCalendarId != null) {
			setUserAvailabilityCalendarId(userAvailabilityCalendarId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String availableFor = (String)attributes.get("availableFor");

		if (availableFor != null) {
			setAvailableFor(availableFor);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public long getUserAvailabilityCalendarId() {
		return _userAvailabilityCalendarId;
	}

	@Override
	public void setUserAvailabilityCalendarId(long userAvailabilityCalendarId) {
		_userAvailabilityCalendarId = userAvailabilityCalendarId;

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setUserAvailabilityCalendarId",
						long.class);

				method.invoke(_userAvailabilityCalendarRemoteModel,
					userAvailabilityCalendarId);
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

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_userAvailabilityCalendarRemoteModel, groupId);
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

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_userAvailabilityCalendarRemoteModel, companyId);
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

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_userAvailabilityCalendarRemoteModel, createDate);
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

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_userAvailabilityCalendarRemoteModel, modifiedDate);
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

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_userAvailabilityCalendarRemoteModel, userId);
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
	public String getAvailableFor() {
		return _availableFor;
	}

	@Override
	public void setAvailableFor(String availableFor) {
		_availableFor = availableFor;

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setAvailableFor", String.class);

				method.invoke(_userAvailabilityCalendarRemoteModel, availableFor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStartDate() {
		return _startDate;
	}

	@Override
	public void setStartDate(Date startDate) {
		_startDate = startDate;

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setStartDate", Date.class);

				method.invoke(_userAvailabilityCalendarRemoteModel, startDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEndDate() {
		return _endDate;
	}

	@Override
	public void setEndDate(Date endDate) {
		_endDate = endDate;

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setEndDate", Date.class);

				method.invoke(_userAvailabilityCalendarRemoteModel, endDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_userAvailabilityCalendarRemoteModel != null) {
			try {
				Class<?> clazz = _userAvailabilityCalendarRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_userAvailabilityCalendarRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getUserAvailabilityCalendarRemoteModel() {
		return _userAvailabilityCalendarRemoteModel;
	}

	public void setUserAvailabilityCalendarRemoteModel(
		BaseModel<?> userAvailabilityCalendarRemoteModel) {
		_userAvailabilityCalendarRemoteModel = userAvailabilityCalendarRemoteModel;
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

		Class<?> remoteModelClass = _userAvailabilityCalendarRemoteModel.getClass();

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

		Object returnValue = method.invoke(_userAvailabilityCalendarRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			UserAvailabilityCalendarLocalServiceUtil.addUserAvailabilityCalendar(this);
		}
		else {
			UserAvailabilityCalendarLocalServiceUtil.updateUserAvailabilityCalendar(this);
		}
	}

	@Override
	public UserAvailabilityCalendar toEscapedModel() {
		return (UserAvailabilityCalendar)ProxyUtil.newProxyInstance(UserAvailabilityCalendar.class.getClassLoader(),
			new Class[] { UserAvailabilityCalendar.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		UserAvailabilityCalendarClp clone = new UserAvailabilityCalendarClp();

		clone.setUserAvailabilityCalendarId(getUserAvailabilityCalendarId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserId(getUserId());
		clone.setAvailableFor(getAvailableFor());
		clone.setStartDate(getStartDate());
		clone.setEndDate(getEndDate());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(UserAvailabilityCalendar userAvailabilityCalendar) {
		long primaryKey = userAvailabilityCalendar.getPrimaryKey();

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

		if (!(obj instanceof UserAvailabilityCalendarClp)) {
			return false;
		}

		UserAvailabilityCalendarClp userAvailabilityCalendar = (UserAvailabilityCalendarClp)obj;

		long primaryKey = userAvailabilityCalendar.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{userAvailabilityCalendarId=");
		sb.append(getUserAvailabilityCalendarId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", availableFor=");
		sb.append(getAvailableFor());
		sb.append(", startDate=");
		sb.append(getStartDate());
		sb.append(", endDate=");
		sb.append(getEndDate());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>userAvailabilityCalendarId</column-name><column-value><![CDATA[");
		sb.append(getUserAvailabilityCalendarId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>availableFor</column-name><column-value><![CDATA[");
		sb.append(getAvailableFor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startDate</column-name><column-value><![CDATA[");
		sb.append(getStartDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endDate</column-name><column-value><![CDATA[");
		sb.append(getEndDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _userAvailabilityCalendarId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _userUuid;
	private String _availableFor;
	private Date _startDate;
	private Date _endDate;
	private boolean _active;
	private BaseModel<?> _userAvailabilityCalendarRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.class;
}