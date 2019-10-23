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
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialProfilePullAudit in entity cache.
 *
 * @author gauravvijayvergia
 * @see SocialProfilePullAudit
 * @generated
 */
public class SocialProfilePullAuditCacheModel implements CacheModel<SocialProfilePullAudit>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{userId=");
		sb.append(userId);
		sb.append(", socialNetworkProfileId=");
		sb.append(socialNetworkProfileId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", lastQueriedDate=");
		sb.append(lastQueriedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialProfilePullAudit toEntityModel() {
		SocialProfilePullAuditImpl socialProfilePullAuditImpl = new SocialProfilePullAuditImpl();

		socialProfilePullAuditImpl.setUserId(userId);
		socialProfilePullAuditImpl.setSocialNetworkProfileId(socialNetworkProfileId);
		socialProfilePullAuditImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			socialProfilePullAuditImpl.setCreateDate(null);
		}
		else {
			socialProfilePullAuditImpl.setCreateDate(new Date(createDate));
		}

		if (lastQueriedDate == Long.MIN_VALUE) {
			socialProfilePullAuditImpl.setLastQueriedDate(null);
		}
		else {
			socialProfilePullAuditImpl.setLastQueriedDate(new Date(
					lastQueriedDate));
		}

		socialProfilePullAuditImpl.resetOriginalValues();

		return socialProfilePullAuditImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userId = objectInput.readLong();
		socialNetworkProfileId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		lastQueriedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userId);
		objectOutput.writeLong(socialNetworkProfileId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(lastQueriedDate);
	}

	public long userId;
	public long socialNetworkProfileId;
	public long companyId;
	public long createDate;
	public long lastQueriedDate;
}