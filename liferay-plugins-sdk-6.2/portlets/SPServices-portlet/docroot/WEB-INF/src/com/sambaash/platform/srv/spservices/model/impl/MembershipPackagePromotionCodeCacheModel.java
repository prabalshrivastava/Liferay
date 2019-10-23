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

import com.sambaash.platform.srv.spservices.model.MembershipPackagePromotionCode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MembershipPackagePromotionCode in entity cache.
 *
 * @author gauravvijayvergia
 * @see MembershipPackagePromotionCode
 * @generated
 */
public class MembershipPackagePromotionCodeCacheModel implements CacheModel<MembershipPackagePromotionCode>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{promotionCode_id=");
		sb.append(promotionCode_id);
		sb.append(", membershipPackage_id=");
		sb.append(membershipPackage_id);
		sb.append(", promotionCode=");
		sb.append(promotionCode);
		sb.append(", promotionFrom=");
		sb.append(promotionFrom);
		sb.append(", promotionTo=");
		sb.append(promotionTo);
		sb.append(", discount=");
		sb.append(discount);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MembershipPackagePromotionCode toEntityModel() {
		MembershipPackagePromotionCodeImpl membershipPackagePromotionCodeImpl = new MembershipPackagePromotionCodeImpl();

		membershipPackagePromotionCodeImpl.setPromotionCode_id(promotionCode_id);
		membershipPackagePromotionCodeImpl.setMembershipPackage_id(membershipPackage_id);

		if (promotionCode == null) {
			membershipPackagePromotionCodeImpl.setPromotionCode(StringPool.BLANK);
		}
		else {
			membershipPackagePromotionCodeImpl.setPromotionCode(promotionCode);
		}

		if (promotionFrom == Long.MIN_VALUE) {
			membershipPackagePromotionCodeImpl.setPromotionFrom(null);
		}
		else {
			membershipPackagePromotionCodeImpl.setPromotionFrom(new Date(
					promotionFrom));
		}

		if (promotionTo == Long.MIN_VALUE) {
			membershipPackagePromotionCodeImpl.setPromotionTo(null);
		}
		else {
			membershipPackagePromotionCodeImpl.setPromotionTo(new Date(
					promotionTo));
		}

		if (discount == null) {
			membershipPackagePromotionCodeImpl.setDiscount(StringPool.BLANK);
		}
		else {
			membershipPackagePromotionCodeImpl.setDiscount(discount);
		}

		if (extra1 == null) {
			membershipPackagePromotionCodeImpl.setExtra1(StringPool.BLANK);
		}
		else {
			membershipPackagePromotionCodeImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			membershipPackagePromotionCodeImpl.setExtra2(StringPool.BLANK);
		}
		else {
			membershipPackagePromotionCodeImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			membershipPackagePromotionCodeImpl.setExtra3(StringPool.BLANK);
		}
		else {
			membershipPackagePromotionCodeImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			membershipPackagePromotionCodeImpl.setExtra4(StringPool.BLANK);
		}
		else {
			membershipPackagePromotionCodeImpl.setExtra4(extra4);
		}

		if (extra5 == null) {
			membershipPackagePromotionCodeImpl.setExtra5(StringPool.BLANK);
		}
		else {
			membershipPackagePromotionCodeImpl.setExtra5(extra5);
		}

		membershipPackagePromotionCodeImpl.resetOriginalValues();

		return membershipPackagePromotionCodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		promotionCode_id = objectInput.readLong();
		membershipPackage_id = objectInput.readLong();
		promotionCode = objectInput.readUTF();
		promotionFrom = objectInput.readLong();
		promotionTo = objectInput.readLong();
		discount = objectInput.readUTF();
		extra1 = objectInput.readUTF();
		extra2 = objectInput.readUTF();
		extra3 = objectInput.readUTF();
		extra4 = objectInput.readUTF();
		extra5 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(promotionCode_id);
		objectOutput.writeLong(membershipPackage_id);

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

		if (extra5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra5);
		}
	}

	public long promotionCode_id;
	public long membershipPackage_id;
	public String promotionCode;
	public long promotionFrom;
	public long promotionTo;
	public String discount;
	public String extra1;
	public String extra2;
	public String extra3;
	public String extra4;
	public String extra5;
}