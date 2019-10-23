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

import com.sambaash.platform.srv.spservices.model.MembershipPackageIndServices;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MembershipPackageIndServices in entity cache.
 *
 * @author gauravvijayvergia
 * @see MembershipPackageIndServices
 * @generated
 */
public class MembershipPackageIndServicesCacheModel implements CacheModel<MembershipPackageIndServices>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{mpgsscId=");
		sb.append(mpgsscId);
		sb.append(", mpId=");
		sb.append(mpId);
		sb.append(", scorder=");
		sb.append(scorder);
		sb.append(", scgId=");
		sb.append(scgId);
		sb.append(", scId=");
		sb.append(scId);
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
		sb.append(", serviceCharges=");
		sb.append(serviceCharges);
		sb.append(", costCurrency=");
		sb.append(costCurrency);
		sb.append(", costPeriod=");
		sb.append(costPeriod);
		sb.append(", costPeriodType=");
		sb.append(costPeriodType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MembershipPackageIndServices toEntityModel() {
		MembershipPackageIndServicesImpl membershipPackageIndServicesImpl = new MembershipPackageIndServicesImpl();

		membershipPackageIndServicesImpl.setMpgsscId(mpgsscId);
		membershipPackageIndServicesImpl.setMpId(mpId);

		if (scorder == null) {
			membershipPackageIndServicesImpl.setScorder(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setScorder(scorder);
		}

		if (scgId == null) {
			membershipPackageIndServicesImpl.setScgId(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setScgId(scgId);
		}

		if (scId == null) {
			membershipPackageIndServicesImpl.setScId(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setScId(scId);
		}

		if (paramType == null) {
			membershipPackageIndServicesImpl.setParamType(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setParamType(paramType);
		}

		if (paramFrom == null) {
			membershipPackageIndServicesImpl.setParamFrom(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setParamFrom(paramFrom);
		}

		if (paramUpto == null) {
			membershipPackageIndServicesImpl.setParamUpto(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setParamUpto(paramUpto);
		}

		if (duration == null) {
			membershipPackageIndServicesImpl.setDuration(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setDuration(duration);
		}

		if (durationType == null) {
			membershipPackageIndServicesImpl.setDurationType(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setDurationType(durationType);
		}

		if (status == null) {
			membershipPackageIndServicesImpl.setStatus(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setStatus(status);
		}

		if (description == null) {
			membershipPackageIndServicesImpl.setDescription(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setDescription(description);
		}

		if (dateAdded == Long.MIN_VALUE) {
			membershipPackageIndServicesImpl.setDateAdded(null);
		}
		else {
			membershipPackageIndServicesImpl.setDateAdded(new Date(dateAdded));
		}

		if (dateModified == Long.MIN_VALUE) {
			membershipPackageIndServicesImpl.setDateModified(null);
		}
		else {
			membershipPackageIndServicesImpl.setDateModified(new Date(
					dateModified));
		}

		if (createdBy == null) {
			membershipPackageIndServicesImpl.setCreatedBy(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setCreatedBy(createdBy);
		}

		if (modifiedBy == null) {
			membershipPackageIndServicesImpl.setModifiedBy(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setModifiedBy(modifiedBy);
		}

		if (extra1 == null) {
			membershipPackageIndServicesImpl.setExtra1(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setExtra1(extra1);
		}

		if (extra2 == null) {
			membershipPackageIndServicesImpl.setExtra2(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setExtra2(extra2);
		}

		if (extra3 == null) {
			membershipPackageIndServicesImpl.setExtra3(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setExtra3(extra3);
		}

		if (extra4 == null) {
			membershipPackageIndServicesImpl.setExtra4(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setExtra4(extra4);
		}

		if (extra5 == Long.MIN_VALUE) {
			membershipPackageIndServicesImpl.setExtra5(null);
		}
		else {
			membershipPackageIndServicesImpl.setExtra5(new Date(extra5));
		}

		if (extra6 == Long.MIN_VALUE) {
			membershipPackageIndServicesImpl.setExtra6(null);
		}
		else {
			membershipPackageIndServicesImpl.setExtra6(new Date(extra6));
		}

		membershipPackageIndServicesImpl.setServiceCharges(serviceCharges);

		if (costCurrency == null) {
			membershipPackageIndServicesImpl.setCostCurrency(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setCostCurrency(costCurrency);
		}

		if (costPeriod == null) {
			membershipPackageIndServicesImpl.setCostPeriod(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setCostPeriod(costPeriod);
		}

		if (costPeriodType == null) {
			membershipPackageIndServicesImpl.setCostPeriodType(StringPool.BLANK);
		}
		else {
			membershipPackageIndServicesImpl.setCostPeriodType(costPeriodType);
		}

		membershipPackageIndServicesImpl.resetOriginalValues();

		return membershipPackageIndServicesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		mpgsscId = objectInput.readLong();
		mpId = objectInput.readLong();
		scorder = objectInput.readUTF();
		scgId = objectInput.readUTF();
		scId = objectInput.readUTF();
		paramType = objectInput.readUTF();
		paramFrom = objectInput.readUTF();
		paramUpto = objectInput.readUTF();
		duration = objectInput.readUTF();
		durationType = objectInput.readUTF();
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
		serviceCharges = objectInput.readFloat();
		costCurrency = objectInput.readUTF();
		costPeriod = objectInput.readUTF();
		costPeriodType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(mpgsscId);
		objectOutput.writeLong(mpId);

		if (scorder == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scorder);
		}

		if (scgId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scgId);
		}

		if (scId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(scId);
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
		objectOutput.writeFloat(serviceCharges);

		if (costCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costCurrency);
		}

		if (costPeriod == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costPeriod);
		}

		if (costPeriodType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(costPeriodType);
		}
	}

	public long mpgsscId;
	public long mpId;
	public String scorder;
	public String scgId;
	public String scId;
	public String paramType;
	public String paramFrom;
	public String paramUpto;
	public String duration;
	public String durationType;
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
	public float serviceCharges;
	public String costCurrency;
	public String costPeriod;
	public String costPeriodType;
}