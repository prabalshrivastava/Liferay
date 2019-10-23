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
public class SPMailBlackListSoap implements Serializable {
	public static SPMailBlackListSoap toSoapModel(SPMailBlackList model) {
		SPMailBlackListSoap soapModel = new SPMailBlackListSoap();

		soapModel.setSpMailBlackListId(model.getSpMailBlackListId());
		soapModel.setSpMailCampaignId(model.getSpMailCampaignId());
		soapModel.setUserId(model.getUserId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setBounced(model.getBounced());
		soapModel.setBounce_soft(model.getBounce_soft());
		soapModel.setComplain(model.getComplain());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setMessage(model.getMessage());
		soapModel.setMessageId(model.getMessageId());

		return soapModel;
	}

	public static SPMailBlackListSoap[] toSoapModels(SPMailBlackList[] models) {
		SPMailBlackListSoap[] soapModels = new SPMailBlackListSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPMailBlackListSoap[][] toSoapModels(
		SPMailBlackList[][] models) {
		SPMailBlackListSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPMailBlackListSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPMailBlackListSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPMailBlackListSoap[] toSoapModels(
		List<SPMailBlackList> models) {
		List<SPMailBlackListSoap> soapModels = new ArrayList<SPMailBlackListSoap>(models.size());

		for (SPMailBlackList model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPMailBlackListSoap[soapModels.size()]);
	}

	public SPMailBlackListSoap() {
	}

	public long getPrimaryKey() {
		return _spMailBlackListId;
	}

	public void setPrimaryKey(long pk) {
		setSpMailBlackListId(pk);
	}

	public long getSpMailBlackListId() {
		return _spMailBlackListId;
	}

	public void setSpMailBlackListId(long spMailBlackListId) {
		_spMailBlackListId = spMailBlackListId;
	}

	public long getSpMailCampaignId() {
		return _spMailCampaignId;
	}

	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignId = spMailCampaignId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public boolean getBounced() {
		return _bounced;
	}

	public boolean isBounced() {
		return _bounced;
	}

	public void setBounced(boolean bounced) {
		_bounced = bounced;
	}

	public boolean getBounce_soft() {
		return _bounce_soft;
	}

	public boolean isBounce_soft() {
		return _bounce_soft;
	}

	public void setBounce_soft(boolean bounce_soft) {
		_bounce_soft = bounce_soft;
	}

	public boolean getComplain() {
		return _complain;
	}

	public boolean isComplain() {
		return _complain;
	}

	public void setComplain(boolean complain) {
		_complain = complain;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public String getMessage() {
		return _message;
	}

	public void setMessage(String message) {
		_message = message;
	}

	public String getMessageId() {
		return _messageId;
	}

	public void setMessageId(String messageId) {
		_messageId = messageId;
	}

	private long _spMailBlackListId;
	private long _spMailCampaignId;
	private long _userId;
	private String _emailAddress;
	private boolean _bounced;
	private boolean _bounce_soft;
	private boolean _complain;
	private Date _createDate;
	private String _message;
	private String _messageId;
}