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

import com.sambaash.platform.srv.mail.model.SPMailUnsubscribe;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPMailUnsubscribe in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPMailUnsubscribe
 * @generated
 */
public class SPMailUnsubscribeCacheModel implements CacheModel<SPMailUnsubscribe>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{spMailUnsubscribeId=");
		sb.append(spMailUnsubscribeId);
		sb.append(", categoryId=");
		sb.append(categoryId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", unsubscribeDate=");
		sb.append(unsubscribeDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPMailUnsubscribe toEntityModel() {
		SPMailUnsubscribeImpl spMailUnsubscribeImpl = new SPMailUnsubscribeImpl();

		spMailUnsubscribeImpl.setSpMailUnsubscribeId(spMailUnsubscribeId);
		spMailUnsubscribeImpl.setCategoryId(categoryId);
		spMailUnsubscribeImpl.setUserId(userId);

		if (emailAddress == null) {
			spMailUnsubscribeImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spMailUnsubscribeImpl.setEmailAddress(emailAddress);
		}

		if (unsubscribeDate == Long.MIN_VALUE) {
			spMailUnsubscribeImpl.setUnsubscribeDate(null);
		}
		else {
			spMailUnsubscribeImpl.setUnsubscribeDate(new Date(unsubscribeDate));
		}

		spMailUnsubscribeImpl.resetOriginalValues();

		return spMailUnsubscribeImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spMailUnsubscribeId = objectInput.readLong();
		categoryId = objectInput.readLong();
		userId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		unsubscribeDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spMailUnsubscribeId);
		objectOutput.writeLong(categoryId);
		objectOutput.writeLong(userId);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		objectOutput.writeLong(unsubscribeDate);
	}

	public long spMailUnsubscribeId;
	public long categoryId;
	public long userId;
	public String emailAddress;
	public long unsubscribeDate;
}