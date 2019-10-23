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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPOrgContactUs}.
 * </p>
 *
 * @author pradeep
 * @see SPOrgContactUs
 * @generated
 */
public class SPOrgContactUsWrapper implements SPOrgContactUs,
	ModelWrapper<SPOrgContactUs> {
	public SPOrgContactUsWrapper(SPOrgContactUs spOrgContactUs) {
		_spOrgContactUs = spOrgContactUs;
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

	/**
	* Returns the primary key of this s p org contact us.
	*
	* @return the primary key of this s p org contact us
	*/
	@Override
	public long getPrimaryKey() {
		return _spOrgContactUs.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p org contact us.
	*
	* @param primaryKey the primary key of this s p org contact us
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spOrgContactUs.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp contact us ID of this s p org contact us.
	*
	* @return the sp contact us ID of this s p org contact us
	*/
	@Override
	public long getSpContactUsId() {
		return _spOrgContactUs.getSpContactUsId();
	}

	/**
	* Sets the sp contact us ID of this s p org contact us.
	*
	* @param spContactUsId the sp contact us ID of this s p org contact us
	*/
	@Override
	public void setSpContactUsId(long spContactUsId) {
		_spOrgContactUs.setSpContactUsId(spContactUsId);
	}

	/**
	* Returns the group ID of this s p org contact us.
	*
	* @return the group ID of this s p org contact us
	*/
	@Override
	public long getGroupId() {
		return _spOrgContactUs.getGroupId();
	}

	/**
	* Sets the group ID of this s p org contact us.
	*
	* @param groupId the group ID of this s p org contact us
	*/
	@Override
	public void setGroupId(long groupId) {
		_spOrgContactUs.setGroupId(groupId);
	}

	/**
	* Returns the organization ID of this s p org contact us.
	*
	* @return the organization ID of this s p org contact us
	*/
	@Override
	public long getOrganizationId() {
		return _spOrgContactUs.getOrganizationId();
	}

	/**
	* Sets the organization ID of this s p org contact us.
	*
	* @param organizationId the organization ID of this s p org contact us
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_spOrgContactUs.setOrganizationId(organizationId);
	}

	/**
	* Returns the user ID of this s p org contact us.
	*
	* @return the user ID of this s p org contact us
	*/
	@Override
	public long getUserId() {
		return _spOrgContactUs.getUserId();
	}

	/**
	* Sets the user ID of this s p org contact us.
	*
	* @param userId the user ID of this s p org contact us
	*/
	@Override
	public void setUserId(long userId) {
		_spOrgContactUs.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p org contact us.
	*
	* @return the user uuid of this s p org contact us
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spOrgContactUs.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p org contact us.
	*
	* @param userUuid the user uuid of this s p org contact us
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spOrgContactUs.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p org contact us.
	*
	* @return the user name of this s p org contact us
	*/
	@Override
	public java.lang.String getUserName() {
		return _spOrgContactUs.getUserName();
	}

	/**
	* Sets the user name of this s p org contact us.
	*
	* @param userName the user name of this s p org contact us
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spOrgContactUs.setUserName(userName);
	}

	/**
	* Returns the create date of this s p org contact us.
	*
	* @return the create date of this s p org contact us
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spOrgContactUs.getCreateDate();
	}

	/**
	* Sets the create date of this s p org contact us.
	*
	* @param createDate the create date of this s p org contact us
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spOrgContactUs.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p org contact us.
	*
	* @return the modified date of this s p org contact us
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spOrgContactUs.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p org contact us.
	*
	* @param modifiedDate the modified date of this s p org contact us
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spOrgContactUs.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the salutation of this s p org contact us.
	*
	* @return the salutation of this s p org contact us
	*/
	@Override
	public java.lang.String getSalutation() {
		return _spOrgContactUs.getSalutation();
	}

	/**
	* Sets the salutation of this s p org contact us.
	*
	* @param salutation the salutation of this s p org contact us
	*/
	@Override
	public void setSalutation(java.lang.String salutation) {
		_spOrgContactUs.setSalutation(salutation);
	}

	/**
	* Returns the person of this s p org contact us.
	*
	* @return the person of this s p org contact us
	*/
	@Override
	public java.lang.String getPerson() {
		return _spOrgContactUs.getPerson();
	}

	/**
	* Sets the person of this s p org contact us.
	*
	* @param person the person of this s p org contact us
	*/
	@Override
	public void setPerson(java.lang.String person) {
		_spOrgContactUs.setPerson(person);
	}

	/**
	* Returns the first name of this s p org contact us.
	*
	* @return the first name of this s p org contact us
	*/
	@Override
	public java.lang.String getFirstName() {
		return _spOrgContactUs.getFirstName();
	}

	/**
	* Sets the first name of this s p org contact us.
	*
	* @param firstName the first name of this s p org contact us
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_spOrgContactUs.setFirstName(firstName);
	}

	/**
	* Returns the last name of this s p org contact us.
	*
	* @return the last name of this s p org contact us
	*/
	@Override
	public java.lang.String getLastName() {
		return _spOrgContactUs.getLastName();
	}

	/**
	* Sets the last name of this s p org contact us.
	*
	* @param lastName the last name of this s p org contact us
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_spOrgContactUs.setLastName(lastName);
	}

	/**
	* Returns the designation of this s p org contact us.
	*
	* @return the designation of this s p org contact us
	*/
	@Override
	public java.lang.String getDesignation() {
		return _spOrgContactUs.getDesignation();
	}

	/**
	* Sets the designation of this s p org contact us.
	*
	* @param designation the designation of this s p org contact us
	*/
	@Override
	public void setDesignation(java.lang.String designation) {
		_spOrgContactUs.setDesignation(designation);
	}

	/**
	* Returns the qualification of this s p org contact us.
	*
	* @return the qualification of this s p org contact us
	*/
	@Override
	public java.lang.String getQualification() {
		return _spOrgContactUs.getQualification();
	}

	/**
	* Sets the qualification of this s p org contact us.
	*
	* @param qualification the qualification of this s p org contact us
	*/
	@Override
	public void setQualification(java.lang.String qualification) {
		_spOrgContactUs.setQualification(qualification);
	}

	/**
	* Returns the qualification date of this s p org contact us.
	*
	* @return the qualification date of this s p org contact us
	*/
	@Override
	public java.lang.String getQualificationDate() {
		return _spOrgContactUs.getQualificationDate();
	}

	/**
	* Sets the qualification date of this s p org contact us.
	*
	* @param qualificationDate the qualification date of this s p org contact us
	*/
	@Override
	public void setQualificationDate(java.lang.String qualificationDate) {
		_spOrgContactUs.setQualificationDate(qualificationDate);
	}

	/**
	* Returns the email address of this s p org contact us.
	*
	* @return the email address of this s p org contact us
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spOrgContactUs.getEmailAddress();
	}

	/**
	* Sets the email address of this s p org contact us.
	*
	* @param emailAddress the email address of this s p org contact us
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spOrgContactUs.setEmailAddress(emailAddress);
	}

	/**
	* Returns the department of this s p org contact us.
	*
	* @return the department of this s p org contact us
	*/
	@Override
	public java.lang.String getDepartment() {
		return _spOrgContactUs.getDepartment();
	}

	/**
	* Sets the department of this s p org contact us.
	*
	* @param department the department of this s p org contact us
	*/
	@Override
	public void setDepartment(java.lang.String department) {
		_spOrgContactUs.setDepartment(department);
	}

	/**
	* Returns the mobile number of this s p org contact us.
	*
	* @return the mobile number of this s p org contact us
	*/
	@Override
	public long getMobileNumber() {
		return _spOrgContactUs.getMobileNumber();
	}

	/**
	* Sets the mobile number of this s p org contact us.
	*
	* @param mobileNumber the mobile number of this s p org contact us
	*/
	@Override
	public void setMobileNumber(long mobileNumber) {
		_spOrgContactUs.setMobileNumber(mobileNumber);
	}

	/**
	* Returns the telephone number of this s p org contact us.
	*
	* @return the telephone number of this s p org contact us
	*/
	@Override
	public long getTelephoneNumber() {
		return _spOrgContactUs.getTelephoneNumber();
	}

	/**
	* Sets the telephone number of this s p org contact us.
	*
	* @param telephoneNumber the telephone number of this s p org contact us
	*/
	@Override
	public void setTelephoneNumber(long telephoneNumber) {
		_spOrgContactUs.setTelephoneNumber(telephoneNumber);
	}

	/**
	* Returns the fax number of this s p org contact us.
	*
	* @return the fax number of this s p org contact us
	*/
	@Override
	public long getFaxNumber() {
		return _spOrgContactUs.getFaxNumber();
	}

	/**
	* Sets the fax number of this s p org contact us.
	*
	* @param faxNumber the fax number of this s p org contact us
	*/
	@Override
	public void setFaxNumber(long faxNumber) {
		_spOrgContactUs.setFaxNumber(faxNumber);
	}

	/**
	* Returns the billing contact of this s p org contact us.
	*
	* @return the billing contact of this s p org contact us
	*/
	@Override
	public boolean getBillingContact() {
		return _spOrgContactUs.getBillingContact();
	}

	/**
	* Returns <code>true</code> if this s p org contact us is billing contact.
	*
	* @return <code>true</code> if this s p org contact us is billing contact; <code>false</code> otherwise
	*/
	@Override
	public boolean isBillingContact() {
		return _spOrgContactUs.isBillingContact();
	}

	/**
	* Sets whether this s p org contact us is billing contact.
	*
	* @param billingContact the billing contact of this s p org contact us
	*/
	@Override
	public void setBillingContact(boolean billingContact) {
		_spOrgContactUs.setBillingContact(billingContact);
	}

	/**
	* Returns the operations contact of this s p org contact us.
	*
	* @return the operations contact of this s p org contact us
	*/
	@Override
	public boolean getOperationsContact() {
		return _spOrgContactUs.getOperationsContact();
	}

	/**
	* Returns <code>true</code> if this s p org contact us is operations contact.
	*
	* @return <code>true</code> if this s p org contact us is operations contact; <code>false</code> otherwise
	*/
	@Override
	public boolean isOperationsContact() {
		return _spOrgContactUs.isOperationsContact();
	}

	/**
	* Sets whether this s p org contact us is operations contact.
	*
	* @param operationsContact the operations contact of this s p org contact us
	*/
	@Override
	public void setOperationsContact(boolean operationsContact) {
		_spOrgContactUs.setOperationsContact(operationsContact);
	}

	/**
	* Returns the active of this s p org contact us.
	*
	* @return the active of this s p org contact us
	*/
	@Override
	public boolean getActive() {
		return _spOrgContactUs.getActive();
	}

	/**
	* Returns <code>true</code> if this s p org contact us is active.
	*
	* @return <code>true</code> if this s p org contact us is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _spOrgContactUs.isActive();
	}

	/**
	* Sets whether this s p org contact us is active.
	*
	* @param active the active of this s p org contact us
	*/
	@Override
	public void setActive(boolean active) {
		_spOrgContactUs.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _spOrgContactUs.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spOrgContactUs.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spOrgContactUs.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spOrgContactUs.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spOrgContactUs.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spOrgContactUs.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spOrgContactUs.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spOrgContactUs.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spOrgContactUs.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spOrgContactUs.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spOrgContactUs.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPOrgContactUsWrapper((SPOrgContactUs)_spOrgContactUs.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs spOrgContactUs) {
		return _spOrgContactUs.compareTo(spOrgContactUs);
	}

	@Override
	public int hashCode() {
		return _spOrgContactUs.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs> toCacheModel() {
		return _spOrgContactUs.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs toEscapedModel() {
		return new SPOrgContactUsWrapper(_spOrgContactUs.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPOrgContactUs toUnescapedModel() {
		return new SPOrgContactUsWrapper(_spOrgContactUs.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spOrgContactUs.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spOrgContactUs.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spOrgContactUs.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPOrgContactUsWrapper)) {
			return false;
		}

		SPOrgContactUsWrapper spOrgContactUsWrapper = (SPOrgContactUsWrapper)obj;

		if (Validator.equals(_spOrgContactUs,
					spOrgContactUsWrapper._spOrgContactUs)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPOrgContactUs getWrappedSPOrgContactUs() {
		return _spOrgContactUs;
	}

	@Override
	public SPOrgContactUs getWrappedModel() {
		return _spOrgContactUs;
	}

	@Override
	public void resetOriginalValues() {
		_spOrgContactUs.resetOriginalValues();
	}

	private SPOrgContactUs _spOrgContactUs;
}