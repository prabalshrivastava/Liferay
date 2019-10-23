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

package com.sambaash.platform.srv.video.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link VideoFileEntry}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see VideoFileEntry
 * @generated
 */
public class VideoFileEntryWrapper implements VideoFileEntry,
	ModelWrapper<VideoFileEntry> {
	public VideoFileEntryWrapper(VideoFileEntry videoFileEntry) {
		_videoFileEntry = videoFileEntry;
	}

	@Override
	public Class<?> getModelClass() {
		return VideoFileEntry.class;
	}

	@Override
	public String getModelClassName() {
		return VideoFileEntry.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spVideoFileEntryId", getSpVideoFileEntryId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("fileEntryId", getFileEntryId());
		attributes.put("fileVersionId", getFileVersionId());
		attributes.put("folderId", getFolderId());
		attributes.put("jobId", getJobId());
		attributes.put("jobResponse", getJobResponse());
		attributes.put("status", getStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spVideoFileEntryId = (Long)attributes.get("spVideoFileEntryId");

		if (spVideoFileEntryId != null) {
			setSpVideoFileEntryId(spVideoFileEntryId);
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

		Long fileEntryId = (Long)attributes.get("fileEntryId");

		if (fileEntryId != null) {
			setFileEntryId(fileEntryId);
		}

		Long fileVersionId = (Long)attributes.get("fileVersionId");

		if (fileVersionId != null) {
			setFileVersionId(fileVersionId);
		}

		Long folderId = (Long)attributes.get("folderId");

		if (folderId != null) {
			setFolderId(folderId);
		}

		String jobId = (String)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		String jobResponse = (String)attributes.get("jobResponse");

		if (jobResponse != null) {
			setJobResponse(jobResponse);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}
	}

	/**
	* Returns the primary key of this video file entry.
	*
	* @return the primary key of this video file entry
	*/
	@Override
	public long getPrimaryKey() {
		return _videoFileEntry.getPrimaryKey();
	}

	/**
	* Sets the primary key of this video file entry.
	*
	* @param primaryKey the primary key of this video file entry
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_videoFileEntry.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp video file entry ID of this video file entry.
	*
	* @return the sp video file entry ID of this video file entry
	*/
	@Override
	public long getSpVideoFileEntryId() {
		return _videoFileEntry.getSpVideoFileEntryId();
	}

	/**
	* Sets the sp video file entry ID of this video file entry.
	*
	* @param spVideoFileEntryId the sp video file entry ID of this video file entry
	*/
	@Override
	public void setSpVideoFileEntryId(long spVideoFileEntryId) {
		_videoFileEntry.setSpVideoFileEntryId(spVideoFileEntryId);
	}

	/**
	* Returns the group ID of this video file entry.
	*
	* @return the group ID of this video file entry
	*/
	@Override
	public long getGroupId() {
		return _videoFileEntry.getGroupId();
	}

	/**
	* Sets the group ID of this video file entry.
	*
	* @param groupId the group ID of this video file entry
	*/
	@Override
	public void setGroupId(long groupId) {
		_videoFileEntry.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this video file entry.
	*
	* @return the company ID of this video file entry
	*/
	@Override
	public long getCompanyId() {
		return _videoFileEntry.getCompanyId();
	}

	/**
	* Sets the company ID of this video file entry.
	*
	* @param companyId the company ID of this video file entry
	*/
	@Override
	public void setCompanyId(long companyId) {
		_videoFileEntry.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this video file entry.
	*
	* @return the user ID of this video file entry
	*/
	@Override
	public long getUserId() {
		return _videoFileEntry.getUserId();
	}

	/**
	* Sets the user ID of this video file entry.
	*
	* @param userId the user ID of this video file entry
	*/
	@Override
	public void setUserId(long userId) {
		_videoFileEntry.setUserId(userId);
	}

	/**
	* Returns the user uuid of this video file entry.
	*
	* @return the user uuid of this video file entry
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _videoFileEntry.getUserUuid();
	}

	/**
	* Sets the user uuid of this video file entry.
	*
	* @param userUuid the user uuid of this video file entry
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_videoFileEntry.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this video file entry.
	*
	* @return the user name of this video file entry
	*/
	@Override
	public java.lang.String getUserName() {
		return _videoFileEntry.getUserName();
	}

	/**
	* Sets the user name of this video file entry.
	*
	* @param userName the user name of this video file entry
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_videoFileEntry.setUserName(userName);
	}

	/**
	* Returns the create date of this video file entry.
	*
	* @return the create date of this video file entry
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _videoFileEntry.getCreateDate();
	}

	/**
	* Sets the create date of this video file entry.
	*
	* @param createDate the create date of this video file entry
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_videoFileEntry.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this video file entry.
	*
	* @return the modified date of this video file entry
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _videoFileEntry.getModifiedDate();
	}

	/**
	* Sets the modified date of this video file entry.
	*
	* @param modifiedDate the modified date of this video file entry
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_videoFileEntry.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the file entry ID of this video file entry.
	*
	* @return the file entry ID of this video file entry
	*/
	@Override
	public long getFileEntryId() {
		return _videoFileEntry.getFileEntryId();
	}

	/**
	* Sets the file entry ID of this video file entry.
	*
	* @param fileEntryId the file entry ID of this video file entry
	*/
	@Override
	public void setFileEntryId(long fileEntryId) {
		_videoFileEntry.setFileEntryId(fileEntryId);
	}

	/**
	* Returns the file version ID of this video file entry.
	*
	* @return the file version ID of this video file entry
	*/
	@Override
	public long getFileVersionId() {
		return _videoFileEntry.getFileVersionId();
	}

	/**
	* Sets the file version ID of this video file entry.
	*
	* @param fileVersionId the file version ID of this video file entry
	*/
	@Override
	public void setFileVersionId(long fileVersionId) {
		_videoFileEntry.setFileVersionId(fileVersionId);
	}

	/**
	* Returns the folder ID of this video file entry.
	*
	* @return the folder ID of this video file entry
	*/
	@Override
	public long getFolderId() {
		return _videoFileEntry.getFolderId();
	}

	/**
	* Sets the folder ID of this video file entry.
	*
	* @param folderId the folder ID of this video file entry
	*/
	@Override
	public void setFolderId(long folderId) {
		_videoFileEntry.setFolderId(folderId);
	}

	/**
	* Returns the job ID of this video file entry.
	*
	* @return the job ID of this video file entry
	*/
	@Override
	public java.lang.String getJobId() {
		return _videoFileEntry.getJobId();
	}

	/**
	* Sets the job ID of this video file entry.
	*
	* @param jobId the job ID of this video file entry
	*/
	@Override
	public void setJobId(java.lang.String jobId) {
		_videoFileEntry.setJobId(jobId);
	}

	/**
	* Returns the job response of this video file entry.
	*
	* @return the job response of this video file entry
	*/
	@Override
	public java.lang.String getJobResponse() {
		return _videoFileEntry.getJobResponse();
	}

	/**
	* Sets the job response of this video file entry.
	*
	* @param jobResponse the job response of this video file entry
	*/
	@Override
	public void setJobResponse(java.lang.String jobResponse) {
		_videoFileEntry.setJobResponse(jobResponse);
	}

	/**
	* Returns the status of this video file entry.
	*
	* @return the status of this video file entry
	*/
	@Override
	public int getStatus() {
		return _videoFileEntry.getStatus();
	}

	/**
	* Sets the status of this video file entry.
	*
	* @param status the status of this video file entry
	*/
	@Override
	public void setStatus(int status) {
		_videoFileEntry.setStatus(status);
	}

	@Override
	public boolean isNew() {
		return _videoFileEntry.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_videoFileEntry.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _videoFileEntry.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_videoFileEntry.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _videoFileEntry.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _videoFileEntry.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_videoFileEntry.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _videoFileEntry.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_videoFileEntry.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_videoFileEntry.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_videoFileEntry.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new VideoFileEntryWrapper((VideoFileEntry)_videoFileEntry.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry) {
		return _videoFileEntry.compareTo(videoFileEntry);
	}

	@Override
	public int hashCode() {
		return _videoFileEntry.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.video.model.VideoFileEntry> toCacheModel() {
		return _videoFileEntry.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry toEscapedModel() {
		return new VideoFileEntryWrapper(_videoFileEntry.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry toUnescapedModel() {
		return new VideoFileEntryWrapper(_videoFileEntry.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _videoFileEntry.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _videoFileEntry.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_videoFileEntry.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoFileEntryWrapper)) {
			return false;
		}

		VideoFileEntryWrapper videoFileEntryWrapper = (VideoFileEntryWrapper)obj;

		if (Validator.equals(_videoFileEntry,
					videoFileEntryWrapper._videoFileEntry)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public VideoFileEntry getWrappedVideoFileEntry() {
		return _videoFileEntry;
	}

	@Override
	public VideoFileEntry getWrappedModel() {
		return _videoFileEntry;
	}

	@Override
	public void resetOriginalValues() {
		_videoFileEntry.resetOriginalValues();
	}

	private VideoFileEntry _videoFileEntry;
}