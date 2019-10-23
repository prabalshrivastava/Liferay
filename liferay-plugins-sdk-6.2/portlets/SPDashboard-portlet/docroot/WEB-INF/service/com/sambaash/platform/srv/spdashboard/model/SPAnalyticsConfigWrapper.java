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

package com.sambaash.platform.srv.spdashboard.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPAnalyticsConfig}.
 * </p>
 *
 * @author pradeep
 * @see SPAnalyticsConfig
 * @generated
 */
public class SPAnalyticsConfigWrapper implements SPAnalyticsConfig,
	ModelWrapper<SPAnalyticsConfig> {
	public SPAnalyticsConfigWrapper(SPAnalyticsConfig spAnalyticsConfig) {
		_spAnalyticsConfig = spAnalyticsConfig;
	}

	@Override
	public Class<?> getModelClass() {
		return SPAnalyticsConfig.class;
	}

	@Override
	public String getModelClassName() {
		return SPAnalyticsConfig.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spAnalyticsConfigId", getSpAnalyticsConfigId());
		attributes.put("name", getName());
		attributes.put("config", getConfig());
		attributes.put("type", getType());
		attributes.put("query", getQuery());
		attributes.put("warId", getWarId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spAnalyticsConfigId = (Long)attributes.get("spAnalyticsConfigId");

		if (spAnalyticsConfigId != null) {
			setSpAnalyticsConfigId(spAnalyticsConfigId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String config = (String)attributes.get("config");

		if (config != null) {
			setConfig(config);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String query = (String)attributes.get("query");

		if (query != null) {
			setQuery(query);
		}

		String warId = (String)attributes.get("warId");

		if (warId != null) {
			setWarId(warId);
		}
	}

	/**
	* Returns the primary key of this s p analytics config.
	*
	* @return the primary key of this s p analytics config
	*/
	@Override
	public long getPrimaryKey() {
		return _spAnalyticsConfig.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p analytics config.
	*
	* @param primaryKey the primary key of this s p analytics config
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spAnalyticsConfig.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp analytics config ID of this s p analytics config.
	*
	* @return the sp analytics config ID of this s p analytics config
	*/
	@Override
	public long getSpAnalyticsConfigId() {
		return _spAnalyticsConfig.getSpAnalyticsConfigId();
	}

	/**
	* Sets the sp analytics config ID of this s p analytics config.
	*
	* @param spAnalyticsConfigId the sp analytics config ID of this s p analytics config
	*/
	@Override
	public void setSpAnalyticsConfigId(long spAnalyticsConfigId) {
		_spAnalyticsConfig.setSpAnalyticsConfigId(spAnalyticsConfigId);
	}

	/**
	* Returns the name of this s p analytics config.
	*
	* @return the name of this s p analytics config
	*/
	@Override
	public java.lang.String getName() {
		return _spAnalyticsConfig.getName();
	}

	/**
	* Sets the name of this s p analytics config.
	*
	* @param name the name of this s p analytics config
	*/
	@Override
	public void setName(java.lang.String name) {
		_spAnalyticsConfig.setName(name);
	}

	/**
	* Returns the config of this s p analytics config.
	*
	* @return the config of this s p analytics config
	*/
	@Override
	public java.lang.String getConfig() {
		return _spAnalyticsConfig.getConfig();
	}

	/**
	* Sets the config of this s p analytics config.
	*
	* @param config the config of this s p analytics config
	*/
	@Override
	public void setConfig(java.lang.String config) {
		_spAnalyticsConfig.setConfig(config);
	}

	/**
	* Returns the type of this s p analytics config.
	*
	* @return the type of this s p analytics config
	*/
	@Override
	public int getType() {
		return _spAnalyticsConfig.getType();
	}

	/**
	* Sets the type of this s p analytics config.
	*
	* @param type the type of this s p analytics config
	*/
	@Override
	public void setType(int type) {
		_spAnalyticsConfig.setType(type);
	}

	/**
	* Returns the query of this s p analytics config.
	*
	* @return the query of this s p analytics config
	*/
	@Override
	public java.lang.String getQuery() {
		return _spAnalyticsConfig.getQuery();
	}

	/**
	* Sets the query of this s p analytics config.
	*
	* @param query the query of this s p analytics config
	*/
	@Override
	public void setQuery(java.lang.String query) {
		_spAnalyticsConfig.setQuery(query);
	}

	/**
	* Returns the war ID of this s p analytics config.
	*
	* @return the war ID of this s p analytics config
	*/
	@Override
	public java.lang.String getWarId() {
		return _spAnalyticsConfig.getWarId();
	}

	/**
	* Sets the war ID of this s p analytics config.
	*
	* @param warId the war ID of this s p analytics config
	*/
	@Override
	public void setWarId(java.lang.String warId) {
		_spAnalyticsConfig.setWarId(warId);
	}

	@Override
	public boolean isNew() {
		return _spAnalyticsConfig.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spAnalyticsConfig.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spAnalyticsConfig.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spAnalyticsConfig.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spAnalyticsConfig.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spAnalyticsConfig.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spAnalyticsConfig.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spAnalyticsConfig.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spAnalyticsConfig.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spAnalyticsConfig.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spAnalyticsConfig.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPAnalyticsConfigWrapper((SPAnalyticsConfig)_spAnalyticsConfig.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig spAnalyticsConfig) {
		return _spAnalyticsConfig.compareTo(spAnalyticsConfig);
	}

	@Override
	public int hashCode() {
		return _spAnalyticsConfig.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig> toCacheModel() {
		return _spAnalyticsConfig.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig toEscapedModel() {
		return new SPAnalyticsConfigWrapper(_spAnalyticsConfig.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spdashboard.model.SPAnalyticsConfig toUnescapedModel() {
		return new SPAnalyticsConfigWrapper(_spAnalyticsConfig.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spAnalyticsConfig.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spAnalyticsConfig.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spAnalyticsConfig.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPAnalyticsConfigWrapper)) {
			return false;
		}

		SPAnalyticsConfigWrapper spAnalyticsConfigWrapper = (SPAnalyticsConfigWrapper)obj;

		if (Validator.equals(_spAnalyticsConfig,
					spAnalyticsConfigWrapper._spAnalyticsConfig)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPAnalyticsConfig getWrappedSPAnalyticsConfig() {
		return _spAnalyticsConfig;
	}

	@Override
	public SPAnalyticsConfig getWrappedModel() {
		return _spAnalyticsConfig;
	}

	@Override
	public void resetOriginalValues() {
		_spAnalyticsConfig.resetOriginalValues();
	}

	private SPAnalyticsConfig _spAnalyticsConfig;
}