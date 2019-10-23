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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.SPApiAuditLogs;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPApiAuditLogs in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPApiAuditLogs
 * @generated
 */
public class SPApiAuditLogsCacheModel implements CacheModel<SPApiAuditLogs>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spApiAuditLogsId=");
		sb.append(spApiAuditLogsId);
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
		sb.append(", apiName=");
		sb.append(apiName);
		sb.append(", parameters=");
		sb.append(parameters);
		sb.append(", result=");
		sb.append(result);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPApiAuditLogs toEntityModel() {
		SPApiAuditLogsImpl spApiAuditLogsImpl = new SPApiAuditLogsImpl();

		if (uuid == null) {
			spApiAuditLogsImpl.setUuid(StringPool.BLANK);
		}
		else {
			spApiAuditLogsImpl.setUuid(uuid);
		}

		spApiAuditLogsImpl.setSpApiAuditLogsId(spApiAuditLogsId);
		spApiAuditLogsImpl.setGroupId(groupId);
		spApiAuditLogsImpl.setCompanyId(companyId);
		spApiAuditLogsImpl.setUserId(userId);

		if (userName == null) {
			spApiAuditLogsImpl.setUserName(StringPool.BLANK);
		}
		else {
			spApiAuditLogsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spApiAuditLogsImpl.setCreateDate(null);
		}
		else {
			spApiAuditLogsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spApiAuditLogsImpl.setModifiedDate(null);
		}
		else {
			spApiAuditLogsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (apiName == null) {
			spApiAuditLogsImpl.setApiName(StringPool.BLANK);
		}
		else {
			spApiAuditLogsImpl.setApiName(apiName);
		}

		if (parameters == null) {
			spApiAuditLogsImpl.setParameters(StringPool.BLANK);
		}
		else {
			spApiAuditLogsImpl.setParameters(parameters);
		}

		if (result == null) {
			spApiAuditLogsImpl.setResult(StringPool.BLANK);
		}
		else {
			spApiAuditLogsImpl.setResult(result);
		}

		spApiAuditLogsImpl.resetOriginalValues();

		return spApiAuditLogsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spApiAuditLogsId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		apiName = objectInput.readUTF();
		parameters = objectInput.readUTF();
		result = objectInput.readUTF();
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

		objectOutput.writeLong(spApiAuditLogsId);
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

		if (apiName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(apiName);
		}

		if (parameters == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(parameters);
		}

		if (result == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(result);
		}
	}

	public String uuid;
	public long spApiAuditLogsId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String apiName;
	public String parameters;
	public String result;
}