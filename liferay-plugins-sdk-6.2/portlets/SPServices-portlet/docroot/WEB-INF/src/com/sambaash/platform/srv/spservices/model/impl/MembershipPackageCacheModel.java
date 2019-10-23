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

import com.sambaash.platform.srv.spservices.model.MembershipPackage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MembershipPackage in entity cache.
 *
 * @author gauravvijayvergia
 * @see MembershipPackage
 * @generated
 */
public class MembershipPackageCacheModel implements CacheModel<MembershipPackage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{mpId=");
		sb.append(mpId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", description=");
		sb.append(description);
		sb.append(", status=");
		sb.append(status);
		sb.append(", type=");
		sb.append(type);
		sb.append(", version=");
		sb.append(version);
		sb.append(", cost=");
		sb.append(cost);
		sb.append(", costCurrency=");
		sb.append(costCurrency);
		sb.append(", costPeriod=");
		sb.append(costPeriod);
		sb.append(", costPeriodType=");
		sb.append(costPeriodType);
		sb.append(", promotionCode=");
		sb.append(promotionCode);
		sb.append(", promotionFrom=");
		sb.append(promotionFrom);
		sb.append(", promotionTo=");
		sb.append(promotionTo);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", dateAdded=");
		sb.append(dateAdded);
		sb.append(", dateModified=");
		sb.append(dateModified);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", extra1=");
		sb.append(extra1);
		sb.append(", extra2=");
		sb.append(extra2);
		sb.append(", extra3=");
		sb.append(extra3);
		sb.append(", extra4=");
		sb.append(extra4);
		sb.append(", extra5=");
		sb.append(extra5);
		sb.append(", extra6=");
		sb.append(extra6);
		sb.append(", extra7=");
		sb.append(extra7);
		sb.append(", extra8=");
		sb.append(extra8);
		sb.append(", extra9=");
		sb.append(extra9);
		sb.append(", extra10=");
		sb.append(extra10);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MembershipPackage toEntityModel() {
		MembershipPackageImpl membershipPackageImpl = new MembershipPackageImpl();

		membershipPackageImpl.setMpId(mpId);

		if (name == null) {
			membershipPackageImpl.setName(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setName(name);
		}

		if (description == null) {
			membershipPackageImpl.setDescription(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setDescription(description);
		}

		if (status == null) {
			membershipPackageImpl.setStatus(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setStatus(status);
		}

		if (type == null) {
			membershipPackageImpl.setType(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setType(type);
		}

		if (version == null) {
			membershipPackageImpl.setVersion(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setVersion(version);
		}

		membershipPackageImpl.setCost(cost);

		if (costCurrency == null) {
			membershipPackageImpl.setCostCurrency(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setCostCurrency(costCurrency);
		}

		if (costPeriod == null) {
			membershipPackageImpl.setCostPeriod(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setCostPeriod(costPeriod);
		}

		if (costPeriodType == null) {
			membershipPackageImpl.setCostPeriodType(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setCostPeriodType(costPeriodType);
		}

		if (promotionCode == null) {
			membershipPackageImpl.setPromotionCode(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setPromotionCode(promotionCode);
		}

		if (promotionFrom == Long.MIN_VALUE) {
			membershipPackageImpl.setPromotionFrom(null);
		}
		else {
			membershipPackageImpl.setPromotionFrom(new Date(promotionFrom));
		}

		if (promotionTo == Long.MIN_VALUE) {
			membershipPackageImpl.setPromotionTo(null);
		}
		else {
			membershipPackageImpl.setPromotionTo(new Date(promotionTo));
		}

		if (discount == null) {
			membershipPackageImpl.setDiscount(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setDiscount(discount);
		}

		if (dateAdded == Long.MIN_VALUE) {
			membershipPackageImpl.setDateAdded(null);
		}
		else {
			membershipPackageImpl.setDateAdded(new Date(dateAdded));
		}

		if (dateModified == Long.MIN_VALUE) {
			membershipPackageImpl.setDateModified(null);
		}
		else {
			membershipPackageImpl.setDateModified(new Date(dateModified));
		}

		if (createdBy == null) {
			membershipPackageImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			membershipPackageImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setModifiedBy(modifiedBy);
		}

		if (extra1 == null) {
			membershipPackageImpl.setExtra1(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			membershipPackageImpl.setExtra2(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			membershipPackageImpl.setExtra3(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			membershipPackageImpl.setExtra4(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setExtra4(extra4);
		}

		if (extra5 == Long.MIN_VALUE) {
			membershipPackageImpl.setExtra5(null);
		}
		else {
			membershipPackageImpl.setExtra5(new Date(extra5));
		}

		if (extra6 == Long.MIN_VALUE) {
			membershipPackageImpl.setExtra6(null);
		}
		else {
			membershipPackageImpl.setExtra6(new Date(extra6));
		}

		if (extra7 == null) {
			membershipPackageImpl.setExtra7(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setExtra7(extra7);
		}

		if (extra8 == null) {
			membershipPackageImpl.setExtra8(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setExtra8(extra8);
		}

		if (extra9 == null) {
			membershipPackageImpl.setExtra9(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setExtra9(extra9);
		}

		if (extra10 == null) {
			membershipPackageImpl.setExtra10(StringPool.BLANK);
		}
		else {
			membershipPackageImpl.setExtra10(extra10);
		}

		membershipPackageImpl.resetOriginalValues();

		return membershipPackageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mpId = objectInput.readLong();
		name = objectInput.readUTF();
		description = objectInput.readUTF();
		status = objectInput.readUTF();
		type = objectInput.readUTF();
		version = objectInput.readUTF();
		cost = objectInput.readFloat();
		costCurrency = objectInput.readUTF();
		costPeriod = objectInput.readUTF();
		costPeriodType = objectInput.readUTF();
		promotionCode = objectInput.readUTF();
		promotionFrom = objectInput.readLong();
		promotionTo = objectInput.readLong();
		discount = objectInput.readUTF();
		dateAdded = objectInput.readLong();
		dateModified = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedBy = objectInput.readUTF();
		extra1 = objectInput.readUTF();
		extra2 = objectInput.readUTF();
		extra3 = objectInput.readUTF();
		extra4 = objectInput.readUTF();
		extra5 = objectInput.readLong();
		extra6 = objectInput.readLong();
		extra7 = objectInput.readUTF();
		extra8 = objectInput.readUTF();
		extra9 = objectInput.readUTF();
		extra10 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(mpId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeFloat(cost);

		if (costCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costCurrency);
		}

		if (costPeriod == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costPeriod);
		}

		if (costPeriodType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costPeriodType);
		}

		if (promotionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(promotionCode);
		}

		objectOutput.writeLong(promotionFrom);
		objectOutput.writeLong(promotionTo);

		if (discount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(discount);
		}

		objectOutput.writeLong(dateAdded);
		objectOutput.writeLong(dateModified);

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		if (modifiedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modifiedBy);
		}

		if (extra1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra1);
		}

		if (extra2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra2);
		}

		if (extra3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra3);
		}

		if (extra4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra4);
		}

		objectOutput.writeLong(extra5);
		objectOutput.writeLong(extra6);

		if (extra7 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra7);
		}

		if (extra8 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra8);
		}

		if (extra9 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra9);
		}

		if (extra10 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra10);
		}
	}

	public long mpId;
	public String name;
	public String description;
	public String status;
	public String type;
	public String version;
	public float cost;
	public String costCurrency;
	public String costPeriod;
	public String costPeriodType;
	public String promotionCode;
	public long promotionFrom;
	public long promotionTo;
	public String discount;
	public long dateAdded;
	public long dateModified;
	public String createdBy;
	public String modifiedBy;
	public String extra1;
	public String extra2;
	public String extra3;
	public String extra4;
	public long extra5;
	public long extra6;
	public String extra7;
	public String extra8;
	public String extra9;
	public String extra10;
}