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

import com.sambaash.platform.srv.spshopping.model.SPPackageItems;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPPackageItems in entity cache.
 *
 * @author pradeep
 * @see SPPackageItems
 * @generated
 */
public class SPPackageItemsCacheModel implements CacheModel<SPPackageItems>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spPackageItemsId=");
		sb.append(spPackageItemsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", packageId=");
		sb.append(packageId);
		sb.append(", itemId=");
		sb.append(itemId);
		sb.append(", quantity=");
		sb.append(quantity);
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
	public SPPackageItems toEntityModel() {
		SPPackageItemsImpl spPackageItemsImpl = new SPPackageItemsImpl();

		spPackageItemsImpl.setSpPackageItemsId(spPackageItemsId);
		spPackageItemsImpl.setGroupId(groupId);
		spPackageItemsImpl.setPackageId(packageId);
		spPackageItemsImpl.setItemId(itemId);
		spPackageItemsImpl.setQuantity(quantity);
		spPackageItemsImpl.setCompanyId(companyId);
		spPackageItemsImpl.setUserId(userId);

		if (userName == null) {
			spPackageItemsImpl.setUserName(StringPool.BLANK);
		}
		else {
			spPackageItemsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spPackageItemsImpl.setCreateDate(null);
		}
		else {
			spPackageItemsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spPackageItemsImpl.setModifiedDate(null);
		}
		else {
			spPackageItemsImpl.setModifiedDate(new Date(modifiedDate));
		}

		spPackageItemsImpl.resetOriginalValues();

		return spPackageItemsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spPackageItemsId = objectInput.readLong();
		groupId = objectInput.readLong();
		packageId = objectInput.readLong();
		itemId = objectInput.readLong();
		quantity = objectInput.readInt();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spPackageItemsId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(packageId);
		objectOutput.writeLong(itemId);
		objectOutput.writeInt(quantity);
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

	public long spPackageItemsId;
	public long groupId;
	public long packageId;
	public long itemId;
	public int quantity;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}