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
 * The base model interface for the VideoFileEntry service. Represents a row in the &quot;SPVideoFileEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.video.model.impl.VideoFileEntryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.video.model.impl.VideoFileEntryImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see VideoFileEntry
 * @see com.sambaash.platform.srv.video.model.impl.VideoFileEntryImpl
 * @see com.sambaash.platform.srv.video.model.impl.VideoFileEntryModelImpl
 * @generated
 */
public interface VideoFileEntryModel extends BaseModel<VideoFileEntry>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a video file entry model instance should use the {@link VideoFileEntry} interface instead.
	 */

	/**
	 * Returns the primary key of this video file entry.
	 *
	 * @return the primary key of this video file entry
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this video file entry.
	 *
	 * @param primaryKey the primary key of this video file entry
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp video file entry ID of this video file entry.
	 *
	 * @return the sp video file entry ID of this video file entry
	 */
	public long getSpVideoFileEntryId();

	/**
	 * Sets the sp video file entry ID of this video file entry.
	 *
	 * @param spVideoFileEntryId the sp video file entry ID of this video file entry
	 */
	public void setSpVideoFileEntryId(long spVideoFileEntryId);

	/**
	 * Returns the group ID of this video file entry.
	 *
	 * @return the group ID of this video file entry
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this video file entry.
	 *
	 * @param groupId the group ID of this video file entry
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this video file entry.
	 *
	 * @return the company ID of this video file entry
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this video file entry.
	 *
	 * @param companyId the company ID of this video file entry
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this video file entry.
	 *
	 * @return the user ID of this video file entry
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this video file entry.
	 *
	 * @param userId the user ID of this video file entry
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this video file entry.
	 *
	 * @return the user uuid of this video file entry
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this video file entry.
	 *
	 * @param userUuid the user uuid of this video file entry
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this video file entry.
	 *
	 * @return the user name of this video file entry
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this video file entry.
	 *
	 * @param userName the user name of this video file entry
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this video file entry.
	 *
	 * @return the create date of this video file entry
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this video file entry.
	 *
	 * @param createDate the create date of this video file entry
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this video file entry.
	 *
	 * @return the modified date of this video file entry
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this video file entry.
	 *
	 * @param modifiedDate the modified date of this video file entry
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the file entry ID of this video file entry.
	 *
	 * @return the file entry ID of this video file entry
	 */
	public long getFileEntryId();

	/**
	 * Sets the file entry ID of this video file entry.
	 *
	 * @param fileEntryId the file entry ID of this video file entry
	 */
	public void setFileEntryId(long fileEntryId);

	/**
	 * Returns the file version ID of this video file entry.
	 *
	 * @return the file version ID of this video file entry
	 */
	public long getFileVersionId();

	/**
	 * Sets the file version ID of this video file entry.
	 *
	 * @param fileVersionId the file version ID of this video file entry
	 */
	public void setFileVersionId(long fileVersionId);

	/**
	 * Returns the folder ID of this video file entry.
	 *
	 * @return the folder ID of this video file entry
	 */
	public long getFolderId();

	/**
	 * Sets the folder ID of this video file entry.
	 *
	 * @param folderId the folder ID of this video file entry
	 */
	public void setFolderId(long folderId);

	/**
	 * Returns the job ID of this video file entry.
	 *
	 * @return the job ID of this video file entry
	 */
	@AutoEscape
	public String getJobId();

	/**
	 * Sets the job ID of this video file entry.
	 *
	 * @param jobId the job ID of this video file entry
	 */
	public void setJobId(String jobId);

	/**
	 * Returns the job response of this video file entry.
	 *
	 * @return the job response of this video file entry
	 */
	@AutoEscape
	public String getJobResponse();

	/**
	 * Sets the job response of this video file entry.
	 *
	 * @param jobResponse the job response of this video file entry
	 */
	public void setJobResponse(String jobResponse);

	/**
	 * Returns the status of this video file entry.
	 *
	 * @return the status of this video file entry
	 */
	public int getStatus();

	/**
	 * Sets the status of this video file entry.
	 *
	 * @param status the status of this video file entry
	 */
	public void setStatus(int status);

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
		com.sambaash.platform.srv.video.model.VideoFileEntry videoFileEntry);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.video.model.VideoFileEntry> toCacheModel();

	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry toEscapedModel();

	@Override
	public com.sambaash.platform.srv.video.model.VideoFileEntry toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}