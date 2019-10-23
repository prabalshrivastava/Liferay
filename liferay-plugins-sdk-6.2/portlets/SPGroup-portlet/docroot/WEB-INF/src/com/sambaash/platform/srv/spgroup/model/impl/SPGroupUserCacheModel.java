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

package com.sambaash.platform.srv.spgroup.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spgroup.model.SPGroupUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPGroupUser in entity cache.
 *
 * @author harini
 * @see SPGroupUser
 * @generated
 */
public class SPGroupUserCacheModel implements CacheModel<SPGroupUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spGroupId=");
		sb.append(spGroupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", joinDate=");
		sb.append(joinDate);
		sb.append(", role=");
		sb.append(role);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPGroupUser toEntityModel() {
		SPGroupUserImpl spGroupUserImpl = new SPGroupUserImpl();

		spGroupUserImpl.setSpGroupId(spGroupId);
		spGroupUserImpl.setUserId(userId);
		spGroupUserImpl.setGroupId(groupId);
		spGroupUserImpl.setCompanyId(companyId);

		if (userName == null) {
			spGroupUserImpl.setUserName(StringPool.BLANK);
		}
		else {
			spGroupUserImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spGroupUserImpl.setCreateDate(null);
		}
		else {
			spGroupUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spGroupUserImpl.setModifiedDate(null);
		}
		else {
			spGroupUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (joinDate == Long.MIN_VALUE) {
			spGroupUserImpl.setJoinDate(null);
		}
		else {
			spGroupUserImpl.setJoinDate(new Date(joinDate));
		}

		spGroupUserImpl.setRole(role);
		spGroupUserImpl.setStatus(status);

		spGroupUserImpl.resetOriginalValues();

		return spGroupUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spGroupId = objectInput.readLong();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		joinDate = objectInput.readLong();
		role = objectInput.readInt();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spGroupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(joinDate);
		objectOutput.writeInt(role);
		objectOutput.writeInt(status);
	}

	public long spGroupId;
	public long userId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long joinDate;
	public int role;
	public int status;
}