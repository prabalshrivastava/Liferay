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

import com.sambaash.platform.srv.spservices.model.SPListType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPListType in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPListType
 * @generated
 */
public class SPListTypeCacheModel implements CacheModel<SPListType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spListTypeId=");
		sb.append(spListTypeId);
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
		sb.append(", itemKey=");
		sb.append(itemKey);
		sb.append(", itemValue=");
		sb.append(itemValue);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", displayOrder=");
		sb.append(displayOrder);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", modeldata=");
		sb.append(modeldata);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPListType toEntityModel() {
		SPListTypeImpl spListTypeImpl = new SPListTypeImpl();

		if (uuid == null) {
			spListTypeImpl.setUuid(StringPool.BLANK);
		}
		else {
			spListTypeImpl.setUuid(uuid);
		}

		spListTypeImpl.setSpListTypeId(spListTypeId);
		spListTypeImpl.setGroupId(groupId);
		spListTypeImpl.setCompanyId(companyId);
		spListTypeImpl.setUserId(userId);

		if (userName == null) {
			spListTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			spListTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spListTypeImpl.setCreateDate(null);
		}
		else {
			spListTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spListTypeImpl.setModifiedDate(null);
		}
		else {
			spListTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (itemKey == null) {
			spListTypeImpl.setItemKey(StringPool.BLANK);
		}
		else {
			spListTypeImpl.setItemKey(itemKey);
		}

		if (itemValue == null) {
			spListTypeImpl.setItemValue(StringPool.BLANK);
		}
		else {
			spListTypeImpl.setItemValue(itemValue);
		}

		if (displayName == null) {
			spListTypeImpl.setDisplayName(StringPool.BLANK);
		}
		else {
			spListTypeImpl.setDisplayName(displayName);
		}

		spListTypeImpl.setDisplayOrder(displayOrder);
		spListTypeImpl.setCategoryId(categoryId);

		if (modeldata == null) {
			spListTypeImpl.setModeldata(StringPool.BLANK);
		}
		else {
			spListTypeImpl.setModeldata(modeldata);
		}

		spListTypeImpl.resetOriginalValues();

		return spListTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spListTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		itemKey = objectInput.readUTF();
		itemValue = objectInput.readUTF();
		displayName = objectInput.readUTF();
		displayOrder = objectInput.readInt();
		categoryId = objectInput.readLong();
		modeldata = objectInput.readUTF();
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

		objectOutput.writeLong(spListTypeId);
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

		if (itemKey == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemKey);
		}

		if (itemValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemValue);
		}

		if (displayName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		objectOutput.writeInt(displayOrder);
		objectOutput.writeLong(categoryId);

		if (modeldata == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modeldata);
		}
	}

	public String uuid;
	public long spListTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String itemKey;
	public String itemValue;
	public String displayName;
	public int displayOrder;
	public long categoryId;
	public String modeldata;
}