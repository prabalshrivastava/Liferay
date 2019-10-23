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

import com.sambaash.platform.srv.validation.model.SPStudentProgramme;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPStudentProgramme in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPStudentProgramme
 * @generated
 */
public class SPStudentProgrammeCacheModel implements CacheModel<SPStudentProgramme>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{spStudentCourseId=");
		sb.append(spStudentCourseId);
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
		sb.append(", programme=");
		sb.append(programme);
		sb.append(", courseCentre=");
		sb.append(courseCentre);
		sb.append(", courseStartDate=");
		sb.append(courseStartDate);
		sb.append(", courseEndDate=");
		sb.append(courseEndDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPStudentProgramme toEntityModel() {
		SPStudentProgrammeImpl spStudentProgrammeImpl = new SPStudentProgrammeImpl();

		spStudentProgrammeImpl.setSpStudentCourseId(spStudentCourseId);
		spStudentProgrammeImpl.setCompanyId(companyId);
		spStudentProgrammeImpl.setUserId(userId);

		if (userName == null) {
			spStudentProgrammeImpl.setUserName(StringPool.BLANK);
		}
		else {
			spStudentProgrammeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spStudentProgrammeImpl.setCreateDate(null);
		}
		else {
			spStudentProgrammeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spStudentProgrammeImpl.setModifiedDate(null);
		}
		else {
			spStudentProgrammeImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (nric == null) {
			spStudentProgrammeImpl.setNric(StringPool.BLANK);
		}
		else {
			spStudentProgrammeImpl.setNric(nric);
		}

		if (emailAddress == null) {
			spStudentProgrammeImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spStudentProgrammeImpl.setEmailAddress(emailAddress);
		}

		if (programme == null) {
			spStudentProgrammeImpl.setProgramme(StringPool.BLANK);
		}
		else {
			spStudentProgrammeImpl.setProgramme(programme);
		}

		if (courseCentre == null) {
			spStudentProgrammeImpl.setCourseCentre(StringPool.BLANK);
		}
		else {
			spStudentProgrammeImpl.setCourseCentre(courseCentre);
		}

		if (courseStartDate == Long.MIN_VALUE) {
			spStudentProgrammeImpl.setCourseStartDate(null);
		}
		else {
			spStudentProgrammeImpl.setCourseStartDate(new Date(courseStartDate));
		}

		if (courseEndDate == Long.MIN_VALUE) {
			spStudentProgrammeImpl.setCourseEndDate(null);
		}
		else {
			spStudentProgrammeImpl.setCourseEndDate(new Date(courseEndDate));
		}

		spStudentProgrammeImpl.resetOriginalValues();

		return spStudentProgrammeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spStudentCourseId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		nric = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		programme = objectInput.readUTF();
		courseCentre = objectInput.readUTF();
		courseStartDate = objectInput.readLong();
		courseEndDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spStudentCourseId);
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

		if (programme == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(programme);
		}

		if (courseCentre == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(courseCentre);
		}

		objectOutput.writeLong(courseStartDate);
		objectOutput.writeLong(courseEndDate);
	}

	public long spStudentCourseId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String nric;
	public String emailAddress;
	public String programme;
	public String courseCentre;
	public long courseStartDate;
	public long courseEndDate;
}