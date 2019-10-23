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

package com.sambaash.platform.srv.contactus.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPContactUs}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPContactUs
 * @generated
 */
public class SPContactUsWrapper implements SPContactUs,
	ModelWrapper<SPContactUs> {
	public SPContactUsWrapper(SPContactUs spContactUs) {
		_spContactUs = spContactUs;
	}

	@Override
	public Class<?> getModelClass() {
		return SPContactUs.class;
	}

	@Override
	public String getModelClassName() {
		return SPContactUs.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spContactUsId", getSpContactUsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("category", getCategory());
		attributes.put("comment", getComment());
		attributes.put("countryName", getCountryName());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("company", getCompany());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("companyUrl", getCompanyUrl());
		attributes.put("noOfEmployee", getNoOfEmployee());
		attributes.put("rate", getRate());
		attributes.put("typeOfEnquiry", getTypeOfEnquiry());
		attributes.put("location", getLocation());

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

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String comment = (String)attributes.get("comment");

		if (comment != null) {
			setComment(comment);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		Long contactNumber = (Long)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String companyUrl = (String)attributes.get("companyUrl");

		if (companyUrl != null) {
			setCompanyUrl(companyUrl);
		}

		Long noOfEmployee = (Long)attributes.get("noOfEmployee");

		if (noOfEmployee != null) {
			setNoOfEmployee(noOfEmployee);
		}

		String rate = (String)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}

		String typeOfEnquiry = (String)attributes.get("typeOfEnquiry");

		if (typeOfEnquiry != null) {
			setTypeOfEnquiry(typeOfEnquiry);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}
	}

	/**
	* Returns the primary key of this s p contact us.
	*
	* @return the primary key of this s p contact us
	*/
	@Override
	public long getPrimaryKey() {
		return _spContactUs.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p contact us.
	*
	* @param primaryKey the primary key of this s p contact us
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spContactUs.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp contact us ID of this s p contact us.
	*
	* @return the sp contact us ID of this s p contact us
	*/
	@Override
	public long getSpContactUsId() {
		return _spContactUs.getSpContactUsId();
	}

	/**
	* Sets the sp contact us ID of this s p contact us.
	*
	* @param spContactUsId the sp contact us ID of this s p contact us
	*/
	@Override
	public void setSpContactUsId(long spContactUsId) {
		_spContactUs.setSpContactUsId(spContactUsId);
	}

	/**
	* Returns the group ID of this s p contact us.
	*
	* @return the group ID of this s p contact us
	*/
	@Override
	public long getGroupId() {
		return _spContactUs.getGroupId();
	}

	/**
	* Sets the group ID of this s p contact us.
	*
	* @param groupId the group ID of this s p contact us
	*/
	@Override
	public void setGroupId(long groupId) {
		_spContactUs.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p contact us.
	*
	* @return the company ID of this s p contact us
	*/
	@Override
	public long getCompanyId() {
		return _spContactUs.getCompanyId();
	}

	/**
	* Sets the company ID of this s p contact us.
	*
	* @param companyId the company ID of this s p contact us
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spContactUs.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p contact us.
	*
	* @return the user ID of this s p contact us
	*/
	@Override
	public long getUserId() {
		return _spContactUs.getUserId();
	}

	/**
	* Sets the user ID of this s p contact us.
	*
	* @param userId the user ID of this s p contact us
	*/
	@Override
	public void setUserId(long userId) {
		_spContactUs.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p contact us.
	*
	* @return the user uuid of this s p contact us
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spContactUs.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p contact us.
	*
	* @param userUuid the user uuid of this s p contact us
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spContactUs.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p contact us.
	*
	* @return the user name of this s p contact us
	*/
	@Override
	public java.lang.String getUserName() {
		return _spContactUs.getUserName();
	}

	/**
	* Sets the user name of this s p contact us.
	*
	* @param userName the user name of this s p contact us
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spContactUs.setUserName(userName);
	}

	/**
	* Returns the create date of this s p contact us.
	*
	* @return the create date of this s p contact us
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spContactUs.getCreateDate();
	}

	/**
	* Sets the create date of this s p contact us.
	*
	* @param createDate the create date of this s p contact us
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spContactUs.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p contact us.
	*
	* @return the modified date of this s p contact us
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spContactUs.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p contact us.
	*
	* @param modifiedDate the modified date of this s p contact us
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spContactUs.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this s p contact us.
	*
	* @return the name of this s p contact us
	*/
	@Override
	public java.lang.String getName() {
		return _spContactUs.getName();
	}

	/**
	* Sets the name of this s p contact us.
	*
	* @param name the name of this s p contact us
	*/
	@Override
	public void setName(java.lang.String name) {
		_spContactUs.setName(name);
	}

	/**
	* Returns the last name of this s p contact us.
	*
	* @return the last name of this s p contact us
	*/
	@Override
	public java.lang.String getLastName() {
		return _spContactUs.getLastName();
	}

	/**
	* Sets the last name of this s p contact us.
	*
	* @param lastName the last name of this s p contact us
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_spContactUs.setLastName(lastName);
	}

	/**
	* Returns the email address of this s p contact us.
	*
	* @return the email address of this s p contact us
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spContactUs.getEmailAddress();
	}

	/**
	* Sets the email address of this s p contact us.
	*
	* @param emailAddress the email address of this s p contact us
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spContactUs.setEmailAddress(emailAddress);
	}

	/**
	* Returns the category of this s p contact us.
	*
	* @return the category of this s p contact us
	*/
	@Override
	public java.lang.String getCategory() {
		return _spContactUs.getCategory();
	}

	/**
	* Sets the category of this s p contact us.
	*
	* @param category the category of this s p contact us
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_spContactUs.setCategory(category);
	}

	/**
	* Returns the comment of this s p contact us.
	*
	* @return the comment of this s p contact us
	*/
	@Override
	public java.lang.String getComment() {
		return _spContactUs.getComment();
	}

	/**
	* Sets the comment of this s p contact us.
	*
	* @param comment the comment of this s p contact us
	*/
	@Override
	public void setComment(java.lang.String comment) {
		_spContactUs.setComment(comment);
	}

	/**
	* Returns the country name of this s p contact us.
	*
	* @return the country name of this s p contact us
	*/
	@Override
	public java.lang.String getCountryName() {
		return _spContactUs.getCountryName();
	}

	/**
	* Sets the country name of this s p contact us.
	*
	* @param countryName the country name of this s p contact us
	*/
	@Override
	public void setCountryName(java.lang.String countryName) {
		_spContactUs.setCountryName(countryName);
	}

	/**
	* Returns the contact number of this s p contact us.
	*
	* @return the contact number of this s p contact us
	*/
	@Override
	public long getContactNumber() {
		return _spContactUs.getContactNumber();
	}

	/**
	* Sets the contact number of this s p contact us.
	*
	* @param contactNumber the contact number of this s p contact us
	*/
	@Override
	public void setContactNumber(long contactNumber) {
		_spContactUs.setContactNumber(contactNumber);
	}

	/**
	* Returns the company of this s p contact us.
	*
	* @return the company of this s p contact us
	*/
	@Override
	public java.lang.String getCompany() {
		return _spContactUs.getCompany();
	}

	/**
	* Sets the company of this s p contact us.
	*
	* @param company the company of this s p contact us
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_spContactUs.setCompany(company);
	}

	/**
	* Returns the job title of this s p contact us.
	*
	* @return the job title of this s p contact us
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _spContactUs.getJobTitle();
	}

	/**
	* Sets the job title of this s p contact us.
	*
	* @param jobTitle the job title of this s p contact us
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_spContactUs.setJobTitle(jobTitle);
	}

	/**
	* Returns the company url of this s p contact us.
	*
	* @return the company url of this s p contact us
	*/
	@Override
	public java.lang.String getCompanyUrl() {
		return _spContactUs.getCompanyUrl();
	}

	/**
	* Sets the company url of this s p contact us.
	*
	* @param companyUrl the company url of this s p contact us
	*/
	@Override
	public void setCompanyUrl(java.lang.String companyUrl) {
		_spContactUs.setCompanyUrl(companyUrl);
	}

	/**
	* Returns the no of employee of this s p contact us.
	*
	* @return the no of employee of this s p contact us
	*/
	@Override
	public long getNoOfEmployee() {
		return _spContactUs.getNoOfEmployee();
	}

	/**
	* Sets the no of employee of this s p contact us.
	*
	* @param noOfEmployee the no of employee of this s p contact us
	*/
	@Override
	public void setNoOfEmployee(long noOfEmployee) {
		_spContactUs.setNoOfEmployee(noOfEmployee);
	}

	/**
	* Returns the rate of this s p contact us.
	*
	* @return the rate of this s p contact us
	*/
	@Override
	public java.lang.String getRate() {
		return _spContactUs.getRate();
	}

	/**
	* Sets the rate of this s p contact us.
	*
	* @param rate the rate of this s p contact us
	*/
	@Override
	public void setRate(java.lang.String rate) {
		_spContactUs.setRate(rate);
	}

	/**
	* Returns the type of enquiry of this s p contact us.
	*
	* @return the type of enquiry of this s p contact us
	*/
	@Override
	public java.lang.String getTypeOfEnquiry() {
		return _spContactUs.getTypeOfEnquiry();
	}

	/**
	* Sets the type of enquiry of this s p contact us.
	*
	* @param typeOfEnquiry the type of enquiry of this s p contact us
	*/
	@Override
	public void setTypeOfEnquiry(java.lang.String typeOfEnquiry) {
		_spContactUs.setTypeOfEnquiry(typeOfEnquiry);
	}

	/**
	* Returns the location of this s p contact us.
	*
	* @return the location of this s p contact us
	*/
	@Override
	public java.lang.String getLocation() {
		return _spContactUs.getLocation();
	}

	/**
	* Sets the location of this s p contact us.
	*
	* @param location the location of this s p contact us
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_spContactUs.setLocation(location);
	}

	@Override
	public boolean isNew() {
		return _spContactUs.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spContactUs.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spContactUs.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spContactUs.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spContactUs.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spContactUs.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spContactUs.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spContactUs.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spContactUs.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spContactUs.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spContactUs.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPContactUsWrapper((SPContactUs)_spContactUs.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.contactus.model.SPContactUs spContactUs) {
		return _spContactUs.compareTo(spContactUs);
	}

	@Override
	public int hashCode() {
		return _spContactUs.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.contactus.model.SPContactUs> toCacheModel() {
		return _spContactUs.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.contactus.model.SPContactUs toEscapedModel() {
		return new SPContactUsWrapper(_spContactUs.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.contactus.model.SPContactUs toUnescapedModel() {
		return new SPContactUsWrapper(_spContactUs.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spContactUs.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spContactUs.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spContactUs.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPContactUsWrapper)) {
			return false;
		}

		SPContactUsWrapper spContactUsWrapper = (SPContactUsWrapper)obj;

		if (Validator.equals(_spContactUs, spContactUsWrapper._spContactUs)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPContactUs getWrappedSPContactUs() {
		return _spContactUs;
	}

	@Override
	public SPContactUs getWrappedModel() {
		return _spContactUs;
	}

	@Override
	public void resetOriginalValues() {
		_spContactUs.resetOriginalValues();
	}

	private SPContactUs _spContactUs;
}