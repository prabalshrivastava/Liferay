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

import com.sambaash.platform.srv.mail.model.SPMailCampaign;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPMailCampaign in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPMailCampaign
 * @generated
 */
public class SPMailCampaignCacheModel implements CacheModel<SPMailCampaign>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(57);

		sb.append("{spMailCampaignId=");
		sb.append(spMailCampaignId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", campaignName=");
		sb.append(campaignName);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", mainTempalteId=");
		sb.append(mainTempalteId);
		sb.append(", rem1TempalteId=");
		sb.append(rem1TempalteId);
		sb.append(", rem2TempalteId=");
		sb.append(rem2TempalteId);
		sb.append(", rem3TempalteId=");
		sb.append(rem3TempalteId);
		sb.append(", thankyouTempalteId=");
		sb.append(thankyouTempalteId);
		sb.append(", missedyouTempalteId=");
		sb.append(missedyouTempalteId);
		sb.append(", mainScheduledDate=");
		sb.append(mainScheduledDate);
		sb.append(", rem1ScheduledDate=");
		sb.append(rem1ScheduledDate);
		sb.append(", rem2ScheduledDate=");
		sb.append(rem2ScheduledDate);
		sb.append(", rem3ScheduledDate=");
		sb.append(rem3ScheduledDate);
		sb.append(", thankYouScheduledDate=");
		sb.append(thankYouScheduledDate);
		sb.append(", missedyouScheduledDate=");
		sb.append(missedyouScheduledDate);
		sb.append(", rsvpId=");
		sb.append(rsvpId);
		sb.append(", dlFileEntryId=");
		sb.append(dlFileEntryId);
		sb.append(", sentBy=");
		sb.append(sentBy);
		sb.append(", sentDate=");
		sb.append(sentDate);
		sb.append(", createBy=");
		sb.append(createBy);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedBy=");
		sb.append(modifiedBy);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", archive=");
		sb.append(archive);
		sb.append(", campaignType=");
		sb.append(campaignType);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPMailCampaign toEntityModel() {
		SPMailCampaignImpl spMailCampaignImpl = new SPMailCampaignImpl();

		spMailCampaignImpl.setSpMailCampaignId(spMailCampaignId);
		spMailCampaignImpl.setGroupId(groupId);
		spMailCampaignImpl.setCompanyId(companyId);

		if (campaignName == null) {
			spMailCampaignImpl.setCampaignName(StringPool.BLANK);
		}
		else {
			spMailCampaignImpl.setCampaignName(campaignName);
		}

		spMailCampaignImpl.setCategoryId(categoryId);
		spMailCampaignImpl.setMainTempalteId(mainTempalteId);
		spMailCampaignImpl.setRem1TempalteId(rem1TempalteId);
		spMailCampaignImpl.setRem2TempalteId(rem2TempalteId);
		spMailCampaignImpl.setRem3TempalteId(rem3TempalteId);
		spMailCampaignImpl.setThankyouTempalteId(thankyouTempalteId);
		spMailCampaignImpl.setMissedyouTempalteId(missedyouTempalteId);

		if (mainScheduledDate == Long.MIN_VALUE) {
			spMailCampaignImpl.setMainScheduledDate(null);
		}
		else {
			spMailCampaignImpl.setMainScheduledDate(new Date(mainScheduledDate));
		}

		if (rem1ScheduledDate == Long.MIN_VALUE) {
			spMailCampaignImpl.setRem1ScheduledDate(null);
		}
		else {
			spMailCampaignImpl.setRem1ScheduledDate(new Date(rem1ScheduledDate));
		}

		if (rem2ScheduledDate == Long.MIN_VALUE) {
			spMailCampaignImpl.setRem2ScheduledDate(null);
		}
		else {
			spMailCampaignImpl.setRem2ScheduledDate(new Date(rem2ScheduledDate));
		}

		if (rem3ScheduledDate == Long.MIN_VALUE) {
			spMailCampaignImpl.setRem3ScheduledDate(null);
		}
		else {
			spMailCampaignImpl.setRem3ScheduledDate(new Date(rem3ScheduledDate));
		}

		if (thankYouScheduledDate == Long.MIN_VALUE) {
			spMailCampaignImpl.setThankYouScheduledDate(null);
		}
		else {
			spMailCampaignImpl.setThankYouScheduledDate(new Date(
					thankYouScheduledDate));
		}

		if (missedyouScheduledDate == Long.MIN_VALUE) {
			spMailCampaignImpl.setMissedyouScheduledDate(null);
		}
		else {
			spMailCampaignImpl.setMissedyouScheduledDate(new Date(
					missedyouScheduledDate));
		}

		spMailCampaignImpl.setRsvpId(rsvpId);
		spMailCampaignImpl.setDlFileEntryId(dlFileEntryId);
		spMailCampaignImpl.setSentBy(sentBy);

		if (sentDate == Long.MIN_VALUE) {
			spMailCampaignImpl.setSentDate(null);
		}
		else {
			spMailCampaignImpl.setSentDate(new Date(sentDate));
		}

		spMailCampaignImpl.setCreateBy(createBy);

		if (createDate == Long.MIN_VALUE) {
			spMailCampaignImpl.setCreateDate(null);
		}
		else {
			spMailCampaignImpl.setCreateDate(new Date(createDate));
		}

		spMailCampaignImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			spMailCampaignImpl.setModifiedDate(null);
		}
		else {
			spMailCampaignImpl.setModifiedDate(new Date(modifiedDate));
		}

		spMailCampaignImpl.setStatus(status);
		spMailCampaignImpl.setArchive(archive);

		if (campaignType == null) {
			spMailCampaignImpl.setCampaignType(StringPool.BLANK);
		}
		else {
			spMailCampaignImpl.setCampaignType(campaignType);
		}

		spMailCampaignImpl.resetOriginalValues();

		return spMailCampaignImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spMailCampaignId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		campaignName = objectInput.readUTF();
		categoryId = objectInput.readLong();
		mainTempalteId = objectInput.readLong();
		rem1TempalteId = objectInput.readLong();
		rem2TempalteId = objectInput.readLong();
		rem3TempalteId = objectInput.readLong();
		thankyouTempalteId = objectInput.readLong();
		missedyouTempalteId = objectInput.readLong();
		mainScheduledDate = objectInput.readLong();
		rem1ScheduledDate = objectInput.readLong();
		rem2ScheduledDate = objectInput.readLong();
		rem3ScheduledDate = objectInput.readLong();
		thankYouScheduledDate = objectInput.readLong();
		missedyouScheduledDate = objectInput.readLong();
		rsvpId = objectInput.readLong();
		dlFileEntryId = objectInput.readLong();
		sentBy = objectInput.readLong();
		sentDate = objectInput.readLong();
		createBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		status = objectInput.readInt();
		archive = objectInput.readBoolean();
		campaignType = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spMailCampaignId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);

		if (campaignName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(campaignName);
		}

		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(mainTempalteId);
		objectOutput.writeLong(rem1TempalteId);
		objectOutput.writeLong(rem2TempalteId);
		objectOutput.writeLong(rem3TempalteId);
		objectOutput.writeLong(thankyouTempalteId);
		objectOutput.writeLong(missedyouTempalteId);
		objectOutput.writeLong(mainScheduledDate);
		objectOutput.writeLong(rem1ScheduledDate);
		objectOutput.writeLong(rem2ScheduledDate);
		objectOutput.writeLong(rem3ScheduledDate);
		objectOutput.writeLong(thankYouScheduledDate);
		objectOutput.writeLong(missedyouScheduledDate);
		objectOutput.writeLong(rsvpId);
		objectOutput.writeLong(dlFileEntryId);
		objectOutput.writeLong(sentBy);
		objectOutput.writeLong(sentDate);
		objectOutput.writeLong(createBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeInt(status);
		objectOutput.writeBoolean(archive);

		if (campaignType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(campaignType);
		}
	}

	public long spMailCampaignId;
	public long groupId;
	public long companyId;
	public String campaignName;
	public long categoryId;
	public long mainTempalteId;
	public long rem1TempalteId;
	public long rem2TempalteId;
	public long rem3TempalteId;
	public long thankyouTempalteId;
	public long missedyouTempalteId;
	public long mainScheduledDate;
	public long rem1ScheduledDate;
	public long rem2ScheduledDate;
	public long rem3ScheduledDate;
	public long thankYouScheduledDate;
	public long missedyouScheduledDate;
	public long rsvpId;
	public long dlFileEntryId;
	public long sentBy;
	public long sentDate;
	public long createBy;
	public long createDate;
	public long modifiedBy;
	public long modifiedDate;
	public int status;
	public boolean archive;
	public String campaignType;
}