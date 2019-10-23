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

import com.sambaash.platform.srv.startupprofile.model.SPATOContacts;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPATOContacts in entity cache.
 *
 * @author pradeep
 * @see SPATOContacts
 * @generated
 */
public class SPATOContactsCacheModel implements CacheModel<SPATOContacts>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spATOContactId=");
		sb.append(spATOContactId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", primaryPrincipalUserId=");
		sb.append(primaryPrincipalUserId);
		sb.append(", secondaryPrincipalUserId=");
		sb.append(secondaryPrincipalUserId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPATOContacts toEntityModel() {
		SPATOContactsImpl spatoContactsImpl = new SPATOContactsImpl();

		spatoContactsImpl.setSpATOContactId(spATOContactId);
		spatoContactsImpl.setGroupId(groupId);
		spatoContactsImpl.setOrganizationId(organizationId);
		spatoContactsImpl.setUserId(userId);

		if (firstName == null) {
			spatoContactsImpl.setFirstName(StringPool.BLANK);
		}
		else {
			spatoContactsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			spatoContactsImpl.setLastName(StringPool.BLANK);
		}
		else {
			spatoContactsImpl.setLastName(lastName);
		}

		if (createDate == Long.MIN_VALUE) {
			spatoContactsImpl.setCreateDate(null);
		}
		else {
			spatoContactsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spatoContactsImpl.setModifiedDate(null);
		}
		else {
			spatoContactsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (primaryPrincipalUserId == null) {
			spatoContactsImpl.setPrimaryPrincipalUserId(StringPool.BLANK);
		}
		else {
			spatoContactsImpl.setPrimaryPrincipalUserId(primaryPrincipalUserId);
		}

		if (secondaryPrincipalUserId == null) {
			spatoContactsImpl.setSecondaryPrincipalUserId(StringPool.BLANK);
		}
		else {
			spatoContactsImpl.setSecondaryPrincipalUserId(secondaryPrincipalUserId);
		}

		spatoContactsImpl.resetOriginalValues();

		return spatoContactsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spATOContactId = objectInput.readLong();
		groupId = objectInput.readLong();
		organizationId = objectInput.readLong();
		userId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		primaryPrincipalUserId = objectInput.readUTF();
		secondaryPrincipalUserId = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spATOContactId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(userId);

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

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (primaryPrincipalUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(primaryPrincipalUserId);
		}

		if (secondaryPrincipalUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secondaryPrincipalUserId);
		}
	}

	public long spATOContactId;
	public long groupId;
	public long organizationId;
	public long userId;
	public String firstName;
	public String lastName;
	public long createDate;
	public long modifiedDate;
	public String primaryPrincipalUserId;
	public String secondaryPrincipalUserId;
}