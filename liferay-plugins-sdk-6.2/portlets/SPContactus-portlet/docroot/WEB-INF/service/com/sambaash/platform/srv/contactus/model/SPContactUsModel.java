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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SPContactUs service. Represents a row in the &quot;SPContactUs&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.contactus.model.impl.SPContactUsImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPContactUs
 * @see com.sambaash.platform.srv.contactus.model.impl.SPContactUsImpl
 * @see com.sambaash.platform.srv.contactus.model.impl.SPContactUsModelImpl
 * @generated
 */
public interface SPContactUsModel extends BaseModel<SPContactUs>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p contact us model instance should use the {@link SPContactUs} interface instead.
	 */

	/**
	 * Returns the primary key of this s p contact us.
	 *
	 * @return the primary key of this s p contact us
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p contact us.
	 *
	 * @param primaryKey the primary key of this s p contact us
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp contact us ID of this s p contact us.
	 *
	 * @return the sp contact us ID of this s p contact us
	 */
	public long getSpContactUsId();

	/**
	 * Sets the sp contact us ID of this s p contact us.
	 *
	 * @param spContactUsId the sp contact us ID of this s p contact us
	 */
	public void setSpContactUsId(long spContactUsId);

	/**
	 * Returns the group ID of this s p contact us.
	 *
	 * @return the group ID of this s p contact us
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this s p contact us.
	 *
	 * @param groupId the group ID of this s p contact us
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this s p contact us.
	 *
	 * @return the company ID of this s p contact us
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p contact us.
	 *
	 * @param companyId the company ID of this s p contact us
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this s p contact us.
	 *
	 * @return the user ID of this s p contact us
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this s p contact us.
	 *
	 * @param userId the user ID of this s p contact us
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p contact us.
	 *
	 * @return the user uuid of this s p contact us
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p contact us.
	 *
	 * @param userUuid the user uuid of this s p contact us
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this s p contact us.
	 *
	 * @return the user name of this s p contact us
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this s p contact us.
	 *
	 * @param userName the user name of this s p contact us
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this s p contact us.
	 *
	 * @return the create date of this s p contact us
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p contact us.
	 *
	 * @param createDate the create date of this s p contact us
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p contact us.
	 *
	 * @return the modified date of this s p contact us
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p contact us.
	 *
	 * @param modifiedDate the modified date of this s p contact us
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the name of this s p contact us.
	 *
	 * @return the name of this s p contact us
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this s p contact us.
	 *
	 * @param name the name of this s p contact us
	 */
	public void setName(String name);

	/**
	 * Returns the last name of this s p contact us.
	 *
	 * @return the last name of this s p contact us
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this s p contact us.
	 *
	 * @param lastName the last name of this s p contact us
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the email address of this s p contact us.
	 *
	 * @return the email address of this s p contact us
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this s p contact us.
	 *
	 * @param emailAddress the email address of this s p contact us
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the category of this s p contact us.
	 *
	 * @return the category of this s p contact us
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this s p contact us.
	 *
	 * @param category the category of this s p contact us
	 */
	public void setCategory(String category);

	/**
	 * Returns the comment of this s p contact us.
	 *
	 * @return the comment of this s p contact us
	 */
	@AutoEscape
	public String getComment();

	/**
	 * Sets the comment of this s p contact us.
	 *
	 * @param comment the comment of this s p contact us
	 */
	public void setComment(String comment);

	/**
	 * Returns the country name of this s p contact us.
	 *
	 * @return the country name of this s p contact us
	 */
	@AutoEscape
	public String getCountryName();

	/**
	 * Sets the country name of this s p contact us.
	 *
	 * @param countryName the country name of this s p contact us
	 */
	public void setCountryName(String countryName);

	/**
	 * Returns the contact number of this s p contact us.
	 *
	 * @return the contact number of this s p contact us
	 */
	public long getContactNumber();

	/**
	 * Sets the contact number of this s p contact us.
	 *
	 * @param contactNumber the contact number of this s p contact us
	 */
	public void setContactNumber(long contactNumber);

	/**
	 * Returns the company of this s p contact us.
	 *
	 * @return the company of this s p contact us
	 */
	@AutoEscape
	public String getCompany();

	/**
	 * Sets the company of this s p contact us.
	 *
	 * @param company the company of this s p contact us
	 */
	public void setCompany(String company);

	/**
	 * Returns the job title of this s p contact us.
	 *
	 * @return the job title of this s p contact us
	 */
	@AutoEscape
	public String getJobTitle();

	/**
	 * Sets the job title of this s p contact us.
	 *
	 * @param jobTitle the job title of this s p contact us
	 */
	public void setJobTitle(String jobTitle);

	/**
	 * Returns the company url of this s p contact us.
	 *
	 * @return the company url of this s p contact us
	 */
	@AutoEscape
	public String getCompanyUrl();

	/**
	 * Sets the company url of this s p contact us.
	 *
	 * @param companyUrl the company url of this s p contact us
	 */
	public void setCompanyUrl(String companyUrl);

	/**
	 * Returns the no of employee of this s p contact us.
	 *
	 * @return the no of employee of this s p contact us
	 */
	public long getNoOfEmployee();

	/**
	 * Sets the no of employee of this s p contact us.
	 *
	 * @param noOfEmployee the no of employee of this s p contact us
	 */
	public void setNoOfEmployee(long noOfEmployee);

	/**
	 * Returns the rate of this s p contact us.
	 *
	 * @return the rate of this s p contact us
	 */
	@AutoEscape
	public String getRate();

	/**
	 * Sets the rate of this s p contact us.
	 *
	 * @param rate the rate of this s p contact us
	 */
	public void setRate(String rate);

	/**
	 * Returns the type of enquiry of this s p contact us.
	 *
	 * @return the type of enquiry of this s p contact us
	 */
	@AutoEscape
	public String getTypeOfEnquiry();

	/**
	 * Sets the type of enquiry of this s p contact us.
	 *
	 * @param typeOfEnquiry the type of enquiry of this s p contact us
	 */
	public void setTypeOfEnquiry(String typeOfEnquiry);

	/**
	 * Returns the location of this s p contact us.
	 *
	 * @return the location of this s p contact us
	 */
	@AutoEscape
	public String getLocation();

	/**
	 * Sets the location of this s p contact us.
	 *
	 * @param location the location of this s p contact us
	 */
	public void setLocation(String location);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.sambaash.platform.srv.contactus.model.SPContactUs spContactUs);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.contactus.model.SPContactUs> toCacheModel();

	@Override
	public com.sambaash.platform.srv.contactus.model.SPContactUs toEscapedModel();

	@Override
	public com.sambaash.platform.srv.contactus.model.SPContactUs toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}