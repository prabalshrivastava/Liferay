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

import com.sambaash.platform.srv.spshopping.model.SPCartPackage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPCartPackage in entity cache.
 *
 * @author pradeep
 * @see SPCartPackage
 * @generated
 */
public class SPCartPackageCacheModel implements CacheModel<SPCartPackage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(33);

		sb.append("{spCartPackageId=");
		sb.append(spCartPackageId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", cartId=");
		sb.append(cartId);
		sb.append(", packageId=");
		sb.append(packageId);
		sb.append(", selectedCurrency=");
		sb.append(selectedCurrency);
		sb.append(", usedDiscountRefId=");
		sb.append(usedDiscountRefId);
		sb.append(", usedDiscountRefPCId=");
		sb.append(usedDiscountRefPCId);
		sb.append(", discount=");
		sb.append(discount);
		sb.append(", initialPrice=");
		sb.append(initialPrice);
		sb.append(", totalPrice=");
		sb.append(totalPrice);
		sb.append(", remarks=");
		sb.append(remarks);
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
	public SPCartPackage toEntityModel() {
		SPCartPackageImpl spCartPackageImpl = new SPCartPackageImpl();

		spCartPackageImpl.setSpCartPackageId(spCartPackageId);
		spCartPackageImpl.setGroupId(groupId);
		spCartPackageImpl.setCartId(cartId);
		spCartPackageImpl.setPackageId(packageId);

		if (selectedCurrency == null) {
			spCartPackageImpl.setSelectedCurrency(StringPool.BLANK);
		}
		else {
			spCartPackageImpl.setSelectedCurrency(selectedCurrency);
		}

		spCartPackageImpl.setUsedDiscountRefId(usedDiscountRefId);
		spCartPackageImpl.setUsedDiscountRefPCId(usedDiscountRefPCId);

		if (discount == null) {
			spCartPackageImpl.setDiscount(StringPool.BLANK);
		}
		else {
			spCartPackageImpl.setDiscount(discount);
		}

		if (initialPrice == null) {
			spCartPackageImpl.setInitialPrice(StringPool.BLANK);
		}
		else {
			spCartPackageImpl.setInitialPrice(initialPrice);
		}

		if (totalPrice == null) {
			spCartPackageImpl.setTotalPrice(StringPool.BLANK);
		}
		else {
			spCartPackageImpl.setTotalPrice(totalPrice);
		}

		if (remarks == null) {
			spCartPackageImpl.setRemarks(StringPool.BLANK);
		}
		else {
			spCartPackageImpl.setRemarks(remarks);
		}

		spCartPackageImpl.setCompanyId(companyId);
		spCartPackageImpl.setUserId(userId);

		if (userName == null) {
			spCartPackageImpl.setUserName(StringPool.BLANK);
		}
		else {
			spCartPackageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spCartPackageImpl.setCreateDate(null);
		}
		else {
			spCartPackageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spCartPackageImpl.setModifiedDate(null);
		}
		else {
			spCartPackageImpl.setModifiedDate(new Date(modifiedDate));
		}

		spCartPackageImpl.resetOriginalValues();

		return spCartPackageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spCartPackageId = objectInput.readLong();
		groupId = objectInput.readLong();
		cartId = objectInput.readLong();
		packageId = objectInput.readLong();
		selectedCurrency = objectInput.readUTF();
		usedDiscountRefId = objectInput.readLong();
		usedDiscountRefPCId = objectInput.readLong();
		discount = objectInput.readUTF();
		initialPrice = objectInput.readUTF();
		totalPrice = objectInput.readUTF();
		remarks = objectInput.readUTF();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spCartPackageId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(cartId);
		objectOutput.writeLong(packageId);

		if (selectedCurrency == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(selectedCurrency);
		}

		objectOutput.writeLong(usedDiscountRefId);
		objectOutput.writeLong(usedDiscountRefPCId);

		if (discount == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(discount);
		}

		if (initialPrice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(initialPrice);
		}

		if (totalPrice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(totalPrice);
		}

		if (remarks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(remarks);
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

	public long spCartPackageId;
	public long groupId;
	public long cartId;
	public long packageId;
	public String selectedCurrency;
	public long usedDiscountRefId;
	public long usedDiscountRefPCId;
	public String discount;
	public String initialPrice;
	public String totalPrice;
	public String remarks;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}