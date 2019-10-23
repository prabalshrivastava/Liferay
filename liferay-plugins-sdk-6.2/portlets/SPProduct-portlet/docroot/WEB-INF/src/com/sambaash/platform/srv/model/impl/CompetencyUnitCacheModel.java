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

import com.sambaash.platform.srv.model.CompetencyUnit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing CompetencyUnit in entity cache.
 *
 * @author gauravvijayvergia
 * @see CompetencyUnit
 * @generated
 */
public class CompetencyUnitCacheModel implements CacheModel<CompetencyUnit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{spCompetencyUnitId=");
		sb.append(spCompetencyUnitId);
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
		sb.append(", spFrameworkId=");
		sb.append(spFrameworkId);
		sb.append(", competencyUnitCode=");
		sb.append(competencyUnitCode);
		sb.append(", competencyUnitDesc=");
		sb.append(competencyUnitDesc);
		sb.append(", jobFamily=");
		sb.append(jobFamily);
		sb.append(", competencyLevel=");
		sb.append(competencyLevel);
		sb.append(", creditValue=");
		sb.append(creditValue);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public CompetencyUnit toEntityModel() {
		CompetencyUnitImpl competencyUnitImpl = new CompetencyUnitImpl();

		competencyUnitImpl.setSpCompetencyUnitId(spCompetencyUnitId);
		competencyUnitImpl.setGroupId(groupId);
		competencyUnitImpl.setCompanyId(companyId);
		competencyUnitImpl.setUserId(userId);

		if (userName == null) {
			competencyUnitImpl.setUserName(StringPool.BLANK);
		}
		else {
			competencyUnitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			competencyUnitImpl.setCreateDate(null);
		}
		else {
			competencyUnitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			competencyUnitImpl.setModifiedDate(null);
		}
		else {
			competencyUnitImpl.setModifiedDate(new Date(modifiedDate));
		}

		competencyUnitImpl.setCountryId(countryId);
		competencyUnitImpl.setSpFrameworkId(spFrameworkId);

		if (competencyUnitCode == null) {
			competencyUnitImpl.setCompetencyUnitCode(StringPool.BLANK);
		}
		else {
			competencyUnitImpl.setCompetencyUnitCode(competencyUnitCode);
		}

		if (competencyUnitDesc == null) {
			competencyUnitImpl.setCompetencyUnitDesc(StringPool.BLANK);
		}
		else {
			competencyUnitImpl.setCompetencyUnitDesc(competencyUnitDesc);
		}

		competencyUnitImpl.setJobFamily(jobFamily);
		competencyUnitImpl.setCompetencyLevel(competencyLevel);
		competencyUnitImpl.setCreditValue(creditValue);

		competencyUnitImpl.resetOriginalValues();

		return competencyUnitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCompetencyUnitId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryId = objectInput.readLong();
		spFrameworkId = objectInput.readLong();
		competencyUnitCode = objectInput.readUTF();
		competencyUnitDesc = objectInput.readUTF();
		jobFamily = objectInput.readLong();
		competencyLevel = objectInput.readLong();
		creditValue = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCompetencyUnitId);
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
		objectOutput.writeLong(spFrameworkId);

		if (competencyUnitCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(competencyUnitCode);
		}

		if (competencyUnitDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(competencyUnitDesc);
		}

		objectOutput.writeLong(jobFamily);
		objectOutput.writeLong(competencyLevel);
		objectOutput.writeLong(creditValue);
	}

	public long spCompetencyUnitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long countryId;
	public long spFrameworkId;
	public String competencyUnitCode;
	public String competencyUnitDesc;
	public long jobFamily;
	public long competencyLevel;
	public long creditValue;
}