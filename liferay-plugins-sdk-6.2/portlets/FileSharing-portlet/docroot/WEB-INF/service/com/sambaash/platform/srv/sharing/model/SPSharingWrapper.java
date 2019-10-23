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

package com.sambaash.platform.srv.sharing.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPSharing}.
 * </p>
 *
 * @author harini
 * @see SPSharing
 * @generated
 */
public class SPSharingWrapper implements SPSharing, ModelWrapper<SPSharing> {
	public SPSharingWrapper(SPSharing spSharing) {
		_spSharing = spSharing;
	}

	@Override
	public Class<?> getModelClass() {
		return SPSharing.class;
	}

	@Override
	public String getModelClassName() {
		return SPSharing.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spSharingId", getSpSharingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("classNameId", getClassNameId());
		attributes.put("classPK", getClassPK());
		attributes.put("duration", getDuration());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("url", getUrl());
		attributes.put("expired", getExpired());
		attributes.put("internalShare", getInternalShare());
		attributes.put("writePermission", getWritePermission());
		attributes.put("viewCount", getViewCount());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spSharingId = (Long)attributes.get("spSharingId");

		if (spSharingId != null) {
			setSpSharingId(spSharingId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
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

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Long classNameId = (Long)attributes.get("classNameId");

		if (classNameId != null) {
			setClassNameId(classNameId);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		Integer duration = (Integer)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		String url = (String)attributes.get("url");

		if (url != null) {
			setUrl(url);
		}

		Boolean expired = (Boolean)attributes.get("expired");

		if (expired != null) {
			setExpired(expired);
		}

		Boolean internalShare = (Boolean)attributes.get("internalShare");

		if (internalShare != null) {
			setInternalShare(internalShare);
		}

		Boolean writePermission = (Boolean)attributes.get("writePermission");

		if (writePermission != null) {
			setWritePermission(writePermission);
		}

		Integer viewCount = (Integer)attributes.get("viewCount");

		if (viewCount != null) {
			setViewCount(viewCount);
		}
	}

	/**
	* Returns the primary key of this s p sharing.
	*
	* @return the primary key of this s p sharing
	*/
	@Override
	public long getPrimaryKey() {
		return _spSharing.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p sharing.
	*
	* @param primaryKey the primary key of this s p sharing
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spSharing.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp sharing ID of this s p sharing.
	*
	* @return the sp sharing ID of this s p sharing
	*/
	@Override
	public long getSpSharingId() {
		return _spSharing.getSpSharingId();
	}

	/**
	* Sets the sp sharing ID of this s p sharing.
	*
	* @param spSharingId the sp sharing ID of this s p sharing
	*/
	@Override
	public void setSpSharingId(long spSharingId) {
		_spSharing.setSpSharingId(spSharingId);
	}

	/**
	* Returns the group ID of this s p sharing.
	*
	* @return the group ID of this s p sharing
	*/
	@Override
	public long getGroupId() {
		return _spSharing.getGroupId();
	}

	/**
	* Sets the group ID of this s p sharing.
	*
	* @param groupId the group ID of this s p sharing
	*/
	@Override
	public void setGroupId(long groupId) {
		_spSharing.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p sharing.
	*
	* @return the company ID of this s p sharing
	*/
	@Override
	public long getCompanyId() {
		return _spSharing.getCompanyId();
	}

	/**
	* Sets the company ID of this s p sharing.
	*
	* @param companyId the company ID of this s p sharing
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spSharing.setCompanyId(companyId);
	}

	/**
	* Returns the created by of this s p sharing.
	*
	* @return the created by of this s p sharing
	*/
	@Override
	public long getCreatedBy() {
		return _spSharing.getCreatedBy();
	}

	/**
	* Sets the created by of this s p sharing.
	*
	* @param createdBy the created by of this s p sharing
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_spSharing.setCreatedBy(createdBy);
	}

	/**
	* Returns the user name of this s p sharing.
	*
	* @return the user name of this s p sharing
	*/
	@Override
	public java.lang.String getUserName() {
		return _spSharing.getUserName();
	}

	/**
	* Sets the user name of this s p sharing.
	*
	* @param userName the user name of this s p sharing
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spSharing.setUserName(userName);
	}

	/**
	* Returns the create date of this s p sharing.
	*
	* @return the create date of this s p sharing
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spSharing.getCreateDate();
	}

	/**
	* Sets the create date of this s p sharing.
	*
	* @param createDate the create date of this s p sharing
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spSharing.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p sharing.
	*
	* @return the modified date of this s p sharing
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spSharing.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p sharing.
	*
	* @param modifiedDate the modified date of this s p sharing
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spSharing.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this s p sharing.
	*
	* @return the user ID of this s p sharing
	*/
	@Override
	public long getUserId() {
		return _spSharing.getUserId();
	}

	/**
	* Sets the user ID of this s p sharing.
	*
	* @param userId the user ID of this s p sharing
	*/
	@Override
	public void setUserId(long userId) {
		_spSharing.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p sharing.
	*
	* @return the user uuid of this s p sharing
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spSharing.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p sharing.
	*
	* @param userUuid the user uuid of this s p sharing
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spSharing.setUserUuid(userUuid);
	}

	/**
	* Returns the email address of this s p sharing.
	*
	* @return the email address of this s p sharing
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spSharing.getEmailAddress();
	}

	/**
	* Sets the email address of this s p sharing.
	*
	* @param emailAddress the email address of this s p sharing
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spSharing.setEmailAddress(emailAddress);
	}

	/**
	* Returns the fully qualified class name of this s p sharing.
	*
	* @return the fully qualified class name of this s p sharing
	*/
	@Override
	public java.lang.String getClassName() {
		return _spSharing.getClassName();
	}

	@Override
	public void setClassName(java.lang.String className) {
		_spSharing.setClassName(className);
	}

	/**
	* Returns the class name ID of this s p sharing.
	*
	* @return the class name ID of this s p sharing
	*/
	@Override
	public long getClassNameId() {
		return _spSharing.getClassNameId();
	}

	/**
	* Sets the class name ID of this s p sharing.
	*
	* @param classNameId the class name ID of this s p sharing
	*/
	@Override
	public void setClassNameId(long classNameId) {
		_spSharing.setClassNameId(classNameId);
	}

	/**
	* Returns the class p k of this s p sharing.
	*
	* @return the class p k of this s p sharing
	*/
	@Override
	public long getClassPK() {
		return _spSharing.getClassPK();
	}

	/**
	* Sets the class p k of this s p sharing.
	*
	* @param classPK the class p k of this s p sharing
	*/
	@Override
	public void setClassPK(long classPK) {
		_spSharing.setClassPK(classPK);
	}

	/**
	* Returns the duration of this s p sharing.
	*
	* @return the duration of this s p sharing
	*/
	@Override
	public int getDuration() {
		return _spSharing.getDuration();
	}

	/**
	* Sets the duration of this s p sharing.
	*
	* @param duration the duration of this s p sharing
	*/
	@Override
	public void setDuration(int duration) {
		_spSharing.setDuration(duration);
	}

	/**
	* Returns the start date of this s p sharing.
	*
	* @return the start date of this s p sharing
	*/
	@Override
	public java.util.Date getStartDate() {
		return _spSharing.getStartDate();
	}

	/**
	* Sets the start date of this s p sharing.
	*
	* @param startDate the start date of this s p sharing
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_spSharing.setStartDate(startDate);
	}

	/**
	* Returns the end date of this s p sharing.
	*
	* @return the end date of this s p sharing
	*/
	@Override
	public java.util.Date getEndDate() {
		return _spSharing.getEndDate();
	}

	/**
	* Sets the end date of this s p sharing.
	*
	* @param endDate the end date of this s p sharing
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_spSharing.setEndDate(endDate);
	}

	/**
	* Returns the url of this s p sharing.
	*
	* @return the url of this s p sharing
	*/
	@Override
	public java.lang.String getUrl() {
		return _spSharing.getUrl();
	}

	/**
	* Sets the url of this s p sharing.
	*
	* @param url the url of this s p sharing
	*/
	@Override
	public void setUrl(java.lang.String url) {
		_spSharing.setUrl(url);
	}

	/**
	* Returns the expired of this s p sharing.
	*
	* @return the expired of this s p sharing
	*/
	@Override
	public boolean getExpired() {
		return _spSharing.getExpired();
	}

	/**
	* Returns <code>true</code> if this s p sharing is expired.
	*
	* @return <code>true</code> if this s p sharing is expired; <code>false</code> otherwise
	*/
	@Override
	public boolean isExpired() {
		return _spSharing.isExpired();
	}

	/**
	* Sets whether this s p sharing is expired.
	*
	* @param expired the expired of this s p sharing
	*/
	@Override
	public void setExpired(boolean expired) {
		_spSharing.setExpired(expired);
	}

	/**
	* Returns the internal share of this s p sharing.
	*
	* @return the internal share of this s p sharing
	*/
	@Override
	public boolean getInternalShare() {
		return _spSharing.getInternalShare();
	}

	/**
	* Returns <code>true</code> if this s p sharing is internal share.
	*
	* @return <code>true</code> if this s p sharing is internal share; <code>false</code> otherwise
	*/
	@Override
	public boolean isInternalShare() {
		return _spSharing.isInternalShare();
	}

	/**
	* Sets whether this s p sharing is internal share.
	*
	* @param internalShare the internal share of this s p sharing
	*/
	@Override
	public void setInternalShare(boolean internalShare) {
		_spSharing.setInternalShare(internalShare);
	}

	/**
	* Returns the write permission of this s p sharing.
	*
	* @return the write permission of this s p sharing
	*/
	@Override
	public boolean getWritePermission() {
		return _spSharing.getWritePermission();
	}

	/**
	* Returns <code>true</code> if this s p sharing is write permission.
	*
	* @return <code>true</code> if this s p sharing is write permission; <code>false</code> otherwise
	*/
	@Override
	public boolean isWritePermission() {
		return _spSharing.isWritePermission();
	}

	/**
	* Sets whether this s p sharing is write permission.
	*
	* @param writePermission the write permission of this s p sharing
	*/
	@Override
	public void setWritePermission(boolean writePermission) {
		_spSharing.setWritePermission(writePermission);
	}

	/**
	* Returns the view count of this s p sharing.
	*
	* @return the view count of this s p sharing
	*/
	@Override
	public int getViewCount() {
		return _spSharing.getViewCount();
	}

	/**
	* Sets the view count of this s p sharing.
	*
	* @param viewCount the view count of this s p sharing
	*/
	@Override
	public void setViewCount(int viewCount) {
		_spSharing.setViewCount(viewCount);
	}

	@Override
	public boolean isNew() {
		return _spSharing.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spSharing.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spSharing.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spSharing.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spSharing.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spSharing.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spSharing.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spSharing.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spSharing.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spSharing.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spSharing.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPSharingWrapper((SPSharing)_spSharing.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.sharing.model.SPSharing spSharing) {
		return _spSharing.compareTo(spSharing);
	}

	@Override
	public int hashCode() {
		return _spSharing.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.sharing.model.SPSharing> toCacheModel() {
		return _spSharing.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing toEscapedModel() {
		return new SPSharingWrapper(_spSharing.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.sharing.model.SPSharing toUnescapedModel() {
		return new SPSharingWrapper(_spSharing.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spSharing.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spSharing.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spSharing.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPSharingWrapper)) {
			return false;
		}

		SPSharingWrapper spSharingWrapper = (SPSharingWrapper)obj;

		if (Validator.equals(_spSharing, spSharingWrapper._spSharing)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPSharing getWrappedSPSharing() {
		return _spSharing;
	}

	@Override
	public SPSharing getWrappedModel() {
		return _spSharing;
	}

	@Override
	public void resetOriginalValues() {
		_spSharing.resetOriginalValues();
	}

	private SPSharing _spSharing;
}