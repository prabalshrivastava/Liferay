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

import com.sambaash.platform.srv.spservices.model.SPLikes;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPLikes in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPLikes
 * @generated
 */
public class SPLikesCacheModel implements CacheModel<SPLikes>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spLikesId=");
		sb.append(spLikesId);
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
		sb.append(", layoutSetId=");
		sb.append(layoutSetId);
		sb.append(", action=");
		sb.append(action);
		sb.append(", actorUserId=");
		sb.append(actorUserId);
		sb.append(", classId=");
		sb.append(classId);
		sb.append(", className=");
		sb.append(className);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPLikes toEntityModel() {
		SPLikesImpl spLikesImpl = new SPLikesImpl();

		if (uuid == null) {
			spLikesImpl.setUuid(StringPool.BLANK);
		}
		else {
			spLikesImpl.setUuid(uuid);
		}

		spLikesImpl.setSpLikesId(spLikesId);
		spLikesImpl.setGroupId(groupId);
		spLikesImpl.setCompanyId(companyId);
		spLikesImpl.setUserId(userId);

		if (userName == null) {
			spLikesImpl.setUserName(StringPool.BLANK);
		}
		else {
			spLikesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spLikesImpl.setCreateDate(null);
		}
		else {
			spLikesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spLikesImpl.setModifiedDate(null);
		}
		else {
			spLikesImpl.setModifiedDate(new Date(modifiedDate));
		}

		spLikesImpl.setLayoutSetId(layoutSetId);

		if (action == null) {
			spLikesImpl.setAction(StringPool.BLANK);
		}
		else {
			spLikesImpl.setAction(action);
		}

		spLikesImpl.setActorUserId(actorUserId);
		spLikesImpl.setClassId(classId);

		if (className == null) {
			spLikesImpl.setClassName(StringPool.BLANK);
		}
		else {
			spLikesImpl.setClassName(className);
		}

		spLikesImpl.setClassPK(classPK);

		spLikesImpl.resetOriginalValues();

		return spLikesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spLikesId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		layoutSetId = objectInput.readLong();
		action = objectInput.readUTF();
		actorUserId = objectInput.readLong();
		classId = objectInput.readLong();
		className = objectInput.readUTF();
		classPK = objectInput.readLong();
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

		objectOutput.writeLong(spLikesId);
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
		objectOutput.writeLong(layoutSetId);

		if (action == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(action);
		}

		objectOutput.writeLong(actorUserId);
		objectOutput.writeLong(classId);

		if (className == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(className);
		}

		objectOutput.writeLong(classPK);
	}

	public String uuid;
	public long spLikesId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long layoutSetId;
	public String action;
	public long actorUserId;
	public long classId;
	public String className;
	public long classPK;
}