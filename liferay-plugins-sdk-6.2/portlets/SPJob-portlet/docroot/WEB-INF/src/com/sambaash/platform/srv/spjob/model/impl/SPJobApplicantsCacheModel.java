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

package com.sambaash.platform.srv.spjob.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spjob.model.SPJobApplicants;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPJobApplicants in entity cache.
 *
 * @author harini
 * @see SPJobApplicants
 * @generated
 */
public class SPJobApplicantsCacheModel implements CacheModel<SPJobApplicants>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{spJobApplicantsId=");
		sb.append(spJobApplicantsId);
		sb.append(", jobId=");
		sb.append(jobId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", yearsOfExperience=");
		sb.append(yearsOfExperience);
		sb.append(", resume=");
		sb.append(resume);
		sb.append(", coverLetter=");
		sb.append(coverLetter);
		sb.append(", briefInfos=");
		sb.append(briefInfos);
		sb.append(", extra1=");
		sb.append(extra1);
		sb.append(", extra2=");
		sb.append(extra2);
		sb.append(", extra3=");
		sb.append(extra3);
		sb.append(", extra4=");
		sb.append(extra4);
		sb.append(", extra5=");
		sb.append(extra5);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPJobApplicants toEntityModel() {
		SPJobApplicantsImpl spJobApplicantsImpl = new SPJobApplicantsImpl();

		spJobApplicantsImpl.setSpJobApplicantsId(spJobApplicantsId);
		spJobApplicantsImpl.setJobId(jobId);
		spJobApplicantsImpl.setGroupId(groupId);
		spJobApplicantsImpl.setCompanyId(companyId);
		spJobApplicantsImpl.setUserId(userId);
		spJobApplicantsImpl.setCreatedBy(createdBy);
		spJobApplicantsImpl.setUpdatedBy(updatedBy);

		if (createDate == Long.MIN_VALUE) {
			spJobApplicantsImpl.setCreateDate(null);
		}
		else {
			spJobApplicantsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spJobApplicantsImpl.setModifiedDate(null);
		}
		else {
			spJobApplicantsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (firstName == null) {
			spJobApplicantsImpl.setFirstName(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			spJobApplicantsImpl.setLastName(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setLastName(lastName);
		}

		if (emailAddress == null) {
			spJobApplicantsImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setEmailAddress(emailAddress);
		}

		if (contactNumber == null) {
			spJobApplicantsImpl.setContactNumber(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setContactNumber(contactNumber);
		}

		if (yearsOfExperience == null) {
			spJobApplicantsImpl.setYearsOfExperience(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setYearsOfExperience(yearsOfExperience);
		}

		if (resume == null) {
			spJobApplicantsImpl.setResume(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setResume(resume);
		}

		if (coverLetter == null) {
			spJobApplicantsImpl.setCoverLetter(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setCoverLetter(coverLetter);
		}

		if (briefInfos == null) {
			spJobApplicantsImpl.setBriefInfos(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setBriefInfos(briefInfos);
		}

		if (extra1 == null) {
			spJobApplicantsImpl.setExtra1(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			spJobApplicantsImpl.setExtra2(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			spJobApplicantsImpl.setExtra3(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			spJobApplicantsImpl.setExtra4(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setExtra4(extra4);
		}

		if (extra5 == null) {
			spJobApplicantsImpl.setExtra5(StringPool.BLANK);
		}
		else {
			spJobApplicantsImpl.setExtra5(extra5);
		}

		spJobApplicantsImpl.resetOriginalValues();

		return spJobApplicantsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spJobApplicantsId = objectInput.readLong();
		jobId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdBy = objectInput.readLong();
		updatedBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		contactNumber = objectInput.readUTF();
		yearsOfExperience = objectInput.readUTF();
		resume = objectInput.readUTF();
		coverLetter = objectInput.readUTF();
		briefInfos = objectInput.readUTF();
		extra1 = objectInput.readUTF();
		extra2 = objectInput.readUTF();
		extra3 = objectInput.readUTF();
		extra4 = objectInput.readUTF();
		extra5 = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spJobApplicantsId);
		objectOutput.writeLong(jobId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(updatedBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (contactNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactNumber);
		}

		if (yearsOfExperience == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yearsOfExperience);
		}

		if (resume == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(resume);
		}

		if (coverLetter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(coverLetter);
		}

		if (briefInfos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(briefInfos);
		}

		if (extra1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra1);
		}

		if (extra2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra2);
		}

		if (extra3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra3);
		}

		if (extra4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra4);
		}

		if (extra5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extra5);
		}
	}

	public long spJobApplicantsId;
	public long jobId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdBy;
	public long updatedBy;
	public long createDate;
	public long modifiedDate;
	public String firstName;
	public String lastName;
	public String emailAddress;
	public String contactNumber;
	public String yearsOfExperience;
	public String resume;
	public String coverLetter;
	public String briefInfos;
	public String extra1;
	public String extra2;
	public String extra3;
	public String extra4;
	public String extra5;
}