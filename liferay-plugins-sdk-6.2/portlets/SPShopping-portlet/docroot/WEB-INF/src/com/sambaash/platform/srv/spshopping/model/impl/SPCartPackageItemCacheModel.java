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

import com.sambaash.platform.srv.spshopping.model.SPCartPackageItem;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPCartPackageItem in entity cache.
 *
 * @author pradeep
 * @see SPCartPackageItem
 * @generated
 */
public class SPCartPackageItemCacheModel implements CacheModel<SPCartPackageItem>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{spCartPackageItemId=");
		sb.append(spCartPackageItemId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", spCartPackageId=");
		sb.append(spCartPackageId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", itemCode=");
		sb.append(itemCode);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", entityClassPk=");
		sb.append(entityClassPk);
		sb.append(", entityClassName=");
		sb.append(entityClassName);
		sb.append(", totalPrice=");
		sb.append(totalPrice);
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
	public SPCartPackageItem toEntityModel() {
		SPCartPackageItemImpl spCartPackageItemImpl = new SPCartPackageItemImpl();

		spCartPackageItemImpl.setSpCartPackageItemId(spCartPackageItemId);
		spCartPackageItemImpl.setGroupId(groupId);
		spCartPackageItemImpl.setSpCartPackageId(spCartPackageId);

		if (title == null) {
			spCartPackageItemImpl.setTitle(StringPool.BLANK);
		}
		else {
			spCartPackageItemImpl.setTitle(title);
		}

		if (itemCode == null) {
			spCartPackageItemImpl.setItemCode(StringPool.BLANK);
		}
		else {
			spCartPackageItemImpl.setItemCode(itemCode);
		}

		spCartPackageItemImpl.setQuantity(quantity);
		spCartPackageItemImpl.setEntityClassPk(entityClassPk);

		if (entityClassName == null) {
			spCartPackageItemImpl.setEntityClassName(StringPool.BLANK);
		}
		else {
			spCartPackageItemImpl.setEntityClassName(entityClassName);
		}

		if (totalPrice == null) {
			spCartPackageItemImpl.setTotalPrice(StringPool.BLANK);
		}
		else {
			spCartPackageItemImpl.setTotalPrice(totalPrice);
		}

		spCartPackageItemImpl.setCompanyId(companyId);
		spCartPackageItemImpl.setUserId(userId);

		if (userName == null) {
			spCartPackageItemImpl.setUserName(StringPool.BLANK);
		}
		else {
			spCartPackageItemImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spCartPackageItemImpl.setCreateDate(null);
		}
		else {
			spCartPackageItemImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spCartPackageItemImpl.setModifiedDate(null);
		}
		else {
			spCartPackageItemImpl.setModifiedDate(new Date(modifiedDate));
		}

		spCartPackageItemImpl.resetOriginalValues();

		return spCartPackageItemImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCartPackageItemId = objectInput.readLong();
		groupId = objectInput.readLong();
		spCartPackageId = objectInput.readLong();
		title = objectInput.readUTF();
		itemCode = objectInput.readUTF();
		quantity = objectInput.readInt();
		entityClassPk = objectInput.readLong();
		entityClassName = objectInput.readUTF();
		totalPrice = objectInput.readUTF();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCartPackageItemId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(spCartPackageId);

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

		objectOutput.writeInt(quantity);
		objectOutput.writeLong(entityClassPk);

		if (entityClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entityClassName);
		}

		if (totalPrice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(totalPrice);
		}

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

	public long spCartPackageItemId;
	public long groupId;
	public long spCartPackageId;
	public String title;
	public String itemCode;
	public int quantity;
	public long entityClassPk;
	public String entityClassName;
	public String totalPrice;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}