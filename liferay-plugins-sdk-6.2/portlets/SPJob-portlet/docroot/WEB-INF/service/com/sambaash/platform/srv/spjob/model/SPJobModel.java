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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SPJob service. Represents a row in the &quot;SPJob&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spjob.model.impl.SPJobImpl}.
 * </p>
 *
 * @author harini
 * @see SPJob
 * @see com.sambaash.platform.srv.spjob.model.impl.SPJobImpl
 * @see com.sambaash.platform.srv.spjob.model.impl.SPJobModelImpl
 * @generated
 */
public interface SPJobModel extends BaseModel<SPJob>, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p job model instance should use the {@link SPJob} interface instead.
	 */

	/**
	 * Returns the primary key of this s p job.
	 *
	 * @return the primary key of this s p job
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p job.
	 *
	 * @param primaryKey the primary key of this s p job
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this s p job.
	 *
	 * @return the uuid of this s p job
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this s p job.
	 *
	 * @param uuid the uuid of this s p job
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the sp job ID of this s p job.
	 *
	 * @return the sp job ID of this s p job
	 */
	public long getSpJobId();

	/**
	 * Sets the sp job ID of this s p job.
	 *
	 * @param spJobId the sp job ID of this s p job
	 */
	public void setSpJobId(long spJobId);

	/**
	 * Returns the group ID of this s p job.
	 *
	 * @return the group ID of this s p job
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this s p job.
	 *
	 * @param groupId the group ID of this s p job
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this s p job.
	 *
	 * @return the company ID of this s p job
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p job.
	 *
	 * @param companyId the company ID of this s p job
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this s p job.
	 *
	 * @return the user ID of this s p job
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this s p job.
	 *
	 * @param userId the user ID of this s p job
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p job.
	 *
	 * @return the user uuid of this s p job
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p job.
	 *
	 * @param userUuid the user uuid of this s p job
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the created by of this s p job.
	 *
	 * @return the created by of this s p job
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this s p job.
	 *
	 * @param createdBy the created by of this s p job
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the create date of this s p job.
	 *
	 * @return the create date of this s p job
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p job.
	 *
	 * @param createDate the create date of this s p job
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p job.
	 *
	 * @return the modified date of this s p job
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p job.
	 *
	 * @param modifiedDate the modified date of this s p job
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the updated by of this s p job.
	 *
	 * @return the updated by of this s p job
	 */
	public long getUpdatedBy();

	/**
	 * Sets the updated by of this s p job.
	 *
	 * @param updatedBy the updated by of this s p job
	 */
	public void setUpdatedBy(long updatedBy);

	/**
	 * Returns the years of experience of this s p job.
	 *
	 * @return the years of experience of this s p job
	 */
	@AutoEscape
	public String getYearsOfExperience();

	/**
	 * Sets the years of experience of this s p job.
	 *
	 * @param yearsOfExperience the years of experience of this s p job
	 */
	public void setYearsOfExperience(String yearsOfExperience);

	/**
	 * Returns the corporate name of this s p job.
	 *
	 * @return the corporate name of this s p job
	 */
	@AutoEscape
	public String getCorporateName();

	/**
	 * Sets the corporate name of this s p job.
	 *
	 * @param corporateName the corporate name of this s p job
	 */
	public void setCorporateName(String corporateName);

	/**
	 * Returns the corporate ID of this s p job.
	 *
	 * @return the corporate ID of this s p job
	 */
	public long getCorporateId();

	/**
	 * Sets the corporate ID of this s p job.
	 *
	 * @param corporateId the corporate ID of this s p job
	 */
	public void setCorporateId(long corporateId);

	/**
	 * Returns the job title of this s p job.
	 *
	 * @return the job title of this s p job
	 */
	@AutoEscape
	public String getJobTitle();

	/**
	 * Sets the job title of this s p job.
	 *
	 * @param jobTitle the job title of this s p job
	 */
	public void setJobTitle(String jobTitle);

	/**
	 * Returns the job type of this s p job.
	 *
	 * @return the job type of this s p job
	 */
	@AutoEscape
	public String getJobType();

	/**
	 * Sets the job type of this s p job.
	 *
	 * @param jobType the job type of this s p job
	 */
	public void setJobType(String jobType);

	/**
	 * Returns the job location of this s p job.
	 *
	 * @return the job location of this s p job
	 */
	@AutoEscape
	public String getJobLocation();

	/**
	 * Sets the job location of this s p job.
	 *
	 * @param jobLocation the job location of this s p job
	 */
	public void setJobLocation(String jobLocation);

	/**
	 * Returns the job description of this s p job.
	 *
	 * @return the job description of this s p job
	 */
	@AutoEscape
	public String getJobDescription();

	/**
	 * Sets the job description of this s p job.
	 *
	 * @param jobDescription the job description of this s p job
	 */
	public void setJobDescription(String jobDescription);

	/**
	 * Returns the status of this s p job.
	 *
	 * @return the status of this s p job
	 */
	@AutoEscape
	public String getStatus();

	/**
	 * Sets the status of this s p job.
	 *
	 * @param status the status of this s p job
	 */
	public void setStatus(String status);

	/**
	 * Returns the auto match of this s p job.
	 *
	 * @return the auto match of this s p job
	 */
	public boolean getAutoMatch();

	/**
	 * Returns <code>true</code> if this s p job is auto match.
	 *
	 * @return <code>true</code> if this s p job is auto match; <code>false</code> otherwise
	 */
	public boolean isAutoMatch();

	/**
	 * Sets whether this s p job is auto match.
	 *
	 * @param autoMatch the auto match of this s p job
	 */
	public void setAutoMatch(boolean autoMatch);

	/**
	 * Returns the currency of this s p job.
	 *
	 * @return the currency of this s p job
	 */
	@AutoEscape
	public String getCurrency();

	/**
	 * Sets the currency of this s p job.
	 *
	 * @param currency the currency of this s p job
	 */
	public void setCurrency(String currency);

	/**
	 * Returns the salary of this s p job.
	 *
	 * @return the salary of this s p job
	 */
	public double getSalary();

	/**
	 * Sets the salary of this s p job.
	 *
	 * @param salary the salary of this s p job
	 */
	public void setSalary(double salary);

	/**
	 * Returns the rate of this s p job.
	 *
	 * @return the rate of this s p job
	 */
	@AutoEscape
	public String getRate();

	/**
	 * Sets the rate of this s p job.
	 *
	 * @param rate the rate of this s p job
	 */
	public void setRate(String rate);

	/**
	 * Returns the start date of this s p job.
	 *
	 * @return the start date of this s p job
	 */
	public Date getStartDate();

	/**
	 * Sets the start date of this s p job.
	 *
	 * @param startDate the start date of this s p job
	 */
	public void setStartDate(Date startDate);

	/**
	 * Returns the end date of this s p job.
	 *
	 * @return the end date of this s p job
	 */
	public Date getEndDate();

	/**
	 * Sets the end date of this s p job.
	 *
	 * @param endDate the end date of this s p job
	 */
	public void setEndDate(Date endDate);

	/**
	 * Returns the closing date of this s p job.
	 *
	 * @return the closing date of this s p job
	 */
	public Date getClosingDate();

	/**
	 * Sets the closing date of this s p job.
	 *
	 * @param closingDate the closing date of this s p job
	 */
	public void setClosingDate(Date closingDate);

	/**
	 * Returns the extra1 of this s p job.
	 *
	 * @return the extra1 of this s p job
	 */
	@AutoEscape
	public String getExtra1();

	/**
	 * Sets the extra1 of this s p job.
	 *
	 * @param extra1 the extra1 of this s p job
	 */
	public void setExtra1(String extra1);

	/**
	 * Returns the extra2 of this s p job.
	 *
	 * @return the extra2 of this s p job
	 */
	@AutoEscape
	public String getExtra2();

	/**
	 * Sets the extra2 of this s p job.
	 *
	 * @param extra2 the extra2 of this s p job
	 */
	public void setExtra2(String extra2);

	/**
	 * Returns the extra3 of this s p job.
	 *
	 * @return the extra3 of this s p job
	 */
	@AutoEscape
	public String getExtra3();

	/**
	 * Sets the extra3 of this s p job.
	 *
	 * @param extra3 the extra3 of this s p job
	 */
	public void setExtra3(String extra3);

	/**
	 * Returns the extra4 of this s p job.
	 *
	 * @return the extra4 of this s p job
	 */
	@AutoEscape
	public String getExtra4();

	/**
	 * Sets the extra4 of this s p job.
	 *
	 * @param extra4 the extra4 of this s p job
	 */
	public void setExtra4(String extra4);

	/**
	 * Returns the extra5 of this s p job.
	 *
	 * @return the extra5 of this s p job
	 */
	@AutoEscape
	public String getExtra5();

	/**
	 * Sets the extra5 of this s p job.
	 *
	 * @param extra5 the extra5 of this s p job
	 */
	public void setExtra5(String extra5);

	/**
	 * Returns the notefto of this s p job.
	 *
	 * @return the notefto of this s p job
	 */
	@AutoEscape
	public String getNotefto();

	/**
	 * Sets the notefto of this s p job.
	 *
	 * @param notefto the notefto of this s p job
	 */
	public void setNotefto(String notefto);

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
	public int compareTo(com.sambaash.platform.srv.spjob.model.SPJob spJob);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spjob.model.SPJob> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJob toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}