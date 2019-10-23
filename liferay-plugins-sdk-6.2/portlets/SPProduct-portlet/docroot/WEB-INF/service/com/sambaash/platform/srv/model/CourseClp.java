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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.service.ClpSerializer;
import com.sambaash.platform.srv.service.CourseLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class CourseClp extends BaseModelImpl<Course> implements Course {
	public CourseClp() {
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
	public long getPrimaryKey() {
		return _spCourseId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setSpCourseId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _spCourseId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public long getSpCourseId() {
		return _spCourseId;
	}

	@Override
	public void setSpCourseId(long spCourseId) {
		_spCourseId = spCourseId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setSpCourseId", long.class);

				method.invoke(_courseRemoteModel, spCourseId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_courseRemoteModel, groupId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_courseRemoteModel, companyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_courseRemoteModel, userId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@Override
	public String getUserName() {
		return _userName;
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_courseRemoteModel, userName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_createDate = createDate;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_courseRemoteModel, createDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_courseRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryId() {
		return _countryId;
	}

	@Override
	public void setCountryId(String countryId) {
		_countryId = countryId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryId", String.class);

				method.invoke(_courseRemoteModel, countryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourseCode() {
		return _courseCode;
	}

	@Override
	public void setCourseCode(String courseCode) {
		_courseCode = courseCode;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseCode", String.class);

				method.invoke(_courseRemoteModel, courseCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourseName() {
		return _courseName;
	}

	@Override
	public void setCourseName(String courseName) {
		_courseName = courseName;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseName", String.class);

				method.invoke(_courseRemoteModel, courseName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getDisplayCourseName() {
		return _displayCourseName;
	}

	@Override
	public boolean isDisplayCourseName() {
		return _displayCourseName;
	}

	@Override
	public void setDisplayCourseName(boolean displayCourseName) {
		_displayCourseName = displayCourseName;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayCourseName",
						boolean.class);

				method.invoke(_courseRemoteModel, displayCourseName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourseDesc() {
		return _courseDesc;
	}

	@Override
	public void setCourseDesc(String courseDesc) {
		_courseDesc = courseDesc;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseDesc", String.class);

				method.invoke(_courseRemoteModel, courseDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourseDurationFullTime() {
		return _courseDurationFullTime;
	}

	@Override
	public void setCourseDurationFullTime(String courseDurationFullTime) {
		_courseDurationFullTime = courseDurationFullTime;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseDurationFullTime",
						String.class);

				method.invoke(_courseRemoteModel, courseDurationFullTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLearningDurationFullTime() {
		return _learningDurationFullTime;
	}

	@Override
	public void setLearningDurationFullTime(String learningDurationFullTime) {
		_learningDurationFullTime = learningDurationFullTime;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setLearningDurationFullTime",
						String.class);

				method.invoke(_courseRemoteModel, learningDurationFullTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourseDurationPartTime() {
		return _courseDurationPartTime;
	}

	@Override
	public void setCourseDurationPartTime(String courseDurationPartTime) {
		_courseDurationPartTime = courseDurationPartTime;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseDurationPartTime",
						String.class);

				method.invoke(_courseRemoteModel, courseDurationPartTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLearningDurationPartTime() {
		return _learningDurationPartTime;
	}

	@Override
	public void setLearningDurationPartTime(String learningDurationPartTime) {
		_learningDurationPartTime = learningDurationPartTime;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setLearningDurationPartTime",
						String.class);

				method.invoke(_courseRemoteModel, learningDurationPartTime);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComplexityLevel() {
		return _complexityLevel;
	}

	@Override
	public void setComplexityLevel(String complexityLevel) {
		_complexityLevel = complexityLevel;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setComplexityLevel",
						String.class);

				method.invoke(_courseRemoteModel, complexityLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCourseType() {
		return _courseType;
	}

	@Override
	public void setCourseType(long courseType) {
		_courseType = courseType;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseType", long.class);

				method.invoke(_courseRemoteModel, courseType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getFrameworkApprovalStatus() {
		return _frameworkApprovalStatus;
	}

	@Override
	public boolean isFrameworkApprovalStatus() {
		return _frameworkApprovalStatus;
	}

	@Override
	public void setFrameworkApprovalStatus(boolean frameworkApprovalStatus) {
		_frameworkApprovalStatus = frameworkApprovalStatus;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setFrameworkApprovalStatus",
						boolean.class);

				method.invoke(_courseRemoteModel, frameworkApprovalStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGraduationCriteriaDesc() {
		return _graduationCriteriaDesc;
	}

	@Override
	public void setGraduationCriteriaDesc(String graduationCriteriaDesc) {
		_graduationCriteriaDesc = graduationCriteriaDesc;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setGraduationCriteriaDesc",
						String.class);

				method.invoke(_courseRemoteModel, graduationCriteriaDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFundingDescPre() {
		return _fundingDescPre;
	}

	@Override
	public void setFundingDescPre(String fundingDescPre) {
		_fundingDescPre = fundingDescPre;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingDescPre",
						String.class);

				method.invoke(_courseRemoteModel, fundingDescPre);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFundingDescPost() {
		return _fundingDescPost;
	}

	@Override
	public void setFundingDescPost(String fundingDescPost) {
		_fundingDescPost = fundingDescPost;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setFundingDescPost",
						String.class);

				method.invoke(_courseRemoteModel, fundingDescPost);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFeeDetailsDesc() {
		return _feeDetailsDesc;
	}

	@Override
	public void setFeeDetailsDesc(String feeDetailsDesc) {
		_feeDetailsDesc = feeDetailsDesc;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setFeeDetailsDesc",
						String.class);

				method.invoke(_courseRemoteModel, feeDetailsDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTestLink() {
		return _testLink;
	}

	@Override
	public void setTestLink(String testLink) {
		_testLink = testLink;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setTestLink", String.class);

				method.invoke(_courseRemoteModel, testLink);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourseOutcomeTitle() {
		return _courseOutcomeTitle;
	}

	@Override
	public void setCourseOutcomeTitle(String courseOutcomeTitle) {
		_courseOutcomeTitle = courseOutcomeTitle;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseOutcomeTitle",
						String.class);

				method.invoke(_courseRemoteModel, courseOutcomeTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCourseOutcomeDesc() {
		return _courseOutcomeDesc;
	}

	@Override
	public void setCourseOutcomeDesc(String courseOutcomeDesc) {
		_courseOutcomeDesc = courseOutcomeDesc;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseOutcomeDesc",
						String.class);

				method.invoke(_courseRemoteModel, courseOutcomeDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPersonaDesc() {
		return _personaDesc;
	}

	@Override
	public void setPersonaDesc(String personaDesc) {
		_personaDesc = personaDesc;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setPersonaDesc", String.class);

				method.invoke(_courseRemoteModel, personaDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCertificateTitle() {
		return _certificateTitle;
	}

	@Override
	public void setCertificateTitle(String certificateTitle) {
		_certificateTitle = certificateTitle;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCertificateTitle",
						String.class);

				method.invoke(_courseRemoteModel, certificateTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAwardingBodyId() {
		return _awardingBodyId;
	}

	@Override
	public void setAwardingBodyId(long awardingBodyId) {
		_awardingBodyId = awardingBodyId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setAwardingBodyId", long.class);

				method.invoke(_courseRemoteModel, awardingBodyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCourseLevel() {
		return _courseLevel;
	}

	@Override
	public void setCourseLevel(long courseLevel) {
		_courseLevel = courseLevel;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseLevel", long.class);

				method.invoke(_courseRemoteModel, courseLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMiscFeeDesc() {
		return _miscFeeDesc;
	}

	@Override
	public void setMiscFeeDesc(String miscFeeDesc) {
		_miscFeeDesc = miscFeeDesc;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setMiscFeeDesc", String.class);

				method.invoke(_courseRemoteModel, miscFeeDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getCourseDeveloperId() {
		return _courseDeveloperId;
	}

	@Override
	public void setCourseDeveloperId(long courseDeveloperId) {
		_courseDeveloperId = courseDeveloperId;

		if (_courseRemoteModel != null) {
			try {
				Class<?> clazz = _courseRemoteModel.getClass();

				Method method = clazz.getMethod("setCourseDeveloperId",
						long.class);

				method.invoke(_courseRemoteModel, courseDeveloperId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getCourseRemoteModel() {
		return _courseRemoteModel;
	}

	public void setCourseRemoteModel(BaseModel<?> courseRemoteModel) {
		_courseRemoteModel = courseRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _courseRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_courseRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			CourseLocalServiceUtil.addCourse(this);
		}
		else {
			CourseLocalServiceUtil.updateCourse(this);
		}
	}

	@Override
	public Course toEscapedModel() {
		return (Course)ProxyUtil.newProxyInstance(Course.class.getClassLoader(),
			new Class[] { Course.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		CourseClp clone = new CourseClp();

		clone.setSpCourseId(getSpCourseId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setCountryId(getCountryId());
		clone.setCourseCode(getCourseCode());
		clone.setCourseName(getCourseName());
		clone.setDisplayCourseName(getDisplayCourseName());
		clone.setCourseDesc(getCourseDesc());
		clone.setCourseDurationFullTime(getCourseDurationFullTime());
		clone.setLearningDurationFullTime(getLearningDurationFullTime());
		clone.setCourseDurationPartTime(getCourseDurationPartTime());
		clone.setLearningDurationPartTime(getLearningDurationPartTime());
		clone.setComplexityLevel(getComplexityLevel());
		clone.setCourseType(getCourseType());
		clone.setFrameworkApprovalStatus(getFrameworkApprovalStatus());
		clone.setGraduationCriteriaDesc(getGraduationCriteriaDesc());
		clone.setFundingDescPre(getFundingDescPre());
		clone.setFundingDescPost(getFundingDescPost());
		clone.setFeeDetailsDesc(getFeeDetailsDesc());
		clone.setTestLink(getTestLink());
		clone.setCourseOutcomeTitle(getCourseOutcomeTitle());
		clone.setCourseOutcomeDesc(getCourseOutcomeDesc());
		clone.setPersonaDesc(getPersonaDesc());
		clone.setCertificateTitle(getCertificateTitle());
		clone.setAwardingBodyId(getAwardingBodyId());
		clone.setCourseLevel(getCourseLevel());
		clone.setMiscFeeDesc(getMiscFeeDesc());
		clone.setCourseDeveloperId(getCourseDeveloperId());

		return clone;
	}

	@Override
	public int compareTo(Course course) {
		int value = 0;

		value = getCourseName().compareTo(course.getCourseName());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof CourseClp)) {
			return false;
		}

		CourseClp course = (CourseClp)obj;

		long primaryKey = course.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	public Class<?> getClpSerializerClass() {
		return _clpSerializerClass;
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(65);

		sb.append("{spCourseId=");
		sb.append(getSpCourseId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", countryId=");
		sb.append(getCountryId());
		sb.append(", courseCode=");
		sb.append(getCourseCode());
		sb.append(", courseName=");
		sb.append(getCourseName());
		sb.append(", displayCourseName=");
		sb.append(getDisplayCourseName());
		sb.append(", courseDesc=");
		sb.append(getCourseDesc());
		sb.append(", courseDurationFullTime=");
		sb.append(getCourseDurationFullTime());
		sb.append(", learningDurationFullTime=");
		sb.append(getLearningDurationFullTime());
		sb.append(", courseDurationPartTime=");
		sb.append(getCourseDurationPartTime());
		sb.append(", learningDurationPartTime=");
		sb.append(getLearningDurationPartTime());
		sb.append(", complexityLevel=");
		sb.append(getComplexityLevel());
		sb.append(", courseType=");
		sb.append(getCourseType());
		sb.append(", frameworkApprovalStatus=");
		sb.append(getFrameworkApprovalStatus());
		sb.append(", graduationCriteriaDesc=");
		sb.append(getGraduationCriteriaDesc());
		sb.append(", fundingDescPre=");
		sb.append(getFundingDescPre());
		sb.append(", fundingDescPost=");
		sb.append(getFundingDescPost());
		sb.append(", feeDetailsDesc=");
		sb.append(getFeeDetailsDesc());
		sb.append(", testLink=");
		sb.append(getTestLink());
		sb.append(", courseOutcomeTitle=");
		sb.append(getCourseOutcomeTitle());
		sb.append(", courseOutcomeDesc=");
		sb.append(getCourseOutcomeDesc());
		sb.append(", personaDesc=");
		sb.append(getPersonaDesc());
		sb.append(", certificateTitle=");
		sb.append(getCertificateTitle());
		sb.append(", awardingBodyId=");
		sb.append(getAwardingBodyId());
		sb.append(", courseLevel=");
		sb.append(getCourseLevel());
		sb.append(", miscFeeDesc=");
		sb.append(getMiscFeeDesc());
		sb.append(", courseDeveloperId=");
		sb.append(getCourseDeveloperId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(100);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.model.Course");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>spCourseId</column-name><column-value><![CDATA[");
		sb.append(getSpCourseId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryId</column-name><column-value><![CDATA[");
		sb.append(getCountryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseCode</column-name><column-value><![CDATA[");
		sb.append(getCourseCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseName</column-name><column-value><![CDATA[");
		sb.append(getCourseName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayCourseName</column-name><column-value><![CDATA[");
		sb.append(getDisplayCourseName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseDesc</column-name><column-value><![CDATA[");
		sb.append(getCourseDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseDurationFullTime</column-name><column-value><![CDATA[");
		sb.append(getCourseDurationFullTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>learningDurationFullTime</column-name><column-value><![CDATA[");
		sb.append(getLearningDurationFullTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseDurationPartTime</column-name><column-value><![CDATA[");
		sb.append(getCourseDurationPartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>learningDurationPartTime</column-name><column-value><![CDATA[");
		sb.append(getLearningDurationPartTime());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complexityLevel</column-name><column-value><![CDATA[");
		sb.append(getComplexityLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseType</column-name><column-value><![CDATA[");
		sb.append(getCourseType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>frameworkApprovalStatus</column-name><column-value><![CDATA[");
		sb.append(getFrameworkApprovalStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>graduationCriteriaDesc</column-name><column-value><![CDATA[");
		sb.append(getGraduationCriteriaDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingDescPre</column-name><column-value><![CDATA[");
		sb.append(getFundingDescPre());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>fundingDescPost</column-name><column-value><![CDATA[");
		sb.append(getFundingDescPost());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feeDetailsDesc</column-name><column-value><![CDATA[");
		sb.append(getFeeDetailsDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>testLink</column-name><column-value><![CDATA[");
		sb.append(getTestLink());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseOutcomeTitle</column-name><column-value><![CDATA[");
		sb.append(getCourseOutcomeTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseOutcomeDesc</column-name><column-value><![CDATA[");
		sb.append(getCourseOutcomeDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>personaDesc</column-name><column-value><![CDATA[");
		sb.append(getPersonaDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>certificateTitle</column-name><column-value><![CDATA[");
		sb.append(getCertificateTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>awardingBodyId</column-name><column-value><![CDATA[");
		sb.append(getAwardingBodyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseLevel</column-name><column-value><![CDATA[");
		sb.append(getCourseLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>miscFeeDesc</column-name><column-value><![CDATA[");
		sb.append(getMiscFeeDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>courseDeveloperId</column-name><column-value><![CDATA[");
		sb.append(getCourseDeveloperId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _spCourseId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
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
	private BaseModel<?> _courseRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.service.ClpSerializer.class;
}