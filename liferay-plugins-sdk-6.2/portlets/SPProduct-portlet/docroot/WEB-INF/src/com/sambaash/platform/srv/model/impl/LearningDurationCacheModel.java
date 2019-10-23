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

import com.sambaash.platform.srv.model.LearningDuration;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing LearningDuration in entity cache.
 *
 * @author gauravvijayvergia
 * @see LearningDuration
 * @generated
 */
public class LearningDurationCacheModel implements CacheModel<LearningDuration>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{spLearningDurationId=");
		sb.append(spLearningDurationId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public LearningDuration toEntityModel() {
		LearningDurationImpl learningDurationImpl = new LearningDurationImpl();

		learningDurationImpl.setSpLearningDurationId(spLearningDurationId);
		learningDurationImpl.setGroupId(groupId);
		learningDurationImpl.setCompanyId(companyId);
		learningDurationImpl.setUserId(userId);

		if (userName == null) {
			learningDurationImpl.setUserName(StringPool.BLANK);
		}
		else {
			learningDurationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			learningDurationImpl.setCreateDate(null);
		}
		else {
			learningDurationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			learningDurationImpl.setModifiedDate(null);
		}
		else {
			learningDurationImpl.setModifiedDate(new Date(modifiedDate));
		}

		learningDurationImpl.setSpCourseId(spCourseId);

		if (title == null) {
			learningDurationImpl.setTitle(StringPool.BLANK);
		}
		else {
			learningDurationImpl.setTitle(title);
		}

		learningDurationImpl.resetOriginalValues();

		return learningDurationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spLearningDurationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spCourseId = objectInput.readLong();
		title = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spLearningDurationId);
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
	}

	public long spLearningDurationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spCourseId;
	public String title;
}