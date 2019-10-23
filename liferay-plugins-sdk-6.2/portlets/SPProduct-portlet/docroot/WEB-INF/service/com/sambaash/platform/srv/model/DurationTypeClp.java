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
import com.sambaash.platform.srv.service.DurationTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class DurationTypeClp extends BaseModelImpl<DurationType>
	implements DurationType {
	public DurationTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return DurationType.class;
	}

	@Override
	public String getModelClassName() {
		return DurationType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spDurationTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpDurationTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spDurationTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spDurationTypeId", getSpDurationTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spLearningDurationId", getSpLearningDurationId());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("title1", getTitle1());
		attributes.put("duration1", getDuration1());
		attributes.put("title2", getTitle2());
		attributes.put("duration2", getDuration2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spDurationTypeId = (Long)attributes.get("spDurationTypeId");

		if (spDurationTypeId != null) {
			setSpDurationTypeId(spDurationTypeId);
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

		Long spLearningDurationId = (Long)attributes.get("spLearningDurationId");

		if (spLearningDurationId != null) {
			setSpLearningDurationId(spLearningDurationId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}

		String title1 = (String)attributes.get("title1");

		if (title1 != null) {
			setTitle1(title1);
		}

		Long duration1 = (Long)attributes.get("duration1");

		if (duration1 != null) {
			setDuration1(duration1);
		}

		String title2 = (String)attributes.get("title2");

		if (title2 != null) {
			setTitle2(title2);
		}

		Long duration2 = (Long)attributes.get("duration2");

		if (duration2 != null) {
			setDuration2(duration2);
		}
	}

	@Override
	public long getSpDurationTypeId() {
		return _spDurationTypeId;
	}

	@Override
	public void setSpDurationTypeId(long spDurationTypeId) {
		_spDurationTypeId = spDurationTypeId;

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpDurationTypeId",
						long.class);

				method.invoke(_durationTypeRemoteModel, spDurationTypeId);
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

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_durationTypeRemoteModel, groupId);
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

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_durationTypeRemoteModel, companyId);
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

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_durationTypeRemoteModel, userId);
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

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_durationTypeRemoteModel, userName);
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

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_durationTypeRemoteModel, createDate);
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

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_durationTypeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpLearningDurationId() {
		return _spLearningDurationId;
	}

	@Override
	public void setSpLearningDurationId(long spLearningDurationId) {
		_spLearningDurationId = spLearningDurationId;

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpLearningDurationId",
						long.class);

				method.invoke(_durationTypeRemoteModel, spLearningDurationId);
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

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_durationTypeRemoteModel, spCourseId);
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

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle1", String.class);

				method.invoke(_durationTypeRemoteModel, title1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDuration1() {
		return _duration1;
	}

	@Override
	public void setDuration1(long duration1) {
		_duration1 = duration1;

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration1", long.class);

				method.invoke(_durationTypeRemoteModel, duration1);
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

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle2", String.class);

				method.invoke(_durationTypeRemoteModel, title2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDuration2() {
		return _duration2;
	}

	@Override
	public void setDuration2(long duration2) {
		_duration2 = duration2;

		if (_durationTypeRemoteModel != null) {
			try {
				Class<?> clazz = _durationTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration2", long.class);

				method.invoke(_durationTypeRemoteModel, duration2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getDurationTypeRemoteModel() {
		return _durationTypeRemoteModel;
	}

	public void setDurationTypeRemoteModel(BaseModel<?> durationTypeRemoteModel) {
		_durationTypeRemoteModel = durationTypeRemoteModel;
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

		Class<?> remoteModelClass = _durationTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_durationTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			DurationTypeLocalServiceUtil.addDurationType(this);
		}
		else {
			DurationTypeLocalServiceUtil.updateDurationType(this);
		}
	}

	@Override
	public DurationType toEscapedModel() {
		return (DurationType)ProxyUtil.newProxyInstance(DurationType.class.getClassLoader(),
			new Class[] { DurationType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		DurationTypeClp clone = new DurationTypeClp();

		clone.setSpDurationTypeId(getSpDurationTypeId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpLearningDurationId(getSpLearningDurationId());
		clone.setSpCourseId(getSpCourseId());
		clone.setTitle1(getTitle1());
		clone.setDuration1(getDuration1());
		clone.setTitle2(getTitle2());
		clone.setDuration2(getDuration2());

		return clone;
	}

	@Override
	public int compareTo(DurationType durationType) {
		long primaryKey = durationType.getPrimaryKey();

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

		if (!(obj instanceof DurationTypeClp)) {
			return false;
		}

		DurationTypeClp durationType = (DurationTypeClp)obj;

		long primaryKey = durationType.getPrimaryKey();

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

		sb.append("{spDurationTypeId=");
		sb.append(getSpDurationTypeId());
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
		sb.append(", spLearningDurationId=");
		sb.append(getSpLearningDurationId());
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
		sb.append("com.sambaash.platform.srv.model.DurationType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spDurationTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpDurationTypeId());
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
			"<column><column-name>spLearningDurationId</column-name><column-value><![CDATA[");
		sb.append(getSpLearningDurationId());
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

	private long _spDurationTypeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spLearningDurationId;
	private long _spCourseId;
	private String _title1;
	private long _duration1;
	private String _title2;
	private long _duration2;
	private BaseModel<?> _durationTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}