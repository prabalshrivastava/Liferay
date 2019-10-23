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

import com.sambaash.platform.srv.model.CourseLearning;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CourseLearning in entity cache.
 *
 * @author gauravvijayvergia
 * @see CourseLearning
 * @generated
 */
public class CourseLearningCacheModel implements CacheModel<CourseLearning>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spCourseLearningId=");
		sb.append(spCourseLearningId);
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
		sb.append(", optionTitle=");
		sb.append(optionTitle);
		sb.append(", option1=");
		sb.append(option1);
		sb.append(", option2=");
		sb.append(option2);
		sb.append(", note=");
		sb.append(note);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CourseLearning toEntityModel() {
		CourseLearningImpl courseLearningImpl = new CourseLearningImpl();

		courseLearningImpl.setSpCourseLearningId(spCourseLearningId);
		courseLearningImpl.setGroupId(groupId);
		courseLearningImpl.setCompanyId(companyId);
		courseLearningImpl.setUserId(userId);

		if (userName == null) {
			courseLearningImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseLearningImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseLearningImpl.setCreateDate(null);
		}
		else {
			courseLearningImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseLearningImpl.setModifiedDate(null);
		}
		else {
			courseLearningImpl.setModifiedDate(new Date(modifiedDate));
		}

		courseLearningImpl.setSpCourseId(spCourseId);

		if (intro == null) {
			courseLearningImpl.setIntro(StringPool.BLANK);
		}
		else {
			courseLearningImpl.setIntro(intro);
		}

		if (optionTitle == null) {
			courseLearningImpl.setOptionTitle(StringPool.BLANK);
		}
		else {
			courseLearningImpl.setOptionTitle(optionTitle);
		}

		if (option1 == null) {
			courseLearningImpl.setOption1(StringPool.BLANK);
		}
		else {
			courseLearningImpl.setOption1(option1);
		}

		if (option2 == null) {
			courseLearningImpl.setOption2(StringPool.BLANK);
		}
		else {
			courseLearningImpl.setOption2(option2);
		}

		if (note == null) {
			courseLearningImpl.setNote(StringPool.BLANK);
		}
		else {
			courseLearningImpl.setNote(note);
		}

		courseLearningImpl.resetOriginalValues();

		return courseLearningImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCourseLearningId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spCourseId = objectInput.readLong();
		intro = objectInput.readUTF();
		optionTitle = objectInput.readUTF();
		option1 = objectInput.readUTF();
		option2 = objectInput.readUTF();
		note = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCourseLearningId);
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

		if (optionTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(optionTitle);
		}

		if (option1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(option1);
		}

		if (option2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(option2);
		}

		if (note == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(note);
		}
	}

	public long spCourseLearningId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spCourseId;
	public String intro;
	public String optionTitle;
	public String option1;
	public String option2;
	public String note;
}