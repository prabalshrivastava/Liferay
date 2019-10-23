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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link PersonaAttendee}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see PersonaAttendee
 * @generated
 */
public class PersonaAttendeeWrapper implements PersonaAttendee,
	ModelWrapper<PersonaAttendee> {
	public PersonaAttendeeWrapper(PersonaAttendee personaAttendee) {
		_personaAttendee = personaAttendee;
	}

	@Override
	public Class<?> getModelClass() {
		return PersonaAttendee.class;
	}

	@Override
	public String getModelClassName() {
		return PersonaAttendee.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPersonaAttendeeId", getSpPersonaAttendeeId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("description", getDescription());
		attributes.put("imageId", getImageId());
		attributes.put("spPersonaId", getSpPersonaId());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPersonaAttendeeId = (Long)attributes.get("spPersonaAttendeeId");

		if (spPersonaAttendeeId != null) {
			setSpPersonaAttendeeId(spPersonaAttendeeId);
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

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		Long imageId = (Long)attributes.get("imageId");

		if (imageId != null) {
			setImageId(imageId);
		}

		Long spPersonaId = (Long)attributes.get("spPersonaId");

		if (spPersonaId != null) {
			setSpPersonaId(spPersonaId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	/**
	* Returns the primary key of this persona attendee.
	*
	* @return the primary key of this persona attendee
	*/
	@Override
	public long getPrimaryKey() {
		return _personaAttendee.getPrimaryKey();
	}

	/**
	* Sets the primary key of this persona attendee.
	*
	* @param primaryKey the primary key of this persona attendee
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_personaAttendee.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp persona attendee ID of this persona attendee.
	*
	* @return the sp persona attendee ID of this persona attendee
	*/
	@Override
	public long getSpPersonaAttendeeId() {
		return _personaAttendee.getSpPersonaAttendeeId();
	}

	/**
	* Sets the sp persona attendee ID of this persona attendee.
	*
	* @param spPersonaAttendeeId the sp persona attendee ID of this persona attendee
	*/
	@Override
	public void setSpPersonaAttendeeId(long spPersonaAttendeeId) {
		_personaAttendee.setSpPersonaAttendeeId(spPersonaAttendeeId);
	}

	/**
	* Returns the group ID of this persona attendee.
	*
	* @return the group ID of this persona attendee
	*/
	@Override
	public long getGroupId() {
		return _personaAttendee.getGroupId();
	}

	/**
	* Sets the group ID of this persona attendee.
	*
	* @param groupId the group ID of this persona attendee
	*/
	@Override
	public void setGroupId(long groupId) {
		_personaAttendee.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this persona attendee.
	*
	* @return the company ID of this persona attendee
	*/
	@Override
	public long getCompanyId() {
		return _personaAttendee.getCompanyId();
	}

	/**
	* Sets the company ID of this persona attendee.
	*
	* @param companyId the company ID of this persona attendee
	*/
	@Override
	public void setCompanyId(long companyId) {
		_personaAttendee.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this persona attendee.
	*
	* @return the user ID of this persona attendee
	*/
	@Override
	public long getUserId() {
		return _personaAttendee.getUserId();
	}

	/**
	* Sets the user ID of this persona attendee.
	*
	* @param userId the user ID of this persona attendee
	*/
	@Override
	public void setUserId(long userId) {
		_personaAttendee.setUserId(userId);
	}

	/**
	* Returns the user uuid of this persona attendee.
	*
	* @return the user uuid of this persona attendee
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _personaAttendee.getUserUuid();
	}

	/**
	* Sets the user uuid of this persona attendee.
	*
	* @param userUuid the user uuid of this persona attendee
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_personaAttendee.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this persona attendee.
	*
	* @return the user name of this persona attendee
	*/
	@Override
	public java.lang.String getUserName() {
		return _personaAttendee.getUserName();
	}

	/**
	* Sets the user name of this persona attendee.
	*
	* @param userName the user name of this persona attendee
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_personaAttendee.setUserName(userName);
	}

	/**
	* Returns the create date of this persona attendee.
	*
	* @return the create date of this persona attendee
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _personaAttendee.getCreateDate();
	}

	/**
	* Sets the create date of this persona attendee.
	*
	* @param createDate the create date of this persona attendee
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_personaAttendee.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this persona attendee.
	*
	* @return the modified date of this persona attendee
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _personaAttendee.getModifiedDate();
	}

	/**
	* Sets the modified date of this persona attendee.
	*
	* @param modifiedDate the modified date of this persona attendee
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_personaAttendee.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the description of this persona attendee.
	*
	* @return the description of this persona attendee
	*/
	@Override
	public java.lang.String getDescription() {
		return _personaAttendee.getDescription();
	}

	/**
	* Sets the description of this persona attendee.
	*
	* @param description the description of this persona attendee
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_personaAttendee.setDescription(description);
	}

	/**
	* Returns the image ID of this persona attendee.
	*
	* @return the image ID of this persona attendee
	*/
	@Override
	public long getImageId() {
		return _personaAttendee.getImageId();
	}

	/**
	* Sets the image ID of this persona attendee.
	*
	* @param imageId the image ID of this persona attendee
	*/
	@Override
	public void setImageId(long imageId) {
		_personaAttendee.setImageId(imageId);
	}

	/**
	* Returns the sp persona ID of this persona attendee.
	*
	* @return the sp persona ID of this persona attendee
	*/
	@Override
	public long getSpPersonaId() {
		return _personaAttendee.getSpPersonaId();
	}

	/**
	* Sets the sp persona ID of this persona attendee.
	*
	* @param spPersonaId the sp persona ID of this persona attendee
	*/
	@Override
	public void setSpPersonaId(long spPersonaId) {
		_personaAttendee.setSpPersonaId(spPersonaId);
	}

	/**
	* Returns the sp course ID of this persona attendee.
	*
	* @return the sp course ID of this persona attendee
	*/
	@Override
	public long getSpCourseId() {
		return _personaAttendee.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this persona attendee.
	*
	* @param spCourseId the sp course ID of this persona attendee
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_personaAttendee.setSpCourseId(spCourseId);
	}

	@Override
	public boolean isNew() {
		return _personaAttendee.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_personaAttendee.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _personaAttendee.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_personaAttendee.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _personaAttendee.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _personaAttendee.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_personaAttendee.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _personaAttendee.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_personaAttendee.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_personaAttendee.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_personaAttendee.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PersonaAttendeeWrapper((PersonaAttendee)_personaAttendee.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.model.PersonaAttendee personaAttendee) {
		return _personaAttendee.compareTo(personaAttendee);
	}

	@Override
	public int hashCode() {
		return _personaAttendee.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.PersonaAttendee> toCacheModel() {
		return _personaAttendee.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee toEscapedModel() {
		return new PersonaAttendeeWrapper(_personaAttendee.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee toUnescapedModel() {
		return new PersonaAttendeeWrapper(_personaAttendee.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _personaAttendee.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _personaAttendee.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_personaAttendee.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonaAttendeeWrapper)) {
			return false;
		}

		PersonaAttendeeWrapper personaAttendeeWrapper = (PersonaAttendeeWrapper)obj;

		if (Validator.equals(_personaAttendee,
					personaAttendeeWrapper._personaAttendee)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public PersonaAttendee getWrappedPersonaAttendee() {
		return _personaAttendee;
	}

	@Override
	public PersonaAttendee getWrappedModel() {
		return _personaAttendee;
	}

	@Override
	public void resetOriginalValues() {
		_personaAttendee.resetOriginalValues();
	}

	private PersonaAttendee _personaAttendee;
}