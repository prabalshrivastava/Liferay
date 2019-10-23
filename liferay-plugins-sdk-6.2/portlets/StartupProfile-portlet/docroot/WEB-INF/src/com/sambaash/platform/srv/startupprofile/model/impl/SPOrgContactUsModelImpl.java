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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs;
import com.sambaash.platform.srv.startupprofile.model.SPOrgContactUsModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the SPOrgContactUs service. Represents a row in the &quot;SPOrgContactUs&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.startupprofile.model.SPOrgContactUsModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SPOrgContactUsImpl}.
 * </p>
 *
 * @author pradeep
 * @see SPOrgContactUsImpl
 * @see com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs
 * @see com.sambaash.platform.srv.startupprofile.model.SPOrgContactUsModel
 * @generated
 */
public class SPOrgContactUsModelImpl extends BaseModelImpl<SPOrgContactUs>
	implements SPOrgContactUsModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a s p org contact us model instance should use the {@link com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs} interface instead.
	 */
	public static final String TABLE_NAME = "SPOrgContactUs";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spContactUsId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "organizationId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "salutation", Types.VARCHAR },
			{ "person", Types.VARCHAR },
			{ "firstName", Types.VARCHAR },
			{ "lastName", Types.VARCHAR },
			{ "designation", Types.VARCHAR },
			{ "qualification", Types.VARCHAR },
			{ "qualificationDate", Types.VARCHAR },
			{ "emailAddress", Types.VARCHAR },
			{ "department", Types.VARCHAR },
			{ "mobileNumber", Types.BIGINT },
			{ "telephoneNumber", Types.BIGINT },
			{ "faxNumber", Types.BIGINT },
			{ "billingContact", Types.BOOLEAN },
			{ "operationsContact", Types.BOOLEAN },
			{ "active_", Types.BOOLEAN }
		};
	public static final String TABLE_SQL_CREATE = "create table SPOrgContactUs (spContactUsId BIGINT(20) not null primary key,groupId BIGINT(20),organizationId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,salutation VARCHAR(75) null,person VARCHAR(75) null,firstName VARCHAR(75) null,lastName VARCHAR(75) null,designation VARCHAR(75) null,qualification VARCHAR(75) null,qualificationDate VARCHAR(75) null,emailAddress VARCHAR(75) null,department VARCHAR(75) null,mobileNumber BIGINT(20),telephoneNumber BIGINT(20),faxNumber BIGINT(20),billingContact BOOLEAN,operationsContact BOOLEAN,active_ BOOLEAN)";
	public static final String TABLE_SQL_DROP = "drop table SPOrgContactUs";
	public static final String ORDER_BY_JPQL = " ORDER BY spOrgContactUs.spContactUsId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPOrgContactUs.spContactUsId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs"),
			true);
	public static long ORGANIZATIONID_COLUMN_BITMASK = 1L;
	public static long SPCONTACTUSID_COLUMN_BITMASK = 2L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs"));

	public SPOrgContactUsModelImpl() {
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
	public Class<?> getModelClass() {
		return SPOrgContactUs.class;
	}

	@Override
	public String getModelClassName() {
		return SPOrgContactUs.class.getName();
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
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_columnBitmask |= ORGANIZATIONID_COLUMN_BITMASK;

		if (!_setOriginalOrganizationId) {
			_setOriginalOrganizationId = true;

			_originalOrganizationId = _organizationId;
		}

		_organizationId = organizationId;
	}

	public long getOriginalOrganizationId() {
		return _originalOrganizationId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
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
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public String getSalutation() {
		if (_salutation == null) {
			return StringPool.BLANK;
		}
		else {
			return _salutation;
		}
	}

	@Override
	public void setSalutation(String salutation) {
		_salutation = salutation;
	}

	@Override
	public String getPerson() {
		if (_person == null) {
			return StringPool.BLANK;
		}
		else {
			return _person;
		}
	}

	@Override
	public void setPerson(String person) {
		_person = person;
	}

	@Override
	public String getFirstName() {
		if (_firstName == null) {
			return StringPool.BLANK;
		}
		else {
			return _firstName;
		}
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	@Override
	public String getLastName() {
		if (_lastName == null) {
			return StringPool.BLANK;
		}
		else {
			return _lastName;
		}
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	@Override
	public String getDesignation() {
		if (_designation == null) {
			return StringPool.BLANK;
		}
		else {
			return _designation;
		}
	}

	@Override
	public void setDesignation(String designation) {
		_designation = designation;
	}

	@Override
	public String getQualification() {
		if (_qualification == null) {
			return StringPool.BLANK;
		}
		else {
			return _qualification;
		}
	}

	@Override
	public void setQualification(String qualification) {
		_qualification = qualification;
	}

	@Override
	public String getQualificationDate() {
		if (_qualificationDate == null) {
			return StringPool.BLANK;
		}
		else {
			return _qualificationDate;
		}
	}

	@Override
	public void setQualificationDate(String qualificationDate) {
		_qualificationDate = qualificationDate;
	}

	@Override
	public String getEmailAddress() {
		if (_emailAddress == null) {
			return StringPool.BLANK;
		}
		else {
			return _emailAddress;
		}
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	@Override
	public String getDepartment() {
		if (_department == null) {
			return StringPool.BLANK;
		}
		else {
			return _department;
		}
	}

	@Override
	public void setDepartment(String department) {
		_department = department;
	}

	@Override
	public long getMobileNumber() {
		return _mobileNumber;
	}

	@Override
	public void setMobileNumber(long mobileNumber) {
		_mobileNumber = mobileNumber;
	}

	@Override
	public long getTelephoneNumber() {
		return _telephoneNumber;
	}

	@Override
	public void setTelephoneNumber(long telephoneNumber) {
		_telephoneNumber = telephoneNumber;
	}

	@Override
	public long getFaxNumber() {
		return _faxNumber;
	}

	@Override
	public void setFaxNumber(long faxNumber) {
		_faxNumber = faxNumber;
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
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(0,
			SPOrgContactUs.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public SPOrgContactUs toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (SPOrgContactUs)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		SPOrgContactUsImpl spOrgContactUsImpl = new SPOrgContactUsImpl();

		spOrgContactUsImpl.setSpContactUsId(getSpContactUsId());
		spOrgContactUsImpl.setGroupId(getGroupId());
		spOrgContactUsImpl.setOrganizationId(getOrganizationId());
		spOrgContactUsImpl.setUserId(getUserId());
		spOrgContactUsImpl.setUserName(getUserName());
		spOrgContactUsImpl.setCreateDate(getCreateDate());
		spOrgContactUsImpl.setModifiedDate(getModifiedDate());
		spOrgContactUsImpl.setSalutation(getSalutation());
		spOrgContactUsImpl.setPerson(getPerson());
		spOrgContactUsImpl.setFirstName(getFirstName());
		spOrgContactUsImpl.setLastName(getLastName());
		spOrgContactUsImpl.setDesignation(getDesignation());
		spOrgContactUsImpl.setQualification(getQualification());
		spOrgContactUsImpl.setQualificationDate(getQualificationDate());
		spOrgContactUsImpl.setEmailAddress(getEmailAddress());
		spOrgContactUsImpl.setDepartment(getDepartment());
		spOrgContactUsImpl.setMobileNumber(getMobileNumber());
		spOrgContactUsImpl.setTelephoneNumber(getTelephoneNumber());
		spOrgContactUsImpl.setFaxNumber(getFaxNumber());
		spOrgContactUsImpl.setBillingContact(getBillingContact());
		spOrgContactUsImpl.setOperationsContact(getOperationsContact());
		spOrgContactUsImpl.setActive(getActive());

		spOrgContactUsImpl.resetOriginalValues();

		return spOrgContactUsImpl;
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

		if (!(obj instanceof SPOrgContactUs)) {
			return false;
		}

		SPOrgContactUs spOrgContactUs = (SPOrgContactUs)obj;

		long primaryKey = spOrgContactUs.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		SPOrgContactUsModelImpl spOrgContactUsModelImpl = this;

		spOrgContactUsModelImpl._originalOrganizationId = spOrgContactUsModelImpl._organizationId;

		spOrgContactUsModelImpl._setOriginalOrganizationId = false;

		spOrgContactUsModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<SPOrgContactUs> toCacheModel() {
		SPOrgContactUsCacheModel spOrgContactUsCacheModel = new SPOrgContactUsCacheModel();

		spOrgContactUsCacheModel.spContactUsId = getSpContactUsId();

		spOrgContactUsCacheModel.groupId = getGroupId();

		spOrgContactUsCacheModel.organizationId = getOrganizationId();

		spOrgContactUsCacheModel.userId = getUserId();

		spOrgContactUsCacheModel.userName = getUserName();

		String userName = spOrgContactUsCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			spOrgContactUsCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			spOrgContactUsCacheModel.createDate = createDate.getTime();
		}
		else {
			spOrgContactUsCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			spOrgContactUsCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			spOrgContactUsCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		spOrgContactUsCacheModel.salutation = getSalutation();

		String salutation = spOrgContactUsCacheModel.salutation;

		if ((salutation != null) && (salutation.length() == 0)) {
			spOrgContactUsCacheModel.salutation = null;
		}

		spOrgContactUsCacheModel.person = getPerson();

		String person = spOrgContactUsCacheModel.person;

		if ((person != null) && (person.length() == 0)) {
			spOrgContactUsCacheModel.person = null;
		}

		spOrgContactUsCacheModel.firstName = getFirstName();

		String firstName = spOrgContactUsCacheModel.firstName;

		if ((firstName != null) && (firstName.length() == 0)) {
			spOrgContactUsCacheModel.firstName = null;
		}

		spOrgContactUsCacheModel.lastName = getLastName();

		String lastName = spOrgContactUsCacheModel.lastName;

		if ((lastName != null) && (lastName.length() == 0)) {
			spOrgContactUsCacheModel.lastName = null;
		}

		spOrgContactUsCacheModel.designation = getDesignation();

		String designation = spOrgContactUsCacheModel.designation;

		if ((designation != null) && (designation.length() == 0)) {
			spOrgContactUsCacheModel.designation = null;
		}

		spOrgContactUsCacheModel.qualification = getQualification();

		String qualification = spOrgContactUsCacheModel.qualification;

		if ((qualification != null) && (qualification.length() == 0)) {
			spOrgContactUsCacheModel.qualification = null;
		}

		spOrgContactUsCacheModel.qualificationDate = getQualificationDate();

		String qualificationDate = spOrgContactUsCacheModel.qualificationDate;

		if ((qualificationDate != null) && (qualificationDate.length() == 0)) {
			spOrgContactUsCacheModel.qualificationDate = null;
		}

		spOrgContactUsCacheModel.emailAddress = getEmailAddress();

		String emailAddress = spOrgContactUsCacheModel.emailAddress;

		if ((emailAddress != null) && (emailAddress.length() == 0)) {
			spOrgContactUsCacheModel.emailAddress = null;
		}

		spOrgContactUsCacheModel.department = getDepartment();

		String department = spOrgContactUsCacheModel.department;

		if ((department != null) && (department.length() == 0)) {
			spOrgContactUsCacheModel.department = null;
		}

		spOrgContactUsCacheModel.mobileNumber = getMobileNumber();

		spOrgContactUsCacheModel.telephoneNumber = getTelephoneNumber();

		spOrgContactUsCacheModel.faxNumber = getFaxNumber();

		spOrgContactUsCacheModel.billingContact = getBillingContact();

		spOrgContactUsCacheModel.operationsContact = getOperationsContact();

		spOrgContactUsCacheModel.active = getActive();

		return spOrgContactUsCacheModel;
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

	private static ClassLoader _classLoader = SPOrgContactUs.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			SPOrgContactUs.class
		};
	private long _spContactUsId;
	private long _groupId;
	private long _organizationId;
	private long _originalOrganizationId;
	private boolean _setOriginalOrganizationId;
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
	private long _columnBitmask;
	private SPOrgContactUs _escapedModel;
}