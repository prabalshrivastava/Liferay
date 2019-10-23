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

import com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RsvpCoParticipantDetail in entity cache.
 *
 * @author gauravvijayvergia
 * @see RsvpCoParticipantDetail
 * @generated
 */
public class RsvpCoParticipantDetailCacheModel implements CacheModel<RsvpCoParticipantDetail>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", rsvpCoParticipantDetailId=");
		sb.append(rsvpCoParticipantDetailId);
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
		sb.append(", rsvpDetailId=");
		sb.append(rsvpDetailId);
		sb.append(", rsvpPaymentId=");
		sb.append(rsvpPaymentId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", nric=");
		sb.append(nric);
		sb.append(", identificationType=");
		sb.append(identificationType);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", rsvpStatus=");
		sb.append(rsvpStatus);
		sb.append(", attendance=");
		sb.append(attendance);
		sb.append(", attendanceBy=");
		sb.append(attendanceBy);
		sb.append(", attendanceDate=");
		sb.append(attendanceDate);
		sb.append(", ticketNumber=");
		sb.append(ticketNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RsvpCoParticipantDetail toEntityModel() {
		RsvpCoParticipantDetailImpl rsvpCoParticipantDetailImpl = new RsvpCoParticipantDetailImpl();

		if (uuid == null) {
			rsvpCoParticipantDetailImpl.setUuid(StringPool.BLANK);
		}
		else {
			rsvpCoParticipantDetailImpl.setUuid(uuid);
		}

		rsvpCoParticipantDetailImpl.setRsvpCoParticipantDetailId(rsvpCoParticipantDetailId);
		rsvpCoParticipantDetailImpl.setGroupId(groupId);
		rsvpCoParticipantDetailImpl.setCompanyId(companyId);

		if (userName == null) {
			rsvpCoParticipantDetailImpl.setUserName(StringPool.BLANK);
		}
		else {
			rsvpCoParticipantDetailImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rsvpCoParticipantDetailImpl.setCreateDate(null);
		}
		else {
			rsvpCoParticipantDetailImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rsvpCoParticipantDetailImpl.setModifiedDate(null);
		}
		else {
			rsvpCoParticipantDetailImpl.setModifiedDate(new Date(modifiedDate));
		}

		rsvpCoParticipantDetailImpl.setRsvpDetailId(rsvpDetailId);
		rsvpCoParticipantDetailImpl.setRsvpPaymentId(rsvpPaymentId);
		rsvpCoParticipantDetailImpl.setUserId(userId);

		if (firstName == null) {
			rsvpCoParticipantDetailImpl.setFirstName(StringPool.BLANK);
		}
		else {
			rsvpCoParticipantDetailImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			rsvpCoParticipantDetailImpl.setLastName(StringPool.BLANK);
		}
		else {
			rsvpCoParticipantDetailImpl.setLastName(lastName);
		}

		if (nric == null) {
			rsvpCoParticipantDetailImpl.setNric(StringPool.BLANK);
		}
		else {
			rsvpCoParticipantDetailImpl.setNric(nric);
		}

		if (identificationType == null) {
			rsvpCoParticipantDetailImpl.setIdentificationType(StringPool.BLANK);
		}
		else {
			rsvpCoParticipantDetailImpl.setIdentificationType(identificationType);
		}

		if (emailAddress == null) {
			rsvpCoParticipantDetailImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			rsvpCoParticipantDetailImpl.setEmailAddress(emailAddress);
		}

		rsvpCoParticipantDetailImpl.setRsvpStatus(rsvpStatus);
		rsvpCoParticipantDetailImpl.setAttendance(attendance);
		rsvpCoParticipantDetailImpl.setAttendanceBy(attendanceBy);

		if (attendanceDate == Long.MIN_VALUE) {
			rsvpCoParticipantDetailImpl.setAttendanceDate(null);
		}
		else {
			rsvpCoParticipantDetailImpl.setAttendanceDate(new Date(
					attendanceDate));
		}

		if (ticketNumber == null) {
			rsvpCoParticipantDetailImpl.setTicketNumber(StringPool.BLANK);
		}
		else {
			rsvpCoParticipantDetailImpl.setTicketNumber(ticketNumber);
		}

		rsvpCoParticipantDetailImpl.resetOriginalValues();

		return rsvpCoParticipantDetailImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		rsvpCoParticipantDetailId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		rsvpDetailId = objectInput.readLong();
		rsvpPaymentId = objectInput.readLong();
		userId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		nric = objectInput.readUTF();
		identificationType = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		rsvpStatus = objectInput.readInt();
		attendance = objectInput.readInt();
		attendanceBy = objectInput.readLong();
		attendanceDate = objectInput.readLong();
		ticketNumber = objectInput.readUTF();
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

		objectOutput.writeLong(rsvpCoParticipantDetailId);
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
		objectOutput.writeLong(rsvpDetailId);
		objectOutput.writeLong(rsvpPaymentId);
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

		if (nric == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(nric);
		}

		if (identificationType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(identificationType);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeInt(rsvpStatus);
		objectOutput.writeInt(attendance);
		objectOutput.writeLong(attendanceBy);
		objectOutput.writeLong(attendanceDate);

		if (ticketNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ticketNumber);
		}
	}

	public String uuid;
	public long rsvpCoParticipantDetailId;
	public long groupId;
	public long companyId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long rsvpDetailId;
	public long rsvpPaymentId;
	public long userId;
	public String firstName;
	public String lastName;
	public String nric;
	public String identificationType;
	public String emailAddress;
	public int rsvpStatus;
	public int attendance;
	public long attendanceBy;
	public long attendanceDate;
	public String ticketNumber;
}