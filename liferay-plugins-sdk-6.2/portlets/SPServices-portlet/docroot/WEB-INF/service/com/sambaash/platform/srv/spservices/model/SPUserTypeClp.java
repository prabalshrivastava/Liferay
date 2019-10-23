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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.SPUserTypeLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPUserTypeClp extends BaseModelImpl<SPUserType>
	implements SPUserType {
	public SPUserTypeClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPUserType.class;
	}

	@Override
	public String getModelClassName() {
		return SPUserType.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spUserTypeId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpUserTypeId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spUserTypeId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spUserTypeId", getSpUserTypeId());
		attributes.put("spSiteId", getSpSiteId());
		attributes.put("userId", getUserId());
		attributes.put("userTypeId", getUserTypeId());
		attributes.put("userStatusId", getUserStatusId());
		attributes.put("declarationCompleted", getDeclarationCompleted());
		attributes.put("declarationDate", getDeclarationDate());
		attributes.put("declarationStorageId", getDeclarationStorageId());
		attributes.put("pdpaCompleted", getPdpaCompleted());
		attributes.put("pdpaCompletionDate", getPdpaCompletionDate());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spUserTypeId = (Long)attributes.get("spUserTypeId");

		if (spUserTypeId != null) {
			setSpUserTypeId(spUserTypeId);
		}

		Long spSiteId = (Long)attributes.get("spSiteId");

		if (spSiteId != null) {
			setSpSiteId(spSiteId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long userTypeId = (Long)attributes.get("userTypeId");

		if (userTypeId != null) {
			setUserTypeId(userTypeId);
		}

		Long userStatusId = (Long)attributes.get("userStatusId");

		if (userStatusId != null) {
			setUserStatusId(userStatusId);
		}

		Boolean declarationCompleted = (Boolean)attributes.get(
				"declarationCompleted");

		if (declarationCompleted != null) {
			setDeclarationCompleted(declarationCompleted);
		}

		Long declarationDate = (Long)attributes.get("declarationDate");

		if (declarationDate != null) {
			setDeclarationDate(declarationDate);
		}

		Long declarationStorageId = (Long)attributes.get("declarationStorageId");

		if (declarationStorageId != null) {
			setDeclarationStorageId(declarationStorageId);
		}

		Boolean pdpaCompleted = (Boolean)attributes.get("pdpaCompleted");

		if (pdpaCompleted != null) {
			setPdpaCompleted(pdpaCompleted);
		}

		Long pdpaCompletionDate = (Long)attributes.get("pdpaCompletionDate");

		if (pdpaCompletionDate != null) {
			setPdpaCompletionDate(pdpaCompletionDate);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spUserTypeRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpUserTypeId() {
		return _spUserTypeId;
	}

	@Override
	public void setSpUserTypeId(long spUserTypeId) {
		_spUserTypeId = spUserTypeId;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpUserTypeId", long.class);

				method.invoke(_spUserTypeRemoteModel, spUserTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpSiteId() {
		return _spSiteId;
	}

	@Override
	public void setSpSiteId(long spSiteId) {
		_spSiteId = spSiteId;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setSpSiteId", long.class);

				method.invoke(_spUserTypeRemoteModel, spSiteId);
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

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spUserTypeRemoteModel, userId);
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
	public long getUserTypeId() {
		return _userTypeId;
	}

	@Override
	public void setUserTypeId(long userTypeId) {
		_userTypeId = userTypeId;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserTypeId", long.class);

				method.invoke(_spUserTypeRemoteModel, userTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserStatusId() {
		return _userStatusId;
	}

	@Override
	public void setUserStatusId(long userStatusId) {
		_userStatusId = userStatusId;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setUserStatusId", long.class);

				method.invoke(_spUserTypeRemoteModel, userStatusId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeclarationCompleted() {
		return _declarationCompleted;
	}

	@Override
	public boolean isDeclarationCompleted() {
		return _declarationCompleted;
	}

	@Override
	public void setDeclarationCompleted(boolean declarationCompleted) {
		_declarationCompleted = declarationCompleted;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDeclarationCompleted",
						boolean.class);

				method.invoke(_spUserTypeRemoteModel, declarationCompleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDeclarationDate() {
		return _declarationDate;
	}

	@Override
	public void setDeclarationDate(long declarationDate) {
		_declarationDate = declarationDate;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDeclarationDate", long.class);

				method.invoke(_spUserTypeRemoteModel, declarationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDeclarationStorageId() {
		return _declarationStorageId;
	}

	@Override
	public void setDeclarationStorageId(long declarationStorageId) {
		_declarationStorageId = declarationStorageId;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setDeclarationStorageId",
						long.class);

				method.invoke(_spUserTypeRemoteModel, declarationStorageId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getPdpaCompleted() {
		return _pdpaCompleted;
	}

	@Override
	public boolean isPdpaCompleted() {
		return _pdpaCompleted;
	}

	@Override
	public void setPdpaCompleted(boolean pdpaCompleted) {
		_pdpaCompleted = pdpaCompleted;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPdpaCompleted",
						boolean.class);

				method.invoke(_spUserTypeRemoteModel, pdpaCompleted);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPdpaCompletionDate() {
		return _pdpaCompletionDate;
	}

	@Override
	public void setPdpaCompletionDate(long pdpaCompletionDate) {
		_pdpaCompletionDate = pdpaCompletionDate;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setPdpaCompletionDate",
						long.class);

				method.invoke(_spUserTypeRemoteModel, pdpaCompletionDate);
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

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spUserTypeRemoteModel, groupId);
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

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spUserTypeRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_spUserTypeRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModifiedBy() {
		return _modifiedBy;
	}

	@Override
	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_spUserTypeRemoteModel, modifiedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_spUserTypeRemoteModel, createdDate);
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

		if (_spUserTypeRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spUserTypeRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPUserTypeRemoteModel() {
		return _spUserTypeRemoteModel;
	}

	public void setSPUserTypeRemoteModel(BaseModel<?> spUserTypeRemoteModel) {
		_spUserTypeRemoteModel = spUserTypeRemoteModel;
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

		Class<?> remoteModelClass = _spUserTypeRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spUserTypeRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPUserTypeLocalServiceUtil.addSPUserType(this);
		}
		else {
			SPUserTypeLocalServiceUtil.updateSPUserType(this);
		}
	}

	@Override
	public SPUserType toEscapedModel() {
		return (SPUserType)ProxyUtil.newProxyInstance(SPUserType.class.getClassLoader(),
			new Class[] { SPUserType.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPUserTypeClp clone = new SPUserTypeClp();

		clone.setUuid(getUuid());
		clone.setSpUserTypeId(getSpUserTypeId());
		clone.setSpSiteId(getSpSiteId());
		clone.setUserId(getUserId());
		clone.setUserTypeId(getUserTypeId());
		clone.setUserStatusId(getUserStatusId());
		clone.setDeclarationCompleted(getDeclarationCompleted());
		clone.setDeclarationDate(getDeclarationDate());
		clone.setDeclarationStorageId(getDeclarationStorageId());
		clone.setPdpaCompleted(getPdpaCompleted());
		clone.setPdpaCompletionDate(getPdpaCompletionDate());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedBy(getCreatedBy());
		clone.setModifiedBy(getModifiedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPUserType spUserType) {
		long primaryKey = spUserType.getPrimaryKey();

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

		if (!(obj instanceof SPUserTypeClp)) {
			return false;
		}

		SPUserTypeClp spUserType = (SPUserTypeClp)obj;

		long primaryKey = spUserType.getPrimaryKey();

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
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spUserTypeId=");
		sb.append(getSpUserTypeId());
		sb.append(", spSiteId=");
		sb.append(getSpSiteId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userTypeId=");
		sb.append(getUserTypeId());
		sb.append(", userStatusId=");
		sb.append(getUserStatusId());
		sb.append(", declarationCompleted=");
		sb.append(getDeclarationCompleted());
		sb.append(", declarationDate=");
		sb.append(getDeclarationDate());
		sb.append(", declarationStorageId=");
		sb.append(getDeclarationStorageId());
		sb.append(", pdpaCompleted=");
		sb.append(getPdpaCompleted());
		sb.append(", pdpaCompletionDate=");
		sb.append(getPdpaCompletionDate());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", modifiedBy=");
		sb.append(getModifiedBy());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(55);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPUserType");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spUserTypeId</column-name><column-value><![CDATA[");
		sb.append(getSpUserTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spSiteId</column-name><column-value><![CDATA[");
		sb.append(getSpSiteId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userTypeId</column-name><column-value><![CDATA[");
		sb.append(getUserTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userStatusId</column-name><column-value><![CDATA[");
		sb.append(getUserStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>declarationCompleted</column-name><column-value><![CDATA[");
		sb.append(getDeclarationCompleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>declarationDate</column-name><column-value><![CDATA[");
		sb.append(getDeclarationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>declarationStorageId</column-name><column-value><![CDATA[");
		sb.append(getDeclarationStorageId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdpaCompleted</column-name><column-value><![CDATA[");
		sb.append(getPdpaCompleted());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdpaCompletionDate</column-name><column-value><![CDATA[");
		sb.append(getPdpaCompletionDate());
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
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedBy</column-name><column-value><![CDATA[");
		sb.append(getModifiedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spUserTypeId;
	private long _spSiteId;
	private long _userId;
	private String _userUuid;
	private long _userTypeId;
	private long _userStatusId;
	private boolean _declarationCompleted;
	private long _declarationDate;
	private long _declarationStorageId;
	private boolean _pdpaCompleted;
	private long _pdpaCompletionDate;
	private long _groupId;
	private long _companyId;
	private long _createdBy;
	private long _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;
	private BaseModel<?> _spUserTypeRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}