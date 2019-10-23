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

package com.sambaash.platform.srv.genericuploader.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link GUUploadLog}.
 * </p>
 *
 * @author nareshchebolu
 * @see GUUploadLog
 * @generated
 */
public class GUUploadLogWrapper implements GUUploadLog,
	ModelWrapper<GUUploadLog> {
	public GUUploadLogWrapper(GUUploadLog guUploadLog) {
		_guUploadLog = guUploadLog;
	}

	@Override
	public Class<?> getModelClass() {
		return GUUploadLog.class;
	}

	@Override
	public String getModelClassName() {
		return GUUploadLog.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("SPGUUploadLogId", getSPGUUploadLogId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("successCount", getSuccessCount());
		attributes.put("errorCount", getErrorCount());
		attributes.put("startTime", getStartTime());
		attributes.put("endTime", getEndTime());
		attributes.put("uploadedFileEntryId", getUploadedFileEntryId());
		attributes.put("errorFileEntryId", getErrorFileEntryId());
		attributes.put("errors", getErrors());
		attributes.put("msgs", getMsgs());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long SPGUUploadLogId = (Long)attributes.get("SPGUUploadLogId");

		if (SPGUUploadLogId != null) {
			setSPGUUploadLogId(SPGUUploadLogId);
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

		Integer successCount = (Integer)attributes.get("successCount");

		if (successCount != null) {
			setSuccessCount(successCount);
		}

		Integer errorCount = (Integer)attributes.get("errorCount");

		if (errorCount != null) {
			setErrorCount(errorCount);
		}

		Date startTime = (Date)attributes.get("startTime");

		if (startTime != null) {
			setStartTime(startTime);
		}

		Date endTime = (Date)attributes.get("endTime");

		if (endTime != null) {
			setEndTime(endTime);
		}

		Long uploadedFileEntryId = (Long)attributes.get("uploadedFileEntryId");

		if (uploadedFileEntryId != null) {
			setUploadedFileEntryId(uploadedFileEntryId);
		}

		Long errorFileEntryId = (Long)attributes.get("errorFileEntryId");

		if (errorFileEntryId != null) {
			setErrorFileEntryId(errorFileEntryId);
		}

		String errors = (String)attributes.get("errors");

		if (errors != null) {
			setErrors(errors);
		}

		String msgs = (String)attributes.get("msgs");

		if (msgs != null) {
			setMsgs(msgs);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this g u upload log.
	*
	* @return the primary key of this g u upload log
	*/
	@Override
	public long getPrimaryKey() {
		return _guUploadLog.getPrimaryKey();
	}

	/**
	* Sets the primary key of this g u upload log.
	*
	* @param primaryKey the primary key of this g u upload log
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_guUploadLog.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the s p g u upload log ID of this g u upload log.
	*
	* @return the s p g u upload log ID of this g u upload log
	*/
	@Override
	public long getSPGUUploadLogId() {
		return _guUploadLog.getSPGUUploadLogId();
	}

	/**
	* Sets the s p g u upload log ID of this g u upload log.
	*
	* @param SPGUUploadLogId the s p g u upload log ID of this g u upload log
	*/
	@Override
	public void setSPGUUploadLogId(long SPGUUploadLogId) {
		_guUploadLog.setSPGUUploadLogId(SPGUUploadLogId);
	}

	/**
	* Returns the group ID of this g u upload log.
	*
	* @return the group ID of this g u upload log
	*/
	@Override
	public long getGroupId() {
		return _guUploadLog.getGroupId();
	}

	/**
	* Sets the group ID of this g u upload log.
	*
	* @param groupId the group ID of this g u upload log
	*/
	@Override
	public void setGroupId(long groupId) {
		_guUploadLog.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this g u upload log.
	*
	* @return the company ID of this g u upload log
	*/
	@Override
	public long getCompanyId() {
		return _guUploadLog.getCompanyId();
	}

	/**
	* Sets the company ID of this g u upload log.
	*
	* @param companyId the company ID of this g u upload log
	*/
	@Override
	public void setCompanyId(long companyId) {
		_guUploadLog.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this g u upload log.
	*
	* @return the user ID of this g u upload log
	*/
	@Override
	public long getUserId() {
		return _guUploadLog.getUserId();
	}

	/**
	* Sets the user ID of this g u upload log.
	*
	* @param userId the user ID of this g u upload log
	*/
	@Override
	public void setUserId(long userId) {
		_guUploadLog.setUserId(userId);
	}

	/**
	* Returns the user uuid of this g u upload log.
	*
	* @return the user uuid of this g u upload log
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _guUploadLog.getUserUuid();
	}

	/**
	* Sets the user uuid of this g u upload log.
	*
	* @param userUuid the user uuid of this g u upload log
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_guUploadLog.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this g u upload log.
	*
	* @return the user name of this g u upload log
	*/
	@Override
	public java.lang.String getUserName() {
		return _guUploadLog.getUserName();
	}

	/**
	* Sets the user name of this g u upload log.
	*
	* @param userName the user name of this g u upload log
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_guUploadLog.setUserName(userName);
	}

	/**
	* Returns the create date of this g u upload log.
	*
	* @return the create date of this g u upload log
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _guUploadLog.getCreateDate();
	}

	/**
	* Sets the create date of this g u upload log.
	*
	* @param createDate the create date of this g u upload log
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_guUploadLog.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this g u upload log.
	*
	* @return the modified date of this g u upload log
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _guUploadLog.getModifiedDate();
	}

	/**
	* Sets the modified date of this g u upload log.
	*
	* @param modifiedDate the modified date of this g u upload log
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_guUploadLog.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the success count of this g u upload log.
	*
	* @return the success count of this g u upload log
	*/
	@Override
	public int getSuccessCount() {
		return _guUploadLog.getSuccessCount();
	}

	/**
	* Sets the success count of this g u upload log.
	*
	* @param successCount the success count of this g u upload log
	*/
	@Override
	public void setSuccessCount(int successCount) {
		_guUploadLog.setSuccessCount(successCount);
	}

	/**
	* Returns the error count of this g u upload log.
	*
	* @return the error count of this g u upload log
	*/
	@Override
	public int getErrorCount() {
		return _guUploadLog.getErrorCount();
	}

	/**
	* Sets the error count of this g u upload log.
	*
	* @param errorCount the error count of this g u upload log
	*/
	@Override
	public void setErrorCount(int errorCount) {
		_guUploadLog.setErrorCount(errorCount);
	}

	/**
	* Returns the start time of this g u upload log.
	*
	* @return the start time of this g u upload log
	*/
	@Override
	public java.util.Date getStartTime() {
		return _guUploadLog.getStartTime();
	}

	/**
	* Sets the start time of this g u upload log.
	*
	* @param startTime the start time of this g u upload log
	*/
	@Override
	public void setStartTime(java.util.Date startTime) {
		_guUploadLog.setStartTime(startTime);
	}

	/**
	* Returns the end time of this g u upload log.
	*
	* @return the end time of this g u upload log
	*/
	@Override
	public java.util.Date getEndTime() {
		return _guUploadLog.getEndTime();
	}

	/**
	* Sets the end time of this g u upload log.
	*
	* @param endTime the end time of this g u upload log
	*/
	@Override
	public void setEndTime(java.util.Date endTime) {
		_guUploadLog.setEndTime(endTime);
	}

	/**
	* Returns the uploaded file entry ID of this g u upload log.
	*
	* @return the uploaded file entry ID of this g u upload log
	*/
	@Override
	public long getUploadedFileEntryId() {
		return _guUploadLog.getUploadedFileEntryId();
	}

	/**
	* Sets the uploaded file entry ID of this g u upload log.
	*
	* @param uploadedFileEntryId the uploaded file entry ID of this g u upload log
	*/
	@Override
	public void setUploadedFileEntryId(long uploadedFileEntryId) {
		_guUploadLog.setUploadedFileEntryId(uploadedFileEntryId);
	}

	/**
	* Returns the error file entry ID of this g u upload log.
	*
	* @return the error file entry ID of this g u upload log
	*/
	@Override
	public long getErrorFileEntryId() {
		return _guUploadLog.getErrorFileEntryId();
	}

	/**
	* Sets the error file entry ID of this g u upload log.
	*
	* @param errorFileEntryId the error file entry ID of this g u upload log
	*/
	@Override
	public void setErrorFileEntryId(long errorFileEntryId) {
		_guUploadLog.setErrorFileEntryId(errorFileEntryId);
	}

	/**
	* Returns the errors of this g u upload log.
	*
	* @return the errors of this g u upload log
	*/
	@Override
	public java.lang.String getErrors() {
		return _guUploadLog.getErrors();
	}

	/**
	* Sets the errors of this g u upload log.
	*
	* @param errors the errors of this g u upload log
	*/
	@Override
	public void setErrors(java.lang.String errors) {
		_guUploadLog.setErrors(errors);
	}

	/**
	* Returns the msgs of this g u upload log.
	*
	* @return the msgs of this g u upload log
	*/
	@Override
	public java.lang.String getMsgs() {
		return _guUploadLog.getMsgs();
	}

	/**
	* Sets the msgs of this g u upload log.
	*
	* @param msgs the msgs of this g u upload log
	*/
	@Override
	public void setMsgs(java.lang.String msgs) {
		_guUploadLog.setMsgs(msgs);
	}

	/**
	* Returns the status of this g u upload log.
	*
	* @return the status of this g u upload log
	*/
	@Override
	public java.lang.String getStatus() {
		return _guUploadLog.getStatus();
	}

	/**
	* Sets the status of this g u upload log.
	*
	* @param status the status of this g u upload log
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_guUploadLog.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _guUploadLog.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_guUploadLog.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _guUploadLog.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_guUploadLog.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _guUploadLog.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _guUploadLog.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_guUploadLog.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _guUploadLog.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_guUploadLog.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_guUploadLog.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_guUploadLog.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new GUUploadLogWrapper((GUUploadLog)_guUploadLog.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.genericuploader.model.GUUploadLog guUploadLog) {
		return _guUploadLog.compareTo(guUploadLog);
	}

	@Override
	public int hashCode() {
		return _guUploadLog.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.genericuploader.model.GUUploadLog> toCacheModel() {
		return _guUploadLog.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog toEscapedModel() {
		return new GUUploadLogWrapper(_guUploadLog.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog toUnescapedModel() {
		return new GUUploadLogWrapper(_guUploadLog.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _guUploadLog.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _guUploadLog.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_guUploadLog.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof GUUploadLogWrapper)) {
			return false;
		}

		GUUploadLogWrapper guUploadLogWrapper = (GUUploadLogWrapper)obj;

		if (Validator.equals(_guUploadLog, guUploadLogWrapper._guUploadLog)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public GUUploadLog getWrappedGUUploadLog() {
		return _guUploadLog;
	}

	@Override
	public GUUploadLog getWrappedModel() {
		return _guUploadLog;
	}

	@Override
	public void resetOriginalValues() {
		_guUploadLog.resetOriginalValues();
	}

	private GUUploadLog _guUploadLog;
}