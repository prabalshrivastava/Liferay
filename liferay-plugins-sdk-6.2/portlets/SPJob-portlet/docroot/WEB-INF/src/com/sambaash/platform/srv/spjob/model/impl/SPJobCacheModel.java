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

import com.sambaash.platform.srv.spjob.model.SPJob;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPJob in entity cache.
 *
 * @author harini
 * @see SPJob
 * @generated
 */
public class SPJobCacheModel implements CacheModel<SPJob>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(61);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spJobId=");
		sb.append(spJobId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", yearsOfExperience=");
		sb.append(yearsOfExperience);
		sb.append(", corporateName=");
		sb.append(corporateName);
		sb.append(", corporateId=");
		sb.append(corporateId);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", jobType=");
		sb.append(jobType);
		sb.append(", jobLocation=");
		sb.append(jobLocation);
		sb.append(", jobDescription=");
		sb.append(jobDescription);
		sb.append(", status=");
		sb.append(status);
		sb.append(", autoMatch=");
		sb.append(autoMatch);
		sb.append(", currency=");
		sb.append(currency);
		sb.append(", salary=");
		sb.append(salary);
		sb.append(", rate=");
		sb.append(rate);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", closingDate=");
		sb.append(closingDate);
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
		sb.append(", notefto=");
		sb.append(notefto);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPJob toEntityModel() {
		SPJobImpl spJobImpl = new SPJobImpl();

		if (uuid == null) {
			spJobImpl.setUuid(StringPool.BLANK);
		}
		else {
			spJobImpl.setUuid(uuid);
		}

		spJobImpl.setSpJobId(spJobId);
		spJobImpl.setGroupId(groupId);
		spJobImpl.setCompanyId(companyId);
		spJobImpl.setUserId(userId);
		spJobImpl.setCreatedBy(createdBy);

		if (createDate == Long.MIN_VALUE) {
			spJobImpl.setCreateDate(null);
		}
		else {
			spJobImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spJobImpl.setModifiedDate(null);
		}
		else {
			spJobImpl.setModifiedDate(new Date(modifiedDate));
		}

		spJobImpl.setUpdatedBy(updatedBy);

		if (yearsOfExperience == null) {
			spJobImpl.setYearsOfExperience(StringPool.BLANK);
		}
		else {
			spJobImpl.setYearsOfExperience(yearsOfExperience);
		}

		if (corporateName == null) {
			spJobImpl.setCorporateName(StringPool.BLANK);
		}
		else {
			spJobImpl.setCorporateName(corporateName);
		}

		spJobImpl.setCorporateId(corporateId);

		if (jobTitle == null) {
			spJobImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			spJobImpl.setJobTitle(jobTitle);
		}

		if (jobType == null) {
			spJobImpl.setJobType(StringPool.BLANK);
		}
		else {
			spJobImpl.setJobType(jobType);
		}

		if (jobLocation == null) {
			spJobImpl.setJobLocation(StringPool.BLANK);
		}
		else {
			spJobImpl.setJobLocation(jobLocation);
		}

		if (jobDescription == null) {
			spJobImpl.setJobDescription(StringPool.BLANK);
		}
		else {
			spJobImpl.setJobDescription(jobDescription);
		}

		if (status == null) {
			spJobImpl.setStatus(StringPool.BLANK);
		}
		else {
			spJobImpl.setStatus(status);
		}

		spJobImpl.setAutoMatch(autoMatch);

		if (currency == null) {
			spJobImpl.setCurrency(StringPool.BLANK);
		}
		else {
			spJobImpl.setCurrency(currency);
		}

		spJobImpl.setSalary(salary);

		if (rate == null) {
			spJobImpl.setRate(StringPool.BLANK);
		}
		else {
			spJobImpl.setRate(rate);
		}

		if (startDate == Long.MIN_VALUE) {
			spJobImpl.setStartDate(null);
		}
		else {
			spJobImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			spJobImpl.setEndDate(null);
		}
		else {
			spJobImpl.setEndDate(new Date(endDate));
		}

		if (closingDate == Long.MIN_VALUE) {
			spJobImpl.setClosingDate(null);
		}
		else {
			spJobImpl.setClosingDate(new Date(closingDate));
		}

		if (extra1 == null) {
			spJobImpl.setExtra1(StringPool.BLANK);
		}
		else {
			spJobImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			spJobImpl.setExtra2(StringPool.BLANK);
		}
		else {
			spJobImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			spJobImpl.setExtra3(StringPool.BLANK);
		}
		else {
			spJobImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			spJobImpl.setExtra4(StringPool.BLANK);
		}
		else {
			spJobImpl.setExtra4(extra4);
		}

		if (extra5 == null) {
			spJobImpl.setExtra5(StringPool.BLANK);
		}
		else {
			spJobImpl.setExtra5(extra5);
		}

		if (notefto == null) {
			spJobImpl.setNotefto(StringPool.BLANK);
		}
		else {
			spJobImpl.setNotefto(notefto);
		}

		spJobImpl.resetOriginalValues();

		return spJobImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spJobId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		createdBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		updatedBy = objectInput.readLong();
		yearsOfExperience = objectInput.readUTF();
		corporateName = objectInput.readUTF();
		corporateId = objectInput.readLong();
		jobTitle = objectInput.readUTF();
		jobType = objectInput.readUTF();
		jobLocation = objectInput.readUTF();
		jobDescription = objectInput.readUTF();
		status = objectInput.readUTF();
		autoMatch = objectInput.readBoolean();
		currency = objectInput.readUTF();
		salary = objectInput.readDouble();
		rate = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		closingDate = objectInput.readLong();
		extra1 = objectInput.readUTF();
		extra2 = objectInput.readUTF();
		extra3 = objectInput.readUTF();
		extra4 = objectInput.readUTF();
		extra5 = objectInput.readUTF();
		notefto = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(spJobId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(updatedBy);

		if (yearsOfExperience == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yearsOfExperience);
		}

		if (corporateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(corporateName);
		}

		objectOutput.writeLong(corporateId);

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		if (jobType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobType);
		}

		if (jobLocation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobLocation);
		}

		if (jobDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobDescription);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeBoolean(autoMatch);

		if (currency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currency);
		}

		objectOutput.writeDouble(salary);

		if (rate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rate);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);
		objectOutput.writeLong(closingDate);

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

		if (notefto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notefto);
		}
	}

	public String uuid;
	public long spJobId;
	public long groupId;
	public long companyId;
	public long userId;
	public long createdBy;
	public long createDate;
	public long modifiedDate;
	public long updatedBy;
	public String yearsOfExperience;
	public String corporateName;
	public long corporateId;
	public String jobTitle;
	public String jobType;
	public String jobLocation;
	public String jobDescription;
	public String status;
	public boolean autoMatch;
	public String currency;
	public double salary;
	public String rate;
	public long startDate;
	public long endDate;
	public long closingDate;
	public String extra1;
	public String extra2;
	public String extra3;
	public String extra4;
	public String extra5;
	public String notefto;
}