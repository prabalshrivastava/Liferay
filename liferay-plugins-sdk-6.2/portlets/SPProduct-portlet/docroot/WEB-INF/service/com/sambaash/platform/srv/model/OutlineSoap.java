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

package com.sambaash.platform.srv.model;

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
public class OutlineSoap implements Serializable {
	public static OutlineSoap toSoapModel(Outline model) {
		OutlineSoap soapModel = new OutlineSoap();

		soapModel.setSpOutlineId(model.getSpOutlineId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setSpCompetencyUnitId(model.getSpCompetencyUnitId());
		soapModel.setOutlineType(model.getOutlineType());
		soapModel.setOutlineDesc(model.getOutlineDesc());

		return soapModel;
	}

	public static OutlineSoap[] toSoapModels(Outline[] models) {
		OutlineSoap[] soapModels = new OutlineSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OutlineSoap[][] toSoapModels(Outline[][] models) {
		OutlineSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OutlineSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OutlineSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OutlineSoap[] toSoapModels(List<Outline> models) {
		List<OutlineSoap> soapModels = new ArrayList<OutlineSoap>(models.size());

		for (Outline model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OutlineSoap[soapModels.size()]);
	}

	public OutlineSoap() {
	}

	public long getPrimaryKey() {
		return _spOutlineId;
	}

	public void setPrimaryKey(long pk) {
		setSpOutlineId(pk);
	}

	public long getSpOutlineId() {
		return _spOutlineId;
	}

	public void setSpOutlineId(long spOutlineId) {
		_spOutlineId = spOutlineId;
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

	public long getSpCompetencyUnitId() {
		return _spCompetencyUnitId;
	}

	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_spCompetencyUnitId = spCompetencyUnitId;
	}

	public long getOutlineType() {
		return _outlineType;
	}

	public void setOutlineType(long outlineType) {
		_outlineType = outlineType;
	}

	public String getOutlineDesc() {
		return _outlineDesc;
	}

	public void setOutlineDesc(String outlineDesc) {
		_outlineDesc = outlineDesc;
	}

	private long _spOutlineId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _spCompetencyUnitId;
	private long _outlineType;
	private String _outlineDesc;
}