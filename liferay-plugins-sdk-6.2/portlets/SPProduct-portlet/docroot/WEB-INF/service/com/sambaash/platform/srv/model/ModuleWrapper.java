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
 * This class is a wrapper for {@link Module}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Module
 * @generated
 */
public class ModuleWrapper implements Module, ModelWrapper<Module> {
	public ModuleWrapper(Module module) {
		_module = module;
	}

	@Override
	public Class<?> getModelClass() {
		return Module.class;
	}

	@Override
	public String getModelClassName() {
		return Module.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spModuleId", getSpModuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("moduleCode", getModuleCode());
		attributes.put("moduleName", getModuleName());
		attributes.put("moduleDesc", getModuleDesc());
		attributes.put("moduleType", getModuleType());
		attributes.put("creditValue", getCreditValue());
		attributes.put("moduleDuration", getModuleDuration());
		attributes.put("noOfSessions", getNoOfSessions());
		attributes.put("generalDesc", getGeneralDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
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

		String moduleCode = (String)attributes.get("moduleCode");

		if (moduleCode != null) {
			setModuleCode(moduleCode);
		}

		String moduleName = (String)attributes.get("moduleName");

		if (moduleName != null) {
			setModuleName(moduleName);
		}

		String moduleDesc = (String)attributes.get("moduleDesc");

		if (moduleDesc != null) {
			setModuleDesc(moduleDesc);
		}

		Long moduleType = (Long)attributes.get("moduleType");

		if (moduleType != null) {
			setModuleType(moduleType);
		}

		Long creditValue = (Long)attributes.get("creditValue");

		if (creditValue != null) {
			setCreditValue(creditValue);
		}

		String moduleDuration = (String)attributes.get("moduleDuration");

		if (moduleDuration != null) {
			setModuleDuration(moduleDuration);
		}

		Long noOfSessions = (Long)attributes.get("noOfSessions");

		if (noOfSessions != null) {
			setNoOfSessions(noOfSessions);
		}

		String generalDesc = (String)attributes.get("generalDesc");

		if (generalDesc != null) {
			setGeneralDesc(generalDesc);
		}
	}

	/**
	* Returns the primary key of this module.
	*
	* @return the primary key of this module
	*/
	@Override
	public long getPrimaryKey() {
		return _module.getPrimaryKey();
	}

	/**
	* Sets the primary key of this module.
	*
	* @param primaryKey the primary key of this module
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_module.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp module ID of this module.
	*
	* @return the sp module ID of this module
	*/
	@Override
	public long getSpModuleId() {
		return _module.getSpModuleId();
	}

	/**
	* Sets the sp module ID of this module.
	*
	* @param spModuleId the sp module ID of this module
	*/
	@Override
	public void setSpModuleId(long spModuleId) {
		_module.setSpModuleId(spModuleId);
	}

	/**
	* Returns the group ID of this module.
	*
	* @return the group ID of this module
	*/
	@Override
	public long getGroupId() {
		return _module.getGroupId();
	}

	/**
	* Sets the group ID of this module.
	*
	* @param groupId the group ID of this module
	*/
	@Override
	public void setGroupId(long groupId) {
		_module.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this module.
	*
	* @return the company ID of this module
	*/
	@Override
	public long getCompanyId() {
		return _module.getCompanyId();
	}

	/**
	* Sets the company ID of this module.
	*
	* @param companyId the company ID of this module
	*/
	@Override
	public void setCompanyId(long companyId) {
		_module.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this module.
	*
	* @return the user ID of this module
	*/
	@Override
	public long getUserId() {
		return _module.getUserId();
	}

	/**
	* Sets the user ID of this module.
	*
	* @param userId the user ID of this module
	*/
	@Override
	public void setUserId(long userId) {
		_module.setUserId(userId);
	}

	/**
	* Returns the user uuid of this module.
	*
	* @return the user uuid of this module
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _module.getUserUuid();
	}

	/**
	* Sets the user uuid of this module.
	*
	* @param userUuid the user uuid of this module
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_module.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this module.
	*
	* @return the user name of this module
	*/
	@Override
	public java.lang.String getUserName() {
		return _module.getUserName();
	}

	/**
	* Sets the user name of this module.
	*
	* @param userName the user name of this module
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_module.setUserName(userName);
	}

	/**
	* Returns the create date of this module.
	*
	* @return the create date of this module
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _module.getCreateDate();
	}

	/**
	* Sets the create date of this module.
	*
	* @param createDate the create date of this module
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_module.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this module.
	*
	* @return the modified date of this module
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _module.getModifiedDate();
	}

	/**
	* Sets the modified date of this module.
	*
	* @param modifiedDate the modified date of this module
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_module.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country ID of this module.
	*
	* @return the country ID of this module
	*/
	@Override
	public long getCountryId() {
		return _module.getCountryId();
	}

	/**
	* Sets the country ID of this module.
	*
	* @param countryId the country ID of this module
	*/
	@Override
	public void setCountryId(long countryId) {
		_module.setCountryId(countryId);
	}

	/**
	* Returns the module code of this module.
	*
	* @return the module code of this module
	*/
	@Override
	public java.lang.String getModuleCode() {
		return _module.getModuleCode();
	}

	/**
	* Sets the module code of this module.
	*
	* @param moduleCode the module code of this module
	*/
	@Override
	public void setModuleCode(java.lang.String moduleCode) {
		_module.setModuleCode(moduleCode);
	}

	/**
	* Returns the module name of this module.
	*
	* @return the module name of this module
	*/
	@Override
	public java.lang.String getModuleName() {
		return _module.getModuleName();
	}

	/**
	* Sets the module name of this module.
	*
	* @param moduleName the module name of this module
	*/
	@Override
	public void setModuleName(java.lang.String moduleName) {
		_module.setModuleName(moduleName);
	}

	/**
	* Returns the module desc of this module.
	*
	* @return the module desc of this module
	*/
	@Override
	public java.lang.String getModuleDesc() {
		return _module.getModuleDesc();
	}

	/**
	* Sets the module desc of this module.
	*
	* @param moduleDesc the module desc of this module
	*/
	@Override
	public void setModuleDesc(java.lang.String moduleDesc) {
		_module.setModuleDesc(moduleDesc);
	}

	/**
	* Returns the module type of this module.
	*
	* @return the module type of this module
	*/
	@Override
	public long getModuleType() {
		return _module.getModuleType();
	}

	/**
	* Sets the module type of this module.
	*
	* @param moduleType the module type of this module
	*/
	@Override
	public void setModuleType(long moduleType) {
		_module.setModuleType(moduleType);
	}

	/**
	* Returns the credit value of this module.
	*
	* @return the credit value of this module
	*/
	@Override
	public long getCreditValue() {
		return _module.getCreditValue();
	}

	/**
	* Sets the credit value of this module.
	*
	* @param creditValue the credit value of this module
	*/
	@Override
	public void setCreditValue(long creditValue) {
		_module.setCreditValue(creditValue);
	}

	/**
	* Returns the module duration of this module.
	*
	* @return the module duration of this module
	*/
	@Override
	public java.lang.String getModuleDuration() {
		return _module.getModuleDuration();
	}

	/**
	* Sets the module duration of this module.
	*
	* @param moduleDuration the module duration of this module
	*/
	@Override
	public void setModuleDuration(java.lang.String moduleDuration) {
		_module.setModuleDuration(moduleDuration);
	}

	/**
	* Returns the no of sessions of this module.
	*
	* @return the no of sessions of this module
	*/
	@Override
	public long getNoOfSessions() {
		return _module.getNoOfSessions();
	}

	/**
	* Sets the no of sessions of this module.
	*
	* @param noOfSessions the no of sessions of this module
	*/
	@Override
	public void setNoOfSessions(long noOfSessions) {
		_module.setNoOfSessions(noOfSessions);
	}

	/**
	* Returns the general desc of this module.
	*
	* @return the general desc of this module
	*/
	@Override
	public java.lang.String getGeneralDesc() {
		return _module.getGeneralDesc();
	}

	/**
	* Sets the general desc of this module.
	*
	* @param generalDesc the general desc of this module
	*/
	@Override
	public void setGeneralDesc(java.lang.String generalDesc) {
		_module.setGeneralDesc(generalDesc);
	}

	@Override
	public boolean isNew() {
		return _module.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_module.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _module.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_module.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _module.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _module.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_module.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _module.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_module.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_module.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_module.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ModuleWrapper((Module)_module.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Module module) {
		return _module.compareTo(module);
	}

	@Override
	public int hashCode() {
		return _module.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Module> toCacheModel() {
		return _module.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Module toEscapedModel() {
		return new ModuleWrapper(_module.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Module toUnescapedModel() {
		return new ModuleWrapper(_module.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _module.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _module.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_module.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ModuleWrapper)) {
			return false;
		}

		ModuleWrapper moduleWrapper = (ModuleWrapper)obj;

		if (Validator.equals(_module, moduleWrapper._module)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Module getWrappedModule() {
		return _module;
	}

	@Override
	public Module getWrappedModel() {
		return _module;
	}

	@Override
	public void resetOriginalValues() {
		_module.resetOriginalValues();
	}

	private Module _module;
}