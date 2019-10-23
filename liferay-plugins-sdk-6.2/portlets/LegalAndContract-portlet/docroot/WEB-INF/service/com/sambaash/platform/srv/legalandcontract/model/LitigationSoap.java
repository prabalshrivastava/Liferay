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
public class LitigationSoap implements Serializable {
	public static LitigationSoap toSoapModel(Litigation model) {
		LitigationSoap soapModel = new LitigationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setSpLitigationId(model.getSpLitigationId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountry(model.getCountry());
		soapModel.setFiledBy(model.getFiledBy());
		soapModel.setFiledOn(model.getFiledOn());
		soapModel.setFiledAtCountry(model.getFiledAtCountry());
		soapModel.setClaimsRemarks(model.getClaimsRemarks());
		soapModel.setResponseDeadline(model.getResponseDeadline());
		soapModel.setActualResponseDate(model.getActualResponseDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setCustomField1(model.getCustomField1());
		soapModel.setCustomField2(model.getCustomField2());
		soapModel.setCustomField3(model.getCustomField3());
		soapModel.setCustomDate1(model.getCustomDate1());
		soapModel.setCustomDate2(model.getCustomDate2());
		soapModel.setCustomDate3(model.getCustomDate3());
		soapModel.setLegalConfRemarks(model.getLegalConfRemarks());
		soapModel.setVersion(model.getVersion());
		soapModel.setSpTrademarksId(model.getSpTrademarksId());
		soapModel.setRootSpLitigationId(model.getRootSpLitigationId());

		return soapModel;
	}

	public static LitigationSoap[] toSoapModels(Litigation[] models) {
		LitigationSoap[] soapModels = new LitigationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static LitigationSoap[][] toSoapModels(Litigation[][] models) {
		LitigationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new LitigationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new LitigationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static LitigationSoap[] toSoapModels(List<Litigation> models) {
		List<LitigationSoap> soapModels = new ArrayList<LitigationSoap>(models.size());

		for (Litigation model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new LitigationSoap[soapModels.size()]);
	}

	public LitigationSoap() {
	}

	public long getPrimaryKey() {
		return _spLitigationId;
	}

	public void setPrimaryKey(long pk) {
		setSpLitigationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
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

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getFiledBy() {
		return _filedBy;
	}

	public void setFiledBy(String filedBy) {
		_filedBy = filedBy;
	}

	public Date getFiledOn() {
		return _filedOn;
	}

	public void setFiledOn(Date filedOn) {
		_filedOn = filedOn;
	}

	public String getFiledAtCountry() {
		return _filedAtCountry;
	}

	public void setFiledAtCountry(String filedAtCountry) {
		_filedAtCountry = filedAtCountry;
	}

	public String getClaimsRemarks() {
		return _claimsRemarks;
	}

	public void setClaimsRemarks(String claimsRemarks) {
		_claimsRemarks = claimsRemarks;
	}

	public Date getResponseDeadline() {
		return _responseDeadline;
	}

	public void setResponseDeadline(Date responseDeadline) {
		_responseDeadline = responseDeadline;
	}

	public Date getActualResponseDate() {
		return _actualResponseDate;
	}

	public void setActualResponseDate(Date actualResponseDate) {
		_actualResponseDate = actualResponseDate;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public String getCustomField1() {
		return _customField1;
	}

	public void setCustomField1(String customField1) {
		_customField1 = customField1;
	}

	public String getCustomField2() {
		return _customField2;
	}

	public void setCustomField2(String customField2) {
		_customField2 = customField2;
	}

	public String getCustomField3() {
		return _customField3;
	}

	public void setCustomField3(String customField3) {
		_customField3 = customField3;
	}

	public Date getCustomDate1() {
		return _customDate1;
	}

	public void setCustomDate1(Date customDate1) {
		_customDate1 = customDate1;
	}

	public Date getCustomDate2() {
		return _customDate2;
	}

	public void setCustomDate2(Date customDate2) {
		_customDate2 = customDate2;
	}

	public Date getCustomDate3() {
		return _customDate3;
	}

	public void setCustomDate3(Date customDate3) {
		_customDate3 = customDate3;
	}

	public String getLegalConfRemarks() {
		return _legalConfRemarks;
	}

	public void setLegalConfRemarks(String legalConfRemarks) {
		_legalConfRemarks = legalConfRemarks;
	}

	public String getVersion() {
		return _version;
	}

	public void setVersion(String version) {
		_version = version;
	}

	public long getSpTrademarksId() {
		return _spTrademarksId;
	}

	public void setSpTrademarksId(long spTrademarksId) {
		_spTrademarksId = spTrademarksId;
	}

	public long getRootSpLitigationId() {
		return _rootSpLitigationId;
	}

	public void setRootSpLitigationId(long rootSpLitigationId) {
		_rootSpLitigationId = rootSpLitigationId;
	}

	private String _uuid;
	private long _spLitigationId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _country;
	private String _filedBy;
	private Date _filedOn;
	private String _filedAtCountry;
	private String _claimsRemarks;
	private Date _responseDeadline;
	private Date _actualResponseDate;
	private String _status;
	private String _customField1;
	private String _customField2;
	private String _customField3;
	private Date _customDate1;
	private Date _customDate2;
	private Date _customDate3;
	private String _legalConfRemarks;
	private String _version;
	private long _spTrademarksId;
	private long _rootSpLitigationId;
}