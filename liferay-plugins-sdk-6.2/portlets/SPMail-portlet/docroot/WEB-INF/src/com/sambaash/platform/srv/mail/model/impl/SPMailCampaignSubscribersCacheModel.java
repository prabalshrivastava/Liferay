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

import com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPMailCampaignSubscribers in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignSubscribers
 * @generated
 */
public class SPMailCampaignSubscribersCacheModel implements CacheModel<SPMailCampaignSubscribers>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(49);

		sb.append("{spMailCampaignSubscribersId=");
		sb.append(spMailCampaignSubscribersId);
		sb.append(", spMailCampaignId=");
		sb.append(spMailCampaignId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", parentSubscriberId=");
		sb.append(parentSubscriberId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", spMailType=");
		sb.append(spMailType);
		sb.append(", messageId=");
		sb.append(messageId);
		sb.append(", opened=");
		sb.append(opened);
		sb.append(", countryName=");
		sb.append(countryName);
		sb.append(", city=");
		sb.append(city);
		sb.append(", regionName=");
		sb.append(regionName);
		sb.append(", areaCode=");
		sb.append(areaCode);
		sb.append(", latitude=");
		sb.append(latitude);
		sb.append(", longitude=");
		sb.append(longitude);
		sb.append(", ipAddress=");
		sb.append(ipAddress);
		sb.append(", webVersion=");
		sb.append(webVersion);
		sb.append(", openedDate=");
		sb.append(openedDate);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPMailCampaignSubscribers toEntityModel() {
		SPMailCampaignSubscribersImpl spMailCampaignSubscribersImpl = new SPMailCampaignSubscribersImpl();

		spMailCampaignSubscribersImpl.setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
		spMailCampaignSubscribersImpl.setSpMailCampaignId(spMailCampaignId);
		spMailCampaignSubscribersImpl.setUserId(userId);
		spMailCampaignSubscribersImpl.setParentSubscriberId(parentSubscriberId);

		if (emailAddress == null) {
			spMailCampaignSubscribersImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setEmailAddress(emailAddress);
		}

		if (firstName == null) {
			spMailCampaignSubscribersImpl.setFirstName(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			spMailCampaignSubscribersImpl.setLastName(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setLastName(lastName);
		}

		spMailCampaignSubscribersImpl.setSpMailType(spMailType);

		if (messageId == null) {
			spMailCampaignSubscribersImpl.setMessageId(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setMessageId(messageId);
		}

		spMailCampaignSubscribersImpl.setOpened(opened);

		if (countryName == null) {
			spMailCampaignSubscribersImpl.setCountryName(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setCountryName(countryName);
		}

		if (city == null) {
			spMailCampaignSubscribersImpl.setCity(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setCity(city);
		}

		if (regionName == null) {
			spMailCampaignSubscribersImpl.setRegionName(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setRegionName(regionName);
		}

		spMailCampaignSubscribersImpl.setAreaCode(areaCode);

		if (latitude == null) {
			spMailCampaignSubscribersImpl.setLatitude(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setLatitude(latitude);
		}

		if (longitude == null) {
			spMailCampaignSubscribersImpl.setLongitude(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setLongitude(longitude);
		}

		if (ipAddress == null) {
			spMailCampaignSubscribersImpl.setIpAddress(StringPool.BLANK);
		}
		else {
			spMailCampaignSubscribersImpl.setIpAddress(ipAddress);
		}

		spMailCampaignSubscribersImpl.setWebVersion(webVersion);

		if (openedDate == Long.MIN_VALUE) {
			spMailCampaignSubscribersImpl.setOpenedDate(null);
		}
		else {
			spMailCampaignSubscribersImpl.setOpenedDate(new Date(openedDate));
		}

		spMailCampaignSubscribersImpl.setCreateBy(createBy);

		if (createDate == Long.MIN_VALUE) {
			spMailCampaignSubscribersImpl.setCreateDate(null);
		}
		else {
			spMailCampaignSubscribersImpl.setCreateDate(new Date(createDate));
		}

		spMailCampaignSubscribersImpl.setModifiedBy(modifiedBy);

		if (modifiedDate == Long.MIN_VALUE) {
			spMailCampaignSubscribersImpl.setModifiedDate(null);
		}
		else {
			spMailCampaignSubscribersImpl.setModifiedDate(new Date(modifiedDate));
		}

		spMailCampaignSubscribersImpl.setStatus(status);

		spMailCampaignSubscribersImpl.resetOriginalValues();

		return spMailCampaignSubscribersImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spMailCampaignSubscribersId = objectInput.readLong();
		spMailCampaignId = objectInput.readLong();
		userId = objectInput.readLong();
		parentSubscriberId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		spMailType = objectInput.readInt();
		messageId = objectInput.readUTF();
		opened = objectInput.readBoolean();
		countryName = objectInput.readUTF();
		city = objectInput.readUTF();
		regionName = objectInput.readUTF();
		areaCode = objectInput.readInt();
		latitude = objectInput.readUTF();
		longitude = objectInput.readUTF();
		ipAddress = objectInput.readUTF();
		webVersion = objectInput.readBoolean();
		openedDate = objectInput.readLong();
		createBy = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedBy = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		status = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spMailCampaignSubscribersId);
		objectOutput.writeLong(spMailCampaignId);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(parentSubscriberId);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		objectOutput.writeInt(spMailType);

		if (messageId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(messageId);
		}

		objectOutput.writeBoolean(opened);

		if (countryName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryName);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (regionName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionName);
		}

		objectOutput.writeInt(areaCode);

		if (latitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(latitude);
		}

		if (longitude == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longitude);
		}

		if (ipAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ipAddress);
		}

		objectOutput.writeBoolean(webVersion);
		objectOutput.writeLong(openedDate);
		objectOutput.writeLong(createBy);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedBy);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeInt(status);
	}

	public long spMailCampaignSubscribersId;
	public long spMailCampaignId;
	public long userId;
	public long parentSubscriberId;
	public String emailAddress;
	public String firstName;
	public String lastName;
	public int spMailType;
	public String messageId;
	public boolean opened;
	public String countryName;
	public String city;
	public String regionName;
	public int areaCode;
	public String latitude;
	public String longitude;
	public String ipAddress;
	public boolean webVersion;
	public long openedDate;
	public long createBy;
	public long createDate;
	public long modifiedBy;
	public long modifiedDate;
	public int status;
}