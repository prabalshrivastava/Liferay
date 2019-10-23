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

import com.liferay.saml.model.SamlIdpSpSession;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SamlIdpSpSession in entity cache.
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlIdpSpSession
 * @generated
 */
public class SamlIdpSpSessionCacheModel implements CacheModel<SamlIdpSpSession>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{samlIdpSpSessionId=");
		sb.append(samlIdpSpSessionId);
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
		sb.append(", samlIdpSsoSessionId=");
		sb.append(samlIdpSsoSessionId);
		sb.append(", samlSpEntityId=");
		sb.append(samlSpEntityId);
		sb.append(", nameIdFormat=");
		sb.append(nameIdFormat);
		sb.append(", nameIdValue=");
		sb.append(nameIdValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SamlIdpSpSession toEntityModel() {
		SamlIdpSpSessionImpl samlIdpSpSessionImpl = new SamlIdpSpSessionImpl();

		samlIdpSpSessionImpl.setSamlIdpSpSessionId(samlIdpSpSessionId);
		samlIdpSpSessionImpl.setCompanyId(companyId);
		samlIdpSpSessionImpl.setUserId(userId);

		if (userName == null) {
			samlIdpSpSessionImpl.setUserName(StringPool.BLANK);
		}
		else {
			samlIdpSpSessionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			samlIdpSpSessionImpl.setCreateDate(null);
		}
		else {
			samlIdpSpSessionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			samlIdpSpSessionImpl.setModifiedDate(null);
		}
		else {
			samlIdpSpSessionImpl.setModifiedDate(new Date(modifiedDate));
		}

		samlIdpSpSessionImpl.setSamlIdpSsoSessionId(samlIdpSsoSessionId);

		if (samlSpEntityId == null) {
			samlIdpSpSessionImpl.setSamlSpEntityId(StringPool.BLANK);
		}
		else {
			samlIdpSpSessionImpl.setSamlSpEntityId(samlSpEntityId);
		}

		if (nameIdFormat == null) {
			samlIdpSpSessionImpl.setNameIdFormat(StringPool.BLANK);
		}
		else {
			samlIdpSpSessionImpl.setNameIdFormat(nameIdFormat);
		}

		if (nameIdValue == null) {
			samlIdpSpSessionImpl.setNameIdValue(StringPool.BLANK);
		}
		else {
			samlIdpSpSessionImpl.setNameIdValue(nameIdValue);
		}

		samlIdpSpSessionImpl.resetOriginalValues();

		return samlIdpSpSessionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		samlIdpSpSessionId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		samlIdpSsoSessionId = objectInput.readLong();
		samlSpEntityId = objectInput.readUTF();
		nameIdFormat = objectInput.readUTF();
		nameIdValue = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(samlIdpSpSessionId);
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
		objectOutput.writeLong(samlIdpSsoSessionId);

		if (samlSpEntityId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(samlSpEntityId);
		}

		if (nameIdFormat == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nameIdFormat);
		}

		if (nameIdValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nameIdValue);
		}
	}

	public long samlIdpSpSessionId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long samlIdpSsoSessionId;
	public String samlSpEntityId;
	public String nameIdFormat;
	public String nameIdValue;
}