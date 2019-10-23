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

import com.sambaash.platform.srv.model.StudentCourseFee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StudentCourseFee in entity cache.
 *
 * @author gauravvijayvergia
 * @see StudentCourseFee
 * @generated
 */
public class StudentCourseFeeCacheModel implements CacheModel<StudentCourseFee>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spStudentCourseFeeId=");
		sb.append(spStudentCourseFeeId);
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
		sb.append(", feeType=");
		sb.append(feeType);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", order=");
		sb.append(order);
		sb.append(", formula=");
		sb.append(formula);
		sb.append(", label=");
		sb.append(label);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StudentCourseFee toEntityModel() {
		StudentCourseFeeImpl studentCourseFeeImpl = new StudentCourseFeeImpl();

		studentCourseFeeImpl.setSpStudentCourseFeeId(spStudentCourseFeeId);
		studentCourseFeeImpl.setGroupId(groupId);
		studentCourseFeeImpl.setCompanyId(companyId);
		studentCourseFeeImpl.setUserId(userId);

		if (userName == null) {
			studentCourseFeeImpl.setUserName(StringPool.BLANK);
		}
		else {
			studentCourseFeeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			studentCourseFeeImpl.setCreateDate(null);
		}
		else {
			studentCourseFeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studentCourseFeeImpl.setModifiedDate(null);
		}
		else {
			studentCourseFeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		studentCourseFeeImpl.setSpPEProcessStateId(spPEProcessStateId);

		if (feeType == null) {
			studentCourseFeeImpl.setFeeType(StringPool.BLANK);
		}
		else {
			studentCourseFeeImpl.setFeeType(feeType);
		}

		if (amount == null) {
			studentCourseFeeImpl.setAmount(StringPool.BLANK);
		}
		else {
			studentCourseFeeImpl.setAmount(amount);
		}

		studentCourseFeeImpl.setOrder(order);

		if (formula == null) {
			studentCourseFeeImpl.setFormula(StringPool.BLANK);
		}
		else {
			studentCourseFeeImpl.setFormula(formula);
		}

		if (label == null) {
			studentCourseFeeImpl.setLabel(StringPool.BLANK);
		}
		else {
			studentCourseFeeImpl.setLabel(label);
		}

		studentCourseFeeImpl.resetOriginalValues();

		return studentCourseFeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spStudentCourseFeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spPEProcessStateId = objectInput.readLong();
		feeType = objectInput.readUTF();
		amount = objectInput.readUTF();
		order = objectInput.readInt();
		formula = objectInput.readUTF();
		label = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spStudentCourseFeeId);
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

		if (feeType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(feeType);
		}

		if (amount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(amount);
		}

		objectOutput.writeInt(order);

		if (formula == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formula);
		}

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}
	}

	public long spStudentCourseFeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spPEProcessStateId;
	public String feeType;
	public String amount;
	public int order;
	public String formula;
	public String label;
}