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

package com.sambaash.platform.srv.spgroup.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPGroup}.
 * </p>
 *
 * @author harini
 * @see SPGroup
 * @generated
 */
public class SPGroupWrapper implements SPGroup, ModelWrapper<SPGroup> {
	public SPGroupWrapper(SPGroup spGroup) {
		_spGroup = spGroup;
	}

	@Override
	public Class<?> getModelClass() {
		return SPGroup.class;
	}

	@Override
	public String getModelClassName() {
		return SPGroup.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spGroupId", getSpGroupId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("title", getTitle());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("description", getDescription());
		attributes.put("imageId", getImageId());
		attributes.put("type", getType());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spGroupId = (Long)attributes.get("spGroupId");

		if (spGroupId != null) {
			setSpGroupId(spGroupId);
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

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String urlTitle = (String)attributes.get("urlTitle");

		if (urlTitle != null) {
			setUrlTitle(urlTitle);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Integer type = (Integer)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this s p group.
	*
	* @return the primary key of this s p group
	*/
	@Override
	public long getPrimaryKey() {
		return _spGroup.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p group.
	*
	* @param primaryKey the primary key of this s p group
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spGroup.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p group.
	*
	* @return the uuid of this s p group
	*/
	@Override
	public java.lang.String getUuid() {
		return _spGroup.getUuid();
	}

	/**
	* Sets the uuid of this s p group.
	*
	* @param uuid the uuid of this s p group
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spGroup.setUuid(uuid);
	}

	/**
	* Returns the sp group ID of this s p group.
	*
	* @return the sp group ID of this s p group
	*/
	@Override
	public long getSpGroupId() {
		return _spGroup.getSpGroupId();
	}

	/**
	* Sets the sp group ID of this s p group.
	*
	* @param spGroupId the sp group ID of this s p group
	*/
	@Override
	public void setSpGroupId(long spGroupId) {
		_spGroup.setSpGroupId(spGroupId);
	}

	/**
	* Returns the group ID of this s p group.
	*
	* @return the group ID of this s p group
	*/
	@Override
	public long getGroupId() {
		return _spGroup.getGroupId();
	}

	/**
	* Sets the group ID of this s p group.
	*
	* @param groupId the group ID of this s p group
	*/
	@Override
	public void setGroupId(long groupId) {
		_spGroup.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p group.
	*
	* @return the company ID of this s p group
	*/
	@Override
	public long getCompanyId() {
		return _spGroup.getCompanyId();
	}

	/**
	* Sets the company ID of this s p group.
	*
	* @param companyId the company ID of this s p group
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spGroup.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p group.
	*
	* @return the user ID of this s p group
	*/
	@Override
	public long getUserId() {
		return _spGroup.getUserId();
	}

	/**
	* Sets the user ID of this s p group.
	*
	* @param userId the user ID of this s p group
	*/
	@Override
	public void setUserId(long userId) {
		_spGroup.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p group.
	*
	* @return the user uuid of this s p group
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroup.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p group.
	*
	* @param userUuid the user uuid of this s p group
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spGroup.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p group.
	*
	* @return the user name of this s p group
	*/
	@Override
	public java.lang.String getUserName() {
		return _spGroup.getUserName();
	}

	/**
	* Sets the user name of this s p group.
	*
	* @param userName the user name of this s p group
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spGroup.setUserName(userName);
	}

	/**
	* Returns the create date of this s p group.
	*
	* @return the create date of this s p group
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spGroup.getCreateDate();
	}

	/**
	* Sets the create date of this s p group.
	*
	* @param createDate the create date of this s p group
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spGroup.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p group.
	*
	* @return the modified date of this s p group
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spGroup.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p group.
	*
	* @param modifiedDate the modified date of this s p group
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spGroup.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the title of this s p group.
	*
	* @return the title of this s p group
	*/
	@Override
	public java.lang.String getTitle() {
		return _spGroup.getTitle();
	}

	/**
	* Sets the title of this s p group.
	*
	* @param title the title of this s p group
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_spGroup.setTitle(title);
	}

	/**
	* Returns the url title of this s p group.
	*
	* @return the url title of this s p group
	*/
	@Override
	public java.lang.String getUrlTitle() {
		return _spGroup.getUrlTitle();
	}

	/**
	* Sets the url title of this s p group.
	*
	* @param urlTitle the url title of this s p group
	*/
	@Override
	public void setUrlTitle(java.lang.String urlTitle) {
		_spGroup.setUrlTitle(urlTitle);
	}

	/**
	* Returns the description of this s p group.
	*
	* @return the description of this s p group
	*/
	@Override
	public java.lang.String getDescription() {
		return _spGroup.getDescription();
	}

	/**
	* Sets the description of this s p group.
	*
	* @param description the description of this s p group
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_spGroup.setDescription(description);
	}

	/**
	* Returns the image ID of this s p group.
	*
	* @return the image ID of this s p group
	*/
	@Override
	public long getImageId() {
		return _spGroup.getImageId();
	}

	/**
	* Sets the image ID of this s p group.
	*
	* @param imageId the image ID of this s p group
	*/
	@Override
	public void setImageId(long imageId) {
		_spGroup.setImageId(imageId);
	}

	/**
	* Returns the type of this s p group.
	*
	* @return the type of this s p group
	*/
	@Override
	public int getType() {
		return _spGroup.getType();
	}

	/**
	* Sets the type of this s p group.
	*
	* @param type the type of this s p group
	*/
	@Override
	public void setType(int type) {
		_spGroup.setType(type);
	}

	/**
	* Returns the status of this s p group.
	*
	* @return the status of this s p group
	*/
	@Override
	public int getStatus() {
		return _spGroup.getStatus();
	}

	/**
	* Sets the status of this s p group.
	*
	* @param status the status of this s p group
	*/
	@Override
	public void setStatus(int status) {
		_spGroup.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _spGroup.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spGroup.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spGroup.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spGroup.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spGroup.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spGroup.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spGroup.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spGroup.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spGroup.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spGroup.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spGroup.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPGroupWrapper((SPGroup)_spGroup.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spgroup.model.SPGroup spGroup) {
		return _spGroup.compareTo(spGroup);
	}

	@Override
	public int hashCode() {
		return _spGroup.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spgroup.model.SPGroup> toCacheModel() {
		return _spGroup.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup toEscapedModel() {
		return new SPGroupWrapper(_spGroup.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroup toUnescapedModel() {
		return new SPGroupWrapper(_spGroup.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spGroup.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spGroup.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spGroup.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPGroupWrapper)) {
			return false;
		}

		SPGroupWrapper spGroupWrapper = (SPGroupWrapper)obj;

		if (Validator.equals(_spGroup, spGroupWrapper._spGroup)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spGroup.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPGroup getWrappedSPGroup() {
		return _spGroup;
	}

	@Override
	public SPGroup getWrappedModel() {
		return _spGroup;
	}

	@Override
	public void resetOriginalValues() {
		_spGroup.resetOriginalValues();
	}

	private SPGroup _spGroup;
}