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
 * The base model interface for the GUUploadLog service. Represents a row in the &quot;SPGUUploadLog&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogImpl}.
 * </p>
 *
 * @author nareshchebolu
 * @see GUUploadLog
 * @see com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogImpl
 * @see com.sambaash.platform.srv.genericuploader.model.impl.GUUploadLogModelImpl
 * @generated
 */
public interface GUUploadLogModel extends BaseModel<GUUploadLog>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a g u upload log model instance should use the {@link GUUploadLog} interface instead.
	 */

	/**
	 * Returns the primary key of this g u upload log.
	 *
	 * @return the primary key of this g u upload log
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this g u upload log.
	 *
	 * @param primaryKey the primary key of this g u upload log
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the s p g u upload log ID of this g u upload log.
	 *
	 * @return the s p g u upload log ID of this g u upload log
	 */
	public long getSPGUUploadLogId();

	/**
	 * Sets the s p g u upload log ID of this g u upload log.
	 *
	 * @param SPGUUploadLogId the s p g u upload log ID of this g u upload log
	 */
	public void setSPGUUploadLogId(long SPGUUploadLogId);

	/**
	 * Returns the group ID of this g u upload log.
	 *
	 * @return the group ID of this g u upload log
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this g u upload log.
	 *
	 * @param groupId the group ID of this g u upload log
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this g u upload log.
	 *
	 * @return the company ID of this g u upload log
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this g u upload log.
	 *
	 * @param companyId the company ID of this g u upload log
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this g u upload log.
	 *
	 * @return the user ID of this g u upload log
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this g u upload log.
	 *
	 * @param userId the user ID of this g u upload log
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this g u upload log.
	 *
	 * @return the user uuid of this g u upload log
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this g u upload log.
	 *
	 * @param userUuid the user uuid of this g u upload log
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this g u upload log.
	 *
	 * @return the user name of this g u upload log
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this g u upload log.
	 *
	 * @param userName the user name of this g u upload log
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this g u upload log.
	 *
	 * @return the create date of this g u upload log
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this g u upload log.
	 *
	 * @param createDate the create date of this g u upload log
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this g u upload log.
	 *
	 * @return the modified date of this g u upload log
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this g u upload log.
	 *
	 * @param modifiedDate the modified date of this g u upload log
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the success count of this g u upload log.
	 *
	 * @return the success count of this g u upload log
	 */
	public int getSuccessCount();

	/**
	 * Sets the success count of this g u upload log.
	 *
	 * @param successCount the success count of this g u upload log
	 */
	public void setSuccessCount(int successCount);

	/**
	 * Returns the error count of this g u upload log.
	 *
	 * @return the error count of this g u upload log
	 */
	public int getErrorCount();

	/**
	 * Sets the error count of this g u upload log.
	 *
	 * @param errorCount the error count of this g u upload log
	 */
	public void setErrorCount(int errorCount);

	/**
	 * Returns the start time of this g u upload log.
	 *
	 * @return the start time of this g u upload log
	 */
	public Date getStartTime();

	/**
	 * Sets the start time of this g u upload log.
	 *
	 * @param startTime the start time of this g u upload log
	 */
	public void setStartTime(Date startTime);

	/**
	 * Returns the end time of this g u upload log.
	 *
	 * @return the end time of this g u upload log
	 */
	public Date getEndTime();

	/**
	 * Sets the end time of this g u upload log.
	 *
	 * @param endTime the end time of this g u upload log
	 */
	public void setEndTime(Date endTime);

	/**
	 * Returns the uploaded file entry ID of this g u upload log.
	 *
	 * @return the uploaded file entry ID of this g u upload log
	 */
	public long getUploadedFileEntryId();

	/**
	 * Sets the uploaded file entry ID of this g u upload log.
	 *
	 * @param uploadedFileEntryId the uploaded file entry ID of this g u upload log
	 */
	public void setUploadedFileEntryId(long uploadedFileEntryId);

	/**
	 * Returns the error file entry ID of this g u upload log.
	 *
	 * @return the error file entry ID of this g u upload log
	 */
	public long getErrorFileEntryId();

	/**
	 * Sets the error file entry ID of this g u upload log.
	 *
	 * @param errorFileEntryId the error file entry ID of this g u upload log
	 */
	public void setErrorFileEntryId(long errorFileEntryId);

	/**
	 * Returns the errors of this g u upload log.
	 *
	 * @return the errors of this g u upload log
	 */
	@AutoEscape
	public String getErrors();

	/**
	 * Sets the errors of this g u upload log.
	 *
	 * @param errors the errors of this g u upload log
	 */
	public void setErrors(String errors);

	/**
	 * Returns the msgs of this g u upload log.
	 *
	 * @return the msgs of this g u upload log
	 */
	@AutoEscape
	public String getMsgs();

	/**
	 * Sets the msgs of this g u upload log.
	 *
	 * @param msgs the msgs of this g u upload log
	 */
	public void setMsgs(String msgs);

	/**
	 * Returns the status of this g u upload log.
	 *
	 * @return the status of this g u upload log
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this g u upload log.
	 *
	 * @param status the status of this g u upload log
	 */
	public void setStatus(String status);

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
		com.sambaash.platform.srv.genericuploader.model.GUUploadLog guUploadLog);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.genericuploader.model.GUUploadLog> toCacheModel();

	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog toEscapedModel();

	@Override
	public com.sambaash.platform.srv.genericuploader.model.GUUploadLog toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}