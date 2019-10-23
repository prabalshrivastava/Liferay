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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.SPUserType;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPUserType in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPUserType
 * @generated
 */
public class SPUserTypeCacheModel implements CacheModel<SPUserType>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(35);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spUserTypeId=");
		sb.append(spUserTypeId);
		sb.append(", spSiteId=");
		sb.append(spSiteId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userTypeId=");
		sb.append(userTypeId);
		sb.append(", userStatusId=");
		sb.append(userStatusId);
		sb.append(", declarationCompleted=");
		sb.append(declarationCompleted);
		sb.append(", declarationDate=");
		sb.append(declarationDate);
		sb.append(", declarationStorageId=");
		sb.append(declarationStorageId);
		sb.append(", pdpaCompleted=");
		sb.append(pdpaCompleted);
		sb.append(", pdpaCompletionDate=");
		sb.append(pdpaCompletionDate);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createdBy=");
		sb.append(createdBy);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPUserType toEntityModel() {
		SPUserTypeImpl spUserTypeImpl = new SPUserTypeImpl();

		if (uuid == null) {
			spUserTypeImpl.setUuid(StringPool.BLANK);
		}
		else {
			spUserTypeImpl.setUuid(uuid);
		}

		spUserTypeImpl.setSpUserTypeId(spUserTypeId);
		spUserTypeImpl.setSpSiteId(spSiteId);
		spUserTypeImpl.setUserId(userId);
		spUserTypeImpl.setUserTypeId(userTypeId);
		spUserTypeImpl.setUserStatusId(userStatusId);
		spUserTypeImpl.setDeclarationCompleted(declarationCompleted);
		spUserTypeImpl.setDeclarationDate(declarationDate);
		spUserTypeImpl.setDeclarationStorageId(declarationStorageId);
		spUserTypeImpl.setPdpaCompleted(pdpaCompleted);
		spUserTypeImpl.setPdpaCompletionDate(pdpaCompletionDate);
		spUserTypeImpl.setGroupId(groupId);
		spUserTypeImpl.setCompanyId(companyId);
		spUserTypeImpl.setCreatedBy(createdBy);
		spUserTypeImpl.setModifiedBy(modifiedBy);

		if (createdDate == Long.MIN_VALUE) {
			spUserTypeImpl.setCreatedDate(null);
		}
		else {
			spUserTypeImpl.setCreatedDate(new Date(createdDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spUserTypeImpl.setModifiedDate(null);
		}
		else {
			spUserTypeImpl.setModifiedDate(new Date(modifiedDate));
		}

		spUserTypeImpl.resetOriginalValues();

		return spUserTypeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spUserTypeId = objectInput.readLong();
		spSiteId = objectInput.readLong();
		userId = objectInput.readLong();
		userTypeId = objectInput.readLong();
		userStatusId = objectInput.readLong();
		declarationCompleted = objectInput.readBoolean();
		declarationDate = objectInput.readLong();
		declarationStorageId = objectInput.readLong();
		pdpaCompleted = objectInput.readBoolean();
		pdpaCompletionDate = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createdBy = objectInput.readLong();
		modifiedBy = objectInput.readLong();
		createdDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
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

		objectOutput.writeLong(spUserTypeId);
		objectOutput.writeLong(spSiteId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(userTypeId);
		objectOutput.writeLong(userStatusId);
		objectOutput.writeBoolean(declarationCompleted);
		objectOutput.writeLong(declarationDate);
		objectOutput.writeLong(declarationStorageId);
		objectOutput.writeBoolean(pdpaCompleted);
		objectOutput.writeLong(pdpaCompletionDate);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createdBy);
		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(createdDate);
		objectOutput.writeLong(modifiedDate);
	}

	public String uuid;
	public long spUserTypeId;
	public long spSiteId;
	public long userId;
	public long userTypeId;
	public long userStatusId;
	public boolean declarationCompleted;
	public long declarationDate;
	public long declarationStorageId;
	public boolean pdpaCompleted;
	public long pdpaCompletionDate;
	public long groupId;
	public long companyId;
	public long createdBy;
	public long modifiedBy;
	public long createdDate;
	public long modifiedDate;
}