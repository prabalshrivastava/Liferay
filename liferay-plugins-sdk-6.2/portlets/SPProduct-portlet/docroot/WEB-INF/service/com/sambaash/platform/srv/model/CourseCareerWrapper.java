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
 * This class is a wrapper for {@link CourseCareer}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseCareer
 * @generated
 */
public class CourseCareerWrapper implements CourseCareer,
	ModelWrapper<CourseCareer> {
	public CourseCareerWrapper(CourseCareer courseCareer) {
		_courseCareer = courseCareer;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseCareer.class;
	}

	@Override
	public String getModelClassName() {
		return CourseCareer.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseCareerId", getSpCourseCareerId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("intro", getIntro());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseCareerId = (Long)attributes.get("spCourseCareerId");

		if (spCourseCareerId != null) {
			setSpCourseCareerId(spCourseCareerId);
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

		String intro = (String)attributes.get("intro");

		if (intro != null) {
			setIntro(intro);
		}
	}

	/**
	* Returns the primary key of this course career.
	*
	* @return the primary key of this course career
	*/
	@Override
	public long getPrimaryKey() {
		return _courseCareer.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course career.
	*
	* @param primaryKey the primary key of this course career
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseCareer.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp course career ID of this course career.
	*
	* @return the sp course career ID of this course career
	*/
	@Override
	public long getSpCourseCareerId() {
		return _courseCareer.getSpCourseCareerId();
	}

	/**
	* Sets the sp course career ID of this course career.
	*
	* @param spCourseCareerId the sp course career ID of this course career
	*/
	@Override
	public void setSpCourseCareerId(long spCourseCareerId) {
		_courseCareer.setSpCourseCareerId(spCourseCareerId);
	}

	/**
	* Returns the group ID of this course career.
	*
	* @return the group ID of this course career
	*/
	@Override
	public long getGroupId() {
		return _courseCareer.getGroupId();
	}

	/**
	* Sets the group ID of this course career.
	*
	* @param groupId the group ID of this course career
	*/
	@Override
	public void setGroupId(long groupId) {
		_courseCareer.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course career.
	*
	* @return the company ID of this course career
	*/
	@Override
	public long getCompanyId() {
		return _courseCareer.getCompanyId();
	}

	/**
	* Sets the company ID of this course career.
	*
	* @param companyId the company ID of this course career
	*/
	@Override
	public void setCompanyId(long companyId) {
		_courseCareer.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course career.
	*
	* @return the user ID of this course career
	*/
	@Override
	public long getUserId() {
		return _courseCareer.getUserId();
	}

	/**
	* Sets the user ID of this course career.
	*
	* @param userId the user ID of this course career
	*/
	@Override
	public void setUserId(long userId) {
		_courseCareer.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course career.
	*
	* @return the user uuid of this course career
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseCareer.getUserUuid();
	}

	/**
	* Sets the user uuid of this course career.
	*
	* @param userUuid the user uuid of this course career
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseCareer.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course career.
	*
	* @return the user name of this course career
	*/
	@Override
	public java.lang.String getUserName() {
		return _courseCareer.getUserName();
	}

	/**
	* Sets the user name of this course career.
	*
	* @param userName the user name of this course career
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseCareer.setUserName(userName);
	}

	/**
	* Returns the create date of this course career.
	*
	* @return the create date of this course career
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _courseCareer.getCreateDate();
	}

	/**
	* Sets the create date of this course career.
	*
	* @param createDate the create date of this course career
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_courseCareer.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course career.
	*
	* @return the modified date of this course career
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _courseCareer.getModifiedDate();
	}

	/**
	* Sets the modified date of this course career.
	*
	* @param modifiedDate the modified date of this course career
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseCareer.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp course ID of this course career.
	*
	* @return the sp course ID of this course career
	*/
	@Override
	public long getSpCourseId() {
		return _courseCareer.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this course career.
	*
	* @param spCourseId the sp course ID of this course career
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_courseCareer.setSpCourseId(spCourseId);
	}

	/**
	* Returns the intro of this course career.
	*
	* @return the intro of this course career
	*/
	@Override
	public java.lang.String getIntro() {
		return _courseCareer.getIntro();
	}

	/**
	* Sets the intro of this course career.
	*
	* @param intro the intro of this course career
	*/
	@Override
	public void setIntro(java.lang.String intro) {
		_courseCareer.setIntro(intro);
	}

	@Override
	public boolean isNew() {
		return _courseCareer.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseCareer.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseCareer.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseCareer.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseCareer.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseCareer.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseCareer.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseCareer.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseCareer.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseCareer.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseCareer.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseCareerWrapper((CourseCareer)_courseCareer.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.CourseCareer courseCareer) {
		return _courseCareer.compareTo(courseCareer);
	}

	@Override
	public int hashCode() {
		return _courseCareer.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.CourseCareer> toCacheModel() {
		return _courseCareer.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseCareer toEscapedModel() {
		return new CourseCareerWrapper(_courseCareer.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.CourseCareer toUnescapedModel() {
		return new CourseCareerWrapper(_courseCareer.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseCareer.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseCareer.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseCareer.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseCareerWrapper)) {
			return false;
		}

		CourseCareerWrapper courseCareerWrapper = (CourseCareerWrapper)obj;

		if (Validator.equals(_courseCareer, courseCareerWrapper._courseCareer)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseCareer getWrappedCourseCareer() {
		return _courseCareer;
	}

	@Override
	public CourseCareer getWrappedModel() {
		return _courseCareer;
	}

	@Override
	public void resetOriginalValues() {
		_courseCareer.resetOriginalValues();
	}

	private CourseCareer _courseCareer;
}