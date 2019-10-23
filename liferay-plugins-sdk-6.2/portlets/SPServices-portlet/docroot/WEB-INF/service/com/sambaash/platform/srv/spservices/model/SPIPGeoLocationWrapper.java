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

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPIPGeoLocation}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPIPGeoLocation
 * @generated
 */
public class SPIPGeoLocationWrapper implements SPIPGeoLocation,
	ModelWrapper<SPIPGeoLocation> {
	public SPIPGeoLocationWrapper(SPIPGeoLocation spipGeoLocation) {
		_spipGeoLocation = spipGeoLocation;
	}

	@Override
	public Class<?> getModelClass() {
		return SPIPGeoLocation.class;
	}

	@Override
	public String getModelClassName() {
		return SPIPGeoLocation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spIPGeoLocationId", getSpIPGeoLocationId());
		attributes.put("ipPrefix", getIpPrefix());
		attributes.put("country", getCountry());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spIPGeoLocationId = (Long)attributes.get("spIPGeoLocationId");

		if (spIPGeoLocationId != null) {
			setSpIPGeoLocationId(spIPGeoLocationId);
		}

		String ipPrefix = (String)attributes.get("ipPrefix");

		if (ipPrefix != null) {
			setIpPrefix(ipPrefix);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}
	}

	/**
	* Returns the primary key of this s p i p geo location.
	*
	* @return the primary key of this s p i p geo location
	*/
	@Override
	public long getPrimaryKey() {
		return _spipGeoLocation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p i p geo location.
	*
	* @param primaryKey the primary key of this s p i p geo location
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spipGeoLocation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p i p geo location.
	*
	* @return the uuid of this s p i p geo location
	*/
	@Override
	public java.lang.String getUuid() {
		return _spipGeoLocation.getUuid();
	}

	/**
	* Sets the uuid of this s p i p geo location.
	*
	* @param uuid the uuid of this s p i p geo location
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spipGeoLocation.setUuid(uuid);
	}

	/**
	* Returns the sp i p geo location ID of this s p i p geo location.
	*
	* @return the sp i p geo location ID of this s p i p geo location
	*/
	@Override
	public long getSpIPGeoLocationId() {
		return _spipGeoLocation.getSpIPGeoLocationId();
	}

	/**
	* Sets the sp i p geo location ID of this s p i p geo location.
	*
	* @param spIPGeoLocationId the sp i p geo location ID of this s p i p geo location
	*/
	@Override
	public void setSpIPGeoLocationId(long spIPGeoLocationId) {
		_spipGeoLocation.setSpIPGeoLocationId(spIPGeoLocationId);
	}

	/**
	* Returns the ip prefix of this s p i p geo location.
	*
	* @return the ip prefix of this s p i p geo location
	*/
	@Override
	public java.lang.String getIpPrefix() {
		return _spipGeoLocation.getIpPrefix();
	}

	/**
	* Sets the ip prefix of this s p i p geo location.
	*
	* @param ipPrefix the ip prefix of this s p i p geo location
	*/
	@Override
	public void setIpPrefix(java.lang.String ipPrefix) {
		_spipGeoLocation.setIpPrefix(ipPrefix);
	}

	/**
	* Returns the country of this s p i p geo location.
	*
	* @return the country of this s p i p geo location
	*/
	@Override
	public java.lang.String getCountry() {
		return _spipGeoLocation.getCountry();
	}

	/**
	* Sets the country of this s p i p geo location.
	*
	* @param country the country of this s p i p geo location
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_spipGeoLocation.setCountry(country);
	}

	@Override
	public boolean isNew() {
		return _spipGeoLocation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spipGeoLocation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spipGeoLocation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spipGeoLocation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spipGeoLocation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spipGeoLocation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spipGeoLocation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spipGeoLocation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spipGeoLocation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spipGeoLocation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spipGeoLocation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPIPGeoLocationWrapper((SPIPGeoLocation)_spipGeoLocation.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPIPGeoLocation spipGeoLocation) {
		return _spipGeoLocation.compareTo(spipGeoLocation);
	}

	@Override
	public int hashCode() {
		return _spipGeoLocation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> toCacheModel() {
		return _spipGeoLocation.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation toEscapedModel() {
		return new SPIPGeoLocationWrapper(_spipGeoLocation.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation toUnescapedModel() {
		return new SPIPGeoLocationWrapper(_spipGeoLocation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spipGeoLocation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spipGeoLocation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spipGeoLocation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPIPGeoLocationWrapper)) {
			return false;
		}

		SPIPGeoLocationWrapper spipGeoLocationWrapper = (SPIPGeoLocationWrapper)obj;

		if (Validator.equals(_spipGeoLocation,
					spipGeoLocationWrapper._spipGeoLocation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPIPGeoLocation getWrappedSPIPGeoLocation() {
		return _spipGeoLocation;
	}

	@Override
	public SPIPGeoLocation getWrappedModel() {
		return _spipGeoLocation;
	}

	@Override
	public void resetOriginalValues() {
		_spipGeoLocation.resetOriginalValues();
	}

	private SPIPGeoLocation _spipGeoLocation;
}