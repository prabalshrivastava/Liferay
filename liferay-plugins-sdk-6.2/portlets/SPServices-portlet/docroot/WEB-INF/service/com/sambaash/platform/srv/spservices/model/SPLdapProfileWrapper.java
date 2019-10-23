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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPLdapProfile}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLdapProfile
 * @generated
 */
public class SPLdapProfileWrapper implements SPLdapProfile,
	ModelWrapper<SPLdapProfile> {
	public SPLdapProfileWrapper(SPLdapProfile spLdapProfile) {
		_spLdapProfile = spLdapProfile;
	}

	@Override
	public Class<?> getModelClass() {
		return SPLdapProfile.class;
	}

	@Override
	public String getModelClassName() {
		return SPLdapProfile.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spLdapProfileId", getSpLdapProfileId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("countryId", getCountryId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("givenName", getGivenName());
		attributes.put("sn", getSn());
		attributes.put("displayName", getDisplayName());
		attributes.put("company", getCompany());
		attributes.put("division", getDivision());
		attributes.put("title", getTitle());
		attributes.put("mail", getMail());
		attributes.put("samAccountName", getSamAccountName());
		attributes.put("employeeId", getEmployeeId());
		attributes.put("manager", getManager());
		attributes.put("telephoneNumber", getTelephoneNumber());
		attributes.put("mobile", getMobile());
		attributes.put("facsimileTelephoneNumber", getFacsimileTelephoneNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spLdapProfileId = (Long)attributes.get("spLdapProfileId");

		if (spLdapProfileId != null) {
			setSpLdapProfileId(spLdapProfileId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		String givenName = (String)attributes.get("givenName");

		if (givenName != null) {
			setGivenName(givenName);
		}

		String sn = (String)attributes.get("sn");

		if (sn != null) {
			setSn(sn);
		}

		String displayName = (String)attributes.get("displayName");

		if (displayName != null) {
			setDisplayName(displayName);
		}

		String company = (String)attributes.get("company");

		if (company != null) {
			setCompany(company);
		}

		String division = (String)attributes.get("division");

		if (division != null) {
			setDivision(division);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String mail = (String)attributes.get("mail");

		if (mail != null) {
			setMail(mail);
		}

		String samAccountName = (String)attributes.get("samAccountName");

		if (samAccountName != null) {
			setSamAccountName(samAccountName);
		}

		String employeeId = (String)attributes.get("employeeId");

		if (employeeId != null) {
			setEmployeeId(employeeId);
		}

		String manager = (String)attributes.get("manager");

		if (manager != null) {
			setManager(manager);
		}

		String telephoneNumber = (String)attributes.get("telephoneNumber");

		if (telephoneNumber != null) {
			setTelephoneNumber(telephoneNumber);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String facsimileTelephoneNumber = (String)attributes.get(
				"facsimileTelephoneNumber");

		if (facsimileTelephoneNumber != null) {
			setFacsimileTelephoneNumber(facsimileTelephoneNumber);
		}
	}

	/**
	* Returns the primary key of this s p ldap profile.
	*
	* @return the primary key of this s p ldap profile
	*/
	@Override
	public long getPrimaryKey() {
		return _spLdapProfile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p ldap profile.
	*
	* @param primaryKey the primary key of this s p ldap profile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spLdapProfile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp ldap profile ID of this s p ldap profile.
	*
	* @return the sp ldap profile ID of this s p ldap profile
	*/
	@Override
	public long getSpLdapProfileId() {
		return _spLdapProfile.getSpLdapProfileId();
	}

	/**
	* Sets the sp ldap profile ID of this s p ldap profile.
	*
	* @param spLdapProfileId the sp ldap profile ID of this s p ldap profile
	*/
	@Override
	public void setSpLdapProfileId(long spLdapProfileId) {
		_spLdapProfile.setSpLdapProfileId(spLdapProfileId);
	}

	/**
	* Returns the group ID of this s p ldap profile.
	*
	* @return the group ID of this s p ldap profile
	*/
	@Override
	public long getGroupId() {
		return _spLdapProfile.getGroupId();
	}

	/**
	* Sets the group ID of this s p ldap profile.
	*
	* @param groupId the group ID of this s p ldap profile
	*/
	@Override
	public void setGroupId(long groupId) {
		_spLdapProfile.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p ldap profile.
	*
	* @return the company ID of this s p ldap profile
	*/
	@Override
	public long getCompanyId() {
		return _spLdapProfile.getCompanyId();
	}

	/**
	* Sets the company ID of this s p ldap profile.
	*
	* @param companyId the company ID of this s p ldap profile
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spLdapProfile.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this s p ldap profile.
	*
	* @return the create date of this s p ldap profile
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spLdapProfile.getCreateDate();
	}

	/**
	* Sets the create date of this s p ldap profile.
	*
	* @param createDate the create date of this s p ldap profile
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spLdapProfile.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p ldap profile.
	*
	* @return the modified date of this s p ldap profile
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spLdapProfile.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p ldap profile.
	*
	* @param modifiedDate the modified date of this s p ldap profile
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spLdapProfile.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this s p ldap profile.
	*
	* @return the user ID of this s p ldap profile
	*/
	@Override
	public long getUserId() {
		return _spLdapProfile.getUserId();
	}

	/**
	* Sets the user ID of this s p ldap profile.
	*
	* @param userId the user ID of this s p ldap profile
	*/
	@Override
	public void setUserId(long userId) {
		_spLdapProfile.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p ldap profile.
	*
	* @return the user uuid of this s p ldap profile
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLdapProfile.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p ldap profile.
	*
	* @param userUuid the user uuid of this s p ldap profile
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spLdapProfile.setUserUuid(userUuid);
	}

	/**
	* Returns the country ID of this s p ldap profile.
	*
	* @return the country ID of this s p ldap profile
	*/
	@Override
	public long getCountryId() {
		return _spLdapProfile.getCountryId();
	}

	/**
	* Sets the country ID of this s p ldap profile.
	*
	* @param countryId the country ID of this s p ldap profile
	*/
	@Override
	public void setCountryId(long countryId) {
		_spLdapProfile.setCountryId(countryId);
	}

	/**
	* Returns the department ID of this s p ldap profile.
	*
	* @return the department ID of this s p ldap profile
	*/
	@Override
	public long getDepartmentId() {
		return _spLdapProfile.getDepartmentId();
	}

	/**
	* Sets the department ID of this s p ldap profile.
	*
	* @param departmentId the department ID of this s p ldap profile
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_spLdapProfile.setDepartmentId(departmentId);
	}

	/**
	* Returns the given name of this s p ldap profile.
	*
	* @return the given name of this s p ldap profile
	*/
	@Override
	public java.lang.String getGivenName() {
		return _spLdapProfile.getGivenName();
	}

	/**
	* Sets the given name of this s p ldap profile.
	*
	* @param givenName the given name of this s p ldap profile
	*/
	@Override
	public void setGivenName(java.lang.String givenName) {
		_spLdapProfile.setGivenName(givenName);
	}

	/**
	* Returns the sn of this s p ldap profile.
	*
	* @return the sn of this s p ldap profile
	*/
	@Override
	public java.lang.String getSn() {
		return _spLdapProfile.getSn();
	}

	/**
	* Sets the sn of this s p ldap profile.
	*
	* @param sn the sn of this s p ldap profile
	*/
	@Override
	public void setSn(java.lang.String sn) {
		_spLdapProfile.setSn(sn);
	}

	/**
	* Returns the display name of this s p ldap profile.
	*
	* @return the display name of this s p ldap profile
	*/
	@Override
	public java.lang.String getDisplayName() {
		return _spLdapProfile.getDisplayName();
	}

	/**
	* Sets the display name of this s p ldap profile.
	*
	* @param displayName the display name of this s p ldap profile
	*/
	@Override
	public void setDisplayName(java.lang.String displayName) {
		_spLdapProfile.setDisplayName(displayName);
	}

	/**
	* Returns the company of this s p ldap profile.
	*
	* @return the company of this s p ldap profile
	*/
	@Override
	public java.lang.String getCompany() {
		return _spLdapProfile.getCompany();
	}

	/**
	* Sets the company of this s p ldap profile.
	*
	* @param company the company of this s p ldap profile
	*/
	@Override
	public void setCompany(java.lang.String company) {
		_spLdapProfile.setCompany(company);
	}

	/**
	* Returns the division of this s p ldap profile.
	*
	* @return the division of this s p ldap profile
	*/
	@Override
	public java.lang.String getDivision() {
		return _spLdapProfile.getDivision();
	}

	/**
	* Sets the division of this s p ldap profile.
	*
	* @param division the division of this s p ldap profile
	*/
	@Override
	public void setDivision(java.lang.String division) {
		_spLdapProfile.setDivision(division);
	}

	/**
	* Returns the title of this s p ldap profile.
	*
	* @return the title of this s p ldap profile
	*/
	@Override
	public java.lang.String getTitle() {
		return _spLdapProfile.getTitle();
	}

	/**
	* Sets the title of this s p ldap profile.
	*
	* @param title the title of this s p ldap profile
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_spLdapProfile.setTitle(title);
	}

	/**
	* Returns the mail of this s p ldap profile.
	*
	* @return the mail of this s p ldap profile
	*/
	@Override
	public java.lang.String getMail() {
		return _spLdapProfile.getMail();
	}

	/**
	* Sets the mail of this s p ldap profile.
	*
	* @param mail the mail of this s p ldap profile
	*/
	@Override
	public void setMail(java.lang.String mail) {
		_spLdapProfile.setMail(mail);
	}

	/**
	* Returns the sam account name of this s p ldap profile.
	*
	* @return the sam account name of this s p ldap profile
	*/
	@Override
	public java.lang.String getSamAccountName() {
		return _spLdapProfile.getSamAccountName();
	}

	/**
	* Sets the sam account name of this s p ldap profile.
	*
	* @param samAccountName the sam account name of this s p ldap profile
	*/
	@Override
	public void setSamAccountName(java.lang.String samAccountName) {
		_spLdapProfile.setSamAccountName(samAccountName);
	}

	/**
	* Returns the employee ID of this s p ldap profile.
	*
	* @return the employee ID of this s p ldap profile
	*/
	@Override
	public java.lang.String getEmployeeId() {
		return _spLdapProfile.getEmployeeId();
	}

	/**
	* Sets the employee ID of this s p ldap profile.
	*
	* @param employeeId the employee ID of this s p ldap profile
	*/
	@Override
	public void setEmployeeId(java.lang.String employeeId) {
		_spLdapProfile.setEmployeeId(employeeId);
	}

	/**
	* Returns the manager of this s p ldap profile.
	*
	* @return the manager of this s p ldap profile
	*/
	@Override
	public java.lang.String getManager() {
		return _spLdapProfile.getManager();
	}

	/**
	* Sets the manager of this s p ldap profile.
	*
	* @param manager the manager of this s p ldap profile
	*/
	@Override
	public void setManager(java.lang.String manager) {
		_spLdapProfile.setManager(manager);
	}

	/**
	* Returns the telephone number of this s p ldap profile.
	*
	* @return the telephone number of this s p ldap profile
	*/
	@Override
	public java.lang.String getTelephoneNumber() {
		return _spLdapProfile.getTelephoneNumber();
	}

	/**
	* Sets the telephone number of this s p ldap profile.
	*
	* @param telephoneNumber the telephone number of this s p ldap profile
	*/
	@Override
	public void setTelephoneNumber(java.lang.String telephoneNumber) {
		_spLdapProfile.setTelephoneNumber(telephoneNumber);
	}

	/**
	* Returns the mobile of this s p ldap profile.
	*
	* @return the mobile of this s p ldap profile
	*/
	@Override
	public java.lang.String getMobile() {
		return _spLdapProfile.getMobile();
	}

	/**
	* Sets the mobile of this s p ldap profile.
	*
	* @param mobile the mobile of this s p ldap profile
	*/
	@Override
	public void setMobile(java.lang.String mobile) {
		_spLdapProfile.setMobile(mobile);
	}

	/**
	* Returns the facsimile telephone number of this s p ldap profile.
	*
	* @return the facsimile telephone number of this s p ldap profile
	*/
	@Override
	public java.lang.String getFacsimileTelephoneNumber() {
		return _spLdapProfile.getFacsimileTelephoneNumber();
	}

	/**
	* Sets the facsimile telephone number of this s p ldap profile.
	*
	* @param facsimileTelephoneNumber the facsimile telephone number of this s p ldap profile
	*/
	@Override
	public void setFacsimileTelephoneNumber(
		java.lang.String facsimileTelephoneNumber) {
		_spLdapProfile.setFacsimileTelephoneNumber(facsimileTelephoneNumber);
	}

	@Override
	public boolean isNew() {
		return _spLdapProfile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spLdapProfile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spLdapProfile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spLdapProfile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spLdapProfile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spLdapProfile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spLdapProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spLdapProfile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spLdapProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spLdapProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spLdapProfile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPLdapProfileWrapper((SPLdapProfile)_spLdapProfile.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPLdapProfile spLdapProfile) {
		return _spLdapProfile.compareTo(spLdapProfile);
	}

	@Override
	public int hashCode() {
		return _spLdapProfile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPLdapProfile> toCacheModel() {
		return _spLdapProfile.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile toEscapedModel() {
		return new SPLdapProfileWrapper(_spLdapProfile.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapProfile toUnescapedModel() {
		return new SPLdapProfileWrapper(_spLdapProfile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spLdapProfile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spLdapProfile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spLdapProfile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPLdapProfileWrapper)) {
			return false;
		}

		SPLdapProfileWrapper spLdapProfileWrapper = (SPLdapProfileWrapper)obj;

		if (Validator.equals(_spLdapProfile, spLdapProfileWrapper._spLdapProfile)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPLdapProfile getWrappedSPLdapProfile() {
		return _spLdapProfile;
	}

	@Override
	public SPLdapProfile getWrappedModel() {
		return _spLdapProfile;
	}

	@Override
	public void resetOriginalValues() {
		_spLdapProfile.resetOriginalValues();
	}

	private SPLdapProfile _spLdapProfile;
}