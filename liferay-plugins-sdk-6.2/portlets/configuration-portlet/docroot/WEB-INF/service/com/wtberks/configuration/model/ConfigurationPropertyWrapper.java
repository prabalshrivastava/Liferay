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

package com.wtberks.configuration.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link ConfigurationProperty}.
 * </p>
 *
 * @author liferay
 * @see ConfigurationProperty
 * @generated
 */
public class ConfigurationPropertyWrapper implements ConfigurationProperty,
	ModelWrapper<ConfigurationProperty> {
	public ConfigurationPropertyWrapper(
		ConfigurationProperty configurationProperty) {
		_configurationProperty = configurationProperty;
	}

	@Override
	public Class<?> getModelClass() {
		return ConfigurationProperty.class;
	}

	@Override
	public String getModelClassName() {
		return ConfigurationProperty.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("configurationPropertyId", getConfigurationPropertyId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("key", getKey());
		attributes.put("value", getValue());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long configurationPropertyId = (Long)attributes.get(
				"configurationPropertyId");

		if (configurationPropertyId != null) {
			setConfigurationPropertyId(configurationPropertyId);
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

		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}
	}

	/**
	* Returns the primary key of this configuration property.
	*
	* @return the primary key of this configuration property
	*/
	@Override
	public long getPrimaryKey() {
		return _configurationProperty.getPrimaryKey();
	}

	/**
	* Sets the primary key of this configuration property.
	*
	* @param primaryKey the primary key of this configuration property
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_configurationProperty.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this configuration property.
	*
	* @return the uuid of this configuration property
	*/
	@Override
	public java.lang.String getUuid() {
		return _configurationProperty.getUuid();
	}

	/**
	* Sets the uuid of this configuration property.
	*
	* @param uuid the uuid of this configuration property
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_configurationProperty.setUuid(uuid);
	}

	/**
	* Returns the configuration property ID of this configuration property.
	*
	* @return the configuration property ID of this configuration property
	*/
	@Override
	public long getConfigurationPropertyId() {
		return _configurationProperty.getConfigurationPropertyId();
	}

	/**
	* Sets the configuration property ID of this configuration property.
	*
	* @param configurationPropertyId the configuration property ID of this configuration property
	*/
	@Override
	public void setConfigurationPropertyId(long configurationPropertyId) {
		_configurationProperty.setConfigurationPropertyId(configurationPropertyId);
	}

	/**
	* Returns the group ID of this configuration property.
	*
	* @return the group ID of this configuration property
	*/
	@Override
	public long getGroupId() {
		return _configurationProperty.getGroupId();
	}

	/**
	* Sets the group ID of this configuration property.
	*
	* @param groupId the group ID of this configuration property
	*/
	@Override
	public void setGroupId(long groupId) {
		_configurationProperty.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this configuration property.
	*
	* @return the company ID of this configuration property
	*/
	@Override
	public long getCompanyId() {
		return _configurationProperty.getCompanyId();
	}

	/**
	* Sets the company ID of this configuration property.
	*
	* @param companyId the company ID of this configuration property
	*/
	@Override
	public void setCompanyId(long companyId) {
		_configurationProperty.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this configuration property.
	*
	* @return the user ID of this configuration property
	*/
	@Override
	public long getUserId() {
		return _configurationProperty.getUserId();
	}

	/**
	* Sets the user ID of this configuration property.
	*
	* @param userId the user ID of this configuration property
	*/
	@Override
	public void setUserId(long userId) {
		_configurationProperty.setUserId(userId);
	}

	/**
	* Returns the user uuid of this configuration property.
	*
	* @return the user uuid of this configuration property
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _configurationProperty.getUserUuid();
	}

	/**
	* Sets the user uuid of this configuration property.
	*
	* @param userUuid the user uuid of this configuration property
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_configurationProperty.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this configuration property.
	*
	* @return the user name of this configuration property
	*/
	@Override
	public java.lang.String getUserName() {
		return _configurationProperty.getUserName();
	}

	/**
	* Sets the user name of this configuration property.
	*
	* @param userName the user name of this configuration property
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_configurationProperty.setUserName(userName);
	}

	/**
	* Returns the create date of this configuration property.
	*
	* @return the create date of this configuration property
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _configurationProperty.getCreateDate();
	}

	/**
	* Sets the create date of this configuration property.
	*
	* @param createDate the create date of this configuration property
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_configurationProperty.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this configuration property.
	*
	* @return the modified date of this configuration property
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _configurationProperty.getModifiedDate();
	}

	/**
	* Sets the modified date of this configuration property.
	*
	* @param modifiedDate the modified date of this configuration property
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_configurationProperty.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the key of this configuration property.
	*
	* @return the key of this configuration property
	*/
	@Override
	public java.lang.String getKey() {
		return _configurationProperty.getKey();
	}

	/**
	* Sets the key of this configuration property.
	*
	* @param key the key of this configuration property
	*/
	@Override
	public void setKey(java.lang.String key) {
		_configurationProperty.setKey(key);
	}

	/**
	* Returns the value of this configuration property.
	*
	* @return the value of this configuration property
	*/
	@Override
	public java.lang.String getValue() {
		return _configurationProperty.getValue();
	}

	/**
	* Sets the value of this configuration property.
	*
	* @param value the value of this configuration property
	*/
	@Override
	public void setValue(java.lang.String value) {
		_configurationProperty.setValue(value);
	}

	@Override
	public boolean isNew() {
		return _configurationProperty.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_configurationProperty.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _configurationProperty.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_configurationProperty.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _configurationProperty.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _configurationProperty.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_configurationProperty.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _configurationProperty.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_configurationProperty.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_configurationProperty.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_configurationProperty.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ConfigurationPropertyWrapper((ConfigurationProperty)_configurationProperty.clone());
	}

	@Override
	public int compareTo(
		com.wtberks.configuration.model.ConfigurationProperty configurationProperty) {
		return _configurationProperty.compareTo(configurationProperty);
	}

	@Override
	public int hashCode() {
		return _configurationProperty.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.wtberks.configuration.model.ConfigurationProperty> toCacheModel() {
		return _configurationProperty.toCacheModel();
	}

	@Override
	public com.wtberks.configuration.model.ConfigurationProperty toEscapedModel() {
		return new ConfigurationPropertyWrapper(_configurationProperty.toEscapedModel());
	}

	@Override
	public com.wtberks.configuration.model.ConfigurationProperty toUnescapedModel() {
		return new ConfigurationPropertyWrapper(_configurationProperty.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _configurationProperty.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _configurationProperty.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_configurationProperty.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ConfigurationPropertyWrapper)) {
			return false;
		}

		ConfigurationPropertyWrapper configurationPropertyWrapper = (ConfigurationPropertyWrapper)obj;

		if (Validator.equals(_configurationProperty,
					configurationPropertyWrapper._configurationProperty)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _configurationProperty.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ConfigurationProperty getWrappedConfigurationProperty() {
		return _configurationProperty;
	}

	@Override
	public ConfigurationProperty getWrappedModel() {
		return _configurationProperty;
	}

	@Override
	public void resetOriginalValues() {
		_configurationProperty.resetOriginalValues();
	}

	private ConfigurationProperty _configurationProperty;
}