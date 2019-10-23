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

package com.sambaash.platform.srv.genericuploader.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.genericuploader.model.GUUploadLog;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GUUploadLog in entity cache.
 *
 * @author nareshchebolu
 * @see GUUploadLog
 * @generated
 */
public class GUUploadLogCacheModel implements CacheModel<GUUploadLog>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{SPGUUploadLogId=");
		sb.append(SPGUUploadLogId);
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
		sb.append(", successCount=");
		sb.append(successCount);
		sb.append(", errorCount=");
		sb.append(errorCount);
		sb.append(", startTime=");
		sb.append(startTime);
		sb.append(", endTime=");
		sb.append(endTime);
		sb.append(", uploadedFileEntryId=");
		sb.append(uploadedFileEntryId);
		sb.append(", errorFileEntryId=");
		sb.append(errorFileEntryId);
		sb.append(", errors=");
		sb.append(errors);
		sb.append(", msgs=");
		sb.append(msgs);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GUUploadLog toEntityModel() {
		GUUploadLogImpl guUploadLogImpl = new GUUploadLogImpl();

		guUploadLogImpl.setSPGUUploadLogId(SPGUUploadLogId);
		guUploadLogImpl.setGroupId(groupId);
		guUploadLogImpl.setCompanyId(companyId);
		guUploadLogImpl.setUserId(userId);

		if (userName == null) {
			guUploadLogImpl.setUserName(StringPool.BLANK);
		}
		else {
			guUploadLogImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			guUploadLogImpl.setCreateDate(null);
		}
		else {
			guUploadLogImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			guUploadLogImpl.setModifiedDate(null);
		}
		else {
			guUploadLogImpl.setModifiedDate(new Date(modifiedDate));
		}

		guUploadLogImpl.setSuccessCount(successCount);
		guUploadLogImpl.setErrorCount(errorCount);

		if (startTime == Long.MIN_VALUE) {
			guUploadLogImpl.setStartTime(null);
		}
		else {
			guUploadLogImpl.setStartTime(new Date(startTime));
		}

		if (endTime == Long.MIN_VALUE) {
			guUploadLogImpl.setEndTime(null);
		}
		else {
			guUploadLogImpl.setEndTime(new Date(endTime));
		}

		guUploadLogImpl.setUploadedFileEntryId(uploadedFileEntryId);
		guUploadLogImpl.setErrorFileEntryId(errorFileEntryId);

		if (errors == null) {
			guUploadLogImpl.setErrors(StringPool.BLANK);
		}
		else {
			guUploadLogImpl.setErrors(errors);
		}

		if (msgs == null) {
			guUploadLogImpl.setMsgs(StringPool.BLANK);
		}
		else {
			guUploadLogImpl.setMsgs(msgs);
		}

		if (status == null) {
			guUploadLogImpl.setStatus(StringPool.BLANK);
		}
		else {
			guUploadLogImpl.setStatus(status);
		}

		guUploadLogImpl.resetOriginalValues();

		return guUploadLogImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		SPGUUploadLogId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		successCount = objectInput.readInt();
		errorCount = objectInput.readInt();
		startTime = objectInput.readLong();
		endTime = objectInput.readLong();
		uploadedFileEntryId = objectInput.readLong();
		errorFileEntryId = objectInput.readLong();
		errors = objectInput.readUTF();
		msgs = objectInput.readUTF();
		status = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(SPGUUploadLogId);
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
		objectOutput.writeInt(successCount);
		objectOutput.writeInt(errorCount);
		objectOutput.writeLong(startTime);
		objectOutput.writeLong(endTime);
		objectOutput.writeLong(uploadedFileEntryId);
		objectOutput.writeLong(errorFileEntryId);

		if (errors == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errors);
		}

		if (msgs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(msgs);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}
	}

	public long SPGUUploadLogId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int successCount;
	public int errorCount;
	public long startTime;
	public long endTime;
	public long uploadedFileEntryId;
	public long errorFileEntryId;
	public String errors;
	public String msgs;
	public String status;
}