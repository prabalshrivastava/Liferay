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

import com.sambaash.platform.srv.spservices.model.MembershipSubscriptionAddonServices;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MembershipSubscriptionAddonServices in entity cache.
 *
 * @author gauravvijayvergia
 * @see MembershipSubscriptionAddonServices
 * @generated
 */
public class MembershipSubscriptionAddonServicesCacheModel implements CacheModel<MembershipSubscriptionAddonServices>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(55);

		sb.append("{msAddonId=");
		sb.append(msAddonId);
		sb.append(", msId=");
		sb.append(msId);
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
		sb.append(", effectiveFromDate=");
		sb.append(effectiveFromDate);
		sb.append(", effectiveToDate=");
		sb.append(effectiveToDate);
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
	public MembershipSubscriptionAddonServices toEntityModel() {
		MembershipSubscriptionAddonServicesImpl membershipSubscriptionAddonServicesImpl =
			new MembershipSubscriptionAddonServicesImpl();

		membershipSubscriptionAddonServicesImpl.setMsAddonId(msAddonId);
		membershipSubscriptionAddonServicesImpl.setMsId(msId);

		if (scId == null) {
			membershipSubscriptionAddonServicesImpl.setScId(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setScId(scId);
		}

		if (scName == null) {
			membershipSubscriptionAddonServicesImpl.setScName(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setScName(scName);
		}

		if (paramType == null) {
			membershipSubscriptionAddonServicesImpl.setParamType(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setParamType(paramType);
		}

		if (paramFrom == null) {
			membershipSubscriptionAddonServicesImpl.setParamFrom(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setParamFrom(paramFrom);
		}

		if (paramUpto == null) {
			membershipSubscriptionAddonServicesImpl.setParamUpto(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setParamUpto(paramUpto);
		}

		if (duration == null) {
			membershipSubscriptionAddonServicesImpl.setDuration(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setDuration(duration);
		}

		if (durationType == null) {
			membershipSubscriptionAddonServicesImpl.setDurationType(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setDurationType(durationType);
		}

		membershipSubscriptionAddonServicesImpl.setServiceCharges(serviceCharges);

		if (serviceChargesCurrency == null) {
			membershipSubscriptionAddonServicesImpl.setServiceChargesCurrency(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setServiceChargesCurrency(serviceChargesCurrency);
		}

		if (serviceChargesPeriod == null) {
			membershipSubscriptionAddonServicesImpl.setServiceChargesPeriod(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setServiceChargesPeriod(serviceChargesPeriod);
		}

		if (serviceChargesPeriodType == null) {
			membershipSubscriptionAddonServicesImpl.setServiceChargesPeriodType(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setServiceChargesPeriodType(serviceChargesPeriodType);
		}

		if (status == null) {
			membershipSubscriptionAddonServicesImpl.setStatus(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setStatus(status);
		}

		if (description == null) {
			membershipSubscriptionAddonServicesImpl.setDescription(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setDescription(description);
		}

		if (effectiveFromDate == Long.MIN_VALUE) {
			membershipSubscriptionAddonServicesImpl.setEffectiveFromDate(null);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setEffectiveFromDate(new Date(
					effectiveFromDate));
		}

		if (effectiveToDate == Long.MIN_VALUE) {
			membershipSubscriptionAddonServicesImpl.setEffectiveToDate(null);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setEffectiveToDate(new Date(
					effectiveToDate));
		}

		if (dateAdded == Long.MIN_VALUE) {
			membershipSubscriptionAddonServicesImpl.setDateAdded(null);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setDateAdded(new Date(
					dateAdded));
		}

		if (dateModified == Long.MIN_VALUE) {
			membershipSubscriptionAddonServicesImpl.setDateModified(null);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setDateModified(new Date(
					dateModified));
		}

		if (createdBy == null) {
			membershipSubscriptionAddonServicesImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			membershipSubscriptionAddonServicesImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setModifiedBy(modifiedBy);
		}

		if (extra1 == null) {
			membershipSubscriptionAddonServicesImpl.setExtra1(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			membershipSubscriptionAddonServicesImpl.setExtra2(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			membershipSubscriptionAddonServicesImpl.setExtra3(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			membershipSubscriptionAddonServicesImpl.setExtra4(StringPool.BLANK);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setExtra4(extra4);
		}

		if (extra5 == Long.MIN_VALUE) {
			membershipSubscriptionAddonServicesImpl.setExtra5(null);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setExtra5(new Date(extra5));
		}

		if (extra6 == Long.MIN_VALUE) {
			membershipSubscriptionAddonServicesImpl.setExtra6(null);
		}
		else {
			membershipSubscriptionAddonServicesImpl.setExtra6(new Date(extra6));
		}

		membershipSubscriptionAddonServicesImpl.resetOriginalValues();

		return membershipSubscriptionAddonServicesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		msAddonId = objectInput.readLong();
		msId = objectInput.readLong();
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
		effectiveFromDate = objectInput.readLong();
		effectiveToDate = objectInput.readLong();
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
		objectOutput.writeLong(msAddonId);
		objectOutput.writeLong(msId);

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

		objectOutput.writeLong(effectiveFromDate);
		objectOutput.writeLong(effectiveToDate);
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

	public long msAddonId;
	public long msId;
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
	public long effectiveFromDate;
	public long effectiveToDate;
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