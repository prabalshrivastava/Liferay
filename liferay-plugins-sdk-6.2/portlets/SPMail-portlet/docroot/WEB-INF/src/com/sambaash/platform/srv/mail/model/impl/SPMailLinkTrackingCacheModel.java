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

import com.sambaash.platform.srv.mail.model.SPMailLinkTracking;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPMailLinkTracking in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPMailLinkTracking
 * @generated
 */
public class SPMailLinkTrackingCacheModel implements CacheModel<SPMailLinkTracking>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spMailLinkTrackingId=");
		sb.append(spMailLinkTrackingId);
		sb.append(", spMailCampaignId=");
		sb.append(spMailCampaignId);
		sb.append(", spMailCampaignEDMId=");
		sb.append(spMailCampaignEDMId);
		sb.append(", spMailCampaignSubscribersId=");
		sb.append(spMailCampaignSubscribersId);
		sb.append(", label=");
		sb.append(label);
		sb.append(", link=");
		sb.append(link);
		sb.append(", encryptedlink=");
		sb.append(encryptedlink);
		sb.append(", status=");
		sb.append(status);
		sb.append(", openedDate=");
		sb.append(openedDate);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPMailLinkTracking toEntityModel() {
		SPMailLinkTrackingImpl spMailLinkTrackingImpl = new SPMailLinkTrackingImpl();

		spMailLinkTrackingImpl.setSpMailLinkTrackingId(spMailLinkTrackingId);
		spMailLinkTrackingImpl.setSpMailCampaignId(spMailCampaignId);
		spMailLinkTrackingImpl.setSpMailCampaignEDMId(spMailCampaignEDMId);
		spMailLinkTrackingImpl.setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);

		if (label == null) {
			spMailLinkTrackingImpl.setLabel(StringPool.BLANK);
		}
		else {
			spMailLinkTrackingImpl.setLabel(label);
		}

		if (link == null) {
			spMailLinkTrackingImpl.setLink(StringPool.BLANK);
		}
		else {
			spMailLinkTrackingImpl.setLink(link);
		}

		if (encryptedlink == null) {
			spMailLinkTrackingImpl.setEncryptedlink(StringPool.BLANK);
		}
		else {
			spMailLinkTrackingImpl.setEncryptedlink(encryptedlink);
		}

		spMailLinkTrackingImpl.setStatus(status);

		if (openedDate == Long.MIN_VALUE) {
			spMailLinkTrackingImpl.setOpenedDate(null);
		}
		else {
			spMailLinkTrackingImpl.setOpenedDate(new Date(openedDate));
		}

		if (createDate == Long.MIN_VALUE) {
			spMailLinkTrackingImpl.setCreateDate(null);
		}
		else {
			spMailLinkTrackingImpl.setCreateDate(new Date(createDate));
		}

		spMailLinkTrackingImpl.resetOriginalValues();

		return spMailLinkTrackingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spMailLinkTrackingId = objectInput.readLong();
		spMailCampaignId = objectInput.readLong();
		spMailCampaignEDMId = objectInput.readLong();
		spMailCampaignSubscribersId = objectInput.readLong();
		label = objectInput.readUTF();
		link = objectInput.readUTF();
		encryptedlink = objectInput.readUTF();
		status = objectInput.readBoolean();
		openedDate = objectInput.readLong();
		createDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spMailLinkTrackingId);
		objectOutput.writeLong(spMailCampaignId);
		objectOutput.writeLong(spMailCampaignEDMId);
		objectOutput.writeLong(spMailCampaignSubscribersId);

		if (label == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(label);
		}

		if (link == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(link);
		}

		if (encryptedlink == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(encryptedlink);
		}

		objectOutput.writeBoolean(status);
		objectOutput.writeLong(openedDate);
		objectOutput.writeLong(createDate);
	}

	public long spMailLinkTrackingId;
	public long spMailCampaignId;
	public long spMailCampaignEDMId;
	public long spMailCampaignSubscribersId;
	public String label;
	public String link;
	public String encryptedlink;
	public boolean status;
	public long openedDate;
	public long createDate;
}