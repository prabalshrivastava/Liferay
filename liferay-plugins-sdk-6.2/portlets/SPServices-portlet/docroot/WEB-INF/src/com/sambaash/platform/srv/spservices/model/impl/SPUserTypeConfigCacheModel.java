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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.SPUserTypeConfig;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPUserTypeConfig in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPUserTypeConfig
 * @generated
 */
public class SPUserTypeConfigCacheModel implements CacheModel<SPUserTypeConfig>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spUserTypeConfigId=");
		sb.append(spUserTypeConfigId);
		sb.append(", userType=");
		sb.append(userType);
		sb.append(", userTypeId=");
		sb.append(userTypeId);
		sb.append(", virtualHostId=");
		sb.append(virtualHostId);
		sb.append(", declarationId=");
		sb.append(declarationId);
		sb.append(", declarationYearly=");
		sb.append(declarationYearly);
		sb.append(", declarationFixedDate=");
		sb.append(declarationFixedDate);
		sb.append(", pdpaId=");
		sb.append(pdpaId);
		sb.append(", accountCreationTemplateName=");
		sb.append(accountCreationTemplateName);
		sb.append(", welcomeTemplateName=");
		sb.append(welcomeTemplateName);
		sb.append(", passwordChangeTemplateName=");
		sb.append(passwordChangeTemplateName);
		sb.append(", passwordResetTemplateName=");
		sb.append(passwordResetTemplateName);
		sb.append(", emailVerificationTemplateName=");
		sb.append(emailVerificationTemplateName);
		sb.append(", defauleRoleIds=");
		sb.append(defauleRoleIds);
		sb.append(", validations=");
		sb.append(validations);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPUserTypeConfig toEntityModel() {
		SPUserTypeConfigImpl spUserTypeConfigImpl = new SPUserTypeConfigImpl();

		if (uuid == null) {
			spUserTypeConfigImpl.setUuid(StringPool.BLANK);
		}
		else {
			spUserTypeConfigImpl.setUuid(uuid);
		}

		spUserTypeConfigImpl.setSpUserTypeConfigId(spUserTypeConfigId);

		if (userType == null) {
			spUserTypeConfigImpl.setUserType(StringPool.BLANK);
		}
		else {
			spUserTypeConfigImpl.setUserType(userType);
		}

		spUserTypeConfigImpl.setUserTypeId(userTypeId);
		spUserTypeConfigImpl.setVirtualHostId(virtualHostId);
		spUserTypeConfigImpl.setDeclarationId(declarationId);
		spUserTypeConfigImpl.setDeclarationYearly(declarationYearly);

		if (declarationFixedDate == Long.MIN_VALUE) {
			spUserTypeConfigImpl.setDeclarationFixedDate(null);
		}
		else {
			spUserTypeConfigImpl.setDeclarationFixedDate(new Date(
					declarationFixedDate));
		}

		spUserTypeConfigImpl.setPdpaId(pdpaId);

		if (accountCreationTemplateName == null) {
			spUserTypeConfigImpl.setAccountCreationTemplateName(StringPool.BLANK);
		}
		else {
			spUserTypeConfigImpl.setAccountCreationTemplateName(accountCreationTemplateName);
		}

		if (welcomeTemplateName == null) {
			spUserTypeConfigImpl.setWelcomeTemplateName(StringPool.BLANK);
		}
		else {
			spUserTypeConfigImpl.setWelcomeTemplateName(welcomeTemplateName);
		}

		if (passwordChangeTemplateName == null) {
			spUserTypeConfigImpl.setPasswordChangeTemplateName(StringPool.BLANK);
		}
		else {
			spUserTypeConfigImpl.setPasswordChangeTemplateName(passwordChangeTemplateName);
		}

		if (passwordResetTemplateName == null) {
			spUserTypeConfigImpl.setPasswordResetTemplateName(StringPool.BLANK);
		}
		else {
			spUserTypeConfigImpl.setPasswordResetTemplateName(passwordResetTemplateName);
		}

		if (emailVerificationTemplateName == null) {
			spUserTypeConfigImpl.setEmailVerificationTemplateName(StringPool.BLANK);
		}
		else {
			spUserTypeConfigImpl.setEmailVerificationTemplateName(emailVerificationTemplateName);
		}

		if (defauleRoleIds == null) {
			spUserTypeConfigImpl.setDefauleRoleIds(StringPool.BLANK);
		}
		else {
			spUserTypeConfigImpl.setDefauleRoleIds(defauleRoleIds);
		}

		if (validations == null) {
			spUserTypeConfigImpl.setValidations(StringPool.BLANK);
		}
		else {
			spUserTypeConfigImpl.setValidations(validations);
		}

		spUserTypeConfigImpl.setGroupId(groupId);
		spUserTypeConfigImpl.setCompanyId(companyId);
		spUserTypeConfigImpl.setCreatedBy(createdBy);
		spUserTypeConfigImpl.setModifiedBy(modifiedBy);

		if (createdDate == Long.MIN_VALUE) {
			spUserTypeConfigImpl.setCreatedDate(null);
		}
		else {
			spUserTypeConfigImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spUserTypeConfigImpl.setModifiedDate(null);
		}
		else {
			spUserTypeConfigImpl.setModifiedDate(new Date(modifiedDate));
		}

		spUserTypeConfigImpl.resetOriginalValues();

		return spUserTypeConfigImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spUserTypeConfigId = objectInput.readLong();
		userType = objectInput.readUTF();
		userTypeId = objectInput.readLong();
		virtualHostId = objectInput.readLong();
		declarationId = objectInput.readLong();
		declarationYearly = objectInput.readBoolean();
		declarationFixedDate = objectInput.readLong();
		pdpaId = objectInput.readLong();
		accountCreationTemplateName = objectInput.readUTF();
		welcomeTemplateName = objectInput.readUTF();
		passwordChangeTemplateName = objectInput.readUTF();
		passwordResetTemplateName = objectInput.readUTF();
		emailVerificationTemplateName = objectInput.readUTF();
		defauleRoleIds = objectInput.readUTF();
		validations = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createdBy = objectInput.readLong();
		modifiedBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(spUserTypeConfigId);

		if (userType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userType);
		}

		objectOutput.writeLong(userTypeId);
		objectOutput.writeLong(virtualHostId);
		objectOutput.writeLong(declarationId);
		objectOutput.writeBoolean(declarationYearly);
		objectOutput.writeLong(declarationFixedDate);
		objectOutput.writeLong(pdpaId);

		if (accountCreationTemplateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accountCreationTemplateName);
		}

		if (welcomeTemplateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(welcomeTemplateName);
		}

		if (passwordChangeTemplateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(passwordChangeTemplateName);
		}

		if (passwordResetTemplateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(passwordResetTemplateName);
		}

		if (emailVerificationTemplateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailVerificationTemplateName);
		}

		if (defauleRoleIds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(defauleRoleIds);
		}

		if (validations == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(validations);
		}

		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long spUserTypeConfigId;
	public String userType;
	public long userTypeId;
	public long virtualHostId;
	public long declarationId;
	public boolean declarationYearly;
	public long declarationFixedDate;
	public long pdpaId;
	public String accountCreationTemplateName;
	public String welcomeTemplateName;
	public String passwordChangeTemplateName;
	public String passwordResetTemplateName;
	public String emailVerificationTemplateName;
	public String defauleRoleIds;
	public String validations;
	public long groupId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long createdDate;
	public long modifiedDate;
}