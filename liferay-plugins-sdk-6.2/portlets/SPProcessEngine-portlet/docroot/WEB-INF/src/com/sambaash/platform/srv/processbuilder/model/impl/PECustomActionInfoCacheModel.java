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

import com.sambaash.platform.srv.processbuilder.model.PECustomActionInfo;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PECustomActionInfo in entity cache.
 *
 * @author nareshchebolu
 * @see PECustomActionInfo
 * @generated
 */
public class PECustomActionInfoCacheModel implements CacheModel<PECustomActionInfo>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spPEActionId=");
		sb.append(spPEActionId);
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
		sb.append(", actionClassName=");
		sb.append(actionClassName);
		sb.append(", title=");
		sb.append(title);
		sb.append(", defaultConfiguration=");
		sb.append(defaultConfiguration);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PECustomActionInfo toEntityModel() {
		PECustomActionInfoImpl peCustomActionInfoImpl = new PECustomActionInfoImpl();

		if (uuid == null) {
			peCustomActionInfoImpl.setUuid(StringPool.BLANK);
		}
		else {
			peCustomActionInfoImpl.setUuid(uuid);
		}

		peCustomActionInfoImpl.setSpPEActionId(spPEActionId);
		peCustomActionInfoImpl.setGroupId(groupId);
		peCustomActionInfoImpl.setCompanyId(companyId);
		peCustomActionInfoImpl.setUserId(userId);

		if (userName == null) {
			peCustomActionInfoImpl.setUserName(StringPool.BLANK);
		}
		else {
			peCustomActionInfoImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peCustomActionInfoImpl.setCreateDate(null);
		}
		else {
			peCustomActionInfoImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peCustomActionInfoImpl.setModifiedDate(null);
		}
		else {
			peCustomActionInfoImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (actionClassName == null) {
			peCustomActionInfoImpl.setActionClassName(StringPool.BLANK);
		}
		else {
			peCustomActionInfoImpl.setActionClassName(actionClassName);
		}

		if (title == null) {
			peCustomActionInfoImpl.setTitle(StringPool.BLANK);
		}
		else {
			peCustomActionInfoImpl.setTitle(title);
		}

		if (defaultConfiguration == null) {
			peCustomActionInfoImpl.setDefaultConfiguration(StringPool.BLANK);
		}
		else {
			peCustomActionInfoImpl.setDefaultConfiguration(defaultConfiguration);
		}

		peCustomActionInfoImpl.resetOriginalValues();

		return peCustomActionInfoImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spPEActionId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		actionClassName = objectInput.readUTF();
		title = objectInput.readUTF();
		defaultConfiguration = objectInput.readUTF();
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

		objectOutput.writeLong(spPEActionId);
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

		if (actionClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(actionClassName);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (defaultConfiguration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(defaultConfiguration);
		}
	}

	public String uuid;
	public long spPEActionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String actionClassName;
	public String title;
	public String defaultConfiguration;
}