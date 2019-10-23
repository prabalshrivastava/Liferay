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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class SPUserTypeConfigSoap implements Serializable {
	public static SPUserTypeConfigSoap toSoapModel(SPUserTypeConfig model) {
		SPUserTypeConfigSoap soapModel = new SPUserTypeConfigSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpUserTypeConfigId(model.getSpUserTypeConfigId());
		soapModel.setUserType(model.getUserType());
		soapModel.setUserTypeId(model.getUserTypeId());
		soapModel.setVirtualHostId(model.getVirtualHostId());
		soapModel.setDeclarationId(model.getDeclarationId());
		soapModel.setDeclarationYearly(model.getDeclarationYearly());
		soapModel.setDeclarationFixedDate(model.getDeclarationFixedDate());
		soapModel.setPdpaId(model.getPdpaId());
		soapModel.setAccountCreationTemplateName(model.getAccountCreationTemplateName());
		soapModel.setWelcomeTemplateName(model.getWelcomeTemplateName());
		soapModel.setPasswordChangeTemplateName(model.getPasswordChangeTemplateName());
		soapModel.setPasswordResetTemplateName(model.getPasswordResetTemplateName());
		soapModel.setEmailVerificationTemplateName(model.getEmailVerificationTemplateName());
		soapModel.setDefauleRoleIds(model.getDefauleRoleIds());
		soapModel.setValidations(model.getValidations());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreatedBy(model.getCreatedBy());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setCreatedDate(model.getCreatedDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static SPUserTypeConfigSoap[] toSoapModels(SPUserTypeConfig[] models) {
		SPUserTypeConfigSoap[] soapModels = new SPUserTypeConfigSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPUserTypeConfigSoap[][] toSoapModels(
		SPUserTypeConfig[][] models) {
		SPUserTypeConfigSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPUserTypeConfigSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPUserTypeConfigSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPUserTypeConfigSoap[] toSoapModels(
		List<SPUserTypeConfig> models) {
		List<SPUserTypeConfigSoap> soapModels = new ArrayList<SPUserTypeConfigSoap>(models.size());

		for (SPUserTypeConfig model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPUserTypeConfigSoap[soapModels.size()]);
	}

	public SPUserTypeConfigSoap() {
	}

	public long getPrimaryKey() {
		return _spUserTypeConfigId;
	}

	public void setPrimaryKey(long pk) {
		setSpUserTypeConfigId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpUserTypeConfigId() {
		return _spUserTypeConfigId;
	}

	public void setSpUserTypeConfigId(long spUserTypeConfigId) {
		_spUserTypeConfigId = spUserTypeConfigId;
	}

	public String getUserType() {
		return _userType;
	}

	public void setUserType(String userType) {
		_userType = userType;
	}

	public long getUserTypeId() {
		return _userTypeId;
	}

	public void setUserTypeId(long userTypeId) {
		_userTypeId = userTypeId;
	}

	public long getVirtualHostId() {
		return _virtualHostId;
	}

	public void setVirtualHostId(long virtualHostId) {
		_virtualHostId = virtualHostId;
	}

	public long getDeclarationId() {
		return _declarationId;
	}

	public void setDeclarationId(long declarationId) {
		_declarationId = declarationId;
	}

	public boolean getDeclarationYearly() {
		return _declarationYearly;
	}

	public boolean isDeclarationYearly() {
		return _declarationYearly;
	}

	public void setDeclarationYearly(boolean declarationYearly) {
		_declarationYearly = declarationYearly;
	}

	public Date getDeclarationFixedDate() {
		return _declarationFixedDate;
	}

	public void setDeclarationFixedDate(Date declarationFixedDate) {
		_declarationFixedDate = declarationFixedDate;
	}

	public long getPdpaId() {
		return _pdpaId;
	}

	public void setPdpaId(long pdpaId) {
		_pdpaId = pdpaId;
	}

	public String getAccountCreationTemplateName() {
		return _accountCreationTemplateName;
	}

	public void setAccountCreationTemplateName(
		String accountCreationTemplateName) {
		_accountCreationTemplateName = accountCreationTemplateName;
	}

	public String getWelcomeTemplateName() {
		return _welcomeTemplateName;
	}

	public void setWelcomeTemplateName(String welcomeTemplateName) {
		_welcomeTemplateName = welcomeTemplateName;
	}

	public String getPasswordChangeTemplateName() {
		return _passwordChangeTemplateName;
	}

	public void setPasswordChangeTemplateName(String passwordChangeTemplateName) {
		_passwordChangeTemplateName = passwordChangeTemplateName;
	}

	public String getPasswordResetTemplateName() {
		return _passwordResetTemplateName;
	}

	public void setPasswordResetTemplateName(String passwordResetTemplateName) {
		_passwordResetTemplateName = passwordResetTemplateName;
	}

	public String getEmailVerificationTemplateName() {
		return _emailVerificationTemplateName;
	}

	public void setEmailVerificationTemplateName(
		String emailVerificationTemplateName) {
		_emailVerificationTemplateName = emailVerificationTemplateName;
	}

	public String getDefauleRoleIds() {
		return _defauleRoleIds;
	}

	public void setDefauleRoleIds(String defauleRoleIds) {
		_defauleRoleIds = defauleRoleIds;
	}

	public String getValidations() {
		return _validations;
	}

	public void setValidations(String validations) {
		_validations = validations;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getCreatedBy() {
		return _createdBy;
	}

	public void setCreatedBy(long createdBy) {
		_createdBy = createdBy;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getCreatedDate() {
		return _createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
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
}