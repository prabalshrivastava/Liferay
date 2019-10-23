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

import com.sambaash.platform.srv.model.CourseEnrollContract;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CourseEnrollContract in entity cache.
 *
 * @author gauravvijayvergia
 * @see CourseEnrollContract
 * @generated
 */
public class CourseEnrollContractCacheModel implements CacheModel<CourseEnrollContract>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{spCourseContractId=");
		sb.append(spCourseContractId);
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
		sb.append(", courseType=");
		sb.append(courseType);
		sb.append(", docType=");
		sb.append(docType);
		sb.append(", seqNo=");
		sb.append(seqNo);
		sb.append(", contractTemplateFileEntryId=");
		sb.append(contractTemplateFileEntryId);
		sb.append(", dataTemplateFileEntryId=");
		sb.append(dataTemplateFileEntryId);
		sb.append(", extraInfo=");
		sb.append(extraInfo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CourseEnrollContract toEntityModel() {
		CourseEnrollContractImpl courseEnrollContractImpl = new CourseEnrollContractImpl();

		courseEnrollContractImpl.setSpCourseContractId(spCourseContractId);
		courseEnrollContractImpl.setGroupId(groupId);
		courseEnrollContractImpl.setCompanyId(companyId);
		courseEnrollContractImpl.setUserId(userId);

		if (userName == null) {
			courseEnrollContractImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseEnrollContractImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseEnrollContractImpl.setCreateDate(null);
		}
		else {
			courseEnrollContractImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseEnrollContractImpl.setModifiedDate(null);
		}
		else {
			courseEnrollContractImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (countryId == null) {
			courseEnrollContractImpl.setCountryId(StringPool.BLANK);
		}
		else {
			courseEnrollContractImpl.setCountryId(countryId);
		}

		courseEnrollContractImpl.setCourseType(courseType);

		if (docType == null) {
			courseEnrollContractImpl.setDocType(StringPool.BLANK);
		}
		else {
			courseEnrollContractImpl.setDocType(docType);
		}

		courseEnrollContractImpl.setSeqNo(seqNo);
		courseEnrollContractImpl.setContractTemplateFileEntryId(contractTemplateFileEntryId);
		courseEnrollContractImpl.setDataTemplateFileEntryId(dataTemplateFileEntryId);

		if (extraInfo == null) {
			courseEnrollContractImpl.setExtraInfo(StringPool.BLANK);
		}
		else {
			courseEnrollContractImpl.setExtraInfo(extraInfo);
		}

		courseEnrollContractImpl.resetOriginalValues();

		return courseEnrollContractImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCourseContractId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryId = objectInput.readUTF();
		courseType = objectInput.readLong();
		docType = objectInput.readUTF();
		seqNo = objectInput.readInt();
		contractTemplateFileEntryId = objectInput.readLong();
		dataTemplateFileEntryId = objectInput.readLong();
		extraInfo = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCourseContractId);
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

		if (countryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryId);
		}

		objectOutput.writeLong(courseType);

		if (docType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(docType);
		}

		objectOutput.writeInt(seqNo);
		objectOutput.writeLong(contractTemplateFileEntryId);
		objectOutput.writeLong(dataTemplateFileEntryId);

		if (extraInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extraInfo);
		}
	}

	public long spCourseContractId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String countryId;
	public long courseType;
	public String docType;
	public int seqNo;
	public long contractTemplateFileEntryId;
	public long dataTemplateFileEntryId;
	public String extraInfo;
}