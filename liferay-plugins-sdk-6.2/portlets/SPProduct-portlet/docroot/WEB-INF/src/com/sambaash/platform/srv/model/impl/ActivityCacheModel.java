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

import com.sambaash.platform.srv.model.Activity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Activity in entity cache.
 *
 * @author gauravvijayvergia
 * @see Activity
 * @generated
 */
public class ActivityCacheModel implements CacheModel<Activity>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spActivityId=");
		sb.append(spActivityId);
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
		sb.append(", spScheduleId=");
		sb.append(spScheduleId);
		sb.append(", description=");
		sb.append(description);
		sb.append(", activityTiming=");
		sb.append(activityTiming);
		sb.append(", activityPerformer=");
		sb.append(activityPerformer);
		sb.append(", activityDuration=");
		sb.append(activityDuration);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Activity toEntityModel() {
		ActivityImpl activityImpl = new ActivityImpl();

		activityImpl.setSpActivityId(spActivityId);
		activityImpl.setGroupId(groupId);
		activityImpl.setCompanyId(companyId);
		activityImpl.setUserId(userId);

		if (userName == null) {
			activityImpl.setUserName(StringPool.BLANK);
		}
		else {
			activityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			activityImpl.setCreateDate(null);
		}
		else {
			activityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			activityImpl.setModifiedDate(null);
		}
		else {
			activityImpl.setModifiedDate(new Date(modifiedDate));
		}

		activityImpl.setSpModuleId(spModuleId);
		activityImpl.setSpScheduleId(spScheduleId);

		if (description == null) {
			activityImpl.setDescription(StringPool.BLANK);
		}
		else {
			activityImpl.setDescription(description);
		}

		if (activityTiming == null) {
			activityImpl.setActivityTiming(StringPool.BLANK);
		}
		else {
			activityImpl.setActivityTiming(activityTiming);
		}

		if (activityPerformer == null) {
			activityImpl.setActivityPerformer(StringPool.BLANK);
		}
		else {
			activityImpl.setActivityPerformer(activityPerformer);
		}

		if (activityDuration == null) {
			activityImpl.setActivityDuration(StringPool.BLANK);
		}
		else {
			activityImpl.setActivityDuration(activityDuration);
		}

		activityImpl.resetOriginalValues();

		return activityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spActivityId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spModuleId = objectInput.readLong();
		spScheduleId = objectInput.readLong();
		description = objectInput.readUTF();
		activityTiming = objectInput.readUTF();
		activityPerformer = objectInput.readUTF();
		activityDuration = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spActivityId);
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
		objectOutput.writeLong(spScheduleId);

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (activityTiming == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityTiming);
		}

		if (activityPerformer == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityPerformer);
		}

		if (activityDuration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityDuration);
		}
	}

	public long spActivityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spModuleId;
	public long spScheduleId;
	public String description;
	public String activityTiming;
	public String activityPerformer;
	public String activityDuration;
}