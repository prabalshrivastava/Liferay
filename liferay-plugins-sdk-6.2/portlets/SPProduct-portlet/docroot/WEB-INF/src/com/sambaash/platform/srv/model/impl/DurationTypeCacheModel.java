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

import com.sambaash.platform.srv.model.DurationType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing DurationType in entity cache.
 *
 * @author gauravvijayvergia
 * @see DurationType
 * @generated
 */
public class DurationTypeCacheModel implements CacheModel<DurationType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spDurationTypeId=");
		sb.append(spDurationTypeId);
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
		sb.append(", spLearningDurationId=");
		sb.append(spLearningDurationId);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append(", title1=");
		sb.append(title1);
		sb.append(", duration1=");
		sb.append(duration1);
		sb.append(", title2=");
		sb.append(title2);
		sb.append(", duration2=");
		sb.append(duration2);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public DurationType toEntityModel() {
		DurationTypeImpl durationTypeImpl = new DurationTypeImpl();

		durationTypeImpl.setSpDurationTypeId(spDurationTypeId);
		durationTypeImpl.setGroupId(groupId);
		durationTypeImpl.setCompanyId(companyId);
		durationTypeImpl.setUserId(userId);

		if (userName == null) {
			durationTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			durationTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			durationTypeImpl.setCreateDate(null);
		}
		else {
			durationTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			durationTypeImpl.setModifiedDate(null);
		}
		else {
			durationTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		durationTypeImpl.setSpLearningDurationId(spLearningDurationId);
		durationTypeImpl.setSpCourseId(spCourseId);

		if (title1 == null) {
			durationTypeImpl.setTitle1(StringPool.BLANK);
		}
		else {
			durationTypeImpl.setTitle1(title1);
		}

		durationTypeImpl.setDuration1(duration1);

		if (title2 == null) {
			durationTypeImpl.setTitle2(StringPool.BLANK);
		}
		else {
			durationTypeImpl.setTitle2(title2);
		}

		durationTypeImpl.setDuration2(duration2);

		durationTypeImpl.resetOriginalValues();

		return durationTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spDurationTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spLearningDurationId = objectInput.readLong();
		spCourseId = objectInput.readLong();
		title1 = objectInput.readUTF();
		duration1 = objectInput.readLong();
		title2 = objectInput.readUTF();
		duration2 = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spDurationTypeId);
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
		objectOutput.writeLong(spLearningDurationId);
		objectOutput.writeLong(spCourseId);

		if (title1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title1);
		}

		objectOutput.writeLong(duration1);

		if (title2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title2);
		}

		objectOutput.writeLong(duration2);
	}

	public long spDurationTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spLearningDurationId;
	public long spCourseId;
	public String title1;
	public long duration1;
	public String title2;
	public long duration2;
}