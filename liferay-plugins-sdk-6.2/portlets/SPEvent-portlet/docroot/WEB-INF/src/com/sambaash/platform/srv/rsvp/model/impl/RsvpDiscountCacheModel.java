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

import com.sambaash.platform.srv.rsvp.model.RsvpDiscount;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RsvpDiscount in entity cache.
 *
 * @author gauravvijayvergia
 * @see RsvpDiscount
 * @generated
 */
public class RsvpDiscountCacheModel implements CacheModel<RsvpDiscount>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rsvpDiscountId=");
		sb.append(rsvpDiscountId);
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
	public RsvpDiscount toEntityModel() {
		RsvpDiscountImpl rsvpDiscountImpl = new RsvpDiscountImpl();

		if (uuid == null) {
			rsvpDiscountImpl.setUuid(StringPool.BLANK);
		}
		else {
			rsvpDiscountImpl.setUuid(uuid);
		}

		rsvpDiscountImpl.setRsvpDiscountId(rsvpDiscountId);
		rsvpDiscountImpl.setGroupId(groupId);
		rsvpDiscountImpl.setCompanyId(companyId);
		rsvpDiscountImpl.setUserId(userId);

		if (userName == null) {
			rsvpDiscountImpl.setUserName(StringPool.BLANK);
		}
		else {
			rsvpDiscountImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rsvpDiscountImpl.setCreateDate(null);
		}
		else {
			rsvpDiscountImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rsvpDiscountImpl.setModifiedDate(null);
		}
		else {
			rsvpDiscountImpl.setModifiedDate(new Date(modifiedDate));
		}

		rsvpDiscountImpl.setRsvpId(rsvpId);
		rsvpDiscountImpl.setRsvpTicketId(rsvpTicketId);

		if (fromDate == Long.MIN_VALUE) {
			rsvpDiscountImpl.setFromDate(null);
		}
		else {
			rsvpDiscountImpl.setFromDate(new Date(fromDate));
		}

		if (toDate == Long.MIN_VALUE) {
			rsvpDiscountImpl.setToDate(null);
		}
		else {
			rsvpDiscountImpl.setToDate(new Date(toDate));
		}

		rsvpDiscountImpl.setNoOfTickets(noOfTickets);
		rsvpDiscountImpl.setDiscount(discount);
		rsvpDiscountImpl.setModifiedBy(modifiedBy);

		rsvpDiscountImpl.resetOriginalValues();

		return rsvpDiscountImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		rsvpDiscountId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		rsvpId = objectInput.readLong();
		rsvpTicketId = objectInput.readLong();
		fromDate = objectInput.readLong();
		toDate = objectInput.readLong();
		noOfTickets = objectInput.readInt();
		discount = objectInput.readDouble();
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

		objectOutput.writeLong(rsvpDiscountId);
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
		objectOutput.writeLong(fromDate);
		objectOutput.writeLong(toDate);
		objectOutput.writeInt(noOfTickets);
		objectOutput.writeDouble(discount);
		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long rsvpDiscountId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long rsvpId;
	public long rsvpTicketId;
	public long fromDate;
	public long toDate;
	public int noOfTickets;
	public double discount;
	public long modifiedBy;
}