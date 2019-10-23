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
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the ApprovedMentors service. Represents a row in the &quot;SPMentors&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsImpl}.
 * </p>
 *
 * @author pradeep
 * @see ApprovedMentors
 * @see com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsImpl
 * @see com.sambaash.platform.srv.startupprofile.model.impl.ApprovedMentorsModelImpl
 * @generated
 */
public interface ApprovedMentorsModel extends BaseModel<ApprovedMentors> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a approved mentors model instance should use the {@link ApprovedMentors} interface instead.
	 */

	/**
	 * Returns the primary key of this approved mentors.
	 *
	 * @return the primary key of this approved mentors
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this approved mentors.
	 *
	 * @param primaryKey the primary key of this approved mentors
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this approved mentors.
	 *
	 * @return the uuid of this approved mentors
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this approved mentors.
	 *
	 * @param uuid the uuid of this approved mentors
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the mentor ID of this approved mentors.
	 *
	 * @return the mentor ID of this approved mentors
	 */
	public long getMentorId();

	/**
	 * Sets the mentor ID of this approved mentors.
	 *
	 * @param mentorId the mentor ID of this approved mentors
	 */
	public void setMentorId(long mentorId);

	/**
	 * Returns the organization ID of this approved mentors.
	 *
	 * @return the organization ID of this approved mentors
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this approved mentors.
	 *
	 * @param organizationId the organization ID of this approved mentors
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the user ID of this approved mentors.
	 *
	 * @return the user ID of this approved mentors
	 */
	@AutoEscape
	public String getUserId();

	/**
	 * Sets the user ID of this approved mentors.
	 *
	 * @param userId the user ID of this approved mentors
	 */
	public void setUserId(String userId);

	/**
	 * Returns the create date of this approved mentors.
	 *
	 * @return the create date of this approved mentors
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this approved mentors.
	 *
	 * @param createDate the create date of this approved mentors
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the approved date of this approved mentors.
	 *
	 * @return the approved date of this approved mentors
	 */
	public Date getApprovedDate();

	/**
	 * Sets the approved date of this approved mentors.
	 *
	 * @param approvedDate the approved date of this approved mentors
	 */
	public void setApprovedDate(Date approvedDate);

	/**
	 * Returns the remarks of this approved mentors.
	 *
	 * @return the remarks of this approved mentors
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this approved mentors.
	 *
	 * @param remarks the remarks of this approved mentors
	 */
	public void setRemarks(String remarks);

	/**
	 * Returns the status of this approved mentors.
	 *
	 * @return the status of this approved mentors
	 */
	public int getStatus();

	/**
	 * Sets the status of this approved mentors.
	 *
	 * @param status the status of this approved mentors
	 */
	public void setStatus(int status);

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
		com.sambaash.platform.srv.startupprofile.model.ApprovedMentors approvedMentors);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.startupprofile.model.ApprovedMentors> toCacheModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ApprovedMentors toEscapedModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ApprovedMentors toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}