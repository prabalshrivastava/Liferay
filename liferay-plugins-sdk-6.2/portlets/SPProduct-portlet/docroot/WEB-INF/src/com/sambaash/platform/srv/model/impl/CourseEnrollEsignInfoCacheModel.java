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

import com.sambaash.platform.srv.model.CourseEnrollEsignInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CourseEnrollEsignInfo in entity cache.
 *
 * @author gauravvijayvergia
 * @see CourseEnrollEsignInfo
 * @generated
 */
public class CourseEnrollEsignInfoCacheModel implements CacheModel<CourseEnrollEsignInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spEsignInfoId=");
		sb.append(spEsignInfoId);
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
		sb.append(", signerId=");
		sb.append(signerId);
		sb.append(", packageId=");
		sb.append(packageId);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", lastGeneratedUrl=");
		sb.append(lastGeneratedUrl);
		sb.append(", spPEProcessStateId=");
		sb.append(spPEProcessStateId);
		sb.append(", extraInfo=");
		sb.append(extraInfo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CourseEnrollEsignInfo toEntityModel() {
		CourseEnrollEsignInfoImpl courseEnrollEsignInfoImpl = new CourseEnrollEsignInfoImpl();

		courseEnrollEsignInfoImpl.setSpEsignInfoId(spEsignInfoId);
		courseEnrollEsignInfoImpl.setGroupId(groupId);
		courseEnrollEsignInfoImpl.setCompanyId(companyId);
		courseEnrollEsignInfoImpl.setUserId(userId);

		if (userName == null) {
			courseEnrollEsignInfoImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseEnrollEsignInfoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseEnrollEsignInfoImpl.setCreateDate(null);
		}
		else {
			courseEnrollEsignInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseEnrollEsignInfoImpl.setModifiedDate(null);
		}
		else {
			courseEnrollEsignInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (signerId == null) {
			courseEnrollEsignInfoImpl.setSignerId(StringPool.BLANK);
		}
		else {
			courseEnrollEsignInfoImpl.setSignerId(signerId);
		}

		if (packageId == null) {
			courseEnrollEsignInfoImpl.setPackageId(StringPool.BLANK);
		}
		else {
			courseEnrollEsignInfoImpl.setPackageId(packageId);
		}

		if (documentId == null) {
			courseEnrollEsignInfoImpl.setDocumentId(StringPool.BLANK);
		}
		else {
			courseEnrollEsignInfoImpl.setDocumentId(documentId);
		}

		if (lastGeneratedUrl == null) {
			courseEnrollEsignInfoImpl.setLastGeneratedUrl(StringPool.BLANK);
		}
		else {
			courseEnrollEsignInfoImpl.setLastGeneratedUrl(lastGeneratedUrl);
		}

		courseEnrollEsignInfoImpl.setSpPEProcessStateId(spPEProcessStateId);

		if (extraInfo == null) {
			courseEnrollEsignInfoImpl.setExtraInfo(StringPool.BLANK);
		}
		else {
			courseEnrollEsignInfoImpl.setExtraInfo(extraInfo);
		}

		courseEnrollEsignInfoImpl.resetOriginalValues();

		return courseEnrollEsignInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spEsignInfoId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		signerId = objectInput.readUTF();
		packageId = objectInput.readUTF();
		documentId = objectInput.readUTF();
		lastGeneratedUrl = objectInput.readUTF();
		spPEProcessStateId = objectInput.readLong();
		extraInfo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spEsignInfoId);
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

		if (signerId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(signerId);
		}

		if (packageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(packageId);
		}

		if (documentId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(documentId);
		}

		if (lastGeneratedUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastGeneratedUrl);
		}

		objectOutput.writeLong(spPEProcessStateId);

		if (extraInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extraInfo);
		}
	}

	public long spEsignInfoId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String signerId;
	public String packageId;
	public String documentId;
	public String lastGeneratedUrl;
	public long spPEProcessStateId;
	public String extraInfo;
}