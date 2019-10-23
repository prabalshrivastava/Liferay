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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class VideoFileEntrySoap implements Serializable {
	public static VideoFileEntrySoap toSoapModel(VideoFileEntry model) {
		VideoFileEntrySoap soapModel = new VideoFileEntrySoap();

		soapModel.setSpVideoFileEntryId(model.getSpVideoFileEntryId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setFileEntryId(model.getFileEntryId());
		soapModel.setFileVersionId(model.getFileVersionId());
		soapModel.setFolderId(model.getFolderId());
		soapModel.setJobId(model.getJobId());
		soapModel.setJobResponse(model.getJobResponse());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static VideoFileEntrySoap[] toSoapModels(VideoFileEntry[] models) {
		VideoFileEntrySoap[] soapModels = new VideoFileEntrySoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static VideoFileEntrySoap[][] toSoapModels(VideoFileEntry[][] models) {
		VideoFileEntrySoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new VideoFileEntrySoap[models.length][models[0].length];
		}
		else {
			soapModels = new VideoFileEntrySoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static VideoFileEntrySoap[] toSoapModels(List<VideoFileEntry> models) {
		List<VideoFileEntrySoap> soapModels = new ArrayList<VideoFileEntrySoap>(models.size());

		for (VideoFileEntry model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new VideoFileEntrySoap[soapModels.size()]);
	}

	public VideoFileEntrySoap() {
	}

	public long getPrimaryKey() {
		return _spVideoFileEntryId;
	}

	public void setPrimaryKey(long pk) {
		setSpVideoFileEntryId(pk);
	}

	public long getSpVideoFileEntryId() {
		return _spVideoFileEntryId;
	}

	public void setSpVideoFileEntryId(long spVideoFileEntryId) {
		_spVideoFileEntryId = spVideoFileEntryId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public long getFileEntryId() {
		return _fileEntryId;
	}

	public void setFileEntryId(long fileEntryId) {
		_fileEntryId = fileEntryId;
	}

	public long getFileVersionId() {
		return _fileVersionId;
	}

	public void setFileVersionId(long fileVersionId) {
		_fileVersionId = fileVersionId;
	}

	public long getFolderId() {
		return _folderId;
	}

	public void setFolderId(long folderId) {
		_folderId = folderId;
	}

	public String getJobId() {
		return _jobId;
	}

	public void setJobId(String jobId) {
		_jobId = jobId;
	}

	public String getJobResponse() {
		return _jobResponse;
	}

	public void setJobResponse(String jobResponse) {
		_jobResponse = jobResponse;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _spVideoFileEntryId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _fileEntryId;
	private long _fileVersionId;
	private long _folderId;
	private String _jobId;
	private String _jobResponse;
	private int _status;
}