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

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.startupprofile.model.ReAccreditation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ReAccreditation in entity cache.
 *
 * @author pradeep
 * @see ReAccreditation
 * @generated
 */
public class ReAccreditationCacheModel implements CacheModel<ReAccreditation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", accreditationId=");
		sb.append(accreditationId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", accreditationStatus=");
		sb.append(accreditationStatus);
		sb.append(", dateOfAccreditation=");
		sb.append(dateOfAccreditation);
		sb.append(", dateOfExpiry=");
		sb.append(dateOfExpiry);
		sb.append(", latestPaymentDate=");
		sb.append(latestPaymentDate);
		sb.append(", startDateOfReaccreditation=");
		sb.append(startDateOfReaccreditation);
		sb.append(", dateOfReaccdtReview=");
		sb.append(dateOfReaccdtReview);
		sb.append(", AccreditationBy=");
		sb.append(AccreditationBy);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ReAccreditation toEntityModel() {
		ReAccreditationImpl reAccreditationImpl = new ReAccreditationImpl();

		if (uuid == null) {
			reAccreditationImpl.setUuid(StringPool.BLANK);
		}
		else {
			reAccreditationImpl.setUuid(uuid);
		}

		reAccreditationImpl.setAccreditationId(accreditationId);
		reAccreditationImpl.setOrganizationId(organizationId);

		if (accreditationStatus == null) {
			reAccreditationImpl.setAccreditationStatus(StringPool.BLANK);
		}
		else {
			reAccreditationImpl.setAccreditationStatus(accreditationStatus);
		}

		if (dateOfAccreditation == Long.MIN_VALUE) {
			reAccreditationImpl.setDateOfAccreditation(null);
		}
		else {
			reAccreditationImpl.setDateOfAccreditation(new Date(
					dateOfAccreditation));
		}

		if (dateOfExpiry == Long.MIN_VALUE) {
			reAccreditationImpl.setDateOfExpiry(null);
		}
		else {
			reAccreditationImpl.setDateOfExpiry(new Date(dateOfExpiry));
		}

		if (latestPaymentDate == Long.MIN_VALUE) {
			reAccreditationImpl.setLatestPaymentDate(null);
		}
		else {
			reAccreditationImpl.setLatestPaymentDate(new Date(latestPaymentDate));
		}

		if (startDateOfReaccreditation == Long.MIN_VALUE) {
			reAccreditationImpl.setStartDateOfReaccreditation(null);
		}
		else {
			reAccreditationImpl.setStartDateOfReaccreditation(new Date(
					startDateOfReaccreditation));
		}

		if (dateOfReaccdtReview == Long.MIN_VALUE) {
			reAccreditationImpl.setDateOfReaccdtReview(null);
		}
		else {
			reAccreditationImpl.setDateOfReaccdtReview(new Date(
					dateOfReaccdtReview));
		}

		if (AccreditationBy == null) {
			reAccreditationImpl.setAccreditationBy(StringPool.BLANK);
		}
		else {
			reAccreditationImpl.setAccreditationBy(AccreditationBy);
		}

		reAccreditationImpl.resetOriginalValues();

		return reAccreditationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		accreditationId = objectInput.readLong();
		organizationId = objectInput.readLong();
		accreditationStatus = objectInput.readUTF();
		dateOfAccreditation = objectInput.readLong();
		dateOfExpiry = objectInput.readLong();
		latestPaymentDate = objectInput.readLong();
		startDateOfReaccreditation = objectInput.readLong();
		dateOfReaccdtReview = objectInput.readLong();
		AccreditationBy = objectInput.readUTF();
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

		objectOutput.writeLong(accreditationId);
		objectOutput.writeLong(organizationId);

		if (accreditationStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(accreditationStatus);
		}

		objectOutput.writeLong(dateOfAccreditation);
		objectOutput.writeLong(dateOfExpiry);
		objectOutput.writeLong(latestPaymentDate);
		objectOutput.writeLong(startDateOfReaccreditation);
		objectOutput.writeLong(dateOfReaccdtReview);

		if (AccreditationBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(AccreditationBy);
		}
	}

	public String uuid;
	public long accreditationId;
	public long organizationId;
	public String accreditationStatus;
	public long dateOfAccreditation;
	public long dateOfExpiry;
	public long latestPaymentDate;
	public long startDateOfReaccreditation;
	public long dateOfReaccdtReview;
	public String AccreditationBy;
}