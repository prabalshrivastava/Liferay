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
public class RsvpTicketSoap implements Serializable {
	public static RsvpTicketSoap toSoapModel(RsvpTicket model) {
		RsvpTicketSoap soapModel = new RsvpTicketSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRsvpTicketId(model.getRsvpTicketId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRsvpId(model.getRsvpId());
		soapModel.setPrice(model.getPrice());
		soapModel.setQuantity(model.getQuantity());
		soapModel.setSoldQuantity(model.getSoldQuantity());
		soapModel.setTicketSequence(model.getTicketSequence());
		soapModel.setLastSequenceNumber(model.getLastSequenceNumber());
		soapModel.setSequencePrefix(model.getSequencePrefix());
		soapModel.setSequenceSuffix(model.getSequenceSuffix());
		soapModel.setTicketTemplateUrl(model.getTicketTemplateUrl());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static RsvpTicketSoap[] toSoapModels(RsvpTicket[] models) {
		RsvpTicketSoap[] soapModels = new RsvpTicketSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RsvpTicketSoap[][] toSoapModels(RsvpTicket[][] models) {
		RsvpTicketSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RsvpTicketSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RsvpTicketSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RsvpTicketSoap[] toSoapModels(List<RsvpTicket> models) {
		List<RsvpTicketSoap> soapModels = new ArrayList<RsvpTicketSoap>(models.size());

		for (RsvpTicket model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RsvpTicketSoap[soapModels.size()]);
	}

	public RsvpTicketSoap() {
	}

	public long getPrimaryKey() {
		return _rsvpTicketId;
	}

	public void setPrimaryKey(long pk) {
		setRsvpTicketId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRsvpTicketId() {
		return _rsvpTicketId;
	}

	public void setRsvpTicketId(long rsvpTicketId) {
		_rsvpTicketId = rsvpTicketId;
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

	public long getRsvpId() {
		return _rsvpId;
	}

	public void setRsvpId(long rsvpId) {
		_rsvpId = rsvpId;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public int getQuantity() {
		return _quantity;
	}

	public void setQuantity(int quantity) {
		_quantity = quantity;
	}

	public int getSoldQuantity() {
		return _soldQuantity;
	}

	public void setSoldQuantity(int soldQuantity) {
		_soldQuantity = soldQuantity;
	}

	public int getTicketSequence() {
		return _ticketSequence;
	}

	public void setTicketSequence(int ticketSequence) {
		_ticketSequence = ticketSequence;
	}

	public int getLastSequenceNumber() {
		return _lastSequenceNumber;
	}

	public void setLastSequenceNumber(int lastSequenceNumber) {
		_lastSequenceNumber = lastSequenceNumber;
	}

	public String getSequencePrefix() {
		return _sequencePrefix;
	}

	public void setSequencePrefix(String sequencePrefix) {
		_sequencePrefix = sequencePrefix;
	}

	public String getSequenceSuffix() {
		return _sequenceSuffix;
	}

	public void setSequenceSuffix(String sequenceSuffix) {
		_sequenceSuffix = sequenceSuffix;
	}

	public String getTicketTemplateUrl() {
		return _ticketTemplateUrl;
	}

	public void setTicketTemplateUrl(String ticketTemplateUrl) {
		_ticketTemplateUrl = ticketTemplateUrl;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	private String _uuid;
	private long _rsvpTicketId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rsvpId;
	private double _price;
	private int _quantity;
	private int _soldQuantity;
	private int _ticketSequence;
	private int _lastSequenceNumber;
	private String _sequencePrefix;
	private String _sequenceSuffix;
	private String _ticketTemplateUrl;
	private long _modifiedBy;
}