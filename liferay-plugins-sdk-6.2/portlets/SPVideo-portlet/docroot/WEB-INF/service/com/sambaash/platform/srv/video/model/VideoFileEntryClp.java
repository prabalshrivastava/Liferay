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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.video.service.ClpSerializer;
import com.sambaash.platform.srv.video.service.VideoFileEntryLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class VideoFileEntryClp extends BaseModelImpl<VideoFileEntry>
	implements VideoFileEntry {
	public VideoFileEntryClp() {
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
		_spVideoFileEntryId = spVideoFileEntryId;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setSpVideoFileEntryId",
						long.class);

				method.invoke(_videoFileEntryRemoteModel, spVideoFileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_videoFileEntryRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_videoFileEntryRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_videoFileEntryRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
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
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_videoFileEntryRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_videoFileEntryRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_videoFileEntryRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileEntryId() {
		return _fileEntryId;
	}

	@Override
	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setFileEntryId", long.class);

				method.invoke(_videoFileEntryRemoteModel, fileEntryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFileVersionId() {
		return _fileVersionId;
	}

	@Override
	public void setFileVersionId(long fileVersionId) {
		_fileVersionId = fileVersionId;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setFileVersionId", long.class);

				method.invoke(_videoFileEntryRemoteModel, fileVersionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getFolderId() {
		return _folderId;
	}

	@Override
	public void setFolderId(long folderId) {
		_folderId = folderId;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setFolderId", long.class);

				method.invoke(_videoFileEntryRemoteModel, folderId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobId() {
		return _jobId;
	}

	@Override
	public void setJobId(String jobId) {
		_jobId = jobId;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setJobId", String.class);

				method.invoke(_videoFileEntryRemoteModel, jobId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getJobResponse() {
		return _jobResponse;
	}

	@Override
	public void setJobResponse(String jobResponse) {
		_jobResponse = jobResponse;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setJobResponse", String.class);

				method.invoke(_videoFileEntryRemoteModel, jobResponse);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_videoFileEntryRemoteModel != null) {
			try {
				Class<?> clazz = _videoFileEntryRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_videoFileEntryRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getVideoFileEntryRemoteModel() {
		return _videoFileEntryRemoteModel;
	}

	public void setVideoFileEntryRemoteModel(
		BaseModel<?> videoFileEntryRemoteModel) {
		_videoFileEntryRemoteModel = videoFileEntryRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _videoFileEntryRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_videoFileEntryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			VideoFileEntryLocalServiceUtil.addVideoFileEntry(this);
		}
		else {
			VideoFileEntryLocalServiceUtil.updateVideoFileEntry(this);
		}
	}

	@Override
	public VideoFileEntry toEscapedModel() {
		return (VideoFileEntry)ProxyUtil.newProxyInstance(VideoFileEntry.class.getClassLoader(),
			new Class[] { VideoFileEntry.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		VideoFileEntryClp clone = new VideoFileEntryClp();

		clone.setSpVideoFileEntryId(getSpVideoFileEntryId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setFileEntryId(getFileEntryId());
		clone.setFileVersionId(getFileVersionId());
		clone.setFolderId(getFolderId());
		clone.setJobId(getJobId());
		clone.setJobResponse(getJobResponse());
		clone.setStatus(getStatus());

		return clone;
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

		if (!(obj instanceof VideoFileEntryClp)) {
			return false;
		}

		VideoFileEntryClp videoFileEntry = (VideoFileEntryClp)obj;

		long primaryKey = videoFileEntry.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
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

	private long _spVideoFileEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _fileEntryId;
	private long _fileVersionId;
	private long _folderId;
	private String _jobId;
	private String _jobResponse;
	private int _status;
	private BaseModel<?> _videoFileEntryRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.video.service.ClpSerializer.class;
}