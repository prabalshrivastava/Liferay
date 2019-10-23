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

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Assessment}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Assessment
 * @generated
 */
public class AssessmentWrapper implements Assessment, ModelWrapper<Assessment> {
	public AssessmentWrapper(Assessment assessment) {
		_assessment = assessment;
	}

	@Override
	public Class<?> getModelClass() {
		return Assessment.class;
	}

	@Override
	public String getModelClassName() {
		return Assessment.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spAssessmentId", getSpAssessmentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("spModuleId", getSpModuleId());
		attributes.put("assessmentDesc", getAssessmentDesc());
		attributes.put("assessmentType", getAssessmentType());
		attributes.put("assessmentMethod", getAssessmentMethod());
		attributes.put("assessmentMode", getAssessmentMode());
		attributes.put("locationType", getLocationType());
		attributes.put("eligibility", getEligibility());
		attributes.put("gradingType", getGradingType());
		attributes.put("maximumMarks", getMaximumMarks());
		attributes.put("passingMarks", getPassingMarks());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spAssessmentId = (Long)attributes.get("spAssessmentId");

		if (spAssessmentId != null) {
			setSpAssessmentId(spAssessmentId);
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

		Long spModuleId = (Long)attributes.get("spModuleId");

		if (spModuleId != null) {
			setSpModuleId(spModuleId);
		}

		String assessmentDesc = (String)attributes.get("assessmentDesc");

		if (assessmentDesc != null) {
			setAssessmentDesc(assessmentDesc);
		}

		Long assessmentType = (Long)attributes.get("assessmentType");

		if (assessmentType != null) {
			setAssessmentType(assessmentType);
		}

		Long assessmentMethod = (Long)attributes.get("assessmentMethod");

		if (assessmentMethod != null) {
			setAssessmentMethod(assessmentMethod);
		}

		Long assessmentMode = (Long)attributes.get("assessmentMode");

		if (assessmentMode != null) {
			setAssessmentMode(assessmentMode);
		}

		Long locationType = (Long)attributes.get("locationType");

		if (locationType != null) {
			setLocationType(locationType);
		}

		String eligibility = (String)attributes.get("eligibility");

		if (eligibility != null) {
			setEligibility(eligibility);
		}

		Long gradingType = (Long)attributes.get("gradingType");

		if (gradingType != null) {
			setGradingType(gradingType);
		}

		String maximumMarks = (String)attributes.get("maximumMarks");

		if (maximumMarks != null) {
			setMaximumMarks(maximumMarks);
		}

		String passingMarks = (String)attributes.get("passingMarks");

		if (passingMarks != null) {
			setPassingMarks(passingMarks);
		}
	}

	/**
	* Returns the primary key of this assessment.
	*
	* @return the primary key of this assessment
	*/
	@Override
	public long getPrimaryKey() {
		return _assessment.getPrimaryKey();
	}

	/**
	* Sets the primary key of this assessment.
	*
	* @param primaryKey the primary key of this assessment
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_assessment.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp assessment ID of this assessment.
	*
	* @return the sp assessment ID of this assessment
	*/
	@Override
	public long getSpAssessmentId() {
		return _assessment.getSpAssessmentId();
	}

	/**
	* Sets the sp assessment ID of this assessment.
	*
	* @param spAssessmentId the sp assessment ID of this assessment
	*/
	@Override
	public void setSpAssessmentId(long spAssessmentId) {
		_assessment.setSpAssessmentId(spAssessmentId);
	}

	/**
	* Returns the group ID of this assessment.
	*
	* @return the group ID of this assessment
	*/
	@Override
	public long getGroupId() {
		return _assessment.getGroupId();
	}

	/**
	* Sets the group ID of this assessment.
	*
	* @param groupId the group ID of this assessment
	*/
	@Override
	public void setGroupId(long groupId) {
		_assessment.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this assessment.
	*
	* @return the company ID of this assessment
	*/
	@Override
	public long getCompanyId() {
		return _assessment.getCompanyId();
	}

	/**
	* Sets the company ID of this assessment.
	*
	* @param companyId the company ID of this assessment
	*/
	@Override
	public void setCompanyId(long companyId) {
		_assessment.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this assessment.
	*
	* @return the user ID of this assessment
	*/
	@Override
	public long getUserId() {
		return _assessment.getUserId();
	}

	/**
	* Sets the user ID of this assessment.
	*
	* @param userId the user ID of this assessment
	*/
	@Override
	public void setUserId(long userId) {
		_assessment.setUserId(userId);
	}

	/**
	* Returns the user uuid of this assessment.
	*
	* @return the user uuid of this assessment
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _assessment.getUserUuid();
	}

	/**
	* Sets the user uuid of this assessment.
	*
	* @param userUuid the user uuid of this assessment
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_assessment.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this assessment.
	*
	* @return the user name of this assessment
	*/
	@Override
	public java.lang.String getUserName() {
		return _assessment.getUserName();
	}

	/**
	* Sets the user name of this assessment.
	*
	* @param userName the user name of this assessment
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_assessment.setUserName(userName);
	}

	/**
	* Returns the create date of this assessment.
	*
	* @return the create date of this assessment
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _assessment.getCreateDate();
	}

	/**
	* Sets the create date of this assessment.
	*
	* @param createDate the create date of this assessment
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_assessment.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this assessment.
	*
	* @return the modified date of this assessment
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _assessment.getModifiedDate();
	}

	/**
	* Sets the modified date of this assessment.
	*
	* @param modifiedDate the modified date of this assessment
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_assessment.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the sp module ID of this assessment.
	*
	* @return the sp module ID of this assessment
	*/
	@Override
	public long getSpModuleId() {
		return _assessment.getSpModuleId();
	}

	/**
	* Sets the sp module ID of this assessment.
	*
	* @param spModuleId the sp module ID of this assessment
	*/
	@Override
	public void setSpModuleId(long spModuleId) {
		_assessment.setSpModuleId(spModuleId);
	}

	/**
	* Returns the assessment desc of this assessment.
	*
	* @return the assessment desc of this assessment
	*/
	@Override
	public java.lang.String getAssessmentDesc() {
		return _assessment.getAssessmentDesc();
	}

	/**
	* Sets the assessment desc of this assessment.
	*
	* @param assessmentDesc the assessment desc of this assessment
	*/
	@Override
	public void setAssessmentDesc(java.lang.String assessmentDesc) {
		_assessment.setAssessmentDesc(assessmentDesc);
	}

	/**
	* Returns the assessment type of this assessment.
	*
	* @return the assessment type of this assessment
	*/
	@Override
	public long getAssessmentType() {
		return _assessment.getAssessmentType();
	}

	/**
	* Sets the assessment type of this assessment.
	*
	* @param assessmentType the assessment type of this assessment
	*/
	@Override
	public void setAssessmentType(long assessmentType) {
		_assessment.setAssessmentType(assessmentType);
	}

	/**
	* Returns the assessment method of this assessment.
	*
	* @return the assessment method of this assessment
	*/
	@Override
	public long getAssessmentMethod() {
		return _assessment.getAssessmentMethod();
	}

	/**
	* Sets the assessment method of this assessment.
	*
	* @param assessmentMethod the assessment method of this assessment
	*/
	@Override
	public void setAssessmentMethod(long assessmentMethod) {
		_assessment.setAssessmentMethod(assessmentMethod);
	}

	/**
	* Returns the assessment mode of this assessment.
	*
	* @return the assessment mode of this assessment
	*/
	@Override
	public long getAssessmentMode() {
		return _assessment.getAssessmentMode();
	}

	/**
	* Sets the assessment mode of this assessment.
	*
	* @param assessmentMode the assessment mode of this assessment
	*/
	@Override
	public void setAssessmentMode(long assessmentMode) {
		_assessment.setAssessmentMode(assessmentMode);
	}

	/**
	* Returns the location type of this assessment.
	*
	* @return the location type of this assessment
	*/
	@Override
	public long getLocationType() {
		return _assessment.getLocationType();
	}

	/**
	* Sets the location type of this assessment.
	*
	* @param locationType the location type of this assessment
	*/
	@Override
	public void setLocationType(long locationType) {
		_assessment.setLocationType(locationType);
	}

	/**
	* Returns the eligibility of this assessment.
	*
	* @return the eligibility of this assessment
	*/
	@Override
	public java.lang.String getEligibility() {
		return _assessment.getEligibility();
	}

	/**
	* Sets the eligibility of this assessment.
	*
	* @param eligibility the eligibility of this assessment
	*/
	@Override
	public void setEligibility(java.lang.String eligibility) {
		_assessment.setEligibility(eligibility);
	}

	/**
	* Returns the grading type of this assessment.
	*
	* @return the grading type of this assessment
	*/
	@Override
	public long getGradingType() {
		return _assessment.getGradingType();
	}

	/**
	* Sets the grading type of this assessment.
	*
	* @param gradingType the grading type of this assessment
	*/
	@Override
	public void setGradingType(long gradingType) {
		_assessment.setGradingType(gradingType);
	}

	/**
	* Returns the maximum marks of this assessment.
	*
	* @return the maximum marks of this assessment
	*/
	@Override
	public java.lang.String getMaximumMarks() {
		return _assessment.getMaximumMarks();
	}

	/**
	* Sets the maximum marks of this assessment.
	*
	* @param maximumMarks the maximum marks of this assessment
	*/
	@Override
	public void setMaximumMarks(java.lang.String maximumMarks) {
		_assessment.setMaximumMarks(maximumMarks);
	}

	/**
	* Returns the passing marks of this assessment.
	*
	* @return the passing marks of this assessment
	*/
	@Override
	public java.lang.String getPassingMarks() {
		return _assessment.getPassingMarks();
	}

	/**
	* Sets the passing marks of this assessment.
	*
	* @param passingMarks the passing marks of this assessment
	*/
	@Override
	public void setPassingMarks(java.lang.String passingMarks) {
		_assessment.setPassingMarks(passingMarks);
	}

	@Override
	public boolean isNew() {
		return _assessment.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_assessment.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _assessment.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_assessment.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _assessment.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _assessment.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_assessment.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _assessment.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_assessment.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_assessment.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_assessment.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new AssessmentWrapper((Assessment)_assessment.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Assessment assessment) {
		return _assessment.compareTo(assessment);
	}

	@Override
	public int hashCode() {
		return _assessment.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Assessment> toCacheModel() {
		return _assessment.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Assessment toEscapedModel() {
		return new AssessmentWrapper(_assessment.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Assessment toUnescapedModel() {
		return new AssessmentWrapper(_assessment.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _assessment.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _assessment.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_assessment.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof AssessmentWrapper)) {
			return false;
		}

		AssessmentWrapper assessmentWrapper = (AssessmentWrapper)obj;

		if (Validator.equals(_assessment, assessmentWrapper._assessment)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Assessment getWrappedAssessment() {
		return _assessment;
	}

	@Override
	public Assessment getWrappedModel() {
		return _assessment;
	}

	@Override
	public void resetOriginalValues() {
		_assessment.resetOriginalValues();
	}

	private Assessment _assessment;
}