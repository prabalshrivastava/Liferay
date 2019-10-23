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

import com.sambaash.platform.srv.model.MiscellaneousFees;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MiscellaneousFees in entity cache.
 *
 * @author gauravvijayvergia
 * @see MiscellaneousFees
 * @generated
 */
public class MiscellaneousFeesCacheModel implements CacheModel<MiscellaneousFees>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spMiscFeesId=");
		sb.append(spMiscFeesId);
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
		sb.append(", miscFeeType=");
		sb.append(miscFeeType);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", payable=");
		sb.append(payable);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MiscellaneousFees toEntityModel() {
		MiscellaneousFeesImpl miscellaneousFeesImpl = new MiscellaneousFeesImpl();

		miscellaneousFeesImpl.setSpMiscFeesId(spMiscFeesId);
		miscellaneousFeesImpl.setGroupId(groupId);
		miscellaneousFeesImpl.setCompanyId(companyId);
		miscellaneousFeesImpl.setUserId(userId);

		if (userName == null) {
			miscellaneousFeesImpl.setUserName(StringPool.BLANK);
		}
		else {
			miscellaneousFeesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			miscellaneousFeesImpl.setCreateDate(null);
		}
		else {
			miscellaneousFeesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			miscellaneousFeesImpl.setModifiedDate(null);
		}
		else {
			miscellaneousFeesImpl.setModifiedDate(new Date(modifiedDate));
		}

		miscellaneousFeesImpl.setMiscFeeType(miscFeeType);
		miscellaneousFeesImpl.setAmount(amount);
		miscellaneousFeesImpl.setPayable(payable);
		miscellaneousFeesImpl.setSpCourseId(spCourseId);

		miscellaneousFeesImpl.resetOriginalValues();

		return miscellaneousFeesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spMiscFeesId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		miscFeeType = objectInput.readLong();
		amount = objectInput.readDouble();
		payable = objectInput.readLong();
		spCourseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spMiscFeesId);
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
		objectOutput.writeLong(miscFeeType);
		objectOutput.writeDouble(amount);
		objectOutput.writeLong(payable);
		objectOutput.writeLong(spCourseId);
	}

	public long spMiscFeesId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long miscFeeType;
	public double amount;
	public long payable;
	public long spCourseId;
}