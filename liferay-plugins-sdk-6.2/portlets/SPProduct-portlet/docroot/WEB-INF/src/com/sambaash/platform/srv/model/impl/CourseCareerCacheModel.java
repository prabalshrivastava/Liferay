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

import com.sambaash.platform.srv.model.CourseCareer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CourseCareer in entity cache.
 *
 * @author gauravvijayvergia
 * @see CourseCareer
 * @generated
 */
public class CourseCareerCacheModel implements CacheModel<CourseCareer>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{spCourseCareerId=");
		sb.append(spCourseCareerId);
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
		sb.append(", intro=");
		sb.append(intro);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CourseCareer toEntityModel() {
		CourseCareerImpl courseCareerImpl = new CourseCareerImpl();

		courseCareerImpl.setSpCourseCareerId(spCourseCareerId);
		courseCareerImpl.setGroupId(groupId);
		courseCareerImpl.setCompanyId(companyId);
		courseCareerImpl.setUserId(userId);

		if (userName == null) {
			courseCareerImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseCareerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseCareerImpl.setCreateDate(null);
		}
		else {
			courseCareerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseCareerImpl.setModifiedDate(null);
		}
		else {
			courseCareerImpl.setModifiedDate(new Date(modifiedDate));
		}

		courseCareerImpl.setSpCourseId(spCourseId);

		if (intro == null) {
			courseCareerImpl.setIntro(StringPool.BLANK);
		}
		else {
			courseCareerImpl.setIntro(intro);
		}

		courseCareerImpl.resetOriginalValues();

		return courseCareerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCourseCareerId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spCourseId = objectInput.readLong();
		intro = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCourseCareerId);
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

		if (intro == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(intro);
		}
	}

	public long spCourseCareerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spCourseId;
	public String intro;
}