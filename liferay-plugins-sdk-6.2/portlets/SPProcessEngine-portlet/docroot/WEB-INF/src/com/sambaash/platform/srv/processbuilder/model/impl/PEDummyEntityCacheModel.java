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

import com.sambaash.platform.srv.processbuilder.model.PEDummyEntity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PEDummyEntity in entity cache.
 *
 * @author nareshchebolu
 * @see PEDummyEntity
 * @generated
 */
public class PEDummyEntityCacheModel implements CacheModel<PEDummyEntity>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spPEDummyEntityId=");
		sb.append(spPEDummyEntityId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PEDummyEntity toEntityModel() {
		PEDummyEntityImpl peDummyEntityImpl = new PEDummyEntityImpl();

		if (uuid == null) {
			peDummyEntityImpl.setUuid(StringPool.BLANK);
		}
		else {
			peDummyEntityImpl.setUuid(uuid);
		}

		peDummyEntityImpl.setSpPEDummyEntityId(spPEDummyEntityId);
		peDummyEntityImpl.setGroupId(groupId);
		peDummyEntityImpl.setCompanyId(companyId);
		peDummyEntityImpl.setUserId(userId);

		if (userName == null) {
			peDummyEntityImpl.setUserName(StringPool.BLANK);
		}
		else {
			peDummyEntityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peDummyEntityImpl.setCreateDate(null);
		}
		else {
			peDummyEntityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peDummyEntityImpl.setModifiedDate(null);
		}
		else {
			peDummyEntityImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			peDummyEntityImpl.setName(StringPool.BLANK);
		}
		else {
			peDummyEntityImpl.setName(name);
		}

		peDummyEntityImpl.resetOriginalValues();

		return peDummyEntityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spPEDummyEntityId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
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

		objectOutput.writeLong(spPEDummyEntityId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}
	}

	public String uuid;
	public long spPEDummyEntityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
}