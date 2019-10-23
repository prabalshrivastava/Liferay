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

package com.sambaash.platform.srv.sprating.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RatingAttr}.
 * </p>
 *
 * @author harini
 * @see RatingAttr
 * @generated
 */
public class RatingAttrWrapper implements RatingAttr, ModelWrapper<RatingAttr> {
	public RatingAttrWrapper(RatingAttr ratingAttr) {
		_ratingAttr = ratingAttr;
	}

	@Override
	public Class<?> getModelClass() {
		return RatingAttr.class;
	}

	@Override
	public String getModelClassName() {
		return RatingAttr.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spRatingAttrId", getSpRatingAttrId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("ratingComponentId", getRatingComponentId());
		attributes.put("name", getName());
		attributes.put("weight", getWeight());
		attributes.put("visible", getVisible());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spRatingAttrId = (Long)attributes.get("spRatingAttrId");

		if (spRatingAttrId != null) {
			setSpRatingAttrId(spRatingAttrId);
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

		Long ratingComponentId = (Long)attributes.get("ratingComponentId");

		if (ratingComponentId != null) {
			setRatingComponentId(ratingComponentId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Double weight = (Double)attributes.get("weight");

		if (weight != null) {
			setWeight(weight);
		}

		Boolean visible = (Boolean)attributes.get("visible");

		if (visible != null) {
			setVisible(visible);
		}
	}

	/**
	* Returns the primary key of this rating attr.
	*
	* @return the primary key of this rating attr
	*/
	@Override
	public long getPrimaryKey() {
		return _ratingAttr.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rating attr.
	*
	* @param primaryKey the primary key of this rating attr
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ratingAttr.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rating attr.
	*
	* @return the uuid of this rating attr
	*/
	@Override
	public java.lang.String getUuid() {
		return _ratingAttr.getUuid();
	}

	/**
	* Sets the uuid of this rating attr.
	*
	* @param uuid the uuid of this rating attr
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_ratingAttr.setUuid(uuid);
	}

	/**
	* Returns the sp rating attr ID of this rating attr.
	*
	* @return the sp rating attr ID of this rating attr
	*/
	@Override
	public long getSpRatingAttrId() {
		return _ratingAttr.getSpRatingAttrId();
	}

	/**
	* Sets the sp rating attr ID of this rating attr.
	*
	* @param spRatingAttrId the sp rating attr ID of this rating attr
	*/
	@Override
	public void setSpRatingAttrId(long spRatingAttrId) {
		_ratingAttr.setSpRatingAttrId(spRatingAttrId);
	}

	/**
	* Returns the group ID of this rating attr.
	*
	* @return the group ID of this rating attr
	*/
	@Override
	public long getGroupId() {
		return _ratingAttr.getGroupId();
	}

	/**
	* Sets the group ID of this rating attr.
	*
	* @param groupId the group ID of this rating attr
	*/
	@Override
	public void setGroupId(long groupId) {
		_ratingAttr.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rating attr.
	*
	* @return the company ID of this rating attr
	*/
	@Override
	public long getCompanyId() {
		return _ratingAttr.getCompanyId();
	}

	/**
	* Sets the company ID of this rating attr.
	*
	* @param companyId the company ID of this rating attr
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ratingAttr.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rating attr.
	*
	* @return the user ID of this rating attr
	*/
	@Override
	public long getUserId() {
		return _ratingAttr.getUserId();
	}

	/**
	* Sets the user ID of this rating attr.
	*
	* @param userId the user ID of this rating attr
	*/
	@Override
	public void setUserId(long userId) {
		_ratingAttr.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rating attr.
	*
	* @return the user uuid of this rating attr
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingAttr.getUserUuid();
	}

	/**
	* Sets the user uuid of this rating attr.
	*
	* @param userUuid the user uuid of this rating attr
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_ratingAttr.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rating attr.
	*
	* @return the user name of this rating attr
	*/
	@Override
	public java.lang.String getUserName() {
		return _ratingAttr.getUserName();
	}

	/**
	* Sets the user name of this rating attr.
	*
	* @param userName the user name of this rating attr
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_ratingAttr.setUserName(userName);
	}

	/**
	* Returns the create date of this rating attr.
	*
	* @return the create date of this rating attr
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _ratingAttr.getCreateDate();
	}

	/**
	* Sets the create date of this rating attr.
	*
	* @param createDate the create date of this rating attr
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_ratingAttr.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rating attr.
	*
	* @return the modified date of this rating attr
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _ratingAttr.getModifiedDate();
	}

	/**
	* Sets the modified date of this rating attr.
	*
	* @param modifiedDate the modified date of this rating attr
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ratingAttr.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the rating component ID of this rating attr.
	*
	* @return the rating component ID of this rating attr
	*/
	@Override
	public long getRatingComponentId() {
		return _ratingAttr.getRatingComponentId();
	}

	/**
	* Sets the rating component ID of this rating attr.
	*
	* @param ratingComponentId the rating component ID of this rating attr
	*/
	@Override
	public void setRatingComponentId(long ratingComponentId) {
		_ratingAttr.setRatingComponentId(ratingComponentId);
	}

	/**
	* Returns the name of this rating attr.
	*
	* @return the name of this rating attr
	*/
	@Override
	public java.lang.String getName() {
		return _ratingAttr.getName();
	}

	/**
	* Sets the name of this rating attr.
	*
	* @param name the name of this rating attr
	*/
	@Override
	public void setName(java.lang.String name) {
		_ratingAttr.setName(name);
	}

	/**
	* Returns the weight of this rating attr.
	*
	* @return the weight of this rating attr
	*/
	@Override
	public double getWeight() {
		return _ratingAttr.getWeight();
	}

	/**
	* Sets the weight of this rating attr.
	*
	* @param weight the weight of this rating attr
	*/
	@Override
	public void setWeight(double weight) {
		_ratingAttr.setWeight(weight);
	}

	/**
	* Returns the visible of this rating attr.
	*
	* @return the visible of this rating attr
	*/
	@Override
	public boolean getVisible() {
		return _ratingAttr.getVisible();
	}

	/**
	* Returns <code>true</code> if this rating attr is visible.
	*
	* @return <code>true</code> if this rating attr is visible; <code>false</code> otherwise
	*/
	@Override
	public boolean isVisible() {
		return _ratingAttr.isVisible();
	}

	/**
	* Sets whether this rating attr is visible.
	*
	* @param visible the visible of this rating attr
	*/
	@Override
	public void setVisible(boolean visible) {
		_ratingAttr.setVisible(visible);
	}

	@Override
	public boolean isNew() {
		return _ratingAttr.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ratingAttr.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ratingAttr.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ratingAttr.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ratingAttr.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ratingAttr.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ratingAttr.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ratingAttr.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ratingAttr.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ratingAttr.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ratingAttr.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RatingAttrWrapper((RatingAttr)_ratingAttr.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.sprating.model.RatingAttr ratingAttr) {
		return _ratingAttr.compareTo(ratingAttr);
	}

	@Override
	public int hashCode() {
		return _ratingAttr.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.sprating.model.RatingAttr> toCacheModel() {
		return _ratingAttr.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.sprating.model.RatingAttr toEscapedModel() {
		return new RatingAttrWrapper(_ratingAttr.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.sprating.model.RatingAttr toUnescapedModel() {
		return new RatingAttrWrapper(_ratingAttr.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ratingAttr.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ratingAttr.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ratingAttr.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RatingAttrWrapper)) {
			return false;
		}

		RatingAttrWrapper ratingAttrWrapper = (RatingAttrWrapper)obj;

		if (Validator.equals(_ratingAttr, ratingAttrWrapper._ratingAttr)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _ratingAttr.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RatingAttr getWrappedRatingAttr() {
		return _ratingAttr;
	}

	@Override
	public RatingAttr getWrappedModel() {
		return _ratingAttr;
	}

	@Override
	public void resetOriginalValues() {
		_ratingAttr.resetOriginalValues();
	}

	private RatingAttr _ratingAttr;
}