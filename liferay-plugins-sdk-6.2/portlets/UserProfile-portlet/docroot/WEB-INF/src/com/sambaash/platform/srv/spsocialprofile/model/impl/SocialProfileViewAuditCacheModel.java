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

package com.sambaash.platform.srv.spsocialprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfileViewAudit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialProfileViewAudit in entity cache.
 *
 * @author gauravvijayvergia
 * @see SocialProfileViewAudit
 * @generated
 */
public class SocialProfileViewAuditCacheModel implements CacheModel<SocialProfileViewAudit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", socialProfileViewAuditId=");
		sb.append(socialProfileViewAuditId);
		sb.append(", loggedInUserId=");
		sb.append(loggedInUserId);
		sb.append(", profileUserId=");
		sb.append(profileUserId);
		sb.append(", lastViewDate=");
		sb.append(lastViewDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialProfileViewAudit toEntityModel() {
		SocialProfileViewAuditImpl socialProfileViewAuditImpl = new SocialProfileViewAuditImpl();

		if (uuid == null) {
			socialProfileViewAuditImpl.setUuid(StringPool.BLANK);
		}
		else {
			socialProfileViewAuditImpl.setUuid(uuid);
		}

		socialProfileViewAuditImpl.setSocialProfileViewAuditId(socialProfileViewAuditId);
		socialProfileViewAuditImpl.setLoggedInUserId(loggedInUserId);
		socialProfileViewAuditImpl.setProfileUserId(profileUserId);

		if (lastViewDate == Long.MIN_VALUE) {
			socialProfileViewAuditImpl.setLastViewDate(null);
		}
		else {
			socialProfileViewAuditImpl.setLastViewDate(new Date(lastViewDate));
		}

		socialProfileViewAuditImpl.resetOriginalValues();

		return socialProfileViewAuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		socialProfileViewAuditId = objectInput.readLong();
		loggedInUserId = objectInput.readLong();
		profileUserId = objectInput.readLong();
		lastViewDate = objectInput.readLong();
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

		objectOutput.writeLong(socialProfileViewAuditId);
		objectOutput.writeLong(loggedInUserId);
		objectOutput.writeLong(profileUserId);
		objectOutput.writeLong(lastViewDate);
	}

	public String uuid;
	public long socialProfileViewAuditId;
	public long loggedInUserId;
	public long profileUserId;
	public long lastViewDate;
}