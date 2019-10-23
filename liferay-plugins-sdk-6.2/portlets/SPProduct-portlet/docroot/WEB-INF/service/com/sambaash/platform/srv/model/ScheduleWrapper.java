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
 * This class is a wrapper for {@link Schedule}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Schedule
 * @generated
 */
public class ScheduleWrapper implements Schedule, ModelWrapper<Schedule> {
	public ScheduleWrapper(Schedule schedule) {
		_schedule = schedule;
	}

	@Override
	public Class<?> getModelClass() {
		return Schedule.class;
	}

	@Override
	public String getModelClassName() {
		return Schedule.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spScheduleId", getSpScheduleId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("sessionNumber", getSessionNumber());
		attributes.put("description", getDescription());
		attributes.put("sessionType", getSessionType());
		attributes.put("sessionDuration", getSessionDuration());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spScheduleId = (Long)attributes.get("spScheduleId");

		if (spScheduleId != null) {
			setSpScheduleId(spScheduleId);
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

		String sessionNumber = (String)attributes.get("sessionNumber");

		if (sessionNumber != null) {
			setSessionNumber(sessionNumber);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long sessionType = (Long)attributes.get("sessionType");

		if (sessionType != null) {
			setSessionType(sessionType);
		}

		String sessionDuration = (String)attributes.get("sessionDuration");

		if (sessionDuration != null) {
			setSessionDuration(sessionDuration);
		}
	}

	/**
	* Returns the primary key of this schedule.
	*
	* @return the primary key of this schedule
	*/
	@Override
	public long getPrimaryKey() {
		return _schedule.getPrimaryKey();
	}

	/**
	* Sets the primary key of this schedule.
	*
	* @param primaryKey the primary key of this schedule
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_schedule.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp schedule ID of this schedule.
	*
	* @return the sp schedule ID of this schedule
	*/
	@Override
	public long getSpScheduleId() {
		return _schedule.getSpScheduleId();
	}

	/**
	* Sets the sp schedule ID of this schedule.
	*
	* @param spScheduleId the sp schedule ID of this schedule
	*/
	@Override
	public void setSpScheduleId(long spScheduleId) {
		_schedule.setSpScheduleId(spScheduleId);
	}

	/**
	* Returns the group ID of this schedule.
	*
	* @return the group ID of this schedule
	*/
	@Override
	public long getGroupId() {
		return _schedule.getGroupId();
	}

	/**
	* Sets the group ID of this schedule.
	*
	* @param groupId the group ID of this schedule
	*/
	@Override
	public void setGroupId(long groupId) {
		_schedule.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this schedule.
	*
	* @return the company ID of this schedule
	*/
	@Override
	public long getCompanyId() {
		return _schedule.getCompanyId();
	}

	/**
	* Sets the company ID of this schedule.
	*
	* @param companyId the company ID of this schedule
	*/
	@Override
	public void setCompanyId(long companyId) {
		_schedule.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this schedule.
	*
	* @return the user ID of this schedule
	*/
	@Override
	public long getUserId() {
		return _schedule.getUserId();
	}

	/**
	* Sets the user ID of this schedule.
	*
	* @param userId the user ID of this schedule
	*/
	@Override
	public void setUserId(long userId) {
		_schedule.setUserId(userId);
	}

	/**
	* Returns the user uuid of this schedule.
	*
	* @return the user uuid of this schedule
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _schedule.getUserUuid();
	}

	/**
	* Sets the user uuid of this schedule.
	*
	* @param userUuid the user uuid of this schedule
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_schedule.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this schedule.
	*
	* @return the user name of this schedule
	*/
	@Override
	public java.lang.String getUserName() {
		return _schedule.getUserName();
	}

	/**
	* Sets the user name of this schedule.
	*
	* @param userName the user name of this schedule
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_schedule.setUserName(userName);
	}

	/**
	* Returns the create date of this schedule.
	*
	* @return the create date of this schedule
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _schedule.getCreateDate();
	}

	/**
	* Sets the create date of this schedule.
	*
	* @param createDate the create date of this schedule
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_schedule.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this schedule.
	*
	* @return the modified date of this schedule
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _schedule.getModifiedDate();
	}

	/**
	* Sets the modified date of this schedule.
	*
	* @param modifiedDate the modified date of this schedule
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_schedule.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp module ID of this schedule.
	*
	* @return the sp module ID of this schedule
	*/
	@Override
	public long getSpModuleId() {
		return _schedule.getSpModuleId();
	}

	/**
	* Sets the sp module ID of this schedule.
	*
	* @param spModuleId the sp module ID of this schedule
	*/
	@Override
	public void setSpModuleId(long spModuleId) {
		_schedule.setSpModuleId(spModuleId);
	}

	/**
	* Returns the session number of this schedule.
	*
	* @return the session number of this schedule
	*/
	@Override
	public java.lang.String getSessionNumber() {
		return _schedule.getSessionNumber();
	}

	/**
	* Sets the session number of this schedule.
	*
	* @param sessionNumber the session number of this schedule
	*/
	@Override
	public void setSessionNumber(java.lang.String sessionNumber) {
		_schedule.setSessionNumber(sessionNumber);
	}

	/**
	* Returns the description of this schedule.
	*
	* @return the description of this schedule
	*/
	@Override
	public java.lang.String getDescription() {
		return _schedule.getDescription();
	}

	/**
	* Sets the description of this schedule.
	*
	* @param description the description of this schedule
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_schedule.setDescription(description);
	}

	/**
	* Returns the session type of this schedule.
	*
	* @return the session type of this schedule
	*/
	@Override
	public long getSessionType() {
		return _schedule.getSessionType();
	}

	/**
	* Sets the session type of this schedule.
	*
	* @param sessionType the session type of this schedule
	*/
	@Override
	public void setSessionType(long sessionType) {
		_schedule.setSessionType(sessionType);
	}

	/**
	* Returns the session duration of this schedule.
	*
	* @return the session duration of this schedule
	*/
	@Override
	public java.lang.String getSessionDuration() {
		return _schedule.getSessionDuration();
	}

	/**
	* Sets the session duration of this schedule.
	*
	* @param sessionDuration the session duration of this schedule
	*/
	@Override
	public void setSessionDuration(java.lang.String sessionDuration) {
		_schedule.setSessionDuration(sessionDuration);
	}

	@Override
	public boolean isNew() {
		return _schedule.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_schedule.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _schedule.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_schedule.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _schedule.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _schedule.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_schedule.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _schedule.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_schedule.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_schedule.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_schedule.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ScheduleWrapper((Schedule)_schedule.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Schedule schedule) {
		return _schedule.compareTo(schedule);
	}

	@Override
	public int hashCode() {
		return _schedule.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Schedule> toCacheModel() {
		return _schedule.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Schedule toEscapedModel() {
		return new ScheduleWrapper(_schedule.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Schedule toUnescapedModel() {
		return new ScheduleWrapper(_schedule.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _schedule.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _schedule.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_schedule.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ScheduleWrapper)) {
			return false;
		}

		ScheduleWrapper scheduleWrapper = (ScheduleWrapper)obj;

		if (Validator.equals(_schedule, scheduleWrapper._schedule)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Schedule getWrappedSchedule() {
		return _schedule;
	}

	@Override
	public Schedule getWrappedModel() {
		return _schedule;
	}

	@Override
	public void resetOriginalValues() {
		_schedule.resetOriginalValues();
	}

	private Schedule _schedule;
}