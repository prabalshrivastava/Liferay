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

package com.sambaash.platform.srv.roles.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPRoles}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPRoles
 * @generated
 */
public class SPRolesWrapper implements SPRoles, ModelWrapper<SPRoles> {
	public SPRolesWrapper(SPRoles spRoles) {
		_spRoles = spRoles;
	}

	@Override
	public Class<?> getModelClass() {
		return SPRoles.class;
	}

	@Override
	public String getModelClassName() {
		return SPRoles.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spRoleId", getSpRoleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("roleId", getRoleId());
		attributes.put("categoryId1", getCategoryId1());
		attributes.put("categoryId2", getCategoryId2());
		attributes.put("countryCategoryId", getCountryCategoryId());
		attributes.put("departmentCategoryId", getDepartmentCategoryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spRoleId = (Long)attributes.get("spRoleId");

		if (spRoleId != null) {
			setSpRoleId(spRoleId);
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

		Long roleId = (Long)attributes.get("roleId");

		if (roleId != null) {
			setRoleId(roleId);
		}

		Long categoryId1 = (Long)attributes.get("categoryId1");

		if (categoryId1 != null) {
			setCategoryId1(categoryId1);
		}

		Long categoryId2 = (Long)attributes.get("categoryId2");

		if (categoryId2 != null) {
			setCategoryId2(categoryId2);
		}

		Long countryCategoryId = (Long)attributes.get("countryCategoryId");

		if (countryCategoryId != null) {
			setCountryCategoryId(countryCategoryId);
		}

		Long departmentCategoryId = (Long)attributes.get("departmentCategoryId");

		if (departmentCategoryId != null) {
			setDepartmentCategoryId(departmentCategoryId);
		}
	}

	/**
	* Returns the primary key of this s p roles.
	*
	* @return the primary key of this s p roles
	*/
	@Override
	public long getPrimaryKey() {
		return _spRoles.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p roles.
	*
	* @param primaryKey the primary key of this s p roles
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spRoles.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p roles.
	*
	* @return the uuid of this s p roles
	*/
	@Override
	public java.lang.String getUuid() {
		return _spRoles.getUuid();
	}

	/**
	* Sets the uuid of this s p roles.
	*
	* @param uuid the uuid of this s p roles
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spRoles.setUuid(uuid);
	}

	/**
	* Returns the sp role ID of this s p roles.
	*
	* @return the sp role ID of this s p roles
	*/
	@Override
	public long getSpRoleId() {
		return _spRoles.getSpRoleId();
	}

	/**
	* Sets the sp role ID of this s p roles.
	*
	* @param spRoleId the sp role ID of this s p roles
	*/
	@Override
	public void setSpRoleId(long spRoleId) {
		_spRoles.setSpRoleId(spRoleId);
	}

	/**
	* Returns the group ID of this s p roles.
	*
	* @return the group ID of this s p roles
	*/
	@Override
	public long getGroupId() {
		return _spRoles.getGroupId();
	}

	/**
	* Sets the group ID of this s p roles.
	*
	* @param groupId the group ID of this s p roles
	*/
	@Override
	public void setGroupId(long groupId) {
		_spRoles.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p roles.
	*
	* @return the company ID of this s p roles
	*/
	@Override
	public long getCompanyId() {
		return _spRoles.getCompanyId();
	}

	/**
	* Sets the company ID of this s p roles.
	*
	* @param companyId the company ID of this s p roles
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spRoles.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p roles.
	*
	* @return the user ID of this s p roles
	*/
	@Override
	public long getUserId() {
		return _spRoles.getUserId();
	}

	/**
	* Sets the user ID of this s p roles.
	*
	* @param userId the user ID of this s p roles
	*/
	@Override
	public void setUserId(long userId) {
		_spRoles.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p roles.
	*
	* @return the user uuid of this s p roles
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spRoles.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p roles.
	*
	* @param userUuid the user uuid of this s p roles
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spRoles.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p roles.
	*
	* @return the user name of this s p roles
	*/
	@Override
	public java.lang.String getUserName() {
		return _spRoles.getUserName();
	}

	/**
	* Sets the user name of this s p roles.
	*
	* @param userName the user name of this s p roles
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spRoles.setUserName(userName);
	}

	/**
	* Returns the create date of this s p roles.
	*
	* @return the create date of this s p roles
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spRoles.getCreateDate();
	}

	/**
	* Sets the create date of this s p roles.
	*
	* @param createDate the create date of this s p roles
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spRoles.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p roles.
	*
	* @return the modified date of this s p roles
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spRoles.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p roles.
	*
	* @param modifiedDate the modified date of this s p roles
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spRoles.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the role ID of this s p roles.
	*
	* @return the role ID of this s p roles
	*/
	@Override
	public long getRoleId() {
		return _spRoles.getRoleId();
	}

	/**
	* Sets the role ID of this s p roles.
	*
	* @param roleId the role ID of this s p roles
	*/
	@Override
	public void setRoleId(long roleId) {
		_spRoles.setRoleId(roleId);
	}

	/**
	* Returns the category id1 of this s p roles.
	*
	* @return the category id1 of this s p roles
	*/
	@Override
	public long getCategoryId1() {
		return _spRoles.getCategoryId1();
	}

	/**
	* Sets the category id1 of this s p roles.
	*
	* @param categoryId1 the category id1 of this s p roles
	*/
	@Override
	public void setCategoryId1(long categoryId1) {
		_spRoles.setCategoryId1(categoryId1);
	}

	/**
	* Returns the category id2 of this s p roles.
	*
	* @return the category id2 of this s p roles
	*/
	@Override
	public long getCategoryId2() {
		return _spRoles.getCategoryId2();
	}

	/**
	* Sets the category id2 of this s p roles.
	*
	* @param categoryId2 the category id2 of this s p roles
	*/
	@Override
	public void setCategoryId2(long categoryId2) {
		_spRoles.setCategoryId2(categoryId2);
	}

	/**
	* Returns the country category ID of this s p roles.
	*
	* @return the country category ID of this s p roles
	*/
	@Override
	public long getCountryCategoryId() {
		return _spRoles.getCountryCategoryId();
	}

	/**
	* Sets the country category ID of this s p roles.
	*
	* @param countryCategoryId the country category ID of this s p roles
	*/
	@Override
	public void setCountryCategoryId(long countryCategoryId) {
		_spRoles.setCountryCategoryId(countryCategoryId);
	}

	/**
	* Returns the department category ID of this s p roles.
	*
	* @return the department category ID of this s p roles
	*/
	@Override
	public long getDepartmentCategoryId() {
		return _spRoles.getDepartmentCategoryId();
	}

	/**
	* Sets the department category ID of this s p roles.
	*
	* @param departmentCategoryId the department category ID of this s p roles
	*/
	@Override
	public void setDepartmentCategoryId(long departmentCategoryId) {
		_spRoles.setDepartmentCategoryId(departmentCategoryId);
	}

	@Override
	public boolean isNew() {
		return _spRoles.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spRoles.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spRoles.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spRoles.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spRoles.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spRoles.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spRoles.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spRoles.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spRoles.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spRoles.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spRoles.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPRolesWrapper((SPRoles)_spRoles.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.roles.model.SPRoles spRoles) {
		return _spRoles.compareTo(spRoles);
	}

	@Override
	public int hashCode() {
		return _spRoles.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.roles.model.SPRoles> toCacheModel() {
		return _spRoles.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.roles.model.SPRoles toEscapedModel() {
		return new SPRolesWrapper(_spRoles.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.roles.model.SPRoles toUnescapedModel() {
		return new SPRolesWrapper(_spRoles.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spRoles.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spRoles.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spRoles.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPRolesWrapper)) {
			return false;
		}

		SPRolesWrapper spRolesWrapper = (SPRolesWrapper)obj;

		if (Validator.equals(_spRoles, spRolesWrapper._spRoles)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spRoles.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPRoles getWrappedSPRoles() {
		return _spRoles;
	}

	@Override
	public SPRoles getWrappedModel() {
		return _spRoles;
	}

	@Override
	public void resetOriginalValues() {
		_spRoles.resetOriginalValues();
	}

	private SPRoles _spRoles;
}