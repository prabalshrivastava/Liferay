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

import com.sambaash.platform.srv.model.Persona;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Persona in entity cache.
 *
 * @author gauravvijayvergia
 * @see Persona
 * @generated
 */
public class PersonaCacheModel implements CacheModel<Persona>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{spPersonaId=");
		sb.append(spPersonaId);
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
		sb.append(", personaType=");
		sb.append(personaType);
		sb.append(", ageGroup=");
		sb.append(ageGroup);
		sb.append(", personaDesc=");
		sb.append(personaDesc);
		sb.append(", personaImageId=");
		sb.append(personaImageId);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Persona toEntityModel() {
		PersonaImpl personaImpl = new PersonaImpl();

		personaImpl.setSpPersonaId(spPersonaId);
		personaImpl.setGroupId(groupId);
		personaImpl.setCompanyId(companyId);
		personaImpl.setUserId(userId);

		if (userName == null) {
			personaImpl.setUserName(StringPool.BLANK);
		}
		else {
			personaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			personaImpl.setCreateDate(null);
		}
		else {
			personaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			personaImpl.setModifiedDate(null);
		}
		else {
			personaImpl.setModifiedDate(new Date(modifiedDate));
		}

		personaImpl.setPersonaType(personaType);

		if (ageGroup == null) {
			personaImpl.setAgeGroup(StringPool.BLANK);
		}
		else {
			personaImpl.setAgeGroup(ageGroup);
		}

		if (personaDesc == null) {
			personaImpl.setPersonaDesc(StringPool.BLANK);
		}
		else {
			personaImpl.setPersonaDesc(personaDesc);
		}

		personaImpl.setPersonaImageId(personaImageId);
		personaImpl.setSpCourseId(spCourseId);

		personaImpl.resetOriginalValues();

		return personaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spPersonaId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		personaType = objectInput.readLong();
		ageGroup = objectInput.readUTF();
		personaDesc = objectInput.readUTF();
		personaImageId = objectInput.readLong();
		spCourseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spPersonaId);
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
		objectOutput.writeLong(personaType);

		if (ageGroup == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ageGroup);
		}

		if (personaDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personaDesc);
		}

		objectOutput.writeLong(personaImageId);
		objectOutput.writeLong(spCourseId);
	}

	public long spPersonaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long personaType;
	public String ageGroup;
	public String personaDesc;
	public long personaImageId;
	public long spCourseId;
}