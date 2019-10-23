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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

/**
 * The base model interface for the SPIPGeoLocation service. Represents a row in the &quot;SPIPGeoLocation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPIPGeoLocation
 * @see com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationImpl
 * @see com.sambaash.platform.srv.spservices.model.impl.SPIPGeoLocationModelImpl
 * @generated
 */
public interface SPIPGeoLocationModel extends BaseModel<SPIPGeoLocation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p i p geo location model instance should use the {@link SPIPGeoLocation} interface instead.
	 */

	/**
	 * Returns the primary key of this s p i p geo location.
	 *
	 * @return the primary key of this s p i p geo location
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p i p geo location.
	 *
	 * @param primaryKey the primary key of this s p i p geo location
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this s p i p geo location.
	 *
	 * @return the uuid of this s p i p geo location
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this s p i p geo location.
	 *
	 * @param uuid the uuid of this s p i p geo location
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the sp i p geo location ID of this s p i p geo location.
	 *
	 * @return the sp i p geo location ID of this s p i p geo location
	 */
	public long getSpIPGeoLocationId();

	/**
	 * Sets the sp i p geo location ID of this s p i p geo location.
	 *
	 * @param spIPGeoLocationId the sp i p geo location ID of this s p i p geo location
	 */
	public void setSpIPGeoLocationId(long spIPGeoLocationId);

	/**
	 * Returns the ip prefix of this s p i p geo location.
	 *
	 * @return the ip prefix of this s p i p geo location
	 */
	@AutoEscape
	public String getIpPrefix();

	/**
	 * Sets the ip prefix of this s p i p geo location.
	 *
	 * @param ipPrefix the ip prefix of this s p i p geo location
	 */
	public void setIpPrefix(String ipPrefix);

	/**
	 * Returns the country of this s p i p geo location.
	 *
	 * @return the country of this s p i p geo location
	 */
	@AutoEscape
	public String getCountry();

	/**
	 * Sets the country of this s p i p geo location.
	 *
	 * @param country the country of this s p i p geo location
	 */
	public void setCountry(String country);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPIPGeoLocation spipGeoLocation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spservices.model.SPIPGeoLocation> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spservices.model.SPIPGeoLocation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}