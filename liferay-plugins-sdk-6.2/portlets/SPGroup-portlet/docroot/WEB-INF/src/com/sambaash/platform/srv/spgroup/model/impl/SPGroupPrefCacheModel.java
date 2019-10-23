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

package com.sambaash.platform.srv.spgroup.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spgroup.model.SPGroupPref;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPGroupPref in entity cache.
 *
 * @author harini
 * @see SPGroupPref
 * @generated
 */
public class SPGroupPrefCacheModel implements CacheModel<SPGroupPref>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{spGroupPrefId=");
		sb.append(spGroupPrefId);
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
		sb.append(", dIn=");
		sb.append(dIn);
		sb.append(", dGoogle=");
		sb.append(dGoogle);
		sb.append(", dFb=");
		sb.append(dFb);
		sb.append(", dTw=");
		sb.append(dTw);
		sb.append(", cIn=");
		sb.append(cIn);
		sb.append(", cGoogle=");
		sb.append(cGoogle);
		sb.append(", cFb=");
		sb.append(cFb);
		sb.append(", cTw=");
		sb.append(cTw);
		sb.append(", enableSubscribeToComments=");
		sb.append(enableSubscribeToComments);
		sb.append(", enableGroupUpdateNotification=");
		sb.append(enableGroupUpdateNotification);
		sb.append(", enableMemberUpdate=");
		sb.append(enableMemberUpdate);
		sb.append(", enableDiscussionUpdate=");
		sb.append(enableDiscussionUpdate);
		sb.append(", updateFrequency=");
		sb.append(updateFrequency);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPGroupPref toEntityModel() {
		SPGroupPrefImpl spGroupPrefImpl = new SPGroupPrefImpl();

		spGroupPrefImpl.setSpGroupPrefId(spGroupPrefId);
		spGroupPrefImpl.setGroupId(groupId);
		spGroupPrefImpl.setCompanyId(companyId);
		spGroupPrefImpl.setUserId(userId);

		if (userName == null) {
			spGroupPrefImpl.setUserName(StringPool.BLANK);
		}
		else {
			spGroupPrefImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spGroupPrefImpl.setCreateDate(null);
		}
		else {
			spGroupPrefImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spGroupPrefImpl.setModifiedDate(null);
		}
		else {
			spGroupPrefImpl.setModifiedDate(new Date(modifiedDate));
		}

		spGroupPrefImpl.setDIn(dIn);
		spGroupPrefImpl.setDGoogle(dGoogle);
		spGroupPrefImpl.setDFb(dFb);
		spGroupPrefImpl.setDTw(dTw);
		spGroupPrefImpl.setCIn(cIn);
		spGroupPrefImpl.setCGoogle(cGoogle);
		spGroupPrefImpl.setCFb(cFb);
		spGroupPrefImpl.setCTw(cTw);
		spGroupPrefImpl.setEnableSubscribeToComments(enableSubscribeToComments);
		spGroupPrefImpl.setEnableGroupUpdateNotification(enableGroupUpdateNotification);
		spGroupPrefImpl.setEnableMemberUpdate(enableMemberUpdate);
		spGroupPrefImpl.setEnableDiscussionUpdate(enableDiscussionUpdate);

		if (updateFrequency == null) {
			spGroupPrefImpl.setUpdateFrequency(StringPool.BLANK);
		}
		else {
			spGroupPrefImpl.setUpdateFrequency(updateFrequency);
		}

		spGroupPrefImpl.resetOriginalValues();

		return spGroupPrefImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spGroupPrefId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		dIn = objectInput.readBoolean();
		dGoogle = objectInput.readBoolean();
		dFb = objectInput.readBoolean();
		dTw = objectInput.readBoolean();
		cIn = objectInput.readBoolean();
		cGoogle = objectInput.readBoolean();
		cFb = objectInput.readBoolean();
		cTw = objectInput.readBoolean();
		enableSubscribeToComments = objectInput.readBoolean();
		enableGroupUpdateNotification = objectInput.readBoolean();
		enableMemberUpdate = objectInput.readBoolean();
		enableDiscussionUpdate = objectInput.readBoolean();
		updateFrequency = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spGroupPrefId);
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
		objectOutput.writeBoolean(dIn);
		objectOutput.writeBoolean(dGoogle);
		objectOutput.writeBoolean(dFb);
		objectOutput.writeBoolean(dTw);
		objectOutput.writeBoolean(cIn);
		objectOutput.writeBoolean(cGoogle);
		objectOutput.writeBoolean(cFb);
		objectOutput.writeBoolean(cTw);
		objectOutput.writeBoolean(enableSubscribeToComments);
		objectOutput.writeBoolean(enableGroupUpdateNotification);
		objectOutput.writeBoolean(enableMemberUpdate);
		objectOutput.writeBoolean(enableDiscussionUpdate);

		if (updateFrequency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updateFrequency);
		}
	}

	public long spGroupPrefId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean dIn;
	public boolean dGoogle;
	public boolean dFb;
	public boolean dTw;
	public boolean cIn;
	public boolean cGoogle;
	public boolean cFb;
	public boolean cTw;
	public boolean enableSubscribeToComments;
	public boolean enableGroupUpdateNotification;
	public boolean enableMemberUpdate;
	public boolean enableDiscussionUpdate;
	public String updateFrequency;
}