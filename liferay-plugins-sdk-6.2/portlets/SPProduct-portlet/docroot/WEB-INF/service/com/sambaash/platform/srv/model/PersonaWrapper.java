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
 * This class is a wrapper for {@link Persona}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Persona
 * @generated
 */
public class PersonaWrapper implements Persona, ModelWrapper<Persona> {
	public PersonaWrapper(Persona persona) {
		_persona = persona;
	}

	@Override
	public Class<?> getModelClass() {
		return Persona.class;
	}

	@Override
	public String getModelClassName() {
		return Persona.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spPersonaId", getSpPersonaId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("personaType", getPersonaType());
		attributes.put("ageGroup", getAgeGroup());
		attributes.put("personaDesc", getPersonaDesc());
		attributes.put("personaImageId", getPersonaImageId());
		attributes.put("spCourseId", getSpCourseId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spPersonaId = (Long)attributes.get("spPersonaId");

		if (spPersonaId != null) {
			setSpPersonaId(spPersonaId);
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

		Long personaType = (Long)attributes.get("personaType");

		if (personaType != null) {
			setPersonaType(personaType);
		}

		String ageGroup = (String)attributes.get("ageGroup");

		if (ageGroup != null) {
			setAgeGroup(ageGroup);
		}

		String personaDesc = (String)attributes.get("personaDesc");

		if (personaDesc != null) {
			setPersonaDesc(personaDesc);
		}

		Long personaImageId = (Long)attributes.get("personaImageId");

		if (personaImageId != null) {
			setPersonaImageId(personaImageId);
		}

		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
		}
	}

	/**
	* Returns the primary key of this persona.
	*
	* @return the primary key of this persona
	*/
	@Override
	public long getPrimaryKey() {
		return _persona.getPrimaryKey();
	}

	/**
	* Sets the primary key of this persona.
	*
	* @param primaryKey the primary key of this persona
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_persona.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp persona ID of this persona.
	*
	* @return the sp persona ID of this persona
	*/
	@Override
	public long getSpPersonaId() {
		return _persona.getSpPersonaId();
	}

	/**
	* Sets the sp persona ID of this persona.
	*
	* @param spPersonaId the sp persona ID of this persona
	*/
	@Override
	public void setSpPersonaId(long spPersonaId) {
		_persona.setSpPersonaId(spPersonaId);
	}

	/**
	* Returns the group ID of this persona.
	*
	* @return the group ID of this persona
	*/
	@Override
	public long getGroupId() {
		return _persona.getGroupId();
	}

	/**
	* Sets the group ID of this persona.
	*
	* @param groupId the group ID of this persona
	*/
	@Override
	public void setGroupId(long groupId) {
		_persona.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this persona.
	*
	* @return the company ID of this persona
	*/
	@Override
	public long getCompanyId() {
		return _persona.getCompanyId();
	}

	/**
	* Sets the company ID of this persona.
	*
	* @param companyId the company ID of this persona
	*/
	@Override
	public void setCompanyId(long companyId) {
		_persona.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this persona.
	*
	* @return the user ID of this persona
	*/
	@Override
	public long getUserId() {
		return _persona.getUserId();
	}

	/**
	* Sets the user ID of this persona.
	*
	* @param userId the user ID of this persona
	*/
	@Override
	public void setUserId(long userId) {
		_persona.setUserId(userId);
	}

	/**
	* Returns the user uuid of this persona.
	*
	* @return the user uuid of this persona
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _persona.getUserUuid();
	}

	/**
	* Sets the user uuid of this persona.
	*
	* @param userUuid the user uuid of this persona
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_persona.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this persona.
	*
	* @return the user name of this persona
	*/
	@Override
	public java.lang.String getUserName() {
		return _persona.getUserName();
	}

	/**
	* Sets the user name of this persona.
	*
	* @param userName the user name of this persona
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_persona.setUserName(userName);
	}

	/**
	* Returns the create date of this persona.
	*
	* @return the create date of this persona
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _persona.getCreateDate();
	}

	/**
	* Sets the create date of this persona.
	*
	* @param createDate the create date of this persona
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_persona.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this persona.
	*
	* @return the modified date of this persona
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _persona.getModifiedDate();
	}

	/**
	* Sets the modified date of this persona.
	*
	* @param modifiedDate the modified date of this persona
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_persona.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the persona type of this persona.
	*
	* @return the persona type of this persona
	*/
	@Override
	public long getPersonaType() {
		return _persona.getPersonaType();
	}

	/**
	* Sets the persona type of this persona.
	*
	* @param personaType the persona type of this persona
	*/
	@Override
	public void setPersonaType(long personaType) {
		_persona.setPersonaType(personaType);
	}

	/**
	* Returns the age group of this persona.
	*
	* @return the age group of this persona
	*/
	@Override
	public java.lang.String getAgeGroup() {
		return _persona.getAgeGroup();
	}

	/**
	* Sets the age group of this persona.
	*
	* @param ageGroup the age group of this persona
	*/
	@Override
	public void setAgeGroup(java.lang.String ageGroup) {
		_persona.setAgeGroup(ageGroup);
	}

	/**
	* Returns the persona desc of this persona.
	*
	* @return the persona desc of this persona
	*/
	@Override
	public java.lang.String getPersonaDesc() {
		return _persona.getPersonaDesc();
	}

	/**
	* Sets the persona desc of this persona.
	*
	* @param personaDesc the persona desc of this persona
	*/
	@Override
	public void setPersonaDesc(java.lang.String personaDesc) {
		_persona.setPersonaDesc(personaDesc);
	}

	/**
	* Returns the persona image ID of this persona.
	*
	* @return the persona image ID of this persona
	*/
	@Override
	public long getPersonaImageId() {
		return _persona.getPersonaImageId();
	}

	/**
	* Sets the persona image ID of this persona.
	*
	* @param personaImageId the persona image ID of this persona
	*/
	@Override
	public void setPersonaImageId(long personaImageId) {
		_persona.setPersonaImageId(personaImageId);
	}

	/**
	* Returns the sp course ID of this persona.
	*
	* @return the sp course ID of this persona
	*/
	@Override
	public long getSpCourseId() {
		return _persona.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this persona.
	*
	* @param spCourseId the sp course ID of this persona
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_persona.setSpCourseId(spCourseId);
	}

	@Override
	public boolean isNew() {
		return _persona.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_persona.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _persona.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_persona.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _persona.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _persona.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_persona.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _persona.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_persona.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_persona.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_persona.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PersonaWrapper((Persona)_persona.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Persona persona) {
		return _persona.compareTo(persona);
	}

	@Override
	public int hashCode() {
		return _persona.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Persona> toCacheModel() {
		return _persona.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Persona toEscapedModel() {
		return new PersonaWrapper(_persona.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Persona toUnescapedModel() {
		return new PersonaWrapper(_persona.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _persona.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _persona.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_persona.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonaWrapper)) {
			return false;
		}

		PersonaWrapper personaWrapper = (PersonaWrapper)obj;

		if (Validator.equals(_persona, personaWrapper._persona)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Persona getWrappedPersona() {
		return _persona;
	}

	@Override
	public Persona getWrappedModel() {
		return _persona;
	}

	@Override
	public void resetOriginalValues() {
		_persona.resetOriginalValues();
	}

	private Persona _persona;
}