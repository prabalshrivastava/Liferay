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
import com.sambaash.platform.srv.enrolment.service.EnrollBatchUploadLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Baxture
 */
public class EnrollBatchUploadClp extends BaseModelImpl<EnrollBatchUpload>
	implements EnrollBatchUpload {
	public EnrollBatchUploadClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return EnrollBatchUpload.class;
	}

	@Override
	public String getModelClassName() {
		return EnrollBatchUpload.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _uploadStatId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUploadStatId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _uploadStatId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uploadStatId", getUploadStatId());
		attributes.put("uploadTransactId", getUploadTransactId());
		attributes.put("errorField", getErrorField());
		attributes.put("errorReason", getErrorReason());
		attributes.put("uploadedRecId", getUploadedRecId());
		attributes.put("userId", getUserId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long uploadStatId = (Long)attributes.get("uploadStatId");

		if (uploadStatId != null) {
			setUploadStatId(uploadStatId);
		}

		String uploadTransactId = (String)attributes.get("uploadTransactId");

		if (uploadTransactId != null) {
			setUploadTransactId(uploadTransactId);
		}

		String errorField = (String)attributes.get("errorField");

		if (errorField != null) {
			setErrorField(errorField);
		}

		String errorReason = (String)attributes.get("errorReason");

		if (errorReason != null) {
			setErrorReason(errorReason);
		}

		Long uploadedRecId = (Long)attributes.get("uploadedRecId");

		if (uploadedRecId != null) {
			setUploadedRecId(uploadedRecId);
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
	public long getUploadStatId() {
		return _uploadStatId;
	}

	@Override
	public void setUploadStatId(long uploadStatId) {
		_uploadStatId = uploadStatId;

		if (_enrollBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _enrollBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadStatId", long.class);

				method.invoke(_enrollBatchUploadRemoteModel, uploadStatId);
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

		if (_enrollBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _enrollBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadTransactId",
						String.class);

				method.invoke(_enrollBatchUploadRemoteModel, uploadTransactId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getErrorField() {
		return _errorField;
	}

	@Override
	public void setErrorField(String errorField) {
		_errorField = errorField;

		if (_enrollBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _enrollBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorField", String.class);

				method.invoke(_enrollBatchUploadRemoteModel, errorField);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getErrorReason() {
		return _errorReason;
	}

	@Override
	public void setErrorReason(String errorReason) {
		_errorReason = errorReason;

		if (_enrollBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _enrollBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorReason", String.class);

				method.invoke(_enrollBatchUploadRemoteModel, errorReason);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUploadedRecId() {
		return _uploadedRecId;
	}

	@Override
	public void setUploadedRecId(long uploadedRecId) {
		_uploadedRecId = uploadedRecId;

		if (_enrollBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _enrollBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setUploadedRecId", long.class);

				method.invoke(_enrollBatchUploadRemoteModel, uploadedRecId);
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

		if (_enrollBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _enrollBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_enrollBatchUploadRemoteModel, userId);
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

		if (_enrollBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _enrollBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_enrollBatchUploadRemoteModel, createDate);
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

		if (_enrollBatchUploadRemoteModel != null) {
			try {
				Class<?> clazz = _enrollBatchUploadRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_enrollBatchUploadRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getEnrollBatchUploadRemoteModel() {
		return _enrollBatchUploadRemoteModel;
	}

	public void setEnrollBatchUploadRemoteModel(
		BaseModel<?> enrollBatchUploadRemoteModel) {
		_enrollBatchUploadRemoteModel = enrollBatchUploadRemoteModel;
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

		Class<?> remoteModelClass = _enrollBatchUploadRemoteModel.getClass();

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

		Object returnValue = method.invoke(_enrollBatchUploadRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			EnrollBatchUploadLocalServiceUtil.addEnrollBatchUpload(this);
		}
		else {
			EnrollBatchUploadLocalServiceUtil.updateEnrollBatchUpload(this);
		}
	}

	@Override
	public EnrollBatchUpload toEscapedModel() {
		return (EnrollBatchUpload)ProxyUtil.newProxyInstance(EnrollBatchUpload.class.getClassLoader(),
			new Class[] { EnrollBatchUpload.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		EnrollBatchUploadClp clone = new EnrollBatchUploadClp();

		clone.setUploadStatId(getUploadStatId());
		clone.setUploadTransactId(getUploadTransactId());
		clone.setErrorField(getErrorField());
		clone.setErrorReason(getErrorReason());
		clone.setUploadedRecId(getUploadedRecId());
		clone.setUserId(getUserId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(EnrollBatchUpload enrollBatchUpload) {
		long primaryKey = enrollBatchUpload.getPrimaryKey();

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

		if (!(obj instanceof EnrollBatchUploadClp)) {
			return false;
		}

		EnrollBatchUploadClp enrollBatchUpload = (EnrollBatchUploadClp)obj;

		long primaryKey = enrollBatchUpload.getPrimaryKey();

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
		StringBundler sb = new StringBundler(17);

		sb.append("{uploadStatId=");
		sb.append(getUploadStatId());
		sb.append(", uploadTransactId=");
		sb.append(getUploadTransactId());
		sb.append(", errorField=");
		sb.append(getErrorField());
		sb.append(", errorReason=");
		sb.append(getErrorReason());
		sb.append(", uploadedRecId=");
		sb.append(getUploadedRecId());
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
		StringBundler sb = new StringBundler(28);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uploadStatId</column-name><column-value><![CDATA[");
		sb.append(getUploadStatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uploadTransactId</column-name><column-value><![CDATA[");
		sb.append(getUploadTransactId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorField</column-name><column-value><![CDATA[");
		sb.append(getErrorField());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorReason</column-name><column-value><![CDATA[");
		sb.append(getErrorReason());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uploadedRecId</column-name><column-value><![CDATA[");
		sb.append(getUploadedRecId());
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

	private long _uploadStatId;
	private String _uploadTransactId;
	private String _errorField;
	private String _errorReason;
	private long _uploadedRecId;
	private long _userId;
	private String _userUuid;
	private Date _createDate;
	private Date _modifiedDate;
	private BaseModel<?> _enrollBatchUploadRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.enrolment.service.ClpSerializer.class;
}