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
import com.sambaash.platform.srv.service.ModuleLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class ModuleClp extends BaseModelImpl<Module> implements Module {
	public ModuleClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Module.class;
	}

	@Override
	public String getModelClassName() {
		return Module.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spModuleId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpModuleId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spModuleId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spModuleId", getSpModuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("moduleCode", getModuleCode());
		attributes.put("moduleName", getModuleName());
		attributes.put("moduleDesc", getModuleDesc());
		attributes.put("moduleType", getModuleType());
		attributes.put("creditValue", getCreditValue());
		attributes.put("moduleDuration", getModuleDuration());
		attributes.put("noOfSessions", getNoOfSessions());
		attributes.put("generalDesc", getGeneralDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
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

		String moduleCode = (String)attributes.get("moduleCode");

		if (moduleCode != null) {
			setModuleCode(moduleCode);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		String moduleDesc = (String)attributes.get("moduleDesc");

		if (moduleDesc != null) {
			setModuleDesc(moduleDesc);
		}

		Long moduleType = (Long)attributes.get("moduleType");

		if (moduleType != null) {
			setModuleType(moduleType);
		}

		Long creditValue = (Long)attributes.get("creditValue");

		if (creditValue != null) {
			setCreditValue(creditValue);
		}

		String moduleDuration = (String)attributes.get("moduleDuration");

		if (moduleDuration != null) {
			setModuleDuration(moduleDuration);
		}

		Long noOfSessions = (Long)attributes.get("noOfSessions");

		if (noOfSessions != null) {
			setNoOfSessions(noOfSessions);
		}

		String generalDesc = (String)attributes.get("generalDesc");

		if (generalDesc != null) {
			setGeneralDesc(generalDesc);
		}
	}

	@Override
	public long getSpModuleId() {
		return _spModuleId;
	}

	@Override
	public void setSpModuleId(long spModuleId) {
		_spModuleId = spModuleId;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setSpModuleId", long.class);

				method.invoke(_moduleRemoteModel, spModuleId);
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

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_moduleRemoteModel, groupId);
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

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_moduleRemoteModel, companyId);
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

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_moduleRemoteModel, userId);
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

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_moduleRemoteModel, userName);
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

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_moduleRemoteModel, createDate);
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

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_moduleRemoteModel, modifiedDate);
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

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", long.class);

				method.invoke(_moduleRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModuleCode() {
		return _moduleCode;
	}

	@Override
	public void setModuleCode(String moduleCode) {
		_moduleCode = moduleCode;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleCode", String.class);

				method.invoke(_moduleRemoteModel, moduleCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModuleName() {
		return _moduleName;
	}

	@Override
	public void setModuleName(String moduleName) {
		_moduleName = moduleName;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleName", String.class);

				method.invoke(_moduleRemoteModel, moduleName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModuleDesc() {
		return _moduleDesc;
	}

	@Override
	public void setModuleDesc(String moduleDesc) {
		_moduleDesc = moduleDesc;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleDesc", String.class);

				method.invoke(_moduleRemoteModel, moduleDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getModuleType() {
		return _moduleType;
	}

	@Override
	public void setModuleType(long moduleType) {
		_moduleType = moduleType;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleType", long.class);

				method.invoke(_moduleRemoteModel, moduleType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCreditValue() {
		return _creditValue;
	}

	@Override
	public void setCreditValue(long creditValue) {
		_creditValue = creditValue;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setCreditValue", long.class);

				method.invoke(_moduleRemoteModel, creditValue);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getModuleDuration() {
		return _moduleDuration;
	}

	@Override
	public void setModuleDuration(String moduleDuration) {
		_moduleDuration = moduleDuration;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setModuleDuration",
						String.class);

				method.invoke(_moduleRemoteModel, moduleDuration);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNoOfSessions() {
		return _noOfSessions;
	}

	@Override
	public void setNoOfSessions(long noOfSessions) {
		_noOfSessions = noOfSessions;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setNoOfSessions", long.class);

				method.invoke(_moduleRemoteModel, noOfSessions);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGeneralDesc() {
		return _generalDesc;
	}

	@Override
	public void setGeneralDesc(String generalDesc) {
		_generalDesc = generalDesc;

		if (_moduleRemoteModel != null) {
			try {
				Class<?> clazz = _moduleRemoteModel.getClass();

				Method method = clazz.getMethod("setGeneralDesc", String.class);

				method.invoke(_moduleRemoteModel, generalDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getModuleRemoteModel() {
		return _moduleRemoteModel;
	}

	public void setModuleRemoteModel(BaseModel<?> moduleRemoteModel) {
		_moduleRemoteModel = moduleRemoteModel;
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

		Class<?> remoteModelClass = _moduleRemoteModel.getClass();

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

		Object returnValue = method.invoke(_moduleRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			ModuleLocalServiceUtil.addModule(this);
		}
		else {
			ModuleLocalServiceUtil.updateModule(this);
		}
	}

	@Override
	public Module toEscapedModel() {
		return (Module)ProxyUtil.newProxyInstance(Module.class.getClassLoader(),
			new Class[] { Module.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		ModuleClp clone = new ModuleClp();

		clone.setSpModuleId(getSpModuleId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryId(getCountryId());
		clone.setModuleCode(getModuleCode());
		clone.setModuleName(getModuleName());
		clone.setModuleDesc(getModuleDesc());
		clone.setModuleType(getModuleType());
		clone.setCreditValue(getCreditValue());
		clone.setModuleDuration(getModuleDuration());
		clone.setNoOfSessions(getNoOfSessions());
		clone.setGeneralDesc(getGeneralDesc());

		return clone;
	}

	@Override
	public int compareTo(Module module) {
		int value = 0;

		value = getModuleCode().compareTo(module.getModuleCode());

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

		if (!(obj instanceof ModuleClp)) {
			return false;
		}

		ModuleClp module = (ModuleClp)obj;

		long primaryKey = module.getPrimaryKey();

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
		StringBundler sb = new StringBundler(33);

		sb.append("{spModuleId=");
		sb.append(getSpModuleId());
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
		sb.append(", moduleCode=");
		sb.append(getModuleCode());
		sb.append(", moduleName=");
		sb.append(getModuleName());
		sb.append(", moduleDesc=");
		sb.append(getModuleDesc());
		sb.append(", moduleType=");
		sb.append(getModuleType());
		sb.append(", creditValue=");
		sb.append(getCreditValue());
		sb.append(", moduleDuration=");
		sb.append(getModuleDuration());
		sb.append(", noOfSessions=");
		sb.append(getNoOfSessions());
		sb.append(", generalDesc=");
		sb.append(getGeneralDesc());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(52);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Module");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spModuleId</column-name><column-value><![CDATA[");
		sb.append(getSpModuleId());
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
			"<column><column-name>moduleCode</column-name><column-value><![CDATA[");
		sb.append(getModuleCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleName</column-name><column-value><![CDATA[");
		sb.append(getModuleName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleDesc</column-name><column-value><![CDATA[");
		sb.append(getModuleDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleType</column-name><column-value><![CDATA[");
		sb.append(getModuleType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creditValue</column-name><column-value><![CDATA[");
		sb.append(getCreditValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>moduleDuration</column-name><column-value><![CDATA[");
		sb.append(getModuleDuration());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noOfSessions</column-name><column-value><![CDATA[");
		sb.append(getNoOfSessions());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>generalDesc</column-name><column-value><![CDATA[");
		sb.append(getGeneralDesc());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spModuleId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private String _moduleCode;
	private String _moduleName;
	private String _moduleDesc;
	private long _moduleType;
	private long _creditValue;
	private String _moduleDuration;
	private long _noOfSessions;
	private String _generalDesc;
	private BaseModel<?> _moduleRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}