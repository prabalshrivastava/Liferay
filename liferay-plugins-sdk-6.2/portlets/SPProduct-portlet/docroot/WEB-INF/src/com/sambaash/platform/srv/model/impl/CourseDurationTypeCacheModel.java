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

import com.sambaash.platform.srv.model.CourseDurationType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CourseDurationType in entity cache.
 *
 * @author gauravvijayvergia
 * @see CourseDurationType
 * @generated
 */
public class CourseDurationTypeCacheModel implements CacheModel<CourseDurationType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spCourseDurationTypeId=");
		sb.append(spCourseDurationTypeId);
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
		sb.append(", spCourseDurationId=");
		sb.append(spCourseDurationId);
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
	public CourseDurationType toEntityModel() {
		CourseDurationTypeImpl courseDurationTypeImpl = new CourseDurationTypeImpl();

		courseDurationTypeImpl.setSpCourseDurationTypeId(spCourseDurationTypeId);
		courseDurationTypeImpl.setGroupId(groupId);
		courseDurationTypeImpl.setCompanyId(companyId);
		courseDurationTypeImpl.setUserId(userId);

		if (userName == null) {
			courseDurationTypeImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseDurationTypeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseDurationTypeImpl.setCreateDate(null);
		}
		else {
			courseDurationTypeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseDurationTypeImpl.setModifiedDate(null);
		}
		else {
			courseDurationTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		courseDurationTypeImpl.setSpCourseDurationId(spCourseDurationId);
		courseDurationTypeImpl.setSpCourseId(spCourseId);

		if (title1 == null) {
			courseDurationTypeImpl.setTitle1(StringPool.BLANK);
		}
		else {
			courseDurationTypeImpl.setTitle1(title1);
		}

		if (duration1 == null) {
			courseDurationTypeImpl.setDuration1(StringPool.BLANK);
		}
		else {
			courseDurationTypeImpl.setDuration1(duration1);
		}

		if (title2 == null) {
			courseDurationTypeImpl.setTitle2(StringPool.BLANK);
		}
		else {
			courseDurationTypeImpl.setTitle2(title2);
		}

		if (duration2 == null) {
			courseDurationTypeImpl.setDuration2(StringPool.BLANK);
		}
		else {
			courseDurationTypeImpl.setDuration2(duration2);
		}

		courseDurationTypeImpl.resetOriginalValues();

		return courseDurationTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCourseDurationTypeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spCourseDurationId = objectInput.readLong();
		spCourseId = objectInput.readLong();
		title1 = objectInput.readUTF();
		duration1 = objectInput.readUTF();
		title2 = objectInput.readUTF();
		duration2 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCourseDurationTypeId);
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
		objectOutput.writeLong(spCourseDurationId);
		objectOutput.writeLong(spCourseId);

		if (title1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title1);
		}

		if (duration1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duration1);
		}

		if (title2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title2);
		}

		if (duration2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duration2);
		}
	}

	public long spCourseDurationTypeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spCourseDurationId;
	public long spCourseId;
	public String title1;
	public String duration1;
	public String title2;
	public String duration2;
}