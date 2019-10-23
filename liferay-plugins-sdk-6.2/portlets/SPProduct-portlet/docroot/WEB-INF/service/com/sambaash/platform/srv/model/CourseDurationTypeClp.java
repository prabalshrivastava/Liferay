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
import com.sambaash.platform.srv.service.CourseDurationTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class CourseDurationTypeClp extends BaseModelImpl<CourseDurationType>
	implements CourseDurationType {
	public CourseDurationTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CourseDurationType.class;
	}

	@Override
	public String getModelClassName() {
		return CourseDurationType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCourseDurationTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCourseDurationTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCourseDurationTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseDurationTypeId", getSpCourseDurationTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseDurationId", getSpCourseDurationId());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("title1", getTitle1());
		attributes.put("duration1", getDuration1());
		attributes.put("title2", getTitle2());
		attributes.put("duration2", getDuration2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseDurationTypeId = (Long)attributes.get(
				"spCourseDurationTypeId");

		if (spCourseDurationTypeId != null) {
			setSpCourseDurationTypeId(spCourseDurationTypeId);
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

		Long spCourseDurationId = (Long)attributes.get("spCourseDurationId");

		if (spCourseDurationId != null) {
			setSpCourseDurationId(spCourseDurationId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}

		String title1 = (String)attributes.get("title1");

		if (title1 != null) {
			setTitle1(title1);
		}

		String duration1 = (String)attributes.get("duration1");

		if (duration1 != null) {
			setDuration1(duration1);
		}

		String title2 = (String)attributes.get("title2");

		if (title2 != null) {
			setTitle2(title2);
		}

		String duration2 = (String)attributes.get("duration2");

		if (duration2 != null) {
			setDuration2(duration2);
		}
	}

	@Override
	public long getSpCourseDurationTypeId() {
		return _spCourseDurationTypeId;
	}

	@Override
	public void setSpCourseDurationTypeId(long spCourseDurationTypeId) {
		_spCourseDurationTypeId = spCourseDurationTypeId;

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseDurationTypeId",
						long.class);

				method.invoke(_courseDurationTypeRemoteModel,
					spCourseDurationTypeId);
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

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_courseDurationTypeRemoteModel, groupId);
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

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_courseDurationTypeRemoteModel, companyId);
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

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_courseDurationTypeRemoteModel, userId);
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

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_courseDurationTypeRemoteModel, userName);
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

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_courseDurationTypeRemoteModel, createDate);
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

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_courseDurationTypeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCourseDurationId() {
		return _spCourseDurationId;
	}

	@Override
	public void setSpCourseDurationId(long spCourseDurationId) {
		_spCourseDurationId = spCourseDurationId;

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseDurationId",
						long.class);

				method.invoke(_courseDurationTypeRemoteModel, spCourseDurationId);
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

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_courseDurationTypeRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle1() {
		return _title1;
	}

	@Override
	public void setTitle1(String title1) {
		_title1 = title1;

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle1", String.class);

				method.invoke(_courseDurationTypeRemoteModel, title1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuration1() {
		return _duration1;
	}

	@Override
	public void setDuration1(String duration1) {
		_duration1 = duration1;

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration1", String.class);

				method.invoke(_courseDurationTypeRemoteModel, duration1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle2() {
		return _title2;
	}

	@Override
	public void setTitle2(String title2) {
		_title2 = title2;

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle2", String.class);

				method.invoke(_courseDurationTypeRemoteModel, title2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuration2() {
		return _duration2;
	}

	@Override
	public void setDuration2(String duration2) {
		_duration2 = duration2;

		if (_courseDurationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _courseDurationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration2", String.class);

				method.invoke(_courseDurationTypeRemoteModel, duration2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCourseDurationTypeRemoteModel() {
		return _courseDurationTypeRemoteModel;
	}

	public void setCourseDurationTypeRemoteModel(
		BaseModel<?> courseDurationTypeRemoteModel) {
		_courseDurationTypeRemoteModel = courseDurationTypeRemoteModel;
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

		Class<?> remoteModelClass = _courseDurationTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_courseDurationTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseDurationTypeLocalServiceUtil.addCourseDurationType(this);
		}
		else {
			CourseDurationTypeLocalServiceUtil.updateCourseDurationType(this);
		}
	}

	@Override
	public CourseDurationType toEscapedModel() {
		return (CourseDurationType)ProxyUtil.newProxyInstance(CourseDurationType.class.getClassLoader(),
			new Class[] { CourseDurationType.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseDurationTypeClp clone = new CourseDurationTypeClp();

		clone.setSpCourseDurationTypeId(getSpCourseDurationTypeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpCourseDurationId(getSpCourseDurationId());
		clone.setSpCourseId(getSpCourseId());
		clone.setTitle1(getTitle1());
		clone.setDuration1(getDuration1());
		clone.setTitle2(getTitle2());
		clone.setDuration2(getDuration2());

		return clone;
	}

	@Override
	public int compareTo(CourseDurationType courseDurationType) {
		long primaryKey = courseDurationType.getPrimaryKey();

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

		if (!(obj instanceof CourseDurationTypeClp)) {
			return false;
		}

		CourseDurationTypeClp courseDurationType = (CourseDurationTypeClp)obj;

		long primaryKey = courseDurationType.getPrimaryKey();

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

		sb.append("{spCourseDurationTypeId=");
		sb.append(getSpCourseDurationTypeId());
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
		sb.append(", spCourseDurationId=");
		sb.append(getSpCourseDurationId());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append(", title1=");
		sb.append(getTitle1());
		sb.append(", duration1=");
		sb.append(getDuration1());
		sb.append(", title2=");
		sb.append(getTitle2());
		sb.append(", duration2=");
		sb.append(getDuration2());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.CourseDurationType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCourseDurationTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseDurationTypeId());
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
			"<column><column-name>spCourseDurationId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseDurationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title1</column-name><column-value><![CDATA[");
		sb.append(getTitle1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration1</column-name><column-value><![CDATA[");
		sb.append(getDuration1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title2</column-name><column-value><![CDATA[");
		sb.append(getTitle2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration2</column-name><column-value><![CDATA[");
		sb.append(getDuration2());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spCourseDurationTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseDurationId;
	private long _spCourseId;
	private String _title1;
	private String _duration1;
	private String _title2;
	private String _duration2;
	private BaseModel<?> _courseDurationTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}