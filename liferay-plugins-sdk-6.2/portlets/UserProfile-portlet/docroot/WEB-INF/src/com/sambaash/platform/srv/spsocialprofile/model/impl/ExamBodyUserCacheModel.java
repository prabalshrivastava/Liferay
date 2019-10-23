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

package com.sambaash.platform.srv.spsocialprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spsocialprofile.model.ExamBodyUser;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ExamBodyUser in entity cache.
 *
 * @author gauravvijayvergia
 * @see ExamBodyUser
 * @generated
 */
public class ExamBodyUserCacheModel implements CacheModel<ExamBodyUser>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{examBodyUserId=");
		sb.append(examBodyUserId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", examBody=");
		sb.append(examBody);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ExamBodyUser toEntityModel() {
		ExamBodyUserImpl examBodyUserImpl = new ExamBodyUserImpl();

		examBodyUserImpl.setExamBodyUserId(examBodyUserId);
		examBodyUserImpl.setGroupId(groupId);
		examBodyUserImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			examBodyUserImpl.setCreateDate(null);
		}
		else {
			examBodyUserImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			examBodyUserImpl.setModifiedDate(null);
		}
		else {
			examBodyUserImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (emailAddress == null) {
			examBodyUserImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			examBodyUserImpl.setEmailAddress(emailAddress);
		}

		if (examBody == null) {
			examBodyUserImpl.setExamBody(StringPool.BLANK);
		}
		else {
			examBodyUserImpl.setExamBody(examBody);
		}

		examBodyUserImpl.setActive(active);

		examBodyUserImpl.resetOriginalValues();

		return examBodyUserImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		examBodyUserId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		examBody = objectInput.readUTF();
		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(examBodyUserId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (examBody == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(examBody);
		}

		objectOutput.writeBoolean(active);
	}

	public long examBodyUserId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String emailAddress;
	public String examBody;
	public boolean active;
}