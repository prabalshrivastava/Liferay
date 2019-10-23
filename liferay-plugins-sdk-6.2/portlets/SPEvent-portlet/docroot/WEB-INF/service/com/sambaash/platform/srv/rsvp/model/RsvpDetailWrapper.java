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
 * This class is a wrapper for {@link RsvpDetail}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see RsvpDetail
 * @generated
 */
public class RsvpDetailWrapper implements RsvpDetail, ModelWrapper<RsvpDetail> {
	public RsvpDetailWrapper(RsvpDetail rsvpDetail) {
		_rsvpDetail = rsvpDetail;
	}

	@Override
	public Class<?> getModelClass() {
		return RsvpDetail.class;
	}

	@Override
	public String getModelClassName() {
		return RsvpDetail.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("rsvpDetailId", getRsvpDetailId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("rsvpId", getRsvpId());
		attributes.put("userId", getUserId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("identifiactionType", getIdentifiactionType());
		attributes.put("nric", getNric());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("rsvpStatus", getRsvpStatus());
		attributes.put("source", getSource());
		attributes.put("attendance", getAttendance());
		attributes.put("attendanceBy", getAttendanceBy());
		attributes.put("attendanceDate", getAttendanceDate());
		attributes.put("rsvpStatusDate", getRsvpStatusDate());
		attributes.put("rsvpStatusBy", getRsvpStatusBy());
		attributes.put("numberOfPeople", getNumberOfPeople());
		attributes.put("streetAddress1", getStreetAddress1());
		attributes.put("streetAddress2", getStreetAddress2());
		attributes.put("postalCode", getPostalCode());
		attributes.put("city", getCity());
		attributes.put("country", getCountry());
		attributes.put("state", getState());
		attributes.put("gender", getGender());
		attributes.put("phoneNumber1", getPhoneNumber1());
		attributes.put("phoneNumber2", getPhoneNumber2());
		attributes.put("hearAboutUs", getHearAboutUs());
		attributes.put("attendedWebinar", getAttendedWebinar());
		attributes.put("ageGroup", getAgeGroup());
		attributes.put("termsOfUse", getTermsOfUse());
		attributes.put("ageRestriction", getAgeRestriction());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long rsvpDetailId = (Long)attributes.get("rsvpDetailId");

		if (rsvpDetailId != null) {
			setRsvpDetailId(rsvpDetailId);
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

		Long rsvpId = (Long)attributes.get("rsvpId");

		if (rsvpId != null) {
			setRsvpId(rsvpId);
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

		String identifiactionType = (String)attributes.get("identifiactionType");

		if (identifiactionType != null) {
			setIdentifiactionType(identifiactionType);
		}

		String nric = (String)attributes.get("nric");

		if (nric != null) {
			setNric(nric);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		Integer rsvpStatus = (Integer)attributes.get("rsvpStatus");

		if (rsvpStatus != null) {
			setRsvpStatus(rsvpStatus);
		}

		Integer source = (Integer)attributes.get("source");

		if (source != null) {
			setSource(source);
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

		Date rsvpStatusDate = (Date)attributes.get("rsvpStatusDate");

		if (rsvpStatusDate != null) {
			setRsvpStatusDate(rsvpStatusDate);
		}

		Long rsvpStatusBy = (Long)attributes.get("rsvpStatusBy");

		if (rsvpStatusBy != null) {
			setRsvpStatusBy(rsvpStatusBy);
		}

		Integer numberOfPeople = (Integer)attributes.get("numberOfPeople");

		if (numberOfPeople != null) {
			setNumberOfPeople(numberOfPeople);
		}

		String streetAddress1 = (String)attributes.get("streetAddress1");

		if (streetAddress1 != null) {
			setStreetAddress1(streetAddress1);
		}

		String streetAddress2 = (String)attributes.get("streetAddress2");

		if (streetAddress2 != null) {
			setStreetAddress2(streetAddress2);
		}

		String postalCode = (String)attributes.get("postalCode");

		if (postalCode != null) {
			setPostalCode(postalCode);
		}

		String city = (String)attributes.get("city");

		if (city != null) {
			setCity(city);
		}

		String country = (String)attributes.get("country");

		if (country != null) {
			setCountry(country);
		}

		String state = (String)attributes.get("state");

		if (state != null) {
			setState(state);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}

		String phoneNumber1 = (String)attributes.get("phoneNumber1");

		if (phoneNumber1 != null) {
			setPhoneNumber1(phoneNumber1);
		}

		String phoneNumber2 = (String)attributes.get("phoneNumber2");

		if (phoneNumber2 != null) {
			setPhoneNumber2(phoneNumber2);
		}

		String hearAboutUs = (String)attributes.get("hearAboutUs");

		if (hearAboutUs != null) {
			setHearAboutUs(hearAboutUs);
		}

		String attendedWebinar = (String)attributes.get("attendedWebinar");

		if (attendedWebinar != null) {
			setAttendedWebinar(attendedWebinar);
		}

		String ageGroup = (String)attributes.get("ageGroup");

		if (ageGroup != null) {
			setAgeGroup(ageGroup);
		}

		Boolean termsOfUse = (Boolean)attributes.get("termsOfUse");

		if (termsOfUse != null) {
			setTermsOfUse(termsOfUse);
		}

		Boolean ageRestriction = (Boolean)attributes.get("ageRestriction");

		if (ageRestriction != null) {
			setAgeRestriction(ageRestriction);
		}
	}

	/**
	* Returns the primary key of this rsvp detail.
	*
	* @return the primary key of this rsvp detail
	*/
	@Override
	public long getPrimaryKey() {
		return _rsvpDetail.getPrimaryKey();
	}

	/**
	* Sets the primary key of this rsvp detail.
	*
	* @param primaryKey the primary key of this rsvp detail
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_rsvpDetail.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this rsvp detail.
	*
	* @return the uuid of this rsvp detail
	*/
	@Override
	public java.lang.String getUuid() {
		return _rsvpDetail.getUuid();
	}

	/**
	* Sets the uuid of this rsvp detail.
	*
	* @param uuid the uuid of this rsvp detail
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_rsvpDetail.setUuid(uuid);
	}

	/**
	* Returns the rsvp detail ID of this rsvp detail.
	*
	* @return the rsvp detail ID of this rsvp detail
	*/
	@Override
	public long getRsvpDetailId() {
		return _rsvpDetail.getRsvpDetailId();
	}

	/**
	* Sets the rsvp detail ID of this rsvp detail.
	*
	* @param rsvpDetailId the rsvp detail ID of this rsvp detail
	*/
	@Override
	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpDetail.setRsvpDetailId(rsvpDetailId);
	}

	/**
	* Returns the group ID of this rsvp detail.
	*
	* @return the group ID of this rsvp detail
	*/
	@Override
	public long getGroupId() {
		return _rsvpDetail.getGroupId();
	}

	/**
	* Sets the group ID of this rsvp detail.
	*
	* @param groupId the group ID of this rsvp detail
	*/
	@Override
	public void setGroupId(long groupId) {
		_rsvpDetail.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this rsvp detail.
	*
	* @return the company ID of this rsvp detail
	*/
	@Override
	public long getCompanyId() {
		return _rsvpDetail.getCompanyId();
	}

	/**
	* Sets the company ID of this rsvp detail.
	*
	* @param companyId the company ID of this rsvp detail
	*/
	@Override
	public void setCompanyId(long companyId) {
		_rsvpDetail.setCompanyId(companyId);
	}

	/**
	* Returns the user name of this rsvp detail.
	*
	* @return the user name of this rsvp detail
	*/
	@Override
	public java.lang.String getUserName() {
		return _rsvpDetail.getUserName();
	}

	/**
	* Sets the user name of this rsvp detail.
	*
	* @param userName the user name of this rsvp detail
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_rsvpDetail.setUserName(userName);
	}

	/**
	* Returns the create date of this rsvp detail.
	*
	* @return the create date of this rsvp detail
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _rsvpDetail.getCreateDate();
	}

	/**
	* Sets the create date of this rsvp detail.
	*
	* @param createDate the create date of this rsvp detail
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_rsvpDetail.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this rsvp detail.
	*
	* @return the modified date of this rsvp detail
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _rsvpDetail.getModifiedDate();
	}

	/**
	* Sets the modified date of this rsvp detail.
	*
	* @param modifiedDate the modified date of this rsvp detail
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_rsvpDetail.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the rsvp ID of this rsvp detail.
	*
	* @return the rsvp ID of this rsvp detail
	*/
	@Override
	public long getRsvpId() {
		return _rsvpDetail.getRsvpId();
	}

	/**
	* Sets the rsvp ID of this rsvp detail.
	*
	* @param rsvpId the rsvp ID of this rsvp detail
	*/
	@Override
	public void setRsvpId(long rsvpId) {
		_rsvpDetail.setRsvpId(rsvpId);
	}

	/**
	* Returns the user ID of this rsvp detail.
	*
	* @return the user ID of this rsvp detail
	*/
	@Override
	public long getUserId() {
		return _rsvpDetail.getUserId();
	}

	/**
	* Sets the user ID of this rsvp detail.
	*
	* @param userId the user ID of this rsvp detail
	*/
	@Override
	public void setUserId(long userId) {
		_rsvpDetail.setUserId(userId);
	}

	/**
	* Returns the user uuid of this rsvp detail.
	*
	* @return the user uuid of this rsvp detail
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _rsvpDetail.getUserUuid();
	}

	/**
	* Sets the user uuid of this rsvp detail.
	*
	* @param userUuid the user uuid of this rsvp detail
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_rsvpDetail.setUserUuid(userUuid);
	}

	/**
	* Returns the first name of this rsvp detail.
	*
	* @return the first name of this rsvp detail
	*/
	@Override
	public java.lang.String getFirstName() {
		return _rsvpDetail.getFirstName();
	}

	/**
	* Sets the first name of this rsvp detail.
	*
	* @param firstName the first name of this rsvp detail
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_rsvpDetail.setFirstName(firstName);
	}

	/**
	* Returns the last name of this rsvp detail.
	*
	* @return the last name of this rsvp detail
	*/
	@Override
	public java.lang.String getLastName() {
		return _rsvpDetail.getLastName();
	}

	/**
	* Sets the last name of this rsvp detail.
	*
	* @param lastName the last name of this rsvp detail
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_rsvpDetail.setLastName(lastName);
	}

	/**
	* Returns the identifiaction type of this rsvp detail.
	*
	* @return the identifiaction type of this rsvp detail
	*/
	@Override
	public java.lang.String getIdentifiactionType() {
		return _rsvpDetail.getIdentifiactionType();
	}

	/**
	* Sets the identifiaction type of this rsvp detail.
	*
	* @param identifiactionType the identifiaction type of this rsvp detail
	*/
	@Override
	public void setIdentifiactionType(java.lang.String identifiactionType) {
		_rsvpDetail.setIdentifiactionType(identifiactionType);
	}

	/**
	* Returns the nric of this rsvp detail.
	*
	* @return the nric of this rsvp detail
	*/
	@Override
	public java.lang.String getNric() {
		return _rsvpDetail.getNric();
	}

	/**
	* Sets the nric of this rsvp detail.
	*
	* @param nric the nric of this rsvp detail
	*/
	@Override
	public void setNric(java.lang.String nric) {
		_rsvpDetail.setNric(nric);
	}

	/**
	* Returns the email address of this rsvp detail.
	*
	* @return the email address of this rsvp detail
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _rsvpDetail.getEmailAddress();
	}

	/**
	* Sets the email address of this rsvp detail.
	*
	* @param emailAddress the email address of this rsvp detail
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_rsvpDetail.setEmailAddress(emailAddress);
	}

	/**
	* Returns the rsvp status of this rsvp detail.
	*
	* @return the rsvp status of this rsvp detail
	*/
	@Override
	public int getRsvpStatus() {
		return _rsvpDetail.getRsvpStatus();
	}

	/**
	* Sets the rsvp status of this rsvp detail.
	*
	* @param rsvpStatus the rsvp status of this rsvp detail
	*/
	@Override
	public void setRsvpStatus(int rsvpStatus) {
		_rsvpDetail.setRsvpStatus(rsvpStatus);
	}

	/**
	* Returns the source of this rsvp detail.
	*
	* @return the source of this rsvp detail
	*/
	@Override
	public int getSource() {
		return _rsvpDetail.getSource();
	}

	/**
	* Sets the source of this rsvp detail.
	*
	* @param source the source of this rsvp detail
	*/
	@Override
	public void setSource(int source) {
		_rsvpDetail.setSource(source);
	}

	/**
	* Returns the attendance of this rsvp detail.
	*
	* @return the attendance of this rsvp detail
	*/
	@Override
	public int getAttendance() {
		return _rsvpDetail.getAttendance();
	}

	/**
	* Sets the attendance of this rsvp detail.
	*
	* @param attendance the attendance of this rsvp detail
	*/
	@Override
	public void setAttendance(int attendance) {
		_rsvpDetail.setAttendance(attendance);
	}

	/**
	* Returns the attendance by of this rsvp detail.
	*
	* @return the attendance by of this rsvp detail
	*/
	@Override
	public long getAttendanceBy() {
		return _rsvpDetail.getAttendanceBy();
	}

	/**
	* Sets the attendance by of this rsvp detail.
	*
	* @param attendanceBy the attendance by of this rsvp detail
	*/
	@Override
	public void setAttendanceBy(long attendanceBy) {
		_rsvpDetail.setAttendanceBy(attendanceBy);
	}

	/**
	* Returns the attendance date of this rsvp detail.
	*
	* @return the attendance date of this rsvp detail
	*/
	@Override
	public java.util.Date getAttendanceDate() {
		return _rsvpDetail.getAttendanceDate();
	}

	/**
	* Sets the attendance date of this rsvp detail.
	*
	* @param attendanceDate the attendance date of this rsvp detail
	*/
	@Override
	public void setAttendanceDate(java.util.Date attendanceDate) {
		_rsvpDetail.setAttendanceDate(attendanceDate);
	}

	/**
	* Returns the rsvp status date of this rsvp detail.
	*
	* @return the rsvp status date of this rsvp detail
	*/
	@Override
	public java.util.Date getRsvpStatusDate() {
		return _rsvpDetail.getRsvpStatusDate();
	}

	/**
	* Sets the rsvp status date of this rsvp detail.
	*
	* @param rsvpStatusDate the rsvp status date of this rsvp detail
	*/
	@Override
	public void setRsvpStatusDate(java.util.Date rsvpStatusDate) {
		_rsvpDetail.setRsvpStatusDate(rsvpStatusDate);
	}

	/**
	* Returns the rsvp status by of this rsvp detail.
	*
	* @return the rsvp status by of this rsvp detail
	*/
	@Override
	public long getRsvpStatusBy() {
		return _rsvpDetail.getRsvpStatusBy();
	}

	/**
	* Sets the rsvp status by of this rsvp detail.
	*
	* @param rsvpStatusBy the rsvp status by of this rsvp detail
	*/
	@Override
	public void setRsvpStatusBy(long rsvpStatusBy) {
		_rsvpDetail.setRsvpStatusBy(rsvpStatusBy);
	}

	/**
	* Returns the number of people of this rsvp detail.
	*
	* @return the number of people of this rsvp detail
	*/
	@Override
	public int getNumberOfPeople() {
		return _rsvpDetail.getNumberOfPeople();
	}

	/**
	* Sets the number of people of this rsvp detail.
	*
	* @param numberOfPeople the number of people of this rsvp detail
	*/
	@Override
	public void setNumberOfPeople(int numberOfPeople) {
		_rsvpDetail.setNumberOfPeople(numberOfPeople);
	}

	/**
	* Returns the street address1 of this rsvp detail.
	*
	* @return the street address1 of this rsvp detail
	*/
	@Override
	public java.lang.String getStreetAddress1() {
		return _rsvpDetail.getStreetAddress1();
	}

	/**
	* Sets the street address1 of this rsvp detail.
	*
	* @param streetAddress1 the street address1 of this rsvp detail
	*/
	@Override
	public void setStreetAddress1(java.lang.String streetAddress1) {
		_rsvpDetail.setStreetAddress1(streetAddress1);
	}

	/**
	* Returns the street address2 of this rsvp detail.
	*
	* @return the street address2 of this rsvp detail
	*/
	@Override
	public java.lang.String getStreetAddress2() {
		return _rsvpDetail.getStreetAddress2();
	}

	/**
	* Sets the street address2 of this rsvp detail.
	*
	* @param streetAddress2 the street address2 of this rsvp detail
	*/
	@Override
	public void setStreetAddress2(java.lang.String streetAddress2) {
		_rsvpDetail.setStreetAddress2(streetAddress2);
	}

	/**
	* Returns the postal code of this rsvp detail.
	*
	* @return the postal code of this rsvp detail
	*/
	@Override
	public java.lang.String getPostalCode() {
		return _rsvpDetail.getPostalCode();
	}

	/**
	* Sets the postal code of this rsvp detail.
	*
	* @param postalCode the postal code of this rsvp detail
	*/
	@Override
	public void setPostalCode(java.lang.String postalCode) {
		_rsvpDetail.setPostalCode(postalCode);
	}

	/**
	* Returns the city of this rsvp detail.
	*
	* @return the city of this rsvp detail
	*/
	@Override
	public java.lang.String getCity() {
		return _rsvpDetail.getCity();
	}

	/**
	* Sets the city of this rsvp detail.
	*
	* @param city the city of this rsvp detail
	*/
	@Override
	public void setCity(java.lang.String city) {
		_rsvpDetail.setCity(city);
	}

	/**
	* Returns the country of this rsvp detail.
	*
	* @return the country of this rsvp detail
	*/
	@Override
	public java.lang.String getCountry() {
		return _rsvpDetail.getCountry();
	}

	/**
	* Sets the country of this rsvp detail.
	*
	* @param country the country of this rsvp detail
	*/
	@Override
	public void setCountry(java.lang.String country) {
		_rsvpDetail.setCountry(country);
	}

	/**
	* Returns the state of this rsvp detail.
	*
	* @return the state of this rsvp detail
	*/
	@Override
	public java.lang.String getState() {
		return _rsvpDetail.getState();
	}

	/**
	* Sets the state of this rsvp detail.
	*
	* @param state the state of this rsvp detail
	*/
	@Override
	public void setState(java.lang.String state) {
		_rsvpDetail.setState(state);
	}

	/**
	* Returns the gender of this rsvp detail.
	*
	* @return the gender of this rsvp detail
	*/
	@Override
	public java.lang.String getGender() {
		return _rsvpDetail.getGender();
	}

	/**
	* Sets the gender of this rsvp detail.
	*
	* @param gender the gender of this rsvp detail
	*/
	@Override
	public void setGender(java.lang.String gender) {
		_rsvpDetail.setGender(gender);
	}

	/**
	* Returns the phone number1 of this rsvp detail.
	*
	* @return the phone number1 of this rsvp detail
	*/
	@Override
	public java.lang.String getPhoneNumber1() {
		return _rsvpDetail.getPhoneNumber1();
	}

	/**
	* Sets the phone number1 of this rsvp detail.
	*
	* @param phoneNumber1 the phone number1 of this rsvp detail
	*/
	@Override
	public void setPhoneNumber1(java.lang.String phoneNumber1) {
		_rsvpDetail.setPhoneNumber1(phoneNumber1);
	}

	/**
	* Returns the phone number2 of this rsvp detail.
	*
	* @return the phone number2 of this rsvp detail
	*/
	@Override
	public java.lang.String getPhoneNumber2() {
		return _rsvpDetail.getPhoneNumber2();
	}

	/**
	* Sets the phone number2 of this rsvp detail.
	*
	* @param phoneNumber2 the phone number2 of this rsvp detail
	*/
	@Override
	public void setPhoneNumber2(java.lang.String phoneNumber2) {
		_rsvpDetail.setPhoneNumber2(phoneNumber2);
	}

	/**
	* Returns the hear about us of this rsvp detail.
	*
	* @return the hear about us of this rsvp detail
	*/
	@Override
	public java.lang.String getHearAboutUs() {
		return _rsvpDetail.getHearAboutUs();
	}

	/**
	* Sets the hear about us of this rsvp detail.
	*
	* @param hearAboutUs the hear about us of this rsvp detail
	*/
	@Override
	public void setHearAboutUs(java.lang.String hearAboutUs) {
		_rsvpDetail.setHearAboutUs(hearAboutUs);
	}

	/**
	* Returns the attended webinar of this rsvp detail.
	*
	* @return the attended webinar of this rsvp detail
	*/
	@Override
	public java.lang.String getAttendedWebinar() {
		return _rsvpDetail.getAttendedWebinar();
	}

	/**
	* Sets the attended webinar of this rsvp detail.
	*
	* @param attendedWebinar the attended webinar of this rsvp detail
	*/
	@Override
	public void setAttendedWebinar(java.lang.String attendedWebinar) {
		_rsvpDetail.setAttendedWebinar(attendedWebinar);
	}

	/**
	* Returns the age group of this rsvp detail.
	*
	* @return the age group of this rsvp detail
	*/
	@Override
	public java.lang.String getAgeGroup() {
		return _rsvpDetail.getAgeGroup();
	}

	/**
	* Sets the age group of this rsvp detail.
	*
	* @param ageGroup the age group of this rsvp detail
	*/
	@Override
	public void setAgeGroup(java.lang.String ageGroup) {
		_rsvpDetail.setAgeGroup(ageGroup);
	}

	/**
	* Returns the terms of use of this rsvp detail.
	*
	* @return the terms of use of this rsvp detail
	*/
	@Override
	public boolean getTermsOfUse() {
		return _rsvpDetail.getTermsOfUse();
	}

	/**
	* Returns <code>true</code> if this rsvp detail is terms of use.
	*
	* @return <code>true</code> if this rsvp detail is terms of use; <code>false</code> otherwise
	*/
	@Override
	public boolean isTermsOfUse() {
		return _rsvpDetail.isTermsOfUse();
	}

	/**
	* Sets whether this rsvp detail is terms of use.
	*
	* @param termsOfUse the terms of use of this rsvp detail
	*/
	@Override
	public void setTermsOfUse(boolean termsOfUse) {
		_rsvpDetail.setTermsOfUse(termsOfUse);
	}

	/**
	* Returns the age restriction of this rsvp detail.
	*
	* @return the age restriction of this rsvp detail
	*/
	@Override
	public boolean getAgeRestriction() {
		return _rsvpDetail.getAgeRestriction();
	}

	/**
	* Returns <code>true</code> if this rsvp detail is age restriction.
	*
	* @return <code>true</code> if this rsvp detail is age restriction; <code>false</code> otherwise
	*/
	@Override
	public boolean isAgeRestriction() {
		return _rsvpDetail.isAgeRestriction();
	}

	/**
	* Sets whether this rsvp detail is age restriction.
	*
	* @param ageRestriction the age restriction of this rsvp detail
	*/
	@Override
	public void setAgeRestriction(boolean ageRestriction) {
		_rsvpDetail.setAgeRestriction(ageRestriction);
	}

	@Override
	public boolean isNew() {
		return _rsvpDetail.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_rsvpDetail.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _rsvpDetail.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_rsvpDetail.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _rsvpDetail.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _rsvpDetail.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_rsvpDetail.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _rsvpDetail.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_rsvpDetail.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_rsvpDetail.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_rsvpDetail.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new RsvpDetailWrapper((RsvpDetail)_rsvpDetail.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.rsvp.model.RsvpDetail rsvpDetail) {
		return _rsvpDetail.compareTo(rsvpDetail);
	}

	@Override
	public int hashCode() {
		return _rsvpDetail.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.rsvp.model.RsvpDetail> toCacheModel() {
		return _rsvpDetail.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail toEscapedModel() {
		return new RsvpDetailWrapper(_rsvpDetail.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.rsvp.model.RsvpDetail toUnescapedModel() {
		return new RsvpDetailWrapper(_rsvpDetail.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _rsvpDetail.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _rsvpDetail.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_rsvpDetail.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RsvpDetailWrapper)) {
			return false;
		}

		RsvpDetailWrapper rsvpDetailWrapper = (RsvpDetailWrapper)obj;

		if (Validator.equals(_rsvpDetail, rsvpDetailWrapper._rsvpDetail)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _rsvpDetail.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public RsvpDetail getWrappedRsvpDetail() {
		return _rsvpDetail;
	}

	@Override
	public RsvpDetail getWrappedModel() {
		return _rsvpDetail;
	}

	@Override
	public void resetOriginalValues() {
		_rsvpDetail.resetOriginalValues();
	}

	private RsvpDetail _rsvpDetail;
}