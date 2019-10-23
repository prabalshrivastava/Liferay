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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.genericuploader.service.http.GUUploadLogServiceSoap}.
 *
 * @author nareshchebolu
 * @see com.sambaash.platform.srv.genericuploader.service.http.GUUploadLogServiceSoap
 * @generated
 */
public class GUUploadLogSoap implements Serializable {
	public static GUUploadLogSoap toSoapModel(GUUploadLog model) {
		GUUploadLogSoap soapModel = new GUUploadLogSoap();

		soapModel.setSPGUUploadLogId(model.getSPGUUploadLogId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSuccessCount(model.getSuccessCount());
		soapModel.setErrorCount(model.getErrorCount());
		soapModel.setStartTime(model.getStartTime());
		soapModel.setEndTime(model.getEndTime());
		soapModel.setUploadedFileEntryId(model.getUploadedFileEntryId());
		soapModel.setErrorFileEntryId(model.getErrorFileEntryId());
		soapModel.setErrors(model.getErrors());
		soapModel.setMsgs(model.getMsgs());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static GUUploadLogSoap[] toSoapModels(GUUploadLog[] models) {
		GUUploadLogSoap[] soapModels = new GUUploadLogSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static GUUploadLogSoap[][] toSoapModels(GUUploadLog[][] models) {
		GUUploadLogSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new GUUploadLogSoap[models.length][models[0].length];
		}
		else {
			soapModels = new GUUploadLogSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static GUUploadLogSoap[] toSoapModels(List<GUUploadLog> models) {
		List<GUUploadLogSoap> soapModels = new ArrayList<GUUploadLogSoap>(models.size());

		for (GUUploadLog model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new GUUploadLogSoap[soapModels.size()]);
	}

	public GUUploadLogSoap() {
	}

	public long getPrimaryKey() {
		return _SPGUUploadLogId;
	}

	public void setPrimaryKey(long pk) {
		setSPGUUploadLogId(pk);
	}

	public long getSPGUUploadLogId() {
		return _SPGUUploadLogId;
	}

	public void setSPGUUploadLogId(long SPGUUploadLogId) {
		_SPGUUploadLogId = SPGUUploadLogId;
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

	public int getSuccessCount() {
		return _successCount;
	}

	public void setSuccessCount(int successCount) {
		_successCount = successCount;
	}

	public int getErrorCount() {
		return _errorCount;
	}

	public void setErrorCount(int errorCount) {
		_errorCount = errorCount;
	}

	public Date getStartTime() {
		return _startTime;
	}

	public void setStartTime(Date startTime) {
		_startTime = startTime;
	}

	public Date getEndTime() {
		return _endTime;
	}

	public void setEndTime(Date endTime) {
		_endTime = endTime;
	}

	public long getUploadedFileEntryId() {
		return _uploadedFileEntryId;
	}

	public void setUploadedFileEntryId(long uploadedFileEntryId) {
		_uploadedFileEntryId = uploadedFileEntryId;
	}

	public long getErrorFileEntryId() {
		return _errorFileEntryId;
	}

	public void setErrorFileEntryId(long errorFileEntryId) {
		_errorFileEntryId = errorFileEntryId;
	}

	public String getErrors() {
		return _errors;
	}

	public void setErrors(String errors) {
		_errors = errors;
	}

	public String getMsgs() {
		return _msgs;
	}

	public void setMsgs(String msgs) {
		_msgs = msgs;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	private long _SPGUUploadLogId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _successCount;
	private int _errorCount;
	private Date _startTime;
	private Date _endTime;
	private long _uploadedFileEntryId;
	private long _errorFileEntryId;
	private String _errors;
	private String _msgs;
	private String _status;
}