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
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the OrganisationRemarks service. Represents a row in the &quot;SPOrganisationRemarks&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksImpl}.
 * </p>
 *
 * @author pradeep
 * @see OrganisationRemarks
 * @see com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksImpl
 * @see com.sambaash.platform.srv.startupprofile.model.impl.OrganisationRemarksModelImpl
 * @generated
 */
public interface OrganisationRemarksModel extends BaseModel<OrganisationRemarks>,
	GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a organisation remarks model instance should use the {@link OrganisationRemarks} interface instead.
	 */

	/**
	 * Returns the primary key of this organisation remarks.
	 *
	 * @return the primary key of this organisation remarks
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this organisation remarks.
	 *
	 * @param primaryKey the primary key of this organisation remarks
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the remarks ID of this organisation remarks.
	 *
	 * @return the remarks ID of this organisation remarks
	 */
	public long getRemarksId();

	/**
	 * Sets the remarks ID of this organisation remarks.
	 *
	 * @param remarksId the remarks ID of this organisation remarks
	 */
	public void setRemarksId(long remarksId);

	/**
	 * Returns the organization ID of this organisation remarks.
	 *
	 * @return the organization ID of this organisation remarks
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this organisation remarks.
	 *
	 * @param organizationId the organization ID of this organisation remarks
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the remark type of this organisation remarks.
	 *
	 * @return the remark type of this organisation remarks
	 */
	@AutoEscape
	public String getRemarkType();

	/**
	 * Sets the remark type of this organisation remarks.
	 *
	 * @param remarkType the remark type of this organisation remarks
	 */
	public void setRemarkType(String remarkType);

	/**
	 * Returns the remarks of this organisation remarks.
	 *
	 * @return the remarks of this organisation remarks
	 */
	@AutoEscape
	public String getRemarks();

	/**
	 * Sets the remarks of this organisation remarks.
	 *
	 * @param Remarks the remarks of this organisation remarks
	 */
	public void setRemarks(String Remarks);

	/**
	 * Returns the notes of this organisation remarks.
	 *
	 * @return the notes of this organisation remarks
	 */
	@AutoEscape
	public String getNotes();

	/**
	 * Sets the notes of this organisation remarks.
	 *
	 * @param Notes the notes of this organisation remarks
	 */
	public void setNotes(String Notes);

	/**
	 * Returns the group ID of this organisation remarks.
	 *
	 * @return the group ID of this organisation remarks
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this organisation remarks.
	 *
	 * @param groupId the group ID of this organisation remarks
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this organisation remarks.
	 *
	 * @return the company ID of this organisation remarks
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this organisation remarks.
	 *
	 * @param companyId the company ID of this organisation remarks
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this organisation remarks.
	 *
	 * @return the user ID of this organisation remarks
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this organisation remarks.
	 *
	 * @param userId the user ID of this organisation remarks
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this organisation remarks.
	 *
	 * @return the user uuid of this organisation remarks
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this organisation remarks.
	 *
	 * @param userUuid the user uuid of this organisation remarks
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this organisation remarks.
	 *
	 * @return the user name of this organisation remarks
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this organisation remarks.
	 *
	 * @param userName the user name of this organisation remarks
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this organisation remarks.
	 *
	 * @return the create date of this organisation remarks
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this organisation remarks.
	 *
	 * @param createDate the create date of this organisation remarks
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this organisation remarks.
	 *
	 * @return the modified date of this organisation remarks
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this organisation remarks.
	 *
	 * @param modifiedDate the modified date of this organisation remarks
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

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
		com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks organisationRemarks);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks> toCacheModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks toEscapedModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.OrganisationRemarks toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}