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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.SPSite;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPSite in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPSite
 * @generated
 */
public class SPSiteCacheModel implements CacheModel<SPSite>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spSiteId=");
		sb.append(spSiteId);
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
		sb.append(", virtualHostId=");
		sb.append(virtualHostId);
		sb.append(", layoutSetId=");
		sb.append(layoutSetId);
		sb.append(", authAccessId=");
		sb.append(authAccessId);
		sb.append(", loginType=");
		sb.append(loginType);
		sb.append(", password=");
		sb.append(password);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPSite toEntityModel() {
		SPSiteImpl spSiteImpl = new SPSiteImpl();

		if (uuid == null) {
			spSiteImpl.setUuid(StringPool.BLANK);
		}
		else {
			spSiteImpl.setUuid(uuid);
		}

		spSiteImpl.setSpSiteId(spSiteId);
		spSiteImpl.setGroupId(groupId);
		spSiteImpl.setCompanyId(companyId);
		spSiteImpl.setUserId(userId);

		if (userName == null) {
			spSiteImpl.setUserName(StringPool.BLANK);
		}
		else {
			spSiteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spSiteImpl.setCreateDate(null);
		}
		else {
			spSiteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spSiteImpl.setModifiedDate(null);
		}
		else {
			spSiteImpl.setModifiedDate(new Date(modifiedDate));
		}

		spSiteImpl.setVirtualHostId(virtualHostId);
		spSiteImpl.setLayoutSetId(layoutSetId);
		spSiteImpl.setAuthAccessId(authAccessId);
		spSiteImpl.setLoginType(loginType);

		if (password == null) {
			spSiteImpl.setPassword(StringPool.BLANK);
		}
		else {
			spSiteImpl.setPassword(password);
		}

		spSiteImpl.setActive(active);

		spSiteImpl.resetOriginalValues();

		return spSiteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spSiteId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		virtualHostId = objectInput.readLong();
		layoutSetId = objectInput.readLong();
		authAccessId = objectInput.readLong();
		loginType = objectInput.readLong();
		password = objectInput.readUTF();
		active = objectInput.readBoolean();
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

		objectOutput.writeLong(spSiteId);
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
		objectOutput.writeLong(virtualHostId);
		objectOutput.writeLong(layoutSetId);
		objectOutput.writeLong(authAccessId);
		objectOutput.writeLong(loginType);

		if (password == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(password);
		}

		objectOutput.writeBoolean(active);
	}

	public String uuid;
	public long spSiteId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long virtualHostId;
	public long layoutSetId;
	public long authAccessId;
	public long loginType;
	public String password;
	public boolean active;
}