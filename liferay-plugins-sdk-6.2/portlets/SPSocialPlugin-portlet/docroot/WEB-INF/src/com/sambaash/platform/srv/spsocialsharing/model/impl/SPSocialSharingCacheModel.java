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

package com.sambaash.platform.srv.spsocialsharing.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spsocialsharing.model.SPSocialSharing;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPSocialSharing in entity cache.
 *
 * @author harini
 * @see SPSocialSharing
 * @generated
 */
public class SPSocialSharingCacheModel implements CacheModel<SPSocialSharing>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", spSocialSharingId=");
		sb.append(spSocialSharingId);
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
		sb.append(", classNameId=");
		sb.append(classNameId);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", facebook=");
		sb.append(facebook);
		sb.append(", twitter=");
		sb.append(twitter);
		sb.append(", linkedin=");
		sb.append(linkedin);
		sb.append(", yahoo=");
		sb.append(yahoo);
		sb.append(", google=");
		sb.append(google);
		sb.append(", facebookPage=");
		sb.append(facebookPage);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPSocialSharing toEntityModel() {
		SPSocialSharingImpl spSocialSharingImpl = new SPSocialSharingImpl();

		if (uuid == null) {
			spSocialSharingImpl.setUuid(StringPool.BLANK);
		}
		else {
			spSocialSharingImpl.setUuid(uuid);
		}

		spSocialSharingImpl.setSpSocialSharingId(spSocialSharingId);
		spSocialSharingImpl.setGroupId(groupId);
		spSocialSharingImpl.setCompanyId(companyId);
		spSocialSharingImpl.setUserId(userId);

		if (userName == null) {
			spSocialSharingImpl.setUserName(StringPool.BLANK);
		}
		else {
			spSocialSharingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spSocialSharingImpl.setCreateDate(null);
		}
		else {
			spSocialSharingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spSocialSharingImpl.setModifiedDate(null);
		}
		else {
			spSocialSharingImpl.setModifiedDate(new Date(modifiedDate));
		}

		spSocialSharingImpl.setClassNameId(classNameId);
		spSocialSharingImpl.setClassPK(classPK);
		spSocialSharingImpl.setFacebook(facebook);
		spSocialSharingImpl.setTwitter(twitter);
		spSocialSharingImpl.setLinkedin(linkedin);
		spSocialSharingImpl.setYahoo(yahoo);
		spSocialSharingImpl.setGoogle(google);
		spSocialSharingImpl.setFacebookPage(facebookPage);

		spSocialSharingImpl.resetOriginalValues();

		return spSocialSharingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		spSocialSharingId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		classNameId = objectInput.readLong();
		classPK = objectInput.readLong();
		facebook = objectInput.readInt();
		twitter = objectInput.readInt();
		linkedin = objectInput.readInt();
		yahoo = objectInput.readInt();
		google = objectInput.readInt();
		facebookPage = objectInput.readInt();
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

		objectOutput.writeLong(spSocialSharingId);
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
		objectOutput.writeLong(classNameId);
		objectOutput.writeLong(classPK);
		objectOutput.writeInt(facebook);
		objectOutput.writeInt(twitter);
		objectOutput.writeInt(linkedin);
		objectOutput.writeInt(yahoo);
		objectOutput.writeInt(google);
		objectOutput.writeInt(facebookPage);
	}

	public String uuid;
	public long spSocialSharingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long classNameId;
	public long classPK;
	public int facebook;
	public int twitter;
	public int linkedin;
	public int yahoo;
	public int google;
	public int facebookPage;
}