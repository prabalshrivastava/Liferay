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

package com.sambaash.platform.srv.spscheduler.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPJobEntry}.
 * </p>
 *
 * @author pradeep
 * @see SPJobEntry
 * @generated
 */
public class SPJobEntryWrapper implements SPJobEntry, ModelWrapper<SPJobEntry> {
	public SPJobEntryWrapper(SPJobEntry spJobEntry) {
		_spJobEntry = spJobEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return SPJobEntry.class;
	}

	@Override
	public String getModelClassName() {
		return SPJobEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spJobEntryId", getSpJobEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("jobName", getJobName());
		attributes.put("jobClass", getJobClass());
		attributes.put("portletId", getPortletId());
		attributes.put("status", getStatus());
		attributes.put("statusMsg", getStatusMsg());
		attributes.put("cronExpression", getCronExpression());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spJobEntryId = (Long)attributes.get("spJobEntryId");

		if (spJobEntryId != null) {
			setSpJobEntryId(spJobEntryId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		String jobName = (String)attributes.get("jobName");

		if (jobName != null) {
			setJobName(jobName);
		}

		String jobClass = (String)attributes.get("jobClass");

		if (jobClass != null) {
			setJobClass(jobClass);
		}

		String portletId = (String)attributes.get("portletId");

		if (portletId != null) {
			setPortletId(portletId);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String statusMsg = (String)attributes.get("statusMsg");

		if (statusMsg != null) {
			setStatusMsg(statusMsg);
		}

		String cronExpression = (String)attributes.get("cronExpression");

		if (cronExpression != null) {
			setCronExpression(cronExpression);
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
	}

	/**
	* Returns the primary key of this s p job entry.
	*
	* @return the primary key of this s p job entry
	*/
	@Override
	public long getPrimaryKey() {
		return _spJobEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p job entry.
	*
	* @param primaryKey the primary key of this s p job entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spJobEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p job entry.
	*
	* @return the uuid of this s p job entry
	*/
	@Override
	public java.lang.String getUuid() {
		return _spJobEntry.getUuid();
	}

	/**
	* Sets the uuid of this s p job entry.
	*
	* @param uuid the uuid of this s p job entry
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spJobEntry.setUuid(uuid);
	}

	/**
	* Returns the sp job entry ID of this s p job entry.
	*
	* @return the sp job entry ID of this s p job entry
	*/
	@Override
	public long getSpJobEntryId() {
		return _spJobEntry.getSpJobEntryId();
	}

	/**
	* Sets the sp job entry ID of this s p job entry.
	*
	* @param spJobEntryId the sp job entry ID of this s p job entry
	*/
	@Override
	public void setSpJobEntryId(long spJobEntryId) {
		_spJobEntry.setSpJobEntryId(spJobEntryId);
	}

	/**
	* Returns the group ID of this s p job entry.
	*
	* @return the group ID of this s p job entry
	*/
	@Override
	public long getGroupId() {
		return _spJobEntry.getGroupId();
	}

	/**
	* Sets the group ID of this s p job entry.
	*
	* @param groupId the group ID of this s p job entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_spJobEntry.setGroupId(groupId);
	}

	/**
	* Returns the job name of this s p job entry.
	*
	* @return the job name of this s p job entry
	*/
	@Override
	public java.lang.String getJobName() {
		return _spJobEntry.getJobName();
	}

	/**
	* Sets the job name of this s p job entry.
	*
	* @param jobName the job name of this s p job entry
	*/
	@Override
	public void setJobName(java.lang.String jobName) {
		_spJobEntry.setJobName(jobName);
	}

	/**
	* Returns the job class of this s p job entry.
	*
	* @return the job class of this s p job entry
	*/
	@Override
	public java.lang.String getJobClass() {
		return _spJobEntry.getJobClass();
	}

	/**
	* Sets the job class of this s p job entry.
	*
	* @param jobClass the job class of this s p job entry
	*/
	@Override
	public void setJobClass(java.lang.String jobClass) {
		_spJobEntry.setJobClass(jobClass);
	}

	/**
	* Returns the portlet ID of this s p job entry.
	*
	* @return the portlet ID of this s p job entry
	*/
	@Override
	public java.lang.String getPortletId() {
		return _spJobEntry.getPortletId();
	}

	/**
	* Sets the portlet ID of this s p job entry.
	*
	* @param portletId the portlet ID of this s p job entry
	*/
	@Override
	public void setPortletId(java.lang.String portletId) {
		_spJobEntry.setPortletId(portletId);
	}

	/**
	* Returns the status of this s p job entry.
	*
	* @return the status of this s p job entry
	*/
	@Override
	public int getStatus() {
		return _spJobEntry.getStatus();
	}

	/**
	* Sets the status of this s p job entry.
	*
	* @param status the status of this s p job entry
	*/
	@Override
	public void setStatus(int status) {
		_spJobEntry.setStatus(status);
	}

	/**
	* Returns the status msg of this s p job entry.
	*
	* @return the status msg of this s p job entry
	*/
	@Override
	public java.lang.String getStatusMsg() {
		return _spJobEntry.getStatusMsg();
	}

	/**
	* Sets the status msg of this s p job entry.
	*
	* @param statusMsg the status msg of this s p job entry
	*/
	@Override
	public void setStatusMsg(java.lang.String statusMsg) {
		_spJobEntry.setStatusMsg(statusMsg);
	}

	/**
	* Returns the cron expression of this s p job entry.
	*
	* @return the cron expression of this s p job entry
	*/
	@Override
	public java.lang.String getCronExpression() {
		return _spJobEntry.getCronExpression();
	}

	/**
	* Sets the cron expression of this s p job entry.
	*
	* @param cronExpression the cron expression of this s p job entry
	*/
	@Override
	public void setCronExpression(java.lang.String cronExpression) {
		_spJobEntry.setCronExpression(cronExpression);
	}

	/**
	* Returns the company ID of this s p job entry.
	*
	* @return the company ID of this s p job entry
	*/
	@Override
	public long getCompanyId() {
		return _spJobEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this s p job entry.
	*
	* @param companyId the company ID of this s p job entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spJobEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p job entry.
	*
	* @return the user ID of this s p job entry
	*/
	@Override
	public long getUserId() {
		return _spJobEntry.getUserId();
	}

	/**
	* Sets the user ID of this s p job entry.
	*
	* @param userId the user ID of this s p job entry
	*/
	@Override
	public void setUserId(long userId) {
		_spJobEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p job entry.
	*
	* @return the user uuid of this s p job entry
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p job entry.
	*
	* @param userUuid the user uuid of this s p job entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spJobEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p job entry.
	*
	* @return the user name of this s p job entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _spJobEntry.getUserName();
	}

	/**
	* Sets the user name of this s p job entry.
	*
	* @param userName the user name of this s p job entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spJobEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this s p job entry.
	*
	* @return the create date of this s p job entry
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spJobEntry.getCreateDate();
	}

	/**
	* Sets the create date of this s p job entry.
	*
	* @param createDate the create date of this s p job entry
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spJobEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p job entry.
	*
	* @return the modified date of this s p job entry
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spJobEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p job entry.
	*
	* @param modifiedDate the modified date of this s p job entry
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spJobEntry.setModifiedDate(modifiedDate);
	}

	@Override
	public boolean isNew() {
		return _spJobEntry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spJobEntry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spJobEntry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spJobEntry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spJobEntry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spJobEntry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spJobEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spJobEntry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spJobEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spJobEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spJobEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPJobEntryWrapper((SPJobEntry)_spJobEntry.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spscheduler.model.SPJobEntry spJobEntry) {
		return _spJobEntry.compareTo(spJobEntry);
	}

	@Override
	public int hashCode() {
		return _spJobEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spscheduler.model.SPJobEntry> toCacheModel() {
		return _spJobEntry.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry toEscapedModel() {
		return new SPJobEntryWrapper(_spJobEntry.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spscheduler.model.SPJobEntry toUnescapedModel() {
		return new SPJobEntryWrapper(_spJobEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spJobEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spJobEntry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spJobEntry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPJobEntryWrapper)) {
			return false;
		}

		SPJobEntryWrapper spJobEntryWrapper = (SPJobEntryWrapper)obj;

		if (Validator.equals(_spJobEntry, spJobEntryWrapper._spJobEntry)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spJobEntry.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPJobEntry getWrappedSPJobEntry() {
		return _spJobEntry;
	}

	@Override
	public SPJobEntry getWrappedModel() {
		return _spJobEntry;
	}

	@Override
	public void resetOriginalValues() {
		_spJobEntry.resetOriginalValues();
	}

	private SPJobEntry _spJobEntry;
}