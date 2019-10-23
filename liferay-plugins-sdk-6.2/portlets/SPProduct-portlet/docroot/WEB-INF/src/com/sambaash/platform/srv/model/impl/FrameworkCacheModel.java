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

import com.sambaash.platform.srv.model.Framework;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Framework in entity cache.
 *
 * @author gauravvijayvergia
 * @see Framework
 * @generated
 */
public class FrameworkCacheModel implements CacheModel<Framework>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spFrameworkId=");
		sb.append(spFrameworkId);
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
		sb.append(", frameworkCode=");
		sb.append(frameworkCode);
		sb.append(", frameworkName=");
		sb.append(frameworkName);
		sb.append(", frameworkImageId=");
		sb.append(frameworkImageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Framework toEntityModel() {
		FrameworkImpl frameworkImpl = new FrameworkImpl();

		frameworkImpl.setSpFrameworkId(spFrameworkId);
		frameworkImpl.setGroupId(groupId);
		frameworkImpl.setCompanyId(companyId);
		frameworkImpl.setUserId(userId);

		if (userName == null) {
			frameworkImpl.setUserName(StringPool.BLANK);
		}
		else {
			frameworkImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			frameworkImpl.setCreateDate(null);
		}
		else {
			frameworkImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			frameworkImpl.setModifiedDate(null);
		}
		else {
			frameworkImpl.setModifiedDate(new Date(modifiedDate));
		}

		frameworkImpl.setCountryId(countryId);

		if (frameworkCode == null) {
			frameworkImpl.setFrameworkCode(StringPool.BLANK);
		}
		else {
			frameworkImpl.setFrameworkCode(frameworkCode);
		}

		if (frameworkName == null) {
			frameworkImpl.setFrameworkName(StringPool.BLANK);
		}
		else {
			frameworkImpl.setFrameworkName(frameworkName);
		}

		frameworkImpl.setFrameworkImageId(frameworkImageId);

		frameworkImpl.resetOriginalValues();

		return frameworkImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spFrameworkId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryId = objectInput.readLong();
		frameworkCode = objectInput.readUTF();
		frameworkName = objectInput.readUTF();
		frameworkImageId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spFrameworkId);
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
		objectOutput.writeLong(countryId);

		if (frameworkCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(frameworkCode);
		}

		if (frameworkName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(frameworkName);
		}

		objectOutput.writeLong(frameworkImageId);
	}

	public long spFrameworkId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long countryId;
	public String frameworkCode;
	public String frameworkName;
	public Long frameworkImageId;
}