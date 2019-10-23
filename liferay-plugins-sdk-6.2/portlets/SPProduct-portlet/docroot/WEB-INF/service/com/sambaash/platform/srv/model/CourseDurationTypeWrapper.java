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
 * This class is a wrapper for {@link CourseDurationType}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseDurationType
 * @generated
 */
public class CourseDurationTypeWrapper implements CourseDurationType,
	ModelWrapper<CourseDurationType> {
	public CourseDurationTypeWrapper(CourseDurationType courseDurationType) {
		_courseDurationType = courseDurationType;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseDurationType.class;
	}

	@Override
	public String getModelClassName() {
		return CourseDurationType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseDurationTypeId", getSpCourseDurationTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseDurationId", getSpCourseDurationId());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("title1", getTitle1());
		attributes.put("duration1", getDuration1());
		attributes.put("title2", getTitle2());
		attributes.put("duration2", getDuration2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseDurationTypeId = (Long)attributes.get(
				"spCourseDurationTypeId");

		if (spCourseDurationTypeId != null) {
			setSpCourseDurationTypeId(spCourseDurationTypeId);
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

		Long spCourseDurationId = (Long)attributes.get("spCourseDurationId");

		if (spCourseDurationId != null) {
			setSpCourseDurationId(spCourseDurationId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}

		String title1 = (String)attributes.get("title1");

		if (title1 != null) {
			setTitle1(title1);
		}

		String duration1 = (String)attributes.get("duration1");

		if (duration1 != null) {
			setDuration1(duration1);
		}

		String title2 = (String)attributes.get("title2");

		if (title2 != null) {
			setTitle2(title2);
		}

		String duration2 = (String)attributes.get("duration2");

		if (duration2 != null) {
			setDuration2(duration2);
		}
	}

	/**
	* Returns the primary key of this course duration type.
	*
	* @return the primary key of this course duration type
	*/
	@Override
	public long getPrimaryKey() {
		return _courseDurationType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course duration type.
	*
	* @param primaryKey the primary key of this course duration type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseDurationType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp course duration type ID of this course duration type.
	*
	* @return the sp course duration type ID of this course duration type
	*/
	@Override
	public long getSpCourseDurationTypeId() {
		return _courseDurationType.getSpCourseDurationTypeId();
	}

	/**
	* Sets the sp course duration type ID of this course duration type.
	*
	* @param spCourseDurationTypeId the sp course duration type ID of this course duration type
	*/
	@Override
	public void setSpCourseDurationTypeId(long spCourseDurationTypeId) {
		_courseDurationType.setSpCourseDurationTypeId(spCourseDurationTypeId);
	}

	/**
	* Returns the group ID of this course duration type.
	*
	* @return the group ID of this course duration type
	*/
	@Override
	public long getGroupId() {
		return _courseDurationType.getGroupId();
	}

	/**
	* Sets the group ID of this course duration type.
	*
	* @param groupId the group ID of this course duration type
	*/
	@Override
	public void setGroupId(long groupId) {
		_courseDurationType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course duration type.
	*
	* @return the company ID of this course duration type
	*/
	@Override
	public long getCompanyId() {
		return _courseDurationType.getCompanyId();
	}

	/**
	* Sets the company ID of this course duration type.
	*
	* @param companyId the company ID of this course duration type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_courseDurationType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course duration type.
	*
	* @return the user ID of this course duration type
	*/
	@Override
	public long getUserId() {
		return _courseDurationType.getUserId();
	}

	/**
	* Sets the user ID of this course duration type.
	*
	* @param userId the user ID of this course duration type
	*/
	@Override
	public void setUserId(long userId) {
		_courseDurationType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course duration type.
	*
	* @return the user uuid of this course duration type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseDurationType.getUserUuid();
	}

	/**
	* Sets the user uuid of this course duration type.
	*
	* @param userUuid the user uuid of this course duration type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseDurationType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course duration type.
	*
	* @return the user name of this course duration type
	*/
	@Override
	public java.lang.String getUserName() {
		return _courseDurationType.getUserName();
	}

	/**
	* Sets the user name of this course duration type.
	*
	* @param userName the user name of this course duration type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseDurationType.setUserName(userName);
	}

	/**
	* Returns the create date of this course duration type.
	*
	* @return the create date of this course duration type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _courseDurationType.getCreateDate();
	}

	/**
	* Sets the create date of this course duration type.
	*
	* @param createDate the create date of this course duration type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_courseDurationType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course duration type.
	*
	* @return the modified date of this course duration type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _courseDurationType.getModifiedDate();
	}

	/**
	* Sets the modified date of this course duration type.
	*
	* @param modifiedDate the modified date of this course duration type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseDurationType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp course duration ID of this course duration type.
	*
	* @return the sp course duration ID of this course duration type
	*/
	@Override
	public long getSpCourseDurationId() {
		return _courseDurationType.getSpCourseDurationId();
	}

	/**
	* Sets the sp course duration ID of this course duration type.
	*
	* @param spCourseDurationId the sp course duration ID of this course duration type
	*/
	@Override
	public void setSpCourseDurationId(long spCourseDurationId) {
		_courseDurationType.setSpCourseDurationId(spCourseDurationId);
	}

	/**
	* Returns the sp course ID of this course duration type.
	*
	* @return the sp course ID of this course duration type
	*/
	@Override
	public long getSpCourseId() {
		return _courseDurationType.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this course duration type.
	*
	* @param spCourseId the sp course ID of this course duration type
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_courseDurationType.setSpCourseId(spCourseId);
	}

	/**
	* Returns the title1 of this course duration type.
	*
	* @return the title1 of this course duration type
	*/
	@Override
	public java.lang.String getTitle1() {
		return _courseDurationType.getTitle1();
	}

	/**
	* Sets the title1 of this course duration type.
	*
	* @param title1 the title1 of this course duration type
	*/
	@Override
	public void setTitle1(java.lang.String title1) {
		_courseDurationType.setTitle1(title1);
	}

	/**
	* Returns the duration1 of this course duration type.
	*
	* @return the duration1 of this course duration type
	*/
	@Override
	public java.lang.String getDuration1() {
		return _courseDurationType.getDuration1();
	}

	/**
	* Sets the duration1 of this course duration type.
	*
	* @param duration1 the duration1 of this course duration type
	*/
	@Override
	public void setDuration1(java.lang.String duration1) {
		_courseDurationType.setDuration1(duration1);
	}

	/**
	* Returns the title2 of this course duration type.
	*
	* @return the title2 of this course duration type
	*/
	@Override
	public java.lang.String getTitle2() {
		return _courseDurationType.getTitle2();
	}

	/**
	* Sets the title2 of this course duration type.
	*
	* @param title2 the title2 of this course duration type
	*/
	@Override
	public void setTitle2(java.lang.String title2) {
		_courseDurationType.setTitle2(title2);
	}

	/**
	* Returns the duration2 of this course duration type.
	*
	* @return the duration2 of this course duration type
	*/
	@Override
	public java.lang.String getDuration2() {
		return _courseDurationType.getDuration2();
	}

	/**
	* Sets the duration2 of this course duration type.
	*
	* @param duration2 the duration2 of this course duration type
	*/
	@Override
	public void setDuration2(java.lang.String duration2) {
		_courseDurationType.setDuration2(duration2);
	}

	@Override
	public boolean isNew() {
		return _courseDurationType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseDurationType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseDurationType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseDurationType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseDurationType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseDurationType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseDurationType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseDurationType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseDurationType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseDurationType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseDurationType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseDurationTypeWrapper((CourseDurationType)_courseDurationType.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.CourseDurationType courseDurationType) {
		return _courseDurationType.compareTo(courseDurationType);
	}

	@Override
	public int hashCode() {
		return _courseDurationType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.CourseDurationType> toCacheModel() {
		return _courseDurationType.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseDurationType toEscapedModel() {
		return new CourseDurationTypeWrapper(_courseDurationType.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.CourseDurationType toUnescapedModel() {
		return new CourseDurationTypeWrapper(_courseDurationType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseDurationType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseDurationType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseDurationType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseDurationTypeWrapper)) {
			return false;
		}

		CourseDurationTypeWrapper courseDurationTypeWrapper = (CourseDurationTypeWrapper)obj;

		if (Validator.equals(_courseDurationType,
					courseDurationTypeWrapper._courseDurationType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseDurationType getWrappedCourseDurationType() {
		return _courseDurationType;
	}

	@Override
	public CourseDurationType getWrappedModel() {
		return _courseDurationType;
	}

	@Override
	public void resetOriginalValues() {
		_courseDurationType.resetOriginalValues();
	}

	private CourseDurationType _courseDurationType;
}