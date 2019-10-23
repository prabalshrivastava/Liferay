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

package com.sambaash.platform.srv.enrolment.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Baxture
 * @generated
 */
public class EnrollBatchUploadSoap implements Serializable {
	public static EnrollBatchUploadSoap toSoapModel(EnrollBatchUpload model) {
		EnrollBatchUploadSoap soapModel = new EnrollBatchUploadSoap();

		soapModel.setUploadStatId(model.getUploadStatId());
		soapModel.setUploadTransactId(model.getUploadTransactId());
		soapModel.setErrorField(model.getErrorField());
		soapModel.setErrorReason(model.getErrorReason());
		soapModel.setUploadedRecId(model.getUploadedRecId());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EnrollBatchUploadSoap[] toSoapModels(
		EnrollBatchUpload[] models) {
		EnrollBatchUploadSoap[] soapModels = new EnrollBatchUploadSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnrollBatchUploadSoap[][] toSoapModels(
		EnrollBatchUpload[][] models) {
		EnrollBatchUploadSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnrollBatchUploadSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnrollBatchUploadSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnrollBatchUploadSoap[] toSoapModels(
		List<EnrollBatchUpload> models) {
		List<EnrollBatchUploadSoap> soapModels = new ArrayList<EnrollBatchUploadSoap>(models.size());

		for (EnrollBatchUpload model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnrollBatchUploadSoap[soapModels.size()]);
	}

	public EnrollBatchUploadSoap() {
	}

	public long getPrimaryKey() {
		return _uploadStatId;
	}

	public void setPrimaryKey(long pk) {
		setUploadStatId(pk);
	}

	public long getUploadStatId() {
		return _uploadStatId;
	}

	public void setUploadStatId(long uploadStatId) {
		_uploadStatId = uploadStatId;
	}

	public String getUploadTransactId() {
		return _uploadTransactId;
	}

	public void setUploadTransactId(String uploadTransactId) {
		_uploadTransactId = uploadTransactId;
	}

	public String getErrorField() {
		return _errorField;
	}

	public void setErrorField(String errorField) {
		_errorField = errorField;
	}

	public String getErrorReason() {
		return _errorReason;
	}

	public void setErrorReason(String errorReason) {
		_errorReason = errorReason;
	}

	public long getUploadedRecId() {
		return _uploadedRecId;
	}

	public void setUploadedRecId(long uploadedRecId) {
		_uploadedRecId = uploadedRecId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	private long _uploadStatId;
	private String _uploadTransactId;
	private String _errorField;
	private String _errorReason;
	private long _uploadedRecId;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}