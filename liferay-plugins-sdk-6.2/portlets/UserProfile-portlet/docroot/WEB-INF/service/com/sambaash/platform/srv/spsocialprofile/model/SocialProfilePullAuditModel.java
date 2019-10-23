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

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import com.sambaash.platform.srv.spsocialprofile.service.persistence.SocialProfilePullAuditPK;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SocialProfilePullAudit service. Represents a row in the &quot;SPSocialProfilePullAudit&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfilePullAudit
 * @see com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditImpl
 * @see com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfilePullAuditModelImpl
 * @generated
 */
public interface SocialProfilePullAuditModel extends BaseModel<SocialProfilePullAudit> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a social profile pull audit model instance should use the {@link SocialProfilePullAudit} interface instead.
	 */

	/**
	 * Returns the primary key of this social profile pull audit.
	 *
	 * @return the primary key of this social profile pull audit
	 */
	public SocialProfilePullAuditPK getPrimaryKey();

	/**
	 * Sets the primary key of this social profile pull audit.
	 *
	 * @param primaryKey the primary key of this social profile pull audit
	 */
	public void setPrimaryKey(SocialProfilePullAuditPK primaryKey);

	/**
	 * Returns the user ID of this social profile pull audit.
	 *
	 * @return the user ID of this social profile pull audit
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this social profile pull audit.
	 *
	 * @param userId the user ID of this social profile pull audit
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this social profile pull audit.
	 *
	 * @return the user uuid of this social profile pull audit
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this social profile pull audit.
	 *
	 * @param userUuid the user uuid of this social profile pull audit
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the social network profile ID of this social profile pull audit.
	 *
	 * @return the social network profile ID of this social profile pull audit
	 */
	public long getSocialNetworkProfileId();

	/**
	 * Sets the social network profile ID of this social profile pull audit.
	 *
	 * @param socialNetworkProfileId the social network profile ID of this social profile pull audit
	 */
	public void setSocialNetworkProfileId(long socialNetworkProfileId);

	/**
	 * Returns the company ID of this social profile pull audit.
	 *
	 * @return the company ID of this social profile pull audit
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this social profile pull audit.
	 *
	 * @param companyId the company ID of this social profile pull audit
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this social profile pull audit.
	 *
	 * @return the create date of this social profile pull audit
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this social profile pull audit.
	 *
	 * @param createDate the create date of this social profile pull audit
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the last queried date of this social profile pull audit.
	 *
	 * @return the last queried date of this social profile pull audit
	 */
	public Date getLastQueriedDate();

	/**
	 * Sets the last queried date of this social profile pull audit.
	 *
	 * @param lastQueriedDate the last queried date of this social profile pull audit
	 */
	public void setLastQueriedDate(Date lastQueriedDate);

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
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit socialProfilePullAudit);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfilePullAudit toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}