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

package com.sambaash.platform.srv.mail.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.mail.model.SPMailCampaignEDM;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPMailCampaignEDM in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignEDM
 * @generated
 */
public class SPMailCampaignEDMCacheModel implements CacheModel<SPMailCampaignEDM>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(37);

		sb.append("{spMailCampaignEDMId=");
		sb.append(spMailCampaignEDMId);
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
		sb.append(", spMailCampaignId=");
		sb.append(spMailCampaignId);
		sb.append(", spMailTemplateId=");
		sb.append(spMailTemplateId);
		sb.append(", seqNo=");
		sb.append(seqNo);
		sb.append(", dayOfWeek=");
		sb.append(dayOfWeek);
		sb.append(", dayOfMonth=");
		sb.append(dayOfMonth);
		sb.append(", delayUnit=");
		sb.append(delayUnit);
		sb.append(", status=");
		sb.append(status);
		sb.append(", delayAmount=");
		sb.append(delayAmount);
		sb.append(", croneType=");
		sb.append(croneType);
		sb.append(", nextScheduleDateTime=");
		sb.append(nextScheduleDateTime);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPMailCampaignEDM toEntityModel() {
		SPMailCampaignEDMImpl spMailCampaignEDMImpl = new SPMailCampaignEDMImpl();

		spMailCampaignEDMImpl.setSpMailCampaignEDMId(spMailCampaignEDMId);
		spMailCampaignEDMImpl.setGroupId(groupId);
		spMailCampaignEDMImpl.setCompanyId(companyId);
		spMailCampaignEDMImpl.setUserId(userId);

		if (userName == null) {
			spMailCampaignEDMImpl.setUserName(StringPool.BLANK);
		}
		else {
			spMailCampaignEDMImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spMailCampaignEDMImpl.setCreateDate(null);
		}
		else {
			spMailCampaignEDMImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spMailCampaignEDMImpl.setModifiedDate(null);
		}
		else {
			spMailCampaignEDMImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (name == null) {
			spMailCampaignEDMImpl.setName(StringPool.BLANK);
		}
		else {
			spMailCampaignEDMImpl.setName(name);
		}

		spMailCampaignEDMImpl.setSpMailCampaignId(spMailCampaignId);
		spMailCampaignEDMImpl.setSpMailTemplateId(spMailTemplateId);
		spMailCampaignEDMImpl.setSeqNo(seqNo);
		spMailCampaignEDMImpl.setDayOfWeek(dayOfWeek);
		spMailCampaignEDMImpl.setDayOfMonth(dayOfMonth);

		if (delayUnit == null) {
			spMailCampaignEDMImpl.setDelayUnit(StringPool.BLANK);
		}
		else {
			spMailCampaignEDMImpl.setDelayUnit(delayUnit);
		}

		if (status == null) {
			spMailCampaignEDMImpl.setStatus(StringPool.BLANK);
		}
		else {
			spMailCampaignEDMImpl.setStatus(status);
		}

		spMailCampaignEDMImpl.setDelayAmount(delayAmount);

		if (croneType == null) {
			spMailCampaignEDMImpl.setCroneType(StringPool.BLANK);
		}
		else {
			spMailCampaignEDMImpl.setCroneType(croneType);
		}

		if (nextScheduleDateTime == Long.MIN_VALUE) {
			spMailCampaignEDMImpl.setNextScheduleDateTime(null);
		}
		else {
			spMailCampaignEDMImpl.setNextScheduleDateTime(new Date(
					nextScheduleDateTime));
		}

		spMailCampaignEDMImpl.resetOriginalValues();

		return spMailCampaignEDMImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spMailCampaignEDMId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		name = objectInput.readUTF();
		spMailCampaignId = objectInput.readLong();
		spMailTemplateId = objectInput.readLong();
		seqNo = objectInput.readInt();
		dayOfWeek = objectInput.readInt();
		dayOfMonth = objectInput.readInt();
		delayUnit = objectInput.readUTF();
		status = objectInput.readUTF();
		delayAmount = objectInput.readInt();
		croneType = objectInput.readUTF();
		nextScheduleDateTime = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spMailCampaignEDMId);
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

		objectOutput.writeLong(spMailCampaignId);
		objectOutput.writeLong(spMailTemplateId);
		objectOutput.writeInt(seqNo);
		objectOutput.writeInt(dayOfWeek);
		objectOutput.writeInt(dayOfMonth);

		if (delayUnit == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(delayUnit);
		}

		if (status == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(status);
		}

		objectOutput.writeInt(delayAmount);

		if (croneType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(croneType);
		}

		objectOutput.writeLong(nextScheduleDateTime);
	}

	public long spMailCampaignEDMId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String name;
	public long spMailCampaignId;
	public long spMailTemplateId;
	public int seqNo;
	public int dayOfWeek;
	public int dayOfMonth;
	public String delayUnit;
	public String status;
	public int delayAmount;
	public String croneType;
	public long nextScheduleDateTime;
}