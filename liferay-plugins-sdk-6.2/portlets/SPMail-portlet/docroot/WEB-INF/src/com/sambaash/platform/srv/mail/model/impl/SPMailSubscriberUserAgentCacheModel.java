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

import com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing SPMailSubscriberUserAgent in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPMailSubscriberUserAgent
 * @generated
 */
public class SPMailSubscriberUserAgentCacheModel implements CacheModel<SPMailSubscriberUserAgent>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{spMailSubscriberUserAgentId=");
		sb.append(spMailSubscriberUserAgentId);
		sb.append(", spMailCampaignSubscribersId=");
		sb.append(spMailCampaignSubscribersId);
		sb.append(", spMailCampaignId=");
		sb.append(spMailCampaignId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", type=");
		sb.append(type);
		sb.append(", typeName=");
		sb.append(typeName);
		sb.append(", deviceCategory=");
		sb.append(deviceCategory);
		sb.append(", family=");
		sb.append(family);
		sb.append(", operatingSystem=");
		sb.append(operatingSystem);
		sb.append(", versionNumber=");
		sb.append(versionNumber);
		sb.append(", userAgent=");
		sb.append(userAgent);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPMailSubscriberUserAgent toEntityModel() {
		SPMailSubscriberUserAgentImpl spMailSubscriberUserAgentImpl = new SPMailSubscriberUserAgentImpl();

		spMailSubscriberUserAgentImpl.setSpMailSubscriberUserAgentId(spMailSubscriberUserAgentId);
		spMailSubscriberUserAgentImpl.setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
		spMailSubscriberUserAgentImpl.setSpMailCampaignId(spMailCampaignId);

		if (name == null) {
			spMailSubscriberUserAgentImpl.setName(StringPool.BLANK);
		}
		else {
			spMailSubscriberUserAgentImpl.setName(name);
		}

		if (type == null) {
			spMailSubscriberUserAgentImpl.setType(StringPool.BLANK);
		}
		else {
			spMailSubscriberUserAgentImpl.setType(type);
		}

		if (typeName == null) {
			spMailSubscriberUserAgentImpl.setTypeName(StringPool.BLANK);
		}
		else {
			spMailSubscriberUserAgentImpl.setTypeName(typeName);
		}

		if (deviceCategory == null) {
			spMailSubscriberUserAgentImpl.setDeviceCategory(StringPool.BLANK);
		}
		else {
			spMailSubscriberUserAgentImpl.setDeviceCategory(deviceCategory);
		}

		if (family == null) {
			spMailSubscriberUserAgentImpl.setFamily(StringPool.BLANK);
		}
		else {
			spMailSubscriberUserAgentImpl.setFamily(family);
		}

		if (operatingSystem == null) {
			spMailSubscriberUserAgentImpl.setOperatingSystem(StringPool.BLANK);
		}
		else {
			spMailSubscriberUserAgentImpl.setOperatingSystem(operatingSystem);
		}

		if (versionNumber == null) {
			spMailSubscriberUserAgentImpl.setVersionNumber(StringPool.BLANK);
		}
		else {
			spMailSubscriberUserAgentImpl.setVersionNumber(versionNumber);
		}

		if (userAgent == null) {
			spMailSubscriberUserAgentImpl.setUserAgent(StringPool.BLANK);
		}
		else {
			spMailSubscriberUserAgentImpl.setUserAgent(userAgent);
		}

		spMailSubscriberUserAgentImpl.resetOriginalValues();

		return spMailSubscriberUserAgentImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spMailSubscriberUserAgentId = objectInput.readLong();
		spMailCampaignSubscribersId = objectInput.readLong();
		spMailCampaignId = objectInput.readLong();
		name = objectInput.readUTF();
		type = objectInput.readUTF();
		typeName = objectInput.readUTF();
		deviceCategory = objectInput.readUTF();
		family = objectInput.readUTF();
		operatingSystem = objectInput.readUTF();
		versionNumber = objectInput.readUTF();
		userAgent = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spMailSubscriberUserAgentId);
		objectOutput.writeLong(spMailCampaignSubscribersId);
		objectOutput.writeLong(spMailCampaignId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (type == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(type);
		}

		if (typeName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(typeName);
		}

		if (deviceCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(deviceCategory);
		}

		if (family == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(family);
		}

		if (operatingSystem == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(operatingSystem);
		}

		if (versionNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(versionNumber);
		}

		if (userAgent == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userAgent);
		}
	}

	public long spMailSubscriberUserAgentId;
	public long spMailCampaignSubscribersId;
	public long spMailCampaignId;
	public String name;
	public String type;
	public String typeName;
	public String deviceCategory;
	public String family;
	public String operatingSystem;
	public String versionNumber;
	public String userAgent;
}