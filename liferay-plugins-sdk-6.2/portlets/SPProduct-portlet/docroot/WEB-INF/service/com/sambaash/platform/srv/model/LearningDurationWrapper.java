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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link LearningDuration}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see LearningDuration
 * @generated
 */
public class LearningDurationWrapper implements LearningDuration,
	ModelWrapper<LearningDuration> {
	public LearningDurationWrapper(LearningDuration learningDuration) {
		_learningDuration = learningDuration;
	}

	@Override
	public Class<?> getModelClass() {
		return LearningDuration.class;
	}

	@Override
	public String getModelClassName() {
		return LearningDuration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spLearningDurationId", getSpLearningDurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spLearningDurationId = (Long)attributes.get("spLearningDurationId");

		if (spLearningDurationId != null) {
			setSpLearningDurationId(spLearningDurationId);
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

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	/**
	* Returns the primary key of this learning duration.
	*
	* @return the primary key of this learning duration
	*/
	@Override
	public long getPrimaryKey() {
		return _learningDuration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this learning duration.
	*
	* @param primaryKey the primary key of this learning duration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_learningDuration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp learning duration ID of this learning duration.
	*
	* @return the sp learning duration ID of this learning duration
	*/
	@Override
	public long getSpLearningDurationId() {
		return _learningDuration.getSpLearningDurationId();
	}

	/**
	* Sets the sp learning duration ID of this learning duration.
	*
	* @param spLearningDurationId the sp learning duration ID of this learning duration
	*/
	@Override
	public void setSpLearningDurationId(long spLearningDurationId) {
		_learningDuration.setSpLearningDurationId(spLearningDurationId);
	}

	/**
	* Returns the group ID of this learning duration.
	*
	* @return the group ID of this learning duration
	*/
	@Override
	public long getGroupId() {
		return _learningDuration.getGroupId();
	}

	/**
	* Sets the group ID of this learning duration.
	*
	* @param groupId the group ID of this learning duration
	*/
	@Override
	public void setGroupId(long groupId) {
		_learningDuration.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this learning duration.
	*
	* @return the company ID of this learning duration
	*/
	@Override
	public long getCompanyId() {
		return _learningDuration.getCompanyId();
	}

	/**
	* Sets the company ID of this learning duration.
	*
	* @param companyId the company ID of this learning duration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_learningDuration.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this learning duration.
	*
	* @return the user ID of this learning duration
	*/
	@Override
	public long getUserId() {
		return _learningDuration.getUserId();
	}

	/**
	* Sets the user ID of this learning duration.
	*
	* @param userId the user ID of this learning duration
	*/
	@Override
	public void setUserId(long userId) {
		_learningDuration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this learning duration.
	*
	* @return the user uuid of this learning duration
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learningDuration.getUserUuid();
	}

	/**
	* Sets the user uuid of this learning duration.
	*
	* @param userUuid the user uuid of this learning duration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_learningDuration.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this learning duration.
	*
	* @return the user name of this learning duration
	*/
	@Override
	public java.lang.String getUserName() {
		return _learningDuration.getUserName();
	}

	/**
	* Sets the user name of this learning duration.
	*
	* @param userName the user name of this learning duration
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_learningDuration.setUserName(userName);
	}

	/**
	* Returns the create date of this learning duration.
	*
	* @return the create date of this learning duration
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _learningDuration.getCreateDate();
	}

	/**
	* Sets the create date of this learning duration.
	*
	* @param createDate the create date of this learning duration
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_learningDuration.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this learning duration.
	*
	* @return the modified date of this learning duration
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _learningDuration.getModifiedDate();
	}

	/**
	* Sets the modified date of this learning duration.
	*
	* @param modifiedDate the modified date of this learning duration
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_learningDuration.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp course ID of this learning duration.
	*
	* @return the sp course ID of this learning duration
	*/
	@Override
	public long getSpCourseId() {
		return _learningDuration.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this learning duration.
	*
	* @param spCourseId the sp course ID of this learning duration
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_learningDuration.setSpCourseId(spCourseId);
	}

	/**
	* Returns the title of this learning duration.
	*
	* @return the title of this learning duration
	*/
	@Override
	public java.lang.String getTitle() {
		return _learningDuration.getTitle();
	}

	/**
	* Sets the title of this learning duration.
	*
	* @param title the title of this learning duration
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_learningDuration.setTitle(title);
	}

	@Override
	public boolean isNew() {
		return _learningDuration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_learningDuration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _learningDuration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_learningDuration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _learningDuration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _learningDuration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_learningDuration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _learningDuration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_learningDuration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_learningDuration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_learningDuration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LearningDurationWrapper((LearningDuration)_learningDuration.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.LearningDuration learningDuration) {
		return _learningDuration.compareTo(learningDuration);
	}

	@Override
	public int hashCode() {
		return _learningDuration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.LearningDuration> toCacheModel() {
		return _learningDuration.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.LearningDuration toEscapedModel() {
		return new LearningDurationWrapper(_learningDuration.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.LearningDuration toUnescapedModel() {
		return new LearningDurationWrapper(_learningDuration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _learningDuration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _learningDuration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_learningDuration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LearningDurationWrapper)) {
			return false;
		}

		LearningDurationWrapper learningDurationWrapper = (LearningDurationWrapper)obj;

		if (Validator.equals(_learningDuration,
					learningDurationWrapper._learningDuration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LearningDuration getWrappedLearningDuration() {
		return _learningDuration;
	}

	@Override
	public LearningDuration getWrappedModel() {
		return _learningDuration;
	}

	@Override
	public void resetOriginalValues() {
		_learningDuration.resetOriginalValues();
	}

	private LearningDuration _learningDuration;
}