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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ModuleFramework}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleFramework
 * @generated
 */
public class ModuleFrameworkWrapper implements ModuleFramework,
	ModelWrapper<ModuleFramework> {
	public ModuleFrameworkWrapper(ModuleFramework moduleFramework) {
		_moduleFramework = moduleFramework;
	}

	@Override
	public Class<?> getModelClass() {
		return ModuleFramework.class;
	}

	@Override
	public String getModelClassName() {
		return ModuleFramework.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spModuleFrameworkId", getSpModuleFrameworkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("spFrameworkId", getSpFrameworkId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spModuleFrameworkId = (Long)attributes.get("spModuleFrameworkId");

		if (spModuleFrameworkId != null) {
			setSpModuleFrameworkId(spModuleFrameworkId);
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

		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
		}

		Long spFrameworkId = (Long)attributes.get("spFrameworkId");

		if (spFrameworkId != null) {
			setSpFrameworkId(spFrameworkId);
		}
	}

	/**
	* Returns the primary key of this module framework.
	*
	* @return the primary key of this module framework
	*/
	@Override
	public long getPrimaryKey() {
		return _moduleFramework.getPrimaryKey();
	}

	/**
	* Sets the primary key of this module framework.
	*
	* @param primaryKey the primary key of this module framework
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_moduleFramework.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp module framework ID of this module framework.
	*
	* @return the sp module framework ID of this module framework
	*/
	@Override
	public long getSpModuleFrameworkId() {
		return _moduleFramework.getSpModuleFrameworkId();
	}

	/**
	* Sets the sp module framework ID of this module framework.
	*
	* @param spModuleFrameworkId the sp module framework ID of this module framework
	*/
	@Override
	public void setSpModuleFrameworkId(long spModuleFrameworkId) {
		_moduleFramework.setSpModuleFrameworkId(spModuleFrameworkId);
	}

	/**
	* Returns the group ID of this module framework.
	*
	* @return the group ID of this module framework
	*/
	@Override
	public long getGroupId() {
		return _moduleFramework.getGroupId();
	}

	/**
	* Sets the group ID of this module framework.
	*
	* @param groupId the group ID of this module framework
	*/
	@Override
	public void setGroupId(long groupId) {
		_moduleFramework.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this module framework.
	*
	* @return the company ID of this module framework
	*/
	@Override
	public long getCompanyId() {
		return _moduleFramework.getCompanyId();
	}

	/**
	* Sets the company ID of this module framework.
	*
	* @param companyId the company ID of this module framework
	*/
	@Override
	public void setCompanyId(long companyId) {
		_moduleFramework.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this module framework.
	*
	* @return the user ID of this module framework
	*/
	@Override
	public long getUserId() {
		return _moduleFramework.getUserId();
	}

	/**
	* Sets the user ID of this module framework.
	*
	* @param userId the user ID of this module framework
	*/
	@Override
	public void setUserId(long userId) {
		_moduleFramework.setUserId(userId);
	}

	/**
	* Returns the user uuid of this module framework.
	*
	* @return the user uuid of this module framework
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleFramework.getUserUuid();
	}

	/**
	* Sets the user uuid of this module framework.
	*
	* @param userUuid the user uuid of this module framework
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_moduleFramework.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this module framework.
	*
	* @return the user name of this module framework
	*/
	@Override
	public java.lang.String getUserName() {
		return _moduleFramework.getUserName();
	}

	/**
	* Sets the user name of this module framework.
	*
	* @param userName the user name of this module framework
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_moduleFramework.setUserName(userName);
	}

	/**
	* Returns the create date of this module framework.
	*
	* @return the create date of this module framework
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _moduleFramework.getCreateDate();
	}

	/**
	* Sets the create date of this module framework.
	*
	* @param createDate the create date of this module framework
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_moduleFramework.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this module framework.
	*
	* @return the modified date of this module framework
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _moduleFramework.getModifiedDate();
	}

	/**
	* Sets the modified date of this module framework.
	*
	* @param modifiedDate the modified date of this module framework
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_moduleFramework.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp module ID of this module framework.
	*
	* @return the sp module ID of this module framework
	*/
	@Override
	public long getSpModuleId() {
		return _moduleFramework.getSpModuleId();
	}

	/**
	* Sets the sp module ID of this module framework.
	*
	* @param spModuleId the sp module ID of this module framework
	*/
	@Override
	public void setSpModuleId(long spModuleId) {
		_moduleFramework.setSpModuleId(spModuleId);
	}

	/**
	* Returns the sp framework ID of this module framework.
	*
	* @return the sp framework ID of this module framework
	*/
	@Override
	public long getSpFrameworkId() {
		return _moduleFramework.getSpFrameworkId();
	}

	/**
	* Sets the sp framework ID of this module framework.
	*
	* @param spFrameworkId the sp framework ID of this module framework
	*/
	@Override
	public void setSpFrameworkId(long spFrameworkId) {
		_moduleFramework.setSpFrameworkId(spFrameworkId);
	}

	@Override
	public boolean isNew() {
		return _moduleFramework.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_moduleFramework.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _moduleFramework.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_moduleFramework.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _moduleFramework.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _moduleFramework.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_moduleFramework.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _moduleFramework.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_moduleFramework.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_moduleFramework.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_moduleFramework.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ModuleFrameworkWrapper((ModuleFramework)_moduleFramework.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.ModuleFramework moduleFramework) {
		return _moduleFramework.compareTo(moduleFramework);
	}

	@Override
	public int hashCode() {
		return _moduleFramework.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.ModuleFramework> toCacheModel() {
		return _moduleFramework.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.ModuleFramework toEscapedModel() {
		return new ModuleFrameworkWrapper(_moduleFramework.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.ModuleFramework toUnescapedModel() {
		return new ModuleFrameworkWrapper(_moduleFramework.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _moduleFramework.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _moduleFramework.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_moduleFramework.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ModuleFrameworkWrapper)) {
			return false;
		}

		ModuleFrameworkWrapper moduleFrameworkWrapper = (ModuleFrameworkWrapper)obj;

		if (Validator.equals(_moduleFramework,
					moduleFrameworkWrapper._moduleFramework)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ModuleFramework getWrappedModuleFramework() {
		return _moduleFramework;
	}

	@Override
	public ModuleFramework getWrappedModel() {
		return _moduleFramework;
	}

	@Override
	public void resetOriginalValues() {
		_moduleFramework.resetOriginalValues();
	}

	private ModuleFramework _moduleFramework;
}