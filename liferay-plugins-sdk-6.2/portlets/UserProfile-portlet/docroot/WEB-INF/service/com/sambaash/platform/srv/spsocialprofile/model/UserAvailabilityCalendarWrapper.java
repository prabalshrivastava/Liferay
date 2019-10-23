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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link UserAvailabilityCalendar}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see UserAvailabilityCalendar
 * @generated
 */
public class UserAvailabilityCalendarWrapper implements UserAvailabilityCalendar,
	ModelWrapper<UserAvailabilityCalendar> {
	public UserAvailabilityCalendarWrapper(
		UserAvailabilityCalendar userAvailabilityCalendar) {
		_userAvailabilityCalendar = userAvailabilityCalendar;
	}

	@Override
	public Class<?> getModelClass() {
		return UserAvailabilityCalendar.class;
	}

	@Override
	public String getModelClassName() {
		return UserAvailabilityCalendar.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("userAvailabilityCalendarId",
			getUserAvailabilityCalendarId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userId", getUserId());
		attributes.put("availableFor", getAvailableFor());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long userAvailabilityCalendarId = (Long)attributes.get(
				"userAvailabilityCalendarId");

		if (userAvailabilityCalendarId != null) {
			setUserAvailabilityCalendarId(userAvailabilityCalendarId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String availableFor = (String)attributes.get("availableFor");

		if (availableFor != null) {
			setAvailableFor(availableFor);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this user availability calendar.
	*
	* @return the primary key of this user availability calendar
	*/
	@Override
	public long getPrimaryKey() {
		return _userAvailabilityCalendar.getPrimaryKey();
	}

	/**
	* Sets the primary key of this user availability calendar.
	*
	* @param primaryKey the primary key of this user availability calendar
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_userAvailabilityCalendar.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the user availability calendar ID of this user availability calendar.
	*
	* @return the user availability calendar ID of this user availability calendar
	*/
	@Override
	public long getUserAvailabilityCalendarId() {
		return _userAvailabilityCalendar.getUserAvailabilityCalendarId();
	}

	/**
	* Sets the user availability calendar ID of this user availability calendar.
	*
	* @param userAvailabilityCalendarId the user availability calendar ID of this user availability calendar
	*/
	@Override
	public void setUserAvailabilityCalendarId(long userAvailabilityCalendarId) {
		_userAvailabilityCalendar.setUserAvailabilityCalendarId(userAvailabilityCalendarId);
	}

	/**
	* Returns the group ID of this user availability calendar.
	*
	* @return the group ID of this user availability calendar
	*/
	@Override
	public long getGroupId() {
		return _userAvailabilityCalendar.getGroupId();
	}

	/**
	* Sets the group ID of this user availability calendar.
	*
	* @param groupId the group ID of this user availability calendar
	*/
	@Override
	public void setGroupId(long groupId) {
		_userAvailabilityCalendar.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this user availability calendar.
	*
	* @return the company ID of this user availability calendar
	*/
	@Override
	public long getCompanyId() {
		return _userAvailabilityCalendar.getCompanyId();
	}

	/**
	* Sets the company ID of this user availability calendar.
	*
	* @param companyId the company ID of this user availability calendar
	*/
	@Override
	public void setCompanyId(long companyId) {
		_userAvailabilityCalendar.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this user availability calendar.
	*
	* @return the create date of this user availability calendar
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _userAvailabilityCalendar.getCreateDate();
	}

	/**
	* Sets the create date of this user availability calendar.
	*
	* @param createDate the create date of this user availability calendar
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_userAvailabilityCalendar.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this user availability calendar.
	*
	* @return the modified date of this user availability calendar
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _userAvailabilityCalendar.getModifiedDate();
	}

	/**
	* Sets the modified date of this user availability calendar.
	*
	* @param modifiedDate the modified date of this user availability calendar
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_userAvailabilityCalendar.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user ID of this user availability calendar.
	*
	* @return the user ID of this user availability calendar
	*/
	@Override
	public long getUserId() {
		return _userAvailabilityCalendar.getUserId();
	}

	/**
	* Sets the user ID of this user availability calendar.
	*
	* @param userId the user ID of this user availability calendar
	*/
	@Override
	public void setUserId(long userId) {
		_userAvailabilityCalendar.setUserId(userId);
	}

	/**
	* Returns the user uuid of this user availability calendar.
	*
	* @return the user uuid of this user availability calendar
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _userAvailabilityCalendar.getUserUuid();
	}

	/**
	* Sets the user uuid of this user availability calendar.
	*
	* @param userUuid the user uuid of this user availability calendar
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_userAvailabilityCalendar.setUserUuid(userUuid);
	}

	/**
	* Returns the available for of this user availability calendar.
	*
	* @return the available for of this user availability calendar
	*/
	@Override
	public java.lang.String getAvailableFor() {
		return _userAvailabilityCalendar.getAvailableFor();
	}

	/**
	* Sets the available for of this user availability calendar.
	*
	* @param availableFor the available for of this user availability calendar
	*/
	@Override
	public void setAvailableFor(java.lang.String availableFor) {
		_userAvailabilityCalendar.setAvailableFor(availableFor);
	}

	/**
	* Returns the start date of this user availability calendar.
	*
	* @return the start date of this user availability calendar
	*/
	@Override
	public java.util.Date getStartDate() {
		return _userAvailabilityCalendar.getStartDate();
	}

	/**
	* Sets the start date of this user availability calendar.
	*
	* @param startDate the start date of this user availability calendar
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_userAvailabilityCalendar.setStartDate(startDate);
	}

	/**
	* Returns the end date of this user availability calendar.
	*
	* @return the end date of this user availability calendar
	*/
	@Override
	public java.util.Date getEndDate() {
		return _userAvailabilityCalendar.getEndDate();
	}

	/**
	* Sets the end date of this user availability calendar.
	*
	* @param endDate the end date of this user availability calendar
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_userAvailabilityCalendar.setEndDate(endDate);
	}

	/**
	* Returns the active of this user availability calendar.
	*
	* @return the active of this user availability calendar
	*/
	@Override
	public boolean getActive() {
		return _userAvailabilityCalendar.getActive();
	}

	/**
	* Returns <code>true</code> if this user availability calendar is active.
	*
	* @return <code>true</code> if this user availability calendar is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _userAvailabilityCalendar.isActive();
	}

	/**
	* Sets whether this user availability calendar is active.
	*
	* @param active the active of this user availability calendar
	*/
	@Override
	public void setActive(boolean active) {
		_userAvailabilityCalendar.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _userAvailabilityCalendar.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_userAvailabilityCalendar.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _userAvailabilityCalendar.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_userAvailabilityCalendar.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _userAvailabilityCalendar.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _userAvailabilityCalendar.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_userAvailabilityCalendar.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _userAvailabilityCalendar.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_userAvailabilityCalendar.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_userAvailabilityCalendar.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_userAvailabilityCalendar.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new UserAvailabilityCalendarWrapper((UserAvailabilityCalendar)_userAvailabilityCalendar.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar userAvailabilityCalendar) {
		return _userAvailabilityCalendar.compareTo(userAvailabilityCalendar);
	}

	@Override
	public int hashCode() {
		return _userAvailabilityCalendar.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar> toCacheModel() {
		return _userAvailabilityCalendar.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar toEscapedModel() {
		return new UserAvailabilityCalendarWrapper(_userAvailabilityCalendar.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.UserAvailabilityCalendar toUnescapedModel() {
		return new UserAvailabilityCalendarWrapper(_userAvailabilityCalendar.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _userAvailabilityCalendar.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _userAvailabilityCalendar.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_userAvailabilityCalendar.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof UserAvailabilityCalendarWrapper)) {
			return false;
		}

		UserAvailabilityCalendarWrapper userAvailabilityCalendarWrapper = (UserAvailabilityCalendarWrapper)obj;

		if (Validator.equals(_userAvailabilityCalendar,
					userAvailabilityCalendarWrapper._userAvailabilityCalendar)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public UserAvailabilityCalendar getWrappedUserAvailabilityCalendar() {
		return _userAvailabilityCalendar;
	}

	@Override
	public UserAvailabilityCalendar getWrappedModel() {
		return _userAvailabilityCalendar;
	}

	@Override
	public void resetOriginalValues() {
		_userAvailabilityCalendar.resetOriginalValues();
	}

	private UserAvailabilityCalendar _userAvailabilityCalendar;
}