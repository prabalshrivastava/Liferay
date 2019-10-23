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

import com.sambaash.platform.srv.model.Schedule;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Schedule in entity cache.
 *
 * @author gauravvijayvergia
 * @see Schedule
 * @generated
 */
public class ScheduleCacheModel implements CacheModel<Schedule>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{spScheduleId=");
		sb.append(spScheduleId);
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
		sb.append(", spModuleId=");
		sb.append(spModuleId);
		sb.append(", sessionNumber=");
		sb.append(sessionNumber);
		sb.append(", description=");
		sb.append(description);
		sb.append(", sessionType=");
		sb.append(sessionType);
		sb.append(", sessionDuration=");
		sb.append(sessionDuration);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Schedule toEntityModel() {
		ScheduleImpl scheduleImpl = new ScheduleImpl();

		scheduleImpl.setSpScheduleId(spScheduleId);
		scheduleImpl.setGroupId(groupId);
		scheduleImpl.setCompanyId(companyId);
		scheduleImpl.setUserId(userId);

		if (userName == null) {
			scheduleImpl.setUserName(StringPool.BLANK);
		}
		else {
			scheduleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			scheduleImpl.setCreateDate(null);
		}
		else {
			scheduleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			scheduleImpl.setModifiedDate(null);
		}
		else {
			scheduleImpl.setModifiedDate(new Date(modifiedDate));
		}

		scheduleImpl.setSpModuleId(spModuleId);

		if (sessionNumber == null) {
			scheduleImpl.setSessionNumber(StringPool.BLANK);
		}
		else {
			scheduleImpl.setSessionNumber(sessionNumber);
		}

		if (description == null) {
			scheduleImpl.setDescription(StringPool.BLANK);
		}
		else {
			scheduleImpl.setDescription(description);
		}

		scheduleImpl.setSessionType(sessionType);

		if (sessionDuration == null) {
			scheduleImpl.setSessionDuration(StringPool.BLANK);
		}
		else {
			scheduleImpl.setSessionDuration(sessionDuration);
		}

		scheduleImpl.resetOriginalValues();

		return scheduleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spScheduleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spModuleId = objectInput.readLong();
		sessionNumber = objectInput.readUTF();
		description = objectInput.readUTF();
		sessionType = objectInput.readLong();
		sessionDuration = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spScheduleId);
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
		objectOutput.writeLong(spModuleId);

		if (sessionNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sessionNumber);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(sessionType);

		if (sessionDuration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sessionDuration);
		}
	}

	public long spScheduleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spModuleId;
	public String sessionNumber;
	public String description;
	public long sessionType;
	public String sessionDuration;
}