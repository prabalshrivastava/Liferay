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

import com.liferay.saml.model.SamlSpAuthRequest;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SamlSpAuthRequest in entity cache.
 *
 * @author Mika Koivisto, W. Berks
 * @see SamlSpAuthRequest
 * @generated
 */
public class SamlSpAuthRequestCacheModel implements CacheModel<SamlSpAuthRequest>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{samlSpAuthnRequestId=");
		sb.append(samlSpAuthnRequestId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", samlIdpEntityId=");
		sb.append(samlIdpEntityId);
		sb.append(", samlSpAuthRequestKey=");
		sb.append(samlSpAuthRequestKey);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SamlSpAuthRequest toEntityModel() {
		SamlSpAuthRequestImpl samlSpAuthRequestImpl = new SamlSpAuthRequestImpl();

		samlSpAuthRequestImpl.setSamlSpAuthnRequestId(samlSpAuthnRequestId);
		samlSpAuthRequestImpl.setCompanyId(companyId);
		samlSpAuthRequestImpl.setGroupId(groupId);

		if (createDate == Long.MIN_VALUE) {
			samlSpAuthRequestImpl.setCreateDate(null);
		}
		else {
			samlSpAuthRequestImpl.setCreateDate(new Date(createDate));
		}

		if (samlIdpEntityId == null) {
			samlSpAuthRequestImpl.setSamlIdpEntityId(StringPool.BLANK);
		}
		else {
			samlSpAuthRequestImpl.setSamlIdpEntityId(samlIdpEntityId);
		}

		if (samlSpAuthRequestKey == null) {
			samlSpAuthRequestImpl.setSamlSpAuthRequestKey(StringPool.BLANK);
		}
		else {
			samlSpAuthRequestImpl.setSamlSpAuthRequestKey(samlSpAuthRequestKey);
		}

		samlSpAuthRequestImpl.resetOriginalValues();

		return samlSpAuthRequestImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		samlSpAuthnRequestId = objectInput.readLong();
		companyId = objectInput.readLong();
		groupId = objectInput.readLong();
		createDate = objectInput.readLong();
		samlIdpEntityId = objectInput.readUTF();
		samlSpAuthRequestKey = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(samlSpAuthnRequestId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(createDate);

		if (samlIdpEntityId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(samlIdpEntityId);
		}

		if (samlSpAuthRequestKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(samlSpAuthRequestKey);
		}
	}

	public long samlSpAuthnRequestId;
	public long companyId;
	public long groupId;
	public long createDate;
	public String samlIdpEntityId;
	public String samlSpAuthRequestKey;
}