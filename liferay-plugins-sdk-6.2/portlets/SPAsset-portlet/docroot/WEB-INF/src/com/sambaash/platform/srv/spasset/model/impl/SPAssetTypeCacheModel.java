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

import com.sambaash.platform.srv.spasset.model.SPAssetType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPAssetType in entity cache.
 *
 * @author harini
 * @see SPAssetType
 * @generated
 */
public class SPAssetTypeCacheModel implements CacheModel<SPAssetType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(47);

		sb.append("{uuid_=");
		sb.append(uuid_);
		sb.append(", spAssetTypeId=");
		sb.append(spAssetTypeId);
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
		sb.append(", spAssetTypeName=");
		sb.append(spAssetTypeName);
		sb.append(", status=");
		sb.append(status);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", spAssetTypeCreateUrl=");
		sb.append(spAssetTypeCreateUrl);
		sb.append(", spAssetTypeDetailUrl=");
		sb.append(spAssetTypeDetailUrl);
		sb.append(", spAssetTypeInnerDetailUrl=");
		sb.append(spAssetTypeInnerDetailUrl);
		sb.append(", requiredTermsOfUse=");
		sb.append(requiredTermsOfUse);
		sb.append(", requiredLogin=");
		sb.append(requiredLogin);
		sb.append(", categoryMandatory=");
		sb.append(categoryMandatory);
		sb.append(", notifyUponCreation=");
		sb.append(notifyUponCreation);
		sb.append(", notificationTemplateId=");
		sb.append(notificationTemplateId);
		sb.append(", allowedFileTypes=");
		sb.append(allowedFileTypes);
		sb.append(", maxFileSize=");
		sb.append(maxFileSize);
		sb.append(", minImageHeight=");
		sb.append(minImageHeight);
		sb.append(", minImageWidth=");
		sb.append(minImageWidth);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPAssetType toEntityModel() {
		SPAssetTypeImpl spAssetTypeImpl = new SPAssetTypeImpl();

		if (uuid_ == null) {
			spAssetTypeImpl.setUuid_(StringPool.BLANK);
		}
		else {
			spAssetTypeImpl.setUuid_(uuid_);
		}

		spAssetTypeImpl.setSpAssetTypeId(spAssetTypeId);
		spAssetTypeImpl.setGroupId(groupId);
		spAssetTypeImpl.setCompanyId(companyId);
		spAssetTypeImpl.setUserId(userId);

		if (userName == null) {
			spAssetTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			spAssetTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spAssetTypeImpl.setCreateDate(null);
		}
		else {
			spAssetTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spAssetTypeImpl.setModifiedDate(null);
		}
		else {
			spAssetTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (spAssetTypeName == null) {
			spAssetTypeImpl.setSpAssetTypeName(StringPool.BLANK);
		}
		else {
			spAssetTypeImpl.setSpAssetTypeName(spAssetTypeName);
		}

		spAssetTypeImpl.setStatus(status);

		if (modifiedBy == null) {
			spAssetTypeImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			spAssetTypeImpl.setModifiedBy(modifiedBy);
		}

		if (spAssetTypeCreateUrl == null) {
			spAssetTypeImpl.setSpAssetTypeCreateUrl(StringPool.BLANK);
		}
		else {
			spAssetTypeImpl.setSpAssetTypeCreateUrl(spAssetTypeCreateUrl);
		}

		if (spAssetTypeDetailUrl == null) {
			spAssetTypeImpl.setSpAssetTypeDetailUrl(StringPool.BLANK);
		}
		else {
			spAssetTypeImpl.setSpAssetTypeDetailUrl(spAssetTypeDetailUrl);
		}

		if (spAssetTypeInnerDetailUrl == null) {
			spAssetTypeImpl.setSpAssetTypeInnerDetailUrl(StringPool.BLANK);
		}
		else {
			spAssetTypeImpl.setSpAssetTypeInnerDetailUrl(spAssetTypeInnerDetailUrl);
		}

		spAssetTypeImpl.setRequiredTermsOfUse(requiredTermsOfUse);
		spAssetTypeImpl.setRequiredLogin(requiredLogin);
		spAssetTypeImpl.setCategoryMandatory(categoryMandatory);
		spAssetTypeImpl.setNotifyUponCreation(notifyUponCreation);
		spAssetTypeImpl.setNotificationTemplateId(notificationTemplateId);

		if (allowedFileTypes == null) {
			spAssetTypeImpl.setAllowedFileTypes(StringPool.BLANK);
		}
		else {
			spAssetTypeImpl.setAllowedFileTypes(allowedFileTypes);
		}

		spAssetTypeImpl.setMaxFileSize(maxFileSize);
		spAssetTypeImpl.setMinImageHeight(minImageHeight);
		spAssetTypeImpl.setMinImageWidth(minImageWidth);

		spAssetTypeImpl.resetOriginalValues();

		return spAssetTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid_ = objectInput.readUTF();
		spAssetTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spAssetTypeName = objectInput.readUTF();
		status = objectInput.readBoolean();
		modifiedBy = objectInput.readUTF();
		spAssetTypeCreateUrl = objectInput.readUTF();
		spAssetTypeDetailUrl = objectInput.readUTF();
		spAssetTypeInnerDetailUrl = objectInput.readUTF();
		requiredTermsOfUse = objectInput.readBoolean();
		requiredLogin = objectInput.readBoolean();
		categoryMandatory = objectInput.readBoolean();
		notifyUponCreation = objectInput.readBoolean();
		notificationTemplateId = objectInput.readLong();
		allowedFileTypes = objectInput.readUTF();
		maxFileSize = objectInput.readInt();
		minImageHeight = objectInput.readInt();
		minImageWidth = objectInput.readInt();
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

		objectOutput.writeLong(spAssetTypeId);
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

		if (spAssetTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spAssetTypeName);
		}

		objectOutput.writeBoolean(status);

		if (modifiedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}

		if (spAssetTypeCreateUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spAssetTypeCreateUrl);
		}

		if (spAssetTypeDetailUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spAssetTypeDetailUrl);
		}

		if (spAssetTypeInnerDetailUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(spAssetTypeInnerDetailUrl);
		}

		objectOutput.writeBoolean(requiredTermsOfUse);
		objectOutput.writeBoolean(requiredLogin);
		objectOutput.writeBoolean(categoryMandatory);
		objectOutput.writeBoolean(notifyUponCreation);
		objectOutput.writeLong(notificationTemplateId);

		if (allowedFileTypes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(allowedFileTypes);
		}

		objectOutput.writeInt(maxFileSize);
		objectOutput.writeInt(minImageHeight);
		objectOutput.writeInt(minImageWidth);
	}

	public String uuid_;
	public long spAssetTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String spAssetTypeName;
	public boolean status;
	public String modifiedBy;
	public String spAssetTypeCreateUrl;
	public String spAssetTypeDetailUrl;
	public String spAssetTypeInnerDetailUrl;
	public boolean requiredTermsOfUse;
	public boolean requiredLogin;
	public boolean categoryMandatory;
	public boolean notifyUponCreation;
	public long notificationTemplateId;
	public String allowedFileTypes;
	public int maxFileSize;
	public int minImageHeight;
	public int minImageWidth;
}