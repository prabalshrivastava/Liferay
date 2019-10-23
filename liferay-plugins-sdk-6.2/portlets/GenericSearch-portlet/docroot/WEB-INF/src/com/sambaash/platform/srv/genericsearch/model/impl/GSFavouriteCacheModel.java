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

package com.sambaash.platform.srv.genericsearch.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.genericsearch.model.GSFavourite;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GSFavourite in entity cache.
 *
 * @author nareshchebolu
 * @see GSFavourite
 * @generated
 */
public class GSFavouriteCacheModel implements CacheModel<GSFavourite>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{SPGSFavouriteId=");
		sb.append(SPGSFavouriteId);
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
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", layoutId=");
		sb.append(layoutId);
		sb.append(", portletInstanceId=");
		sb.append(portletInstanceId);
		sb.append(", config=");
		sb.append(config);
		sb.append(", permissionType=");
		sb.append(permissionType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GSFavourite toEntityModel() {
		GSFavouriteImpl gsFavouriteImpl = new GSFavouriteImpl();

		gsFavouriteImpl.setSPGSFavouriteId(SPGSFavouriteId);
		gsFavouriteImpl.setGroupId(groupId);
		gsFavouriteImpl.setCompanyId(companyId);
		gsFavouriteImpl.setUserId(userId);

		if (userName == null) {
			gsFavouriteImpl.setUserName(StringPool.BLANK);
		}
		else {
			gsFavouriteImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			gsFavouriteImpl.setCreateDate(null);
		}
		else {
			gsFavouriteImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			gsFavouriteImpl.setModifiedDate(null);
		}
		else {
			gsFavouriteImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			gsFavouriteImpl.setName(StringPool.BLANK);
		}
		else {
			gsFavouriteImpl.setName(name);
		}

		gsFavouriteImpl.setCreatedBy(createdBy);
		gsFavouriteImpl.setLayoutId(layoutId);

		if (portletInstanceId == null) {
			gsFavouriteImpl.setPortletInstanceId(StringPool.BLANK);
		}
		else {
			gsFavouriteImpl.setPortletInstanceId(portletInstanceId);
		}

		if (config == null) {
			gsFavouriteImpl.setConfig(StringPool.BLANK);
		}
		else {
			gsFavouriteImpl.setConfig(config);
		}

		gsFavouriteImpl.setPermissionType(permissionType);

		gsFavouriteImpl.resetOriginalValues();

		return gsFavouriteImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		SPGSFavouriteId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		createdBy = objectInput.readLong();
		layoutId = objectInput.readLong();
		portletInstanceId = objectInput.readUTF();
		config = objectInput.readUTF();
		permissionType = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(SPGSFavouriteId);
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

		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(layoutId);

		if (portletInstanceId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletInstanceId);
		}

		if (config == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(config);
		}

		objectOutput.writeInt(permissionType);
	}

	public long SPGSFavouriteId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long createdBy;
	public long layoutId;
	public String portletInstanceId;
	public String config;
	public int permissionType;
}