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

import com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserAvailabilityCalendar in entity cache.
 *
 * @author gauravvijayvergia
 * @see UserAvailabilityCalendar
 * @generated
 */
public class UserAvailabilityCalendarCacheModel implements CacheModel<UserAvailabilityCalendar>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{userAvailabilityCalendarId=");
		sb.append(userAvailabilityCalendarId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", availableFor=");
		sb.append(availableFor);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserAvailabilityCalendar toEntityModel() {
		UserAvailabilityCalendarImpl userAvailabilityCalendarImpl = new UserAvailabilityCalendarImpl();

		userAvailabilityCalendarImpl.setUserAvailabilityCalendarId(userAvailabilityCalendarId);
		userAvailabilityCalendarImpl.setGroupId(groupId);
		userAvailabilityCalendarImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			userAvailabilityCalendarImpl.setCreateDate(null);
		}
		else {
			userAvailabilityCalendarImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			userAvailabilityCalendarImpl.setModifiedDate(null);
		}
		else {
			userAvailabilityCalendarImpl.setModifiedDate(new Date(modifiedDate));
		}

		userAvailabilityCalendarImpl.setUserId(userId);

		if (availableFor == null) {
			userAvailabilityCalendarImpl.setAvailableFor(StringPool.BLANK);
		}
		else {
			userAvailabilityCalendarImpl.setAvailableFor(availableFor);
		}

		if (startDate == Long.MIN_VALUE) {
			userAvailabilityCalendarImpl.setStartDate(null);
		}
		else {
			userAvailabilityCalendarImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			userAvailabilityCalendarImpl.setEndDate(null);
		}
		else {
			userAvailabilityCalendarImpl.setEndDate(new Date(endDate));
		}

		userAvailabilityCalendarImpl.setActive(active);

		userAvailabilityCalendarImpl.resetOriginalValues();

		return userAvailabilityCalendarImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userAvailabilityCalendarId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		availableFor = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userAvailabilityCalendarId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);

		if (availableFor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(availableFor);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeBoolean(active);
	}

	public long userAvailabilityCalendarId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public String availableFor;
	public long startDate;
	public long endDate;
	public boolean active;
}