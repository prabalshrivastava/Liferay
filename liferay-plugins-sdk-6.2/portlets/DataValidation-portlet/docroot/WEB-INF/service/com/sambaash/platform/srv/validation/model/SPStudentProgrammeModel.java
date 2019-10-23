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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.AuditedModel;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SPStudentProgramme service. Represents a row in the &quot;SPStudentProgramme&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPStudentProgramme
 * @see com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeImpl
 * @see com.sambaash.platform.srv.validation.model.impl.SPStudentProgrammeModelImpl
 * @generated
 */
public interface SPStudentProgrammeModel extends AuditedModel,
	BaseModel<SPStudentProgramme> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a s p student programme model instance should use the {@link SPStudentProgramme} interface instead.
	 */

	/**
	 * Returns the primary key of this s p student programme.
	 *
	 * @return the primary key of this s p student programme
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this s p student programme.
	 *
	 * @param primaryKey the primary key of this s p student programme
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp student course ID of this s p student programme.
	 *
	 * @return the sp student course ID of this s p student programme
	 */
	public long getSpStudentCourseId();

	/**
	 * Sets the sp student course ID of this s p student programme.
	 *
	 * @param spStudentCourseId the sp student course ID of this s p student programme
	 */
	public void setSpStudentCourseId(long spStudentCourseId);

	/**
	 * Returns the company ID of this s p student programme.
	 *
	 * @return the company ID of this s p student programme
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this s p student programme.
	 *
	 * @param companyId the company ID of this s p student programme
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this s p student programme.
	 *
	 * @return the user ID of this s p student programme
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this s p student programme.
	 *
	 * @param userId the user ID of this s p student programme
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this s p student programme.
	 *
	 * @return the user uuid of this s p student programme
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this s p student programme.
	 *
	 * @param userUuid the user uuid of this s p student programme
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this s p student programme.
	 *
	 * @return the user name of this s p student programme
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this s p student programme.
	 *
	 * @param userName the user name of this s p student programme
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this s p student programme.
	 *
	 * @return the create date of this s p student programme
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this s p student programme.
	 *
	 * @param createDate the create date of this s p student programme
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this s p student programme.
	 *
	 * @return the modified date of this s p student programme
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this s p student programme.
	 *
	 * @param modifiedDate the modified date of this s p student programme
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the nric of this s p student programme.
	 *
	 * @return the nric of this s p student programme
	 */
	@AutoEscape
	public String getNric();

	/**
	 * Sets the nric of this s p student programme.
	 *
	 * @param nric the nric of this s p student programme
	 */
	public void setNric(String nric);

	/**
	 * Returns the email address of this s p student programme.
	 *
	 * @return the email address of this s p student programme
	 */
	@AutoEscape
	public String getEmailAddress();

	/**
	 * Sets the email address of this s p student programme.
	 *
	 * @param emailAddress the email address of this s p student programme
	 */
	public void setEmailAddress(String emailAddress);

	/**
	 * Returns the programme of this s p student programme.
	 *
	 * @return the programme of this s p student programme
	 */
	@AutoEscape
	public String getProgramme();

	/**
	 * Sets the programme of this s p student programme.
	 *
	 * @param programme the programme of this s p student programme
	 */
	public void setProgramme(String programme);

	/**
	 * Returns the course centre of this s p student programme.
	 *
	 * @return the course centre of this s p student programme
	 */
	@AutoEscape
	public String getCourseCentre();

	/**
	 * Sets the course centre of this s p student programme.
	 *
	 * @param courseCentre the course centre of this s p student programme
	 */
	public void setCourseCentre(String courseCentre);

	/**
	 * Returns the course start date of this s p student programme.
	 *
	 * @return the course start date of this s p student programme
	 */
	public Date getCourseStartDate();

	/**
	 * Sets the course start date of this s p student programme.
	 *
	 * @param courseStartDate the course start date of this s p student programme
	 */
	public void setCourseStartDate(Date courseStartDate);

	/**
	 * Returns the course end date of this s p student programme.
	 *
	 * @return the course end date of this s p student programme
	 */
	public Date getCourseEndDate();

	/**
	 * Sets the course end date of this s p student programme.
	 *
	 * @param courseEndDate the course end date of this s p student programme
	 */
	public void setCourseEndDate(Date courseEndDate);

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
		com.sambaash.platform.srv.validation.model.SPStudentProgramme spStudentProgramme);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.validation.model.SPStudentProgramme> toCacheModel();

	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme toEscapedModel();

	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgramme toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}