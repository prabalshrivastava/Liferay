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

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialProfileFriends in entity cache.
 *
 * @author gauravvijayvergia
 * @see SocialProfileFriends
 * @generated
 */
public class SocialProfileFriendsCacheModel implements CacheModel<SocialProfileFriends>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{socialProfileFriendsId=");
		sb.append(socialProfileFriendsId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", belongsToUserId=");
		sb.append(belongsToUserId);
		sb.append(", socialNetworkProfileId=");
		sb.append(socialNetworkProfileId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", birthday=");
		sb.append(birthday);
		sb.append(", location=");
		sb.append(location);
		sb.append(", pictureUrl=");
		sb.append(pictureUrl);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", socialNetworkType=");
		sb.append(socialNetworkType);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialProfileFriends toEntityModel() {
		SocialProfileFriendsImpl socialProfileFriendsImpl = new SocialProfileFriendsImpl();

		socialProfileFriendsImpl.setSocialProfileFriendsId(socialProfileFriendsId);
		socialProfileFriendsImpl.setCompanyId(companyId);
		socialProfileFriendsImpl.setBelongsToUserId(belongsToUserId);
		socialProfileFriendsImpl.setSocialNetworkProfileId(socialNetworkProfileId);

		if (firstName == null) {
			socialProfileFriendsImpl.setFirstName(StringPool.BLANK);
		}
		else {
			socialProfileFriendsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			socialProfileFriendsImpl.setLastName(StringPool.BLANK);
		}
		else {
			socialProfileFriendsImpl.setLastName(lastName);
		}

		if (birthday == null) {
			socialProfileFriendsImpl.setBirthday(StringPool.BLANK);
		}
		else {
			socialProfileFriendsImpl.setBirthday(birthday);
		}

		if (location == null) {
			socialProfileFriendsImpl.setLocation(StringPool.BLANK);
		}
		else {
			socialProfileFriendsImpl.setLocation(location);
		}

		if (pictureUrl == null) {
			socialProfileFriendsImpl.setPictureUrl(StringPool.BLANK);
		}
		else {
			socialProfileFriendsImpl.setPictureUrl(pictureUrl);
		}

		if (userName == null) {
			socialProfileFriendsImpl.setUserName(StringPool.BLANK);
		}
		else {
			socialProfileFriendsImpl.setUserName(userName);
		}

		socialProfileFriendsImpl.setGender(gender);
		socialProfileFriendsImpl.setSocialNetworkType(socialNetworkType);

		if (createDate == Long.MIN_VALUE) {
			socialProfileFriendsImpl.setCreateDate(null);
		}
		else {
			socialProfileFriendsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			socialProfileFriendsImpl.setModifiedDate(null);
		}
		else {
			socialProfileFriendsImpl.setModifiedDate(new Date(modifiedDate));
		}

		socialProfileFriendsImpl.resetOriginalValues();

		return socialProfileFriendsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		socialProfileFriendsId = objectInput.readLong();
		companyId = objectInput.readLong();
		belongsToUserId = objectInput.readLong();
		socialNetworkProfileId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		birthday = objectInput.readUTF();
		location = objectInput.readUTF();
		pictureUrl = objectInput.readUTF();
		userName = objectInput.readUTF();
		gender = objectInput.readInt();
		socialNetworkType = objectInput.readInt();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(socialProfileFriendsId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(belongsToUserId);
		objectOutput.writeLong(socialNetworkProfileId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (birthday == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(birthday);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		if (pictureUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pictureUrl);
		}

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeInt(gender);
		objectOutput.writeInt(socialNetworkType);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
	}

	public long socialProfileFriendsId;
	public long companyId;
	public long belongsToUserId;
	public long socialNetworkProfileId;
	public String firstName;
	public String lastName;
	public String birthday;
	public String location;
	public String pictureUrl;
	public String userName;
	public int gender;
	public int socialNetworkType;
	public long createDate;
	public long modifiedDate;
}