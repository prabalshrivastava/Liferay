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

package com.sambaash.platform.srv.rsvp.model;

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
public class RsvpSoap implements Serializable {
	public static RsvpSoap toSoapModel(Rsvp model) {
		RsvpSoap soapModel = new RsvpSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRsvpId(model.getRsvpId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setTitle(model.getTitle());
		soapModel.setDescription(model.getDescription());
		soapModel.setEventId(model.getEventId());
		soapModel.setSpAssetTypeId(model.getSpAssetTypeId());
		soapModel.setStatus(model.getStatus());
		soapModel.setRsvpUrl(model.getRsvpUrl());
		soapModel.setProcessing(model.getProcessing());
		soapModel.setPrice(model.getPrice());
		soapModel.setCurrency(model.getCurrency());
		soapModel.setTax(model.getTax());
		soapModel.setAccountId(model.getAccountId());
		soapModel.setPaymentFlag(model.getPaymentFlag());
		soapModel.setRegisterFlag(model.getRegisterFlag());
		soapModel.setTicketFlag(model.getTicketFlag());
		soapModel.setDynamicSectionName(model.getDynamicSectionName());
		soapModel.setCcEmail(model.getCcEmail());

		return soapModel;
	}

	public static RsvpSoap[] toSoapModels(Rsvp[] models) {
		RsvpSoap[] soapModels = new RsvpSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RsvpSoap[][] toSoapModels(Rsvp[][] models) {
		RsvpSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RsvpSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RsvpSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RsvpSoap[] toSoapModels(List<Rsvp> models) {
		List<RsvpSoap> soapModels = new ArrayList<RsvpSoap>(models.size());

		for (Rsvp model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RsvpSoap[soapModels.size()]);
	}

	public RsvpSoap() {
	}

	public long getPrimaryKey() {
		return _rsvpId;
	}

	public void setPrimaryKey(long pk) {
		setRsvpId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRsvpId() {
		return _rsvpId;
	}

	public void setRsvpId(long rsvpId) {
		_rsvpId = rsvpId;
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

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	public long getSpAssetTypeId() {
		return _spAssetTypeId;
	}

	public void setSpAssetTypeId(long spAssetTypeId) {
		_spAssetTypeId = spAssetTypeId;
	}

	public boolean getStatus() {
		return _status;
	}

	public boolean isStatus() {
		return _status;
	}

	public void setStatus(boolean status) {
		_status = status;
	}

	public String getRsvpUrl() {
		return _rsvpUrl;
	}

	public void setRsvpUrl(String rsvpUrl) {
		_rsvpUrl = rsvpUrl;
	}

	public int getProcessing() {
		return _processing;
	}

	public void setProcessing(int processing) {
		_processing = processing;
	}

	public String getPrice() {
		return _price;
	}

	public void setPrice(String price) {
		_price = price;
	}

	public String getCurrency() {
		return _currency;
	}

	public void setCurrency(String currency) {
		_currency = currency;
	}

	public String getTax() {
		return _tax;
	}

	public void setTax(String tax) {
		_tax = tax;
	}

	public String getAccountId() {
		return _accountId;
	}

	public void setAccountId(String accountId) {
		_accountId = accountId;
	}

	public boolean getPaymentFlag() {
		return _paymentFlag;
	}

	public boolean isPaymentFlag() {
		return _paymentFlag;
	}

	public void setPaymentFlag(boolean paymentFlag) {
		_paymentFlag = paymentFlag;
	}

	public boolean getRegisterFlag() {
		return _registerFlag;
	}

	public boolean isRegisterFlag() {
		return _registerFlag;
	}

	public void setRegisterFlag(boolean registerFlag) {
		_registerFlag = registerFlag;
	}

	public boolean getTicketFlag() {
		return _ticketFlag;
	}

	public boolean isTicketFlag() {
		return _ticketFlag;
	}

	public void setTicketFlag(boolean ticketFlag) {
		_ticketFlag = ticketFlag;
	}

	public String getDynamicSectionName() {
		return _dynamicSectionName;
	}

	public void setDynamicSectionName(String dynamicSectionName) {
		_dynamicSectionName = dynamicSectionName;
	}

	public boolean getCcEmail() {
		return _ccEmail;
	}

	public boolean isCcEmail() {
		return _ccEmail;
	}

	public void setCcEmail(boolean ccEmail) {
		_ccEmail = ccEmail;
	}

	private String _uuid;
	private long _rsvpId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _title;
	private String _description;
	private long _eventId;
	private long _spAssetTypeId;
	private boolean _status;
	private String _rsvpUrl;
	private int _processing;
	private String _price;
	private String _currency;
	private String _tax;
	private String _accountId;
	private boolean _paymentFlag;
	private boolean _registerFlag;
	private boolean _ticketFlag;
	private String _dynamicSectionName;
	private boolean _ccEmail;
}