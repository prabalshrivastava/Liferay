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
 * This class is a wrapper for {@link RsvpTicket}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpTicket
 * @generated
 */
public class RsvpTicketWrapper implements RsvpTicket, ModelWrapper<RsvpTicket> {
	public RsvpTicketWrapper(RsvpTicket rsvpTicket) {
		_rsvpTicket = rsvpTicket;
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpTicket.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpTicket.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpTicketId", getRsvpTicketId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("price", getPrice());
		attributes.put("quantity", getQuantity());
		attributes.put("soldQuantity", getSoldQuantity());
		attributes.put("ticketSequence", getTicketSequence());
		attributes.put("lastSequenceNumber", getLastSequenceNumber());
		attributes.put("sequencePrefix", getSequencePrefix());
		attributes.put("sequenceSuffix", getSequenceSuffix());
		attributes.put("ticketTemplateUrl", getTicketTemplateUrl());
		attributes.put("modifiedBy", getModifiedBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpTicketId = (Long)attributes.get("rsvpTicketId");

		if (rsvpTicketId != null) {
			setRsvpTicketId(rsvpTicketId);
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

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
		}

		Double price = (Double)attributes.get("price");

		if (price != null) {
			setPrice(price);
		}

		Integer quantity = (Integer)attributes.get("quantity");

		if (quantity != null) {
			setQuantity(quantity);
		}

		Integer soldQuantity = (Integer)attributes.get("soldQuantity");

		if (soldQuantity != null) {
			setSoldQuantity(soldQuantity);
		}

		Integer ticketSequence = (Integer)attributes.get("ticketSequence");

		if (ticketSequence != null) {
			setTicketSequence(ticketSequence);
		}

		Integer lastSequenceNumber = (Integer)attributes.get(
				"lastSequenceNumber");

		if (lastSequenceNumber != null) {
			setLastSequenceNumber(lastSequenceNumber);
		}

		String sequencePrefix = (String)attributes.get("sequencePrefix");

		if (sequencePrefix != null) {
			setSequencePrefix(sequencePrefix);
		}

		String sequenceSuffix = (String)attributes.get("sequenceSuffix");

		if (sequenceSuffix != null) {
			setSequenceSuffix(sequenceSuffix);
		}

		String ticketTemplateUrl = (String)attributes.get("ticketTemplateUrl");

		if (ticketTemplateUrl != null) {
			setTicketTemplateUrl(ticketTemplateUrl);
		}

		Long modifiedBy = (Long)attributes.get("modifiedBy");

		if (modifiedBy != null) {
			setModifiedBy(modifiedBy);
		}
	}

	/**
	* Returns the primary key of this rsvp ticket.
	*
	* @return the primary key of this rsvp ticket
	*/
	@Override
	public long getPrimaryKey() {
		return _rsvpTicket.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rsvp ticket.
	*
	* @param primaryKey the primary key of this rsvp ticket
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rsvpTicket.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rsvp ticket.
	*
	* @return the uuid of this rsvp ticket
	*/
	@Override
	public java.lang.String getUuid() {
		return _rsvpTicket.getUuid();
	}

	/**
	* Sets the uuid of this rsvp ticket.
	*
	* @param uuid the uuid of this rsvp ticket
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rsvpTicket.setUuid(uuid);
	}

	/**
	* Returns the rsvp ticket ID of this rsvp ticket.
	*
	* @return the rsvp ticket ID of this rsvp ticket
	*/
	@Override
	public long getRsvpTicketId() {
		return _rsvpTicket.getRsvpTicketId();
	}

	/**
	* Sets the rsvp ticket ID of this rsvp ticket.
	*
	* @param rsvpTicketId the rsvp ticket ID of this rsvp ticket
	*/
	@Override
	public void setRsvpTicketId(long rsvpTicketId) {
		_rsvpTicket.setRsvpTicketId(rsvpTicketId);
	}

	/**
	* Returns the group ID of this rsvp ticket.
	*
	* @return the group ID of this rsvp ticket
	*/
	@Override
	public long getGroupId() {
		return _rsvpTicket.getGroupId();
	}

	/**
	* Sets the group ID of this rsvp ticket.
	*
	* @param groupId the group ID of this rsvp ticket
	*/
	@Override
	public void setGroupId(long groupId) {
		_rsvpTicket.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rsvp ticket.
	*
	* @return the company ID of this rsvp ticket
	*/
	@Override
	public long getCompanyId() {
		return _rsvpTicket.getCompanyId();
	}

	/**
	* Sets the company ID of this rsvp ticket.
	*
	* @param companyId the company ID of this rsvp ticket
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rsvpTicket.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this rsvp ticket.
	*
	* @return the user ID of this rsvp ticket
	*/
	@Override
	public long getUserId() {
		return _rsvpTicket.getUserId();
	}

	/**
	* Sets the user ID of this rsvp ticket.
	*
	* @param userId the user ID of this rsvp ticket
	*/
	@Override
	public void setUserId(long userId) {
		_rsvpTicket.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rsvp ticket.
	*
	* @return the user uuid of this rsvp ticket
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpTicket.getUserUuid();
	}

	/**
	* Sets the user uuid of this rsvp ticket.
	*
	* @param userUuid the user uuid of this rsvp ticket
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rsvpTicket.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this rsvp ticket.
	*
	* @return the user name of this rsvp ticket
	*/
	@Override
	public java.lang.String getUserName() {
		return _rsvpTicket.getUserName();
	}

	/**
	* Sets the user name of this rsvp ticket.
	*
	* @param userName the user name of this rsvp ticket
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rsvpTicket.setUserName(userName);
	}

	/**
	* Returns the create date of this rsvp ticket.
	*
	* @return the create date of this rsvp ticket
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rsvpTicket.getCreateDate();
	}

	/**
	* Sets the create date of this rsvp ticket.
	*
	* @param createDate the create date of this rsvp ticket
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rsvpTicket.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rsvp ticket.
	*
	* @return the modified date of this rsvp ticket
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rsvpTicket.getModifiedDate();
	}

	/**
	* Sets the modified date of this rsvp ticket.
	*
	* @param modifiedDate the modified date of this rsvp ticket
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rsvpTicket.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the rsvp ID of this rsvp ticket.
	*
	* @return the rsvp ID of this rsvp ticket
	*/
	@Override
	public long getRsvpId() {
		return _rsvpTicket.getRsvpId();
	}

	/**
	* Sets the rsvp ID of this rsvp ticket.
	*
	* @param rsvpId the rsvp ID of this rsvp ticket
	*/
	@Override
	public void setRsvpId(long rsvpId) {
		_rsvpTicket.setRsvpId(rsvpId);
	}

	/**
	* Returns the price of this rsvp ticket.
	*
	* @return the price of this rsvp ticket
	*/
	@Override
	public double getPrice() {
		return _rsvpTicket.getPrice();
	}

	/**
	* Sets the price of this rsvp ticket.
	*
	* @param price the price of this rsvp ticket
	*/
	@Override
	public void setPrice(double price) {
		_rsvpTicket.setPrice(price);
	}

	/**
	* Returns the quantity of this rsvp ticket.
	*
	* @return the quantity of this rsvp ticket
	*/
	@Override
	public int getQuantity() {
		return _rsvpTicket.getQuantity();
	}

	/**
	* Sets the quantity of this rsvp ticket.
	*
	* @param quantity the quantity of this rsvp ticket
	*/
	@Override
	public void setQuantity(int quantity) {
		_rsvpTicket.setQuantity(quantity);
	}

	/**
	* Returns the sold quantity of this rsvp ticket.
	*
	* @return the sold quantity of this rsvp ticket
	*/
	@Override
	public int getSoldQuantity() {
		return _rsvpTicket.getSoldQuantity();
	}

	/**
	* Sets the sold quantity of this rsvp ticket.
	*
	* @param soldQuantity the sold quantity of this rsvp ticket
	*/
	@Override
	public void setSoldQuantity(int soldQuantity) {
		_rsvpTicket.setSoldQuantity(soldQuantity);
	}

	/**
	* Returns the ticket sequence of this rsvp ticket.
	*
	* @return the ticket sequence of this rsvp ticket
	*/
	@Override
	public int getTicketSequence() {
		return _rsvpTicket.getTicketSequence();
	}

	/**
	* Sets the ticket sequence of this rsvp ticket.
	*
	* @param ticketSequence the ticket sequence of this rsvp ticket
	*/
	@Override
	public void setTicketSequence(int ticketSequence) {
		_rsvpTicket.setTicketSequence(ticketSequence);
	}

	/**
	* Returns the last sequence number of this rsvp ticket.
	*
	* @return the last sequence number of this rsvp ticket
	*/
	@Override
	public int getLastSequenceNumber() {
		return _rsvpTicket.getLastSequenceNumber();
	}

	/**
	* Sets the last sequence number of this rsvp ticket.
	*
	* @param lastSequenceNumber the last sequence number of this rsvp ticket
	*/
	@Override
	public void setLastSequenceNumber(int lastSequenceNumber) {
		_rsvpTicket.setLastSequenceNumber(lastSequenceNumber);
	}

	/**
	* Returns the sequence prefix of this rsvp ticket.
	*
	* @return the sequence prefix of this rsvp ticket
	*/
	@Override
	public java.lang.String getSequencePrefix() {
		return _rsvpTicket.getSequencePrefix();
	}

	/**
	* Sets the sequence prefix of this rsvp ticket.
	*
	* @param sequencePrefix the sequence prefix of this rsvp ticket
	*/
	@Override
	public void setSequencePrefix(java.lang.String sequencePrefix) {
		_rsvpTicket.setSequencePrefix(sequencePrefix);
	}

	/**
	* Returns the sequence suffix of this rsvp ticket.
	*
	* @return the sequence suffix of this rsvp ticket
	*/
	@Override
	public java.lang.String getSequenceSuffix() {
		return _rsvpTicket.getSequenceSuffix();
	}

	/**
	* Sets the sequence suffix of this rsvp ticket.
	*
	* @param sequenceSuffix the sequence suffix of this rsvp ticket
	*/
	@Override
	public void setSequenceSuffix(java.lang.String sequenceSuffix) {
		_rsvpTicket.setSequenceSuffix(sequenceSuffix);
	}

	/**
	* Returns the ticket template url of this rsvp ticket.
	*
	* @return the ticket template url of this rsvp ticket
	*/
	@Override
	public java.lang.String getTicketTemplateUrl() {
		return _rsvpTicket.getTicketTemplateUrl();
	}

	/**
	* Sets the ticket template url of this rsvp ticket.
	*
	* @param ticketTemplateUrl the ticket template url of this rsvp ticket
	*/
	@Override
	public void setTicketTemplateUrl(java.lang.String ticketTemplateUrl) {
		_rsvpTicket.setTicketTemplateUrl(ticketTemplateUrl);
	}

	/**
	* Returns the modified by of this rsvp ticket.
	*
	* @return the modified by of this rsvp ticket
	*/
	@Override
	public long getModifiedBy() {
		return _rsvpTicket.getModifiedBy();
	}

	/**
	* Sets the modified by of this rsvp ticket.
	*
	* @param modifiedBy the modified by of this rsvp ticket
	*/
	@Override
	public void setModifiedBy(long modifiedBy) {
		_rsvpTicket.setModifiedBy(modifiedBy);
	}

	@Override
	public boolean isNew() {
		return _rsvpTicket.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rsvpTicket.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rsvpTicket.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rsvpTicket.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rsvpTicket.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rsvpTicket.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rsvpTicket.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rsvpTicket.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rsvpTicket.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rsvpTicket.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rsvpTicket.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RsvpTicketWrapper((RsvpTicket)_rsvpTicket.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.rsvp.model.RsvpTicket rsvpTicket) {
		return _rsvpTicket.compareTo(rsvpTicket);
	}

	@Override
	public int hashCode() {
		return _rsvpTicket.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.rsvp.model.RsvpTicket> toCacheModel() {
		return _rsvpTicket.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket toEscapedModel() {
		return new RsvpTicketWrapper(_rsvpTicket.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket toUnescapedModel() {
		return new RsvpTicketWrapper(_rsvpTicket.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rsvpTicket.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rsvpTicket.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rsvpTicket.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RsvpTicketWrapper)) {
			return false;
		}

		RsvpTicketWrapper rsvpTicketWrapper = (RsvpTicketWrapper)obj;

		if (Validator.equals(_rsvpTicket, rsvpTicketWrapper._rsvpTicket)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _rsvpTicket.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RsvpTicket getWrappedRsvpTicket() {
		return _rsvpTicket;
	}

	@Override
	public RsvpTicket getWrappedModel() {
		return _rsvpTicket;
	}

	@Override
	public void resetOriginalValues() {
		_rsvpTicket.resetOriginalValues();
	}

	private RsvpTicket _rsvpTicket;
}