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

import com.sambaash.platform.srv.startupprofile.model.FundingRound;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing FundingRound in entity cache.
 *
 * @author pradeep
 * @see FundingRound
 * @generated
 */
public class FundingRoundCacheModel implements CacheModel<FundingRound>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", fundingRoundId=");
		sb.append(fundingRoundId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", apiPath=");
		sb.append(apiPath);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", announcedOn=");
		sb.append(announcedOn);
		sb.append(", moneyRaisedInUsd=");
		sb.append(moneyRaisedInUsd);
		sb.append(", fundingType=");
		sb.append(fundingType);
		sb.append(", description=");
		sb.append(description);
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
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public FundingRound toEntityModel() {
		FundingRoundImpl fundingRoundImpl = new FundingRoundImpl();

		if (uuid == null) {
			fundingRoundImpl.setUuid(StringPool.BLANK);
		}
		else {
			fundingRoundImpl.setUuid(uuid);
		}

		fundingRoundImpl.setFundingRoundId(fundingRoundId);
		fundingRoundImpl.setOrganizationId(organizationId);

		if (name == null) {
			fundingRoundImpl.setName(StringPool.BLANK);
		}
		else {
			fundingRoundImpl.setName(name);
		}

		if (apiPath == null) {
			fundingRoundImpl.setApiPath(StringPool.BLANK);
		}
		else {
			fundingRoundImpl.setApiPath(apiPath);
		}

		if (imageUrl == null) {
			fundingRoundImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			fundingRoundImpl.setImageUrl(imageUrl);
		}

		if (announcedOn == null) {
			fundingRoundImpl.setAnnouncedOn(StringPool.BLANK);
		}
		else {
			fundingRoundImpl.setAnnouncedOn(announcedOn);
		}

		if (moneyRaisedInUsd == null) {
			fundingRoundImpl.setMoneyRaisedInUsd(StringPool.BLANK);
		}
		else {
			fundingRoundImpl.setMoneyRaisedInUsd(moneyRaisedInUsd);
		}

		if (fundingType == null) {
			fundingRoundImpl.setFundingType(StringPool.BLANK);
		}
		else {
			fundingRoundImpl.setFundingType(fundingType);
		}

		if (description == null) {
			fundingRoundImpl.setDescription(StringPool.BLANK);
		}
		else {
			fundingRoundImpl.setDescription(description);
		}

		fundingRoundImpl.setGroupId(groupId);
		fundingRoundImpl.setCompanyId(companyId);
		fundingRoundImpl.setUserId(userId);

		if (userName == null) {
			fundingRoundImpl.setUserName(StringPool.BLANK);
		}
		else {
			fundingRoundImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			fundingRoundImpl.setCreateDate(null);
		}
		else {
			fundingRoundImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			fundingRoundImpl.setModifiedDate(null);
		}
		else {
			fundingRoundImpl.setModifiedDate(new Date(modifiedDate));
		}

		fundingRoundImpl.setActive(active);

		fundingRoundImpl.resetOriginalValues();

		return fundingRoundImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		fundingRoundId = objectInput.readLong();
		organizationId = objectInput.readLong();
		name = objectInput.readUTF();
		apiPath = objectInput.readUTF();
		imageUrl = objectInput.readUTF();
		announcedOn = objectInput.readUTF();
		moneyRaisedInUsd = objectInput.readUTF();
		fundingType = objectInput.readUTF();
		description = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		active = objectInput.readBoolean();
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

		objectOutput.writeLong(fundingRoundId);
		objectOutput.writeLong(organizationId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (apiPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(apiPath);
		}

		if (imageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		if (announcedOn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(announcedOn);
		}

		if (moneyRaisedInUsd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moneyRaisedInUsd);
		}

		if (fundingType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(fundingType);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

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
		objectOutput.writeBoolean(active);
	}

	public String uuid;
	public long fundingRoundId;
	public long organizationId;
	public String name;
	public String apiPath;
	public String imageUrl;
	public String announcedOn;
	public String moneyRaisedInUsd;
	public String fundingType;
	public String description;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
}