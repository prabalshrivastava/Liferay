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
import com.sambaash.platform.srv.service.CourseEnrollEsignInfoLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class CourseEnrollEsignInfoClp extends BaseModelImpl<CourseEnrollEsignInfo>
	implements CourseEnrollEsignInfo {
	public CourseEnrollEsignInfoClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return CourseEnrollEsignInfo.class;
	}

	@Override
	public String getModelClassName() {
		return CourseEnrollEsignInfo.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spEsignInfoId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpEsignInfoId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spEsignInfoId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spEsignInfoId", getSpEsignInfoId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("signerId", getSignerId());
		attributes.put("packageId", getPackageId());
		attributes.put("documentId", getDocumentId());
		attributes.put("lastGeneratedUrl", getLastGeneratedUrl());
		attributes.put("spPEProcessStateId", getSpPEProcessStateId());
		attributes.put("extraInfo", getExtraInfo());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spEsignInfoId = (Long)attributes.get("spEsignInfoId");

		if (spEsignInfoId != null) {
			setSpEsignInfoId(spEsignInfoId);
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

		String signerId = (String)attributes.get("signerId");

		if (signerId != null) {
			setSignerId(signerId);
		}

		String packageId = (String)attributes.get("packageId");

		if (packageId != null) {
			setPackageId(packageId);
		}

		String documentId = (String)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String lastGeneratedUrl = (String)attributes.get("lastGeneratedUrl");

		if (lastGeneratedUrl != null) {
			setLastGeneratedUrl(lastGeneratedUrl);
		}

		Long spPEProcessStateId = (Long)attributes.get("spPEProcessStateId");

		if (spPEProcessStateId != null) {
			setSpPEProcessStateId(spPEProcessStateId);
		}

		String extraInfo = (String)attributes.get("extraInfo");

		if (extraInfo != null) {
			setExtraInfo(extraInfo);
		}
	}

	@Override
	public long getSpEsignInfoId() {
		return _spEsignInfoId;
	}

	@Override
	public void setSpEsignInfoId(long spEsignInfoId) {
		_spEsignInfoId = spEsignInfoId;

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSpEsignInfoId", long.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, spEsignInfoId);
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

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, groupId);
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

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, companyId);
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

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, userId);
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

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, userName);
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

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, createDate);
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

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSignerId() {
		return _signerId;
	}

	@Override
	public void setSignerId(String signerId) {
		_signerId = signerId;

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSignerId", String.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, signerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPackageId() {
		return _packageId;
	}

	@Override
	public void setPackageId(String packageId) {
		_packageId = packageId;

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setPackageId", String.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, packageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDocumentId() {
		return _documentId;
	}

	@Override
	public void setDocumentId(String documentId) {
		_documentId = documentId;

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setDocumentId", String.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, documentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastGeneratedUrl() {
		return _lastGeneratedUrl;
	}

	@Override
	public void setLastGeneratedUrl(String lastGeneratedUrl) {
		_lastGeneratedUrl = lastGeneratedUrl;

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setLastGeneratedUrl",
						String.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel,
					lastGeneratedUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpPEProcessStateId() {
		return _spPEProcessStateId;
	}

	@Override
	public void setSpPEProcessStateId(long spPEProcessStateId) {
		_spPEProcessStateId = spPEProcessStateId;

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setSpPEProcessStateId",
						long.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel,
					spPEProcessStateId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtraInfo() {
		return _extraInfo;
	}

	@Override
	public void setExtraInfo(String extraInfo) {
		_extraInfo = extraInfo;

		if (_courseEnrollEsignInfoRemoteModel != null) {
			try {
				Class<?> clazz = _courseEnrollEsignInfoRemoteModel.getClass();

				Method method = clazz.getMethod("setExtraInfo", String.class);

				method.invoke(_courseEnrollEsignInfoRemoteModel, extraInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCourseEnrollEsignInfoRemoteModel() {
		return _courseEnrollEsignInfoRemoteModel;
	}

	public void setCourseEnrollEsignInfoRemoteModel(
		BaseModel<?> courseEnrollEsignInfoRemoteModel) {
		_courseEnrollEsignInfoRemoteModel = courseEnrollEsignInfoRemoteModel;
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

		Class<?> remoteModelClass = _courseEnrollEsignInfoRemoteModel.getClass();

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

		Object returnValue = method.invoke(_courseEnrollEsignInfoRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseEnrollEsignInfoLocalServiceUtil.addCourseEnrollEsignInfo(this);
		}
		else {
			CourseEnrollEsignInfoLocalServiceUtil.updateCourseEnrollEsignInfo(this);
		}
	}

	@Override
	public CourseEnrollEsignInfo toEscapedModel() {
		return (CourseEnrollEsignInfo)ProxyUtil.newProxyInstance(CourseEnrollEsignInfo.class.getClassLoader(),
			new Class[] { CourseEnrollEsignInfo.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseEnrollEsignInfoClp clone = new CourseEnrollEsignInfoClp();

		clone.setSpEsignInfoId(getSpEsignInfoId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSignerId(getSignerId());
		clone.setPackageId(getPackageId());
		clone.setDocumentId(getDocumentId());
		clone.setLastGeneratedUrl(getLastGeneratedUrl());
		clone.setSpPEProcessStateId(getSpPEProcessStateId());
		clone.setExtraInfo(getExtraInfo());

		return clone;
	}

	@Override
	public int compareTo(CourseEnrollEsignInfo courseEnrollEsignInfo) {
		long primaryKey = courseEnrollEsignInfo.getPrimaryKey();

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

		if (!(obj instanceof CourseEnrollEsignInfoClp)) {
			return false;
		}

		CourseEnrollEsignInfoClp courseEnrollEsignInfo = (CourseEnrollEsignInfoClp)obj;

		long primaryKey = courseEnrollEsignInfo.getPrimaryKey();

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

		sb.append("{spEsignInfoId=");
		sb.append(getSpEsignInfoId());
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
		sb.append(", signerId=");
		sb.append(getSignerId());
		sb.append(", packageId=");
		sb.append(getPackageId());
		sb.append(", documentId=");
		sb.append(getDocumentId());
		sb.append(", lastGeneratedUrl=");
		sb.append(getLastGeneratedUrl());
		sb.append(", spPEProcessStateId=");
		sb.append(getSpPEProcessStateId());
		sb.append(", extraInfo=");
		sb.append(getExtraInfo());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.CourseEnrollEsignInfo");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spEsignInfoId</column-name><column-value><![CDATA[");
		sb.append(getSpEsignInfoId());
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
			"<column><column-name>signerId</column-name><column-value><![CDATA[");
		sb.append(getSignerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>packageId</column-name><column-value><![CDATA[");
		sb.append(getPackageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentId</column-name><column-value><![CDATA[");
		sb.append(getDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastGeneratedUrl</column-name><column-value><![CDATA[");
		sb.append(getLastGeneratedUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spPEProcessStateId</column-name><column-value><![CDATA[");
		sb.append(getSpPEProcessStateId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extraInfo</column-name><column-value><![CDATA[");
		sb.append(getExtraInfo());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spEsignInfoId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _signerId;
	private String _packageId;
	private String _documentId;
	private String _lastGeneratedUrl;
	private long _spPEProcessStateId;
	private String _extraInfo;
	private BaseModel<?> _courseEnrollEsignInfoRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}