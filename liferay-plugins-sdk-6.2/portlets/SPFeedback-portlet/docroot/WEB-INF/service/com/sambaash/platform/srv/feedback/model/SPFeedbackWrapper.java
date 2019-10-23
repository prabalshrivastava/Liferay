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

package com.sambaash.platform.srv.feedback.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPFeedback}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPFeedback
 * @generated
 */
public class SPFeedbackWrapper implements SPFeedback, ModelWrapper<SPFeedback> {
	public SPFeedbackWrapper(SPFeedback spFeedback) {
		_spFeedback = spFeedback;
	}

	@Override
	public Class<?> getModelClass() {
		return SPFeedback.class;
	}

	@Override
	public String getModelClassName() {
		return SPFeedback.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spFeedbackId", getSpFeedbackId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("type", getType());
		attributes.put("description", getDescription());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spFeedbackId = (Long)attributes.get("spFeedbackId");

		if (spFeedbackId != null) {
			setSpFeedbackId(spFeedbackId);
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

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}
	}

	/**
	* Returns the primary key of this s p feedback.
	*
	* @return the primary key of this s p feedback
	*/
	@Override
	public long getPrimaryKey() {
		return _spFeedback.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p feedback.
	*
	* @param primaryKey the primary key of this s p feedback
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spFeedback.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp feedback ID of this s p feedback.
	*
	* @return the sp feedback ID of this s p feedback
	*/
	@Override
	public long getSpFeedbackId() {
		return _spFeedback.getSpFeedbackId();
	}

	/**
	* Sets the sp feedback ID of this s p feedback.
	*
	* @param spFeedbackId the sp feedback ID of this s p feedback
	*/
	@Override
	public void setSpFeedbackId(long spFeedbackId) {
		_spFeedback.setSpFeedbackId(spFeedbackId);
	}

	/**
	* Returns the group ID of this s p feedback.
	*
	* @return the group ID of this s p feedback
	*/
	@Override
	public long getGroupId() {
		return _spFeedback.getGroupId();
	}

	/**
	* Sets the group ID of this s p feedback.
	*
	* @param groupId the group ID of this s p feedback
	*/
	@Override
	public void setGroupId(long groupId) {
		_spFeedback.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p feedback.
	*
	* @return the company ID of this s p feedback
	*/
	@Override
	public long getCompanyId() {
		return _spFeedback.getCompanyId();
	}

	/**
	* Sets the company ID of this s p feedback.
	*
	* @param companyId the company ID of this s p feedback
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spFeedback.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p feedback.
	*
	* @return the user ID of this s p feedback
	*/
	@Override
	public long getUserId() {
		return _spFeedback.getUserId();
	}

	/**
	* Sets the user ID of this s p feedback.
	*
	* @param userId the user ID of this s p feedback
	*/
	@Override
	public void setUserId(long userId) {
		_spFeedback.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p feedback.
	*
	* @return the user uuid of this s p feedback
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spFeedback.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p feedback.
	*
	* @param userUuid the user uuid of this s p feedback
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spFeedback.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p feedback.
	*
	* @return the user name of this s p feedback
	*/
	@Override
	public java.lang.String getUserName() {
		return _spFeedback.getUserName();
	}

	/**
	* Sets the user name of this s p feedback.
	*
	* @param userName the user name of this s p feedback
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spFeedback.setUserName(userName);
	}

	/**
	* Returns the create date of this s p feedback.
	*
	* @return the create date of this s p feedback
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spFeedback.getCreateDate();
	}

	/**
	* Sets the create date of this s p feedback.
	*
	* @param createDate the create date of this s p feedback
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spFeedback.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p feedback.
	*
	* @return the modified date of this s p feedback
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spFeedback.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p feedback.
	*
	* @param modifiedDate the modified date of this s p feedback
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spFeedback.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the type of this s p feedback.
	*
	* @return the type of this s p feedback
	*/
	@Override
	public java.lang.String getType() {
		return _spFeedback.getType();
	}

	/**
	* Sets the type of this s p feedback.
	*
	* @param type the type of this s p feedback
	*/
	@Override
	public void setType(java.lang.String type) {
		_spFeedback.setType(type);
	}

	/**
	* Returns the description of this s p feedback.
	*
	* @return the description of this s p feedback
	*/
	@Override
	public java.lang.String getDescription() {
		return _spFeedback.getDescription();
	}

	/**
	* Sets the description of this s p feedback.
	*
	* @param description the description of this s p feedback
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_spFeedback.setDescription(description);
	}

	@Override
	public boolean isNew() {
		return _spFeedback.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spFeedback.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spFeedback.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spFeedback.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spFeedback.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spFeedback.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spFeedback.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spFeedback.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spFeedback.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spFeedback.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spFeedback.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPFeedbackWrapper((SPFeedback)_spFeedback.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.feedback.model.SPFeedback spFeedback) {
		return _spFeedback.compareTo(spFeedback);
	}

	@Override
	public int hashCode() {
		return _spFeedback.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.feedback.model.SPFeedback> toCacheModel() {
		return _spFeedback.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.feedback.model.SPFeedback toEscapedModel() {
		return new SPFeedbackWrapper(_spFeedback.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.feedback.model.SPFeedback toUnescapedModel() {
		return new SPFeedbackWrapper(_spFeedback.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spFeedback.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spFeedback.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spFeedback.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPFeedbackWrapper)) {
			return false;
		}

		SPFeedbackWrapper spFeedbackWrapper = (SPFeedbackWrapper)obj;

		if (Validator.equals(_spFeedback, spFeedbackWrapper._spFeedback)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPFeedback getWrappedSPFeedback() {
		return _spFeedback;
	}

	@Override
	public SPFeedback getWrappedModel() {
		return _spFeedback;
	}

	@Override
	public void resetOriginalValues() {
		_spFeedback.resetOriginalValues();
	}

	private SPFeedback _spFeedback;
}