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

import com.sambaash.platform.srv.model.CourseDuration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CourseDuration in entity cache.
 *
 * @author gauravvijayvergia
 * @see CourseDuration
 * @generated
 */
public class CourseDurationCacheModel implements CacheModel<CourseDuration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spCourseDurationId=");
		sb.append(spCourseDurationId);
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
		sb.append(", spCourseLearningId=");
		sb.append(spCourseLearningId);
		sb.append(", title=");
		sb.append(title);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CourseDuration toEntityModel() {
		CourseDurationImpl courseDurationImpl = new CourseDurationImpl();

		courseDurationImpl.setSpCourseDurationId(spCourseDurationId);
		courseDurationImpl.setGroupId(groupId);
		courseDurationImpl.setCompanyId(companyId);
		courseDurationImpl.setUserId(userId);

		if (userName == null) {
			courseDurationImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseDurationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseDurationImpl.setCreateDate(null);
		}
		else {
			courseDurationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseDurationImpl.setModifiedDate(null);
		}
		else {
			courseDurationImpl.setModifiedDate(new Date(modifiedDate));
		}

		courseDurationImpl.setSpCourseId(spCourseId);
		courseDurationImpl.setSpCourseLearningId(spCourseLearningId);

		if (title == null) {
			courseDurationImpl.setTitle(StringPool.BLANK);
		}
		else {
			courseDurationImpl.setTitle(title);
		}

		courseDurationImpl.resetOriginalValues();

		return courseDurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCourseDurationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spCourseId = objectInput.readLong();
		spCourseLearningId = objectInput.readLong();
		title = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCourseDurationId);
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
		objectOutput.writeLong(spCourseLearningId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}
	}

	public long spCourseDurationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spCourseId;
	public long spCourseLearningId;
	public String title;
}