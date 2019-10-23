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

package com.sambaash.platform.srv.sharing.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.sharing.model.SPSharing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPSharing in entity cache.
 *
 * @author harini
 * @see SPSharing
 * @generated
 */
public class SPSharingCacheModel implements CacheModel<SPSharing>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{spSharingId=");
		sb.append(spSharingId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", url=");
		sb.append(url);
		sb.append(", expired=");
		sb.append(expired);
		sb.append(", internalShare=");
		sb.append(internalShare);
		sb.append(", writePermission=");
		sb.append(writePermission);
		sb.append(", viewCount=");
		sb.append(viewCount);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPSharing toEntityModel() {
		SPSharingImpl spSharingImpl = new SPSharingImpl();

		spSharingImpl.setSpSharingId(spSharingId);
		spSharingImpl.setGroupId(groupId);
		spSharingImpl.setCompanyId(companyId);
		spSharingImpl.setCreatedBy(createdBy);

		if (userName == null) {
			spSharingImpl.setUserName(StringPool.BLANK);
		}
		else {
			spSharingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spSharingImpl.setCreateDate(null);
		}
		else {
			spSharingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spSharingImpl.setModifiedDate(null);
		}
		else {
			spSharingImpl.setModifiedDate(new Date(modifiedDate));
		}

		spSharingImpl.setUserId(userId);

		if (emailAddress == null) {
			spSharingImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spSharingImpl.setEmailAddress(emailAddress);
		}

		spSharingImpl.setClassNameId(classNameId);
		spSharingImpl.setClassPK(classPK);
		spSharingImpl.setDuration(duration);

		if (startDate == Long.MIN_VALUE) {
			spSharingImpl.setStartDate(null);
		}
		else {
			spSharingImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			spSharingImpl.setEndDate(null);
		}
		else {
			spSharingImpl.setEndDate(new Date(endDate));
		}

		if (url == null) {
			spSharingImpl.setUrl(StringPool.BLANK);
		}
		else {
			spSharingImpl.setUrl(url);
		}

		spSharingImpl.setExpired(expired);
		spSharingImpl.setInternalShare(internalShare);
		spSharingImpl.setWritePermission(writePermission);
		spSharingImpl.setViewCount(viewCount);

		spSharingImpl.resetOriginalValues();

		return spSharingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spSharingId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createdBy = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		duration = objectInput.readInt();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		url = objectInput.readUTF();
		expired = objectInput.readBoolean();
		internalShare = objectInput.readBoolean();
		writePermission = objectInput.readBoolean();
		viewCount = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spSharingId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdBy);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);
		objectOutput.writeInt(duration);
		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (url == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(url);
		}

		objectOutput.writeBoolean(expired);
		objectOutput.writeBoolean(internalShare);
		objectOutput.writeBoolean(writePermission);
		objectOutput.writeInt(viewCount);
	}

	public long spSharingId;
	public long groupId;
	public long companyId;
	public long createdBy;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String emailAddress;
	public long classNameId;
	public long classPK;
	public int duration;
	public long startDate;
	public long endDate;
	public String url;
	public boolean expired;
	public boolean internalShare;
	public boolean writePermission;
	public int viewCount;
}