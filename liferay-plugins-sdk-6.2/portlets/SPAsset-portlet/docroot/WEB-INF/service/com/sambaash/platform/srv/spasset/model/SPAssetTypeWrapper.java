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

package com.sambaash.platform.srv.spasset.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPAssetType}.
 * </p>
 *
 * @author harini
 * @see SPAssetType
 * @generated
 */
public class SPAssetTypeWrapper implements SPAssetType,
	ModelWrapper<SPAssetType> {
	public SPAssetTypeWrapper(SPAssetType spAssetType) {
		_spAssetType = spAssetType;
	}

	@Override
	public Class<?> getModelClass() {
		return SPAssetType.class;
	}

	@Override
	public String getModelClassName() {
		return SPAssetType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid_", getUuid_());
		attributes.put("spAssetTypeId", getSpAssetTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spAssetTypeName", getSpAssetTypeName());
		attributes.put("status", getStatus());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("spAssetTypeCreateUrl", getSpAssetTypeCreateUrl());
		attributes.put("spAssetTypeDetailUrl", getSpAssetTypeDetailUrl());
		attributes.put("spAssetTypeInnerDetailUrl",
			getSpAssetTypeInnerDetailUrl());
		attributes.put("requiredTermsOfUse", getRequiredTermsOfUse());
		attributes.put("requiredLogin", getRequiredLogin());
		attributes.put("categoryMandatory", getCategoryMandatory());
		attributes.put("notifyUponCreation", getNotifyUponCreation());
		attributes.put("notificationTemplateId", getNotificationTemplateId());
		attributes.put("allowedFileTypes", getAllowedFileTypes());
		attributes.put("maxFileSize", getMaxFileSize());
		attributes.put("minImageHeight", getMinImageHeight());
		attributes.put("minImageWidth", getMinImageWidth());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid_ = (String)attributes.get("uuid_");

		if (uuid_ != null) {
			setUuid_(uuid_);
		}

		Long spAssetTypeId = (Long)attributes.get("spAssetTypeId");

		if (spAssetTypeId != null) {
			setSpAssetTypeId(spAssetTypeId);
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

		String spAssetTypeName = (String)attributes.get("spAssetTypeName");

		if (spAssetTypeName != null) {
			setSpAssetTypeName(spAssetTypeName);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		String spAssetTypeCreateUrl = (String)attributes.get(
				"spAssetTypeCreateUrl");

		if (spAssetTypeCreateUrl != null) {
			setSpAssetTypeCreateUrl(spAssetTypeCreateUrl);
		}

		String spAssetTypeDetailUrl = (String)attributes.get(
				"spAssetTypeDetailUrl");

		if (spAssetTypeDetailUrl != null) {
			setSpAssetTypeDetailUrl(spAssetTypeDetailUrl);
		}

		String spAssetTypeInnerDetailUrl = (String)attributes.get(
				"spAssetTypeInnerDetailUrl");

		if (spAssetTypeInnerDetailUrl != null) {
			setSpAssetTypeInnerDetailUrl(spAssetTypeInnerDetailUrl);
		}

		Boolean requiredTermsOfUse = (Boolean)attributes.get(
				"requiredTermsOfUse");

		if (requiredTermsOfUse != null) {
			setRequiredTermsOfUse(requiredTermsOfUse);
		}

		Boolean requiredLogin = (Boolean)attributes.get("requiredLogin");

		if (requiredLogin != null) {
			setRequiredLogin(requiredLogin);
		}

		Boolean categoryMandatory = (Boolean)attributes.get("categoryMandatory");

		if (categoryMandatory != null) {
			setCategoryMandatory(categoryMandatory);
		}

		Boolean notifyUponCreation = (Boolean)attributes.get(
				"notifyUponCreation");

		if (notifyUponCreation != null) {
			setNotifyUponCreation(notifyUponCreation);
		}

		Long notificationTemplateId = (Long)attributes.get(
				"notificationTemplateId");

		if (notificationTemplateId != null) {
			setNotificationTemplateId(notificationTemplateId);
		}

		String allowedFileTypes = (String)attributes.get("allowedFileTypes");

		if (allowedFileTypes != null) {
			setAllowedFileTypes(allowedFileTypes);
		}

		Integer maxFileSize = (Integer)attributes.get("maxFileSize");

		if (maxFileSize != null) {
			setMaxFileSize(maxFileSize);
		}

		Integer minImageHeight = (Integer)attributes.get("minImageHeight");

		if (minImageHeight != null) {
			setMinImageHeight(minImageHeight);
		}

		Integer minImageWidth = (Integer)attributes.get("minImageWidth");

		if (minImageWidth != null) {
			setMinImageWidth(minImageWidth);
		}
	}

	/**
	* Returns the primary key of this s p asset type.
	*
	* @return the primary key of this s p asset type
	*/
	@Override
	public long getPrimaryKey() {
		return _spAssetType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p asset type.
	*
	* @param primaryKey the primary key of this s p asset type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spAssetType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid_ of this s p asset type.
	*
	* @return the uuid_ of this s p asset type
	*/
	@Override
	public java.lang.String getUuid_() {
		return _spAssetType.getUuid_();
	}

	/**
	* Sets the uuid_ of this s p asset type.
	*
	* @param uuid_ the uuid_ of this s p asset type
	*/
	@Override
	public void setUuid_(java.lang.String uuid_) {
		_spAssetType.setUuid_(uuid_);
	}

	/**
	* Returns the sp asset type ID of this s p asset type.
	*
	* @return the sp asset type ID of this s p asset type
	*/
	@Override
	public long getSpAssetTypeId() {
		return _spAssetType.getSpAssetTypeId();
	}

	/**
	* Sets the sp asset type ID of this s p asset type.
	*
	* @param spAssetTypeId the sp asset type ID of this s p asset type
	*/
	@Override
	public void setSpAssetTypeId(long spAssetTypeId) {
		_spAssetType.setSpAssetTypeId(spAssetTypeId);
	}

	/**
	* Returns the group ID of this s p asset type.
	*
	* @return the group ID of this s p asset type
	*/
	@Override
	public long getGroupId() {
		return _spAssetType.getGroupId();
	}

	/**
	* Sets the group ID of this s p asset type.
	*
	* @param groupId the group ID of this s p asset type
	*/
	@Override
	public void setGroupId(long groupId) {
		_spAssetType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p asset type.
	*
	* @return the company ID of this s p asset type
	*/
	@Override
	public long getCompanyId() {
		return _spAssetType.getCompanyId();
	}

	/**
	* Sets the company ID of this s p asset type.
	*
	* @param companyId the company ID of this s p asset type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spAssetType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p asset type.
	*
	* @return the user ID of this s p asset type
	*/
	@Override
	public long getUserId() {
		return _spAssetType.getUserId();
	}

	/**
	* Sets the user ID of this s p asset type.
	*
	* @param userId the user ID of this s p asset type
	*/
	@Override
	public void setUserId(long userId) {
		_spAssetType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p asset type.
	*
	* @return the user uuid of this s p asset type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetType.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p asset type.
	*
	* @param userUuid the user uuid of this s p asset type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spAssetType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p asset type.
	*
	* @return the user name of this s p asset type
	*/
	@Override
	public java.lang.String getUserName() {
		return _spAssetType.getUserName();
	}

	/**
	* Sets the user name of this s p asset type.
	*
	* @param userName the user name of this s p asset type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spAssetType.setUserName(userName);
	}

	/**
	* Returns the create date of this s p asset type.
	*
	* @return the create date of this s p asset type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spAssetType.getCreateDate();
	}

	/**
	* Sets the create date of this s p asset type.
	*
	* @param createDate the create date of this s p asset type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spAssetType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p asset type.
	*
	* @return the modified date of this s p asset type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spAssetType.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p asset type.
	*
	* @param modifiedDate the modified date of this s p asset type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spAssetType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp asset type name of this s p asset type.
	*
	* @return the sp asset type name of this s p asset type
	*/
	@Override
	public java.lang.String getSpAssetTypeName() {
		return _spAssetType.getSpAssetTypeName();
	}

	/**
	* Sets the sp asset type name of this s p asset type.
	*
	* @param spAssetTypeName the sp asset type name of this s p asset type
	*/
	@Override
	public void setSpAssetTypeName(java.lang.String spAssetTypeName) {
		_spAssetType.setSpAssetTypeName(spAssetTypeName);
	}

	/**
	* Returns the status of this s p asset type.
	*
	* @return the status of this s p asset type
	*/
	@Override
	public boolean getStatus() {
		return _spAssetType.getStatus();
	}

	/**
	* Returns <code>true</code> if this s p asset type is status.
	*
	* @return <code>true</code> if this s p asset type is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _spAssetType.isStatus();
	}

	/**
	* Sets whether this s p asset type is status.
	*
	* @param status the status of this s p asset type
	*/
	@Override
	public void setStatus(boolean status) {
		_spAssetType.setStatus(status);
	}

	/**
	* Returns the modified by of this s p asset type.
	*
	* @return the modified by of this s p asset type
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _spAssetType.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p asset type.
	*
	* @param modifiedBy the modified by of this s p asset type
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_spAssetType.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the sp asset type create url of this s p asset type.
	*
	* @return the sp asset type create url of this s p asset type
	*/
	@Override
	public java.lang.String getSpAssetTypeCreateUrl() {
		return _spAssetType.getSpAssetTypeCreateUrl();
	}

	/**
	* Sets the sp asset type create url of this s p asset type.
	*
	* @param spAssetTypeCreateUrl the sp asset type create url of this s p asset type
	*/
	@Override
	public void setSpAssetTypeCreateUrl(java.lang.String spAssetTypeCreateUrl) {
		_spAssetType.setSpAssetTypeCreateUrl(spAssetTypeCreateUrl);
	}

	/**
	* Returns the sp asset type detail url of this s p asset type.
	*
	* @return the sp asset type detail url of this s p asset type
	*/
	@Override
	public java.lang.String getSpAssetTypeDetailUrl() {
		return _spAssetType.getSpAssetTypeDetailUrl();
	}

	/**
	* Sets the sp asset type detail url of this s p asset type.
	*
	* @param spAssetTypeDetailUrl the sp asset type detail url of this s p asset type
	*/
	@Override
	public void setSpAssetTypeDetailUrl(java.lang.String spAssetTypeDetailUrl) {
		_spAssetType.setSpAssetTypeDetailUrl(spAssetTypeDetailUrl);
	}

	/**
	* Returns the sp asset type inner detail url of this s p asset type.
	*
	* @return the sp asset type inner detail url of this s p asset type
	*/
	@Override
	public java.lang.String getSpAssetTypeInnerDetailUrl() {
		return _spAssetType.getSpAssetTypeInnerDetailUrl();
	}

	/**
	* Sets the sp asset type inner detail url of this s p asset type.
	*
	* @param spAssetTypeInnerDetailUrl the sp asset type inner detail url of this s p asset type
	*/
	@Override
	public void setSpAssetTypeInnerDetailUrl(
		java.lang.String spAssetTypeInnerDetailUrl) {
		_spAssetType.setSpAssetTypeInnerDetailUrl(spAssetTypeInnerDetailUrl);
	}

	/**
	* Returns the required terms of use of this s p asset type.
	*
	* @return the required terms of use of this s p asset type
	*/
	@Override
	public boolean getRequiredTermsOfUse() {
		return _spAssetType.getRequiredTermsOfUse();
	}

	/**
	* Returns <code>true</code> if this s p asset type is required terms of use.
	*
	* @return <code>true</code> if this s p asset type is required terms of use; <code>false</code> otherwise
	*/
	@Override
	public boolean isRequiredTermsOfUse() {
		return _spAssetType.isRequiredTermsOfUse();
	}

	/**
	* Sets whether this s p asset type is required terms of use.
	*
	* @param requiredTermsOfUse the required terms of use of this s p asset type
	*/
	@Override
	public void setRequiredTermsOfUse(boolean requiredTermsOfUse) {
		_spAssetType.setRequiredTermsOfUse(requiredTermsOfUse);
	}

	/**
	* Returns the required login of this s p asset type.
	*
	* @return the required login of this s p asset type
	*/
	@Override
	public boolean getRequiredLogin() {
		return _spAssetType.getRequiredLogin();
	}

	/**
	* Returns <code>true</code> if this s p asset type is required login.
	*
	* @return <code>true</code> if this s p asset type is required login; <code>false</code> otherwise
	*/
	@Override
	public boolean isRequiredLogin() {
		return _spAssetType.isRequiredLogin();
	}

	/**
	* Sets whether this s p asset type is required login.
	*
	* @param requiredLogin the required login of this s p asset type
	*/
	@Override
	public void setRequiredLogin(boolean requiredLogin) {
		_spAssetType.setRequiredLogin(requiredLogin);
	}

	/**
	* Returns the category mandatory of this s p asset type.
	*
	* @return the category mandatory of this s p asset type
	*/
	@Override
	public boolean getCategoryMandatory() {
		return _spAssetType.getCategoryMandatory();
	}

	/**
	* Returns <code>true</code> if this s p asset type is category mandatory.
	*
	* @return <code>true</code> if this s p asset type is category mandatory; <code>false</code> otherwise
	*/
	@Override
	public boolean isCategoryMandatory() {
		return _spAssetType.isCategoryMandatory();
	}

	/**
	* Sets whether this s p asset type is category mandatory.
	*
	* @param categoryMandatory the category mandatory of this s p asset type
	*/
	@Override
	public void setCategoryMandatory(boolean categoryMandatory) {
		_spAssetType.setCategoryMandatory(categoryMandatory);
	}

	/**
	* Returns the notify upon creation of this s p asset type.
	*
	* @return the notify upon creation of this s p asset type
	*/
	@Override
	public boolean getNotifyUponCreation() {
		return _spAssetType.getNotifyUponCreation();
	}

	/**
	* Returns <code>true</code> if this s p asset type is notify upon creation.
	*
	* @return <code>true</code> if this s p asset type is notify upon creation; <code>false</code> otherwise
	*/
	@Override
	public boolean isNotifyUponCreation() {
		return _spAssetType.isNotifyUponCreation();
	}

	/**
	* Sets whether this s p asset type is notify upon creation.
	*
	* @param notifyUponCreation the notify upon creation of this s p asset type
	*/
	@Override
	public void setNotifyUponCreation(boolean notifyUponCreation) {
		_spAssetType.setNotifyUponCreation(notifyUponCreation);
	}

	/**
	* Returns the notification template ID of this s p asset type.
	*
	* @return the notification template ID of this s p asset type
	*/
	@Override
	public long getNotificationTemplateId() {
		return _spAssetType.getNotificationTemplateId();
	}

	/**
	* Sets the notification template ID of this s p asset type.
	*
	* @param notificationTemplateId the notification template ID of this s p asset type
	*/
	@Override
	public void setNotificationTemplateId(long notificationTemplateId) {
		_spAssetType.setNotificationTemplateId(notificationTemplateId);
	}

	/**
	* Returns the allowed file types of this s p asset type.
	*
	* @return the allowed file types of this s p asset type
	*/
	@Override
	public java.lang.String getAllowedFileTypes() {
		return _spAssetType.getAllowedFileTypes();
	}

	/**
	* Sets the allowed file types of this s p asset type.
	*
	* @param allowedFileTypes the allowed file types of this s p asset type
	*/
	@Override
	public void setAllowedFileTypes(java.lang.String allowedFileTypes) {
		_spAssetType.setAllowedFileTypes(allowedFileTypes);
	}

	/**
	* Returns the max file size of this s p asset type.
	*
	* @return the max file size of this s p asset type
	*/
	@Override
	public int getMaxFileSize() {
		return _spAssetType.getMaxFileSize();
	}

	/**
	* Sets the max file size of this s p asset type.
	*
	* @param maxFileSize the max file size of this s p asset type
	*/
	@Override
	public void setMaxFileSize(int maxFileSize) {
		_spAssetType.setMaxFileSize(maxFileSize);
	}

	/**
	* Returns the min image height of this s p asset type.
	*
	* @return the min image height of this s p asset type
	*/
	@Override
	public int getMinImageHeight() {
		return _spAssetType.getMinImageHeight();
	}

	/**
	* Sets the min image height of this s p asset type.
	*
	* @param minImageHeight the min image height of this s p asset type
	*/
	@Override
	public void setMinImageHeight(int minImageHeight) {
		_spAssetType.setMinImageHeight(minImageHeight);
	}

	/**
	* Returns the min image width of this s p asset type.
	*
	* @return the min image width of this s p asset type
	*/
	@Override
	public int getMinImageWidth() {
		return _spAssetType.getMinImageWidth();
	}

	/**
	* Sets the min image width of this s p asset type.
	*
	* @param minImageWidth the min image width of this s p asset type
	*/
	@Override
	public void setMinImageWidth(int minImageWidth) {
		_spAssetType.setMinImageWidth(minImageWidth);
	}

	@Override
	public boolean isNew() {
		return _spAssetType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spAssetType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spAssetType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spAssetType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spAssetType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spAssetType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spAssetType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spAssetType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spAssetType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spAssetType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spAssetType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPAssetTypeWrapper((SPAssetType)_spAssetType.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spasset.model.SPAssetType spAssetType) {
		return _spAssetType.compareTo(spAssetType);
	}

	@Override
	public int hashCode() {
		return _spAssetType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spasset.model.SPAssetType> toCacheModel() {
		return _spAssetType.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetType toEscapedModel() {
		return new SPAssetTypeWrapper(_spAssetType.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetType toUnescapedModel() {
		return new SPAssetTypeWrapper(_spAssetType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spAssetType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spAssetType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spAssetType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPAssetTypeWrapper)) {
			return false;
		}

		SPAssetTypeWrapper spAssetTypeWrapper = (SPAssetTypeWrapper)obj;

		if (Validator.equals(_spAssetType, spAssetTypeWrapper._spAssetType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPAssetType getWrappedSPAssetType() {
		return _spAssetType;
	}

	@Override
	public SPAssetType getWrappedModel() {
		return _spAssetType;
	}

	@Override
	public void resetOriginalValues() {
		_spAssetType.resetOriginalValues();
	}

	private SPAssetType _spAssetType;
}