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
 * This class is a wrapper for {@link Activity}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Activity
 * @generated
 */
public class ActivityWrapper implements Activity, ModelWrapper<Activity> {
	public ActivityWrapper(Activity activity) {
		_activity = activity;
	}

	@Override
	public Class<?> getModelClass() {
		return Activity.class;
	}

	@Override
	public String getModelClassName() {
		return Activity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spActivityId", getSpActivityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("spScheduleId", getSpScheduleId());
		attributes.put("description", getDescription());
		attributes.put("activityTiming", getActivityTiming());
		attributes.put("activityPerformer", getActivityPerformer());
		attributes.put("activityDuration", getActivityDuration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spActivityId = (Long)attributes.get("spActivityId");

		if (spActivityId != null) {
			setSpActivityId(spActivityId);
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

		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
		}

		Long spScheduleId = (Long)attributes.get("spScheduleId");

		if (spScheduleId != null) {
			setSpScheduleId(spScheduleId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String activityTiming = (String)attributes.get("activityTiming");

		if (activityTiming != null) {
			setActivityTiming(activityTiming);
		}

		String activityPerformer = (String)attributes.get("activityPerformer");

		if (activityPerformer != null) {
			setActivityPerformer(activityPerformer);
		}

		String activityDuration = (String)attributes.get("activityDuration");

		if (activityDuration != null) {
			setActivityDuration(activityDuration);
		}
	}

	/**
	* Returns the primary key of this activity.
	*
	* @return the primary key of this activity
	*/
	@Override
	public long getPrimaryKey() {
		return _activity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this activity.
	*
	* @param primaryKey the primary key of this activity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_activity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp activity ID of this activity.
	*
	* @return the sp activity ID of this activity
	*/
	@Override
	public long getSpActivityId() {
		return _activity.getSpActivityId();
	}

	/**
	* Sets the sp activity ID of this activity.
	*
	* @param spActivityId the sp activity ID of this activity
	*/
	@Override
	public void setSpActivityId(long spActivityId) {
		_activity.setSpActivityId(spActivityId);
	}

	/**
	* Returns the group ID of this activity.
	*
	* @return the group ID of this activity
	*/
	@Override
	public long getGroupId() {
		return _activity.getGroupId();
	}

	/**
	* Sets the group ID of this activity.
	*
	* @param groupId the group ID of this activity
	*/
	@Override
	public void setGroupId(long groupId) {
		_activity.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this activity.
	*
	* @return the company ID of this activity
	*/
	@Override
	public long getCompanyId() {
		return _activity.getCompanyId();
	}

	/**
	* Sets the company ID of this activity.
	*
	* @param companyId the company ID of this activity
	*/
	@Override
	public void setCompanyId(long companyId) {
		_activity.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this activity.
	*
	* @return the user ID of this activity
	*/
	@Override
	public long getUserId() {
		return _activity.getUserId();
	}

	/**
	* Sets the user ID of this activity.
	*
	* @param userId the user ID of this activity
	*/
	@Override
	public void setUserId(long userId) {
		_activity.setUserId(userId);
	}

	/**
	* Returns the user uuid of this activity.
	*
	* @return the user uuid of this activity
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activity.getUserUuid();
	}

	/**
	* Sets the user uuid of this activity.
	*
	* @param userUuid the user uuid of this activity
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_activity.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this activity.
	*
	* @return the user name of this activity
	*/
	@Override
	public java.lang.String getUserName() {
		return _activity.getUserName();
	}

	/**
	* Sets the user name of this activity.
	*
	* @param userName the user name of this activity
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_activity.setUserName(userName);
	}

	/**
	* Returns the create date of this activity.
	*
	* @return the create date of this activity
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _activity.getCreateDate();
	}

	/**
	* Sets the create date of this activity.
	*
	* @param createDate the create date of this activity
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_activity.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this activity.
	*
	* @return the modified date of this activity
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _activity.getModifiedDate();
	}

	/**
	* Sets the modified date of this activity.
	*
	* @param modifiedDate the modified date of this activity
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_activity.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp module ID of this activity.
	*
	* @return the sp module ID of this activity
	*/
	@Override
	public long getSpModuleId() {
		return _activity.getSpModuleId();
	}

	/**
	* Sets the sp module ID of this activity.
	*
	* @param spModuleId the sp module ID of this activity
	*/
	@Override
	public void setSpModuleId(long spModuleId) {
		_activity.setSpModuleId(spModuleId);
	}

	/**
	* Returns the sp schedule ID of this activity.
	*
	* @return the sp schedule ID of this activity
	*/
	@Override
	public long getSpScheduleId() {
		return _activity.getSpScheduleId();
	}

	/**
	* Sets the sp schedule ID of this activity.
	*
	* @param spScheduleId the sp schedule ID of this activity
	*/
	@Override
	public void setSpScheduleId(long spScheduleId) {
		_activity.setSpScheduleId(spScheduleId);
	}

	/**
	* Returns the description of this activity.
	*
	* @return the description of this activity
	*/
	@Override
	public java.lang.String getDescription() {
		return _activity.getDescription();
	}

	/**
	* Sets the description of this activity.
	*
	* @param description the description of this activity
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_activity.setDescription(description);
	}

	/**
	* Returns the activity timing of this activity.
	*
	* @return the activity timing of this activity
	*/
	@Override
	public java.lang.String getActivityTiming() {
		return _activity.getActivityTiming();
	}

	/**
	* Sets the activity timing of this activity.
	*
	* @param activityTiming the activity timing of this activity
	*/
	@Override
	public void setActivityTiming(java.lang.String activityTiming) {
		_activity.setActivityTiming(activityTiming);
	}

	/**
	* Returns the activity performer of this activity.
	*
	* @return the activity performer of this activity
	*/
	@Override
	public java.lang.String getActivityPerformer() {
		return _activity.getActivityPerformer();
	}

	/**
	* Sets the activity performer of this activity.
	*
	* @param activityPerformer the activity performer of this activity
	*/
	@Override
	public void setActivityPerformer(java.lang.String activityPerformer) {
		_activity.setActivityPerformer(activityPerformer);
	}

	/**
	* Returns the activity duration of this activity.
	*
	* @return the activity duration of this activity
	*/
	@Override
	public java.lang.String getActivityDuration() {
		return _activity.getActivityDuration();
	}

	/**
	* Sets the activity duration of this activity.
	*
	* @param activityDuration the activity duration of this activity
	*/
	@Override
	public void setActivityDuration(java.lang.String activityDuration) {
		_activity.setActivityDuration(activityDuration);
	}

	@Override
	public boolean isNew() {
		return _activity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_activity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _activity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_activity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _activity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _activity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_activity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _activity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_activity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_activity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_activity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ActivityWrapper((Activity)_activity.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Activity activity) {
		return _activity.compareTo(activity);
	}

	@Override
	public int hashCode() {
		return _activity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Activity> toCacheModel() {
		return _activity.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Activity toEscapedModel() {
		return new ActivityWrapper(_activity.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Activity toUnescapedModel() {
		return new ActivityWrapper(_activity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _activity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _activity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_activity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ActivityWrapper)) {
			return false;
		}

		ActivityWrapper activityWrapper = (ActivityWrapper)obj;

		if (Validator.equals(_activity, activityWrapper._activity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Activity getWrappedActivity() {
		return _activity;
	}

	@Override
	public Activity getWrappedModel() {
		return _activity;
	}

	@Override
	public void resetOriginalValues() {
		_activity.resetOriginalValues();
	}

	private Activity _activity;
}