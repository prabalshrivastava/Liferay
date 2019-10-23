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

package com.sambaash.platform.srv.legalandcontract.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.legalandcontract.model.RDL;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing RDL in entity cache.
 *
 * @author nareshchebolu
 * @see RDL
 * @generated
 */
public class RDLCacheModel implements CacheModel<RDL>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spRdlId=");
		sb.append(spRdlId);
		sb.append(", spLitigationId=");
		sb.append(spLitigationId);
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
		sb.append(", responseDeadline=");
		sb.append(responseDeadline);
		sb.append(", claimsRemarks=");
		sb.append(claimsRemarks);
		sb.append(", alertBefore=");
		sb.append(alertBefore);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public RDL toEntityModel() {
		RDLImpl rdlImpl = new RDLImpl();

		if (uuid == null) {
			rdlImpl.setUuid(StringPool.BLANK);
		}
		else {
			rdlImpl.setUuid(uuid);
		}

		rdlImpl.setSpRdlId(spRdlId);
		rdlImpl.setSpLitigationId(spLitigationId);
		rdlImpl.setGroupId(groupId);
		rdlImpl.setCompanyId(companyId);
		rdlImpl.setUserId(userId);

		if (userName == null) {
			rdlImpl.setUserName(StringPool.BLANK);
		}
		else {
			rdlImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			rdlImpl.setCreateDate(null);
		}
		else {
			rdlImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			rdlImpl.setModifiedDate(null);
		}
		else {
			rdlImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (responseDeadline == Long.MIN_VALUE) {
			rdlImpl.setResponseDeadline(null);
		}
		else {
			rdlImpl.setResponseDeadline(new Date(responseDeadline));
		}

		if (claimsRemarks == null) {
			rdlImpl.setClaimsRemarks(StringPool.BLANK);
		}
		else {
			rdlImpl.setClaimsRemarks(claimsRemarks);
		}

		rdlImpl.setAlertBefore(alertBefore);

		rdlImpl.resetOriginalValues();

		return rdlImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spRdlId = objectInput.readLong();
		spLitigationId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		responseDeadline = objectInput.readLong();
		claimsRemarks = objectInput.readUTF();
		alertBefore = objectInput.readLong();
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

		objectOutput.writeLong(spRdlId);
		objectOutput.writeLong(spLitigationId);
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
		objectOutput.writeLong(responseDeadline);

		if (claimsRemarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(claimsRemarks);
		}

		objectOutput.writeLong(alertBefore);
	}

	public String uuid;
	public long spRdlId;
	public long spLitigationId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long responseDeadline;
	public String claimsRemarks;
	public long alertBefore;
}