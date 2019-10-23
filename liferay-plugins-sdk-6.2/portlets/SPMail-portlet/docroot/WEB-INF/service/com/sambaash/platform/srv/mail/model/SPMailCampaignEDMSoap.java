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

package com.sambaash.platform.srv.mail.model;

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
public class SPMailCampaignEDMSoap implements Serializable {
	public static SPMailCampaignEDMSoap toSoapModel(SPMailCampaignEDM model) {
		SPMailCampaignEDMSoap soapModel = new SPMailCampaignEDMSoap();

		soapModel.setSpMailCampaignEDMId(model.getSpMailCampaignEDMId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setName(model.getName());
		soapModel.setSpMailCampaignId(model.getSpMailCampaignId());
		soapModel.setSpMailTemplateId(model.getSpMailTemplateId());
		soapModel.setSeqNo(model.getSeqNo());
		soapModel.setDayOfWeek(model.getDayOfWeek());
		soapModel.setDayOfMonth(model.getDayOfMonth());
		soapModel.setDelayUnit(model.getDelayUnit());
		soapModel.setStatus(model.getStatus());
		soapModel.setDelayAmount(model.getDelayAmount());
		soapModel.setCroneType(model.getCroneType());
		soapModel.setNextScheduleDateTime(model.getNextScheduleDateTime());

		return soapModel;
	}

	public static SPMailCampaignEDMSoap[] toSoapModels(
		SPMailCampaignEDM[] models) {
		SPMailCampaignEDMSoap[] soapModels = new SPMailCampaignEDMSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPMailCampaignEDMSoap[][] toSoapModels(
		SPMailCampaignEDM[][] models) {
		SPMailCampaignEDMSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPMailCampaignEDMSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPMailCampaignEDMSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPMailCampaignEDMSoap[] toSoapModels(
		List<SPMailCampaignEDM> models) {
		List<SPMailCampaignEDMSoap> soapModels = new ArrayList<SPMailCampaignEDMSoap>(models.size());

		for (SPMailCampaignEDM model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPMailCampaignEDMSoap[soapModels.size()]);
	}

	public SPMailCampaignEDMSoap() {
	}

	public long getPrimaryKey() {
		return _spMailCampaignEDMId;
	}

	public void setPrimaryKey(long pk) {
		setSpMailCampaignEDMId(pk);
	}

	public long getSpMailCampaignEDMId() {
		return _spMailCampaignEDMId;
	}

	public void setSpMailCampaignEDMId(long spMailCampaignEDMId) {
		_spMailCampaignEDMId = spMailCampaignEDMId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public long getSpMailCampaignId() {
		return _spMailCampaignId;
	}

	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignId = spMailCampaignId;
	}

	public long getSpMailTemplateId() {
		return _spMailTemplateId;
	}

	public void setSpMailTemplateId(long spMailTemplateId) {
		_spMailTemplateId = spMailTemplateId;
	}

	public int getSeqNo() {
		return _seqNo;
	}

	public void setSeqNo(int seqNo) {
		_seqNo = seqNo;
	}

	public int getDayOfWeek() {
		return _dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		_dayOfWeek = dayOfWeek;
	}

	public int getDayOfMonth() {
		return _dayOfMonth;
	}

	public void setDayOfMonth(int dayOfMonth) {
		_dayOfMonth = dayOfMonth;
	}

	public String getDelayUnit() {
		return _delayUnit;
	}

	public void setDelayUnit(String delayUnit) {
		_delayUnit = delayUnit;
	}

	public String getStatus() {
		return _status;
	}

	public void setStatus(String status) {
		_status = status;
	}

	public int getDelayAmount() {
		return _delayAmount;
	}

	public void setDelayAmount(int delayAmount) {
		_delayAmount = delayAmount;
	}

	public String getCroneType() {
		return _croneType;
	}

	public void setCroneType(String croneType) {
		_croneType = croneType;
	}

	public Date getNextScheduleDateTime() {
		return _nextScheduleDateTime;
	}

	public void setNextScheduleDateTime(Date nextScheduleDateTime) {
		_nextScheduleDateTime = nextScheduleDateTime;
	}

	private long _spMailCampaignEDMId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private long _spMailCampaignId;
	private long _spMailTemplateId;
	private int _seqNo;
	private int _dayOfWeek;
	private int _dayOfMonth;
	private String _delayUnit;
	private String _status;
	private int _delayAmount;
	private String _croneType;
	private Date _nextScheduleDateTime;
}