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
public class RsvpDetailSoap implements Serializable {
	public static RsvpDetailSoap toSoapModel(RsvpDetail model) {
		RsvpDetailSoap soapModel = new RsvpDetailSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setRsvpDetailId(model.getRsvpDetailId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setRsvpId(model.getRsvpId());
		soapModel.setUserId(model.getUserId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setIdentifiactionType(model.getIdentifiactionType());
		soapModel.setNric(model.getNric());
		soapModel.setEmailAddress(model.getEmailAddress());
		soapModel.setRsvpStatus(model.getRsvpStatus());
		soapModel.setSource(model.getSource());
		soapModel.setAttendance(model.getAttendance());
		soapModel.setAttendanceBy(model.getAttendanceBy());
		soapModel.setAttendanceDate(model.getAttendanceDate());
		soapModel.setRsvpStatusDate(model.getRsvpStatusDate());
		soapModel.setRsvpStatusBy(model.getRsvpStatusBy());
		soapModel.setNumberOfPeople(model.getNumberOfPeople());
		soapModel.setStreetAddress1(model.getStreetAddress1());
		soapModel.setStreetAddress2(model.getStreetAddress2());
		soapModel.setPostalCode(model.getPostalCode());
		soapModel.setCity(model.getCity());
		soapModel.setCountry(model.getCountry());
		soapModel.setState(model.getState());
		soapModel.setGender(model.getGender());
		soapModel.setPhoneNumber1(model.getPhoneNumber1());
		soapModel.setPhoneNumber2(model.getPhoneNumber2());
		soapModel.setHearAboutUs(model.getHearAboutUs());
		soapModel.setAttendedWebinar(model.getAttendedWebinar());
		soapModel.setAgeGroup(model.getAgeGroup());
		soapModel.setTermsOfUse(model.getTermsOfUse());
		soapModel.setAgeRestriction(model.getAgeRestriction());

		return soapModel;
	}

	public static RsvpDetailSoap[] toSoapModels(RsvpDetail[] models) {
		RsvpDetailSoap[] soapModels = new RsvpDetailSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static RsvpDetailSoap[][] toSoapModels(RsvpDetail[][] models) {
		RsvpDetailSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new RsvpDetailSoap[models.length][models[0].length];
		}
		else {
			soapModels = new RsvpDetailSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static RsvpDetailSoap[] toSoapModels(List<RsvpDetail> models) {
		List<RsvpDetailSoap> soapModels = new ArrayList<RsvpDetailSoap>(models.size());

		for (RsvpDetail model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new RsvpDetailSoap[soapModels.size()]);
	}

	public RsvpDetailSoap() {
	}

	public long getPrimaryKey() {
		return _rsvpDetailId;
	}

	public void setPrimaryKey(long pk) {
		setRsvpDetailId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getRsvpDetailId() {
		return _rsvpDetailId;
	}

	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpDetailId = rsvpDetailId;
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

	public long getRsvpId() {
		return _rsvpId;
	}

	public void setRsvpId(long rsvpId) {
		_rsvpId = rsvpId;
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

	public String getIdentifiactionType() {
		return _identifiactionType;
	}

	public void setIdentifiactionType(String identifiactionType) {
		_identifiactionType = identifiactionType;
	}

	public String getNric() {
		return _nric;
	}

	public void setNric(String nric) {
		_nric = nric;
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

	public int getSource() {
		return _source;
	}

	public void setSource(int source) {
		_source = source;
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

	public Date getRsvpStatusDate() {
		return _rsvpStatusDate;
	}

	public void setRsvpStatusDate(Date rsvpStatusDate) {
		_rsvpStatusDate = rsvpStatusDate;
	}

	public long getRsvpStatusBy() {
		return _rsvpStatusBy;
	}

	public void setRsvpStatusBy(long rsvpStatusBy) {
		_rsvpStatusBy = rsvpStatusBy;
	}

	public int getNumberOfPeople() {
		return _numberOfPeople;
	}

	public void setNumberOfPeople(int numberOfPeople) {
		_numberOfPeople = numberOfPeople;
	}

	public String getStreetAddress1() {
		return _streetAddress1;
	}

	public void setStreetAddress1(String streetAddress1) {
		_streetAddress1 = streetAddress1;
	}

	public String getStreetAddress2() {
		return _streetAddress2;
	}

	public void setStreetAddress2(String streetAddress2) {
		_streetAddress2 = streetAddress2;
	}

	public String getPostalCode() {
		return _postalCode;
	}

	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;
	}

	public String getCity() {
		return _city;
	}

	public void setCity(String city) {
		_city = city;
	}

	public String getCountry() {
		return _country;
	}

	public void setCountry(String country) {
		_country = country;
	}

	public String getState() {
		return _state;
	}

	public void setState(String state) {
		_state = state;
	}

	public String getGender() {
		return _gender;
	}

	public void setGender(String gender) {
		_gender = gender;
	}

	public String getPhoneNumber1() {
		return _phoneNumber1;
	}

	public void setPhoneNumber1(String phoneNumber1) {
		_phoneNumber1 = phoneNumber1;
	}

	public String getPhoneNumber2() {
		return _phoneNumber2;
	}

	public void setPhoneNumber2(String phoneNumber2) {
		_phoneNumber2 = phoneNumber2;
	}

	public String getHearAboutUs() {
		return _hearAboutUs;
	}

	public void setHearAboutUs(String hearAboutUs) {
		_hearAboutUs = hearAboutUs;
	}

	public String getAttendedWebinar() {
		return _attendedWebinar;
	}

	public void setAttendedWebinar(String attendedWebinar) {
		_attendedWebinar = attendedWebinar;
	}

	public String getAgeGroup() {
		return _ageGroup;
	}

	public void setAgeGroup(String ageGroup) {
		_ageGroup = ageGroup;
	}

	public boolean getTermsOfUse() {
		return _termsOfUse;
	}

	public boolean isTermsOfUse() {
		return _termsOfUse;
	}

	public void setTermsOfUse(boolean termsOfUse) {
		_termsOfUse = termsOfUse;
	}

	public boolean getAgeRestriction() {
		return _ageRestriction;
	}

	public boolean isAgeRestriction() {
		return _ageRestriction;
	}

	public void setAgeRestriction(boolean ageRestriction) {
		_ageRestriction = ageRestriction;
	}

	private String _uuid;
	private long _rsvpDetailId;
	private long _groupId;
	private long _companyId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private long _rsvpId;
	private long _userId;
	private String _firstName;
	private String _lastName;
	private String _identifiactionType;
	private String _nric;
	private String _emailAddress;
	private int _rsvpStatus;
	private int _source;
	private int _attendance;
	private long _attendanceBy;
	private Date _attendanceDate;
	private Date _rsvpStatusDate;
	private long _rsvpStatusBy;
	private int _numberOfPeople;
	private String _streetAddress1;
	private String _streetAddress2;
	private String _postalCode;
	private String _city;
	private String _country;
	private String _state;
	private String _gender;
	private String _phoneNumber1;
	private String _phoneNumber2;
	private String _hearAboutUs;
	private String _attendedWebinar;
	private String _ageGroup;
	private boolean _termsOfUse;
	private boolean _ageRestriction;
}