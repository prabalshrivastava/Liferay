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

package com.sambaash.platform.srv.spsocialprofile.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SocialProfileFriends}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileFriends
 * @generated
 */
public class SocialProfileFriendsWrapper implements SocialProfileFriends,
	ModelWrapper<SocialProfileFriends> {
	public SocialProfileFriendsWrapper(
		SocialProfileFriends socialProfileFriends) {
		_socialProfileFriends = socialProfileFriends;
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfileFriends.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfileFriends.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("socialProfileFriendsId", getSocialProfileFriendsId());
		attributes.put("companyId", getCompanyId());
		attributes.put("belongsToUserId", getBelongsToUserId());
		attributes.put("socialNetworkProfileId", getSocialNetworkProfileId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("birthday", getBirthday());
		attributes.put("location", getLocation());
		attributes.put("pictureUrl", getPictureUrl());
		attributes.put("userName", getUserName());
		attributes.put("gender", getGender());
		attributes.put("socialNetworkType", getSocialNetworkType());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long socialProfileFriendsId = (Long)attributes.get(
				"socialProfileFriendsId");

		if (socialProfileFriendsId != null) {
			setSocialProfileFriendsId(socialProfileFriendsId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long belongsToUserId = (Long)attributes.get("belongsToUserId");

		if (belongsToUserId != null) {
			setBelongsToUserId(belongsToUserId);
		}

		Long socialNetworkProfileId = (Long)attributes.get(
				"socialNetworkProfileId");

		if (socialNetworkProfileId != null) {
			setSocialNetworkProfileId(socialNetworkProfileId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String birthday = (String)attributes.get("birthday");

		if (birthday != null) {
			setBirthday(birthday);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		String pictureUrl = (String)attributes.get("pictureUrl");

		if (pictureUrl != null) {
			setPictureUrl(pictureUrl);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Integer gender = (Integer)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		Integer socialNetworkType = (Integer)attributes.get("socialNetworkType");

		if (socialNetworkType != null) {
			setSocialNetworkType(socialNetworkType);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}
	}

	/**
	* Returns the primary key of this social profile friends.
	*
	* @return the primary key of this social profile friends
	*/
	@Override
	public long getPrimaryKey() {
		return _socialProfileFriends.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social profile friends.
	*
	* @param primaryKey the primary key of this social profile friends
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_socialProfileFriends.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the social profile friends ID of this social profile friends.
	*
	* @return the social profile friends ID of this social profile friends
	*/
	@Override
	public long getSocialProfileFriendsId() {
		return _socialProfileFriends.getSocialProfileFriendsId();
	}

	/**
	* Sets the social profile friends ID of this social profile friends.
	*
	* @param socialProfileFriendsId the social profile friends ID of this social profile friends
	*/
	@Override
	public void setSocialProfileFriendsId(long socialProfileFriendsId) {
		_socialProfileFriends.setSocialProfileFriendsId(socialProfileFriendsId);
	}

	/**
	* Returns the company ID of this social profile friends.
	*
	* @return the company ID of this social profile friends
	*/
	@Override
	public long getCompanyId() {
		return _socialProfileFriends.getCompanyId();
	}

	/**
	* Sets the company ID of this social profile friends.
	*
	* @param companyId the company ID of this social profile friends
	*/
	@Override
	public void setCompanyId(long companyId) {
		_socialProfileFriends.setCompanyId(companyId);
	}

	/**
	* Returns the belongs to user ID of this social profile friends.
	*
	* @return the belongs to user ID of this social profile friends
	*/
	@Override
	public long getBelongsToUserId() {
		return _socialProfileFriends.getBelongsToUserId();
	}

	/**
	* Sets the belongs to user ID of this social profile friends.
	*
	* @param belongsToUserId the belongs to user ID of this social profile friends
	*/
	@Override
	public void setBelongsToUserId(long belongsToUserId) {
		_socialProfileFriends.setBelongsToUserId(belongsToUserId);
	}

	/**
	* Returns the belongs to user uuid of this social profile friends.
	*
	* @return the belongs to user uuid of this social profile friends
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getBelongsToUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfileFriends.getBelongsToUserUuid();
	}

	/**
	* Sets the belongs to user uuid of this social profile friends.
	*
	* @param belongsToUserUuid the belongs to user uuid of this social profile friends
	*/
	@Override
	public void setBelongsToUserUuid(java.lang.String belongsToUserUuid) {
		_socialProfileFriends.setBelongsToUserUuid(belongsToUserUuid);
	}

	/**
	* Returns the social network profile ID of this social profile friends.
	*
	* @return the social network profile ID of this social profile friends
	*/
	@Override
	public long getSocialNetworkProfileId() {
		return _socialProfileFriends.getSocialNetworkProfileId();
	}

	/**
	* Sets the social network profile ID of this social profile friends.
	*
	* @param socialNetworkProfileId the social network profile ID of this social profile friends
	*/
	@Override
	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_socialProfileFriends.setSocialNetworkProfileId(socialNetworkProfileId);
	}

	/**
	* Returns the first name of this social profile friends.
	*
	* @return the first name of this social profile friends
	*/
	@Override
	public java.lang.String getFirstName() {
		return _socialProfileFriends.getFirstName();
	}

	/**
	* Sets the first name of this social profile friends.
	*
	* @param firstName the first name of this social profile friends
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_socialProfileFriends.setFirstName(firstName);
	}

	/**
	* Returns the last name of this social profile friends.
	*
	* @return the last name of this social profile friends
	*/
	@Override
	public java.lang.String getLastName() {
		return _socialProfileFriends.getLastName();
	}

	/**
	* Sets the last name of this social profile friends.
	*
	* @param lastName the last name of this social profile friends
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_socialProfileFriends.setLastName(lastName);
	}

	/**
	* Returns the birthday of this social profile friends.
	*
	* @return the birthday of this social profile friends
	*/
	@Override
	public java.lang.String getBirthday() {
		return _socialProfileFriends.getBirthday();
	}

	/**
	* Sets the birthday of this social profile friends.
	*
	* @param birthday the birthday of this social profile friends
	*/
	@Override
	public void setBirthday(java.lang.String birthday) {
		_socialProfileFriends.setBirthday(birthday);
	}

	/**
	* Returns the location of this social profile friends.
	*
	* @return the location of this social profile friends
	*/
	@Override
	public java.lang.String getLocation() {
		return _socialProfileFriends.getLocation();
	}

	/**
	* Sets the location of this social profile friends.
	*
	* @param location the location of this social profile friends
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_socialProfileFriends.setLocation(location);
	}

	/**
	* Returns the picture url of this social profile friends.
	*
	* @return the picture url of this social profile friends
	*/
	@Override
	public java.lang.String getPictureUrl() {
		return _socialProfileFriends.getPictureUrl();
	}

	/**
	* Sets the picture url of this social profile friends.
	*
	* @param pictureUrl the picture url of this social profile friends
	*/
	@Override
	public void setPictureUrl(java.lang.String pictureUrl) {
		_socialProfileFriends.setPictureUrl(pictureUrl);
	}

	/**
	* Returns the user name of this social profile friends.
	*
	* @return the user name of this social profile friends
	*/
	@Override
	public java.lang.String getUserName() {
		return _socialProfileFriends.getUserName();
	}

	/**
	* Sets the user name of this social profile friends.
	*
	* @param userName the user name of this social profile friends
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_socialProfileFriends.setUserName(userName);
	}

	/**
	* Returns the gender of this social profile friends.
	*
	* @return the gender of this social profile friends
	*/
	@Override
	public int getGender() {
		return _socialProfileFriends.getGender();
	}

	/**
	* Sets the gender of this social profile friends.
	*
	* @param gender the gender of this social profile friends
	*/
	@Override
	public void setGender(int gender) {
		_socialProfileFriends.setGender(gender);
	}

	/**
	* Returns the social network type of this social profile friends.
	*
	* @return the social network type of this social profile friends
	*/
	@Override
	public int getSocialNetworkType() {
		return _socialProfileFriends.getSocialNetworkType();
	}

	/**
	* Sets the social network type of this social profile friends.
	*
	* @param socialNetworkType the social network type of this social profile friends
	*/
	@Override
	public void setSocialNetworkType(int socialNetworkType) {
		_socialProfileFriends.setSocialNetworkType(socialNetworkType);
	}

	/**
	* Returns the create date of this social profile friends.
	*
	* @return the create date of this social profile friends
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _socialProfileFriends.getCreateDate();
	}

	/**
	* Sets the create date of this social profile friends.
	*
	* @param createDate the create date of this social profile friends
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_socialProfileFriends.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this social profile friends.
	*
	* @return the modified date of this social profile friends
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _socialProfileFriends.getModifiedDate();
	}

	/**
	* Sets the modified date of this social profile friends.
	*
	* @param modifiedDate the modified date of this social profile friends
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_socialProfileFriends.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _socialProfileFriends.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_socialProfileFriends.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _socialProfileFriends.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_socialProfileFriends.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _socialProfileFriends.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _socialProfileFriends.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_socialProfileFriends.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialProfileFriends.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_socialProfileFriends.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_socialProfileFriends.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialProfileFriends.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SocialProfileFriendsWrapper((SocialProfileFriends)_socialProfileFriends.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends socialProfileFriends) {
		return _socialProfileFriends.compareTo(socialProfileFriends);
	}

	@Override
	public int hashCode() {
		return _socialProfileFriends.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends> toCacheModel() {
		return _socialProfileFriends.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends toEscapedModel() {
		return new SocialProfileFriendsWrapper(_socialProfileFriends.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileFriends toUnescapedModel() {
		return new SocialProfileFriendsWrapper(_socialProfileFriends.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _socialProfileFriends.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _socialProfileFriends.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileFriends.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialProfileFriendsWrapper)) {
			return false;
		}

		SocialProfileFriendsWrapper socialProfileFriendsWrapper = (SocialProfileFriendsWrapper)obj;

		if (Validator.equals(_socialProfileFriends,
					socialProfileFriendsWrapper._socialProfileFriends)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SocialProfileFriends getWrappedSocialProfileFriends() {
		return _socialProfileFriends;
	}

	@Override
	public SocialProfileFriends getWrappedModel() {
		return _socialProfileFriends;
	}

	@Override
	public void resetOriginalValues() {
		_socialProfileFriends.resetOriginalValues();
	}

	private SocialProfileFriends _socialProfileFriends;
}