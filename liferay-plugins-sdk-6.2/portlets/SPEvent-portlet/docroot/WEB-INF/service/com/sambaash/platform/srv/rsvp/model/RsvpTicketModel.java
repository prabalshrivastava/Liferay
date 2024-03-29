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
 * The base model interface for the RsvpTicket service. Represents a row in the &quot;SPRsvpTicket&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpTicket
 * @see com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketImpl
 * @see com.sambaash.platform.srv.rsvp.model.impl.RsvpTicketModelImpl
 * @generated
 */
public interface RsvpTicketModel extends BaseModel<RsvpTicket>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a rsvp ticket model instance should use the {@link RsvpTicket} interface instead.
	 */

	/**
	 * Returns the primary key of this rsvp ticket.
	 *
	 * @return the primary key of this rsvp ticket
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this rsvp ticket.
	 *
	 * @param primaryKey the primary key of this rsvp ticket
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this rsvp ticket.
	 *
	 * @return the uuid of this rsvp ticket
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this rsvp ticket.
	 *
	 * @param uuid the uuid of this rsvp ticket
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the rsvp ticket ID of this rsvp ticket.
	 *
	 * @return the rsvp ticket ID of this rsvp ticket
	 */
	public long getRsvpTicketId();

	/**
	 * Sets the rsvp ticket ID of this rsvp ticket.
	 *
	 * @param rsvpTicketId the rsvp ticket ID of this rsvp ticket
	 */
	public void setRsvpTicketId(long rsvpTicketId);

	/**
	 * Returns the group ID of this rsvp ticket.
	 *
	 * @return the group ID of this rsvp ticket
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this rsvp ticket.
	 *
	 * @param groupId the group ID of this rsvp ticket
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this rsvp ticket.
	 *
	 * @return the company ID of this rsvp ticket
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this rsvp ticket.
	 *
	 * @param companyId the company ID of this rsvp ticket
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this rsvp ticket.
	 *
	 * @return the user ID of this rsvp ticket
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this rsvp ticket.
	 *
	 * @param userId the user ID of this rsvp ticket
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this rsvp ticket.
	 *
	 * @return the user uuid of this rsvp ticket
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this rsvp ticket.
	 *
	 * @param userUuid the user uuid of this rsvp ticket
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this rsvp ticket.
	 *
	 * @return the user name of this rsvp ticket
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this rsvp ticket.
	 *
	 * @param userName the user name of this rsvp ticket
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this rsvp ticket.
	 *
	 * @return the create date of this rsvp ticket
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this rsvp ticket.
	 *
	 * @param createDate the create date of this rsvp ticket
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this rsvp ticket.
	 *
	 * @return the modified date of this rsvp ticket
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this rsvp ticket.
	 *
	 * @param modifiedDate the modified date of this rsvp ticket
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the rsvp ID of this rsvp ticket.
	 *
	 * @return the rsvp ID of this rsvp ticket
	 */
	public long getRsvpId();

	/**
	 * Sets the rsvp ID of this rsvp ticket.
	 *
	 * @param rsvpId the rsvp ID of this rsvp ticket
	 */
	public void setRsvpId(long rsvpId);

	/**
	 * Returns the price of this rsvp ticket.
	 *
	 * @return the price of this rsvp ticket
	 */
	public double getPrice();

	/**
	 * Sets the price of this rsvp ticket.
	 *
	 * @param price the price of this rsvp ticket
	 */
	public void setPrice(double price);

	/**
	 * Returns the quantity of this rsvp ticket.
	 *
	 * @return the quantity of this rsvp ticket
	 */
	public int getQuantity();

	/**
	 * Sets the quantity of this rsvp ticket.
	 *
	 * @param quantity the quantity of this rsvp ticket
	 */
	public void setQuantity(int quantity);

	/**
	 * Returns the sold quantity of this rsvp ticket.
	 *
	 * @return the sold quantity of this rsvp ticket
	 */
	public int getSoldQuantity();

	/**
	 * Sets the sold quantity of this rsvp ticket.
	 *
	 * @param soldQuantity the sold quantity of this rsvp ticket
	 */
	public void setSoldQuantity(int soldQuantity);

	/**
	 * Returns the ticket sequence of this rsvp ticket.
	 *
	 * @return the ticket sequence of this rsvp ticket
	 */
	public int getTicketSequence();

	/**
	 * Sets the ticket sequence of this rsvp ticket.
	 *
	 * @param ticketSequence the ticket sequence of this rsvp ticket
	 */
	public void setTicketSequence(int ticketSequence);

	/**
	 * Returns the last sequence number of this rsvp ticket.
	 *
	 * @return the last sequence number of this rsvp ticket
	 */
	public int getLastSequenceNumber();

	/**
	 * Sets the last sequence number of this rsvp ticket.
	 *
	 * @param lastSequenceNumber the last sequence number of this rsvp ticket
	 */
	public void setLastSequenceNumber(int lastSequenceNumber);

	/**
	 * Returns the sequence prefix of this rsvp ticket.
	 *
	 * @return the sequence prefix of this rsvp ticket
	 */
	@AutoEscape
	public String getSequencePrefix();

	/**
	 * Sets the sequence prefix of this rsvp ticket.
	 *
	 * @param sequencePrefix the sequence prefix of this rsvp ticket
	 */
	public void setSequencePrefix(String sequencePrefix);

	/**
	 * Returns the sequence suffix of this rsvp ticket.
	 *
	 * @return the sequence suffix of this rsvp ticket
	 */
	@AutoEscape
	public String getSequenceSuffix();

	/**
	 * Sets the sequence suffix of this rsvp ticket.
	 *
	 * @param sequenceSuffix the sequence suffix of this rsvp ticket
	 */
	public void setSequenceSuffix(String sequenceSuffix);

	/**
	 * Returns the ticket template url of this rsvp ticket.
	 *
	 * @return the ticket template url of this rsvp ticket
	 */
	@AutoEscape
	public String getTicketTemplateUrl();

	/**
	 * Sets the ticket template url of this rsvp ticket.
	 *
	 * @param ticketTemplateUrl the ticket template url of this rsvp ticket
	 */
	public void setTicketTemplateUrl(String ticketTemplateUrl);

	/**
	 * Returns the modified by of this rsvp ticket.
	 *
	 * @return the modified by of this rsvp ticket
	 */
	public long getModifiedBy();

	/**
	 * Sets the modified by of this rsvp ticket.
	 *
	 * @param modifiedBy the modified by of this rsvp ticket
	 */
	public void setModifiedBy(long modifiedBy);

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
		com.sambaash.platform.srv.rsvp.model.RsvpTicket rsvpTicket);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.rsvp.model.RsvpTicket> toCacheModel();

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket toEscapedModel();

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpTicket toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}