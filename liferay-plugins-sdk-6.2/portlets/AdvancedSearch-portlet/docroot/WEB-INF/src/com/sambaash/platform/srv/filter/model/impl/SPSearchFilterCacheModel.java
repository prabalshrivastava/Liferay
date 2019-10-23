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

package com.sambaash.platform.srv.filter.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.filter.model.SPSearchFilter;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPSearchFilter in entity cache.
 *
 * @author harini
 * @see SPSearchFilter
 * @generated
 */
public class SPSearchFilterCacheModel implements CacheModel<SPSearchFilter>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spSearchFilterId=");
		sb.append(spSearchFilterId);
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
		sb.append(", filterName=");
		sb.append(filterName);
		sb.append(", filterParameter=");
		sb.append(filterParameter);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPSearchFilter toEntityModel() {
		SPSearchFilterImpl spSearchFilterImpl = new SPSearchFilterImpl();

		if (uuid == null) {
			spSearchFilterImpl.setUuid(StringPool.BLANK);
		}
		else {
			spSearchFilterImpl.setUuid(uuid);
		}

		spSearchFilterImpl.setSpSearchFilterId(spSearchFilterId);
		spSearchFilterImpl.setGroupId(groupId);
		spSearchFilterImpl.setCompanyId(companyId);
		spSearchFilterImpl.setUserId(userId);

		if (userName == null) {
			spSearchFilterImpl.setUserName(StringPool.BLANK);
		}
		else {
			spSearchFilterImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spSearchFilterImpl.setCreateDate(null);
		}
		else {
			spSearchFilterImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spSearchFilterImpl.setModifiedDate(null);
		}
		else {
			spSearchFilterImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (filterName == null) {
			spSearchFilterImpl.setFilterName(StringPool.BLANK);
		}
		else {
			spSearchFilterImpl.setFilterName(filterName);
		}

		if (filterParameter == null) {
			spSearchFilterImpl.setFilterParameter(StringPool.BLANK);
		}
		else {
			spSearchFilterImpl.setFilterParameter(filterParameter);
		}

		spSearchFilterImpl.resetOriginalValues();

		return spSearchFilterImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spSearchFilterId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		filterName = objectInput.readUTF();
		filterParameter = objectInput.readUTF();
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

		objectOutput.writeLong(spSearchFilterId);
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

		if (filterName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filterName);
		}

		if (filterParameter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(filterParameter);
		}
	}

	public String uuid;
	public long spSearchFilterId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String filterName;
	public String filterParameter;
}