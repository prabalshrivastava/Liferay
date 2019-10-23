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

package com.sambaash.platform.srv.validation.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPStudentProgrammeResult in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammeResult
 * @generated
 */
public class SPStudentProgrammeResultCacheModel implements CacheModel<SPStudentProgrammeResult>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{spStudentProgrammeResultId=");
		sb.append(spStudentProgrammeResultId);
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
		sb.append(", nric=");
		sb.append(nric);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", courseCentre=");
		sb.append(courseCentre);
		sb.append(", courseStartDate=");
		sb.append(courseStartDate);
		sb.append(", courseEndDate=");
		sb.append(courseEndDate);
		sb.append(", programme=");
		sb.append(programme);
		sb.append(", exam=");
		sb.append(exam);
		sb.append(", examType=");
		sb.append(examType);
		sb.append(", paper1Result=");
		sb.append(paper1Result);
		sb.append(", paper2Result=");
		sb.append(paper2Result);
		sb.append(", overallResult=");
		sb.append(overallResult);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPStudentProgrammeResult toEntityModel() {
		SPStudentProgrammeResultImpl spStudentProgrammeResultImpl = new SPStudentProgrammeResultImpl();

		spStudentProgrammeResultImpl.setSpStudentProgrammeResultId(spStudentProgrammeResultId);
		spStudentProgrammeResultImpl.setCompanyId(companyId);
		spStudentProgrammeResultImpl.setUserId(userId);

		if (userName == null) {
			spStudentProgrammeResultImpl.setUserName(StringPool.BLANK);
		}
		else {
			spStudentProgrammeResultImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spStudentProgrammeResultImpl.setCreateDate(null);
		}
		else {
			spStudentProgrammeResultImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spStudentProgrammeResultImpl.setModifiedDate(null);
		}
		else {
			spStudentProgrammeResultImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nric == null) {
			spStudentProgrammeResultImpl.setNric(StringPool.BLANK);
		}
		else {
			spStudentProgrammeResultImpl.setNric(nric);
		}

		if (emailAddress == null) {
			spStudentProgrammeResultImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spStudentProgrammeResultImpl.setEmailAddress(emailAddress);
		}

		if (courseCentre == null) {
			spStudentProgrammeResultImpl.setCourseCentre(StringPool.BLANK);
		}
		else {
			spStudentProgrammeResultImpl.setCourseCentre(courseCentre);
		}

		if (courseStartDate == Long.MIN_VALUE) {
			spStudentProgrammeResultImpl.setCourseStartDate(null);
		}
		else {
			spStudentProgrammeResultImpl.setCourseStartDate(new Date(
					courseStartDate));
		}

		if (courseEndDate == Long.MIN_VALUE) {
			spStudentProgrammeResultImpl.setCourseEndDate(null);
		}
		else {
			spStudentProgrammeResultImpl.setCourseEndDate(new Date(
					courseEndDate));
		}

		if (programme == null) {
			spStudentProgrammeResultImpl.setProgramme(StringPool.BLANK);
		}
		else {
			spStudentProgrammeResultImpl.setProgramme(programme);
		}

		if (exam == Long.MIN_VALUE) {
			spStudentProgrammeResultImpl.setExam(null);
		}
		else {
			spStudentProgrammeResultImpl.setExam(new Date(exam));
		}

		if (examType == null) {
			spStudentProgrammeResultImpl.setExamType(StringPool.BLANK);
		}
		else {
			spStudentProgrammeResultImpl.setExamType(examType);
		}

		if (paper1Result == null) {
			spStudentProgrammeResultImpl.setPaper1Result(StringPool.BLANK);
		}
		else {
			spStudentProgrammeResultImpl.setPaper1Result(paper1Result);
		}

		if (paper2Result == null) {
			spStudentProgrammeResultImpl.setPaper2Result(StringPool.BLANK);
		}
		else {
			spStudentProgrammeResultImpl.setPaper2Result(paper2Result);
		}

		if (overallResult == null) {
			spStudentProgrammeResultImpl.setOverallResult(StringPool.BLANK);
		}
		else {
			spStudentProgrammeResultImpl.setOverallResult(overallResult);
		}

		spStudentProgrammeResultImpl.resetOriginalValues();

		return spStudentProgrammeResultImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spStudentProgrammeResultId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nric = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		courseCentre = objectInput.readUTF();
		courseStartDate = objectInput.readLong();
		courseEndDate = objectInput.readLong();
		programme = objectInput.readUTF();
		exam = objectInput.readLong();
		examType = objectInput.readUTF();
		paper1Result = objectInput.readUTF();
		paper2Result = objectInput.readUTF();
		overallResult = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spStudentProgrammeResultId);
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

		if (nric == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nric);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (courseCentre == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseCentre);
		}

		objectOutput.writeLong(courseStartDate);
		objectOutput.writeLong(courseEndDate);

		if (programme == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(programme);
		}

		objectOutput.writeLong(exam);

		if (examType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(examType);
		}

		if (paper1Result == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paper1Result);
		}

		if (paper2Result == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paper2Result);
		}

		if (overallResult == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(overallResult);
		}
	}

	public long spStudentProgrammeResultId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nric;
	public String emailAddress;
	public String courseCentre;
	public long courseStartDate;
	public long courseEndDate;
	public String programme;
	public long exam;
	public String examType;
	public String paper1Result;
	public String paper2Result;
	public String overallResult;
}