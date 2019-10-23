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
 * This class is a wrapper for {@link Course}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see Course
 * @generated
 */
public class CourseWrapper implements Course, ModelWrapper<Course> {
	public CourseWrapper(Course course) {
		_course = course;
	}

	@Override
	public Class<?> getModelClass() {
		return Course.class;
	}

	@Override
	public String getModelClassName() {
		return Course.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("spCourseId", getSpCourseId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("countryId", getCountryId());
		attributes.put("courseCode", getCourseCode());
		attributes.put("courseName", getCourseName());
		attributes.put("displayCourseName", getDisplayCourseName());
		attributes.put("courseDesc", getCourseDesc());
		attributes.put("courseDurationFullTime", getCourseDurationFullTime());
		attributes.put("learningDurationFullTime", getLearningDurationFullTime());
		attributes.put("courseDurationPartTime", getCourseDurationPartTime());
		attributes.put("learningDurationPartTime", getLearningDurationPartTime());
		attributes.put("complexityLevel", getComplexityLevel());
		attributes.put("courseType", getCourseType());
		attributes.put("frameworkApprovalStatus", getFrameworkApprovalStatus());
		attributes.put("graduationCriteriaDesc", getGraduationCriteriaDesc());
		attributes.put("fundingDescPre", getFundingDescPre());
		attributes.put("fundingDescPost", getFundingDescPost());
		attributes.put("feeDetailsDesc", getFeeDetailsDesc());
		attributes.put("testLink", getTestLink());
		attributes.put("courseOutcomeTitle", getCourseOutcomeTitle());
		attributes.put("courseOutcomeDesc", getCourseOutcomeDesc());
		attributes.put("personaDesc", getPersonaDesc());
		attributes.put("certificateTitle", getCertificateTitle());
		attributes.put("awardingBodyId", getAwardingBodyId());
		attributes.put("courseLevel", getCourseLevel());
		attributes.put("miscFeeDesc", getMiscFeeDesc());
		attributes.put("courseDeveloperId", getCourseDeveloperId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long spCourseId = (Long)attributes.get("spCourseId");

		if (spCourseId != null) {
			setSpCourseId(spCourseId);
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

		String countryId = (String)attributes.get("countryId");

		if (countryId != null) {
			setCountryId(countryId);
		}

		String courseCode = (String)attributes.get("courseCode");

		if (courseCode != null) {
			setCourseCode(courseCode);
		}

		String courseName = (String)attributes.get("courseName");

		if (courseName != null) {
			setCourseName(courseName);
		}

		Boolean displayCourseName = (Boolean)attributes.get("displayCourseName");

		if (displayCourseName != null) {
			setDisplayCourseName(displayCourseName);
		}

		String courseDesc = (String)attributes.get("courseDesc");

		if (courseDesc != null) {
			setCourseDesc(courseDesc);
		}

		String courseDurationFullTime = (String)attributes.get(
				"courseDurationFullTime");

		if (courseDurationFullTime != null) {
			setCourseDurationFullTime(courseDurationFullTime);
		}

		String learningDurationFullTime = (String)attributes.get(
				"learningDurationFullTime");

		if (learningDurationFullTime != null) {
			setLearningDurationFullTime(learningDurationFullTime);
		}

		String courseDurationPartTime = (String)attributes.get(
				"courseDurationPartTime");

		if (courseDurationPartTime != null) {
			setCourseDurationPartTime(courseDurationPartTime);
		}

		String learningDurationPartTime = (String)attributes.get(
				"learningDurationPartTime");

		if (learningDurationPartTime != null) {
			setLearningDurationPartTime(learningDurationPartTime);
		}

		String complexityLevel = (String)attributes.get("complexityLevel");

		if (complexityLevel != null) {
			setComplexityLevel(complexityLevel);
		}

		Long courseType = (Long)attributes.get("courseType");

		if (courseType != null) {
			setCourseType(courseType);
		}

		Boolean frameworkApprovalStatus = (Boolean)attributes.get(
				"frameworkApprovalStatus");

		if (frameworkApprovalStatus != null) {
			setFrameworkApprovalStatus(frameworkApprovalStatus);
		}

		String graduationCriteriaDesc = (String)attributes.get(
				"graduationCriteriaDesc");

		if (graduationCriteriaDesc != null) {
			setGraduationCriteriaDesc(graduationCriteriaDesc);
		}

		String fundingDescPre = (String)attributes.get("fundingDescPre");

		if (fundingDescPre != null) {
			setFundingDescPre(fundingDescPre);
		}

		String fundingDescPost = (String)attributes.get("fundingDescPost");

		if (fundingDescPost != null) {
			setFundingDescPost(fundingDescPost);
		}

		String feeDetailsDesc = (String)attributes.get("feeDetailsDesc");

		if (feeDetailsDesc != null) {
			setFeeDetailsDesc(feeDetailsDesc);
		}

		String testLink = (String)attributes.get("testLink");

		if (testLink != null) {
			setTestLink(testLink);
		}

		String courseOutcomeTitle = (String)attributes.get("courseOutcomeTitle");

		if (courseOutcomeTitle != null) {
			setCourseOutcomeTitle(courseOutcomeTitle);
		}

		String courseOutcomeDesc = (String)attributes.get("courseOutcomeDesc");

		if (courseOutcomeDesc != null) {
			setCourseOutcomeDesc(courseOutcomeDesc);
		}

		String personaDesc = (String)attributes.get("personaDesc");

		if (personaDesc != null) {
			setPersonaDesc(personaDesc);
		}

		String certificateTitle = (String)attributes.get("certificateTitle");

		if (certificateTitle != null) {
			setCertificateTitle(certificateTitle);
		}

		Long awardingBodyId = (Long)attributes.get("awardingBodyId");

		if (awardingBodyId != null) {
			setAwardingBodyId(awardingBodyId);
		}

		Long courseLevel = (Long)attributes.get("courseLevel");

		if (courseLevel != null) {
			setCourseLevel(courseLevel);
		}

		String miscFeeDesc = (String)attributes.get("miscFeeDesc");

		if (miscFeeDesc != null) {
			setMiscFeeDesc(miscFeeDesc);
		}

		Long courseDeveloperId = (Long)attributes.get("courseDeveloperId");

		if (courseDeveloperId != null) {
			setCourseDeveloperId(courseDeveloperId);
		}
	}

	/**
	* Returns the primary key of this course.
	*
	* @return the primary key of this course
	*/
	@Override
	public long getPrimaryKey() {
		return _course.getPrimaryKey();
	}

	/**
	* Sets the primary key of this course.
	*
	* @param primaryKey the primary key of this course
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_course.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the sp course ID of this course.
	*
	* @return the sp course ID of this course
	*/
	@Override
	public long getSpCourseId() {
		return _course.getSpCourseId();
	}

	/**
	* Sets the sp course ID of this course.
	*
	* @param spCourseId the sp course ID of this course
	*/
	@Override
	public void setSpCourseId(long spCourseId) {
		_course.setSpCourseId(spCourseId);
	}

	/**
	* Returns the group ID of this course.
	*
	* @return the group ID of this course
	*/
	@Override
	public long getGroupId() {
		return _course.getGroupId();
	}

	/**
	* Sets the group ID of this course.
	*
	* @param groupId the group ID of this course
	*/
	@Override
	public void setGroupId(long groupId) {
		_course.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this course.
	*
	* @return the company ID of this course
	*/
	@Override
	public long getCompanyId() {
		return _course.getCompanyId();
	}

	/**
	* Sets the company ID of this course.
	*
	* @param companyId the company ID of this course
	*/
	@Override
	public void setCompanyId(long companyId) {
		_course.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this course.
	*
	* @return the user ID of this course
	*/
	@Override
	public long getUserId() {
		return _course.getUserId();
	}

	/**
	* Sets the user ID of this course.
	*
	* @param userId the user ID of this course
	*/
	@Override
	public void setUserId(long userId) {
		_course.setUserId(userId);
	}

	/**
	* Returns the user uuid of this course.
	*
	* @return the user uuid of this course
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _course.getUserUuid();
	}

	/**
	* Sets the user uuid of this course.
	*
	* @param userUuid the user uuid of this course
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_course.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this course.
	*
	* @return the user name of this course
	*/
	@Override
	public java.lang.String getUserName() {
		return _course.getUserName();
	}

	/**
	* Sets the user name of this course.
	*
	* @param userName the user name of this course
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_course.setUserName(userName);
	}

	/**
	* Returns the create date of this course.
	*
	* @return the create date of this course
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _course.getCreateDate();
	}

	/**
	* Sets the create date of this course.
	*
	* @param createDate the create date of this course
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_course.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this course.
	*
	* @return the modified date of this course
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _course.getModifiedDate();
	}

	/**
	* Sets the modified date of this course.
	*
	* @param modifiedDate the modified date of this course
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_course.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the country ID of this course.
	*
	* @return the country ID of this course
	*/
	@Override
	public java.lang.String getCountryId() {
		return _course.getCountryId();
	}

	/**
	* Sets the country ID of this course.
	*
	* @param countryId the country ID of this course
	*/
	@Override
	public void setCountryId(java.lang.String countryId) {
		_course.setCountryId(countryId);
	}

	/**
	* Returns the course code of this course.
	*
	* @return the course code of this course
	*/
	@Override
	public java.lang.String getCourseCode() {
		return _course.getCourseCode();
	}

	/**
	* Sets the course code of this course.
	*
	* @param courseCode the course code of this course
	*/
	@Override
	public void setCourseCode(java.lang.String courseCode) {
		_course.setCourseCode(courseCode);
	}

	/**
	* Returns the course name of this course.
	*
	* @return the course name of this course
	*/
	@Override
	public java.lang.String getCourseName() {
		return _course.getCourseName();
	}

	/**
	* Sets the course name of this course.
	*
	* @param courseName the course name of this course
	*/
	@Override
	public void setCourseName(java.lang.String courseName) {
		_course.setCourseName(courseName);
	}

	/**
	* Returns the display course name of this course.
	*
	* @return the display course name of this course
	*/
	@Override
	public boolean getDisplayCourseName() {
		return _course.getDisplayCourseName();
	}

	/**
	* Returns <code>true</code> if this course is display course name.
	*
	* @return <code>true</code> if this course is display course name; <code>false</code> otherwise
	*/
	@Override
	public boolean isDisplayCourseName() {
		return _course.isDisplayCourseName();
	}

	/**
	* Sets whether this course is display course name.
	*
	* @param displayCourseName the display course name of this course
	*/
	@Override
	public void setDisplayCourseName(boolean displayCourseName) {
		_course.setDisplayCourseName(displayCourseName);
	}

	/**
	* Returns the course desc of this course.
	*
	* @return the course desc of this course
	*/
	@Override
	public java.lang.String getCourseDesc() {
		return _course.getCourseDesc();
	}

	/**
	* Sets the course desc of this course.
	*
	* @param courseDesc the course desc of this course
	*/
	@Override
	public void setCourseDesc(java.lang.String courseDesc) {
		_course.setCourseDesc(courseDesc);
	}

	/**
	* Returns the course duration full time of this course.
	*
	* @return the course duration full time of this course
	*/
	@Override
	public java.lang.String getCourseDurationFullTime() {
		return _course.getCourseDurationFullTime();
	}

	/**
	* Sets the course duration full time of this course.
	*
	* @param courseDurationFullTime the course duration full time of this course
	*/
	@Override
	public void setCourseDurationFullTime(
		java.lang.String courseDurationFullTime) {
		_course.setCourseDurationFullTime(courseDurationFullTime);
	}

	/**
	* Returns the learning duration full time of this course.
	*
	* @return the learning duration full time of this course
	*/
	@Override
	public java.lang.String getLearningDurationFullTime() {
		return _course.getLearningDurationFullTime();
	}

	/**
	* Sets the learning duration full time of this course.
	*
	* @param learningDurationFullTime the learning duration full time of this course
	*/
	@Override
	public void setLearningDurationFullTime(
		java.lang.String learningDurationFullTime) {
		_course.setLearningDurationFullTime(learningDurationFullTime);
	}

	/**
	* Returns the course duration part time of this course.
	*
	* @return the course duration part time of this course
	*/
	@Override
	public java.lang.String getCourseDurationPartTime() {
		return _course.getCourseDurationPartTime();
	}

	/**
	* Sets the course duration part time of this course.
	*
	* @param courseDurationPartTime the course duration part time of this course
	*/
	@Override
	public void setCourseDurationPartTime(
		java.lang.String courseDurationPartTime) {
		_course.setCourseDurationPartTime(courseDurationPartTime);
	}

	/**
	* Returns the learning duration part time of this course.
	*
	* @return the learning duration part time of this course
	*/
	@Override
	public java.lang.String getLearningDurationPartTime() {
		return _course.getLearningDurationPartTime();
	}

	/**
	* Sets the learning duration part time of this course.
	*
	* @param learningDurationPartTime the learning duration part time of this course
	*/
	@Override
	public void setLearningDurationPartTime(
		java.lang.String learningDurationPartTime) {
		_course.setLearningDurationPartTime(learningDurationPartTime);
	}

	/**
	* Returns the complexity level of this course.
	*
	* @return the complexity level of this course
	*/
	@Override
	public java.lang.String getComplexityLevel() {
		return _course.getComplexityLevel();
	}

	/**
	* Sets the complexity level of this course.
	*
	* @param complexityLevel the complexity level of this course
	*/
	@Override
	public void setComplexityLevel(java.lang.String complexityLevel) {
		_course.setComplexityLevel(complexityLevel);
	}

	/**
	* Returns the course type of this course.
	*
	* @return the course type of this course
	*/
	@Override
	public long getCourseType() {
		return _course.getCourseType();
	}

	/**
	* Sets the course type of this course.
	*
	* @param courseType the course type of this course
	*/
	@Override
	public void setCourseType(long courseType) {
		_course.setCourseType(courseType);
	}

	/**
	* Returns the framework approval status of this course.
	*
	* @return the framework approval status of this course
	*/
	@Override
	public boolean getFrameworkApprovalStatus() {
		return _course.getFrameworkApprovalStatus();
	}

	/**
	* Returns <code>true</code> if this course is framework approval status.
	*
	* @return <code>true</code> if this course is framework approval status; <code>false</code> otherwise
	*/
	@Override
	public boolean isFrameworkApprovalStatus() {
		return _course.isFrameworkApprovalStatus();
	}

	/**
	* Sets whether this course is framework approval status.
	*
	* @param frameworkApprovalStatus the framework approval status of this course
	*/
	@Override
	public void setFrameworkApprovalStatus(boolean frameworkApprovalStatus) {
		_course.setFrameworkApprovalStatus(frameworkApprovalStatus);
	}

	/**
	* Returns the graduation criteria desc of this course.
	*
	* @return the graduation criteria desc of this course
	*/
	@Override
	public java.lang.String getGraduationCriteriaDesc() {
		return _course.getGraduationCriteriaDesc();
	}

	/**
	* Sets the graduation criteria desc of this course.
	*
	* @param graduationCriteriaDesc the graduation criteria desc of this course
	*/
	@Override
	public void setGraduationCriteriaDesc(
		java.lang.String graduationCriteriaDesc) {
		_course.setGraduationCriteriaDesc(graduationCriteriaDesc);
	}

	/**
	* Returns the funding desc pre of this course.
	*
	* @return the funding desc pre of this course
	*/
	@Override
	public java.lang.String getFundingDescPre() {
		return _course.getFundingDescPre();
	}

	/**
	* Sets the funding desc pre of this course.
	*
	* @param fundingDescPre the funding desc pre of this course
	*/
	@Override
	public void setFundingDescPre(java.lang.String fundingDescPre) {
		_course.setFundingDescPre(fundingDescPre);
	}

	/**
	* Returns the funding desc post of this course.
	*
	* @return the funding desc post of this course
	*/
	@Override
	public java.lang.String getFundingDescPost() {
		return _course.getFundingDescPost();
	}

	/**
	* Sets the funding desc post of this course.
	*
	* @param fundingDescPost the funding desc post of this course
	*/
	@Override
	public void setFundingDescPost(java.lang.String fundingDescPost) {
		_course.setFundingDescPost(fundingDescPost);
	}

	/**
	* Returns the fee details desc of this course.
	*
	* @return the fee details desc of this course
	*/
	@Override
	public java.lang.String getFeeDetailsDesc() {
		return _course.getFeeDetailsDesc();
	}

	/**
	* Sets the fee details desc of this course.
	*
	* @param feeDetailsDesc the fee details desc of this course
	*/
	@Override
	public void setFeeDetailsDesc(java.lang.String feeDetailsDesc) {
		_course.setFeeDetailsDesc(feeDetailsDesc);
	}

	/**
	* Returns the test link of this course.
	*
	* @return the test link of this course
	*/
	@Override
	public java.lang.String getTestLink() {
		return _course.getTestLink();
	}

	/**
	* Sets the test link of this course.
	*
	* @param testLink the test link of this course
	*/
	@Override
	public void setTestLink(java.lang.String testLink) {
		_course.setTestLink(testLink);
	}

	/**
	* Returns the course outcome title of this course.
	*
	* @return the course outcome title of this course
	*/
	@Override
	public java.lang.String getCourseOutcomeTitle() {
		return _course.getCourseOutcomeTitle();
	}

	/**
	* Sets the course outcome title of this course.
	*
	* @param courseOutcomeTitle the course outcome title of this course
	*/
	@Override
	public void setCourseOutcomeTitle(java.lang.String courseOutcomeTitle) {
		_course.setCourseOutcomeTitle(courseOutcomeTitle);
	}

	/**
	* Returns the course outcome desc of this course.
	*
	* @return the course outcome desc of this course
	*/
	@Override
	public java.lang.String getCourseOutcomeDesc() {
		return _course.getCourseOutcomeDesc();
	}

	/**
	* Sets the course outcome desc of this course.
	*
	* @param courseOutcomeDesc the course outcome desc of this course
	*/
	@Override
	public void setCourseOutcomeDesc(java.lang.String courseOutcomeDesc) {
		_course.setCourseOutcomeDesc(courseOutcomeDesc);
	}

	/**
	* Returns the persona desc of this course.
	*
	* @return the persona desc of this course
	*/
	@Override
	public java.lang.String getPersonaDesc() {
		return _course.getPersonaDesc();
	}

	/**
	* Sets the persona desc of this course.
	*
	* @param personaDesc the persona desc of this course
	*/
	@Override
	public void setPersonaDesc(java.lang.String personaDesc) {
		_course.setPersonaDesc(personaDesc);
	}

	/**
	* Returns the certificate title of this course.
	*
	* @return the certificate title of this course
	*/
	@Override
	public java.lang.String getCertificateTitle() {
		return _course.getCertificateTitle();
	}

	/**
	* Sets the certificate title of this course.
	*
	* @param certificateTitle the certificate title of this course
	*/
	@Override
	public void setCertificateTitle(java.lang.String certificateTitle) {
		_course.setCertificateTitle(certificateTitle);
	}

	/**
	* Returns the awarding body ID of this course.
	*
	* @return the awarding body ID of this course
	*/
	@Override
	public long getAwardingBodyId() {
		return _course.getAwardingBodyId();
	}

	/**
	* Sets the awarding body ID of this course.
	*
	* @param awardingBodyId the awarding body ID of this course
	*/
	@Override
	public void setAwardingBodyId(long awardingBodyId) {
		_course.setAwardingBodyId(awardingBodyId);
	}

	/**
	* Returns the course level of this course.
	*
	* @return the course level of this course
	*/
	@Override
	public long getCourseLevel() {
		return _course.getCourseLevel();
	}

	/**
	* Sets the course level of this course.
	*
	* @param courseLevel the course level of this course
	*/
	@Override
	public void setCourseLevel(long courseLevel) {
		_course.setCourseLevel(courseLevel);
	}

	/**
	* Returns the misc fee desc of this course.
	*
	* @return the misc fee desc of this course
	*/
	@Override
	public java.lang.String getMiscFeeDesc() {
		return _course.getMiscFeeDesc();
	}

	/**
	* Sets the misc fee desc of this course.
	*
	* @param miscFeeDesc the misc fee desc of this course
	*/
	@Override
	public void setMiscFeeDesc(java.lang.String miscFeeDesc) {
		_course.setMiscFeeDesc(miscFeeDesc);
	}

	/**
	* Returns the course developer ID of this course.
	*
	* @return the course developer ID of this course
	*/
	@Override
	public long getCourseDeveloperId() {
		return _course.getCourseDeveloperId();
	}

	/**
	* Sets the course developer ID of this course.
	*
	* @param courseDeveloperId the course developer ID of this course
	*/
	@Override
	public void setCourseDeveloperId(long courseDeveloperId) {
		_course.setCourseDeveloperId(courseDeveloperId);
	}

	@Override
	public boolean isNew() {
		return _course.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_course.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _course.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_course.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _course.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _course.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_course.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _course.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_course.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_course.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_course.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new CourseWrapper((Course)_course.clone());
	}

	@Override
	public int compareTo(com.sambaash.platform.srv.model.Course course) {
		return _course.compareTo(course);
	}

	@Override
	public int hashCode() {
		return _course.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.model.Course> toCacheModel() {
		return _course.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.model.Course toEscapedModel() {
		return new CourseWrapper(_course.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.model.Course toUnescapedModel() {
		return new CourseWrapper(_course.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _course.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _course.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_course.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseWrapper)) {
			return false;
		}

		CourseWrapper courseWrapper = (CourseWrapper)obj;

		if (Validator.equals(_course, courseWrapper._course)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Course getWrappedCourse() {
		return _course;
	}

	@Override
	public Course getWrappedModel() {
		return _course;
	}

	@Override
	public void resetOriginalValues() {
		_course.resetOriginalValues();
	}

	private Course _course;
}