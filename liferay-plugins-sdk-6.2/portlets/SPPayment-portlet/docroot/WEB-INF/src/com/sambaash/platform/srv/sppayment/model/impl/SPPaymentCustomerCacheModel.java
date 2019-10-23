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

package com.sambaash.platform.srv.sppayment.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.sppayment.model.SPPaymentCustomer;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPPaymentCustomer in entity cache.
 *
 * @author pradeep
 * @see SPPaymentCustomer
 * @generated
 */
public class SPPaymentCustomerCacheModel implements CacheModel<SPPaymentCustomer>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{sPPaymentCustomerId=");
		sb.append(sPPaymentCustomerId);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", providerCustomerId=");
		sb.append(providerCustomerId);
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
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPPaymentCustomer toEntityModel() {
		SPPaymentCustomerImpl spPaymentCustomerImpl = new SPPaymentCustomerImpl();

		spPaymentCustomerImpl.setSPPaymentCustomerId(sPPaymentCustomerId);

		if (emailAddress == null) {
			spPaymentCustomerImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spPaymentCustomerImpl.setEmailAddress(emailAddress);
		}

		if (providerCustomerId == null) {
			spPaymentCustomerImpl.setProviderCustomerId(StringPool.BLANK);
		}
		else {
			spPaymentCustomerImpl.setProviderCustomerId(providerCustomerId);
		}

		spPaymentCustomerImpl.setGroupId(groupId);
		spPaymentCustomerImpl.setCompanyId(companyId);
		spPaymentCustomerImpl.setUserId(userId);

		if (userName == null) {
			spPaymentCustomerImpl.setUserName(StringPool.BLANK);
		}
		else {
			spPaymentCustomerImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spPaymentCustomerImpl.setCreateDate(null);
		}
		else {
			spPaymentCustomerImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spPaymentCustomerImpl.setModifiedDate(null);
		}
		else {
			spPaymentCustomerImpl.setModifiedDate(new Date(modifiedDate));
		}

		spPaymentCustomerImpl.resetOriginalValues();

		return spPaymentCustomerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		sPPaymentCustomerId = objectInput.readLong();
		emailAddress = objectInput.readUTF();
		providerCustomerId = objectInput.readUTF();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(sPPaymentCustomerId);

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (providerCustomerId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(providerCustomerId);
		}

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
	}

	public long sPPaymentCustomerId;
	public String emailAddress;
	public String providerCustomerId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}