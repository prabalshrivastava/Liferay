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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SPATOContacts service. Represents a row in the &quot;SPATOContacts&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsImpl}.
 * </p>
 *
 * @author pradeep
 * @see SPATOContacts
 * @see com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsImpl
 * @see com.sambaash.platform.srv.startupprofile.model.impl.SPATOContactsModelImpl
 * @generated
 */
public interface SPATOContactsModel extends BaseModel<SPATOContacts> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p a t o contacts model instance should use the {@link SPATOContacts} interface instead.
	 */

	/**
	 * Returns the primary key of this s p a t o contacts.
	 *
	 * @return the primary key of this s p a t o contacts
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p a t o contacts.
	 *
	 * @param primaryKey the primary key of this s p a t o contacts
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp a t o contact ID of this s p a t o contacts.
	 *
	 * @return the sp a t o contact ID of this s p a t o contacts
	 */
	public long getSpATOContactId();

	/**
	 * Sets the sp a t o contact ID of this s p a t o contacts.
	 *
	 * @param spATOContactId the sp a t o contact ID of this s p a t o contacts
	 */
	public void setSpATOContactId(long spATOContactId);

	/**
	 * Returns the group ID of this s p a t o contacts.
	 *
	 * @return the group ID of this s p a t o contacts
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this s p a t o contacts.
	 *
	 * @param groupId the group ID of this s p a t o contacts
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the organization ID of this s p a t o contacts.
	 *
	 * @return the organization ID of this s p a t o contacts
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this s p a t o contacts.
	 *
	 * @param organizationId the organization ID of this s p a t o contacts
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the user ID of this s p a t o contacts.
	 *
	 * @return the user ID of this s p a t o contacts
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this s p a t o contacts.
	 *
	 * @param userId the user ID of this s p a t o contacts
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p a t o contacts.
	 *
	 * @return the user uuid of this s p a t o contacts
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p a t o contacts.
	 *
	 * @param userUuid the user uuid of this s p a t o contacts
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the first name of this s p a t o contacts.
	 *
	 * @return the first name of this s p a t o contacts
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this s p a t o contacts.
	 *
	 * @param firstName the first name of this s p a t o contacts
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this s p a t o contacts.
	 *
	 * @return the last name of this s p a t o contacts
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this s p a t o contacts.
	 *
	 * @param lastName the last name of this s p a t o contacts
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the create date of this s p a t o contacts.
	 *
	 * @return the create date of this s p a t o contacts
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p a t o contacts.
	 *
	 * @param createDate the create date of this s p a t o contacts
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p a t o contacts.
	 *
	 * @return the modified date of this s p a t o contacts
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p a t o contacts.
	 *
	 * @param modifiedDate the modified date of this s p a t o contacts
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the primary principal user ID of this s p a t o contacts.
	 *
	 * @return the primary principal user ID of this s p a t o contacts
	 */
	@AutoEscape
	public String getPrimaryPrincipalUserId();

	/**
	 * Sets the primary principal user ID of this s p a t o contacts.
	 *
	 * @param primaryPrincipalUserId the primary principal user ID of this s p a t o contacts
	 */
	public void setPrimaryPrincipalUserId(String primaryPrincipalUserId);

	/**
	 * Returns the secondary principal user ID of this s p a t o contacts.
	 *
	 * @return the secondary principal user ID of this s p a t o contacts
	 */
	@AutoEscape
	public String getSecondaryPrincipalUserId();

	/**
	 * Sets the secondary principal user ID of this s p a t o contacts.
	 *
	 * @param secondaryPrincipalUserId the secondary principal user ID of this s p a t o contacts
	 */
	public void setSecondaryPrincipalUserId(String secondaryPrincipalUserId);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.SPATOContacts spatoContacts);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.startupprofile.model.SPATOContacts> toCacheModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts toEscapedModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.SPATOContacts toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}