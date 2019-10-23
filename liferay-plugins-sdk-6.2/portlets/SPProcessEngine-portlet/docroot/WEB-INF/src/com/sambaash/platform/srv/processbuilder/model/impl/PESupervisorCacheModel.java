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

import com.sambaash.platform.srv.processbuilder.model.PESupervisor;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing PESupervisor in entity cache.
 *
 * @author nareshchebolu
 * @see PESupervisor
 * @generated
 */
public class PESupervisorCacheModel implements CacheModel<PESupervisor>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spPESupervisorId=");
		sb.append(spPESupervisorId);
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
		sb.append(", filter1=");
		sb.append(filter1);
		sb.append(", filter2=");
		sb.append(filter2);
		sb.append(", filter3=");
		sb.append(filter3);
		sb.append(", filter4=");
		sb.append(filter4);
		sb.append(", filter5=");
		sb.append(filter5);
		sb.append(", supervisorId=");
		sb.append(supervisorId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public PESupervisor toEntityModel() {
		PESupervisorImpl peSupervisorImpl = new PESupervisorImpl();

		peSupervisorImpl.setSpPESupervisorId(spPESupervisorId);
		peSupervisorImpl.setGroupId(groupId);
		peSupervisorImpl.setCompanyId(companyId);
		peSupervisorImpl.setUserId(userId);

		if (userName == null) {
			peSupervisorImpl.setUserName(StringPool.BLANK);
		}
		else {
			peSupervisorImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			peSupervisorImpl.setCreateDate(null);
		}
		else {
			peSupervisorImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			peSupervisorImpl.setModifiedDate(null);
		}
		else {
			peSupervisorImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (filter1 == null) {
			peSupervisorImpl.setFilter1(StringPool.BLANK);
		}
		else {
			peSupervisorImpl.setFilter1(filter1);
		}

		if (filter2 == null) {
			peSupervisorImpl.setFilter2(StringPool.BLANK);
		}
		else {
			peSupervisorImpl.setFilter2(filter2);
		}

		if (filter3 == null) {
			peSupervisorImpl.setFilter3(StringPool.BLANK);
		}
		else {
			peSupervisorImpl.setFilter3(filter3);
		}

		if (filter4 == null) {
			peSupervisorImpl.setFilter4(StringPool.BLANK);
		}
		else {
			peSupervisorImpl.setFilter4(filter4);
		}

		if (filter5 == null) {
			peSupervisorImpl.setFilter5(StringPool.BLANK);
		}
		else {
			peSupervisorImpl.setFilter5(filter5);
		}

		peSupervisorImpl.setSupervisorId(supervisorId);

		peSupervisorImpl.resetOriginalValues();

		return peSupervisorImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spPESupervisorId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		filter1 = objectInput.readUTF();
		filter2 = objectInput.readUTF();
		filter3 = objectInput.readUTF();
		filter4 = objectInput.readUTF();
		filter5 = objectInput.readUTF();
		supervisorId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spPESupervisorId);
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

		if (filter1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filter1);
		}

		if (filter2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filter2);
		}

		if (filter3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filter3);
		}

		if (filter4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filter4);
		}

		if (filter5 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filter5);
		}

		objectOutput.writeLong(supervisorId);
	}

	public long spPESupervisorId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String filter1;
	public String filter2;
	public String filter3;
	public String filter4;
	public String filter5;
	public long supervisorId;
}