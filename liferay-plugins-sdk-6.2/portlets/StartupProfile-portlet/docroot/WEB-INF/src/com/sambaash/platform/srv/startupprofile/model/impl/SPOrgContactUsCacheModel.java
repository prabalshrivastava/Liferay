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

import com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SPOrgContactUs in entity cache.
 *
 * @author pradeep
 * @see SPOrgContactUs
 * @generated
 */
public class SPOrgContactUsCacheModel implements CacheModel<SPOrgContactUs>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{spContactUsId=");
		sb.append(spContactUsId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", salutation=");
		sb.append(salutation);
		sb.append(", person=");
		sb.append(person);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", designation=");
		sb.append(designation);
		sb.append(", qualification=");
		sb.append(qualification);
		sb.append(", qualificationDate=");
		sb.append(qualificationDate);
		sb.append(", emailAddress=");
		sb.append(emailAddress);
		sb.append(", department=");
		sb.append(department);
		sb.append(", mobileNumber=");
		sb.append(mobileNumber);
		sb.append(", telephoneNumber=");
		sb.append(telephoneNumber);
		sb.append(", faxNumber=");
		sb.append(faxNumber);
		sb.append(", billingContact=");
		sb.append(billingContact);
		sb.append(", operationsContact=");
		sb.append(operationsContact);
		sb.append(", active=");
		sb.append(active);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SPOrgContactUs toEntityModel() {
		SPOrgContactUsImpl spOrgContactUsImpl = new SPOrgContactUsImpl();

		spOrgContactUsImpl.setSpContactUsId(spContactUsId);
		spOrgContactUsImpl.setGroupId(groupId);
		spOrgContactUsImpl.setOrganizationId(organizationId);
		spOrgContactUsImpl.setUserId(userId);

		if (userName == null) {
			spOrgContactUsImpl.setUserName(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			spOrgContactUsImpl.setCreateDate(null);
		}
		else {
			spOrgContactUsImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			spOrgContactUsImpl.setModifiedDate(null);
		}
		else {
			spOrgContactUsImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (salutation == null) {
			spOrgContactUsImpl.setSalutation(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setSalutation(salutation);
		}

		if (person == null) {
			spOrgContactUsImpl.setPerson(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setPerson(person);
		}

		if (firstName == null) {
			spOrgContactUsImpl.setFirstName(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			spOrgContactUsImpl.setLastName(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setLastName(lastName);
		}

		if (designation == null) {
			spOrgContactUsImpl.setDesignation(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setDesignation(designation);
		}

		if (qualification == null) {
			spOrgContactUsImpl.setQualification(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setQualification(qualification);
		}

		if (qualificationDate == null) {
			spOrgContactUsImpl.setQualificationDate(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setQualificationDate(qualificationDate);
		}

		if (emailAddress == null) {
			spOrgContactUsImpl.setEmailAddress(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setEmailAddress(emailAddress);
		}

		if (department == null) {
			spOrgContactUsImpl.setDepartment(StringPool.BLANK);
		}
		else {
			spOrgContactUsImpl.setDepartment(department);
		}

		spOrgContactUsImpl.setMobileNumber(mobileNumber);
		spOrgContactUsImpl.setTelephoneNumber(telephoneNumber);
		spOrgContactUsImpl.setFaxNumber(faxNumber);
		spOrgContactUsImpl.setBillingContact(billingContact);
		spOrgContactUsImpl.setOperationsContact(operationsContact);
		spOrgContactUsImpl.setActive(active);

		spOrgContactUsImpl.resetOriginalValues();

		return spOrgContactUsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		spContactUsId = objectInput.readLong();
		groupId = objectInput.readLong();
		organizationId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		salutation = objectInput.readUTF();
		person = objectInput.readUTF();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		designation = objectInput.readUTF();
		qualification = objectInput.readUTF();
		qualificationDate = objectInput.readUTF();
		emailAddress = objectInput.readUTF();
		department = objectInput.readUTF();
		mobileNumber = objectInput.readLong();
		telephoneNumber = objectInput.readLong();
		faxNumber = objectInput.readLong();
		billingContact = objectInput.readBoolean();
		operationsContact = objectInput.readBoolean();
		active = objectInput.readBoolean();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(spContactUsId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(organizationId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (salutation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(salutation);
		}

		if (person == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(person);
		}

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (designation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(designation);
		}

		if (qualification == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(qualification);
		}

		if (qualificationDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(qualificationDate);
		}

		if (emailAddress == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailAddress);
		}

		if (department == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(department);
		}

		objectOutput.writeLong(mobileNumber);
		objectOutput.writeLong(telephoneNumber);
		objectOutput.writeLong(faxNumber);
		objectOutput.writeBoolean(billingContact);
		objectOutput.writeBoolean(operationsContact);
		objectOutput.writeBoolean(active);
	}

	public long spContactUsId;
	public long groupId;
	public long organizationId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public String salutation;
	public String person;
	public String firstName;
	public String lastName;
	public String designation;
	public String qualification;
	public String qualificationDate;
	public String emailAddress;
	public String department;
	public long mobileNumber;
	public long telephoneNumber;
	public long faxNumber;
	public boolean billingContact;
	public boolean operationsContact;
	public boolean active;
}