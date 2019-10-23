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
import com.sambaash.platform.srv.service.ProgressionPathLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ProgressionPathClp extends BaseModelImpl<ProgressionPath>
	implements ProgressionPath {
	public ProgressionPathClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return ProgressionPath.class;
	}

	@Override
	public String getModelClassName() {
		return ProgressionPath.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spProgressionPathId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpProgressionPathId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spProgressionPathId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spProgressionPathId", getSpProgressionPathId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("careerLevel", getCareerLevel());
		attributes.put("level", getLevel());
		attributes.put("progressionType", getProgressionType());
		attributes.put("progressionCategory", getProgressionCategory());
		attributes.put("startMonth", getStartMonth());
		attributes.put("endMonth", getEndMonth());
		attributes.put("duration", getDuration());
		attributes.put("optionalMandatory", getOptionalMandatory());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spProgressionPathId = (Long)attributes.get("spProgressionPathId");

		if (spProgressionPathId != null) {
			setSpProgressionPathId(spProgressionPathId);
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

		Long careerLevel = (Long)attributes.get("careerLevel");

		if (careerLevel != null) {
			setCareerLevel(careerLevel);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long progressionType = (Long)attributes.get("progressionType");

		if (progressionType != null) {
			setProgressionType(progressionType);
		}

		Long progressionCategory = (Long)attributes.get("progressionCategory");

		if (progressionCategory != null) {
			setProgressionCategory(progressionCategory);
		}

		String startMonth = (String)attributes.get("startMonth");

		if (startMonth != null) {
			setStartMonth(startMonth);
		}

		String endMonth = (String)attributes.get("endMonth");

		if (endMonth != null) {
			setEndMonth(endMonth);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String optionalMandatory = (String)attributes.get("optionalMandatory");

		if (optionalMandatory != null) {
			setOptionalMandatory(optionalMandatory);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	@Override
	public long getSpProgressionPathId() {
		return _spProgressionPathId;
	}

	@Override
	public void setSpProgressionPathId(long spProgressionPathId) {
		_spProgressionPathId = spProgressionPathId;

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setSpProgressionPathId",
						long.class);

				method.invoke(_progressionPathRemoteModel, spProgressionPathId);
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

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_progressionPathRemoteModel, groupId);
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

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_progressionPathRemoteModel, companyId);
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

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_progressionPathRemoteModel, userId);
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

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_progressionPathRemoteModel, userName);
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

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_progressionPathRemoteModel, createDate);
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

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_progressionPathRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCareerLevel() {
		return _careerLevel;
	}

	@Override
	public void setCareerLevel(long careerLevel) {
		_careerLevel = careerLevel;

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setCareerLevel", long.class);

				method.invoke(_progressionPathRemoteModel, careerLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLevel() {
		return _level;
	}

	@Override
	public void setLevel(int level) {
		_level = level;

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel", int.class);

				method.invoke(_progressionPathRemoteModel, level);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProgressionType() {
		return _progressionType;
	}

	@Override
	public void setProgressionType(long progressionType) {
		_progressionType = progressionType;

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressionType", long.class);

				method.invoke(_progressionPathRemoteModel, progressionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProgressionCategory() {
		return _progressionCategory;
	}

	@Override
	public void setProgressionCategory(long progressionCategory) {
		_progressionCategory = progressionCategory;

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressionCategory",
						long.class);

				method.invoke(_progressionPathRemoteModel, progressionCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStartMonth() {
		return _startMonth;
	}

	@Override
	public void setStartMonth(String startMonth) {
		_startMonth = startMonth;

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setStartMonth", String.class);

				method.invoke(_progressionPathRemoteModel, startMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEndMonth() {
		return _endMonth;
	}

	@Override
	public void setEndMonth(String endMonth) {
		_endMonth = endMonth;

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setEndMonth", String.class);

				method.invoke(_progressionPathRemoteModel, endMonth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDuration() {
		return _duration;
	}

	@Override
	public void setDuration(String duration) {
		_duration = duration;

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setDuration", String.class);

				method.invoke(_progressionPathRemoteModel, duration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionalMandatory() {
		return _optionalMandatory;
	}

	@Override
	public void setOptionalMandatory(String optionalMandatory) {
		_optionalMandatory = optionalMandatory;

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionalMandatory",
						String.class);

				method.invoke(_progressionPathRemoteModel, optionalMandatory);
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

		if (_progressionPathRemoteModel != null) {
			try {
				Class<?> clazz = _progressionPathRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_progressionPathRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getProgressionPathRemoteModel() {
		return _progressionPathRemoteModel;
	}

	public void setProgressionPathRemoteModel(
		BaseModel<?> progressionPathRemoteModel) {
		_progressionPathRemoteModel = progressionPathRemoteModel;
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

		Class<?> remoteModelClass = _progressionPathRemoteModel.getClass();

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

		Object returnValue = method.invoke(_progressionPathRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ProgressionPathLocalServiceUtil.addProgressionPath(this);
		}
		else {
			ProgressionPathLocalServiceUtil.updateProgressionPath(this);
		}
	}

	@Override
	public ProgressionPath toEscapedModel() {
		return (ProgressionPath)ProxyUtil.newProxyInstance(ProgressionPath.class.getClassLoader(),
			new Class[] { ProgressionPath.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ProgressionPathClp clone = new ProgressionPathClp();

		clone.setSpProgressionPathId(getSpProgressionPathId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCareerLevel(getCareerLevel());
		clone.setLevel(getLevel());
		clone.setProgressionType(getProgressionType());
		clone.setProgressionCategory(getProgressionCategory());
		clone.setStartMonth(getStartMonth());
		clone.setEndMonth(getEndMonth());
		clone.setDuration(getDuration());
		clone.setOptionalMandatory(getOptionalMandatory());
		clone.setSpCourseId(getSpCourseId());

		return clone;
	}

	@Override
	public int compareTo(ProgressionPath progressionPath) {
		int value = 0;

		if (getSpCourseId() < progressionPath.getSpCourseId()) {
			value = -1;
		}
		else if (getSpCourseId() > progressionPath.getSpCourseId()) {
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

		if (!(obj instanceof ProgressionPathClp)) {
			return false;
		}

		ProgressionPathClp progressionPath = (ProgressionPathClp)obj;

		long primaryKey = progressionPath.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{spProgressionPathId=");
		sb.append(getSpProgressionPathId());
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
		sb.append(", careerLevel=");
		sb.append(getCareerLevel());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append(", progressionType=");
		sb.append(getProgressionType());
		sb.append(", progressionCategory=");
		sb.append(getProgressionCategory());
		sb.append(", startMonth=");
		sb.append(getStartMonth());
		sb.append(", endMonth=");
		sb.append(getEndMonth());
		sb.append(", duration=");
		sb.append(getDuration());
		sb.append(", optionalMandatory=");
		sb.append(getOptionalMandatory());
		sb.append(", spCourseId=");
		sb.append(getSpCourseId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.ProgressionPath");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spProgressionPathId</column-name><column-value><![CDATA[");
		sb.append(getSpProgressionPathId());
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
			"<column><column-name>careerLevel</column-name><column-value><![CDATA[");
		sb.append(getCareerLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progressionType</column-name><column-value><![CDATA[");
		sb.append(getProgressionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progressionCategory</column-name><column-value><![CDATA[");
		sb.append(getProgressionCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>startMonth</column-name><column-value><![CDATA[");
		sb.append(getStartMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>endMonth</column-name><column-value><![CDATA[");
		sb.append(getEndMonth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>duration</column-name><column-value><![CDATA[");
		sb.append(getDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>optionalMandatory</column-name><column-value><![CDATA[");
		sb.append(getOptionalMandatory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spProgressionPathId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _careerLevel;
	private int _level;
	private long _progressionType;
	private long _progressionCategory;
	private String _startMonth;
	private String _endMonth;
	private String _duration;
	private String _optionalMandatory;
	private long _spCourseId;
	private BaseModel<?> _progressionPathRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}