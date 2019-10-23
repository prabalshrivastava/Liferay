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

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialProfileLike in entity cache.
 *
 * @author gauravvijayvergia
 * @see SocialProfileLike
 * @generated
 */
public class SocialProfileLikeCacheModel implements CacheModel<SocialProfileLike>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{socialProfileLikeId=");
		sb.append(socialProfileLikeId);
		sb.append(", socialNetworkProfileId=");
		sb.append(socialNetworkProfileId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", category=");
		sb.append(category);
		sb.append(", socialNetworkLikeId=");
		sb.append(socialNetworkLikeId);
		sb.append(", socialNetworkType=");
		sb.append(socialNetworkType);
		sb.append(", socialNetworkCreateDate=");
		sb.append(socialNetworkCreateDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialProfileLike toEntityModel() {
		SocialProfileLikeImpl socialProfileLikeImpl = new SocialProfileLikeImpl();

		socialProfileLikeImpl.setSocialProfileLikeId(socialProfileLikeId);
		socialProfileLikeImpl.setSocialNetworkProfileId(socialNetworkProfileId);

		if (name == null) {
			socialProfileLikeImpl.setName(StringPool.BLANK);
		}
		else {
			socialProfileLikeImpl.setName(name);
		}

		if (category == null) {
			socialProfileLikeImpl.setCategory(StringPool.BLANK);
		}
		else {
			socialProfileLikeImpl.setCategory(category);
		}

		socialProfileLikeImpl.setSocialNetworkLikeId(socialNetworkLikeId);
		socialProfileLikeImpl.setSocialNetworkType(socialNetworkType);

		if (socialNetworkCreateDate == Long.MIN_VALUE) {
			socialProfileLikeImpl.setSocialNetworkCreateDate(null);
		}
		else {
			socialProfileLikeImpl.setSocialNetworkCreateDate(new Date(
					socialNetworkCreateDate));
		}

		if (createDate == Long.MIN_VALUE) {
			socialProfileLikeImpl.setCreateDate(null);
		}
		else {
			socialProfileLikeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			socialProfileLikeImpl.setModifiedDate(null);
		}
		else {
			socialProfileLikeImpl.setModifiedDate(new Date(modifiedDate));
		}

		socialProfileLikeImpl.resetOriginalValues();

		return socialProfileLikeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		socialProfileLikeId = objectInput.readLong();
		socialNetworkProfileId = objectInput.readLong();
		name = objectInput.readUTF();
		category = objectInput.readUTF();
		socialNetworkLikeId = objectInput.readLong();
		socialNetworkType = objectInput.readInt();
		socialNetworkCreateDate = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(socialProfileLikeId);
		objectOutput.writeLong(socialNetworkProfileId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		objectOutput.writeLong(socialNetworkLikeId);
		objectOutput.writeInt(socialNetworkType);
		objectOutput.writeLong(socialNetworkCreateDate);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long socialProfileLikeId;
	public long socialNetworkProfileId;
	public String name;
	public String category;
	public long socialNetworkLikeId;
	public int socialNetworkType;
	public long socialNetworkCreateDate;
	public long createDate;
	public long modifiedDate;
}