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

import com.sambaash.platform.srv.model.ModuleCertificate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ModuleCertificate in entity cache.
 *
 * @author gauravvijayvergia
 * @see ModuleCertificate
 * @generated
 */
public class ModuleCertificateCacheModel implements CacheModel<ModuleCertificate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{spModuleCertificateId=");
		sb.append(spModuleCertificateId);
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
		sb.append(", spModuleId=");
		sb.append(spModuleId);
		sb.append(", spCertificatetId=");
		sb.append(spCertificatetId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ModuleCertificate toEntityModel() {
		ModuleCertificateImpl moduleCertificateImpl = new ModuleCertificateImpl();

		moduleCertificateImpl.setSpModuleCertificateId(spModuleCertificateId);
		moduleCertificateImpl.setGroupId(groupId);
		moduleCertificateImpl.setCompanyId(companyId);
		moduleCertificateImpl.setUserId(userId);

		if (userName == null) {
			moduleCertificateImpl.setUserName(StringPool.BLANK);
		}
		else {
			moduleCertificateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			moduleCertificateImpl.setCreateDate(null);
		}
		else {
			moduleCertificateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			moduleCertificateImpl.setModifiedDate(null);
		}
		else {
			moduleCertificateImpl.setModifiedDate(new Date(modifiedDate));
		}

		moduleCertificateImpl.setSpModuleId(spModuleId);
		moduleCertificateImpl.setSpCertificatetId(spCertificatetId);

		moduleCertificateImpl.resetOriginalValues();

		return moduleCertificateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spModuleCertificateId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spModuleId = objectInput.readLong();
		spCertificatetId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spModuleCertificateId);
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
		objectOutput.writeLong(spModuleId);
		objectOutput.writeLong(spCertificatetId);
	}

	public long spModuleCertificateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spModuleId;
	public long spCertificatetId;
}