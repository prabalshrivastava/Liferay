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
 * This class is a wrapper for {@link SPStudentProgrammeResult}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SPStudentProgrammeResult
 * @generated
 */
public class SPStudentProgrammeResultWrapper implements SPStudentProgrammeResult,
	ModelWrapper<SPStudentProgrammeResult> {
	public SPStudentProgrammeResultWrapper(
		SPStudentProgrammeResult spStudentProgrammeResult) {
		_spStudentProgrammeResult = spStudentProgrammeResult;
	}

	@Override
	public Class<?> getModelClass() {
		return SPStudentProgrammeResult.class;
	}

	@Override
	public String getModelClassName() {
		return SPStudentProgrammeResult.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spStudentProgrammeResultId",
			getSpStudentProgrammeResultId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("nric", getNric());
		attributes.put("emailAddress", getEmailAddress());
		attributes.put("courseCentre", getCourseCentre());
		attributes.put("courseStartDate", getCourseStartDate());
		attributes.put("courseEndDate", getCourseEndDate());
		attributes.put("programme", getProgramme());
		attributes.put("exam", getExam());
		attributes.put("examType", getExamType());
		attributes.put("paper1Result", getPaper1Result());
		attributes.put("paper2Result", getPaper2Result());
		attributes.put("overallResult", getOverallResult());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spStudentProgrammeResultId = (Long)attributes.get(
				"spStudentProgrammeResultId");

		if (spStudentProgrammeResultId != null) {
			setSpStudentProgrammeResultId(spStudentProgrammeResultId);
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

		String programme = (String)attributes.get("programme");

		if (programme != null) {
			setProgramme(programme);
		}

		Date exam = (Date)attributes.get("exam");

		if (exam != null) {
			setExam(exam);
		}

		String examType = (String)attributes.get("examType");

		if (examType != null) {
			setExamType(examType);
		}

		String paper1Result = (String)attributes.get("paper1Result");

		if (paper1Result != null) {
			setPaper1Result(paper1Result);
		}

		String paper2Result = (String)attributes.get("paper2Result");

		if (paper2Result != null) {
			setPaper2Result(paper2Result);
		}

		String overallResult = (String)attributes.get("overallResult");

		if (overallResult != null) {
			setOverallResult(overallResult);
		}
	}

	/**
	* Returns the primary key of this s p student programme result.
	*
	* @return the primary key of this s p student programme result
	*/
	@Override
	public long getPrimaryKey() {
		return _spStudentProgrammeResult.getPrimaryKey();
	}

	/**
	* Sets the primary key of this s p student programme result.
	*
	* @param primaryKey the primary key of this s p student programme result
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_spStudentProgrammeResult.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp student programme result ID of this s p student programme result.
	*
	* @return the sp student programme result ID of this s p student programme result
	*/
	@Override
	public long getSpStudentProgrammeResultId() {
		return _spStudentProgrammeResult.getSpStudentProgrammeResultId();
	}

	/**
	* Sets the sp student programme result ID of this s p student programme result.
	*
	* @param spStudentProgrammeResultId the sp student programme result ID of this s p student programme result
	*/
	@Override
	public void setSpStudentProgrammeResultId(long spStudentProgrammeResultId) {
		_spStudentProgrammeResult.setSpStudentProgrammeResultId(spStudentProgrammeResultId);
	}

	/**
	* Returns the company ID of this s p student programme result.
	*
	* @return the company ID of this s p student programme result
	*/
	@Override
	public long getCompanyId() {
		return _spStudentProgrammeResult.getCompanyId();
	}

	/**
	* Sets the company ID of this s p student programme result.
	*
	* @param companyId the company ID of this s p student programme result
	*/
	@Override
	public void setCompanyId(long companyId) {
		_spStudentProgrammeResult.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this s p student programme result.
	*
	* @return the user ID of this s p student programme result
	*/
	@Override
	public long getUserId() {
		return _spStudentProgrammeResult.getUserId();
	}

	/**
	* Sets the user ID of this s p student programme result.
	*
	* @param userId the user ID of this s p student programme result
	*/
	@Override
	public void setUserId(long userId) {
		_spStudentProgrammeResult.setUserId(userId);
	}

	/**
	* Returns the user uuid of this s p student programme result.
	*
	* @return the user uuid of this s p student programme result
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _spStudentProgrammeResult.getUserUuid();
	}

	/**
	* Sets the user uuid of this s p student programme result.
	*
	* @param userUuid the user uuid of this s p student programme result
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_spStudentProgrammeResult.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this s p student programme result.
	*
	* @return the user name of this s p student programme result
	*/
	@Override
	public java.lang.String getUserName() {
		return _spStudentProgrammeResult.getUserName();
	}

	/**
	* Sets the user name of this s p student programme result.
	*
	* @param userName the user name of this s p student programme result
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_spStudentProgrammeResult.setUserName(userName);
	}

	/**
	* Returns the create date of this s p student programme result.
	*
	* @return the create date of this s p student programme result
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _spStudentProgrammeResult.getCreateDate();
	}

	/**
	* Sets the create date of this s p student programme result.
	*
	* @param createDate the create date of this s p student programme result
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_spStudentProgrammeResult.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this s p student programme result.
	*
	* @return the modified date of this s p student programme result
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _spStudentProgrammeResult.getModifiedDate();
	}

	/**
	* Sets the modified date of this s p student programme result.
	*
	* @param modifiedDate the modified date of this s p student programme result
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_spStudentProgrammeResult.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the nric of this s p student programme result.
	*
	* @return the nric of this s p student programme result
	*/
	@Override
	public java.lang.String getNric() {
		return _spStudentProgrammeResult.getNric();
	}

	/**
	* Sets the nric of this s p student programme result.
	*
	* @param nric the nric of this s p student programme result
	*/
	@Override
	public void setNric(java.lang.String nric) {
		_spStudentProgrammeResult.setNric(nric);
	}

	/**
	* Returns the email address of this s p student programme result.
	*
	* @return the email address of this s p student programme result
	*/
	@Override
	public java.lang.String getEmailAddress() {
		return _spStudentProgrammeResult.getEmailAddress();
	}

	/**
	* Sets the email address of this s p student programme result.
	*
	* @param emailAddress the email address of this s p student programme result
	*/
	@Override
	public void setEmailAddress(java.lang.String emailAddress) {
		_spStudentProgrammeResult.setEmailAddress(emailAddress);
	}

	/**
	* Returns the course centre of this s p student programme result.
	*
	* @return the course centre of this s p student programme result
	*/
	@Override
	public java.lang.String getCourseCentre() {
		return _spStudentProgrammeResult.getCourseCentre();
	}

	/**
	* Sets the course centre of this s p student programme result.
	*
	* @param courseCentre the course centre of this s p student programme result
	*/
	@Override
	public void setCourseCentre(java.lang.String courseCentre) {
		_spStudentProgrammeResult.setCourseCentre(courseCentre);
	}

	/**
	* Returns the course start date of this s p student programme result.
	*
	* @return the course start date of this s p student programme result
	*/
	@Override
	public java.util.Date getCourseStartDate() {
		return _spStudentProgrammeResult.getCourseStartDate();
	}

	/**
	* Sets the course start date of this s p student programme result.
	*
	* @param courseStartDate the course start date of this s p student programme result
	*/
	@Override
	public void setCourseStartDate(java.util.Date courseStartDate) {
		_spStudentProgrammeResult.setCourseStartDate(courseStartDate);
	}

	/**
	* Returns the course end date of this s p student programme result.
	*
	* @return the course end date of this s p student programme result
	*/
	@Override
	public java.util.Date getCourseEndDate() {
		return _spStudentProgrammeResult.getCourseEndDate();
	}

	/**
	* Sets the course end date of this s p student programme result.
	*
	* @param courseEndDate the course end date of this s p student programme result
	*/
	@Override
	public void setCourseEndDate(java.util.Date courseEndDate) {
		_spStudentProgrammeResult.setCourseEndDate(courseEndDate);
	}

	/**
	* Returns the programme of this s p student programme result.
	*
	* @return the programme of this s p student programme result
	*/
	@Override
	public java.lang.String getProgramme() {
		return _spStudentProgrammeResult.getProgramme();
	}

	/**
	* Sets the programme of this s p student programme result.
	*
	* @param programme the programme of this s p student programme result
	*/
	@Override
	public void setProgramme(java.lang.String programme) {
		_spStudentProgrammeResult.setProgramme(programme);
	}

	/**
	* Returns the exam of this s p student programme result.
	*
	* @return the exam of this s p student programme result
	*/
	@Override
	public java.util.Date getExam() {
		return _spStudentProgrammeResult.getExam();
	}

	/**
	* Sets the exam of this s p student programme result.
	*
	* @param exam the exam of this s p student programme result
	*/
	@Override
	public void setExam(java.util.Date exam) {
		_spStudentProgrammeResult.setExam(exam);
	}

	/**
	* Returns the exam type of this s p student programme result.
	*
	* @return the exam type of this s p student programme result
	*/
	@Override
	public java.lang.String getExamType() {
		return _spStudentProgrammeResult.getExamType();
	}

	/**
	* Sets the exam type of this s p student programme result.
	*
	* @param examType the exam type of this s p student programme result
	*/
	@Override
	public void setExamType(java.lang.String examType) {
		_spStudentProgrammeResult.setExamType(examType);
	}

	/**
	* Returns the paper1 result of this s p student programme result.
	*
	* @return the paper1 result of this s p student programme result
	*/
	@Override
	public java.lang.String getPaper1Result() {
		return _spStudentProgrammeResult.getPaper1Result();
	}

	/**
	* Sets the paper1 result of this s p student programme result.
	*
	* @param paper1Result the paper1 result of this s p student programme result
	*/
	@Override
	public void setPaper1Result(java.lang.String paper1Result) {
		_spStudentProgrammeResult.setPaper1Result(paper1Result);
	}

	/**
	* Returns the paper2 result of this s p student programme result.
	*
	* @return the paper2 result of this s p student programme result
	*/
	@Override
	public java.lang.String getPaper2Result() {
		return _spStudentProgrammeResult.getPaper2Result();
	}

	/**
	* Sets the paper2 result of this s p student programme result.
	*
	* @param paper2Result the paper2 result of this s p student programme result
	*/
	@Override
	public void setPaper2Result(java.lang.String paper2Result) {
		_spStudentProgrammeResult.setPaper2Result(paper2Result);
	}

	/**
	* Returns the overall result of this s p student programme result.
	*
	* @return the overall result of this s p student programme result
	*/
	@Override
	public java.lang.String getOverallResult() {
		return _spStudentProgrammeResult.getOverallResult();
	}

	/**
	* Sets the overall result of this s p student programme result.
	*
	* @param overallResult the overall result of this s p student programme result
	*/
	@Override
	public void setOverallResult(java.lang.String overallResult) {
		_spStudentProgrammeResult.setOverallResult(overallResult);
	}

	@Override
	public boolean isNew() {
		return _spStudentProgrammeResult.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_spStudentProgrammeResult.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _spStudentProgrammeResult.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_spStudentProgrammeResult.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _spStudentProgrammeResult.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _spStudentProgrammeResult.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_spStudentProgrammeResult.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _spStudentProgrammeResult.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_spStudentProgrammeResult.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_spStudentProgrammeResult.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_spStudentProgrammeResult.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SPStudentProgrammeResultWrapper((SPStudentProgrammeResult)_spStudentProgrammeResult.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult spStudentProgrammeResult) {
		return _spStudentProgrammeResult.compareTo(spStudentProgrammeResult);
	}

	@Override
	public int hashCode() {
		return _spStudentProgrammeResult.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult> toCacheModel() {
		return _spStudentProgrammeResult.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult toEscapedModel() {
		return new SPStudentProgrammeResultWrapper(_spStudentProgrammeResult.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.validation.model.SPStudentProgrammeResult toUnescapedModel() {
		return new SPStudentProgrammeResultWrapper(_spStudentProgrammeResult.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _spStudentProgrammeResult.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _spStudentProgrammeResult.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_spStudentProgrammeResult.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SPStudentProgrammeResultWrapper)) {
			return false;
		}

		SPStudentProgrammeResultWrapper spStudentProgrammeResultWrapper = (SPStudentProgrammeResultWrapper)obj;

		if (Validator.equals(_spStudentProgrammeResult,
					spStudentProgrammeResultWrapper._spStudentProgrammeResult)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SPStudentProgrammeResult getWrappedSPStudentProgrammeResult() {
		return _spStudentProgrammeResult;
	}

	@Override
	public SPStudentProgrammeResult getWrappedModel() {
		return _spStudentProgrammeResult;
	}

	@Override
	public void resetOriginalValues() {
		_spStudentProgrammeResult.resetOriginalValues();
	}

	private SPStudentProgrammeResult _spStudentProgrammeResult;
}