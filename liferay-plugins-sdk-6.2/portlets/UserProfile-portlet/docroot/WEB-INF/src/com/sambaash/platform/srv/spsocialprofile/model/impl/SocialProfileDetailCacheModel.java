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

package com.sambaash.platform.srv.spsocialprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialProfileDetail in entity cache.
 *
 * @author gauravvijayvergia
 * @see SocialProfileDetail
 * @generated
 */
public class SocialProfileDetailCacheModel implements CacheModel<SocialProfileDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", socialProfileDetailId=");
		sb.append(socialProfileDetailId);
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
		sb.append(", userJobId=");
		sb.append(userJobId);
		sb.append(", companyName=");
		sb.append(companyName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialProfileDetail toEntityModel() {
		SocialProfileDetailImpl socialProfileDetailImpl = new SocialProfileDetailImpl();

		if (uuid == null) {
			socialProfileDetailImpl.setUuid(StringPool.BLANK);
		}
		else {
			socialProfileDetailImpl.setUuid(uuid);
		}

		socialProfileDetailImpl.setSocialProfileDetailId(socialProfileDetailId);
		socialProfileDetailImpl.setGroupId(groupId);
		socialProfileDetailImpl.setCompanyId(companyId);
		socialProfileDetailImpl.setUserId(userId);

		if (userName == null) {
			socialProfileDetailImpl.setUserName(StringPool.BLANK);
		}
		else {
			socialProfileDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			socialProfileDetailImpl.setCreateDate(null);
		}
		else {
			socialProfileDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			socialProfileDetailImpl.setModifiedDate(null);
		}
		else {
			socialProfileDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (userJobId == null) {
			socialProfileDetailImpl.setUserJobId(StringPool.BLANK);
		}
		else {
			socialProfileDetailImpl.setUserJobId(userJobId);
		}

		if (companyName == null) {
			socialProfileDetailImpl.setCompanyName(StringPool.BLANK);
		}
		else {
			socialProfileDetailImpl.setCompanyName(companyName);
		}

		socialProfileDetailImpl.resetOriginalValues();

		return socialProfileDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		socialProfileDetailId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userJobId = objectInput.readUTF();
		companyName = objectInput.readUTF();
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

		objectOutput.writeLong(socialProfileDetailId);
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

		if (userJobId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userJobId);
		}

		if (companyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyName);
		}
	}

	public String uuid;
	public long socialProfileDetailId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String userJobId;
	public String companyName;
}