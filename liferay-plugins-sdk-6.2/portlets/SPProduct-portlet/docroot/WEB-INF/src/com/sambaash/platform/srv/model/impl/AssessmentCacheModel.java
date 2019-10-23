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

import com.sambaash.platform.srv.model.Assessment;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Assessment in entity cache.
 *
 * @author gauravvijayvergia
 * @see Assessment
 * @generated
 */
public class AssessmentCacheModel implements CacheModel<Assessment>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{spAssessmentId=");
		sb.append(spAssessmentId);
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
		sb.append(", spModuleId=");
		sb.append(spModuleId);
		sb.append(", assessmentDesc=");
		sb.append(assessmentDesc);
		sb.append(", assessmentType=");
		sb.append(assessmentType);
		sb.append(", assessmentMethod=");
		sb.append(assessmentMethod);
		sb.append(", assessmentMode=");
		sb.append(assessmentMode);
		sb.append(", locationType=");
		sb.append(locationType);
		sb.append(", eligibility=");
		sb.append(eligibility);
		sb.append(", gradingType=");
		sb.append(gradingType);
		sb.append(", maximumMarks=");
		sb.append(maximumMarks);
		sb.append(", passingMarks=");
		sb.append(passingMarks);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Assessment toEntityModel() {
		AssessmentImpl assessmentImpl = new AssessmentImpl();

		assessmentImpl.setSpAssessmentId(spAssessmentId);
		assessmentImpl.setGroupId(groupId);
		assessmentImpl.setCompanyId(companyId);
		assessmentImpl.setUserId(userId);

		if (userName == null) {
			assessmentImpl.setUserName(StringPool.BLANK);
		}
		else {
			assessmentImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			assessmentImpl.setCreateDate(null);
		}
		else {
			assessmentImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			assessmentImpl.setModifiedDate(null);
		}
		else {
			assessmentImpl.setModifiedDate(new Date(modifiedDate));
		}

		assessmentImpl.setSpModuleId(spModuleId);

		if (assessmentDesc == null) {
			assessmentImpl.setAssessmentDesc(StringPool.BLANK);
		}
		else {
			assessmentImpl.setAssessmentDesc(assessmentDesc);
		}

		assessmentImpl.setAssessmentType(assessmentType);
		assessmentImpl.setAssessmentMethod(assessmentMethod);
		assessmentImpl.setAssessmentMode(assessmentMode);
		assessmentImpl.setLocationType(locationType);

		if (eligibility == null) {
			assessmentImpl.setEligibility(StringPool.BLANK);
		}
		else {
			assessmentImpl.setEligibility(eligibility);
		}

		assessmentImpl.setGradingType(gradingType);

		if (maximumMarks == null) {
			assessmentImpl.setMaximumMarks(StringPool.BLANK);
		}
		else {
			assessmentImpl.setMaximumMarks(maximumMarks);
		}

		if (passingMarks == null) {
			assessmentImpl.setPassingMarks(StringPool.BLANK);
		}
		else {
			assessmentImpl.setPassingMarks(passingMarks);
		}

		assessmentImpl.resetOriginalValues();

		return assessmentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spAssessmentId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spModuleId = objectInput.readLong();
		assessmentDesc = objectInput.readUTF();
		assessmentType = objectInput.readLong();
		assessmentMethod = objectInput.readLong();
		assessmentMode = objectInput.readLong();
		locationType = objectInput.readLong();
		eligibility = objectInput.readUTF();
		gradingType = objectInput.readLong();
		maximumMarks = objectInput.readUTF();
		passingMarks = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spAssessmentId);
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
		objectOutput.writeLong(spModuleId);

		if (assessmentDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(assessmentDesc);
		}

		objectOutput.writeLong(assessmentType);
		objectOutput.writeLong(assessmentMethod);
		objectOutput.writeLong(assessmentMode);
		objectOutput.writeLong(locationType);

		if (eligibility == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(eligibility);
		}

		objectOutput.writeLong(gradingType);

		if (maximumMarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(maximumMarks);
		}

		if (passingMarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(passingMarks);
		}
	}

	public long spAssessmentId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spModuleId;
	public String assessmentDesc;
	public long assessmentType;
	public long assessmentMethod;
	public long assessmentMode;
	public long locationType;
	public String eligibility;
	public long gradingType;
	public String maximumMarks;
	public String passingMarks;
}