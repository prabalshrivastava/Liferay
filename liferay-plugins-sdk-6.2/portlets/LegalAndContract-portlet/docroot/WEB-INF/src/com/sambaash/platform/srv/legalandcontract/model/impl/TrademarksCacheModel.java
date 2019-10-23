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

import com.sambaash.platform.srv.legalandcontract.model.Trademarks;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Trademarks in entity cache.
 *
 * @author nareshchebolu
 * @see Trademarks
 * @generated
 */
public class TrademarksCacheModel implements CacheModel<Trademarks>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(67);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spTrademarksId=");
		sb.append(spTrademarksId);
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
		sb.append(", registrationNumber=");
		sb.append(registrationNumber);
		sb.append(", applicationNo=");
		sb.append(applicationNo);
		sb.append(", country=");
		sb.append(country);
		sb.append(", trademark=");
		sb.append(trademark);
		sb.append(", trademarkLocalized=");
		sb.append(trademarkLocalized);
		sb.append(", registeredOwner=");
		sb.append(registeredOwner);
		sb.append(", applicationDate=");
		sb.append(applicationDate);
		sb.append(", firstRegistrationDate=");
		sb.append(firstRegistrationDate);
		sb.append(", renewalDate=");
		sb.append(renewalDate);
		sb.append(", goodsServices=");
		sb.append(goodsServices);
		sb.append(", pendingComments=");
		sb.append(pendingComments);
		sb.append(", spAgencyId=");
		sb.append(spAgencyId);
		sb.append(", classDescription=");
		sb.append(classDescription);
		sb.append(", legalConfRemarks=");
		sb.append(legalConfRemarks);
		sb.append(", workflowStatus=");
		sb.append(workflowStatus);
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
		sb.append(", classCodes=");
		sb.append(classCodes);
		sb.append(", version=");
		sb.append(version);
		sb.append(", trademarkType=");
		sb.append(trademarkType);
		sb.append(", rootSpTrademarksId=");
		sb.append(rootSpTrademarksId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Trademarks toEntityModel() {
		TrademarksImpl trademarksImpl = new TrademarksImpl();

		if (uuid == null) {
			trademarksImpl.setUuid(StringPool.BLANK);
		}
		else {
			trademarksImpl.setUuid(uuid);
		}

		trademarksImpl.setSpTrademarksId(spTrademarksId);
		trademarksImpl.setGroupId(groupId);
		trademarksImpl.setCompanyId(companyId);
		trademarksImpl.setUserId(userId);

		if (userName == null) {
			trademarksImpl.setUserName(StringPool.BLANK);
		}
		else {
			trademarksImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			trademarksImpl.setCreateDate(null);
		}
		else {
			trademarksImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			trademarksImpl.setModifiedDate(null);
		}
		else {
			trademarksImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (registrationNumber == null) {
			trademarksImpl.setRegistrationNumber(StringPool.BLANK);
		}
		else {
			trademarksImpl.setRegistrationNumber(registrationNumber);
		}

		if (applicationNo == null) {
			trademarksImpl.setApplicationNo(StringPool.BLANK);
		}
		else {
			trademarksImpl.setApplicationNo(applicationNo);
		}

		if (country == null) {
			trademarksImpl.setCountry(StringPool.BLANK);
		}
		else {
			trademarksImpl.setCountry(country);
		}

		if (trademark == null) {
			trademarksImpl.setTrademark(StringPool.BLANK);
		}
		else {
			trademarksImpl.setTrademark(trademark);
		}

		if (trademarkLocalized == null) {
			trademarksImpl.setTrademarkLocalized(StringPool.BLANK);
		}
		else {
			trademarksImpl.setTrademarkLocalized(trademarkLocalized);
		}

		if (registeredOwner == null) {
			trademarksImpl.setRegisteredOwner(StringPool.BLANK);
		}
		else {
			trademarksImpl.setRegisteredOwner(registeredOwner);
		}

		if (applicationDate == Long.MIN_VALUE) {
			trademarksImpl.setApplicationDate(null);
		}
		else {
			trademarksImpl.setApplicationDate(new Date(applicationDate));
		}

		if (firstRegistrationDate == Long.MIN_VALUE) {
			trademarksImpl.setFirstRegistrationDate(null);
		}
		else {
			trademarksImpl.setFirstRegistrationDate(new Date(
					firstRegistrationDate));
		}

		if (renewalDate == Long.MIN_VALUE) {
			trademarksImpl.setRenewalDate(null);
		}
		else {
			trademarksImpl.setRenewalDate(new Date(renewalDate));
		}

		if (goodsServices == null) {
			trademarksImpl.setGoodsServices(StringPool.BLANK);
		}
		else {
			trademarksImpl.setGoodsServices(goodsServices);
		}

		if (pendingComments == null) {
			trademarksImpl.setPendingComments(StringPool.BLANK);
		}
		else {
			trademarksImpl.setPendingComments(pendingComments);
		}

		trademarksImpl.setSpAgencyId(spAgencyId);

		if (classDescription == null) {
			trademarksImpl.setClassDescription(StringPool.BLANK);
		}
		else {
			trademarksImpl.setClassDescription(classDescription);
		}

		if (legalConfRemarks == null) {
			trademarksImpl.setLegalConfRemarks(StringPool.BLANK);
		}
		else {
			trademarksImpl.setLegalConfRemarks(legalConfRemarks);
		}

		trademarksImpl.setWorkflowStatus(workflowStatus);

		if (customField1 == null) {
			trademarksImpl.setCustomField1(StringPool.BLANK);
		}
		else {
			trademarksImpl.setCustomField1(customField1);
		}

		if (customField2 == null) {
			trademarksImpl.setCustomField2(StringPool.BLANK);
		}
		else {
			trademarksImpl.setCustomField2(customField2);
		}

		if (customField3 == null) {
			trademarksImpl.setCustomField3(StringPool.BLANK);
		}
		else {
			trademarksImpl.setCustomField3(customField3);
		}

		if (customDate1 == Long.MIN_VALUE) {
			trademarksImpl.setCustomDate1(null);
		}
		else {
			trademarksImpl.setCustomDate1(new Date(customDate1));
		}

		if (customDate2 == Long.MIN_VALUE) {
			trademarksImpl.setCustomDate2(null);
		}
		else {
			trademarksImpl.setCustomDate2(new Date(customDate2));
		}

		if (customDate3 == Long.MIN_VALUE) {
			trademarksImpl.setCustomDate3(null);
		}
		else {
			trademarksImpl.setCustomDate3(new Date(customDate3));
		}

		if (classCodes == null) {
			trademarksImpl.setClassCodes(StringPool.BLANK);
		}
		else {
			trademarksImpl.setClassCodes(classCodes);
		}

		if (version == null) {
			trademarksImpl.setVersion(StringPool.BLANK);
		}
		else {
			trademarksImpl.setVersion(version);
		}

		if (trademarkType == null) {
			trademarksImpl.setTrademarkType(StringPool.BLANK);
		}
		else {
			trademarksImpl.setTrademarkType(trademarkType);
		}

		trademarksImpl.setRootSpTrademarksId(rootSpTrademarksId);

		trademarksImpl.resetOriginalValues();

		return trademarksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spTrademarksId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		registrationNumber = objectInput.readUTF();
		applicationNo = objectInput.readUTF();
		country = objectInput.readUTF();
		trademark = objectInput.readUTF();
		trademarkLocalized = objectInput.readUTF();
		registeredOwner = objectInput.readUTF();
		applicationDate = objectInput.readLong();
		firstRegistrationDate = objectInput.readLong();
		renewalDate = objectInput.readLong();
		goodsServices = objectInput.readUTF();
		pendingComments = objectInput.readUTF();
		spAgencyId = objectInput.readLong();
		classDescription = objectInput.readUTF();
		legalConfRemarks = objectInput.readUTF();
		workflowStatus = objectInput.readLong();
		customField1 = objectInput.readUTF();
		customField2 = objectInput.readUTF();
		customField3 = objectInput.readUTF();
		customDate1 = objectInput.readLong();
		customDate2 = objectInput.readLong();
		customDate3 = objectInput.readLong();
		classCodes = objectInput.readUTF();
		version = objectInput.readUTF();
		trademarkType = objectInput.readUTF();
		rootSpTrademarksId = objectInput.readLong();
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

		objectOutput.writeLong(spTrademarksId);
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

		if (registrationNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(registrationNumber);
		}

		if (applicationNo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(applicationNo);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (trademark == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(trademark);
		}

		if (trademarkLocalized == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(trademarkLocalized);
		}

		if (registeredOwner == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(registeredOwner);
		}

		objectOutput.writeLong(applicationDate);
		objectOutput.writeLong(firstRegistrationDate);
		objectOutput.writeLong(renewalDate);

		if (goodsServices == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(goodsServices);
		}

		if (pendingComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pendingComments);
		}

		objectOutput.writeLong(spAgencyId);

		if (classDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classDescription);
		}

		if (legalConfRemarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(legalConfRemarks);
		}

		objectOutput.writeLong(workflowStatus);

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

		if (classCodes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(classCodes);
		}

		if (version == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(version);
		}

		if (trademarkType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(trademarkType);
		}

		objectOutput.writeLong(rootSpTrademarksId);
	}

	public String uuid;
	public long spTrademarksId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String registrationNumber;
	public String applicationNo;
	public String country;
	public String trademark;
	public String trademarkLocalized;
	public String registeredOwner;
	public long applicationDate;
	public long firstRegistrationDate;
	public long renewalDate;
	public String goodsServices;
	public String pendingComments;
	public long spAgencyId;
	public String classDescription;
	public String legalConfRemarks;
	public long workflowStatus;
	public String customField1;
	public String customField2;
	public String customField3;
	public long customDate1;
	public long customDate2;
	public long customDate3;
	public String classCodes;
	public String version;
	public String trademarkType;
	public long rootSpTrademarksId;
}