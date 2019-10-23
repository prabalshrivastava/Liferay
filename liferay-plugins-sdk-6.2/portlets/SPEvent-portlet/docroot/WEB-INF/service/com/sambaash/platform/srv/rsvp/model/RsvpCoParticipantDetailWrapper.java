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
 * This class is a wrapper for {@link RsvpCoParticipantDetail}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpCoParticipantDetail
 * @generated
 */
public class RsvpCoParticipantDetailWrapper implements RsvpCoParticipantDetail,
	ModelWrapper<RsvpCoParticipantDetail> {
	public RsvpCoParticipantDetailWrapper(
		RsvpCoParticipantDetail rsvpCoParticipantDetail) {
		_rsvpCoParticipantDetail = rsvpCoParticipantDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpCoParticipantDetail.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpCoParticipantDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpCoParticipantDetailId",
			getRsvpCoParticipantDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpDetailId", getRsvpDetailId());
		attributes.put("rsvpPaymentId", getRsvpPaymentId());
		attributes.put("userId", getUserId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("nric", getNric());
		attributes.put("identificationType", getIdentificationType());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("rsvpStatus", getRsvpStatus());
		attributes.put("attendance", getAttendance());
		attributes.put("attendanceBy", getAttendanceBy());
		attributes.put("attendanceDate", getAttendanceDate());
		attributes.put("ticketNumber", getTicketNumber());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpCoParticipantDetailId = (Long)attributes.get(
				"rsvpCoParticipantDetailId");

		if (rsvpCoParticipantDetailId != null) {
			setRsvpCoParticipantDetailId(rsvpCoParticipantDetailId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
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

		Long rsvpPaymentId = (Long)attributes.get("rsvpPaymentId");

		if (rsvpPaymentId != null) {
			setRsvpPaymentId(rsvpPaymentId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String nric = (String)attributes.get("nric");

		if (nric != null) {
			setNric(nric);
		}

		String identificationType = (String)attributes.get("identificationType");

		if (identificationType != null) {
			setIdentificationType(identificationType);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Integer rsvpStatus = (Integer)attributes.get("rsvpStatus");

		if (rsvpStatus != null) {
			setRsvpStatus(rsvpStatus);
		}

		Integer attendance = (Integer)attributes.get("attendance");

		if (attendance != null) {
			setAttendance(attendance);
		}

		Long attendanceBy = (Long)attributes.get("attendanceBy");

		if (attendanceBy != null) {
			setAttendanceBy(attendanceBy);
		}

		Date attendanceDate = (Date)attributes.get("attendanceDate");

		if (attendanceDate != null) {
			setAttendanceDate(attendanceDate);
		}

		String ticketNumber = (String)attributes.get("ticketNumber");

		if (ticketNumber != null) {
			setTicketNumber(ticketNumber);
		}
	}

	/**
	* Returns the primary key of this rsvp co participant detail.
	*
	* @return the primary key of this rsvp co participant detail
	*/
	@Override
	public long getPrimaryKey() {
		return _rsvpCoParticipantDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rsvp co participant detail.
	*
	* @param primaryKey the primary key of this rsvp co participant detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rsvpCoParticipantDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rsvp co participant detail.
	*
	* @return the uuid of this rsvp co participant detail
	*/
	@Override
	public java.lang.String getUuid() {
		return _rsvpCoParticipantDetail.getUuid();
	}

	/**
	* Sets the uuid of this rsvp co participant detail.
	*
	* @param uuid the uuid of this rsvp co participant detail
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rsvpCoParticipantDetail.setUuid(uuid);
	}

	/**
	* Returns the rsvp co participant detail ID of this rsvp co participant detail.
	*
	* @return the rsvp co participant detail ID of this rsvp co participant detail
	*/
	@Override
	public long getRsvpCoParticipantDetailId() {
		return _rsvpCoParticipantDetail.getRsvpCoParticipantDetailId();
	}

	/**
	* Sets the rsvp co participant detail ID of this rsvp co participant detail.
	*
	* @param rsvpCoParticipantDetailId the rsvp co participant detail ID of this rsvp co participant detail
	*/
	@Override
	public void setRsvpCoParticipantDetailId(long rsvpCoParticipantDetailId) {
		_rsvpCoParticipantDetail.setRsvpCoParticipantDetailId(rsvpCoParticipantDetailId);
	}

	/**
	* Returns the group ID of this rsvp co participant detail.
	*
	* @return the group ID of this rsvp co participant detail
	*/
	@Override
	public long getGroupId() {
		return _rsvpCoParticipantDetail.getGroupId();
	}

	/**
	* Sets the group ID of this rsvp co participant detail.
	*
	* @param groupId the group ID of this rsvp co participant detail
	*/
	@Override
	public void setGroupId(long groupId) {
		_rsvpCoParticipantDetail.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rsvp co participant detail.
	*
	* @return the company ID of this rsvp co participant detail
	*/
	@Override
	public long getCompanyId() {
		return _rsvpCoParticipantDetail.getCompanyId();
	}

	/**
	* Sets the company ID of this rsvp co participant detail.
	*
	* @param companyId the company ID of this rsvp co participant detail
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rsvpCoParticipantDetail.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this rsvp co participant detail.
	*
	* @return the user name of this rsvp co participant detail
	*/
	@Override
	public java.lang.String getUserName() {
		return _rsvpCoParticipantDetail.getUserName();
	}

	/**
	* Sets the user name of this rsvp co participant detail.
	*
	* @param userName the user name of this rsvp co participant detail
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rsvpCoParticipantDetail.setUserName(userName);
	}

	/**
	* Returns the create date of this rsvp co participant detail.
	*
	* @return the create date of this rsvp co participant detail
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rsvpCoParticipantDetail.getCreateDate();
	}

	/**
	* Sets the create date of this rsvp co participant detail.
	*
	* @param createDate the create date of this rsvp co participant detail
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rsvpCoParticipantDetail.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rsvp co participant detail.
	*
	* @return the modified date of this rsvp co participant detail
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rsvpCoParticipantDetail.getModifiedDate();
	}

	/**
	* Sets the modified date of this rsvp co participant detail.
	*
	* @param modifiedDate the modified date of this rsvp co participant detail
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rsvpCoParticipantDetail.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the rsvp detail ID of this rsvp co participant detail.
	*
	* @return the rsvp detail ID of this rsvp co participant detail
	*/
	@Override
	public long getRsvpDetailId() {
		return _rsvpCoParticipantDetail.getRsvpDetailId();
	}

	/**
	* Sets the rsvp detail ID of this rsvp co participant detail.
	*
	* @param rsvpDetailId the rsvp detail ID of this rsvp co participant detail
	*/
	@Override
	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpCoParticipantDetail.setRsvpDetailId(rsvpDetailId);
	}

	/**
	* Returns the rsvp payment ID of this rsvp co participant detail.
	*
	* @return the rsvp payment ID of this rsvp co participant detail
	*/
	@Override
	public long getRsvpPaymentId() {
		return _rsvpCoParticipantDetail.getRsvpPaymentId();
	}

	/**
	* Sets the rsvp payment ID of this rsvp co participant detail.
	*
	* @param rsvpPaymentId the rsvp payment ID of this rsvp co participant detail
	*/
	@Override
	public void setRsvpPaymentId(long rsvpPaymentId) {
		_rsvpCoParticipantDetail.setRsvpPaymentId(rsvpPaymentId);
	}

	/**
	* Returns the user ID of this rsvp co participant detail.
	*
	* @return the user ID of this rsvp co participant detail
	*/
	@Override
	public long getUserId() {
		return _rsvpCoParticipantDetail.getUserId();
	}

	/**
	* Sets the user ID of this rsvp co participant detail.
	*
	* @param userId the user ID of this rsvp co participant detail
	*/
	@Override
	public void setUserId(long userId) {
		_rsvpCoParticipantDetail.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rsvp co participant detail.
	*
	* @return the user uuid of this rsvp co participant detail
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpCoParticipantDetail.getUserUuid();
	}

	/**
	* Sets the user uuid of this rsvp co participant detail.
	*
	* @param userUuid the user uuid of this rsvp co participant detail
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rsvpCoParticipantDetail.setUserUuid(userUuid);
	}

	/**
	* Returns the first name of this rsvp co participant detail.
	*
	* @return the first name of this rsvp co participant detail
	*/
	@Override
	public java.lang.String getFirstName() {
		return _rsvpCoParticipantDetail.getFirstName();
	}

	/**
	* Sets the first name of this rsvp co participant detail.
	*
	* @param firstName the first name of this rsvp co participant detail
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_rsvpCoParticipantDetail.setFirstName(firstName);
	}

	/**
	* Returns the last name of this rsvp co participant detail.
	*
	* @return the last name of this rsvp co participant detail
	*/
	@Override
	public java.lang.String getLastName() {
		return _rsvpCoParticipantDetail.getLastName();
	}

	/**
	* Sets the last name of this rsvp co participant detail.
	*
	* @param lastName the last name of this rsvp co participant detail
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_rsvpCoParticipantDetail.setLastName(lastName);
	}

	/**
	* Returns the nric of this rsvp co participant detail.
	*
	* @return the nric of this rsvp co participant detail
	*/
	@Override
	public java.lang.String getNric() {
		return _rsvpCoParticipantDetail.getNric();
	}

	/**
	* Sets the nric of this rsvp co participant detail.
	*
	* @param nric the nric of this rsvp co participant detail
	*/
	@Override
	public void setNric(java.lang.String nric) {
		_rsvpCoParticipantDetail.setNric(nric);
	}

	/**
	* Returns the identification type of this rsvp co participant detail.
	*
	* @return the identification type of this rsvp co participant detail
	*/
	@Override
	public java.lang.String getIdentificationType() {
		return _rsvpCoParticipantDetail.getIdentificationType();
	}

	/**
	* Sets the identification type of this rsvp co participant detail.
	*
	* @param identificationType the identification type of this rsvp co participant detail
	*/
	@Override
	public void setIdentificationType(java.lang.String identificationType) {
		_rsvpCoParticipantDetail.setIdentificationType(identificationType);
	}

	/**
	* Returns the email address of this rsvp co participant detail.
	*
	* @return the email address of this rsvp co participant detail
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _rsvpCoParticipantDetail.getEmailAddress();
	}

	/**
	* Sets the email address of this rsvp co participant detail.
	*
	* @param emailAddress the email address of this rsvp co participant detail
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_rsvpCoParticipantDetail.setEmailAddress(emailAddress);
	}

	/**
	* Returns the rsvp status of this rsvp co participant detail.
	*
	* @return the rsvp status of this rsvp co participant detail
	*/
	@Override
	public int getRsvpStatus() {
		return _rsvpCoParticipantDetail.getRsvpStatus();
	}

	/**
	* Sets the rsvp status of this rsvp co participant detail.
	*
	* @param rsvpStatus the rsvp status of this rsvp co participant detail
	*/
	@Override
	public void setRsvpStatus(int rsvpStatus) {
		_rsvpCoParticipantDetail.setRsvpStatus(rsvpStatus);
	}

	/**
	* Returns the attendance of this rsvp co participant detail.
	*
	* @return the attendance of this rsvp co participant detail
	*/
	@Override
	public int getAttendance() {
		return _rsvpCoParticipantDetail.getAttendance();
	}

	/**
	* Sets the attendance of this rsvp co participant detail.
	*
	* @param attendance the attendance of this rsvp co participant detail
	*/
	@Override
	public void setAttendance(int attendance) {
		_rsvpCoParticipantDetail.setAttendance(attendance);
	}

	/**
	* Returns the attendance by of this rsvp co participant detail.
	*
	* @return the attendance by of this rsvp co participant detail
	*/
	@Override
	public long getAttendanceBy() {
		return _rsvpCoParticipantDetail.getAttendanceBy();
	}

	/**
	* Sets the attendance by of this rsvp co participant detail.
	*
	* @param attendanceBy the attendance by of this rsvp co participant detail
	*/
	@Override
	public void setAttendanceBy(long attendanceBy) {
		_rsvpCoParticipantDetail.setAttendanceBy(attendanceBy);
	}

	/**
	* Returns the attendance date of this rsvp co participant detail.
	*
	* @return the attendance date of this rsvp co participant detail
	*/
	@Override
	public java.util.Date getAttendanceDate() {
		return _rsvpCoParticipantDetail.getAttendanceDate();
	}

	/**
	* Sets the attendance date of this rsvp co participant detail.
	*
	* @param attendanceDate the attendance date of this rsvp co participant detail
	*/
	@Override
	public void setAttendanceDate(java.util.Date attendanceDate) {
		_rsvpCoParticipantDetail.setAttendanceDate(attendanceDate);
	}

	/**
	* Returns the ticket number of this rsvp co participant detail.
	*
	* @return the ticket number of this rsvp co participant detail
	*/
	@Override
	public java.lang.String getTicketNumber() {
		return _rsvpCoParticipantDetail.getTicketNumber();
	}

	/**
	* Sets the ticket number of this rsvp co participant detail.
	*
	* @param ticketNumber the ticket number of this rsvp co participant detail
	*/
	@Override
	public void setTicketNumber(java.lang.String ticketNumber) {
		_rsvpCoParticipantDetail.setTicketNumber(ticketNumber);
	}

	@Override
	public boolean isNew() {
		return _rsvpCoParticipantDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rsvpCoParticipantDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rsvpCoParticipantDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rsvpCoParticipantDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rsvpCoParticipantDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rsvpCoParticipantDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rsvpCoParticipantDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rsvpCoParticipantDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rsvpCoParticipantDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rsvpCoParticipantDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rsvpCoParticipantDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RsvpCoParticipantDetailWrapper((RsvpCoParticipantDetail)_rsvpCoParticipantDetail.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail rsvpCoParticipantDetail) {
		return _rsvpCoParticipantDetail.compareTo(rsvpCoParticipantDetail);
	}

	@Override
	public int hashCode() {
		return _rsvpCoParticipantDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail> toCacheModel() {
		return _rsvpCoParticipantDetail.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail toEscapedModel() {
		return new RsvpCoParticipantDetailWrapper(_rsvpCoParticipantDetail.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpCoParticipantDetail toUnescapedModel() {
		return new RsvpCoParticipantDetailWrapper(_rsvpCoParticipantDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rsvpCoParticipantDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rsvpCoParticipantDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rsvpCoParticipantDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RsvpCoParticipantDetailWrapper)) {
			return false;
		}

		RsvpCoParticipantDetailWrapper rsvpCoParticipantDetailWrapper = (RsvpCoParticipantDetailWrapper)obj;

		if (Validator.equals(_rsvpCoParticipantDetail,
					rsvpCoParticipantDetailWrapper._rsvpCoParticipantDetail)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _rsvpCoParticipantDetail.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RsvpCoParticipantDetail getWrappedRsvpCoParticipantDetail() {
		return _rsvpCoParticipantDetail;
	}

	@Override
	public RsvpCoParticipantDetail getWrappedModel() {
		return _rsvpCoParticipantDetail;
	}

	@Override
	public void resetOriginalValues() {
		_rsvpCoParticipantDetail.resetOriginalValues();
	}

	private RsvpCoParticipantDetail _rsvpCoParticipantDetail;
}