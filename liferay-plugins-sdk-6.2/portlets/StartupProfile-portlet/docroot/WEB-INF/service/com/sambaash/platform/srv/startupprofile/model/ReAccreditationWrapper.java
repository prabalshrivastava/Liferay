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
 * This class is a wrapper for {@link ReAccreditation}.
 * </p>
 *
 * @author pradeep
 * @see ReAccreditation
 * @generated
 */
public class ReAccreditationWrapper implements ReAccreditation,
	ModelWrapper<ReAccreditation> {
	public ReAccreditationWrapper(ReAccreditation reAccreditation) {
		_reAccreditation = reAccreditation;
	}

	@Override
	public Class<?> getModelClass() {
		return ReAccreditation.class;
	}

	@Override
	public String getModelClassName() {
		return ReAccreditation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("accreditationId", getAccreditationId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("accreditationStatus", getAccreditationStatus());
		attributes.put("dateOfAccreditation", getDateOfAccreditation());
		attributes.put("dateOfExpiry", getDateOfExpiry());
		attributes.put("latestPaymentDate", getLatestPaymentDate());
		attributes.put("startDateOfReaccreditation",
			getStartDateOfReaccreditation());
		attributes.put("dateOfReaccdtReview", getDateOfReaccdtReview());
		attributes.put("AccreditationBy", getAccreditationBy());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long accreditationId = (Long)attributes.get("accreditationId");

		if (accreditationId != null) {
			setAccreditationId(accreditationId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String accreditationStatus = (String)attributes.get(
				"accreditationStatus");

		if (accreditationStatus != null) {
			setAccreditationStatus(accreditationStatus);
		}

		Date dateOfAccreditation = (Date)attributes.get("dateOfAccreditation");

		if (dateOfAccreditation != null) {
			setDateOfAccreditation(dateOfAccreditation);
		}

		Date dateOfExpiry = (Date)attributes.get("dateOfExpiry");

		if (dateOfExpiry != null) {
			setDateOfExpiry(dateOfExpiry);
		}

		Date latestPaymentDate = (Date)attributes.get("latestPaymentDate");

		if (latestPaymentDate != null) {
			setLatestPaymentDate(latestPaymentDate);
		}

		Date startDateOfReaccreditation = (Date)attributes.get(
				"startDateOfReaccreditation");

		if (startDateOfReaccreditation != null) {
			setStartDateOfReaccreditation(startDateOfReaccreditation);
		}

		Date dateOfReaccdtReview = (Date)attributes.get("dateOfReaccdtReview");

		if (dateOfReaccdtReview != null) {
			setDateOfReaccdtReview(dateOfReaccdtReview);
		}

		String AccreditationBy = (String)attributes.get("AccreditationBy");

		if (AccreditationBy != null) {
			setAccreditationBy(AccreditationBy);
		}
	}

	/**
	* Returns the primary key of this re accreditation.
	*
	* @return the primary key of this re accreditation
	*/
	@Override
	public long getPrimaryKey() {
		return _reAccreditation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this re accreditation.
	*
	* @param primaryKey the primary key of this re accreditation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_reAccreditation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this re accreditation.
	*
	* @return the uuid of this re accreditation
	*/
	@Override
	public java.lang.String getUuid() {
		return _reAccreditation.getUuid();
	}

	/**
	* Sets the uuid of this re accreditation.
	*
	* @param uuid the uuid of this re accreditation
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_reAccreditation.setUuid(uuid);
	}

	/**
	* Returns the accreditation ID of this re accreditation.
	*
	* @return the accreditation ID of this re accreditation
	*/
	@Override
	public long getAccreditationId() {
		return _reAccreditation.getAccreditationId();
	}

	/**
	* Sets the accreditation ID of this re accreditation.
	*
	* @param accreditationId the accreditation ID of this re accreditation
	*/
	@Override
	public void setAccreditationId(long accreditationId) {
		_reAccreditation.setAccreditationId(accreditationId);
	}

	/**
	* Returns the organization ID of this re accreditation.
	*
	* @return the organization ID of this re accreditation
	*/
	@Override
	public long getOrganizationId() {
		return _reAccreditation.getOrganizationId();
	}

	/**
	* Sets the organization ID of this re accreditation.
	*
	* @param organizationId the organization ID of this re accreditation
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_reAccreditation.setOrganizationId(organizationId);
	}

	/**
	* Returns the accreditation status of this re accreditation.
	*
	* @return the accreditation status of this re accreditation
	*/
	@Override
	public java.lang.String getAccreditationStatus() {
		return _reAccreditation.getAccreditationStatus();
	}

	/**
	* Sets the accreditation status of this re accreditation.
	*
	* @param accreditationStatus the accreditation status of this re accreditation
	*/
	@Override
	public void setAccreditationStatus(java.lang.String accreditationStatus) {
		_reAccreditation.setAccreditationStatus(accreditationStatus);
	}

	/**
	* Returns the date of accreditation of this re accreditation.
	*
	* @return the date of accreditation of this re accreditation
	*/
	@Override
	public java.util.Date getDateOfAccreditation() {
		return _reAccreditation.getDateOfAccreditation();
	}

	/**
	* Sets the date of accreditation of this re accreditation.
	*
	* @param dateOfAccreditation the date of accreditation of this re accreditation
	*/
	@Override
	public void setDateOfAccreditation(java.util.Date dateOfAccreditation) {
		_reAccreditation.setDateOfAccreditation(dateOfAccreditation);
	}

	/**
	* Returns the date of expiry of this re accreditation.
	*
	* @return the date of expiry of this re accreditation
	*/
	@Override
	public java.util.Date getDateOfExpiry() {
		return _reAccreditation.getDateOfExpiry();
	}

	/**
	* Sets the date of expiry of this re accreditation.
	*
	* @param dateOfExpiry the date of expiry of this re accreditation
	*/
	@Override
	public void setDateOfExpiry(java.util.Date dateOfExpiry) {
		_reAccreditation.setDateOfExpiry(dateOfExpiry);
	}

	/**
	* Returns the latest payment date of this re accreditation.
	*
	* @return the latest payment date of this re accreditation
	*/
	@Override
	public java.util.Date getLatestPaymentDate() {
		return _reAccreditation.getLatestPaymentDate();
	}

	/**
	* Sets the latest payment date of this re accreditation.
	*
	* @param latestPaymentDate the latest payment date of this re accreditation
	*/
	@Override
	public void setLatestPaymentDate(java.util.Date latestPaymentDate) {
		_reAccreditation.setLatestPaymentDate(latestPaymentDate);
	}

	/**
	* Returns the start date of reaccreditation of this re accreditation.
	*
	* @return the start date of reaccreditation of this re accreditation
	*/
	@Override
	public java.util.Date getStartDateOfReaccreditation() {
		return _reAccreditation.getStartDateOfReaccreditation();
	}

	/**
	* Sets the start date of reaccreditation of this re accreditation.
	*
	* @param startDateOfReaccreditation the start date of reaccreditation of this re accreditation
	*/
	@Override
	public void setStartDateOfReaccreditation(
		java.util.Date startDateOfReaccreditation) {
		_reAccreditation.setStartDateOfReaccreditation(startDateOfReaccreditation);
	}

	/**
	* Returns the date of reaccdt review of this re accreditation.
	*
	* @return the date of reaccdt review of this re accreditation
	*/
	@Override
	public java.util.Date getDateOfReaccdtReview() {
		return _reAccreditation.getDateOfReaccdtReview();
	}

	/**
	* Sets the date of reaccdt review of this re accreditation.
	*
	* @param dateOfReaccdtReview the date of reaccdt review of this re accreditation
	*/
	@Override
	public void setDateOfReaccdtReview(java.util.Date dateOfReaccdtReview) {
		_reAccreditation.setDateOfReaccdtReview(dateOfReaccdtReview);
	}

	/**
	* Returns the accreditation by of this re accreditation.
	*
	* @return the accreditation by of this re accreditation
	*/
	@Override
	public java.lang.String getAccreditationBy() {
		return _reAccreditation.getAccreditationBy();
	}

	/**
	* Sets the accreditation by of this re accreditation.
	*
	* @param AccreditationBy the accreditation by of this re accreditation
	*/
	@Override
	public void setAccreditationBy(java.lang.String AccreditationBy) {
		_reAccreditation.setAccreditationBy(AccreditationBy);
	}

	@Override
	public boolean isNew() {
		return _reAccreditation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_reAccreditation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _reAccreditation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_reAccreditation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _reAccreditation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _reAccreditation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_reAccreditation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _reAccreditation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_reAccreditation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_reAccreditation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_reAccreditation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new ReAccreditationWrapper((ReAccreditation)_reAccreditation.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.ReAccreditation reAccreditation) {
		return _reAccreditation.compareTo(reAccreditation);
	}

	@Override
	public int hashCode() {
		return _reAccreditation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.ReAccreditation> toCacheModel() {
		return _reAccreditation.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation toEscapedModel() {
		return new ReAccreditationWrapper(_reAccreditation.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.ReAccreditation toUnescapedModel() {
		return new ReAccreditationWrapper(_reAccreditation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _reAccreditation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _reAccreditation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_reAccreditation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof ReAccreditationWrapper)) {
			return false;
		}

		ReAccreditationWrapper reAccreditationWrapper = (ReAccreditationWrapper)obj;

		if (Validator.equals(_reAccreditation,
					reAccreditationWrapper._reAccreditation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public ReAccreditation getWrappedReAccreditation() {
		return _reAccreditation;
	}

	@Override
	public ReAccreditation getWrappedModel() {
		return _reAccreditation;
	}

	@Override
	public void resetOriginalValues() {
		_reAccreditation.resetOriginalValues();
	}

	private ReAccreditation _reAccreditation;
}