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
 * This class is a wrapper for {@link Framework}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Framework
 * @generated
 */
public class FrameworkWrapper implements Framework, ModelWrapper<Framework> {
	public FrameworkWrapper(Framework framework) {
		_framework = framework;
	}

	@Override
	public Class<?> getModelClass() {
		return Framework.class;
	}

	@Override
	public String getModelClassName() {
		return Framework.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFrameworkId", getSpFrameworkId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("frameworkCode", getFrameworkCode());
		attributes.put("frameworkName", getFrameworkName());
		attributes.put("frameworkImageId", getFrameworkImageId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFrameworkId = (Long)attributes.get("spFrameworkId");

		if (spFrameworkId != null) {
			setSpFrameworkId(spFrameworkId);
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

		String frameworkCode = (String)attributes.get("frameworkCode");

		if (frameworkCode != null) {
			setFrameworkCode(frameworkCode);
		}

		String frameworkName = (String)attributes.get("frameworkName");

		if (frameworkName != null) {
			setFrameworkName(frameworkName);
		}

		Long frameworkImageId = (Long)attributes.get("frameworkImageId");

		if (frameworkImageId != null) {
			setFrameworkImageId(frameworkImageId);
		}
	}

	/**
	* Returns the primary key of this framework.
	*
	* @return the primary key of this framework
	*/
	@Override
	public long getPrimaryKey() {
		return _framework.getPrimaryKey();
	}

	/**
	* Sets the primary key of this framework.
	*
	* @param primaryKey the primary key of this framework
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_framework.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp framework ID of this framework.
	*
	* @return the sp framework ID of this framework
	*/
	@Override
	public long getSpFrameworkId() {
		return _framework.getSpFrameworkId();
	}

	/**
	* Sets the sp framework ID of this framework.
	*
	* @param spFrameworkId the sp framework ID of this framework
	*/
	@Override
	public void setSpFrameworkId(long spFrameworkId) {
		_framework.setSpFrameworkId(spFrameworkId);
	}

	/**
	* Returns the group ID of this framework.
	*
	* @return the group ID of this framework
	*/
	@Override
	public long getGroupId() {
		return _framework.getGroupId();
	}

	/**
	* Sets the group ID of this framework.
	*
	* @param groupId the group ID of this framework
	*/
	@Override
	public void setGroupId(long groupId) {
		_framework.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this framework.
	*
	* @return the company ID of this framework
	*/
	@Override
	public long getCompanyId() {
		return _framework.getCompanyId();
	}

	/**
	* Sets the company ID of this framework.
	*
	* @param companyId the company ID of this framework
	*/
	@Override
	public void setCompanyId(long companyId) {
		_framework.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this framework.
	*
	* @return the user ID of this framework
	*/
	@Override
	public long getUserId() {
		return _framework.getUserId();
	}

	/**
	* Sets the user ID of this framework.
	*
	* @param userId the user ID of this framework
	*/
	@Override
	public void setUserId(long userId) {
		_framework.setUserId(userId);
	}

	/**
	* Returns the user uuid of this framework.
	*
	* @return the user uuid of this framework
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _framework.getUserUuid();
	}

	/**
	* Sets the user uuid of this framework.
	*
	* @param userUuid the user uuid of this framework
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_framework.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this framework.
	*
	* @return the user name of this framework
	*/
	@Override
	public java.lang.String getUserName() {
		return _framework.getUserName();
	}

	/**
	* Sets the user name of this framework.
	*
	* @param userName the user name of this framework
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_framework.setUserName(userName);
	}

	/**
	* Returns the create date of this framework.
	*
	* @return the create date of this framework
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _framework.getCreateDate();
	}

	/**
	* Sets the create date of this framework.
	*
	* @param createDate the create date of this framework
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_framework.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this framework.
	*
	* @return the modified date of this framework
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _framework.getModifiedDate();
	}

	/**
	* Sets the modified date of this framework.
	*
	* @param modifiedDate the modified date of this framework
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_framework.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country ID of this framework.
	*
	* @return the country ID of this framework
	*/
	@Override
	public long getCountryId() {
		return _framework.getCountryId();
	}

	/**
	* Sets the country ID of this framework.
	*
	* @param countryId the country ID of this framework
	*/
	@Override
	public void setCountryId(long countryId) {
		_framework.setCountryId(countryId);
	}

	/**
	* Returns the framework code of this framework.
	*
	* @return the framework code of this framework
	*/
	@Override
	public java.lang.String getFrameworkCode() {
		return _framework.getFrameworkCode();
	}

	/**
	* Sets the framework code of this framework.
	*
	* @param frameworkCode the framework code of this framework
	*/
	@Override
	public void setFrameworkCode(java.lang.String frameworkCode) {
		_framework.setFrameworkCode(frameworkCode);
	}

	/**
	* Returns the framework name of this framework.
	*
	* @return the framework name of this framework
	*/
	@Override
	public java.lang.String getFrameworkName() {
		return _framework.getFrameworkName();
	}

	/**
	* Sets the framework name of this framework.
	*
	* @param frameworkName the framework name of this framework
	*/
	@Override
	public void setFrameworkName(java.lang.String frameworkName) {
		_framework.setFrameworkName(frameworkName);
	}

	/**
	* Returns the framework image ID of this framework.
	*
	* @return the framework image ID of this framework
	*/
	@Override
	public java.lang.Long getFrameworkImageId() {
		return _framework.getFrameworkImageId();
	}

	/**
	* Sets the framework image ID of this framework.
	*
	* @param frameworkImageId the framework image ID of this framework
	*/
	@Override
	public void setFrameworkImageId(java.lang.Long frameworkImageId) {
		_framework.setFrameworkImageId(frameworkImageId);
	}

	@Override
	public boolean isNew() {
		return _framework.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_framework.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _framework.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_framework.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _framework.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _framework.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_framework.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _framework.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_framework.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_framework.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_framework.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FrameworkWrapper((Framework)_framework.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Framework framework) {
		return _framework.compareTo(framework);
	}

	@Override
	public int hashCode() {
		return _framework.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Framework> toCacheModel() {
		return _framework.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Framework toEscapedModel() {
		return new FrameworkWrapper(_framework.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Framework toUnescapedModel() {
		return new FrameworkWrapper(_framework.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _framework.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _framework.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_framework.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FrameworkWrapper)) {
			return false;
		}

		FrameworkWrapper frameworkWrapper = (FrameworkWrapper)obj;

		if (Validator.equals(_framework, frameworkWrapper._framework)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Framework getWrappedFramework() {
		return _framework;
	}

	@Override
	public Framework getWrappedModel() {
		return _framework;
	}

	@Override
	public void resetOriginalValues() {
		_framework.resetOriginalValues();
	}

	private Framework _framework;
}