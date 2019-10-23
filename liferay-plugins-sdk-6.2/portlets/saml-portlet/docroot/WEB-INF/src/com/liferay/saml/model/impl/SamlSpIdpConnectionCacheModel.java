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

package com.liferay.saml.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.liferay.saml.model.SamlSpIdpConnection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SamlSpIdpConnection in entity cache.
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlSpIdpConnection
 * @generated
 */
public class SamlSpIdpConnectionCacheModel implements CacheModel<SamlSpIdpConnection>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{samlSpIdpConnectionId=");
		sb.append(samlSpIdpConnectionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", samlIdpEntityId=");
		sb.append(samlIdpEntityId);
		sb.append(", assertionSignatureRequired=");
		sb.append(assertionSignatureRequired);
		sb.append(", clockSkew=");
		sb.append(clockSkew);
		sb.append(", enabled=");
		sb.append(enabled);
		sb.append(", ldapImportEnabled=");
		sb.append(ldapImportEnabled);
		sb.append(", metadataUrl=");
		sb.append(metadataUrl);
		sb.append(", metadataXml=");
		sb.append(metadataXml);
		sb.append(", metadataUpdatedDate=");
		sb.append(metadataUpdatedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", nameIdFormat=");
		sb.append(nameIdFormat);
		sb.append(", signAuthnRequest=");
		sb.append(signAuthnRequest);
		sb.append(", userAttributeMappings=");
		sb.append(userAttributeMappings);
		sb.append(", keepAliveUrl=");
		sb.append(keepAliveUrl);
		sb.append(", primaryKeyType=");
		sb.append(primaryKeyType);
		sb.append(", primaryKeyAttribute=");
		sb.append(primaryKeyAttribute);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SamlSpIdpConnection toEntityModel() {
		SamlSpIdpConnectionImpl samlSpIdpConnectionImpl = new SamlSpIdpConnectionImpl();

		samlSpIdpConnectionImpl.setSamlSpIdpConnectionId(samlSpIdpConnectionId);
		samlSpIdpConnectionImpl.setCompanyId(companyId);
		samlSpIdpConnectionImpl.setGroupId(groupId);
		samlSpIdpConnectionImpl.setUserId(userId);

		if (userName == null) {
			samlSpIdpConnectionImpl.setUserName(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			samlSpIdpConnectionImpl.setCreateDate(null);
		}
		else {
			samlSpIdpConnectionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			samlSpIdpConnectionImpl.setModifiedDate(null);
		}
		else {
			samlSpIdpConnectionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (samlIdpEntityId == null) {
			samlSpIdpConnectionImpl.setSamlIdpEntityId(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setSamlIdpEntityId(samlIdpEntityId);
		}

		samlSpIdpConnectionImpl.setAssertionSignatureRequired(assertionSignatureRequired);
		samlSpIdpConnectionImpl.setClockSkew(clockSkew);
		samlSpIdpConnectionImpl.setEnabled(enabled);
		samlSpIdpConnectionImpl.setLdapImportEnabled(ldapImportEnabled);

		if (metadataUrl == null) {
			samlSpIdpConnectionImpl.setMetadataUrl(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setMetadataUrl(metadataUrl);
		}

		if (metadataXml == null) {
			samlSpIdpConnectionImpl.setMetadataXml(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setMetadataXml(metadataXml);
		}

		if (metadataUpdatedDate == Long.MIN_VALUE) {
			samlSpIdpConnectionImpl.setMetadataUpdatedDate(null);
		}
		else {
			samlSpIdpConnectionImpl.setMetadataUpdatedDate(new Date(
					metadataUpdatedDate));
		}

		if (name == null) {
			samlSpIdpConnectionImpl.setName(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setName(name);
		}

		if (nameIdFormat == null) {
			samlSpIdpConnectionImpl.setNameIdFormat(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setNameIdFormat(nameIdFormat);
		}

		samlSpIdpConnectionImpl.setSignAuthnRequest(signAuthnRequest);

		if (userAttributeMappings == null) {
			samlSpIdpConnectionImpl.setUserAttributeMappings(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setUserAttributeMappings(userAttributeMappings);
		}

		if (keepAliveUrl == null) {
			samlSpIdpConnectionImpl.setKeepAliveUrl(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setKeepAliveUrl(keepAliveUrl);
		}

		if (primaryKeyType == null) {
			samlSpIdpConnectionImpl.setPrimaryKeyType(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setPrimaryKeyType(primaryKeyType);
		}

		if (primaryKeyAttribute == null) {
			samlSpIdpConnectionImpl.setPrimaryKeyAttribute(StringPool.BLANK);
		}
		else {
			samlSpIdpConnectionImpl.setPrimaryKeyAttribute(primaryKeyAttribute);
		}

		samlSpIdpConnectionImpl.resetOriginalValues();

		return samlSpIdpConnectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		samlSpIdpConnectionId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		samlIdpEntityId = objectInput.readUTF();
		assertionSignatureRequired = objectInput.readBoolean();
		clockSkew = objectInput.readLong();
		enabled = objectInput.readBoolean();
		ldapImportEnabled = objectInput.readBoolean();
		metadataUrl = objectInput.readUTF();
		metadataXml = objectInput.readUTF();
		metadataUpdatedDate = objectInput.readLong();
		name = objectInput.readUTF();
		nameIdFormat = objectInput.readUTF();
		signAuthnRequest = objectInput.readBoolean();
		userAttributeMappings = objectInput.readUTF();
		keepAliveUrl = objectInput.readUTF();
		primaryKeyType = objectInput.readUTF();
		primaryKeyAttribute = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(samlSpIdpConnectionId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (samlIdpEntityId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(samlIdpEntityId);
		}

		objectOutput.writeBoolean(assertionSignatureRequired);
		objectOutput.writeLong(clockSkew);
		objectOutput.writeBoolean(enabled);
		objectOutput.writeBoolean(ldapImportEnabled);

		if (metadataUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(metadataUrl);
		}

		if (metadataXml == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(metadataXml);
		}

		objectOutput.writeLong(metadataUpdatedDate);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (nameIdFormat == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nameIdFormat);
		}

		objectOutput.writeBoolean(signAuthnRequest);

		if (userAttributeMappings == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userAttributeMappings);
		}

		if (keepAliveUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(keepAliveUrl);
		}

		if (primaryKeyType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(primaryKeyType);
		}

		if (primaryKeyAttribute == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(primaryKeyAttribute);
		}
	}

	public long samlSpIdpConnectionId;
	public long companyId;
	public long groupId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String samlIdpEntityId;
	public boolean assertionSignatureRequired;
	public long clockSkew;
	public boolean enabled;
	public boolean ldapImportEnabled;
	public String metadataUrl;
	public String metadataXml;
	public long metadataUpdatedDate;
	public String name;
	public String nameIdFormat;
	public boolean signAuthnRequest;
	public String userAttributeMappings;
	public String keepAliveUrl;
	public String primaryKeyType;
	public String primaryKeyAttribute;
}