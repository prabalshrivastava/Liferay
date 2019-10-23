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
public class OutcomeSoap implements Serializable {
	public static OutcomeSoap toSoapModel(Outcome model) {
		OutcomeSoap soapModel = new OutcomeSoap();

		soapModel.setSpOutcomeId(model.getSpOutcomeId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setOutcomeCode(model.getOutcomeCode());
		soapModel.setOutcomeDesc(model.getOutcomeDesc());
		soapModel.setOutcomeType(model.getOutcomeType());
		soapModel.setOutcomeFolderId(model.getOutcomeFolderId());
		soapModel.setSpCompetencyUnitId(model.getSpCompetencyUnitId());

		return soapModel;
	}

	public static OutcomeSoap[] toSoapModels(Outcome[] models) {
		OutcomeSoap[] soapModels = new OutcomeSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OutcomeSoap[][] toSoapModels(Outcome[][] models) {
		OutcomeSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OutcomeSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OutcomeSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OutcomeSoap[] toSoapModels(List<Outcome> models) {
		List<OutcomeSoap> soapModels = new ArrayList<OutcomeSoap>(models.size());

		for (Outcome model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OutcomeSoap[soapModels.size()]);
	}

	public OutcomeSoap() {
	}

	public long getPrimaryKey() {
		return _spOutcomeId;
	}

	public void setPrimaryKey(long pk) {
		setSpOutcomeId(pk);
	}

	public long getSpOutcomeId() {
		return _spOutcomeId;
	}

	public void setSpOutcomeId(long spOutcomeId) {
		_spOutcomeId = spOutcomeId;
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

	public long getCountryId() {
		return _countryId;
	}

	public void setCountryId(long countryId) {
		_countryId = countryId;
	}

	public String getOutcomeCode() {
		return _outcomeCode;
	}

	public void setOutcomeCode(String outcomeCode) {
		_outcomeCode = outcomeCode;
	}

	public String getOutcomeDesc() {
		return _outcomeDesc;
	}

	public void setOutcomeDesc(String outcomeDesc) {
		_outcomeDesc = outcomeDesc;
	}

	public long getOutcomeType() {
		return _outcomeType;
	}

	public void setOutcomeType(long outcomeType) {
		_outcomeType = outcomeType;
	}

	public long getOutcomeFolderId() {
		return _outcomeFolderId;
	}

	public void setOutcomeFolderId(long outcomeFolderId) {
		_outcomeFolderId = outcomeFolderId;
	}

	public long getSpCompetencyUnitId() {
		return _spCompetencyUnitId;
	}

	public void setSpCompetencyUnitId(long spCompetencyUnitId) {
		_spCompetencyUnitId = spCompetencyUnitId;
	}

	private long _spOutcomeId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _countryId;
	private String _outcomeCode;
	private String _outcomeDesc;
	private long _outcomeType;
	private long _outcomeFolderId;
	private long _spCompetencyUnitId;
}