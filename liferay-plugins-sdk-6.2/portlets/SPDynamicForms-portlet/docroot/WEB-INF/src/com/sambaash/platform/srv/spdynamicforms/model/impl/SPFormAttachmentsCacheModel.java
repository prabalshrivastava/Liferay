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

package com.sambaash.platform.srv.spdynamicforms.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spdynamicforms.model.SPFormAttachments;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPFormAttachments in entity cache.
 *
 * @author glenn
 * @see SPFormAttachments
 * @generated
 */
public class SPFormAttachmentsCacheModel implements CacheModel<SPFormAttachments>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{spFormAttachmentsId=");
		sb.append(spFormAttachmentsId);
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
		sb.append(", formStorageId=");
		sb.append(formStorageId);
		sb.append(", dataKey=");
		sb.append(dataKey);
		sb.append(", name=");
		sb.append(name);
		sb.append(", url=");
		sb.append(url);
		sb.append(", version=");
		sb.append(version);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPFormAttachments toEntityModel() {
		SPFormAttachmentsImpl spFormAttachmentsImpl = new SPFormAttachmentsImpl();

		spFormAttachmentsImpl.setSpFormAttachmentsId(spFormAttachmentsId);
		spFormAttachmentsImpl.setGroupId(groupId);
		spFormAttachmentsImpl.setCompanyId(companyId);
		spFormAttachmentsImpl.setUserId(userId);

		if (userName == null) {
			spFormAttachmentsImpl.setUserName(StringPool.BLANK);
		}
		else {
			spFormAttachmentsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spFormAttachmentsImpl.setCreateDate(null);
		}
		else {
			spFormAttachmentsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spFormAttachmentsImpl.setModifiedDate(null);
		}
		else {
			spFormAttachmentsImpl.setModifiedDate(new Date(modifiedDate));
		}

		spFormAttachmentsImpl.setFormStorageId(formStorageId);

		if (dataKey == null) {
			spFormAttachmentsImpl.setDataKey(StringPool.BLANK);
		}
		else {
			spFormAttachmentsImpl.setDataKey(dataKey);
		}

		if (name == null) {
			spFormAttachmentsImpl.setName(StringPool.BLANK);
		}
		else {
			spFormAttachmentsImpl.setName(name);
		}

		if (url == null) {
			spFormAttachmentsImpl.setUrl(StringPool.BLANK);
		}
		else {
			spFormAttachmentsImpl.setUrl(url);
		}

		if (version == null) {
			spFormAttachmentsImpl.setVersion(StringPool.BLANK);
		}
		else {
			spFormAttachmentsImpl.setVersion(version);
		}

		spFormAttachmentsImpl.resetOriginalValues();

		return spFormAttachmentsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spFormAttachmentsId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		formStorageId = objectInput.readLong();
		dataKey = objectInput.readUTF();
		name = objectInput.readUTF();
		url = objectInput.readUTF();
		version = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spFormAttachmentsId);
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
		objectOutput.writeLong(formStorageId);

		if (dataKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dataKey);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}
	}

	public long spFormAttachmentsId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long formStorageId;
	public String dataKey;
	public String name;
	public String url;
	public String version;
}