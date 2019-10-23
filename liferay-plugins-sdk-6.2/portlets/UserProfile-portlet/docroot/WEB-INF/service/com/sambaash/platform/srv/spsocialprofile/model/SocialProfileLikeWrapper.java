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
 * This class is a wrapper for {@link SocialProfileLike}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileLike
 * @generated
 */
public class SocialProfileLikeWrapper implements SocialProfileLike,
	ModelWrapper<SocialProfileLike> {
	public SocialProfileLikeWrapper(SocialProfileLike socialProfileLike) {
		_socialProfileLike = socialProfileLike;
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfileLike.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfileLike.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("socialProfileLikeId", getSocialProfileLikeId());
		attributes.put("socialNetworkProfileId", getSocialNetworkProfileId());
		attributes.put("name", getName());
		attributes.put("category", getCategory());
		attributes.put("socialNetworkLikeId", getSocialNetworkLikeId());
		attributes.put("socialNetworkType", getSocialNetworkType());
		attributes.put("socialNetworkCreateDate", getSocialNetworkCreateDate());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long socialProfileLikeId = (Long)attributes.get("socialProfileLikeId");

		if (socialProfileLikeId != null) {
			setSocialProfileLikeId(socialProfileLikeId);
		}

		Long socialNetworkProfileId = (Long)attributes.get(
				"socialNetworkProfileId");

		if (socialNetworkProfileId != null) {
			setSocialNetworkProfileId(socialNetworkProfileId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		Long socialNetworkLikeId = (Long)attributes.get("socialNetworkLikeId");

		if (socialNetworkLikeId != null) {
			setSocialNetworkLikeId(socialNetworkLikeId);
		}

		Integer socialNetworkType = (Integer)attributes.get("socialNetworkType");

		if (socialNetworkType != null) {
			setSocialNetworkType(socialNetworkType);
		}

		Date socialNetworkCreateDate = (Date)attributes.get(
				"socialNetworkCreateDate");

		if (socialNetworkCreateDate != null) {
			setSocialNetworkCreateDate(socialNetworkCreateDate);
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
	* Returns the primary key of this social profile like.
	*
	* @return the primary key of this social profile like
	*/
	@Override
	public long getPrimaryKey() {
		return _socialProfileLike.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social profile like.
	*
	* @param primaryKey the primary key of this social profile like
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_socialProfileLike.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the social profile like ID of this social profile like.
	*
	* @return the social profile like ID of this social profile like
	*/
	@Override
	public long getSocialProfileLikeId() {
		return _socialProfileLike.getSocialProfileLikeId();
	}

	/**
	* Sets the social profile like ID of this social profile like.
	*
	* @param socialProfileLikeId the social profile like ID of this social profile like
	*/
	@Override
	public void setSocialProfileLikeId(long socialProfileLikeId) {
		_socialProfileLike.setSocialProfileLikeId(socialProfileLikeId);
	}

	/**
	* Returns the social network profile ID of this social profile like.
	*
	* @return the social network profile ID of this social profile like
	*/
	@Override
	public long getSocialNetworkProfileId() {
		return _socialProfileLike.getSocialNetworkProfileId();
	}

	/**
	* Sets the social network profile ID of this social profile like.
	*
	* @param socialNetworkProfileId the social network profile ID of this social profile like
	*/
	@Override
	public void setSocialNetworkProfileId(long socialNetworkProfileId) {
		_socialProfileLike.setSocialNetworkProfileId(socialNetworkProfileId);
	}

	/**
	* Returns the name of this social profile like.
	*
	* @return the name of this social profile like
	*/
	@Override
	public java.lang.String getName() {
		return _socialProfileLike.getName();
	}

	/**
	* Sets the name of this social profile like.
	*
	* @param name the name of this social profile like
	*/
	@Override
	public void setName(java.lang.String name) {
		_socialProfileLike.setName(name);
	}

	/**
	* Returns the category of this social profile like.
	*
	* @return the category of this social profile like
	*/
	@Override
	public java.lang.String getCategory() {
		return _socialProfileLike.getCategory();
	}

	/**
	* Sets the category of this social profile like.
	*
	* @param category the category of this social profile like
	*/
	@Override
	public void setCategory(java.lang.String category) {
		_socialProfileLike.setCategory(category);
	}

	/**
	* Returns the social network like ID of this social profile like.
	*
	* @return the social network like ID of this social profile like
	*/
	@Override
	public long getSocialNetworkLikeId() {
		return _socialProfileLike.getSocialNetworkLikeId();
	}

	/**
	* Sets the social network like ID of this social profile like.
	*
	* @param socialNetworkLikeId the social network like ID of this social profile like
	*/
	@Override
	public void setSocialNetworkLikeId(long socialNetworkLikeId) {
		_socialProfileLike.setSocialNetworkLikeId(socialNetworkLikeId);
	}

	/**
	* Returns the social network type of this social profile like.
	*
	* @return the social network type of this social profile like
	*/
	@Override
	public int getSocialNetworkType() {
		return _socialProfileLike.getSocialNetworkType();
	}

	/**
	* Sets the social network type of this social profile like.
	*
	* @param socialNetworkType the social network type of this social profile like
	*/
	@Override
	public void setSocialNetworkType(int socialNetworkType) {
		_socialProfileLike.setSocialNetworkType(socialNetworkType);
	}

	/**
	* Returns the social network create date of this social profile like.
	*
	* @return the social network create date of this social profile like
	*/
	@Override
	public java.util.Date getSocialNetworkCreateDate() {
		return _socialProfileLike.getSocialNetworkCreateDate();
	}

	/**
	* Sets the social network create date of this social profile like.
	*
	* @param socialNetworkCreateDate the social network create date of this social profile like
	*/
	@Override
	public void setSocialNetworkCreateDate(
		java.util.Date socialNetworkCreateDate) {
		_socialProfileLike.setSocialNetworkCreateDate(socialNetworkCreateDate);
	}

	/**
	* Returns the create date of this social profile like.
	*
	* @return the create date of this social profile like
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _socialProfileLike.getCreateDate();
	}

	/**
	* Sets the create date of this social profile like.
	*
	* @param createDate the create date of this social profile like
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_socialProfileLike.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this social profile like.
	*
	* @return the modified date of this social profile like
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _socialProfileLike.getModifiedDate();
	}

	/**
	* Sets the modified date of this social profile like.
	*
	* @param modifiedDate the modified date of this social profile like
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_socialProfileLike.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _socialProfileLike.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_socialProfileLike.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _socialProfileLike.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_socialProfileLike.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _socialProfileLike.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _socialProfileLike.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_socialProfileLike.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialProfileLike.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_socialProfileLike.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_socialProfileLike.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialProfileLike.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SocialProfileLikeWrapper((SocialProfileLike)_socialProfileLike.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike) {
		return _socialProfileLike.compareTo(socialProfileLike);
	}

	@Override
	public int hashCode() {
		return _socialProfileLike.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> toCacheModel() {
		return _socialProfileLike.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike toEscapedModel() {
		return new SocialProfileLikeWrapper(_socialProfileLike.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike toUnescapedModel() {
		return new SocialProfileLikeWrapper(_socialProfileLike.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _socialProfileLike.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _socialProfileLike.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfileLike.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialProfileLikeWrapper)) {
			return false;
		}

		SocialProfileLikeWrapper socialProfileLikeWrapper = (SocialProfileLikeWrapper)obj;

		if (Validator.equals(_socialProfileLike,
					socialProfileLikeWrapper._socialProfileLike)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SocialProfileLike getWrappedSocialProfileLike() {
		return _socialProfileLike;
	}

	@Override
	public SocialProfileLike getWrappedModel() {
		return _socialProfileLike;
	}

	@Override
	public void resetOriginalValues() {
		_socialProfileLike.resetOriginalValues();
	}

	private SocialProfileLike _socialProfileLike;
}