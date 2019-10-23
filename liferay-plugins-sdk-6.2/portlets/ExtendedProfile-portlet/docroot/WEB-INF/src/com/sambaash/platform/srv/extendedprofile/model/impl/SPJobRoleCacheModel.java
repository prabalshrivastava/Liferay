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

import com.sambaash.platform.srv.extendedprofile.model.SPJobRole;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPJobRole in entity cache.
 *
 * @author harini
 * @see SPJobRole
 * @generated
 */
public class SPJobRoleCacheModel implements CacheModel<SPJobRole>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spJobRoleId=");
		sb.append(spJobRoleId);
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
		sb.append(", functionalGroupId=");
		sb.append(functionalGroupId);
		sb.append(", JobLevelId=");
		sb.append(JobLevelId);
		sb.append(", careerPathId=");
		sb.append(careerPathId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPJobRole toEntityModel() {
		SPJobRoleImpl spJobRoleImpl = new SPJobRoleImpl();

		spJobRoleImpl.setSpJobRoleId(spJobRoleId);
		spJobRoleImpl.setGroupId(groupId);
		spJobRoleImpl.setCompanyId(companyId);
		spJobRoleImpl.setUserId(userId);

		if (userName == null) {
			spJobRoleImpl.setUserName(StringPool.BLANK);
		}
		else {
			spJobRoleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spJobRoleImpl.setCreateDate(null);
		}
		else {
			spJobRoleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spJobRoleImpl.setModifiedDate(null);
		}
		else {
			spJobRoleImpl.setModifiedDate(new Date(modifiedDate));
		}

		spJobRoleImpl.setFunctionalGroupId(functionalGroupId);
		spJobRoleImpl.setJobLevelId(JobLevelId);
		spJobRoleImpl.setCareerPathId(careerPathId);

		spJobRoleImpl.resetOriginalValues();

		return spJobRoleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spJobRoleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		functionalGroupId = objectInput.readLong();
		JobLevelId = objectInput.readLong();
		careerPathId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spJobRoleId);
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
		objectOutput.writeLong(functionalGroupId);
		objectOutput.writeLong(JobLevelId);
		objectOutput.writeLong(careerPathId);
	}

	public long spJobRoleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long functionalGroupId;
	public long JobLevelId;
	public long careerPathId;
}