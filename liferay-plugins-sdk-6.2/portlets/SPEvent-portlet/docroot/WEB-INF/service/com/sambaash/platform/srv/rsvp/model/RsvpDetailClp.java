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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.rsvp.service.ClpSerializer;
import com.sambaash.platform.srv.rsvp.service.RsvpDetailLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class RsvpDetailClp extends BaseModelImpl<RsvpDetail>
	implements RsvpDetail {
	public RsvpDetailClp() {
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
	public long getPrimaryKey() {
		return _rsvpDetailId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setRsvpDetailId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _rsvpDetailId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_rsvpDetailRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpDetailId() {
		return _rsvpDetailId;
	}

	@Override
	public void setRsvpDetailId(long rsvpDetailId) {
		_rsvpDetailId = rsvpDetailId;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpDetailId", long.class);

				method.invoke(_rsvpDetailRemoteModel, rsvpDetailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_rsvpDetailRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_rsvpDetailRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_rsvpDetailRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_rsvpDetailRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_rsvpDetailRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpId() {
		return _rsvpId;
	}

	@Override
	public void setRsvpId(long rsvpId) {
		_rsvpId = rsvpId;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpId", long.class);

				method.invoke(_rsvpDetailRemoteModel, rsvpId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_rsvpDetailRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getFirstName() {
		return _firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		_firstName = firstName;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setFirstName", String.class);

				method.invoke(_rsvpDetailRemoteModel, firstName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLastName() {
		return _lastName;
	}

	@Override
	public void setLastName(String lastName) {
		_lastName = lastName;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setLastName", String.class);

				method.invoke(_rsvpDetailRemoteModel, lastName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIdentifiactionType() {
		return _identifiactionType;
	}

	@Override
	public void setIdentifiactionType(String identifiactionType) {
		_identifiactionType = identifiactionType;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setIdentifiactionType",
						String.class);

				method.invoke(_rsvpDetailRemoteModel, identifiactionType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNric() {
		return _nric;
	}

	@Override
	public void setNric(String nric) {
		_nric = nric;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setNric", String.class);

				method.invoke(_rsvpDetailRemoteModel, nric);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailAddress() {
		return _emailAddress;
	}

	@Override
	public void setEmailAddress(String emailAddress) {
		_emailAddress = emailAddress;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailAddress", String.class);

				method.invoke(_rsvpDetailRemoteModel, emailAddress);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getRsvpStatus() {
		return _rsvpStatus;
	}

	@Override
	public void setRsvpStatus(int rsvpStatus) {
		_rsvpStatus = rsvpStatus;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpStatus", int.class);

				method.invoke(_rsvpDetailRemoteModel, rsvpStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getSource() {
		return _source;
	}

	@Override
	public void setSource(int source) {
		_source = source;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setSource", int.class);

				method.invoke(_rsvpDetailRemoteModel, source);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getAttendance() {
		return _attendance;
	}

	@Override
	public void setAttendance(int attendance) {
		_attendance = attendance;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAttendance", int.class);

				method.invoke(_rsvpDetailRemoteModel, attendance);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAttendanceBy() {
		return _attendanceBy;
	}

	@Override
	public void setAttendanceBy(long attendanceBy) {
		_attendanceBy = attendanceBy;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAttendanceBy", long.class);

				method.invoke(_rsvpDetailRemoteModel, attendanceBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAttendanceDate() {
		return _attendanceDate;
	}

	@Override
	public void setAttendanceDate(Date attendanceDate) {
		_attendanceDate = attendanceDate;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAttendanceDate", Date.class);

				method.invoke(_rsvpDetailRemoteModel, attendanceDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getRsvpStatusDate() {
		return _rsvpStatusDate;
	}

	@Override
	public void setRsvpStatusDate(Date rsvpStatusDate) {
		_rsvpStatusDate = rsvpStatusDate;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpStatusDate", Date.class);

				method.invoke(_rsvpDetailRemoteModel, rsvpStatusDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRsvpStatusBy() {
		return _rsvpStatusBy;
	}

	@Override
	public void setRsvpStatusBy(long rsvpStatusBy) {
		_rsvpStatusBy = rsvpStatusBy;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setRsvpStatusBy", long.class);

				method.invoke(_rsvpDetailRemoteModel, rsvpStatusBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNumberOfPeople() {
		return _numberOfPeople;
	}

	@Override
	public void setNumberOfPeople(int numberOfPeople) {
		_numberOfPeople = numberOfPeople;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setNumberOfPeople", int.class);

				method.invoke(_rsvpDetailRemoteModel, numberOfPeople);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreetAddress1() {
		return _streetAddress1;
	}

	@Override
	public void setStreetAddress1(String streetAddress1) {
		_streetAddress1 = streetAddress1;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setStreetAddress1",
						String.class);

				method.invoke(_rsvpDetailRemoteModel, streetAddress1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStreetAddress2() {
		return _streetAddress2;
	}

	@Override
	public void setStreetAddress2(String streetAddress2) {
		_streetAddress2 = streetAddress2;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setStreetAddress2",
						String.class);

				method.invoke(_rsvpDetailRemoteModel, streetAddress2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPostalCode() {
		return _postalCode;
	}

	@Override
	public void setPostalCode(String postalCode) {
		_postalCode = postalCode;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setPostalCode", String.class);

				method.invoke(_rsvpDetailRemoteModel, postalCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCity() {
		return _city;
	}

	@Override
	public void setCity(String city) {
		_city = city;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCity", String.class);

				method.invoke(_rsvpDetailRemoteModel, city);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountry() {
		return _country;
	}

	@Override
	public void setCountry(String country) {
		_country = country;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setCountry", String.class);

				method.invoke(_rsvpDetailRemoteModel, country);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getState() {
		return _state;
	}

	@Override
	public void setState(String state) {
		_state = state;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setState", String.class);

				method.invoke(_rsvpDetailRemoteModel, state);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGender() {
		return _gender;
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setGender", String.class);

				method.invoke(_rsvpDetailRemoteModel, gender);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhoneNumber1() {
		return _phoneNumber1;
	}

	@Override
	public void setPhoneNumber1(String phoneNumber1) {
		_phoneNumber1 = phoneNumber1;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setPhoneNumber1", String.class);

				method.invoke(_rsvpDetailRemoteModel, phoneNumber1);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPhoneNumber2() {
		return _phoneNumber2;
	}

	@Override
	public void setPhoneNumber2(String phoneNumber2) {
		_phoneNumber2 = phoneNumber2;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setPhoneNumber2", String.class);

				method.invoke(_rsvpDetailRemoteModel, phoneNumber2);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHearAboutUs() {
		return _hearAboutUs;
	}

	@Override
	public void setHearAboutUs(String hearAboutUs) {
		_hearAboutUs = hearAboutUs;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setHearAboutUs", String.class);

				method.invoke(_rsvpDetailRemoteModel, hearAboutUs);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAttendedWebinar() {
		return _attendedWebinar;
	}

	@Override
	public void setAttendedWebinar(String attendedWebinar) {
		_attendedWebinar = attendedWebinar;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAttendedWebinar",
						String.class);

				method.invoke(_rsvpDetailRemoteModel, attendedWebinar);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAgeGroup() {
		return _ageGroup;
	}

	@Override
	public void setAgeGroup(String ageGroup) {
		_ageGroup = ageGroup;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAgeGroup", String.class);

				method.invoke(_rsvpDetailRemoteModel, ageGroup);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getTermsOfUse() {
		return _termsOfUse;
	}

	@Override
	public boolean isTermsOfUse() {
		return _termsOfUse;
	}

	@Override
	public void setTermsOfUse(boolean termsOfUse) {
		_termsOfUse = termsOfUse;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setTermsOfUse", boolean.class);

				method.invoke(_rsvpDetailRemoteModel, termsOfUse);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getAgeRestriction() {
		return _ageRestriction;
	}

	@Override
	public boolean isAgeRestriction() {
		return _ageRestriction;
	}

	@Override
	public void setAgeRestriction(boolean ageRestriction) {
		_ageRestriction = ageRestriction;

		if (_rsvpDetailRemoteModel != null) {
			try {
				Class<?> clazz = _rsvpDetailRemoteModel.getClass();

				Method method = clazz.getMethod("setAgeRestriction",
						boolean.class);

				method.invoke(_rsvpDetailRemoteModel, ageRestriction);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				RsvpDetail.class.getName()));
	}

	public BaseModel<?> getRsvpDetailRemoteModel() {
		return _rsvpDetailRemoteModel;
	}

	public void setRsvpDetailRemoteModel(BaseModel<?> rsvpDetailRemoteModel) {
		_rsvpDetailRemoteModel = rsvpDetailRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _rsvpDetailRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_rsvpDetailRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			RsvpDetailLocalServiceUtil.addRsvpDetail(this);
		}
		else {
			RsvpDetailLocalServiceUtil.updateRsvpDetail(this);
		}
	}

	@Override
	public RsvpDetail toEscapedModel() {
		return (RsvpDetail)ProxyUtil.newProxyInstance(RsvpDetail.class.getClassLoader(),
			new Class[] { RsvpDetail.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		RsvpDetailClp clone = new RsvpDetailClp();

		clone.setUuid(getUuid());
		clone.setRsvpDetailId(getRsvpDetailId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setRsvpId(getRsvpId());
		clone.setUserId(getUserId());
		clone.setFirstName(getFirstName());
		clone.setLastName(getLastName());
		clone.setIdentifiactionType(getIdentifiactionType());
		clone.setNric(getNric());
		clone.setEmailAddress(getEmailAddress());
		clone.setRsvpStatus(getRsvpStatus());
		clone.setSource(getSource());
		clone.setAttendance(getAttendance());
		clone.setAttendanceBy(getAttendanceBy());
		clone.setAttendanceDate(getAttendanceDate());
		clone.setRsvpStatusDate(getRsvpStatusDate());
		clone.setRsvpStatusBy(getRsvpStatusBy());
		clone.setNumberOfPeople(getNumberOfPeople());
		clone.setStreetAddress1(getStreetAddress1());
		clone.setStreetAddress2(getStreetAddress2());
		clone.setPostalCode(getPostalCode());
		clone.setCity(getCity());
		clone.setCountry(getCountry());
		clone.setState(getState());
		clone.setGender(getGender());
		clone.setPhoneNumber1(getPhoneNumber1());
		clone.setPhoneNumber2(getPhoneNumber2());
		clone.setHearAboutUs(getHearAboutUs());
		clone.setAttendedWebinar(getAttendedWebinar());
		clone.setAgeGroup(getAgeGroup());
		clone.setTermsOfUse(getTermsOfUse());
		clone.setAgeRestriction(getAgeRestriction());

		return clone;
	}

	@Override
	public int compareTo(RsvpDetail rsvpDetail) {
		long primaryKey = rsvpDetail.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof RsvpDetailClp)) {
			return false;
		}

		RsvpDetailClp rsvpDetail = (RsvpDetailClp)obj;

		long primaryKey = rsvpDetail.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(73);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", rsvpDetailId=");
		sb.append(getRsvpDetailId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", rsvpId=");
		sb.append(getRsvpId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", firstName=");
		sb.append(getFirstName());
		sb.append(", lastName=");
		sb.append(getLastName());
		sb.append(", identifiactionType=");
		sb.append(getIdentifiactionType());
		sb.append(", nric=");
		sb.append(getNric());
		sb.append(", emailAddress=");
		sb.append(getEmailAddress());
		sb.append(", rsvpStatus=");
		sb.append(getRsvpStatus());
		sb.append(", source=");
		sb.append(getSource());
		sb.append(", attendance=");
		sb.append(getAttendance());
		sb.append(", attendanceBy=");
		sb.append(getAttendanceBy());
		sb.append(", attendanceDate=");
		sb.append(getAttendanceDate());
		sb.append(", rsvpStatusDate=");
		sb.append(getRsvpStatusDate());
		sb.append(", rsvpStatusBy=");
		sb.append(getRsvpStatusBy());
		sb.append(", numberOfPeople=");
		sb.append(getNumberOfPeople());
		sb.append(", streetAddress1=");
		sb.append(getStreetAddress1());
		sb.append(", streetAddress2=");
		sb.append(getStreetAddress2());
		sb.append(", postalCode=");
		sb.append(getPostalCode());
		sb.append(", city=");
		sb.append(getCity());
		sb.append(", country=");
		sb.append(getCountry());
		sb.append(", state=");
		sb.append(getState());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append(", phoneNumber1=");
		sb.append(getPhoneNumber1());
		sb.append(", phoneNumber2=");
		sb.append(getPhoneNumber2());
		sb.append(", hearAboutUs=");
		sb.append(getHearAboutUs());
		sb.append(", attendedWebinar=");
		sb.append(getAttendedWebinar());
		sb.append(", ageGroup=");
		sb.append(getAgeGroup());
		sb.append(", termsOfUse=");
		sb.append(getTermsOfUse());
		sb.append(", ageRestriction=");
		sb.append(getAgeRestriction());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(112);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.rsvp.model.RsvpDetail");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpDetailId</column-name><column-value><![CDATA[");
		sb.append(getRsvpDetailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpId</column-name><column-value><![CDATA[");
		sb.append(getRsvpId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>firstName</column-name><column-value><![CDATA[");
		sb.append(getFirstName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lastName</column-name><column-value><![CDATA[");
		sb.append(getLastName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>identifiactionType</column-name><column-value><![CDATA[");
		sb.append(getIdentifiactionType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>nric</column-name><column-value><![CDATA[");
		sb.append(getNric());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailAddress</column-name><column-value><![CDATA[");
		sb.append(getEmailAddress());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpStatus</column-name><column-value><![CDATA[");
		sb.append(getRsvpStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>source</column-name><column-value><![CDATA[");
		sb.append(getSource());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attendance</column-name><column-value><![CDATA[");
		sb.append(getAttendance());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attendanceBy</column-name><column-value><![CDATA[");
		sb.append(getAttendanceBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attendanceDate</column-name><column-value><![CDATA[");
		sb.append(getAttendanceDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpStatusDate</column-name><column-value><![CDATA[");
		sb.append(getRsvpStatusDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>rsvpStatusBy</column-name><column-value><![CDATA[");
		sb.append(getRsvpStatusBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>numberOfPeople</column-name><column-value><![CDATA[");
		sb.append(getNumberOfPeople());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>streetAddress1</column-name><column-value><![CDATA[");
		sb.append(getStreetAddress1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>streetAddress2</column-name><column-value><![CDATA[");
		sb.append(getStreetAddress2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>postalCode</column-name><column-value><![CDATA[");
		sb.append(getPostalCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>city</column-name><column-value><![CDATA[");
		sb.append(getCity());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>country</column-name><column-value><![CDATA[");
		sb.append(getCountry());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>state</column-name><column-value><![CDATA[");
		sb.append(getState());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber1</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber1());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>phoneNumber2</column-name><column-value><![CDATA[");
		sb.append(getPhoneNumber2());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hearAboutUs</column-name><column-value><![CDATA[");
		sb.append(getHearAboutUs());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attendedWebinar</column-name><column-value><![CDATA[");
		sb.append(getAttendedWebinar());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ageGroup</column-name><column-value><![CDATA[");
		sb.append(getAgeGroup());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>termsOfUse</column-name><column-value><![CDATA[");
		sb.append(getTermsOfUse());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ageRestriction</column-name><column-value><![CDATA[");
		sb.append(getAgeRestriction());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
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
	private BaseModel<?> _rsvpDetailRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.rsvp.service.ClpSerializer.class;
}