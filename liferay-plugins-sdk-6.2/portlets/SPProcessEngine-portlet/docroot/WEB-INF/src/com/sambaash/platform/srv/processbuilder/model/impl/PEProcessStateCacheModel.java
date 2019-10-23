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

import com.sambaash.platform.srv.processbuilder.model.PEProcessState;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PEProcessState in entity cache.
 *
 * @author nareshchebolu
 * @see PEProcessState
 * @generated
 */
public class PEProcessStateCacheModel implements CacheModel<PEProcessState>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(81);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spPEProcessStateId=");
		sb.append(spPEProcessStateId);
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
		sb.append(", spPEProcessId=");
		sb.append(spPEProcessId);
		sb.append(", entityClassId=");
		sb.append(entityClassId);
		sb.append(", entityId=");
		sb.append(entityId);
		sb.append(", userIdProcess=");
		sb.append(userIdProcess);
		sb.append(", userIdCreator=");
		sb.append(userIdCreator);
		sb.append(", statusTypeId=");
		sb.append(statusTypeId);
		sb.append(", spPEProcessStageId=");
		sb.append(spPEProcessStageId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", nodeId=");
		sb.append(nodeId);
		sb.append(", nodeIdLastProcessed=");
		sb.append(nodeIdLastProcessed);
		sb.append(", nodeIdLastDisplayed=");
		sb.append(nodeIdLastDisplayed);
		sb.append(", nodeIdLastDataSubmitted=");
		sb.append(nodeIdLastDataSubmitted);
		sb.append(", data=");
		sb.append(data);
		sb.append(", lastErrorCode=");
		sb.append(lastErrorCode);
		sb.append(", lastErrorMsg=");
		sb.append(lastErrorMsg);
		sb.append(", lastErrorDate=");
		sb.append(lastErrorDate);
		sb.append(", currentStatusTypeApprovers=");
		sb.append(currentStatusTypeApprovers);
		sb.append(", currentNodeSubmitters=");
		sb.append(currentNodeSubmitters);
		sb.append(", lock=");
		sb.append(lock);
		sb.append(", lockDate=");
		sb.append(lockDate);
		sb.append(", userIdSupervisor=");
		sb.append(userIdSupervisor);
		sb.append(", userIdAgent=");
		sb.append(userIdAgent);
		sb.append(", closedStageId=");
		sb.append(closedStageId);
		sb.append(", closedDate=");
		sb.append(closedDate);
		sb.append(", closedReasonCatId=");
		sb.append(closedReasonCatId);
		sb.append(", closedDescription=");
		sb.append(closedDescription);
		sb.append(", convertedFromProcessStateId=");
		sb.append(convertedFromProcessStateId);
		sb.append(", convertedToProcessStateId=");
		sb.append(convertedToProcessStateId);
		sb.append(", activeStatus=");
		sb.append(activeStatus);
		sb.append(", amount=");
		sb.append(amount);
		sb.append(", sourceClassId=");
		sb.append(sourceClassId);
		sb.append(", sourceEntityID=");
		sb.append(sourceEntityID);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PEProcessState toEntityModel() {
		PEProcessStateImpl peProcessStateImpl = new PEProcessStateImpl();

		if (uuid == null) {
			peProcessStateImpl.setUuid(StringPool.BLANK);
		}
		else {
			peProcessStateImpl.setUuid(uuid);
		}

		peProcessStateImpl.setSpPEProcessStateId(spPEProcessStateId);
		peProcessStateImpl.setGroupId(groupId);
		peProcessStateImpl.setCompanyId(companyId);
		peProcessStateImpl.setUserId(userId);

		if (userName == null) {
			peProcessStateImpl.setUserName(StringPool.BLANK);
		}
		else {
			peProcessStateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peProcessStateImpl.setCreateDate(null);
		}
		else {
			peProcessStateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peProcessStateImpl.setModifiedDate(null);
		}
		else {
			peProcessStateImpl.setModifiedDate(new Date(modifiedDate));
		}

		peProcessStateImpl.setSpPEProcessId(spPEProcessId);
		peProcessStateImpl.setEntityClassId(entityClassId);
		peProcessStateImpl.setEntityId(entityId);
		peProcessStateImpl.setUserIdProcess(userIdProcess);
		peProcessStateImpl.setUserIdCreator(userIdCreator);
		peProcessStateImpl.setStatusTypeId(statusTypeId);
		peProcessStateImpl.setSpPEProcessStageId(spPEProcessStageId);

		if (status == null) {
			peProcessStateImpl.setStatus(StringPool.BLANK);
		}
		else {
			peProcessStateImpl.setStatus(status);
		}

		peProcessStateImpl.setNodeId(nodeId);
		peProcessStateImpl.setNodeIdLastProcessed(nodeIdLastProcessed);
		peProcessStateImpl.setNodeIdLastDisplayed(nodeIdLastDisplayed);
		peProcessStateImpl.setNodeIdLastDataSubmitted(nodeIdLastDataSubmitted);

		if (data == null) {
			peProcessStateImpl.setData(StringPool.BLANK);
		}
		else {
			peProcessStateImpl.setData(data);
		}

		peProcessStateImpl.setLastErrorCode(lastErrorCode);

		if (lastErrorMsg == null) {
			peProcessStateImpl.setLastErrorMsg(StringPool.BLANK);
		}
		else {
			peProcessStateImpl.setLastErrorMsg(lastErrorMsg);
		}

		if (lastErrorDate == Long.MIN_VALUE) {
			peProcessStateImpl.setLastErrorDate(null);
		}
		else {
			peProcessStateImpl.setLastErrorDate(new Date(lastErrorDate));
		}

		if (currentStatusTypeApprovers == null) {
			peProcessStateImpl.setCurrentStatusTypeApprovers(StringPool.BLANK);
		}
		else {
			peProcessStateImpl.setCurrentStatusTypeApprovers(currentStatusTypeApprovers);
		}

		if (currentNodeSubmitters == null) {
			peProcessStateImpl.setCurrentNodeSubmitters(StringPool.BLANK);
		}
		else {
			peProcessStateImpl.setCurrentNodeSubmitters(currentNodeSubmitters);
		}

		peProcessStateImpl.setLock(lock);

		if (lockDate == Long.MIN_VALUE) {
			peProcessStateImpl.setLockDate(null);
		}
		else {
			peProcessStateImpl.setLockDate(new Date(lockDate));
		}

		peProcessStateImpl.setUserIdSupervisor(userIdSupervisor);
		peProcessStateImpl.setUserIdAgent(userIdAgent);
		peProcessStateImpl.setClosedStageId(closedStageId);

		if (closedDate == Long.MIN_VALUE) {
			peProcessStateImpl.setClosedDate(null);
		}
		else {
			peProcessStateImpl.setClosedDate(new Date(closedDate));
		}

		peProcessStateImpl.setClosedReasonCatId(closedReasonCatId);

		if (closedDescription == null) {
			peProcessStateImpl.setClosedDescription(StringPool.BLANK);
		}
		else {
			peProcessStateImpl.setClosedDescription(closedDescription);
		}

		peProcessStateImpl.setConvertedFromProcessStateId(convertedFromProcessStateId);
		peProcessStateImpl.setConvertedToProcessStateId(convertedToProcessStateId);
		peProcessStateImpl.setActiveStatus(activeStatus);

		if (amount == null) {
			peProcessStateImpl.setAmount(StringPool.BLANK);
		}
		else {
			peProcessStateImpl.setAmount(amount);
		}

		peProcessStateImpl.setSourceClassId(sourceClassId);
		peProcessStateImpl.setSourceEntityID(sourceEntityID);

		peProcessStateImpl.resetOriginalValues();

		return peProcessStateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spPEProcessStateId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spPEProcessId = objectInput.readLong();
		entityClassId = objectInput.readLong();
		entityId = objectInput.readLong();
		userIdProcess = objectInput.readLong();
		userIdCreator = objectInput.readLong();
		statusTypeId = objectInput.readLong();
		spPEProcessStageId = objectInput.readLong();
		status = objectInput.readUTF();
		nodeId = objectInput.readLong();
		nodeIdLastProcessed = objectInput.readLong();
		nodeIdLastDisplayed = objectInput.readLong();
		nodeIdLastDataSubmitted = objectInput.readLong();
		data = objectInput.readUTF();
		lastErrorCode = objectInput.readLong();
		lastErrorMsg = objectInput.readUTF();
		lastErrorDate = objectInput.readLong();
		currentStatusTypeApprovers = objectInput.readUTF();
		currentNodeSubmitters = objectInput.readUTF();
		lock = objectInput.readInt();
		lockDate = objectInput.readLong();
		userIdSupervisor = objectInput.readLong();
		userIdAgent = objectInput.readLong();
		closedStageId = objectInput.readLong();
		closedDate = objectInput.readLong();
		closedReasonCatId = objectInput.readLong();
		closedDescription = objectInput.readUTF();
		convertedFromProcessStateId = objectInput.readLong();
		convertedToProcessStateId = objectInput.readLong();
		activeStatus = objectInput.readInt();
		amount = objectInput.readUTF();
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

		objectOutput.writeLong(spPEProcessStateId);
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
		objectOutput.writeLong(spPEProcessId);
		objectOutput.writeLong(entityClassId);
		objectOutput.writeLong(entityId);
		objectOutput.writeLong(userIdProcess);
		objectOutput.writeLong(userIdCreator);
		objectOutput.writeLong(statusTypeId);
		objectOutput.writeLong(spPEProcessStageId);

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeLong(nodeId);
		objectOutput.writeLong(nodeIdLastProcessed);
		objectOutput.writeLong(nodeIdLastDisplayed);
		objectOutput.writeLong(nodeIdLastDataSubmitted);

		if (data == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(data);
		}

		objectOutput.writeLong(lastErrorCode);

		if (lastErrorMsg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastErrorMsg);
		}

		objectOutput.writeLong(lastErrorDate);

		if (currentStatusTypeApprovers == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentStatusTypeApprovers);
		}

		if (currentNodeSubmitters == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currentNodeSubmitters);
		}

		objectOutput.writeInt(lock);
		objectOutput.writeLong(lockDate);
		objectOutput.writeLong(userIdSupervisor);
		objectOutput.writeLong(userIdAgent);
		objectOutput.writeLong(closedStageId);
		objectOutput.writeLong(closedDate);
		objectOutput.writeLong(closedReasonCatId);

		if (closedDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(closedDescription);
		}

		objectOutput.writeLong(convertedFromProcessStateId);
		objectOutput.writeLong(convertedToProcessStateId);
		objectOutput.writeInt(activeStatus);

		if (amount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(amount);
		}

		objectOutput.writeLong(sourceClassId);
		objectOutput.writeLong(sourceEntityID);
	}

	public String uuid;
	public long spPEProcessStateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spPEProcessId;
	public long entityClassId;
	public long entityId;
	public long userIdProcess;
	public long userIdCreator;
	public long statusTypeId;
	public long spPEProcessStageId;
	public String status;
	public long nodeId;
	public long nodeIdLastProcessed;
	public long nodeIdLastDisplayed;
	public long nodeIdLastDataSubmitted;
	public String data;
	public long lastErrorCode;
	public String lastErrorMsg;
	public long lastErrorDate;
	public String currentStatusTypeApprovers;
	public String currentNodeSubmitters;
	public int lock;
	public long lockDate;
	public long userIdSupervisor;
	public long userIdAgent;
	public long closedStageId;
	public long closedDate;
	public long closedReasonCatId;
	public String closedDescription;
	public long convertedFromProcessStateId;
	public long convertedToProcessStateId;
	public int activeStatus;
	public String amount;
	public long sourceClassId;
	public long sourceEntityID;
}