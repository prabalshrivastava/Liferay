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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SPJob}.
 * </p>
 *
 * @author harini
 * @see SPJob
 * @generated
 */
public class SPJobWrapper implements SPJob, ModelWrapper<SPJob> {
	public SPJobWrapper(SPJob spJob) {
		_spJob = spJob;
	}

	@Override
	public Class<?> getModelClass() {
		return SPJob.class;
	}

	@Override
	public String getModelClassName() {
		return SPJob.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("spJobId", getSpJobId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("yearsOfExperience", getYearsOfExperience());
		attributes.put("corporateName", getCorporateName());
		attributes.put("corporateId", getCorporateId());
		attributes.put("jobTitle", getJobTitle());
		attributes.put("jobType", getJobType());
		attributes.put("jobLocation", getJobLocation());
		attributes.put("jobDescription", getJobDescription());
		attributes.put("status", getStatus());
		attributes.put("autoMatch", getAutoMatch());
		attributes.put("currency", getCurrency());
		attributes.put("salary", getSalary());
		attributes.put("rate", getRate());
		attributes.put("startDate", getStartDate());
		attributes.put("endDate", getEndDate());
		attributes.put("closingDate", getClosingDate());
		attributes.put("extra1", getExtra1());
		attributes.put("extra2", getExtra2());
		attributes.put("extra3", getExtra3());
		attributes.put("extra4", getExtra4());
		attributes.put("extra5", getExtra5());
		attributes.put("notefto", getNotefto());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long spJobId = (Long)attributes.get("spJobId");

		if (spJobId != null) {
			setSpJobId(spJobId);
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

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Long updatedBy = (Long)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		String yearsOfExperience = (String)attributes.get("yearsOfExperience");

		if (yearsOfExperience != null) {
			setYearsOfExperience(yearsOfExperience);
		}

		String corporateName = (String)attributes.get("corporateName");

		if (corporateName != null) {
			setCorporateName(corporateName);
		}

		Long corporateId = (Long)attributes.get("corporateId");

		if (corporateId != null) {
			setCorporateId(corporateId);
		}

		String jobTitle = (String)attributes.get("jobTitle");

		if (jobTitle != null) {
			setJobTitle(jobTitle);
		}

		String jobType = (String)attributes.get("jobType");

		if (jobType != null) {
			setJobType(jobType);
		}

		String jobLocation = (String)attributes.get("jobLocation");

		if (jobLocation != null) {
			setJobLocation(jobLocation);
		}

		String jobDescription = (String)attributes.get("jobDescription");

		if (jobDescription != null) {
			setJobDescription(jobDescription);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Boolean autoMatch = (Boolean)attributes.get("autoMatch");

		if (autoMatch != null) {
			setAutoMatch(autoMatch);
		}

		String currency = (String)attributes.get("currency");

		if (currency != null) {
			setCurrency(currency);
		}

		Double salary = (Double)attributes.get("salary");

		if (salary != null) {
			setSalary(salary);
		}

		String rate = (String)attributes.get("rate");

		if (rate != null) {
			setRate(rate);
		}

		Date startDate = (Date)attributes.get("startDate");

		if (startDate != null) {
			setStartDate(startDate);
		}

		Date endDate = (Date)attributes.get("endDate");

		if (endDate != null) {
			setEndDate(endDate);
		}

		Date closingDate = (Date)attributes.get("closingDate");

		if (closingDate != null) {
			setClosingDate(closingDate);
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

		String notefto = (String)attributes.get("notefto");

		if (notefto != null) {
			setNotefto(notefto);
		}
	}

	/**
	* Returns the primary key of this s p job.
	*
	* @return the primary key of this s p job
	*/
	@Override
	public long getPrimaryKey() {
		return _spJob.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p job.
	*
	* @param primaryKey the primary key of this s p job
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spJob.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this s p job.
	*
	* @return the uuid of this s p job
	*/
	@Override
	public java.lang.String getUuid() {
		return _spJob.getUuid();
	}

	/**
	* Sets the uuid of this s p job.
	*
	* @param uuid the uuid of this s p job
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_spJob.setUuid(uuid);
	}

	/**
	* Returns the sp job ID of this s p job.
	*
	* @return the sp job ID of this s p job
	*/
	@Override
	public long getSpJobId() {
		return _spJob.getSpJobId();
	}

	/**
	* Sets the sp job ID of this s p job.
	*
	* @param spJobId the sp job ID of this s p job
	*/
	@Override
	public void setSpJobId(long spJobId) {
		_spJob.setSpJobId(spJobId);
	}

	/**
	* Returns the group ID of this s p job.
	*
	* @return the group ID of this s p job
	*/
	@Override
	public long getGroupId() {
		return _spJob.getGroupId();
	}

	/**
	* Sets the group ID of this s p job.
	*
	* @param groupId the group ID of this s p job
	*/
	@Override
	public void setGroupId(long groupId) {
		_spJob.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this s p job.
	*
	* @return the company ID of this s p job
	*/
	@Override
	public long getCompanyId() {
		return _spJob.getCompanyId();
	}

	/**
	* Sets the company ID of this s p job.
	*
	* @param companyId the company ID of this s p job
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spJob.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p job.
	*
	* @return the user ID of this s p job
	*/
	@Override
	public long getUserId() {
		return _spJob.getUserId();
	}

	/**
	* Sets the user ID of this s p job.
	*
	* @param userId the user ID of this s p job
	*/
	@Override
	public void setUserId(long userId) {
		_spJob.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p job.
	*
	* @return the user uuid of this s p job
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spJob.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p job.
	*
	* @param userUuid the user uuid of this s p job
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spJob.setUserUuid(userUuid);
	}

	/**
	* Returns the created by of this s p job.
	*
	* @return the created by of this s p job
	*/
	@Override
	public long getCreatedBy() {
		return _spJob.getCreatedBy();
	}

	/**
	* Sets the created by of this s p job.
	*
	* @param createdBy the created by of this s p job
	*/
	@Override
	public void setCreatedBy(long createdBy) {
		_spJob.setCreatedBy(createdBy);
	}

	/**
	* Returns the create date of this s p job.
	*
	* @return the create date of this s p job
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spJob.getCreateDate();
	}

	/**
	* Sets the create date of this s p job.
	*
	* @param createDate the create date of this s p job
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spJob.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p job.
	*
	* @return the modified date of this s p job
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spJob.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p job.
	*
	* @param modifiedDate the modified date of this s p job
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spJob.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the updated by of this s p job.
	*
	* @return the updated by of this s p job
	*/
	@Override
	public long getUpdatedBy() {
		return _spJob.getUpdatedBy();
	}

	/**
	* Sets the updated by of this s p job.
	*
	* @param updatedBy the updated by of this s p job
	*/
	@Override
	public void setUpdatedBy(long updatedBy) {
		_spJob.setUpdatedBy(updatedBy);
	}

	/**
	* Returns the years of experience of this s p job.
	*
	* @return the years of experience of this s p job
	*/
	@Override
	public java.lang.String getYearsOfExperience() {
		return _spJob.getYearsOfExperience();
	}

	/**
	* Sets the years of experience of this s p job.
	*
	* @param yearsOfExperience the years of experience of this s p job
	*/
	@Override
	public void setYearsOfExperience(java.lang.String yearsOfExperience) {
		_spJob.setYearsOfExperience(yearsOfExperience);
	}

	/**
	* Returns the corporate name of this s p job.
	*
	* @return the corporate name of this s p job
	*/
	@Override
	public java.lang.String getCorporateName() {
		return _spJob.getCorporateName();
	}

	/**
	* Sets the corporate name of this s p job.
	*
	* @param corporateName the corporate name of this s p job
	*/
	@Override
	public void setCorporateName(java.lang.String corporateName) {
		_spJob.setCorporateName(corporateName);
	}

	/**
	* Returns the corporate ID of this s p job.
	*
	* @return the corporate ID of this s p job
	*/
	@Override
	public long getCorporateId() {
		return _spJob.getCorporateId();
	}

	/**
	* Sets the corporate ID of this s p job.
	*
	* @param corporateId the corporate ID of this s p job
	*/
	@Override
	public void setCorporateId(long corporateId) {
		_spJob.setCorporateId(corporateId);
	}

	/**
	* Returns the job title of this s p job.
	*
	* @return the job title of this s p job
	*/
	@Override
	public java.lang.String getJobTitle() {
		return _spJob.getJobTitle();
	}

	/**
	* Sets the job title of this s p job.
	*
	* @param jobTitle the job title of this s p job
	*/
	@Override
	public void setJobTitle(java.lang.String jobTitle) {
		_spJob.setJobTitle(jobTitle);
	}

	/**
	* Returns the job type of this s p job.
	*
	* @return the job type of this s p job
	*/
	@Override
	public java.lang.String getJobType() {
		return _spJob.getJobType();
	}

	/**
	* Sets the job type of this s p job.
	*
	* @param jobType the job type of this s p job
	*/
	@Override
	public void setJobType(java.lang.String jobType) {
		_spJob.setJobType(jobType);
	}

	/**
	* Returns the job location of this s p job.
	*
	* @return the job location of this s p job
	*/
	@Override
	public java.lang.String getJobLocation() {
		return _spJob.getJobLocation();
	}

	/**
	* Sets the job location of this s p job.
	*
	* @param jobLocation the job location of this s p job
	*/
	@Override
	public void setJobLocation(java.lang.String jobLocation) {
		_spJob.setJobLocation(jobLocation);
	}

	/**
	* Returns the job description of this s p job.
	*
	* @return the job description of this s p job
	*/
	@Override
	public java.lang.String getJobDescription() {
		return _spJob.getJobDescription();
	}

	/**
	* Sets the job description of this s p job.
	*
	* @param jobDescription the job description of this s p job
	*/
	@Override
	public void setJobDescription(java.lang.String jobDescription) {
		_spJob.setJobDescription(jobDescription);
	}

	/**
	* Returns the status of this s p job.
	*
	* @return the status of this s p job
	*/
	@Override
	public java.lang.String getStatus() {
		return _spJob.getStatus();
	}

	/**
	* Sets the status of this s p job.
	*
	* @param status the status of this s p job
	*/
	@Override
	public void setStatus(java.lang.String status) {
		_spJob.setStatus(status);
	}

	/**
	* Returns the auto match of this s p job.
	*
	* @return the auto match of this s p job
	*/
	@Override
	public boolean getAutoMatch() {
		return _spJob.getAutoMatch();
	}

	/**
	* Returns <code>true</code> if this s p job is auto match.
	*
	* @return <code>true</code> if this s p job is auto match; <code>false</code> otherwise
	*/
	@Override
	public boolean isAutoMatch() {
		return _spJob.isAutoMatch();
	}

	/**
	* Sets whether this s p job is auto match.
	*
	* @param autoMatch the auto match of this s p job
	*/
	@Override
	public void setAutoMatch(boolean autoMatch) {
		_spJob.setAutoMatch(autoMatch);
	}

	/**
	* Returns the currency of this s p job.
	*
	* @return the currency of this s p job
	*/
	@Override
	public java.lang.String getCurrency() {
		return _spJob.getCurrency();
	}

	/**
	* Sets the currency of this s p job.
	*
	* @param currency the currency of this s p job
	*/
	@Override
	public void setCurrency(java.lang.String currency) {
		_spJob.setCurrency(currency);
	}

	/**
	* Returns the salary of this s p job.
	*
	* @return the salary of this s p job
	*/
	@Override
	public double getSalary() {
		return _spJob.getSalary();
	}

	/**
	* Sets the salary of this s p job.
	*
	* @param salary the salary of this s p job
	*/
	@Override
	public void setSalary(double salary) {
		_spJob.setSalary(salary);
	}

	/**
	* Returns the rate of this s p job.
	*
	* @return the rate of this s p job
	*/
	@Override
	public java.lang.String getRate() {
		return _spJob.getRate();
	}

	/**
	* Sets the rate of this s p job.
	*
	* @param rate the rate of this s p job
	*/
	@Override
	public void setRate(java.lang.String rate) {
		_spJob.setRate(rate);
	}

	/**
	* Returns the start date of this s p job.
	*
	* @return the start date of this s p job
	*/
	@Override
	public java.util.Date getStartDate() {
		return _spJob.getStartDate();
	}

	/**
	* Sets the start date of this s p job.
	*
	* @param startDate the start date of this s p job
	*/
	@Override
	public void setStartDate(java.util.Date startDate) {
		_spJob.setStartDate(startDate);
	}

	/**
	* Returns the end date of this s p job.
	*
	* @return the end date of this s p job
	*/
	@Override
	public java.util.Date getEndDate() {
		return _spJob.getEndDate();
	}

	/**
	* Sets the end date of this s p job.
	*
	* @param endDate the end date of this s p job
	*/
	@Override
	public void setEndDate(java.util.Date endDate) {
		_spJob.setEndDate(endDate);
	}

	/**
	* Returns the closing date of this s p job.
	*
	* @return the closing date of this s p job
	*/
	@Override
	public java.util.Date getClosingDate() {
		return _spJob.getClosingDate();
	}

	/**
	* Sets the closing date of this s p job.
	*
	* @param closingDate the closing date of this s p job
	*/
	@Override
	public void setClosingDate(java.util.Date closingDate) {
		_spJob.setClosingDate(closingDate);
	}

	/**
	* Returns the extra1 of this s p job.
	*
	* @return the extra1 of this s p job
	*/
	@Override
	public java.lang.String getExtra1() {
		return _spJob.getExtra1();
	}

	/**
	* Sets the extra1 of this s p job.
	*
	* @param extra1 the extra1 of this s p job
	*/
	@Override
	public void setExtra1(java.lang.String extra1) {
		_spJob.setExtra1(extra1);
	}

	/**
	* Returns the extra2 of this s p job.
	*
	* @return the extra2 of this s p job
	*/
	@Override
	public java.lang.String getExtra2() {
		return _spJob.getExtra2();
	}

	/**
	* Sets the extra2 of this s p job.
	*
	* @param extra2 the extra2 of this s p job
	*/
	@Override
	public void setExtra2(java.lang.String extra2) {
		_spJob.setExtra2(extra2);
	}

	/**
	* Returns the extra3 of this s p job.
	*
	* @return the extra3 of this s p job
	*/
	@Override
	public java.lang.String getExtra3() {
		return _spJob.getExtra3();
	}

	/**
	* Sets the extra3 of this s p job.
	*
	* @param extra3 the extra3 of this s p job
	*/
	@Override
	public void setExtra3(java.lang.String extra3) {
		_spJob.setExtra3(extra3);
	}

	/**
	* Returns the extra4 of this s p job.
	*
	* @return the extra4 of this s p job
	*/
	@Override
	public java.lang.String getExtra4() {
		return _spJob.getExtra4();
	}

	/**
	* Sets the extra4 of this s p job.
	*
	* @param extra4 the extra4 of this s p job
	*/
	@Override
	public void setExtra4(java.lang.String extra4) {
		_spJob.setExtra4(extra4);
	}

	/**
	* Returns the extra5 of this s p job.
	*
	* @return the extra5 of this s p job
	*/
	@Override
	public java.lang.String getExtra5() {
		return _spJob.getExtra5();
	}

	/**
	* Sets the extra5 of this s p job.
	*
	* @param extra5 the extra5 of this s p job
	*/
	@Override
	public void setExtra5(java.lang.String extra5) {
		_spJob.setExtra5(extra5);
	}

	/**
	* Returns the notefto of this s p job.
	*
	* @return the notefto of this s p job
	*/
	@Override
	public java.lang.String getNotefto() {
		return _spJob.getNotefto();
	}

	/**
	* Sets the notefto of this s p job.
	*
	* @param notefto the notefto of this s p job
	*/
	@Override
	public void setNotefto(java.lang.String notefto) {
		_spJob.setNotefto(notefto);
	}

	@Override
	public boolean isNew() {
		return _spJob.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spJob.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spJob.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spJob.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spJob.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spJob.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spJob.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spJob.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spJob.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spJob.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spJob.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPJobWrapper((SPJob)_spJob.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.spjob.model.SPJob spJob) {
		return _spJob.compareTo(spJob);
	}

	@Override
	public int hashCode() {
		return _spJob.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spjob.model.SPJob> toCacheModel() {
		return _spJob.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob toEscapedModel() {
		return new SPJobWrapper(_spJob.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob toUnescapedModel() {
		return new SPJobWrapper(_spJob.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spJob.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spJob.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spJob.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPJobWrapper)) {
			return false;
		}

		SPJobWrapper spJobWrapper = (SPJobWrapper)obj;

		if (Validator.equals(_spJob, spJobWrapper._spJob)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _spJob.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPJob getWrappedSPJob() {
		return _spJob;
	}

	@Override
	public SPJob getWrappedModel() {
		return _spJob;
	}

	@Override
	public void resetOriginalValues() {
		_spJob.resetOriginalValues();
	}

	private SPJob _spJob;
}