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

package com.sambaash.platform.srv.rsvp.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.rsvp.model.RsvpDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RsvpDetail in entity cache.
 *
 * @author gauravvijayvergia
 * @see RsvpDetail
 * @generated
 */
public class RsvpDetailCacheModel implements CacheModel<RsvpDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rsvpDetailId=");
		sb.append(rsvpDetailId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", rsvpId=");
		sb.append(rsvpId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", identifiactionType=");
		sb.append(identifiactionType);
		sb.append(", nric=");
		sb.append(nric);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", rsvpStatus=");
		sb.append(rsvpStatus);
		sb.append(", source=");
		sb.append(source);
		sb.append(", attendance=");
		sb.append(attendance);
		sb.append(", attendanceBy=");
		sb.append(attendanceBy);
		sb.append(", attendanceDate=");
		sb.append(attendanceDate);
		sb.append(", rsvpStatusDate=");
		sb.append(rsvpStatusDate);
		sb.append(", rsvpStatusBy=");
		sb.append(rsvpStatusBy);
		sb.append(", numberOfPeople=");
		sb.append(numberOfPeople);
		sb.append(", streetAddress1=");
		sb.append(streetAddress1);
		sb.append(", streetAddress2=");
		sb.append(streetAddress2);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", city=");
		sb.append(city);
		sb.append(", country=");
		sb.append(country);
		sb.append(", state=");
		sb.append(state);
		sb.append(", gender=");
		sb.append(gender);
		sb.append(", phoneNumber1=");
		sb.append(phoneNumber1);
		sb.append(", phoneNumber2=");
		sb.append(phoneNumber2);
		sb.append(", hearAboutUs=");
		sb.append(hearAboutUs);
		sb.append(", attendedWebinar=");
		sb.append(attendedWebinar);
		sb.append(", ageGroup=");
		sb.append(ageGroup);
		sb.append(", termsOfUse=");
		sb.append(termsOfUse);
		sb.append(", ageRestriction=");
		sb.append(ageRestriction);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RsvpDetail toEntityModel() {
		RsvpDetailImpl rsvpDetailImpl = new RsvpDetailImpl();

		if (uuid == null) {
			rsvpDetailImpl.setUuid(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setUuid(uuid);
		}

		rsvpDetailImpl.setRsvpDetailId(rsvpDetailId);
		rsvpDetailImpl.setGroupId(groupId);
		rsvpDetailImpl.setCompanyId(companyId);

		if (userName == null) {
			rsvpDetailImpl.setUserName(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rsvpDetailImpl.setCreateDate(null);
		}
		else {
			rsvpDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rsvpDetailImpl.setModifiedDate(null);
		}
		else {
			rsvpDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		rsvpDetailImpl.setRsvpId(rsvpId);
		rsvpDetailImpl.setUserId(userId);

		if (firstName == null) {
			rsvpDetailImpl.setFirstName(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			rsvpDetailImpl.setLastName(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setLastName(lastName);
		}

		if (identifiactionType == null) {
			rsvpDetailImpl.setIdentifiactionType(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setIdentifiactionType(identifiactionType);
		}

		if (nric == null) {
			rsvpDetailImpl.setNric(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setNric(nric);
		}

		if (emailAddress == null) {
			rsvpDetailImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setEmailAddress(emailAddress);
		}

		rsvpDetailImpl.setRsvpStatus(rsvpStatus);
		rsvpDetailImpl.setSource(source);
		rsvpDetailImpl.setAttendance(attendance);
		rsvpDetailImpl.setAttendanceBy(attendanceBy);

		if (attendanceDate == Long.MIN_VALUE) {
			rsvpDetailImpl.setAttendanceDate(null);
		}
		else {
			rsvpDetailImpl.setAttendanceDate(new Date(attendanceDate));
		}

		if (rsvpStatusDate == Long.MIN_VALUE) {
			rsvpDetailImpl.setRsvpStatusDate(null);
		}
		else {
			rsvpDetailImpl.setRsvpStatusDate(new Date(rsvpStatusDate));
		}

		rsvpDetailImpl.setRsvpStatusBy(rsvpStatusBy);
		rsvpDetailImpl.setNumberOfPeople(numberOfPeople);

		if (streetAddress1 == null) {
			rsvpDetailImpl.setStreetAddress1(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setStreetAddress1(streetAddress1);
		}

		if (streetAddress2 == null) {
			rsvpDetailImpl.setStreetAddress2(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setStreetAddress2(streetAddress2);
		}

		if (postalCode == null) {
			rsvpDetailImpl.setPostalCode(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setPostalCode(postalCode);
		}

		if (city == null) {
			rsvpDetailImpl.setCity(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setCity(city);
		}

		if (country == null) {
			rsvpDetailImpl.setCountry(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setCountry(country);
		}

		if (state == null) {
			rsvpDetailImpl.setState(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setState(state);
		}

		if (gender == null) {
			rsvpDetailImpl.setGender(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setGender(gender);
		}

		if (phoneNumber1 == null) {
			rsvpDetailImpl.setPhoneNumber1(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setPhoneNumber1(phoneNumber1);
		}

		if (phoneNumber2 == null) {
			rsvpDetailImpl.setPhoneNumber2(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setPhoneNumber2(phoneNumber2);
		}

		if (hearAboutUs == null) {
			rsvpDetailImpl.setHearAboutUs(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setHearAboutUs(hearAboutUs);
		}

		if (attendedWebinar == null) {
			rsvpDetailImpl.setAttendedWebinar(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setAttendedWebinar(attendedWebinar);
		}

		if (ageGroup == null) {
			rsvpDetailImpl.setAgeGroup(StringPool.BLANK);
		}
		else {
			rsvpDetailImpl.setAgeGroup(ageGroup);
		}

		rsvpDetailImpl.setTermsOfUse(termsOfUse);
		rsvpDetailImpl.setAgeRestriction(ageRestriction);

		rsvpDetailImpl.resetOriginalValues();

		return rsvpDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		rsvpDetailId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		rsvpId = objectInput.readLong();
		userId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		identifiactionType = objectInput.readUTF();
		nric = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		rsvpStatus = objectInput.readInt();
		source = objectInput.readInt();
		attendance = objectInput.readInt();
		attendanceBy = objectInput.readLong();
		attendanceDate = objectInput.readLong();
		rsvpStatusDate = objectInput.readLong();
		rsvpStatusBy = objectInput.readLong();
		numberOfPeople = objectInput.readInt();
		streetAddress1 = objectInput.readUTF();
		streetAddress2 = objectInput.readUTF();
		postalCode = objectInput.readUTF();
		city = objectInput.readUTF();
		country = objectInput.readUTF();
		state = objectInput.readUTF();
		gender = objectInput.readUTF();
		phoneNumber1 = objectInput.readUTF();
		phoneNumber2 = objectInput.readUTF();
		hearAboutUs = objectInput.readUTF();
		attendedWebinar = objectInput.readUTF();
		ageGroup = objectInput.readUTF();
		termsOfUse = objectInput.readBoolean();
		ageRestriction = objectInput.readBoolean();
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

		objectOutput.writeLong(rsvpDetailId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(rsvpId);
		objectOutput.writeLong(userId);

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

		if (identifiactionType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(identifiactionType);
		}

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

		objectOutput.writeInt(rsvpStatus);
		objectOutput.writeInt(source);
		objectOutput.writeInt(attendance);
		objectOutput.writeLong(attendanceBy);
		objectOutput.writeLong(attendanceDate);
		objectOutput.writeLong(rsvpStatusDate);
		objectOutput.writeLong(rsvpStatusBy);
		objectOutput.writeInt(numberOfPeople);

		if (streetAddress1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(streetAddress1);
		}

		if (streetAddress2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(streetAddress2);
		}

		if (postalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (state == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(state);
		}

		if (gender == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(gender);
		}

		if (phoneNumber1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber1);
		}

		if (phoneNumber2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(phoneNumber2);
		}

		if (hearAboutUs == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(hearAboutUs);
		}

		if (attendedWebinar == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(attendedWebinar);
		}

		if (ageGroup == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ageGroup);
		}

		objectOutput.writeBoolean(termsOfUse);
		objectOutput.writeBoolean(ageRestriction);
	}

	public String uuid;
	public long rsvpDetailId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long rsvpId;
	public long userId;
	public String firstName;
	public String lastName;
	public String identifiactionType;
	public String nric;
	public String emailAddress;
	public int rsvpStatus;
	public int source;
	public int attendance;
	public long attendanceBy;
	public long attendanceDate;
	public long rsvpStatusDate;
	public long rsvpStatusBy;
	public int numberOfPeople;
	public String streetAddress1;
	public String streetAddress2;
	public String postalCode;
	public String city;
	public String country;
	public String state;
	public String gender;
	public String phoneNumber1;
	public String phoneNumber2;
	public String hearAboutUs;
	public String attendedWebinar;
	public String ageGroup;
	public boolean termsOfUse;
	public boolean ageRestriction;
}