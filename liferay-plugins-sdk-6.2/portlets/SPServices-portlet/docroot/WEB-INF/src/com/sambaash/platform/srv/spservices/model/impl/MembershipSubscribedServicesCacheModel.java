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

import com.sambaash.platform.srv.spservices.model.MembershipSubscribedServices;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MembershipSubscribedServices in entity cache.
 *
 * @author gauravvijayvergia
 * @see MembershipSubscribedServices
 * @generated
 */
public class MembershipSubscribedServicesCacheModel implements CacheModel<MembershipSubscribedServices>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{mssId=");
		sb.append(mssId);
		sb.append(", userid=");
		sb.append(userid);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", scId=");
		sb.append(scId);
		sb.append(", scName=");
		sb.append(scName);
		sb.append(", count=");
		sb.append(count);
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
		sb.append(", effectiveFromDate=");
		sb.append(effectiveFromDate);
		sb.append(", effectiveToDate=");
		sb.append(effectiveToDate);
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
	public MembershipSubscribedServices toEntityModel() {
		MembershipSubscribedServicesImpl membershipSubscribedServicesImpl = new MembershipSubscribedServicesImpl();

		membershipSubscribedServicesImpl.setMssId(mssId);
		membershipSubscribedServicesImpl.setUserid(userid);
		membershipSubscribedServicesImpl.setCompanyId(companyId);

		if (scId == null) {
			membershipSubscribedServicesImpl.setScId(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setScId(scId);
		}

		if (scName == null) {
			membershipSubscribedServicesImpl.setScName(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setScName(scName);
		}

		if (count == null) {
			membershipSubscribedServicesImpl.setCount(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setCount(count);
		}

		if (status == null) {
			membershipSubscribedServicesImpl.setStatus(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setStatus(status);
		}

		if (description == null) {
			membershipSubscribedServicesImpl.setDescription(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setDescription(description);
		}

		if (dateAdded == Long.MIN_VALUE) {
			membershipSubscribedServicesImpl.setDateAdded(null);
		}
		else {
			membershipSubscribedServicesImpl.setDateAdded(new Date(dateAdded));
		}

		if (dateModified == Long.MIN_VALUE) {
			membershipSubscribedServicesImpl.setDateModified(null);
		}
		else {
			membershipSubscribedServicesImpl.setDateModified(new Date(
					dateModified));
		}

		if (createdBy == null) {
			membershipSubscribedServicesImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			membershipSubscribedServicesImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setModifiedBy(modifiedBy);
		}

		if (effectiveFromDate == Long.MIN_VALUE) {
			membershipSubscribedServicesImpl.setEffectiveFromDate(null);
		}
		else {
			membershipSubscribedServicesImpl.setEffectiveFromDate(new Date(
					effectiveFromDate));
		}

		if (effectiveToDate == Long.MIN_VALUE) {
			membershipSubscribedServicesImpl.setEffectiveToDate(null);
		}
		else {
			membershipSubscribedServicesImpl.setEffectiveToDate(new Date(
					effectiveToDate));
		}

		if (paramFrom == null) {
			membershipSubscribedServicesImpl.setParamFrom(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setParamFrom(paramFrom);
		}

		if (paramUpto == null) {
			membershipSubscribedServicesImpl.setParamUpto(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setParamUpto(paramUpto);
		}

		if (duration == null) {
			membershipSubscribedServicesImpl.setDuration(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setDuration(duration);
		}

		if (durationType == null) {
			membershipSubscribedServicesImpl.setDurationType(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setDurationType(durationType);
		}

		membershipSubscribedServicesImpl.setServiceCharges(serviceCharges);

		if (serviceChargesCurrency == null) {
			membershipSubscribedServicesImpl.setServiceChargesCurrency(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setServiceChargesCurrency(serviceChargesCurrency);
		}

		if (serviceChargesPeriod == null) {
			membershipSubscribedServicesImpl.setServiceChargesPeriod(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setServiceChargesPeriod(serviceChargesPeriod);
		}

		if (serviceChargesPeriodType == null) {
			membershipSubscribedServicesImpl.setServiceChargesPeriodType(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setServiceChargesPeriodType(serviceChargesPeriodType);
		}

		if (extra1 == null) {
			membershipSubscribedServicesImpl.setExtra1(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			membershipSubscribedServicesImpl.setExtra2(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			membershipSubscribedServicesImpl.setExtra3(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			membershipSubscribedServicesImpl.setExtra4(StringPool.BLANK);
		}
		else {
			membershipSubscribedServicesImpl.setExtra4(extra4);
		}

		if (extra5 == Long.MIN_VALUE) {
			membershipSubscribedServicesImpl.setExtra5(null);
		}
		else {
			membershipSubscribedServicesImpl.setExtra5(new Date(extra5));
		}

		if (extra6 == Long.MIN_VALUE) {
			membershipSubscribedServicesImpl.setExtra6(null);
		}
		else {
			membershipSubscribedServicesImpl.setExtra6(new Date(extra6));
		}

		membershipSubscribedServicesImpl.resetOriginalValues();

		return membershipSubscribedServicesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mssId = objectInput.readLong();
		userid = objectInput.readLong();
		companyId = objectInput.readLong();
		scId = objectInput.readUTF();
		scName = objectInput.readUTF();
		count = objectInput.readUTF();
		status = objectInput.readUTF();
		description = objectInput.readUTF();
		dateAdded = objectInput.readLong();
		dateModified = objectInput.readLong();
		createdBy = objectInput.readUTF();
		modifiedBy = objectInput.readUTF();
		effectiveFromDate = objectInput.readLong();
		effectiveToDate = objectInput.readLong();
		paramFrom = objectInput.readUTF();
		paramUpto = objectInput.readUTF();
		duration = objectInput.readUTF();
		durationType = objectInput.readUTF();
		serviceCharges = objectInput.readFloat();
		serviceChargesCurrency = objectInput.readUTF();
		serviceChargesPeriod = objectInput.readUTF();
		serviceChargesPeriodType = objectInput.readUTF();
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
		objectOutput.writeLong(mssId);
		objectOutput.writeLong(userid);
		objectOutput.writeLong(companyId);

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

		if (count == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(count);
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

		objectOutput.writeLong(effectiveFromDate);
		objectOutput.writeLong(effectiveToDate);

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

	public long mssId;
	public long userid;
	public long companyId;
	public String scId;
	public String scName;
	public String count;
	public String status;
	public String description;
	public long dateAdded;
	public long dateModified;
	public String createdBy;
	public String modifiedBy;
	public long effectiveFromDate;
	public long effectiveToDate;
	public String paramFrom;
	public String paramUpto;
	public String duration;
	public String durationType;
	public float serviceCharges;
	public String serviceChargesCurrency;
	public String serviceChargesPeriod;
	public String serviceChargesPeriodType;
	public String extra1;
	public String extra2;
	public String extra3;
	public String extra4;
	public long extra5;
	public long extra6;
}