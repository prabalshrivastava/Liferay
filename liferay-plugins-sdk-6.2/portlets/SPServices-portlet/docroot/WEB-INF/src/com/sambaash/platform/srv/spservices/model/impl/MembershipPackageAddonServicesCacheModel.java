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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.MembershipPackageAddonServices;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MembershipPackageAddonServices in entity cache.
 *
 * @author gauravvijayvergia
 * @see MembershipPackageAddonServices
 * @generated
 */
public class MembershipPackageAddonServicesCacheModel implements CacheModel<MembershipPackageAddonServices>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{mpAddonId=");
		sb.append(mpAddonId);
		sb.append(", scId=");
		sb.append(scId);
		sb.append(", scName=");
		sb.append(scName);
		sb.append(", paramType=");
		sb.append(paramType);
		sb.append(", paramFrom=");
		sb.append(paramFrom);
		sb.append(", paramUpto=");
		sb.append(paramUpto);
		sb.append(", duration=");
		sb.append(duration);
		sb.append(", durationType=");
		sb.append(durationType);
		sb.append(", serviceCharges=");
		sb.append(serviceCharges);
		sb.append(", serviceChargesCurrency=");
		sb.append(serviceChargesCurrency);
		sb.append(", serviceChargesPeriod=");
		sb.append(serviceChargesPeriod);
		sb.append(", serviceChargesPeriodType=");
		sb.append(serviceChargesPeriodType);
		sb.append(", status=");
		sb.append(status);
		sb.append(", description=");
		sb.append(description);
		sb.append(", dateAdded=");
		sb.append(dateAdded);
		sb.append(", dateModified=");
		sb.append(dateModified);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
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
		sb.append(", extra6=");
		sb.append(extra6);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MembershipPackageAddonServices toEntityModel() {
		MembershipPackageAddonServicesImpl membershipPackageAddonServicesImpl = new MembershipPackageAddonServicesImpl();

		membershipPackageAddonServicesImpl.setMpAddonId(mpAddonId);

		if (scId == null) {
			membershipPackageAddonServicesImpl.setScId(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setScId(scId);
		}

		if (scName == null) {
			membershipPackageAddonServicesImpl.setScName(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setScName(scName);
		}

		if (paramType == null) {
			membershipPackageAddonServicesImpl.setParamType(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setParamType(paramType);
		}

		if (paramFrom == null) {
			membershipPackageAddonServicesImpl.setParamFrom(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setParamFrom(paramFrom);
		}

		if (paramUpto == null) {
			membershipPackageAddonServicesImpl.setParamUpto(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setParamUpto(paramUpto);
		}

		if (duration == null) {
			membershipPackageAddonServicesImpl.setDuration(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setDuration(duration);
		}

		if (durationType == null) {
			membershipPackageAddonServicesImpl.setDurationType(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setDurationType(durationType);
		}

		membershipPackageAddonServicesImpl.setServiceCharges(serviceCharges);

		if (serviceChargesCurrency == null) {
			membershipPackageAddonServicesImpl.setServiceChargesCurrency(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setServiceChargesCurrency(serviceChargesCurrency);
		}

		if (serviceChargesPeriod == null) {
			membershipPackageAddonServicesImpl.setServiceChargesPeriod(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setServiceChargesPeriod(serviceChargesPeriod);
		}

		if (serviceChargesPeriodType == null) {
			membershipPackageAddonServicesImpl.setServiceChargesPeriodType(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setServiceChargesPeriodType(serviceChargesPeriodType);
		}

		if (status == null) {
			membershipPackageAddonServicesImpl.setStatus(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setStatus(status);
		}

		if (description == null) {
			membershipPackageAddonServicesImpl.setDescription(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setDescription(description);
		}

		if (dateAdded == Long.MIN_VALUE) {
			membershipPackageAddonServicesImpl.setDateAdded(null);
		}
		else {
			membershipPackageAddonServicesImpl.setDateAdded(new Date(dateAdded));
		}

		if (dateModified == Long.MIN_VALUE) {
			membershipPackageAddonServicesImpl.setDateModified(null);
		}
		else {
			membershipPackageAddonServicesImpl.setDateModified(new Date(
					dateModified));
		}

		if (createdBy == null) {
			membershipPackageAddonServicesImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			membershipPackageAddonServicesImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setModifiedBy(modifiedBy);
		}

		if (extra1 == null) {
			membershipPackageAddonServicesImpl.setExtra1(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			membershipPackageAddonServicesImpl.setExtra2(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			membershipPackageAddonServicesImpl.setExtra3(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			membershipPackageAddonServicesImpl.setExtra4(StringPool.BLANK);
		}
		else {
			membershipPackageAddonServicesImpl.setExtra4(extra4);
		}

		if (extra5 == Long.MIN_VALUE) {
			membershipPackageAddonServicesImpl.setExtra5(null);
		}
		else {
			membershipPackageAddonServicesImpl.setExtra5(new Date(extra5));
		}

		if (extra6 == Long.MIN_VALUE) {
			membershipPackageAddonServicesImpl.setExtra6(null);
		}
		else {
			membershipPackageAddonServicesImpl.setExtra6(new Date(extra6));
		}

		membershipPackageAddonServicesImpl.resetOriginalValues();

		return membershipPackageAddonServicesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mpAddonId = objectInput.readLong();
		scId = objectInput.readUTF();
		scName = objectInput.readUTF();
		paramType = objectInput.readUTF();
		paramFrom = objectInput.readUTF();
		paramUpto = objectInput.readUTF();
		duration = objectInput.readUTF();
		durationType = objectInput.readUTF();
		serviceCharges = objectInput.readFloat();
		serviceChargesCurrency = objectInput.readUTF();
		serviceChargesPeriod = objectInput.readUTF();
		serviceChargesPeriodType = objectInput.readUTF();
		status = objectInput.readUTF();
		description = objectInput.readUTF();
		dateAdded = objectInput.readLong();
		dateModified = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedBy = objectInput.readUTF();
		extra1 = objectInput.readUTF();
		extra2 = objectInput.readUTF();
		extra3 = objectInput.readUTF();
		extra4 = objectInput.readUTF();
		extra5 = objectInput.readLong();
		extra6 = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(mpAddonId);

		if (scId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scId);
		}

		if (scName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scName);
		}

		if (paramType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paramType);
		}

		if (paramFrom == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paramFrom);
		}

		if (paramUpto == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(paramUpto);
		}

		if (duration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(duration);
		}

		if (durationType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(durationType);
		}

		objectOutput.writeFloat(serviceCharges);

		if (serviceChargesCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceChargesCurrency);
		}

		if (serviceChargesPeriod == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceChargesPeriod);
		}

		if (serviceChargesPeriodType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(serviceChargesPeriodType);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		objectOutput.writeLong(dateAdded);
		objectOutput.writeLong(dateModified);

		if (createdBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createdBy);
		}

		if (modifiedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(modifiedBy);
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

		objectOutput.writeLong(extra5);
		objectOutput.writeLong(extra6);
	}

	public long mpAddonId;
	public String scId;
	public String scName;
	public String paramType;
	public String paramFrom;
	public String paramUpto;
	public String duration;
	public String durationType;
	public float serviceCharges;
	public String serviceChargesCurrency;
	public String serviceChargesPeriod;
	public String serviceChargesPeriodType;
	public String status;
	public String description;
	public long dateAdded;
	public long dateModified;
	public String createdBy;
	public String modifiedBy;
	public String extra1;
	public String extra2;
	public String extra3;
	public String extra4;
	public long extra5;
	public long extra6;
}