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

import com.sambaash.platform.srv.rsvp.model.RsvpTicket;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RsvpTicket in entity cache.
 *
 * @author gauravvijayvergia
 * @see RsvpTicket
 * @generated
 */
public class RsvpTicketCacheModel implements CacheModel<RsvpTicket>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rsvpTicketId=");
		sb.append(rsvpTicketId);
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
		sb.append(", price=");
		sb.append(price);
		sb.append(", quantity=");
		sb.append(quantity);
		sb.append(", soldQuantity=");
		sb.append(soldQuantity);
		sb.append(", ticketSequence=");
		sb.append(ticketSequence);
		sb.append(", lastSequenceNumber=");
		sb.append(lastSequenceNumber);
		sb.append(", sequencePrefix=");
		sb.append(sequencePrefix);
		sb.append(", sequenceSuffix=");
		sb.append(sequenceSuffix);
		sb.append(", ticketTemplateUrl=");
		sb.append(ticketTemplateUrl);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RsvpTicket toEntityModel() {
		RsvpTicketImpl rsvpTicketImpl = new RsvpTicketImpl();

		if (uuid == null) {
			rsvpTicketImpl.setUuid(StringPool.BLANK);
		}
		else {
			rsvpTicketImpl.setUuid(uuid);
		}

		rsvpTicketImpl.setRsvpTicketId(rsvpTicketId);
		rsvpTicketImpl.setGroupId(groupId);
		rsvpTicketImpl.setCompanyId(companyId);
		rsvpTicketImpl.setUserId(userId);

		if (userName == null) {
			rsvpTicketImpl.setUserName(StringPool.BLANK);
		}
		else {
			rsvpTicketImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rsvpTicketImpl.setCreateDate(null);
		}
		else {
			rsvpTicketImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rsvpTicketImpl.setModifiedDate(null);
		}
		else {
			rsvpTicketImpl.setModifiedDate(new Date(modifiedDate));
		}

		rsvpTicketImpl.setRsvpId(rsvpId);
		rsvpTicketImpl.setPrice(price);
		rsvpTicketImpl.setQuantity(quantity);
		rsvpTicketImpl.setSoldQuantity(soldQuantity);
		rsvpTicketImpl.setTicketSequence(ticketSequence);
		rsvpTicketImpl.setLastSequenceNumber(lastSequenceNumber);

		if (sequencePrefix == null) {
			rsvpTicketImpl.setSequencePrefix(StringPool.BLANK);
		}
		else {
			rsvpTicketImpl.setSequencePrefix(sequencePrefix);
		}

		if (sequenceSuffix == null) {
			rsvpTicketImpl.setSequenceSuffix(StringPool.BLANK);
		}
		else {
			rsvpTicketImpl.setSequenceSuffix(sequenceSuffix);
		}

		if (ticketTemplateUrl == null) {
			rsvpTicketImpl.setTicketTemplateUrl(StringPool.BLANK);
		}
		else {
			rsvpTicketImpl.setTicketTemplateUrl(ticketTemplateUrl);
		}

		rsvpTicketImpl.setModifiedBy(modifiedBy);

		rsvpTicketImpl.resetOriginalValues();

		return rsvpTicketImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		rsvpTicketId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		rsvpId = objectInput.readLong();
		price = objectInput.readDouble();
		quantity = objectInput.readInt();
		soldQuantity = objectInput.readInt();
		ticketSequence = objectInput.readInt();
		lastSequenceNumber = objectInput.readInt();
		sequencePrefix = objectInput.readUTF();
		sequenceSuffix = objectInput.readUTF();
		ticketTemplateUrl = objectInput.readUTF();
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

		objectOutput.writeLong(rsvpTicketId);
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
		objectOutput.writeDouble(price);
		objectOutput.writeInt(quantity);
		objectOutput.writeInt(soldQuantity);
		objectOutput.writeInt(ticketSequence);
		objectOutput.writeInt(lastSequenceNumber);

		if (sequencePrefix == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sequencePrefix);
		}

		if (sequenceSuffix == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sequenceSuffix);
		}

		if (ticketTemplateUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketTemplateUrl);
		}

		objectOutput.writeLong(modifiedBy);
	}

	public String uuid;
	public long rsvpTicketId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long rsvpId;
	public double price;
	public int quantity;
	public int soldQuantity;
	public int ticketSequence;
	public int lastSequenceNumber;
	public String sequencePrefix;
	public String sequenceSuffix;
	public String ticketTemplateUrl;
	public long modifiedBy;
}