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
import com.sambaash.platform.srv.service.CourseCareerLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class CourseCareerClp extends BaseModelImpl<CourseCareer>
	implements CourseCareer {
	public CourseCareerClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CourseCareer.class;
	}

	@Override
	public String getModelClassName() {
		return CourseCareer.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCourseCareerId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCourseCareerId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCourseCareerId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseCareerId", getSpCourseCareerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("intro", getIntro());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseCareerId = (Long)attributes.get("spCourseCareerId");

		if (spCourseCareerId != null) {
			setSpCourseCareerId(spCourseCareerId);
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

		String intro = (String)attributes.get("intro");

		if (intro != null) {
			setIntro(intro);
		}
	}

	@Override
	public long getSpCourseCareerId() {
		return _spCourseCareerId;
	}

	@Override
	public void setSpCourseCareerId(long spCourseCareerId) {
		_spCourseCareerId = spCourseCareerId;

		if (_courseCareerRemoteModel != null) {
			try {
				Class<?> clazz = _courseCareerRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseCareerId",
						long.class);

				method.invoke(_courseCareerRemoteModel, spCourseCareerId);
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

		if (_courseCareerRemoteModel != null) {
			try {
				Class<?> clazz = _courseCareerRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_courseCareerRemoteModel, groupId);
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

		if (_courseCareerRemoteModel != null) {
			try {
				Class<?> clazz = _courseCareerRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_courseCareerRemoteModel, companyId);
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

		if (_courseCareerRemoteModel != null) {
			try {
				Class<?> clazz = _courseCareerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_courseCareerRemoteModel, userId);
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

		if (_courseCareerRemoteModel != null) {
			try {
				Class<?> clazz = _courseCareerRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_courseCareerRemoteModel, userName);
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

		if (_courseCareerRemoteModel != null) {
			try {
				Class<?> clazz = _courseCareerRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_courseCareerRemoteModel, createDate);
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

		if (_courseCareerRemoteModel != null) {
			try {
				Class<?> clazz = _courseCareerRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_courseCareerRemoteModel, modifiedDate);
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

		if (_courseCareerRemoteModel != null) {
			try {
				Class<?> clazz = _courseCareerRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_courseCareerRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIntro() {
		return _intro;
	}

	@Override
	public void setIntro(String intro) {
		_intro = intro;

		if (_courseCareerRemoteModel != null) {
			try {
				Class<?> clazz = _courseCareerRemoteModel.getClass();

				Method method = clazz.getMethod("setIntro", String.class);

				method.invoke(_courseCareerRemoteModel, intro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCourseCareerRemoteModel() {
		return _courseCareerRemoteModel;
	}

	public void setCourseCareerRemoteModel(BaseModel<?> courseCareerRemoteModel) {
		_courseCareerRemoteModel = courseCareerRemoteModel;
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

		Class<?> remoteModelClass = _courseCareerRemoteModel.getClass();

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

		Object returnValue = method.invoke(_courseCareerRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseCareerLocalServiceUtil.addCourseCareer(this);
		}
		else {
			CourseCareerLocalServiceUtil.updateCourseCareer(this);
		}
	}

	@Override
	public CourseCareer toEscapedModel() {
		return (CourseCareer)ProxyUtil.newProxyInstance(CourseCareer.class.getClassLoader(),
			new Class[] { CourseCareer.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseCareerClp clone = new CourseCareerClp();

		clone.setSpCourseCareerId(getSpCourseCareerId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpCourseId(getSpCourseId());
		clone.setIntro(getIntro());

		return clone;
	}

	@Override
	public int compareTo(CourseCareer courseCareer) {
		long primaryKey = courseCareer.getPrimaryKey();

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

		if (!(obj instanceof CourseCareerClp)) {
			return false;
		}

		CourseCareerClp courseCareer = (CourseCareerClp)obj;

		long primaryKey = courseCareer.getPrimaryKey();

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
		StringBundler sb = new StringBundler(19);

		sb.append("{spCourseCareerId=");
		sb.append(getSpCourseCareerId());
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
		sb.append(", intro=");
		sb.append(getIntro());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.CourseCareer");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCourseCareerId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseCareerId());
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
			"<column><column-name>intro</column-name><column-value><![CDATA[");
		sb.append(getIntro());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spCourseCareerId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseId;
	private String _intro;
	private BaseModel<?> _courseCareerRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}