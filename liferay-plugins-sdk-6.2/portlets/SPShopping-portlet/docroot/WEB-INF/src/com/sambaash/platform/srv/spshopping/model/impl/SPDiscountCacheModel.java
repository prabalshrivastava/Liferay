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

import com.sambaash.platform.srv.spshopping.model.SPDiscount;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPDiscount in entity cache.
 *
 * @author pradeep
 * @see SPDiscount
 * @generated
 */
public class SPDiscountCacheModel implements CacheModel<SPDiscount>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{spDiscountId=");
		sb.append(spDiscountId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", percent=");
		sb.append(percent);
		sb.append(", packageId=");
		sb.append(packageId);
		sb.append(", value=");
		sb.append(value);
		sb.append(", couponCode=");
		sb.append(couponCode);
		sb.append(", description=");
		sb.append(description);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", minQuantity=");
		sb.append(minQuantity);
		sb.append(", maxQuantity=");
		sb.append(maxQuantity);
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
	public SPDiscount toEntityModel() {
		SPDiscountImpl spDiscountImpl = new SPDiscountImpl();

		spDiscountImpl.setSpDiscountId(spDiscountId);
		spDiscountImpl.setGroupId(groupId);

		if (title == null) {
			spDiscountImpl.setTitle(StringPool.BLANK);
		}
		else {
			spDiscountImpl.setTitle(title);
		}

		spDiscountImpl.setPercent(percent);
		spDiscountImpl.setPackageId(packageId);

		if (value == null) {
			spDiscountImpl.setValue(StringPool.BLANK);
		}
		else {
			spDiscountImpl.setValue(value);
		}

		if (couponCode == null) {
			spDiscountImpl.setCouponCode(StringPool.BLANK);
		}
		else {
			spDiscountImpl.setCouponCode(couponCode);
		}

		if (description == null) {
			spDiscountImpl.setDescription(StringPool.BLANK);
		}
		else {
			spDiscountImpl.setDescription(description);
		}

		if (startDate == Long.MIN_VALUE) {
			spDiscountImpl.setStartDate(null);
		}
		else {
			spDiscountImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			spDiscountImpl.setEndDate(null);
		}
		else {
			spDiscountImpl.setEndDate(new Date(endDate));
		}

		spDiscountImpl.setMinQuantity(minQuantity);
		spDiscountImpl.setMaxQuantity(maxQuantity);
		spDiscountImpl.setActive(active);
		spDiscountImpl.setCompanyId(companyId);
		spDiscountImpl.setUserId(userId);

		if (userName == null) {
			spDiscountImpl.setUserName(StringPool.BLANK);
		}
		else {
			spDiscountImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spDiscountImpl.setCreateDate(null);
		}
		else {
			spDiscountImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spDiscountImpl.setModifiedDate(null);
		}
		else {
			spDiscountImpl.setModifiedDate(new Date(modifiedDate));
		}

		spDiscountImpl.resetOriginalValues();

		return spDiscountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spDiscountId = objectInput.readLong();
		groupId = objectInput.readLong();
		title = objectInput.readUTF();
		percent = objectInput.readBoolean();
		packageId = objectInput.readLong();
		value = objectInput.readUTF();
		couponCode = objectInput.readUTF();
		description = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		minQuantity = objectInput.readInt();
		maxQuantity = objectInput.readInt();
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
		objectOutput.writeLong(spDiscountId);
		objectOutput.writeLong(groupId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		objectOutput.writeBoolean(percent);
		objectOutput.writeLong(packageId);

		if (value == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(value);
		}

		if (couponCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(couponCode);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeInt(minQuantity);
		objectOutput.writeInt(maxQuantity);
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

	public long spDiscountId;
	public long groupId;
	public String title;
	public boolean percent;
	public long packageId;
	public String value;
	public String couponCode;
	public String description;
	public long startDate;
	public long endDate;
	public int minQuantity;
	public int maxQuantity;
	public boolean active;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}