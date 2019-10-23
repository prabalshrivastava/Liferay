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

import com.sambaash.platform.srv.model.Module;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Module in entity cache.
 *
 * @author gauravvijayvergia
 * @see Module
 * @generated
 */
public class ModuleCacheModel implements CacheModel<Module>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{spModuleId=");
		sb.append(spModuleId);
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
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", moduleCode=");
		sb.append(moduleCode);
		sb.append(", moduleName=");
		sb.append(moduleName);
		sb.append(", moduleDesc=");
		sb.append(moduleDesc);
		sb.append(", moduleType=");
		sb.append(moduleType);
		sb.append(", creditValue=");
		sb.append(creditValue);
		sb.append(", moduleDuration=");
		sb.append(moduleDuration);
		sb.append(", noOfSessions=");
		sb.append(noOfSessions);
		sb.append(", generalDesc=");
		sb.append(generalDesc);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Module toEntityModel() {
		ModuleImpl moduleImpl = new ModuleImpl();

		moduleImpl.setSpModuleId(spModuleId);
		moduleImpl.setGroupId(groupId);
		moduleImpl.setCompanyId(companyId);
		moduleImpl.setUserId(userId);

		if (userName == null) {
			moduleImpl.setUserName(StringPool.BLANK);
		}
		else {
			moduleImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			moduleImpl.setCreateDate(null);
		}
		else {
			moduleImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			moduleImpl.setModifiedDate(null);
		}
		else {
			moduleImpl.setModifiedDate(new Date(modifiedDate));
		}

		moduleImpl.setCountryId(countryId);

		if (moduleCode == null) {
			moduleImpl.setModuleCode(StringPool.BLANK);
		}
		else {
			moduleImpl.setModuleCode(moduleCode);
		}

		if (moduleName == null) {
			moduleImpl.setModuleName(StringPool.BLANK);
		}
		else {
			moduleImpl.setModuleName(moduleName);
		}

		if (moduleDesc == null) {
			moduleImpl.setModuleDesc(StringPool.BLANK);
		}
		else {
			moduleImpl.setModuleDesc(moduleDesc);
		}

		moduleImpl.setModuleType(moduleType);
		moduleImpl.setCreditValue(creditValue);

		if (moduleDuration == null) {
			moduleImpl.setModuleDuration(StringPool.BLANK);
		}
		else {
			moduleImpl.setModuleDuration(moduleDuration);
		}

		moduleImpl.setNoOfSessions(noOfSessions);

		if (generalDesc == null) {
			moduleImpl.setGeneralDesc(StringPool.BLANK);
		}
		else {
			moduleImpl.setGeneralDesc(generalDesc);
		}

		moduleImpl.resetOriginalValues();

		return moduleImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spModuleId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryId = objectInput.readLong();
		moduleCode = objectInput.readUTF();
		moduleName = objectInput.readUTF();
		moduleDesc = objectInput.readUTF();
		moduleType = objectInput.readLong();
		creditValue = objectInput.readLong();
		moduleDuration = objectInput.readUTF();
		noOfSessions = objectInput.readLong();
		generalDesc = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spModuleId);
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
		objectOutput.writeLong(countryId);

		if (moduleCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleCode);
		}

		if (moduleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleName);
		}

		if (moduleDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleDesc);
		}

		objectOutput.writeLong(moduleType);
		objectOutput.writeLong(creditValue);

		if (moduleDuration == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleDuration);
		}

		objectOutput.writeLong(noOfSessions);

		if (generalDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(generalDesc);
		}
	}

	public long spModuleId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long countryId;
	public String moduleCode;
	public String moduleName;
	public String moduleDesc;
	public long moduleType;
	public long creditValue;
	public String moduleDuration;
	public long noOfSessions;
	public String generalDesc;
}