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
import com.sambaash.platform.srv.service.StudyOptionLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class StudyOptionClp extends BaseModelImpl<StudyOption>
	implements StudyOption {
	public StudyOptionClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StudyOption.class;
	}

	@Override
	public String getModelClassName() {
		return StudyOption.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spStudyOptionId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpStudyOptionId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spStudyOptionId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudyOptionId", getSpStudyOptionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("coverImageFileEntryId", getCoverImageFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudyOptionId = (Long)attributes.get("spStudyOptionId");

		if (spStudyOptionId != null) {
			setSpStudyOptionId(spStudyOptionId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}

		Long coverImageFileEntryId = (Long)attributes.get(
				"coverImageFileEntryId");

		if (coverImageFileEntryId != null) {
			setCoverImageFileEntryId(coverImageFileEntryId);
		}
	}

	@Override
	public long getSpStudyOptionId() {
		return _spStudyOptionId;
	}

	@Override
	public void setSpStudyOptionId(long spStudyOptionId) {
		_spStudyOptionId = spStudyOptionId;

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSpStudyOptionId", long.class);

				method.invoke(_studyOptionRemoteModel, spStudyOptionId);
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

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_studyOptionRemoteModel, groupId);
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

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_studyOptionRemoteModel, companyId);
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

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_studyOptionRemoteModel, userId);
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

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_studyOptionRemoteModel, userName);
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

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_studyOptionRemoteModel, createDate);
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

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_studyOptionRemoteModel, modifiedDate);
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

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_studyOptionRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_studyOptionRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesc() {
		return _desc;
	}

	@Override
	public void setDesc(String desc) {
		_desc = desc;

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setDesc", String.class);

				method.invoke(_studyOptionRemoteModel, desc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCoverImageFileEntryId() {
		return _coverImageFileEntryId;
	}

	@Override
	public void setCoverImageFileEntryId(long coverImageFileEntryId) {
		_coverImageFileEntryId = coverImageFileEntryId;

		if (_studyOptionRemoteModel != null) {
			try {
				Class<?> clazz = _studyOptionRemoteModel.getClass();

				Method method = clazz.getMethod("setCoverImageFileEntryId",
						long.class);

				method.invoke(_studyOptionRemoteModel, coverImageFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getStudyOptionRemoteModel() {
		return _studyOptionRemoteModel;
	}

	public void setStudyOptionRemoteModel(BaseModel<?> studyOptionRemoteModel) {
		_studyOptionRemoteModel = studyOptionRemoteModel;
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

		Class<?> remoteModelClass = _studyOptionRemoteModel.getClass();

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

		Object returnValue = method.invoke(_studyOptionRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StudyOptionLocalServiceUtil.addStudyOption(this);
		}
		else {
			StudyOptionLocalServiceUtil.updateStudyOption(this);
		}
	}

	@Override
	public StudyOption toEscapedModel() {
		return (StudyOption)ProxyUtil.newProxyInstance(StudyOption.class.getClassLoader(),
			new Class[] { StudyOption.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StudyOptionClp clone = new StudyOptionClp();

		clone.setSpStudyOptionId(getSpStudyOptionId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSpCourseId(getSpCourseId());
		clone.setTitle(getTitle());
		clone.setDesc(getDesc());
		clone.setCoverImageFileEntryId(getCoverImageFileEntryId());

		return clone;
	}

	@Override
	public int compareTo(StudyOption studyOption) {
		long primaryKey = studyOption.getPrimaryKey();

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

		if (!(obj instanceof StudyOptionClp)) {
			return false;
		}

		StudyOptionClp studyOption = (StudyOptionClp)obj;

		long primaryKey = studyOption.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{spStudyOptionId=");
		sb.append(getSpStudyOptionId());
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
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", desc=");
		sb.append(getDesc());
		sb.append(", coverImageFileEntryId=");
		sb.append(getCoverImageFileEntryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.StudyOption");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spStudyOptionId</column-name><column-value><![CDATA[");
		sb.append(getSpStudyOptionId());
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
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desc</column-name><column-value><![CDATA[");
		sb.append(getDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>coverImageFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getCoverImageFileEntryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spStudyOptionId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCourseId;
	private String _title;
	private String _desc;
	private long _coverImageFileEntryId;
	private BaseModel<?> _studyOptionRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}