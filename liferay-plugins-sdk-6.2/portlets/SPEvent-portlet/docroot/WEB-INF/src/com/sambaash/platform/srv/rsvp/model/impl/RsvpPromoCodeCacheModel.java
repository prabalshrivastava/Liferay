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

package com.sambaash.platform.srv.rsvp.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.rsvp.model.RsvpPromoCode;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RsvpPromoCode in entity cache.
 *
 * @author gauravvijayvergia
 * @see RsvpPromoCode
 * @generated
 */
public class RsvpPromoCodeCacheModel implements CacheModel<RsvpPromoCode>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rsvpPromoCodeId=");
		sb.append(rsvpPromoCodeId);
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
		sb.append(", rsvpId=");
		sb.append(rsvpId);
		sb.append(", rsvpTicketId=");
		sb.append(rsvpTicketId);
		sb.append(", promoCode=");
		sb.append(promoCode);
		sb.append(", fromDate=");
		sb.append(fromDate);
		sb.append(", toDate=");
		sb.append(toDate);
		sb.append(", noOfTickets=");
		sb.append(noOfTickets);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RsvpPromoCode toEntityModel() {
		RsvpPromoCodeImpl rsvpPromoCodeImpl = new RsvpPromoCodeImpl();

		if (uuid == null) {
			rsvpPromoCodeImpl.setUuid(StringPool.BLANK);
		}
		else {
			rsvpPromoCodeImpl.setUuid(uuid);
		}

		rsvpPromoCodeImpl.setRsvpPromoCodeId(rsvpPromoCodeId);
		rsvpPromoCodeImpl.setGroupId(groupId);
		rsvpPromoCodeImpl.setCompanyId(companyId);
		rsvpPromoCodeImpl.setUserId(userId);

		if (userName == null) {
			rsvpPromoCodeImpl.setUserName(StringPool.BLANK);
		}
		else {
			rsvpPromoCodeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rsvpPromoCodeImpl.setCreateDate(null);
		}
		else {
			rsvpPromoCodeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rsvpPromoCodeImpl.setModifiedDate(null);
		}
		else {
			rsvpPromoCodeImpl.setModifiedDate(new Date(modifiedDate));
		}

		rsvpPromoCodeImpl.setRsvpId(rsvpId);
		rsvpPromoCodeImpl.setRsvpTicketId(rsvpTicketId);

		if (promoCode == null) {
			rsvpPromoCodeImpl.setPromoCode(StringPool.BLANK);
		}
		else {
			rsvpPromoCodeImpl.setPromoCode(promoCode);
		}

		if (fromDate == Long.MIN_VALUE) {
			rsvpPromoCodeImpl.setFromDate(null);
		}
		else {
			rsvpPromoCodeImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			rsvpPromoCodeImpl.setToDate(null);
		}
		else {
			rsvpPromoCodeImpl.setToDate(new Date(toDate));
		}

		rsvpPromoCodeImpl.setNoOfTickets(noOfTickets);
		rsvpPromoCodeImpl.setDiscount(discount);
		rsvpPromoCodeImpl.setModifiedBy(modifiedBy);

		rsvpPromoCodeImpl.resetOriginalValues();

		return rsvpPromoCodeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		rsvpPromoCodeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		rsvpId = objectInput.readLong();
		rsvpTicketId = objectInput.readLong();
		promoCode = objectInput.readUTF();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		noOfTickets = objectInput.readInt();
		discount = objectInput.readInt();
		modifiedBy = objectInput.readLong();
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

		objectOutput.writeLong(rsvpPromoCodeId);
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
		objectOutput.writeLong(rsvpId);
		objectOutput.writeLong(rsvpTicketId);

		if (promoCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(promoCode);
		}

		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);
		objectOutput.writeInt(noOfTickets);
		objectOutput.writeInt(discount);
		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long rsvpPromoCodeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long rsvpId;
	public long rsvpTicketId;
	public String promoCode;
	public long fromDate;
	public long toDate;
	public int noOfTickets;
	public int discount;
	public long modifiedBy;
}