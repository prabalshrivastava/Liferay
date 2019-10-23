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

package com.sambaash.platform.srv.spservices.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spservices.model.SPLdapMapping;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPLdapMapping in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPLdapMapping
 * @generated
 */
public class SPLdapMappingCacheModel implements CacheModel<SPLdapMapping>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(29);

		sb.append("{spLdapMappingId=");
		sb.append(spLdapMappingId);
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
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", countryDepartmentId=");
		sb.append(countryDepartmentId);
		sb.append(", ldapCountry=");
		sb.append(ldapCountry);
		sb.append(", ldapDepartment=");
		sb.append(ldapDepartment);
		sb.append(", ldapCompany=");
		sb.append(ldapCompany);
		sb.append(", defaultRoleId=");
		sb.append(defaultRoleId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPLdapMapping toEntityModel() {
		SPLdapMappingImpl spLdapMappingImpl = new SPLdapMappingImpl();

		spLdapMappingImpl.setSpLdapMappingId(spLdapMappingId);
		spLdapMappingImpl.setGroupId(groupId);
		spLdapMappingImpl.setCompanyId(companyId);
		spLdapMappingImpl.setUserId(userId);

		if (userName == null) {
			spLdapMappingImpl.setUserName(StringPool.BLANK);
		}
		else {
			spLdapMappingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spLdapMappingImpl.setCreateDate(null);
		}
		else {
			spLdapMappingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spLdapMappingImpl.setModifiedDate(null);
		}
		else {
			spLdapMappingImpl.setModifiedDate(new Date(modifiedDate));
		}

		spLdapMappingImpl.setCountryId(countryId);
		spLdapMappingImpl.setDepartmentId(departmentId);
		spLdapMappingImpl.setCountryDepartmentId(countryDepartmentId);

		if (ldapCountry == null) {
			spLdapMappingImpl.setLdapCountry(StringPool.BLANK);
		}
		else {
			spLdapMappingImpl.setLdapCountry(ldapCountry);
		}

		if (ldapDepartment == null) {
			spLdapMappingImpl.setLdapDepartment(StringPool.BLANK);
		}
		else {
			spLdapMappingImpl.setLdapDepartment(ldapDepartment);
		}

		if (ldapCompany == null) {
			spLdapMappingImpl.setLdapCompany(StringPool.BLANK);
		}
		else {
			spLdapMappingImpl.setLdapCompany(ldapCompany);
		}

		spLdapMappingImpl.setDefaultRoleId(defaultRoleId);

		spLdapMappingImpl.resetOriginalValues();

		return spLdapMappingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spLdapMappingId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		countryId = objectInput.readLong();
		departmentId = objectInput.readLong();
		countryDepartmentId = objectInput.readLong();
		ldapCountry = objectInput.readUTF();
		ldapDepartment = objectInput.readUTF();
		ldapCompany = objectInput.readUTF();
		defaultRoleId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spLdapMappingId);
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
		objectOutput.writeLong(countryId);
		objectOutput.writeLong(departmentId);
		objectOutput.writeLong(countryDepartmentId);

		if (ldapCountry == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldapCountry);
		}

		if (ldapDepartment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldapDepartment);
		}

		if (ldapCompany == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(ldapCompany);
		}

		objectOutput.writeLong(defaultRoleId);
	}

	public long spLdapMappingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public long countryId;
	public long departmentId;
	public long countryDepartmentId;
	public String ldapCountry;
	public String ldapDepartment;
	public String ldapCompany;
	public long defaultRoleId;
}