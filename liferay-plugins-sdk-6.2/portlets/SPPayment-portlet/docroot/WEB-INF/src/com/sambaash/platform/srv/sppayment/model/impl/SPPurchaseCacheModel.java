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

import com.sambaash.platform.srv.sppayment.model.SPPurchase;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPPurchase in entity cache.
 *
 * @author pradeep
 * @see SPPurchase
 * @generated
 */
public class SPPurchaseCacheModel implements CacheModel<SPPurchase>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{spPurchaseId=");
		sb.append(spPurchaseId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", cartId=");
		sb.append(cartId);
		sb.append(", extPaymentId=");
		sb.append(extPaymentId);
		sb.append(", extStatus=");
		sb.append(extStatus);
		sb.append(", extErrorCode=");
		sb.append(extErrorCode);
		sb.append(", extErrorMsg=");
		sb.append(extErrorMsg);
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
	public SPPurchase toEntityModel() {
		SPPurchaseImpl spPurchaseImpl = new SPPurchaseImpl();

		spPurchaseImpl.setSpPurchaseId(spPurchaseId);
		spPurchaseImpl.setGroupId(groupId);
		spPurchaseImpl.setCartId(cartId);

		if (extPaymentId == null) {
			spPurchaseImpl.setExtPaymentId(StringPool.BLANK);
		}
		else {
			spPurchaseImpl.setExtPaymentId(extPaymentId);
		}

		if (extStatus == null) {
			spPurchaseImpl.setExtStatus(StringPool.BLANK);
		}
		else {
			spPurchaseImpl.setExtStatus(extStatus);
		}

		spPurchaseImpl.setExtErrorCode(extErrorCode);

		if (extErrorMsg == null) {
			spPurchaseImpl.setExtErrorMsg(StringPool.BLANK);
		}
		else {
			spPurchaseImpl.setExtErrorMsg(extErrorMsg);
		}

		spPurchaseImpl.setCompanyId(companyId);
		spPurchaseImpl.setUserId(userId);

		if (userName == null) {
			spPurchaseImpl.setUserName(StringPool.BLANK);
		}
		else {
			spPurchaseImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spPurchaseImpl.setCreateDate(null);
		}
		else {
			spPurchaseImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spPurchaseImpl.setModifiedDate(null);
		}
		else {
			spPurchaseImpl.setModifiedDate(new Date(modifiedDate));
		}

		spPurchaseImpl.resetOriginalValues();

		return spPurchaseImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spPurchaseId = objectInput.readLong();
		groupId = objectInput.readLong();
		cartId = objectInput.readLong();
		extPaymentId = objectInput.readUTF();
		extStatus = objectInput.readUTF();
		extErrorCode = objectInput.readLong();
		extErrorMsg = objectInput.readUTF();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spPurchaseId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(cartId);

		if (extPaymentId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extPaymentId);
		}

		if (extStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extStatus);
		}

		objectOutput.writeLong(extErrorCode);

		if (extErrorMsg == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extErrorMsg);
		}

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

	public long spPurchaseId;
	public long groupId;
	public long cartId;
	public String extPaymentId;
	public String extStatus;
	public long extErrorCode;
	public String extErrorMsg;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}