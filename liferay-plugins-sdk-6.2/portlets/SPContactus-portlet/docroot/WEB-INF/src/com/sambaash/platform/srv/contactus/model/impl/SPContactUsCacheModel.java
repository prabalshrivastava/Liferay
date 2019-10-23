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

package com.sambaash.platform.srv.contactus.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.contactus.model.SPContactUs;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPContactUs in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPContactUs
 * @generated
 */
public class SPContactUsCacheModel implements CacheModel<SPContactUs>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{spContactUsId=");
		sb.append(spContactUsId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", category=");
		sb.append(category);
		sb.append(", comment=");
		sb.append(comment);
		sb.append(", countryName=");
		sb.append(countryName);
		sb.append(", contactNumber=");
		sb.append(contactNumber);
		sb.append(", company=");
		sb.append(company);
		sb.append(", jobTitle=");
		sb.append(jobTitle);
		sb.append(", companyUrl=");
		sb.append(companyUrl);
		sb.append(", noOfEmployee=");
		sb.append(noOfEmployee);
		sb.append(", rate=");
		sb.append(rate);
		sb.append(", typeOfEnquiry=");
		sb.append(typeOfEnquiry);
		sb.append(", location=");
		sb.append(location);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPContactUs toEntityModel() {
		SPContactUsImpl spContactUsImpl = new SPContactUsImpl();

		spContactUsImpl.setSpContactUsId(spContactUsId);
		spContactUsImpl.setGroupId(groupId);
		spContactUsImpl.setCompanyId(companyId);
		spContactUsImpl.setUserId(userId);

		if (userName == null) {
			spContactUsImpl.setUserName(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spContactUsImpl.setCreateDate(null);
		}
		else {
			spContactUsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spContactUsImpl.setModifiedDate(null);
		}
		else {
			spContactUsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			spContactUsImpl.setName(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setName(name);
		}

		if (lastName == null) {
			spContactUsImpl.setLastName(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setLastName(lastName);
		}

		if (emailAddress == null) {
			spContactUsImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setEmailAddress(emailAddress);
		}

		if (category == null) {
			spContactUsImpl.setCategory(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setCategory(category);
		}

		if (comment == null) {
			spContactUsImpl.setComment(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setComment(comment);
		}

		if (countryName == null) {
			spContactUsImpl.setCountryName(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setCountryName(countryName);
		}

		spContactUsImpl.setContactNumber(contactNumber);

		if (company == null) {
			spContactUsImpl.setCompany(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setCompany(company);
		}

		if (jobTitle == null) {
			spContactUsImpl.setJobTitle(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setJobTitle(jobTitle);
		}

		if (companyUrl == null) {
			spContactUsImpl.setCompanyUrl(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setCompanyUrl(companyUrl);
		}

		spContactUsImpl.setNoOfEmployee(noOfEmployee);

		if (rate == null) {
			spContactUsImpl.setRate(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setRate(rate);
		}

		if (typeOfEnquiry == null) {
			spContactUsImpl.setTypeOfEnquiry(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setTypeOfEnquiry(typeOfEnquiry);
		}

		if (location == null) {
			spContactUsImpl.setLocation(StringPool.BLANK);
		}
		else {
			spContactUsImpl.setLocation(location);
		}

		spContactUsImpl.resetOriginalValues();

		return spContactUsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spContactUsId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		lastName = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		category = objectInput.readUTF();
		comment = objectInput.readUTF();
		countryName = objectInput.readUTF();
		contactNumber = objectInput.readLong();
		company = objectInput.readUTF();
		jobTitle = objectInput.readUTF();
		companyUrl = objectInput.readUTF();
		noOfEmployee = objectInput.readLong();
		rate = objectInput.readUTF();
		typeOfEnquiry = objectInput.readUTF();
		location = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spContactUsId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
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

		if (category == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(category);
		}

		if (comment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(comment);
		}

		if (countryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryName);
		}

		objectOutput.writeLong(contactNumber);

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (jobTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(jobTitle);
		}

		if (companyUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(companyUrl);
		}

		objectOutput.writeLong(noOfEmployee);

		if (rate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(rate);
		}

		if (typeOfEnquiry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeOfEnquiry);
		}

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}
	}

	public long spContactUsId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String lastName;
	public String emailAddress;
	public String category;
	public String comment;
	public String countryName;
	public long contactNumber;
	public String company;
	public String jobTitle;
	public String companyUrl;
	public long noOfEmployee;
	public String rate;
	public String typeOfEnquiry;
	public String location;
}