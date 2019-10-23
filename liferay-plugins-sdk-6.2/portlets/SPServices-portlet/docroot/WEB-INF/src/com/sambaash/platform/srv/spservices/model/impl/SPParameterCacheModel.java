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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.SPParameter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPParameter in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPParameter
 * @generated
 */
public class SPParameterCacheModel implements CacheModel<SPParameter>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spParameterId=");
		sb.append(spParameterId);
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
		sb.append(", category=");
		sb.append(category);
		sb.append(", description=");
		sb.append(description);
		sb.append(", name=");
		sb.append(name);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPParameter toEntityModel() {
		SPParameterImpl spParameterImpl = new SPParameterImpl();

		if (uuid == null) {
			spParameterImpl.setUuid(StringPool.BLANK);
		}
		else {
			spParameterImpl.setUuid(uuid);
		}

		spParameterImpl.setSpParameterId(spParameterId);
		spParameterImpl.setGroupId(groupId);
		spParameterImpl.setCompanyId(companyId);
		spParameterImpl.setUserId(userId);

		if (userName == null) {
			spParameterImpl.setUserName(StringPool.BLANK);
		}
		else {
			spParameterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spParameterImpl.setCreateDate(null);
		}
		else {
			spParameterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spParameterImpl.setModifiedDate(null);
		}
		else {
			spParameterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (category == null) {
			spParameterImpl.setCategory(StringPool.BLANK);
		}
		else {
			spParameterImpl.setCategory(category);
		}

		if (description == null) {
			spParameterImpl.setDescription(StringPool.BLANK);
		}
		else {
			spParameterImpl.setDescription(description);
		}

		if (name == null) {
			spParameterImpl.setName(StringPool.BLANK);
		}
		else {
			spParameterImpl.setName(name);
		}

		if (value == null) {
			spParameterImpl.setValue(StringPool.BLANK);
		}
		else {
			spParameterImpl.setValue(value);
		}

		spParameterImpl.resetOriginalValues();

		return spParameterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spParameterId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		category = objectInput.readUTF();
		description = objectInput.readUTF();
		name = objectInput.readUTF();
		value = objectInput.readUTF();
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

		objectOutput.writeLong(spParameterId);
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

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public String uuid;
	public long spParameterId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String category;
	public String description;
	public String name;
	public String value;
}