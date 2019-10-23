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
import com.sambaash.platform.srv.service.CourseLearningLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class CourseLearningClp extends BaseModelImpl<CourseLearning>
	implements CourseLearning {
	public CourseLearningClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CourseLearning.class;
	}

	@Override
	public String getModelClassName() {
		return CourseLearning.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCourseLearningId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCourseLearningId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCourseLearningId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseLearningId", getSpCourseLearningId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("intro", getIntro());
		attributes.put("optionTitle", getOptionTitle());
		attributes.put("option1", getOption1());
		attributes.put("option2", getOption2());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseLearningId = (Long)attributes.get("spCourseLearningId");

		if (spCourseLearningId != null) {
			setSpCourseLearningId(spCourseLearningId);
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

		String optionTitle = (String)attributes.get("optionTitle");

		if (optionTitle != null) {
			setOptionTitle(optionTitle);
		}

		String option1 = (String)attributes.get("option1");

		if (option1 != null) {
			setOption1(option1);
		}

		String option2 = (String)attributes.get("option2");

		if (option2 != null) {
			setOption2(option2);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	@Override
	public long getSpCourseLearningId() {
		return _spCourseLearningId;
	}

	@Override
	public void setSpCourseLearningId(long spCourseLearningId) {
		_spCourseLearningId = spCourseLearningId;

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseLearningId",
						long.class);

				method.invoke(_courseLearningRemoteModel, spCourseLearningId);
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

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_courseLearningRemoteModel, groupId);
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

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_courseLearningRemoteModel, companyId);
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

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_courseLearningRemoteModel, userId);
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

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_courseLearningRemoteModel, userName);
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

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_courseLearningRemoteModel, createDate);
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

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_courseLearningRemoteModel, modifiedDate);
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

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_courseLearningRemoteModel, spCourseId);
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

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setIntro", String.class);

				method.invoke(_courseLearningRemoteModel, intro);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOptionTitle() {
		return _optionTitle;
	}

	@Override
	public void setOptionTitle(String optionTitle) {
		_optionTitle = optionTitle;

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setOptionTitle", String.class);

				method.invoke(_courseLearningRemoteModel, optionTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOption1() {
		return _option1;
	}

	@Override
	public void setOption1(String option1) {
		_option1 = option1;

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setOption1", String.class);

				method.invoke(_courseLearningRemoteModel, option1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOption2() {
		return _option2;
	}

	@Override
	public void setOption2(String option2) {
		_option2 = option2;

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setOption2", String.class);

				method.invoke(_courseLearningRemoteModel, option2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNote() {
		return _note;
	}

	@Override
	public void setNote(String note) {
		_note = note;

		if (_courseLearningRemoteModel != null) {
			try {
				Class<?> clazz = _courseLearningRemoteModel.getClass();

				Method method = clazz.getMethod("setNote", String.class);

				method.invoke(_courseLearningRemoteModel, note);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCourseLearningRemoteModel() {
		return _courseLearningRemoteModel;
	}

	public void setCourseLearningRemoteModel(
		BaseModel<?> courseLearningRemoteModel) {
		_courseLearningRemoteModel = courseLearningRemoteModel;
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

		Class<?> remoteModelClass = _courseLearningRemoteModel.getClass();

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

		Object returnValue = method.invoke(_courseLearningRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseLearningLocalServiceUtil.addCourseLearning(this);
		}
		else {
			CourseLearningLocalServiceUtil.updateCourseLearning(this);
		}
	}

	@Override
	public CourseLearning toEscapedModel() {
		return (CourseLearning)ProxyUtil.newProxyInstance(CourseLearning.class.getClassLoader(),
			new Class[] { CourseLearning.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseLearningClp clone = new CourseLearningClp();

		clone.setSpCourseLearningId(getSpCourseLearningId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpCourseId(getSpCourseId());
		clone.setIntro(getIntro());
		clone.setOptionTitle(getOptionTitle());
		clone.setOption1(getOption1());
		clone.setOption2(getOption2());
		clone.setNote(getNote());

		return clone;
	}

	@Override
	public int compareTo(CourseLearning courseLearning) {
		long primaryKey = courseLearning.getPrimaryKey();

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

		if (!(obj instanceof CourseLearningClp)) {
			return false;
		}

		CourseLearningClp courseLearning = (CourseLearningClp)obj;

		long primaryKey = courseLearning.getPrimaryKey();

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

		sb.append("{spCourseLearningId=");
		sb.append(getSpCourseLearningId());
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
		sb.append(", optionTitle=");
		sb.append(getOptionTitle());
		sb.append(", option1=");
		sb.append(getOption1());
		sb.append(", option2=");
		sb.append(getOption2());
		sb.append(", note=");
		sb.append(getNote());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.CourseLearning");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCourseLearningId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseLearningId());
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
		sb.append(
			"<column><column-name>optionTitle</column-name><column-value><![CDATA[");
		sb.append(getOptionTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>option1</column-name><column-value><![CDATA[");
		sb.append(getOption1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>option2</column-name><column-value><![CDATA[");
		sb.append(getOption2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>note</column-name><column-value><![CDATA[");
		sb.append(getNote());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spCourseLearningId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseId;
	private String _intro;
	private String _optionTitle;
	private String _option1;
	private String _option2;
	private String _note;
	private BaseModel<?> _courseLearningRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}