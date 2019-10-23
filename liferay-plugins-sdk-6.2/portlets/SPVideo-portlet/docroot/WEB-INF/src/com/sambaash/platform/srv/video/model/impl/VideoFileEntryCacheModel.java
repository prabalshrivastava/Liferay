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

package com.sambaash.platform.srv.video.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.video.model.VideoFileEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing VideoFileEntry in entity cache.
 *
 * @author gauravvijayvergia
 * @see VideoFileEntry
 * @generated
 */
public class VideoFileEntryCacheModel implements CacheModel<VideoFileEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spVideoFileEntryId=");
		sb.append(spVideoFileEntryId);
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
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", fileVersionId=");
		sb.append(fileVersionId);
		sb.append(", folderId=");
		sb.append(folderId);
		sb.append(", jobId=");
		sb.append(jobId);
		sb.append(", jobResponse=");
		sb.append(jobResponse);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public VideoFileEntry toEntityModel() {
		VideoFileEntryImpl videoFileEntryImpl = new VideoFileEntryImpl();

		videoFileEntryImpl.setSpVideoFileEntryId(spVideoFileEntryId);
		videoFileEntryImpl.setGroupId(groupId);
		videoFileEntryImpl.setCompanyId(companyId);
		videoFileEntryImpl.setUserId(userId);

		if (userName == null) {
			videoFileEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			videoFileEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			videoFileEntryImpl.setCreateDate(null);
		}
		else {
			videoFileEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			videoFileEntryImpl.setModifiedDate(null);
		}
		else {
			videoFileEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		videoFileEntryImpl.setFileEntryId(fileEntryId);
		videoFileEntryImpl.setFileVersionId(fileVersionId);
		videoFileEntryImpl.setFolderId(folderId);

		if (jobId == null) {
			videoFileEntryImpl.setJobId(StringPool.BLANK);
		}
		else {
			videoFileEntryImpl.setJobId(jobId);
		}

		if (jobResponse == null) {
			videoFileEntryImpl.setJobResponse(StringPool.BLANK);
		}
		else {
			videoFileEntryImpl.setJobResponse(jobResponse);
		}

		videoFileEntryImpl.setStatus(status);

		videoFileEntryImpl.resetOriginalValues();

		return videoFileEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spVideoFileEntryId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		fileEntryId = objectInput.readLong();
		fileVersionId = objectInput.readLong();
		folderId = objectInput.readLong();
		jobId = objectInput.readUTF();
		jobResponse = objectInput.readUTF();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spVideoFileEntryId);
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
		objectOutput.writeLong(fileEntryId);
		objectOutput.writeLong(fileVersionId);
		objectOutput.writeLong(folderId);

		if (jobId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobId);
		}

		if (jobResponse == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobResponse);
		}

		objectOutput.writeInt(status);
	}

	public long spVideoFileEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long fileEntryId;
	public long fileVersionId;
	public long folderId;
	public String jobId;
	public String jobResponse;
	public int status;
}