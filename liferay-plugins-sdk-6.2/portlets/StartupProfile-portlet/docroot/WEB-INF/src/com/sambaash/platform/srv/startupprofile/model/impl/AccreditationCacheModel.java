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

import com.sambaash.platform.srv.startupprofile.model.Accreditation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Accreditation in entity cache.
 *
 * @author pradeep
 * @see Accreditation
 * @generated
 */
public class AccreditationCacheModel implements CacheModel<Accreditation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", accreditationId=");
		sb.append(accreditationId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", aselected=");
		sb.append(aselected);
		sb.append(", avalue=");
		sb.append(avalue);
		sb.append(", bselected=");
		sb.append(bselected);
		sb.append(", bvalue=");
		sb.append(bvalue);
		sb.append(", cselected=");
		sb.append(cselected);
		sb.append(", cvalue=");
		sb.append(cvalue);
		sb.append(", ccompanyName=");
		sb.append(ccompanyName);
		sb.append(", csamepolicy=");
		sb.append(csamepolicy);
		sb.append(", celaborate=");
		sb.append(celaborate);
		sb.append(", dselected=");
		sb.append(dselected);
		sb.append(", dvalue=");
		sb.append(dvalue);
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
	public Accreditation toEntityModel() {
		AccreditationImpl accreditationImpl = new AccreditationImpl();

		if (uuid == null) {
			accreditationImpl.setUuid(StringPool.BLANK);
		}
		else {
			accreditationImpl.setUuid(uuid);
		}

		accreditationImpl.setAccreditationId(accreditationId);
		accreditationImpl.setOrganizationId(organizationId);
		accreditationImpl.setAselected(aselected);

		if (avalue == null) {
			accreditationImpl.setAvalue(StringPool.BLANK);
		}
		else {
			accreditationImpl.setAvalue(avalue);
		}

		accreditationImpl.setBselected(bselected);

		if (bvalue == null) {
			accreditationImpl.setBvalue(StringPool.BLANK);
		}
		else {
			accreditationImpl.setBvalue(bvalue);
		}

		accreditationImpl.setCselected(cselected);

		if (cvalue == null) {
			accreditationImpl.setCvalue(StringPool.BLANK);
		}
		else {
			accreditationImpl.setCvalue(cvalue);
		}

		if (ccompanyName == null) {
			accreditationImpl.setCcompanyName(StringPool.BLANK);
		}
		else {
			accreditationImpl.setCcompanyName(ccompanyName);
		}

		accreditationImpl.setCsamepolicy(csamepolicy);

		if (celaborate == null) {
			accreditationImpl.setCelaborate(StringPool.BLANK);
		}
		else {
			accreditationImpl.setCelaborate(celaborate);
		}

		accreditationImpl.setDselected(dselected);

		if (dvalue == null) {
			accreditationImpl.setDvalue(StringPool.BLANK);
		}
		else {
			accreditationImpl.setDvalue(dvalue);
		}

		if (accreditationStatus == null) {
			accreditationImpl.setAccreditationStatus(StringPool.BLANK);
		}
		else {
			accreditationImpl.setAccreditationStatus(accreditationStatus);
		}

		if (dateOfAccreditation == Long.MIN_VALUE) {
			accreditationImpl.setDateOfAccreditation(null);
		}
		else {
			accreditationImpl.setDateOfAccreditation(new Date(
					dateOfAccreditation));
		}

		if (dateOfExpiry == Long.MIN_VALUE) {
			accreditationImpl.setDateOfExpiry(null);
		}
		else {
			accreditationImpl.setDateOfExpiry(new Date(dateOfExpiry));
		}

		if (latestPaymentDate == Long.MIN_VALUE) {
			accreditationImpl.setLatestPaymentDate(null);
		}
		else {
			accreditationImpl.setLatestPaymentDate(new Date(latestPaymentDate));
		}

		if (startDateOfReaccreditation == Long.MIN_VALUE) {
			accreditationImpl.setStartDateOfReaccreditation(null);
		}
		else {
			accreditationImpl.setStartDateOfReaccreditation(new Date(
					startDateOfReaccreditation));
		}

		if (dateOfReaccdtReview == Long.MIN_VALUE) {
			accreditationImpl.setDateOfReaccdtReview(null);
		}
		else {
			accreditationImpl.setDateOfReaccdtReview(new Date(
					dateOfReaccdtReview));
		}

		if (AccreditationBy == null) {
			accreditationImpl.setAccreditationBy(StringPool.BLANK);
		}
		else {
			accreditationImpl.setAccreditationBy(AccreditationBy);
		}

		accreditationImpl.resetOriginalValues();

		return accreditationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		accreditationId = objectInput.readLong();
		organizationId = objectInput.readLong();
		aselected = objectInput.readBoolean();
		avalue = objectInput.readUTF();
		bselected = objectInput.readBoolean();
		bvalue = objectInput.readUTF();
		cselected = objectInput.readBoolean();
		cvalue = objectInput.readUTF();
		ccompanyName = objectInput.readUTF();
		csamepolicy = objectInput.readBoolean();
		celaborate = objectInput.readUTF();
		dselected = objectInput.readBoolean();
		dvalue = objectInput.readUTF();
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
		objectOutput.writeBoolean(aselected);

		if (avalue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(avalue);
		}

		objectOutput.writeBoolean(bselected);

		if (bvalue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(bvalue);
		}

		objectOutput.writeBoolean(cselected);

		if (cvalue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(cvalue);
		}

		if (ccompanyName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ccompanyName);
		}

		objectOutput.writeBoolean(csamepolicy);

		if (celaborate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(celaborate);
		}

		objectOutput.writeBoolean(dselected);

		if (dvalue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(dvalue);
		}

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
	public boolean aselected;
	public String avalue;
	public boolean bselected;
	public String bvalue;
	public boolean cselected;
	public String cvalue;
	public String ccompanyName;
	public boolean csamepolicy;
	public String celaborate;
	public boolean dselected;
	public String dvalue;
	public String accreditationStatus;
	public long dateOfAccreditation;
	public long dateOfExpiry;
	public long latestPaymentDate;
	public long startDateOfReaccreditation;
	public long dateOfReaccdtReview;
	public String AccreditationBy;
}