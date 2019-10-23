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

import com.sambaash.platform.srv.spservices.model.SPAudit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPAudit in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPAudit
 * @generated
 */
public class SPAuditCacheModel implements CacheModel<SPAudit>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", SPAuditId=");
		sb.append(SPAuditId);
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
		sb.append(", doneByUserId=");
		sb.append(doneByUserId);
		sb.append(", entityClassNameId=");
		sb.append(entityClassNameId);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", field1Str=");
		sb.append(field1Str);
		sb.append(", field1Long=");
		sb.append(field1Long);
		sb.append(", field2Str=");
		sb.append(field2Str);
		sb.append(", field2Long=");
		sb.append(field2Long);
		sb.append(", data1=");
		sb.append(data1);
		sb.append(", data2=");
		sb.append(data2);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPAudit toEntityModel() {
		SPAuditImpl spAuditImpl = new SPAuditImpl();

		if (uuid == null) {
			spAuditImpl.setUuid(StringPool.BLANK);
		}
		else {
			spAuditImpl.setUuid(uuid);
		}

		spAuditImpl.setSPAuditId(SPAuditId);
		spAuditImpl.setGroupId(groupId);
		spAuditImpl.setCompanyId(companyId);
		spAuditImpl.setUserId(userId);

		if (userName == null) {
			spAuditImpl.setUserName(StringPool.BLANK);
		}
		else {
			spAuditImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spAuditImpl.setCreateDate(null);
		}
		else {
			spAuditImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spAuditImpl.setModifiedDate(null);
		}
		else {
			spAuditImpl.setModifiedDate(new Date(modifiedDate));
		}

		spAuditImpl.setDoneByUserId(doneByUserId);
		spAuditImpl.setEntityClassNameId(entityClassNameId);
		spAuditImpl.setEntityId(entityId);

		if (action == null) {
			spAuditImpl.setAction(StringPool.BLANK);
		}
		else {
			spAuditImpl.setAction(action);
		}

		if (field1Str == null) {
			spAuditImpl.setField1Str(StringPool.BLANK);
		}
		else {
			spAuditImpl.setField1Str(field1Str);
		}

		spAuditImpl.setField1Long(field1Long);

		if (field2Str == null) {
			spAuditImpl.setField2Str(StringPool.BLANK);
		}
		else {
			spAuditImpl.setField2Str(field2Str);
		}

		spAuditImpl.setField2Long(field2Long);

		if (data1 == null) {
			spAuditImpl.setData1(StringPool.BLANK);
		}
		else {
			spAuditImpl.setData1(data1);
		}

		if (data2 == null) {
			spAuditImpl.setData2(StringPool.BLANK);
		}
		else {
			spAuditImpl.setData2(data2);
		}

		spAuditImpl.resetOriginalValues();

		return spAuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		SPAuditId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		doneByUserId = objectInput.readLong();
		entityClassNameId = objectInput.readLong();
		entityId = objectInput.readLong();
		action = objectInput.readUTF();
		field1Str = objectInput.readUTF();
		field1Long = objectInput.readLong();
		field2Str = objectInput.readUTF();
		field2Long = objectInput.readLong();
		data1 = objectInput.readUTF();
		data2 = objectInput.readUTF();
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

		objectOutput.writeLong(SPAuditId);
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
		objectOutput.writeLong(doneByUserId);
		objectOutput.writeLong(entityClassNameId);
		objectOutput.writeLong(entityId);

		if (action == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (field1Str == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(field1Str);
		}

		objectOutput.writeLong(field1Long);

		if (field2Str == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(field2Str);
		}

		objectOutput.writeLong(field2Long);

		if (data1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(data1);
		}

		if (data2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(data2);
		}
	}

	public String uuid;
	public long SPAuditId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long doneByUserId;
	public long entityClassNameId;
	public long entityId;
	public String action;
	public String field1Str;
	public long field1Long;
	public String field2Str;
	public long field2Long;
	public String data1;
	public String data2;
}