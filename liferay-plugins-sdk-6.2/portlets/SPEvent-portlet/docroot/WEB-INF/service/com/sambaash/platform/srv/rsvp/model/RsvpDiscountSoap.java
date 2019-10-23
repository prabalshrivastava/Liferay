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
public class RsvpDiscountSoap implements Serializable {
	public static RsvpDiscountSoap toSoapModel(RsvpDiscount model) {
		RsvpDiscountSoap soapModel = new RsvpDiscountSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRsvpDiscountId(model.getRsvpDiscountId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRsvpId(model.getRsvpId());
		soapModel.setRsvpTicketId(model.getRsvpTicketId());
		soapModel.setFromDate(model.getFromDate());
		soapModel.setToDate(model.getToDate());
		soapModel.setNoOfTickets(model.getNoOfTickets());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setModifiedBy(model.getModifiedBy());

		return soapModel;
	}

	public static RsvpDiscountSoap[] toSoapModels(RsvpDiscount[] models) {
		RsvpDiscountSoap[] soapModels = new RsvpDiscountSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RsvpDiscountSoap[][] toSoapModels(RsvpDiscount[][] models) {
		RsvpDiscountSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RsvpDiscountSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RsvpDiscountSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RsvpDiscountSoap[] toSoapModels(List<RsvpDiscount> models) {
		List<RsvpDiscountSoap> soapModels = new ArrayList<RsvpDiscountSoap>(models.size());

		for (RsvpDiscount model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RsvpDiscountSoap[soapModels.size()]);
	}

	public RsvpDiscountSoap() {
	}

	public long getPrimaryKey() {
		return _rsvpDiscountId;
	}

	public void setPrimaryKey(long pk) {
		setRsvpDiscountId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRsvpDiscountId() {
		return _rsvpDiscountId;
	}

	public void setRsvpDiscountId(long rsvpDiscountId) {
		_rsvpDiscountId = rsvpDiscountId;
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

	public long getRsvpTicketId() {
		return _rsvpTicketId;
	}

	public void setRsvpTicketId(long rsvpTicketId) {
		_rsvpTicketId = rsvpTicketId;
	}

	public Date getFromDate() {
		return _fromDate;
	}

	public void setFromDate(Date fromDate) {
		_fromDate = fromDate;
	}

	public Date getToDate() {
		return _toDate;
	}

	public void setToDate(Date toDate) {
		_toDate = toDate;
	}

	public int getNoOfTickets() {
		return _noOfTickets;
	}

	public void setNoOfTickets(int noOfTickets) {
		_noOfTickets = noOfTickets;
	}

	public double getDiscount() {
		return _discount;
	}

	public void setDiscount(double discount) {
		_discount = discount;
	}

	public long getModifiedBy() {
		return _modifiedBy;
	}

	public void setModifiedBy(long modifiedBy) {
		_modifiedBy = modifiedBy;
	}

	private String _uuid;
	private long _rsvpDiscountId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rsvpId;
	private long _rsvpTicketId;
	private Date _fromDate;
	private Date _toDate;
	private int _noOfTickets;
	private double _discount;
	private long _modifiedBy;
}