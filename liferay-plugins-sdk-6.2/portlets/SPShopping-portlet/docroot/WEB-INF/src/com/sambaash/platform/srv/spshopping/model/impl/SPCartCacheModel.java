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

import com.sambaash.platform.srv.spshopping.model.SPCart;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPCart in entity cache.
 *
 * @author pradeep
 * @see SPCart
 * @generated
 */
public class SPCartCacheModel implements CacheModel<SPCart>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{spCartId=");
		sb.append(spCartId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", totalPrice=");
		sb.append(totalPrice);
		sb.append(", userRemarks=");
		sb.append(userRemarks);
		sb.append(", status=");
		sb.append(status);
		sb.append(", transactionDetails=");
		sb.append(transactionDetails);
		sb.append(", orderPage=");
		sb.append(orderPage);
		sb.append(", rsvpDetailId=");
		sb.append(rsvpDetailId);
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
	public SPCart toEntityModel() {
		SPCartImpl spCartImpl = new SPCartImpl();

		spCartImpl.setSpCartId(spCartId);
		spCartImpl.setGroupId(groupId);

		if (discount == null) {
			spCartImpl.setDiscount(StringPool.BLANK);
		}
		else {
			spCartImpl.setDiscount(discount);
		}

		if (totalPrice == null) {
			spCartImpl.setTotalPrice(StringPool.BLANK);
		}
		else {
			spCartImpl.setTotalPrice(totalPrice);
		}

		if (userRemarks == null) {
			spCartImpl.setUserRemarks(StringPool.BLANK);
		}
		else {
			spCartImpl.setUserRemarks(userRemarks);
		}

		spCartImpl.setStatus(status);

		if (transactionDetails == null) {
			spCartImpl.setTransactionDetails(StringPool.BLANK);
		}
		else {
			spCartImpl.setTransactionDetails(transactionDetails);
		}

		if (orderPage == null) {
			spCartImpl.setOrderPage(StringPool.BLANK);
		}
		else {
			spCartImpl.setOrderPage(orderPage);
		}

		spCartImpl.setRsvpDetailId(rsvpDetailId);
		spCartImpl.setCompanyId(companyId);
		spCartImpl.setUserId(userId);

		if (userName == null) {
			spCartImpl.setUserName(StringPool.BLANK);
		}
		else {
			spCartImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spCartImpl.setCreateDate(null);
		}
		else {
			spCartImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spCartImpl.setModifiedDate(null);
		}
		else {
			spCartImpl.setModifiedDate(new Date(modifiedDate));
		}

		spCartImpl.resetOriginalValues();

		return spCartImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCartId = objectInput.readLong();
		groupId = objectInput.readLong();
		discount = objectInput.readUTF();
		totalPrice = objectInput.readUTF();
		userRemarks = objectInput.readUTF();
		status = objectInput.readInt();
		transactionDetails = objectInput.readUTF();
		orderPage = objectInput.readUTF();
		rsvpDetailId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCartId);
		objectOutput.writeLong(groupId);

		if (discount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(discount);
		}

		if (totalPrice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(totalPrice);
		}

		if (userRemarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userRemarks);
		}

		objectOutput.writeInt(status);

		if (transactionDetails == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(transactionDetails);
		}

		if (orderPage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orderPage);
		}

		objectOutput.writeLong(rsvpDetailId);
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

	public long spCartId;
	public long groupId;
	public String discount;
	public String totalPrice;
	public String userRemarks;
	public int status;
	public String transactionDetails;
	public String orderPage;
	public long rsvpDetailId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}