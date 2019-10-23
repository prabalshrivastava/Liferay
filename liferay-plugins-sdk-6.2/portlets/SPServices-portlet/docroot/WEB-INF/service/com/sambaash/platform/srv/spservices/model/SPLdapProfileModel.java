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

package com.sambaash.platform.srv.spservices.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SPLdapProfile service. Represents a row in the &quot;SPLdapProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLdapProfile
 * @see com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileImpl
 * @see com.sambaash.platform.srv.spservices.model.impl.SPLdapProfileModelImpl
 * @generated
 */
public interface SPLdapProfileModel extends BaseModel<SPLdapProfile> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p ldap profile model instance should use the {@link SPLdapProfile} interface instead.
	 */

	/**
	 * Returns the primary key of this s p ldap profile.
	 *
	 * @return the primary key of this s p ldap profile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p ldap profile.
	 *
	 * @param primaryKey the primary key of this s p ldap profile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp ldap profile ID of this s p ldap profile.
	 *
	 * @return the sp ldap profile ID of this s p ldap profile
	 */
	public long getSpLdapProfileId();

	/**
	 * Sets the sp ldap profile ID of this s p ldap profile.
	 *
	 * @param spLdapProfileId the sp ldap profile ID of this s p ldap profile
	 */
	public void setSpLdapProfileId(long spLdapProfileId);

	/**
	 * Returns the group ID of this s p ldap profile.
	 *
	 * @return the group ID of this s p ldap profile
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this s p ldap profile.
	 *
	 * @param groupId the group ID of this s p ldap profile
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this s p ldap profile.
	 *
	 * @return the company ID of this s p ldap profile
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p ldap profile.
	 *
	 * @param companyId the company ID of this s p ldap profile
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this s p ldap profile.
	 *
	 * @return the create date of this s p ldap profile
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p ldap profile.
	 *
	 * @param createDate the create date of this s p ldap profile
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p ldap profile.
	 *
	 * @return the modified date of this s p ldap profile
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p ldap profile.
	 *
	 * @param modifiedDate the modified date of this s p ldap profile
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user ID of this s p ldap profile.
	 *
	 * @return the user ID of this s p ldap profile
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this s p ldap profile.
	 *
	 * @param userId the user ID of this s p ldap profile
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p ldap profile.
	 *
	 * @return the user uuid of this s p ldap profile
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p ldap profile.
	 *
	 * @param userUuid the user uuid of this s p ldap profile
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the country ID of this s p ldap profile.
	 *
	 * @return the country ID of this s p ldap profile
	 */
	public long getCountryId();

	/**
	 * Sets the country ID of this s p ldap profile.
	 *
	 * @param countryId the country ID of this s p ldap profile
	 */
	public void setCountryId(long countryId);

	/**
	 * Returns the department ID of this s p ldap profile.
	 *
	 * @return the department ID of this s p ldap profile
	 */
	public long getDepartmentId();

	/**
	 * Sets the department ID of this s p ldap profile.
	 *
	 * @param departmentId the department ID of this s p ldap profile
	 */
	public void setDepartmentId(long departmentId);

	/**
	 * Returns the given name of this s p ldap profile.
	 *
	 * @return the given name of this s p ldap profile
	 */
	@AutoEscape
	public String getGivenName();

	/**
	 * Sets the given name of this s p ldap profile.
	 *
	 * @param givenName the given name of this s p ldap profile
	 */
	public void setGivenName(String givenName);

	/**
	 * Returns the sn of this s p ldap profile.
	 *
	 * @return the sn of this s p ldap profile
	 */
	@AutoEscape
	public String getSn();

	/**
	 * Sets the sn of this s p ldap profile.
	 *
	 * @param sn the sn of this s p ldap profile
	 */
	public void setSn(String sn);

	/**
	 * Returns the display name of this s p ldap profile.
	 *
	 * @return the display name of this s p ldap profile
	 */
	@AutoEscape
	public String getDisplayName();

	/**
	 * Sets the display name of this s p ldap profile.
	 *
	 * @param displayName the display name of this s p ldap profile
	 */
	public void setDisplayName(String displayName);

	/**
	 * Returns the company of this s p ldap profile.
	 *
	 * @return the company of this s p ldap profile
	 */
	@AutoEscape
	public String getCompany();

	/**
	 * Sets the company of this s p ldap profile.
	 *
	 * @param company the company of this s p ldap profile
	 */
	public void setCompany(String company);

	/**
	 * Returns the division of this s p ldap profile.
	 *
	 * @return the division of this s p ldap profile
	 */
	@AutoEscape
	public String getDivision();

	/**
	 * Sets the division of this s p ldap profile.
	 *
	 * @param division the division of this s p ldap profile
	 */
	public void setDivision(String division);

	/**
	 * Returns the title of this s p ldap profile.
	 *
	 * @return the title of this s p ldap profile
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this s p ldap profile.
	 *
	 * @param title the title of this s p ldap profile
	 */
	public void setTitle(String title);

	/**
	 * Returns the mail of this s p ldap profile.
	 *
	 * @return the mail of this s p ldap profile
	 */
	@AutoEscape
	public String getMail();

	/**
	 * Sets the mail of this s p ldap profile.
	 *
	 * @param mail the mail of this s p ldap profile
	 */
	public void setMail(String mail);

	/**
	 * Returns the sam account name of this s p ldap profile.
	 *
	 * @return the sam account name of this s p ldap profile
	 */
	@AutoEscape
	public String getSamAccountName();

	/**
	 * Sets the sam account name of this s p ldap profile.
	 *
	 * @param samAccountName the sam account name of this s p ldap profile
	 */
	public void setSamAccountName(String samAccountName);

	/**
	 * Returns the employee ID of this s p ldap profile.
	 *
	 * @return the employee ID of this s p ldap profile
	 */
	@AutoEscape
	public String getEmployeeId();

	/**
	 * Sets the employee ID of this s p ldap profile.
	 *
	 * @param employeeId the employee ID of this s p ldap profile
	 */
	public void setEmployeeId(String employeeId);

	/**
	 * Returns the manager of this s p ldap profile.
	 *
	 * @return the manager of this s p ldap profile
	 */
	@AutoEscape
	public String getManager();

	/**
	 * Sets the manager of this s p ldap profile.
	 *
	 * @param manager the manager of this s p ldap profile
	 */
	public void setManager(String manager);

	/**
	 * Returns the telephone number of this s p ldap profile.
	 *
	 * @return the telephone number of this s p ldap profile
	 */
	@AutoEscape
	public String getTelephoneNumber();

	/**
	 * Sets the telephone number of this s p ldap profile.
	 *
	 * @param telephoneNumber the telephone number of this s p ldap profile
	 */
	public void setTelephoneNumber(String telephoneNumber);

	/**
	 * Returns the mobile of this s p ldap profile.
	 *
	 * @return the mobile of this s p ldap profile
	 */
	@AutoEscape
	public String getMobile();

	/**
	 * Sets the mobile of this s p ldap profile.
	 *
	 * @param mobile the mobile of this s p ldap profile
	 */
	public void setMobile(String mobile);

	/**
	 * Returns the facsimile telephone number of this s p ldap profile.
	 *
	 * @return the facsimile telephone number of this s p ldap profile
	 */
	@AutoEscape
	public String getFacsimileTelephoneNumber();

	/**
	 * Sets the facsimile telephone number of this s p ldap profile.
	 *
	 * @param facsimileTelephoneNumber the facsimile telephone number of this s p ldap profile
	 */
	public void setFacsimileTelephoneNumber(String facsimileTelephoneNumber);

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
		com.sambaash.platform.srv.spservices.model.SPLdapProfile spLdapProfile);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spservices.model.SPLdapProfile> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}