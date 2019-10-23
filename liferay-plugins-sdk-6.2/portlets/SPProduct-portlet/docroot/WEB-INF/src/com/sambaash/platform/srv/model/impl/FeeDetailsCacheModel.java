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

import com.sambaash.platform.srv.model.FeeDetails;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FeeDetails in entity cache.
 *
 * @author gauravvijayvergia
 * @see FeeDetails
 * @generated
 */
public class FeeDetailsCacheModel implements CacheModel<FeeDetails>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{spFeeDetailsId=");
		sb.append(spFeeDetailsId);
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
		sb.append(", feeType=");
		sb.append(feeType);
		sb.append(", feeDesc=");
		sb.append(feeDesc);
		sb.append(", calculationBase=");
		sb.append(calculationBase);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", displayOrder=");
		sb.append(displayOrder);
		sb.append(", fundId=");
		sb.append(fundId);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FeeDetails toEntityModel() {
		FeeDetailsImpl feeDetailsImpl = new FeeDetailsImpl();

		feeDetailsImpl.setSpFeeDetailsId(spFeeDetailsId);
		feeDetailsImpl.setGroupId(groupId);
		feeDetailsImpl.setCompanyId(companyId);
		feeDetailsImpl.setUserId(userId);

		if (userName == null) {
			feeDetailsImpl.setUserName(StringPool.BLANK);
		}
		else {
			feeDetailsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			feeDetailsImpl.setCreateDate(null);
		}
		else {
			feeDetailsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			feeDetailsImpl.setModifiedDate(null);
		}
		else {
			feeDetailsImpl.setModifiedDate(new Date(modifiedDate));
		}

		feeDetailsImpl.setFeeType(feeType);

		if (feeDesc == null) {
			feeDetailsImpl.setFeeDesc(StringPool.BLANK);
		}
		else {
			feeDetailsImpl.setFeeDesc(feeDesc);
		}

		if (calculationBase == null) {
			feeDetailsImpl.setCalculationBase(StringPool.BLANK);
		}
		else {
			feeDetailsImpl.setCalculationBase(calculationBase);
		}

		if (amount == null) {
			feeDetailsImpl.setAmount(StringPool.BLANK);
		}
		else {
			feeDetailsImpl.setAmount(amount);
		}

		feeDetailsImpl.setDisplayOrder(displayOrder);
		feeDetailsImpl.setFundId(fundId);
		feeDetailsImpl.setSpCourseId(spCourseId);

		feeDetailsImpl.resetOriginalValues();

		return feeDetailsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spFeeDetailsId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		feeType = objectInput.readLong();
		feeDesc = objectInput.readUTF();
		calculationBase = objectInput.readUTF();
		amount = objectInput.readUTF();
		displayOrder = objectInput.readLong();
		fundId = objectInput.readLong();
		spCourseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spFeeDetailsId);
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
		objectOutput.writeLong(feeType);

		if (feeDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(feeDesc);
		}

		if (calculationBase == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(calculationBase);
		}

		if (amount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(amount);
		}

		objectOutput.writeLong(displayOrder);
		objectOutput.writeLong(fundId);
		objectOutput.writeLong(spCourseId);
	}

	public long spFeeDetailsId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long feeType;
	public String feeDesc;
	public String calculationBase;
	public String amount;
	public long displayOrder;
	public long fundId;
	public long spCourseId;
}