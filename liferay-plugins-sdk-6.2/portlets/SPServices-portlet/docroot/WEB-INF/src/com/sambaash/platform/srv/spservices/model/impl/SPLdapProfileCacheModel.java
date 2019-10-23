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

import com.sambaash.platform.srv.spservices.model.SPLdapProfile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPLdapProfile in entity cache.
 *
 * @author gauravvijayvergia
 * @see SPLdapProfile
 * @generated
 */
public class SPLdapProfileCacheModel implements CacheModel<SPLdapProfile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(43);

		sb.append("{spLdapProfileId=");
		sb.append(spLdapProfileId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", countryId=");
		sb.append(countryId);
		sb.append(", departmentId=");
		sb.append(departmentId);
		sb.append(", givenName=");
		sb.append(givenName);
		sb.append(", sn=");
		sb.append(sn);
		sb.append(", displayName=");
		sb.append(displayName);
		sb.append(", company=");
		sb.append(company);
		sb.append(", division=");
		sb.append(division);
		sb.append(", title=");
		sb.append(title);
		sb.append(", mail=");
		sb.append(mail);
		sb.append(", samAccountName=");
		sb.append(samAccountName);
		sb.append(", employeeId=");
		sb.append(employeeId);
		sb.append(", manager=");
		sb.append(manager);
		sb.append(", telephoneNumber=");
		sb.append(telephoneNumber);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", facsimileTelephoneNumber=");
		sb.append(facsimileTelephoneNumber);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPLdapProfile toEntityModel() {
		SPLdapProfileImpl spLdapProfileImpl = new SPLdapProfileImpl();

		spLdapProfileImpl.setSpLdapProfileId(spLdapProfileId);
		spLdapProfileImpl.setGroupId(groupId);
		spLdapProfileImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			spLdapProfileImpl.setCreateDate(null);
		}
		else {
			spLdapProfileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spLdapProfileImpl.setModifiedDate(null);
		}
		else {
			spLdapProfileImpl.setModifiedDate(new Date(modifiedDate));
		}

		spLdapProfileImpl.setUserId(userId);
		spLdapProfileImpl.setCountryId(countryId);
		spLdapProfileImpl.setDepartmentId(departmentId);

		if (givenName == null) {
			spLdapProfileImpl.setGivenName(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setGivenName(givenName);
		}

		if (sn == null) {
			spLdapProfileImpl.setSn(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setSn(sn);
		}

		if (displayName == null) {
			spLdapProfileImpl.setDisplayName(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setDisplayName(displayName);
		}

		if (company == null) {
			spLdapProfileImpl.setCompany(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setCompany(company);
		}

		if (division == null) {
			spLdapProfileImpl.setDivision(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setDivision(division);
		}

		if (title == null) {
			spLdapProfileImpl.setTitle(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setTitle(title);
		}

		if (mail == null) {
			spLdapProfileImpl.setMail(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setMail(mail);
		}

		if (samAccountName == null) {
			spLdapProfileImpl.setSamAccountName(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setSamAccountName(samAccountName);
		}

		if (employeeId == null) {
			spLdapProfileImpl.setEmployeeId(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setEmployeeId(employeeId);
		}

		if (manager == null) {
			spLdapProfileImpl.setManager(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setManager(manager);
		}

		if (telephoneNumber == null) {
			spLdapProfileImpl.setTelephoneNumber(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setTelephoneNumber(telephoneNumber);
		}

		if (mobile == null) {
			spLdapProfileImpl.setMobile(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setMobile(mobile);
		}

		if (facsimileTelephoneNumber == null) {
			spLdapProfileImpl.setFacsimileTelephoneNumber(StringPool.BLANK);
		}
		else {
			spLdapProfileImpl.setFacsimileTelephoneNumber(facsimileTelephoneNumber);
		}

		spLdapProfileImpl.resetOriginalValues();

		return spLdapProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spLdapProfileId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userId = objectInput.readLong();
		countryId = objectInput.readLong();
		departmentId = objectInput.readLong();
		givenName = objectInput.readUTF();
		sn = objectInput.readUTF();
		displayName = objectInput.readUTF();
		company = objectInput.readUTF();
		division = objectInput.readUTF();
		title = objectInput.readUTF();
		mail = objectInput.readUTF();
		samAccountName = objectInput.readUTF();
		employeeId = objectInput.readUTF();
		manager = objectInput.readUTF();
		telephoneNumber = objectInput.readUTF();
		mobile = objectInput.readUTF();
		facsimileTelephoneNumber = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spLdapProfileId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeLong(userId);
		objectOutput.writeLong(countryId);
		objectOutput.writeLong(departmentId);

		if (givenName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(givenName);
		}

		if (sn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(sn);
		}

		if (displayName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(displayName);
		}

		if (company == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(company);
		}

		if (division == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(division);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (mail == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mail);
		}

		if (samAccountName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(samAccountName);
		}

		if (employeeId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(employeeId);
		}

		if (manager == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(manager);
		}

		if (telephoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(telephoneNumber);
		}

		if (mobile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (facsimileTelephoneNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(facsimileTelephoneNumber);
		}
	}

	public long spLdapProfileId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public long userId;
	public long countryId;
	public long departmentId;
	public String givenName;
	public String sn;
	public String displayName;
	public String company;
	public String division;
	public String title;
	public String mail;
	public String samAccountName;
	public String employeeId;
	public String manager;
	public String telephoneNumber;
	public String mobile;
	public String facsimileTelephoneNumber;
}