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

package com.sambaash.platform.srv.spsocialprofile.model;

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
public class ExamBodyUserSoap implements Serializable {
	public static ExamBodyUserSoap toSoapModel(ExamBodyUser model) {
		ExamBodyUserSoap soapModel = new ExamBodyUserSoap();

		soapModel.setExamBodyUserId(model.getExamBodyUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setExamBody(model.getExamBody());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static ExamBodyUserSoap[] toSoapModels(ExamBodyUser[] models) {
		ExamBodyUserSoap[] soapModels = new ExamBodyUserSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static ExamBodyUserSoap[][] toSoapModels(ExamBodyUser[][] models) {
		ExamBodyUserSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new ExamBodyUserSoap[models.length][models[0].length];
		}
		else {
			soapModels = new ExamBodyUserSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static ExamBodyUserSoap[] toSoapModels(List<ExamBodyUser> models) {
		List<ExamBodyUserSoap> soapModels = new ArrayList<ExamBodyUserSoap>(models.size());

		for (ExamBodyUser model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new ExamBodyUserSoap[soapModels.size()]);
	}

	public ExamBodyUserSoap() {
	}

	public long getPrimaryKey() {
		return _examBodyUserId;
	}

	public void setPrimaryKey(long pk) {
		setExamBodyUserId(pk);
	}

	public long getExamBodyUserId() {
		return _examBodyUserId;
	}

	public void setExamBodyUserId(long examBodyUserId) {
		_examBodyUserId = examBodyUserId;
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

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getExamBody() {
		return _examBody;
	}

	public void setExamBody(String examBody) {
		_examBody = examBody;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _examBodyUserId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _emailAddress;
	private String _examBody;
	private boolean _active;
}