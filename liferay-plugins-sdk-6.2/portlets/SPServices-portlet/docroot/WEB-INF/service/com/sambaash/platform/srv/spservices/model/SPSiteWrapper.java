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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPSite}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPSite
 * @generated
 */
public class SPSiteWrapper implements SPSite, ModelWrapper<SPSite> {
	public SPSiteWrapper(SPSite spSite) {
		_spSite = spSite;
	}

	@Override
	public Class<?> getModelClass() {
		return SPSite.class;
	}

	@Override
	public String getModelClassName() {
		return SPSite.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spSiteId", getSpSiteId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("virtualHostId", getVirtualHostId());
		attributes.put("layoutSetId", getLayoutSetId());
		attributes.put("authAccessId", getAuthAccessId());
		attributes.put("loginType", getLoginType());
		attributes.put("password", getPassword());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spSiteId = (Long)attributes.get("spSiteId");

		if (spSiteId != null) {
			setSpSiteId(spSiteId);
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

		Long virtualHostId = (Long)attributes.get("virtualHostId");

		if (virtualHostId != null) {
			setVirtualHostId(virtualHostId);
		}

		Long layoutSetId = (Long)attributes.get("layoutSetId");

		if (layoutSetId != null) {
			setLayoutSetId(layoutSetId);
		}

		Long authAccessId = (Long)attributes.get("authAccessId");

		if (authAccessId != null) {
			setAuthAccessId(authAccessId);
		}

		Long loginType = (Long)attributes.get("loginType");

		if (loginType != null) {
			setLoginType(loginType);
		}

		String password = (String)attributes.get("password");

		if (password != null) {
			setPassword(password);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this s p site.
	*
	* @return the primary key of this s p site
	*/
	@Override
	public long getPrimaryKey() {
		return _spSite.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p site.
	*
	* @param primaryKey the primary key of this s p site
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spSite.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p site.
	*
	* @return the uuid of this s p site
	*/
	@Override
	public java.lang.String getUuid() {
		return _spSite.getUuid();
	}

	/**
	* Sets the uuid of this s p site.
	*
	* @param uuid the uuid of this s p site
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spSite.setUuid(uuid);
	}

	/**
	* Returns the sp site ID of this s p site.
	*
	* @return the sp site ID of this s p site
	*/
	@Override
	public long getSpSiteId() {
		return _spSite.getSpSiteId();
	}

	/**
	* Sets the sp site ID of this s p site.
	*
	* @param spSiteId the sp site ID of this s p site
	*/
	@Override
	public void setSpSiteId(long spSiteId) {
		_spSite.setSpSiteId(spSiteId);
	}

	/**
	* Returns the group ID of this s p site.
	*
	* @return the group ID of this s p site
	*/
	@Override
	public long getGroupId() {
		return _spSite.getGroupId();
	}

	/**
	* Sets the group ID of this s p site.
	*
	* @param groupId the group ID of this s p site
	*/
	@Override
	public void setGroupId(long groupId) {
		_spSite.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p site.
	*
	* @return the company ID of this s p site
	*/
	@Override
	public long getCompanyId() {
		return _spSite.getCompanyId();
	}

	/**
	* Sets the company ID of this s p site.
	*
	* @param companyId the company ID of this s p site
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spSite.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p site.
	*
	* @return the user ID of this s p site
	*/
	@Override
	public long getUserId() {
		return _spSite.getUserId();
	}

	/**
	* Sets the user ID of this s p site.
	*
	* @param userId the user ID of this s p site
	*/
	@Override
	public void setUserId(long userId) {
		_spSite.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p site.
	*
	* @return the user uuid of this s p site
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSite.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p site.
	*
	* @param userUuid the user uuid of this s p site
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spSite.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p site.
	*
	* @return the user name of this s p site
	*/
	@Override
	public java.lang.String getUserName() {
		return _spSite.getUserName();
	}

	/**
	* Sets the user name of this s p site.
	*
	* @param userName the user name of this s p site
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spSite.setUserName(userName);
	}

	/**
	* Returns the create date of this s p site.
	*
	* @return the create date of this s p site
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spSite.getCreateDate();
	}

	/**
	* Sets the create date of this s p site.
	*
	* @param createDate the create date of this s p site
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spSite.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p site.
	*
	* @return the modified date of this s p site
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spSite.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p site.
	*
	* @param modifiedDate the modified date of this s p site
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spSite.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the virtual host ID of this s p site.
	*
	* @return the virtual host ID of this s p site
	*/
	@Override
	public long getVirtualHostId() {
		return _spSite.getVirtualHostId();
	}

	/**
	* Sets the virtual host ID of this s p site.
	*
	* @param virtualHostId the virtual host ID of this s p site
	*/
	@Override
	public void setVirtualHostId(long virtualHostId) {
		_spSite.setVirtualHostId(virtualHostId);
	}

	/**
	* Returns the layout set ID of this s p site.
	*
	* @return the layout set ID of this s p site
	*/
	@Override
	public long getLayoutSetId() {
		return _spSite.getLayoutSetId();
	}

	/**
	* Sets the layout set ID of this s p site.
	*
	* @param layoutSetId the layout set ID of this s p site
	*/
	@Override
	public void setLayoutSetId(long layoutSetId) {
		_spSite.setLayoutSetId(layoutSetId);
	}

	/**
	* Returns the auth access ID of this s p site.
	*
	* @return the auth access ID of this s p site
	*/
	@Override
	public long getAuthAccessId() {
		return _spSite.getAuthAccessId();
	}

	/**
	* Sets the auth access ID of this s p site.
	*
	* @param authAccessId the auth access ID of this s p site
	*/
	@Override
	public void setAuthAccessId(long authAccessId) {
		_spSite.setAuthAccessId(authAccessId);
	}

	/**
	* Returns the login type of this s p site.
	*
	* @return the login type of this s p site
	*/
	@Override
	public long getLoginType() {
		return _spSite.getLoginType();
	}

	/**
	* Sets the login type of this s p site.
	*
	* @param loginType the login type of this s p site
	*/
	@Override
	public void setLoginType(long loginType) {
		_spSite.setLoginType(loginType);
	}

	/**
	* Returns the password of this s p site.
	*
	* @return the password of this s p site
	*/
	@Override
	public java.lang.String getPassword() {
		return _spSite.getPassword();
	}

	/**
	* Sets the password of this s p site.
	*
	* @param password the password of this s p site
	*/
	@Override
	public void setPassword(java.lang.String password) {
		_spSite.setPassword(password);
	}

	/**
	* Returns the active of this s p site.
	*
	* @return the active of this s p site
	*/
	@Override
	public boolean getActive() {
		return _spSite.getActive();
	}

	/**
	* Returns <code>true</code> if this s p site is active.
	*
	* @return <code>true</code> if this s p site is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _spSite.isActive();
	}

	/**
	* Sets whether this s p site is active.
	*
	* @param active the active of this s p site
	*/
	@Override
	public void setActive(boolean active) {
		_spSite.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _spSite.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spSite.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spSite.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spSite.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spSite.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spSite.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spSite.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spSite.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spSite.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spSite.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spSite.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPSiteWrapper((SPSite)_spSite.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spservices.model.SPSite spSite) {
		return _spSite.compareTo(spSite);
	}

	@Override
	public int hashCode() {
		return _spSite.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spservices.model.SPSite> toCacheModel() {
		return _spSite.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite toEscapedModel() {
		return new SPSiteWrapper(_spSite.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spservices.model.SPSite toUnescapedModel() {
		return new SPSiteWrapper(_spSite.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spSite.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spSite.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spSite.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPSiteWrapper)) {
			return false;
		}

		SPSiteWrapper spSiteWrapper = (SPSiteWrapper)obj;

		if (Validator.equals(_spSite, spSiteWrapper._spSite)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spSite.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPSite getWrappedSPSite() {
		return _spSite;
	}

	@Override
	public SPSite getWrappedModel() {
		return _spSite;
	}

	@Override
	public void resetOriginalValues() {
		_spSite.resetOriginalValues();
	}

	private SPSite _spSite;
}