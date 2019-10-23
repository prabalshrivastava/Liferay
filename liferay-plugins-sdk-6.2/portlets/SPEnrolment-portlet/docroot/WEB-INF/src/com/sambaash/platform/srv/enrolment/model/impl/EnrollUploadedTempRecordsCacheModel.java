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

package com.sambaash.platform.srv.enrolment.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.enrolment.model.EnrollUploadedTempRecords;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EnrollUploadedTempRecords in entity cache.
 *
 * @author Baxture
 * @see EnrollUploadedTempRecords
 * @generated
 */
public class EnrollUploadedTempRecordsCacheModel implements CacheModel<EnrollUploadedTempRecords>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uploadedRecId=");
		sb.append(uploadedRecId);
		sb.append(", uploadTransactId=");
		sb.append(uploadTransactId);
		sb.append(", sprCode=");
		sb.append(sprCode);
		sb.append(", title=");
		sb.append(title);
		sb.append(", fullOfficialName=");
		sb.append(fullOfficialName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", dateofBirth=");
		sb.append(dateofBirth);
		sb.append(", email=");
		sb.append(email);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public EnrollUploadedTempRecords toEntityModel() {
		EnrollUploadedTempRecordsImpl enrollUploadedTempRecordsImpl = new EnrollUploadedTempRecordsImpl();

		enrollUploadedTempRecordsImpl.setUploadedRecId(uploadedRecId);

		if (uploadTransactId == null) {
			enrollUploadedTempRecordsImpl.setUploadTransactId(StringPool.BLANK);
		}
		else {
			enrollUploadedTempRecordsImpl.setUploadTransactId(uploadTransactId);
		}

		if (sprCode == null) {
			enrollUploadedTempRecordsImpl.setSprCode(StringPool.BLANK);
		}
		else {
			enrollUploadedTempRecordsImpl.setSprCode(sprCode);
		}

		if (title == null) {
			enrollUploadedTempRecordsImpl.setTitle(StringPool.BLANK);
		}
		else {
			enrollUploadedTempRecordsImpl.setTitle(title);
		}

		if (fullOfficialName == null) {
			enrollUploadedTempRecordsImpl.setFullOfficialName(StringPool.BLANK);
		}
		else {
			enrollUploadedTempRecordsImpl.setFullOfficialName(fullOfficialName);
		}

		if (gender == null) {
			enrollUploadedTempRecordsImpl.setGender(StringPool.BLANK);
		}
		else {
			enrollUploadedTempRecordsImpl.setGender(gender);
		}

		if (dateofBirth == null) {
			enrollUploadedTempRecordsImpl.setDateofBirth(StringPool.BLANK);
		}
		else {
			enrollUploadedTempRecordsImpl.setDateofBirth(dateofBirth);
		}

		if (email == null) {
			enrollUploadedTempRecordsImpl.setEmail(StringPool.BLANK);
		}
		else {
			enrollUploadedTempRecordsImpl.setEmail(email);
		}

		enrollUploadedTempRecordsImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			enrollUploadedTempRecordsImpl.setCreateDate(null);
		}
		else {
			enrollUploadedTempRecordsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			enrollUploadedTempRecordsImpl.setModifiedDate(null);
		}
		else {
			enrollUploadedTempRecordsImpl.setModifiedDate(new Date(modifiedDate));
		}

		enrollUploadedTempRecordsImpl.resetOriginalValues();

		return enrollUploadedTempRecordsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uploadedRecId = objectInput.readLong();
		uploadTransactId = objectInput.readUTF();
		sprCode = objectInput.readUTF();
		title = objectInput.readUTF();
		fullOfficialName = objectInput.readUTF();
		gender = objectInput.readUTF();
		dateofBirth = objectInput.readUTF();
		email = objectInput.readUTF();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(uploadedRecId);

		if (uploadTransactId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uploadTransactId);
		}

		if (sprCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sprCode);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (fullOfficialName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fullOfficialName);
		}

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (dateofBirth == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dateofBirth);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long uploadedRecId;
	public String uploadTransactId;
	public String sprCode;
	public String title;
	public String fullOfficialName;
	public String gender;
	public String dateofBirth;
	public String email;
	public long userId;
	public long createDate;
	public long modifiedDate;
}