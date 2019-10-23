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

import com.sambaash.platform.srv.model.Outline;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Outline in entity cache.
 *
 * @author gauravvijayvergia
 * @see Outline
 * @generated
 */
public class OutlineCacheModel implements CacheModel<Outline>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spOutlineId=");
		sb.append(spOutlineId);
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
		sb.append(", spCompetencyUnitId=");
		sb.append(spCompetencyUnitId);
		sb.append(", outlineType=");
		sb.append(outlineType);
		sb.append(", outlineDesc=");
		sb.append(outlineDesc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Outline toEntityModel() {
		OutlineImpl outlineImpl = new OutlineImpl();

		outlineImpl.setSpOutlineId(spOutlineId);
		outlineImpl.setGroupId(groupId);
		outlineImpl.setCompanyId(companyId);
		outlineImpl.setUserId(userId);

		if (userName == null) {
			outlineImpl.setUserName(StringPool.BLANK);
		}
		else {
			outlineImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			outlineImpl.setCreateDate(null);
		}
		else {
			outlineImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			outlineImpl.setModifiedDate(null);
		}
		else {
			outlineImpl.setModifiedDate(new Date(modifiedDate));
		}

		outlineImpl.setSpCompetencyUnitId(spCompetencyUnitId);
		outlineImpl.setOutlineType(outlineType);

		if (outlineDesc == null) {
			outlineImpl.setOutlineDesc(StringPool.BLANK);
		}
		else {
			outlineImpl.setOutlineDesc(outlineDesc);
		}

		outlineImpl.resetOriginalValues();

		return outlineImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spOutlineId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spCompetencyUnitId = objectInput.readLong();
		outlineType = objectInput.readLong();
		outlineDesc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spOutlineId);
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
		objectOutput.writeLong(spCompetencyUnitId);
		objectOutput.writeLong(outlineType);

		if (outlineDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(outlineDesc);
		}
	}

	public long spOutlineId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spCompetencyUnitId;
	public long outlineType;
	public String outlineDesc;
}