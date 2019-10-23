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

package com.sambaash.platform.srv.extendedprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.extendedprofile.model.SPCompetency;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPCompetency in entity cache.
 *
 * @author harini
 * @see SPCompetency
 * @generated
 */
public class SPCompetencyCacheModel implements CacheModel<SPCompetency>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{classpk=");
		sb.append(classpk);
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
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", competencyId=");
		sb.append(competencyId);
		sb.append(", competencyLevelId=");
		sb.append(competencyLevelId);
		sb.append(", belongsToJobRole=");
		sb.append(belongsToJobRole);
		sb.append(", publicView=");
		sb.append(publicView);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPCompetency toEntityModel() {
		SPCompetencyImpl spCompetencyImpl = new SPCompetencyImpl();

		spCompetencyImpl.setClasspk(classpk);
		spCompetencyImpl.setGroupId(groupId);
		spCompetencyImpl.setCompanyId(companyId);
		spCompetencyImpl.setUserId(userId);

		if (userName == null) {
			spCompetencyImpl.setUserName(StringPool.BLANK);
		}
		else {
			spCompetencyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spCompetencyImpl.setCreateDate(null);
		}
		else {
			spCompetencyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spCompetencyImpl.setModifiedDate(null);
		}
		else {
			spCompetencyImpl.setModifiedDate(new Date(modifiedDate));
		}

		spCompetencyImpl.setCategoryId(categoryId);
		spCompetencyImpl.setCompetencyId(competencyId);
		spCompetencyImpl.setCompetencyLevelId(competencyLevelId);
		spCompetencyImpl.setBelongsToJobRole(belongsToJobRole);
		spCompetencyImpl.setPublicView(publicView);

		spCompetencyImpl.resetOriginalValues();

		return spCompetencyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		classpk = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		categoryId = objectInput.readLong();
		competencyId = objectInput.readLong();
		competencyLevelId = objectInput.readLong();
		belongsToJobRole = objectInput.readLong();
		publicView = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(classpk);
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
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(competencyId);
		objectOutput.writeLong(competencyLevelId);
		objectOutput.writeLong(belongsToJobRole);
		objectOutput.writeBoolean(publicView);
	}

	public long classpk;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long categoryId;
	public long competencyId;
	public long competencyLevelId;
	public long belongsToJobRole;
	public boolean publicView;
}