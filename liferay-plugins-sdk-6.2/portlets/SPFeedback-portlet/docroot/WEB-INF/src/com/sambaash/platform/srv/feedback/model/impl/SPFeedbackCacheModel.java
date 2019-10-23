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

package com.sambaash.platform.srv.feedback.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.feedback.model.SPFeedback;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPFeedback in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPFeedback
 * @generated
 */
public class SPFeedbackCacheModel implements CacheModel<SPFeedback>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{spFeedbackId=");
		sb.append(spFeedbackId);
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
		sb.append(", type=");
		sb.append(type);
		sb.append(", description=");
		sb.append(description);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPFeedback toEntityModel() {
		SPFeedbackImpl spFeedbackImpl = new SPFeedbackImpl();

		spFeedbackImpl.setSpFeedbackId(spFeedbackId);
		spFeedbackImpl.setGroupId(groupId);
		spFeedbackImpl.setCompanyId(companyId);
		spFeedbackImpl.setUserId(userId);

		if (userName == null) {
			spFeedbackImpl.setUserName(StringPool.BLANK);
		}
		else {
			spFeedbackImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spFeedbackImpl.setCreateDate(null);
		}
		else {
			spFeedbackImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spFeedbackImpl.setModifiedDate(null);
		}
		else {
			spFeedbackImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (type == null) {
			spFeedbackImpl.setType(StringPool.BLANK);
		}
		else {
			spFeedbackImpl.setType(type);
		}

		if (description == null) {
			spFeedbackImpl.setDescription(StringPool.BLANK);
		}
		else {
			spFeedbackImpl.setDescription(description);
		}

		spFeedbackImpl.resetOriginalValues();

		return spFeedbackImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spFeedbackId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		type = objectInput.readUTF();
		description = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spFeedbackId);
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

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}
	}

	public long spFeedbackId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String type;
	public String description;
}