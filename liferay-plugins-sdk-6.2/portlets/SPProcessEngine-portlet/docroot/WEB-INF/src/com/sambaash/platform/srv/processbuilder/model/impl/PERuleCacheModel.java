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

package com.sambaash.platform.srv.processbuilder.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.processbuilder.model.PERule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PERule in entity cache.
 *
 * @author nareshchebolu
 * @see PERule
 * @generated
 */
public class PERuleCacheModel implements CacheModel<PERule>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spPERuleId=");
		sb.append(spPERuleId);
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
		sb.append(", spPERuleSetId=");
		sb.append(spPERuleSetId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", definition=");
		sb.append(definition);
		sb.append(", sequenceNO=");
		sb.append(sequenceNO);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PERule toEntityModel() {
		PERuleImpl peRuleImpl = new PERuleImpl();

		if (uuid == null) {
			peRuleImpl.setUuid(StringPool.BLANK);
		}
		else {
			peRuleImpl.setUuid(uuid);
		}

		peRuleImpl.setSpPERuleId(spPERuleId);
		peRuleImpl.setGroupId(groupId);
		peRuleImpl.setCompanyId(companyId);
		peRuleImpl.setUserId(userId);

		if (userName == null) {
			peRuleImpl.setUserName(StringPool.BLANK);
		}
		else {
			peRuleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peRuleImpl.setCreateDate(null);
		}
		else {
			peRuleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peRuleImpl.setModifiedDate(null);
		}
		else {
			peRuleImpl.setModifiedDate(new Date(modifiedDate));
		}

		peRuleImpl.setSpPERuleSetId(spPERuleSetId);

		if (name == null) {
			peRuleImpl.setName(StringPool.BLANK);
		}
		else {
			peRuleImpl.setName(name);
		}

		if (type == null) {
			peRuleImpl.setType(StringPool.BLANK);
		}
		else {
			peRuleImpl.setType(type);
		}

		if (definition == null) {
			peRuleImpl.setDefinition(StringPool.BLANK);
		}
		else {
			peRuleImpl.setDefinition(definition);
		}

		peRuleImpl.setSequenceNO(sequenceNO);

		peRuleImpl.resetOriginalValues();

		return peRuleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spPERuleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spPERuleSetId = objectInput.readLong();
		name = objectInput.readUTF();
		type = objectInput.readUTF();
		definition = objectInput.readUTF();
		sequenceNO = objectInput.readLong();
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

		objectOutput.writeLong(spPERuleId);
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
		objectOutput.writeLong(spPERuleSetId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (definition == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(definition);
		}

		objectOutput.writeLong(sequenceNO);
	}

	public String uuid;
	public long spPERuleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spPERuleSetId;
	public String name;
	public String type;
	public String definition;
	public long sequenceNO;
}