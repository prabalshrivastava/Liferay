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

import com.sambaash.platform.srv.model.ModuleCompetencyUnit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ModuleCompetencyUnit in entity cache.
 *
 * @author gauravvijayvergia
 * @see ModuleCompetencyUnit
 * @generated
 */
public class ModuleCompetencyUnitCacheModel implements CacheModel<ModuleCompetencyUnit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{spModuleCompetencyUnitId=");
		sb.append(spModuleCompetencyUnitId);
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
		sb.append(", spCompetencyUnitId=");
		sb.append(spCompetencyUnitId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ModuleCompetencyUnit toEntityModel() {
		ModuleCompetencyUnitImpl moduleCompetencyUnitImpl = new ModuleCompetencyUnitImpl();

		moduleCompetencyUnitImpl.setSpModuleCompetencyUnitId(spModuleCompetencyUnitId);
		moduleCompetencyUnitImpl.setGroupId(groupId);
		moduleCompetencyUnitImpl.setCompanyId(companyId);
		moduleCompetencyUnitImpl.setUserId(userId);

		if (userName == null) {
			moduleCompetencyUnitImpl.setUserName(StringPool.BLANK);
		}
		else {
			moduleCompetencyUnitImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			moduleCompetencyUnitImpl.setCreateDate(null);
		}
		else {
			moduleCompetencyUnitImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			moduleCompetencyUnitImpl.setModifiedDate(null);
		}
		else {
			moduleCompetencyUnitImpl.setModifiedDate(new Date(modifiedDate));
		}

		moduleCompetencyUnitImpl.setSpModuleId(spModuleId);
		moduleCompetencyUnitImpl.setSpCompetencyUnitId(spCompetencyUnitId);

		moduleCompetencyUnitImpl.resetOriginalValues();

		return moduleCompetencyUnitImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spModuleCompetencyUnitId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		spModuleId = objectInput.readLong();
		spCompetencyUnitId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spModuleCompetencyUnitId);
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
		objectOutput.writeLong(spCompetencyUnitId);
	}

	public long spModuleCompetencyUnitId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long spModuleId;
	public long spCompetencyUnitId;
}