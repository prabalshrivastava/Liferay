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

package com.sambaash.platform.srv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.model.PersonaAttendee;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PersonaAttendee in entity cache.
 *
 * @author gauravvijayvergia
 * @see PersonaAttendee
 * @generated
 */
public class PersonaAttendeeCacheModel implements CacheModel<PersonaAttendee>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spPersonaAttendeeId=");
		sb.append(spPersonaAttendeeId);
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
		sb.append(", description=");
		sb.append(description);
		sb.append(", imageId=");
		sb.append(imageId);
		sb.append(", spPersonaId=");
		sb.append(spPersonaId);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PersonaAttendee toEntityModel() {
		PersonaAttendeeImpl personaAttendeeImpl = new PersonaAttendeeImpl();

		personaAttendeeImpl.setSpPersonaAttendeeId(spPersonaAttendeeId);
		personaAttendeeImpl.setGroupId(groupId);
		personaAttendeeImpl.setCompanyId(companyId);
		personaAttendeeImpl.setUserId(userId);

		if (userName == null) {
			personaAttendeeImpl.setUserName(StringPool.BLANK);
		}
		else {
			personaAttendeeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personaAttendeeImpl.setCreateDate(null);
		}
		else {
			personaAttendeeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personaAttendeeImpl.setModifiedDate(null);
		}
		else {
			personaAttendeeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (description == null) {
			personaAttendeeImpl.setDescription(StringPool.BLANK);
		}
		else {
			personaAttendeeImpl.setDescription(description);
		}

		personaAttendeeImpl.setImageId(imageId);
		personaAttendeeImpl.setSpPersonaId(spPersonaId);
		personaAttendeeImpl.setSpCourseId(spCourseId);

		personaAttendeeImpl.resetOriginalValues();

		return personaAttendeeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spPersonaAttendeeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		description = objectInput.readUTF();
		imageId = objectInput.readLong();
		spPersonaId = objectInput.readLong();
		spCourseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spPersonaAttendeeId);
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

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(imageId);
		objectOutput.writeLong(spPersonaId);
		objectOutput.writeLong(spCourseId);
	}

	public long spPersonaAttendeeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String description;
	public long imageId;
	public long spPersonaId;
	public long spCourseId;
}