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

package com.sambaash.platform.srv.startupprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.SPOrgContactUsLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class SPOrgContactUsClp extends BaseModelImpl<SPOrgContactUs>
	implements SPOrgContactUs {
	public SPOrgContactUsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SPOrgContactUs.class;
	}

	@Override
	public String getModelClassName() {
		return SPOrgContactUs.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _spContactUsId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpContactUsId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spContactUsId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spContactUsId", getSpContactUsId());
		attributes.put("groupId", getGroupId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("salutation", getSalutation());
		attributes.put("person", getPerson());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("designation", getDesignation());
		attributes.put("qualification", getQualification());
		attributes.put("qualificationDate", getQualificationDate());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("department", getDepartment());
		attributes.put("mobileNumber", getMobileNumber());
		attributes.put("telephoneNumber", getTelephoneNumber());
		attributes.put("faxNumber", getFaxNumber());
		attributes.put("billingContact", getBillingContact());
		attributes.put("operationsContact", getOperationsContact());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spContactUsId = (Long)attributes.get("spContactUsId");

		if (spContactUsId != null) {
			setSpContactUsId(spContactUsId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String salutation = (String)attributes.get("salutation");

		if (salutation != null) {
			setSalutation(salutation);
		}

		String person = (String)attributes.get("person");

		if (person != null) {
			setPerson(person);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String designation = (String)attributes.get("designation");

		if (designation != null) {
			setDesignation(designation);
		}

		String qualification = (String)attributes.get("qualification");

		if (qualification != null) {
			setQualification(qualification);
		}

		String qualificationDate = (String)attributes.get("qualificationDate");

		if (qualificationDate != null) {
			setQualificationDate(qualificationDate);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String department = (String)attributes.get("department");

		if (department != null) {
			setDepartment(department);
		}

		Long mobileNumber = (Long)attributes.get("mobileNumber");

		if (mobileNumber != null) {
			setMobileNumber(mobileNumber);
		}

		Long telephoneNumber = (Long)attributes.get("telephoneNumber");

		if (telephoneNumber != null) {
			setTelephoneNumber(telephoneNumber);
		}

		Long faxNumber = (Long)attributes.get("faxNumber");

		if (faxNumber != null) {
			setFaxNumber(faxNumber);
		}

		Boolean billingContact = (Boolean)attributes.get("billingContact");

		if (billingContact != null) {
			setBillingContact(billingContact);
		}

		Boolean operationsContact = (Boolean)attributes.get("operationsContact");

		if (operationsContact != null) {
			setOperationsContact(operationsContact);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	@Override
	public long getSpContactUsId() {
		return _spContactUsId;
	}

	@Override
	public void setSpContactUsId(long spContactUsId) {
		_spContactUsId = spContactUsId;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setSpContactUsId", long.class);

				method.invoke(_spOrgContactUsRemoteModel, spContactUsId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_spOrgContactUsRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_spOrgContactUsRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_spOrgContactUsRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_spOrgContactUsRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_spOrgContactUsRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_spOrgContactUsRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSalutation() {
		return _salutation;
	}

	@Override
	public void setSalutation(String salutation) {
		_salutation = salutation;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setSalutation", String.class);

				method.invoke(_spOrgContactUsRemoteModel, salutation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPerson() {
		return _person;
	}

	@Override
	public void setPerson(String person) {
		_person = person;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setPerson", String.class);

				method.invoke(_spOrgContactUsRemoteModel, person);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_spOrgContactUsRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_spOrgContactUsRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesignation() {
		return _designation;
	}

	@Override
	public void setDesignation(String designation) {
		_designation = designation;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setDesignation", String.class);

				method.invoke(_spOrgContactUsRemoteModel, designation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQualification() {
		return _qualification;
	}

	@Override
	public void setQualification(String qualification) {
		_qualification = qualification;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setQualification", String.class);

				method.invoke(_spOrgContactUsRemoteModel, qualification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getQualificationDate() {
		return _qualificationDate;
	}

	@Override
	public void setQualificationDate(String qualificationDate) {
		_qualificationDate = qualificationDate;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setQualificationDate",
						String.class);

				method.invoke(_spOrgContactUsRemoteModel, qualificationDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_spOrgContactUsRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDepartment() {
		return _department;
	}

	@Override
	public void setDepartment(String department) {
		_department = department;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setDepartment", String.class);

				method.invoke(_spOrgContactUsRemoteModel, department);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMobileNumber() {
		return _mobileNumber;
	}

	@Override
	public void setMobileNumber(long mobileNumber) {
		_mobileNumber = mobileNumber;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setMobileNumber", long.class);

				method.invoke(_spOrgContactUsRemoteModel, mobileNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTelephoneNumber() {
		return _telephoneNumber;
	}

	@Override
	public void setTelephoneNumber(long telephoneNumber) {
		_telephoneNumber = telephoneNumber;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setTelephoneNumber", long.class);

				method.invoke(_spOrgContactUsRemoteModel, telephoneNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFaxNumber() {
		return _faxNumber;
	}

	@Override
	public void setFaxNumber(long faxNumber) {
		_faxNumber = faxNumber;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setFaxNumber", long.class);

				method.invoke(_spOrgContactUsRemoteModel, faxNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getBillingContact() {
		return _billingContact;
	}

	@Override
	public boolean isBillingContact() {
		return _billingContact;
	}

	@Override
	public void setBillingContact(boolean billingContact) {
		_billingContact = billingContact;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setBillingContact",
						boolean.class);

				method.invoke(_spOrgContactUsRemoteModel, billingContact);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getOperationsContact() {
		return _operationsContact;
	}

	@Override
	public boolean isOperationsContact() {
		return _operationsContact;
	}

	@Override
	public void setOperationsContact(boolean operationsContact) {
		_operationsContact = operationsContact;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setOperationsContact",
						boolean.class);

				method.invoke(_spOrgContactUsRemoteModel, operationsContact);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_spOrgContactUsRemoteModel != null) {
			try {
				Class<?> clazz = _spOrgContactUsRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_spOrgContactUsRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getSPOrgContactUsRemoteModel() {
		return _spOrgContactUsRemoteModel;
	}

	public void setSPOrgContactUsRemoteModel(
		BaseModel<?> spOrgContactUsRemoteModel) {
		_spOrgContactUsRemoteModel = spOrgContactUsRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _spOrgContactUsRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_spOrgContactUsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SPOrgContactUsLocalServiceUtil.addSPOrgContactUs(this);
		}
		else {
			SPOrgContactUsLocalServiceUtil.updateSPOrgContactUs(this);
		}
	}

	@Override
	public SPOrgContactUs toEscapedModel() {
		return (SPOrgContactUs)ProxyUtil.newProxyInstance(SPOrgContactUs.class.getClassLoader(),
			new Class[] { SPOrgContactUs.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SPOrgContactUsClp clone = new SPOrgContactUsClp();

		clone.setSpContactUsId(getSpContactUsId());
		clone.setGroupId(getGroupId());
		clone.setOrganizationId(getOrganizationId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setSalutation(getSalutation());
		clone.setPerson(getPerson());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setDesignation(getDesignation());
		clone.setQualification(getQualification());
		clone.setQualificationDate(getQualificationDate());
		clone.setEmailAddress(getEmailAddress());
		clone.setDepartment(getDepartment());
		clone.setMobileNumber(getMobileNumber());
		clone.setTelephoneNumber(getTelephoneNumber());
		clone.setFaxNumber(getFaxNumber());
		clone.setBillingContact(getBillingContact());
		clone.setOperationsContact(getOperationsContact());
		clone.setActive(getActive());

		return clone;
	}

	@Override
	public int compareTo(SPOrgContactUs spOrgContactUs) {
		long primaryKey = spOrgContactUs.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPOrgContactUsClp)) {
			return false;
		}

		SPOrgContactUsClp spOrgContactUs = (SPOrgContactUsClp)obj;

		long primaryKey = spOrgContactUs.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(45);

		sb.append("{spContactUsId=");
		sb.append(getSpContactUsId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", salutation=");
		sb.append(getSalutation());
		sb.append(", person=");
		sb.append(getPerson());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", designation=");
		sb.append(getDesignation());
		sb.append(", qualification=");
		sb.append(getQualification());
		sb.append(", qualificationDate=");
		sb.append(getQualificationDate());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", department=");
		sb.append(getDepartment());
		sb.append(", mobileNumber=");
		sb.append(getMobileNumber());
		sb.append(", telephoneNumber=");
		sb.append(getTelephoneNumber());
		sb.append(", faxNumber=");
		sb.append(getFaxNumber());
		sb.append(", billingContact=");
		sb.append(getBillingContact());
		sb.append(", operationsContact=");
		sb.append(getOperationsContact());
		sb.append(", active=");
		sb.append(getActive());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spContactUsId</column-name><column-value><![CDATA[");
		sb.append(getSpContactUsId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>salutation</column-name><column-value><![CDATA[");
		sb.append(getSalutation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>person</column-name><column-value><![CDATA[");
		sb.append(getPerson());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>designation</column-name><column-value><![CDATA[");
		sb.append(getDesignation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qualification</column-name><column-value><![CDATA[");
		sb.append(getQualification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>qualificationDate</column-name><column-value><![CDATA[");
		sb.append(getQualificationDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>department</column-name><column-value><![CDATA[");
		sb.append(getDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobileNumber</column-name><column-value><![CDATA[");
		sb.append(getMobileNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>telephoneNumber</column-name><column-value><![CDATA[");
		sb.append(getTelephoneNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>faxNumber</column-name><column-value><![CDATA[");
		sb.append(getFaxNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>billingContact</column-name><column-value><![CDATA[");
		sb.append(getBillingContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>operationsContact</column-name><column-value><![CDATA[");
		sb.append(getOperationsContact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spContactUsId;
	private long _groupId;
	private long _organizationId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _salutation;
	private String _person;
	private String _firstName;
	private String _lastName;
	private String _designation;
	private String _qualification;
	private String _qualificationDate;
	private String _emailAddress;
	private String _department;
	private long _mobileNumber;
	private long _telephoneNumber;
	private long _faxNumber;
	private boolean _billingContact;
	private boolean _operationsContact;
	private boolean _active;
	private BaseModel<?> _spOrgContactUsRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}