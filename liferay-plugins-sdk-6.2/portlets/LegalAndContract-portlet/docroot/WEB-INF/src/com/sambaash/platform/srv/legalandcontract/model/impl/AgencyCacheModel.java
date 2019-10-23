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

package com.sambaash.platform.srv.legalandcontract.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.legalandcontract.model.Agency;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Agency in entity cache.
 *
 * @author nareshchebolu
 * @see Agency
 * @generated
 */
public class AgencyCacheModel implements CacheModel<Agency>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(51);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spAgencyId=");
		sb.append(spAgencyId);
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
		sb.append(", number=");
		sb.append(number);
		sb.append(", country=");
		sb.append(country);
		sb.append(", name=");
		sb.append(name);
		sb.append(", reference=");
		sb.append(reference);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", address=");
		sb.append(address);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", status=");
		sb.append(status);
		sb.append(", customField1=");
		sb.append(customField1);
		sb.append(", customField2=");
		sb.append(customField2);
		sb.append(", customField3=");
		sb.append(customField3);
		sb.append(", customDate1=");
		sb.append(customDate1);
		sb.append(", customDate2=");
		sb.append(customDate2);
		sb.append(", customDate3=");
		sb.append(customDate3);
		sb.append(", version=");
		sb.append(version);
		sb.append(", rootSpAgencyId=");
		sb.append(rootSpAgencyId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Agency toEntityModel() {
		AgencyImpl agencyImpl = new AgencyImpl();

		if (uuid == null) {
			agencyImpl.setUuid(StringPool.BLANK);
		}
		else {
			agencyImpl.setUuid(uuid);
		}

		agencyImpl.setSpAgencyId(spAgencyId);
		agencyImpl.setGroupId(groupId);
		agencyImpl.setCompanyId(companyId);
		agencyImpl.setUserId(userId);

		if (userName == null) {
			agencyImpl.setUserName(StringPool.BLANK);
		}
		else {
			agencyImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			agencyImpl.setCreateDate(null);
		}
		else {
			agencyImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			agencyImpl.setModifiedDate(null);
		}
		else {
			agencyImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (number == null) {
			agencyImpl.setNumber(StringPool.BLANK);
		}
		else {
			agencyImpl.setNumber(number);
		}

		if (country == null) {
			agencyImpl.setCountry(StringPool.BLANK);
		}
		else {
			agencyImpl.setCountry(country);
		}

		if (name == null) {
			agencyImpl.setName(StringPool.BLANK);
		}
		else {
			agencyImpl.setName(name);
		}

		if (reference == null) {
			agencyImpl.setReference(StringPool.BLANK);
		}
		else {
			agencyImpl.setReference(reference);
		}

		if (startDate == null) {
			agencyImpl.setStartDate(StringPool.BLANK);
		}
		else {
			agencyImpl.setStartDate(startDate);
		}

		if (endDate == null) {
			agencyImpl.setEndDate(StringPool.BLANK);
		}
		else {
			agencyImpl.setEndDate(endDate);
		}

		if (address == null) {
			agencyImpl.setAddress(StringPool.BLANK);
		}
		else {
			agencyImpl.setAddress(address);
		}

		if (remarks == null) {
			agencyImpl.setRemarks(StringPool.BLANK);
		}
		else {
			agencyImpl.setRemarks(remarks);
		}

		if (status == null) {
			agencyImpl.setStatus(StringPool.BLANK);
		}
		else {
			agencyImpl.setStatus(status);
		}

		if (customField1 == null) {
			agencyImpl.setCustomField1(StringPool.BLANK);
		}
		else {
			agencyImpl.setCustomField1(customField1);
		}

		if (customField2 == null) {
			agencyImpl.setCustomField2(StringPool.BLANK);
		}
		else {
			agencyImpl.setCustomField2(customField2);
		}

		if (customField3 == null) {
			agencyImpl.setCustomField3(StringPool.BLANK);
		}
		else {
			agencyImpl.setCustomField3(customField3);
		}

		if (customDate1 == Long.MIN_VALUE) {
			agencyImpl.setCustomDate1(null);
		}
		else {
			agencyImpl.setCustomDate1(new Date(customDate1));
		}

		if (customDate2 == Long.MIN_VALUE) {
			agencyImpl.setCustomDate2(null);
		}
		else {
			agencyImpl.setCustomDate2(new Date(customDate2));
		}

		if (customDate3 == Long.MIN_VALUE) {
			agencyImpl.setCustomDate3(null);
		}
		else {
			agencyImpl.setCustomDate3(new Date(customDate3));
		}

		if (version == null) {
			agencyImpl.setVersion(StringPool.BLANK);
		}
		else {
			agencyImpl.setVersion(version);
		}

		agencyImpl.setRootSpAgencyId(rootSpAgencyId);

		agencyImpl.resetOriginalValues();

		return agencyImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spAgencyId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		number = objectInput.readUTF();
		country = objectInput.readUTF();
		name = objectInput.readUTF();
		reference = objectInput.readUTF();
		startDate = objectInput.readUTF();
		endDate = objectInput.readUTF();
		address = objectInput.readUTF();
		remarks = objectInput.readUTF();
		status = objectInput.readUTF();
		customField1 = objectInput.readUTF();
		customField2 = objectInput.readUTF();
		customField3 = objectInput.readUTF();
		customDate1 = objectInput.readLong();
		customDate2 = objectInput.readLong();
		customDate3 = objectInput.readLong();
		version = objectInput.readUTF();
		rootSpAgencyId = objectInput.readLong();
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

		objectOutput.writeLong(spAgencyId);
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

		if (number == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(number);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (reference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(reference);
		}

		if (startDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(startDate);
		}

		if (endDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(endDate);
		}

		if (address == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(address);
		}

		if (remarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (customField1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField1);
		}

		if (customField2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField2);
		}

		if (customField3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(customField3);
		}

		objectOutput.writeLong(customDate1);
		objectOutput.writeLong(customDate2);
		objectOutput.writeLong(customDate3);

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeLong(rootSpAgencyId);
	}

	public String uuid;
	public long spAgencyId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String number;
	public String country;
	public String name;
	public String reference;
	public String startDate;
	public String endDate;
	public String address;
	public String remarks;
	public String status;
	public String customField1;
	public String customField2;
	public String customField3;
	public long customDate1;
	public long customDate2;
	public long customDate3;
	public String version;
	public long rootSpAgencyId;
}