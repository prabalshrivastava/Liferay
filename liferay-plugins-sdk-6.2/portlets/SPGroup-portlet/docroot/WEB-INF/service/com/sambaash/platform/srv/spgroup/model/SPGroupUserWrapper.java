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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPGroupUser}.
 * </p>
 *
 * @author harini
 * @see SPGroupUser
 * @generated
 */
public class SPGroupUserWrapper implements SPGroupUser,
	ModelWrapper<SPGroupUser> {
	public SPGroupUserWrapper(SPGroupUser spGroupUser) {
		_spGroupUser = spGroupUser;
	}

	@Override
	public Class<?> getModelClass() {
		return SPGroupUser.class;
	}

	@Override
	public String getModelClassName() {
		return SPGroupUser.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spGroupId", getSpGroupId());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("joinDate", getJoinDate());
		attributes.put("role", getRole());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spGroupId = (Long)attributes.get("spGroupId");

		if (spGroupId != null) {
			setSpGroupId(spGroupId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Date joinDate = (Date)attributes.get("joinDate");

		if (joinDate != null) {
			setJoinDate(joinDate);
		}

		Integer role = (Integer)attributes.get("role");

		if (role != null) {
			setRole(role);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this s p group user.
	*
	* @return the primary key of this s p group user
	*/
	@Override
	public com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK getPrimaryKey() {
		return _spGroupUser.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p group user.
	*
	* @param primaryKey the primary key of this s p group user
	*/
	@Override
	public void setPrimaryKey(
		com.sambaash.platform.srv.spgroup.service.persistence.SPGroupUserPK primaryKey) {
		_spGroupUser.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp group ID of this s p group user.
	*
	* @return the sp group ID of this s p group user
	*/
	@Override
	public long getSpGroupId() {
		return _spGroupUser.getSpGroupId();
	}

	/**
	* Sets the sp group ID of this s p group user.
	*
	* @param spGroupId the sp group ID of this s p group user
	*/
	@Override
	public void setSpGroupId(long spGroupId) {
		_spGroupUser.setSpGroupId(spGroupId);
	}

	/**
	* Returns the user ID of this s p group user.
	*
	* @return the user ID of this s p group user
	*/
	@Override
	public long getUserId() {
		return _spGroupUser.getUserId();
	}

	/**
	* Sets the user ID of this s p group user.
	*
	* @param userId the user ID of this s p group user
	*/
	@Override
	public void setUserId(long userId) {
		_spGroupUser.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p group user.
	*
	* @return the user uuid of this s p group user
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spGroupUser.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p group user.
	*
	* @param userUuid the user uuid of this s p group user
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spGroupUser.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this s p group user.
	*
	* @return the group ID of this s p group user
	*/
	@Override
	public long getGroupId() {
		return _spGroupUser.getGroupId();
	}

	/**
	* Sets the group ID of this s p group user.
	*
	* @param groupId the group ID of this s p group user
	*/
	@Override
	public void setGroupId(long groupId) {
		_spGroupUser.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p group user.
	*
	* @return the company ID of this s p group user
	*/
	@Override
	public long getCompanyId() {
		return _spGroupUser.getCompanyId();
	}

	/**
	* Sets the company ID of this s p group user.
	*
	* @param companyId the company ID of this s p group user
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spGroupUser.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this s p group user.
	*
	* @return the user name of this s p group user
	*/
	@Override
	public java.lang.String getUserName() {
		return _spGroupUser.getUserName();
	}

	/**
	* Sets the user name of this s p group user.
	*
	* @param userName the user name of this s p group user
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spGroupUser.setUserName(userName);
	}

	/**
	* Returns the create date of this s p group user.
	*
	* @return the create date of this s p group user
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spGroupUser.getCreateDate();
	}

	/**
	* Sets the create date of this s p group user.
	*
	* @param createDate the create date of this s p group user
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spGroupUser.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p group user.
	*
	* @return the modified date of this s p group user
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spGroupUser.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p group user.
	*
	* @param modifiedDate the modified date of this s p group user
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spGroupUser.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the join date of this s p group user.
	*
	* @return the join date of this s p group user
	*/
	@Override
	public java.util.Date getJoinDate() {
		return _spGroupUser.getJoinDate();
	}

	/**
	* Sets the join date of this s p group user.
	*
	* @param joinDate the join date of this s p group user
	*/
	@Override
	public void setJoinDate(java.util.Date joinDate) {
		_spGroupUser.setJoinDate(joinDate);
	}

	/**
	* Returns the role of this s p group user.
	*
	* @return the role of this s p group user
	*/
	@Override
	public int getRole() {
		return _spGroupUser.getRole();
	}

	/**
	* Sets the role of this s p group user.
	*
	* @param role the role of this s p group user
	*/
	@Override
	public void setRole(int role) {
		_spGroupUser.setRole(role);
	}

	/**
	* Returns the status of this s p group user.
	*
	* @return the status of this s p group user
	*/
	@Override
	public int getStatus() {
		return _spGroupUser.getStatus();
	}

	/**
	* Sets the status of this s p group user.
	*
	* @param status the status of this s p group user
	*/
	@Override
	public void setStatus(int status) {
		_spGroupUser.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _spGroupUser.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spGroupUser.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spGroupUser.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spGroupUser.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spGroupUser.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spGroupUser.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spGroupUser.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spGroupUser.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spGroupUser.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spGroupUser.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spGroupUser.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPGroupUserWrapper((SPGroupUser)_spGroupUser.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spgroup.model.SPGroupUser spGroupUser) {
		return _spGroupUser.compareTo(spGroupUser);
	}

	@Override
	public int hashCode() {
		return _spGroupUser.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spgroup.model.SPGroupUser> toCacheModel() {
		return _spGroupUser.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser toEscapedModel() {
		return new SPGroupUserWrapper(_spGroupUser.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spgroup.model.SPGroupUser toUnescapedModel() {
		return new SPGroupUserWrapper(_spGroupUser.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spGroupUser.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spGroupUser.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spGroupUser.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPGroupUserWrapper)) {
			return false;
		}

		SPGroupUserWrapper spGroupUserWrapper = (SPGroupUserWrapper)obj;

		if (Validator.equals(_spGroupUser, spGroupUserWrapper._spGroupUser)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPGroupUser getWrappedSPGroupUser() {
		return _spGroupUser;
	}

	@Override
	public SPGroupUser getWrappedModel() {
		return _spGroupUser;
	}

	@Override
	public void resetOriginalValues() {
		_spGroupUser.resetOriginalValues();
	}

	private SPGroupUser _spGroupUser;
}