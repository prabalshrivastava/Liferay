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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPUserTypeConfig}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPUserTypeConfig
 * @generated
 */
public class SPUserTypeConfigWrapper implements SPUserTypeConfig,
	ModelWrapper<SPUserTypeConfig> {
	public SPUserTypeConfigWrapper(SPUserTypeConfig spUserTypeConfig) {
		_spUserTypeConfig = spUserTypeConfig;
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

	/**
	* Returns the primary key of this s p user type config.
	*
	* @return the primary key of this s p user type config
	*/
	@Override
	public long getPrimaryKey() {
		return _spUserTypeConfig.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p user type config.
	*
	* @param primaryKey the primary key of this s p user type config
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spUserTypeConfig.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p user type config.
	*
	* @return the uuid of this s p user type config
	*/
	@Override
	public java.lang.String getUuid() {
		return _spUserTypeConfig.getUuid();
	}

	/**
	* Sets the uuid of this s p user type config.
	*
	* @param uuid the uuid of this s p user type config
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spUserTypeConfig.setUuid(uuid);
	}

	/**
	* Returns the sp user type config ID of this s p user type config.
	*
	* @return the sp user type config ID of this s p user type config
	*/
	@Override
	public long getSpUserTypeConfigId() {
		return _spUserTypeConfig.getSpUserTypeConfigId();
	}

	/**
	* Sets the sp user type config ID of this s p user type config.
	*
	* @param spUserTypeConfigId the sp user type config ID of this s p user type config
	*/
	@Override
	public void setSpUserTypeConfigId(long spUserTypeConfigId) {
		_spUserTypeConfig.setSpUserTypeConfigId(spUserTypeConfigId);
	}

	/**
	* Returns the user type of this s p user type config.
	*
	* @return the user type of this s p user type config
	*/
	@Override
	public java.lang.String getUserType() {
		return _spUserTypeConfig.getUserType();
	}

	/**
	* Sets the user type of this s p user type config.
	*
	* @param userType the user type of this s p user type config
	*/
	@Override
	public void setUserType(java.lang.String userType) {
		_spUserTypeConfig.setUserType(userType);
	}

	/**
	* Returns the user type ID of this s p user type config.
	*
	* @return the user type ID of this s p user type config
	*/
	@Override
	public long getUserTypeId() {
		return _spUserTypeConfig.getUserTypeId();
	}

	/**
	* Sets the user type ID of this s p user type config.
	*
	* @param userTypeId the user type ID of this s p user type config
	*/
	@Override
	public void setUserTypeId(long userTypeId) {
		_spUserTypeConfig.setUserTypeId(userTypeId);
	}

	/**
	* Returns the virtual host ID of this s p user type config.
	*
	* @return the virtual host ID of this s p user type config
	*/
	@Override
	public long getVirtualHostId() {
		return _spUserTypeConfig.getVirtualHostId();
	}

	/**
	* Sets the virtual host ID of this s p user type config.
	*
	* @param virtualHostId the virtual host ID of this s p user type config
	*/
	@Override
	public void setVirtualHostId(long virtualHostId) {
		_spUserTypeConfig.setVirtualHostId(virtualHostId);
	}

	/**
	* Returns the declaration ID of this s p user type config.
	*
	* @return the declaration ID of this s p user type config
	*/
	@Override
	public long getDeclarationId() {
		return _spUserTypeConfig.getDeclarationId();
	}

	/**
	* Sets the declaration ID of this s p user type config.
	*
	* @param declarationId the declaration ID of this s p user type config
	*/
	@Override
	public void setDeclarationId(long declarationId) {
		_spUserTypeConfig.setDeclarationId(declarationId);
	}

	/**
	* Returns the declaration yearly of this s p user type config.
	*
	* @return the declaration yearly of this s p user type config
	*/
	@Override
	public boolean getDeclarationYearly() {
		return _spUserTypeConfig.getDeclarationYearly();
	}

	/**
	* Returns <code>true</code> if this s p user type config is declaration yearly.
	*
	* @return <code>true</code> if this s p user type config is declaration yearly; <code>false</code> otherwise
	*/
	@Override
	public boolean isDeclarationYearly() {
		return _spUserTypeConfig.isDeclarationYearly();
	}

	/**
	* Sets whether this s p user type config is declaration yearly.
	*
	* @param declarationYearly the declaration yearly of this s p user type config
	*/
	@Override
	public void setDeclarationYearly(boolean declarationYearly) {
		_spUserTypeConfig.setDeclarationYearly(declarationYearly);
	}

	/**
	* Returns the declaration fixed date of this s p user type config.
	*
	* @return the declaration fixed date of this s p user type config
	*/
	@Override
	public java.util.Date getDeclarationFixedDate() {
		return _spUserTypeConfig.getDeclarationFixedDate();
	}

	/**
	* Sets the declaration fixed date of this s p user type config.
	*
	* @param declarationFixedDate the declaration fixed date of this s p user type config
	*/
	@Override
	public void setDeclarationFixedDate(java.util.Date declarationFixedDate) {
		_spUserTypeConfig.setDeclarationFixedDate(declarationFixedDate);
	}

	/**
	* Returns the pdpa ID of this s p user type config.
	*
	* @return the pdpa ID of this s p user type config
	*/
	@Override
	public long getPdpaId() {
		return _spUserTypeConfig.getPdpaId();
	}

	/**
	* Sets the pdpa ID of this s p user type config.
	*
	* @param pdpaId the pdpa ID of this s p user type config
	*/
	@Override
	public void setPdpaId(long pdpaId) {
		_spUserTypeConfig.setPdpaId(pdpaId);
	}

	/**
	* Returns the account creation template name of this s p user type config.
	*
	* @return the account creation template name of this s p user type config
	*/
	@Override
	public java.lang.String getAccountCreationTemplateName() {
		return _spUserTypeConfig.getAccountCreationTemplateName();
	}

	/**
	* Sets the account creation template name of this s p user type config.
	*
	* @param accountCreationTemplateName the account creation template name of this s p user type config
	*/
	@Override
	public void setAccountCreationTemplateName(
		java.lang.String accountCreationTemplateName) {
		_spUserTypeConfig.setAccountCreationTemplateName(accountCreationTemplateName);
	}

	/**
	* Returns the welcome template name of this s p user type config.
	*
	* @return the welcome template name of this s p user type config
	*/
	@Override
	public java.lang.String getWelcomeTemplateName() {
		return _spUserTypeConfig.getWelcomeTemplateName();
	}

	/**
	* Sets the welcome template name of this s p user type config.
	*
	* @param welcomeTemplateName the welcome template name of this s p user type config
	*/
	@Override
	public void setWelcomeTemplateName(java.lang.String welcomeTemplateName) {
		_spUserTypeConfig.setWelcomeTemplateName(welcomeTemplateName);
	}

	/**
	* Returns the password change template name of this s p user type config.
	*
	* @return the password change template name of this s p user type config
	*/
	@Override
	public java.lang.String getPasswordChangeTemplateName() {
		return _spUserTypeConfig.getPasswordChangeTemplateName();
	}

	/**
	* Sets the password change template name of this s p user type config.
	*
	* @param passwordChangeTemplateName the password change template name of this s p user type config
	*/
	@Override
	public void setPasswordChangeTemplateName(
		java.lang.String passwordChangeTemplateName) {
		_spUserTypeConfig.setPasswordChangeTemplateName(passwordChangeTemplateName);
	}

	/**
	* Returns the password reset template name of this s p user type config.
	*
	* @return the password reset template name of this s p user type config
	*/
	@Override
	public java.lang.String getPasswordResetTemplateName() {
		return _spUserTypeConfig.getPasswordResetTemplateName();
	}

	/**
	* Sets the password reset template name of this s p user type config.
	*
	* @param passwordResetTemplateName the password reset template name of this s p user type config
	*/
	@Override
	public void setPasswordResetTemplateName(
		java.lang.String passwordResetTemplateName) {
		_spUserTypeConfig.setPasswordResetTemplateName(passwordResetTemplateName);
	}

	/**
	* Returns the email verification template name of this s p user type config.
	*
	* @return the email verification template name of this s p user type config
	*/
	@Override
	public java.lang.String getEmailVerificationTemplateName() {
		return _spUserTypeConfig.getEmailVerificationTemplateName();
	}

	/**
	* Sets the email verification template name of this s p user type config.
	*
	* @param emailVerificationTemplateName the email verification template name of this s p user type config
	*/
	@Override
	public void setEmailVerificationTemplateName(
		java.lang.String emailVerificationTemplateName) {
		_spUserTypeConfig.setEmailVerificationTemplateName(emailVerificationTemplateName);
	}

	/**
	* Returns the defaule role IDs of this s p user type config.
	*
	* @return the defaule role IDs of this s p user type config
	*/
	@Override
	public java.lang.String getDefauleRoleIds() {
		return _spUserTypeConfig.getDefauleRoleIds();
	}

	/**
	* Sets the defaule role IDs of this s p user type config.
	*
	* @param defauleRoleIds the defaule role IDs of this s p user type config
	*/
	@Override
	public void setDefauleRoleIds(java.lang.String defauleRoleIds) {
		_spUserTypeConfig.setDefauleRoleIds(defauleRoleIds);
	}

	/**
	* Returns the validations of this s p user type config.
	*
	* @return the validations of this s p user type config
	*/
	@Override
	public java.lang.String getValidations() {
		return _spUserTypeConfig.getValidations();
	}

	/**
	* Sets the validations of this s p user type config.
	*
	* @param validations the validations of this s p user type config
	*/
	@Override
	public void setValidations(java.lang.String validations) {
		_spUserTypeConfig.setValidations(validations);
	}

	/**
	* Returns the group ID of this s p user type config.
	*
	* @return the group ID of this s p user type config
	*/
	@Override
	public long getGroupId() {
		return _spUserTypeConfig.getGroupId();
	}

	/**
	* Sets the group ID of this s p user type config.
	*
	* @param groupId the group ID of this s p user type config
	*/
	@Override
	public void setGroupId(long groupId) {
		_spUserTypeConfig.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p user type config.
	*
	* @return the company ID of this s p user type config
	*/
	@Override
	public long getCompanyId() {
		return _spUserTypeConfig.getCompanyId();
	}

	/**
	* Sets the company ID of this s p user type config.
	*
	* @param companyId the company ID of this s p user type config
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spUserTypeConfig.setCompanyId(companyId);
	}

	/**
	* Returns the created by of this s p user type config.
	*
	* @return the created by of this s p user type config
	*/
	@Override
	public long getCreatedBy() {
		return _spUserTypeConfig.getCreatedBy();
	}

	/**
	* Sets the created by of this s p user type config.
	*
	* @param createdBy the created by of this s p user type config
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_spUserTypeConfig.setCreatedBy(createdBy);
	}

	/**
	* Returns the modified by of this s p user type config.
	*
	* @return the modified by of this s p user type config
	*/
	@Override
	public long getModifiedBy() {
		return _spUserTypeConfig.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p user type config.
	*
	* @param modifiedBy the modified by of this s p user type config
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_spUserTypeConfig.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the created date of this s p user type config.
	*
	* @return the created date of this s p user type config
	*/
	@Override
	public java.util.Date getCreatedDate() {
		return _spUserTypeConfig.getCreatedDate();
	}

	/**
	* Sets the created date of this s p user type config.
	*
	* @param createdDate the created date of this s p user type config
	*/
	@Override
	public void setCreatedDate(java.util.Date createdDate) {
		_spUserTypeConfig.setCreatedDate(createdDate);
	}

	/**
	* Returns the modified date of this s p user type config.
	*
	* @return the modified date of this s p user type config
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spUserTypeConfig.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p user type config.
	*
	* @param modifiedDate the modified date of this s p user type config
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spUserTypeConfig.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spUserTypeConfig.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spUserTypeConfig.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spUserTypeConfig.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spUserTypeConfig.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spUserTypeConfig.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spUserTypeConfig.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spUserTypeConfig.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spUserTypeConfig.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spUserTypeConfig.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spUserTypeConfig.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spUserTypeConfig.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPUserTypeConfigWrapper((SPUserTypeConfig)_spUserTypeConfig.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPUserTypeConfig spUserTypeConfig) {
		return _spUserTypeConfig.compareTo(spUserTypeConfig);
	}

	@Override
	public int hashCode() {
		return _spUserTypeConfig.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPUserTypeConfig> toCacheModel() {
		return _spUserTypeConfig.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig toEscapedModel() {
		return new SPUserTypeConfigWrapper(_spUserTypeConfig.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPUserTypeConfig toUnescapedModel() {
		return new SPUserTypeConfigWrapper(_spUserTypeConfig.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spUserTypeConfig.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spUserTypeConfig.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spUserTypeConfig.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPUserTypeConfigWrapper)) {
			return false;
		}

		SPUserTypeConfigWrapper spUserTypeConfigWrapper = (SPUserTypeConfigWrapper)obj;

		if (Validator.equals(_spUserTypeConfig,
					spUserTypeConfigWrapper._spUserTypeConfig)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPUserTypeConfig getWrappedSPUserTypeConfig() {
		return _spUserTypeConfig;
	}

	@Override
	public SPUserTypeConfig getWrappedModel() {
		return _spUserTypeConfig;
	}

	@Override
	public void resetOriginalValues() {
		_spUserTypeConfig.resetOriginalValues();
	}

	private SPUserTypeConfig _spUserTypeConfig;
}