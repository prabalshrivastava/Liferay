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

package com.sambaash.platform.srv.spjob.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPJobApplicants}.
 * </p>
 *
 * @author harini
 * @see SPJobApplicants
 * @generated
 */
public class SPJobApplicantsWrapper implements SPJobApplicants,
	ModelWrapper<SPJobApplicants> {
	public SPJobApplicantsWrapper(SPJobApplicants spJobApplicants) {
		_spJobApplicants = spJobApplicants;
	}

	@Override
	public Class<?> getModelClass() {
		return SPJobApplicants.class;
	}

	@Override
	public String getModelClassName() {
		return SPJobApplicants.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spJobApplicantsId", getSpJobApplicantsId());
		attributes.put("jobId", getJobId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("contactNumber", getContactNumber());
		attributes.put("yearsOfExperience", getYearsOfExperience());
		attributes.put("resume", getResume());
		attributes.put("coverLetter", getCoverLetter());
		attributes.put("briefInfos", getBriefInfos());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spJobApplicantsId = (Long)attributes.get("spJobApplicantsId");

		if (spJobApplicantsId != null) {
			setSpJobApplicantsId(spJobApplicantsId);
		}

		Long jobId = (Long)attributes.get("jobId");

		if (jobId != null) {
			setJobId(jobId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long createdBy = (Long)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long updatedBy = (Long)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String emailAddress = (String)attributes.get("emailAddress");

		if (emailAddress != null) {
			setEmailAddress(emailAddress);
		}

		String contactNumber = (String)attributes.get("contactNumber");

		if (contactNumber != null) {
			setContactNumber(contactNumber);
		}

		String yearsOfExperience = (String)attributes.get("yearsOfExperience");

		if (yearsOfExperience != null) {
			setYearsOfExperience(yearsOfExperience);
		}

		String resume = (String)attributes.get("resume");

		if (resume != null) {
			setResume(resume);
		}

		String coverLetter = (String)attributes.get("coverLetter");

		if (coverLetter != null) {
			setCoverLetter(coverLetter);
		}

		String briefInfos = (String)attributes.get("briefInfos");

		if (briefInfos != null) {
			setBriefInfos(briefInfos);
		}

		String extra1 = (String)attributes.get("extra1");

		if (extra1 != null) {
			setExtra1(extra1);
		}

		String extra2 = (String)attributes.get("extra2");

		if (extra2 != null) {
			setExtra2(extra2);
		}

		String extra3 = (String)attributes.get("extra3");

		if (extra3 != null) {
			setExtra3(extra3);
		}

		String extra4 = (String)attributes.get("extra4");

		if (extra4 != null) {
			setExtra4(extra4);
		}

		String extra5 = (String)attributes.get("extra5");

		if (extra5 != null) {
			setExtra5(extra5);
		}
	}

	/**
	* Returns the primary key of this s p job applicants.
	*
	* @return the primary key of this s p job applicants
	*/
	@Override
	public long getPrimaryKey() {
		return _spJobApplicants.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p job applicants.
	*
	* @param primaryKey the primary key of this s p job applicants
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spJobApplicants.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp job applicants ID of this s p job applicants.
	*
	* @return the sp job applicants ID of this s p job applicants
	*/
	@Override
	public long getSpJobApplicantsId() {
		return _spJobApplicants.getSpJobApplicantsId();
	}

	/**
	* Sets the sp job applicants ID of this s p job applicants.
	*
	* @param spJobApplicantsId the sp job applicants ID of this s p job applicants
	*/
	@Override
	public void setSpJobApplicantsId(long spJobApplicantsId) {
		_spJobApplicants.setSpJobApplicantsId(spJobApplicantsId);
	}

	/**
	* Returns the job ID of this s p job applicants.
	*
	* @return the job ID of this s p job applicants
	*/
	@Override
	public long getJobId() {
		return _spJobApplicants.getJobId();
	}

	/**
	* Sets the job ID of this s p job applicants.
	*
	* @param jobId the job ID of this s p job applicants
	*/
	@Override
	public void setJobId(long jobId) {
		_spJobApplicants.setJobId(jobId);
	}

	/**
	* Returns the group ID of this s p job applicants.
	*
	* @return the group ID of this s p job applicants
	*/
	@Override
	public long getGroupId() {
		return _spJobApplicants.getGroupId();
	}

	/**
	* Sets the group ID of this s p job applicants.
	*
	* @param groupId the group ID of this s p job applicants
	*/
	@Override
	public void setGroupId(long groupId) {
		_spJobApplicants.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p job applicants.
	*
	* @return the company ID of this s p job applicants
	*/
	@Override
	public long getCompanyId() {
		return _spJobApplicants.getCompanyId();
	}

	/**
	* Sets the company ID of this s p job applicants.
	*
	* @param companyId the company ID of this s p job applicants
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spJobApplicants.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p job applicants.
	*
	* @return the user ID of this s p job applicants
	*/
	@Override
	public long getUserId() {
		return _spJobApplicants.getUserId();
	}

	/**
	* Sets the user ID of this s p job applicants.
	*
	* @param userId the user ID of this s p job applicants
	*/
	@Override
	public void setUserId(long userId) {
		_spJobApplicants.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p job applicants.
	*
	* @return the user uuid of this s p job applicants
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJobApplicants.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p job applicants.
	*
	* @param userUuid the user uuid of this s p job applicants
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spJobApplicants.setUserUuid(userUuid);
	}

	/**
	* Returns the created by of this s p job applicants.
	*
	* @return the created by of this s p job applicants
	*/
	@Override
	public long getCreatedBy() {
		return _spJobApplicants.getCreatedBy();
	}

	/**
	* Sets the created by of this s p job applicants.
	*
	* @param createdBy the created by of this s p job applicants
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_spJobApplicants.setCreatedBy(createdBy);
	}

	/**
	* Returns the updated by of this s p job applicants.
	*
	* @return the updated by of this s p job applicants
	*/
	@Override
	public long getUpdatedBy() {
		return _spJobApplicants.getUpdatedBy();
	}

	/**
	* Sets the updated by of this s p job applicants.
	*
	* @param updatedBy the updated by of this s p job applicants
	*/
	@Override
	public void setUpdatedBy(long updatedBy) {
		_spJobApplicants.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the create date of this s p job applicants.
	*
	* @return the create date of this s p job applicants
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spJobApplicants.getCreateDate();
	}

	/**
	* Sets the create date of this s p job applicants.
	*
	* @param createDate the create date of this s p job applicants
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spJobApplicants.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p job applicants.
	*
	* @return the modified date of this s p job applicants
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spJobApplicants.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p job applicants.
	*
	* @param modifiedDate the modified date of this s p job applicants
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spJobApplicants.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the first name of this s p job applicants.
	*
	* @return the first name of this s p job applicants
	*/
	@Override
	public java.lang.String getFirstName() {
		return _spJobApplicants.getFirstName();
	}

	/**
	* Sets the first name of this s p job applicants.
	*
	* @param firstName the first name of this s p job applicants
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_spJobApplicants.setFirstName(firstName);
	}

	/**
	* Returns the last name of this s p job applicants.
	*
	* @return the last name of this s p job applicants
	*/
	@Override
	public java.lang.String getLastName() {
		return _spJobApplicants.getLastName();
	}

	/**
	* Sets the last name of this s p job applicants.
	*
	* @param lastName the last name of this s p job applicants
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_spJobApplicants.setLastName(lastName);
	}

	/**
	* Returns the email address of this s p job applicants.
	*
	* @return the email address of this s p job applicants
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spJobApplicants.getEmailAddress();
	}

	/**
	* Sets the email address of this s p job applicants.
	*
	* @param emailAddress the email address of this s p job applicants
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spJobApplicants.setEmailAddress(emailAddress);
	}

	/**
	* Returns the contact number of this s p job applicants.
	*
	* @return the contact number of this s p job applicants
	*/
	@Override
	public java.lang.String getContactNumber() {
		return _spJobApplicants.getContactNumber();
	}

	/**
	* Sets the contact number of this s p job applicants.
	*
	* @param contactNumber the contact number of this s p job applicants
	*/
	@Override
	public void setContactNumber(java.lang.String contactNumber) {
		_spJobApplicants.setContactNumber(contactNumber);
	}

	/**
	* Returns the years of experience of this s p job applicants.
	*
	* @return the years of experience of this s p job applicants
	*/
	@Override
	public java.lang.String getYearsOfExperience() {
		return _spJobApplicants.getYearsOfExperience();
	}

	/**
	* Sets the years of experience of this s p job applicants.
	*
	* @param yearsOfExperience the years of experience of this s p job applicants
	*/
	@Override
	public void setYearsOfExperience(java.lang.String yearsOfExperience) {
		_spJobApplicants.setYearsOfExperience(yearsOfExperience);
	}

	/**
	* Returns the resume of this s p job applicants.
	*
	* @return the resume of this s p job applicants
	*/
	@Override
	public java.lang.String getResume() {
		return _spJobApplicants.getResume();
	}

	/**
	* Sets the resume of this s p job applicants.
	*
	* @param resume the resume of this s p job applicants
	*/
	@Override
	public void setResume(java.lang.String resume) {
		_spJobApplicants.setResume(resume);
	}

	/**
	* Returns the cover letter of this s p job applicants.
	*
	* @return the cover letter of this s p job applicants
	*/
	@Override
	public java.lang.String getCoverLetter() {
		return _spJobApplicants.getCoverLetter();
	}

	/**
	* Sets the cover letter of this s p job applicants.
	*
	* @param coverLetter the cover letter of this s p job applicants
	*/
	@Override
	public void setCoverLetter(java.lang.String coverLetter) {
		_spJobApplicants.setCoverLetter(coverLetter);
	}

	/**
	* Returns the brief infos of this s p job applicants.
	*
	* @return the brief infos of this s p job applicants
	*/
	@Override
	public java.lang.String getBriefInfos() {
		return _spJobApplicants.getBriefInfos();
	}

	/**
	* Sets the brief infos of this s p job applicants.
	*
	* @param briefInfos the brief infos of this s p job applicants
	*/
	@Override
	public void setBriefInfos(java.lang.String briefInfos) {
		_spJobApplicants.setBriefInfos(briefInfos);
	}

	/**
	* Returns the extra1 of this s p job applicants.
	*
	* @return the extra1 of this s p job applicants
	*/
	@Override
	public java.lang.String getExtra1() {
		return _spJobApplicants.getExtra1();
	}

	/**
	* Sets the extra1 of this s p job applicants.
	*
	* @param extra1 the extra1 of this s p job applicants
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_spJobApplicants.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this s p job applicants.
	*
	* @return the extra2 of this s p job applicants
	*/
	@Override
	public java.lang.String getExtra2() {
		return _spJobApplicants.getExtra2();
	}

	/**
	* Sets the extra2 of this s p job applicants.
	*
	* @param extra2 the extra2 of this s p job applicants
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_spJobApplicants.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this s p job applicants.
	*
	* @return the extra3 of this s p job applicants
	*/
	@Override
	public java.lang.String getExtra3() {
		return _spJobApplicants.getExtra3();
	}

	/**
	* Sets the extra3 of this s p job applicants.
	*
	* @param extra3 the extra3 of this s p job applicants
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_spJobApplicants.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this s p job applicants.
	*
	* @return the extra4 of this s p job applicants
	*/
	@Override
	public java.lang.String getExtra4() {
		return _spJobApplicants.getExtra4();
	}

	/**
	* Sets the extra4 of this s p job applicants.
	*
	* @param extra4 the extra4 of this s p job applicants
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_spJobApplicants.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this s p job applicants.
	*
	* @return the extra5 of this s p job applicants
	*/
	@Override
	public java.lang.String getExtra5() {
		return _spJobApplicants.getExtra5();
	}

	/**
	* Sets the extra5 of this s p job applicants.
	*
	* @param extra5 the extra5 of this s p job applicants
	*/
	@Override
	public void setExtra5(java.lang.String extra5) {
		_spJobApplicants.setExtra5(extra5);
	}

	@Override
	public boolean isNew() {
		return _spJobApplicants.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spJobApplicants.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spJobApplicants.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spJobApplicants.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spJobApplicants.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spJobApplicants.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spJobApplicants.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spJobApplicants.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spJobApplicants.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spJobApplicants.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spJobApplicants.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPJobApplicantsWrapper((SPJobApplicants)_spJobApplicants.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spjob.model.SPJobApplicants spJobApplicants) {
		return _spJobApplicants.compareTo(spJobApplicants);
	}

	@Override
	public int hashCode() {
		return _spJobApplicants.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spjob.model.SPJobApplicants> toCacheModel() {
		return _spJobApplicants.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants toEscapedModel() {
		return new SPJobApplicantsWrapper(_spJobApplicants.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants toUnescapedModel() {
		return new SPJobApplicantsWrapper(_spJobApplicants.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spJobApplicants.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spJobApplicants.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spJobApplicants.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPJobApplicantsWrapper)) {
			return false;
		}

		SPJobApplicantsWrapper spJobApplicantsWrapper = (SPJobApplicantsWrapper)obj;

		if (Validator.equals(_spJobApplicants,
					spJobApplicantsWrapper._spJobApplicants)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPJobApplicants getWrappedSPJobApplicants() {
		return _spJobApplicants;
	}

	@Override
	public SPJobApplicants getWrappedModel() {
		return _spJobApplicants;
	}

	@Override
	public void resetOriginalValues() {
		_spJobApplicants.resetOriginalValues();
	}

	private SPJobApplicants _spJobApplicants;
}