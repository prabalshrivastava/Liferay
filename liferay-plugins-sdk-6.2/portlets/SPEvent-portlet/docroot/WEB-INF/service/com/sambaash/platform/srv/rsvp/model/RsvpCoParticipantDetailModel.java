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
 * The base model interface for the RsvpCoParticipantDetail service. Represents a row in the &quot;SPRsvpCoParticipantDetail&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpCoParticipantDetail
 * @see com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailImpl
 * @see com.sambaash.platform.srv.rsvp.model.impl.RsvpCoParticipantDetailModelImpl
 * @generated
 */
public interface RsvpCoParticipantDetailModel extends BaseModel<RsvpCoParticipantDetail>,
	StagedGroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a rsvp co participant detail model instance should use the {@link RsvpCoParticipantDetail} interface instead.
	 */

	/**
	 * Returns the primary key of this rsvp co participant detail.
	 *
	 * @return the primary key of this rsvp co participant detail
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this rsvp co participant detail.
	 *
	 * @param primaryKey the primary key of this rsvp co participant detail
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this rsvp co participant detail.
	 *
	 * @return the uuid of this rsvp co participant detail
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this rsvp co participant detail.
	 *
	 * @param uuid the uuid of this rsvp co participant detail
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the rsvp co participant detail ID of this rsvp co participant detail.
	 *
	 * @return the rsvp co participant detail ID of this rsvp co participant detail
	 */
	public long getRsvpCoParticipantDetailId();

	/**
	 * Sets the rsvp co participant detail ID of this rsvp co participant detail.
	 *
	 * @param rsvpCoParticipantDetailId the rsvp co participant detail ID of this rsvp co participant detail
	 */
	public void setRsvpCoParticipantDetailId(long rsvpCoParticipantDetailId);

	/**
	 * Returns the group ID of this rsvp co participant detail.
	 *
	 * @return the group ID of this rsvp co participant detail
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this rsvp co participant detail.
	 *
	 * @param groupId the group ID of this rsvp co participant detail
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this rsvp co participant detail.
	 *
	 * @return the company ID of this rsvp co participant detail
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this rsvp co participant detail.
	 *
	 * @param companyId the company ID of this rsvp co participant detail
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user name of this rsvp co participant detail.
	 *
	 * @return the user name of this rsvp co participant detail
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this rsvp co participant detail.
	 *
	 * @param userName the user name of this rsvp co participant detail
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this rsvp co participant detail.
	 *
	 * @return the create date of this rsvp co participant detail
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this rsvp co participant detail.
	 *
	 * @param createDate the create date of this rsvp co participant detail
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this rsvp co participant detail.
	 *
	 * @return the modified date of this rsvp co participant detail
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this rsvp co participant detail.
	 *
	 * @param modifiedDate the modified date of this rsvp co participant detail
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the rsvp detail ID of this rsvp co participant detail.
	 *
	 * @return the rsvp detail ID of this rsvp co participant detail
	 */
	public long getRsvpDetailId();

	/**
	 * Sets the rsvp detail ID of this rsvp co participant detail.
	 *
	 * @param rsvpDetailId the rsvp detail ID of this rsvp co participant detail
	 */
	public void setRsvpDetailId(long rsvpDetailId);

	/**
	 * Returns the rsvp payment ID of this rsvp co participant detail.
	 *
	 * @return the rsvp payment ID of this rsvp co participant detail
	 */
	public long getRsvpPaymentId();

	/**
	 * Sets the rsvp payment ID of this rsvp co participant detail.
	 *
	 * @param rsvpPaymentId the rsvp payment ID of this rsvp co participant detail
	 */
	public void setRsvpPaymentId(long rsvpPaymentId);

	/**
	 * Returns the user ID of this rsvp co participant detail.
	 *
	 * @return the user ID of this rsvp co participant detail
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this rsvp co participant detail.
	 *
	 * @param userId the user ID of this rsvp co participant detail
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this rsvp co participant detail.
	 *
	 * @return the user uuid of this rsvp co participant detail
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this rsvp co participant detail.
	 *
	 * @param userUuid the user uuid of this rsvp co participant detail
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the first name of this rsvp co participant detail.
	 *
	 * @return the first name of this rsvp co participant detail
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this rsvp co participant detail.
	 *
	 * @param firstName the first name of this rsvp co participant detail
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this rsvp co participant detail.
	 *
	 * @return the last name of this rsvp co participant detail
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this rsvp co participant detail.
	 *
	 * @param lastName the last name of this rsvp co participant detail
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the nric of this rsvp co participant detail.
	 *
	 * @return the nric of this rsvp co participant detail
	 */
	@AutoEscape
	public String getNric();

	/**
	 * Sets the nric of this rsvp co participant detail.
	 *
	 * @param nric the nric of this rsvp co participant detail
	 */
	public void setNric(String nric);

	/**
	 * Returns the identification type of this rsvp co participant detail.
	 *
	 * @return the identification type of this rsvp co participant detail
	 */
	@AutoEscape
	public String getIdentificationType();

	/**
	 * Sets the identification type of this rsvp co participant detail.
	 *
	 * @param identificationType the identification type of this rsvp co participant detail
	 */
	public void setIdentificationType(String identificationType);

	/**
	 * Returns the email address of this rsvp co participant detail.
	 *
	 * @return the email address of this rsvp co participant detail
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this rsvp co participant detail.
	 *
	 * @param emailAddress the email address of this rsvp co participant detail
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the rsvp status of this rsvp co participant detail.
	 *
	 * @return the rsvp status of this rsvp co participant detail
	 */
	public int getRsvpStatus();

	/**
	 * Sets the rsvp status of this rsvp co participant detail.
	 *
	 * @param rsvpStatus the rsvp status of this rsvp co participant detail
	 */
	public void setRsvpStatus(int rsvpStatus);

	/**
	 * Returns the attendance of this rsvp co participant detail.
	 *
	 * @return the attendance of this rsvp co participant detail
	 */
	public int getAttendance();

	/**
	 * Sets the attendance of this rsvp co participant detail.
	 *
	 * @param attendance the attendance of this rsvp co participant detail
	 */
	public void setAttendance(int attendance);

	/**
	 * Returns the attendance by of this rsvp co participant detail.
	 *
	 * @return the attendance by of this rsvp co participant detail
	 */
	public long getAttendanceBy();

	/**
	 * Sets the attendance by of this rsvp co participant detail.
	 *
	 * @param attendanceBy the attendance by of this rsvp co participant detail
	 */
	public void setAttendanceBy(long attendanceBy);

	/**
	 * Returns the attendance date of this rsvp co participant detail.
	 *
	 * @return the attendance date of this rsvp co participant detail
	 */
	public Date getAttendanceDate();

	/**
	 * Sets the attendance date of this rsvp co participant detail.
	 *
	 * @param attendanceDate the attendance date of this rsvp co participant detail
	 */
	public void setAttendanceDate(Date attendanceDate);

	/**
	 * Returns the ticket number of this rsvp co participant detail.
	 *
	 * @return the ticket number of this rsvp co participant detail
	 */
	@AutoEscape
	public String getTicketNumber();

	/**
	 * Sets the ticket number of this rsvp co participant detail.
	 *
	 * @param ticketNumber the ticket number of this rsvp co participant detail
	 */
	public void setTicketNumber(String ticketNumber);

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
		com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail rsvpCoParticipantDetail);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> toCacheModel();

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail toEscapedModel();

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}