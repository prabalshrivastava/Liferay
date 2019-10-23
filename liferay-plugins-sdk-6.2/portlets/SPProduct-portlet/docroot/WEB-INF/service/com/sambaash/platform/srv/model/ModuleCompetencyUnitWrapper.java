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
 * This class is a wrapper for {@link ModuleCompetencyUnit}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ModuleCompetencyUnit
 * @generated
 */
public class ModuleCompetencyUnitWrapper implements ModuleCompetencyUnit,
	ModelWrapper<ModuleCompetencyUnit> {
	public ModuleCompetencyUnitWrapper(
		ModuleCompetencyUnit moduleCompetencyUnit) {
		_moduleCompetencyUnit = moduleCompetencyUnit;
	}

	@Override
	public Class<?> getModelClass() {
		return ModuleCompetencyUnit.class;
	}

	@Override
	public String getModelClassName() {
		return ModuleCompetencyUnit.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spModuleCompetencyUnitId", getSpModuleCompetencyUnitId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("spCompetencyUnitId", getSpCompetencyUnitId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spModuleCompetencyUnitId = (Long)attributes.get(
				"spModuleCompetencyUnitId");

		if (spModuleCompetencyUnitId != null) {
			setSpModuleCompetencyUnitId(spModuleCompetencyUnitId);
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

		Long spCompetencyUnitId = (Long)attributes.get("spCompetencyUnitId");

		if (spCompetencyUnitId != null) {
			setSpCompetencyUnitId(spCompetencyUnitId);
		}
	}

	/**
	* Returns the primary key of this module competency unit.
	*
	* @return the primary key of this module competency unit
	*/
	@Override
	public long getPrimaryKey() {
		return _moduleCompetencyUnit.getPrimaryKey();
	}

	/**
	* Sets the primary key of this module competency unit.
	*
	* @param primaryKey the primary key of this module competency unit
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_moduleCompetencyUnit.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp module competency unit ID of this module competency unit.
	*
	* @return the sp module competency unit ID of this module competency unit
	*/
	@Override
	public long getSpModuleCompetencyUnitId() {
		return _moduleCompetencyUnit.getSpModuleCompetencyUnitId();
	}

	/**
	* Sets the sp module competency unit ID of this module competency unit.
	*
	* @param spModuleCompetencyUnitId the sp module competency unit ID of this module competency unit
	*/
	@Override
	public void setSpModuleCompetencyUnitId(long spModuleCompetencyUnitId) {
		_moduleCompetencyUnit.setSpModuleCompetencyUnitId(spModuleCompetencyUnitId);
	}

	/**
	* Returns the group ID of this module competency unit.
	*
	* @return the group ID of this module competency unit
	*/
	@Override
	public long getGroupId() {
		return _moduleCompetencyUnit.getGroupId();
	}

	/**
	* Sets the group ID of this module competency unit.
	*
	* @param groupId the group ID of this module competency unit
	*/
	@Override
	public void setGroupId(long groupId) {
		_moduleCompetencyUnit.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this module competency unit.
	*
	* @return the company ID of this module competency unit
	*/
	@Override
	public long getCompanyId() {
		return _moduleCompetencyUnit.getCompanyId();
	}

	/**
	* Sets the company ID of this module competency unit.
	*
	* @param companyId the company ID of this module competency unit
	*/
	@Override
	public void setCompanyId(long companyId) {
		_moduleCompetencyUnit.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this module competency unit.
	*
	* @return the user ID of this module competency unit
	*/
	@Override
	public long getUserId() {
		return _moduleCompetencyUnit.getUserId();
	}

	/**
	* Sets the user ID of this module competency unit.
	*
	* @param userId the user ID of this module competency unit
	*/
	@Override
	public void setUserId(long userId) {
		_moduleCompetencyUnit.setUserId(userId);
	}

	/**
	* Returns the user uuid of this module competency unit.
	*
	* @return the user uuid of this module competency unit
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _moduleCompetencyUnit.getUserUuid();
	}

	/**
	* Sets the user uuid of this module competency unit.
	*
	* @param userUuid the user uuid of this module competency unit
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_moduleCompetencyUnit.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this module competency unit.
	*
	* @return the user name of this module competency unit
	*/
	@Override
	public java.lang.String getUserName() {
		return _moduleCompetencyUnit.getUserName();
	}

	/**
	* Sets the user name of this module competency unit.
	*
	* @param userName the user name of this module competency unit
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_moduleCompetencyUnit.setUserName(userName);
	}

	/**
	* Returns the create date of this module competency unit.
	*
	* @return the create date of this module competency unit
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _moduleCompetencyUnit.getCreateDate();
	}

	/**
	* Sets the create date of this module competency unit.
	*
	* @param createDate the create date of this module competency unit
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_moduleCompetencyUnit.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this module competency unit.
	*
	* @return the modified date of this module competency unit
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _moduleCompetencyUnit.getModifiedDate();
	}

	/**
	* Sets the modified date of this module competency unit.
	*
	* @param modifiedDate the modified date of this module competency unit
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_moduleCompetencyUnit.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp module ID of this module competency unit.
	*
	* @return the sp module ID of this module competency unit
	*/
	@Override
	public long getSpModuleId() {
		return _moduleCompetencyUnit.getSpModuleId();
	}

	/**
	* Sets the sp module ID of this module competency unit.
	*
	* @param spModuleId the sp module ID of this module competency unit
	*/
	@Override
	public void setSpModuleId(long spModuleId) {
		_moduleCompetencyUnit.setSpModuleId(spModuleId);
	}

	/**
	* Returns the sp competency unit ID of this module competency unit.
	*
	* @return the sp competency unit ID of this module competency unit
	*/
	@Override
	public long getSpCompetencyUnitId() {
		return _moduleCompetencyUnit.getSpCompetencyUnitId();
	}

	/**
	* Sets the sp competency unit ID of this module competency unit.
	*
	* @param spCompetencyUnitId the sp competency unit ID of this module competency unit
	*/
	@Override
	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_moduleCompetencyUnit.setSpCompetencyUnitId(spCompetencyUnitId);
	}

	@Override
	public boolean isNew() {
		return _moduleCompetencyUnit.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_moduleCompetencyUnit.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _moduleCompetencyUnit.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_moduleCompetencyUnit.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _moduleCompetencyUnit.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _moduleCompetencyUnit.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_moduleCompetencyUnit.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _moduleCompetencyUnit.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_moduleCompetencyUnit.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_moduleCompetencyUnit.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_moduleCompetencyUnit.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ModuleCompetencyUnitWrapper((ModuleCompetencyUnit)_moduleCompetencyUnit.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.ModuleCompetencyUnit moduleCompetencyUnit) {
		return _moduleCompetencyUnit.compareTo(moduleCompetencyUnit);
	}

	@Override
	public int hashCode() {
		return _moduleCompetencyUnit.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.ModuleCompetencyUnit> toCacheModel() {
		return _moduleCompetencyUnit.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit toEscapedModel() {
		return new ModuleCompetencyUnitWrapper(_moduleCompetencyUnit.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.ModuleCompetencyUnit toUnescapedModel() {
		return new ModuleCompetencyUnitWrapper(_moduleCompetencyUnit.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _moduleCompetencyUnit.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _moduleCompetencyUnit.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_moduleCompetencyUnit.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ModuleCompetencyUnitWrapper)) {
			return false;
		}

		ModuleCompetencyUnitWrapper moduleCompetencyUnitWrapper = (ModuleCompetencyUnitWrapper)obj;

		if (Validator.equals(_moduleCompetencyUnit,
					moduleCompetencyUnitWrapper._moduleCompetencyUnit)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ModuleCompetencyUnit getWrappedModuleCompetencyUnit() {
		return _moduleCompetencyUnit;
	}

	@Override
	public ModuleCompetencyUnit getWrappedModel() {
		return _moduleCompetencyUnit;
	}

	@Override
	public void resetOriginalValues() {
		_moduleCompetencyUnit.resetOriginalValues();
	}

	private ModuleCompetencyUnit _moduleCompetencyUnit;
}