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
 * This class is a wrapper for {@link CourseOutcome}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseOutcome
 * @generated
 */
public class CourseOutcomeWrapper implements CourseOutcome,
	ModelWrapper<CourseOutcome> {
	public CourseOutcomeWrapper(CourseOutcome courseOutcome) {
		_courseOutcome = courseOutcome;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseOutcome.class;
	}

	@Override
	public String getModelClassName() {
		return CourseOutcome.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseOutcomeId", getSpCourseOutcomeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("outcomeId", getOutcomeId());
		attributes.put("outcomeDesc", getOutcomeDesc());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseOutcomeId = (Long)attributes.get("spCourseOutcomeId");

		if (spCourseOutcomeId != null) {
			setSpCourseOutcomeId(spCourseOutcomeId);
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

		Long outcomeId = (Long)attributes.get("outcomeId");

		if (outcomeId != null) {
			setOutcomeId(outcomeId);
		}

		String outcomeDesc = (String)attributes.get("outcomeDesc");

		if (outcomeDesc != null) {
			setOutcomeDesc(outcomeDesc);
		}
	}

	/**
	* Returns the primary key of this course outcome.
	*
	* @return the primary key of this course outcome
	*/
	@Override
	public long getPrimaryKey() {
		return _courseOutcome.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course outcome.
	*
	* @param primaryKey the primary key of this course outcome
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseOutcome.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp course outcome ID of this course outcome.
	*
	* @return the sp course outcome ID of this course outcome
	*/
	@Override
	public long getSpCourseOutcomeId() {
		return _courseOutcome.getSpCourseOutcomeId();
	}

	/**
	* Sets the sp course outcome ID of this course outcome.
	*
	* @param spCourseOutcomeId the sp course outcome ID of this course outcome
	*/
	@Override
	public void setSpCourseOutcomeId(long spCourseOutcomeId) {
		_courseOutcome.setSpCourseOutcomeId(spCourseOutcomeId);
	}

	/**
	* Returns the group ID of this course outcome.
	*
	* @return the group ID of this course outcome
	*/
	@Override
	public long getGroupId() {
		return _courseOutcome.getGroupId();
	}

	/**
	* Sets the group ID of this course outcome.
	*
	* @param groupId the group ID of this course outcome
	*/
	@Override
	public void setGroupId(long groupId) {
		_courseOutcome.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course outcome.
	*
	* @return the company ID of this course outcome
	*/
	@Override
	public long getCompanyId() {
		return _courseOutcome.getCompanyId();
	}

	/**
	* Sets the company ID of this course outcome.
	*
	* @param companyId the company ID of this course outcome
	*/
	@Override
	public void setCompanyId(long companyId) {
		_courseOutcome.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course outcome.
	*
	* @return the user ID of this course outcome
	*/
	@Override
	public long getUserId() {
		return _courseOutcome.getUserId();
	}

	/**
	* Sets the user ID of this course outcome.
	*
	* @param userId the user ID of this course outcome
	*/
	@Override
	public void setUserId(long userId) {
		_courseOutcome.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course outcome.
	*
	* @return the user uuid of this course outcome
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseOutcome.getUserUuid();
	}

	/**
	* Sets the user uuid of this course outcome.
	*
	* @param userUuid the user uuid of this course outcome
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseOutcome.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course outcome.
	*
	* @return the user name of this course outcome
	*/
	@Override
	public java.lang.String getUserName() {
		return _courseOutcome.getUserName();
	}

	/**
	* Sets the user name of this course outcome.
	*
	* @param userName the user name of this course outcome
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseOutcome.setUserName(userName);
	}

	/**
	* Returns the create date of this course outcome.
	*
	* @return the create date of this course outcome
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _courseOutcome.getCreateDate();
	}

	/**
	* Sets the create date of this course outcome.
	*
	* @param createDate the create date of this course outcome
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_courseOutcome.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course outcome.
	*
	* @return the modified date of this course outcome
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _courseOutcome.getModifiedDate();
	}

	/**
	* Sets the modified date of this course outcome.
	*
	* @param modifiedDate the modified date of this course outcome
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseOutcome.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp course ID of this course outcome.
	*
	* @return the sp course ID of this course outcome
	*/
	@Override
	public long getSpCourseId() {
		return _courseOutcome.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this course outcome.
	*
	* @param spCourseId the sp course ID of this course outcome
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_courseOutcome.setSpCourseId(spCourseId);
	}

	/**
	* Returns the outcome ID of this course outcome.
	*
	* @return the outcome ID of this course outcome
	*/
	@Override
	public long getOutcomeId() {
		return _courseOutcome.getOutcomeId();
	}

	/**
	* Sets the outcome ID of this course outcome.
	*
	* @param outcomeId the outcome ID of this course outcome
	*/
	@Override
	public void setOutcomeId(long outcomeId) {
		_courseOutcome.setOutcomeId(outcomeId);
	}

	/**
	* Returns the outcome desc of this course outcome.
	*
	* @return the outcome desc of this course outcome
	*/
	@Override
	public java.lang.String getOutcomeDesc() {
		return _courseOutcome.getOutcomeDesc();
	}

	/**
	* Sets the outcome desc of this course outcome.
	*
	* @param outcomeDesc the outcome desc of this course outcome
	*/
	@Override
	public void setOutcomeDesc(java.lang.String outcomeDesc) {
		_courseOutcome.setOutcomeDesc(outcomeDesc);
	}

	@Override
	public boolean isNew() {
		return _courseOutcome.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseOutcome.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseOutcome.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseOutcome.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseOutcome.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseOutcome.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseOutcome.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseOutcome.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseOutcome.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseOutcome.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseOutcome.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseOutcomeWrapper((CourseOutcome)_courseOutcome.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.CourseOutcome courseOutcome) {
		return _courseOutcome.compareTo(courseOutcome);
	}

	@Override
	public int hashCode() {
		return _courseOutcome.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.CourseOutcome> toCacheModel() {
		return _courseOutcome.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseOutcome toEscapedModel() {
		return new CourseOutcomeWrapper(_courseOutcome.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.CourseOutcome toUnescapedModel() {
		return new CourseOutcomeWrapper(_courseOutcome.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseOutcome.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseOutcome.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseOutcome.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseOutcomeWrapper)) {
			return false;
		}

		CourseOutcomeWrapper courseOutcomeWrapper = (CourseOutcomeWrapper)obj;

		if (Validator.equals(_courseOutcome, courseOutcomeWrapper._courseOutcome)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseOutcome getWrappedCourseOutcome() {
		return _courseOutcome;
	}

	@Override
	public CourseOutcome getWrappedModel() {
		return _courseOutcome;
	}

	@Override
	public void resetOriginalValues() {
		_courseOutcome.resetOriginalValues();
	}

	private CourseOutcome _courseOutcome;
}