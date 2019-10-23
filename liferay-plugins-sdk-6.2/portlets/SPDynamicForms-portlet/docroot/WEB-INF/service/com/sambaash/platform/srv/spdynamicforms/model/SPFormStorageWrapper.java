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

package com.sambaash.platform.srv.spdynamicforms.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPFormStorage}.
 * </p>
 *
 * @author glenn
 * @see SPFormStorage
 * @generated
 */
public class SPFormStorageWrapper implements SPFormStorage,
	ModelWrapper<SPFormStorage> {
	public SPFormStorageWrapper(SPFormStorage spFormStorage) {
		_spFormStorage = spFormStorage;
	}

	@Override
	public Class<?> getModelClass() {
		return SPFormStorage.class;
	}

	@Override
	public String getModelClassName() {
		return SPFormStorage.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("formStorageId", getFormStorageId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("applicationId", getApplicationId());
		attributes.put("content", getContent());
		attributes.put("htmlFormId", getHtmlFormId());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long formStorageId = (Long)attributes.get("formStorageId");

		if (formStorageId != null) {
			setFormStorageId(formStorageId);
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

		String applicationId = (String)attributes.get("applicationId");

		if (applicationId != null) {
			setApplicationId(applicationId);
		}

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		Long htmlFormId = (Long)attributes.get("htmlFormId");

		if (htmlFormId != null) {
			setHtmlFormId(htmlFormId);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this s p form storage.
	*
	* @return the primary key of this s p form storage
	*/
	@Override
	public long getPrimaryKey() {
		return _spFormStorage.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p form storage.
	*
	* @param primaryKey the primary key of this s p form storage
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spFormStorage.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the form storage ID of this s p form storage.
	*
	* @return the form storage ID of this s p form storage
	*/
	@Override
	public long getFormStorageId() {
		return _spFormStorage.getFormStorageId();
	}

	/**
	* Sets the form storage ID of this s p form storage.
	*
	* @param formStorageId the form storage ID of this s p form storage
	*/
	@Override
	public void setFormStorageId(long formStorageId) {
		_spFormStorage.setFormStorageId(formStorageId);
	}

	/**
	* Returns the group ID of this s p form storage.
	*
	* @return the group ID of this s p form storage
	*/
	@Override
	public long getGroupId() {
		return _spFormStorage.getGroupId();
	}

	/**
	* Sets the group ID of this s p form storage.
	*
	* @param groupId the group ID of this s p form storage
	*/
	@Override
	public void setGroupId(long groupId) {
		_spFormStorage.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p form storage.
	*
	* @return the company ID of this s p form storage
	*/
	@Override
	public long getCompanyId() {
		return _spFormStorage.getCompanyId();
	}

	/**
	* Sets the company ID of this s p form storage.
	*
	* @param companyId the company ID of this s p form storage
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spFormStorage.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p form storage.
	*
	* @return the user ID of this s p form storage
	*/
	@Override
	public long getUserId() {
		return _spFormStorage.getUserId();
	}

	/**
	* Sets the user ID of this s p form storage.
	*
	* @param userId the user ID of this s p form storage
	*/
	@Override
	public void setUserId(long userId) {
		_spFormStorage.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p form storage.
	*
	* @return the user uuid of this s p form storage
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spFormStorage.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p form storage.
	*
	* @param userUuid the user uuid of this s p form storage
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spFormStorage.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p form storage.
	*
	* @return the user name of this s p form storage
	*/
	@Override
	public java.lang.String getUserName() {
		return _spFormStorage.getUserName();
	}

	/**
	* Sets the user name of this s p form storage.
	*
	* @param userName the user name of this s p form storage
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spFormStorage.setUserName(userName);
	}

	/**
	* Returns the create date of this s p form storage.
	*
	* @return the create date of this s p form storage
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spFormStorage.getCreateDate();
	}

	/**
	* Sets the create date of this s p form storage.
	*
	* @param createDate the create date of this s p form storage
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spFormStorage.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p form storage.
	*
	* @return the modified date of this s p form storage
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spFormStorage.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p form storage.
	*
	* @param modifiedDate the modified date of this s p form storage
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spFormStorage.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the application ID of this s p form storage.
	*
	* @return the application ID of this s p form storage
	*/
	@Override
	public java.lang.String getApplicationId() {
		return _spFormStorage.getApplicationId();
	}

	/**
	* Sets the application ID of this s p form storage.
	*
	* @param applicationId the application ID of this s p form storage
	*/
	@Override
	public void setApplicationId(java.lang.String applicationId) {
		_spFormStorage.setApplicationId(applicationId);
	}

	/**
	* Returns the content of this s p form storage.
	*
	* @return the content of this s p form storage
	*/
	@Override
	public java.lang.String getContent() {
		return _spFormStorage.getContent();
	}

	/**
	* Sets the content of this s p form storage.
	*
	* @param content the content of this s p form storage
	*/
	@Override
	public void setContent(java.lang.String content) {
		_spFormStorage.setContent(content);
	}

	/**
	* Returns the html form ID of this s p form storage.
	*
	* @return the html form ID of this s p form storage
	*/
	@Override
	public long getHtmlFormId() {
		return _spFormStorage.getHtmlFormId();
	}

	/**
	* Sets the html form ID of this s p form storage.
	*
	* @param htmlFormId the html form ID of this s p form storage
	*/
	@Override
	public void setHtmlFormId(long htmlFormId) {
		_spFormStorage.setHtmlFormId(htmlFormId);
	}

	/**
	* Returns the status of this s p form storage.
	*
	* @return the status of this s p form storage
	*/
	@Override
	public java.lang.String getStatus() {
		return _spFormStorage.getStatus();
	}

	/**
	* Sets the status of this s p form storage.
	*
	* @param status the status of this s p form storage
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_spFormStorage.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _spFormStorage.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spFormStorage.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spFormStorage.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spFormStorage.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spFormStorage.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spFormStorage.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spFormStorage.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spFormStorage.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spFormStorage.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spFormStorage.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spFormStorage.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPFormStorageWrapper((SPFormStorage)_spFormStorage.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage spFormStorage) {
		return _spFormStorage.compareTo(spFormStorage);
	}

	@Override
	public int hashCode() {
		return _spFormStorage.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage> toCacheModel() {
		return _spFormStorage.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage toEscapedModel() {
		return new SPFormStorageWrapper(_spFormStorage.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spdynamicforms.model.SPFormStorage toUnescapedModel() {
		return new SPFormStorageWrapper(_spFormStorage.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spFormStorage.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spFormStorage.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spFormStorage.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPFormStorageWrapper)) {
			return false;
		}

		SPFormStorageWrapper spFormStorageWrapper = (SPFormStorageWrapper)obj;

		if (Validator.equals(_spFormStorage, spFormStorageWrapper._spFormStorage)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPFormStorage getWrappedSPFormStorage() {
		return _spFormStorage;
	}

	@Override
	public SPFormStorage getWrappedModel() {
		return _spFormStorage;
	}

	@Override
	public void resetOriginalValues() {
		_spFormStorage.resetOriginalValues();
	}

	private SPFormStorage _spFormStorage;
}