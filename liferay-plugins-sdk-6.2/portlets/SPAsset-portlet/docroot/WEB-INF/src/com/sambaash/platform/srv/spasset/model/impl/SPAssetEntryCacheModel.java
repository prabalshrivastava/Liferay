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

package com.sambaash.platform.srv.spasset.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spasset.model.SPAssetEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPAssetEntry in entity cache.
 *
 * @author harini
 * @see SPAssetEntry
 * @generated
 */
public class SPAssetEntryCacheModel implements CacheModel<SPAssetEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{uuid_=");
		sb.append(uuid_);
		sb.append(", spAssetEntryId=");
		sb.append(spAssetEntryId);
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
		sb.append(", dlFolderId=");
		sb.append(dlFolderId);
		sb.append(", coverFileEntryId=");
		sb.append(coverFileEntryId);
		sb.append(", spAssetTypeId=");
		sb.append(spAssetTypeId);
		sb.append(", spAssetEntrySubType=");
		sb.append(spAssetEntrySubType);
		sb.append(", corporateProfileUserId=");
		sb.append(corporateProfileUserId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", urlTitle=");
		sb.append(urlTitle);
		sb.append(", description=");
		sb.append(description);
		sb.append(", content=");
		sb.append(content);
		sb.append(", link=");
		sb.append(link);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusByUserName=");
		sb.append(statusByUserName);
		sb.append(", type=");
		sb.append(type);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", allowPingbacks=");
		sb.append(allowPingbacks);
		sb.append(", allowTrackbacks=");
		sb.append(allowTrackbacks);
		sb.append(", trackbacks=");
		sb.append(trackbacks);
		sb.append(", permissionType=");
		sb.append(permissionType);
		sb.append(", agreedToTermsOfUse=");
		sb.append(agreedToTermsOfUse);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPAssetEntry toEntityModel() {
		SPAssetEntryImpl spAssetEntryImpl = new SPAssetEntryImpl();

		if (uuid_ == null) {
			spAssetEntryImpl.setUuid_(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setUuid_(uuid_);
		}

		spAssetEntryImpl.setSpAssetEntryId(spAssetEntryId);
		spAssetEntryImpl.setGroupId(groupId);
		spAssetEntryImpl.setCompanyId(companyId);
		spAssetEntryImpl.setUserId(userId);

		if (userName == null) {
			spAssetEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spAssetEntryImpl.setCreateDate(null);
		}
		else {
			spAssetEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spAssetEntryImpl.setModifiedDate(null);
		}
		else {
			spAssetEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		spAssetEntryImpl.setDlFolderId(dlFolderId);
		spAssetEntryImpl.setCoverFileEntryId(coverFileEntryId);
		spAssetEntryImpl.setSpAssetTypeId(spAssetTypeId);

		if (spAssetEntrySubType == null) {
			spAssetEntryImpl.setSpAssetEntrySubType(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setSpAssetEntrySubType(spAssetEntrySubType);
		}

		spAssetEntryImpl.setCorporateProfileUserId(corporateProfileUserId);
		spAssetEntryImpl.setClassNameId(classNameId);

		if (title == null) {
			spAssetEntryImpl.setTitle(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setTitle(title);
		}

		if (urlTitle == null) {
			spAssetEntryImpl.setUrlTitle(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setUrlTitle(urlTitle);
		}

		if (description == null) {
			spAssetEntryImpl.setDescription(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setDescription(description);
		}

		if (content == null) {
			spAssetEntryImpl.setContent(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setContent(content);
		}

		if (link == null) {
			spAssetEntryImpl.setLink(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setLink(link);
		}

		spAssetEntryImpl.setStatus(status);

		if (statusByUserName == null) {
			spAssetEntryImpl.setStatusByUserName(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setStatusByUserName(statusByUserName);
		}

		if (type == null) {
			spAssetEntryImpl.setType(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setType(type);
		}

		if (modifiedBy == null) {
			spAssetEntryImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setModifiedBy(modifiedBy);
		}

		spAssetEntryImpl.setAllowPingbacks(allowPingbacks);
		spAssetEntryImpl.setAllowTrackbacks(allowTrackbacks);

		if (trackbacks == null) {
			spAssetEntryImpl.setTrackbacks(StringPool.BLANK);
		}
		else {
			spAssetEntryImpl.setTrackbacks(trackbacks);
		}

		spAssetEntryImpl.setPermissionType(permissionType);
		spAssetEntryImpl.setAgreedToTermsOfUse(agreedToTermsOfUse);

		spAssetEntryImpl.resetOriginalValues();

		return spAssetEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid_ = objectInput.readUTF();
		spAssetEntryId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dlFolderId = objectInput.readLong();
		coverFileEntryId = objectInput.readLong();
		spAssetTypeId = objectInput.readLong();
		spAssetEntrySubType = objectInput.readUTF();
		corporateProfileUserId = objectInput.readLong();
		classNameId = objectInput.readLong();
		title = objectInput.readUTF();
		urlTitle = objectInput.readUTF();
		description = objectInput.readUTF();
		content = objectInput.readUTF();
		link = objectInput.readUTF();
		status = objectInput.readBoolean();
		statusByUserName = objectInput.readUTF();
		type = objectInput.readUTF();
		modifiedBy = objectInput.readUTF();
		allowPingbacks = objectInput.readBoolean();
		allowTrackbacks = objectInput.readBoolean();
		trackbacks = objectInput.readUTF();
		permissionType = objectInput.readInt();
		agreedToTermsOfUse = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid_ == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid_);
		}

		objectOutput.writeLong(spAssetEntryId);
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
		objectOutput.writeLong(dlFolderId);
		objectOutput.writeLong(coverFileEntryId);
		objectOutput.writeLong(spAssetTypeId);

		if (spAssetEntrySubType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spAssetEntrySubType);
		}

		objectOutput.writeLong(corporateProfileUserId);
		objectOutput.writeLong(classNameId);

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

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (link == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(link);
		}

		objectOutput.writeBoolean(status);

		if (statusByUserName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusByUserName);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (modifiedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}

		objectOutput.writeBoolean(allowPingbacks);
		objectOutput.writeBoolean(allowTrackbacks);

		if (trackbacks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(trackbacks);
		}

		objectOutput.writeInt(permissionType);
		objectOutput.writeBoolean(agreedToTermsOfUse);
	}

	public String uuid_;
	public long spAssetEntryId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long dlFolderId;
	public long coverFileEntryId;
	public long spAssetTypeId;
	public String spAssetEntrySubType;
	public long corporateProfileUserId;
	public long classNameId;
	public String title;
	public String urlTitle;
	public String description;
	public String content;
	public String link;
	public boolean status;
	public String statusByUserName;
	public String type;
	public String modifiedBy;
	public boolean allowPingbacks;
	public boolean allowTrackbacks;
	public String trackbacks;
	public int permissionType;
	public boolean agreedToTermsOfUse;
}