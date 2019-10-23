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

package com.sambaash.platform.srv.spgroup.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spgroup.model.SPGroup;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPGroup in entity cache.
 *
 * @author harini
 * @see SPGroup
 * @generated
 */
public class SPGroupCacheModel implements CacheModel<SPGroup>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spGroupId=");
		sb.append(spGroupId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", urlTitle=");
		sb.append(urlTitle);
		sb.append(", description=");
		sb.append(description);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPGroup toEntityModel() {
		SPGroupImpl spGroupImpl = new SPGroupImpl();

		if (uuid == null) {
			spGroupImpl.setUuid(StringPool.BLANK);
		}
		else {
			spGroupImpl.setUuid(uuid);
		}

		spGroupImpl.setSpGroupId(spGroupId);
		spGroupImpl.setGroupId(groupId);
		spGroupImpl.setCompanyId(companyId);
		spGroupImpl.setUserId(userId);

		if (userName == null) {
			spGroupImpl.setUserName(StringPool.BLANK);
		}
		else {
			spGroupImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spGroupImpl.setCreateDate(null);
		}
		else {
			spGroupImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spGroupImpl.setModifiedDate(null);
		}
		else {
			spGroupImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			spGroupImpl.setTitle(StringPool.BLANK);
		}
		else {
			spGroupImpl.setTitle(title);
		}

		if (urlTitle == null) {
			spGroupImpl.setUrlTitle(StringPool.BLANK);
		}
		else {
			spGroupImpl.setUrlTitle(urlTitle);
		}

		if (description == null) {
			spGroupImpl.setDescription(StringPool.BLANK);
		}
		else {
			spGroupImpl.setDescription(description);
		}

		spGroupImpl.setImageId(imageId);
		spGroupImpl.setType(type);
		spGroupImpl.setStatus(status);

		spGroupImpl.resetOriginalValues();

		return spGroupImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spGroupId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		urlTitle = objectInput.readUTF();
		description = objectInput.readUTF();
		imageId = objectInput.readLong();
		type = objectInput.readInt();
		status = objectInput.readInt();
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

		objectOutput.writeLong(spGroupId);
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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (urlTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(urlTitle);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(imageId);
		objectOutput.writeInt(type);
		objectOutput.writeInt(status);
	}

	public String uuid;
	public long spGroupId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String urlTitle;
	public String description;
	public long imageId;
	public int type;
	public int status;
}