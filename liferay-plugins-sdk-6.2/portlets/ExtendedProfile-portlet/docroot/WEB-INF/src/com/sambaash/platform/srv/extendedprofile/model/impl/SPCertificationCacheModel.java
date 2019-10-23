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

package com.sambaash.platform.srv.extendedprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.extendedprofile.model.SPCertification;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPCertification in entity cache.
 *
 * @author harini
 * @see SPCertification
 * @generated
 */
public class SPCertificationCacheModel implements CacheModel<SPCertification>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{classPk=");
		sb.append(classPk);
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
		sb.append(", certificationId=");
		sb.append(certificationId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPCertification toEntityModel() {
		SPCertificationImpl spCertificationImpl = new SPCertificationImpl();

		spCertificationImpl.setClassPk(classPk);
		spCertificationImpl.setGroupId(groupId);
		spCertificationImpl.setCompanyId(companyId);
		spCertificationImpl.setUserId(userId);

		if (userName == null) {
			spCertificationImpl.setUserName(StringPool.BLANK);
		}
		else {
			spCertificationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spCertificationImpl.setCreateDate(null);
		}
		else {
			spCertificationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spCertificationImpl.setModifiedDate(null);
		}
		else {
			spCertificationImpl.setModifiedDate(new Date(modifiedDate));
		}

		spCertificationImpl.setCertificationId(certificationId);

		spCertificationImpl.resetOriginalValues();

		return spCertificationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		classPk = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		certificationId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(classPk);
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
		objectOutput.writeLong(certificationId);
	}

	public long classPk;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long certificationId;
}