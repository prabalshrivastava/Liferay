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

import com.sambaash.platform.srv.legalandcontract.model.Litigation;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Litigation in entity cache.
 *
 * @author nareshchebolu
 * @see Litigation
 * @generated
 */
public class LitigationCacheModel implements CacheModel<Litigation>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(53);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spLitigationId=");
		sb.append(spLitigationId);
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
		sb.append(", country=");
		sb.append(country);
		sb.append(", filedBy=");
		sb.append(filedBy);
		sb.append(", filedOn=");
		sb.append(filedOn);
		sb.append(", filedAtCountry=");
		sb.append(filedAtCountry);
		sb.append(", claimsRemarks=");
		sb.append(claimsRemarks);
		sb.append(", responseDeadline=");
		sb.append(responseDeadline);
		sb.append(", actualResponseDate=");
		sb.append(actualResponseDate);
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
		sb.append(", legalConfRemarks=");
		sb.append(legalConfRemarks);
		sb.append(", version=");
		sb.append(version);
		sb.append(", spTrademarksId=");
		sb.append(spTrademarksId);
		sb.append(", rootSpLitigationId=");
		sb.append(rootSpLitigationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Litigation toEntityModel() {
		LitigationImpl litigationImpl = new LitigationImpl();

		if (uuid == null) {
			litigationImpl.setUuid(StringPool.BLANK);
		}
		else {
			litigationImpl.setUuid(uuid);
		}

		litigationImpl.setSpLitigationId(spLitigationId);
		litigationImpl.setGroupId(groupId);
		litigationImpl.setCompanyId(companyId);
		litigationImpl.setUserId(userId);

		if (userName == null) {
			litigationImpl.setUserName(StringPool.BLANK);
		}
		else {
			litigationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			litigationImpl.setCreateDate(null);
		}
		else {
			litigationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			litigationImpl.setModifiedDate(null);
		}
		else {
			litigationImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (country == null) {
			litigationImpl.setCountry(StringPool.BLANK);
		}
		else {
			litigationImpl.setCountry(country);
		}

		if (filedBy == null) {
			litigationImpl.setFiledBy(StringPool.BLANK);
		}
		else {
			litigationImpl.setFiledBy(filedBy);
		}

		if (filedOn == Long.MIN_VALUE) {
			litigationImpl.setFiledOn(null);
		}
		else {
			litigationImpl.setFiledOn(new Date(filedOn));
		}

		if (filedAtCountry == null) {
			litigationImpl.setFiledAtCountry(StringPool.BLANK);
		}
		else {
			litigationImpl.setFiledAtCountry(filedAtCountry);
		}

		if (claimsRemarks == null) {
			litigationImpl.setClaimsRemarks(StringPool.BLANK);
		}
		else {
			litigationImpl.setClaimsRemarks(claimsRemarks);
		}

		if (responseDeadline == Long.MIN_VALUE) {
			litigationImpl.setResponseDeadline(null);
		}
		else {
			litigationImpl.setResponseDeadline(new Date(responseDeadline));
		}

		if (actualResponseDate == Long.MIN_VALUE) {
			litigationImpl.setActualResponseDate(null);
		}
		else {
			litigationImpl.setActualResponseDate(new Date(actualResponseDate));
		}

		if (status == null) {
			litigationImpl.setStatus(StringPool.BLANK);
		}
		else {
			litigationImpl.setStatus(status);
		}

		if (customField1 == null) {
			litigationImpl.setCustomField1(StringPool.BLANK);
		}
		else {
			litigationImpl.setCustomField1(customField1);
		}

		if (customField2 == null) {
			litigationImpl.setCustomField2(StringPool.BLANK);
		}
		else {
			litigationImpl.setCustomField2(customField2);
		}

		if (customField3 == null) {
			litigationImpl.setCustomField3(StringPool.BLANK);
		}
		else {
			litigationImpl.setCustomField3(customField3);
		}

		if (customDate1 == Long.MIN_VALUE) {
			litigationImpl.setCustomDate1(null);
		}
		else {
			litigationImpl.setCustomDate1(new Date(customDate1));
		}

		if (customDate2 == Long.MIN_VALUE) {
			litigationImpl.setCustomDate2(null);
		}
		else {
			litigationImpl.setCustomDate2(new Date(customDate2));
		}

		if (customDate3 == Long.MIN_VALUE) {
			litigationImpl.setCustomDate3(null);
		}
		else {
			litigationImpl.setCustomDate3(new Date(customDate3));
		}

		if (legalConfRemarks == null) {
			litigationImpl.setLegalConfRemarks(StringPool.BLANK);
		}
		else {
			litigationImpl.setLegalConfRemarks(legalConfRemarks);
		}

		if (version == null) {
			litigationImpl.setVersion(StringPool.BLANK);
		}
		else {
			litigationImpl.setVersion(version);
		}

		litigationImpl.setSpTrademarksId(spTrademarksId);
		litigationImpl.setRootSpLitigationId(rootSpLitigationId);

		litigationImpl.resetOriginalValues();

		return litigationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spLitigationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		country = objectInput.readUTF();
		filedBy = objectInput.readUTF();
		filedOn = objectInput.readLong();
		filedAtCountry = objectInput.readUTF();
		claimsRemarks = objectInput.readUTF();
		responseDeadline = objectInput.readLong();
		actualResponseDate = objectInput.readLong();
		status = objectInput.readUTF();
		customField1 = objectInput.readUTF();
		customField2 = objectInput.readUTF();
		customField3 = objectInput.readUTF();
		customDate1 = objectInput.readLong();
		customDate2 = objectInput.readLong();
		customDate3 = objectInput.readLong();
		legalConfRemarks = objectInput.readUTF();
		version = objectInput.readUTF();
		spTrademarksId = objectInput.readLong();
		rootSpLitigationId = objectInput.readLong();
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

		objectOutput.writeLong(spLitigationId);
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

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (filedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filedBy);
		}

		objectOutput.writeLong(filedOn);

		if (filedAtCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filedAtCountry);
		}

		if (claimsRemarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(claimsRemarks);
		}

		objectOutput.writeLong(responseDeadline);
		objectOutput.writeLong(actualResponseDate);

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

		if (legalConfRemarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(legalConfRemarks);
		}

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		objectOutput.writeLong(spTrademarksId);
		objectOutput.writeLong(rootSpLitigationId);
	}

	public String uuid;
	public long spLitigationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String country;
	public String filedBy;
	public long filedOn;
	public String filedAtCountry;
	public String claimsRemarks;
	public long responseDeadline;
	public long actualResponseDate;
	public String status;
	public String customField1;
	public String customField2;
	public String customField3;
	public long customDate1;
	public long customDate2;
	public long customDate3;
	public String legalConfRemarks;
	public String version;
	public long spTrademarksId;
	public long rootSpLitigationId;
}