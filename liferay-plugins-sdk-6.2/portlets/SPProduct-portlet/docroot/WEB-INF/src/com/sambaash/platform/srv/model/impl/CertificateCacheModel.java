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

package com.sambaash.platform.srv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.model.Certificate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Certificate in entity cache.
 *
 * @author gauravvijayvergia
 * @see Certificate
 * @generated
 */
public class CertificateCacheModel implements CacheModel<Certificate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{spCertificatetId=");
		sb.append(spCertificatetId);
		sb.append(", groupId=");
		sb.append(groupId);
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
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", certificateCode=");
		sb.append(certificateCode);
		sb.append(", certificateType=");
		sb.append(certificateType);
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", level=");
		sb.append(level);
		sb.append(", attachmentFolderId=");
		sb.append(attachmentFolderId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Certificate toEntityModel() {
		CertificateImpl certificateImpl = new CertificateImpl();

		certificateImpl.setSpCertificatetId(spCertificatetId);
		certificateImpl.setGroupId(groupId);
		certificateImpl.setCompanyId(companyId);
		certificateImpl.setUserId(userId);

		if (userName == null) {
			certificateImpl.setUserName(StringPool.BLANK);
		}
		else {
			certificateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			certificateImpl.setCreateDate(null);
		}
		else {
			certificateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			certificateImpl.setModifiedDate(null);
		}
		else {
			certificateImpl.setModifiedDate(new Date(modifiedDate));
		}

		certificateImpl.setCountryId(countryId);

		if (certificateCode == null) {
			certificateImpl.setCertificateCode(StringPool.BLANK);
		}
		else {
			certificateImpl.setCertificateCode(certificateCode);
		}

		certificateImpl.setCertificateType(certificateType);

		if (title == null) {
			certificateImpl.setTitle(StringPool.BLANK);
		}
		else {
			certificateImpl.setTitle(title);
		}

		if (description == null) {
			certificateImpl.setDescription(StringPool.BLANK);
		}
		else {
			certificateImpl.setDescription(description);
		}

		certificateImpl.setLevel(level);
		certificateImpl.setAttachmentFolderId(attachmentFolderId);

		certificateImpl.resetOriginalValues();

		return certificateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCertificatetId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryId = objectInput.readLong();
		certificateCode = objectInput.readUTF();
		certificateType = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		level = objectInput.readLong();
		attachmentFolderId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCertificatetId);
		objectOutput.writeLong(groupId);
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
		objectOutput.writeLong(countryId);

		if (certificateCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificateCode);
		}

		objectOutput.writeLong(certificateType);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(level);
		objectOutput.writeLong(attachmentFolderId);
	}

	public long spCertificatetId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long countryId;
	public String certificateCode;
	public long certificateType;
	public String title;
	public String description;
	public long level;
	public long attachmentFolderId;
}