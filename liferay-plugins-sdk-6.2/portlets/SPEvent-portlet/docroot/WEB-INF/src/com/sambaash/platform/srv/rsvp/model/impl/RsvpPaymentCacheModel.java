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

import com.sambaash.platform.srv.rsvp.model.RsvpPayment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RsvpPayment in entity cache.
 *
 * @author gauravvijayvergia
 * @see RsvpPayment
 * @generated
 */
public class RsvpPaymentCacheModel implements CacheModel<RsvpPayment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rsvpPaymentId=");
		sb.append(rsvpPaymentId);
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
		sb.append(", rsvpDetailId=");
		sb.append(rsvpDetailId);
		sb.append(", rsvpId=");
		sb.append(rsvpId);
		sb.append(", rsvpTicketId=");
		sb.append(rsvpTicketId);
		sb.append(", rsvpDiscountId=");
		sb.append(rsvpDiscountId);
		sb.append(", rsvpPromoCodeId=");
		sb.append(rsvpPromoCodeId);
		sb.append(", price=");
		sb.append(price);
		sb.append(", numberOfPeople=");
		sb.append(numberOfPeople);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", netTotal=");
		sb.append(netTotal);
		sb.append(", ticketNumber=");
		sb.append(ticketNumber);
		sb.append(", payerEmailAddress=");
		sb.append(payerEmailAddress);
		sb.append(", receiverEmailAddress=");
		sb.append(receiverEmailAddress);
		sb.append(", transactionId=");
		sb.append(transactionId);
		sb.append(", transactionStatus=");
		sb.append(transactionStatus);
		sb.append(", transactionAmount=");
		sb.append(transactionAmount);
		sb.append(", transactionDate=");
		sb.append(transactionDate);
		sb.append(", emailStatus=");
		sb.append(emailStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RsvpPayment toEntityModel() {
		RsvpPaymentImpl rsvpPaymentImpl = new RsvpPaymentImpl();

		if (uuid == null) {
			rsvpPaymentImpl.setUuid(StringPool.BLANK);
		}
		else {
			rsvpPaymentImpl.setUuid(uuid);
		}

		rsvpPaymentImpl.setRsvpPaymentId(rsvpPaymentId);
		rsvpPaymentImpl.setGroupId(groupId);
		rsvpPaymentImpl.setCompanyId(companyId);
		rsvpPaymentImpl.setUserId(userId);

		if (userName == null) {
			rsvpPaymentImpl.setUserName(StringPool.BLANK);
		}
		else {
			rsvpPaymentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rsvpPaymentImpl.setCreateDate(null);
		}
		else {
			rsvpPaymentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rsvpPaymentImpl.setModifiedDate(null);
		}
		else {
			rsvpPaymentImpl.setModifiedDate(new Date(modifiedDate));
		}

		rsvpPaymentImpl.setRsvpDetailId(rsvpDetailId);
		rsvpPaymentImpl.setRsvpId(rsvpId);
		rsvpPaymentImpl.setRsvpTicketId(rsvpTicketId);
		rsvpPaymentImpl.setRsvpDiscountId(rsvpDiscountId);
		rsvpPaymentImpl.setRsvpPromoCodeId(rsvpPromoCodeId);
		rsvpPaymentImpl.setPrice(price);
		rsvpPaymentImpl.setNumberOfPeople(numberOfPeople);
		rsvpPaymentImpl.setDiscount(discount);
		rsvpPaymentImpl.setNetTotal(netTotal);

		if (ticketNumber == null) {
			rsvpPaymentImpl.setTicketNumber(StringPool.BLANK);
		}
		else {
			rsvpPaymentImpl.setTicketNumber(ticketNumber);
		}

		if (payerEmailAddress == null) {
			rsvpPaymentImpl.setPayerEmailAddress(StringPool.BLANK);
		}
		else {
			rsvpPaymentImpl.setPayerEmailAddress(payerEmailAddress);
		}

		if (receiverEmailAddress == null) {
			rsvpPaymentImpl.setReceiverEmailAddress(StringPool.BLANK);
		}
		else {
			rsvpPaymentImpl.setReceiverEmailAddress(receiverEmailAddress);
		}

		if (transactionId == null) {
			rsvpPaymentImpl.setTransactionId(StringPool.BLANK);
		}
		else {
			rsvpPaymentImpl.setTransactionId(transactionId);
		}

		if (transactionStatus == null) {
			rsvpPaymentImpl.setTransactionStatus(StringPool.BLANK);
		}
		else {
			rsvpPaymentImpl.setTransactionStatus(transactionStatus);
		}

		rsvpPaymentImpl.setTransactionAmount(transactionAmount);

		if (transactionDate == Long.MIN_VALUE) {
			rsvpPaymentImpl.setTransactionDate(null);
		}
		else {
			rsvpPaymentImpl.setTransactionDate(new Date(transactionDate));
		}

		rsvpPaymentImpl.setEmailStatus(emailStatus);

		rsvpPaymentImpl.resetOriginalValues();

		return rsvpPaymentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		rsvpPaymentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		rsvpDetailId = objectInput.readLong();
		rsvpId = objectInput.readLong();
		rsvpTicketId = objectInput.readLong();
		rsvpDiscountId = objectInput.readLong();
		rsvpPromoCodeId = objectInput.readLong();
		price = objectInput.readDouble();
		numberOfPeople = objectInput.readInt();
		discount = objectInput.readInt();
		netTotal = objectInput.readDouble();
		ticketNumber = objectInput.readUTF();
		payerEmailAddress = objectInput.readUTF();
		receiverEmailAddress = objectInput.readUTF();
		transactionId = objectInput.readUTF();
		transactionStatus = objectInput.readUTF();
		transactionAmount = objectInput.readDouble();
		transactionDate = objectInput.readLong();
		emailStatus = objectInput.readBoolean();
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

		objectOutput.writeLong(rsvpPaymentId);
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
		objectOutput.writeLong(rsvpDetailId);
		objectOutput.writeLong(rsvpId);
		objectOutput.writeLong(rsvpTicketId);
		objectOutput.writeLong(rsvpDiscountId);
		objectOutput.writeLong(rsvpPromoCodeId);
		objectOutput.writeDouble(price);
		objectOutput.writeInt(numberOfPeople);
		objectOutput.writeInt(discount);
		objectOutput.writeDouble(netTotal);

		if (ticketNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNumber);
		}

		if (payerEmailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(payerEmailAddress);
		}

		if (receiverEmailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receiverEmailAddress);
		}

		if (transactionId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(transactionId);
		}

		if (transactionStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(transactionStatus);
		}

		objectOutput.writeDouble(transactionAmount);
		objectOutput.writeLong(transactionDate);
		objectOutput.writeBoolean(emailStatus);
	}

	public String uuid;
	public long rsvpPaymentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long rsvpDetailId;
	public long rsvpId;
	public long rsvpTicketId;
	public long rsvpDiscountId;
	public long rsvpPromoCodeId;
	public double price;
	public int numberOfPeople;
	public int discount;
	public double netTotal;
	public String ticketNumber;
	public String payerEmailAddress;
	public String receiverEmailAddress;
	public String transactionId;
	public String transactionStatus;
	public double transactionAmount;
	public long transactionDate;
	public boolean emailStatus;
}