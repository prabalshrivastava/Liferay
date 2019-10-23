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
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SPJobApplicants service. Represents a row in the &quot;SPJobApplicants&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsImpl}.
 * </p>
 *
 * @author harini
 * @see SPJobApplicants
 * @see com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsImpl
 * @see com.sambaash.platform.srv.spjob.model.impl.SPJobApplicantsModelImpl
 * @generated
 */
public interface SPJobApplicantsModel extends BaseModel<SPJobApplicants> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p job applicants model instance should use the {@link SPJobApplicants} interface instead.
	 */

	/**
	 * Returns the primary key of this s p job applicants.
	 *
	 * @return the primary key of this s p job applicants
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p job applicants.
	 *
	 * @param primaryKey the primary key of this s p job applicants
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp job applicants ID of this s p job applicants.
	 *
	 * @return the sp job applicants ID of this s p job applicants
	 */
	public long getSpJobApplicantsId();

	/**
	 * Sets the sp job applicants ID of this s p job applicants.
	 *
	 * @param spJobApplicantsId the sp job applicants ID of this s p job applicants
	 */
	public void setSpJobApplicantsId(long spJobApplicantsId);

	/**
	 * Returns the job ID of this s p job applicants.
	 *
	 * @return the job ID of this s p job applicants
	 */
	public long getJobId();

	/**
	 * Sets the job ID of this s p job applicants.
	 *
	 * @param jobId the job ID of this s p job applicants
	 */
	public void setJobId(long jobId);

	/**
	 * Returns the group ID of this s p job applicants.
	 *
	 * @return the group ID of this s p job applicants
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this s p job applicants.
	 *
	 * @param groupId the group ID of this s p job applicants
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this s p job applicants.
	 *
	 * @return the company ID of this s p job applicants
	 */
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p job applicants.
	 *
	 * @param companyId the company ID of this s p job applicants
	 */
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this s p job applicants.
	 *
	 * @return the user ID of this s p job applicants
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this s p job applicants.
	 *
	 * @param userId the user ID of this s p job applicants
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p job applicants.
	 *
	 * @return the user uuid of this s p job applicants
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p job applicants.
	 *
	 * @param userUuid the user uuid of this s p job applicants
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the created by of this s p job applicants.
	 *
	 * @return the created by of this s p job applicants
	 */
	public long getCreatedBy();

	/**
	 * Sets the created by of this s p job applicants.
	 *
	 * @param createdBy the created by of this s p job applicants
	 */
	public void setCreatedBy(long createdBy);

	/**
	 * Returns the updated by of this s p job applicants.
	 *
	 * @return the updated by of this s p job applicants
	 */
	public long getUpdatedBy();

	/**
	 * Sets the updated by of this s p job applicants.
	 *
	 * @param updatedBy the updated by of this s p job applicants
	 */
	public void setUpdatedBy(long updatedBy);

	/**
	 * Returns the create date of this s p job applicants.
	 *
	 * @return the create date of this s p job applicants
	 */
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p job applicants.
	 *
	 * @param createDate the create date of this s p job applicants
	 */
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p job applicants.
	 *
	 * @return the modified date of this s p job applicants
	 */
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p job applicants.
	 *
	 * @param modifiedDate the modified date of this s p job applicants
	 */
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the first name of this s p job applicants.
	 *
	 * @return the first name of this s p job applicants
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this s p job applicants.
	 *
	 * @param firstName the first name of this s p job applicants
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this s p job applicants.
	 *
	 * @return the last name of this s p job applicants
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this s p job applicants.
	 *
	 * @param lastName the last name of this s p job applicants
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the email address of this s p job applicants.
	 *
	 * @return the email address of this s p job applicants
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this s p job applicants.
	 *
	 * @param emailAddress the email address of this s p job applicants
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the contact number of this s p job applicants.
	 *
	 * @return the contact number of this s p job applicants
	 */
	@AutoEscape
	public String getContactNumber();

	/**
	 * Sets the contact number of this s p job applicants.
	 *
	 * @param contactNumber the contact number of this s p job applicants
	 */
	public void setContactNumber(String contactNumber);

	/**
	 * Returns the years of experience of this s p job applicants.
	 *
	 * @return the years of experience of this s p job applicants
	 */
	@AutoEscape
	public String getYearsOfExperience();

	/**
	 * Sets the years of experience of this s p job applicants.
	 *
	 * @param yearsOfExperience the years of experience of this s p job applicants
	 */
	public void setYearsOfExperience(String yearsOfExperience);

	/**
	 * Returns the resume of this s p job applicants.
	 *
	 * @return the resume of this s p job applicants
	 */
	@AutoEscape
	public String getResume();

	/**
	 * Sets the resume of this s p job applicants.
	 *
	 * @param resume the resume of this s p job applicants
	 */
	public void setResume(String resume);

	/**
	 * Returns the cover letter of this s p job applicants.
	 *
	 * @return the cover letter of this s p job applicants
	 */
	@AutoEscape
	public String getCoverLetter();

	/**
	 * Sets the cover letter of this s p job applicants.
	 *
	 * @param coverLetter the cover letter of this s p job applicants
	 */
	public void setCoverLetter(String coverLetter);

	/**
	 * Returns the brief infos of this s p job applicants.
	 *
	 * @return the brief infos of this s p job applicants
	 */
	@AutoEscape
	public String getBriefInfos();

	/**
	 * Sets the brief infos of this s p job applicants.
	 *
	 * @param briefInfos the brief infos of this s p job applicants
	 */
	public void setBriefInfos(String briefInfos);

	/**
	 * Returns the extra1 of this s p job applicants.
	 *
	 * @return the extra1 of this s p job applicants
	 */
	@AutoEscape
	public String getExtra1();

	/**
	 * Sets the extra1 of this s p job applicants.
	 *
	 * @param extra1 the extra1 of this s p job applicants
	 */
	public void setExtra1(String extra1);

	/**
	 * Returns the extra2 of this s p job applicants.
	 *
	 * @return the extra2 of this s p job applicants
	 */
	@AutoEscape
	public String getExtra2();

	/**
	 * Sets the extra2 of this s p job applicants.
	 *
	 * @param extra2 the extra2 of this s p job applicants
	 */
	public void setExtra2(String extra2);

	/**
	 * Returns the extra3 of this s p job applicants.
	 *
	 * @return the extra3 of this s p job applicants
	 */
	@AutoEscape
	public String getExtra3();

	/**
	 * Sets the extra3 of this s p job applicants.
	 *
	 * @param extra3 the extra3 of this s p job applicants
	 */
	public void setExtra3(String extra3);

	/**
	 * Returns the extra4 of this s p job applicants.
	 *
	 * @return the extra4 of this s p job applicants
	 */
	@AutoEscape
	public String getExtra4();

	/**
	 * Sets the extra4 of this s p job applicants.
	 *
	 * @param extra4 the extra4 of this s p job applicants
	 */
	public void setExtra4(String extra4);

	/**
	 * Returns the extra5 of this s p job applicants.
	 *
	 * @return the extra5 of this s p job applicants
	 */
	@AutoEscape
	public String getExtra5();

	/**
	 * Sets the extra5 of this s p job applicants.
	 *
	 * @param extra5 the extra5 of this s p job applicants
	 */
	public void setExtra5(String extra5);

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
		com.sambaash.platform.srv.spjob.model.SPJobApplicants spJobApplicants);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spjob.model.SPJobApplicants> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spjob.model.SPJobApplicants toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}