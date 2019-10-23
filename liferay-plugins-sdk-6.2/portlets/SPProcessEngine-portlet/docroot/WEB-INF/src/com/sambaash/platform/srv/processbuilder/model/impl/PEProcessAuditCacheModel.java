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

package com.sambaash.platform.srv.processbuilder.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.processbuilder.model.PEProcessAudit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PEProcessAudit in entity cache.
 *
 * @author nareshchebolu
 * @see PEProcessAudit
 * @generated
 */
public class PEProcessAuditCacheModel implements CacheModel<PEProcessAudit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spPEProcessAuditId=");
		sb.append(spPEProcessAuditId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", spPEProcessStateId=");
		sb.append(spPEProcessStateId);
		sb.append(", spPEProcessId=");
		sb.append(spPEProcessId);
		sb.append(", entityClassId=");
		sb.append(entityClassId);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", userIdProcess=");
		sb.append(userIdProcess);
		sb.append(", statusTypeId=");
		sb.append(statusTypeId);
		sb.append(", spPEProcessStageId=");
		sb.append(spPEProcessStageId);
		sb.append(", nodeId=");
		sb.append(nodeId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", userIdSupervisor=");
		sb.append(userIdSupervisor);
		sb.append(", userIdAgent=");
		sb.append(userIdAgent);
		sb.append(", spPEClosedStageId=");
		sb.append(spPEClosedStageId);
		sb.append(", type=");
		sb.append(type);
		sb.append(", doneBy=");
		sb.append(doneBy);
		sb.append(", action=");
		sb.append(action);
		sb.append(", field1=");
		sb.append(field1);
		sb.append(", field2=");
		sb.append(field2);
		sb.append(", field3=");
		sb.append(field3);
		sb.append(", field4=");
		sb.append(field4);
		sb.append(", field5=");
		sb.append(field5);
		sb.append(", storageId=");
		sb.append(storageId);
		sb.append(", data1=");
		sb.append(data1);
		sb.append(", data2=");
		sb.append(data2);
		sb.append(", sourceClassId=");
		sb.append(sourceClassId);
		sb.append(", sourceEntityID=");
		sb.append(sourceEntityID);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PEProcessAudit toEntityModel() {
		PEProcessAuditImpl peProcessAuditImpl = new PEProcessAuditImpl();

		if (uuid == null) {
			peProcessAuditImpl.setUuid(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setUuid(uuid);
		}

		peProcessAuditImpl.setSpPEProcessAuditId(spPEProcessAuditId);
		peProcessAuditImpl.setGroupId(groupId);
		peProcessAuditImpl.setUserId(userId);
		peProcessAuditImpl.setCompanyId(companyId);

		if (userName == null) {
			peProcessAuditImpl.setUserName(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peProcessAuditImpl.setCreateDate(null);
		}
		else {
			peProcessAuditImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peProcessAuditImpl.setModifiedDate(null);
		}
		else {
			peProcessAuditImpl.setModifiedDate(new Date(modifiedDate));
		}

		peProcessAuditImpl.setSpPEProcessStateId(spPEProcessStateId);
		peProcessAuditImpl.setSpPEProcessId(spPEProcessId);
		peProcessAuditImpl.setEntityClassId(entityClassId);
		peProcessAuditImpl.setEntityId(entityId);
		peProcessAuditImpl.setUserIdProcess(userIdProcess);
		peProcessAuditImpl.setStatusTypeId(statusTypeId);
		peProcessAuditImpl.setSpPEProcessStageId(spPEProcessStageId);
		peProcessAuditImpl.setNodeId(nodeId);

		if (status == null) {
			peProcessAuditImpl.setStatus(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setStatus(status);
		}

		peProcessAuditImpl.setUserIdSupervisor(userIdSupervisor);
		peProcessAuditImpl.setUserIdAgent(userIdAgent);
		peProcessAuditImpl.setSpPEClosedStageId(spPEClosedStageId);

		if (type == null) {
			peProcessAuditImpl.setType(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setType(type);
		}

		if (doneBy == null) {
			peProcessAuditImpl.setDoneBy(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setDoneBy(doneBy);
		}

		if (action == null) {
			peProcessAuditImpl.setAction(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setAction(action);
		}

		if (field1 == null) {
			peProcessAuditImpl.setField1(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setField1(field1);
		}

		if (field2 == null) {
			peProcessAuditImpl.setField2(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setField2(field2);
		}

		if (field3 == null) {
			peProcessAuditImpl.setField3(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setField3(field3);
		}

		if (field4 == null) {
			peProcessAuditImpl.setField4(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setField4(field4);
		}

		peProcessAuditImpl.setField5(field5);
		peProcessAuditImpl.setStorageId(storageId);

		if (data1 == null) {
			peProcessAuditImpl.setData1(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setData1(data1);
		}

		if (data2 == null) {
			peProcessAuditImpl.setData2(StringPool.BLANK);
		}
		else {
			peProcessAuditImpl.setData2(data2);
		}

		peProcessAuditImpl.setSourceClassId(sourceClassId);
		peProcessAuditImpl.setSourceEntityID(sourceEntityID);

		peProcessAuditImpl.resetOriginalValues();

		return peProcessAuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spPEProcessAuditId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spPEProcessStateId = objectInput.readLong();
		spPEProcessId = objectInput.readLong();
		entityClassId = objectInput.readLong();
		entityId = objectInput.readLong();
		userIdProcess = objectInput.readLong();
		statusTypeId = objectInput.readLong();
		spPEProcessStageId = objectInput.readLong();
		nodeId = objectInput.readLong();
		status = objectInput.readUTF();
		userIdSupervisor = objectInput.readLong();
		userIdAgent = objectInput.readLong();
		spPEClosedStageId = objectInput.readLong();
		type = objectInput.readUTF();
		doneBy = objectInput.readUTF();
		action = objectInput.readUTF();
		field1 = objectInput.readUTF();
		field2 = objectInput.readUTF();
		field3 = objectInput.readUTF();
		field4 = objectInput.readUTF();
		field5 = objectInput.readLong();
		storageId = objectInput.readLong();
		data1 = objectInput.readUTF();
		data2 = objectInput.readUTF();
		sourceClassId = objectInput.readLong();
		sourceEntityID = objectInput.readLong();
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

		objectOutput.writeLong(spPEProcessAuditId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(companyId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(spPEProcessStateId);
		objectOutput.writeLong(spPEProcessId);
		objectOutput.writeLong(entityClassId);
		objectOutput.writeLong(entityId);
		objectOutput.writeLong(userIdProcess);
		objectOutput.writeLong(statusTypeId);
		objectOutput.writeLong(spPEProcessStageId);
		objectOutput.writeLong(nodeId);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(userIdSupervisor);
		objectOutput.writeLong(userIdAgent);
		objectOutput.writeLong(spPEClosedStageId);

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (doneBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(doneBy);
		}

		if (action == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(action);
		}

		if (field1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(field1);
		}

		if (field2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(field2);
		}

		if (field3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(field3);
		}

		if (field4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(field4);
		}

		objectOutput.writeLong(field5);
		objectOutput.writeLong(storageId);

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

		objectOutput.writeLong(sourceClassId);
		objectOutput.writeLong(sourceEntityID);
	}

	public String uuid;
	public long spPEProcessAuditId;
	public long groupId;
	public long userId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spPEProcessStateId;
	public long spPEProcessId;
	public long entityClassId;
	public long entityId;
	public long userIdProcess;
	public long statusTypeId;
	public long spPEProcessStageId;
	public long nodeId;
	public String status;
	public long userIdSupervisor;
	public long userIdAgent;
	public long spPEClosedStageId;
	public String type;
	public String doneBy;
	public String action;
	public String field1;
	public String field2;
	public String field3;
	public String field4;
	public long field5;
	public long storageId;
	public String data1;
	public String data2;
	public long sourceClassId;
	public long sourceEntityID;
}