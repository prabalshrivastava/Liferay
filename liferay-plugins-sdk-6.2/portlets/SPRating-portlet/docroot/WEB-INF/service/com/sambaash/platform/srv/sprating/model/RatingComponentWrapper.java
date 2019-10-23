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
 * This class is a wrapper for {@link RatingComponent}.
 * </p>
 *
 * @author harini
 * @see RatingComponent
 * @generated
 */
public class RatingComponentWrapper implements RatingComponent,
	ModelWrapper<RatingComponent> {
	public RatingComponentWrapper(RatingComponent ratingComponent) {
		_ratingComponent = ratingComponent;
	}

	@Override
	public Class<?> getModelClass() {
		return RatingComponent.class;
	}

	@Override
	public String getModelClassName() {
		return RatingComponent.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spRatingComponentId", getSpRatingComponentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("classNameId", getClassNameId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spRatingComponentId = (Long)attributes.get("spRatingComponentId");

		if (spRatingComponentId != null) {
			setSpRatingComponentId(spRatingComponentId);
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

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}
	}

	/**
	* Returns the primary key of this rating component.
	*
	* @return the primary key of this rating component
	*/
	@Override
	public long getPrimaryKey() {
		return _ratingComponent.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rating component.
	*
	* @param primaryKey the primary key of this rating component
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_ratingComponent.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rating component.
	*
	* @return the uuid of this rating component
	*/
	@Override
	public java.lang.String getUuid() {
		return _ratingComponent.getUuid();
	}

	/**
	* Sets the uuid of this rating component.
	*
	* @param uuid the uuid of this rating component
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_ratingComponent.setUuid(uuid);
	}

	/**
	* Returns the sp rating component ID of this rating component.
	*
	* @return the sp rating component ID of this rating component
	*/
	@Override
	public long getSpRatingComponentId() {
		return _ratingComponent.getSpRatingComponentId();
	}

	/**
	* Sets the sp rating component ID of this rating component.
	*
	* @param spRatingComponentId the sp rating component ID of this rating component
	*/
	@Override
	public void setSpRatingComponentId(long spRatingComponentId) {
		_ratingComponent.setSpRatingComponentId(spRatingComponentId);
	}

	/**
	* Returns the group ID of this rating component.
	*
	* @return the group ID of this rating component
	*/
	@Override
	public long getGroupId() {
		return _ratingComponent.getGroupId();
	}

	/**
	* Sets the group ID of this rating component.
	*
	* @param groupId the group ID of this rating component
	*/
	@Override
	public void setGroupId(long groupId) {
		_ratingComponent.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rating component.
	*
	* @return the company ID of this rating component
	*/
	@Override
	public long getCompanyId() {
		return _ratingComponent.getCompanyId();
	}

	/**
	* Sets the company ID of this rating component.
	*
	* @param companyId the company ID of this rating component
	*/
	@Override
	public void setCompanyId(long companyId) {
		_ratingComponent.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rating component.
	*
	* @return the user ID of this rating component
	*/
	@Override
	public long getUserId() {
		return _ratingComponent.getUserId();
	}

	/**
	* Sets the user ID of this rating component.
	*
	* @param userId the user ID of this rating component
	*/
	@Override
	public void setUserId(long userId) {
		_ratingComponent.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rating component.
	*
	* @return the user uuid of this rating component
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _ratingComponent.getUserUuid();
	}

	/**
	* Sets the user uuid of this rating component.
	*
	* @param userUuid the user uuid of this rating component
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_ratingComponent.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rating component.
	*
	* @return the user name of this rating component
	*/
	@Override
	public java.lang.String getUserName() {
		return _ratingComponent.getUserName();
	}

	/**
	* Sets the user name of this rating component.
	*
	* @param userName the user name of this rating component
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_ratingComponent.setUserName(userName);
	}

	/**
	* Returns the create date of this rating component.
	*
	* @return the create date of this rating component
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _ratingComponent.getCreateDate();
	}

	/**
	* Sets the create date of this rating component.
	*
	* @param createDate the create date of this rating component
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_ratingComponent.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rating component.
	*
	* @return the modified date of this rating component
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _ratingComponent.getModifiedDate();
	}

	/**
	* Sets the modified date of this rating component.
	*
	* @param modifiedDate the modified date of this rating component
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_ratingComponent.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this rating component.
	*
	* @return the name of this rating component
	*/
	@Override
	public java.lang.String getName() {
		return _ratingComponent.getName();
	}

	/**
	* Sets the name of this rating component.
	*
	* @param name the name of this rating component
	*/
	@Override
	public void setName(java.lang.String name) {
		_ratingComponent.setName(name);
	}

	/**
	* Returns the fully qualified class name of this rating component.
	*
	* @return the fully qualified class name of this rating component
	*/
	@Override
	public java.lang.String getClassName() {
		return _ratingComponent.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_ratingComponent.setClassName(className);
	}

	/**
	* Returns the class name ID of this rating component.
	*
	* @return the class name ID of this rating component
	*/
	@Override
	public long getClassNameId() {
		return _ratingComponent.getClassNameId();
	}

	/**
	* Sets the class name ID of this rating component.
	*
	* @param classNameId the class name ID of this rating component
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_ratingComponent.setClassNameId(classNameId);
	}

	@Override
	public boolean isNew() {
		return _ratingComponent.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_ratingComponent.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _ratingComponent.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_ratingComponent.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _ratingComponent.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _ratingComponent.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_ratingComponent.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _ratingComponent.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_ratingComponent.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_ratingComponent.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_ratingComponent.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RatingComponentWrapper((RatingComponent)_ratingComponent.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.sprating.model.RatingComponent ratingComponent) {
		return _ratingComponent.compareTo(ratingComponent);
	}

	@Override
	public int hashCode() {
		return _ratingComponent.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.sprating.model.RatingComponent> toCacheModel() {
		return _ratingComponent.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent toEscapedModel() {
		return new RatingComponentWrapper(_ratingComponent.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.sprating.model.RatingComponent toUnescapedModel() {
		return new RatingComponentWrapper(_ratingComponent.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _ratingComponent.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _ratingComponent.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_ratingComponent.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RatingComponentWrapper)) {
			return false;
		}

		RatingComponentWrapper ratingComponentWrapper = (RatingComponentWrapper)obj;

		if (Validator.equals(_ratingComponent,
					ratingComponentWrapper._ratingComponent)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _ratingComponent.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RatingComponent getWrappedRatingComponent() {
		return _ratingComponent;
	}

	@Override
	public RatingComponent getWrappedModel() {
		return _ratingComponent;
	}

	@Override
	public void resetOriginalValues() {
		_ratingComponent.resetOriginalValues();
	}

	private RatingComponent _ratingComponent;
}