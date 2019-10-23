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

import com.sambaash.platform.srv.model.LogActivity;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LogActivity in entity cache.
 *
 * @author aishwarya
 * @see LogActivity
 * @generated
 */
public class LogActivityCacheModel implements CacheModel<LogActivity>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{spLogActivityId=");
		sb.append(spLogActivityId);
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
		sb.append(", entityClassId=");
		sb.append(entityClassId);
		sb.append(", entityClassName=");
		sb.append(entityClassName);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", savedByUserId=");
		sb.append(savedByUserId);
		sb.append(", activityTitle=");
		sb.append(activityTitle);
		sb.append(", activityType=");
		sb.append(activityType);
		sb.append(", activityOutcome=");
		sb.append(activityOutcome);
		sb.append(", activityDate=");
		sb.append(activityDate);
		sb.append(", activityTime=");
		sb.append(activityTime);
		sb.append(", activityContent=");
		sb.append(activityContent);
		sb.append(", fileEntryId=");
		sb.append(fileEntryId);
		sb.append(", associatedWith=");
		sb.append(associatedWith);
		sb.append(", status=");
		sb.append(status);
		sb.append(", parentLogActivityId=");
		sb.append(parentLogActivityId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LogActivity toEntityModel() {
		LogActivityImpl logActivityImpl = new LogActivityImpl();

		logActivityImpl.setSpLogActivityId(spLogActivityId);
		logActivityImpl.setGroupId(groupId);
		logActivityImpl.setCompanyId(companyId);
		logActivityImpl.setUserId(userId);

		if (userName == null) {
			logActivityImpl.setUserName(StringPool.BLANK);
		}
		else {
			logActivityImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			logActivityImpl.setCreateDate(null);
		}
		else {
			logActivityImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			logActivityImpl.setModifiedDate(null);
		}
		else {
			logActivityImpl.setModifiedDate(new Date(modifiedDate));
		}

		logActivityImpl.setEntityClassId(entityClassId);

		if (entityClassName == null) {
			logActivityImpl.setEntityClassName(StringPool.BLANK);
		}
		else {
			logActivityImpl.setEntityClassName(entityClassName);
		}

		logActivityImpl.setEntityId(entityId);
		logActivityImpl.setSavedByUserId(savedByUserId);

		if (activityTitle == null) {
			logActivityImpl.setActivityTitle(StringPool.BLANK);
		}
		else {
			logActivityImpl.setActivityTitle(activityTitle);
		}

		if (activityType == null) {
			logActivityImpl.setActivityType(StringPool.BLANK);
		}
		else {
			logActivityImpl.setActivityType(activityType);
		}

		if (activityOutcome == null) {
			logActivityImpl.setActivityOutcome(StringPool.BLANK);
		}
		else {
			logActivityImpl.setActivityOutcome(activityOutcome);
		}

		if (activityDate == Long.MIN_VALUE) {
			logActivityImpl.setActivityDate(null);
		}
		else {
			logActivityImpl.setActivityDate(new Date(activityDate));
		}

		if (activityTime == null) {
			logActivityImpl.setActivityTime(StringPool.BLANK);
		}
		else {
			logActivityImpl.setActivityTime(activityTime);
		}

		if (activityContent == null) {
			logActivityImpl.setActivityContent(StringPool.BLANK);
		}
		else {
			logActivityImpl.setActivityContent(activityContent);
		}

		if (fileEntryId == null) {
			logActivityImpl.setFileEntryId(StringPool.BLANK);
		}
		else {
			logActivityImpl.setFileEntryId(fileEntryId);
		}

		logActivityImpl.setAssociatedWith(associatedWith);
		logActivityImpl.setStatus(status);
		logActivityImpl.setParentLogActivityId(parentLogActivityId);

		logActivityImpl.resetOriginalValues();

		return logActivityImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spLogActivityId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		entityClassId = objectInput.readLong();
		entityClassName = objectInput.readUTF();
		entityId = objectInput.readLong();
		savedByUserId = objectInput.readLong();
		activityTitle = objectInput.readUTF();
		activityType = objectInput.readUTF();
		activityOutcome = objectInput.readUTF();
		activityDate = objectInput.readLong();
		activityTime = objectInput.readUTF();
		activityContent = objectInput.readUTF();
		fileEntryId = objectInput.readUTF();
		associatedWith = objectInput.readLong();
		status = objectInput.readInt();
		parentLogActivityId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spLogActivityId);
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
		objectOutput.writeLong(entityClassId);

		if (entityClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entityClassName);
		}

		objectOutput.writeLong(entityId);
		objectOutput.writeLong(savedByUserId);

		if (activityTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityTitle);
		}

		if (activityType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityType);
		}

		if (activityOutcome == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityOutcome);
		}

		objectOutput.writeLong(activityDate);

		if (activityTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityTime);
		}

		if (activityContent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activityContent);
		}

		if (fileEntryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fileEntryId);
		}

		objectOutput.writeLong(associatedWith);
		objectOutput.writeInt(status);
		objectOutput.writeLong(parentLogActivityId);
	}

	public long spLogActivityId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long entityClassId;
	public String entityClassName;
	public long entityId;
	public long savedByUserId;
	public String activityTitle;
	public String activityType;
	public String activityOutcome;
	public long activityDate;
	public String activityTime;
	public String activityContent;
	public String fileEntryId;
	public long associatedWith;
	public int status;
	public long parentLogActivityId;
}