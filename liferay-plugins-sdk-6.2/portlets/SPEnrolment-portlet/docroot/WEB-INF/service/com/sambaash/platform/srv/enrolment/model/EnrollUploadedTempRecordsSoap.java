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
public class EnrollUploadedTempRecordsSoap implements Serializable {
	public static EnrollUploadedTempRecordsSoap toSoapModel(
		EnrollUploadedTempRecords model) {
		EnrollUploadedTempRecordsSoap soapModel = new EnrollUploadedTempRecordsSoap();

		soapModel.setUploadedRecId(model.getUploadedRecId());
		soapModel.setUploadTransactId(model.getUploadTransactId());
		soapModel.setSprCode(model.getSprCode());
		soapModel.setTitle(model.getTitle());
		soapModel.setFullOfficialName(model.getFullOfficialName());
		soapModel.setGender(model.getGender());
		soapModel.setDateofBirth(model.getDateofBirth());
		soapModel.setEmail(model.getEmail());
		soapModel.setUserId(model.getUserId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());

		return soapModel;
	}

	public static EnrollUploadedTempRecordsSoap[] toSoapModels(
		EnrollUploadedTempRecords[] models) {
		EnrollUploadedTempRecordsSoap[] soapModels = new EnrollUploadedTempRecordsSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static EnrollUploadedTempRecordsSoap[][] toSoapModels(
		EnrollUploadedTempRecords[][] models) {
		EnrollUploadedTempRecordsSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new EnrollUploadedTempRecordsSoap[models.length][models[0].length];
		}
		else {
			soapModels = new EnrollUploadedTempRecordsSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static EnrollUploadedTempRecordsSoap[] toSoapModels(
		List<EnrollUploadedTempRecords> models) {
		List<EnrollUploadedTempRecordsSoap> soapModels = new ArrayList<EnrollUploadedTempRecordsSoap>(models.size());

		for (EnrollUploadedTempRecords model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new EnrollUploadedTempRecordsSoap[soapModels.size()]);
	}

	public EnrollUploadedTempRecordsSoap() {
	}

	public long getPrimaryKey() {
		return _uploadedRecId;
	}

	public void setPrimaryKey(long pk) {
		setUploadedRecId(pk);
	}

	public long getUploadedRecId() {
		return _uploadedRecId;
	}

	public void setUploadedRecId(long uploadedRecId) {
		_uploadedRecId = uploadedRecId;
	}

	public String getUploadTransactId() {
		return _uploadTransactId;
	}

	public void setUploadTransactId(String uploadTransactId) {
		_uploadTransactId = uploadTransactId;
	}

	public String getSprCode() {
		return _sprCode;
	}

	public void setSprCode(String sprCode) {
		_sprCode = sprCode;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getFullOfficialName() {
		return _fullOfficialName;
	}

	public void setFullOfficialName(String fullOfficialName) {
		_fullOfficialName = fullOfficialName;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getDateofBirth() {
		return _dateofBirth;
	}

	public void setDateofBirth(String dateofBirth) {
		_dateofBirth = dateofBirth;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
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

	private long _uploadedRecId;
	private String _uploadTransactId;
	private String _sprCode;
	private String _title;
	private String _fullOfficialName;
	private String _gender;
	private String _dateofBirth;
	private String _email;
	private long _userId;
	private Date _createDate;
	private Date _modifiedDate;
}