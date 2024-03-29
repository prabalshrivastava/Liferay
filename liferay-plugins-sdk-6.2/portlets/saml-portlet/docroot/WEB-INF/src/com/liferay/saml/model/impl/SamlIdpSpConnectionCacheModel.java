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

import com.liferay.saml.model.SamlIdpSpConnection;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SamlIdpSpConnection in entity cache.
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlIdpSpConnection
 * @generated
 */
public class SamlIdpSpConnectionCacheModel implements CacheModel<SamlIdpSpConnection>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{samlIdpSpConnectionId=");
		sb.append(samlIdpSpConnectionId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", samlSpEntityId=");
		sb.append(samlSpEntityId);
		sb.append(", assertionLifetime=");
		sb.append(assertionLifetime);
		sb.append(", attributeNames=");
		sb.append(attributeNames);
		sb.append(", attributesEnabled=");
		sb.append(attributesEnabled);
		sb.append(", attributesNamespaceEnabled=");
		sb.append(attributesNamespaceEnabled);
		sb.append(", enabled=");
		sb.append(enabled);
		sb.append(", metadataUrl=");
		sb.append(metadataUrl);
		sb.append(", metadataXml=");
		sb.append(metadataXml);
		sb.append(", metadataUpdatedDate=");
		sb.append(metadataUpdatedDate);
		sb.append(", name=");
		sb.append(name);
		sb.append(", nameIdAttribute=");
		sb.append(nameIdAttribute);
		sb.append(", nameIdFormat=");
		sb.append(nameIdFormat);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SamlIdpSpConnection toEntityModel() {
		SamlIdpSpConnectionImpl samlIdpSpConnectionImpl = new SamlIdpSpConnectionImpl();

		samlIdpSpConnectionImpl.setSamlIdpSpConnectionId(samlIdpSpConnectionId);
		samlIdpSpConnectionImpl.setCompanyId(companyId);
		samlIdpSpConnectionImpl.setUserId(userId);

		if (userName == null) {
			samlIdpSpConnectionImpl.setUserName(StringPool.BLANK);
		}
		else {
			samlIdpSpConnectionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			samlIdpSpConnectionImpl.setCreateDate(null);
		}
		else {
			samlIdpSpConnectionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			samlIdpSpConnectionImpl.setModifiedDate(null);
		}
		else {
			samlIdpSpConnectionImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (samlSpEntityId == null) {
			samlIdpSpConnectionImpl.setSamlSpEntityId(StringPool.BLANK);
		}
		else {
			samlIdpSpConnectionImpl.setSamlSpEntityId(samlSpEntityId);
		}

		samlIdpSpConnectionImpl.setAssertionLifetime(assertionLifetime);

		if (attributeNames == null) {
			samlIdpSpConnectionImpl.setAttributeNames(StringPool.BLANK);
		}
		else {
			samlIdpSpConnectionImpl.setAttributeNames(attributeNames);
		}

		samlIdpSpConnectionImpl.setAttributesEnabled(attributesEnabled);
		samlIdpSpConnectionImpl.setAttributesNamespaceEnabled(attributesNamespaceEnabled);
		samlIdpSpConnectionImpl.setEnabled(enabled);

		if (metadataUrl == null) {
			samlIdpSpConnectionImpl.setMetadataUrl(StringPool.BLANK);
		}
		else {
			samlIdpSpConnectionImpl.setMetadataUrl(metadataUrl);
		}

		if (metadataXml == null) {
			samlIdpSpConnectionImpl.setMetadataXml(StringPool.BLANK);
		}
		else {
			samlIdpSpConnectionImpl.setMetadataXml(metadataXml);
		}

		if (metadataUpdatedDate == Long.MIN_VALUE) {
			samlIdpSpConnectionImpl.setMetadataUpdatedDate(null);
		}
		else {
			samlIdpSpConnectionImpl.setMetadataUpdatedDate(new Date(
					metadataUpdatedDate));
		}

		if (name == null) {
			samlIdpSpConnectionImpl.setName(StringPool.BLANK);
		}
		else {
			samlIdpSpConnectionImpl.setName(name);
		}

		if (nameIdAttribute == null) {
			samlIdpSpConnectionImpl.setNameIdAttribute(StringPool.BLANK);
		}
		else {
			samlIdpSpConnectionImpl.setNameIdAttribute(nameIdAttribute);
		}

		if (nameIdFormat == null) {
			samlIdpSpConnectionImpl.setNameIdFormat(StringPool.BLANK);
		}
		else {
			samlIdpSpConnectionImpl.setNameIdFormat(nameIdFormat);
		}

		samlIdpSpConnectionImpl.resetOriginalValues();

		return samlIdpSpConnectionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		samlIdpSpConnectionId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		samlSpEntityId = objectInput.readUTF();
		assertionLifetime = objectInput.readInt();
		attributeNames = objectInput.readUTF();
		attributesEnabled = objectInput.readBoolean();
		attributesNamespaceEnabled = objectInput.readBoolean();
		enabled = objectInput.readBoolean();
		metadataUrl = objectInput.readUTF();
		metadataXml = objectInput.readUTF();
		metadataUpdatedDate = objectInput.readLong();
		name = objectInput.readUTF();
		nameIdAttribute = objectInput.readUTF();
		nameIdFormat = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(samlIdpSpConnectionId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (samlSpEntityId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(samlSpEntityId);
		}

		objectOutput.writeInt(assertionLifetime);

		if (attributeNames == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attributeNames);
		}

		objectOutput.writeBoolean(attributesEnabled);
		objectOutput.writeBoolean(attributesNamespaceEnabled);
		objectOutput.writeBoolean(enabled);

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

		if (nameIdAttribute == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nameIdAttribute);
		}

		if (nameIdFormat == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nameIdFormat);
		}
	}

	public long samlIdpSpConnectionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String samlSpEntityId;
	public int assertionLifetime;
	public String attributeNames;
	public boolean attributesEnabled;
	public boolean attributesNamespaceEnabled;
	public boolean enabled;
	public String metadataUrl;
	public String metadataXml;
	public long metadataUpdatedDate;
	public String name;
	public String nameIdAttribute;
	public String nameIdFormat;
}