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

package com.sambaash.platform.srv.startupprofile.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Person}.
 * </p>
 *
 * @author pradeep
 * @see Person
 * @generated
 */
public class PersonWrapper implements Person, ModelWrapper<Person> {
	public PersonWrapper(Person person) {
		_person = person;
	}

	@Override
	public Class<?> getModelClass() {
		return Person.class;
	}

	@Override
	public String getModelClassName() {
		return Person.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("personId", getPersonId());
		attributes.put("name", getName());
		attributes.put("title", getTitle());
		attributes.put("apiPath", getApiPath());
		attributes.put("emailId", getEmailId());
		attributes.put("description", getDescription());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("mobile", getMobile());
		attributes.put("skype", getSkype());
		attributes.put("memberUserId", getMemberUserId());
		attributes.put("extras", getExtras());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long personId = (Long)attributes.get("personId");

		if (personId != null) {
			setPersonId(personId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String apiPath = (String)attributes.get("apiPath");

		if (apiPath != null) {
			setApiPath(apiPath);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String skype = (String)attributes.get("skype");

		if (skype != null) {
			setSkype(skype);
		}

		Long memberUserId = (Long)attributes.get("memberUserId");

		if (memberUserId != null) {
			setMemberUserId(memberUserId);
		}

		String extras = (String)attributes.get("extras");

		if (extras != null) {
			setExtras(extras);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}
	}

	/**
	* Returns the primary key of this person.
	*
	* @return the primary key of this person
	*/
	@Override
	public long getPrimaryKey() {
		return _person.getPrimaryKey();
	}

	/**
	* Sets the primary key of this person.
	*
	* @param primaryKey the primary key of this person
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_person.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this person.
	*
	* @return the uuid of this person
	*/
	@Override
	public java.lang.String getUuid() {
		return _person.getUuid();
	}

	/**
	* Sets the uuid of this person.
	*
	* @param uuid the uuid of this person
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_person.setUuid(uuid);
	}

	/**
	* Returns the person ID of this person.
	*
	* @return the person ID of this person
	*/
	@Override
	public long getPersonId() {
		return _person.getPersonId();
	}

	/**
	* Sets the person ID of this person.
	*
	* @param personId the person ID of this person
	*/
	@Override
	public void setPersonId(long personId) {
		_person.setPersonId(personId);
	}

	/**
	* Returns the name of this person.
	*
	* @return the name of this person
	*/
	@Override
	public java.lang.String getName() {
		return _person.getName();
	}

	/**
	* Sets the name of this person.
	*
	* @param name the name of this person
	*/
	@Override
	public void setName(java.lang.String name) {
		_person.setName(name);
	}

	/**
	* Returns the title of this person.
	*
	* @return the title of this person
	*/
	@Override
	public java.lang.String getTitle() {
		return _person.getTitle();
	}

	/**
	* Sets the title of this person.
	*
	* @param title the title of this person
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_person.setTitle(title);
	}

	/**
	* Returns the api path of this person.
	*
	* @return the api path of this person
	*/
	@Override
	public java.lang.String getApiPath() {
		return _person.getApiPath();
	}

	/**
	* Sets the api path of this person.
	*
	* @param apiPath the api path of this person
	*/
	@Override
	public void setApiPath(java.lang.String apiPath) {
		_person.setApiPath(apiPath);
	}

	/**
	* Returns the email ID of this person.
	*
	* @return the email ID of this person
	*/
	@Override
	public java.lang.String getEmailId() {
		return _person.getEmailId();
	}

	/**
	* Sets the email ID of this person.
	*
	* @param emailId the email ID of this person
	*/
	@Override
	public void setEmailId(java.lang.String emailId) {
		_person.setEmailId(emailId);
	}

	/**
	* Returns the description of this person.
	*
	* @return the description of this person
	*/
	@Override
	public java.lang.String getDescription() {
		return _person.getDescription();
	}

	/**
	* Sets the description of this person.
	*
	* @param description the description of this person
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_person.setDescription(description);
	}

	/**
	* Returns the image url of this person.
	*
	* @return the image url of this person
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _person.getImageUrl();
	}

	/**
	* Sets the image url of this person.
	*
	* @param imageUrl the image url of this person
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_person.setImageUrl(imageUrl);
	}

	/**
	* Returns the mobile of this person.
	*
	* @return the mobile of this person
	*/
	@Override
	public java.lang.String getMobile() {
		return _person.getMobile();
	}

	/**
	* Sets the mobile of this person.
	*
	* @param mobile the mobile of this person
	*/
	@Override
	public void setMobile(java.lang.String mobile) {
		_person.setMobile(mobile);
	}

	/**
	* Returns the skype of this person.
	*
	* @return the skype of this person
	*/
	@Override
	public java.lang.String getSkype() {
		return _person.getSkype();
	}

	/**
	* Sets the skype of this person.
	*
	* @param skype the skype of this person
	*/
	@Override
	public void setSkype(java.lang.String skype) {
		_person.setSkype(skype);
	}

	/**
	* Returns the member user ID of this person.
	*
	* @return the member user ID of this person
	*/
	@Override
	public long getMemberUserId() {
		return _person.getMemberUserId();
	}

	/**
	* Sets the member user ID of this person.
	*
	* @param memberUserId the member user ID of this person
	*/
	@Override
	public void setMemberUserId(long memberUserId) {
		_person.setMemberUserId(memberUserId);
	}

	/**
	* Returns the member user uuid of this person.
	*
	* @return the member user uuid of this person
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getMemberUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _person.getMemberUserUuid();
	}

	/**
	* Sets the member user uuid of this person.
	*
	* @param memberUserUuid the member user uuid of this person
	*/
	@Override
	public void setMemberUserUuid(java.lang.String memberUserUuid) {
		_person.setMemberUserUuid(memberUserUuid);
	}

	/**
	* Returns the extras of this person.
	*
	* @return the extras of this person
	*/
	@Override
	public java.lang.String getExtras() {
		return _person.getExtras();
	}

	/**
	* Sets the extras of this person.
	*
	* @param extras the extras of this person
	*/
	@Override
	public void setExtras(java.lang.String extras) {
		_person.setExtras(extras);
	}

	/**
	* Returns the group ID of this person.
	*
	* @return the group ID of this person
	*/
	@Override
	public long getGroupId() {
		return _person.getGroupId();
	}

	/**
	* Sets the group ID of this person.
	*
	* @param groupId the group ID of this person
	*/
	@Override
	public void setGroupId(long groupId) {
		_person.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this person.
	*
	* @return the company ID of this person
	*/
	@Override
	public long getCompanyId() {
		return _person.getCompanyId();
	}

	/**
	* Sets the company ID of this person.
	*
	* @param companyId the company ID of this person
	*/
	@Override
	public void setCompanyId(long companyId) {
		_person.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this person.
	*
	* @return the user ID of this person
	*/
	@Override
	public long getUserId() {
		return _person.getUserId();
	}

	/**
	* Sets the user ID of this person.
	*
	* @param userId the user ID of this person
	*/
	@Override
	public void setUserId(long userId) {
		_person.setUserId(userId);
	}

	/**
	* Returns the user uuid of this person.
	*
	* @return the user uuid of this person
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _person.getUserUuid();
	}

	/**
	* Sets the user uuid of this person.
	*
	* @param userUuid the user uuid of this person
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_person.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this person.
	*
	* @return the user name of this person
	*/
	@Override
	public java.lang.String getUserName() {
		return _person.getUserName();
	}

	/**
	* Sets the user name of this person.
	*
	* @param userName the user name of this person
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_person.setUserName(userName);
	}

	/**
	* Returns the create date of this person.
	*
	* @return the create date of this person
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _person.getCreateDate();
	}

	/**
	* Sets the create date of this person.
	*
	* @param createDate the create date of this person
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_person.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this person.
	*
	* @return the modified date of this person
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _person.getModifiedDate();
	}

	/**
	* Sets the modified date of this person.
	*
	* @param modifiedDate the modified date of this person
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_person.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the active of this person.
	*
	* @return the active of this person
	*/
	@Override
	public boolean getActive() {
		return _person.getActive();
	}

	/**
	* Returns <code>true</code> if this person is active.
	*
	* @return <code>true</code> if this person is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _person.isActive();
	}

	/**
	* Sets whether this person is active.
	*
	* @param active the active of this person
	*/
	@Override
	public void setActive(boolean active) {
		_person.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _person.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_person.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _person.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_person.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _person.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _person.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_person.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _person.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_person.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_person.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_person.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new PersonWrapper((Person)_person.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.Person person) {
		return _person.compareTo(person);
	}

	@Override
	public int hashCode() {
		return _person.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.Person> toCacheModel() {
		return _person.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Person toEscapedModel() {
		return new PersonWrapper(_person.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Person toUnescapedModel() {
		return new PersonWrapper(_person.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _person.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _person.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_person.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PersonWrapper)) {
			return false;
		}

		PersonWrapper personWrapper = (PersonWrapper)obj;

		if (Validator.equals(_person, personWrapper._person)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _person.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Person getWrappedPerson() {
		return _person;
	}

	@Override
	public Person getWrappedModel() {
		return _person;
	}

	@Override
	public void resetOriginalValues() {
		_person.resetOriginalValues();
	}

	private Person _person;
}