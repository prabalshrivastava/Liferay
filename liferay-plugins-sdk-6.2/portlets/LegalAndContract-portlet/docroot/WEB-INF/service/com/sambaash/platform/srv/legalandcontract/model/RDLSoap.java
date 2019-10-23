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

package com.sambaash.platform.srv.legalandcontract.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author nareshchebolu
 * @generated
 */
public class RDLSoap implements Serializable {
	public static RDLSoap toSoapModel(RDL model) {
		RDLSoap soapModel = new RDLSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpRdlId(model.getSpRdlId());
		soapModel.setSpLitigationId(model.getSpLitigationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setResponseDeadline(model.getResponseDeadline());
		soapModel.setClaimsRemarks(model.getClaimsRemarks());
		soapModel.setAlertBefore(model.getAlertBefore());

		return soapModel;
	}

	public static RDLSoap[] toSoapModels(RDL[] models) {
		RDLSoap[] soapModels = new RDLSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RDLSoap[][] toSoapModels(RDL[][] models) {
		RDLSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RDLSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RDLSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RDLSoap[] toSoapModels(List<RDL> models) {
		List<RDLSoap> soapModels = new ArrayList<RDLSoap>(models.size());

		for (RDL model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RDLSoap[soapModels.size()]);
	}

	public RDLSoap() {
	}

	public long getPrimaryKey() {
		return _spRdlId;
	}

	public void setPrimaryKey(long pk) {
		setSpRdlId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getSpRdlId() {
		return _spRdlId;
	}

	public void setSpRdlId(long spRdlId) {
		_spRdlId = spRdlId;
	}

	public long getSpLitigationId() {
		return _spLitigationId;
	}

	public void setSpLitigationId(long spLitigationId) {
		_spLitigationId = spLitigationId;
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

	public Date getResponseDeadline() {
		return _responseDeadline;
	}

	public void setResponseDeadline(Date responseDeadline) {
		_responseDeadline = responseDeadline;
	}

	public String getClaimsRemarks() {
		return _claimsRemarks;
	}

	public void setClaimsRemarks(String claimsRemarks) {
		_claimsRemarks = claimsRemarks;
	}

	public long getAlertBefore() {
		return _alertBefore;
	}

	public void setAlertBefore(long alertBefore) {
		_alertBefore = alertBefore;
	}

	private String _uuid;
	private long _spRdlId;
	private long _spLitigationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private Date _responseDeadline;
	private String _claimsRemarks;
	private long _alertBefore;
}