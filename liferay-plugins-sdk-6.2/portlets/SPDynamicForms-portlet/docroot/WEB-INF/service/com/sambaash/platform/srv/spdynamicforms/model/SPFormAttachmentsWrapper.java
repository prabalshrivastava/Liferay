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
 * This class is a wrapper for {@link SPFormAttachments}.
 * </p>
 *
 * @author glenn
 * @see SPFormAttachments
 * @generated
 */
public class SPFormAttachmentsWrapper implements SPFormAttachments,
	ModelWrapper<SPFormAttachments> {
	public SPFormAttachmentsWrapper(SPFormAttachments spFormAttachments) {
		_spFormAttachments = spFormAttachments;
	}

	@Override
	public Class<?> getModelClass() {
		return SPFormAttachments.class;
	}

	@Override
	public String getModelClassName() {
		return SPFormAttachments.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFormAttachmentsId", getSpFormAttachmentsId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("formStorageId", getFormStorageId());
		attributes.put("dataKey", getDataKey());
		attributes.put("name", getName());
		attributes.put("url", getUrl());
		attributes.put("version", getVersion());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFormAttachmentsId = (Long)attributes.get("spFormAttachmentsId");

		if (spFormAttachmentsId != null) {
			setSpFormAttachmentsId(spFormAttachmentsId);
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

		Long formStorageId = (Long)attributes.get("formStorageId");

		if (formStorageId != null) {
			setFormStorageId(formStorageId);
		}

		String dataKey = (String)attributes.get("dataKey");

		if (dataKey != null) {
			setDataKey(dataKey);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		String version = (String)attributes.get("version");

		if (version != null) {
			setVersion(version);
		}
	}

	/**
	* Returns the primary key of this s p form attachments.
	*
	* @return the primary key of this s p form attachments
	*/
	@Override
	public long getPrimaryKey() {
		return _spFormAttachments.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p form attachments.
	*
	* @param primaryKey the primary key of this s p form attachments
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spFormAttachments.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp form attachments ID of this s p form attachments.
	*
	* @return the sp form attachments ID of this s p form attachments
	*/
	@Override
	public long getSpFormAttachmentsId() {
		return _spFormAttachments.getSpFormAttachmentsId();
	}

	/**
	* Sets the sp form attachments ID of this s p form attachments.
	*
	* @param spFormAttachmentsId the sp form attachments ID of this s p form attachments
	*/
	@Override
	public void setSpFormAttachmentsId(long spFormAttachmentsId) {
		_spFormAttachments.setSpFormAttachmentsId(spFormAttachmentsId);
	}

	/**
	* Returns the group ID of this s p form attachments.
	*
	* @return the group ID of this s p form attachments
	*/
	@Override
	public long getGroupId() {
		return _spFormAttachments.getGroupId();
	}

	/**
	* Sets the group ID of this s p form attachments.
	*
	* @param groupId the group ID of this s p form attachments
	*/
	@Override
	public void setGroupId(long groupId) {
		_spFormAttachments.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p form attachments.
	*
	* @return the company ID of this s p form attachments
	*/
	@Override
	public long getCompanyId() {
		return _spFormAttachments.getCompanyId();
	}

	/**
	* Sets the company ID of this s p form attachments.
	*
	* @param companyId the company ID of this s p form attachments
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spFormAttachments.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p form attachments.
	*
	* @return the user ID of this s p form attachments
	*/
	@Override
	public long getUserId() {
		return _spFormAttachments.getUserId();
	}

	/**
	* Sets the user ID of this s p form attachments.
	*
	* @param userId the user ID of this s p form attachments
	*/
	@Override
	public void setUserId(long userId) {
		_spFormAttachments.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p form attachments.
	*
	* @return the user uuid of this s p form attachments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spFormAttachments.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p form attachments.
	*
	* @param userUuid the user uuid of this s p form attachments
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spFormAttachments.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p form attachments.
	*
	* @return the user name of this s p form attachments
	*/
	@Override
	public java.lang.String getUserName() {
		return _spFormAttachments.getUserName();
	}

	/**
	* Sets the user name of this s p form attachments.
	*
	* @param userName the user name of this s p form attachments
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spFormAttachments.setUserName(userName);
	}

	/**
	* Returns the create date of this s p form attachments.
	*
	* @return the create date of this s p form attachments
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spFormAttachments.getCreateDate();
	}

	/**
	* Sets the create date of this s p form attachments.
	*
	* @param createDate the create date of this s p form attachments
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spFormAttachments.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p form attachments.
	*
	* @return the modified date of this s p form attachments
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spFormAttachments.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p form attachments.
	*
	* @param modifiedDate the modified date of this s p form attachments
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spFormAttachments.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the form storage ID of this s p form attachments.
	*
	* @return the form storage ID of this s p form attachments
	*/
	@Override
	public long getFormStorageId() {
		return _spFormAttachments.getFormStorageId();
	}

	/**
	* Sets the form storage ID of this s p form attachments.
	*
	* @param formStorageId the form storage ID of this s p form attachments
	*/
	@Override
	public void setFormStorageId(long formStorageId) {
		_spFormAttachments.setFormStorageId(formStorageId);
	}

	/**
	* Returns the data key of this s p form attachments.
	*
	* @return the data key of this s p form attachments
	*/
	@Override
	public java.lang.String getDataKey() {
		return _spFormAttachments.getDataKey();
	}

	/**
	* Sets the data key of this s p form attachments.
	*
	* @param dataKey the data key of this s p form attachments
	*/
	@Override
	public void setDataKey(java.lang.String dataKey) {
		_spFormAttachments.setDataKey(dataKey);
	}

	/**
	* Returns the name of this s p form attachments.
	*
	* @return the name of this s p form attachments
	*/
	@Override
	public java.lang.String getName() {
		return _spFormAttachments.getName();
	}

	/**
	* Sets the name of this s p form attachments.
	*
	* @param name the name of this s p form attachments
	*/
	@Override
	public void setName(java.lang.String name) {
		_spFormAttachments.setName(name);
	}

	/**
	* Returns the url of this s p form attachments.
	*
	* @return the url of this s p form attachments
	*/
	@Override
	public java.lang.String getUrl() {
		return _spFormAttachments.getUrl();
	}

	/**
	* Sets the url of this s p form attachments.
	*
	* @param url the url of this s p form attachments
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_spFormAttachments.setUrl(url);
	}

	/**
	* Returns the version of this s p form attachments.
	*
	* @return the version of this s p form attachments
	*/
	@Override
	public java.lang.String getVersion() {
		return _spFormAttachments.getVersion();
	}

	/**
	* Sets the version of this s p form attachments.
	*
	* @param version the version of this s p form attachments
	*/
	@Override
	public void setVersion(java.lang.String version) {
		_spFormAttachments.setVersion(version);
	}

	@Override
	public boolean isNew() {
		return _spFormAttachments.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spFormAttachments.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spFormAttachments.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spFormAttachments.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spFormAttachments.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spFormAttachments.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spFormAttachments.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spFormAttachments.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spFormAttachments.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spFormAttachments.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spFormAttachments.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPFormAttachmentsWrapper((SPFormAttachments)_spFormAttachments.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spdynamicforms.model.SPFormAttachments spFormAttachments) {
		return _spFormAttachments.compareTo(spFormAttachments);
	}

	@Override
	public int hashCode() {
		return _spFormAttachments.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spdynamicforms.model.SPFormAttachments> toCacheModel() {
		return _spFormAttachments.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spdynamicforms.model.SPFormAttachments toEscapedModel() {
		return new SPFormAttachmentsWrapper(_spFormAttachments.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spdynamicforms.model.SPFormAttachments toUnescapedModel() {
		return new SPFormAttachmentsWrapper(_spFormAttachments.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spFormAttachments.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spFormAttachments.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spFormAttachments.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPFormAttachmentsWrapper)) {
			return false;
		}

		SPFormAttachmentsWrapper spFormAttachmentsWrapper = (SPFormAttachmentsWrapper)obj;

		if (Validator.equals(_spFormAttachments,
					spFormAttachmentsWrapper._spFormAttachments)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPFormAttachments getWrappedSPFormAttachments() {
		return _spFormAttachments;
	}

	@Override
	public SPFormAttachments getWrappedModel() {
		return _spFormAttachments;
	}

	@Override
	public void resetOriginalValues() {
		_spFormAttachments.resetOriginalValues();
	}

	private SPFormAttachments _spFormAttachments;
}