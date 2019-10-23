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
 * This class is a wrapper for {@link CourseDuration}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseDuration
 * @generated
 */
public class CourseDurationWrapper implements CourseDuration,
	ModelWrapper<CourseDuration> {
	public CourseDurationWrapper(CourseDuration courseDuration) {
		_courseDuration = courseDuration;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseDuration.class;
	}

	@Override
	public String getModelClassName() {
		return CourseDuration.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseDurationId", getSpCourseDurationId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("spCourseLearningId", getSpCourseLearningId());
		attributes.put("title", getTitle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseDurationId = (Long)attributes.get("spCourseDurationId");

		if (spCourseDurationId != null) {
			setSpCourseDurationId(spCourseDurationId);
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

		Long spCourseLearningId = (Long)attributes.get("spCourseLearningId");

		if (spCourseLearningId != null) {
			setSpCourseLearningId(spCourseLearningId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}
	}

	/**
	* Returns the primary key of this course duration.
	*
	* @return the primary key of this course duration
	*/
	@Override
	public long getPrimaryKey() {
		return _courseDuration.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course duration.
	*
	* @param primaryKey the primary key of this course duration
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseDuration.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp course duration ID of this course duration.
	*
	* @return the sp course duration ID of this course duration
	*/
	@Override
	public long getSpCourseDurationId() {
		return _courseDuration.getSpCourseDurationId();
	}

	/**
	* Sets the sp course duration ID of this course duration.
	*
	* @param spCourseDurationId the sp course duration ID of this course duration
	*/
	@Override
	public void setSpCourseDurationId(long spCourseDurationId) {
		_courseDuration.setSpCourseDurationId(spCourseDurationId);
	}

	/**
	* Returns the group ID of this course duration.
	*
	* @return the group ID of this course duration
	*/
	@Override
	public long getGroupId() {
		return _courseDuration.getGroupId();
	}

	/**
	* Sets the group ID of this course duration.
	*
	* @param groupId the group ID of this course duration
	*/
	@Override
	public void setGroupId(long groupId) {
		_courseDuration.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course duration.
	*
	* @return the company ID of this course duration
	*/
	@Override
	public long getCompanyId() {
		return _courseDuration.getCompanyId();
	}

	/**
	* Sets the company ID of this course duration.
	*
	* @param companyId the company ID of this course duration
	*/
	@Override
	public void setCompanyId(long companyId) {
		_courseDuration.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course duration.
	*
	* @return the user ID of this course duration
	*/
	@Override
	public long getUserId() {
		return _courseDuration.getUserId();
	}

	/**
	* Sets the user ID of this course duration.
	*
	* @param userId the user ID of this course duration
	*/
	@Override
	public void setUserId(long userId) {
		_courseDuration.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course duration.
	*
	* @return the user uuid of this course duration
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDuration.getUserUuid();
	}

	/**
	* Sets the user uuid of this course duration.
	*
	* @param userUuid the user uuid of this course duration
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseDuration.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course duration.
	*
	* @return the user name of this course duration
	*/
	@Override
	public java.lang.String getUserName() {
		return _courseDuration.getUserName();
	}

	/**
	* Sets the user name of this course duration.
	*
	* @param userName the user name of this course duration
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseDuration.setUserName(userName);
	}

	/**
	* Returns the create date of this course duration.
	*
	* @return the create date of this course duration
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _courseDuration.getCreateDate();
	}

	/**
	* Sets the create date of this course duration.
	*
	* @param createDate the create date of this course duration
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_courseDuration.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course duration.
	*
	* @return the modified date of this course duration
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _courseDuration.getModifiedDate();
	}

	/**
	* Sets the modified date of this course duration.
	*
	* @param modifiedDate the modified date of this course duration
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseDuration.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp course ID of this course duration.
	*
	* @return the sp course ID of this course duration
	*/
	@Override
	public long getSpCourseId() {
		return _courseDuration.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this course duration.
	*
	* @param spCourseId the sp course ID of this course duration
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_courseDuration.setSpCourseId(spCourseId);
	}

	/**
	* Returns the sp course learning ID of this course duration.
	*
	* @return the sp course learning ID of this course duration
	*/
	@Override
	public long getSpCourseLearningId() {
		return _courseDuration.getSpCourseLearningId();
	}

	/**
	* Sets the sp course learning ID of this course duration.
	*
	* @param spCourseLearningId the sp course learning ID of this course duration
	*/
	@Override
	public void setSpCourseLearningId(long spCourseLearningId) {
		_courseDuration.setSpCourseLearningId(spCourseLearningId);
	}

	/**
	* Returns the title of this course duration.
	*
	* @return the title of this course duration
	*/
	@Override
	public java.lang.String getTitle() {
		return _courseDuration.getTitle();
	}

	/**
	* Sets the title of this course duration.
	*
	* @param title the title of this course duration
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_courseDuration.setTitle(title);
	}

	@Override
	public boolean isNew() {
		return _courseDuration.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseDuration.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseDuration.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseDuration.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseDuration.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseDuration.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseDuration.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseDuration.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseDuration.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseDuration.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseDuration.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseDurationWrapper((CourseDuration)_courseDuration.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.CourseDuration courseDuration) {
		return _courseDuration.compareTo(courseDuration);
	}

	@Override
	public int hashCode() {
		return _courseDuration.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.CourseDuration> toCacheModel() {
		return _courseDuration.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseDuration toEscapedModel() {
		return new CourseDurationWrapper(_courseDuration.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.CourseDuration toUnescapedModel() {
		return new CourseDurationWrapper(_courseDuration.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseDuration.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseDuration.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseDuration.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseDurationWrapper)) {
			return false;
		}

		CourseDurationWrapper courseDurationWrapper = (CourseDurationWrapper)obj;

		if (Validator.equals(_courseDuration,
					courseDurationWrapper._courseDuration)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseDuration getWrappedCourseDuration() {
		return _courseDuration;
	}

	@Override
	public CourseDuration getWrappedModel() {
		return _courseDuration;
	}

	@Override
	public void resetOriginalValues() {
		_courseDuration.resetOriginalValues();
	}

	private CourseDuration _courseDuration;
}