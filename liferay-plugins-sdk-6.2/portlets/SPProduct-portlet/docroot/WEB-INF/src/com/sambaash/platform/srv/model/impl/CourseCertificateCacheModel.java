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

import com.sambaash.platform.srv.model.CourseCertificate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CourseCertificate in entity cache.
 *
 * @author gauravvijayvergia
 * @see CourseCertificate
 * @generated
 */
public class CourseCertificateCacheModel implements CacheModel<CourseCertificate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{spCourseCertificateId=");
		sb.append(spCourseCertificateId);
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
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append(", spCertificatetId=");
		sb.append(spCertificatetId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CourseCertificate toEntityModel() {
		CourseCertificateImpl courseCertificateImpl = new CourseCertificateImpl();

		courseCertificateImpl.setSpCourseCertificateId(spCourseCertificateId);
		courseCertificateImpl.setGroupId(groupId);
		courseCertificateImpl.setCompanyId(companyId);
		courseCertificateImpl.setUserId(userId);

		if (userName == null) {
			courseCertificateImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseCertificateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseCertificateImpl.setCreateDate(null);
		}
		else {
			courseCertificateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseCertificateImpl.setModifiedDate(null);
		}
		else {
			courseCertificateImpl.setModifiedDate(new Date(modifiedDate));
		}

		courseCertificateImpl.setSpCourseId(spCourseId);
		courseCertificateImpl.setSpCertificatetId(spCertificatetId);

		courseCertificateImpl.resetOriginalValues();

		return courseCertificateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCourseCertificateId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spCourseId = objectInput.readLong();
		spCertificatetId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCourseCertificateId);
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
		objectOutput.writeLong(spCourseId);
		objectOutput.writeLong(spCertificatetId);
	}

	public long spCourseCertificateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spCourseId;
	public long spCertificatetId;
}