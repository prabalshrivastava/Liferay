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

package com.wtberks.configuration.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.wtberks.configuration.model.ConfigurationProperty;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ConfigurationProperty in entity cache.
 *
 * @author liferay
 * @see ConfigurationProperty
 * @generated
 */
public class ConfigurationPropertyCacheModel implements CacheModel<ConfigurationProperty>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", configurationPropertyId=");
		sb.append(configurationPropertyId);
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
		sb.append(", key=");
		sb.append(key);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConfigurationProperty toEntityModel() {
		ConfigurationPropertyImpl configurationPropertyImpl = new ConfigurationPropertyImpl();

		if (uuid == null) {
			configurationPropertyImpl.setUuid(StringPool.BLANK);
		}
		else {
			configurationPropertyImpl.setUuid(uuid);
		}

		configurationPropertyImpl.setConfigurationPropertyId(configurationPropertyId);
		configurationPropertyImpl.setGroupId(groupId);
		configurationPropertyImpl.setCompanyId(companyId);
		configurationPropertyImpl.setUserId(userId);

		if (userName == null) {
			configurationPropertyImpl.setUserName(StringPool.BLANK);
		}
		else {
			configurationPropertyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			configurationPropertyImpl.setCreateDate(null);
		}
		else {
			configurationPropertyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			configurationPropertyImpl.setModifiedDate(null);
		}
		else {
			configurationPropertyImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (key == null) {
			configurationPropertyImpl.setKey(StringPool.BLANK);
		}
		else {
			configurationPropertyImpl.setKey(key);
		}

		if (value == null) {
			configurationPropertyImpl.setValue(StringPool.BLANK);
		}
		else {
			configurationPropertyImpl.setValue(value);
		}

		configurationPropertyImpl.resetOriginalValues();

		return configurationPropertyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		configurationPropertyId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		key = objectInput.readUTF();
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

		objectOutput.writeLong(configurationPropertyId);
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

		if (key == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(key);
		}

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}
	}

	public String uuid;
	public long configurationPropertyId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String key;
	public String value;
}