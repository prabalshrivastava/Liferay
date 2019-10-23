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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedGroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the RsvpPayment service. Represents a row in the &quot;SPRsvpPayment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpPayment
 * @see com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentImpl
 * @see com.sambaash.platform.srv.rsvp.model.impl.RsvpPaymentModelImpl
 * @generated
 */
public interface RsvpPaymentModel extends BaseModel<RsvpPayment>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a rsvp payment model instance should use the {@link RsvpPayment} interface instead.
	 */

	/**
	 * Returns the primary key of this rsvp payment.
	 *
	 * @return the primary key of this rsvp payment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this rsvp payment.
	 *
	 * @param primaryKey the primary key of this rsvp payment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this rsvp payment.
	 *
	 * @return the uuid of this rsvp payment
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this rsvp payment.
	 *
	 * @param uuid the uuid of this rsvp payment
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the rsvp payment ID of this rsvp payment.
	 *
	 * @return the rsvp payment ID of this rsvp payment
	 */
	public long getRsvpPaymentId();

	/**
	 * Sets the rsvp payment ID of this rsvp payment.
	 *
	 * @param rsvpPaymentId the rsvp payment ID of this rsvp payment
	 */
	public void setRsvpPaymentId(long rsvpPaymentId);

	/**
	 * Returns the group ID of this rsvp payment.
	 *
	 * @return the group ID of this rsvp payment
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this rsvp payment.
	 *
	 * @param groupId the group ID of this rsvp payment
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this rsvp payment.
	 *
	 * @return the company ID of this rsvp payment
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this rsvp payment.
	 *
	 * @param companyId the company ID of this rsvp payment
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this rsvp payment.
	 *
	 * @return the user ID of this rsvp payment
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this rsvp payment.
	 *
	 * @param userId the user ID of this rsvp payment
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this rsvp payment.
	 *
	 * @return the user uuid of this rsvp payment
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this rsvp payment.
	 *
	 * @param userUuid the user uuid of this rsvp payment
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this rsvp payment.
	 *
	 * @return the user name of this rsvp payment
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this rsvp payment.
	 *
	 * @param userName the user name of this rsvp payment
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this rsvp payment.
	 *
	 * @return the create date of this rsvp payment
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this rsvp payment.
	 *
	 * @param createDate the create date of this rsvp payment
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this rsvp payment.
	 *
	 * @return the modified date of this rsvp payment
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this rsvp payment.
	 *
	 * @param modifiedDate the modified date of this rsvp payment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the rsvp detail ID of this rsvp payment.
	 *
	 * @return the rsvp detail ID of this rsvp payment
	 */
	public long getRsvpDetailId();

	/**
	 * Sets the rsvp detail ID of this rsvp payment.
	 *
	 * @param rsvpDetailId the rsvp detail ID of this rsvp payment
	 */
	public void setRsvpDetailId(long rsvpDetailId);

	/**
	 * Returns the rsvp ID of this rsvp payment.
	 *
	 * @return the rsvp ID of this rsvp payment
	 */
	public long getRsvpId();

	/**
	 * Sets the rsvp ID of this rsvp payment.
	 *
	 * @param rsvpId the rsvp ID of this rsvp payment
	 */
	public void setRsvpId(long rsvpId);

	/**
	 * Returns the rsvp ticket ID of this rsvp payment.
	 *
	 * @return the rsvp ticket ID of this rsvp payment
	 */
	public long getRsvpTicketId();

	/**
	 * Sets the rsvp ticket ID of this rsvp payment.
	 *
	 * @param rsvpTicketId the rsvp ticket ID of this rsvp payment
	 */
	public void setRsvpTicketId(long rsvpTicketId);

	/**
	 * Returns the rsvp discount ID of this rsvp payment.
	 *
	 * @return the rsvp discount ID of this rsvp payment
	 */
	public long getRsvpDiscountId();

	/**
	 * Sets the rsvp discount ID of this rsvp payment.
	 *
	 * @param rsvpDiscountId the rsvp discount ID of this rsvp payment
	 */
	public void setRsvpDiscountId(long rsvpDiscountId);

	/**
	 * Returns the rsvp promo code ID of this rsvp payment.
	 *
	 * @return the rsvp promo code ID of this rsvp payment
	 */
	public long getRsvpPromoCodeId();

	/**
	 * Sets the rsvp promo code ID of this rsvp payment.
	 *
	 * @param rsvpPromoCodeId the rsvp promo code ID of this rsvp payment
	 */
	public void setRsvpPromoCodeId(long rsvpPromoCodeId);

	/**
	 * Returns the price of this rsvp payment.
	 *
	 * @return the price of this rsvp payment
	 */
	public double getPrice();

	/**
	 * Sets the price of this rsvp payment.
	 *
	 * @param price the price of this rsvp payment
	 */
	public void setPrice(double price);

	/**
	 * Returns the number of people of this rsvp payment.
	 *
	 * @return the number of people of this rsvp payment
	 */
	public int getNumberOfPeople();

	/**
	 * Sets the number of people of this rsvp payment.
	 *
	 * @param numberOfPeople the number of people of this rsvp payment
	 */
	public void setNumberOfPeople(int numberOfPeople);

	/**
	 * Returns the discount of this rsvp payment.
	 *
	 * @return the discount of this rsvp payment
	 */
	public int getDiscount();

	/**
	 * Sets the discount of this rsvp payment.
	 *
	 * @param discount the discount of this rsvp payment
	 */
	public void setDiscount(int discount);

	/**
	 * Returns the net total of this rsvp payment.
	 *
	 * @return the net total of this rsvp payment
	 */
	public double getNetTotal();

	/**
	 * Sets the net total of this rsvp payment.
	 *
	 * @param netTotal the net total of this rsvp payment
	 */
	public void setNetTotal(double netTotal);

	/**
	 * Returns the ticket number of this rsvp payment.
	 *
	 * @return the ticket number of this rsvp payment
	 */
	@AutoEscape
	public String getTicketNumber();

	/**
	 * Sets the ticket number of this rsvp payment.
	 *
	 * @param ticketNumber the ticket number of this rsvp payment
	 */
	public void setTicketNumber(String ticketNumber);

	/**
	 * Returns the payer email address of this rsvp payment.
	 *
	 * @return the payer email address of this rsvp payment
	 */
	@AutoEscape
	public String getPayerEmailAddress();

	/**
	 * Sets the payer email address of this rsvp payment.
	 *
	 * @param payerEmailAddress the payer email address of this rsvp payment
	 */
	public void setPayerEmailAddress(String payerEmailAddress);

	/**
	 * Returns the receiver email address of this rsvp payment.
	 *
	 * @return the receiver email address of this rsvp payment
	 */
	@AutoEscape
	public String getReceiverEmailAddress();

	/**
	 * Sets the receiver email address of this rsvp payment.
	 *
	 * @param receiverEmailAddress the receiver email address of this rsvp payment
	 */
	public void setReceiverEmailAddress(String receiverEmailAddress);

	/**
	 * Returns the transaction ID of this rsvp payment.
	 *
	 * @return the transaction ID of this rsvp payment
	 */
	@AutoEscape
	public String getTransactionId();

	/**
	 * Sets the transaction ID of this rsvp payment.
	 *
	 * @param transactionId the transaction ID of this rsvp payment
	 */
	public void setTransactionId(String transactionId);

	/**
	 * Returns the transaction status of this rsvp payment.
	 *
	 * @return the transaction status of this rsvp payment
	 */
	@AutoEscape
	public String getTransactionStatus();

	/**
	 * Sets the transaction status of this rsvp payment.
	 *
	 * @param transactionStatus the transaction status of this rsvp payment
	 */
	public void setTransactionStatus(String transactionStatus);

	/**
	 * Returns the transaction amount of this rsvp payment.
	 *
	 * @return the transaction amount of this rsvp payment
	 */
	public double getTransactionAmount();

	/**
	 * Sets the transaction amount of this rsvp payment.
	 *
	 * @param transactionAmount the transaction amount of this rsvp payment
	 */
	public void setTransactionAmount(double transactionAmount);

	/**
	 * Returns the transaction date of this rsvp payment.
	 *
	 * @return the transaction date of this rsvp payment
	 */
	public Date getTransactionDate();

	/**
	 * Sets the transaction date of this rsvp payment.
	 *
	 * @param transactionDate the transaction date of this rsvp payment
	 */
	public void setTransactionDate(Date transactionDate);

	/**
	 * Returns the email status of this rsvp payment.
	 *
	 * @return the email status of this rsvp payment
	 */
	public boolean getEmailStatus();

	/**
	 * Returns <code>true</code> if this rsvp payment is email status.
	 *
	 * @return <code>true</code> if this rsvp payment is email status; <code>false</code> otherwise
	 */
	public boolean isEmailStatus();

	/**
	 * Sets whether this rsvp payment is email status.
	 *
	 * @param emailStatus the email status of this rsvp payment
	 */
	public void setEmailStatus(boolean emailStatus);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.sambaash.platform.srv.rsvp.model.RsvpPayment rsvpPayment);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.rsvp.model.RsvpPayment> toCacheModel();

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment toEscapedModel();

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpPayment toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}