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

package com.sambaash.platform.srv.spinbox.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spinbox.model.IBMessage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing IBMessage in entity cache.
 *
 * @author nareshchebolu
 * @see IBMessage
 * @generated
 */
public class IBMessageCacheModel implements CacheModel<IBMessage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append(", parentMessageId=");
		sb.append(parentMessageId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", subject=");
		sb.append(subject);
		sb.append(", content=");
		sb.append(content);
		sb.append(", from=");
		sb.append(from);
		sb.append(", to=");
		sb.append(to);
		sb.append(", allowOpen=");
		sb.append(allowOpen);
		sb.append(", sendDate=");
		sb.append(sendDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", createBy=");
		sb.append(createBy);
		sb.append(", createByUserId=");
		sb.append(createByUserId);
		sb.append(", draft=");
		sb.append(draft);
		sb.append(", deleteStatus=");
		sb.append(deleteStatus);
		sb.append(", draftStatus=");
		sb.append(draftStatus);
		sb.append(", sentMeCopy=");
		sb.append(sentMeCopy);
		sb.append(", belongToGroupDetailId=");
		sb.append(belongToGroupDetailId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IBMessage toEntityModel() {
		IBMessageImpl ibMessageImpl = new IBMessageImpl();

		if (uuid == null) {
			ibMessageImpl.setUuid(StringPool.BLANK);
		}
		else {
			ibMessageImpl.setUuid(uuid);
		}

		ibMessageImpl.setMessageId(messageId);
		ibMessageImpl.setParentMessageId(parentMessageId);
		ibMessageImpl.setGroupId(groupId);
		ibMessageImpl.setCompanyId(companyId);

		if (subject == null) {
			ibMessageImpl.setSubject(StringPool.BLANK);
		}
		else {
			ibMessageImpl.setSubject(subject);
		}

		if (content == null) {
			ibMessageImpl.setContent(StringPool.BLANK);
		}
		else {
			ibMessageImpl.setContent(content);
		}

		if (from == null) {
			ibMessageImpl.setFrom(StringPool.BLANK);
		}
		else {
			ibMessageImpl.setFrom(from);
		}

		if (to == null) {
			ibMessageImpl.setTo(StringPool.BLANK);
		}
		else {
			ibMessageImpl.setTo(to);
		}

		ibMessageImpl.setAllowOpen(allowOpen);

		if (sendDate == Long.MIN_VALUE) {
			ibMessageImpl.setSendDate(null);
		}
		else {
			ibMessageImpl.setSendDate(new Date(sendDate));
		}

		if (createDate == Long.MIN_VALUE) {
			ibMessageImpl.setCreateDate(null);
		}
		else {
			ibMessageImpl.setCreateDate(new Date(createDate));
		}

		if (createBy == null) {
			ibMessageImpl.setCreateBy(StringPool.BLANK);
		}
		else {
			ibMessageImpl.setCreateBy(createBy);
		}

		if (createByUserId == null) {
			ibMessageImpl.setCreateByUserId(StringPool.BLANK);
		}
		else {
			ibMessageImpl.setCreateByUserId(createByUserId);
		}

		ibMessageImpl.setDraft(draft);
		ibMessageImpl.setDeleteStatus(deleteStatus);

		if (draftStatus == null) {
			ibMessageImpl.setDraftStatus(StringPool.BLANK);
		}
		else {
			ibMessageImpl.setDraftStatus(draftStatus);
		}

		ibMessageImpl.setSentMeCopy(sentMeCopy);
		ibMessageImpl.setBelongToGroupDetailId(belongToGroupDetailId);

		ibMessageImpl.resetOriginalValues();

		return ibMessageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		messageId = objectInput.readLong();
		parentMessageId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		subject = objectInput.readUTF();
		content = objectInput.readUTF();
		from = objectInput.readUTF();
		to = objectInput.readUTF();
		allowOpen = objectInput.readBoolean();
		sendDate = objectInput.readLong();
		createDate = objectInput.readLong();
		createBy = objectInput.readUTF();
		createByUserId = objectInput.readUTF();
		draft = objectInput.readBoolean();
		deleteStatus = objectInput.readBoolean();
		draftStatus = objectInput.readUTF();
		sentMeCopy = objectInput.readBoolean();
		belongToGroupDetailId = objectInput.readLong();
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

		objectOutput.writeLong(messageId);
		objectOutput.writeLong(parentMessageId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (subject == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(subject);
		}

		if (content == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(content);
		}

		if (from == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(from);
		}

		if (to == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(to);
		}

		objectOutput.writeBoolean(allowOpen);
		objectOutput.writeLong(sendDate);
		objectOutput.writeLong(createDate);

		if (createBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createBy);
		}

		if (createByUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createByUserId);
		}

		objectOutput.writeBoolean(draft);
		objectOutput.writeBoolean(deleteStatus);

		if (draftStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(draftStatus);
		}

		objectOutput.writeBoolean(sentMeCopy);
		objectOutput.writeLong(belongToGroupDetailId);
	}

	public String uuid;
	public long messageId;
	public long parentMessageId;
	public long groupId;
	public long companyId;
	public String subject;
	public String content;
	public String from;
	public String to;
	public boolean allowOpen;
	public long sendDate;
	public long createDate;
	public String createBy;
	public String createByUserId;
	public boolean draft;
	public boolean deleteStatus;
	public String draftStatus;
	public boolean sentMeCopy;
	public long belongToGroupDetailId;
}