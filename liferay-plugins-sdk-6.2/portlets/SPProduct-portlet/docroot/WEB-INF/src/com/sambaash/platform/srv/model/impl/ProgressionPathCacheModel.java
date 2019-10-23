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

import com.sambaash.platform.srv.model.ProgressionPath;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProgressionPath in entity cache.
 *
 * @author gauravvijayvergia
 * @see ProgressionPath
 * @generated
 */
public class ProgressionPathCacheModel implements CacheModel<ProgressionPath>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{spProgressionPathId=");
		sb.append(spProgressionPathId);
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
		sb.append(", careerLevel=");
		sb.append(careerLevel);
		sb.append(", level=");
		sb.append(level);
		sb.append(", progressionType=");
		sb.append(progressionType);
		sb.append(", progressionCategory=");
		sb.append(progressionCategory);
		sb.append(", startMonth=");
		sb.append(startMonth);
		sb.append(", endMonth=");
		sb.append(endMonth);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", optionalMandatory=");
		sb.append(optionalMandatory);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProgressionPath toEntityModel() {
		ProgressionPathImpl progressionPathImpl = new ProgressionPathImpl();

		progressionPathImpl.setSpProgressionPathId(spProgressionPathId);
		progressionPathImpl.setGroupId(groupId);
		progressionPathImpl.setCompanyId(companyId);
		progressionPathImpl.setUserId(userId);

		if (userName == null) {
			progressionPathImpl.setUserName(StringPool.BLANK);
		}
		else {
			progressionPathImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			progressionPathImpl.setCreateDate(null);
		}
		else {
			progressionPathImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			progressionPathImpl.setModifiedDate(null);
		}
		else {
			progressionPathImpl.setModifiedDate(new Date(modifiedDate));
		}

		progressionPathImpl.setCareerLevel(careerLevel);
		progressionPathImpl.setLevel(level);
		progressionPathImpl.setProgressionType(progressionType);
		progressionPathImpl.setProgressionCategory(progressionCategory);

		if (startMonth == null) {
			progressionPathImpl.setStartMonth(StringPool.BLANK);
		}
		else {
			progressionPathImpl.setStartMonth(startMonth);
		}

		if (endMonth == null) {
			progressionPathImpl.setEndMonth(StringPool.BLANK);
		}
		else {
			progressionPathImpl.setEndMonth(endMonth);
		}

		if (duration == null) {
			progressionPathImpl.setDuration(StringPool.BLANK);
		}
		else {
			progressionPathImpl.setDuration(duration);
		}

		if (optionalMandatory == null) {
			progressionPathImpl.setOptionalMandatory(StringPool.BLANK);
		}
		else {
			progressionPathImpl.setOptionalMandatory(optionalMandatory);
		}

		progressionPathImpl.setSpCourseId(spCourseId);

		progressionPathImpl.resetOriginalValues();

		return progressionPathImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spProgressionPathId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		careerLevel = objectInput.readLong();
		level = objectInput.readInt();
		progressionType = objectInput.readLong();
		progressionCategory = objectInput.readLong();
		startMonth = objectInput.readUTF();
		endMonth = objectInput.readUTF();
		duration = objectInput.readUTF();
		optionalMandatory = objectInput.readUTF();
		spCourseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spProgressionPathId);
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
		objectOutput.writeLong(careerLevel);
		objectOutput.writeInt(level);
		objectOutput.writeLong(progressionType);
		objectOutput.writeLong(progressionCategory);

		if (startMonth == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startMonth);
		}

		if (endMonth == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endMonth);
		}

		if (duration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duration);
		}

		if (optionalMandatory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(optionalMandatory);
		}

		objectOutput.writeLong(spCourseId);
	}

	public long spProgressionPathId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long careerLevel;
	public int level;
	public long progressionType;
	public long progressionCategory;
	public String startMonth;
	public String endMonth;
	public String duration;
	public String optionalMandatory;
	public long spCourseId;
}