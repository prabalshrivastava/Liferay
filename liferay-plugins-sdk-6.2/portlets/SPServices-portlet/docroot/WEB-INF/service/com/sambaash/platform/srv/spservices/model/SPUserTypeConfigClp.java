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

import com.sambaash.platform.srv.spservices.service.ClpSerializer;
import com.sambaash.platform.srv.spservices.service.SPUserTypeConfigLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SPUserTypeConfigClp extends BaseModelImpl<SPUserTypeConfig>
	implements SPUserTypeConfig {
	public SPUserTypeConfigClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPUserTypeConfig.class;
	}

	@Override
	public String getModelClassName() {
		return SPUserTypeConfig.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spUserTypeConfigId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpUserTypeConfigId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spUserTypeConfigId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spUserTypeConfigId", getSpUserTypeConfigId());
		attributes.put("userType", getUserType());
		attributes.put("userTypeId", getUserTypeId());
		attributes.put("virtualHostId", getVirtualHostId());
		attributes.put("declarationId", getDeclarationId());
		attributes.put("declarationYearly", getDeclarationYearly());
		attributes.put("declarationFixedDate", getDeclarationFixedDate());
		attributes.put("pdpaId", getPdpaId());
		attributes.put("accountCreationTemplateName",
			getAccountCreationTemplateName());
		attributes.put("welcomeTemplateName", getWelcomeTemplateName());
		attributes.put("passwordChangeTemplateName",
			getPasswordChangeTemplateName());
		attributes.put("passwordResetTemplateName",
			getPasswordResetTemplateName());
		attributes.put("emailVerificationTemplateName",
			getEmailVerificationTemplateName());
		attributes.put("defauleRoleIds", getDefauleRoleIds());
		attributes.put("validations", getValidations());
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

		Long spUserTypeConfigId = (Long)attributes.get("spUserTypeConfigId");

		if (spUserTypeConfigId != null) {
			setSpUserTypeConfigId(spUserTypeConfigId);
		}

		String userType = (String)attributes.get("userType");

		if (userType != null) {
			setUserType(userType);
		}

		Long userTypeId = (Long)attributes.get("userTypeId");

		if (userTypeId != null) {
			setUserTypeId(userTypeId);
		}

		Long virtualHostId = (Long)attributes.get("virtualHostId");

		if (virtualHostId != null) {
			setVirtualHostId(virtualHostId);
		}

		Long declarationId = (Long)attributes.get("declarationId");

		if (declarationId != null) {
			setDeclarationId(declarationId);
		}

		Boolean declarationYearly = (Boolean)attributes.get("declarationYearly");

		if (declarationYearly != null) {
			setDeclarationYearly(declarationYearly);
		}

		Date declarationFixedDate = (Date)attributes.get("declarationFixedDate");

		if (declarationFixedDate != null) {
			setDeclarationFixedDate(declarationFixedDate);
		}

		Long pdpaId = (Long)attributes.get("pdpaId");

		if (pdpaId != null) {
			setPdpaId(pdpaId);
		}

		String accountCreationTemplateName = (String)attributes.get(
				"accountCreationTemplateName");

		if (accountCreationTemplateName != null) {
			setAccountCreationTemplateName(accountCreationTemplateName);
		}

		String welcomeTemplateName = (String)attributes.get(
				"welcomeTemplateName");

		if (welcomeTemplateName != null) {
			setWelcomeTemplateName(welcomeTemplateName);
		}

		String passwordChangeTemplateName = (String)attributes.get(
				"passwordChangeTemplateName");

		if (passwordChangeTemplateName != null) {
			setPasswordChangeTemplateName(passwordChangeTemplateName);
		}

		String passwordResetTemplateName = (String)attributes.get(
				"passwordResetTemplateName");

		if (passwordResetTemplateName != null) {
			setPasswordResetTemplateName(passwordResetTemplateName);
		}

		String emailVerificationTemplateName = (String)attributes.get(
				"emailVerificationTemplateName");

		if (emailVerificationTemplateName != null) {
			setEmailVerificationTemplateName(emailVerificationTemplateName);
		}

		String defauleRoleIds = (String)attributes.get("defauleRoleIds");

		if (defauleRoleIds != null) {
			setDefauleRoleIds(defauleRoleIds);
		}

		String validations = (String)attributes.get("validations");

		if (validations != null) {
			setValidations(validations);
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

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_spUserTypeConfigRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getSpUserTypeConfigId() {
		return _spUserTypeConfigId;
	}

	@Override
	public void setSpUserTypeConfigId(long spUserTypeConfigId) {
		_spUserTypeConfigId = spUserTypeConfigId;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setSpUserTypeConfigId",
						long.class);

				method.invoke(_spUserTypeConfigRemoteModel, spUserTypeConfigId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserType() {
		return _userType;
	}

	@Override
	public void setUserType(String userType) {
		_userType = userType;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setUserType", String.class);

				method.invoke(_spUserTypeConfigRemoteModel, userType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserTypeId() {
		return _userTypeId;
	}

	@Override
	public void setUserTypeId(long userTypeId) {
		_userTypeId = userTypeId;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setUserTypeId", long.class);

				method.invoke(_spUserTypeConfigRemoteModel, userTypeId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getVirtualHostId() {
		return _virtualHostId;
	}

	@Override
	public void setVirtualHostId(long virtualHostId) {
		_virtualHostId = virtualHostId;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setVirtualHostId", long.class);

				method.invoke(_spUserTypeConfigRemoteModel, virtualHostId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDeclarationId() {
		return _declarationId;
	}

	@Override
	public void setDeclarationId(long declarationId) {
		_declarationId = declarationId;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setDeclarationId", long.class);

				method.invoke(_spUserTypeConfigRemoteModel, declarationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDeclarationYearly() {
		return _declarationYearly;
	}

	@Override
	public boolean isDeclarationYearly() {
		return _declarationYearly;
	}

	@Override
	public void setDeclarationYearly(boolean declarationYearly) {
		_declarationYearly = declarationYearly;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setDeclarationYearly",
						boolean.class);

				method.invoke(_spUserTypeConfigRemoteModel, declarationYearly);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getDeclarationFixedDate() {
		return _declarationFixedDate;
	}

	@Override
	public void setDeclarationFixedDate(Date declarationFixedDate) {
		_declarationFixedDate = declarationFixedDate;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setDeclarationFixedDate",
						Date.class);

				method.invoke(_spUserTypeConfigRemoteModel, declarationFixedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPdpaId() {
		return _pdpaId;
	}

	@Override
	public void setPdpaId(long pdpaId) {
		_pdpaId = pdpaId;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setPdpaId", long.class);

				method.invoke(_spUserTypeConfigRemoteModel, pdpaId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAccountCreationTemplateName() {
		return _accountCreationTemplateName;
	}

	@Override
	public void setAccountCreationTemplateName(
		String accountCreationTemplateName) {
		_accountCreationTemplateName = accountCreationTemplateName;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setAccountCreationTemplateName",
						String.class);

				method.invoke(_spUserTypeConfigRemoteModel,
					accountCreationTemplateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWelcomeTemplateName() {
		return _welcomeTemplateName;
	}

	@Override
	public void setWelcomeTemplateName(String welcomeTemplateName) {
		_welcomeTemplateName = welcomeTemplateName;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setWelcomeTemplateName",
						String.class);

				method.invoke(_spUserTypeConfigRemoteModel, welcomeTemplateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPasswordChangeTemplateName() {
		return _passwordChangeTemplateName;
	}

	@Override
	public void setPasswordChangeTemplateName(String passwordChangeTemplateName) {
		_passwordChangeTemplateName = passwordChangeTemplateName;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setPasswordChangeTemplateName",
						String.class);

				method.invoke(_spUserTypeConfigRemoteModel,
					passwordChangeTemplateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPasswordResetTemplateName() {
		return _passwordResetTemplateName;
	}

	@Override
	public void setPasswordResetTemplateName(String passwordResetTemplateName) {
		_passwordResetTemplateName = passwordResetTemplateName;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setPasswordResetTemplateName",
						String.class);

				method.invoke(_spUserTypeConfigRemoteModel,
					passwordResetTemplateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailVerificationTemplateName() {
		return _emailVerificationTemplateName;
	}

	@Override
	public void setEmailVerificationTemplateName(
		String emailVerificationTemplateName) {
		_emailVerificationTemplateName = emailVerificationTemplateName;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailVerificationTemplateName",
						String.class);

				method.invoke(_spUserTypeConfigRemoteModel,
					emailVerificationTemplateName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDefauleRoleIds() {
		return _defauleRoleIds;
	}

	@Override
	public void setDefauleRoleIds(String defauleRoleIds) {
		_defauleRoleIds = defauleRoleIds;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setDefauleRoleIds",
						String.class);

				method.invoke(_spUserTypeConfigRemoteModel, defauleRoleIds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValidations() {
		return _validations;
	}

	@Override
	public void setValidations(String validations) {
		_validations = validations;

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setValidations", String.class);

				method.invoke(_spUserTypeConfigRemoteModel, validations);
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

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spUserTypeConfigRemoteModel, groupId);
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

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_spUserTypeConfigRemoteModel, companyId);
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

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", long.class);

				method.invoke(_spUserTypeConfigRemoteModel, createdBy);
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

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedBy", long.class);

				method.invoke(_spUserTypeConfigRemoteModel, modifiedBy);
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

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_spUserTypeConfigRemoteModel, createdDate);
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

		if (_spUserTypeConfigRemoteModel != null) {
			try {
				Class<?> clazz = _spUserTypeConfigRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spUserTypeConfigRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPUserTypeConfigRemoteModel() {
		return _spUserTypeConfigRemoteModel;
	}

	public void setSPUserTypeConfigRemoteModel(
		BaseModel<?> spUserTypeConfigRemoteModel) {
		_spUserTypeConfigRemoteModel = spUserTypeConfigRemoteModel;
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

		Class<?> remoteModelClass = _spUserTypeConfigRemoteModel.getClass();

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

		Object returnValue = method.invoke(_spUserTypeConfigRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPUserTypeConfigLocalServiceUtil.addSPUserTypeConfig(this);
		}
		else {
			SPUserTypeConfigLocalServiceUtil.updateSPUserTypeConfig(this);
		}
	}

	@Override
	public SPUserTypeConfig toEscapedModel() {
		return (SPUserTypeConfig)ProxyUtil.newProxyInstance(SPUserTypeConfig.class.getClassLoader(),
			new Class[] { SPUserTypeConfig.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPUserTypeConfigClp clone = new SPUserTypeConfigClp();

		clone.setUuid(getUuid());
		clone.setSpUserTypeConfigId(getSpUserTypeConfigId());
		clone.setUserType(getUserType());
		clone.setUserTypeId(getUserTypeId());
		clone.setVirtualHostId(getVirtualHostId());
		clone.setDeclarationId(getDeclarationId());
		clone.setDeclarationYearly(getDeclarationYearly());
		clone.setDeclarationFixedDate(getDeclarationFixedDate());
		clone.setPdpaId(getPdpaId());
		clone.setAccountCreationTemplateName(getAccountCreationTemplateName());
		clone.setWelcomeTemplateName(getWelcomeTemplateName());
		clone.setPasswordChangeTemplateName(getPasswordChangeTemplateName());
		clone.setPasswordResetTemplateName(getPasswordResetTemplateName());
		clone.setEmailVerificationTemplateName(getEmailVerificationTemplateName());
		clone.setDefauleRoleIds(getDefauleRoleIds());
		clone.setValidations(getValidations());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreatedBy(getCreatedBy());
		clone.setModifiedBy(getModifiedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setModifiedDate(getModifiedDate());

		return clone;
	}

	@Override
	public int compareTo(SPUserTypeConfig spUserTypeConfig) {
		long primaryKey = spUserTypeConfig.getPrimaryKey();

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

		if (!(obj instanceof SPUserTypeConfigClp)) {
			return false;
		}

		SPUserTypeConfigClp spUserTypeConfig = (SPUserTypeConfigClp)obj;

		long primaryKey = spUserTypeConfig.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", spUserTypeConfigId=");
		sb.append(getSpUserTypeConfigId());
		sb.append(", userType=");
		sb.append(getUserType());
		sb.append(", userTypeId=");
		sb.append(getUserTypeId());
		sb.append(", virtualHostId=");
		sb.append(getVirtualHostId());
		sb.append(", declarationId=");
		sb.append(getDeclarationId());
		sb.append(", declarationYearly=");
		sb.append(getDeclarationYearly());
		sb.append(", declarationFixedDate=");
		sb.append(getDeclarationFixedDate());
		sb.append(", pdpaId=");
		sb.append(getPdpaId());
		sb.append(", accountCreationTemplateName=");
		sb.append(getAccountCreationTemplateName());
		sb.append(", welcomeTemplateName=");
		sb.append(getWelcomeTemplateName());
		sb.append(", passwordChangeTemplateName=");
		sb.append(getPasswordChangeTemplateName());
		sb.append(", passwordResetTemplateName=");
		sb.append(getPasswordResetTemplateName());
		sb.append(", emailVerificationTemplateName=");
		sb.append(getEmailVerificationTemplateName());
		sb.append(", defauleRoleIds=");
		sb.append(getDefauleRoleIds());
		sb.append(", validations=");
		sb.append(getValidations());
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
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.spservices.model.SPUserTypeConfig");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>spUserTypeConfigId</column-name><column-value><![CDATA[");
		sb.append(getSpUserTypeConfigId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userType</column-name><column-value><![CDATA[");
		sb.append(getUserType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userTypeId</column-name><column-value><![CDATA[");
		sb.append(getUserTypeId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>virtualHostId</column-name><column-value><![CDATA[");
		sb.append(getVirtualHostId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>declarationId</column-name><column-value><![CDATA[");
		sb.append(getDeclarationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>declarationYearly</column-name><column-value><![CDATA[");
		sb.append(getDeclarationYearly());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>declarationFixedDate</column-name><column-value><![CDATA[");
		sb.append(getDeclarationFixedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdpaId</column-name><column-value><![CDATA[");
		sb.append(getPdpaId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>accountCreationTemplateName</column-name><column-value><![CDATA[");
		sb.append(getAccountCreationTemplateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>welcomeTemplateName</column-name><column-value><![CDATA[");
		sb.append(getWelcomeTemplateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passwordChangeTemplateName</column-name><column-value><![CDATA[");
		sb.append(getPasswordChangeTemplateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>passwordResetTemplateName</column-name><column-value><![CDATA[");
		sb.append(getPasswordResetTemplateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailVerificationTemplateName</column-name><column-value><![CDATA[");
		sb.append(getEmailVerificationTemplateName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>defauleRoleIds</column-name><column-value><![CDATA[");
		sb.append(getDefauleRoleIds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validations</column-name><column-value><![CDATA[");
		sb.append(getValidations());
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
	private long _spUserTypeConfigId;
	private String _userType;
	private long _userTypeId;
	private long _virtualHostId;
	private long _declarationId;
	private boolean _declarationYearly;
	private Date _declarationFixedDate;
	private long _pdpaId;
	private String _accountCreationTemplateName;
	private String _welcomeTemplateName;
	private String _passwordChangeTemplateName;
	private String _passwordResetTemplateName;
	private String _emailVerificationTemplateName;
	private String _defauleRoleIds;
	private String _validations;
	private long _groupId;
	private long _companyId;
	private long _createdBy;
	private long _modifiedBy;
	private Date _createdDate;
	private Date _modifiedDate;
	private BaseModel<?> _spUserTypeConfigRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spservices.service.ClpSerializer.class;
}