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
import com.sambaash.platform.srv.spservices.service.SPLdapMappingLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPLdapMappingClp extends BaseModelImpl<SPLdapMapping>
	implements SPLdapMapping {
	public SPLdapMappingClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPLdapMapping.class;
	}

	@Override
	public String getModelClassName() {
		return SPLdapMapping.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spLdapMappingId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpLdapMappingId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spLdapMappingId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spLdapMappingId", getSpLdapMappingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("countryDepartmentId", getCountryDepartmentId());
		attributes.put("ldapCountry", getLdapCountry());
		attributes.put("ldapDepartment", getLdapDepartment());
		attributes.put("ldapCompany", getLdapCompany());
		attributes.put("defaultRoleId", getDefaultRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spLdapMappingId = (Long)attributes.get("spLdapMappingId");

		if (spLdapMappingId != null) {
			setSpLdapMappingId(spLdapMappingId);
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

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long countryDepartmentId = (Long)attributes.get("countryDepartmentId");

		if (countryDepartmentId != null) {
			setCountryDepartmentId(countryDepartmentId);
		}

		String ldapCountry = (String)attributes.get("ldapCountry");

		if (ldapCountry != null) {
			setLdapCountry(ldapCountry);
		}

		String ldapDepartment = (String)attributes.get("ldapDepartment");

		if (ldapDepartment != null) {
			setLdapDepartment(ldapDepartment);
		}

		String ldapCompany = (String)attributes.get("ldapCompany");

		if (ldapCompany != null) {
			setLdapCompany(ldapCompany);
		}

		Long defaultRoleId = (Long)attributes.get("defaultRoleId");

		if (defaultRoleId != null) {
			setDefaultRoleId(defaultRoleId);
		}
	}

	@Override
	public long getSpLdapMappingId() {
		return _spLdapMappingId;
	}

	@Override
	public void setSpLdapMappingId(long spLdapMappingId) {
		_spLdapMappingId = spLdapMappingId;

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setSpLdapMappingId", long.class);

				method.invoke(_spLdapMappingRemoteModel, spLdapMappingId);
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

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spLdapMappingRemoteModel, groupId);
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

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spLdapMappingRemoteModel, companyId);
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

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spLdapMappingRemoteModel, userId);
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

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spLdapMappingRemoteModel, userName);
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

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spLdapMappingRemoteModel, createDate);
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

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spLdapMappingRemoteModel, modifiedDate);
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

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_spLdapMappingRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDepartmentId() {
		return _departmentId;
	}

	@Override
	public void setDepartmentId(long departmentId) {
		_departmentId = departmentId;

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartmentId", long.class);

				method.invoke(_spLdapMappingRemoteModel, departmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCountryDepartmentId() {
		return _countryDepartmentId;
	}

	@Override
	public void setCountryDepartmentId(long countryDepartmentId) {
		_countryDepartmentId = countryDepartmentId;

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryDepartmentId",
						long.class);

				method.invoke(_spLdapMappingRemoteModel, countryDepartmentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdapCountry() {
		return _ldapCountry;
	}

	@Override
	public void setLdapCountry(String ldapCountry) {
		_ldapCountry = ldapCountry;

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setLdapCountry", String.class);

				method.invoke(_spLdapMappingRemoteModel, ldapCountry);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdapDepartment() {
		return _ldapDepartment;
	}

	@Override
	public void setLdapDepartment(String ldapDepartment) {
		_ldapDepartment = ldapDepartment;

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setLdapDepartment",
						String.class);

				method.invoke(_spLdapMappingRemoteModel, ldapDepartment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLdapCompany() {
		return _ldapCompany;
	}

	@Override
	public void setLdapCompany(String ldapCompany) {
		_ldapCompany = ldapCompany;

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setLdapCompany", String.class);

				method.invoke(_spLdapMappingRemoteModel, ldapCompany);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDefaultRoleId() {
		return _defaultRoleId;
	}

	@Override
	public void setDefaultRoleId(long defaultRoleId) {
		_defaultRoleId = defaultRoleId;

		if (_spLdapMappingRemoteModel != null) {
			try {
				Class<?> clazz = _spLdapMappingRemoteModel.getClass();

				Method method = clazz.getMethod("setDefaultRoleId", long.class);

				method.invoke(_spLdapMappingRemoteModel, defaultRoleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPLdapMappingRemoteModel() {
		return _spLdapMappingRemoteModel;
	}

	public void setSPLdapMappingRemoteModel(
		BaseModel<?> spLdapMappingRemoteModel) {
		_spLdapMappingRemoteModel = spLdapMappingRemoteModel;
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

		Class<?> remoteModelClass = _spLdapMappingRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spLdapMappingRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPLdapMappingLocalServiceUtil.addSPLdapMapping(this);
		}
		else {
			SPLdapMappingLocalServiceUtil.updateSPLdapMapping(this);
		}
	}

	@Override
	public SPLdapMapping toEscapedModel() {
		return (SPLdapMapping)ProxyUtil.newProxyInstance(SPLdapMapping.class.getClassLoader(),
			new Class[] { SPLdapMapping.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPLdapMappingClp clone = new SPLdapMappingClp();

		clone.setSpLdapMappingId(getSpLdapMappingId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryId(getCountryId());
		clone.setDepartmentId(getDepartmentId());
		clone.setCountryDepartmentId(getCountryDepartmentId());
		clone.setLdapCountry(getLdapCountry());
		clone.setLdapDepartment(getLdapDepartment());
		clone.setLdapCompany(getLdapCompany());
		clone.setDefaultRoleId(getDefaultRoleId());

		return clone;
	}

	@Override
	public int compareTo(SPLdapMapping spLdapMapping) {
		int value = 0;

		if (getSpLdapMappingId() < spLdapMapping.getSpLdapMappingId()) {
			value = -1;
		}
		else if (getSpLdapMappingId() > spLdapMapping.getSpLdapMappingId()) {
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

		if (!(obj instanceof SPLdapMappingClp)) {
			return false;
		}

		SPLdapMappingClp spLdapMapping = (SPLdapMappingClp)obj;

		long primaryKey = spLdapMapping.getPrimaryKey();

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

		sb.append("{spLdapMappingId=");
		sb.append(getSpLdapMappingId());
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
		sb.append(", departmentId=");
		sb.append(getDepartmentId());
		sb.append(", countryDepartmentId=");
		sb.append(getCountryDepartmentId());
		sb.append(", ldapCountry=");
		sb.append(getLdapCountry());
		sb.append(", ldapDepartment=");
		sb.append(getLdapDepartment());
		sb.append(", ldapCompany=");
		sb.append(getLdapCompany());
		sb.append(", defaultRoleId=");
		sb.append(getDefaultRoleId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPLdapMapping");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spLdapMappingId</column-name><column-value><![CDATA[");
		sb.append(getSpLdapMappingId());
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
			"<column><column-name>departmentId</column-name><column-value><![CDATA[");
		sb.append(getDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryDepartmentId</column-name><column-value><![CDATA[");
		sb.append(getCountryDepartmentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldapCountry</column-name><column-value><![CDATA[");
		sb.append(getLdapCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldapDepartment</column-name><column-value><![CDATA[");
		sb.append(getLdapDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ldapCompany</column-name><column-value><![CDATA[");
		sb.append(getLdapCompany());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defaultRoleId</column-name><column-value><![CDATA[");
		sb.append(getDefaultRoleId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spLdapMappingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private long _departmentId;
	private long _countryDepartmentId;
	private String _ldapCountry;
	private String _ldapDepartment;
	private String _ldapCompany;
	private long _defaultRoleId;
	private BaseModel<?> _spLdapMappingRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}