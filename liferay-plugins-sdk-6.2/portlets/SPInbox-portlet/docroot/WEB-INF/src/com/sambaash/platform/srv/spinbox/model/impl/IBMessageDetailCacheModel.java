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

import com.sambaash.platform.srv.spinbox.model.IBMessageDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing IBMessageDetail in entity cache.
 *
 * @author nareshchebolu
 * @see IBMessageDetail
 * @generated
 */
public class IBMessageDetailCacheModel implements CacheModel<IBMessageDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{ibMsgDetailId=");
		sb.append(ibMsgDetailId);
		sb.append(", receiverId=");
		sb.append(receiverId);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append(", receiverMsgStatus=");
		sb.append(receiverMsgStatus);
		sb.append(", senderMsgStatus=");
		sb.append(senderMsgStatus);
		sb.append(", status=");
		sb.append(status);
		sb.append(", receiveDate=");
		sb.append(receiveDate);
		sb.append(", receiveBy=");
		sb.append(receiveBy);
		sb.append(", archived=");
		sb.append(archived);
		sb.append(", updateDate=");
		sb.append(updateDate);
		sb.append(", updateBy=");
		sb.append(updateBy);
		sb.append(", category=");
		sb.append(category);
		sb.append(", processId=");
		sb.append(processId);
		sb.append(", corpProfileId=");
		sb.append(corpProfileId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public IBMessageDetail toEntityModel() {
		IBMessageDetailImpl ibMessageDetailImpl = new IBMessageDetailImpl();

		ibMessageDetailImpl.setIbMsgDetailId(ibMsgDetailId);
		ibMessageDetailImpl.setReceiverId(receiverId);
		ibMessageDetailImpl.setMessageId(messageId);

		if (receiverMsgStatus == null) {
			ibMessageDetailImpl.setReceiverMsgStatus(StringPool.BLANK);
		}
		else {
			ibMessageDetailImpl.setReceiverMsgStatus(receiverMsgStatus);
		}

		if (senderMsgStatus == null) {
			ibMessageDetailImpl.setSenderMsgStatus(StringPool.BLANK);
		}
		else {
			ibMessageDetailImpl.setSenderMsgStatus(senderMsgStatus);
		}

		if (status == null) {
			ibMessageDetailImpl.setStatus(StringPool.BLANK);
		}
		else {
			ibMessageDetailImpl.setStatus(status);
		}

		if (receiveDate == Long.MIN_VALUE) {
			ibMessageDetailImpl.setReceiveDate(null);
		}
		else {
			ibMessageDetailImpl.setReceiveDate(new Date(receiveDate));
		}

		if (receiveBy == null) {
			ibMessageDetailImpl.setReceiveBy(StringPool.BLANK);
		}
		else {
			ibMessageDetailImpl.setReceiveBy(receiveBy);
		}

		ibMessageDetailImpl.setArchived(archived);

		if (updateDate == Long.MIN_VALUE) {
			ibMessageDetailImpl.setUpdateDate(null);
		}
		else {
			ibMessageDetailImpl.setUpdateDate(new Date(updateDate));
		}

		if (updateBy == null) {
			ibMessageDetailImpl.setUpdateBy(StringPool.BLANK);
		}
		else {
			ibMessageDetailImpl.setUpdateBy(updateBy);
		}

		if (category == null) {
			ibMessageDetailImpl.setCategory(StringPool.BLANK);
		}
		else {
			ibMessageDetailImpl.setCategory(category);
		}

		ibMessageDetailImpl.setProcessId(processId);
		ibMessageDetailImpl.setCorpProfileId(corpProfileId);

		ibMessageDetailImpl.resetOriginalValues();

		return ibMessageDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ibMsgDetailId = objectInput.readLong();
		receiverId = objectInput.readLong();
		messageId = objectInput.readLong();
		receiverMsgStatus = objectInput.readUTF();
		senderMsgStatus = objectInput.readUTF();
		status = objectInput.readUTF();
		receiveDate = objectInput.readLong();
		receiveBy = objectInput.readUTF();
		archived = objectInput.readBoolean();
		updateDate = objectInput.readLong();
		updateBy = objectInput.readUTF();
		category = objectInput.readUTF();
		processId = objectInput.readLong();
		corpProfileId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ibMsgDetailId);
		objectOutput.writeLong(receiverId);
		objectOutput.writeLong(messageId);

		if (receiverMsgStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receiverMsgStatus);
		}

		if (senderMsgStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(senderMsgStatus);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(receiveDate);

		if (receiveBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(receiveBy);
		}

		objectOutput.writeBoolean(archived);
		objectOutput.writeLong(updateDate);

		if (updateBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updateBy);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		objectOutput.writeLong(processId);
		objectOutput.writeLong(corpProfileId);
	}

	public long ibMsgDetailId;
	public long receiverId;
	public long messageId;
	public String receiverMsgStatus;
	public String senderMsgStatus;
	public String status;
	public long receiveDate;
	public String receiveBy;
	public boolean archived;
	public long updateDate;
	public String updateBy;
	public String category;
	public long processId;
	public long corpProfileId;
}