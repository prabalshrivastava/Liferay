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
 * This class is a wrapper for {@link ProgressionPath}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see ProgressionPath
 * @generated
 */
public class ProgressionPathWrapper implements ProgressionPath,
	ModelWrapper<ProgressionPath> {
	public ProgressionPathWrapper(ProgressionPath progressionPath) {
		_progressionPath = progressionPath;
	}

	@Override
	public Class<?> getModelClass() {
		return ProgressionPath.class;
	}

	@Override
	public String getModelClassName() {
		return ProgressionPath.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spProgressionPathId", getSpProgressionPathId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("careerLevel", getCareerLevel());
		attributes.put("level", getLevel());
		attributes.put("progressionType", getProgressionType());
		attributes.put("progressionCategory", getProgressionCategory());
		attributes.put("startMonth", getStartMonth());
		attributes.put("endMonth", getEndMonth());
		attributes.put("duration", getDuration());
		attributes.put("optionalMandatory", getOptionalMandatory());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spProgressionPathId = (Long)attributes.get("spProgressionPathId");

		if (spProgressionPathId != null) {
			setSpProgressionPathId(spProgressionPathId);
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

		Long careerLevel = (Long)attributes.get("careerLevel");

		if (careerLevel != null) {
			setCareerLevel(careerLevel);
		}

		Integer level = (Integer)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long progressionType = (Long)attributes.get("progressionType");

		if (progressionType != null) {
			setProgressionType(progressionType);
		}

		Long progressionCategory = (Long)attributes.get("progressionCategory");

		if (progressionCategory != null) {
			setProgressionCategory(progressionCategory);
		}

		String startMonth = (String)attributes.get("startMonth");

		if (startMonth != null) {
			setStartMonth(startMonth);
		}

		String endMonth = (String)attributes.get("endMonth");

		if (endMonth != null) {
			setEndMonth(endMonth);
		}

		String duration = (String)attributes.get("duration");

		if (duration != null) {
			setDuration(duration);
		}

		String optionalMandatory = (String)attributes.get("optionalMandatory");

		if (optionalMandatory != null) {
			setOptionalMandatory(optionalMandatory);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	/**
	* Returns the primary key of this progression path.
	*
	* @return the primary key of this progression path
	*/
	@Override
	public long getPrimaryKey() {
		return _progressionPath.getPrimaryKey();
	}

	/**
	* Sets the primary key of this progression path.
	*
	* @param primaryKey the primary key of this progression path
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_progressionPath.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp progression path ID of this progression path.
	*
	* @return the sp progression path ID of this progression path
	*/
	@Override
	public long getSpProgressionPathId() {
		return _progressionPath.getSpProgressionPathId();
	}

	/**
	* Sets the sp progression path ID of this progression path.
	*
	* @param spProgressionPathId the sp progression path ID of this progression path
	*/
	@Override
	public void setSpProgressionPathId(long spProgressionPathId) {
		_progressionPath.setSpProgressionPathId(spProgressionPathId);
	}

	/**
	* Returns the group ID of this progression path.
	*
	* @return the group ID of this progression path
	*/
	@Override
	public long getGroupId() {
		return _progressionPath.getGroupId();
	}

	/**
	* Sets the group ID of this progression path.
	*
	* @param groupId the group ID of this progression path
	*/
	@Override
	public void setGroupId(long groupId) {
		_progressionPath.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this progression path.
	*
	* @return the company ID of this progression path
	*/
	@Override
	public long getCompanyId() {
		return _progressionPath.getCompanyId();
	}

	/**
	* Sets the company ID of this progression path.
	*
	* @param companyId the company ID of this progression path
	*/
	@Override
	public void setCompanyId(long companyId) {
		_progressionPath.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this progression path.
	*
	* @return the user ID of this progression path
	*/
	@Override
	public long getUserId() {
		return _progressionPath.getUserId();
	}

	/**
	* Sets the user ID of this progression path.
	*
	* @param userId the user ID of this progression path
	*/
	@Override
	public void setUserId(long userId) {
		_progressionPath.setUserId(userId);
	}

	/**
	* Returns the user uuid of this progression path.
	*
	* @return the user uuid of this progression path
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _progressionPath.getUserUuid();
	}

	/**
	* Sets the user uuid of this progression path.
	*
	* @param userUuid the user uuid of this progression path
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_progressionPath.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this progression path.
	*
	* @return the user name of this progression path
	*/
	@Override
	public java.lang.String getUserName() {
		return _progressionPath.getUserName();
	}

	/**
	* Sets the user name of this progression path.
	*
	* @param userName the user name of this progression path
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_progressionPath.setUserName(userName);
	}

	/**
	* Returns the create date of this progression path.
	*
	* @return the create date of this progression path
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _progressionPath.getCreateDate();
	}

	/**
	* Sets the create date of this progression path.
	*
	* @param createDate the create date of this progression path
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_progressionPath.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this progression path.
	*
	* @return the modified date of this progression path
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _progressionPath.getModifiedDate();
	}

	/**
	* Sets the modified date of this progression path.
	*
	* @param modifiedDate the modified date of this progression path
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_progressionPath.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the career level of this progression path.
	*
	* @return the career level of this progression path
	*/
	@Override
	public long getCareerLevel() {
		return _progressionPath.getCareerLevel();
	}

	/**
	* Sets the career level of this progression path.
	*
	* @param careerLevel the career level of this progression path
	*/
	@Override
	public void setCareerLevel(long careerLevel) {
		_progressionPath.setCareerLevel(careerLevel);
	}

	/**
	* Returns the level of this progression path.
	*
	* @return the level of this progression path
	*/
	@Override
	public int getLevel() {
		return _progressionPath.getLevel();
	}

	/**
	* Sets the level of this progression path.
	*
	* @param level the level of this progression path
	*/
	@Override
	public void setLevel(int level) {
		_progressionPath.setLevel(level);
	}

	/**
	* Returns the progression type of this progression path.
	*
	* @return the progression type of this progression path
	*/
	@Override
	public long getProgressionType() {
		return _progressionPath.getProgressionType();
	}

	/**
	* Sets the progression type of this progression path.
	*
	* @param progressionType the progression type of this progression path
	*/
	@Override
	public void setProgressionType(long progressionType) {
		_progressionPath.setProgressionType(progressionType);
	}

	/**
	* Returns the progression category of this progression path.
	*
	* @return the progression category of this progression path
	*/
	@Override
	public long getProgressionCategory() {
		return _progressionPath.getProgressionCategory();
	}

	/**
	* Sets the progression category of this progression path.
	*
	* @param progressionCategory the progression category of this progression path
	*/
	@Override
	public void setProgressionCategory(long progressionCategory) {
		_progressionPath.setProgressionCategory(progressionCategory);
	}

	/**
	* Returns the start month of this progression path.
	*
	* @return the start month of this progression path
	*/
	@Override
	public java.lang.String getStartMonth() {
		return _progressionPath.getStartMonth();
	}

	/**
	* Sets the start month of this progression path.
	*
	* @param startMonth the start month of this progression path
	*/
	@Override
	public void setStartMonth(java.lang.String startMonth) {
		_progressionPath.setStartMonth(startMonth);
	}

	/**
	* Returns the end month of this progression path.
	*
	* @return the end month of this progression path
	*/
	@Override
	public java.lang.String getEndMonth() {
		return _progressionPath.getEndMonth();
	}

	/**
	* Sets the end month of this progression path.
	*
	* @param endMonth the end month of this progression path
	*/
	@Override
	public void setEndMonth(java.lang.String endMonth) {
		_progressionPath.setEndMonth(endMonth);
	}

	/**
	* Returns the duration of this progression path.
	*
	* @return the duration of this progression path
	*/
	@Override
	public java.lang.String getDuration() {
		return _progressionPath.getDuration();
	}

	/**
	* Sets the duration of this progression path.
	*
	* @param duration the duration of this progression path
	*/
	@Override
	public void setDuration(java.lang.String duration) {
		_progressionPath.setDuration(duration);
	}

	/**
	* Returns the optional mandatory of this progression path.
	*
	* @return the optional mandatory of this progression path
	*/
	@Override
	public java.lang.String getOptionalMandatory() {
		return _progressionPath.getOptionalMandatory();
	}

	/**
	* Sets the optional mandatory of this progression path.
	*
	* @param optionalMandatory the optional mandatory of this progression path
	*/
	@Override
	public void setOptionalMandatory(java.lang.String optionalMandatory) {
		_progressionPath.setOptionalMandatory(optionalMandatory);
	}

	/**
	* Returns the sp course ID of this progression path.
	*
	* @return the sp course ID of this progression path
	*/
	@Override
	public long getSpCourseId() {
		return _progressionPath.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this progression path.
	*
	* @param spCourseId the sp course ID of this progression path
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_progressionPath.setSpCourseId(spCourseId);
	}

	@Override
	public boolean isNew() {
		return _progressionPath.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_progressionPath.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _progressionPath.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_progressionPath.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _progressionPath.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _progressionPath.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_progressionPath.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _progressionPath.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_progressionPath.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_progressionPath.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_progressionPath.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ProgressionPathWrapper((ProgressionPath)_progressionPath.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.ProgressionPath progressionPath) {
		return _progressionPath.compareTo(progressionPath);
	}

	@Override
	public int hashCode() {
		return _progressionPath.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.ProgressionPath> toCacheModel() {
		return _progressionPath.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.ProgressionPath toEscapedModel() {
		return new ProgressionPathWrapper(_progressionPath.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.ProgressionPath toUnescapedModel() {
		return new ProgressionPathWrapper(_progressionPath.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _progressionPath.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _progressionPath.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_progressionPath.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ProgressionPathWrapper)) {
			return false;
		}

		ProgressionPathWrapper progressionPathWrapper = (ProgressionPathWrapper)obj;

		if (Validator.equals(_progressionPath,
					progressionPathWrapper._progressionPath)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ProgressionPath getWrappedProgressionPath() {
		return _progressionPath;
	}

	@Override
	public ProgressionPath getWrappedModel() {
		return _progressionPath;
	}

	@Override
	public void resetOriginalValues() {
		_progressionPath.resetOriginalValues();
	}

	private ProgressionPath _progressionPath;
}