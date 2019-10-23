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

import com.sambaash.platform.srv.spshopping.model.SPSellingPrice;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPSellingPrice in entity cache.
 *
 * @author pradeep
 * @see SPSellingPrice
 * @generated
 */
public class SPSellingPriceCacheModel implements CacheModel<SPSellingPrice>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{spSellingPriceId=");
		sb.append(spSellingPriceId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", priceRefId=");
		sb.append(priceRefId);
		sb.append(", priceRefTypeId=");
		sb.append(priceRefTypeId);
		sb.append(", currencyCode=");
		sb.append(currencyCode);
		sb.append(", basePrice=");
		sb.append(basePrice);
		sb.append(", taxName=");
		sb.append(taxName);
		sb.append(", taxValue=");
		sb.append(taxValue);
		sb.append(", totalPrice=");
		sb.append(totalPrice);
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
	public SPSellingPrice toEntityModel() {
		SPSellingPriceImpl spSellingPriceImpl = new SPSellingPriceImpl();

		spSellingPriceImpl.setSpSellingPriceId(spSellingPriceId);
		spSellingPriceImpl.setGroupId(groupId);
		spSellingPriceImpl.setPriceRefId(priceRefId);
		spSellingPriceImpl.setPriceRefTypeId(priceRefTypeId);

		if (currencyCode == null) {
			spSellingPriceImpl.setCurrencyCode(StringPool.BLANK);
		}
		else {
			spSellingPriceImpl.setCurrencyCode(currencyCode);
		}

		if (basePrice == null) {
			spSellingPriceImpl.setBasePrice(StringPool.BLANK);
		}
		else {
			spSellingPriceImpl.setBasePrice(basePrice);
		}

		if (taxName == null) {
			spSellingPriceImpl.setTaxName(StringPool.BLANK);
		}
		else {
			spSellingPriceImpl.setTaxName(taxName);
		}

		if (taxValue == null) {
			spSellingPriceImpl.setTaxValue(StringPool.BLANK);
		}
		else {
			spSellingPriceImpl.setTaxValue(taxValue);
		}

		if (totalPrice == null) {
			spSellingPriceImpl.setTotalPrice(StringPool.BLANK);
		}
		else {
			spSellingPriceImpl.setTotalPrice(totalPrice);
		}

		spSellingPriceImpl.setCompanyId(companyId);
		spSellingPriceImpl.setUserId(userId);

		if (userName == null) {
			spSellingPriceImpl.setUserName(StringPool.BLANK);
		}
		else {
			spSellingPriceImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spSellingPriceImpl.setCreateDate(null);
		}
		else {
			spSellingPriceImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spSellingPriceImpl.setModifiedDate(null);
		}
		else {
			spSellingPriceImpl.setModifiedDate(new Date(modifiedDate));
		}

		spSellingPriceImpl.resetOriginalValues();

		return spSellingPriceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spSellingPriceId = objectInput.readLong();
		groupId = objectInput.readLong();
		priceRefId = objectInput.readLong();
		priceRefTypeId = objectInput.readLong();
		currencyCode = objectInput.readUTF();
		basePrice = objectInput.readUTF();
		taxName = objectInput.readUTF();
		taxValue = objectInput.readUTF();
		totalPrice = objectInput.readUTF();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spSellingPriceId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(priceRefId);
		objectOutput.writeLong(priceRefTypeId);

		if (currencyCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currencyCode);
		}

		if (basePrice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(basePrice);
		}

		if (taxName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taxName);
		}

		if (taxValue == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(taxValue);
		}

		if (totalPrice == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(totalPrice);
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

	public long spSellingPriceId;
	public long groupId;
	public long priceRefId;
	public long priceRefTypeId;
	public String currencyCode;
	public String basePrice;
	public String taxName;
	public String taxValue;
	public String totalPrice;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}