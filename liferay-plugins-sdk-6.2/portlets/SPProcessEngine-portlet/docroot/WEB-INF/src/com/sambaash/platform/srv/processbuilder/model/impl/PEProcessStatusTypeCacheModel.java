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

import com.sambaash.platform.srv.processbuilder.model.PEProcessStatusType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PEProcessStatusType in entity cache.
 *
 * @author nareshchebolu
 * @see PEProcessStatusType
 * @generated
 */
public class PEProcessStatusTypeCacheModel implements CacheModel<PEProcessStatusType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spPEProcessStatusTypeId=");
		sb.append(spPEProcessStatusTypeId);
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
		sb.append(", statusName=");
		sb.append(statusName);
		sb.append(", seqNo=");
		sb.append(seqNo);
		sb.append(", approveTemplateId=");
		sb.append(approveTemplateId);
		sb.append(", rejectTemplateId=");
		sb.append(rejectTemplateId);
		sb.append(", spPEProcessStageId=");
		sb.append(spPEProcessStageId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PEProcessStatusType toEntityModel() {
		PEProcessStatusTypeImpl peProcessStatusTypeImpl = new PEProcessStatusTypeImpl();

		if (uuid == null) {
			peProcessStatusTypeImpl.setUuid(StringPool.BLANK);
		}
		else {
			peProcessStatusTypeImpl.setUuid(uuid);
		}

		peProcessStatusTypeImpl.setSpPEProcessStatusTypeId(spPEProcessStatusTypeId);
		peProcessStatusTypeImpl.setGroupId(groupId);
		peProcessStatusTypeImpl.setCompanyId(companyId);
		peProcessStatusTypeImpl.setUserId(userId);

		if (userName == null) {
			peProcessStatusTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			peProcessStatusTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peProcessStatusTypeImpl.setCreateDate(null);
		}
		else {
			peProcessStatusTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peProcessStatusTypeImpl.setModifiedDate(null);
		}
		else {
			peProcessStatusTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		peProcessStatusTypeImpl.setSpPEProcessId(spPEProcessId);

		if (statusName == null) {
			peProcessStatusTypeImpl.setStatusName(StringPool.BLANK);
		}
		else {
			peProcessStatusTypeImpl.setStatusName(statusName);
		}

		peProcessStatusTypeImpl.setSeqNo(seqNo);
		peProcessStatusTypeImpl.setApproveTemplateId(approveTemplateId);
		peProcessStatusTypeImpl.setRejectTemplateId(rejectTemplateId);
		peProcessStatusTypeImpl.setSpPEProcessStageId(spPEProcessStageId);

		peProcessStatusTypeImpl.resetOriginalValues();

		return peProcessStatusTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spPEProcessStatusTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spPEProcessId = objectInput.readLong();
		statusName = objectInput.readUTF();
		seqNo = objectInput.readLong();
		approveTemplateId = objectInput.readLong();
		rejectTemplateId = objectInput.readLong();
		spPEProcessStageId = objectInput.readLong();
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

		objectOutput.writeLong(spPEProcessStatusTypeId);
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

		if (statusName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(statusName);
		}

		objectOutput.writeLong(seqNo);
		objectOutput.writeLong(approveTemplateId);
		objectOutput.writeLong(rejectTemplateId);
		objectOutput.writeLong(spPEProcessStageId);
	}

	public String uuid;
	public long spPEProcessStatusTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spPEProcessId;
	public String statusName;
	public long seqNo;
	public long approveTemplateId;
	public long rejectTemplateId;
	public long spPEProcessStageId;
}