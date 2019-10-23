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

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPMailCampaignSubscribers}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPMailCampaignSubscribers
 * @generated
 */
public class SPMailCampaignSubscribersWrapper
	implements SPMailCampaignSubscribers,
		ModelWrapper<SPMailCampaignSubscribers> {
	public SPMailCampaignSubscribersWrapper(
		SPMailCampaignSubscribers spMailCampaignSubscribers) {
		_spMailCampaignSubscribers = spMailCampaignSubscribers;
	}

	@Override
	public Class<?> getModelClass() {
		return SPMailCampaignSubscribers.class;
	}

	@Override
	public String getModelClassName() {
		return SPMailCampaignSubscribers.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spMailCampaignSubscribersId",
			getSpMailCampaignSubscribersId());
		attributes.put("spMailCampaignId", getSpMailCampaignId());
		attributes.put("userId", getUserId());
		attributes.put("parentSubscriberId", getParentSubscriberId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("spMailType", getSpMailType());
		attributes.put("messageId", getMessageId());
		attributes.put("opened", getOpened());
		attributes.put("countryName", getCountryName());
		attributes.put("city", getCity());
		attributes.put("regionName", getRegionName());
		attributes.put("areaCode", getAreaCode());
		attributes.put("latitude", getLatitude());
		attributes.put("longitude", getLongitude());
		attributes.put("ipAddress", getIpAddress());
		attributes.put("webVersion", getWebVersion());
		attributes.put("openedDate", getOpenedDate());
		attributes.put("createBy", getCreateBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spMailCampaignSubscribersId = (Long)attributes.get(
				"spMailCampaignSubscribersId");

		if (spMailCampaignSubscribersId != null) {
			setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
		}

		Long spMailCampaignId = (Long)attributes.get("spMailCampaignId");

		if (spMailCampaignId != null) {
			setSpMailCampaignId(spMailCampaignId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long parentSubscriberId = (Long)attributes.get("parentSubscriberId");

		if (parentSubscriberId != null) {
			setParentSubscriberId(parentSubscriberId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		Integer spMailType = (Integer)attributes.get("spMailType");

		if (spMailType != null) {
			setSpMailType(spMailType);
		}

		String messageId = (String)attributes.get("messageId");

		if (messageId != null) {
			setMessageId(messageId);
		}

		Boolean opened = (Boolean)attributes.get("opened");

		if (opened != null) {
			setOpened(opened);
		}

		String countryName = (String)attributes.get("countryName");

		if (countryName != null) {
			setCountryName(countryName);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String regionName = (String)attributes.get("regionName");

		if (regionName != null) {
			setRegionName(regionName);
		}

		Integer areaCode = (Integer)attributes.get("areaCode");

		if (areaCode != null) {
			setAreaCode(areaCode);
		}

		String latitude = (String)attributes.get("latitude");

		if (latitude != null) {
			setLatitude(latitude);
		}

		String longitude = (String)attributes.get("longitude");

		if (longitude != null) {
			setLongitude(longitude);
		}

		String ipAddress = (String)attributes.get("ipAddress");

		if (ipAddress != null) {
			setIpAddress(ipAddress);
		}

		Boolean webVersion = (Boolean)attributes.get("webVersion");

		if (webVersion != null) {
			setWebVersion(webVersion);
		}

		Date openedDate = (Date)attributes.get("openedDate");

		if (openedDate != null) {
			setOpenedDate(openedDate);
		}

		Long createBy = (Long)attributes.get("createBy");

		if (createBy != null) {
			setCreateBy(createBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this s p mail campaign subscribers.
	*
	* @return the primary key of this s p mail campaign subscribers
	*/
	@Override
	public long getPrimaryKey() {
		return _spMailCampaignSubscribers.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p mail campaign subscribers.
	*
	* @param primaryKey the primary key of this s p mail campaign subscribers
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spMailCampaignSubscribers.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp mail campaign subscribers ID of this s p mail campaign subscribers.
	*
	* @return the sp mail campaign subscribers ID of this s p mail campaign subscribers
	*/
	@Override
	public long getSpMailCampaignSubscribersId() {
		return _spMailCampaignSubscribers.getSpMailCampaignSubscribersId();
	}

	/**
	* Sets the sp mail campaign subscribers ID of this s p mail campaign subscribers.
	*
	* @param spMailCampaignSubscribersId the sp mail campaign subscribers ID of this s p mail campaign subscribers
	*/
	@Override
	public void setSpMailCampaignSubscribersId(long spMailCampaignSubscribersId) {
		_spMailCampaignSubscribers.setSpMailCampaignSubscribersId(spMailCampaignSubscribersId);
	}

	/**
	* Returns the sp mail campaign ID of this s p mail campaign subscribers.
	*
	* @return the sp mail campaign ID of this s p mail campaign subscribers
	*/
	@Override
	public long getSpMailCampaignId() {
		return _spMailCampaignSubscribers.getSpMailCampaignId();
	}

	/**
	* Sets the sp mail campaign ID of this s p mail campaign subscribers.
	*
	* @param spMailCampaignId the sp mail campaign ID of this s p mail campaign subscribers
	*/
	@Override
	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignSubscribers.setSpMailCampaignId(spMailCampaignId);
	}

	/**
	* Returns the user ID of this s p mail campaign subscribers.
	*
	* @return the user ID of this s p mail campaign subscribers
	*/
	@Override
	public long getUserId() {
		return _spMailCampaignSubscribers.getUserId();
	}

	/**
	* Sets the user ID of this s p mail campaign subscribers.
	*
	* @param userId the user ID of this s p mail campaign subscribers
	*/
	@Override
	public void setUserId(long userId) {
		_spMailCampaignSubscribers.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p mail campaign subscribers.
	*
	* @return the user uuid of this s p mail campaign subscribers
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spMailCampaignSubscribers.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p mail campaign subscribers.
	*
	* @param userUuid the user uuid of this s p mail campaign subscribers
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spMailCampaignSubscribers.setUserUuid(userUuid);
	}

	/**
	* Returns the parent subscriber ID of this s p mail campaign subscribers.
	*
	* @return the parent subscriber ID of this s p mail campaign subscribers
	*/
	@Override
	public long getParentSubscriberId() {
		return _spMailCampaignSubscribers.getParentSubscriberId();
	}

	/**
	* Sets the parent subscriber ID of this s p mail campaign subscribers.
	*
	* @param parentSubscriberId the parent subscriber ID of this s p mail campaign subscribers
	*/
	@Override
	public void setParentSubscriberId(long parentSubscriberId) {
		_spMailCampaignSubscribers.setParentSubscriberId(parentSubscriberId);
	}

	/**
	* Returns the email address of this s p mail campaign subscribers.
	*
	* @return the email address of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spMailCampaignSubscribers.getEmailAddress();
	}

	/**
	* Sets the email address of this s p mail campaign subscribers.
	*
	* @param emailAddress the email address of this s p mail campaign subscribers
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spMailCampaignSubscribers.setEmailAddress(emailAddress);
	}

	/**
	* Returns the first name of this s p mail campaign subscribers.
	*
	* @return the first name of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getFirstName() {
		return _spMailCampaignSubscribers.getFirstName();
	}

	/**
	* Sets the first name of this s p mail campaign subscribers.
	*
	* @param firstName the first name of this s p mail campaign subscribers
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_spMailCampaignSubscribers.setFirstName(firstName);
	}

	/**
	* Returns the last name of this s p mail campaign subscribers.
	*
	* @return the last name of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getLastName() {
		return _spMailCampaignSubscribers.getLastName();
	}

	/**
	* Sets the last name of this s p mail campaign subscribers.
	*
	* @param lastName the last name of this s p mail campaign subscribers
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_spMailCampaignSubscribers.setLastName(lastName);
	}

	/**
	* Returns the sp mail type of this s p mail campaign subscribers.
	*
	* @return the sp mail type of this s p mail campaign subscribers
	*/
	@Override
	public int getSpMailType() {
		return _spMailCampaignSubscribers.getSpMailType();
	}

	/**
	* Sets the sp mail type of this s p mail campaign subscribers.
	*
	* @param spMailType the sp mail type of this s p mail campaign subscribers
	*/
	@Override
	public void setSpMailType(int spMailType) {
		_spMailCampaignSubscribers.setSpMailType(spMailType);
	}

	/**
	* Returns the message ID of this s p mail campaign subscribers.
	*
	* @return the message ID of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getMessageId() {
		return _spMailCampaignSubscribers.getMessageId();
	}

	/**
	* Sets the message ID of this s p mail campaign subscribers.
	*
	* @param messageId the message ID of this s p mail campaign subscribers
	*/
	@Override
	public void setMessageId(java.lang.String messageId) {
		_spMailCampaignSubscribers.setMessageId(messageId);
	}

	/**
	* Returns the opened of this s p mail campaign subscribers.
	*
	* @return the opened of this s p mail campaign subscribers
	*/
	@Override
	public boolean getOpened() {
		return _spMailCampaignSubscribers.getOpened();
	}

	/**
	* Returns <code>true</code> if this s p mail campaign subscribers is opened.
	*
	* @return <code>true</code> if this s p mail campaign subscribers is opened; <code>false</code> otherwise
	*/
	@Override
	public boolean isOpened() {
		return _spMailCampaignSubscribers.isOpened();
	}

	/**
	* Sets whether this s p mail campaign subscribers is opened.
	*
	* @param opened the opened of this s p mail campaign subscribers
	*/
	@Override
	public void setOpened(boolean opened) {
		_spMailCampaignSubscribers.setOpened(opened);
	}

	/**
	* Returns the country name of this s p mail campaign subscribers.
	*
	* @return the country name of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getCountryName() {
		return _spMailCampaignSubscribers.getCountryName();
	}

	/**
	* Sets the country name of this s p mail campaign subscribers.
	*
	* @param countryName the country name of this s p mail campaign subscribers
	*/
	@Override
	public void setCountryName(java.lang.String countryName) {
		_spMailCampaignSubscribers.setCountryName(countryName);
	}

	/**
	* Returns the city of this s p mail campaign subscribers.
	*
	* @return the city of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getCity() {
		return _spMailCampaignSubscribers.getCity();
	}

	/**
	* Sets the city of this s p mail campaign subscribers.
	*
	* @param city the city of this s p mail campaign subscribers
	*/
	@Override
	public void setCity(java.lang.String city) {
		_spMailCampaignSubscribers.setCity(city);
	}

	/**
	* Returns the region name of this s p mail campaign subscribers.
	*
	* @return the region name of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getRegionName() {
		return _spMailCampaignSubscribers.getRegionName();
	}

	/**
	* Sets the region name of this s p mail campaign subscribers.
	*
	* @param regionName the region name of this s p mail campaign subscribers
	*/
	@Override
	public void setRegionName(java.lang.String regionName) {
		_spMailCampaignSubscribers.setRegionName(regionName);
	}

	/**
	* Returns the area code of this s p mail campaign subscribers.
	*
	* @return the area code of this s p mail campaign subscribers
	*/
	@Override
	public int getAreaCode() {
		return _spMailCampaignSubscribers.getAreaCode();
	}

	/**
	* Sets the area code of this s p mail campaign subscribers.
	*
	* @param areaCode the area code of this s p mail campaign subscribers
	*/
	@Override
	public void setAreaCode(int areaCode) {
		_spMailCampaignSubscribers.setAreaCode(areaCode);
	}

	/**
	* Returns the latitude of this s p mail campaign subscribers.
	*
	* @return the latitude of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getLatitude() {
		return _spMailCampaignSubscribers.getLatitude();
	}

	/**
	* Sets the latitude of this s p mail campaign subscribers.
	*
	* @param latitude the latitude of this s p mail campaign subscribers
	*/
	@Override
	public void setLatitude(java.lang.String latitude) {
		_spMailCampaignSubscribers.setLatitude(latitude);
	}

	/**
	* Returns the longitude of this s p mail campaign subscribers.
	*
	* @return the longitude of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getLongitude() {
		return _spMailCampaignSubscribers.getLongitude();
	}

	/**
	* Sets the longitude of this s p mail campaign subscribers.
	*
	* @param longitude the longitude of this s p mail campaign subscribers
	*/
	@Override
	public void setLongitude(java.lang.String longitude) {
		_spMailCampaignSubscribers.setLongitude(longitude);
	}

	/**
	* Returns the ip address of this s p mail campaign subscribers.
	*
	* @return the ip address of this s p mail campaign subscribers
	*/
	@Override
	public java.lang.String getIpAddress() {
		return _spMailCampaignSubscribers.getIpAddress();
	}

	/**
	* Sets the ip address of this s p mail campaign subscribers.
	*
	* @param ipAddress the ip address of this s p mail campaign subscribers
	*/
	@Override
	public void setIpAddress(java.lang.String ipAddress) {
		_spMailCampaignSubscribers.setIpAddress(ipAddress);
	}

	/**
	* Returns the web version of this s p mail campaign subscribers.
	*
	* @return the web version of this s p mail campaign subscribers
	*/
	@Override
	public boolean getWebVersion() {
		return _spMailCampaignSubscribers.getWebVersion();
	}

	/**
	* Returns <code>true</code> if this s p mail campaign subscribers is web version.
	*
	* @return <code>true</code> if this s p mail campaign subscribers is web version; <code>false</code> otherwise
	*/
	@Override
	public boolean isWebVersion() {
		return _spMailCampaignSubscribers.isWebVersion();
	}

	/**
	* Sets whether this s p mail campaign subscribers is web version.
	*
	* @param webVersion the web version of this s p mail campaign subscribers
	*/
	@Override
	public void setWebVersion(boolean webVersion) {
		_spMailCampaignSubscribers.setWebVersion(webVersion);
	}

	/**
	* Returns the opened date of this s p mail campaign subscribers.
	*
	* @return the opened date of this s p mail campaign subscribers
	*/
	@Override
	public java.util.Date getOpenedDate() {
		return _spMailCampaignSubscribers.getOpenedDate();
	}

	/**
	* Sets the opened date of this s p mail campaign subscribers.
	*
	* @param openedDate the opened date of this s p mail campaign subscribers
	*/
	@Override
	public void setOpenedDate(java.util.Date openedDate) {
		_spMailCampaignSubscribers.setOpenedDate(openedDate);
	}

	/**
	* Returns the create by of this s p mail campaign subscribers.
	*
	* @return the create by of this s p mail campaign subscribers
	*/
	@Override
	public long getCreateBy() {
		return _spMailCampaignSubscribers.getCreateBy();
	}

	/**
	* Sets the create by of this s p mail campaign subscribers.
	*
	* @param createBy the create by of this s p mail campaign subscribers
	*/
	@Override
	public void setCreateBy(long createBy) {
		_spMailCampaignSubscribers.setCreateBy(createBy);
	}

	/**
	* Returns the create date of this s p mail campaign subscribers.
	*
	* @return the create date of this s p mail campaign subscribers
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spMailCampaignSubscribers.getCreateDate();
	}

	/**
	* Sets the create date of this s p mail campaign subscribers.
	*
	* @param createDate the create date of this s p mail campaign subscribers
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spMailCampaignSubscribers.setCreateDate(createDate);
	}

	/**
	* Returns the modified by of this s p mail campaign subscribers.
	*
	* @return the modified by of this s p mail campaign subscribers
	*/
	@Override
	public long getModifiedBy() {
		return _spMailCampaignSubscribers.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p mail campaign subscribers.
	*
	* @param modifiedBy the modified by of this s p mail campaign subscribers
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_spMailCampaignSubscribers.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the modified date of this s p mail campaign subscribers.
	*
	* @return the modified date of this s p mail campaign subscribers
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spMailCampaignSubscribers.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p mail campaign subscribers.
	*
	* @param modifiedDate the modified date of this s p mail campaign subscribers
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spMailCampaignSubscribers.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the status of this s p mail campaign subscribers.
	*
	* @return the status of this s p mail campaign subscribers
	*/
	@Override
	public int getStatus() {
		return _spMailCampaignSubscribers.getStatus();
	}

	/**
	* Sets the status of this s p mail campaign subscribers.
	*
	* @param status the status of this s p mail campaign subscribers
	*/
	@Override
	public void setStatus(int status) {
		_spMailCampaignSubscribers.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _spMailCampaignSubscribers.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spMailCampaignSubscribers.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spMailCampaignSubscribers.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spMailCampaignSubscribers.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spMailCampaignSubscribers.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spMailCampaignSubscribers.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spMailCampaignSubscribers.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spMailCampaignSubscribers.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spMailCampaignSubscribers.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spMailCampaignSubscribers.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spMailCampaignSubscribers.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPMailCampaignSubscribersWrapper((SPMailCampaignSubscribers)_spMailCampaignSubscribers.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers spMailCampaignSubscribers) {
		return _spMailCampaignSubscribers.compareTo(spMailCampaignSubscribers);
	}

	@Override
	public int hashCode() {
		return _spMailCampaignSubscribers.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers> toCacheModel() {
		return _spMailCampaignSubscribers.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers toEscapedModel() {
		return new SPMailCampaignSubscribersWrapper(_spMailCampaignSubscribers.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.mail.model.SPMailCampaignSubscribers toUnescapedModel() {
		return new SPMailCampaignSubscribersWrapper(_spMailCampaignSubscribers.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spMailCampaignSubscribers.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spMailCampaignSubscribers.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spMailCampaignSubscribers.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPMailCampaignSubscribersWrapper)) {
			return false;
		}

		SPMailCampaignSubscribersWrapper spMailCampaignSubscribersWrapper = (SPMailCampaignSubscribersWrapper)obj;

		if (Validator.equals(_spMailCampaignSubscribers,
					spMailCampaignSubscribersWrapper._spMailCampaignSubscribers)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPMailCampaignSubscribers getWrappedSPMailCampaignSubscribers() {
		return _spMailCampaignSubscribers;
	}

	@Override
	public SPMailCampaignSubscribers getWrappedModel() {
		return _spMailCampaignSubscribers;
	}

	@Override
	public void resetOriginalValues() {
		_spMailCampaignSubscribers.resetOriginalValues();
	}

	private SPMailCampaignSubscribers _spMailCampaignSubscribers;
}