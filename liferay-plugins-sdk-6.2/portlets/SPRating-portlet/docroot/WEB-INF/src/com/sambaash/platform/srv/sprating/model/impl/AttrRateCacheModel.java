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

package com.sambaash.platform.srv.sprating.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.sprating.model.AttrRate;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing AttrRate in entity cache.
 *
 * @author harini
 * @see AttrRate
 * @generated
 */
public class AttrRateCacheModel implements CacheModel<AttrRate>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spAttrRateId=");
		sb.append(spAttrRateId);
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
		sb.append(", objId=");
		sb.append(objId);
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", ratingAttrId=");
		sb.append(ratingAttrId);
		sb.append(", value=");
		sb.append(value);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public AttrRate toEntityModel() {
		AttrRateImpl attrRateImpl = new AttrRateImpl();

		if (uuid == null) {
			attrRateImpl.setUuid(StringPool.BLANK);
		}
		else {
			attrRateImpl.setUuid(uuid);
		}

		attrRateImpl.setSpAttrRateId(spAttrRateId);
		attrRateImpl.setGroupId(groupId);
		attrRateImpl.setCompanyId(companyId);
		attrRateImpl.setUserId(userId);

		if (userName == null) {
			attrRateImpl.setUserName(StringPool.BLANK);
		}
		else {
			attrRateImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			attrRateImpl.setCreateDate(null);
		}
		else {
			attrRateImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			attrRateImpl.setModifiedDate(null);
		}
		else {
			attrRateImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (objId == null) {
			attrRateImpl.setObjId(StringPool.BLANK);
		}
		else {
			attrRateImpl.setObjId(objId);
		}

		attrRateImpl.setClassNameId(classNameId);
		attrRateImpl.setRatingAttrId(ratingAttrId);
		attrRateImpl.setValue(value);

		attrRateImpl.resetOriginalValues();

		return attrRateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spAttrRateId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		objId = objectInput.readUTF();
		classNameId = objectInput.readLong();
		ratingAttrId = objectInput.readLong();
		value = objectInput.readDouble();
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

		objectOutput.writeLong(spAttrRateId);
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

		if (objId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(objId);
		}

		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(ratingAttrId);
		objectOutput.writeDouble(value);
	}

	public String uuid;
	public long spAttrRateId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String objId;
	public long classNameId;
	public long ratingAttrId;
	public double value;
}