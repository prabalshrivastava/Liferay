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

package com.sambaash.platform.srv.spscheduler.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spscheduler.model.SPJobEntry;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPJobEntry in entity cache.
 *
 * @author pradeep
 * @see SPJobEntry
 * @generated
 */
public class SPJobEntryCacheModel implements CacheModel<SPJobEntry>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spJobEntryId=");
		sb.append(spJobEntryId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", jobName=");
		sb.append(jobName);
		sb.append(", jobClass=");
		sb.append(jobClass);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", statusMsg=");
		sb.append(statusMsg);
		sb.append(", cronExpression=");
		sb.append(cronExpression);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPJobEntry toEntityModel() {
		SPJobEntryImpl spJobEntryImpl = new SPJobEntryImpl();

		if (uuid == null) {
			spJobEntryImpl.setUuid(StringPool.BLANK);
		}
		else {
			spJobEntryImpl.setUuid(uuid);
		}

		spJobEntryImpl.setSpJobEntryId(spJobEntryId);
		spJobEntryImpl.setGroupId(groupId);

		if (jobName == null) {
			spJobEntryImpl.setJobName(StringPool.BLANK);
		}
		else {
			spJobEntryImpl.setJobName(jobName);
		}

		if (jobClass == null) {
			spJobEntryImpl.setJobClass(StringPool.BLANK);
		}
		else {
			spJobEntryImpl.setJobClass(jobClass);
		}

		if (portletId == null) {
			spJobEntryImpl.setPortletId(StringPool.BLANK);
		}
		else {
			spJobEntryImpl.setPortletId(portletId);
		}

		spJobEntryImpl.setStatus(status);

		if (statusMsg == null) {
			spJobEntryImpl.setStatusMsg(StringPool.BLANK);
		}
		else {
			spJobEntryImpl.setStatusMsg(statusMsg);
		}

		if (cronExpression == null) {
			spJobEntryImpl.setCronExpression(StringPool.BLANK);
		}
		else {
			spJobEntryImpl.setCronExpression(cronExpression);
		}

		spJobEntryImpl.setCompanyId(companyId);
		spJobEntryImpl.setUserId(userId);

		if (userName == null) {
			spJobEntryImpl.setUserName(StringPool.BLANK);
		}
		else {
			spJobEntryImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spJobEntryImpl.setCreateDate(null);
		}
		else {
			spJobEntryImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spJobEntryImpl.setModifiedDate(null);
		}
		else {
			spJobEntryImpl.setModifiedDate(new Date(modifiedDate));
		}

		spJobEntryImpl.resetOriginalValues();

		return spJobEntryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spJobEntryId = objectInput.readLong();
		groupId = objectInput.readLong();
		jobName = objectInput.readUTF();
		jobClass = objectInput.readUTF();
		portletId = objectInput.readUTF();
		status = objectInput.readInt();
		statusMsg = objectInput.readUTF();
		cronExpression = objectInput.readUTF();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(spJobEntryId);
		objectOutput.writeLong(groupId);

		if (jobName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobName);
		}

		if (jobClass == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobClass);
		}

		if (portletId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletId);
		}

		objectOutput.writeInt(status);

		if (statusMsg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusMsg);
		}

		if (cronExpression == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cronExpression);
		}

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
	}

	public String uuid;
	public long spJobEntryId;
	public long groupId;
	public String jobName;
	public String jobClass;
	public String portletId;
	public int status;
	public String statusMsg;
	public String cronExpression;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}