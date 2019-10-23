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

package com.sambaash.platform.srv.legalandcontract.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.legalandcontract.model.ClassMaster;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ClassMaster in entity cache.
 *
 * @author nareshchebolu
 * @see ClassMaster
 * @generated
 */
public class ClassMasterCacheModel implements CacheModel<ClassMaster>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spClassId=");
		sb.append(spClassId);
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
		sb.append(", code=");
		sb.append(code);
		sb.append(", country=");
		sb.append(country);
		sb.append(", filedBy=");
		sb.append(filedBy);
		sb.append(", customField1=");
		sb.append(customField1);
		sb.append(", customField2=");
		sb.append(customField2);
		sb.append(", customDate1=");
		sb.append(customDate1);
		sb.append(", customDate2=");
		sb.append(customDate2);
		sb.append(", version=");
		sb.append(version);
		sb.append(", rootSpClassId=");
		sb.append(rootSpClassId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ClassMaster toEntityModel() {
		ClassMasterImpl classMasterImpl = new ClassMasterImpl();

		if (uuid == null) {
			classMasterImpl.setUuid(StringPool.BLANK);
		}
		else {
			classMasterImpl.setUuid(uuid);
		}

		classMasterImpl.setSpClassId(spClassId);
		classMasterImpl.setGroupId(groupId);
		classMasterImpl.setCompanyId(companyId);
		classMasterImpl.setUserId(userId);

		if (userName == null) {
			classMasterImpl.setUserName(StringPool.BLANK);
		}
		else {
			classMasterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			classMasterImpl.setCreateDate(null);
		}
		else {
			classMasterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			classMasterImpl.setModifiedDate(null);
		}
		else {
			classMasterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (code == null) {
			classMasterImpl.setCode(StringPool.BLANK);
		}
		else {
			classMasterImpl.setCode(code);
		}

		if (country == null) {
			classMasterImpl.setCountry(StringPool.BLANK);
		}
		else {
			classMasterImpl.setCountry(country);
		}

		if (filedBy == null) {
			classMasterImpl.setFiledBy(StringPool.BLANK);
		}
		else {
			classMasterImpl.setFiledBy(filedBy);
		}

		if (customField1 == null) {
			classMasterImpl.setCustomField1(StringPool.BLANK);
		}
		else {
			classMasterImpl.setCustomField1(customField1);
		}

		if (customField2 == null) {
			classMasterImpl.setCustomField2(StringPool.BLANK);
		}
		else {
			classMasterImpl.setCustomField2(customField2);
		}

		if (customDate1 == Long.MIN_VALUE) {
			classMasterImpl.setCustomDate1(null);
		}
		else {
			classMasterImpl.setCustomDate1(new Date(customDate1));
		}

		if (customDate2 == Long.MIN_VALUE) {
			classMasterImpl.setCustomDate2(null);
		}
		else {
			classMasterImpl.setCustomDate2(new Date(customDate2));
		}

		if (version == null) {
			classMasterImpl.setVersion(StringPool.BLANK);
		}
		else {
			classMasterImpl.setVersion(version);
		}

		classMasterImpl.setRootSpClassId(rootSpClassId);

		classMasterImpl.resetOriginalValues();

		return classMasterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spClassId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		code = objectInput.readUTF();
		country = objectInput.readUTF();
		filedBy = objectInput.readUTF();
		customField1 = objectInput.readUTF();
		customField2 = objectInput.readUTF();
		customDate1 = objectInput.readLong();
		customDate2 = objectInput.readLong();
		version = objectInput.readUTF();
		rootSpClassId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(spClassId);
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

		if (code == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(code);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (filedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filedBy);
		}

		if (customField1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField1);
		}

		if (customField2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField2);
		}

		objectOutput.writeLong(customDate1);
		objectOutput.writeLong(customDate2);

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeLong(rootSpClassId);
	}

	public String uuid;
	public long spClassId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String code;
	public String country;
	public String filedBy;
	public String customField1;
	public String customField2;
	public long customDate1;
	public long customDate2;
	public String version;
	public long rootSpClassId;
}