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

package com.sambaash.platform.srv.mail.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.mail.model.SPMailBlackList;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPMailBlackList in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPMailBlackList
 * @generated
 */
public class SPMailBlackListCacheModel implements CacheModel<SPMailBlackList>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spMailBlackListId=");
		sb.append(spMailBlackListId);
		sb.append(", spMailCampaignId=");
		sb.append(spMailCampaignId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", bounced=");
		sb.append(bounced);
		sb.append(", bounce_soft=");
		sb.append(bounce_soft);
		sb.append(", complain=");
		sb.append(complain);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", message=");
		sb.append(message);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPMailBlackList toEntityModel() {
		SPMailBlackListImpl spMailBlackListImpl = new SPMailBlackListImpl();

		spMailBlackListImpl.setSpMailBlackListId(spMailBlackListId);
		spMailBlackListImpl.setSpMailCampaignId(spMailCampaignId);
		spMailBlackListImpl.setUserId(userId);

		if (emailAddress == null) {
			spMailBlackListImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spMailBlackListImpl.setEmailAddress(emailAddress);
		}

		spMailBlackListImpl.setBounced(bounced);
		spMailBlackListImpl.setBounce_soft(bounce_soft);
		spMailBlackListImpl.setComplain(complain);

		if (createDate == Long.MIN_VALUE) {
			spMailBlackListImpl.setCreateDate(null);
		}
		else {
			spMailBlackListImpl.setCreateDate(new Date(createDate));
		}

		if (message == null) {
			spMailBlackListImpl.setMessage(StringPool.BLANK);
		}
		else {
			spMailBlackListImpl.setMessage(message);
		}

		if (messageId == null) {
			spMailBlackListImpl.setMessageId(StringPool.BLANK);
		}
		else {
			spMailBlackListImpl.setMessageId(messageId);
		}

		spMailBlackListImpl.resetOriginalValues();

		return spMailBlackListImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spMailBlackListId = objectInput.readLong();
		spMailCampaignId = objectInput.readLong();
		userId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		bounced = objectInput.readBoolean();
		bounce_soft = objectInput.readBoolean();
		complain = objectInput.readBoolean();
		createDate = objectInput.readLong();
		message = objectInput.readUTF();
		messageId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spMailBlackListId);
		objectOutput.writeLong(spMailCampaignId);
		objectOutput.writeLong(userId);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeBoolean(bounced);
		objectOutput.writeBoolean(bounce_soft);
		objectOutput.writeBoolean(complain);
		objectOutput.writeLong(createDate);

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (messageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageId);
		}
	}

	public long spMailBlackListId;
	public long spMailCampaignId;
	public long userId;
	public String emailAddress;
	public boolean bounced;
	public boolean bounce_soft;
	public boolean complain;
	public long createDate;
	public String message;
	public String messageId;
}