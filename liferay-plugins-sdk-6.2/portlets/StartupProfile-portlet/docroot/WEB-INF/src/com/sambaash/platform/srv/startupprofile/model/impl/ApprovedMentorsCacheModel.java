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

import com.sambaash.platform.srv.startupprofile.model.ApprovedMentors;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ApprovedMentors in entity cache.
 *
 * @author pradeep
 * @see ApprovedMentors
 * @generated
 */
public class ApprovedMentorsCacheModel implements CacheModel<ApprovedMentors>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", mentorId=");
		sb.append(mentorId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", approvedDate=");
		sb.append(approvedDate);
		sb.append(", remarks=");
		sb.append(remarks);
		sb.append(", status=");
		sb.append(status);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ApprovedMentors toEntityModel() {
		ApprovedMentorsImpl approvedMentorsImpl = new ApprovedMentorsImpl();

		if (uuid == null) {
			approvedMentorsImpl.setUuid(StringPool.BLANK);
		}
		else {
			approvedMentorsImpl.setUuid(uuid);
		}

		approvedMentorsImpl.setMentorId(mentorId);
		approvedMentorsImpl.setOrganizationId(organizationId);

		if (userId == null) {
			approvedMentorsImpl.setUserId(StringPool.BLANK);
		}
		else {
			approvedMentorsImpl.setUserId(userId);
		}

		if (createDate == Long.MIN_VALUE) {
			approvedMentorsImpl.setCreateDate(null);
		}
		else {
			approvedMentorsImpl.setCreateDate(new Date(createDate));
		}

		if (approvedDate == Long.MIN_VALUE) {
			approvedMentorsImpl.setApprovedDate(null);
		}
		else {
			approvedMentorsImpl.setApprovedDate(new Date(approvedDate));
		}

		if (remarks == null) {
			approvedMentorsImpl.setRemarks(StringPool.BLANK);
		}
		else {
			approvedMentorsImpl.setRemarks(remarks);
		}

		approvedMentorsImpl.setStatus(status);

		approvedMentorsImpl.resetOriginalValues();

		return approvedMentorsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		mentorId = objectInput.readLong();
		organizationId = objectInput.readLong();
		userId = objectInput.readUTF();
		createDate = objectInput.readLong();
		approvedDate = objectInput.readLong();
		remarks = objectInput.readUTF();
		status = objectInput.readInt();
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

		objectOutput.writeLong(mentorId);
		objectOutput.writeLong(organizationId);

		if (userId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userId);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(approvedDate);

		if (remarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remarks);
		}

		objectOutput.writeInt(status);
	}

	public String uuid;
	public long mentorId;
	public long organizationId;
	public String userId;
	public long createDate;
	public long approvedDate;
	public String remarks;
	public int status;
}