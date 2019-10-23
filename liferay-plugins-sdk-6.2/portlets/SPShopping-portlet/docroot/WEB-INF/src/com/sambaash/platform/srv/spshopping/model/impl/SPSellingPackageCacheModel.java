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

import com.sambaash.platform.srv.spshopping.model.SPSellingPackage;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPSellingPackage in entity cache.
 *
 * @author pradeep
 * @see SPSellingPackage
 * @generated
 */
public class SPSellingPackageCacheModel implements CacheModel<SPSellingPackage>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(39);

		sb.append("{spSellingPackageId=");
		sb.append(spSellingPackageId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", title=");
		sb.append(title);
		sb.append(", pkgCode=");
		sb.append(pkgCode);
		sb.append(", shortDescription=");
		sb.append(shortDescription);
		sb.append(", longDescription=");
		sb.append(longDescription);
		sb.append(", currencyCode=");
		sb.append(currencyCode);
		sb.append(", startDate=");
		sb.append(startDate);
		sb.append(", endDate=");
		sb.append(endDate);
		sb.append(", notify=");
		sb.append(notify);
		sb.append(", needsPayment=");
		sb.append(needsPayment);
		sb.append(", orderPage=");
		sb.append(orderPage);
		sb.append(", orderSequence=");
		sb.append(orderSequence);
		sb.append(", active=");
		sb.append(active);
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
	public SPSellingPackage toEntityModel() {
		SPSellingPackageImpl spSellingPackageImpl = new SPSellingPackageImpl();

		spSellingPackageImpl.setSpSellingPackageId(spSellingPackageId);
		spSellingPackageImpl.setGroupId(groupId);

		if (title == null) {
			spSellingPackageImpl.setTitle(StringPool.BLANK);
		}
		else {
			spSellingPackageImpl.setTitle(title);
		}

		if (pkgCode == null) {
			spSellingPackageImpl.setPkgCode(StringPool.BLANK);
		}
		else {
			spSellingPackageImpl.setPkgCode(pkgCode);
		}

		if (shortDescription == null) {
			spSellingPackageImpl.setShortDescription(StringPool.BLANK);
		}
		else {
			spSellingPackageImpl.setShortDescription(shortDescription);
		}

		if (longDescription == null) {
			spSellingPackageImpl.setLongDescription(StringPool.BLANK);
		}
		else {
			spSellingPackageImpl.setLongDescription(longDescription);
		}

		if (currencyCode == null) {
			spSellingPackageImpl.setCurrencyCode(StringPool.BLANK);
		}
		else {
			spSellingPackageImpl.setCurrencyCode(currencyCode);
		}

		if (startDate == Long.MIN_VALUE) {
			spSellingPackageImpl.setStartDate(null);
		}
		else {
			spSellingPackageImpl.setStartDate(new Date(startDate));
		}

		if (endDate == Long.MIN_VALUE) {
			spSellingPackageImpl.setEndDate(null);
		}
		else {
			spSellingPackageImpl.setEndDate(new Date(endDate));
		}

		if (notify == null) {
			spSellingPackageImpl.setNotify(StringPool.BLANK);
		}
		else {
			spSellingPackageImpl.setNotify(notify);
		}

		spSellingPackageImpl.setNeedsPayment(needsPayment);

		if (orderPage == null) {
			spSellingPackageImpl.setOrderPage(StringPool.BLANK);
		}
		else {
			spSellingPackageImpl.setOrderPage(orderPage);
		}

		if (orderSequence == null) {
			spSellingPackageImpl.setOrderSequence(StringPool.BLANK);
		}
		else {
			spSellingPackageImpl.setOrderSequence(orderSequence);
		}

		spSellingPackageImpl.setActive(active);
		spSellingPackageImpl.setCompanyId(companyId);
		spSellingPackageImpl.setUserId(userId);

		if (userName == null) {
			spSellingPackageImpl.setUserName(StringPool.BLANK);
		}
		else {
			spSellingPackageImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spSellingPackageImpl.setCreateDate(null);
		}
		else {
			spSellingPackageImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spSellingPackageImpl.setModifiedDate(null);
		}
		else {
			spSellingPackageImpl.setModifiedDate(new Date(modifiedDate));
		}

		spSellingPackageImpl.resetOriginalValues();

		return spSellingPackageImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spSellingPackageId = objectInput.readLong();
		groupId = objectInput.readLong();
		title = objectInput.readUTF();
		pkgCode = objectInput.readUTF();
		shortDescription = objectInput.readUTF();
		longDescription = objectInput.readUTF();
		currencyCode = objectInput.readUTF();
		startDate = objectInput.readLong();
		endDate = objectInput.readLong();
		notify = objectInput.readUTF();
		needsPayment = objectInput.readBoolean();
		orderPage = objectInput.readUTF();
		orderSequence = objectInput.readUTF();
		active = objectInput.readBoolean();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spSellingPackageId);
		objectOutput.writeLong(groupId);

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (pkgCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(pkgCode);
		}

		if (shortDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortDescription);
		}

		if (longDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(longDescription);
		}

		if (currencyCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(currencyCode);
		}

		objectOutput.writeLong(startDate);
		objectOutput.writeLong(endDate);

		if (notify == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(notify);
		}

		objectOutput.writeBoolean(needsPayment);

		if (orderPage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orderPage);
		}

		if (orderSequence == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(orderSequence);
		}

		objectOutput.writeBoolean(active);
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

	public long spSellingPackageId;
	public long groupId;
	public String title;
	public String pkgCode;
	public String shortDescription;
	public String longDescription;
	public String currencyCode;
	public long startDate;
	public long endDate;
	public String notify;
	public boolean needsPayment;
	public String orderPage;
	public String orderSequence;
	public boolean active;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
}