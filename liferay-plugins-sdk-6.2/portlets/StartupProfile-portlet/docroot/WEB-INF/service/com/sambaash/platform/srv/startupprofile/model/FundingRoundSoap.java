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

package com.sambaash.platform.srv.startupprofile.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author pradeep
 * @generated
 */
public class FundingRoundSoap implements Serializable {
	public static FundingRoundSoap toSoapModel(FundingRound model) {
		FundingRoundSoap soapModel = new FundingRoundSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setFundingRoundId(model.getFundingRoundId());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setName(model.getName());
		soapModel.setApiPath(model.getApiPath());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setAnnouncedOn(model.getAnnouncedOn());
		soapModel.setMoneyRaisedInUsd(model.getMoneyRaisedInUsd());
		soapModel.setFundingType(model.getFundingType());
		soapModel.setDescription(model.getDescription());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static FundingRoundSoap[] toSoapModels(FundingRound[] models) {
		FundingRoundSoap[] soapModels = new FundingRoundSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static FundingRoundSoap[][] toSoapModels(FundingRound[][] models) {
		FundingRoundSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new FundingRoundSoap[models.length][models[0].length];
		}
		else {
			soapModels = new FundingRoundSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static FundingRoundSoap[] toSoapModels(List<FundingRound> models) {
		List<FundingRoundSoap> soapModels = new ArrayList<FundingRoundSoap>(models.size());

		for (FundingRound model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new FundingRoundSoap[soapModels.size()]);
	}

	public FundingRoundSoap() {
	}

	public long getPrimaryKey() {
		return _fundingRoundId;
	}

	public void setPrimaryKey(long pk) {
		setFundingRoundId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getFundingRoundId() {
		return _fundingRoundId;
	}

	public void setFundingRoundId(long fundingRoundId) {
		_fundingRoundId = fundingRoundId;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getApiPath() {
		return _apiPath;
	}

	public void setApiPath(String apiPath) {
		_apiPath = apiPath;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getAnnouncedOn() {
		return _announcedOn;
	}

	public void setAnnouncedOn(String announcedOn) {
		_announcedOn = announcedOn;
	}

	public String getMoneyRaisedInUsd() {
		return _moneyRaisedInUsd;
	}

	public void setMoneyRaisedInUsd(String moneyRaisedInUsd) {
		_moneyRaisedInUsd = moneyRaisedInUsd;
	}

	public String getFundingType() {
		return _fundingType;
	}

	public void setFundingType(String fundingType) {
		_fundingType = fundingType;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private String _uuid;
	private long _fundingRoundId;
	private long _organizationId;
	private String _name;
	private String _apiPath;
	private String _imageUrl;
	private String _announcedOn;
	private String _moneyRaisedInUsd;
	private String _fundingType;
	private String _description;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
}