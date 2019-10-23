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

import com.sambaash.platform.srv.service.CertificateLocalServiceUtil;
import com.sambaash.platform.srv.service.ClpSerializer;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class CertificateClp extends BaseModelImpl<Certificate>
	implements Certificate {
	public CertificateClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Certificate.class;
	}

	@Override
	public String getModelClassName() {
		return Certificate.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCertificatetId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCertificatetId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCertificatetId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCertificatetId", getSpCertificatetId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("certificateCode", getCertificateCode());
		attributes.put("certificateType", getCertificateType());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("level", getLevel());
		attributes.put("attachmentFolderId", getAttachmentFolderId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCertificatetId = (Long)attributes.get("spCertificatetId");

		if (spCertificatetId != null) {
			setSpCertificatetId(spCertificatetId);
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

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String certificateCode = (String)attributes.get("certificateCode");

		if (certificateCode != null) {
			setCertificateCode(certificateCode);
		}

		Long certificateType = (Long)attributes.get("certificateType");

		if (certificateType != null) {
			setCertificateType(certificateType);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long level = (Long)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long attachmentFolderId = (Long)attributes.get("attachmentFolderId");

		if (attachmentFolderId != null) {
			setAttachmentFolderId(attachmentFolderId);
		}
	}

	@Override
	public long getSpCertificatetId() {
		return _spCertificatetId;
	}

	@Override
	public void setSpCertificatetId(long spCertificatetId) {
		_spCertificatetId = spCertificatetId;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCertificatetId",
						long.class);

				method.invoke(_certificateRemoteModel, spCertificatetId);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_certificateRemoteModel, groupId);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_certificateRemoteModel, companyId);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_certificateRemoteModel, userId);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_certificateRemoteModel, userName);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_certificateRemoteModel, createDate);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_certificateRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(long countryId) {
		_countryId = countryId;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_certificateRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCertificateCode() {
		return _certificateCode;
	}

	@Override
	public void setCertificateCode(String certificateCode) {
		_certificateCode = certificateCode;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateCode",
						String.class);

				method.invoke(_certificateRemoteModel, certificateCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCertificateType() {
		return _certificateType;
	}

	@Override
	public void setCertificateType(long certificateType) {
		_certificateType = certificateType;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateType", long.class);

				method.invoke(_certificateRemoteModel, certificateType);
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

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_certificateRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_certificateRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel() {
		return _level;
	}

	@Override
	public void setLevel(long level) {
		_level = level;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel", long.class);

				method.invoke(_certificateRemoteModel, level);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAttachmentFolderId() {
		return _attachmentFolderId;
	}

	@Override
	public void setAttachmentFolderId(long attachmentFolderId) {
		_attachmentFolderId = attachmentFolderId;

		if (_certificateRemoteModel != null) {
			try {
				Class<?> clazz = _certificateRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentFolderId",
						long.class);

				method.invoke(_certificateRemoteModel, attachmentFolderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCertificateRemoteModel() {
		return _certificateRemoteModel;
	}

	public void setCertificateRemoteModel(BaseModel<?> certificateRemoteModel) {
		_certificateRemoteModel = certificateRemoteModel;
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

		Class<?> remoteModelClass = _certificateRemoteModel.getClass();

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

		Object returnValue = method.invoke(_certificateRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CertificateLocalServiceUtil.addCertificate(this);
		}
		else {
			CertificateLocalServiceUtil.updateCertificate(this);
		}
	}

	@Override
	public Certificate toEscapedModel() {
		return (Certificate)ProxyUtil.newProxyInstance(Certificate.class.getClassLoader(),
			new Class[] { Certificate.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CertificateClp clone = new CertificateClp();

		clone.setSpCertificatetId(getSpCertificatetId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryId(getCountryId());
		clone.setCertificateCode(getCertificateCode());
		clone.setCertificateType(getCertificateType());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setLevel(getLevel());
		clone.setAttachmentFolderId(getAttachmentFolderId());

		return clone;
	}

	@Override
	public int compareTo(Certificate certificate) {
		int value = 0;

		value = getTitle().compareTo(certificate.getTitle());

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

		if (!(obj instanceof CertificateClp)) {
			return false;
		}

		CertificateClp certificate = (CertificateClp)obj;

		long primaryKey = certificate.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{spCertificatetId=");
		sb.append(getSpCertificatetId());
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
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", certificateCode=");
		sb.append(getCertificateCode());
		sb.append(", certificateType=");
		sb.append(getCertificateType());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append(", attachmentFolderId=");
		sb.append(getAttachmentFolderId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Certificate");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCertificatetId</column-name><column-value><![CDATA[");
		sb.append(getSpCertificatetId());
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
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateCode</column-name><column-value><![CDATA[");
		sb.append(getCertificateCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateType</column-name><column-value><![CDATA[");
		sb.append(getCertificateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentFolderId</column-name><column-value><![CDATA[");
		sb.append(getAttachmentFolderId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spCertificatetId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private String _certificateCode;
	private long _certificateType;
	private String _title;
	private String _description;
	private long _level;
	private long _attachmentFolderId;
	private BaseModel<?> _certificateRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}