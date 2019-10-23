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
 * This class is a wrapper for {@link LogActivity}.
 * </p>
 *
 * @author aishwarya
 * @see LogActivity
 * @generated
 */
public class LogActivityWrapper implements LogActivity,
	ModelWrapper<LogActivity> {
	public LogActivityWrapper(LogActivity logActivity) {
		_logActivity = logActivity;
	}

	@Override
	public Class<?> getModelClass() {
		return LogActivity.class;
	}

	@Override
	public String getModelClassName() {
		return LogActivity.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spLogActivityId", getSpLogActivityId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("entityClassId", getEntityClassId());
		attributes.put("entityClassName", getEntityClassName());
		attributes.put("entityId", getEntityId());
		attributes.put("savedByUserId", getSavedByUserId());
		attributes.put("activityTitle", getActivityTitle());
		attributes.put("activityType", getActivityType());
		attributes.put("activityOutcome", getActivityOutcome());
		attributes.put("activityDate", getActivityDate());
		attributes.put("activityTime", getActivityTime());
		attributes.put("activityContent", getActivityContent());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("associatedWith", getAssociatedWith());
		attributes.put("status", getStatus());
		attributes.put("parentLogActivityId", getParentLogActivityId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spLogActivityId = (Long)attributes.get("spLogActivityId");

		if (spLogActivityId != null) {
			setSpLogActivityId(spLogActivityId);
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

		Long entityClassId = (Long)attributes.get("entityClassId");

		if (entityClassId != null) {
			setEntityClassId(entityClassId);
		}

		String entityClassName = (String)attributes.get("entityClassName");

		if (entityClassName != null) {
			setEntityClassName(entityClassName);
		}

		Long entityId = (Long)attributes.get("entityId");

		if (entityId != null) {
			setEntityId(entityId);
		}

		Long savedByUserId = (Long)attributes.get("savedByUserId");

		if (savedByUserId != null) {
			setSavedByUserId(savedByUserId);
		}

		String activityTitle = (String)attributes.get("activityTitle");

		if (activityTitle != null) {
			setActivityTitle(activityTitle);
		}

		String activityType = (String)attributes.get("activityType");

		if (activityType != null) {
			setActivityType(activityType);
		}

		String activityOutcome = (String)attributes.get("activityOutcome");

		if (activityOutcome != null) {
			setActivityOutcome(activityOutcome);
		}

		Date activityDate = (Date)attributes.get("activityDate");

		if (activityDate != null) {
			setActivityDate(activityDate);
		}

		String activityTime = (String)attributes.get("activityTime");

		if (activityTime != null) {
			setActivityTime(activityTime);
		}

		String activityContent = (String)attributes.get("activityContent");

		if (activityContent != null) {
			setActivityContent(activityContent);
		}

		String fileEntryId = (String)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long associatedWith = (Long)attributes.get("associatedWith");

		if (associatedWith != null) {
			setAssociatedWith(associatedWith);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long parentLogActivityId = (Long)attributes.get("parentLogActivityId");

		if (parentLogActivityId != null) {
			setParentLogActivityId(parentLogActivityId);
		}
	}

	/**
	* Returns the primary key of this log activity.
	*
	* @return the primary key of this log activity
	*/
	@Override
	public long getPrimaryKey() {
		return _logActivity.getPrimaryKey();
	}

	/**
	* Sets the primary key of this log activity.
	*
	* @param primaryKey the primary key of this log activity
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_logActivity.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp log activity ID of this log activity.
	*
	* @return the sp log activity ID of this log activity
	*/
	@Override
	public long getSpLogActivityId() {
		return _logActivity.getSpLogActivityId();
	}

	/**
	* Sets the sp log activity ID of this log activity.
	*
	* @param spLogActivityId the sp log activity ID of this log activity
	*/
	@Override
	public void setSpLogActivityId(long spLogActivityId) {
		_logActivity.setSpLogActivityId(spLogActivityId);
	}

	/**
	* Returns the group ID of this log activity.
	*
	* @return the group ID of this log activity
	*/
	@Override
	public long getGroupId() {
		return _logActivity.getGroupId();
	}

	/**
	* Sets the group ID of this log activity.
	*
	* @param groupId the group ID of this log activity
	*/
	@Override
	public void setGroupId(long groupId) {
		_logActivity.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this log activity.
	*
	* @return the company ID of this log activity
	*/
	@Override
	public long getCompanyId() {
		return _logActivity.getCompanyId();
	}

	/**
	* Sets the company ID of this log activity.
	*
	* @param companyId the company ID of this log activity
	*/
	@Override
	public void setCompanyId(long companyId) {
		_logActivity.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this log activity.
	*
	* @return the user ID of this log activity
	*/
	@Override
	public long getUserId() {
		return _logActivity.getUserId();
	}

	/**
	* Sets the user ID of this log activity.
	*
	* @param userId the user ID of this log activity
	*/
	@Override
	public void setUserId(long userId) {
		_logActivity.setUserId(userId);
	}

	/**
	* Returns the user uuid of this log activity.
	*
	* @return the user uuid of this log activity
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivity.getUserUuid();
	}

	/**
	* Sets the user uuid of this log activity.
	*
	* @param userUuid the user uuid of this log activity
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_logActivity.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this log activity.
	*
	* @return the user name of this log activity
	*/
	@Override
	public java.lang.String getUserName() {
		return _logActivity.getUserName();
	}

	/**
	* Sets the user name of this log activity.
	*
	* @param userName the user name of this log activity
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_logActivity.setUserName(userName);
	}

	/**
	* Returns the create date of this log activity.
	*
	* @return the create date of this log activity
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _logActivity.getCreateDate();
	}

	/**
	* Sets the create date of this log activity.
	*
	* @param createDate the create date of this log activity
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_logActivity.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this log activity.
	*
	* @return the modified date of this log activity
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _logActivity.getModifiedDate();
	}

	/**
	* Sets the modified date of this log activity.
	*
	* @param modifiedDate the modified date of this log activity
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_logActivity.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the entity class ID of this log activity.
	*
	* @return the entity class ID of this log activity
	*/
	@Override
	public long getEntityClassId() {
		return _logActivity.getEntityClassId();
	}

	/**
	* Sets the entity class ID of this log activity.
	*
	* @param entityClassId the entity class ID of this log activity
	*/
	@Override
	public void setEntityClassId(long entityClassId) {
		_logActivity.setEntityClassId(entityClassId);
	}

	/**
	* Returns the entity class name of this log activity.
	*
	* @return the entity class name of this log activity
	*/
	@Override
	public java.lang.String getEntityClassName() {
		return _logActivity.getEntityClassName();
	}

	/**
	* Sets the entity class name of this log activity.
	*
	* @param entityClassName the entity class name of this log activity
	*/
	@Override
	public void setEntityClassName(java.lang.String entityClassName) {
		_logActivity.setEntityClassName(entityClassName);
	}

	/**
	* Returns the entity ID of this log activity.
	*
	* @return the entity ID of this log activity
	*/
	@Override
	public long getEntityId() {
		return _logActivity.getEntityId();
	}

	/**
	* Sets the entity ID of this log activity.
	*
	* @param entityId the entity ID of this log activity
	*/
	@Override
	public void setEntityId(long entityId) {
		_logActivity.setEntityId(entityId);
	}

	/**
	* Returns the saved by user ID of this log activity.
	*
	* @return the saved by user ID of this log activity
	*/
	@Override
	public long getSavedByUserId() {
		return _logActivity.getSavedByUserId();
	}

	/**
	* Sets the saved by user ID of this log activity.
	*
	* @param savedByUserId the saved by user ID of this log activity
	*/
	@Override
	public void setSavedByUserId(long savedByUserId) {
		_logActivity.setSavedByUserId(savedByUserId);
	}

	/**
	* Returns the saved by user uuid of this log activity.
	*
	* @return the saved by user uuid of this log activity
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getSavedByUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _logActivity.getSavedByUserUuid();
	}

	/**
	* Sets the saved by user uuid of this log activity.
	*
	* @param savedByUserUuid the saved by user uuid of this log activity
	*/
	@Override
	public void setSavedByUserUuid(java.lang.String savedByUserUuid) {
		_logActivity.setSavedByUserUuid(savedByUserUuid);
	}

	/**
	* Returns the activity title of this log activity.
	*
	* @return the activity title of this log activity
	*/
	@Override
	public java.lang.String getActivityTitle() {
		return _logActivity.getActivityTitle();
	}

	/**
	* Sets the activity title of this log activity.
	*
	* @param activityTitle the activity title of this log activity
	*/
	@Override
	public void setActivityTitle(java.lang.String activityTitle) {
		_logActivity.setActivityTitle(activityTitle);
	}

	/**
	* Returns the activity type of this log activity.
	*
	* @return the activity type of this log activity
	*/
	@Override
	public java.lang.String getActivityType() {
		return _logActivity.getActivityType();
	}

	/**
	* Sets the activity type of this log activity.
	*
	* @param activityType the activity type of this log activity
	*/
	@Override
	public void setActivityType(java.lang.String activityType) {
		_logActivity.setActivityType(activityType);
	}

	/**
	* Returns the activity outcome of this log activity.
	*
	* @return the activity outcome of this log activity
	*/
	@Override
	public java.lang.String getActivityOutcome() {
		return _logActivity.getActivityOutcome();
	}

	/**
	* Sets the activity outcome of this log activity.
	*
	* @param activityOutcome the activity outcome of this log activity
	*/
	@Override
	public void setActivityOutcome(java.lang.String activityOutcome) {
		_logActivity.setActivityOutcome(activityOutcome);
	}

	/**
	* Returns the activity date of this log activity.
	*
	* @return the activity date of this log activity
	*/
	@Override
	public java.util.Date getActivityDate() {
		return _logActivity.getActivityDate();
	}

	/**
	* Sets the activity date of this log activity.
	*
	* @param activityDate the activity date of this log activity
	*/
	@Override
	public void setActivityDate(java.util.Date activityDate) {
		_logActivity.setActivityDate(activityDate);
	}

	/**
	* Returns the activity time of this log activity.
	*
	* @return the activity time of this log activity
	*/
	@Override
	public java.lang.String getActivityTime() {
		return _logActivity.getActivityTime();
	}

	/**
	* Sets the activity time of this log activity.
	*
	* @param activityTime the activity time of this log activity
	*/
	@Override
	public void setActivityTime(java.lang.String activityTime) {
		_logActivity.setActivityTime(activityTime);
	}

	/**
	* Returns the activity content of this log activity.
	*
	* @return the activity content of this log activity
	*/
	@Override
	public java.lang.String getActivityContent() {
		return _logActivity.getActivityContent();
	}

	/**
	* Sets the activity content of this log activity.
	*
	* @param activityContent the activity content of this log activity
	*/
	@Override
	public void setActivityContent(java.lang.String activityContent) {
		_logActivity.setActivityContent(activityContent);
	}

	/**
	* Returns the file entry ID of this log activity.
	*
	* @return the file entry ID of this log activity
	*/
	@Override
	public java.lang.String getFileEntryId() {
		return _logActivity.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this log activity.
	*
	* @param fileEntryId the file entry ID of this log activity
	*/
	@Override
	public void setFileEntryId(java.lang.String fileEntryId) {
		_logActivity.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the associated with of this log activity.
	*
	* @return the associated with of this log activity
	*/
	@Override
	public long getAssociatedWith() {
		return _logActivity.getAssociatedWith();
	}

	/**
	* Sets the associated with of this log activity.
	*
	* @param associatedWith the associated with of this log activity
	*/
	@Override
	public void setAssociatedWith(long associatedWith) {
		_logActivity.setAssociatedWith(associatedWith);
	}

	/**
	* Returns the status of this log activity.
	*
	* @return the status of this log activity
	*/
	@Override
	public int getStatus() {
		return _logActivity.getStatus();
	}

	/**
	* Sets the status of this log activity.
	*
	* @param status the status of this log activity
	*/
	@Override
	public void setStatus(int status) {
		_logActivity.setStatus(status);
	}

	/**
	* Returns the parent log activity ID of this log activity.
	*
	* @return the parent log activity ID of this log activity
	*/
	@Override
	public long getParentLogActivityId() {
		return _logActivity.getParentLogActivityId();
	}

	/**
	* Sets the parent log activity ID of this log activity.
	*
	* @param parentLogActivityId the parent log activity ID of this log activity
	*/
	@Override
	public void setParentLogActivityId(long parentLogActivityId) {
		_logActivity.setParentLogActivityId(parentLogActivityId);
	}

	@Override
	public boolean isNew() {
		return _logActivity.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_logActivity.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _logActivity.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_logActivity.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _logActivity.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _logActivity.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_logActivity.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _logActivity.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_logActivity.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_logActivity.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_logActivity.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new LogActivityWrapper((LogActivity)_logActivity.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.LogActivity logActivity) {
		return _logActivity.compareTo(logActivity);
	}

	@Override
	public int hashCode() {
		return _logActivity.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.LogActivity> toCacheModel() {
		return _logActivity.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.LogActivity toEscapedModel() {
		return new LogActivityWrapper(_logActivity.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.LogActivity toUnescapedModel() {
		return new LogActivityWrapper(_logActivity.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _logActivity.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _logActivity.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_logActivity.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof LogActivityWrapper)) {
			return false;
		}

		LogActivityWrapper logActivityWrapper = (LogActivityWrapper)obj;

		if (Validator.equals(_logActivity, logActivityWrapper._logActivity)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public LogActivity getWrappedLogActivity() {
		return _logActivity;
	}

	@Override
	public LogActivity getWrappedModel() {
		return _logActivity;
	}

	@Override
	public void resetOriginalValues() {
		_logActivity.resetOriginalValues();
	}

	private LogActivity _logActivity;
}