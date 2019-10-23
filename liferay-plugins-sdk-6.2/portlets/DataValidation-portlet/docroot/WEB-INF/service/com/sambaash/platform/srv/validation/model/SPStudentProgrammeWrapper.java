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

package com.sambaash.platform.srv.validation.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPStudentProgramme}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPStudentProgramme
 * @generated
 */
public class SPStudentProgrammeWrapper implements SPStudentProgramme,
	ModelWrapper<SPStudentProgramme> {
	public SPStudentProgrammeWrapper(SPStudentProgramme spStudentProgramme) {
		_spStudentProgramme = spStudentProgramme;
	}

	@Override
	public Class<?> getModelClass() {
		return SPStudentProgramme.class;
	}

	@Override
	public String getModelClassName() {
		return SPStudentProgramme.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudentCourseId", getSpStudentCourseId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nric", getNric());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("programme", getProgramme());
		attributes.put("courseCentre", getCourseCentre());
		attributes.put("courseStartDate", getCourseStartDate());
		attributes.put("courseEndDate", getCourseEndDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudentCourseId = (Long)attributes.get("spStudentCourseId");

		if (spStudentCourseId != null) {
			setSpStudentCourseId(spStudentCourseId);
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

		String nric = (String)attributes.get("nric");

		if (nric != null) {
			setNric(nric);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String programme = (String)attributes.get("programme");

		if (programme != null) {
			setProgramme(programme);
		}

		String courseCentre = (String)attributes.get("courseCentre");

		if (courseCentre != null) {
			setCourseCentre(courseCentre);
		}

		Date courseStartDate = (Date)attributes.get("courseStartDate");

		if (courseStartDate != null) {
			setCourseStartDate(courseStartDate);
		}

		Date courseEndDate = (Date)attributes.get("courseEndDate");

		if (courseEndDate != null) {
			setCourseEndDate(courseEndDate);
		}
	}

	/**
	* Returns the primary key of this s p student programme.
	*
	* @return the primary key of this s p student programme
	*/
	@Override
	public long getPrimaryKey() {
		return _spStudentProgramme.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p student programme.
	*
	* @param primaryKey the primary key of this s p student programme
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spStudentProgramme.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp student course ID of this s p student programme.
	*
	* @return the sp student course ID of this s p student programme
	*/
	@Override
	public long getSpStudentCourseId() {
		return _spStudentProgramme.getSpStudentCourseId();
	}

	/**
	* Sets the sp student course ID of this s p student programme.
	*
	* @param spStudentCourseId the sp student course ID of this s p student programme
	*/
	@Override
	public void setSpStudentCourseId(long spStudentCourseId) {
		_spStudentProgramme.setSpStudentCourseId(spStudentCourseId);
	}

	/**
	* Returns the company ID of this s p student programme.
	*
	* @return the company ID of this s p student programme
	*/
	@Override
	public long getCompanyId() {
		return _spStudentProgramme.getCompanyId();
	}

	/**
	* Sets the company ID of this s p student programme.
	*
	* @param companyId the company ID of this s p student programme
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spStudentProgramme.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p student programme.
	*
	* @return the user ID of this s p student programme
	*/
	@Override
	public long getUserId() {
		return _spStudentProgramme.getUserId();
	}

	/**
	* Sets the user ID of this s p student programme.
	*
	* @param userId the user ID of this s p student programme
	*/
	@Override
	public void setUserId(long userId) {
		_spStudentProgramme.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p student programme.
	*
	* @return the user uuid of this s p student programme
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgramme.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p student programme.
	*
	* @param userUuid the user uuid of this s p student programme
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spStudentProgramme.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p student programme.
	*
	* @return the user name of this s p student programme
	*/
	@Override
	public java.lang.String getUserName() {
		return _spStudentProgramme.getUserName();
	}

	/**
	* Sets the user name of this s p student programme.
	*
	* @param userName the user name of this s p student programme
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spStudentProgramme.setUserName(userName);
	}

	/**
	* Returns the create date of this s p student programme.
	*
	* @return the create date of this s p student programme
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spStudentProgramme.getCreateDate();
	}

	/**
	* Sets the create date of this s p student programme.
	*
	* @param createDate the create date of this s p student programme
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spStudentProgramme.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p student programme.
	*
	* @return the modified date of this s p student programme
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spStudentProgramme.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p student programme.
	*
	* @param modifiedDate the modified date of this s p student programme
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spStudentProgramme.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the nric of this s p student programme.
	*
	* @return the nric of this s p student programme
	*/
	@Override
	public java.lang.String getNric() {
		return _spStudentProgramme.getNric();
	}

	/**
	* Sets the nric of this s p student programme.
	*
	* @param nric the nric of this s p student programme
	*/
	@Override
	public void setNric(java.lang.String nric) {
		_spStudentProgramme.setNric(nric);
	}

	/**
	* Returns the email address of this s p student programme.
	*
	* @return the email address of this s p student programme
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spStudentProgramme.getEmailAddress();
	}

	/**
	* Sets the email address of this s p student programme.
	*
	* @param emailAddress the email address of this s p student programme
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spStudentProgramme.setEmailAddress(emailAddress);
	}

	/**
	* Returns the programme of this s p student programme.
	*
	* @return the programme of this s p student programme
	*/
	@Override
	public java.lang.String getProgramme() {
		return _spStudentProgramme.getProgramme();
	}

	/**
	* Sets the programme of this s p student programme.
	*
	* @param programme the programme of this s p student programme
	*/
	@Override
	public void setProgramme(java.lang.String programme) {
		_spStudentProgramme.setProgramme(programme);
	}

	/**
	* Returns the course centre of this s p student programme.
	*
	* @return the course centre of this s p student programme
	*/
	@Override
	public java.lang.String getCourseCentre() {
		return _spStudentProgramme.getCourseCentre();
	}

	/**
	* Sets the course centre of this s p student programme.
	*
	* @param courseCentre the course centre of this s p student programme
	*/
	@Override
	public void setCourseCentre(java.lang.String courseCentre) {
		_spStudentProgramme.setCourseCentre(courseCentre);
	}

	/**
	* Returns the course start date of this s p student programme.
	*
	* @return the course start date of this s p student programme
	*/
	@Override
	public java.util.Date getCourseStartDate() {
		return _spStudentProgramme.getCourseStartDate();
	}

	/**
	* Sets the course start date of this s p student programme.
	*
	* @param courseStartDate the course start date of this s p student programme
	*/
	@Override
	public void setCourseStartDate(java.util.Date courseStartDate) {
		_spStudentProgramme.setCourseStartDate(courseStartDate);
	}

	/**
	* Returns the course end date of this s p student programme.
	*
	* @return the course end date of this s p student programme
	*/
	@Override
	public java.util.Date getCourseEndDate() {
		return _spStudentProgramme.getCourseEndDate();
	}

	/**
	* Sets the course end date of this s p student programme.
	*
	* @param courseEndDate the course end date of this s p student programme
	*/
	@Override
	public void setCourseEndDate(java.util.Date courseEndDate) {
		_spStudentProgramme.setCourseEndDate(courseEndDate);
	}

	@Override
	public boolean isNew() {
		return _spStudentProgramme.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spStudentProgramme.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spStudentProgramme.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spStudentProgramme.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spStudentProgramme.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spStudentProgramme.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spStudentProgramme.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spStudentProgramme.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spStudentProgramme.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spStudentProgramme.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spStudentProgramme.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPStudentProgrammeWrapper((SPStudentProgramme)_spStudentProgramme.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.validation.model.SPStudentProgramme spStudentProgramme) {
		return _spStudentProgramme.compareTo(spStudentProgramme);
	}

	@Override
	public int hashCode() {
		return _spStudentProgramme.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.validation.model.SPStudentProgramme> toCacheModel() {
		return _spStudentProgramme.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme toEscapedModel() {
		return new SPStudentProgrammeWrapper(_spStudentProgramme.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme toUnescapedModel() {
		return new SPStudentProgrammeWrapper(_spStudentProgramme.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spStudentProgramme.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spStudentProgramme.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spStudentProgramme.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPStudentProgrammeWrapper)) {
			return false;
		}

		SPStudentProgrammeWrapper spStudentProgrammeWrapper = (SPStudentProgrammeWrapper)obj;

		if (Validator.equals(_spStudentProgramme,
					spStudentProgrammeWrapper._spStudentProgramme)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPStudentProgramme getWrappedSPStudentProgramme() {
		return _spStudentProgramme;
	}

	@Override
	public SPStudentProgramme getWrappedModel() {
		return _spStudentProgramme;
	}

	@Override
	public void resetOriginalValues() {
		_spStudentProgramme.resetOriginalValues();
	}

	private SPStudentProgramme _spStudentProgramme;
}