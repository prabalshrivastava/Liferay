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
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.model.ConversationUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing ConversationUser in entity cache.
 *
 * @author aishwarya
 * @see ConversationUser
 * @generated
 */
public class ConversationUserCacheModel implements CacheModel<ConversationUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{spConversationUserId=");
		sb.append(spConversationUserId);
		sb.append(", spConversationId=");
		sb.append(spConversationId);
		sb.append(", sentToUserId=");
		sb.append(sentToUserId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", entityClassId=");
		sb.append(entityClassId);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ConversationUser toEntityModel() {
		ConversationUserImpl conversationUserImpl = new ConversationUserImpl();

		conversationUserImpl.setSpConversationUserId(spConversationUserId);
		conversationUserImpl.setSpConversationId(spConversationId);
		conversationUserImpl.setSentToUserId(sentToUserId);
		conversationUserImpl.setStatus(status);
		conversationUserImpl.setEntityClassId(entityClassId);
		conversationUserImpl.setEntityId(entityId);

		conversationUserImpl.resetOriginalValues();

		return conversationUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spConversationUserId = objectInput.readLong();
		spConversationId = objectInput.readLong();
		sentToUserId = objectInput.readLong();
		status = objectInput.readLong();
		entityClassId = objectInput.readLong();
		entityId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spConversationUserId);
		objectOutput.writeLong(spConversationId);
		objectOutput.writeLong(sentToUserId);
		objectOutput.writeLong(status);
		objectOutput.writeLong(entityClassId);
		objectOutput.writeLong(entityId);
	}

	public long spConversationUserId;
	public long spConversationId;
	public long sentToUserId;
	public long status;
	public long entityClassId;
	public long entityId;
}