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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the PersonaAttendee service. Represents a row in the &quot;SPPersonaAttendee&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.PersonaAttendeeImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see PersonaAttendee
 * @see com.sambaash.platform.srv.model.impl.PersonaAttendeeImpl
 * @see com.sambaash.platform.srv.model.impl.PersonaAttendeeModelImpl
 * @generated
 */
public interface PersonaAttendeeModel extends BaseModel<PersonaAttendee>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a persona attendee model instance should use the {@link PersonaAttendee} interface instead.
	 */

	/**
	 * Returns the primary key of this persona attendee.
	 *
	 * @return the primary key of this persona attendee
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this persona attendee.
	 *
	 * @param primaryKey the primary key of this persona attendee
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp persona attendee ID of this persona attendee.
	 *
	 * @return the sp persona attendee ID of this persona attendee
	 */
	public long getSpPersonaAttendeeId();

	/**
	 * Sets the sp persona attendee ID of this persona attendee.
	 *
	 * @param spPersonaAttendeeId the sp persona attendee ID of this persona attendee
	 */
	public void setSpPersonaAttendeeId(long spPersonaAttendeeId);

	/**
	 * Returns the group ID of this persona attendee.
	 *
	 * @return the group ID of this persona attendee
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this persona attendee.
	 *
	 * @param groupId the group ID of this persona attendee
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this persona attendee.
	 *
	 * @return the company ID of this persona attendee
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this persona attendee.
	 *
	 * @param companyId the company ID of this persona attendee
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this persona attendee.
	 *
	 * @return the user ID of this persona attendee
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this persona attendee.
	 *
	 * @param userId the user ID of this persona attendee
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this persona attendee.
	 *
	 * @return the user uuid of this persona attendee
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this persona attendee.
	 *
	 * @param userUuid the user uuid of this persona attendee
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this persona attendee.
	 *
	 * @return the user name of this persona attendee
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this persona attendee.
	 *
	 * @param userName the user name of this persona attendee
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this persona attendee.
	 *
	 * @return the create date of this persona attendee
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this persona attendee.
	 *
	 * @param createDate the create date of this persona attendee
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this persona attendee.
	 *
	 * @return the modified date of this persona attendee
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this persona attendee.
	 *
	 * @param modifiedDate the modified date of this persona attendee
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the description of this persona attendee.
	 *
	 * @return the description of this persona attendee
	 */
	@AutoEscape
	public String getDescription();

	/**
	 * Sets the description of this persona attendee.
	 *
	 * @param description the description of this persona attendee
	 */
	public void setDescription(String description);

	/**
	 * Returns the image ID of this persona attendee.
	 *
	 * @return the image ID of this persona attendee
	 */
	public long getImageId();

	/**
	 * Sets the image ID of this persona attendee.
	 *
	 * @param imageId the image ID of this persona attendee
	 */
	public void setImageId(long imageId);

	/**
	 * Returns the sp persona ID of this persona attendee.
	 *
	 * @return the sp persona ID of this persona attendee
	 */
	public long getSpPersonaId();

	/**
	 * Sets the sp persona ID of this persona attendee.
	 *
	 * @param spPersonaId the sp persona ID of this persona attendee
	 */
	public void setSpPersonaId(long spPersonaId);

	/**
	 * Returns the sp course ID of this persona attendee.
	 *
	 * @return the sp course ID of this persona attendee
	 */
	public long getSpCourseId();

	/**
	 * Sets the sp course ID of this persona attendee.
	 *
	 * @param spCourseId the sp course ID of this persona attendee
	 */
	public void setSpCourseId(long spCourseId);

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
		com.sambaash.platform.srv.model.PersonaAttendee personaAttendee);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.PersonaAttendee> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.PersonaAttendee toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}