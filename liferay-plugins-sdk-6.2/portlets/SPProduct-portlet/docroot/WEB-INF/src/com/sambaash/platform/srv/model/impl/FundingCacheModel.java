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

import com.sambaash.platform.srv.model.Funding;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Funding in entity cache.
 *
 * @author gauravvijayvergia
 * @see Funding
 * @generated
 */
public class FundingCacheModel implements CacheModel<Funding>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{spFundingId=");
		sb.append(spFundingId);
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
		sb.append(", courseType=");
		sb.append(courseType);
		sb.append(", fundingDesc=");
		sb.append(fundingDesc);
		sb.append(", fundingCriteria=");
		sb.append(fundingCriteria);
		sb.append(", fundOrder=");
		sb.append(fundOrder);
		sb.append(", sponsoredBy=");
		sb.append(sponsoredBy);
		sb.append(", residenceStatus=");
		sb.append(residenceStatus);
		sb.append(", ageOperator=");
		sb.append(ageOperator);
		sb.append(", age=");
		sb.append(age);
		sb.append(", earningStatus=");
		sb.append(earningStatus);
		sb.append(", salaryOperator=");
		sb.append(salaryOperator);
		sb.append(", salary=");
		sb.append(salary);
		sb.append(", fundingHour=");
		sb.append(fundingHour);
		sb.append(", fundingAmount=");
		sb.append(fundingAmount);
		sb.append(", netFees=");
		sb.append(netFees);
		sb.append(", absenteePayroll=");
		sb.append(absenteePayroll);
		sb.append(", fundingCourseFee=");
		sb.append(fundingCourseFee);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Funding toEntityModel() {
		FundingImpl fundingImpl = new FundingImpl();

		fundingImpl.setSpFundingId(spFundingId);
		fundingImpl.setGroupId(groupId);
		fundingImpl.setCompanyId(companyId);
		fundingImpl.setUserId(userId);

		if (userName == null) {
			fundingImpl.setUserName(StringPool.BLANK);
		}
		else {
			fundingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			fundingImpl.setCreateDate(null);
		}
		else {
			fundingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fundingImpl.setModifiedDate(null);
		}
		else {
			fundingImpl.setModifiedDate(new Date(modifiedDate));
		}

		fundingImpl.setCourseType(courseType);

		if (fundingDesc == null) {
			fundingImpl.setFundingDesc(StringPool.BLANK);
		}
		else {
			fundingImpl.setFundingDesc(fundingDesc);
		}

		if (fundingCriteria == null) {
			fundingImpl.setFundingCriteria(StringPool.BLANK);
		}
		else {
			fundingImpl.setFundingCriteria(fundingCriteria);
		}

		fundingImpl.setFundOrder(fundOrder);
		fundingImpl.setSponsoredBy(sponsoredBy);

		if (residenceStatus == null) {
			fundingImpl.setResidenceStatus(StringPool.BLANK);
		}
		else {
			fundingImpl.setResidenceStatus(residenceStatus);
		}

		if (ageOperator == null) {
			fundingImpl.setAgeOperator(StringPool.BLANK);
		}
		else {
			fundingImpl.setAgeOperator(ageOperator);
		}

		fundingImpl.setAge(age);

		if (earningStatus == null) {
			fundingImpl.setEarningStatus(StringPool.BLANK);
		}
		else {
			fundingImpl.setEarningStatus(earningStatus);
		}

		if (salaryOperator == null) {
			fundingImpl.setSalaryOperator(StringPool.BLANK);
		}
		else {
			fundingImpl.setSalaryOperator(salaryOperator);
		}

		fundingImpl.setSalary(salary);

		if (fundingHour == null) {
			fundingImpl.setFundingHour(StringPool.BLANK);
		}
		else {
			fundingImpl.setFundingHour(fundingHour);
		}

		fundingImpl.setFundingAmount(fundingAmount);
		fundingImpl.setNetFees(netFees);

		if (absenteePayroll == null) {
			fundingImpl.setAbsenteePayroll(StringPool.BLANK);
		}
		else {
			fundingImpl.setAbsenteePayroll(absenteePayroll);
		}

		if (fundingCourseFee == null) {
			fundingImpl.setFundingCourseFee(StringPool.BLANK);
		}
		else {
			fundingImpl.setFundingCourseFee(fundingCourseFee);
		}

		fundingImpl.setSpCourseId(spCourseId);

		fundingImpl.resetOriginalValues();

		return fundingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spFundingId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		courseType = objectInput.readLong();
		fundingDesc = objectInput.readUTF();
		fundingCriteria = objectInput.readUTF();
		fundOrder = objectInput.readLong();
		sponsoredBy = objectInput.readLong();
		residenceStatus = objectInput.readUTF();
		ageOperator = objectInput.readUTF();
		age = objectInput.readDouble();
		earningStatus = objectInput.readUTF();
		salaryOperator = objectInput.readUTF();
		salary = objectInput.readDouble();
		fundingHour = objectInput.readUTF();
		fundingAmount = objectInput.readDouble();
		netFees = objectInput.readDouble();
		absenteePayroll = objectInput.readUTF();
		fundingCourseFee = objectInput.readUTF();
		spCourseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spFundingId);
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
		objectOutput.writeLong(courseType);

		if (fundingDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fundingDesc);
		}

		if (fundingCriteria == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fundingCriteria);
		}

		objectOutput.writeLong(fundOrder);
		objectOutput.writeLong(sponsoredBy);

		if (residenceStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(residenceStatus);
		}

		if (ageOperator == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ageOperator);
		}

		objectOutput.writeDouble(age);

		if (earningStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(earningStatus);
		}

		if (salaryOperator == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(salaryOperator);
		}

		objectOutput.writeDouble(salary);

		if (fundingHour == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fundingHour);
		}

		objectOutput.writeDouble(fundingAmount);
		objectOutput.writeDouble(netFees);

		if (absenteePayroll == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(absenteePayroll);
		}

		if (fundingCourseFee == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fundingCourseFee);
		}

		objectOutput.writeLong(spCourseId);
	}

	public long spFundingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long courseType;
	public String fundingDesc;
	public String fundingCriteria;
	public long fundOrder;
	public long sponsoredBy;
	public String residenceStatus;
	public String ageOperator;
	public double age;
	public String earningStatus;
	public String salaryOperator;
	public double salary;
	public String fundingHour;
	public double fundingAmount;
	public double netFees;
	public String absenteePayroll;
	public String fundingCourseFee;
	public long spCourseId;
}