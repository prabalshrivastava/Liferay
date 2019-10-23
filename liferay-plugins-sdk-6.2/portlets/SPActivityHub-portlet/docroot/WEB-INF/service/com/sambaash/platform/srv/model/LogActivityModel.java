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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the LogActivity service. Represents a row in the &quot;SPLogActivity&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.LogActivityModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.LogActivityImpl}.
 * </p>
 *
 * @author aishwarya
 * @see LogActivity
 * @see com.sambaash.platform.srv.model.impl.LogActivityImpl
 * @see com.sambaash.platform.srv.model.impl.LogActivityModelImpl
 * @generated
 */
public interface LogActivityModel extends BaseModel<LogActivity>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a log activity model instance should use the {@link LogActivity} interface instead.
	 */

	/**
	 * Returns the primary key of this log activity.
	 *
	 * @return the primary key of this log activity
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this log activity.
	 *
	 * @param primaryKey the primary key of this log activity
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp log activity ID of this log activity.
	 *
	 * @return the sp log activity ID of this log activity
	 */
	public long getSpLogActivityId();

	/**
	 * Sets the sp log activity ID of this log activity.
	 *
	 * @param spLogActivityId the sp log activity ID of this log activity
	 */
	public void setSpLogActivityId(long spLogActivityId);

	/**
	 * Returns the group ID of this log activity.
	 *
	 * @return the group ID of this log activity
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this log activity.
	 *
	 * @param groupId the group ID of this log activity
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this log activity.
	 *
	 * @return the company ID of this log activity
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this log activity.
	 *
	 * @param companyId the company ID of this log activity
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this log activity.
	 *
	 * @return the user ID of this log activity
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this log activity.
	 *
	 * @param userId the user ID of this log activity
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this log activity.
	 *
	 * @return the user uuid of this log activity
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this log activity.
	 *
	 * @param userUuid the user uuid of this log activity
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this log activity.
	 *
	 * @return the user name of this log activity
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this log activity.
	 *
	 * @param userName the user name of this log activity
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this log activity.
	 *
	 * @return the create date of this log activity
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this log activity.
	 *
	 * @param createDate the create date of this log activity
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this log activity.
	 *
	 * @return the modified date of this log activity
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this log activity.
	 *
	 * @param modifiedDate the modified date of this log activity
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the entity class ID of this log activity.
	 *
	 * @return the entity class ID of this log activity
	 */
	public long getEntityClassId();

	/**
	 * Sets the entity class ID of this log activity.
	 *
	 * @param entityClassId the entity class ID of this log activity
	 */
	public void setEntityClassId(long entityClassId);

	/**
	 * Returns the entity class name of this log activity.
	 *
	 * @return the entity class name of this log activity
	 */
	@AutoEscape
	public String getEntityClassName();

	/**
	 * Sets the entity class name of this log activity.
	 *
	 * @param entityClassName the entity class name of this log activity
	 */
	public void setEntityClassName(String entityClassName);

	/**
	 * Returns the entity ID of this log activity.
	 *
	 * @return the entity ID of this log activity
	 */
	public long getEntityId();

	/**
	 * Sets the entity ID of this log activity.
	 *
	 * @param entityId the entity ID of this log activity
	 */
	public void setEntityId(long entityId);

	/**
	 * Returns the saved by user ID of this log activity.
	 *
	 * @return the saved by user ID of this log activity
	 */
	public long getSavedByUserId();

	/**
	 * Sets the saved by user ID of this log activity.
	 *
	 * @param savedByUserId the saved by user ID of this log activity
	 */
	public void setSavedByUserId(long savedByUserId);

	/**
	 * Returns the saved by user uuid of this log activity.
	 *
	 * @return the saved by user uuid of this log activity
	 * @throws SystemException if a system exception occurred
	 */
	public String getSavedByUserUuid() throws SystemException;

	/**
	 * Sets the saved by user uuid of this log activity.
	 *
	 * @param savedByUserUuid the saved by user uuid of this log activity
	 */
	public void setSavedByUserUuid(String savedByUserUuid);

	/**
	 * Returns the activity title of this log activity.
	 *
	 * @return the activity title of this log activity
	 */
	@AutoEscape
	public String getActivityTitle();

	/**
	 * Sets the activity title of this log activity.
	 *
	 * @param activityTitle the activity title of this log activity
	 */
	public void setActivityTitle(String activityTitle);

	/**
	 * Returns the activity type of this log activity.
	 *
	 * @return the activity type of this log activity
	 */
	@AutoEscape
	public String getActivityType();

	/**
	 * Sets the activity type of this log activity.
	 *
	 * @param activityType the activity type of this log activity
	 */
	public void setActivityType(String activityType);

	/**
	 * Returns the activity outcome of this log activity.
	 *
	 * @return the activity outcome of this log activity
	 */
	@AutoEscape
	public String getActivityOutcome();

	/**
	 * Sets the activity outcome of this log activity.
	 *
	 * @param activityOutcome the activity outcome of this log activity
	 */
	public void setActivityOutcome(String activityOutcome);

	/**
	 * Returns the activity date of this log activity.
	 *
	 * @return the activity date of this log activity
	 */
	public Date getActivityDate();

	/**
	 * Sets the activity date of this log activity.
	 *
	 * @param activityDate the activity date of this log activity
	 */
	public void setActivityDate(Date activityDate);

	/**
	 * Returns the activity time of this log activity.
	 *
	 * @return the activity time of this log activity
	 */
	@AutoEscape
	public String getActivityTime();

	/**
	 * Sets the activity time of this log activity.
	 *
	 * @param activityTime the activity time of this log activity
	 */
	public void setActivityTime(String activityTime);

	/**
	 * Returns the activity content of this log activity.
	 *
	 * @return the activity content of this log activity
	 */
	@AutoEscape
	public String getActivityContent();

	/**
	 * Sets the activity content of this log activity.
	 *
	 * @param activityContent the activity content of this log activity
	 */
	public void setActivityContent(String activityContent);

	/**
	 * Returns the file entry ID of this log activity.
	 *
	 * @return the file entry ID of this log activity
	 */
	@AutoEscape
	public String getFileEntryId();

	/**
	 * Sets the file entry ID of this log activity.
	 *
	 * @param fileEntryId the file entry ID of this log activity
	 */
	public void setFileEntryId(String fileEntryId);

	/**
	 * Returns the associated with of this log activity.
	 *
	 * @return the associated with of this log activity
	 */
	public long getAssociatedWith();

	/**
	 * Sets the associated with of this log activity.
	 *
	 * @param associatedWith the associated with of this log activity
	 */
	public void setAssociatedWith(long associatedWith);

	/**
	 * Returns the status of this log activity.
	 *
	 * @return the status of this log activity
	 */
	public int getStatus();

	/**
	 * Sets the status of this log activity.
	 *
	 * @param status the status of this log activity
	 */
	public void setStatus(int status);

	/**
	 * Returns the parent log activity ID of this log activity.
	 *
	 * @return the parent log activity ID of this log activity
	 */
	public long getParentLogActivityId();

	/**
	 * Sets the parent log activity ID of this log activity.
	 *
	 * @param parentLogActivityId the parent log activity ID of this log activity
	 */
	public void setParentLogActivityId(long parentLogActivityId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.LogActivity logActivity);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.LogActivity> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.LogActivity toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.LogActivity toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}