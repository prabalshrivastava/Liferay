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

package com.sambaash.platform.srv.roles.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.roles.service.ClpSerializer;
import com.sambaash.platform.srv.roles.service.SPCategoriesMappingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPCategoriesMappingClp extends BaseModelImpl<SPCategoriesMapping>
	implements SPCategoriesMapping {
	public SPCategoriesMappingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPCategoriesMapping.class;
	}

	@Override
	public String getModelClassName() {
		return SPCategoriesMapping.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spCategoryMappingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCategoryMappingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCategoryMappingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spCategoryMappingId", getSpCategoryMappingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("createdVocabularyId", getCreatedVocabularyId());
		attributes.put("mainCategoryId", getMainCategoryId());
		attributes.put("subCategoryId", getSubCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spCategoryMappingId = (Long)attributes.get("spCategoryMappingId");

		if (spCategoryMappingId != null) {
			setSpCategoryMappingId(spCategoryMappingId);
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

		Long createdVocabularyId = (Long)attributes.get("createdVocabularyId");

		if (createdVocabularyId != null) {
			setCreatedVocabularyId(createdVocabularyId);
		}

		Long mainCategoryId = (Long)attributes.get("mainCategoryId");

		if (mainCategoryId != null) {
			setMainCategoryId(mainCategoryId);
		}

		Long subCategoryId = (Long)attributes.get("subCategoryId");

		if (subCategoryId != null) {
			setSubCategoryId(subCategoryId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spCategoriesMappingRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpCategoryMappingId() {
		return _spCategoryMappingId;
	}

	@Override
	public void setSpCategoryMappingId(long spCategoryMappingId) {
		_spCategoryMappingId = spCategoryMappingId;

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCategoryMappingId",
						long.class);

				method.invoke(_spCategoriesMappingRemoteModel,
					spCategoryMappingId);
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

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spCategoriesMappingRemoteModel, groupId);
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

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spCategoriesMappingRemoteModel, companyId);
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

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spCategoriesMappingRemoteModel, userId);
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

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spCategoriesMappingRemoteModel, userName);
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

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spCategoriesMappingRemoteModel, createDate);
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

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spCategoriesMappingRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreatedVocabularyId() {
		return _createdVocabularyId;
	}

	@Override
	public void setCreatedVocabularyId(long createdVocabularyId) {
		_createdVocabularyId = createdVocabularyId;

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedVocabularyId",
						long.class);

				method.invoke(_spCategoriesMappingRemoteModel,
					createdVocabularyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMainCategoryId() {
		return _mainCategoryId;
	}

	@Override
	public void setMainCategoryId(long mainCategoryId) {
		_mainCategoryId = mainCategoryId;

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setMainCategoryId", long.class);

				method.invoke(_spCategoriesMappingRemoteModel, mainCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSubCategoryId() {
		return _subCategoryId;
	}

	@Override
	public void setSubCategoryId(long subCategoryId) {
		_subCategoryId = subCategoryId;

		if (_spCategoriesMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spCategoriesMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setSubCategoryId", long.class);

				method.invoke(_spCategoriesMappingRemoteModel, subCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPCategoriesMapping.class.getName()));
	}

	public BaseModel<?> getSPCategoriesMappingRemoteModel() {
		return _spCategoriesMappingRemoteModel;
	}

	public void setSPCategoriesMappingRemoteModel(
		BaseModel<?> spCategoriesMappingRemoteModel) {
		_spCategoriesMappingRemoteModel = spCategoriesMappingRemoteModel;
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

		Class<?> remoteModelClass = _spCategoriesMappingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spCategoriesMappingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPCategoriesMappingLocalServiceUtil.addSPCategoriesMapping(this);
		}
		else {
			SPCategoriesMappingLocalServiceUtil.updateSPCategoriesMapping(this);
		}
	}

	@Override
	public SPCategoriesMapping toEscapedModel() {
		return (SPCategoriesMapping)ProxyUtil.newProxyInstance(SPCategoriesMapping.class.getClassLoader(),
			new Class[] { SPCategoriesMapping.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPCategoriesMappingClp clone = new SPCategoriesMappingClp();

		clone.setUuid(getUuid());
		clone.setSpCategoryMappingId(getSpCategoryMappingId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCreatedVocabularyId(getCreatedVocabularyId());
		clone.setMainCategoryId(getMainCategoryId());
		clone.setSubCategoryId(getSubCategoryId());

		return clone;
	}

	@Override
	public int compareTo(SPCategoriesMapping spCategoriesMapping) {
		int value = 0;

		if (getMainCategoryId() < spCategoriesMapping.getMainCategoryId()) {
			value = -1;
		}
		else if (getMainCategoryId() > spCategoriesMapping.getMainCategoryId()) {
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

		if (!(obj instanceof SPCategoriesMappingClp)) {
			return false;
		}

		SPCategoriesMappingClp spCategoriesMapping = (SPCategoriesMappingClp)obj;

		long primaryKey = spCategoriesMapping.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spCategoryMappingId=");
		sb.append(getSpCategoryMappingId());
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
		sb.append(", createdVocabularyId=");
		sb.append(getCreatedVocabularyId());
		sb.append(", mainCategoryId=");
		sb.append(getMainCategoryId());
		sb.append(", subCategoryId=");
		sb.append(getSubCategoryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.roles.model.SPCategoriesMapping");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spCategoryMappingId</column-name><column-value><![CDATA[");
		sb.append(getSpCategoryMappingId());
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
			"<column><column-name>createdVocabularyId</column-name><column-value><![CDATA[");
		sb.append(getCreatedVocabularyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mainCategoryId</column-name><column-value><![CDATA[");
		sb.append(getMainCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>subCategoryId</column-name><column-value><![CDATA[");
		sb.append(getSubCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spCategoryMappingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _createdVocabularyId;
	private long _mainCategoryId;
	private long _subCategoryId;
	private BaseModel<?> _spCategoriesMappingRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.roles.service.ClpSerializer.class;
}