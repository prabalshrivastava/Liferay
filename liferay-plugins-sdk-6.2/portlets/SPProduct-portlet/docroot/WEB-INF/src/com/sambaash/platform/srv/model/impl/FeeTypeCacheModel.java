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

import com.sambaash.platform.srv.model.FeeType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FeeType in entity cache.
 *
 * @author gauravvijayvergia
 * @see FeeType
 * @generated
 */
public class FeeTypeCacheModel implements CacheModel<FeeType>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spFeeTypeId=");
		sb.append(spFeeTypeId);
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
		sb.append(", feeTypeName=");
		sb.append(feeTypeName);
		sb.append(", feeTypeDesc=");
		sb.append(feeTypeDesc);
		sb.append(", misc=");
		sb.append(misc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FeeType toEntityModel() {
		FeeTypeImpl feeTypeImpl = new FeeTypeImpl();

		feeTypeImpl.setSpFeeTypeId(spFeeTypeId);
		feeTypeImpl.setGroupId(groupId);
		feeTypeImpl.setCompanyId(companyId);
		feeTypeImpl.setUserId(userId);

		if (userName == null) {
			feeTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			feeTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			feeTypeImpl.setCreateDate(null);
		}
		else {
			feeTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			feeTypeImpl.setModifiedDate(null);
		}
		else {
			feeTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (feeType == null) {
			feeTypeImpl.setFeeType(StringPool.BLANK);
		}
		else {
			feeTypeImpl.setFeeType(feeType);
		}

		if (feeTypeName == null) {
			feeTypeImpl.setFeeTypeName(StringPool.BLANK);
		}
		else {
			feeTypeImpl.setFeeTypeName(feeTypeName);
		}

		if (feeTypeDesc == null) {
			feeTypeImpl.setFeeTypeDesc(StringPool.BLANK);
		}
		else {
			feeTypeImpl.setFeeTypeDesc(feeTypeDesc);
		}

		feeTypeImpl.setMisc(misc);

		feeTypeImpl.resetOriginalValues();

		return feeTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spFeeTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		feeType = objectInput.readUTF();
		feeTypeName = objectInput.readUTF();
		feeTypeDesc = objectInput.readUTF();
		misc = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spFeeTypeId);
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

		if (feeType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(feeType);
		}

		if (feeTypeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(feeTypeName);
		}

		if (feeTypeDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(feeTypeDesc);
		}

		objectOutput.writeBoolean(misc);
	}

	public long spFeeTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String feeType;
	public String feeTypeName;
	public String feeTypeDesc;
	public boolean misc;
}