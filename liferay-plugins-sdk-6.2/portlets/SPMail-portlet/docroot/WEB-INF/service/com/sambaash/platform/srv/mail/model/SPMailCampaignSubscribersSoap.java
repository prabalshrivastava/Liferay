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
public class SPMailCampaignSubscribersSoap implements Serializable {
	public static SPMailCampaignSubscribersSoap toSoapModel(
		SPMailCampaignSubscribers model) {
		SPMailCampaignSubscribersSoap soapModel = new SPMailCampaignSubscribersSoap();

		soapModel.setSpMailCampaignSubscribersId(model.getSpMailCampaignSubscribersId());
		soapModel.setSpMailCampaignId(model.getSpMailCampaignId());
		soapModel.setUserId(model.getUserId());
		soapModel.setParentSubscriberId(model.getParentSubscriberId());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setSpMailType(model.getSpMailType());
		soapModel.setMessageId(model.getMessageId());
		soapModel.setOpened(model.getOpened());
		soapModel.setCountryName(model.getCountryName());
		soapModel.setCity(model.getCity());
		soapModel.setRegionName(model.getRegionName());
		soapModel.setAreaCode(model.getAreaCode());
		soapModel.setLatitude(model.getLatitude());
		soapModel.setLongitude(model.getLongitude());
		soapModel.setIpAddress(model.getIpAddress());
		soapModel.setWebVersion(model.getWebVersion());
		soapModel.setOpenedDate(model.getOpenedDate());
		soapModel.setCreateBy(model.getCreateBy());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedBy(model.getModifiedBy());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setStatus(model.getStatus());

		return soapModel;
	}

	public static SPMailCampaignSubscribersSoap[] toSoapModels(
		SPMailCampaignSubscribers[] models) {
		SPMailCampaignSubscribersSoap[] soapModels = new SPMailCampaignSubscribersSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPMailCampaignSubscribersSoap[][] toSoapModels(
		SPMailCampaignSubscribers[][] models) {
		SPMailCampaignSubscribersSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPMailCampaignSubscribersSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPMailCampaignSubscribersSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPMailCampaignSubscribersSoap[] toSoapModels(
		List<SPMailCampaignSubscribers> models) {
		List<SPMailCampaignSubscribersSoap> soapModels = new ArrayList<SPMailCampaignSubscribersSoap>(models.size());

		for (SPMailCampaignSubscribers model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPMailCampaignSubscribersSoap[soapModels.size()]);
	}

	public SPMailCampaignSubscribersSoap() {
	}

	public long getPrimaryKey() {
		return _spMailCampaignSubscribersId;
	}

	public void setPrimaryKey(long pk) {
		setSpMailCampaignSubscribersId(pk);
	}

	public long getSpMailCampaignSubscribersId() {
		return _spMailCampaignSubscribersId;
	}

	public void setSpMailCampaignSubscribersId(long spMailCampaignSubscribersId) {
		_spMailCampaignSubscribersId = spMailCampaignSubscribersId;
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

	public long getParentSubscriberId() {
		return _parentSubscriberId;
	}

	public void setParentSubscriberId(long parentSubscriberId) {
		_parentSubscriberId = parentSubscriberId;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public int getSpMailType() {
		return _spMailType;
	}

	public void setSpMailType(int spMailType) {
		_spMailType = spMailType;
	}

	public String getMessageId() {
		return _messageId;
	}

	public void setMessageId(String messageId) {
		_messageId = messageId;
	}

	public boolean getOpened() {
		return _opened;
	}

	public boolean isOpened() {
		return _opened;
	}

	public void setOpened(boolean opened) {
		_opened = opened;
	}

	public String getCountryName() {
		return _countryName;
	}

	public void setCountryName(String countryName) {
		_countryName = countryName;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getRegionName() {
		return _regionName;
	}

	public void setRegionName(String regionName) {
		_regionName = regionName;
	}

	public int getAreaCode() {
		return _areaCode;
	}

	public void setAreaCode(int areaCode) {
		_areaCode = areaCode;
	}

	public String getLatitude() {
		return _latitude;
	}

	public void setLatitude(String latitude) {
		_latitude = latitude;
	}

	public String getLongitude() {
		return _longitude;
	}

	public void setLongitude(String longitude) {
		_longitude = longitude;
	}

	public String getIpAddress() {
		return _ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		_ipAddress = ipAddress;
	}

	public boolean getWebVersion() {
		return _webVersion;
	}

	public boolean isWebVersion() {
		return _webVersion;
	}

	public void setWebVersion(boolean webVersion) {
		_webVersion = webVersion;
	}

	public Date getOpenedDate() {
		return _openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		_openedDate = openedDate;
	}

	public long getCreateBy() {
		return _createBy;
	}

	public void setCreateBy(long createBy) {
		_createBy = createBy;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	private long _spMailCampaignSubscribersId;
	private long _spMailCampaignId;
	private long _userId;
	private long _parentSubscriberId;
	private String _emailAddress;
	private String _firstName;
	private String _lastName;
	private int _spMailType;
	private String _messageId;
	private boolean _opened;
	private String _countryName;
	private String _city;
	private String _regionName;
	private int _areaCode;
	private String _latitude;
	private String _longitude;
	private String _ipAddress;
	private boolean _webVersion;
	private Date _openedDate;
	private long _createBy;
	private Date _createDate;
	private long _modifiedBy;
	private Date _modifiedDate;
	private int _status;
}