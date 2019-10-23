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

import com.sambaash.platform.srv.model.Learning;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Learning in entity cache.
 *
 * @author gauravvijayvergia
 * @see Learning
 * @generated
 */
public class LearningCacheModel implements CacheModel<Learning>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spLearningId=");
		sb.append(spLearningId);
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
	public Learning toEntityModel() {
		LearningImpl learningImpl = new LearningImpl();

		learningImpl.setSpLearningId(spLearningId);
		learningImpl.setGroupId(groupId);
		learningImpl.setCompanyId(companyId);
		learningImpl.setUserId(userId);

		if (userName == null) {
			learningImpl.setUserName(StringPool.BLANK);
		}
		else {
			learningImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			learningImpl.setCreateDate(null);
		}
		else {
			learningImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			learningImpl.setModifiedDate(null);
		}
		else {
			learningImpl.setModifiedDate(new Date(modifiedDate));
		}

		learningImpl.setSpCourseId(spCourseId);

		if (intro == null) {
			learningImpl.setIntro(StringPool.BLANK);
		}
		else {
			learningImpl.setIntro(intro);
		}

		if (optionTitle == null) {
			learningImpl.setOptionTitle(StringPool.BLANK);
		}
		else {
			learningImpl.setOptionTitle(optionTitle);
		}

		if (option1 == null) {
			learningImpl.setOption1(StringPool.BLANK);
		}
		else {
			learningImpl.setOption1(option1);
		}

		if (option2 == null) {
			learningImpl.setOption2(StringPool.BLANK);
		}
		else {
			learningImpl.setOption2(option2);
		}

		if (note == null) {
			learningImpl.setNote(StringPool.BLANK);
		}
		else {
			learningImpl.setNote(note);
		}

		learningImpl.resetOriginalValues();

		return learningImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spLearningId = objectInput.readLong();
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
		objectOutput.writeLong(spLearningId);
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

	public long spLearningId;
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