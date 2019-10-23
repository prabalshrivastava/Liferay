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

package com.sambaash.platform.srv.spprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spprofile.model.ProfilePreferences;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing ProfilePreferences in entity cache.
 *
 * @author harini
 * @see ProfilePreferences
 * @generated
 */
public class ProfilePreferencesCacheModel implements CacheModel<ProfilePreferences>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{proferenceId=");
		sb.append(proferenceId);
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
		sb.append(", layoutId=");
		sb.append(layoutId);
		sb.append(", portletId=");
		sb.append(portletId);
		sb.append(", preferenceName=");
		sb.append(preferenceName);
		sb.append(", portletPreferences=");
		sb.append(portletPreferences);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public ProfilePreferences toEntityModel() {
		ProfilePreferencesImpl profilePreferencesImpl = new ProfilePreferencesImpl();

		profilePreferencesImpl.setProferenceId(proferenceId);
		profilePreferencesImpl.setGroupId(groupId);
		profilePreferencesImpl.setCompanyId(companyId);
		profilePreferencesImpl.setUserId(userId);

		if (userName == null) {
			profilePreferencesImpl.setUserName(StringPool.BLANK);
		}
		else {
			profilePreferencesImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			profilePreferencesImpl.setCreateDate(null);
		}
		else {
			profilePreferencesImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			profilePreferencesImpl.setModifiedDate(null);
		}
		else {
			profilePreferencesImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (layoutId == null) {
			profilePreferencesImpl.setLayoutId(StringPool.BLANK);
		}
		else {
			profilePreferencesImpl.setLayoutId(layoutId);
		}

		if (portletId == null) {
			profilePreferencesImpl.setPortletId(StringPool.BLANK);
		}
		else {
			profilePreferencesImpl.setPortletId(portletId);
		}

		if (preferenceName == null) {
			profilePreferencesImpl.setPreferenceName(StringPool.BLANK);
		}
		else {
			profilePreferencesImpl.setPreferenceName(preferenceName);
		}

		if (portletPreferences == null) {
			profilePreferencesImpl.setPortletPreferences(StringPool.BLANK);
		}
		else {
			profilePreferencesImpl.setPortletPreferences(portletPreferences);
		}

		profilePreferencesImpl.resetOriginalValues();

		return profilePreferencesImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		proferenceId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		layoutId = objectInput.readUTF();
		portletId = objectInput.readUTF();
		preferenceName = objectInput.readUTF();
		portletPreferences = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(proferenceId);
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

		if (layoutId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(layoutId);
		}

		if (portletId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletId);
		}

		if (preferenceName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(preferenceName);
		}

		if (portletPreferences == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(portletPreferences);
		}
	}

	public long proferenceId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String layoutId;
	public String portletId;
	public String preferenceName;
	public String portletPreferences;
}