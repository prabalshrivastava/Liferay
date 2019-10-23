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

import com.sambaash.platform.srv.enrolment.model.EnrollBatchUpload;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing EnrollBatchUpload in entity cache.
 *
 * @author Baxture
 * @see EnrollBatchUpload
 * @generated
 */
public class EnrollBatchUploadCacheModel implements CacheModel<EnrollBatchUpload>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uploadStatId=");
		sb.append(uploadStatId);
		sb.append(", uploadTransactId=");
		sb.append(uploadTransactId);
		sb.append(", errorField=");
		sb.append(errorField);
		sb.append(", errorReason=");
		sb.append(errorReason);
		sb.append(", uploadedRecId=");
		sb.append(uploadedRecId);
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
	public EnrollBatchUpload toEntityModel() {
		EnrollBatchUploadImpl enrollBatchUploadImpl = new EnrollBatchUploadImpl();

		enrollBatchUploadImpl.setUploadStatId(uploadStatId);

		if (uploadTransactId == null) {
			enrollBatchUploadImpl.setUploadTransactId(StringPool.BLANK);
		}
		else {
			enrollBatchUploadImpl.setUploadTransactId(uploadTransactId);
		}

		if (errorField == null) {
			enrollBatchUploadImpl.setErrorField(StringPool.BLANK);
		}
		else {
			enrollBatchUploadImpl.setErrorField(errorField);
		}

		if (errorReason == null) {
			enrollBatchUploadImpl.setErrorReason(StringPool.BLANK);
		}
		else {
			enrollBatchUploadImpl.setErrorReason(errorReason);
		}

		enrollBatchUploadImpl.setUploadedRecId(uploadedRecId);
		enrollBatchUploadImpl.setUserId(userId);

		if (createDate == Long.MIN_VALUE) {
			enrollBatchUploadImpl.setCreateDate(null);
		}
		else {
			enrollBatchUploadImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			enrollBatchUploadImpl.setModifiedDate(null);
		}
		else {
			enrollBatchUploadImpl.setModifiedDate(new Date(modifiedDate));
		}

		enrollBatchUploadImpl.resetOriginalValues();

		return enrollBatchUploadImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uploadStatId = objectInput.readLong();
		uploadTransactId = objectInput.readUTF();
		errorField = objectInput.readUTF();
		errorReason = objectInput.readUTF();
		uploadedRecId = objectInput.readLong();
		userId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(uploadStatId);

		if (uploadTransactId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uploadTransactId);
		}

		if (errorField == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorField);
		}

		if (errorReason == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(errorReason);
		}

		objectOutput.writeLong(uploadedRecId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long uploadStatId;
	public String uploadTransactId;
	public String errorField;
	public String errorReason;
	public long uploadedRecId;
	public long userId;
	public long createDate;
	public long modifiedDate;
}