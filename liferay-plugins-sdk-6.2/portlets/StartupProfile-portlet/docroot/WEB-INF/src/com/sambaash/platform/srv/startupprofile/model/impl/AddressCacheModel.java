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

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.startupprofile.model.Address;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Address in entity cache.
 *
 * @author pradeep
 * @see Address
 * @generated
 */
public class AddressCacheModel implements CacheModel<Address>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(41);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", addressId=");
		sb.append(addressId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", street1=");
		sb.append(street1);
		sb.append(", street2=");
		sb.append(street2);
		sb.append(", street3=");
		sb.append(street3);
		sb.append(", street4=");
		sb.append(street4);
		sb.append(", city=");
		sb.append(city);
		sb.append(", region=");
		sb.append(region);
		sb.append(", country=");
		sb.append(country);
		sb.append(", postalCode=");
		sb.append(postalCode);
		sb.append(", hq=");
		sb.append(hq);
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
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Address toEntityModel() {
		AddressImpl addressImpl = new AddressImpl();

		if (uuid == null) {
			addressImpl.setUuid(StringPool.BLANK);
		}
		else {
			addressImpl.setUuid(uuid);
		}

		addressImpl.setAddressId(addressId);
		addressImpl.setOrganizationId(organizationId);

		if (name == null) {
			addressImpl.setName(StringPool.BLANK);
		}
		else {
			addressImpl.setName(name);
		}

		if (street1 == null) {
			addressImpl.setStreet1(StringPool.BLANK);
		}
		else {
			addressImpl.setStreet1(street1);
		}

		if (street2 == null) {
			addressImpl.setStreet2(StringPool.BLANK);
		}
		else {
			addressImpl.setStreet2(street2);
		}

		if (street3 == null) {
			addressImpl.setStreet3(StringPool.BLANK);
		}
		else {
			addressImpl.setStreet3(street3);
		}

		if (street4 == null) {
			addressImpl.setStreet4(StringPool.BLANK);
		}
		else {
			addressImpl.setStreet4(street4);
		}

		if (city == null) {
			addressImpl.setCity(StringPool.BLANK);
		}
		else {
			addressImpl.setCity(city);
		}

		if (region == null) {
			addressImpl.setRegion(StringPool.BLANK);
		}
		else {
			addressImpl.setRegion(region);
		}

		if (country == null) {
			addressImpl.setCountry(StringPool.BLANK);
		}
		else {
			addressImpl.setCountry(country);
		}

		if (postalCode == null) {
			addressImpl.setPostalCode(StringPool.BLANK);
		}
		else {
			addressImpl.setPostalCode(postalCode);
		}

		addressImpl.setHq(hq);
		addressImpl.setGroupId(groupId);
		addressImpl.setCompanyId(companyId);
		addressImpl.setUserId(userId);

		if (userName == null) {
			addressImpl.setUserName(StringPool.BLANK);
		}
		else {
			addressImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			addressImpl.setCreateDate(null);
		}
		else {
			addressImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			addressImpl.setModifiedDate(null);
		}
		else {
			addressImpl.setModifiedDate(new Date(modifiedDate));
		}

		addressImpl.setActive(active);

		addressImpl.resetOriginalValues();

		return addressImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		addressId = objectInput.readLong();
		organizationId = objectInput.readLong();
		name = objectInput.readUTF();
		street1 = objectInput.readUTF();
		street2 = objectInput.readUTF();
		street3 = objectInput.readUTF();
		street4 = objectInput.readUTF();
		city = objectInput.readUTF();
		region = objectInput.readUTF();
		country = objectInput.readUTF();
		postalCode = objectInput.readUTF();
		hq = objectInput.readBoolean();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		active = objectInput.readBoolean();
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

		objectOutput.writeLong(addressId);
		objectOutput.writeLong(organizationId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (street1 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street1);
		}

		if (street2 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street2);
		}

		if (street3 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street3);
		}

		if (street4 == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(street4);
		}

		if (city == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(city);
		}

		if (region == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(region);
		}

		if (country == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(country);
		}

		if (postalCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(postalCode);
		}

		objectOutput.writeBoolean(hq);
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
		objectOutput.writeBoolean(active);
	}

	public String uuid;
	public long addressId;
	public long organizationId;
	public String name;
	public String street1;
	public String street2;
	public String street3;
	public String street4;
	public String city;
	public String region;
	public String country;
	public String postalCode;
	public boolean hq;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
}