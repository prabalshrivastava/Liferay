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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.spsocialprofile.service.http.SocialProfileServiceSoap}.
 *
 * @author gauravvijayvergia
 * @see com.sambaash.platform.srv.spsocialprofile.service.http.SocialProfileServiceSoap
 * @generated
 */
public class SocialProfileSoap implements Serializable {
	public static SocialProfileSoap toSoapModel(SocialProfile model) {
		SocialProfileSoap soapModel = new SocialProfileSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setUserId(model.getUserId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setUserType(model.getUserType());
		soapModel.setMemberPackage(model.getMemberPackage());
		soapModel.setUserRegistrationStatus(model.getUserRegistrationStatus());
		soapModel.setClassPK(model.getClassPK());
		soapModel.setLocation(model.getLocation());
		soapModel.setProfileViewCount(model.getProfileViewCount());
		soapModel.setInterest(model.getInterest());
		soapModel.setHonors(model.getHonors());
		soapModel.setGroupAssociation(model.getGroupAssociation());
		soapModel.setSkillsQualification(model.getSkillsQualification());
		soapModel.setTitle(model.getTitle());
		soapModel.setTrainingEducation(model.getTrainingEducation());
		soapModel.setAbout(model.getAbout());
		soapModel.setDocumentId(model.getDocumentId());
		soapModel.setUserInfo(model.getUserInfo());
		soapModel.setStatus(model.getStatus());
		soapModel.setTwitterId(model.getTwitterId());
		soapModel.setLinkedinId(model.getLinkedinId());
		soapModel.setYahooId(model.getYahooId());
		soapModel.setGoogleId(model.getGoogleId());
		soapModel.setFacebookAuthToken(model.getFacebookAuthToken());
		soapModel.setOpenIdAuthToken(model.getOpenIdAuthToken());
		soapModel.setTwitterAuthToken(model.getTwitterAuthToken());
		soapModel.setLinkedinAuthToken(model.getLinkedinAuthToken());
		soapModel.setYahooAuthToken(model.getYahooAuthToken());
		soapModel.setGoogleAuthToken(model.getGoogleAuthToken());
		soapModel.setFacebookAuthSecret(model.getFacebookAuthSecret());
		soapModel.setOpenIdAuthSecret(model.getOpenIdAuthSecret());
		soapModel.setTwitterAuthSecret(model.getTwitterAuthSecret());
		soapModel.setLinkedinAuthSecret(model.getLinkedinAuthSecret());
		soapModel.setYahooAuthSecret(model.getYahooAuthSecret());
		soapModel.setGoogleAuthSecret(model.getGoogleAuthSecret());
		soapModel.setLoginCount(model.getLoginCount());
		soapModel.setUpdateInterestsStatus(model.getUpdateInterestsStatus());

		return soapModel;
	}

	public static SocialProfileSoap[] toSoapModels(SocialProfile[] models) {
		SocialProfileSoap[] soapModels = new SocialProfileSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileSoap[][] toSoapModels(SocialProfile[][] models) {
		SocialProfileSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SocialProfileSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SocialProfileSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SocialProfileSoap[] toSoapModels(List<SocialProfile> models) {
		List<SocialProfileSoap> soapModels = new ArrayList<SocialProfileSoap>(models.size());

		for (SocialProfile model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SocialProfileSoap[soapModels.size()]);
	}

	public SocialProfileSoap() {
	}

	public long getPrimaryKey() {
		return _userId;
	}

	public void setPrimaryKey(long pk) {
		setUserId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
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

	public String getUserType() {
		return _userType;
	}

	public void setUserType(String userType) {
		_userType = userType;
	}

	public long getMemberPackage() {
		return _memberPackage;
	}

	public void setMemberPackage(long memberPackage) {
		_memberPackage = memberPackage;
	}

	public String getUserRegistrationStatus() {
		return _userRegistrationStatus;
	}

	public void setUserRegistrationStatus(String userRegistrationStatus) {
		_userRegistrationStatus = userRegistrationStatus;
	}

	public long getClassPK() {
		return _classPK;
	}

	public void setClassPK(long classPK) {
		_classPK = classPK;
	}

	public String getLocation() {
		return _location;
	}

	public void setLocation(String location) {
		_location = location;
	}

	public int getProfileViewCount() {
		return _profileViewCount;
	}

	public void setProfileViewCount(int profileViewCount) {
		_profileViewCount = profileViewCount;
	}

	public String getInterest() {
		return _interest;
	}

	public void setInterest(String interest) {
		_interest = interest;
	}

	public String getHonors() {
		return _honors;
	}

	public void setHonors(String honors) {
		_honors = honors;
	}

	public String getGroupAssociation() {
		return _groupAssociation;
	}

	public void setGroupAssociation(String groupAssociation) {
		_groupAssociation = groupAssociation;
	}

	public String getSkillsQualification() {
		return _skillsQualification;
	}

	public void setSkillsQualification(String skillsQualification) {
		_skillsQualification = skillsQualification;
	}

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		_title = title;
	}

	public String getTrainingEducation() {
		return _trainingEducation;
	}

	public void setTrainingEducation(String trainingEducation) {
		_trainingEducation = trainingEducation;
	}

	public String getAbout() {
		return _about;
	}

	public void setAbout(String about) {
		_about = about;
	}

	public long getDocumentId() {
		return _documentId;
	}

	public void setDocumentId(long documentId) {
		_documentId = documentId;
	}

	public String getUserInfo() {
		return _userInfo;
	}

	public void setUserInfo(String userInfo) {
		_userInfo = userInfo;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getTwitterId() {
		return _twitterId;
	}

	public void setTwitterId(String twitterId) {
		_twitterId = twitterId;
	}

	public String getLinkedinId() {
		return _linkedinId;
	}

	public void setLinkedinId(String linkedinId) {
		_linkedinId = linkedinId;
	}

	public String getYahooId() {
		return _yahooId;
	}

	public void setYahooId(String yahooId) {
		_yahooId = yahooId;
	}

	public String getGoogleId() {
		return _googleId;
	}

	public void setGoogleId(String googleId) {
		_googleId = googleId;
	}

	public String getFacebookAuthToken() {
		return _facebookAuthToken;
	}

	public void setFacebookAuthToken(String facebookAuthToken) {
		_facebookAuthToken = facebookAuthToken;
	}

	public String getOpenIdAuthToken() {
		return _openIdAuthToken;
	}

	public void setOpenIdAuthToken(String openIdAuthToken) {
		_openIdAuthToken = openIdAuthToken;
	}

	public String getTwitterAuthToken() {
		return _twitterAuthToken;
	}

	public void setTwitterAuthToken(String twitterAuthToken) {
		_twitterAuthToken = twitterAuthToken;
	}

	public String getLinkedinAuthToken() {
		return _linkedinAuthToken;
	}

	public void setLinkedinAuthToken(String linkedinAuthToken) {
		_linkedinAuthToken = linkedinAuthToken;
	}

	public String getYahooAuthToken() {
		return _yahooAuthToken;
	}

	public void setYahooAuthToken(String yahooAuthToken) {
		_yahooAuthToken = yahooAuthToken;
	}

	public String getGoogleAuthToken() {
		return _googleAuthToken;
	}

	public void setGoogleAuthToken(String googleAuthToken) {
		_googleAuthToken = googleAuthToken;
	}

	public String getFacebookAuthSecret() {
		return _facebookAuthSecret;
	}

	public void setFacebookAuthSecret(String facebookAuthSecret) {
		_facebookAuthSecret = facebookAuthSecret;
	}

	public String getOpenIdAuthSecret() {
		return _openIdAuthSecret;
	}

	public void setOpenIdAuthSecret(String openIdAuthSecret) {
		_openIdAuthSecret = openIdAuthSecret;
	}

	public String getTwitterAuthSecret() {
		return _twitterAuthSecret;
	}

	public void setTwitterAuthSecret(String twitterAuthSecret) {
		_twitterAuthSecret = twitterAuthSecret;
	}

	public String getLinkedinAuthSecret() {
		return _linkedinAuthSecret;
	}

	public void setLinkedinAuthSecret(String linkedinAuthSecret) {
		_linkedinAuthSecret = linkedinAuthSecret;
	}

	public String getYahooAuthSecret() {
		return _yahooAuthSecret;
	}

	public void setYahooAuthSecret(String yahooAuthSecret) {
		_yahooAuthSecret = yahooAuthSecret;
	}

	public String getGoogleAuthSecret() {
		return _googleAuthSecret;
	}

	public void setGoogleAuthSecret(String googleAuthSecret) {
		_googleAuthSecret = googleAuthSecret;
	}

	public int getLoginCount() {
		return _loginCount;
	}

	public void setLoginCount(int loginCount) {
		_loginCount = loginCount;
	}

	public int getUpdateInterestsStatus() {
		return _updateInterestsStatus;
	}

	public void setUpdateInterestsStatus(int updateInterestsStatus) {
		_updateInterestsStatus = updateInterestsStatus;
	}

	private String _uuid;
	private long _userId;
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
}