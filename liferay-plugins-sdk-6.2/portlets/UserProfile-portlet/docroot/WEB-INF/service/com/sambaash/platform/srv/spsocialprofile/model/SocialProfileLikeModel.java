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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SocialProfileLike service. Represents a row in the &quot;SPSocialProfileLike&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfileLike
 * @see com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeImpl
 * @see com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileLikeModelImpl
 * @generated
 */
public interface SocialProfileLikeModel extends BaseModel<SocialProfileLike> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a social profile like model instance should use the {@link SocialProfileLike} interface instead.
	 */

	/**
	 * Returns the primary key of this social profile like.
	 *
	 * @return the primary key of this social profile like
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this social profile like.
	 *
	 * @param primaryKey the primary key of this social profile like
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the social profile like ID of this social profile like.
	 *
	 * @return the social profile like ID of this social profile like
	 */
	public long getSocialProfileLikeId();

	/**
	 * Sets the social profile like ID of this social profile like.
	 *
	 * @param socialProfileLikeId the social profile like ID of this social profile like
	 */
	public void setSocialProfileLikeId(long socialProfileLikeId);

	/**
	 * Returns the social network profile ID of this social profile like.
	 *
	 * @return the social network profile ID of this social profile like
	 */
	public long getSocialNetworkProfileId();

	/**
	 * Sets the social network profile ID of this social profile like.
	 *
	 * @param socialNetworkProfileId the social network profile ID of this social profile like
	 */
	public void setSocialNetworkProfileId(long socialNetworkProfileId);

	/**
	 * Returns the name of this social profile like.
	 *
	 * @return the name of this social profile like
	 */
	@AutoEscape
	public String getName();

	/**
	 * Sets the name of this social profile like.
	 *
	 * @param name the name of this social profile like
	 */
	public void setName(String name);

	/**
	 * Returns the category of this social profile like.
	 *
	 * @return the category of this social profile like
	 */
	@AutoEscape
	public String getCategory();

	/**
	 * Sets the category of this social profile like.
	 *
	 * @param category the category of this social profile like
	 */
	public void setCategory(String category);

	/**
	 * Returns the social network like ID of this social profile like.
	 *
	 * @return the social network like ID of this social profile like
	 */
	public long getSocialNetworkLikeId();

	/**
	 * Sets the social network like ID of this social profile like.
	 *
	 * @param socialNetworkLikeId the social network like ID of this social profile like
	 */
	public void setSocialNetworkLikeId(long socialNetworkLikeId);

	/**
	 * Returns the social network type of this social profile like.
	 *
	 * @return the social network type of this social profile like
	 */
	public int getSocialNetworkType();

	/**
	 * Sets the social network type of this social profile like.
	 *
	 * @param socialNetworkType the social network type of this social profile like
	 */
	public void setSocialNetworkType(int socialNetworkType);

	/**
	 * Returns the social network create date of this social profile like.
	 *
	 * @return the social network create date of this social profile like
	 */
	public Date getSocialNetworkCreateDate();

	/**
	 * Sets the social network create date of this social profile like.
	 *
	 * @param socialNetworkCreateDate the social network create date of this social profile like
	 */
	public void setSocialNetworkCreateDate(Date socialNetworkCreateDate);

	/**
	 * Returns the create date of this social profile like.
	 *
	 * @return the create date of this social profile like
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this social profile like.
	 *
	 * @param createDate the create date of this social profile like
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this social profile like.
	 *
	 * @return the modified date of this social profile like
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this social profile like.
	 *
	 * @param modifiedDate the modified date of this social profile like
	 */
	public void setModifiedDate(Date modifiedDate);

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
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike socialProfileLike);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfileLike toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}