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

import com.sambaash.platform.srv.model.Course;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Course in entity cache.
 *
 * @author gauravvijayvergia
 * @see Course
 * @generated
 */
public class CourseCacheModel implements CacheModel<Course>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{spCourseId=");
		sb.append(spCourseId);
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
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", courseCode=");
		sb.append(courseCode);
		sb.append(", courseName=");
		sb.append(courseName);
		sb.append(", displayCourseName=");
		sb.append(displayCourseName);
		sb.append(", courseDesc=");
		sb.append(courseDesc);
		sb.append(", courseDurationFullTime=");
		sb.append(courseDurationFullTime);
		sb.append(", learningDurationFullTime=");
		sb.append(learningDurationFullTime);
		sb.append(", courseDurationPartTime=");
		sb.append(courseDurationPartTime);
		sb.append(", learningDurationPartTime=");
		sb.append(learningDurationPartTime);
		sb.append(", complexityLevel=");
		sb.append(complexityLevel);
		sb.append(", courseType=");
		sb.append(courseType);
		sb.append(", frameworkApprovalStatus=");
		sb.append(frameworkApprovalStatus);
		sb.append(", graduationCriteriaDesc=");
		sb.append(graduationCriteriaDesc);
		sb.append(", fundingDescPre=");
		sb.append(fundingDescPre);
		sb.append(", fundingDescPost=");
		sb.append(fundingDescPost);
		sb.append(", feeDetailsDesc=");
		sb.append(feeDetailsDesc);
		sb.append(", testLink=");
		sb.append(testLink);
		sb.append(", courseOutcomeTitle=");
		sb.append(courseOutcomeTitle);
		sb.append(", courseOutcomeDesc=");
		sb.append(courseOutcomeDesc);
		sb.append(", personaDesc=");
		sb.append(personaDesc);
		sb.append(", certificateTitle=");
		sb.append(certificateTitle);
		sb.append(", awardingBodyId=");
		sb.append(awardingBodyId);
		sb.append(", courseLevel=");
		sb.append(courseLevel);
		sb.append(", miscFeeDesc=");
		sb.append(miscFeeDesc);
		sb.append(", courseDeveloperId=");
		sb.append(courseDeveloperId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Course toEntityModel() {
		CourseImpl courseImpl = new CourseImpl();

		courseImpl.setSpCourseId(spCourseId);
		courseImpl.setGroupId(groupId);
		courseImpl.setCompanyId(companyId);
		courseImpl.setUserId(userId);

		if (userName == null) {
			courseImpl.setUserName(StringPool.BLANK);
		}
		else {
			courseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			courseImpl.setCreateDate(null);
		}
		else {
			courseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			courseImpl.setModifiedDate(null);
		}
		else {
			courseImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (countryId == null) {
			courseImpl.setCountryId(StringPool.BLANK);
		}
		else {
			courseImpl.setCountryId(countryId);
		}

		if (courseCode == null) {
			courseImpl.setCourseCode(StringPool.BLANK);
		}
		else {
			courseImpl.setCourseCode(courseCode);
		}

		if (courseName == null) {
			courseImpl.setCourseName(StringPool.BLANK);
		}
		else {
			courseImpl.setCourseName(courseName);
		}

		courseImpl.setDisplayCourseName(displayCourseName);

		if (courseDesc == null) {
			courseImpl.setCourseDesc(StringPool.BLANK);
		}
		else {
			courseImpl.setCourseDesc(courseDesc);
		}

		if (courseDurationFullTime == null) {
			courseImpl.setCourseDurationFullTime(StringPool.BLANK);
		}
		else {
			courseImpl.setCourseDurationFullTime(courseDurationFullTime);
		}

		if (learningDurationFullTime == null) {
			courseImpl.setLearningDurationFullTime(StringPool.BLANK);
		}
		else {
			courseImpl.setLearningDurationFullTime(learningDurationFullTime);
		}

		if (courseDurationPartTime == null) {
			courseImpl.setCourseDurationPartTime(StringPool.BLANK);
		}
		else {
			courseImpl.setCourseDurationPartTime(courseDurationPartTime);
		}

		if (learningDurationPartTime == null) {
			courseImpl.setLearningDurationPartTime(StringPool.BLANK);
		}
		else {
			courseImpl.setLearningDurationPartTime(learningDurationPartTime);
		}

		if (complexityLevel == null) {
			courseImpl.setComplexityLevel(StringPool.BLANK);
		}
		else {
			courseImpl.setComplexityLevel(complexityLevel);
		}

		courseImpl.setCourseType(courseType);
		courseImpl.setFrameworkApprovalStatus(frameworkApprovalStatus);

		if (graduationCriteriaDesc == null) {
			courseImpl.setGraduationCriteriaDesc(StringPool.BLANK);
		}
		else {
			courseImpl.setGraduationCriteriaDesc(graduationCriteriaDesc);
		}

		if (fundingDescPre == null) {
			courseImpl.setFundingDescPre(StringPool.BLANK);
		}
		else {
			courseImpl.setFundingDescPre(fundingDescPre);
		}

		if (fundingDescPost == null) {
			courseImpl.setFundingDescPost(StringPool.BLANK);
		}
		else {
			courseImpl.setFundingDescPost(fundingDescPost);
		}

		if (feeDetailsDesc == null) {
			courseImpl.setFeeDetailsDesc(StringPool.BLANK);
		}
		else {
			courseImpl.setFeeDetailsDesc(feeDetailsDesc);
		}

		if (testLink == null) {
			courseImpl.setTestLink(StringPool.BLANK);
		}
		else {
			courseImpl.setTestLink(testLink);
		}

		if (courseOutcomeTitle == null) {
			courseImpl.setCourseOutcomeTitle(StringPool.BLANK);
		}
		else {
			courseImpl.setCourseOutcomeTitle(courseOutcomeTitle);
		}

		if (courseOutcomeDesc == null) {
			courseImpl.setCourseOutcomeDesc(StringPool.BLANK);
		}
		else {
			courseImpl.setCourseOutcomeDesc(courseOutcomeDesc);
		}

		if (personaDesc == null) {
			courseImpl.setPersonaDesc(StringPool.BLANK);
		}
		else {
			courseImpl.setPersonaDesc(personaDesc);
		}

		if (certificateTitle == null) {
			courseImpl.setCertificateTitle(StringPool.BLANK);
		}
		else {
			courseImpl.setCertificateTitle(certificateTitle);
		}

		courseImpl.setAwardingBodyId(awardingBodyId);
		courseImpl.setCourseLevel(courseLevel);

		if (miscFeeDesc == null) {
			courseImpl.setMiscFeeDesc(StringPool.BLANK);
		}
		else {
			courseImpl.setMiscFeeDesc(miscFeeDesc);
		}

		courseImpl.setCourseDeveloperId(courseDeveloperId);

		courseImpl.resetOriginalValues();

		return courseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCourseId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryId = objectInput.readUTF();
		courseCode = objectInput.readUTF();
		courseName = objectInput.readUTF();
		displayCourseName = objectInput.readBoolean();
		courseDesc = objectInput.readUTF();
		courseDurationFullTime = objectInput.readUTF();
		learningDurationFullTime = objectInput.readUTF();
		courseDurationPartTime = objectInput.readUTF();
		learningDurationPartTime = objectInput.readUTF();
		complexityLevel = objectInput.readUTF();
		courseType = objectInput.readLong();
		frameworkApprovalStatus = objectInput.readBoolean();
		graduationCriteriaDesc = objectInput.readUTF();
		fundingDescPre = objectInput.readUTF();
		fundingDescPost = objectInput.readUTF();
		feeDetailsDesc = objectInput.readUTF();
		testLink = objectInput.readUTF();
		courseOutcomeTitle = objectInput.readUTF();
		courseOutcomeDesc = objectInput.readUTF();
		personaDesc = objectInput.readUTF();
		certificateTitle = objectInput.readUTF();
		awardingBodyId = objectInput.readLong();
		courseLevel = objectInput.readLong();
		miscFeeDesc = objectInput.readUTF();
		courseDeveloperId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCourseId);
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

		if (countryId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryId);
		}

		if (courseCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseCode);
		}

		if (courseName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseName);
		}

		objectOutput.writeBoolean(displayCourseName);

		if (courseDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseDesc);
		}

		if (courseDurationFullTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseDurationFullTime);
		}

		if (learningDurationFullTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(learningDurationFullTime);
		}

		if (courseDurationPartTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseDurationPartTime);
		}

		if (learningDurationPartTime == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(learningDurationPartTime);
		}

		if (complexityLevel == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(complexityLevel);
		}

		objectOutput.writeLong(courseType);
		objectOutput.writeBoolean(frameworkApprovalStatus);

		if (graduationCriteriaDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(graduationCriteriaDesc);
		}

		if (fundingDescPre == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fundingDescPre);
		}

		if (fundingDescPost == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fundingDescPost);
		}

		if (feeDetailsDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(feeDetailsDesc);
		}

		if (testLink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(testLink);
		}

		if (courseOutcomeTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseOutcomeTitle);
		}

		if (courseOutcomeDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseOutcomeDesc);
		}

		if (personaDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(personaDesc);
		}

		if (certificateTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(certificateTitle);
		}

		objectOutput.writeLong(awardingBodyId);
		objectOutput.writeLong(courseLevel);

		if (miscFeeDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(miscFeeDesc);
		}

		objectOutput.writeLong(courseDeveloperId);
	}

	public long spCourseId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String countryId;
	public String courseCode;
	public String courseName;
	public boolean displayCourseName;
	public String courseDesc;
	public String courseDurationFullTime;
	public String learningDurationFullTime;
	public String courseDurationPartTime;
	public String learningDurationPartTime;
	public String complexityLevel;
	public long courseType;
	public boolean frameworkApprovalStatus;
	public String graduationCriteriaDesc;
	public String fundingDescPre;
	public String fundingDescPost;
	public String feeDetailsDesc;
	public String testLink;
	public String courseOutcomeTitle;
	public String courseOutcomeDesc;
	public String personaDesc;
	public String certificateTitle;
	public long awardingBodyId;
	public long courseLevel;
	public String miscFeeDesc;
	public long courseDeveloperId;
}