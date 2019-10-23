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
 * This class is a wrapper for {@link Accreditation}.
 * </p>
 *
 * @author pradeep
 * @see Accreditation
 * @generated
 */
public class AccreditationWrapper implements Accreditation,
	ModelWrapper<Accreditation> {
	public AccreditationWrapper(Accreditation accreditation) {
		_accreditation = accreditation;
	}

	@Override
	public Class<?> getModelClass() {
		return Accreditation.class;
	}

	@Override
	public String getModelClassName() {
		return Accreditation.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("accreditationId", getAccreditationId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("aselected", getAselected());
		attributes.put("avalue", getAvalue());
		attributes.put("bselected", getBselected());
		attributes.put("bvalue", getBvalue());
		attributes.put("cselected", getCselected());
		attributes.put("cvalue", getCvalue());
		attributes.put("ccompanyName", getCcompanyName());
		attributes.put("csamepolicy", getCsamepolicy());
		attributes.put("celaborate", getCelaborate());
		attributes.put("dselected", getDselected());
		attributes.put("dvalue", getDvalue());
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

		Boolean aselected = (Boolean)attributes.get("aselected");

		if (aselected != null) {
			setAselected(aselected);
		}

		String avalue = (String)attributes.get("avalue");

		if (avalue != null) {
			setAvalue(avalue);
		}

		Boolean bselected = (Boolean)attributes.get("bselected");

		if (bselected != null) {
			setBselected(bselected);
		}

		String bvalue = (String)attributes.get("bvalue");

		if (bvalue != null) {
			setBvalue(bvalue);
		}

		Boolean cselected = (Boolean)attributes.get("cselected");

		if (cselected != null) {
			setCselected(cselected);
		}

		String cvalue = (String)attributes.get("cvalue");

		if (cvalue != null) {
			setCvalue(cvalue);
		}

		String ccompanyName = (String)attributes.get("ccompanyName");

		if (ccompanyName != null) {
			setCcompanyName(ccompanyName);
		}

		Boolean csamepolicy = (Boolean)attributes.get("csamepolicy");

		if (csamepolicy != null) {
			setCsamepolicy(csamepolicy);
		}

		String celaborate = (String)attributes.get("celaborate");

		if (celaborate != null) {
			setCelaborate(celaborate);
		}

		Boolean dselected = (Boolean)attributes.get("dselected");

		if (dselected != null) {
			setDselected(dselected);
		}

		String dvalue = (String)attributes.get("dvalue");

		if (dvalue != null) {
			setDvalue(dvalue);
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
	* Returns the primary key of this accreditation.
	*
	* @return the primary key of this accreditation
	*/
	@Override
	public long getPrimaryKey() {
		return _accreditation.getPrimaryKey();
	}

	/**
	* Sets the primary key of this accreditation.
	*
	* @param primaryKey the primary key of this accreditation
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_accreditation.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this accreditation.
	*
	* @return the uuid of this accreditation
	*/
	@Override
	public java.lang.String getUuid() {
		return _accreditation.getUuid();
	}

	/**
	* Sets the uuid of this accreditation.
	*
	* @param uuid the uuid of this accreditation
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_accreditation.setUuid(uuid);
	}

	/**
	* Returns the accreditation ID of this accreditation.
	*
	* @return the accreditation ID of this accreditation
	*/
	@Override
	public long getAccreditationId() {
		return _accreditation.getAccreditationId();
	}

	/**
	* Sets the accreditation ID of this accreditation.
	*
	* @param accreditationId the accreditation ID of this accreditation
	*/
	@Override
	public void setAccreditationId(long accreditationId) {
		_accreditation.setAccreditationId(accreditationId);
	}

	/**
	* Returns the organization ID of this accreditation.
	*
	* @return the organization ID of this accreditation
	*/
	@Override
	public long getOrganizationId() {
		return _accreditation.getOrganizationId();
	}

	/**
	* Sets the organization ID of this accreditation.
	*
	* @param organizationId the organization ID of this accreditation
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_accreditation.setOrganizationId(organizationId);
	}

	/**
	* Returns the aselected of this accreditation.
	*
	* @return the aselected of this accreditation
	*/
	@Override
	public boolean getAselected() {
		return _accreditation.getAselected();
	}

	/**
	* Returns <code>true</code> if this accreditation is aselected.
	*
	* @return <code>true</code> if this accreditation is aselected; <code>false</code> otherwise
	*/
	@Override
	public boolean isAselected() {
		return _accreditation.isAselected();
	}

	/**
	* Sets whether this accreditation is aselected.
	*
	* @param aselected the aselected of this accreditation
	*/
	@Override
	public void setAselected(boolean aselected) {
		_accreditation.setAselected(aselected);
	}

	/**
	* Returns the avalue of this accreditation.
	*
	* @return the avalue of this accreditation
	*/
	@Override
	public java.lang.String getAvalue() {
		return _accreditation.getAvalue();
	}

	/**
	* Sets the avalue of this accreditation.
	*
	* @param avalue the avalue of this accreditation
	*/
	@Override
	public void setAvalue(java.lang.String avalue) {
		_accreditation.setAvalue(avalue);
	}

	/**
	* Returns the bselected of this accreditation.
	*
	* @return the bselected of this accreditation
	*/
	@Override
	public boolean getBselected() {
		return _accreditation.getBselected();
	}

	/**
	* Returns <code>true</code> if this accreditation is bselected.
	*
	* @return <code>true</code> if this accreditation is bselected; <code>false</code> otherwise
	*/
	@Override
	public boolean isBselected() {
		return _accreditation.isBselected();
	}

	/**
	* Sets whether this accreditation is bselected.
	*
	* @param bselected the bselected of this accreditation
	*/
	@Override
	public void setBselected(boolean bselected) {
		_accreditation.setBselected(bselected);
	}

	/**
	* Returns the bvalue of this accreditation.
	*
	* @return the bvalue of this accreditation
	*/
	@Override
	public java.lang.String getBvalue() {
		return _accreditation.getBvalue();
	}

	/**
	* Sets the bvalue of this accreditation.
	*
	* @param bvalue the bvalue of this accreditation
	*/
	@Override
	public void setBvalue(java.lang.String bvalue) {
		_accreditation.setBvalue(bvalue);
	}

	/**
	* Returns the cselected of this accreditation.
	*
	* @return the cselected of this accreditation
	*/
	@Override
	public boolean getCselected() {
		return _accreditation.getCselected();
	}

	/**
	* Returns <code>true</code> if this accreditation is cselected.
	*
	* @return <code>true</code> if this accreditation is cselected; <code>false</code> otherwise
	*/
	@Override
	public boolean isCselected() {
		return _accreditation.isCselected();
	}

	/**
	* Sets whether this accreditation is cselected.
	*
	* @param cselected the cselected of this accreditation
	*/
	@Override
	public void setCselected(boolean cselected) {
		_accreditation.setCselected(cselected);
	}

	/**
	* Returns the cvalue of this accreditation.
	*
	* @return the cvalue of this accreditation
	*/
	@Override
	public java.lang.String getCvalue() {
		return _accreditation.getCvalue();
	}

	/**
	* Sets the cvalue of this accreditation.
	*
	* @param cvalue the cvalue of this accreditation
	*/
	@Override
	public void setCvalue(java.lang.String cvalue) {
		_accreditation.setCvalue(cvalue);
	}

	/**
	* Returns the ccompany name of this accreditation.
	*
	* @return the ccompany name of this accreditation
	*/
	@Override
	public java.lang.String getCcompanyName() {
		return _accreditation.getCcompanyName();
	}

	/**
	* Sets the ccompany name of this accreditation.
	*
	* @param ccompanyName the ccompany name of this accreditation
	*/
	@Override
	public void setCcompanyName(java.lang.String ccompanyName) {
		_accreditation.setCcompanyName(ccompanyName);
	}

	/**
	* Returns the csamepolicy of this accreditation.
	*
	* @return the csamepolicy of this accreditation
	*/
	@Override
	public boolean getCsamepolicy() {
		return _accreditation.getCsamepolicy();
	}

	/**
	* Returns <code>true</code> if this accreditation is csamepolicy.
	*
	* @return <code>true</code> if this accreditation is csamepolicy; <code>false</code> otherwise
	*/
	@Override
	public boolean isCsamepolicy() {
		return _accreditation.isCsamepolicy();
	}

	/**
	* Sets whether this accreditation is csamepolicy.
	*
	* @param csamepolicy the csamepolicy of this accreditation
	*/
	@Override
	public void setCsamepolicy(boolean csamepolicy) {
		_accreditation.setCsamepolicy(csamepolicy);
	}

	/**
	* Returns the celaborate of this accreditation.
	*
	* @return the celaborate of this accreditation
	*/
	@Override
	public java.lang.String getCelaborate() {
		return _accreditation.getCelaborate();
	}

	/**
	* Sets the celaborate of this accreditation.
	*
	* @param celaborate the celaborate of this accreditation
	*/
	@Override
	public void setCelaborate(java.lang.String celaborate) {
		_accreditation.setCelaborate(celaborate);
	}

	/**
	* Returns the dselected of this accreditation.
	*
	* @return the dselected of this accreditation
	*/
	@Override
	public boolean getDselected() {
		return _accreditation.getDselected();
	}

	/**
	* Returns <code>true</code> if this accreditation is dselected.
	*
	* @return <code>true</code> if this accreditation is dselected; <code>false</code> otherwise
	*/
	@Override
	public boolean isDselected() {
		return _accreditation.isDselected();
	}

	/**
	* Sets whether this accreditation is dselected.
	*
	* @param dselected the dselected of this accreditation
	*/
	@Override
	public void setDselected(boolean dselected) {
		_accreditation.setDselected(dselected);
	}

	/**
	* Returns the dvalue of this accreditation.
	*
	* @return the dvalue of this accreditation
	*/
	@Override
	public java.lang.String getDvalue() {
		return _accreditation.getDvalue();
	}

	/**
	* Sets the dvalue of this accreditation.
	*
	* @param dvalue the dvalue of this accreditation
	*/
	@Override
	public void setDvalue(java.lang.String dvalue) {
		_accreditation.setDvalue(dvalue);
	}

	/**
	* Returns the accreditation status of this accreditation.
	*
	* @return the accreditation status of this accreditation
	*/
	@Override
	public java.lang.String getAccreditationStatus() {
		return _accreditation.getAccreditationStatus();
	}

	/**
	* Sets the accreditation status of this accreditation.
	*
	* @param accreditationStatus the accreditation status of this accreditation
	*/
	@Override
	public void setAccreditationStatus(java.lang.String accreditationStatus) {
		_accreditation.setAccreditationStatus(accreditationStatus);
	}

	/**
	* Returns the date of accreditation of this accreditation.
	*
	* @return the date of accreditation of this accreditation
	*/
	@Override
	public java.util.Date getDateOfAccreditation() {
		return _accreditation.getDateOfAccreditation();
	}

	/**
	* Sets the date of accreditation of this accreditation.
	*
	* @param dateOfAccreditation the date of accreditation of this accreditation
	*/
	@Override
	public void setDateOfAccreditation(java.util.Date dateOfAccreditation) {
		_accreditation.setDateOfAccreditation(dateOfAccreditation);
	}

	/**
	* Returns the date of expiry of this accreditation.
	*
	* @return the date of expiry of this accreditation
	*/
	@Override
	public java.util.Date getDateOfExpiry() {
		return _accreditation.getDateOfExpiry();
	}

	/**
	* Sets the date of expiry of this accreditation.
	*
	* @param dateOfExpiry the date of expiry of this accreditation
	*/
	@Override
	public void setDateOfExpiry(java.util.Date dateOfExpiry) {
		_accreditation.setDateOfExpiry(dateOfExpiry);
	}

	/**
	* Returns the latest payment date of this accreditation.
	*
	* @return the latest payment date of this accreditation
	*/
	@Override
	public java.util.Date getLatestPaymentDate() {
		return _accreditation.getLatestPaymentDate();
	}

	/**
	* Sets the latest payment date of this accreditation.
	*
	* @param latestPaymentDate the latest payment date of this accreditation
	*/
	@Override
	public void setLatestPaymentDate(java.util.Date latestPaymentDate) {
		_accreditation.setLatestPaymentDate(latestPaymentDate);
	}

	/**
	* Returns the start date of reaccreditation of this accreditation.
	*
	* @return the start date of reaccreditation of this accreditation
	*/
	@Override
	public java.util.Date getStartDateOfReaccreditation() {
		return _accreditation.getStartDateOfReaccreditation();
	}

	/**
	* Sets the start date of reaccreditation of this accreditation.
	*
	* @param startDateOfReaccreditation the start date of reaccreditation of this accreditation
	*/
	@Override
	public void setStartDateOfReaccreditation(
		java.util.Date startDateOfReaccreditation) {
		_accreditation.setStartDateOfReaccreditation(startDateOfReaccreditation);
	}

	/**
	* Returns the date of reaccdt review of this accreditation.
	*
	* @return the date of reaccdt review of this accreditation
	*/
	@Override
	public java.util.Date getDateOfReaccdtReview() {
		return _accreditation.getDateOfReaccdtReview();
	}

	/**
	* Sets the date of reaccdt review of this accreditation.
	*
	* @param dateOfReaccdtReview the date of reaccdt review of this accreditation
	*/
	@Override
	public void setDateOfReaccdtReview(java.util.Date dateOfReaccdtReview) {
		_accreditation.setDateOfReaccdtReview(dateOfReaccdtReview);
	}

	/**
	* Returns the accreditation by of this accreditation.
	*
	* @return the accreditation by of this accreditation
	*/
	@Override
	public java.lang.String getAccreditationBy() {
		return _accreditation.getAccreditationBy();
	}

	/**
	* Sets the accreditation by of this accreditation.
	*
	* @param AccreditationBy the accreditation by of this accreditation
	*/
	@Override
	public void setAccreditationBy(java.lang.String AccreditationBy) {
		_accreditation.setAccreditationBy(AccreditationBy);
	}

	@Override
	public boolean isNew() {
		return _accreditation.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_accreditation.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _accreditation.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_accreditation.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _accreditation.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _accreditation.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_accreditation.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _accreditation.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_accreditation.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_accreditation.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_accreditation.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AccreditationWrapper((Accreditation)_accreditation.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.Accreditation accreditation) {
		return _accreditation.compareTo(accreditation);
	}

	@Override
	public int hashCode() {
		return _accreditation.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.Accreditation> toCacheModel() {
		return _accreditation.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Accreditation toEscapedModel() {
		return new AccreditationWrapper(_accreditation.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Accreditation toUnescapedModel() {
		return new AccreditationWrapper(_accreditation.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _accreditation.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _accreditation.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_accreditation.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AccreditationWrapper)) {
			return false;
		}

		AccreditationWrapper accreditationWrapper = (AccreditationWrapper)obj;

		if (Validator.equals(_accreditation, accreditationWrapper._accreditation)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Accreditation getWrappedAccreditation() {
		return _accreditation;
	}

	@Override
	public Accreditation getWrappedModel() {
		return _accreditation;
	}

	@Override
	public void resetOriginalValues() {
		_accreditation.resetOriginalValues();
	}

	private Accreditation _accreditation;
}