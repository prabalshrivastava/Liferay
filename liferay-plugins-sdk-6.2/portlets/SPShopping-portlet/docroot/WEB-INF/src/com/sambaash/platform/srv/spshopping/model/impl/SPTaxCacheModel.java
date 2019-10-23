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

package com.sambaash.platform.srv.spshopping.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spshopping.model.SPTax;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPTax in entity cache.
 *
 * @author pradeep
 * @see SPTax
 * @generated
 */
public class SPTaxCacheModel implements CacheModel<SPTax>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{spTaxId=");
		sb.append(spTaxId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", currencyCode=");
		sb.append(currencyCode);
		sb.append(", taxName=");
		sb.append(taxName);
		sb.append(", taxValue=");
		sb.append(taxValue);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPTax toEntityModel() {
		SPTaxImpl spTaxImpl = new SPTaxImpl();

		spTaxImpl.setSpTaxId(spTaxId);
		spTaxImpl.setGroupId(groupId);

		if (currencyCode == null) {
			spTaxImpl.setCurrencyCode(StringPool.BLANK);
		}
		else {
			spTaxImpl.setCurrencyCode(currencyCode);
		}

		if (taxName == null) {
			spTaxImpl.setTaxName(StringPool.BLANK);
		}
		else {
			spTaxImpl.setTaxName(taxName);
		}

		spTaxImpl.setTaxValue(taxValue);
		spTaxImpl.setCompanyId(companyId);
		spTaxImpl.setUserId(userId);

		if (userName == null) {
			spTaxImpl.setUserName(StringPool.BLANK);
		}
		else {
			spTaxImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spTaxImpl.setCreateDate(null);
		}
		else {
			spTaxImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spTaxImpl.setModifiedDate(null);
		}
		else {
			spTaxImpl.setModifiedDate(new Date(modifiedDate));
		}

		spTaxImpl.resetOriginalValues();

		return spTaxImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spTaxId = objectInput.readLong();
		groupId = objectInput.readLong();
		currencyCode = objectInput.readUTF();
		taxName = objectInput.readUTF();
		taxValue = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spTaxId);
		objectOutput.writeLong(groupId);

		if (currencyCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currencyCode);
		}

		if (taxName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taxName);
		}

		objectOutput.writeLong(taxValue);
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
	}

	public long spTaxId;
	public long groupId;
	public String currencyCode;
	public String taxName;
	public long taxValue;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}