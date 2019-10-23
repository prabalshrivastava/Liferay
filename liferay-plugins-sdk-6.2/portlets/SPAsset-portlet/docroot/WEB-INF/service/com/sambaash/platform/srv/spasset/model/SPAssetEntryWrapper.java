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
 * This class is a wrapper for {@link SPAssetEntry}.
 * </p>
 *
 * @author harini
 * @see SPAssetEntry
 * @generated
 */
public class SPAssetEntryWrapper implements SPAssetEntry,
	ModelWrapper<SPAssetEntry> {
	public SPAssetEntryWrapper(SPAssetEntry spAssetEntry) {
		_spAssetEntry = spAssetEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return SPAssetEntry.class;
	}

	@Override
	public String getModelClassName() {
		return SPAssetEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid_", getUuid_());
		attributes.put("spAssetEntryId", getSpAssetEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("dlFolderId", getDlFolderId());
		attributes.put("coverFileEntryId", getCoverFileEntryId());
		attributes.put("spAssetTypeId", getSpAssetTypeId());
		attributes.put("spAssetEntrySubType", getSpAssetEntrySubType());
		attributes.put("corporateProfileUserId", getCorporateProfileUserId());
		attributes.put("classNameId", getClassNameId());
		attributes.put("title", getTitle());
		attributes.put("urlTitle", getUrlTitle());
		attributes.put("description", getDescription());
		attributes.put("content", getContent());
		attributes.put("link", getLink());
		attributes.put("status", getStatus());
		attributes.put("statusByUserName", getStatusByUserName());
		attributes.put("type", getType());
		attributes.put("modifiedBy", getModifiedBy());
		attributes.put("allowPingbacks", getAllowPingbacks());
		attributes.put("allowTrackbacks", getAllowTrackbacks());
		attributes.put("trackbacks", getTrackbacks());
		attributes.put("permissionType", getPermissionType());
		attributes.put("agreedToTermsOfUse", getAgreedToTermsOfUse());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid_ = (String)attributes.get("uuid_");

		if (uuid_ != null) {
			setUuid_(uuid_);
		}

		Long spAssetEntryId = (Long)attributes.get("spAssetEntryId");

		if (spAssetEntryId != null) {
			setSpAssetEntryId(spAssetEntryId);
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

		Long dlFolderId = (Long)attributes.get("dlFolderId");

		if (dlFolderId != null) {
			setDlFolderId(dlFolderId);
		}

		Long coverFileEntryId = (Long)attributes.get("coverFileEntryId");

		if (coverFileEntryId != null) {
			setCoverFileEntryId(coverFileEntryId);
		}

		Long spAssetTypeId = (Long)attributes.get("spAssetTypeId");

		if (spAssetTypeId != null) {
			setSpAssetTypeId(spAssetTypeId);
		}

		String spAssetEntrySubType = (String)attributes.get(
				"spAssetEntrySubType");

		if (spAssetEntrySubType != null) {
			setSpAssetEntrySubType(spAssetEntrySubType);
		}

		Long corporateProfileUserId = (Long)attributes.get(
				"corporateProfileUserId");

		if (corporateProfileUserId != null) {
			setCorporateProfileUserId(corporateProfileUserId);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
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

		String content = (String)attributes.get("content");

		if (content != null) {
			setContent(content);
		}

		String link = (String)attributes.get("link");

		if (link != null) {
			setLink(link);
		}

		Boolean status = (Boolean)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String statusByUserName = (String)attributes.get("statusByUserName");

		if (statusByUserName != null) {
			setStatusByUserName(statusByUserName);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String modifiedBy = (String)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}

		Boolean allowPingbacks = (Boolean)attributes.get("allowPingbacks");

		if (allowPingbacks != null) {
			setAllowPingbacks(allowPingbacks);
		}

		Boolean allowTrackbacks = (Boolean)attributes.get("allowTrackbacks");

		if (allowTrackbacks != null) {
			setAllowTrackbacks(allowTrackbacks);
		}

		String trackbacks = (String)attributes.get("trackbacks");

		if (trackbacks != null) {
			setTrackbacks(trackbacks);
		}

		Integer permissionType = (Integer)attributes.get("permissionType");

		if (permissionType != null) {
			setPermissionType(permissionType);
		}

		Boolean agreedToTermsOfUse = (Boolean)attributes.get(
				"agreedToTermsOfUse");

		if (agreedToTermsOfUse != null) {
			setAgreedToTermsOfUse(agreedToTermsOfUse);
		}
	}

	/**
	* Returns the primary key of this s p asset entry.
	*
	* @return the primary key of this s p asset entry
	*/
	@Override
	public long getPrimaryKey() {
		return _spAssetEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p asset entry.
	*
	* @param primaryKey the primary key of this s p asset entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spAssetEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid_ of this s p asset entry.
	*
	* @return the uuid_ of this s p asset entry
	*/
	@Override
	public java.lang.String getUuid_() {
		return _spAssetEntry.getUuid_();
	}

	/**
	* Sets the uuid_ of this s p asset entry.
	*
	* @param uuid_ the uuid_ of this s p asset entry
	*/
	@Override
	public void setUuid_(java.lang.String uuid_) {
		_spAssetEntry.setUuid_(uuid_);
	}

	/**
	* Returns the sp asset entry ID of this s p asset entry.
	*
	* @return the sp asset entry ID of this s p asset entry
	*/
	@Override
	public long getSpAssetEntryId() {
		return _spAssetEntry.getSpAssetEntryId();
	}

	/**
	* Sets the sp asset entry ID of this s p asset entry.
	*
	* @param spAssetEntryId the sp asset entry ID of this s p asset entry
	*/
	@Override
	public void setSpAssetEntryId(long spAssetEntryId) {
		_spAssetEntry.setSpAssetEntryId(spAssetEntryId);
	}

	/**
	* Returns the group ID of this s p asset entry.
	*
	* @return the group ID of this s p asset entry
	*/
	@Override
	public long getGroupId() {
		return _spAssetEntry.getGroupId();
	}

	/**
	* Sets the group ID of this s p asset entry.
	*
	* @param groupId the group ID of this s p asset entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_spAssetEntry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p asset entry.
	*
	* @return the company ID of this s p asset entry
	*/
	@Override
	public long getCompanyId() {
		return _spAssetEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this s p asset entry.
	*
	* @param companyId the company ID of this s p asset entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spAssetEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p asset entry.
	*
	* @return the user ID of this s p asset entry
	*/
	@Override
	public long getUserId() {
		return _spAssetEntry.getUserId();
	}

	/**
	* Sets the user ID of this s p asset entry.
	*
	* @param userId the user ID of this s p asset entry
	*/
	@Override
	public void setUserId(long userId) {
		_spAssetEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p asset entry.
	*
	* @return the user uuid of this s p asset entry
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p asset entry.
	*
	* @param userUuid the user uuid of this s p asset entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spAssetEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p asset entry.
	*
	* @return the user name of this s p asset entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _spAssetEntry.getUserName();
	}

	/**
	* Sets the user name of this s p asset entry.
	*
	* @param userName the user name of this s p asset entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spAssetEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this s p asset entry.
	*
	* @return the create date of this s p asset entry
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spAssetEntry.getCreateDate();
	}

	/**
	* Sets the create date of this s p asset entry.
	*
	* @param createDate the create date of this s p asset entry
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spAssetEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p asset entry.
	*
	* @return the modified date of this s p asset entry
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spAssetEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p asset entry.
	*
	* @param modifiedDate the modified date of this s p asset entry
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spAssetEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the dl folder ID of this s p asset entry.
	*
	* @return the dl folder ID of this s p asset entry
	*/
	@Override
	public long getDlFolderId() {
		return _spAssetEntry.getDlFolderId();
	}

	/**
	* Sets the dl folder ID of this s p asset entry.
	*
	* @param dlFolderId the dl folder ID of this s p asset entry
	*/
	@Override
	public void setDlFolderId(long dlFolderId) {
		_spAssetEntry.setDlFolderId(dlFolderId);
	}

	/**
	* Returns the cover file entry ID of this s p asset entry.
	*
	* @return the cover file entry ID of this s p asset entry
	*/
	@Override
	public long getCoverFileEntryId() {
		return _spAssetEntry.getCoverFileEntryId();
	}

	/**
	* Sets the cover file entry ID of this s p asset entry.
	*
	* @param coverFileEntryId the cover file entry ID of this s p asset entry
	*/
	@Override
	public void setCoverFileEntryId(long coverFileEntryId) {
		_spAssetEntry.setCoverFileEntryId(coverFileEntryId);
	}

	/**
	* Returns the sp asset type ID of this s p asset entry.
	*
	* @return the sp asset type ID of this s p asset entry
	*/
	@Override
	public long getSpAssetTypeId() {
		return _spAssetEntry.getSpAssetTypeId();
	}

	/**
	* Sets the sp asset type ID of this s p asset entry.
	*
	* @param spAssetTypeId the sp asset type ID of this s p asset entry
	*/
	@Override
	public void setSpAssetTypeId(long spAssetTypeId) {
		_spAssetEntry.setSpAssetTypeId(spAssetTypeId);
	}

	/**
	* Returns the sp asset entry sub type of this s p asset entry.
	*
	* @return the sp asset entry sub type of this s p asset entry
	*/
	@Override
	public java.lang.String getSpAssetEntrySubType() {
		return _spAssetEntry.getSpAssetEntrySubType();
	}

	/**
	* Sets the sp asset entry sub type of this s p asset entry.
	*
	* @param spAssetEntrySubType the sp asset entry sub type of this s p asset entry
	*/
	@Override
	public void setSpAssetEntrySubType(java.lang.String spAssetEntrySubType) {
		_spAssetEntry.setSpAssetEntrySubType(spAssetEntrySubType);
	}

	/**
	* Returns the corporate profile user ID of this s p asset entry.
	*
	* @return the corporate profile user ID of this s p asset entry
	*/
	@Override
	public long getCorporateProfileUserId() {
		return _spAssetEntry.getCorporateProfileUserId();
	}

	/**
	* Sets the corporate profile user ID of this s p asset entry.
	*
	* @param corporateProfileUserId the corporate profile user ID of this s p asset entry
	*/
	@Override
	public void setCorporateProfileUserId(long corporateProfileUserId) {
		_spAssetEntry.setCorporateProfileUserId(corporateProfileUserId);
	}

	/**
	* Returns the corporate profile user uuid of this s p asset entry.
	*
	* @return the corporate profile user uuid of this s p asset entry
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getCorporateProfileUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spAssetEntry.getCorporateProfileUserUuid();
	}

	/**
	* Sets the corporate profile user uuid of this s p asset entry.
	*
	* @param corporateProfileUserUuid the corporate profile user uuid of this s p asset entry
	*/
	@Override
	public void setCorporateProfileUserUuid(
		java.lang.String corporateProfileUserUuid) {
		_spAssetEntry.setCorporateProfileUserUuid(corporateProfileUserUuid);
	}

	/**
	* Returns the fully qualified class name of this s p asset entry.
	*
	* @return the fully qualified class name of this s p asset entry
	*/
	@Override
	public java.lang.String getClassName() {
		return _spAssetEntry.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_spAssetEntry.setClassName(className);
	}

	/**
	* Returns the class name ID of this s p asset entry.
	*
	* @return the class name ID of this s p asset entry
	*/
	@Override
	public long getClassNameId() {
		return _spAssetEntry.getClassNameId();
	}

	/**
	* Sets the class name ID of this s p asset entry.
	*
	* @param classNameId the class name ID of this s p asset entry
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_spAssetEntry.setClassNameId(classNameId);
	}

	/**
	* Returns the title of this s p asset entry.
	*
	* @return the title of this s p asset entry
	*/
	@Override
	public java.lang.String getTitle() {
		return _spAssetEntry.getTitle();
	}

	/**
	* Sets the title of this s p asset entry.
	*
	* @param title the title of this s p asset entry
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_spAssetEntry.setTitle(title);
	}

	/**
	* Returns the url title of this s p asset entry.
	*
	* @return the url title of this s p asset entry
	*/
	@Override
	public java.lang.String getUrlTitle() {
		return _spAssetEntry.getUrlTitle();
	}

	/**
	* Sets the url title of this s p asset entry.
	*
	* @param urlTitle the url title of this s p asset entry
	*/
	@Override
	public void setUrlTitle(java.lang.String urlTitle) {
		_spAssetEntry.setUrlTitle(urlTitle);
	}

	/**
	* Returns the description of this s p asset entry.
	*
	* @return the description of this s p asset entry
	*/
	@Override
	public java.lang.String getDescription() {
		return _spAssetEntry.getDescription();
	}

	/**
	* Sets the description of this s p asset entry.
	*
	* @param description the description of this s p asset entry
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_spAssetEntry.setDescription(description);
	}

	/**
	* Returns the content of this s p asset entry.
	*
	* @return the content of this s p asset entry
	*/
	@Override
	public java.lang.String getContent() {
		return _spAssetEntry.getContent();
	}

	/**
	* Sets the content of this s p asset entry.
	*
	* @param content the content of this s p asset entry
	*/
	@Override
	public void setContent(java.lang.String content) {
		_spAssetEntry.setContent(content);
	}

	/**
	* Returns the link of this s p asset entry.
	*
	* @return the link of this s p asset entry
	*/
	@Override
	public java.lang.String getLink() {
		return _spAssetEntry.getLink();
	}

	/**
	* Sets the link of this s p asset entry.
	*
	* @param link the link of this s p asset entry
	*/
	@Override
	public void setLink(java.lang.String link) {
		_spAssetEntry.setLink(link);
	}

	/**
	* Returns the status of this s p asset entry.
	*
	* @return the status of this s p asset entry
	*/
	@Override
	public boolean getStatus() {
		return _spAssetEntry.getStatus();
	}

	/**
	* Returns <code>true</code> if this s p asset entry is status.
	*
	* @return <code>true</code> if this s p asset entry is status; <code>false</code> otherwise
	*/
	@Override
	public boolean isStatus() {
		return _spAssetEntry.isStatus();
	}

	/**
	* Sets whether this s p asset entry is status.
	*
	* @param status the status of this s p asset entry
	*/
	@Override
	public void setStatus(boolean status) {
		_spAssetEntry.setStatus(status);
	}

	/**
	* Returns the status by user name of this s p asset entry.
	*
	* @return the status by user name of this s p asset entry
	*/
	@Override
	public java.lang.String getStatusByUserName() {
		return _spAssetEntry.getStatusByUserName();
	}

	/**
	* Sets the status by user name of this s p asset entry.
	*
	* @param statusByUserName the status by user name of this s p asset entry
	*/
	@Override
	public void setStatusByUserName(java.lang.String statusByUserName) {
		_spAssetEntry.setStatusByUserName(statusByUserName);
	}

	/**
	* Returns the type of this s p asset entry.
	*
	* @return the type of this s p asset entry
	*/
	@Override
	public java.lang.String getType() {
		return _spAssetEntry.getType();
	}

	/**
	* Sets the type of this s p asset entry.
	*
	* @param type the type of this s p asset entry
	*/
	@Override
	public void setType(java.lang.String type) {
		_spAssetEntry.setType(type);
	}

	/**
	* Returns the modified by of this s p asset entry.
	*
	* @return the modified by of this s p asset entry
	*/
	@Override
	public java.lang.String getModifiedBy() {
		return _spAssetEntry.getModifiedBy();
	}

	/**
	* Sets the modified by of this s p asset entry.
	*
	* @param modifiedBy the modified by of this s p asset entry
	*/
	@Override
	public void setModifiedBy(java.lang.String modifiedBy) {
		_spAssetEntry.setModifiedBy(modifiedBy);
	}

	/**
	* Returns the allow pingbacks of this s p asset entry.
	*
	* @return the allow pingbacks of this s p asset entry
	*/
	@Override
	public boolean getAllowPingbacks() {
		return _spAssetEntry.getAllowPingbacks();
	}

	/**
	* Returns <code>true</code> if this s p asset entry is allow pingbacks.
	*
	* @return <code>true</code> if this s p asset entry is allow pingbacks; <code>false</code> otherwise
	*/
	@Override
	public boolean isAllowPingbacks() {
		return _spAssetEntry.isAllowPingbacks();
	}

	/**
	* Sets whether this s p asset entry is allow pingbacks.
	*
	* @param allowPingbacks the allow pingbacks of this s p asset entry
	*/
	@Override
	public void setAllowPingbacks(boolean allowPingbacks) {
		_spAssetEntry.setAllowPingbacks(allowPingbacks);
	}

	/**
	* Returns the allow trackbacks of this s p asset entry.
	*
	* @return the allow trackbacks of this s p asset entry
	*/
	@Override
	public boolean getAllowTrackbacks() {
		return _spAssetEntry.getAllowTrackbacks();
	}

	/**
	* Returns <code>true</code> if this s p asset entry is allow trackbacks.
	*
	* @return <code>true</code> if this s p asset entry is allow trackbacks; <code>false</code> otherwise
	*/
	@Override
	public boolean isAllowTrackbacks() {
		return _spAssetEntry.isAllowTrackbacks();
	}

	/**
	* Sets whether this s p asset entry is allow trackbacks.
	*
	* @param allowTrackbacks the allow trackbacks of this s p asset entry
	*/
	@Override
	public void setAllowTrackbacks(boolean allowTrackbacks) {
		_spAssetEntry.setAllowTrackbacks(allowTrackbacks);
	}

	/**
	* Returns the trackbacks of this s p asset entry.
	*
	* @return the trackbacks of this s p asset entry
	*/
	@Override
	public java.lang.String getTrackbacks() {
		return _spAssetEntry.getTrackbacks();
	}

	/**
	* Sets the trackbacks of this s p asset entry.
	*
	* @param trackbacks the trackbacks of this s p asset entry
	*/
	@Override
	public void setTrackbacks(java.lang.String trackbacks) {
		_spAssetEntry.setTrackbacks(trackbacks);
	}

	/**
	* Returns the permission type of this s p asset entry.
	*
	* @return the permission type of this s p asset entry
	*/
	@Override
	public int getPermissionType() {
		return _spAssetEntry.getPermissionType();
	}

	/**
	* Sets the permission type of this s p asset entry.
	*
	* @param permissionType the permission type of this s p asset entry
	*/
	@Override
	public void setPermissionType(int permissionType) {
		_spAssetEntry.setPermissionType(permissionType);
	}

	/**
	* Returns the agreed to terms of use of this s p asset entry.
	*
	* @return the agreed to terms of use of this s p asset entry
	*/
	@Override
	public boolean getAgreedToTermsOfUse() {
		return _spAssetEntry.getAgreedToTermsOfUse();
	}

	/**
	* Returns <code>true</code> if this s p asset entry is agreed to terms of use.
	*
	* @return <code>true</code> if this s p asset entry is agreed to terms of use; <code>false</code> otherwise
	*/
	@Override
	public boolean isAgreedToTermsOfUse() {
		return _spAssetEntry.isAgreedToTermsOfUse();
	}

	/**
	* Sets whether this s p asset entry is agreed to terms of use.
	*
	* @param agreedToTermsOfUse the agreed to terms of use of this s p asset entry
	*/
	@Override
	public void setAgreedToTermsOfUse(boolean agreedToTermsOfUse) {
		_spAssetEntry.setAgreedToTermsOfUse(agreedToTermsOfUse);
	}

	@Override
	public boolean isNew() {
		return _spAssetEntry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spAssetEntry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spAssetEntry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spAssetEntry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spAssetEntry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spAssetEntry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spAssetEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spAssetEntry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spAssetEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spAssetEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spAssetEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPAssetEntryWrapper((SPAssetEntry)_spAssetEntry.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spasset.model.SPAssetEntry spAssetEntry) {
		return _spAssetEntry.compareTo(spAssetEntry);
	}

	@Override
	public int hashCode() {
		return _spAssetEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spasset.model.SPAssetEntry> toCacheModel() {
		return _spAssetEntry.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry toEscapedModel() {
		return new SPAssetEntryWrapper(_spAssetEntry.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spasset.model.SPAssetEntry toUnescapedModel() {
		return new SPAssetEntryWrapper(_spAssetEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spAssetEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spAssetEntry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spAssetEntry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPAssetEntryWrapper)) {
			return false;
		}

		SPAssetEntryWrapper spAssetEntryWrapper = (SPAssetEntryWrapper)obj;

		if (Validator.equals(_spAssetEntry, spAssetEntryWrapper._spAssetEntry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPAssetEntry getWrappedSPAssetEntry() {
		return _spAssetEntry;
	}

	@Override
	public SPAssetEntry getWrappedModel() {
		return _spAssetEntry;
	}

	@Override
	public void resetOriginalValues() {
		_spAssetEntry.resetOriginalValues();
	}

	private SPAssetEntry _spAssetEntry;
}