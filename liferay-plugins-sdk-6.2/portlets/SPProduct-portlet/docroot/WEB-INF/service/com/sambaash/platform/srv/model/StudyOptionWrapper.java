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
 * This class is a wrapper for {@link StudyOption}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see StudyOption
 * @generated
 */
public class StudyOptionWrapper implements StudyOption,
	ModelWrapper<StudyOption> {
	public StudyOptionWrapper(StudyOption studyOption) {
		_studyOption = studyOption;
	}

	@Override
	public Class<?> getModelClass() {
		return StudyOption.class;
	}

	@Override
	public String getModelClassName() {
		return StudyOption.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudyOptionId", getSpStudyOptionId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("coverImageFileEntryId", getCoverImageFileEntryId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudyOptionId = (Long)attributes.get("spStudyOptionId");

		if (spStudyOptionId != null) {
			setSpStudyOptionId(spStudyOptionId);
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

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}

		Long coverImageFileEntryId = (Long)attributes.get(
				"coverImageFileEntryId");

		if (coverImageFileEntryId != null) {
			setCoverImageFileEntryId(coverImageFileEntryId);
		}
	}

	/**
	* Returns the primary key of this study option.
	*
	* @return the primary key of this study option
	*/
	@Override
	public long getPrimaryKey() {
		return _studyOption.getPrimaryKey();
	}

	/**
	* Sets the primary key of this study option.
	*
	* @param primaryKey the primary key of this study option
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_studyOption.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp study option ID of this study option.
	*
	* @return the sp study option ID of this study option
	*/
	@Override
	public long getSpStudyOptionId() {
		return _studyOption.getSpStudyOptionId();
	}

	/**
	* Sets the sp study option ID of this study option.
	*
	* @param spStudyOptionId the sp study option ID of this study option
	*/
	@Override
	public void setSpStudyOptionId(long spStudyOptionId) {
		_studyOption.setSpStudyOptionId(spStudyOptionId);
	}

	/**
	* Returns the group ID of this study option.
	*
	* @return the group ID of this study option
	*/
	@Override
	public long getGroupId() {
		return _studyOption.getGroupId();
	}

	/**
	* Sets the group ID of this study option.
	*
	* @param groupId the group ID of this study option
	*/
	@Override
	public void setGroupId(long groupId) {
		_studyOption.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this study option.
	*
	* @return the company ID of this study option
	*/
	@Override
	public long getCompanyId() {
		return _studyOption.getCompanyId();
	}

	/**
	* Sets the company ID of this study option.
	*
	* @param companyId the company ID of this study option
	*/
	@Override
	public void setCompanyId(long companyId) {
		_studyOption.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this study option.
	*
	* @return the user ID of this study option
	*/
	@Override
	public long getUserId() {
		return _studyOption.getUserId();
	}

	/**
	* Sets the user ID of this study option.
	*
	* @param userId the user ID of this study option
	*/
	@Override
	public void setUserId(long userId) {
		_studyOption.setUserId(userId);
	}

	/**
	* Returns the user uuid of this study option.
	*
	* @return the user uuid of this study option
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _studyOption.getUserUuid();
	}

	/**
	* Sets the user uuid of this study option.
	*
	* @param userUuid the user uuid of this study option
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_studyOption.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this study option.
	*
	* @return the user name of this study option
	*/
	@Override
	public java.lang.String getUserName() {
		return _studyOption.getUserName();
	}

	/**
	* Sets the user name of this study option.
	*
	* @param userName the user name of this study option
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_studyOption.setUserName(userName);
	}

	/**
	* Returns the create date of this study option.
	*
	* @return the create date of this study option
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _studyOption.getCreateDate();
	}

	/**
	* Sets the create date of this study option.
	*
	* @param createDate the create date of this study option
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_studyOption.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this study option.
	*
	* @return the modified date of this study option
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _studyOption.getModifiedDate();
	}

	/**
	* Sets the modified date of this study option.
	*
	* @param modifiedDate the modified date of this study option
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_studyOption.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp course ID of this study option.
	*
	* @return the sp course ID of this study option
	*/
	@Override
	public long getSpCourseId() {
		return _studyOption.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this study option.
	*
	* @param spCourseId the sp course ID of this study option
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_studyOption.setSpCourseId(spCourseId);
	}

	/**
	* Returns the title of this study option.
	*
	* @return the title of this study option
	*/
	@Override
	public java.lang.String getTitle() {
		return _studyOption.getTitle();
	}

	/**
	* Sets the title of this study option.
	*
	* @param title the title of this study option
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_studyOption.setTitle(title);
	}

	/**
	* Returns the desc of this study option.
	*
	* @return the desc of this study option
	*/
	@Override
	public java.lang.String getDesc() {
		return _studyOption.getDesc();
	}

	/**
	* Sets the desc of this study option.
	*
	* @param desc the desc of this study option
	*/
	@Override
	public void setDesc(java.lang.String desc) {
		_studyOption.setDesc(desc);
	}

	/**
	* Returns the cover image file entry ID of this study option.
	*
	* @return the cover image file entry ID of this study option
	*/
	@Override
	public long getCoverImageFileEntryId() {
		return _studyOption.getCoverImageFileEntryId();
	}

	/**
	* Sets the cover image file entry ID of this study option.
	*
	* @param coverImageFileEntryId the cover image file entry ID of this study option
	*/
	@Override
	public void setCoverImageFileEntryId(long coverImageFileEntryId) {
		_studyOption.setCoverImageFileEntryId(coverImageFileEntryId);
	}

	@Override
	public boolean isNew() {
		return _studyOption.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_studyOption.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _studyOption.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_studyOption.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _studyOption.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _studyOption.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_studyOption.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _studyOption.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_studyOption.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_studyOption.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_studyOption.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new StudyOptionWrapper((StudyOption)_studyOption.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.StudyOption studyOption) {
		return _studyOption.compareTo(studyOption);
	}

	@Override
	public int hashCode() {
		return _studyOption.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.StudyOption> toCacheModel() {
		return _studyOption.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.StudyOption toEscapedModel() {
		return new StudyOptionWrapper(_studyOption.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.StudyOption toUnescapedModel() {
		return new StudyOptionWrapper(_studyOption.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _studyOption.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _studyOption.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_studyOption.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StudyOptionWrapper)) {
			return false;
		}

		StudyOptionWrapper studyOptionWrapper = (StudyOptionWrapper)obj;

		if (Validator.equals(_studyOption, studyOptionWrapper._studyOption)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public StudyOption getWrappedStudyOption() {
		return _studyOption;
	}

	@Override
	public StudyOption getWrappedModel() {
		return _studyOption;
	}

	@Override
	public void resetOriginalValues() {
		_studyOption.resetOriginalValues();
	}

	private StudyOption _studyOption;
}