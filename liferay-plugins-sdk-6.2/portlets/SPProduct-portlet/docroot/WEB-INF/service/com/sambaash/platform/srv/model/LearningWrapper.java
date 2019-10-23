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
 * This class is a wrapper for {@link Learning}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Learning
 * @generated
 */
public class LearningWrapper implements Learning, ModelWrapper<Learning> {
	public LearningWrapper(Learning learning) {
		_learning = learning;
	}

	@Override
	public Class<?> getModelClass() {
		return Learning.class;
	}

	@Override
	public String getModelClassName() {
		return Learning.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spLearningId", getSpLearningId());
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
		Long spLearningId = (Long)attributes.get("spLearningId");

		if (spLearningId != null) {
			setSpLearningId(spLearningId);
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
	* Returns the primary key of this learning.
	*
	* @return the primary key of this learning
	*/
	@Override
	public long getPrimaryKey() {
		return _learning.getPrimaryKey();
	}

	/**
	* Sets the primary key of this learning.
	*
	* @param primaryKey the primary key of this learning
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_learning.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp learning ID of this learning.
	*
	* @return the sp learning ID of this learning
	*/
	@Override
	public long getSpLearningId() {
		return _learning.getSpLearningId();
	}

	/**
	* Sets the sp learning ID of this learning.
	*
	* @param spLearningId the sp learning ID of this learning
	*/
	@Override
	public void setSpLearningId(long spLearningId) {
		_learning.setSpLearningId(spLearningId);
	}

	/**
	* Returns the group ID of this learning.
	*
	* @return the group ID of this learning
	*/
	@Override
	public long getGroupId() {
		return _learning.getGroupId();
	}

	/**
	* Sets the group ID of this learning.
	*
	* @param groupId the group ID of this learning
	*/
	@Override
	public void setGroupId(long groupId) {
		_learning.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this learning.
	*
	* @return the company ID of this learning
	*/
	@Override
	public long getCompanyId() {
		return _learning.getCompanyId();
	}

	/**
	* Sets the company ID of this learning.
	*
	* @param companyId the company ID of this learning
	*/
	@Override
	public void setCompanyId(long companyId) {
		_learning.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this learning.
	*
	* @return the user ID of this learning
	*/
	@Override
	public long getUserId() {
		return _learning.getUserId();
	}

	/**
	* Sets the user ID of this learning.
	*
	* @param userId the user ID of this learning
	*/
	@Override
	public void setUserId(long userId) {
		_learning.setUserId(userId);
	}

	/**
	* Returns the user uuid of this learning.
	*
	* @return the user uuid of this learning
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _learning.getUserUuid();
	}

	/**
	* Sets the user uuid of this learning.
	*
	* @param userUuid the user uuid of this learning
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_learning.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this learning.
	*
	* @return the user name of this learning
	*/
	@Override
	public java.lang.String getUserName() {
		return _learning.getUserName();
	}

	/**
	* Sets the user name of this learning.
	*
	* @param userName the user name of this learning
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_learning.setUserName(userName);
	}

	/**
	* Returns the create date of this learning.
	*
	* @return the create date of this learning
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _learning.getCreateDate();
	}

	/**
	* Sets the create date of this learning.
	*
	* @param createDate the create date of this learning
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_learning.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this learning.
	*
	* @return the modified date of this learning
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _learning.getModifiedDate();
	}

	/**
	* Sets the modified date of this learning.
	*
	* @param modifiedDate the modified date of this learning
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_learning.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp course ID of this learning.
	*
	* @return the sp course ID of this learning
	*/
	@Override
	public long getSpCourseId() {
		return _learning.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this learning.
	*
	* @param spCourseId the sp course ID of this learning
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_learning.setSpCourseId(spCourseId);
	}

	/**
	* Returns the intro of this learning.
	*
	* @return the intro of this learning
	*/
	@Override
	public java.lang.String getIntro() {
		return _learning.getIntro();
	}

	/**
	* Sets the intro of this learning.
	*
	* @param intro the intro of this learning
	*/
	@Override
	public void setIntro(java.lang.String intro) {
		_learning.setIntro(intro);
	}

	/**
	* Returns the option title of this learning.
	*
	* @return the option title of this learning
	*/
	@Override
	public java.lang.String getOptionTitle() {
		return _learning.getOptionTitle();
	}

	/**
	* Sets the option title of this learning.
	*
	* @param optionTitle the option title of this learning
	*/
	@Override
	public void setOptionTitle(java.lang.String optionTitle) {
		_learning.setOptionTitle(optionTitle);
	}

	/**
	* Returns the option1 of this learning.
	*
	* @return the option1 of this learning
	*/
	@Override
	public java.lang.String getOption1() {
		return _learning.getOption1();
	}

	/**
	* Sets the option1 of this learning.
	*
	* @param option1 the option1 of this learning
	*/
	@Override
	public void setOption1(java.lang.String option1) {
		_learning.setOption1(option1);
	}

	/**
	* Returns the option2 of this learning.
	*
	* @return the option2 of this learning
	*/
	@Override
	public java.lang.String getOption2() {
		return _learning.getOption2();
	}

	/**
	* Sets the option2 of this learning.
	*
	* @param option2 the option2 of this learning
	*/
	@Override
	public void setOption2(java.lang.String option2) {
		_learning.setOption2(option2);
	}

	/**
	* Returns the note of this learning.
	*
	* @return the note of this learning
	*/
	@Override
	public java.lang.String getNote() {
		return _learning.getNote();
	}

	/**
	* Sets the note of this learning.
	*
	* @param note the note of this learning
	*/
	@Override
	public void setNote(java.lang.String note) {
		_learning.setNote(note);
	}

	@Override
	public boolean isNew() {
		return _learning.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_learning.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _learning.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_learning.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _learning.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _learning.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_learning.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _learning.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_learning.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_learning.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_learning.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LearningWrapper((Learning)_learning.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Learning learning) {
		return _learning.compareTo(learning);
	}

	@Override
	public int hashCode() {
		return _learning.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Learning> toCacheModel() {
		return _learning.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Learning toEscapedModel() {
		return new LearningWrapper(_learning.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Learning toUnescapedModel() {
		return new LearningWrapper(_learning.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _learning.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _learning.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_learning.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LearningWrapper)) {
			return false;
		}

		LearningWrapper learningWrapper = (LearningWrapper)obj;

		if (Validator.equals(_learning, learningWrapper._learning)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Learning getWrappedLearning() {
		return _learning;
	}

	@Override
	public Learning getWrappedModel() {
		return _learning;
	}

	@Override
	public void resetOriginalValues() {
		_learning.resetOriginalValues();
	}

	private Learning _learning;
}