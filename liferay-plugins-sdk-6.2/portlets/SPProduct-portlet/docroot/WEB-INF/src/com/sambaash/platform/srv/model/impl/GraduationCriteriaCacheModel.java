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

import com.sambaash.platform.srv.model.GraduationCriteria;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GraduationCriteria in entity cache.
 *
 * @author gauravvijayvergia
 * @see GraduationCriteria
 * @generated
 */
public class GraduationCriteriaCacheModel implements CacheModel<GraduationCriteria>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{spGraduationCriteriaId=");
		sb.append(spGraduationCriteriaId);
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
		sb.append(", criteriaType=");
		sb.append(criteriaType);
		sb.append(", criteriaLevel=");
		sb.append(criteriaLevel);
		sb.append(", criteriaValueRange=");
		sb.append(criteriaValueRange);
		sb.append(", criteriaDesc=");
		sb.append(criteriaDesc);
		sb.append(", spCourseId=");
		sb.append(spCourseId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GraduationCriteria toEntityModel() {
		GraduationCriteriaImpl graduationCriteriaImpl = new GraduationCriteriaImpl();

		graduationCriteriaImpl.setSpGraduationCriteriaId(spGraduationCriteriaId);
		graduationCriteriaImpl.setGroupId(groupId);
		graduationCriteriaImpl.setCompanyId(companyId);
		graduationCriteriaImpl.setUserId(userId);

		if (userName == null) {
			graduationCriteriaImpl.setUserName(StringPool.BLANK);
		}
		else {
			graduationCriteriaImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			graduationCriteriaImpl.setCreateDate(null);
		}
		else {
			graduationCriteriaImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			graduationCriteriaImpl.setModifiedDate(null);
		}
		else {
			graduationCriteriaImpl.setModifiedDate(new Date(modifiedDate));
		}

		graduationCriteriaImpl.setCriteriaType(criteriaType);
		graduationCriteriaImpl.setCriteriaLevel(criteriaLevel);

		if (criteriaValueRange == null) {
			graduationCriteriaImpl.setCriteriaValueRange(StringPool.BLANK);
		}
		else {
			graduationCriteriaImpl.setCriteriaValueRange(criteriaValueRange);
		}

		if (criteriaDesc == null) {
			graduationCriteriaImpl.setCriteriaDesc(StringPool.BLANK);
		}
		else {
			graduationCriteriaImpl.setCriteriaDesc(criteriaDesc);
		}

		graduationCriteriaImpl.setSpCourseId(spCourseId);

		graduationCriteriaImpl.resetOriginalValues();

		return graduationCriteriaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spGraduationCriteriaId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		criteriaType = objectInput.readLong();
		criteriaLevel = objectInput.readLong();
		criteriaValueRange = objectInput.readUTF();
		criteriaDesc = objectInput.readUTF();
		spCourseId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spGraduationCriteriaId);
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
		objectOutput.writeLong(criteriaType);
		objectOutput.writeLong(criteriaLevel);

		if (criteriaValueRange == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(criteriaValueRange);
		}

		if (criteriaDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(criteriaDesc);
		}

		objectOutput.writeLong(spCourseId);
	}

	public long spGraduationCriteriaId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long criteriaType;
	public long criteriaLevel;
	public String criteriaValueRange;
	public String criteriaDesc;
	public long spCourseId;
}