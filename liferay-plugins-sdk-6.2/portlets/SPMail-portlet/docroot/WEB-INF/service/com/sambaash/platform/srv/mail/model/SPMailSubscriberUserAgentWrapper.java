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

package com.sambaash.platform.srv.mail.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPMailSubscriberUserAgent}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailSubscriberUserAgent
 * @generated
 */
public class SPMailSubscriberUserAgentWrapper
	implements SPMailSubscriberUserAgent,
		ModelWrapper<SPMailSubscriberUserAgent> {
	public SPMailSubscriberUserAgentWrapper(
		SPMailSubscriberUserAgent spMailSubscriberUserAgent) {
		_spMailSubscriberUserAgent = spMailSubscriberUserAgent;
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailSubscriberUserAgent.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailSubscriberUserAgent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailSubscriberUserAgentId",
			getSpMailSubscriberUserAgentId());
		attributes.put("spMailCampaignSubscribersId",
			getSpMailCampaignSubscribersId());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("name", getName());
		attributes.put("type", getType());
		attributes.put("typeName", getTypeName());
		attributes.put("deviceCategory", getDeviceCategory());
		attributes.put("family", getFamily());
		attributes.put("operatingSystem", getOperatingSystem());
		attributes.put("versionNumber", getVersionNumber());
		attributes.put("userAgent", getUserAgent());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailSubscriberUserAgentId = (Long)attributes.get(
				"spMailSubscriberUserAgentId");

		if (spMailSubscriberUserAgentId != null) {
			setSpMailSubscriberUserAgentId(spMailSubscriberUserAgentId);
		}

		Long spMailCampaignSubscribersId = (Long)attributes.get(
				"spMailCampaignSubscribersId");

		if (spMailCampaignSubscribersId != null) {
			setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String typeName = (String)attributes.get("typeName");

		if (typeName != null) {
			setTypeName(typeName);
		}

		String deviceCategory = (String)attributes.get("deviceCategory");

		if (deviceCategory != null) {
			setDeviceCategory(deviceCategory);
		}

		String family = (String)attributes.get("family");

		if (family != null) {
			setFamily(family);
		}

		String operatingSystem = (String)attributes.get("operatingSystem");

		if (operatingSystem != null) {
			setOperatingSystem(operatingSystem);
		}

		String versionNumber = (String)attributes.get("versionNumber");

		if (versionNumber != null) {
			setVersionNumber(versionNumber);
		}

		String userAgent = (String)attributes.get("userAgent");

		if (userAgent != null) {
			setUserAgent(userAgent);
		}
	}

	/**
	* Returns the primary key of this s p mail subscriber user agent.
	*
	* @return the primary key of this s p mail subscriber user agent
	*/
	@Override
	public long getPrimaryKey() {
		return _spMailSubscriberUserAgent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p mail subscriber user agent.
	*
	* @param primaryKey the primary key of this s p mail subscriber user agent
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spMailSubscriberUserAgent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp mail subscriber user agent ID of this s p mail subscriber user agent.
	*
	* @return the sp mail subscriber user agent ID of this s p mail subscriber user agent
	*/
	@Override
	public long getSpMailSubscriberUserAgentId() {
		return _spMailSubscriberUserAgent.getSpMailSubscriberUserAgentId();
	}

	/**
	* Sets the sp mail subscriber user agent ID of this s p mail subscriber user agent.
	*
	* @param spMailSubscriberUserAgentId the sp mail subscriber user agent ID of this s p mail subscriber user agent
	*/
	@Override
	public void setSpMailSubscriberUserAgentId(long spMailSubscriberUserAgentId) {
		_spMailSubscriberUserAgent.setSpMailSubscriberUserAgentId(spMailSubscriberUserAgentId);
	}

	/**
	* Returns the sp mail campaign subscribers ID of this s p mail subscriber user agent.
	*
	* @return the sp mail campaign subscribers ID of this s p mail subscriber user agent
	*/
	@Override
	public long getSpMailCampaignSubscribersId() {
		return _spMailSubscriberUserAgent.getSpMailCampaignSubscribersId();
	}

	/**
	* Sets the sp mail campaign subscribers ID of this s p mail subscriber user agent.
	*
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID of this s p mail subscriber user agent
	*/
	@Override
	public void setSpMailCampaignSubscribersId(long spMailCampaignSubscribersId) {
		_spMailSubscriberUserAgent.setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
	}

	/**
	* Returns the sp mail campaign ID of this s p mail subscriber user agent.
	*
	* @return the sp mail campaign ID of this s p mail subscriber user agent
	*/
	@Override
	public long getSpMailCampaignId() {
		return _spMailSubscriberUserAgent.getSpMailCampaignId();
	}

	/**
	* Sets the sp mail campaign ID of this s p mail subscriber user agent.
	*
	* @param spMailCampaignId the sp mail campaign ID of this s p mail subscriber user agent
	*/
	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailSubscriberUserAgent.setSpMailCampaignId(spMailCampaignId);
	}

	/**
	* Returns the name of this s p mail subscriber user agent.
	*
	* @return the name of this s p mail subscriber user agent
	*/
	@Override
	public java.lang.String getName() {
		return _spMailSubscriberUserAgent.getName();
	}

	/**
	* Sets the name of this s p mail subscriber user agent.
	*
	* @param name the name of this s p mail subscriber user agent
	*/
	@Override
	public void setName(java.lang.String name) {
		_spMailSubscriberUserAgent.setName(name);
	}

	/**
	* Returns the type of this s p mail subscriber user agent.
	*
	* @return the type of this s p mail subscriber user agent
	*/
	@Override
	public java.lang.String getType() {
		return _spMailSubscriberUserAgent.getType();
	}

	/**
	* Sets the type of this s p mail subscriber user agent.
	*
	* @param type the type of this s p mail subscriber user agent
	*/
	@Override
	public void setType(java.lang.String type) {
		_spMailSubscriberUserAgent.setType(type);
	}

	/**
	* Returns the type name of this s p mail subscriber user agent.
	*
	* @return the type name of this s p mail subscriber user agent
	*/
	@Override
	public java.lang.String getTypeName() {
		return _spMailSubscriberUserAgent.getTypeName();
	}

	/**
	* Sets the type name of this s p mail subscriber user agent.
	*
	* @param typeName the type name of this s p mail subscriber user agent
	*/
	@Override
	public void setTypeName(java.lang.String typeName) {
		_spMailSubscriberUserAgent.setTypeName(typeName);
	}

	/**
	* Returns the device category of this s p mail subscriber user agent.
	*
	* @return the device category of this s p mail subscriber user agent
	*/
	@Override
	public java.lang.String getDeviceCategory() {
		return _spMailSubscriberUserAgent.getDeviceCategory();
	}

	/**
	* Sets the device category of this s p mail subscriber user agent.
	*
	* @param deviceCategory the device category of this s p mail subscriber user agent
	*/
	@Override
	public void setDeviceCategory(java.lang.String deviceCategory) {
		_spMailSubscriberUserAgent.setDeviceCategory(deviceCategory);
	}

	/**
	* Returns the family of this s p mail subscriber user agent.
	*
	* @return the family of this s p mail subscriber user agent
	*/
	@Override
	public java.lang.String getFamily() {
		return _spMailSubscriberUserAgent.getFamily();
	}

	/**
	* Sets the family of this s p mail subscriber user agent.
	*
	* @param family the family of this s p mail subscriber user agent
	*/
	@Override
	public void setFamily(java.lang.String family) {
		_spMailSubscriberUserAgent.setFamily(family);
	}

	/**
	* Returns the operating system of this s p mail subscriber user agent.
	*
	* @return the operating system of this s p mail subscriber user agent
	*/
	@Override
	public java.lang.String getOperatingSystem() {
		return _spMailSubscriberUserAgent.getOperatingSystem();
	}

	/**
	* Sets the operating system of this s p mail subscriber user agent.
	*
	* @param operatingSystem the operating system of this s p mail subscriber user agent
	*/
	@Override
	public void setOperatingSystem(java.lang.String operatingSystem) {
		_spMailSubscriberUserAgent.setOperatingSystem(operatingSystem);
	}

	/**
	* Returns the version number of this s p mail subscriber user agent.
	*
	* @return the version number of this s p mail subscriber user agent
	*/
	@Override
	public java.lang.String getVersionNumber() {
		return _spMailSubscriberUserAgent.getVersionNumber();
	}

	/**
	* Sets the version number of this s p mail subscriber user agent.
	*
	* @param versionNumber the version number of this s p mail subscriber user agent
	*/
	@Override
	public void setVersionNumber(java.lang.String versionNumber) {
		_spMailSubscriberUserAgent.setVersionNumber(versionNumber);
	}

	/**
	* Returns the user agent of this s p mail subscriber user agent.
	*
	* @return the user agent of this s p mail subscriber user agent
	*/
	@Override
	public java.lang.String getUserAgent() {
		return _spMailSubscriberUserAgent.getUserAgent();
	}

	/**
	* Sets the user agent of this s p mail subscriber user agent.
	*
	* @param userAgent the user agent of this s p mail subscriber user agent
	*/
	@Override
	public void setUserAgent(java.lang.String userAgent) {
		_spMailSubscriberUserAgent.setUserAgent(userAgent);
	}

	@Override
	public boolean isNew() {
		return _spMailSubscriberUserAgent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spMailSubscriberUserAgent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spMailSubscriberUserAgent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spMailSubscriberUserAgent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spMailSubscriberUserAgent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spMailSubscriberUserAgent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spMailSubscriberUserAgent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spMailSubscriberUserAgent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spMailSubscriberUserAgent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spMailSubscriberUserAgent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spMailSubscriberUserAgent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPMailSubscriberUserAgentWrapper((SPMailSubscriberUserAgent)_spMailSubscriberUserAgent.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent spMailSubscriberUserAgent) {
		return _spMailSubscriberUserAgent.compareTo(spMailSubscriberUserAgent);
	}

	@Override
	public int hashCode() {
		return _spMailSubscriberUserAgent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent> toCacheModel() {
		return _spMailSubscriberUserAgent.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent toEscapedModel() {
		return new SPMailSubscriberUserAgentWrapper(_spMailSubscriberUserAgent.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailSubscriberUserAgent toUnescapedModel() {
		return new SPMailSubscriberUserAgentWrapper(_spMailSubscriberUserAgent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spMailSubscriberUserAgent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spMailSubscriberUserAgent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailSubscriberUserAgent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailSubscriberUserAgentWrapper)) {
			return false;
		}

		SPMailSubscriberUserAgentWrapper spMailSubscriberUserAgentWrapper = (SPMailSubscriberUserAgentWrapper)obj;

		if (Validator.equals(_spMailSubscriberUserAgent,
					spMailSubscriberUserAgentWrapper._spMailSubscriberUserAgent)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPMailSubscriberUserAgent getWrappedSPMailSubscriberUserAgent() {
		return _spMailSubscriberUserAgent;
	}

	@Override
	public SPMailSubscriberUserAgent getWrappedModel() {
		return _spMailSubscriberUserAgent;
	}

	@Override
	public void resetOriginalValues() {
		_spMailSubscriberUserAgent.resetOriginalValues();
	}

	private SPMailSubscriberUserAgent _spMailSubscriberUserAgent;
}