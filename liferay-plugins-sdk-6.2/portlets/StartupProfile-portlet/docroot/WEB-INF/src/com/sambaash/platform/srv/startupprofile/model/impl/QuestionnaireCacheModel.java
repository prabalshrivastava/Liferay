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

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.startupprofile.model.Questionnaire;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Questionnaire in entity cache.
 *
 * @author pradeep
 * @see Questionnaire
 * @generated
 */
public class QuestionnaireCacheModel implements CacheModel<Questionnaire>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{questionnaireId=");
		sb.append(questionnaireId);
		sb.append(", entryClassPK=");
		sb.append(entryClassPK);
		sb.append(", entryClassName=");
		sb.append(entryClassName);
		sb.append(", answer1=");
		sb.append(answer1);
		sb.append(", answer2=");
		sb.append(answer2);
		sb.append(", answer3=");
		sb.append(answer3);
		sb.append(", answer4=");
		sb.append(answer4);
		sb.append(", answer5=");
		sb.append(answer5);
		sb.append(", answer6=");
		sb.append(answer6);
		sb.append(", answer7=");
		sb.append(answer7);
		sb.append(", answer8=");
		sb.append(answer8);
		sb.append(", answer9=");
		sb.append(answer9);
		sb.append(", answer10=");
		sb.append(answer10);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Questionnaire toEntityModel() {
		QuestionnaireImpl questionnaireImpl = new QuestionnaireImpl();

		questionnaireImpl.setQuestionnaireId(questionnaireId);
		questionnaireImpl.setEntryClassPK(entryClassPK);

		if (entryClassName == null) {
			questionnaireImpl.setEntryClassName(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setEntryClassName(entryClassName);
		}

		if (answer1 == null) {
			questionnaireImpl.setAnswer1(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer1(answer1);
		}

		if (answer2 == null) {
			questionnaireImpl.setAnswer2(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer2(answer2);
		}

		if (answer3 == null) {
			questionnaireImpl.setAnswer3(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer3(answer3);
		}

		if (answer4 == null) {
			questionnaireImpl.setAnswer4(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer4(answer4);
		}

		if (answer5 == null) {
			questionnaireImpl.setAnswer5(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer5(answer5);
		}

		if (answer6 == null) {
			questionnaireImpl.setAnswer6(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer6(answer6);
		}

		if (answer7 == null) {
			questionnaireImpl.setAnswer7(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer7(answer7);
		}

		if (answer8 == null) {
			questionnaireImpl.setAnswer8(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer8(answer8);
		}

		if (answer9 == null) {
			questionnaireImpl.setAnswer9(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer9(answer9);
		}

		if (answer10 == null) {
			questionnaireImpl.setAnswer10(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setAnswer10(answer10);
		}

		questionnaireImpl.setGroupId(groupId);
		questionnaireImpl.setCompanyId(companyId);
		questionnaireImpl.setUserId(userId);

		if (userName == null) {
			questionnaireImpl.setUserName(StringPool.BLANK);
		}
		else {
			questionnaireImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			questionnaireImpl.setCreateDate(null);
		}
		else {
			questionnaireImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			questionnaireImpl.setModifiedDate(null);
		}
		else {
			questionnaireImpl.setModifiedDate(new Date(modifiedDate));
		}

		questionnaireImpl.resetOriginalValues();

		return questionnaireImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		questionnaireId = objectInput.readLong();
		entryClassPK = objectInput.readLong();
		entryClassName = objectInput.readUTF();
		answer1 = objectInput.readUTF();
		answer2 = objectInput.readUTF();
		answer3 = objectInput.readUTF();
		answer4 = objectInput.readUTF();
		answer5 = objectInput.readUTF();
		answer6 = objectInput.readUTF();
		answer7 = objectInput.readUTF();
		answer8 = objectInput.readUTF();
		answer9 = objectInput.readUTF();
		answer10 = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(questionnaireId);
		objectOutput.writeLong(entryClassPK);

		if (entryClassName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(entryClassName);
		}

		if (answer1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer1);
		}

		if (answer2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer2);
		}

		if (answer3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer3);
		}

		if (answer4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer4);
		}

		if (answer5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer5);
		}

		if (answer6 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer6);
		}

		if (answer7 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer7);
		}

		if (answer8 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer8);
		}

		if (answer9 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer9);
		}

		if (answer10 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(answer10);
		}

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
	}

	public long questionnaireId;
	public long entryClassPK;
	public String entryClassName;
	public String answer1;
	public String answer2;
	public String answer3;
	public String answer4;
	public String answer5;
	public String answer6;
	public String answer7;
	public String answer8;
	public String answer9;
	public String answer10;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}