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

import com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing OrganisationRemarks in entity cache.
 *
 * @author pradeep
 * @see OrganisationRemarks
 * @generated
 */
public class OrganisationRemarksCacheModel implements CacheModel<OrganisationRemarks>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{remarksId=");
		sb.append(remarksId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", remarkType=");
		sb.append(remarkType);
		sb.append(", Remarks=");
		sb.append(Remarks);
		sb.append(", Notes=");
		sb.append(Notes);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public OrganisationRemarks toEntityModel() {
		OrganisationRemarksImpl organisationRemarksImpl = new OrganisationRemarksImpl();

		organisationRemarksImpl.setRemarksId(remarksId);
		organisationRemarksImpl.setOrganizationId(organizationId);

		if (remarkType == null) {
			organisationRemarksImpl.setRemarkType(StringPool.BLANK);
		}
		else {
			organisationRemarksImpl.setRemarkType(remarkType);
		}

		if (Remarks == null) {
			organisationRemarksImpl.setRemarks(StringPool.BLANK);
		}
		else {
			organisationRemarksImpl.setRemarks(Remarks);
		}

		if (Notes == null) {
			organisationRemarksImpl.setNotes(StringPool.BLANK);
		}
		else {
			organisationRemarksImpl.setNotes(Notes);
		}

		organisationRemarksImpl.setGroupId(groupId);
		organisationRemarksImpl.setCompanyId(companyId);
		organisationRemarksImpl.setUserId(userId);

		if (userName == null) {
			organisationRemarksImpl.setUserName(StringPool.BLANK);
		}
		else {
			organisationRemarksImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			organisationRemarksImpl.setCreateDate(null);
		}
		else {
			organisationRemarksImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organisationRemarksImpl.setModifiedDate(null);
		}
		else {
			organisationRemarksImpl.setModifiedDate(new Date(modifiedDate));
		}

		organisationRemarksImpl.resetOriginalValues();

		return organisationRemarksImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		remarksId = objectInput.readLong();
		organizationId = objectInput.readLong();
		remarkType = objectInput.readUTF();
		Remarks = objectInput.readUTF();
		Notes = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(remarksId);
		objectOutput.writeLong(organizationId);

		if (remarkType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remarkType);
		}

		if (Remarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Remarks);
		}

		if (Notes == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(Notes);
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
	}

	public long remarksId;
	public long organizationId;
	public String remarkType;
	public String Remarks;
	public String Notes;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}