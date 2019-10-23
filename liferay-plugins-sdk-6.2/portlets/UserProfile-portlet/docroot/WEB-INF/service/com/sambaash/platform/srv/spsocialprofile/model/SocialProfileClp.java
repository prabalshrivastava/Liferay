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

package com.sambaash.platform.srv.spsocialprofile.model;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer;
import com.sambaash.platform.srv.spsocialprofile.service.SocialProfileLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author gauravvijayvergia
 */
public class SocialProfileClp extends BaseModelImpl<SocialProfile>
	implements SocialProfile {
	public SocialProfileClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return SocialProfile.class;
	}

	@Override
	public String getModelClassName() {
		return SocialProfile.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _userId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setUserId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _userId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("userId", getUserId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("userType", getUserType());
		attributes.put("memberPackage", getMemberPackage());
		attributes.put("userRegistrationStatus", getUserRegistrationStatus());
		attributes.put("classPK", getClassPK());
		attributes.put("location", getLocation());
		attributes.put("profileViewCount", getProfileViewCount());
		attributes.put("interest", getInterest());
		attributes.put("honors", getHonors());
		attributes.put("groupAssociation", getGroupAssociation());
		attributes.put("skillsQualification", getSkillsQualification());
		attributes.put("title", getTitle());
		attributes.put("trainingEducation", getTrainingEducation());
		attributes.put("about", getAbout());
		attributes.put("documentId", getDocumentId());
		attributes.put("userInfo", getUserInfo());
		attributes.put("status", getStatus());
		attributes.put("twitterId", getTwitterId());
		attributes.put("linkedinId", getLinkedinId());
		attributes.put("yahooId", getYahooId());
		attributes.put("googleId", getGoogleId());
		attributes.put("facebookAuthToken", getFacebookAuthToken());
		attributes.put("openIdAuthToken", getOpenIdAuthToken());
		attributes.put("twitterAuthToken", getTwitterAuthToken());
		attributes.put("linkedinAuthToken", getLinkedinAuthToken());
		attributes.put("yahooAuthToken", getYahooAuthToken());
		attributes.put("googleAuthToken", getGoogleAuthToken());
		attributes.put("facebookAuthSecret", getFacebookAuthSecret());
		attributes.put("openIdAuthSecret", getOpenIdAuthSecret());
		attributes.put("twitterAuthSecret", getTwitterAuthSecret());
		attributes.put("linkedinAuthSecret", getLinkedinAuthSecret());
		attributes.put("yahooAuthSecret", getYahooAuthSecret());
		attributes.put("googleAuthSecret", getGoogleAuthSecret());
		attributes.put("loginCount", getLoginCount());
		attributes.put("updateInterestsStatus", getUpdateInterestsStatus());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String userType = (String)attributes.get("userType");

		if (userType != null) {
			setUserType(userType);
		}

		Long memberPackage = (Long)attributes.get("memberPackage");

		if (memberPackage != null) {
			setMemberPackage(memberPackage);
		}

		String userRegistrationStatus = (String)attributes.get(
				"userRegistrationStatus");

		if (userRegistrationStatus != null) {
			setUserRegistrationStatus(userRegistrationStatus);
		}

		Long classPK = (Long)attributes.get("classPK");

		if (classPK != null) {
			setClassPK(classPK);
		}

		String location = (String)attributes.get("location");

		if (location != null) {
			setLocation(location);
		}

		Integer profileViewCount = (Integer)attributes.get("profileViewCount");

		if (profileViewCount != null) {
			setProfileViewCount(profileViewCount);
		}

		String interest = (String)attributes.get("interest");

		if (interest != null) {
			setInterest(interest);
		}

		String honors = (String)attributes.get("honors");

		if (honors != null) {
			setHonors(honors);
		}

		String groupAssociation = (String)attributes.get("groupAssociation");

		if (groupAssociation != null) {
			setGroupAssociation(groupAssociation);
		}

		String skillsQualification = (String)attributes.get(
				"skillsQualification");

		if (skillsQualification != null) {
			setSkillsQualification(skillsQualification);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String trainingEducation = (String)attributes.get("trainingEducation");

		if (trainingEducation != null) {
			setTrainingEducation(trainingEducation);
		}

		String about = (String)attributes.get("about");

		if (about != null) {
			setAbout(about);
		}

		Long documentId = (Long)attributes.get("documentId");

		if (documentId != null) {
			setDocumentId(documentId);
		}

		String userInfo = (String)attributes.get("userInfo");

		if (userInfo != null) {
			setUserInfo(userInfo);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String twitterId = (String)attributes.get("twitterId");

		if (twitterId != null) {
			setTwitterId(twitterId);
		}

		String linkedinId = (String)attributes.get("linkedinId");

		if (linkedinId != null) {
			setLinkedinId(linkedinId);
		}

		String yahooId = (String)attributes.get("yahooId");

		if (yahooId != null) {
			setYahooId(yahooId);
		}

		String googleId = (String)attributes.get("googleId");

		if (googleId != null) {
			setGoogleId(googleId);
		}

		String facebookAuthToken = (String)attributes.get("facebookAuthToken");

		if (facebookAuthToken != null) {
			setFacebookAuthToken(facebookAuthToken);
		}

		String openIdAuthToken = (String)attributes.get("openIdAuthToken");

		if (openIdAuthToken != null) {
			setOpenIdAuthToken(openIdAuthToken);
		}

		String twitterAuthToken = (String)attributes.get("twitterAuthToken");

		if (twitterAuthToken != null) {
			setTwitterAuthToken(twitterAuthToken);
		}

		String linkedinAuthToken = (String)attributes.get("linkedinAuthToken");

		if (linkedinAuthToken != null) {
			setLinkedinAuthToken(linkedinAuthToken);
		}

		String yahooAuthToken = (String)attributes.get("yahooAuthToken");

		if (yahooAuthToken != null) {
			setYahooAuthToken(yahooAuthToken);
		}

		String googleAuthToken = (String)attributes.get("googleAuthToken");

		if (googleAuthToken != null) {
			setGoogleAuthToken(googleAuthToken);
		}

		String facebookAuthSecret = (String)attributes.get("facebookAuthSecret");

		if (facebookAuthSecret != null) {
			setFacebookAuthSecret(facebookAuthSecret);
		}

		String openIdAuthSecret = (String)attributes.get("openIdAuthSecret");

		if (openIdAuthSecret != null) {
			setOpenIdAuthSecret(openIdAuthSecret);
		}

		String twitterAuthSecret = (String)attributes.get("twitterAuthSecret");

		if (twitterAuthSecret != null) {
			setTwitterAuthSecret(twitterAuthSecret);
		}

		String linkedinAuthSecret = (String)attributes.get("linkedinAuthSecret");

		if (linkedinAuthSecret != null) {
			setLinkedinAuthSecret(linkedinAuthSecret);
		}

		String yahooAuthSecret = (String)attributes.get("yahooAuthSecret");

		if (yahooAuthSecret != null) {
			setYahooAuthSecret(yahooAuthSecret);
		}

		String googleAuthSecret = (String)attributes.get("googleAuthSecret");

		if (googleAuthSecret != null) {
			setGoogleAuthSecret(googleAuthSecret);
		}

		Integer loginCount = (Integer)attributes.get("loginCount");

		if (loginCount != null) {
			setLoginCount(loginCount);
		}

		Integer updateInterestsStatus = (Integer)attributes.get(
				"updateInterestsStatus");

		if (updateInterestsStatus != null) {
			setUpdateInterestsStatus(updateInterestsStatus);
		}
	}

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_socialProfileRemoteModel, uuid);
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

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_socialProfileRemoteModel, userId);
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
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_socialProfileRemoteModel, groupId);
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

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_socialProfileRemoteModel, companyId);
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

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_socialProfileRemoteModel, createDate);
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

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_socialProfileRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserType() {
		return _userType;
	}

	@Override
	public void setUserType(String userType) {
		_userType = userType;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserType", String.class);

				method.invoke(_socialProfileRemoteModel, userType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMemberPackage() {
		return _memberPackage;
	}

	@Override
	public void setMemberPackage(long memberPackage) {
		_memberPackage = memberPackage;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setMemberPackage", long.class);

				method.invoke(_socialProfileRemoteModel, memberPackage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserRegistrationStatus() {
		return _userRegistrationStatus;
	}

	@Override
	public void setUserRegistrationStatus(String userRegistrationStatus) {
		_userRegistrationStatus = userRegistrationStatus;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserRegistrationStatus",
						String.class);

				method.invoke(_socialProfileRemoteModel, userRegistrationStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getClassPK() {
		return _classPK;
	}

	@Override
	public void setClassPK(long classPK) {
		_classPK = classPK;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setClassPK", long.class);

				method.invoke(_socialProfileRemoteModel, classPK);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLocation() {
		return _location;
	}

	@Override
	public void setLocation(String location) {
		_location = location;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setLocation", String.class);

				method.invoke(_socialProfileRemoteModel, location);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getProfileViewCount() {
		return _profileViewCount;
	}

	@Override
	public void setProfileViewCount(int profileViewCount) {
		_profileViewCount = profileViewCount;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setProfileViewCount", int.class);

				method.invoke(_socialProfileRemoteModel, profileViewCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInterest() {
		return _interest;
	}

	@Override
	public void setInterest(String interest) {
		_interest = interest;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setInterest", String.class);

				method.invoke(_socialProfileRemoteModel, interest);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHonors() {
		return _honors;
	}

	@Override
	public void setHonors(String honors) {
		_honors = honors;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setHonors", String.class);

				method.invoke(_socialProfileRemoteModel, honors);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGroupAssociation() {
		return _groupAssociation;
	}

	@Override
	public void setGroupAssociation(String groupAssociation) {
		_groupAssociation = groupAssociation;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupAssociation",
						String.class);

				method.invoke(_socialProfileRemoteModel, groupAssociation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSkillsQualification() {
		return _skillsQualification;
	}

	@Override
	public void setSkillsQualification(String skillsQualification) {
		_skillsQualification = skillsQualification;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setSkillsQualification",
						String.class);

				method.invoke(_socialProfileRemoteModel, skillsQualification);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_socialProfileRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTrainingEducation() {
		return _trainingEducation;
	}

	@Override
	public void setTrainingEducation(String trainingEducation) {
		_trainingEducation = trainingEducation;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setTrainingEducation",
						String.class);

				method.invoke(_socialProfileRemoteModel, trainingEducation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAbout() {
		return _about;
	}

	@Override
	public void setAbout(String about) {
		_about = about;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setAbout", String.class);

				method.invoke(_socialProfileRemoteModel, about);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDocumentId() {
		return _documentId;
	}

	@Override
	public void setDocumentId(long documentId) {
		_documentId = documentId;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setDocumentId", long.class);

				method.invoke(_socialProfileRemoteModel, documentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUserInfo() {
		return _userInfo;
	}

	@Override
	public void setUserInfo(String userInfo) {
		_userInfo = userInfo;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setUserInfo", String.class);

				method.invoke(_socialProfileRemoteModel, userInfo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStatus() {
		return _status;
	}

	@Override
	public void setStatus(int status) {
		_status = status;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_socialProfileRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTwitterId() {
		return _twitterId;
	}

	@Override
	public void setTwitterId(String twitterId) {
		_twitterId = twitterId;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setTwitterId", String.class);

				method.invoke(_socialProfileRemoteModel, twitterId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkedinId() {
		return _linkedinId;
	}

	@Override
	public void setLinkedinId(String linkedinId) {
		_linkedinId = linkedinId;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkedinId", String.class);

				method.invoke(_socialProfileRemoteModel, linkedinId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYahooId() {
		return _yahooId;
	}

	@Override
	public void setYahooId(String yahooId) {
		_yahooId = yahooId;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setYahooId", String.class);

				method.invoke(_socialProfileRemoteModel, yahooId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGoogleId() {
		return _googleId;
	}

	@Override
	public void setGoogleId(String googleId) {
		_googleId = googleId;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGoogleId", String.class);

				method.invoke(_socialProfileRemoteModel, googleId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFacebookAuthToken() {
		return _facebookAuthToken;
	}

	@Override
	public void setFacebookAuthToken(String facebookAuthToken) {
		_facebookAuthToken = facebookAuthToken;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setFacebookAuthToken",
						String.class);

				method.invoke(_socialProfileRemoteModel, facebookAuthToken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOpenIdAuthToken() {
		return _openIdAuthToken;
	}

	@Override
	public void setOpenIdAuthToken(String openIdAuthToken) {
		_openIdAuthToken = openIdAuthToken;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setOpenIdAuthToken",
						String.class);

				method.invoke(_socialProfileRemoteModel, openIdAuthToken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTwitterAuthToken() {
		return _twitterAuthToken;
	}

	@Override
	public void setTwitterAuthToken(String twitterAuthToken) {
		_twitterAuthToken = twitterAuthToken;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setTwitterAuthToken",
						String.class);

				method.invoke(_socialProfileRemoteModel, twitterAuthToken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkedinAuthToken() {
		return _linkedinAuthToken;
	}

	@Override
	public void setLinkedinAuthToken(String linkedinAuthToken) {
		_linkedinAuthToken = linkedinAuthToken;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkedinAuthToken",
						String.class);

				method.invoke(_socialProfileRemoteModel, linkedinAuthToken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYahooAuthToken() {
		return _yahooAuthToken;
	}

	@Override
	public void setYahooAuthToken(String yahooAuthToken) {
		_yahooAuthToken = yahooAuthToken;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setYahooAuthToken",
						String.class);

				method.invoke(_socialProfileRemoteModel, yahooAuthToken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGoogleAuthToken() {
		return _googleAuthToken;
	}

	@Override
	public void setGoogleAuthToken(String googleAuthToken) {
		_googleAuthToken = googleAuthToken;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGoogleAuthToken",
						String.class);

				method.invoke(_socialProfileRemoteModel, googleAuthToken);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFacebookAuthSecret() {
		return _facebookAuthSecret;
	}

	@Override
	public void setFacebookAuthSecret(String facebookAuthSecret) {
		_facebookAuthSecret = facebookAuthSecret;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setFacebookAuthSecret",
						String.class);

				method.invoke(_socialProfileRemoteModel, facebookAuthSecret);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getOpenIdAuthSecret() {
		return _openIdAuthSecret;
	}

	@Override
	public void setOpenIdAuthSecret(String openIdAuthSecret) {
		_openIdAuthSecret = openIdAuthSecret;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setOpenIdAuthSecret",
						String.class);

				method.invoke(_socialProfileRemoteModel, openIdAuthSecret);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTwitterAuthSecret() {
		return _twitterAuthSecret;
	}

	@Override
	public void setTwitterAuthSecret(String twitterAuthSecret) {
		_twitterAuthSecret = twitterAuthSecret;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setTwitterAuthSecret",
						String.class);

				method.invoke(_socialProfileRemoteModel, twitterAuthSecret);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkedinAuthSecret() {
		return _linkedinAuthSecret;
	}

	@Override
	public void setLinkedinAuthSecret(String linkedinAuthSecret) {
		_linkedinAuthSecret = linkedinAuthSecret;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkedinAuthSecret",
						String.class);

				method.invoke(_socialProfileRemoteModel, linkedinAuthSecret);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getYahooAuthSecret() {
		return _yahooAuthSecret;
	}

	@Override
	public void setYahooAuthSecret(String yahooAuthSecret) {
		_yahooAuthSecret = yahooAuthSecret;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setYahooAuthSecret",
						String.class);

				method.invoke(_socialProfileRemoteModel, yahooAuthSecret);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getGoogleAuthSecret() {
		return _googleAuthSecret;
	}

	@Override
	public void setGoogleAuthSecret(String googleAuthSecret) {
		_googleAuthSecret = googleAuthSecret;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setGoogleAuthSecret",
						String.class);

				method.invoke(_socialProfileRemoteModel, googleAuthSecret);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getLoginCount() {
		return _loginCount;
	}

	@Override
	public void setLoginCount(int loginCount) {
		_loginCount = loginCount;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setLoginCount", int.class);

				method.invoke(_socialProfileRemoteModel, loginCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getUpdateInterestsStatus() {
		return _updateInterestsStatus;
	}

	@Override
	public void setUpdateInterestsStatus(int updateInterestsStatus) {
		_updateInterestsStatus = updateInterestsStatus;

		if (_socialProfileRemoteModel != null) {
			try {
				Class<?> clazz = _socialProfileRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdateInterestsStatus",
						int.class);

				method.invoke(_socialProfileRemoteModel, updateInterestsStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				SocialProfile.class.getName()));
	}

	public BaseModel<?> getSocialProfileRemoteModel() {
		return _socialProfileRemoteModel;
	}

	public void setSocialProfileRemoteModel(
		BaseModel<?> socialProfileRemoteModel) {
		_socialProfileRemoteModel = socialProfileRemoteModel;
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

		Class<?> remoteModelClass = _socialProfileRemoteModel.getClass();

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

		Object returnValue = method.invoke(_socialProfileRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			SocialProfileLocalServiceUtil.addSocialProfile(this);
		}
		else {
			SocialProfileLocalServiceUtil.updateSocialProfile(this);
		}
	}

	@Override
	public SocialProfile toEscapedModel() {
		return (SocialProfile)ProxyUtil.newProxyInstance(SocialProfile.class.getClassLoader(),
			new Class[] { SocialProfile.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		SocialProfileClp clone = new SocialProfileClp();

		clone.setUuid(getUuid());
		clone.setUserId(getUserId());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setUserType(getUserType());
		clone.setMemberPackage(getMemberPackage());
		clone.setUserRegistrationStatus(getUserRegistrationStatus());
		clone.setClassPK(getClassPK());
		clone.setLocation(getLocation());
		clone.setProfileViewCount(getProfileViewCount());
		clone.setInterest(getInterest());
		clone.setHonors(getHonors());
		clone.setGroupAssociation(getGroupAssociation());
		clone.setSkillsQualification(getSkillsQualification());
		clone.setTitle(getTitle());
		clone.setTrainingEducation(getTrainingEducation());
		clone.setAbout(getAbout());
		clone.setDocumentId(getDocumentId());
		clone.setUserInfo(getUserInfo());
		clone.setStatus(getStatus());
		clone.setTwitterId(getTwitterId());
		clone.setLinkedinId(getLinkedinId());
		clone.setYahooId(getYahooId());
		clone.setGoogleId(getGoogleId());
		clone.setFacebookAuthToken(getFacebookAuthToken());
		clone.setOpenIdAuthToken(getOpenIdAuthToken());
		clone.setTwitterAuthToken(getTwitterAuthToken());
		clone.setLinkedinAuthToken(getLinkedinAuthToken());
		clone.setYahooAuthToken(getYahooAuthToken());
		clone.setGoogleAuthToken(getGoogleAuthToken());
		clone.setFacebookAuthSecret(getFacebookAuthSecret());
		clone.setOpenIdAuthSecret(getOpenIdAuthSecret());
		clone.setTwitterAuthSecret(getTwitterAuthSecret());
		clone.setLinkedinAuthSecret(getLinkedinAuthSecret());
		clone.setYahooAuthSecret(getYahooAuthSecret());
		clone.setGoogleAuthSecret(getGoogleAuthSecret());
		clone.setLoginCount(getLoginCount());
		clone.setUpdateInterestsStatus(getUpdateInterestsStatus());

		return clone;
	}

	@Override
	public int compareTo(SocialProfile socialProfile) {
		long primaryKey = socialProfile.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialProfileClp)) {
			return false;
		}

		SocialProfileClp socialProfile = (SocialProfileClp)obj;

		long primaryKey = socialProfile.getPrimaryKey();

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
		StringBundler sb = new StringBundler(81);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", userType=");
		sb.append(getUserType());
		sb.append(", memberPackage=");
		sb.append(getMemberPackage());
		sb.append(", userRegistrationStatus=");
		sb.append(getUserRegistrationStatus());
		sb.append(", classPK=");
		sb.append(getClassPK());
		sb.append(", location=");
		sb.append(getLocation());
		sb.append(", profileViewCount=");
		sb.append(getProfileViewCount());
		sb.append(", interest=");
		sb.append(getInterest());
		sb.append(", honors=");
		sb.append(getHonors());
		sb.append(", groupAssociation=");
		sb.append(getGroupAssociation());
		sb.append(", skillsQualification=");
		sb.append(getSkillsQualification());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", trainingEducation=");
		sb.append(getTrainingEducation());
		sb.append(", about=");
		sb.append(getAbout());
		sb.append(", documentId=");
		sb.append(getDocumentId());
		sb.append(", userInfo=");
		sb.append(getUserInfo());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", twitterId=");
		sb.append(getTwitterId());
		sb.append(", linkedinId=");
		sb.append(getLinkedinId());
		sb.append(", yahooId=");
		sb.append(getYahooId());
		sb.append(", googleId=");
		sb.append(getGoogleId());
		sb.append(", facebookAuthToken=");
		sb.append(getFacebookAuthToken());
		sb.append(", openIdAuthToken=");
		sb.append(getOpenIdAuthToken());
		sb.append(", twitterAuthToken=");
		sb.append(getTwitterAuthToken());
		sb.append(", linkedinAuthToken=");
		sb.append(getLinkedinAuthToken());
		sb.append(", yahooAuthToken=");
		sb.append(getYahooAuthToken());
		sb.append(", googleAuthToken=");
		sb.append(getGoogleAuthToken());
		sb.append(", facebookAuthSecret=");
		sb.append(getFacebookAuthSecret());
		sb.append(", openIdAuthSecret=");
		sb.append(getOpenIdAuthSecret());
		sb.append(", twitterAuthSecret=");
		sb.append(getTwitterAuthSecret());
		sb.append(", linkedinAuthSecret=");
		sb.append(getLinkedinAuthSecret());
		sb.append(", yahooAuthSecret=");
		sb.append(getYahooAuthSecret());
		sb.append(", googleAuthSecret=");
		sb.append(getGoogleAuthSecret());
		sb.append(", loginCount=");
		sb.append(getLoginCount());
		sb.append(", updateInterestsStatus=");
		sb.append(getUpdateInterestsStatus());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(124);

		sb.append("<model><model-name>");
		sb.append(
			"com.sambaash.platform.srv.spsocialprofile.model.SocialProfile");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
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
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userType</column-name><column-value><![CDATA[");
		sb.append(getUserType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>memberPackage</column-name><column-value><![CDATA[");
		sb.append(getMemberPackage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userRegistrationStatus</column-name><column-value><![CDATA[");
		sb.append(getUserRegistrationStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>classPK</column-name><column-value><![CDATA[");
		sb.append(getClassPK());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>location</column-name><column-value><![CDATA[");
		sb.append(getLocation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profileViewCount</column-name><column-value><![CDATA[");
		sb.append(getProfileViewCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>interest</column-name><column-value><![CDATA[");
		sb.append(getInterest());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>honors</column-name><column-value><![CDATA[");
		sb.append(getHonors());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupAssociation</column-name><column-value><![CDATA[");
		sb.append(getGroupAssociation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>skillsQualification</column-name><column-value><![CDATA[");
		sb.append(getSkillsQualification());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>trainingEducation</column-name><column-value><![CDATA[");
		sb.append(getTrainingEducation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>about</column-name><column-value><![CDATA[");
		sb.append(getAbout());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>documentId</column-name><column-value><![CDATA[");
		sb.append(getDocumentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userInfo</column-name><column-value><![CDATA[");
		sb.append(getUserInfo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitterId</column-name><column-value><![CDATA[");
		sb.append(getTwitterId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkedinId</column-name><column-value><![CDATA[");
		sb.append(getLinkedinId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yahooId</column-name><column-value><![CDATA[");
		sb.append(getYahooId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>googleId</column-name><column-value><![CDATA[");
		sb.append(getGoogleId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebookAuthToken</column-name><column-value><![CDATA[");
		sb.append(getFacebookAuthToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openIdAuthToken</column-name><column-value><![CDATA[");
		sb.append(getOpenIdAuthToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitterAuthToken</column-name><column-value><![CDATA[");
		sb.append(getTwitterAuthToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkedinAuthToken</column-name><column-value><![CDATA[");
		sb.append(getLinkedinAuthToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yahooAuthToken</column-name><column-value><![CDATA[");
		sb.append(getYahooAuthToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>googleAuthToken</column-name><column-value><![CDATA[");
		sb.append(getGoogleAuthToken());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebookAuthSecret</column-name><column-value><![CDATA[");
		sb.append(getFacebookAuthSecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>openIdAuthSecret</column-name><column-value><![CDATA[");
		sb.append(getOpenIdAuthSecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitterAuthSecret</column-name><column-value><![CDATA[");
		sb.append(getTwitterAuthSecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkedinAuthSecret</column-name><column-value><![CDATA[");
		sb.append(getLinkedinAuthSecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>yahooAuthSecret</column-name><column-value><![CDATA[");
		sb.append(getYahooAuthSecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>googleAuthSecret</column-name><column-value><![CDATA[");
		sb.append(getGoogleAuthSecret());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>loginCount</column-name><column-value><![CDATA[");
		sb.append(getLoginCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updateInterestsStatus</column-name><column-value><![CDATA[");
		sb.append(getUpdateInterestsStatus());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _uuid;
	private long _userId;
	private String _userUuid;
	private long _groupId;
	private long _companyId;
	private Date _createDate;
	private Date _modifiedDate;
	private String _userType;
	private long _memberPackage;
	private String _userRegistrationStatus;
	private long _classPK;
	private String _location;
	private int _profileViewCount;
	private String _interest;
	private String _honors;
	private String _groupAssociation;
	private String _skillsQualification;
	private String _title;
	private String _trainingEducation;
	private String _about;
	private long _documentId;
	private String _userInfo;
	private int _status;
	private String _twitterId;
	private String _linkedinId;
	private String _yahooId;
	private String _googleId;
	private String _facebookAuthToken;
	private String _openIdAuthToken;
	private String _twitterAuthToken;
	private String _linkedinAuthToken;
	private String _yahooAuthToken;
	private String _googleAuthToken;
	private String _facebookAuthSecret;
	private String _openIdAuthSecret;
	private String _twitterAuthSecret;
	private String _linkedinAuthSecret;
	private String _yahooAuthSecret;
	private String _googleAuthSecret;
	private int _loginCount;
	private int _updateInterestsStatus;
	private BaseModel<?> _socialProfileRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.spsocialprofile.service.ClpSerializer.class;
}