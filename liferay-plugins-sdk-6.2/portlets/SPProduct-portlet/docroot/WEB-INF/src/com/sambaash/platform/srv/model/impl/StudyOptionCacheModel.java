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

import com.sambaash.platform.srv.model.StudyOption;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StudyOption in entity cache.
 *
 * @author gauravvijayvergia
 * @see StudyOption
 * @generated
 */
public class StudyOptionCacheModel implements CacheModel<StudyOption>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spStudyOptionId=");
		sb.append(spStudyOptionId);
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
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", desc=");
		sb.append(desc);
		sb.append(", coverImageFileEntryId=");
		sb.append(coverImageFileEntryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StudyOption toEntityModel() {
		StudyOptionImpl studyOptionImpl = new StudyOptionImpl();

		studyOptionImpl.setSpStudyOptionId(spStudyOptionId);
		studyOptionImpl.setGroupId(groupId);
		studyOptionImpl.setCompanyId(companyId);
		studyOptionImpl.setUserId(userId);

		if (userName == null) {
			studyOptionImpl.setUserName(StringPool.BLANK);
		}
		else {
			studyOptionImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			studyOptionImpl.setCreateDate(null);
		}
		else {
			studyOptionImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			studyOptionImpl.setModifiedDate(null);
		}
		else {
			studyOptionImpl.setModifiedDate(new Date(modifiedDate));
		}

		studyOptionImpl.setSpCourseId(spCourseId);

		if (title == null) {
			studyOptionImpl.setTitle(StringPool.BLANK);
		}
		else {
			studyOptionImpl.setTitle(title);
		}

		if (desc == null) {
			studyOptionImpl.setDesc(StringPool.BLANK);
		}
		else {
			studyOptionImpl.setDesc(desc);
		}

		studyOptionImpl.setCoverImageFileEntryId(coverImageFileEntryId);

		studyOptionImpl.resetOriginalValues();

		return studyOptionImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spStudyOptionId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spCourseId = objectInput.readLong();
		title = objectInput.readUTF();
		desc = objectInput.readUTF();
		coverImageFileEntryId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spStudyOptionId);
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
		objectOutput.writeLong(spCourseId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (desc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(desc);
		}

		objectOutput.writeLong(coverImageFileEntryId);
	}

	public long spStudyOptionId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spCourseId;
	public String title;
	public String desc;
	public long coverImageFileEntryId;
}