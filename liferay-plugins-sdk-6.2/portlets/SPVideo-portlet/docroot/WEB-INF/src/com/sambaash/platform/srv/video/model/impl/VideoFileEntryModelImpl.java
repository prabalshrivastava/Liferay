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

package com.sambaash.platform.srv.video.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import com.sambaash.platform.srv.video.model.VideoFileEntry;
import com.sambaash.platform.srv.video.model.VideoFileEntryModel;

import java.io.Serializable;

import java.sql.Types;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * The base model implementation for the VideoFileEntry service. Represents a row in the &quot;SPVideoFileEntry&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link com.sambaash.platform.srv.video.model.VideoFileEntryModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link VideoFileEntryImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see VideoFileEntryImpl
 * @see com.sambaash.platform.srv.video.model.VideoFileEntry
 * @see com.sambaash.platform.srv.video.model.VideoFileEntryModel
 * @generated
 */
public class VideoFileEntryModelImpl extends BaseModelImpl<VideoFileEntry>
	implements VideoFileEntryModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a video file entry model instance should use the {@link com.sambaash.platform.srv.video.model.VideoFileEntry} interface instead.
	 */
	public static final String TABLE_NAME = "SPVideoFileEntry";
	public static final Object[][] TABLE_COLUMNS = {
			{ "spVideoFileEntryId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "fileEntryId", Types.BIGINT },
			{ "fileVersionId", Types.BIGINT },
			{ "folderId", Types.BIGINT },
			{ "jobId", Types.VARCHAR },
			{ "jobResponse", Types.VARCHAR },
			{ "status", Types.INTEGER }
		};
	public static final String TABLE_SQL_CREATE = "create table SPVideoFileEntry (spVideoFileEntryId BIGINT(20) not null primary key,groupId BIGINT(20),companyId BIGINT(20),userId BIGINT(20),userName VARCHAR(75) null,createDate DATETIME null,modifiedDate DATETIME null,fileEntryId BIGINT(20),fileVersionId BIGINT(20),folderId BIGINT(20),jobId VARCHAR(75) null,jobResponse LONGTEXT null,status INTEGER)";
	public static final String TABLE_SQL_DROP = "drop table SPVideoFileEntry";
	public static final String ORDER_BY_JPQL = " ORDER BY videoFileEntry.spVideoFileEntryId ASC";
	public static final String ORDER_BY_SQL = " ORDER BY SPVideoFileEntry.spVideoFileEntryId ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.com.sambaash.platform.srv.video.model.VideoFileEntry"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.com.sambaash.platform.srv.video.model.VideoFileEntry"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.com.sambaash.platform.srv.video.model.VideoFileEntry"),
			true);
	public static long FILEENTRYID_COLUMN_BITMASK = 1L;
	public static long FILEVERSIONID_COLUMN_BITMASK = 2L;
	public static long SPVIDEOFILEENTRYID_COLUMN_BITMASK = 4L;
	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.com.sambaash.platform.srv.video.model.VideoFileEntry"));

	public VideoFileEntryModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _spVideoFileEntryId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpVideoFileEntryId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spVideoFileEntryId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpVideoFileEntryId() {
		return _spVideoFileEntryId;
	}

	@Override
	public void setSpVideoFileEntryId(long spVideoFileEntryId) {
		_columnBitmask = -1L;

		_spVideoFileEntryId = spVideoFileEntryId;
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_columnBitmask |= FILEENTRYID_COLUMN_BITMASK;

		if (!_setOriginalFileEntryId) {
			_setOriginalFileEntryId = true;

			_originalFileEntryId = _fileEntryId;
		}

		_fileEntryId = fileEntryId;
	}

	public long getOriginalFileEntryId() {
		return _originalFileEntryId;
	}

	@Override
	public long getFileVersionId() {
		return _fileVersionId;
	}

	@Override
	public void setFileVersionId(long fileVersionId) {
		_columnBitmask |= FILEVERSIONID_COLUMN_BITMASK;

		if (!_setOriginalFileVersionId) {
			_setOriginalFileVersionId = true;

			_originalFileVersionId = _fileVersionId;
		}

		_fileVersionId = fileVersionId;
	}

	public long getOriginalFileVersionId() {
		return _originalFileVersionId;
	}

	@Override
	public long getFolderId() {
		return _folderId;
	}

	@Override
	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	@Override
	public String getJobId() {
		if (_jobId == null) {
			return StringPool.BLANK;
		}
		else {
			return _jobId;
		}
	}

	@Override
	public void setJobId(String jobId) {
		_jobId = jobId;
	}

	@Override
	public String getJobResponse() {
		if (_jobResponse == null) {
			return StringPool.BLANK;
		}
		else {
			return _jobResponse;
		}
	}

	@Override
	public void setJobResponse(String jobResponse) {
		_jobResponse = jobResponse;
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			VideoFileEntry.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public VideoFileEntry toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (VideoFileEntry)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		VideoFileEntryImpl videoFileEntryImpl = new VideoFileEntryImpl();

		videoFileEntryImpl.setSpVideoFileEntryId(getSpVideoFileEntryId());
		videoFileEntryImpl.setGroupId(getGroupId());
		videoFileEntryImpl.setCompanyId(getCompanyId());
		videoFileEntryImpl.setUserId(getUserId());
		videoFileEntryImpl.setUserName(getUserName());
		videoFileEntryImpl.setCreateDate(getCreateDate());
		videoFileEntryImpl.setModifiedDate(getModifiedDate());
		videoFileEntryImpl.setFileEntryId(getFileEntryId());
		videoFileEntryImpl.setFileVersionId(getFileVersionId());
		videoFileEntryImpl.setFolderId(getFolderId());
		videoFileEntryImpl.setJobId(getJobId());
		videoFileEntryImpl.setJobResponse(getJobResponse());
		videoFileEntryImpl.setStatus(getStatus());

		videoFileEntryImpl.resetOriginalValues();

		return videoFileEntryImpl;
	}

	@Override
	public int compareTo(VideoFileEntry videoFileEntry) {
		int value = 0;

		if (getSpVideoFileEntryId() < videoFileEntry.getSpVideoFileEntryId()) {
			value = -1;
		}
		else if (getSpVideoFileEntryId() > videoFileEntry.getSpVideoFileEntryId()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof VideoFileEntry)) {
			return false;
		}

		VideoFileEntry videoFileEntry = (VideoFileEntry)obj;

		long primaryKey = videoFileEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		VideoFileEntryModelImpl videoFileEntryModelImpl = this;

		videoFileEntryModelImpl._originalFileEntryId = videoFileEntryModelImpl._fileEntryId;

		videoFileEntryModelImpl._setOriginalFileEntryId = false;

		videoFileEntryModelImpl._originalFileVersionId = videoFileEntryModelImpl._fileVersionId;

		videoFileEntryModelImpl._setOriginalFileVersionId = false;

		videoFileEntryModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<VideoFileEntry> toCacheModel() {
		VideoFileEntryCacheModel videoFileEntryCacheModel = new VideoFileEntryCacheModel();

		videoFileEntryCacheModel.spVideoFileEntryId = getSpVideoFileEntryId();

		videoFileEntryCacheModel.groupId = getGroupId();

		videoFileEntryCacheModel.companyId = getCompanyId();

		videoFileEntryCacheModel.userId = getUserId();

		videoFileEntryCacheModel.userName = getUserName();

		String userName = videoFileEntryCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			videoFileEntryCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			videoFileEntryCacheModel.createDate = createDate.getTime();
		}
		else {
			videoFileEntryCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			videoFileEntryCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			videoFileEntryCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		videoFileEntryCacheModel.fileEntryId = getFileEntryId();

		videoFileEntryCacheModel.fileVersionId = getFileVersionId();

		videoFileEntryCacheModel.folderId = getFolderId();

		videoFileEntryCacheModel.jobId = getJobId();

		String jobId = videoFileEntryCacheModel.jobId;

		if ((jobId != null) && (jobId.length() == 0)) {
			videoFileEntryCacheModel.jobId = null;
		}

		videoFileEntryCacheModel.jobResponse = getJobResponse();

		String jobResponse = videoFileEntryCacheModel.jobResponse;

		if ((jobResponse != null) && (jobResponse.length() == 0)) {
			videoFileEntryCacheModel.jobResponse = null;
		}

		videoFileEntryCacheModel.status = getStatus();

		return videoFileEntryCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(27);

		sb.append("{spVideoFileEntryId=");
		sb.append(getSpVideoFileEntryId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", fileEntryId=");
		sb.append(getFileEntryId());
		sb.append(", fileVersionId=");
		sb.append(getFileVersionId());
		sb.append(", folderId=");
		sb.append(getFolderId());
		sb.append(", jobId=");
		sb.append(getJobId());
		sb.append(", jobResponse=");
		sb.append(getJobResponse());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.video.model.VideoFileEntry");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spVideoFileEntryId</column-name><column-value><![CDATA[");
		sb.append(getSpVideoFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileEntryId</column-name><column-value><![CDATA[");
		sb.append(getFileEntryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fileVersionId</column-name><column-value><![CDATA[");
		sb.append(getFileVersionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>folderId</column-name><column-value><![CDATA[");
		sb.append(getFolderId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobId</column-name><column-value><![CDATA[");
		sb.append(getJobId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>jobResponse</column-name><column-value><![CDATA[");
		sb.append(getJobResponse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = VideoFileEntry.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			VideoFileEntry.class
		};
	private long _spVideoFileEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _fileEntryId;
	private long _originalFileEntryId;
	private boolean _setOriginalFileEntryId;
	private long _fileVersionId;
	private long _originalFileVersionId;
	private boolean _setOriginalFileVersionId;
	private long _folderId;
	private String _jobId;
	private String _jobResponse;
	private int _status;
	private long _columnBitmask;
	private VideoFileEntry _escapedModel;
}