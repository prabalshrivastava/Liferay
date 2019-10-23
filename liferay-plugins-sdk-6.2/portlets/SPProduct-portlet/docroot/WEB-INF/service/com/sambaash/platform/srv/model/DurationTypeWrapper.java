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
 * This class is a wrapper for {@link DurationType}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see DurationType
 * @generated
 */
public class DurationTypeWrapper implements DurationType,
	ModelWrapper<DurationType> {
	public DurationTypeWrapper(DurationType durationType) {
		_durationType = durationType;
	}

	@Override
	public Class<?> getModelClass() {
		return DurationType.class;
	}

	@Override
	public String getModelClassName() {
		return DurationType.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spDurationTypeId", getSpDurationTypeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spLearningDurationId", getSpLearningDurationId());
		attributes.put("spCourseId", getSpCourseId());
		attributes.put("title1", getTitle1());
		attributes.put("duration1", getDuration1());
		attributes.put("title2", getTitle2());
		attributes.put("duration2", getDuration2());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spDurationTypeId = (Long)attributes.get("spDurationTypeId");

		if (spDurationTypeId != null) {
			setSpDurationTypeId(spDurationTypeId);
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

		Long spLearningDurationId = (Long)attributes.get("spLearningDurationId");

		if (spLearningDurationId != null) {
			setSpLearningDurationId(spLearningDurationId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}

		String title1 = (String)attributes.get("title1");

		if (title1 != null) {
			setTitle1(title1);
		}

		Long duration1 = (Long)attributes.get("duration1");

		if (duration1 != null) {
			setDuration1(duration1);
		}

		String title2 = (String)attributes.get("title2");

		if (title2 != null) {
			setTitle2(title2);
		}

		Long duration2 = (Long)attributes.get("duration2");

		if (duration2 != null) {
			setDuration2(duration2);
		}
	}

	/**
	* Returns the primary key of this duration type.
	*
	* @return the primary key of this duration type
	*/
	@Override
	public long getPrimaryKey() {
		return _durationType.getPrimaryKey();
	}

	/**
	* Sets the primary key of this duration type.
	*
	* @param primaryKey the primary key of this duration type
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_durationType.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp duration type ID of this duration type.
	*
	* @return the sp duration type ID of this duration type
	*/
	@Override
	public long getSpDurationTypeId() {
		return _durationType.getSpDurationTypeId();
	}

	/**
	* Sets the sp duration type ID of this duration type.
	*
	* @param spDurationTypeId the sp duration type ID of this duration type
	*/
	@Override
	public void setSpDurationTypeId(long spDurationTypeId) {
		_durationType.setSpDurationTypeId(spDurationTypeId);
	}

	/**
	* Returns the group ID of this duration type.
	*
	* @return the group ID of this duration type
	*/
	@Override
	public long getGroupId() {
		return _durationType.getGroupId();
	}

	/**
	* Sets the group ID of this duration type.
	*
	* @param groupId the group ID of this duration type
	*/
	@Override
	public void setGroupId(long groupId) {
		_durationType.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this duration type.
	*
	* @return the company ID of this duration type
	*/
	@Override
	public long getCompanyId() {
		return _durationType.getCompanyId();
	}

	/**
	* Sets the company ID of this duration type.
	*
	* @param companyId the company ID of this duration type
	*/
	@Override
	public void setCompanyId(long companyId) {
		_durationType.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this duration type.
	*
	* @return the user ID of this duration type
	*/
	@Override
	public long getUserId() {
		return _durationType.getUserId();
	}

	/**
	* Sets the user ID of this duration type.
	*
	* @param userId the user ID of this duration type
	*/
	@Override
	public void setUserId(long userId) {
		_durationType.setUserId(userId);
	}

	/**
	* Returns the user uuid of this duration type.
	*
	* @return the user uuid of this duration type
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _durationType.getUserUuid();
	}

	/**
	* Sets the user uuid of this duration type.
	*
	* @param userUuid the user uuid of this duration type
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_durationType.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this duration type.
	*
	* @return the user name of this duration type
	*/
	@Override
	public java.lang.String getUserName() {
		return _durationType.getUserName();
	}

	/**
	* Sets the user name of this duration type.
	*
	* @param userName the user name of this duration type
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_durationType.setUserName(userName);
	}

	/**
	* Returns the create date of this duration type.
	*
	* @return the create date of this duration type
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _durationType.getCreateDate();
	}

	/**
	* Sets the create date of this duration type.
	*
	* @param createDate the create date of this duration type
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_durationType.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this duration type.
	*
	* @return the modified date of this duration type
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _durationType.getModifiedDate();
	}

	/**
	* Sets the modified date of this duration type.
	*
	* @param modifiedDate the modified date of this duration type
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_durationType.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp learning duration ID of this duration type.
	*
	* @return the sp learning duration ID of this duration type
	*/
	@Override
	public long getSpLearningDurationId() {
		return _durationType.getSpLearningDurationId();
	}

	/**
	* Sets the sp learning duration ID of this duration type.
	*
	* @param spLearningDurationId the sp learning duration ID of this duration type
	*/
	@Override
	public void setSpLearningDurationId(long spLearningDurationId) {
		_durationType.setSpLearningDurationId(spLearningDurationId);
	}

	/**
	* Returns the sp course ID of this duration type.
	*
	* @return the sp course ID of this duration type
	*/
	@Override
	public long getSpCourseId() {
		return _durationType.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this duration type.
	*
	* @param spCourseId the sp course ID of this duration type
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_durationType.setSpCourseId(spCourseId);
	}

	/**
	* Returns the title1 of this duration type.
	*
	* @return the title1 of this duration type
	*/
	@Override
	public java.lang.String getTitle1() {
		return _durationType.getTitle1();
	}

	/**
	* Sets the title1 of this duration type.
	*
	* @param title1 the title1 of this duration type
	*/
	@Override
	public void setTitle1(java.lang.String title1) {
		_durationType.setTitle1(title1);
	}

	/**
	* Returns the duration1 of this duration type.
	*
	* @return the duration1 of this duration type
	*/
	@Override
	public long getDuration1() {
		return _durationType.getDuration1();
	}

	/**
	* Sets the duration1 of this duration type.
	*
	* @param duration1 the duration1 of this duration type
	*/
	@Override
	public void setDuration1(long duration1) {
		_durationType.setDuration1(duration1);
	}

	/**
	* Returns the title2 of this duration type.
	*
	* @return the title2 of this duration type
	*/
	@Override
	public java.lang.String getTitle2() {
		return _durationType.getTitle2();
	}

	/**
	* Sets the title2 of this duration type.
	*
	* @param title2 the title2 of this duration type
	*/
	@Override
	public void setTitle2(java.lang.String title2) {
		_durationType.setTitle2(title2);
	}

	/**
	* Returns the duration2 of this duration type.
	*
	* @return the duration2 of this duration type
	*/
	@Override
	public long getDuration2() {
		return _durationType.getDuration2();
	}

	/**
	* Sets the duration2 of this duration type.
	*
	* @param duration2 the duration2 of this duration type
	*/
	@Override
	public void setDuration2(long duration2) {
		_durationType.setDuration2(duration2);
	}

	@Override
	public boolean isNew() {
		return _durationType.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_durationType.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _durationType.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_durationType.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _durationType.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _durationType.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_durationType.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _durationType.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_durationType.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_durationType.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_durationType.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new DurationTypeWrapper((DurationType)_durationType.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.DurationType durationType) {
		return _durationType.compareTo(durationType);
	}

	@Override
	public int hashCode() {
		return _durationType.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.DurationType> toCacheModel() {
		return _durationType.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.DurationType toEscapedModel() {
		return new DurationTypeWrapper(_durationType.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.DurationType toUnescapedModel() {
		return new DurationTypeWrapper(_durationType.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _durationType.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _durationType.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_durationType.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof DurationTypeWrapper)) {
			return false;
		}

		DurationTypeWrapper durationTypeWrapper = (DurationTypeWrapper)obj;

		if (Validator.equals(_durationType, durationTypeWrapper._durationType)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public DurationType getWrappedDurationType() {
		return _durationType;
	}

	@Override
	public DurationType getWrappedModel() {
		return _durationType;
	}

	@Override
	public void resetOriginalValues() {
		_durationType.resetOriginalValues();
	}

	private DurationType _durationType;
}