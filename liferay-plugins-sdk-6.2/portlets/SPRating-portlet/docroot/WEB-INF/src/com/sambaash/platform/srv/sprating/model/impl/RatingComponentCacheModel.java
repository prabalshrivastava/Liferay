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

import com.sambaash.platform.srv.sprating.model.RatingComponent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RatingComponent in entity cache.
 *
 * @author harini
 * @see RatingComponent
 * @generated
 */
public class RatingComponentCacheModel implements CacheModel<RatingComponent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spRatingComponentId=");
		sb.append(spRatingComponentId);
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
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RatingComponent toEntityModel() {
		RatingComponentImpl ratingComponentImpl = new RatingComponentImpl();

		if (uuid == null) {
			ratingComponentImpl.setUuid(StringPool.BLANK);
		}
		else {
			ratingComponentImpl.setUuid(uuid);
		}

		ratingComponentImpl.setSpRatingComponentId(spRatingComponentId);
		ratingComponentImpl.setGroupId(groupId);
		ratingComponentImpl.setCompanyId(companyId);
		ratingComponentImpl.setUserId(userId);

		if (userName == null) {
			ratingComponentImpl.setUserName(StringPool.BLANK);
		}
		else {
			ratingComponentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			ratingComponentImpl.setCreateDate(null);
		}
		else {
			ratingComponentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			ratingComponentImpl.setModifiedDate(null);
		}
		else {
			ratingComponentImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			ratingComponentImpl.setName(StringPool.BLANK);
		}
		else {
			ratingComponentImpl.setName(name);
		}

		ratingComponentImpl.setClassNameId(classNameId);

		ratingComponentImpl.resetOriginalValues();

		return ratingComponentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spRatingComponentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		classNameId = objectInput.readLong();
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

		objectOutput.writeLong(spRatingComponentId);
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

		objectOutput.writeLong(classNameId);
	}

	public String uuid;
	public long spRatingComponentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long classNameId;
}