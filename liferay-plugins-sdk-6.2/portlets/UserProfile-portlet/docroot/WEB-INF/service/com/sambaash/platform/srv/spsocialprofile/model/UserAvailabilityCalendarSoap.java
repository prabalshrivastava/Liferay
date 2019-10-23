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

package com.sambaash.platform.srv.spsocialprofile.model;

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
public class UserAvailabilityCalendarSoap implements Serializable {
	public static UserAvailabilityCalendarSoap toSoapModel(
		UserAvailabilityCalendar model) {
		UserAvailabilityCalendarSoap soapModel = new UserAvailabilityCalendarSoap();

		soapModel.setUserAvailabilityCalendarId(model.getUserAvailabilityCalendarId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserId(model.getUserId());
		soapModel.setAvailableFor(model.getAvailableFor());
		soapModel.setStartDate(model.getStartDate());
		soapModel.setEndDate(model.getEndDate());
		soapModel.setActive(model.getActive());

		return soapModel;
	}

	public static UserAvailabilityCalendarSoap[] toSoapModels(
		UserAvailabilityCalendar[] models) {
		UserAvailabilityCalendarSoap[] soapModels = new UserAvailabilityCalendarSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static UserAvailabilityCalendarSoap[][] toSoapModels(
		UserAvailabilityCalendar[][] models) {
		UserAvailabilityCalendarSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new UserAvailabilityCalendarSoap[models.length][models[0].length];
		}
		else {
			soapModels = new UserAvailabilityCalendarSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static UserAvailabilityCalendarSoap[] toSoapModels(
		List<UserAvailabilityCalendar> models) {
		List<UserAvailabilityCalendarSoap> soapModels = new ArrayList<UserAvailabilityCalendarSoap>(models.size());

		for (UserAvailabilityCalendar model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new UserAvailabilityCalendarSoap[soapModels.size()]);
	}

	public UserAvailabilityCalendarSoap() {
	}

	public long getPrimaryKey() {
		return _userAvailabilityCalendarId;
	}

	public void setPrimaryKey(long pk) {
		setUserAvailabilityCalendarId(pk);
	}

	public long getUserAvailabilityCalendarId() {
		return _userAvailabilityCalendarId;
	}

	public void setUserAvailabilityCalendarId(long userAvailabilityCalendarId) {
		_userAvailabilityCalendarId = userAvailabilityCalendarId;
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

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getAvailableFor() {
		return _availableFor;
	}

	public void setAvailableFor(String availableFor) {
		_availableFor = availableFor;
	}

	public Date getStartDate() {
		return _startDate;
	}

	public void setStartDate(Date startDate) {
		_startDate = startDate;
	}

	public Date getEndDate() {
		return _endDate;
	}

	public void setEndDate(Date endDate) {
		_endDate = endDate;
	}

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	private long _userAvailabilityCalendarId;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private long _userId;
	private String _availableFor;
	private Date _startDate;
	private Date _endDate;
	private boolean _active;
}