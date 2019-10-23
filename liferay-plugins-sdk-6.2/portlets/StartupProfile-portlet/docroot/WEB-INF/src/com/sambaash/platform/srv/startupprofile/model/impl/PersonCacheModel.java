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

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.startupprofile.model.Person;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Person in entity cache.
 *
 * @author pradeep
 * @see Person
 * @generated
 */
public class PersonCacheModel implements CacheModel<Person>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", personId=");
		sb.append(personId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", title=");
		sb.append(title);
		sb.append(", apiPath=");
		sb.append(apiPath);
		sb.append(", emailId=");
		sb.append(emailId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", skype=");
		sb.append(skype);
		sb.append(", memberUserId=");
		sb.append(memberUserId);
		sb.append(", extras=");
		sb.append(extras);
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
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Person toEntityModel() {
		PersonImpl personImpl = new PersonImpl();

		if (uuid == null) {
			personImpl.setUuid(StringPool.BLANK);
		}
		else {
			personImpl.setUuid(uuid);
		}

		personImpl.setPersonId(personId);

		if (name == null) {
			personImpl.setName(StringPool.BLANK);
		}
		else {
			personImpl.setName(name);
		}

		if (title == null) {
			personImpl.setTitle(StringPool.BLANK);
		}
		else {
			personImpl.setTitle(title);
		}

		if (apiPath == null) {
			personImpl.setApiPath(StringPool.BLANK);
		}
		else {
			personImpl.setApiPath(apiPath);
		}

		if (emailId == null) {
			personImpl.setEmailId(StringPool.BLANK);
		}
		else {
			personImpl.setEmailId(emailId);
		}

		if (description == null) {
			personImpl.setDescription(StringPool.BLANK);
		}
		else {
			personImpl.setDescription(description);
		}

		if (imageUrl == null) {
			personImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			personImpl.setImageUrl(imageUrl);
		}

		if (mobile == null) {
			personImpl.setMobile(StringPool.BLANK);
		}
		else {
			personImpl.setMobile(mobile);
		}

		if (skype == null) {
			personImpl.setSkype(StringPool.BLANK);
		}
		else {
			personImpl.setSkype(skype);
		}

		personImpl.setMemberUserId(memberUserId);

		if (extras == null) {
			personImpl.setExtras(StringPool.BLANK);
		}
		else {
			personImpl.setExtras(extras);
		}

		personImpl.setGroupId(groupId);
		personImpl.setCompanyId(companyId);
		personImpl.setUserId(userId);

		if (userName == null) {
			personImpl.setUserName(StringPool.BLANK);
		}
		else {
			personImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personImpl.setCreateDate(null);
		}
		else {
			personImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personImpl.setModifiedDate(null);
		}
		else {
			personImpl.setModifiedDate(new Date(modifiedDate));
		}

		personImpl.setActive(active);

		personImpl.resetOriginalValues();

		return personImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		personId = objectInput.readLong();
		name = objectInput.readUTF();
		title = objectInput.readUTF();
		apiPath = objectInput.readUTF();
		emailId = objectInput.readUTF();
		description = objectInput.readUTF();
		imageUrl = objectInput.readUTF();
		mobile = objectInput.readUTF();
		skype = objectInput.readUTF();
		memberUserId = objectInput.readLong();
		extras = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(personId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (apiPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(apiPath);
		}

		if (emailId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailId);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (imageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		if (mobile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (skype == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(skype);
		}

		objectOutput.writeLong(memberUserId);

		if (extras == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extras);
		}

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
		objectOutput.writeBoolean(active);
	}

	public String uuid;
	public long personId;
	public String name;
	public String title;
	public String apiPath;
	public String emailId;
	public String description;
	public String imageUrl;
	public String mobile;
	public String skype;
	public long memberUserId;
	public String extras;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
}