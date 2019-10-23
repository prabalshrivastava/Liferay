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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author gauravvijayvergia
 * @generated
 */
public class CourseSoap implements Serializable {
	public static CourseSoap toSoapModel(Course model) {
		CourseSoap soapModel = new CourseSoap();

		soapModel.setSpCourseId(model.getSpCourseId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setCountryId(model.getCountryId());
		soapModel.setCourseCode(model.getCourseCode());
		soapModel.setCourseName(model.getCourseName());
		soapModel.setDisplayCourseName(model.getDisplayCourseName());
		soapModel.setCourseDesc(model.getCourseDesc());
		soapModel.setCourseDurationFullTime(model.getCourseDurationFullTime());
		soapModel.setLearningDurationFullTime(model.getLearningDurationFullTime());
		soapModel.setCourseDurationPartTime(model.getCourseDurationPartTime());
		soapModel.setLearningDurationPartTime(model.getLearningDurationPartTime());
		soapModel.setComplexityLevel(model.getComplexityLevel());
		soapModel.setCourseType(model.getCourseType());
		soapModel.setFrameworkApprovalStatus(model.getFrameworkApprovalStatus());
		soapModel.setGraduationCriteriaDesc(model.getGraduationCriteriaDesc());
		soapModel.setFundingDescPre(model.getFundingDescPre());
		soapModel.setFundingDescPost(model.getFundingDescPost());
		soapModel.setFeeDetailsDesc(model.getFeeDetailsDesc());
		soapModel.setTestLink(model.getTestLink());
		soapModel.setCourseOutcomeTitle(model.getCourseOutcomeTitle());
		soapModel.setCourseOutcomeDesc(model.getCourseOutcomeDesc());
		soapModel.setPersonaDesc(model.getPersonaDesc());
		soapModel.setCertificateTitle(model.getCertificateTitle());
		soapModel.setAwardingBodyId(model.getAwardingBodyId());
		soapModel.setCourseLevel(model.getCourseLevel());
		soapModel.setMiscFeeDesc(model.getMiscFeeDesc());
		soapModel.setCourseDeveloperId(model.getCourseDeveloperId());

		return soapModel;
	}

	public static CourseSoap[] toSoapModels(Course[] models) {
		CourseSoap[] soapModels = new CourseSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static CourseSoap[][] toSoapModels(Course[][] models) {
		CourseSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new CourseSoap[models.length][models[0].length];
		}
		else {
			soapModels = new CourseSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static CourseSoap[] toSoapModels(List<Course> models) {
		List<CourseSoap> soapModels = new ArrayList<CourseSoap>(models.size());

		for (Course model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new CourseSoap[soapModels.size()]);
	}

	public CourseSoap() {
	}

	public long getPrimaryKey() {
		return _spCourseId;
	}

	public void setPrimaryKey(long pk) {
		setSpCourseId(pk);
	}

	public long getSpCourseId() {
		return _spCourseId;
	}

	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public String getCountryId() {
		return _countryId;
	}

	public void setCountryId(String countryId) {
		_countryId = countryId;
	}

	public String getCourseCode() {
		return _courseCode;
	}

	public void setCourseCode(String courseCode) {
		_courseCode = courseCode;
	}

	public String getCourseName() {
		return _courseName;
	}

	public void setCourseName(String courseName) {
		_courseName = courseName;
	}

	public boolean getDisplayCourseName() {
		return _displayCourseName;
	}

	public boolean isDisplayCourseName() {
		return _displayCourseName;
	}

	public void setDisplayCourseName(boolean displayCourseName) {
		_displayCourseName = displayCourseName;
	}

	public String getCourseDesc() {
		return _courseDesc;
	}

	public void setCourseDesc(String courseDesc) {
		_courseDesc = courseDesc;
	}

	public String getCourseDurationFullTime() {
		return _courseDurationFullTime;
	}

	public void setCourseDurationFullTime(String courseDurationFullTime) {
		_courseDurationFullTime = courseDurationFullTime;
	}

	public String getLearningDurationFullTime() {
		return _learningDurationFullTime;
	}

	public void setLearningDurationFullTime(String learningDurationFullTime) {
		_learningDurationFullTime = learningDurationFullTime;
	}

	public String getCourseDurationPartTime() {
		return _courseDurationPartTime;
	}

	public void setCourseDurationPartTime(String courseDurationPartTime) {
		_courseDurationPartTime = courseDurationPartTime;
	}

	public String getLearningDurationPartTime() {
		return _learningDurationPartTime;
	}

	public void setLearningDurationPartTime(String learningDurationPartTime) {
		_learningDurationPartTime = learningDurationPartTime;
	}

	public String getComplexityLevel() {
		return _complexityLevel;
	}

	public void setComplexityLevel(String complexityLevel) {
		_complexityLevel = complexityLevel;
	}

	public long getCourseType() {
		return _courseType;
	}

	public void setCourseType(long courseType) {
		_courseType = courseType;
	}

	public boolean getFrameworkApprovalStatus() {
		return _frameworkApprovalStatus;
	}

	public boolean isFrameworkApprovalStatus() {
		return _frameworkApprovalStatus;
	}

	public void setFrameworkApprovalStatus(boolean frameworkApprovalStatus) {
		_frameworkApprovalStatus = frameworkApprovalStatus;
	}

	public String getGraduationCriteriaDesc() {
		return _graduationCriteriaDesc;
	}

	public void setGraduationCriteriaDesc(String graduationCriteriaDesc) {
		_graduationCriteriaDesc = graduationCriteriaDesc;
	}

	public String getFundingDescPre() {
		return _fundingDescPre;
	}

	public void setFundingDescPre(String fundingDescPre) {
		_fundingDescPre = fundingDescPre;
	}

	public String getFundingDescPost() {
		return _fundingDescPost;
	}

	public void setFundingDescPost(String fundingDescPost) {
		_fundingDescPost = fundingDescPost;
	}

	public String getFeeDetailsDesc() {
		return _feeDetailsDesc;
	}

	public void setFeeDetailsDesc(String feeDetailsDesc) {
		_feeDetailsDesc = feeDetailsDesc;
	}

	public String getTestLink() {
		return _testLink;
	}

	public void setTestLink(String testLink) {
		_testLink = testLink;
	}

	public String getCourseOutcomeTitle() {
		return _courseOutcomeTitle;
	}

	public void setCourseOutcomeTitle(String courseOutcomeTitle) {
		_courseOutcomeTitle = courseOutcomeTitle;
	}

	public String getCourseOutcomeDesc() {
		return _courseOutcomeDesc;
	}

	public void setCourseOutcomeDesc(String courseOutcomeDesc) {
		_courseOutcomeDesc = courseOutcomeDesc;
	}

	public String getPersonaDesc() {
		return _personaDesc;
	}

	public void setPersonaDesc(String personaDesc) {
		_personaDesc = personaDesc;
	}

	public String getCertificateTitle() {
		return _certificateTitle;
	}

	public void setCertificateTitle(String certificateTitle) {
		_certificateTitle = certificateTitle;
	}

	public long getAwardingBodyId() {
		return _awardingBodyId;
	}

	public void setAwardingBodyId(long awardingBodyId) {
		_awardingBodyId = awardingBodyId;
	}

	public long getCourseLevel() {
		return _courseLevel;
	}

	public void setCourseLevel(long courseLevel) {
		_courseLevel = courseLevel;
	}

	public String getMiscFeeDesc() {
		return _miscFeeDesc;
	}

	public void setMiscFeeDesc(String miscFeeDesc) {
		_miscFeeDesc = miscFeeDesc;
	}

	public long getCourseDeveloperId() {
		return _courseDeveloperId;
	}

	public void setCourseDeveloperId(long courseDeveloperId) {
		_courseDeveloperId = courseDeveloperId;
	}

	private long _spCourseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _countryId;
	private String _courseCode;
	private String _courseName;
	private boolean _displayCourseName;
	private String _courseDesc;
	private String _courseDurationFullTime;
	private String _learningDurationFullTime;
	private String _courseDurationPartTime;
	private String _learningDurationPartTime;
	private String _complexityLevel;
	private long _courseType;
	private boolean _frameworkApprovalStatus;
	private String _graduationCriteriaDesc;
	private String _fundingDescPre;
	private String _fundingDescPost;
	private String _feeDetailsDesc;
	private String _testLink;
	private String _courseOutcomeTitle;
	private String _courseOutcomeDesc;
	private String _personaDesc;
	private String _certificateTitle;
	private long _awardingBodyId;
	private long _courseLevel;
	private String _miscFeeDesc;
	private long _courseDeveloperId;
}