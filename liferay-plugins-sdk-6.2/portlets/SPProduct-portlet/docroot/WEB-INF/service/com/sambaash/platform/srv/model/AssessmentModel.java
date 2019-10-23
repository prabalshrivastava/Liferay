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

package com.sambaash.platform.srv.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.GroupedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the Assessment service. Represents a row in the &quot;SPAssessment&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.model.impl.AssessmentModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.model.impl.AssessmentImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Assessment
 * @see com.sambaash.platform.srv.model.impl.AssessmentImpl
 * @see com.sambaash.platform.srv.model.impl.AssessmentModelImpl
 * @generated
 */
public interface AssessmentModel extends BaseModel<Assessment>, GroupedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a assessment model instance should use the {@link Assessment} interface instead.
	 */

	/**
	 * Returns the primary key of this assessment.
	 *
	 * @return the primary key of this assessment
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this assessment.
	 *
	 * @param primaryKey the primary key of this assessment
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the sp assessment ID of this assessment.
	 *
	 * @return the sp assessment ID of this assessment
	 */
	public long getSpAssessmentId();

	/**
	 * Sets the sp assessment ID of this assessment.
	 *
	 * @param spAssessmentId the sp assessment ID of this assessment
	 */
	public void setSpAssessmentId(long spAssessmentId);

	/**
	 * Returns the group ID of this assessment.
	 *
	 * @return the group ID of this assessment
	 */
	@Override
	public long getGroupId();

	/**
	 * Sets the group ID of this assessment.
	 *
	 * @param groupId the group ID of this assessment
	 */
	@Override
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this assessment.
	 *
	 * @return the company ID of this assessment
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this assessment.
	 *
	 * @param companyId the company ID of this assessment
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the user ID of this assessment.
	 *
	 * @return the user ID of this assessment
	 */
	@Override
	public long getUserId();

	/**
	 * Sets the user ID of this assessment.
	 *
	 * @param userId the user ID of this assessment
	 */
	@Override
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this assessment.
	 *
	 * @return the user uuid of this assessment
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this assessment.
	 *
	 * @param userUuid the user uuid of this assessment
	 */
	@Override
	public void setUserUuid(String userUuid);

	/**
	 * Returns the user name of this assessment.
	 *
	 * @return the user name of this assessment
	 */
	@AutoEscape
	@Override
	public String getUserName();

	/**
	 * Sets the user name of this assessment.
	 *
	 * @param userName the user name of this assessment
	 */
	@Override
	public void setUserName(String userName);

	/**
	 * Returns the create date of this assessment.
	 *
	 * @return the create date of this assessment
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this assessment.
	 *
	 * @param createDate the create date of this assessment
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this assessment.
	 *
	 * @return the modified date of this assessment
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this assessment.
	 *
	 * @param modifiedDate the modified date of this assessment
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the sp module ID of this assessment.
	 *
	 * @return the sp module ID of this assessment
	 */
	public long getSpModuleId();

	/**
	 * Sets the sp module ID of this assessment.
	 *
	 * @param spModuleId the sp module ID of this assessment
	 */
	public void setSpModuleId(long spModuleId);

	/**
	 * Returns the assessment desc of this assessment.
	 *
	 * @return the assessment desc of this assessment
	 */
	@AutoEscape
	public String getAssessmentDesc();

	/**
	 * Sets the assessment desc of this assessment.
	 *
	 * @param assessmentDesc the assessment desc of this assessment
	 */
	public void setAssessmentDesc(String assessmentDesc);

	/**
	 * Returns the assessment type of this assessment.
	 *
	 * @return the assessment type of this assessment
	 */
	public long getAssessmentType();

	/**
	 * Sets the assessment type of this assessment.
	 *
	 * @param assessmentType the assessment type of this assessment
	 */
	public void setAssessmentType(long assessmentType);

	/**
	 * Returns the assessment method of this assessment.
	 *
	 * @return the assessment method of this assessment
	 */
	public long getAssessmentMethod();

	/**
	 * Sets the assessment method of this assessment.
	 *
	 * @param assessmentMethod the assessment method of this assessment
	 */
	public void setAssessmentMethod(long assessmentMethod);

	/**
	 * Returns the assessment mode of this assessment.
	 *
	 * @return the assessment mode of this assessment
	 */
	public long getAssessmentMode();

	/**
	 * Sets the assessment mode of this assessment.
	 *
	 * @param assessmentMode the assessment mode of this assessment
	 */
	public void setAssessmentMode(long assessmentMode);

	/**
	 * Returns the location type of this assessment.
	 *
	 * @return the location type of this assessment
	 */
	public long getLocationType();

	/**
	 * Sets the location type of this assessment.
	 *
	 * @param locationType the location type of this assessment
	 */
	public void setLocationType(long locationType);

	/**
	 * Returns the eligibility of this assessment.
	 *
	 * @return the eligibility of this assessment
	 */
	@AutoEscape
	public String getEligibility();

	/**
	 * Sets the eligibility of this assessment.
	 *
	 * @param eligibility the eligibility of this assessment
	 */
	public void setEligibility(String eligibility);

	/**
	 * Returns the grading type of this assessment.
	 *
	 * @return the grading type of this assessment
	 */
	public long getGradingType();

	/**
	 * Sets the grading type of this assessment.
	 *
	 * @param gradingType the grading type of this assessment
	 */
	public void setGradingType(long gradingType);

	/**
	 * Returns the maximum marks of this assessment.
	 *
	 * @return the maximum marks of this assessment
	 */
	@AutoEscape
	public String getMaximumMarks();

	/**
	 * Sets the maximum marks of this assessment.
	 *
	 * @param maximumMarks the maximum marks of this assessment
	 */
	public void setMaximumMarks(String maximumMarks);

	/**
	 * Returns the passing marks of this assessment.
	 *
	 * @return the passing marks of this assessment
	 */
	@AutoEscape
	public String getPassingMarks();

	/**
	 * Sets the passing marks of this assessment.
	 *
	 * @param passingMarks the passing marks of this assessment
	 */
	public void setPassingMarks(String passingMarks);

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
	public int compareTo(com.sambaash.platform.srv.model.Assessment assessment);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.model.Assessment> toCacheModel();

	@Override
	public com.sambaash.platform.srv.model.Assessment toEscapedModel();

	@Override
	public com.sambaash.platform.srv.model.Assessment toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}