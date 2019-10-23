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

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link SocialProfile}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfile
 * @generated
 */
public class SocialProfileWrapper implements SocialProfile,
	ModelWrapper<SocialProfile> {
	public SocialProfileWrapper(SocialProfile socialProfile) {
		_socialProfile = socialProfile;
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

	/**
	* Returns the primary key of this social profile.
	*
	* @return the primary key of this social profile
	*/
	@Override
	public long getPrimaryKey() {
		return _socialProfile.getPrimaryKey();
	}

	/**
	* Sets the primary key of this social profile.
	*
	* @param primaryKey the primary key of this social profile
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_socialProfile.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this social profile.
	*
	* @return the uuid of this social profile
	*/
	@Override
	public java.lang.String getUuid() {
		return _socialProfile.getUuid();
	}

	/**
	* Sets the uuid of this social profile.
	*
	* @param uuid the uuid of this social profile
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_socialProfile.setUuid(uuid);
	}

	/**
	* Returns the user ID of this social profile.
	*
	* @return the user ID of this social profile
	*/
	@Override
	public long getUserId() {
		return _socialProfile.getUserId();
	}

	/**
	* Sets the user ID of this social profile.
	*
	* @param userId the user ID of this social profile
	*/
	@Override
	public void setUserId(long userId) {
		_socialProfile.setUserId(userId);
	}

	/**
	* Returns the user uuid of this social profile.
	*
	* @return the user uuid of this social profile
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _socialProfile.getUserUuid();
	}

	/**
	* Sets the user uuid of this social profile.
	*
	* @param userUuid the user uuid of this social profile
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_socialProfile.setUserUuid(userUuid);
	}

	/**
	* Returns the group ID of this social profile.
	*
	* @return the group ID of this social profile
	*/
	@Override
	public long getGroupId() {
		return _socialProfile.getGroupId();
	}

	/**
	* Sets the group ID of this social profile.
	*
	* @param groupId the group ID of this social profile
	*/
	@Override
	public void setGroupId(long groupId) {
		_socialProfile.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this social profile.
	*
	* @return the company ID of this social profile
	*/
	@Override
	public long getCompanyId() {
		return _socialProfile.getCompanyId();
	}

	/**
	* Sets the company ID of this social profile.
	*
	* @param companyId the company ID of this social profile
	*/
	@Override
	public void setCompanyId(long companyId) {
		_socialProfile.setCompanyId(companyId);
	}

	/**
	* Returns the create date of this social profile.
	*
	* @return the create date of this social profile
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _socialProfile.getCreateDate();
	}

	/**
	* Sets the create date of this social profile.
	*
	* @param createDate the create date of this social profile
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_socialProfile.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this social profile.
	*
	* @return the modified date of this social profile
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _socialProfile.getModifiedDate();
	}

	/**
	* Sets the modified date of this social profile.
	*
	* @param modifiedDate the modified date of this social profile
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_socialProfile.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the user type of this social profile.
	*
	* @return the user type of this social profile
	*/
	@Override
	public java.lang.String getUserType() {
		return _socialProfile.getUserType();
	}

	/**
	* Sets the user type of this social profile.
	*
	* @param userType the user type of this social profile
	*/
	@Override
	public void setUserType(java.lang.String userType) {
		_socialProfile.setUserType(userType);
	}

	/**
	* Returns the member package of this social profile.
	*
	* @return the member package of this social profile
	*/
	@Override
	public long getMemberPackage() {
		return _socialProfile.getMemberPackage();
	}

	/**
	* Sets the member package of this social profile.
	*
	* @param memberPackage the member package of this social profile
	*/
	@Override
	public void setMemberPackage(long memberPackage) {
		_socialProfile.setMemberPackage(memberPackage);
	}

	/**
	* Returns the user registration status of this social profile.
	*
	* @return the user registration status of this social profile
	*/
	@Override
	public java.lang.String getUserRegistrationStatus() {
		return _socialProfile.getUserRegistrationStatus();
	}

	/**
	* Sets the user registration status of this social profile.
	*
	* @param userRegistrationStatus the user registration status of this social profile
	*/
	@Override
	public void setUserRegistrationStatus(
		java.lang.String userRegistrationStatus) {
		_socialProfile.setUserRegistrationStatus(userRegistrationStatus);
	}

	/**
	* Returns the class p k of this social profile.
	*
	* @return the class p k of this social profile
	*/
	@Override
	public long getClassPK() {
		return _socialProfile.getClassPK();
	}

	/**
	* Sets the class p k of this social profile.
	*
	* @param classPK the class p k of this social profile
	*/
	@Override
	public void setClassPK(long classPK) {
		_socialProfile.setClassPK(classPK);
	}

	/**
	* Returns the location of this social profile.
	*
	* @return the location of this social profile
	*/
	@Override
	public java.lang.String getLocation() {
		return _socialProfile.getLocation();
	}

	/**
	* Sets the location of this social profile.
	*
	* @param location the location of this social profile
	*/
	@Override
	public void setLocation(java.lang.String location) {
		_socialProfile.setLocation(location);
	}

	/**
	* Returns the profile view count of this social profile.
	*
	* @return the profile view count of this social profile
	*/
	@Override
	public int getProfileViewCount() {
		return _socialProfile.getProfileViewCount();
	}

	/**
	* Sets the profile view count of this social profile.
	*
	* @param profileViewCount the profile view count of this social profile
	*/
	@Override
	public void setProfileViewCount(int profileViewCount) {
		_socialProfile.setProfileViewCount(profileViewCount);
	}

	/**
	* Returns the interest of this social profile.
	*
	* @return the interest of this social profile
	*/
	@Override
	public java.lang.String getInterest() {
		return _socialProfile.getInterest();
	}

	/**
	* Sets the interest of this social profile.
	*
	* @param interest the interest of this social profile
	*/
	@Override
	public void setInterest(java.lang.String interest) {
		_socialProfile.setInterest(interest);
	}

	/**
	* Returns the honors of this social profile.
	*
	* @return the honors of this social profile
	*/
	@Override
	public java.lang.String getHonors() {
		return _socialProfile.getHonors();
	}

	/**
	* Sets the honors of this social profile.
	*
	* @param honors the honors of this social profile
	*/
	@Override
	public void setHonors(java.lang.String honors) {
		_socialProfile.setHonors(honors);
	}

	/**
	* Returns the group association of this social profile.
	*
	* @return the group association of this social profile
	*/
	@Override
	public java.lang.String getGroupAssociation() {
		return _socialProfile.getGroupAssociation();
	}

	/**
	* Sets the group association of this social profile.
	*
	* @param groupAssociation the group association of this social profile
	*/
	@Override
	public void setGroupAssociation(java.lang.String groupAssociation) {
		_socialProfile.setGroupAssociation(groupAssociation);
	}

	/**
	* Returns the skills qualification of this social profile.
	*
	* @return the skills qualification of this social profile
	*/
	@Override
	public java.lang.String getSkillsQualification() {
		return _socialProfile.getSkillsQualification();
	}

	/**
	* Sets the skills qualification of this social profile.
	*
	* @param skillsQualification the skills qualification of this social profile
	*/
	@Override
	public void setSkillsQualification(java.lang.String skillsQualification) {
		_socialProfile.setSkillsQualification(skillsQualification);
	}

	/**
	* Returns the title of this social profile.
	*
	* @return the title of this social profile
	*/
	@Override
	public java.lang.String getTitle() {
		return _socialProfile.getTitle();
	}

	/**
	* Sets the title of this social profile.
	*
	* @param title the title of this social profile
	*/
	@Override
	public void setTitle(java.lang.String title) {
		_socialProfile.setTitle(title);
	}

	/**
	* Returns the training education of this social profile.
	*
	* @return the training education of this social profile
	*/
	@Override
	public java.lang.String getTrainingEducation() {
		return _socialProfile.getTrainingEducation();
	}

	/**
	* Sets the training education of this social profile.
	*
	* @param trainingEducation the training education of this social profile
	*/
	@Override
	public void setTrainingEducation(java.lang.String trainingEducation) {
		_socialProfile.setTrainingEducation(trainingEducation);
	}

	/**
	* Returns the about of this social profile.
	*
	* @return the about of this social profile
	*/
	@Override
	public java.lang.String getAbout() {
		return _socialProfile.getAbout();
	}

	/**
	* Sets the about of this social profile.
	*
	* @param about the about of this social profile
	*/
	@Override
	public void setAbout(java.lang.String about) {
		_socialProfile.setAbout(about);
	}

	/**
	* Returns the document ID of this social profile.
	*
	* @return the document ID of this social profile
	*/
	@Override
	public long getDocumentId() {
		return _socialProfile.getDocumentId();
	}

	/**
	* Sets the document ID of this social profile.
	*
	* @param documentId the document ID of this social profile
	*/
	@Override
	public void setDocumentId(long documentId) {
		_socialProfile.setDocumentId(documentId);
	}

	/**
	* Returns the user info of this social profile.
	*
	* @return the user info of this social profile
	*/
	@Override
	public java.lang.String getUserInfo() {
		return _socialProfile.getUserInfo();
	}

	/**
	* Sets the user info of this social profile.
	*
	* @param userInfo the user info of this social profile
	*/
	@Override
	public void setUserInfo(java.lang.String userInfo) {
		_socialProfile.setUserInfo(userInfo);
	}

	/**
	* Returns the status of this social profile.
	*
	* @return the status of this social profile
	*/
	@Override
	public int getStatus() {
		return _socialProfile.getStatus();
	}

	/**
	* Sets the status of this social profile.
	*
	* @param status the status of this social profile
	*/
	@Override
	public void setStatus(int status) {
		_socialProfile.setStatus(status);
	}

	/**
	* Returns the twitter ID of this social profile.
	*
	* @return the twitter ID of this social profile
	*/
	@Override
	public java.lang.String getTwitterId() {
		return _socialProfile.getTwitterId();
	}

	/**
	* Sets the twitter ID of this social profile.
	*
	* @param twitterId the twitter ID of this social profile
	*/
	@Override
	public void setTwitterId(java.lang.String twitterId) {
		_socialProfile.setTwitterId(twitterId);
	}

	/**
	* Returns the linkedin ID of this social profile.
	*
	* @return the linkedin ID of this social profile
	*/
	@Override
	public java.lang.String getLinkedinId() {
		return _socialProfile.getLinkedinId();
	}

	/**
	* Sets the linkedin ID of this social profile.
	*
	* @param linkedinId the linkedin ID of this social profile
	*/
	@Override
	public void setLinkedinId(java.lang.String linkedinId) {
		_socialProfile.setLinkedinId(linkedinId);
	}

	/**
	* Returns the yahoo ID of this social profile.
	*
	* @return the yahoo ID of this social profile
	*/
	@Override
	public java.lang.String getYahooId() {
		return _socialProfile.getYahooId();
	}

	/**
	* Sets the yahoo ID of this social profile.
	*
	* @param yahooId the yahoo ID of this social profile
	*/
	@Override
	public void setYahooId(java.lang.String yahooId) {
		_socialProfile.setYahooId(yahooId);
	}

	/**
	* Returns the google ID of this social profile.
	*
	* @return the google ID of this social profile
	*/
	@Override
	public java.lang.String getGoogleId() {
		return _socialProfile.getGoogleId();
	}

	/**
	* Sets the google ID of this social profile.
	*
	* @param googleId the google ID of this social profile
	*/
	@Override
	public void setGoogleId(java.lang.String googleId) {
		_socialProfile.setGoogleId(googleId);
	}

	/**
	* Returns the facebook auth token of this social profile.
	*
	* @return the facebook auth token of this social profile
	*/
	@Override
	public java.lang.String getFacebookAuthToken() {
		return _socialProfile.getFacebookAuthToken();
	}

	/**
	* Sets the facebook auth token of this social profile.
	*
	* @param facebookAuthToken the facebook auth token of this social profile
	*/
	@Override
	public void setFacebookAuthToken(java.lang.String facebookAuthToken) {
		_socialProfile.setFacebookAuthToken(facebookAuthToken);
	}

	/**
	* Returns the open ID auth token of this social profile.
	*
	* @return the open ID auth token of this social profile
	*/
	@Override
	public java.lang.String getOpenIdAuthToken() {
		return _socialProfile.getOpenIdAuthToken();
	}

	/**
	* Sets the open ID auth token of this social profile.
	*
	* @param openIdAuthToken the open ID auth token of this social profile
	*/
	@Override
	public void setOpenIdAuthToken(java.lang.String openIdAuthToken) {
		_socialProfile.setOpenIdAuthToken(openIdAuthToken);
	}

	/**
	* Returns the twitter auth token of this social profile.
	*
	* @return the twitter auth token of this social profile
	*/
	@Override
	public java.lang.String getTwitterAuthToken() {
		return _socialProfile.getTwitterAuthToken();
	}

	/**
	* Sets the twitter auth token of this social profile.
	*
	* @param twitterAuthToken the twitter auth token of this social profile
	*/
	@Override
	public void setTwitterAuthToken(java.lang.String twitterAuthToken) {
		_socialProfile.setTwitterAuthToken(twitterAuthToken);
	}

	/**
	* Returns the linkedin auth token of this social profile.
	*
	* @return the linkedin auth token of this social profile
	*/
	@Override
	public java.lang.String getLinkedinAuthToken() {
		return _socialProfile.getLinkedinAuthToken();
	}

	/**
	* Sets the linkedin auth token of this social profile.
	*
	* @param linkedinAuthToken the linkedin auth token of this social profile
	*/
	@Override
	public void setLinkedinAuthToken(java.lang.String linkedinAuthToken) {
		_socialProfile.setLinkedinAuthToken(linkedinAuthToken);
	}

	/**
	* Returns the yahoo auth token of this social profile.
	*
	* @return the yahoo auth token of this social profile
	*/
	@Override
	public java.lang.String getYahooAuthToken() {
		return _socialProfile.getYahooAuthToken();
	}

	/**
	* Sets the yahoo auth token of this social profile.
	*
	* @param yahooAuthToken the yahoo auth token of this social profile
	*/
	@Override
	public void setYahooAuthToken(java.lang.String yahooAuthToken) {
		_socialProfile.setYahooAuthToken(yahooAuthToken);
	}

	/**
	* Returns the google auth token of this social profile.
	*
	* @return the google auth token of this social profile
	*/
	@Override
	public java.lang.String getGoogleAuthToken() {
		return _socialProfile.getGoogleAuthToken();
	}

	/**
	* Sets the google auth token of this social profile.
	*
	* @param googleAuthToken the google auth token of this social profile
	*/
	@Override
	public void setGoogleAuthToken(java.lang.String googleAuthToken) {
		_socialProfile.setGoogleAuthToken(googleAuthToken);
	}

	/**
	* Returns the facebook auth secret of this social profile.
	*
	* @return the facebook auth secret of this social profile
	*/
	@Override
	public java.lang.String getFacebookAuthSecret() {
		return _socialProfile.getFacebookAuthSecret();
	}

	/**
	* Sets the facebook auth secret of this social profile.
	*
	* @param facebookAuthSecret the facebook auth secret of this social profile
	*/
	@Override
	public void setFacebookAuthSecret(java.lang.String facebookAuthSecret) {
		_socialProfile.setFacebookAuthSecret(facebookAuthSecret);
	}

	/**
	* Returns the open ID auth secret of this social profile.
	*
	* @return the open ID auth secret of this social profile
	*/
	@Override
	public java.lang.String getOpenIdAuthSecret() {
		return _socialProfile.getOpenIdAuthSecret();
	}

	/**
	* Sets the open ID auth secret of this social profile.
	*
	* @param openIdAuthSecret the open ID auth secret of this social profile
	*/
	@Override
	public void setOpenIdAuthSecret(java.lang.String openIdAuthSecret) {
		_socialProfile.setOpenIdAuthSecret(openIdAuthSecret);
	}

	/**
	* Returns the twitter auth secret of this social profile.
	*
	* @return the twitter auth secret of this social profile
	*/
	@Override
	public java.lang.String getTwitterAuthSecret() {
		return _socialProfile.getTwitterAuthSecret();
	}

	/**
	* Sets the twitter auth secret of this social profile.
	*
	* @param twitterAuthSecret the twitter auth secret of this social profile
	*/
	@Override
	public void setTwitterAuthSecret(java.lang.String twitterAuthSecret) {
		_socialProfile.setTwitterAuthSecret(twitterAuthSecret);
	}

	/**
	* Returns the linkedin auth secret of this social profile.
	*
	* @return the linkedin auth secret of this social profile
	*/
	@Override
	public java.lang.String getLinkedinAuthSecret() {
		return _socialProfile.getLinkedinAuthSecret();
	}

	/**
	* Sets the linkedin auth secret of this social profile.
	*
	* @param linkedinAuthSecret the linkedin auth secret of this social profile
	*/
	@Override
	public void setLinkedinAuthSecret(java.lang.String linkedinAuthSecret) {
		_socialProfile.setLinkedinAuthSecret(linkedinAuthSecret);
	}

	/**
	* Returns the yahoo auth secret of this social profile.
	*
	* @return the yahoo auth secret of this social profile
	*/
	@Override
	public java.lang.String getYahooAuthSecret() {
		return _socialProfile.getYahooAuthSecret();
	}

	/**
	* Sets the yahoo auth secret of this social profile.
	*
	* @param yahooAuthSecret the yahoo auth secret of this social profile
	*/
	@Override
	public void setYahooAuthSecret(java.lang.String yahooAuthSecret) {
		_socialProfile.setYahooAuthSecret(yahooAuthSecret);
	}

	/**
	* Returns the google auth secret of this social profile.
	*
	* @return the google auth secret of this social profile
	*/
	@Override
	public java.lang.String getGoogleAuthSecret() {
		return _socialProfile.getGoogleAuthSecret();
	}

	/**
	* Sets the google auth secret of this social profile.
	*
	* @param googleAuthSecret the google auth secret of this social profile
	*/
	@Override
	public void setGoogleAuthSecret(java.lang.String googleAuthSecret) {
		_socialProfile.setGoogleAuthSecret(googleAuthSecret);
	}

	/**
	* Returns the login count of this social profile.
	*
	* @return the login count of this social profile
	*/
	@Override
	public int getLoginCount() {
		return _socialProfile.getLoginCount();
	}

	/**
	* Sets the login count of this social profile.
	*
	* @param loginCount the login count of this social profile
	*/
	@Override
	public void setLoginCount(int loginCount) {
		_socialProfile.setLoginCount(loginCount);
	}

	/**
	* Returns the update interests status of this social profile.
	*
	* @return the update interests status of this social profile
	*/
	@Override
	public int getUpdateInterestsStatus() {
		return _socialProfile.getUpdateInterestsStatus();
	}

	/**
	* Sets the update interests status of this social profile.
	*
	* @param updateInterestsStatus the update interests status of this social profile
	*/
	@Override
	public void setUpdateInterestsStatus(int updateInterestsStatus) {
		_socialProfile.setUpdateInterestsStatus(updateInterestsStatus);
	}

	@Override
	public boolean isNew() {
		return _socialProfile.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_socialProfile.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _socialProfile.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_socialProfile.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _socialProfile.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _socialProfile.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_socialProfile.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _socialProfile.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_socialProfile.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_socialProfile.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_socialProfile.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new SocialProfileWrapper((SocialProfile)_socialProfile.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile) {
		return _socialProfile.compareTo(socialProfile);
	}

	@Override
	public int hashCode() {
		return _socialProfile.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> toCacheModel() {
		return _socialProfile.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile toEscapedModel() {
		return new SocialProfileWrapper(_socialProfile.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile toUnescapedModel() {
		return new SocialProfileWrapper(_socialProfile.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _socialProfile.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _socialProfile.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_socialProfile.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SocialProfileWrapper)) {
			return false;
		}

		SocialProfileWrapper socialProfileWrapper = (SocialProfileWrapper)obj;

		if (Validator.equals(_socialProfile, socialProfileWrapper._socialProfile)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _socialProfile.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public SocialProfile getWrappedSocialProfile() {
		return _socialProfile;
	}

	@Override
	public SocialProfile getWrappedModel() {
		return _socialProfile;
	}

	@Override
	public void resetOriginalValues() {
		_socialProfile.resetOriginalValues();
	}

	private SocialProfile _socialProfile;
}