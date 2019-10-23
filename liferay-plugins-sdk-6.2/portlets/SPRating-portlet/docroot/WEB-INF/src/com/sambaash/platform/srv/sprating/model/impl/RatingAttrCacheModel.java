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

package com.sambaash.platform.srv.sprating.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.sprating.model.RatingAttr;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RatingAttr in entity cache.
 *
 * @author harini
 * @see RatingAttr
 * @generated
 */
public class RatingAttrCacheModel implements CacheModel<RatingAttr>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spRatingAttrId=");
		sb.append(spRatingAttrId);
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
		sb.append(", ratingComponentId=");
		sb.append(ratingComponentId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", weight=");
		sb.append(weight);
		sb.append(", visible=");
		sb.append(visible);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RatingAttr toEntityModel() {
		RatingAttrImpl ratingAttrImpl = new RatingAttrImpl();

		if (uuid == null) {
			ratingAttrImpl.setUuid(StringPool.BLANK);
		}
		else {
			ratingAttrImpl.setUuid(uuid);
		}

		ratingAttrImpl.setSpRatingAttrId(spRatingAttrId);
		ratingAttrImpl.setGroupId(groupId);
		ratingAttrImpl.setCompanyId(companyId);
		ratingAttrImpl.setUserId(userId);

		if (userName == null) {
			ratingAttrImpl.setUserName(StringPool.BLANK);
		}
		else {
			ratingAttrImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ratingAttrImpl.setCreateDate(null);
		}
		else {
			ratingAttrImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ratingAttrImpl.setModifiedDate(null);
		}
		else {
			ratingAttrImpl.setModifiedDate(new Date(modifiedDate));
		}

		ratingAttrImpl.setRatingComponentId(ratingComponentId);

		if (name == null) {
			ratingAttrImpl.setName(StringPool.BLANK);
		}
		else {
			ratingAttrImpl.setName(name);
		}

		ratingAttrImpl.setWeight(weight);
		ratingAttrImpl.setVisible(visible);

		ratingAttrImpl.resetOriginalValues();

		return ratingAttrImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spRatingAttrId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		ratingComponentId = objectInput.readLong();
		name = objectInput.readUTF();
		weight = objectInput.readDouble();
		visible = objectInput.readBoolean();
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

		objectOutput.writeLong(spRatingAttrId);
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
		objectOutput.writeLong(ratingComponentId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		objectOutput.writeDouble(weight);
		objectOutput.writeBoolean(visible);
	}

	public String uuid;
	public long spRatingAttrId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long ratingComponentId;
	public String name;
	public double weight;
	public boolean visible;
}