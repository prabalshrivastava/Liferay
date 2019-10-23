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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPATOContacts}.
 * </p>
 *
 * @author pradeep
 * @see SPATOContacts
 * @generated
 */
public class SPATOContactsWrapper implements SPATOContacts,
	ModelWrapper<SPATOContacts> {
	public SPATOContactsWrapper(SPATOContacts spatoContacts) {
		_spatoContacts = spatoContacts;
	}

	@Override
	public Class<?> getModelClass() {
		return SPATOContacts.class;
	}

	@Override
	public String getModelClassName() {
		return SPATOContacts.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spATOContactId", getSpATOContactId());
		attributes.put("groupId", getGroupId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("userId", getUserId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("primaryPrincipalUserId", getPrimaryPrincipalUserId());
		attributes.put("secondaryPrincipalUserId", getSecondaryPrincipalUserId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spATOContactId = (Long)attributes.get("spATOContactId");

		if (spATOContactId != null) {
			setSpATOContactId(spATOContactId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String primaryPrincipalUserId = (String)attributes.get(
				"primaryPrincipalUserId");

		if (primaryPrincipalUserId != null) {
			setPrimaryPrincipalUserId(primaryPrincipalUserId);
		}

		String secondaryPrincipalUserId = (String)attributes.get(
				"secondaryPrincipalUserId");

		if (secondaryPrincipalUserId != null) {
			setSecondaryPrincipalUserId(secondaryPrincipalUserId);
		}
	}

	/**
	* Returns the primary key of this s p a t o contacts.
	*
	* @return the primary key of this s p a t o contacts
	*/
	@Override
	public long getPrimaryKey() {
		return _spatoContacts.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p a t o contacts.
	*
	* @param primaryKey the primary key of this s p a t o contacts
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spatoContacts.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp a t o contact ID of this s p a t o contacts.
	*
	* @return the sp a t o contact ID of this s p a t o contacts
	*/
	@Override
	public long getSpATOContactId() {
		return _spatoContacts.getSpATOContactId();
	}

	/**
	* Sets the sp a t o contact ID of this s p a t o contacts.
	*
	* @param spATOContactId the sp a t o contact ID of this s p a t o contacts
	*/
	@Override
	public void setSpATOContactId(long spATOContactId) {
		_spatoContacts.setSpATOContactId(spATOContactId);
	}

	/**
	* Returns the group ID of this s p a t o contacts.
	*
	* @return the group ID of this s p a t o contacts
	*/
	@Override
	public long getGroupId() {
		return _spatoContacts.getGroupId();
	}

	/**
	* Sets the group ID of this s p a t o contacts.
	*
	* @param groupId the group ID of this s p a t o contacts
	*/
	@Override
	public void setGroupId(long groupId) {
		_spatoContacts.setGroupId(groupId);
	}

	/**
	* Returns the organization ID of this s p a t o contacts.
	*
	* @return the organization ID of this s p a t o contacts
	*/
	@Override
	public long getOrganizationId() {
		return _spatoContacts.getOrganizationId();
	}

	/**
	* Sets the organization ID of this s p a t o contacts.
	*
	* @param organizationId the organization ID of this s p a t o contacts
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_spatoContacts.setOrganizationId(organizationId);
	}

	/**
	* Returns the user ID of this s p a t o contacts.
	*
	* @return the user ID of this s p a t o contacts
	*/
	@Override
	public long getUserId() {
		return _spatoContacts.getUserId();
	}

	/**
	* Sets the user ID of this s p a t o contacts.
	*
	* @param userId the user ID of this s p a t o contacts
	*/
	@Override
	public void setUserId(long userId) {
		_spatoContacts.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p a t o contacts.
	*
	* @return the user uuid of this s p a t o contacts
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spatoContacts.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p a t o contacts.
	*
	* @param userUuid the user uuid of this s p a t o contacts
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spatoContacts.setUserUuid(userUuid);
	}

	/**
	* Returns the first name of this s p a t o contacts.
	*
	* @return the first name of this s p a t o contacts
	*/
	@Override
	public java.lang.String getFirstName() {
		return _spatoContacts.getFirstName();
	}

	/**
	* Sets the first name of this s p a t o contacts.
	*
	* @param firstName the first name of this s p a t o contacts
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_spatoContacts.setFirstName(firstName);
	}

	/**
	* Returns the last name of this s p a t o contacts.
	*
	* @return the last name of this s p a t o contacts
	*/
	@Override
	public java.lang.String getLastName() {
		return _spatoContacts.getLastName();
	}

	/**
	* Sets the last name of this s p a t o contacts.
	*
	* @param lastName the last name of this s p a t o contacts
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_spatoContacts.setLastName(lastName);
	}

	/**
	* Returns the create date of this s p a t o contacts.
	*
	* @return the create date of this s p a t o contacts
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spatoContacts.getCreateDate();
	}

	/**
	* Sets the create date of this s p a t o contacts.
	*
	* @param createDate the create date of this s p a t o contacts
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spatoContacts.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p a t o contacts.
	*
	* @return the modified date of this s p a t o contacts
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spatoContacts.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p a t o contacts.
	*
	* @param modifiedDate the modified date of this s p a t o contacts
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spatoContacts.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the primary principal user ID of this s p a t o contacts.
	*
	* @return the primary principal user ID of this s p a t o contacts
	*/
	@Override
	public java.lang.String getPrimaryPrincipalUserId() {
		return _spatoContacts.getPrimaryPrincipalUserId();
	}

	/**
	* Sets the primary principal user ID of this s p a t o contacts.
	*
	* @param primaryPrincipalUserId the primary principal user ID of this s p a t o contacts
	*/
	@Override
	public void setPrimaryPrincipalUserId(
		java.lang.String primaryPrincipalUserId) {
		_spatoContacts.setPrimaryPrincipalUserId(primaryPrincipalUserId);
	}

	/**
	* Returns the secondary principal user ID of this s p a t o contacts.
	*
	* @return the secondary principal user ID of this s p a t o contacts
	*/
	@Override
	public java.lang.String getSecondaryPrincipalUserId() {
		return _spatoContacts.getSecondaryPrincipalUserId();
	}

	/**
	* Sets the secondary principal user ID of this s p a t o contacts.
	*
	* @param secondaryPrincipalUserId the secondary principal user ID of this s p a t o contacts
	*/
	@Override
	public void setSecondaryPrincipalUserId(
		java.lang.String secondaryPrincipalUserId) {
		_spatoContacts.setSecondaryPrincipalUserId(secondaryPrincipalUserId);
	}

	@Override
	public boolean isNew() {
		return _spatoContacts.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spatoContacts.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spatoContacts.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spatoContacts.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spatoContacts.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spatoContacts.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spatoContacts.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spatoContacts.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spatoContacts.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spatoContacts.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spatoContacts.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPATOContactsWrapper((SPATOContacts)_spatoContacts.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts) {
		return _spatoContacts.compareTo(spatoContacts);
	}

	@Override
	public int hashCode() {
		return _spatoContacts.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> toCacheModel() {
		return _spatoContacts.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts toEscapedModel() {
		return new SPATOContactsWrapper(_spatoContacts.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts toUnescapedModel() {
		return new SPATOContactsWrapper(_spatoContacts.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spatoContacts.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spatoContacts.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spatoContacts.persist();
	}

	@Override
	public int getPrimaryTitleId() {
		return _spatoContacts.getPrimaryTitleId();
	}

	@Override
	public void setPrimaryTitleId(int primaryTitleId) {
		_spatoContacts.setPrimaryTitleId(primaryTitleId);
	}

	@Override
	public java.lang.String getPrimaryJobTitle() {
		return _spatoContacts.getPrimaryJobTitle();
	}

	@Override
	public void setPrimaryJobTitle(java.lang.String primaryJobTitle) {
		_spatoContacts.setPrimaryJobTitle(primaryJobTitle);
	}

	@Override
	public java.lang.String getPrimaryMobile() {
		return _spatoContacts.getPrimaryMobile();
	}

	@Override
	public void setPrimaryMobile(java.lang.String primaryMobile) {
		_spatoContacts.setPrimaryMobile(primaryMobile);
	}

	@Override
	public int getSecondaryTitleId() {
		return _spatoContacts.getSecondaryTitleId();
	}

	@Override
	public void setSecondaryTitleId(int secondaryTitleId) {
		_spatoContacts.setSecondaryTitleId(secondaryTitleId);
	}

	@Override
	public java.lang.String getSecondaryJobTitle() {
		return _spatoContacts.getSecondaryJobTitle();
	}

	@Override
	public void setSecondaryJobTitle(java.lang.String secondaryJobTitle) {
		_spatoContacts.setSecondaryJobTitle(secondaryJobTitle);
	}

	@Override
	public java.lang.String getSecondaryMobile() {
		return _spatoContacts.getSecondaryMobile();
	}

	@Override
	public void setSecondaryMobile(java.lang.String secondaryMobile) {
		_spatoContacts.setSecondaryMobile(secondaryMobile);
	}

	@Override
	public java.lang.String getPrimaryPrincipalUserEmail() {
		return _spatoContacts.getPrimaryPrincipalUserEmail();
	}

	@Override
	public void setPrimaryPrincipalUserEmail(
		java.lang.String primaryPrincipalUserEmail) {
		_spatoContacts.setPrimaryPrincipalUserEmail(primaryPrincipalUserEmail);
	}

	@Override
	public java.lang.String getPrimaryPrincipalUserFirstName() {
		return _spatoContacts.getPrimaryPrincipalUserFirstName();
	}

	@Override
	public void setPrimaryPrincipalUserFirstName(
		java.lang.String primaryPrincipalUserFirstName) {
		_spatoContacts.setPrimaryPrincipalUserFirstName(primaryPrincipalUserFirstName);
	}

	@Override
	public java.lang.String getPrimaryPrincipalUserLastName() {
		return _spatoContacts.getPrimaryPrincipalUserLastName();
	}

	@Override
	public void setPrimaryPrincipalUserLastName(
		java.lang.String primaryPrincipalUserLastName) {
		_spatoContacts.setPrimaryPrincipalUserLastName(primaryPrincipalUserLastName);
	}

	@Override
	public java.lang.String getSecondaryPrincipalUserEmail() {
		return _spatoContacts.getSecondaryPrincipalUserEmail();
	}

	@Override
	public void setSecondaryPrincipalUserEmail(
		java.lang.String secondaryPrincipalUserEmail) {
		_spatoContacts.setSecondaryPrincipalUserEmail(secondaryPrincipalUserEmail);
	}

	@Override
	public java.lang.String getSecondaryPrincipalUserFirstName() {
		return _spatoContacts.getSecondaryPrincipalUserFirstName();
	}

	@Override
	public void setSecondaryPrincipalUserFirstName(
		java.lang.String secondaryPrincipalUserFirstName) {
		_spatoContacts.setSecondaryPrincipalUserFirstName(secondaryPrincipalUserFirstName);
	}

	@Override
	public java.lang.String getSecondaryPrincipalUserLastName() {
		return _spatoContacts.getSecondaryPrincipalUserLastName();
	}

	@Override
	public void setSecondaryPrincipalUserLastName(
		java.lang.String secondaryPrincipalUserLastName) {
		_spatoContacts.setSecondaryPrincipalUserLastName(secondaryPrincipalUserLastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPATOContactsWrapper)) {
			return false;
		}

		SPATOContactsWrapper spatoContactsWrapper = (SPATOContactsWrapper)obj;

		if (Validator.equals(_spatoContacts, spatoContactsWrapper._spatoContacts)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPATOContacts getWrappedSPATOContacts() {
		return _spatoContacts;
	}

	@Override
	public SPATOContacts getWrappedModel() {
		return _spatoContacts;
	}

	@Override
	public void resetOriginalValues() {
		_spatoContacts.resetOriginalValues();
	}

	private SPATOContacts _spatoContacts;
}