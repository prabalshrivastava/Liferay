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
public class SPMailLinkTrackingSoap implements Serializable {
	public static SPMailLinkTrackingSoap toSoapModel(SPMailLinkTracking model) {
		SPMailLinkTrackingSoap soapModel = new SPMailLinkTrackingSoap();

		soapModel.setSpMailLinkTrackingId(model.getSpMailLinkTrackingId());
		soapModel.setSpMailCampaignId(model.getSpMailCampaignId());
		soapModel.setSpMailCampaignEDMId(model.getSpMailCampaignEDMId());
		soapModel.setSpMailCampaignSubscribersId(model.getSpMailCampaignSubscribersId());
		soapModel.setLabel(model.getLabel());
		soapModel.setLink(model.getLink());
		soapModel.setEncryptedlink(model.getEncryptedlink());
		soapModel.setStatus(model.getStatus());
		soapModel.setOpenedDate(model.getOpenedDate());
		soapModel.setCreateDate(model.getCreateDate());

		return soapModel;
	}

	public static SPMailLinkTrackingSoap[] toSoapModels(
		SPMailLinkTracking[] models) {
		SPMailLinkTrackingSoap[] soapModels = new SPMailLinkTrackingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SPMailLinkTrackingSoap[][] toSoapModels(
		SPMailLinkTracking[][] models) {
		SPMailLinkTrackingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SPMailLinkTrackingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SPMailLinkTrackingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SPMailLinkTrackingSoap[] toSoapModels(
		List<SPMailLinkTracking> models) {
		List<SPMailLinkTrackingSoap> soapModels = new ArrayList<SPMailLinkTrackingSoap>(models.size());

		for (SPMailLinkTracking model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SPMailLinkTrackingSoap[soapModels.size()]);
	}

	public SPMailLinkTrackingSoap() {
	}

	public long getPrimaryKey() {
		return _spMailLinkTrackingId;
	}

	public void setPrimaryKey(long pk) {
		setSpMailLinkTrackingId(pk);
	}

	public long getSpMailLinkTrackingId() {
		return _spMailLinkTrackingId;
	}

	public void setSpMailLinkTrackingId(long spMailLinkTrackingId) {
		_spMailLinkTrackingId = spMailLinkTrackingId;
	}

	public long getSpMailCampaignId() {
		return _spMailCampaignId;
	}

	public void setSpMailCampaignId(long spMailCampaignId) {
		_spMailCampaignId = spMailCampaignId;
	}

	public long getSpMailCampaignEDMId() {
		return _spMailCampaignEDMId;
	}

	public void setSpMailCampaignEDMId(long spMailCampaignEDMId) {
		_spMailCampaignEDMId = spMailCampaignEDMId;
	}

	public long getSpMailCampaignSubscribersId() {
		return _spMailCampaignSubscribersId;
	}

	public void setSpMailCampaignSubscribersId(long spMailCampaignSubscribersId) {
		_spMailCampaignSubscribersId = spMailCampaignSubscribersId;
	}

	public String getLabel() {
		return _label;
	}

	public void setLabel(String label) {
		_label = label;
	}

	public String getLink() {
		return _link;
	}

	public void setLink(String link) {
		_link = link;
	}

	public String getEncryptedlink() {
		return _encryptedlink;
	}

	public void setEncryptedlink(String encryptedlink) {
		_encryptedlink = encryptedlink;
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

	public Date getOpenedDate() {
		return _openedDate;
	}

	public void setOpenedDate(Date openedDate) {
		_openedDate = openedDate;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	private long _spMailLinkTrackingId;
	private long _spMailCampaignId;
	private long _spMailCampaignEDMId;
	private long _spMailCampaignSubscribersId;
	private String _label;
	private String _link;
	private String _encryptedlink;
	private boolean _status;
	private Date _openedDate;
	private Date _createDate;
}