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

package com.sambaash.platform.srv.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.model.Outcome;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Outcome in entity cache.
 *
 * @author gauravvijayvergia
 * @see Outcome
 * @generated
 */
public class OutcomeCacheModel implements CacheModel<Outcome>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spOutcomeId=");
		sb.append(spOutcomeId);
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
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", outcomeCode=");
		sb.append(outcomeCode);
		sb.append(", outcomeDesc=");
		sb.append(outcomeDesc);
		sb.append(", outcomeType=");
		sb.append(outcomeType);
		sb.append(", outcomeFolderId=");
		sb.append(outcomeFolderId);
		sb.append(", spCompetencyUnitId=");
		sb.append(spCompetencyUnitId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Outcome toEntityModel() {
		OutcomeImpl outcomeImpl = new OutcomeImpl();

		outcomeImpl.setSpOutcomeId(spOutcomeId);
		outcomeImpl.setGroupId(groupId);
		outcomeImpl.setCompanyId(companyId);
		outcomeImpl.setUserId(userId);

		if (userName == null) {
			outcomeImpl.setUserName(StringPool.BLANK);
		}
		else {
			outcomeImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			outcomeImpl.setCreateDate(null);
		}
		else {
			outcomeImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			outcomeImpl.setModifiedDate(null);
		}
		else {
			outcomeImpl.setModifiedDate(new Date(modifiedDate));
		}

		outcomeImpl.setCountryId(countryId);

		if (outcomeCode == null) {
			outcomeImpl.setOutcomeCode(StringPool.BLANK);
		}
		else {
			outcomeImpl.setOutcomeCode(outcomeCode);
		}

		if (outcomeDesc == null) {
			outcomeImpl.setOutcomeDesc(StringPool.BLANK);
		}
		else {
			outcomeImpl.setOutcomeDesc(outcomeDesc);
		}

		outcomeImpl.setOutcomeType(outcomeType);
		outcomeImpl.setOutcomeFolderId(outcomeFolderId);
		outcomeImpl.setSpCompetencyUnitId(spCompetencyUnitId);

		outcomeImpl.resetOriginalValues();

		return outcomeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spOutcomeId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryId = objectInput.readLong();
		outcomeCode = objectInput.readUTF();
		outcomeDesc = objectInput.readUTF();
		outcomeType = objectInput.readLong();
		outcomeFolderId = objectInput.readLong();
		spCompetencyUnitId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spOutcomeId);
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
		objectOutput.writeLong(countryId);

		if (outcomeCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(outcomeCode);
		}

		if (outcomeDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(outcomeDesc);
		}

		objectOutput.writeLong(outcomeType);
		objectOutput.writeLong(outcomeFolderId);
		objectOutput.writeLong(spCompetencyUnitId);
	}

	public long spOutcomeId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long countryId;
	public String outcomeCode;
	public String outcomeDesc;
	public long outcomeType;
	public long outcomeFolderId;
	public long spCompetencyUnitId;
}