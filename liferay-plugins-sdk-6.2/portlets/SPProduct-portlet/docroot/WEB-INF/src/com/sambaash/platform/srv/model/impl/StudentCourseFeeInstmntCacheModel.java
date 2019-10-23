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

import com.sambaash.platform.srv.model.StudentCourseFeeInstmnt;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StudentCourseFeeInstmnt in entity cache.
 *
 * @author gauravvijayvergia
 * @see StudentCourseFeeInstmnt
 * @generated
 */
public class StudentCourseFeeInstmntCacheModel implements CacheModel<StudentCourseFeeInstmnt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spStudentCourseFeeInstmntId=");
		sb.append(spStudentCourseFeeInstmntId);
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
		sb.append(", spPEProcessStateId=");
		sb.append(spPEProcessStateId);
		sb.append(", insmntNo=");
		sb.append(insmntNo);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", date=");
		sb.append(date);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StudentCourseFeeInstmnt toEntityModel() {
		StudentCourseFeeInstmntImpl studentCourseFeeInstmntImpl = new StudentCourseFeeInstmntImpl();

		studentCourseFeeInstmntImpl.setSpStudentCourseFeeInstmntId(spStudentCourseFeeInstmntId);
		studentCourseFeeInstmntImpl.setGroupId(groupId);
		studentCourseFeeInstmntImpl.setCompanyId(companyId);
		studentCourseFeeInstmntImpl.setUserId(userId);

		if (userName == null) {
			studentCourseFeeInstmntImpl.setUserName(StringPool.BLANK);
		}
		else {
			studentCourseFeeInstmntImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			studentCourseFeeInstmntImpl.setCreateDate(null);
		}
		else {
			studentCourseFeeInstmntImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studentCourseFeeInstmntImpl.setModifiedDate(null);
		}
		else {
			studentCourseFeeInstmntImpl.setModifiedDate(new Date(modifiedDate));
		}

		studentCourseFeeInstmntImpl.setSpPEProcessStateId(spPEProcessStateId);
		studentCourseFeeInstmntImpl.setInsmntNo(insmntNo);

		if (amount == null) {
			studentCourseFeeInstmntImpl.setAmount(StringPool.BLANK);
		}
		else {
			studentCourseFeeInstmntImpl.setAmount(amount);
		}

		if (date == Long.MIN_VALUE) {
			studentCourseFeeInstmntImpl.setDate(null);
		}
		else {
			studentCourseFeeInstmntImpl.setDate(new Date(date));
		}

		studentCourseFeeInstmntImpl.resetOriginalValues();

		return studentCourseFeeInstmntImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spStudentCourseFeeInstmntId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spPEProcessStateId = objectInput.readLong();
		insmntNo = objectInput.readInt();
		amount = objectInput.readUTF();
		date = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spStudentCourseFeeInstmntId);
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
		objectOutput.writeLong(spPEProcessStateId);
		objectOutput.writeInt(insmntNo);

		if (amount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(amount);
		}

		objectOutput.writeLong(date);
	}

	public long spStudentCourseFeeInstmntId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spPEProcessStateId;
	public int insmntNo;
	public String amount;
	public long date;
}