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
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class SPMailSubscriberUserAgentSoap implements Serializable {
	public static SPMailSubscriberUserAgentSoap toSoapModel(
		SPMailSubscriberUserAgent model) {
		SPMailSubscriberUserAgentSoap soapModel = new SPMailSubscriberUserAgentSoap();

		soapModel.setSpMailSubscriberUserAgentId(model.getSpMailSubscriberUserAgentId());
		soapModel.setSpMailCampaignSubscribersId(model.getSpMailCampaignSubscribersId());
		soapModel.setSpMailCampaignId(model.getSpMailCampaignId());
		soapModel.setName(model.getName());
		soapModel.setType(model.getType());
		soapModel.setTypeName(model.getTypeName());
		soapModel.setDeviceCategory(model.getDeviceCategory());
		soapModel.setFamily(model.getFamily());
		soapModel.setOperatingSystem(model.getOperatingSystem());
		soapModel.setVersionNumber(model.getVersionNumber());
		soapModel.setUserAgent(model.getUserAgent());

		return soapModel;
	}

	public static SPMailSubscriberUserAgentSoap[] toSoapModels(
		SPMailSubscriberUserAgent[] models) {
		SPMailSubscriberUserAgentSoap[] soapModels = new SPMailSubscriberUserAgentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPMailSubscriberUserAgentSoap[][] toSoapModels(
		SPMailSubscriberUserAgent[][] models) {
		SPMailSubscriberUserAgentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPMailSubscriberUserAgentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPMailSubscriberUserAgentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPMailSubscriberUserAgentSoap[] toSoapModels(
		List<SPMailSubscriberUserAgent> models) {
		List<SPMailSubscriberUserAgentSoap> soapModels = new ArrayList<SPMailSubscriberUserAgentSoap>(models.size());

		for (SPMailSubscriberUserAgent model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPMailSubscriberUserAgentSoap[soapModels.size()]);
	}

	public SPMailSubscriberUserAgentSoap() {
	}

	public long getPrimaryKey() {
		return _spMailSubscriberUserAgentId;
	}

	public void setPrimaryKey(long pk) {
		setSpMailSubscriberUserAgentId(pk);
	}

	public long getSpMailSubscriberUserAgentId() {
		return _spMailSubscriberUserAgentId;
	}

	public void setSpMailSubscriberUserAgentId(long spMailSubscriberUserAgentId) {
		_spMailSubscriberUserAgentId = spMailSubscriberUserAgentId;
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

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getType() {
		return _type;
	}

	public void setType(String type) {
		_type = type;
	}

	public String getTypeName() {
		return _typeName;
	}

	public void setTypeName(String typeName) {
		_typeName = typeName;
	}

	public String getDeviceCategory() {
		return _deviceCategory;
	}

	public void setDeviceCategory(String deviceCategory) {
		_deviceCategory = deviceCategory;
	}

	public String getFamily() {
		return _family;
	}

	public void setFamily(String family) {
		_family = family;
	}

	public String getOperatingSystem() {
		return _operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		_operatingSystem = operatingSystem;
	}

	public String getVersionNumber() {
		return _versionNumber;
	}

	public void setVersionNumber(String versionNumber) {
		_versionNumber = versionNumber;
	}

	public String getUserAgent() {
		return _userAgent;
	}

	public void setUserAgent(String userAgent) {
		_userAgent = userAgent;
	}

	private long _spMailSubscriberUserAgentId;
	private long _spMailCampaignSubscribersId;
	private long _spMailCampaignId;
	private String _name;
	private String _type;
	private String _typeName;
	private String _deviceCategory;
	private String _family;
	private String _operatingSystem;
	private String _versionNumber;
	private String _userAgent;
}