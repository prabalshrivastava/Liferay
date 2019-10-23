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
import com.sambaash.platform.srv.roles.service.SPRolesLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPRolesClp extends BaseModelImpl<SPRoles> implements SPRoles {
	public SPRolesClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPRoles.class;
	}

	@Override
	public String getModelClassName() {
		return SPRoles.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spRoleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpRoleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spRoleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spRoleId", getSpRoleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("roleId", getRoleId());
		attributes.put("categoryId1", getCategoryId1());
		attributes.put("categoryId2", getCategoryId2());
		attributes.put("countryCategoryId", getCountryCategoryId());
		attributes.put("departmentCategoryId", getDepartmentCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spRoleId = (Long)attributes.get("spRoleId");

		if (spRoleId != null) {
			setSpRoleId(spRoleId);
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

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long categoryId1 = (Long)attributes.get("categoryId1");

		if (categoryId1 != null) {
			setCategoryId1(categoryId1);
		}

		Long categoryId2 = (Long)attributes.get("categoryId2");

		if (categoryId2 != null) {
			setCategoryId2(categoryId2);
		}

		Long countryCategoryId = (Long)attributes.get("countryCategoryId");

		if (countryCategoryId != null) {
			setCountryCategoryId(countryCategoryId);
		}

		Long departmentCategoryId = (Long)attributes.get("departmentCategoryId");

		if (departmentCategoryId != null) {
			setDepartmentCategoryId(departmentCategoryId);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spRolesRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpRoleId() {
		return _spRoleId;
	}

	@Override
	public void setSpRoleId(long spRoleId) {
		_spRoleId = spRoleId;

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setSpRoleId", long.class);

				method.invoke(_spRolesRemoteModel, spRoleId);
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

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spRolesRemoteModel, groupId);
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

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spRolesRemoteModel, companyId);
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

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spRolesRemoteModel, userId);
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

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spRolesRemoteModel, userName);
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

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spRolesRemoteModel, createDate);
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

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spRolesRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRoleId() {
		return _roleId;
	}

	@Override
	public void setRoleId(long roleId) {
		_roleId = roleId;

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setRoleId", long.class);

				method.invoke(_spRolesRemoteModel, roleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId1() {
		return _categoryId1;
	}

	@Override
	public void setCategoryId1(long categoryId1) {
		_categoryId1 = categoryId1;

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId1", long.class);

				method.invoke(_spRolesRemoteModel, categoryId1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCategoryId2() {
		return _categoryId2;
	}

	@Override
	public void setCategoryId2(long categoryId2) {
		_categoryId2 = categoryId2;

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setCategoryId2", long.class);

				method.invoke(_spRolesRemoteModel, categoryId2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCountryCategoryId() {
		return _countryCategoryId;
	}

	@Override
	public void setCountryCategoryId(long countryCategoryId) {
		_countryCategoryId = countryCategoryId;

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCategoryId",
						long.class);

				method.invoke(_spRolesRemoteModel, countryCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDepartmentCategoryId() {
		return _departmentCategoryId;
	}

	@Override
	public void setDepartmentCategoryId(long departmentCategoryId) {
		_departmentCategoryId = departmentCategoryId;

		if (_spRolesRemoteModel != null) {
			try {
				Class<?> clazz = _spRolesRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentCategoryId",
						long.class);

				method.invoke(_spRolesRemoteModel, departmentCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SPRoles.class.getName()));
	}

	public BaseModel<?> getSPRolesRemoteModel() {
		return _spRolesRemoteModel;
	}

	public void setSPRolesRemoteModel(BaseModel<?> spRolesRemoteModel) {
		_spRolesRemoteModel = spRolesRemoteModel;
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

		Class<?> remoteModelClass = _spRolesRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spRolesRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPRolesLocalServiceUtil.addSPRoles(this);
		}
		else {
			SPRolesLocalServiceUtil.updateSPRoles(this);
		}
	}

	@Override
	public SPRoles toEscapedModel() {
		return (SPRoles)ProxyUtil.newProxyInstance(SPRoles.class.getClassLoader(),
			new Class[] { SPRoles.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPRolesClp clone = new SPRolesClp();

		clone.setUuid(getUuid());
		clone.setSpRoleId(getSpRoleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRoleId(getRoleId());
		clone.setCategoryId1(getCategoryId1());
		clone.setCategoryId2(getCategoryId2());
		clone.setCountryCategoryId(getCountryCategoryId());
		clone.setDepartmentCategoryId(getDepartmentCategoryId());

		return clone;
	}

	@Override
	public int compareTo(SPRoles spRoles) {
		int value = 0;

		if (getRoleId() < spRoles.getRoleId()) {
			value = -1;
		}
		else if (getRoleId() > spRoles.getRoleId()) {
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

		if (!(obj instanceof SPRolesClp)) {
			return false;
		}

		SPRolesClp spRoles = (SPRolesClp)obj;

		long primaryKey = spRoles.getPrimaryKey();

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

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spRoleId=");
		sb.append(getSpRoleId());
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
		sb.append(", roleId=");
		sb.append(getRoleId());
		sb.append(", categoryId1=");
		sb.append(getCategoryId1());
		sb.append(", categoryId2=");
		sb.append(getCategoryId2());
		sb.append(", countryCategoryId=");
		sb.append(getCountryCategoryId());
		sb.append(", departmentCategoryId=");
		sb.append(getDepartmentCategoryId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.roles.model.SPRoles");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spRoleId</column-name><column-value><![CDATA[");
		sb.append(getSpRoleId());
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
			"<column><column-name>roleId</column-name><column-value><![CDATA[");
		sb.append(getRoleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId1</column-name><column-value><![CDATA[");
		sb.append(getCategoryId1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categoryId2</column-name><column-value><![CDATA[");
		sb.append(getCategoryId2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCategoryId</column-name><column-value><![CDATA[");
		sb.append(getCountryCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>departmentCategoryId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentCategoryId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _spRoleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _roleId;
	private long _categoryId1;
	private long _categoryId2;
	private long _countryCategoryId;
	private long _departmentCategoryId;
	private BaseModel<?> _spRolesRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.roles.service.ClpSerializer.class;
}