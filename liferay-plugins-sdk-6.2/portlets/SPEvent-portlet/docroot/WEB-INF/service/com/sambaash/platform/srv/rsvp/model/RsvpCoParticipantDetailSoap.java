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
public class RsvpCoParticipantDetailSoap implements Serializable {
	public static RsvpCoParticipantDetailSoap toSoapModel(
		RsvpCoParticipantDetail model) {
		RsvpCoParticipantDetailSoap soapModel = new RsvpCoParticipantDetailSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRsvpCoParticipantDetailId(model.getRsvpCoParticipantDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRsvpDetailId(model.getRsvpDetailId());
		soapModel.setRsvpPaymentId(model.getRsvpPaymentId());
		soapModel.setUserId(model.getUserId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setNric(model.getNric());
		soapModel.setIdentificationType(model.getIdentificationType());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setRsvpStatus(model.getRsvpStatus());
		soapModel.setAttendance(model.getAttendance());
		soapModel.setAttendanceBy(model.getAttendanceBy());
		soapModel.setAttendanceDate(model.getAttendanceDate());
		soapModel.setTicketNumber(model.getTicketNumber());

		return soapModel;
	}

	public static RsvpCoParticipantDetailSoap[] toSoapModels(
		RsvpCoParticipantDetail[] models) {
		RsvpCoParticipantDetailSoap[] soapModels = new RsvpCoParticipantDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RsvpCoParticipantDetailSoap[][] toSoapModels(
		RsvpCoParticipantDetail[][] models) {
		RsvpCoParticipantDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RsvpCoParticipantDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RsvpCoParticipantDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RsvpCoParticipantDetailSoap[] toSoapModels(
		List<RsvpCoParticipantDetail> models) {
		List<RsvpCoParticipantDetailSoap> soapModels = new ArrayList<RsvpCoParticipantDetailSoap>(models.size());

		for (RsvpCoParticipantDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RsvpCoParticipantDetailSoap[soapModels.size()]);
	}

	public RsvpCoParticipantDetailSoap() {
	}

	public long getPrimaryKey() {
		return _rsvpCoParticipantDetailId;
	}

	public void setPrimaryKey(long pk) {
		setRsvpCoParticipantDetailId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRsvpCoParticipantDetailId() {
		return _rsvpCoParticipantDetailId;
	}

	public void setRsvpCoParticipantDetailId(long rsvpCoParticipantDetailId) {
		_rsvpCoParticipantDetailId = rsvpCoParticipantDetailId;
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

	public long getRsvpPaymentId() {
		return _rsvpPaymentId;
	}

	public void setRsvpPaymentId(long rsvpPaymentId) {
		_rsvpPaymentId = rsvpPaymentId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getNric() {
		return _nric;
	}

	public void setNric(String nric) {
		_nric = nric;
	}

	public String getIdentificationType() {
		return _identificationType;
	}

	public void setIdentificationType(String identificationType) {
		_identificationType = identificationType;
	}

	public String getEmailAddress() {
		return _emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;
	}

	public int getRsvpStatus() {
		return _rsvpStatus;
	}

	public void setRsvpStatus(int rsvpStatus) {
		_rsvpStatus = rsvpStatus;
	}

	public int getAttendance() {
		return _attendance;
	}

	public void setAttendance(int attendance) {
		_attendance = attendance;
	}

	public long getAttendanceBy() {
		return _attendanceBy;
	}

	public void setAttendanceBy(long attendanceBy) {
		_attendanceBy = attendanceBy;
	}

	public Date getAttendanceDate() {
		return _attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		_attendanceDate = attendanceDate;
	}

	public String getTicketNumber() {
		return _ticketNumber;
	}

	public void setTicketNumber(String ticketNumber) {
		_ticketNumber = ticketNumber;
	}

	private String _uuid;
	private long _rsvpCoParticipantDetailId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rsvpDetailId;
	private long _rsvpPaymentId;
	private long _userId;
	private String _firstName;
	private String _lastName;
	private String _nric;
	private String _identificationType;
	private String _emailAddress;
	private int _rsvpStatus;
	private int _attendance;
	private long _attendanceBy;
	private Date _attendanceDate;
	private String _ticketNumber;
}