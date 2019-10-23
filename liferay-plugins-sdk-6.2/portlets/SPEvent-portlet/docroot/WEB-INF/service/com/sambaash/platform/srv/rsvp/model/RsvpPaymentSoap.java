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
public class RsvpPaymentSoap implements Serializable {
	public static RsvpPaymentSoap toSoapModel(RsvpPayment model) {
		RsvpPaymentSoap soapModel = new RsvpPaymentSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRsvpPaymentId(model.getRsvpPaymentId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRsvpDetailId(model.getRsvpDetailId());
		soapModel.setRsvpId(model.getRsvpId());
		soapModel.setRsvpTicketId(model.getRsvpTicketId());
		soapModel.setRsvpDiscountId(model.getRsvpDiscountId());
		soapModel.setRsvpPromoCodeId(model.getRsvpPromoCodeId());
		soapModel.setPrice(model.getPrice());
		soapModel.setNumberOfPeople(model.getNumberOfPeople());
		soapModel.setDiscount(model.getDiscount());
		soapModel.setNetTotal(model.getNetTotal());
		soapModel.setTicketNumber(model.getTicketNumber());
		soapModel.setPayerEmailAddress(model.getPayerEmailAddress());
		soapModel.setReceiverEmailAddress(model.getReceiverEmailAddress());
		soapModel.setTransactionId(model.getTransactionId());
		soapModel.setTransactionStatus(model.getTransactionStatus());
		soapModel.setTransactionAmount(model.getTransactionAmount());
		soapModel.setTransactionDate(model.getTransactionDate());
		soapModel.setEmailStatus(model.getEmailStatus());

		return soapModel;
	}

	public static RsvpPaymentSoap[] toSoapModels(RsvpPayment[] models) {
		RsvpPaymentSoap[] soapModels = new RsvpPaymentSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RsvpPaymentSoap[][] toSoapModels(RsvpPayment[][] models) {
		RsvpPaymentSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RsvpPaymentSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RsvpPaymentSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RsvpPaymentSoap[] toSoapModels(List<RsvpPayment> models) {
		List<RsvpPaymentSoap> soapModels = new ArrayList<RsvpPaymentSoap>(models.size());

		for (RsvpPayment model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RsvpPaymentSoap[soapModels.size()]);
	}

	public RsvpPaymentSoap() {
	}

	public long getPrimaryKey() {
		return _rsvpPaymentId;
	}

	public void setPrimaryKey(long pk) {
		setRsvpPaymentId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRsvpPaymentId() {
		return _rsvpPaymentId;
	}

	public void setRsvpPaymentId(long rsvpPaymentId) {
		_rsvpPaymentId = rsvpPaymentId;
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

	public long getRsvpDetailId() {
		return _rsvpDetailId;
	}

	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpDetailId = rsvpDetailId;
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

	public long getRsvpDiscountId() {
		return _rsvpDiscountId;
	}

	public void setRsvpDiscountId(long rsvpDiscountId) {
		_rsvpDiscountId = rsvpDiscountId;
	}

	public long getRsvpPromoCodeId() {
		return _rsvpPromoCodeId;
	}

	public void setRsvpPromoCodeId(long rsvpPromoCodeId) {
		_rsvpPromoCodeId = rsvpPromoCodeId;
	}

	public double getPrice() {
		return _price;
	}

	public void setPrice(double price) {
		_price = price;
	}

	public int getNumberOfPeople() {
		return _numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		_numberOfPeople = numberOfPeople;
	}

	public int getDiscount() {
		return _discount;
	}

	public void setDiscount(int discount) {
		_discount = discount;
	}

	public double getNetTotal() {
		return _netTotal;
	}

	public void setNetTotal(double netTotal) {
		_netTotal = netTotal;
	}

	public String getTicketNumber() {
		return _ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		_ticketNumber = ticketNumber;
	}

	public String getPayerEmailAddress() {
		return _payerEmailAddress;
	}

	public void setPayerEmailAddress(String payerEmailAddress) {
		_payerEmailAddress = payerEmailAddress;
	}

	public String getReceiverEmailAddress() {
		return _receiverEmailAddress;
	}

	public void setReceiverEmailAddress(String receiverEmailAddress) {
		_receiverEmailAddress = receiverEmailAddress;
	}

	public String getTransactionId() {
		return _transactionId;
	}

	public void setTransactionId(String transactionId) {
		_transactionId = transactionId;
	}

	public String getTransactionStatus() {
		return _transactionStatus;
	}

	public void setTransactionStatus(String transactionStatus) {
		_transactionStatus = transactionStatus;
	}

	public double getTransactionAmount() {
		return _transactionAmount;
	}

	public void setTransactionAmount(double transactionAmount) {
		_transactionAmount = transactionAmount;
	}

	public Date getTransactionDate() {
		return _transactionDate;
	}

	public void setTransactionDate(Date transactionDate) {
		_transactionDate = transactionDate;
	}

	public boolean getEmailStatus() {
		return _emailStatus;
	}

	public boolean isEmailStatus() {
		return _emailStatus;
	}

	public void setEmailStatus(boolean emailStatus) {
		_emailStatus = emailStatus;
	}

	private String _uuid;
	private long _rsvpPaymentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rsvpDetailId;
	private long _rsvpId;
	private long _rsvpTicketId;
	private long _rsvpDiscountId;
	private long _rsvpPromoCodeId;
	private double _price;
	private int _numberOfPeople;
	private int _discount;
	private double _netTotal;
	private String _ticketNumber;
	private String _payerEmailAddress;
	private String _receiverEmailAddress;
	private String _transactionId;
	private String _transactionStatus;
	private double _transactionAmount;
	private Date _transactionDate;
	private boolean _emailStatus;
}