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

package com.sambaash.platform.srv.processbuilder.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.processbuilder.model.PERuleSet;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PERuleSet in entity cache.
 *
 * @author nareshchebolu
 * @see PERuleSet
 * @generated
 */
public class PERuleSetCacheModel implements CacheModel<PERuleSet>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spPERuleSetId=");
		sb.append(spPERuleSetId);
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
		sb.append(", name=");
		sb.append(name);
		sb.append(", componentType=");
		sb.append(componentType);
		sb.append(", componentId=");
		sb.append(componentId);
		sb.append(", status=");
		sb.append(status);
		sb.append(", formVersion=");
		sb.append(formVersion);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PERuleSet toEntityModel() {
		PERuleSetImpl peRuleSetImpl = new PERuleSetImpl();

		if (uuid == null) {
			peRuleSetImpl.setUuid(StringPool.BLANK);
		}
		else {
			peRuleSetImpl.setUuid(uuid);
		}

		peRuleSetImpl.setSpPERuleSetId(spPERuleSetId);
		peRuleSetImpl.setGroupId(groupId);
		peRuleSetImpl.setCompanyId(companyId);
		peRuleSetImpl.setUserId(userId);

		if (userName == null) {
			peRuleSetImpl.setUserName(StringPool.BLANK);
		}
		else {
			peRuleSetImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peRuleSetImpl.setCreateDate(null);
		}
		else {
			peRuleSetImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peRuleSetImpl.setModifiedDate(null);
		}
		else {
			peRuleSetImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			peRuleSetImpl.setName(StringPool.BLANK);
		}
		else {
			peRuleSetImpl.setName(name);
		}

		if (componentType == null) {
			peRuleSetImpl.setComponentType(StringPool.BLANK);
		}
		else {
			peRuleSetImpl.setComponentType(componentType);
		}

		if (componentId == null) {
			peRuleSetImpl.setComponentId(StringPool.BLANK);
		}
		else {
			peRuleSetImpl.setComponentId(componentId);
		}

		peRuleSetImpl.setStatus(status);

		if (formVersion == null) {
			peRuleSetImpl.setFormVersion(StringPool.BLANK);
		}
		else {
			peRuleSetImpl.setFormVersion(formVersion);
		}

		peRuleSetImpl.resetOriginalValues();

		return peRuleSetImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spPERuleSetId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		componentType = objectInput.readUTF();
		componentId = objectInput.readUTF();
		status = objectInput.readLong();
		formVersion = objectInput.readUTF();
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

		objectOutput.writeLong(spPERuleSetId);
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

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (componentType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(componentType);
		}

		if (componentId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(componentId);
		}

		objectOutput.writeLong(status);

		if (formVersion == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(formVersion);
		}
	}

	public String uuid;
	public long spPERuleSetId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public String componentType;
	public String componentId;
	public long status;
	public String formVersion;
}