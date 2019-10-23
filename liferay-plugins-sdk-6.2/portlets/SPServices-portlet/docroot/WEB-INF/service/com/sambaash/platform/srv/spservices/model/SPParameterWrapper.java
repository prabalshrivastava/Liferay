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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPParameter}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPParameter
 * @generated
 */
public class SPParameterWrapper implements SPParameter,
	ModelWrapper<SPParameter> {
	public SPParameterWrapper(SPParameter spParameter) {
		_spParameter = spParameter;
	}

	@Override
	public Class<?> getModelClass() {
		return SPParameter.class;
	}

	@Override
	public String getModelClassName() {
		return SPParameter.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spParameterId", getSpParameterId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("category", getCategory());
		attributes.put("description", getDescription());
		attributes.put("name", getName());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spParameterId = (Long)attributes.get("spParameterId");

		if (spParameterId != null) {
			setSpParameterId(spParameterId);
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

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this s p parameter.
	*
	* @return the primary key of this s p parameter
	*/
	@Override
	public long getPrimaryKey() {
		return _spParameter.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p parameter.
	*
	* @param primaryKey the primary key of this s p parameter
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spParameter.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p parameter.
	*
	* @return the uuid of this s p parameter
	*/
	@Override
	public java.lang.String getUuid() {
		return _spParameter.getUuid();
	}

	/**
	* Sets the uuid of this s p parameter.
	*
	* @param uuid the uuid of this s p parameter
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spParameter.setUuid(uuid);
	}

	/**
	* Returns the sp parameter ID of this s p parameter.
	*
	* @return the sp parameter ID of this s p parameter
	*/
	@Override
	public long getSpParameterId() {
		return _spParameter.getSpParameterId();
	}

	/**
	* Sets the sp parameter ID of this s p parameter.
	*
	* @param spParameterId the sp parameter ID of this s p parameter
	*/
	@Override
	public void setSpParameterId(long spParameterId) {
		_spParameter.setSpParameterId(spParameterId);
	}

	/**
	* Returns the group ID of this s p parameter.
	*
	* @return the group ID of this s p parameter
	*/
	@Override
	public long getGroupId() {
		return _spParameter.getGroupId();
	}

	/**
	* Sets the group ID of this s p parameter.
	*
	* @param groupId the group ID of this s p parameter
	*/
	@Override
	public void setGroupId(long groupId) {
		_spParameter.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p parameter.
	*
	* @return the company ID of this s p parameter
	*/
	@Override
	public long getCompanyId() {
		return _spParameter.getCompanyId();
	}

	/**
	* Sets the company ID of this s p parameter.
	*
	* @param companyId the company ID of this s p parameter
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spParameter.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p parameter.
	*
	* @return the user ID of this s p parameter
	*/
	@Override
	public long getUserId() {
		return _spParameter.getUserId();
	}

	/**
	* Sets the user ID of this s p parameter.
	*
	* @param userId the user ID of this s p parameter
	*/
	@Override
	public void setUserId(long userId) {
		_spParameter.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p parameter.
	*
	* @return the user uuid of this s p parameter
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spParameter.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p parameter.
	*
	* @param userUuid the user uuid of this s p parameter
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spParameter.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p parameter.
	*
	* @return the user name of this s p parameter
	*/
	@Override
	public java.lang.String getUserName() {
		return _spParameter.getUserName();
	}

	/**
	* Sets the user name of this s p parameter.
	*
	* @param userName the user name of this s p parameter
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spParameter.setUserName(userName);
	}

	/**
	* Returns the create date of this s p parameter.
	*
	* @return the create date of this s p parameter
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spParameter.getCreateDate();
	}

	/**
	* Sets the create date of this s p parameter.
	*
	* @param createDate the create date of this s p parameter
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spParameter.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p parameter.
	*
	* @return the modified date of this s p parameter
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spParameter.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p parameter.
	*
	* @param modifiedDate the modified date of this s p parameter
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spParameter.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the category of this s p parameter.
	*
	* @return the category of this s p parameter
	*/
	@Override
	public java.lang.String getCategory() {
		return _spParameter.getCategory();
	}

	/**
	* Sets the category of this s p parameter.
	*
	* @param category the category of this s p parameter
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_spParameter.setCategory(category);
	}

	/**
	* Returns the description of this s p parameter.
	*
	* @return the description of this s p parameter
	*/
	@Override
	public java.lang.String getDescription() {
		return _spParameter.getDescription();
	}

	/**
	* Sets the description of this s p parameter.
	*
	* @param description the description of this s p parameter
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_spParameter.setDescription(description);
	}

	/**
	* Returns the name of this s p parameter.
	*
	* @return the name of this s p parameter
	*/
	@Override
	public java.lang.String getName() {
		return _spParameter.getName();
	}

	/**
	* Sets the name of this s p parameter.
	*
	* @param name the name of this s p parameter
	*/
	@Override
	public void setName(java.lang.String name) {
		_spParameter.setName(name);
	}

	/**
	* Returns the value of this s p parameter.
	*
	* @return the value of this s p parameter
	*/
	@Override
	public java.lang.String getValue() {
		return _spParameter.getValue();
	}

	/**
	* Sets the value of this s p parameter.
	*
	* @param value the value of this s p parameter
	*/
	@Override
	public void setValue(java.lang.String value) {
		_spParameter.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _spParameter.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spParameter.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spParameter.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spParameter.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spParameter.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spParameter.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spParameter.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spParameter.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spParameter.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spParameter.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spParameter.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPParameterWrapper((SPParameter)_spParameter.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPParameter spParameter) {
		return _spParameter.compareTo(spParameter);
	}

	@Override
	public int hashCode() {
		return _spParameter.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPParameter> toCacheModel() {
		return _spParameter.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPParameter toEscapedModel() {
		return new SPParameterWrapper(_spParameter.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPParameter toUnescapedModel() {
		return new SPParameterWrapper(_spParameter.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spParameter.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spParameter.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spParameter.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPParameterWrapper)) {
			return false;
		}

		SPParameterWrapper spParameterWrapper = (SPParameterWrapper)obj;

		if (Validator.equals(_spParameter, spParameterWrapper._spParameter)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spParameter.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPParameter getWrappedSPParameter() {
		return _spParameter;
	}

	@Override
	public SPParameter getWrappedModel() {
		return _spParameter;
	}

	@Override
	public void resetOriginalValues() {
		_spParameter.resetOriginalValues();
	}

	private SPParameter _spParameter;
}