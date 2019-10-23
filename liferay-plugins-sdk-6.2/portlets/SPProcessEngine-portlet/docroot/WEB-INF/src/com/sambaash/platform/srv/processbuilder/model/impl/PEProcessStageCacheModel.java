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

import com.sambaash.platform.srv.processbuilder.model.PEProcessStage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PEProcessStage in entity cache.
 *
 * @author nareshchebolu
 * @see PEProcessStage
 * @generated
 */
public class PEProcessStageCacheModel implements CacheModel<PEProcessStage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spPEProcessStageId=");
		sb.append(spPEProcessStageId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", style=");
		sb.append(style);
		sb.append(", seqNo=");
		sb.append(seqNo);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PEProcessStage toEntityModel() {
		PEProcessStageImpl peProcessStageImpl = new PEProcessStageImpl();

		if (uuid == null) {
			peProcessStageImpl.setUuid(StringPool.BLANK);
		}
		else {
			peProcessStageImpl.setUuid(uuid);
		}

		peProcessStageImpl.setSpPEProcessStageId(spPEProcessStageId);
		peProcessStageImpl.setGroupId(groupId);
		peProcessStageImpl.setUserId(userId);
		peProcessStageImpl.setCompanyId(companyId);

		if (userName == null) {
			peProcessStageImpl.setUserName(StringPool.BLANK);
		}
		else {
			peProcessStageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peProcessStageImpl.setCreateDate(null);
		}
		else {
			peProcessStageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peProcessStageImpl.setModifiedDate(null);
		}
		else {
			peProcessStageImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			peProcessStageImpl.setName(StringPool.BLANK);
		}
		else {
			peProcessStageImpl.setName(name);
		}

		if (style == null) {
			peProcessStageImpl.setStyle(StringPool.BLANK);
		}
		else {
			peProcessStageImpl.setStyle(style);
		}

		peProcessStageImpl.setSeqNo(seqNo);

		peProcessStageImpl.resetOriginalValues();

		return peProcessStageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spPEProcessStageId = objectInput.readLong();
		groupId = objectInput.readLong();
		userId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		style = objectInput.readUTF();
		seqNo = objectInput.readLong();
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

		objectOutput.writeLong(spPEProcessStageId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (style == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(style);
		}

		objectOutput.writeLong(seqNo);
	}

	public String uuid;
	public long spPEProcessStageId;
	public long groupId;
	public long userId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String style;
	public long seqNo;
}