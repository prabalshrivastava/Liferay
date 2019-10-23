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
 * This class is a wrapper for {@link SPLdapMapping}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPLdapMapping
 * @generated
 */
public class SPLdapMappingWrapper implements SPLdapMapping,
	ModelWrapper<SPLdapMapping> {
	public SPLdapMappingWrapper(SPLdapMapping spLdapMapping) {
		_spLdapMapping = spLdapMapping;
	}

	@Override
	public Class<?> getModelClass() {
		return SPLdapMapping.class;
	}

	@Override
	public String getModelClassName() {
		return SPLdapMapping.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spLdapMappingId", getSpLdapMappingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("departmentId", getDepartmentId());
		attributes.put("countryDepartmentId", getCountryDepartmentId());
		attributes.put("ldapCountry", getLdapCountry());
		attributes.put("ldapDepartment", getLdapDepartment());
		attributes.put("ldapCompany", getLdapCompany());
		attributes.put("defaultRoleId", getDefaultRoleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spLdapMappingId = (Long)attributes.get("spLdapMappingId");

		if (spLdapMappingId != null) {
			setSpLdapMappingId(spLdapMappingId);
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

		Long countryId = (Long)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		Long departmentId = (Long)attributes.get("departmentId");

		if (departmentId != null) {
			setDepartmentId(departmentId);
		}

		Long countryDepartmentId = (Long)attributes.get("countryDepartmentId");

		if (countryDepartmentId != null) {
			setCountryDepartmentId(countryDepartmentId);
		}

		String ldapCountry = (String)attributes.get("ldapCountry");

		if (ldapCountry != null) {
			setLdapCountry(ldapCountry);
		}

		String ldapDepartment = (String)attributes.get("ldapDepartment");

		if (ldapDepartment != null) {
			setLdapDepartment(ldapDepartment);
		}

		String ldapCompany = (String)attributes.get("ldapCompany");

		if (ldapCompany != null) {
			setLdapCompany(ldapCompany);
		}

		Long defaultRoleId = (Long)attributes.get("defaultRoleId");

		if (defaultRoleId != null) {
			setDefaultRoleId(defaultRoleId);
		}
	}

	/**
	* Returns the primary key of this s p ldap mapping.
	*
	* @return the primary key of this s p ldap mapping
	*/
	@Override
	public long getPrimaryKey() {
		return _spLdapMapping.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p ldap mapping.
	*
	* @param primaryKey the primary key of this s p ldap mapping
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spLdapMapping.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp ldap mapping ID of this s p ldap mapping.
	*
	* @return the sp ldap mapping ID of this s p ldap mapping
	*/
	@Override
	public long getSpLdapMappingId() {
		return _spLdapMapping.getSpLdapMappingId();
	}

	/**
	* Sets the sp ldap mapping ID of this s p ldap mapping.
	*
	* @param spLdapMappingId the sp ldap mapping ID of this s p ldap mapping
	*/
	@Override
	public void setSpLdapMappingId(long spLdapMappingId) {
		_spLdapMapping.setSpLdapMappingId(spLdapMappingId);
	}

	/**
	* Returns the group ID of this s p ldap mapping.
	*
	* @return the group ID of this s p ldap mapping
	*/
	@Override
	public long getGroupId() {
		return _spLdapMapping.getGroupId();
	}

	/**
	* Sets the group ID of this s p ldap mapping.
	*
	* @param groupId the group ID of this s p ldap mapping
	*/
	@Override
	public void setGroupId(long groupId) {
		_spLdapMapping.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p ldap mapping.
	*
	* @return the company ID of this s p ldap mapping
	*/
	@Override
	public long getCompanyId() {
		return _spLdapMapping.getCompanyId();
	}

	/**
	* Sets the company ID of this s p ldap mapping.
	*
	* @param companyId the company ID of this s p ldap mapping
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spLdapMapping.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p ldap mapping.
	*
	* @return the user ID of this s p ldap mapping
	*/
	@Override
	public long getUserId() {
		return _spLdapMapping.getUserId();
	}

	/**
	* Sets the user ID of this s p ldap mapping.
	*
	* @param userId the user ID of this s p ldap mapping
	*/
	@Override
	public void setUserId(long userId) {
		_spLdapMapping.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p ldap mapping.
	*
	* @return the user uuid of this s p ldap mapping
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spLdapMapping.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p ldap mapping.
	*
	* @param userUuid the user uuid of this s p ldap mapping
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spLdapMapping.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p ldap mapping.
	*
	* @return the user name of this s p ldap mapping
	*/
	@Override
	public java.lang.String getUserName() {
		return _spLdapMapping.getUserName();
	}

	/**
	* Sets the user name of this s p ldap mapping.
	*
	* @param userName the user name of this s p ldap mapping
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spLdapMapping.setUserName(userName);
	}

	/**
	* Returns the create date of this s p ldap mapping.
	*
	* @return the create date of this s p ldap mapping
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spLdapMapping.getCreateDate();
	}

	/**
	* Sets the create date of this s p ldap mapping.
	*
	* @param createDate the create date of this s p ldap mapping
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spLdapMapping.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p ldap mapping.
	*
	* @return the modified date of this s p ldap mapping
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spLdapMapping.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p ldap mapping.
	*
	* @param modifiedDate the modified date of this s p ldap mapping
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spLdapMapping.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country ID of this s p ldap mapping.
	*
	* @return the country ID of this s p ldap mapping
	*/
	@Override
	public long getCountryId() {
		return _spLdapMapping.getCountryId();
	}

	/**
	* Sets the country ID of this s p ldap mapping.
	*
	* @param countryId the country ID of this s p ldap mapping
	*/
	@Override
	public void setCountryId(long countryId) {
		_spLdapMapping.setCountryId(countryId);
	}

	/**
	* Returns the department ID of this s p ldap mapping.
	*
	* @return the department ID of this s p ldap mapping
	*/
	@Override
	public long getDepartmentId() {
		return _spLdapMapping.getDepartmentId();
	}

	/**
	* Sets the department ID of this s p ldap mapping.
	*
	* @param departmentId the department ID of this s p ldap mapping
	*/
	@Override
	public void setDepartmentId(long departmentId) {
		_spLdapMapping.setDepartmentId(departmentId);
	}

	/**
	* Returns the country department ID of this s p ldap mapping.
	*
	* @return the country department ID of this s p ldap mapping
	*/
	@Override
	public long getCountryDepartmentId() {
		return _spLdapMapping.getCountryDepartmentId();
	}

	/**
	* Sets the country department ID of this s p ldap mapping.
	*
	* @param countryDepartmentId the country department ID of this s p ldap mapping
	*/
	@Override
	public void setCountryDepartmentId(long countryDepartmentId) {
		_spLdapMapping.setCountryDepartmentId(countryDepartmentId);
	}

	/**
	* Returns the ldap country of this s p ldap mapping.
	*
	* @return the ldap country of this s p ldap mapping
	*/
	@Override
	public java.lang.String getLdapCountry() {
		return _spLdapMapping.getLdapCountry();
	}

	/**
	* Sets the ldap country of this s p ldap mapping.
	*
	* @param ldapCountry the ldap country of this s p ldap mapping
	*/
	@Override
	public void setLdapCountry(java.lang.String ldapCountry) {
		_spLdapMapping.setLdapCountry(ldapCountry);
	}

	/**
	* Returns the ldap department of this s p ldap mapping.
	*
	* @return the ldap department of this s p ldap mapping
	*/
	@Override
	public java.lang.String getLdapDepartment() {
		return _spLdapMapping.getLdapDepartment();
	}

	/**
	* Sets the ldap department of this s p ldap mapping.
	*
	* @param ldapDepartment the ldap department of this s p ldap mapping
	*/
	@Override
	public void setLdapDepartment(java.lang.String ldapDepartment) {
		_spLdapMapping.setLdapDepartment(ldapDepartment);
	}

	/**
	* Returns the ldap company of this s p ldap mapping.
	*
	* @return the ldap company of this s p ldap mapping
	*/
	@Override
	public java.lang.String getLdapCompany() {
		return _spLdapMapping.getLdapCompany();
	}

	/**
	* Sets the ldap company of this s p ldap mapping.
	*
	* @param ldapCompany the ldap company of this s p ldap mapping
	*/
	@Override
	public void setLdapCompany(java.lang.String ldapCompany) {
		_spLdapMapping.setLdapCompany(ldapCompany);
	}

	/**
	* Returns the default role ID of this s p ldap mapping.
	*
	* @return the default role ID of this s p ldap mapping
	*/
	@Override
	public long getDefaultRoleId() {
		return _spLdapMapping.getDefaultRoleId();
	}

	/**
	* Sets the default role ID of this s p ldap mapping.
	*
	* @param defaultRoleId the default role ID of this s p ldap mapping
	*/
	@Override
	public void setDefaultRoleId(long defaultRoleId) {
		_spLdapMapping.setDefaultRoleId(defaultRoleId);
	}

	@Override
	public boolean isNew() {
		return _spLdapMapping.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spLdapMapping.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spLdapMapping.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spLdapMapping.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spLdapMapping.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spLdapMapping.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spLdapMapping.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spLdapMapping.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spLdapMapping.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spLdapMapping.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spLdapMapping.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPLdapMappingWrapper((SPLdapMapping)_spLdapMapping.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPLdapMapping spLdapMapping) {
		return _spLdapMapping.compareTo(spLdapMapping);
	}

	@Override
	public int hashCode() {
		return _spLdapMapping.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPLdapMapping> toCacheModel() {
		return _spLdapMapping.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping toEscapedModel() {
		return new SPLdapMappingWrapper(_spLdapMapping.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPLdapMapping toUnescapedModel() {
		return new SPLdapMappingWrapper(_spLdapMapping.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spLdapMapping.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spLdapMapping.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spLdapMapping.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPLdapMappingWrapper)) {
			return false;
		}

		SPLdapMappingWrapper spLdapMappingWrapper = (SPLdapMappingWrapper)obj;

		if (Validator.equals(_spLdapMapping, spLdapMappingWrapper._spLdapMapping)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPLdapMapping getWrappedSPLdapMapping() {
		return _spLdapMapping;
	}

	@Override
	public SPLdapMapping getWrappedModel() {
		return _spLdapMapping;
	}

	@Override
	public void resetOriginalValues() {
		_spLdapMapping.resetOriginalValues();
	}

	private SPLdapMapping _spLdapMapping;
}