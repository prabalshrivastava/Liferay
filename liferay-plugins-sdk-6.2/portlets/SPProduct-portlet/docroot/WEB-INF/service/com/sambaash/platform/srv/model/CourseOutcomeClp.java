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
import com.sambaash.platform.srv.service.CourseOutcomeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class CourseOutcomeClp extends BaseModelImpl<CourseOutcome>
	implements CourseOutcome {
	public CourseOutcomeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CourseOutcome.class;
	}

	@Override
	public String getModelClassName() {
		return CourseOutcome.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCourseOutcomeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCourseOutcomeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCourseOutcomeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseOutcomeId", getSpCourseOutcomeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("outcomeId", getOutcomeId());
		attributes.put("outcomeDesc", getOutcomeDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseOutcomeId = (Long)attributes.get("spCourseOutcomeId");

		if (spCourseOutcomeId != null) {
			setSpCourseOutcomeId(spCourseOutcomeId);
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

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}

		Long outcomeId = (Long)attributes.get("outcomeId");

		if (outcomeId != null) {
			setOutcomeId(outcomeId);
		}

		String outcomeDesc = (String)attributes.get("outcomeDesc");

		if (outcomeDesc != null) {
			setOutcomeDesc(outcomeDesc);
		}
	}

	@Override
	public long getSpCourseOutcomeId() {
		return _spCourseOutcomeId;
	}

	@Override
	public void setSpCourseOutcomeId(long spCourseOutcomeId) {
		_spCourseOutcomeId = spCourseOutcomeId;

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseOutcomeId",
						long.class);

				method.invoke(_courseOutcomeRemoteModel, spCourseOutcomeId);
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

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_courseOutcomeRemoteModel, groupId);
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

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_courseOutcomeRemoteModel, companyId);
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

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_courseOutcomeRemoteModel, userId);
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

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_courseOutcomeRemoteModel, userName);
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

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_courseOutcomeRemoteModel, createDate);
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

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_courseOutcomeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_courseOutcomeRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOutcomeId() {
		return _outcomeId;
	}

	@Override
	public void setOutcomeId(long outcomeId) {
		_outcomeId = outcomeId;

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setOutcomeId", long.class);

				method.invoke(_courseOutcomeRemoteModel, outcomeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOutcomeDesc() {
		return _outcomeDesc;
	}

	@Override
	public void setOutcomeDesc(String outcomeDesc) {
		_outcomeDesc = outcomeDesc;

		if (_courseOutcomeRemoteModel != null) {
			try {
				Class<?> clazz = _courseOutcomeRemoteModel.getClass();

				Method method = clazz.getMethod("setOutcomeDesc", String.class);

				method.invoke(_courseOutcomeRemoteModel, outcomeDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCourseOutcomeRemoteModel() {
		return _courseOutcomeRemoteModel;
	}

	public void setCourseOutcomeRemoteModel(
		BaseModel<?> courseOutcomeRemoteModel) {
		_courseOutcomeRemoteModel = courseOutcomeRemoteModel;
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

		Class<?> remoteModelClass = _courseOutcomeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_courseOutcomeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseOutcomeLocalServiceUtil.addCourseOutcome(this);
		}
		else {
			CourseOutcomeLocalServiceUtil.updateCourseOutcome(this);
		}
	}

	@Override
	public CourseOutcome toEscapedModel() {
		return (CourseOutcome)ProxyUtil.newProxyInstance(CourseOutcome.class.getClassLoader(),
			new Class[] { CourseOutcome.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseOutcomeClp clone = new CourseOutcomeClp();

		clone.setSpCourseOutcomeId(getSpCourseOutcomeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpCourseId(getSpCourseId());
		clone.setOutcomeId(getOutcomeId());
		clone.setOutcomeDesc(getOutcomeDesc());

		return clone;
	}

	@Override
	public int compareTo(CourseOutcome courseOutcome) {
		int value = 0;

		if (getSpCourseId() < courseOutcome.getSpCourseId()) {
			value = -1;
		}
		else if (getSpCourseId() > courseOutcome.getSpCourseId()) {
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

		if (!(obj instanceof CourseOutcomeClp)) {
			return false;
		}

		CourseOutcomeClp courseOutcome = (CourseOutcomeClp)obj;

		long primaryKey = courseOutcome.getPrimaryKey();

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

		sb.append("{spCourseOutcomeId=");
		sb.append(getSpCourseOutcomeId());
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
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append(", outcomeId=");
		sb.append(getOutcomeId());
		sb.append(", outcomeDesc=");
		sb.append(getOutcomeDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.CourseOutcome");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCourseOutcomeId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseOutcomeId());
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
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outcomeId</column-name><column-value><![CDATA[");
		sb.append(getOutcomeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>outcomeDesc</column-name><column-value><![CDATA[");
		sb.append(getOutcomeDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spCourseOutcomeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseId;
	private long _outcomeId;
	private String _outcomeDesc;
	private BaseModel<?> _courseOutcomeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}