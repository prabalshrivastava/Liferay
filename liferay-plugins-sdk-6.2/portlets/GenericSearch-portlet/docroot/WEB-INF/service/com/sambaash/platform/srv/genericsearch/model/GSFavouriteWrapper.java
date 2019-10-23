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

package com.sambaash.platform.srv.genericsearch.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GSFavourite}.
 * </p>
 *
 * @author nareshchebolu
 * @see GSFavourite
 * @generated
 */
public class GSFavouriteWrapper implements GSFavourite,
	ModelWrapper<GSFavourite> {
	public GSFavouriteWrapper(GSFavourite gsFavourite) {
		_gsFavourite = gsFavourite;
	}

	@Override
	public Class<?> getModelClass() {
		return GSFavourite.class;
	}

	@Override
	public String getModelClassName() {
		return GSFavourite.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SPGSFavouriteId", getSPGSFavouriteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("layoutId", getLayoutId());
		attributes.put("portletInstanceId", getPortletInstanceId());
		attributes.put("config", getConfig());
		attributes.put("permissionType", getPermissionType());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long SPGSFavouriteId = (Long)attributes.get("SPGSFavouriteId");

		if (SPGSFavouriteId != null) {
			setSPGSFavouriteId(SPGSFavouriteId);
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

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long layoutId = (Long)attributes.get("layoutId");

		if (layoutId != null) {
			setLayoutId(layoutId);
		}

		String portletInstanceId = (String)attributes.get("portletInstanceId");

		if (portletInstanceId != null) {
			setPortletInstanceId(portletInstanceId);
		}

		String config = (String)attributes.get("config");

		if (config != null) {
			setConfig(config);
		}

		Integer permissionType = (Integer)attributes.get("permissionType");

		if (permissionType != null) {
			setPermissionType(permissionType);
		}
	}

	/**
	* Returns the primary key of this g s favourite.
	*
	* @return the primary key of this g s favourite
	*/
	@Override
	public long getPrimaryKey() {
		return _gsFavourite.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g s favourite.
	*
	* @param primaryKey the primary key of this g s favourite
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_gsFavourite.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the s p g s favourite ID of this g s favourite.
	*
	* @return the s p g s favourite ID of this g s favourite
	*/
	@Override
	public long getSPGSFavouriteId() {
		return _gsFavourite.getSPGSFavouriteId();
	}

	/**
	* Sets the s p g s favourite ID of this g s favourite.
	*
	* @param SPGSFavouriteId the s p g s favourite ID of this g s favourite
	*/
	@Override
	public void setSPGSFavouriteId(long SPGSFavouriteId) {
		_gsFavourite.setSPGSFavouriteId(SPGSFavouriteId);
	}

	/**
	* Returns the group ID of this g s favourite.
	*
	* @return the group ID of this g s favourite
	*/
	@Override
	public long getGroupId() {
		return _gsFavourite.getGroupId();
	}

	/**
	* Sets the group ID of this g s favourite.
	*
	* @param groupId the group ID of this g s favourite
	*/
	@Override
	public void setGroupId(long groupId) {
		_gsFavourite.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this g s favourite.
	*
	* @return the company ID of this g s favourite
	*/
	@Override
	public long getCompanyId() {
		return _gsFavourite.getCompanyId();
	}

	/**
	* Sets the company ID of this g s favourite.
	*
	* @param companyId the company ID of this g s favourite
	*/
	@Override
	public void setCompanyId(long companyId) {
		_gsFavourite.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this g s favourite.
	*
	* @return the user ID of this g s favourite
	*/
	@Override
	public long getUserId() {
		return _gsFavourite.getUserId();
	}

	/**
	* Sets the user ID of this g s favourite.
	*
	* @param userId the user ID of this g s favourite
	*/
	@Override
	public void setUserId(long userId) {
		_gsFavourite.setUserId(userId);
	}

	/**
	* Returns the user uuid of this g s favourite.
	*
	* @return the user uuid of this g s favourite
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _gsFavourite.getUserUuid();
	}

	/**
	* Sets the user uuid of this g s favourite.
	*
	* @param userUuid the user uuid of this g s favourite
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_gsFavourite.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this g s favourite.
	*
	* @return the user name of this g s favourite
	*/
	@Override
	public java.lang.String getUserName() {
		return _gsFavourite.getUserName();
	}

	/**
	* Sets the user name of this g s favourite.
	*
	* @param userName the user name of this g s favourite
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_gsFavourite.setUserName(userName);
	}

	/**
	* Returns the create date of this g s favourite.
	*
	* @return the create date of this g s favourite
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _gsFavourite.getCreateDate();
	}

	/**
	* Sets the create date of this g s favourite.
	*
	* @param createDate the create date of this g s favourite
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_gsFavourite.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this g s favourite.
	*
	* @return the modified date of this g s favourite
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _gsFavourite.getModifiedDate();
	}

	/**
	* Sets the modified date of this g s favourite.
	*
	* @param modifiedDate the modified date of this g s favourite
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_gsFavourite.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the name of this g s favourite.
	*
	* @return the name of this g s favourite
	*/
	@Override
	public java.lang.String getName() {
		return _gsFavourite.getName();
	}

	/**
	* Sets the name of this g s favourite.
	*
	* @param name the name of this g s favourite
	*/
	@Override
	public void setName(java.lang.String name) {
		_gsFavourite.setName(name);
	}

	/**
	* Returns the created by of this g s favourite.
	*
	* @return the created by of this g s favourite
	*/
	@Override
	public long getCreatedBy() {
		return _gsFavourite.getCreatedBy();
	}

	/**
	* Sets the created by of this g s favourite.
	*
	* @param createdBy the created by of this g s favourite
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_gsFavourite.setCreatedBy(createdBy);
	}

	/**
	* Returns the layout ID of this g s favourite.
	*
	* @return the layout ID of this g s favourite
	*/
	@Override
	public long getLayoutId() {
		return _gsFavourite.getLayoutId();
	}

	/**
	* Sets the layout ID of this g s favourite.
	*
	* @param layoutId the layout ID of this g s favourite
	*/
	@Override
	public void setLayoutId(long layoutId) {
		_gsFavourite.setLayoutId(layoutId);
	}

	/**
	* Returns the portlet instance ID of this g s favourite.
	*
	* @return the portlet instance ID of this g s favourite
	*/
	@Override
	public java.lang.String getPortletInstanceId() {
		return _gsFavourite.getPortletInstanceId();
	}

	/**
	* Sets the portlet instance ID of this g s favourite.
	*
	* @param portletInstanceId the portlet instance ID of this g s favourite
	*/
	@Override
	public void setPortletInstanceId(java.lang.String portletInstanceId) {
		_gsFavourite.setPortletInstanceId(portletInstanceId);
	}

	/**
	* Returns the config of this g s favourite.
	*
	* @return the config of this g s favourite
	*/
	@Override
	public java.lang.String getConfig() {
		return _gsFavourite.getConfig();
	}

	/**
	* Sets the config of this g s favourite.
	*
	* @param config the config of this g s favourite
	*/
	@Override
	public void setConfig(java.lang.String config) {
		_gsFavourite.setConfig(config);
	}

	/**
	* Returns the permission type of this g s favourite.
	*
	* @return the permission type of this g s favourite
	*/
	@Override
	public int getPermissionType() {
		return _gsFavourite.getPermissionType();
	}

	/**
	* Sets the permission type of this g s favourite.
	*
	* @param permissionType the permission type of this g s favourite
	*/
	@Override
	public void setPermissionType(int permissionType) {
		_gsFavourite.setPermissionType(permissionType);
	}

	@Override
	public boolean isNew() {
		return _gsFavourite.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_gsFavourite.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _gsFavourite.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_gsFavourite.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _gsFavourite.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _gsFavourite.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_gsFavourite.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _gsFavourite.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_gsFavourite.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_gsFavourite.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_gsFavourite.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GSFavouriteWrapper((GSFavourite)_gsFavourite.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.genericsearch.model.GSFavourite gsFavourite) {
		return _gsFavourite.compareTo(gsFavourite);
	}

	@Override
	public int hashCode() {
		return _gsFavourite.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.genericsearch.model.GSFavourite> toCacheModel() {
		return _gsFavourite.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite toEscapedModel() {
		return new GSFavouriteWrapper(_gsFavourite.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.genericsearch.model.GSFavourite toUnescapedModel() {
		return new GSFavouriteWrapper(_gsFavourite.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _gsFavourite.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _gsFavourite.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_gsFavourite.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GSFavouriteWrapper)) {
			return false;
		}

		GSFavouriteWrapper gsFavouriteWrapper = (GSFavouriteWrapper)obj;

		if (Validator.equals(_gsFavourite, gsFavouriteWrapper._gsFavourite)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GSFavourite getWrappedGSFavourite() {
		return _gsFavourite;
	}

	@Override
	public GSFavourite getWrappedModel() {
		return _gsFavourite;
	}

	@Override
	public void resetOriginalValues() {
		_gsFavourite.resetOriginalValues();
	}

	private GSFavourite _gsFavourite;
}