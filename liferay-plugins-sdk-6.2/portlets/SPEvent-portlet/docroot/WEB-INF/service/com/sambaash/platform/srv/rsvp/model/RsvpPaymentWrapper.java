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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link RsvpPayment}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPayment
 * @generated
 */
public class RsvpPaymentWrapper implements RsvpPayment,
	ModelWrapper<RsvpPayment> {
	public RsvpPaymentWrapper(RsvpPayment rsvpPayment) {
		_rsvpPayment = rsvpPayment;
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpPayment.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpPayment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpPaymentId", getRsvpPaymentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpDetailId", getRsvpDetailId());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("rsvpTicketId", getRsvpTicketId());
		attributes.put("rsvpDiscountId", getRsvpDiscountId());
		attributes.put("rsvpPromoCodeId", getRsvpPromoCodeId());
		attributes.put("price", getPrice());
		attributes.put("numberOfPeople", getNumberOfPeople());
		attributes.put("discount", getDiscount());
		attributes.put("netTotal", getNetTotal());
		attributes.put("ticketNumber", getTicketNumber());
		attributes.put("payerEmailAddress", getPayerEmailAddress());
		attributes.put("receiverEmailAddress", getReceiverEmailAddress());
		attributes.put("transactionId", getTransactionId());
		attributes.put("transactionStatus", getTransactionStatus());
		attributes.put("transactionAmount", getTransactionAmount());
		attributes.put("transactionDate", getTransactionDate());
		attributes.put("emailStatus", getEmailStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpPaymentId = (Long)attributes.get("rsvpPaymentId");

		if (rsvpPaymentId != null) {
			setRsvpPaymentId(rsvpPaymentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long rsvpDetailId = (Long)attributes.get("rsvpDetailId");

		if (rsvpDetailId != null) {
			setRsvpDetailId(rsvpDetailId);
		}

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
		}

		Long rsvpTicketId = (Long)attributes.get("rsvpTicketId");

		if (rsvpTicketId != null) {
			setRsvpTicketId(rsvpTicketId);
		}

		Long rsvpDiscountId = (Long)attributes.get("rsvpDiscountId");

		if (rsvpDiscountId != null) {
			setRsvpDiscountId(rsvpDiscountId);
		}

		Long rsvpPromoCodeId = (Long)attributes.get("rsvpPromoCodeId");

		if (rsvpPromoCodeId != null) {
			setRsvpPromoCodeId(rsvpPromoCodeId);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer numberOfPeople = (Integer)attributes.get("numberOfPeople");

		if (numberOfPeople != null) {
			setNumberOfPeople(numberOfPeople);
		}

		Integer discount = (Integer)attributes.get("discount");

		if (discount != null) {
			setDiscount(discount);
		}

		Double netTotal = (Double)attributes.get("netTotal");

		if (netTotal != null) {
			setNetTotal(netTotal);
		}

		String ticketNumber = (String)attributes.get("ticketNumber");

		if (ticketNumber != null) {
			setTicketNumber(ticketNumber);
		}

		String payerEmailAddress = (String)attributes.get("payerEmailAddress");

		if (payerEmailAddress != null) {
			setPayerEmailAddress(payerEmailAddress);
		}

		String receiverEmailAddress = (String)attributes.get(
				"receiverEmailAddress");

		if (receiverEmailAddress != null) {
			setReceiverEmailAddress(receiverEmailAddress);
		}

		String transactionId = (String)attributes.get("transactionId");

		if (transactionId != null) {
			setTransactionId(transactionId);
		}

		String transactionStatus = (String)attributes.get("transactionStatus");

		if (transactionStatus != null) {
			setTransactionStatus(transactionStatus);
		}

		Double transactionAmount = (Double)attributes.get("transactionAmount");

		if (transactionAmount != null) {
			setTransactionAmount(transactionAmount);
		}

		Date transactionDate = (Date)attributes.get("transactionDate");

		if (transactionDate != null) {
			setTransactionDate(transactionDate);
		}

		Boolean emailStatus = (Boolean)attributes.get("emailStatus");

		if (emailStatus != null) {
			setEmailStatus(emailStatus);
		}
	}

	/**
	* Returns the primary key of this rsvp payment.
	*
	* @return the primary key of this rsvp payment
	*/
	@Override
	public long getPrimaryKey() {
		return _rsvpPayment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rsvp payment.
	*
	* @param primaryKey the primary key of this rsvp payment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rsvpPayment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rsvp payment.
	*
	* @return the uuid of this rsvp payment
	*/
	@Override
	public java.lang.String getUuid() {
		return _rsvpPayment.getUuid();
	}

	/**
	* Sets the uuid of this rsvp payment.
	*
	* @param uuid the uuid of this rsvp payment
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rsvpPayment.setUuid(uuid);
	}

	/**
	* Returns the rsvp payment ID of this rsvp payment.
	*
	* @return the rsvp payment ID of this rsvp payment
	*/
	@Override
	public long getRsvpPaymentId() {
		return _rsvpPayment.getRsvpPaymentId();
	}

	/**
	* Sets the rsvp payment ID of this rsvp payment.
	*
	* @param rsvpPaymentId the rsvp payment ID of this rsvp payment
	*/
	@Override
	public void setRsvpPaymentId(long rsvpPaymentId) {
		_rsvpPayment.setRsvpPaymentId(rsvpPaymentId);
	}

	/**
	* Returns the group ID of this rsvp payment.
	*
	* @return the group ID of this rsvp payment
	*/
	@Override
	public long getGroupId() {
		return _rsvpPayment.getGroupId();
	}

	/**
	* Sets the group ID of this rsvp payment.
	*
	* @param groupId the group ID of this rsvp payment
	*/
	@Override
	public void setGroupId(long groupId) {
		_rsvpPayment.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rsvp payment.
	*
	* @return the company ID of this rsvp payment
	*/
	@Override
	public long getCompanyId() {
		return _rsvpPayment.getCompanyId();
	}

	/**
	* Sets the company ID of this rsvp payment.
	*
	* @param companyId the company ID of this rsvp payment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rsvpPayment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rsvp payment.
	*
	* @return the user ID of this rsvp payment
	*/
	@Override
	public long getUserId() {
		return _rsvpPayment.getUserId();
	}

	/**
	* Sets the user ID of this rsvp payment.
	*
	* @param userId the user ID of this rsvp payment
	*/
	@Override
	public void setUserId(long userId) {
		_rsvpPayment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rsvp payment.
	*
	* @return the user uuid of this rsvp payment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpPayment.getUserUuid();
	}

	/**
	* Sets the user uuid of this rsvp payment.
	*
	* @param userUuid the user uuid of this rsvp payment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rsvpPayment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rsvp payment.
	*
	* @return the user name of this rsvp payment
	*/
	@Override
	public java.lang.String getUserName() {
		return _rsvpPayment.getUserName();
	}

	/**
	* Sets the user name of this rsvp payment.
	*
	* @param userName the user name of this rsvp payment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rsvpPayment.setUserName(userName);
	}

	/**
	* Returns the create date of this rsvp payment.
	*
	* @return the create date of this rsvp payment
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rsvpPayment.getCreateDate();
	}

	/**
	* Sets the create date of this rsvp payment.
	*
	* @param createDate the create date of this rsvp payment
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rsvpPayment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rsvp payment.
	*
	* @return the modified date of this rsvp payment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rsvpPayment.getModifiedDate();
	}

	/**
	* Sets the modified date of this rsvp payment.
	*
	* @param modifiedDate the modified date of this rsvp payment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rsvpPayment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the rsvp detail ID of this rsvp payment.
	*
	* @return the rsvp detail ID of this rsvp payment
	*/
	@Override
	public long getRsvpDetailId() {
		return _rsvpPayment.getRsvpDetailId();
	}

	/**
	* Sets the rsvp detail ID of this rsvp payment.
	*
	* @param rsvpDetailId the rsvp detail ID of this rsvp payment
	*/
	@Override
	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpPayment.setRsvpDetailId(rsvpDetailId);
	}

	/**
	* Returns the rsvp ID of this rsvp payment.
	*
	* @return the rsvp ID of this rsvp payment
	*/
	@Override
	public long getRsvpId() {
		return _rsvpPayment.getRsvpId();
	}

	/**
	* Sets the rsvp ID of this rsvp payment.
	*
	* @param rsvpId the rsvp ID of this rsvp payment
	*/
	@Override
	public void setRsvpId(long rsvpId) {
		_rsvpPayment.setRsvpId(rsvpId);
	}

	/**
	* Returns the rsvp ticket ID of this rsvp payment.
	*
	* @return the rsvp ticket ID of this rsvp payment
	*/
	@Override
	public long getRsvpTicketId() {
		return _rsvpPayment.getRsvpTicketId();
	}

	/**
	* Sets the rsvp ticket ID of this rsvp payment.
	*
	* @param rsvpTicketId the rsvp ticket ID of this rsvp payment
	*/
	@Override
	public void setRsvpTicketId(long rsvpTicketId) {
		_rsvpPayment.setRsvpTicketId(rsvpTicketId);
	}

	/**
	* Returns the rsvp discount ID of this rsvp payment.
	*
	* @return the rsvp discount ID of this rsvp payment
	*/
	@Override
	public long getRsvpDiscountId() {
		return _rsvpPayment.getRsvpDiscountId();
	}

	/**
	* Sets the rsvp discount ID of this rsvp payment.
	*
	* @param rsvpDiscountId the rsvp discount ID of this rsvp payment
	*/
	@Override
	public void setRsvpDiscountId(long rsvpDiscountId) {
		_rsvpPayment.setRsvpDiscountId(rsvpDiscountId);
	}

	/**
	* Returns the rsvp promo code ID of this rsvp payment.
	*
	* @return the rsvp promo code ID of this rsvp payment
	*/
	@Override
	public long getRsvpPromoCodeId() {
		return _rsvpPayment.getRsvpPromoCodeId();
	}

	/**
	* Sets the rsvp promo code ID of this rsvp payment.
	*
	* @param rsvpPromoCodeId the rsvp promo code ID of this rsvp payment
	*/
	@Override
	public void setRsvpPromoCodeId(long rsvpPromoCodeId) {
		_rsvpPayment.setRsvpPromoCodeId(rsvpPromoCodeId);
	}

	/**
	* Returns the price of this rsvp payment.
	*
	* @return the price of this rsvp payment
	*/
	@Override
	public double getPrice() {
		return _rsvpPayment.getPrice();
	}

	/**
	* Sets the price of this rsvp payment.
	*
	* @param price the price of this rsvp payment
	*/
	@Override
	public void setPrice(double price) {
		_rsvpPayment.setPrice(price);
	}

	/**
	* Returns the number of people of this rsvp payment.
	*
	* @return the number of people of this rsvp payment
	*/
	@Override
	public int getNumberOfPeople() {
		return _rsvpPayment.getNumberOfPeople();
	}

	/**
	* Sets the number of people of this rsvp payment.
	*
	* @param numberOfPeople the number of people of this rsvp payment
	*/
	@Override
	public void setNumberOfPeople(int numberOfPeople) {
		_rsvpPayment.setNumberOfPeople(numberOfPeople);
	}

	/**
	* Returns the discount of this rsvp payment.
	*
	* @return the discount of this rsvp payment
	*/
	@Override
	public int getDiscount() {
		return _rsvpPayment.getDiscount();
	}

	/**
	* Sets the discount of this rsvp payment.
	*
	* @param discount the discount of this rsvp payment
	*/
	@Override
	public void setDiscount(int discount) {
		_rsvpPayment.setDiscount(discount);
	}

	/**
	* Returns the net total of this rsvp payment.
	*
	* @return the net total of this rsvp payment
	*/
	@Override
	public double getNetTotal() {
		return _rsvpPayment.getNetTotal();
	}

	/**
	* Sets the net total of this rsvp payment.
	*
	* @param netTotal the net total of this rsvp payment
	*/
	@Override
	public void setNetTotal(double netTotal) {
		_rsvpPayment.setNetTotal(netTotal);
	}

	/**
	* Returns the ticket number of this rsvp payment.
	*
	* @return the ticket number of this rsvp payment
	*/
	@Override
	public java.lang.String getTicketNumber() {
		return _rsvpPayment.getTicketNumber();
	}

	/**
	* Sets the ticket number of this rsvp payment.
	*
	* @param ticketNumber the ticket number of this rsvp payment
	*/
	@Override
	public void setTicketNumber(java.lang.String ticketNumber) {
		_rsvpPayment.setTicketNumber(ticketNumber);
	}

	/**
	* Returns the payer email address of this rsvp payment.
	*
	* @return the payer email address of this rsvp payment
	*/
	@Override
	public java.lang.String getPayerEmailAddress() {
		return _rsvpPayment.getPayerEmailAddress();
	}

	/**
	* Sets the payer email address of this rsvp payment.
	*
	* @param payerEmailAddress the payer email address of this rsvp payment
	*/
	@Override
	public void setPayerEmailAddress(java.lang.String payerEmailAddress) {
		_rsvpPayment.setPayerEmailAddress(payerEmailAddress);
	}

	/**
	* Returns the receiver email address of this rsvp payment.
	*
	* @return the receiver email address of this rsvp payment
	*/
	@Override
	public java.lang.String getReceiverEmailAddress() {
		return _rsvpPayment.getReceiverEmailAddress();
	}

	/**
	* Sets the receiver email address of this rsvp payment.
	*
	* @param receiverEmailAddress the receiver email address of this rsvp payment
	*/
	@Override
	public void setReceiverEmailAddress(java.lang.String receiverEmailAddress) {
		_rsvpPayment.setReceiverEmailAddress(receiverEmailAddress);
	}

	/**
	* Returns the transaction ID of this rsvp payment.
	*
	* @return the transaction ID of this rsvp payment
	*/
	@Override
	public java.lang.String getTransactionId() {
		return _rsvpPayment.getTransactionId();
	}

	/**
	* Sets the transaction ID of this rsvp payment.
	*
	* @param transactionId the transaction ID of this rsvp payment
	*/
	@Override
	public void setTransactionId(java.lang.String transactionId) {
		_rsvpPayment.setTransactionId(transactionId);
	}

	/**
	* Returns the transaction status of this rsvp payment.
	*
	* @return the transaction status of this rsvp payment
	*/
	@Override
	public java.lang.String getTransactionStatus() {
		return _rsvpPayment.getTransactionStatus();
	}

	/**
	* Sets the transaction status of this rsvp payment.
	*
	* @param transactionStatus the transaction status of this rsvp payment
	*/
	@Override
	public void setTransactionStatus(java.lang.String transactionStatus) {
		_rsvpPayment.setTransactionStatus(transactionStatus);
	}

	/**
	* Returns the transaction amount of this rsvp payment.
	*
	* @return the transaction amount of this rsvp payment
	*/
	@Override
	public double getTransactionAmount() {
		return _rsvpPayment.getTransactionAmount();
	}

	/**
	* Sets the transaction amount of this rsvp payment.
	*
	* @param transactionAmount the transaction amount of this rsvp payment
	*/
	@Override
	public void setTransactionAmount(double transactionAmount) {
		_rsvpPayment.setTransactionAmount(transactionAmount);
	}

	/**
	* Returns the transaction date of this rsvp payment.
	*
	* @return the transaction date of this rsvp payment
	*/
	@Override
	public java.util.Date getTransactionDate() {
		return _rsvpPayment.getTransactionDate();
	}

	/**
	* Sets the transaction date of this rsvp payment.
	*
	* @param transactionDate the transaction date of this rsvp payment
	*/
	@Override
	public void setTransactionDate(java.util.Date transactionDate) {
		_rsvpPayment.setTransactionDate(transactionDate);
	}

	/**
	* Returns the email status of this rsvp payment.
	*
	* @return the email status of this rsvp payment
	*/
	@Override
	public boolean getEmailStatus() {
		return _rsvpPayment.getEmailStatus();
	}

	/**
	* Returns <code>true</code> if this rsvp payment is email status.
	*
	* @return <code>true</code> if this rsvp payment is email status; <code>false</code> otherwise
	*/
	@Override
	public boolean isEmailStatus() {
		return _rsvpPayment.isEmailStatus();
	}

	/**
	* Sets whether this rsvp payment is email status.
	*
	* @param emailStatus the email status of this rsvp payment
	*/
	@Override
	public void setEmailStatus(boolean emailStatus) {
		_rsvpPayment.setEmailStatus(emailStatus);
	}

	@Override
	public boolean isNew() {
		return _rsvpPayment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rsvpPayment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rsvpPayment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rsvpPayment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rsvpPayment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rsvpPayment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rsvpPayment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rsvpPayment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rsvpPayment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rsvpPayment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rsvpPayment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RsvpPaymentWrapper((RsvpPayment)_rsvpPayment.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment) {
		return _rsvpPayment.compareTo(rsvpPayment);
	}

	@Override
	public int hashCode() {
		return _rsvpPayment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.rsvp.model.RsvpPayment> toCacheModel() {
		return _rsvpPayment.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment toEscapedModel() {
		return new RsvpPaymentWrapper(_rsvpPayment.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment toUnescapedModel() {
		return new RsvpPaymentWrapper(_rsvpPayment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rsvpPayment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rsvpPayment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rsvpPayment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RsvpPaymentWrapper)) {
			return false;
		}

		RsvpPaymentWrapper rsvpPaymentWrapper = (RsvpPaymentWrapper)obj;

		if (Validator.equals(_rsvpPayment, rsvpPaymentWrapper._rsvpPayment)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _rsvpPayment.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RsvpPayment getWrappedRsvpPayment() {
		return _rsvpPayment;
	}

	@Override
	public RsvpPayment getWrappedModel() {
		return _rsvpPayment;
	}

	@Override
	public void resetOriginalValues() {
		_rsvpPayment.resetOriginalValues();
	}

	private RsvpPayment _rsvpPayment;
}