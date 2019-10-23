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

package com.sambaash.platform.srv.feedback.model;

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
public class SPFeedbackSoap implements Serializable {
	public static SPFeedbackSoap toSoapModel(SPFeedback model) {
		SPFeedbackSoap soapModel = new SPFeedbackSoap();

		soapModel.setSpFeedbackId(model.getSpFeedbackId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setType(model.getType());
		soapModel.setDescription(model.getDescription());

		return soapModel;
	}

	public static SPFeedbackSoap[] toSoapModels(SPFeedback[] models) {
		SPFeedbackSoap[] soapModels = new SPFeedbackSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPFeedbackSoap[][] toSoapModels(SPFeedback[][] models) {
		SPFeedbackSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPFeedbackSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPFeedbackSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPFeedbackSoap[] toSoapModels(List<SPFeedback> models) {
		List<SPFeedbackSoap> soapModels = new ArrayList<SPFeedbackSoap>(models.size());

		for (SPFeedback model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPFeedbackSoap[soapModels.size()]);
	}

	public SPFeedbackSoap() {
	}

	public long getPrimaryKey() {
		return _spFeedbackId;
	}

	public void setPrimaryKey(long pk) {
		setSpFeedbackId(pk);
	}

	public long getSpFeedbackId() {
		return _spFeedbackId;
	}

	public void setSpFeedbackId(long spFeedbackId) {
		_spFeedbackId = spFeedbackId;
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

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	private long _spFeedbackId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _type;
	private String _description;
}