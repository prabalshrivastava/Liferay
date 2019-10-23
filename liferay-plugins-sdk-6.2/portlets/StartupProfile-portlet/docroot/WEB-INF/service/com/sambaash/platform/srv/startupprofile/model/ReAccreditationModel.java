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
 * The base model interface for the ReAccreditation service. Represents a row in the &quot;SPReAccreditation&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationImpl}.
 * </p>
 *
 * @author pradeep
 * @see ReAccreditation
 * @see com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationImpl
 * @see com.sambaash.platform.srv.startupprofile.model.impl.ReAccreditationModelImpl
 * @generated
 */
public interface ReAccreditationModel extends BaseModel<ReAccreditation> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a re accreditation model instance should use the {@link ReAccreditation} interface instead.
	 */

	/**
	 * Returns the primary key of this re accreditation.
	 *
	 * @return the primary key of this re accreditation
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this re accreditation.
	 *
	 * @param primaryKey the primary key of this re accreditation
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this re accreditation.
	 *
	 * @return the uuid of this re accreditation
	 */
	@AutoEscape
	public String getUuid();

	/**
	 * Sets the uuid of this re accreditation.
	 *
	 * @param uuid the uuid of this re accreditation
	 */
	public void setUuid(String uuid);

	/**
	 * Returns the accreditation ID of this re accreditation.
	 *
	 * @return the accreditation ID of this re accreditation
	 */
	public long getAccreditationId();

	/**
	 * Sets the accreditation ID of this re accreditation.
	 *
	 * @param accreditationId the accreditation ID of this re accreditation
	 */
	public void setAccreditationId(long accreditationId);

	/**
	 * Returns the organization ID of this re accreditation.
	 *
	 * @return the organization ID of this re accreditation
	 */
	public long getOrganizationId();

	/**
	 * Sets the organization ID of this re accreditation.
	 *
	 * @param organizationId the organization ID of this re accreditation
	 */
	public void setOrganizationId(long organizationId);

	/**
	 * Returns the accreditation status of this re accreditation.
	 *
	 * @return the accreditation status of this re accreditation
	 */
	@AutoEscape
	public String getAccreditationStatus();

	/**
	 * Sets the accreditation status of this re accreditation.
	 *
	 * @param accreditationStatus the accreditation status of this re accreditation
	 */
	public void setAccreditationStatus(String accreditationStatus);

	/**
	 * Returns the date of accreditation of this re accreditation.
	 *
	 * @return the date of accreditation of this re accreditation
	 */
	public Date getDateOfAccreditation();

	/**
	 * Sets the date of accreditation of this re accreditation.
	 *
	 * @param dateOfAccreditation the date of accreditation of this re accreditation
	 */
	public void setDateOfAccreditation(Date dateOfAccreditation);

	/**
	 * Returns the date of expiry of this re accreditation.
	 *
	 * @return the date of expiry of this re accreditation
	 */
	public Date getDateOfExpiry();

	/**
	 * Sets the date of expiry of this re accreditation.
	 *
	 * @param dateOfExpiry the date of expiry of this re accreditation
	 */
	public void setDateOfExpiry(Date dateOfExpiry);

	/**
	 * Returns the latest payment date of this re accreditation.
	 *
	 * @return the latest payment date of this re accreditation
	 */
	public Date getLatestPaymentDate();

	/**
	 * Sets the latest payment date of this re accreditation.
	 *
	 * @param latestPaymentDate the latest payment date of this re accreditation
	 */
	public void setLatestPaymentDate(Date latestPaymentDate);

	/**
	 * Returns the start date of reaccreditation of this re accreditation.
	 *
	 * @return the start date of reaccreditation of this re accreditation
	 */
	public Date getStartDateOfReaccreditation();

	/**
	 * Sets the start date of reaccreditation of this re accreditation.
	 *
	 * @param startDateOfReaccreditation the start date of reaccreditation of this re accreditation
	 */
	public void setStartDateOfReaccreditation(Date startDateOfReaccreditation);

	/**
	 * Returns the date of reaccdt review of this re accreditation.
	 *
	 * @return the date of reaccdt review of this re accreditation
	 */
	public Date getDateOfReaccdtReview();

	/**
	 * Sets the date of reaccdt review of this re accreditation.
	 *
	 * @param dateOfReaccdtReview the date of reaccdt review of this re accreditation
	 */
	public void setDateOfReaccdtReview(Date dateOfReaccdtReview);

	/**
	 * Returns the accreditation by of this re accreditation.
	 *
	 * @return the accreditation by of this re accreditation
	 */
	@AutoEscape
	public String getAccreditationBy();

	/**
	 * Sets the accreditation by of this re accreditation.
	 *
	 * @param AccreditationBy the accreditation by of this re accreditation
	 */
	public void setAccreditationBy(String AccreditationBy);

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
		com.sambaash.platform.srv.startupprofile.model.ReAccreditation reAccreditation);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> toCacheModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation toEscapedModel();

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}