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

package com.sambaash.platform.srv.enrolment.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.enrolment.service.ClpSerializer;
import com.sambaash.platform.srv.enrolment.service.EnrollUploadedTempRecordsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Baxture
 */
public class EnrollUploadedTempRecordsClp extends BaseModelImpl<EnrollUploadedTempRecords>
	implements EnrollUploadedTempRecords {
	public EnrollUploadedTempRecordsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EnrollUploadedTempRecords.class;
	}

	@Override
	public String getModelClassName() {
		return EnrollUploadedTempRecords.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _uploadedRecId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUploadedRecId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _uploadedRecId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uploadedRecId", getUploadedRecId());
		attributes.put("uploadTransactId", getUploadTransactId());
		attributes.put("sprCode", getSprCode());
		attributes.put("title", getTitle());
		attributes.put("fullOfficialName", getFullOfficialName());
		attributes.put("gender", getGender());
		attributes.put("dateofBirth", getDateofBirth());
		attributes.put("email", getEmail());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uploadedRecId = (Long)attributes.get("uploadedRecId");

		if (uploadedRecId != null) {
			setUploadedRecId(uploadedRecId);
		}

		String uploadTransactId = (String)attributes.get("uploadTransactId");

		if (uploadTransactId != null) {
			setUploadTransactId(uploadTransactId);
		}

		String sprCode = (String)attributes.get("sprCode");

		if (sprCode != null) {
			setSprCode(sprCode);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String fullOfficialName = (String)attributes.get("fullOfficialName");

		if (fullOfficialName != null) {
			setFullOfficialName(fullOfficialName);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String dateofBirth = (String)attributes.get("dateofBirth");

		if (dateofBirth != null) {
			setDateofBirth(dateofBirth);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public long getUploadedRecId() {
		return _uploadedRecId;
	}

	@Override
	public void setUploadedRecId(long uploadedRecId) {
		_uploadedRecId = uploadedRecId;

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadedRecId", long.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel,
					uploadedRecId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUploadTransactId() {
		return _uploadTransactId;
	}

	@Override
	public void setUploadTransactId(String uploadTransactId) {
		_uploadTransactId = uploadTransactId;

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadTransactId",
						String.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel,
					uploadTransactId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSprCode() {
		return _sprCode;
	}

	@Override
	public void setSprCode(String sprCode) {
		_sprCode = sprCode;

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setSprCode", String.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel, sprCode);
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

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFullOfficialName() {
		return _fullOfficialName;
	}

	@Override
	public void setFullOfficialName(String fullOfficialName) {
		_fullOfficialName = fullOfficialName;

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setFullOfficialName",
						String.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel,
					fullOfficialName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGender() {
		return _gender;
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", String.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDateofBirth() {
		return _dateofBirth;
	}

	@Override
	public void setDateofBirth(String dateofBirth) {
		_dateofBirth = dateofBirth;

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setDateofBirth", String.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel, dateofBirth);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmail() {
		return _email;
	}

	@Override
	public void setEmail(String email) {
		_email = email;

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmail", String.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel, email);
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

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel, userId);
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
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel, createDate);
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

		if (_enrollUploadedTempRecordsRemoteModel != null) {
			try {
				Class<?> clazz = _enrollUploadedTempRecordsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_enrollUploadedTempRecordsRemoteModel,
					modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEnrollUploadedTempRecordsRemoteModel() {
		return _enrollUploadedTempRecordsRemoteModel;
	}

	public void setEnrollUploadedTempRecordsRemoteModel(
		BaseModel<?> enrollUploadedTempRecordsRemoteModel) {
		_enrollUploadedTempRecordsRemoteModel = enrollUploadedTempRecordsRemoteModel;
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

		Class<?> remoteModelClass = _enrollUploadedTempRecordsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_enrollUploadedTempRecordsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EnrollUploadedTempRecordsLocalServiceUtil.addEnrollUploadedTempRecords(this);
		}
		else {
			EnrollUploadedTempRecordsLocalServiceUtil.updateEnrollUploadedTempRecords(this);
		}
	}

	@Override
	public EnrollUploadedTempRecords toEscapedModel() {
		return (EnrollUploadedTempRecords)ProxyUtil.newProxyInstance(EnrollUploadedTempRecords.class.getClassLoader(),
			new Class[] { EnrollUploadedTempRecords.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EnrollUploadedTempRecordsClp clone = new EnrollUploadedTempRecordsClp();

		clone.setUploadedRecId(getUploadedRecId());
		clone.setUploadTransactId(getUploadTransactId());
		clone.setSprCode(getSprCode());
		clone.setTitle(getTitle());
		clone.setFullOfficialName(getFullOfficialName());
		clone.setGender(getGender());
		clone.setDateofBirth(getDateofBirth());
		clone.setEmail(getEmail());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EnrollUploadedTempRecords enrollUploadedTempRecords) {
		long primaryKey = enrollUploadedTempRecords.getPrimaryKey();

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

		if (!(obj instanceof EnrollUploadedTempRecordsClp)) {
			return false;
		}

		EnrollUploadedTempRecordsClp enrollUploadedTempRecords = (EnrollUploadedTempRecordsClp)obj;

		long primaryKey = enrollUploadedTempRecords.getPrimaryKey();

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

		sb.append("{uploadedRecId=");
		sb.append(getUploadedRecId());
		sb.append(", uploadTransactId=");
		sb.append(getUploadTransactId());
		sb.append(", sprCode=");
		sb.append(getSprCode());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", fullOfficialName=");
		sb.append(getFullOfficialName());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", dateofBirth=");
		sb.append(getDateofBirth());
		sb.append(", email=");
		sb.append(getEmail());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uploadedRecId</column-name><column-value><![CDATA[");
		sb.append(getUploadedRecId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uploadTransactId</column-name><column-value><![CDATA[");
		sb.append(getUploadTransactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>sprCode</column-name><column-value><![CDATA[");
		sb.append(getSprCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fullOfficialName</column-name><column-value><![CDATA[");
		sb.append(getFullOfficialName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>dateofBirth</column-name><column-value><![CDATA[");
		sb.append(getDateofBirth());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>email</column-name><column-value><![CDATA[");
		sb.append(getEmail());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _uploadedRecId;
	private String _uploadTransactId;
	private String _sprCode;
	private String _title;
	private String _fullOfficialName;
	private String _gender;
	private String _dateofBirth;
	private String _email;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _enrollUploadedTempRecordsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.enrolment.service.ClpSerializer.class;
}