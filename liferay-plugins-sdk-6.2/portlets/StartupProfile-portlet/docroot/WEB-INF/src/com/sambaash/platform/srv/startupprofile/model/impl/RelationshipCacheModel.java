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

import com.sambaash.platform.srv.startupprofile.model.Relationship;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Relationship in entity cache.
 *
 * @author pradeep
 * @see Relationship
 * @generated
 */
public class RelationshipCacheModel implements CacheModel<Relationship>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{relationshipId=");
		sb.append(relationshipId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", refId=");
		sb.append(refId);
		sb.append(", refTypeId=");
		sb.append(refTypeId);
		sb.append(", relation=");
		sb.append(relation);
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
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Relationship toEntityModel() {
		RelationshipImpl relationshipImpl = new RelationshipImpl();

		relationshipImpl.setRelationshipId(relationshipId);
		relationshipImpl.setOrganizationId(organizationId);
		relationshipImpl.setRefId(refId);
		relationshipImpl.setRefTypeId(refTypeId);
		relationshipImpl.setRelation(relation);
		relationshipImpl.setGroupId(groupId);
		relationshipImpl.setCompanyId(companyId);
		relationshipImpl.setUserId(userId);

		if (userName == null) {
			relationshipImpl.setUserName(StringPool.BLANK);
		}
		else {
			relationshipImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			relationshipImpl.setCreateDate(null);
		}
		else {
			relationshipImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			relationshipImpl.setModifiedDate(null);
		}
		else {
			relationshipImpl.setModifiedDate(new Date(modifiedDate));
		}

		relationshipImpl.setActive(active);

		relationshipImpl.resetOriginalValues();

		return relationshipImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		relationshipId = objectInput.readLong();
		organizationId = objectInput.readLong();
		refId = objectInput.readLong();
		refTypeId = objectInput.readLong();
		relation = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(relationshipId);
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(refId);
		objectOutput.writeLong(refTypeId);
		objectOutput.writeLong(relation);
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
		objectOutput.writeBoolean(active);
	}

	public long relationshipId;
	public long organizationId;
	public long refId;
	public long refTypeId;
	public long relation;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
}