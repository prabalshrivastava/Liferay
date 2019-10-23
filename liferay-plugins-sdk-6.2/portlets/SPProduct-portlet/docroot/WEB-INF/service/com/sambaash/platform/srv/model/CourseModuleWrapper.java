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
 * This class is a wrapper for {@link CourseModule}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseModule
 * @generated
 */
public class CourseModuleWrapper implements CourseModule,
	ModelWrapper<CourseModule> {
	public CourseModuleWrapper(CourseModule courseModule) {
		_courseModule = courseModule;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseModule.class;
	}

	@Override
	public String getModelClassName() {
		return CourseModule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseModuleId", getSpCourseModuleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("spModuleId", getSpModuleId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseModuleId = (Long)attributes.get("spCourseModuleId");

		if (spCourseModuleId != null) {
			setSpCourseModuleId(spCourseModuleId);
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

		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
		}
	}

	/**
	* Returns the primary key of this course module.
	*
	* @return the primary key of this course module
	*/
	@Override
	public long getPrimaryKey() {
		return _courseModule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course module.
	*
	* @param primaryKey the primary key of this course module
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseModule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp course module ID of this course module.
	*
	* @return the sp course module ID of this course module
	*/
	@Override
	public long getSpCourseModuleId() {
		return _courseModule.getSpCourseModuleId();
	}

	/**
	* Sets the sp course module ID of this course module.
	*
	* @param spCourseModuleId the sp course module ID of this course module
	*/
	@Override
	public void setSpCourseModuleId(long spCourseModuleId) {
		_courseModule.setSpCourseModuleId(spCourseModuleId);
	}

	/**
	* Returns the group ID of this course module.
	*
	* @return the group ID of this course module
	*/
	@Override
	public long getGroupId() {
		return _courseModule.getGroupId();
	}

	/**
	* Sets the group ID of this course module.
	*
	* @param groupId the group ID of this course module
	*/
	@Override
	public void setGroupId(long groupId) {
		_courseModule.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course module.
	*
	* @return the company ID of this course module
	*/
	@Override
	public long getCompanyId() {
		return _courseModule.getCompanyId();
	}

	/**
	* Sets the company ID of this course module.
	*
	* @param companyId the company ID of this course module
	*/
	@Override
	public void setCompanyId(long companyId) {
		_courseModule.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course module.
	*
	* @return the user ID of this course module
	*/
	@Override
	public long getUserId() {
		return _courseModule.getUserId();
	}

	/**
	* Sets the user ID of this course module.
	*
	* @param userId the user ID of this course module
	*/
	@Override
	public void setUserId(long userId) {
		_courseModule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course module.
	*
	* @return the user uuid of this course module
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseModule.getUserUuid();
	}

	/**
	* Sets the user uuid of this course module.
	*
	* @param userUuid the user uuid of this course module
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseModule.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course module.
	*
	* @return the user name of this course module
	*/
	@Override
	public java.lang.String getUserName() {
		return _courseModule.getUserName();
	}

	/**
	* Sets the user name of this course module.
	*
	* @param userName the user name of this course module
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseModule.setUserName(userName);
	}

	/**
	* Returns the create date of this course module.
	*
	* @return the create date of this course module
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _courseModule.getCreateDate();
	}

	/**
	* Sets the create date of this course module.
	*
	* @param createDate the create date of this course module
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_courseModule.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course module.
	*
	* @return the modified date of this course module
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _courseModule.getModifiedDate();
	}

	/**
	* Sets the modified date of this course module.
	*
	* @param modifiedDate the modified date of this course module
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseModule.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp course ID of this course module.
	*
	* @return the sp course ID of this course module
	*/
	@Override
	public long getSpCourseId() {
		return _courseModule.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this course module.
	*
	* @param spCourseId the sp course ID of this course module
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_courseModule.setSpCourseId(spCourseId);
	}

	/**
	* Returns the sp module ID of this course module.
	*
	* @return the sp module ID of this course module
	*/
	@Override
	public long getSpModuleId() {
		return _courseModule.getSpModuleId();
	}

	/**
	* Sets the sp module ID of this course module.
	*
	* @param spModuleId the sp module ID of this course module
	*/
	@Override
	public void setSpModuleId(long spModuleId) {
		_courseModule.setSpModuleId(spModuleId);
	}

	@Override
	public boolean isNew() {
		return _courseModule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseModule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseModule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseModule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseModule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseModule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseModule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseModule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseModule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseModule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseModule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseModuleWrapper((CourseModule)_courseModule.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.CourseModule courseModule) {
		return _courseModule.compareTo(courseModule);
	}

	@Override
	public int hashCode() {
		return _courseModule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.CourseModule> toCacheModel() {
		return _courseModule.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseModule toEscapedModel() {
		return new CourseModuleWrapper(_courseModule.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.CourseModule toUnescapedModel() {
		return new CourseModuleWrapper(_courseModule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseModule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseModule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseModule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseModuleWrapper)) {
			return false;
		}

		CourseModuleWrapper courseModuleWrapper = (CourseModuleWrapper)obj;

		if (Validator.equals(_courseModule, courseModuleWrapper._courseModule)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseModule getWrappedCourseModule() {
		return _courseModule;
	}

	@Override
	public CourseModule getWrappedModel() {
		return _courseModule;
	}

	@Override
	public void resetOriginalValues() {
		_courseModule.resetOriginalValues();
	}

	private CourseModule _courseModule;
}