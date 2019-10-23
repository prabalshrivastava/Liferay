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

package com.sambaash.platform.srv.roles.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.roles.model.SPRoles;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPRoles in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPRoles
 * @generated
 */
public class SPRolesCacheModel implements CacheModel<SPRoles>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spRoleId=");
		sb.append(spRoleId);
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
		sb.append(", roleId=");
		sb.append(roleId);
		sb.append(", categoryId1=");
		sb.append(categoryId1);
		sb.append(", categoryId2=");
		sb.append(categoryId2);
		sb.append(", countryCategoryId=");
		sb.append(countryCategoryId);
		sb.append(", departmentCategoryId=");
		sb.append(departmentCategoryId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPRoles toEntityModel() {
		SPRolesImpl spRolesImpl = new SPRolesImpl();

		if (uuid == null) {
			spRolesImpl.setUuid(StringPool.BLANK);
		}
		else {
			spRolesImpl.setUuid(uuid);
		}

		spRolesImpl.setSpRoleId(spRoleId);
		spRolesImpl.setGroupId(groupId);
		spRolesImpl.setCompanyId(companyId);
		spRolesImpl.setUserId(userId);

		if (userName == null) {
			spRolesImpl.setUserName(StringPool.BLANK);
		}
		else {
			spRolesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spRolesImpl.setCreateDate(null);
		}
		else {
			spRolesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spRolesImpl.setModifiedDate(null);
		}
		else {
			spRolesImpl.setModifiedDate(new Date(modifiedDate));
		}

		spRolesImpl.setRoleId(roleId);
		spRolesImpl.setCategoryId1(categoryId1);
		spRolesImpl.setCategoryId2(categoryId2);
		spRolesImpl.setCountryCategoryId(countryCategoryId);
		spRolesImpl.setDepartmentCategoryId(departmentCategoryId);

		spRolesImpl.resetOriginalValues();

		return spRolesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spRoleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		roleId = objectInput.readLong();
		categoryId1 = objectInput.readLong();
		categoryId2 = objectInput.readLong();
		countryCategoryId = objectInput.readLong();
		departmentCategoryId = objectInput.readLong();
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

		objectOutput.writeLong(spRoleId);
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
		objectOutput.writeLong(roleId);
		objectOutput.writeLong(categoryId1);
		objectOutput.writeLong(categoryId2);
		objectOutput.writeLong(countryCategoryId);
		objectOutput.writeLong(departmentCategoryId);
	}

	public String uuid;
	public long spRoleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long roleId;
	public long categoryId1;
	public long categoryId2;
	public long countryCategoryId;
	public long departmentCategoryId;
}