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

package com.sambaash.platform.srv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.model.Conversation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Conversation in entity cache.
 *
 * @author aishwarya
 * @see Conversation
 * @generated
 */
public class ConversationCacheModel implements CacheModel<Conversation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spConversationId=");
		sb.append(spConversationId);
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
		sb.append(", entityClassId=");
		sb.append(entityClassId);
		sb.append(", entityClassName=");
		sb.append(entityClassName);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", sentByUserId=");
		sb.append(sentByUserId);
		sb.append(", message=");
		sb.append(message);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", associatedWith=");
		sb.append(associatedWith);
		sb.append(", restricted=");
		sb.append(restricted);
		sb.append(", status=");
		sb.append(status);
		sb.append(", parentConverstationId=");
		sb.append(parentConverstationId);
		sb.append(", currentPlId=");
		sb.append(currentPlId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Conversation toEntityModel() {
		ConversationImpl conversationImpl = new ConversationImpl();

		if (uuid == null) {
			conversationImpl.setUuid(StringPool.BLANK);
		}
		else {
			conversationImpl.setUuid(uuid);
		}

		conversationImpl.setSpConversationId(spConversationId);
		conversationImpl.setGroupId(groupId);
		conversationImpl.setCompanyId(companyId);
		conversationImpl.setUserId(userId);

		if (userName == null) {
			conversationImpl.setUserName(StringPool.BLANK);
		}
		else {
			conversationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			conversationImpl.setCreateDate(null);
		}
		else {
			conversationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			conversationImpl.setModifiedDate(null);
		}
		else {
			conversationImpl.setModifiedDate(new Date(modifiedDate));
		}

		conversationImpl.setEntityClassId(entityClassId);

		if (entityClassName == null) {
			conversationImpl.setEntityClassName(StringPool.BLANK);
		}
		else {
			conversationImpl.setEntityClassName(entityClassName);
		}

		conversationImpl.setEntityId(entityId);
		conversationImpl.setSentByUserId(sentByUserId);

		if (message == null) {
			conversationImpl.setMessage(StringPool.BLANK);
		}
		else {
			conversationImpl.setMessage(message);
		}

		if (fileEntryId == null) {
			conversationImpl.setFileEntryId(StringPool.BLANK);
		}
		else {
			conversationImpl.setFileEntryId(fileEntryId);
		}

		conversationImpl.setAssociatedWith(associatedWith);
		conversationImpl.setRestricted(restricted);
		conversationImpl.setStatus(status);
		conversationImpl.setParentConverstationId(parentConverstationId);
		conversationImpl.setCurrentPlId(currentPlId);

		conversationImpl.resetOriginalValues();

		return conversationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spConversationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		entityClassId = objectInput.readLong();
		entityClassName = objectInput.readUTF();
		entityId = objectInput.readLong();
		sentByUserId = objectInput.readLong();
		message = objectInput.readUTF();
		fileEntryId = objectInput.readUTF();
		associatedWith = objectInput.readLong();
		restricted = objectInput.readInt();
		status = objectInput.readInt();
		parentConverstationId = objectInput.readLong();
		currentPlId = objectInput.readLong();
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

		objectOutput.writeLong(spConversationId);
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
		objectOutput.writeLong(entityClassId);

		if (entityClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entityClassName);
		}

		objectOutput.writeLong(entityId);
		objectOutput.writeLong(sentByUserId);

		if (message == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(message);
		}

		if (fileEntryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryId);
		}

		objectOutput.writeLong(associatedWith);
		objectOutput.writeInt(restricted);
		objectOutput.writeInt(status);
		objectOutput.writeLong(parentConverstationId);
		objectOutput.writeLong(currentPlId);
	}

	public String uuid;
	public long spConversationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long entityClassId;
	public String entityClassName;
	public long entityId;
	public long sentByUserId;
	public String message;
	public String fileEntryId;
	public long associatedWith;
	public int restricted;
	public int status;
	public long parentConverstationId;
	public long currentPlId;
}