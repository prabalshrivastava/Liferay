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

import com.sambaash.platform.srv.rsvp.model.Rsvp;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Rsvp in entity cache.
 *
 * @author gauravvijayvergia
 * @see Rsvp
 * @generated
 */
public class RsvpCacheModel implements CacheModel<Rsvp>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rsvpId=");
		sb.append(rsvpId);
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
		sb.append(", title=");
		sb.append(title);
		sb.append(", description=");
		sb.append(description);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append(", spAssetTypeId=");
		sb.append(spAssetTypeId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", rsvpUrl=");
		sb.append(rsvpUrl);
		sb.append(", processing=");
		sb.append(processing);
		sb.append(", price=");
		sb.append(price);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", tax=");
		sb.append(tax);
		sb.append(", accountId=");
		sb.append(accountId);
		sb.append(", paymentFlag=");
		sb.append(paymentFlag);
		sb.append(", registerFlag=");
		sb.append(registerFlag);
		sb.append(", ticketFlag=");
		sb.append(ticketFlag);
		sb.append(", dynamicSectionName=");
		sb.append(dynamicSectionName);
		sb.append(", ccEmail=");
		sb.append(ccEmail);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Rsvp toEntityModel() {
		RsvpImpl rsvpImpl = new RsvpImpl();

		if (uuid == null) {
			rsvpImpl.setUuid(StringPool.BLANK);
		}
		else {
			rsvpImpl.setUuid(uuid);
		}

		rsvpImpl.setRsvpId(rsvpId);
		rsvpImpl.setGroupId(groupId);
		rsvpImpl.setCompanyId(companyId);
		rsvpImpl.setUserId(userId);

		if (userName == null) {
			rsvpImpl.setUserName(StringPool.BLANK);
		}
		else {
			rsvpImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rsvpImpl.setCreateDate(null);
		}
		else {
			rsvpImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rsvpImpl.setModifiedDate(null);
		}
		else {
			rsvpImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (title == null) {
			rsvpImpl.setTitle(StringPool.BLANK);
		}
		else {
			rsvpImpl.setTitle(title);
		}

		if (description == null) {
			rsvpImpl.setDescription(StringPool.BLANK);
		}
		else {
			rsvpImpl.setDescription(description);
		}

		rsvpImpl.setEventId(eventId);
		rsvpImpl.setSpAssetTypeId(spAssetTypeId);
		rsvpImpl.setStatus(status);

		if (rsvpUrl == null) {
			rsvpImpl.setRsvpUrl(StringPool.BLANK);
		}
		else {
			rsvpImpl.setRsvpUrl(rsvpUrl);
		}

		rsvpImpl.setProcessing(processing);

		if (price == null) {
			rsvpImpl.setPrice(StringPool.BLANK);
		}
		else {
			rsvpImpl.setPrice(price);
		}

		if (currency == null) {
			rsvpImpl.setCurrency(StringPool.BLANK);
		}
		else {
			rsvpImpl.setCurrency(currency);
		}

		if (tax == null) {
			rsvpImpl.setTax(StringPool.BLANK);
		}
		else {
			rsvpImpl.setTax(tax);
		}

		if (accountId == null) {
			rsvpImpl.setAccountId(StringPool.BLANK);
		}
		else {
			rsvpImpl.setAccountId(accountId);
		}

		rsvpImpl.setPaymentFlag(paymentFlag);
		rsvpImpl.setRegisterFlag(registerFlag);
		rsvpImpl.setTicketFlag(ticketFlag);

		if (dynamicSectionName == null) {
			rsvpImpl.setDynamicSectionName(StringPool.BLANK);
		}
		else {
			rsvpImpl.setDynamicSectionName(dynamicSectionName);
		}

		rsvpImpl.setCcEmail(ccEmail);

		rsvpImpl.resetOriginalValues();

		return rsvpImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		rsvpId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		title = objectInput.readUTF();
		description = objectInput.readUTF();
		eventId = objectInput.readLong();
		spAssetTypeId = objectInput.readLong();
		status = objectInput.readBoolean();
		rsvpUrl = objectInput.readUTF();
		processing = objectInput.readInt();
		price = objectInput.readUTF();
		currency = objectInput.readUTF();
		tax = objectInput.readUTF();
		accountId = objectInput.readUTF();
		paymentFlag = objectInput.readBoolean();
		registerFlag = objectInput.readBoolean();
		ticketFlag = objectInput.readBoolean();
		dynamicSectionName = objectInput.readUTF();
		ccEmail = objectInput.readBoolean();
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

		objectOutput.writeLong(rsvpId);
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

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(eventId);
		objectOutput.writeLong(spAssetTypeId);
		objectOutput.writeBoolean(status);

		if (rsvpUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rsvpUrl);
		}

		objectOutput.writeInt(processing);

		if (price == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(price);
		}

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		if (tax == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(tax);
		}

		if (accountId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accountId);
		}

		objectOutput.writeBoolean(paymentFlag);
		objectOutput.writeBoolean(registerFlag);
		objectOutput.writeBoolean(ticketFlag);

		if (dynamicSectionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dynamicSectionName);
		}

		objectOutput.writeBoolean(ccEmail);
	}

	public String uuid;
	public long rsvpId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String title;
	public String description;
	public long eventId;
	public long spAssetTypeId;
	public boolean status;
	public String rsvpUrl;
	public int processing;
	public String price;
	public String currency;
	public String tax;
	public String accountId;
	public boolean paymentFlag;
	public boolean registerFlag;
	public boolean ticketFlag;
	public String dynamicSectionName;
	public boolean ccEmail;
}