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

package com.sambaash.platform.srv.spvoting.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spvoting.model.SPVoting;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPVoting in entity cache.
 *
 * @author harini
 * @see SPVoting
 * @generated
 */
public class SPVotingCacheModel implements CacheModel<SPVoting>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spVotingId=");
		sb.append(spVotingId);
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
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", ip=");
		sb.append(ip);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPVoting toEntityModel() {
		SPVotingImpl spVotingImpl = new SPVotingImpl();

		if (uuid == null) {
			spVotingImpl.setUuid(StringPool.BLANK);
		}
		else {
			spVotingImpl.setUuid(uuid);
		}

		spVotingImpl.setSpVotingId(spVotingId);
		spVotingImpl.setGroupId(groupId);
		spVotingImpl.setCompanyId(companyId);
		spVotingImpl.setUserId(userId);

		if (userName == null) {
			spVotingImpl.setUserName(StringPool.BLANK);
		}
		else {
			spVotingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spVotingImpl.setCreateDate(null);
		}
		else {
			spVotingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spVotingImpl.setModifiedDate(null);
		}
		else {
			spVotingImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (className == null) {
			spVotingImpl.setClassName(StringPool.BLANK);
		}
		else {
			spVotingImpl.setClassName(className);
		}

		spVotingImpl.setClassPK(classPK);

		if (ip == null) {
			spVotingImpl.setIp(StringPool.BLANK);
		}
		else {
			spVotingImpl.setIp(ip);
		}

		spVotingImpl.resetOriginalValues();

		return spVotingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spVotingId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
		ip = objectInput.readUTF();
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

		objectOutput.writeLong(spVotingId);
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

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);

		if (ip == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ip);
		}
	}

	public String uuid;
	public long spVotingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String className;
	public long classPK;
	public String ip;
}