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
 * This class is a wrapper for {@link CourseLearning}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see CourseLearning
 * @generated
 */
public class CourseLearningWrapper implements CourseLearning,
	ModelWrapper<CourseLearning> {
	public CourseLearningWrapper(CourseLearning courseLearning) {
		_courseLearning = courseLearning;
	}

	@Override
	public Class<?> getModelClass() {
		return CourseLearning.class;
	}

	@Override
	public String getModelClassName() {
		return CourseLearning.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseLearningId", getSpCourseLearningId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("intro", getIntro());
		attributes.put("optionTitle", getOptionTitle());
		attributes.put("option1", getOption1());
		attributes.put("option2", getOption2());
		attributes.put("note", getNote());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseLearningId = (Long)attributes.get("spCourseLearningId");

		if (spCourseLearningId != null) {
			setSpCourseLearningId(spCourseLearningId);
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

		String optionTitle = (String)attributes.get("optionTitle");

		if (optionTitle != null) {
			setOptionTitle(optionTitle);
		}

		String option1 = (String)attributes.get("option1");

		if (option1 != null) {
			setOption1(option1);
		}

		String option2 = (String)attributes.get("option2");

		if (option2 != null) {
			setOption2(option2);
		}

		String note = (String)attributes.get("note");

		if (note != null) {
			setNote(note);
		}
	}

	/**
	* Returns the primary key of this course learning.
	*
	* @return the primary key of this course learning
	*/
	@Override
	public long getPrimaryKey() {
		return _courseLearning.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course learning.
	*
	* @param primaryKey the primary key of this course learning
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_courseLearning.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp course learning ID of this course learning.
	*
	* @return the sp course learning ID of this course learning
	*/
	@Override
	public long getSpCourseLearningId() {
		return _courseLearning.getSpCourseLearningId();
	}

	/**
	* Sets the sp course learning ID of this course learning.
	*
	* @param spCourseLearningId the sp course learning ID of this course learning
	*/
	@Override
	public void setSpCourseLearningId(long spCourseLearningId) {
		_courseLearning.setSpCourseLearningId(spCourseLearningId);
	}

	/**
	* Returns the group ID of this course learning.
	*
	* @return the group ID of this course learning
	*/
	@Override
	public long getGroupId() {
		return _courseLearning.getGroupId();
	}

	/**
	* Sets the group ID of this course learning.
	*
	* @param groupId the group ID of this course learning
	*/
	@Override
	public void setGroupId(long groupId) {
		_courseLearning.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course learning.
	*
	* @return the company ID of this course learning
	*/
	@Override
	public long getCompanyId() {
		return _courseLearning.getCompanyId();
	}

	/**
	* Sets the company ID of this course learning.
	*
	* @param companyId the company ID of this course learning
	*/
	@Override
	public void setCompanyId(long companyId) {
		_courseLearning.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course learning.
	*
	* @return the user ID of this course learning
	*/
	@Override
	public long getUserId() {
		return _courseLearning.getUserId();
	}

	/**
	* Sets the user ID of this course learning.
	*
	* @param userId the user ID of this course learning
	*/
	@Override
	public void setUserId(long userId) {
		_courseLearning.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course learning.
	*
	* @return the user uuid of this course learning
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _courseLearning.getUserUuid();
	}

	/**
	* Sets the user uuid of this course learning.
	*
	* @param userUuid the user uuid of this course learning
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_courseLearning.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course learning.
	*
	* @return the user name of this course learning
	*/
	@Override
	public java.lang.String getUserName() {
		return _courseLearning.getUserName();
	}

	/**
	* Sets the user name of this course learning.
	*
	* @param userName the user name of this course learning
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_courseLearning.setUserName(userName);
	}

	/**
	* Returns the create date of this course learning.
	*
	* @return the create date of this course learning
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _courseLearning.getCreateDate();
	}

	/**
	* Sets the create date of this course learning.
	*
	* @param createDate the create date of this course learning
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_courseLearning.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course learning.
	*
	* @return the modified date of this course learning
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _courseLearning.getModifiedDate();
	}

	/**
	* Sets the modified date of this course learning.
	*
	* @param modifiedDate the modified date of this course learning
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_courseLearning.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp course ID of this course learning.
	*
	* @return the sp course ID of this course learning
	*/
	@Override
	public long getSpCourseId() {
		return _courseLearning.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this course learning.
	*
	* @param spCourseId the sp course ID of this course learning
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_courseLearning.setSpCourseId(spCourseId);
	}

	/**
	* Returns the intro of this course learning.
	*
	* @return the intro of this course learning
	*/
	@Override
	public java.lang.String getIntro() {
		return _courseLearning.getIntro();
	}

	/**
	* Sets the intro of this course learning.
	*
	* @param intro the intro of this course learning
	*/
	@Override
	public void setIntro(java.lang.String intro) {
		_courseLearning.setIntro(intro);
	}

	/**
	* Returns the option title of this course learning.
	*
	* @return the option title of this course learning
	*/
	@Override
	public java.lang.String getOptionTitle() {
		return _courseLearning.getOptionTitle();
	}

	/**
	* Sets the option title of this course learning.
	*
	* @param optionTitle the option title of this course learning
	*/
	@Override
	public void setOptionTitle(java.lang.String optionTitle) {
		_courseLearning.setOptionTitle(optionTitle);
	}

	/**
	* Returns the option1 of this course learning.
	*
	* @return the option1 of this course learning
	*/
	@Override
	public java.lang.String getOption1() {
		return _courseLearning.getOption1();
	}

	/**
	* Sets the option1 of this course learning.
	*
	* @param option1 the option1 of this course learning
	*/
	@Override
	public void setOption1(java.lang.String option1) {
		_courseLearning.setOption1(option1);
	}

	/**
	* Returns the option2 of this course learning.
	*
	* @return the option2 of this course learning
	*/
	@Override
	public java.lang.String getOption2() {
		return _courseLearning.getOption2();
	}

	/**
	* Sets the option2 of this course learning.
	*
	* @param option2 the option2 of this course learning
	*/
	@Override
	public void setOption2(java.lang.String option2) {
		_courseLearning.setOption2(option2);
	}

	/**
	* Returns the note of this course learning.
	*
	* @return the note of this course learning
	*/
	@Override
	public java.lang.String getNote() {
		return _courseLearning.getNote();
	}

	/**
	* Sets the note of this course learning.
	*
	* @param note the note of this course learning
	*/
	@Override
	public void setNote(java.lang.String note) {
		_courseLearning.setNote(note);
	}

	@Override
	public boolean isNew() {
		return _courseLearning.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_courseLearning.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _courseLearning.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_courseLearning.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _courseLearning.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _courseLearning.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_courseLearning.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _courseLearning.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_courseLearning.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_courseLearning.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_courseLearning.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseLearningWrapper((CourseLearning)_courseLearning.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.CourseLearning courseLearning) {
		return _courseLearning.compareTo(courseLearning);
	}

	@Override
	public int hashCode() {
		return _courseLearning.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.CourseLearning> toCacheModel() {
		return _courseLearning.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.CourseLearning toEscapedModel() {
		return new CourseLearningWrapper(_courseLearning.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.CourseLearning toUnescapedModel() {
		return new CourseLearningWrapper(_courseLearning.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _courseLearning.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _courseLearning.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_courseLearning.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseLearningWrapper)) {
			return false;
		}

		CourseLearningWrapper courseLearningWrapper = (CourseLearningWrapper)obj;

		if (Validator.equals(_courseLearning,
					courseLearningWrapper._courseLearning)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public CourseLearning getWrappedCourseLearning() {
		return _courseLearning;
	}

	@Override
	public CourseLearning getWrappedModel() {
		return _courseLearning;
	}

	@Override
	public void resetOriginalValues() {
		_courseLearning.resetOriginalValues();
	}

	private CourseLearning _courseLearning;
}