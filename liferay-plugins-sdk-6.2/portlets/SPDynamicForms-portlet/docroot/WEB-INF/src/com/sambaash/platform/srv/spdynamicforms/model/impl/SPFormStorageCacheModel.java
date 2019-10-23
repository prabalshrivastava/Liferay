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

import com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPFormStorage in entity cache.
 *
 * @author glenn
 * @see SPFormStorage
 * @generated
 */
public class SPFormStorageCacheModel implements CacheModel<SPFormStorage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{formStorageId=");
		sb.append(formStorageId);
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
		sb.append(", applicationId=");
		sb.append(applicationId);
		sb.append(", content=");
		sb.append(content);
		sb.append(", htmlFormId=");
		sb.append(htmlFormId);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPFormStorage toEntityModel() {
		SPFormStorageImpl spFormStorageImpl = new SPFormStorageImpl();

		spFormStorageImpl.setFormStorageId(formStorageId);
		spFormStorageImpl.setGroupId(groupId);
		spFormStorageImpl.setCompanyId(companyId);
		spFormStorageImpl.setUserId(userId);

		if (userName == null) {
			spFormStorageImpl.setUserName(StringPool.BLANK);
		}
		else {
			spFormStorageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spFormStorageImpl.setCreateDate(null);
		}
		else {
			spFormStorageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spFormStorageImpl.setModifiedDate(null);
		}
		else {
			spFormStorageImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (applicationId == null) {
			spFormStorageImpl.setApplicationId(StringPool.BLANK);
		}
		else {
			spFormStorageImpl.setApplicationId(applicationId);
		}

		if (content == null) {
			spFormStorageImpl.setContent(StringPool.BLANK);
		}
		else {
			spFormStorageImpl.setContent(content);
		}

		spFormStorageImpl.setHtmlFormId(htmlFormId);

		if (status == null) {
			spFormStorageImpl.setStatus(StringPool.BLANK);
		}
		else {
			spFormStorageImpl.setStatus(status);
		}

		spFormStorageImpl.resetOriginalValues();

		return spFormStorageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		formStorageId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		applicationId = objectInput.readUTF();
		content = objectInput.readUTF();
		htmlFormId = objectInput.readLong();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(formStorageId);
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

		if (applicationId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationId);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		objectOutput.writeLong(htmlFormId);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long formStorageId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String applicationId;
	public String content;
	public long htmlFormId;
	public String status;
}