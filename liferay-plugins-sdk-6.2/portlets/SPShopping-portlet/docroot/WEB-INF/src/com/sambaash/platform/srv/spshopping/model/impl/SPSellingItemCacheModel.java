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

package com.sambaash.platform.srv.spshopping.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spshopping.model.SPSellingItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPSellingItem in entity cache.
 *
 * @author pradeep
 * @see SPSellingItem
 * @generated
 */
public class SPSellingItemCacheModel implements CacheModel<SPSellingItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{spSellingItemId=");
		sb.append(spSellingItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", itemCode=");
		sb.append(itemCode);
		sb.append(", entityClassPk=");
		sb.append(entityClassPk);
		sb.append(", entityClassNameId=");
		sb.append(entityClassNameId);
		sb.append(", entityClassName=");
		sb.append(entityClassName);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", longDescription=");
		sb.append(longDescription);
		sb.append(", active=");
		sb.append(active);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPSellingItem toEntityModel() {
		SPSellingItemImpl spSellingItemImpl = new SPSellingItemImpl();

		spSellingItemImpl.setSpSellingItemId(spSellingItemId);
		spSellingItemImpl.setGroupId(groupId);

		if (title == null) {
			spSellingItemImpl.setTitle(StringPool.BLANK);
		}
		else {
			spSellingItemImpl.setTitle(title);
		}

		if (itemCode == null) {
			spSellingItemImpl.setItemCode(StringPool.BLANK);
		}
		else {
			spSellingItemImpl.setItemCode(itemCode);
		}

		spSellingItemImpl.setEntityClassPk(entityClassPk);
		spSellingItemImpl.setEntityClassNameId(entityClassNameId);

		if (entityClassName == null) {
			spSellingItemImpl.setEntityClassName(StringPool.BLANK);
		}
		else {
			spSellingItemImpl.setEntityClassName(entityClassName);
		}

		if (shortDescription == null) {
			spSellingItemImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			spSellingItemImpl.setShortDescription(shortDescription);
		}

		if (longDescription == null) {
			spSellingItemImpl.setLongDescription(StringPool.BLANK);
		}
		else {
			spSellingItemImpl.setLongDescription(longDescription);
		}

		spSellingItemImpl.setActive(active);
		spSellingItemImpl.setCompanyId(companyId);
		spSellingItemImpl.setUserId(userId);

		if (userName == null) {
			spSellingItemImpl.setUserName(StringPool.BLANK);
		}
		else {
			spSellingItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spSellingItemImpl.setCreateDate(null);
		}
		else {
			spSellingItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spSellingItemImpl.setModifiedDate(null);
		}
		else {
			spSellingItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		spSellingItemImpl.resetOriginalValues();

		return spSellingItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spSellingItemId = objectInput.readLong();
		groupId = objectInput.readLong();
		title = objectInput.readUTF();
		itemCode = objectInput.readUTF();
		entityClassPk = objectInput.readLong();
		entityClassNameId = objectInput.readLong();
		entityClassName = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		longDescription = objectInput.readUTF();
		active = objectInput.readBoolean();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spSellingItemId);
		objectOutput.writeLong(groupId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (itemCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(itemCode);
		}

		objectOutput.writeLong(entityClassPk);
		objectOutput.writeLong(entityClassNameId);

		if (entityClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entityClassName);
		}

		if (shortDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortDescription);
		}

		if (longDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longDescription);
		}

		objectOutput.writeBoolean(active);
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
	}

	public long spSellingItemId;
	public long groupId;
	public String title;
	public String itemCode;
	public long entityClassPk;
	public long entityClassNameId;
	public String entityClassName;
	public String shortDescription;
	public String longDescription;
	public boolean active;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}