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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.StagedModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SocialProfile service. Represents a row in the &quot;SPSocialProfile&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileImpl}.
 * </p>
 *
 * @author gauravvijayvergia
 * @see SocialProfile
 * @see com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileImpl
 * @see com.sambaash.platform.srv.spsocialprofile.model.impl.SocialProfileModelImpl
 * @generated
 */
public interface SocialProfileModel extends BaseModel<SocialProfile>, StagedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a social profile model instance should use the {@link SocialProfile} interface instead.
	 */

	/**
	 * Returns the primary key of this social profile.
	 *
	 * @return the primary key of this social profile
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this social profile.
	 *
	 * @param primaryKey the primary key of this social profile
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the uuid of this social profile.
	 *
	 * @return the uuid of this social profile
	 */
	@AutoEscape
	@Override
	public String getUuid();

	/**
	 * Sets the uuid of this social profile.
	 *
	 * @param uuid the uuid of this social profile
	 */
	@Override
	public void setUuid(String uuid);

	/**
	 * Returns the user ID of this social profile.
	 *
	 * @return the user ID of this social profile
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this social profile.
	 *
	 * @param userId the user ID of this social profile
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this social profile.
	 *
	 * @return the user uuid of this social profile
	 * @throws SystemException if a system exception occurred
	 */
	public String getUserUuid() throws SystemException;

	/**
	 * Sets the user uuid of this social profile.
	 *
	 * @param userUuid the user uuid of this social profile
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the group ID of this social profile.
	 *
	 * @return the group ID of this social profile
	 */
	public long getGroupId();

	/**
	 * Sets the group ID of this social profile.
	 *
	 * @param groupId the group ID of this social profile
	 */
	public void setGroupId(long groupId);

	/**
	 * Returns the company ID of this social profile.
	 *
	 * @return the company ID of this social profile
	 */
	@Override
	public long getCompanyId();

	/**
	 * Sets the company ID of this social profile.
	 *
	 * @param companyId the company ID of this social profile
	 */
	@Override
	public void setCompanyId(long companyId);

	/**
	 * Returns the create date of this social profile.
	 *
	 * @return the create date of this social profile
	 */
	@Override
	public Date getCreateDate();

	/**
	 * Sets the create date of this social profile.
	 *
	 * @param createDate the create date of this social profile
	 */
	@Override
	public void setCreateDate(Date createDate);

	/**
	 * Returns the modified date of this social profile.
	 *
	 * @return the modified date of this social profile
	 */
	@Override
	public Date getModifiedDate();

	/**
	 * Sets the modified date of this social profile.
	 *
	 * @param modifiedDate the modified date of this social profile
	 */
	@Override
	public void setModifiedDate(Date modifiedDate);

	/**
	 * Returns the user type of this social profile.
	 *
	 * @return the user type of this social profile
	 */
	@AutoEscape
	public String getUserType();

	/**
	 * Sets the user type of this social profile.
	 *
	 * @param userType the user type of this social profile
	 */
	public void setUserType(String userType);

	/**
	 * Returns the member package of this social profile.
	 *
	 * @return the member package of this social profile
	 */
	public long getMemberPackage();

	/**
	 * Sets the member package of this social profile.
	 *
	 * @param memberPackage the member package of this social profile
	 */
	public void setMemberPackage(long memberPackage);

	/**
	 * Returns the user registration status of this social profile.
	 *
	 * @return the user registration status of this social profile
	 */
	@AutoEscape
	public String getUserRegistrationStatus();

	/**
	 * Sets the user registration status of this social profile.
	 *
	 * @param userRegistrationStatus the user registration status of this social profile
	 */
	public void setUserRegistrationStatus(String userRegistrationStatus);

	/**
	 * Returns the class p k of this social profile.
	 *
	 * @return the class p k of this social profile
	 */
	public long getClassPK();

	/**
	 * Sets the class p k of this social profile.
	 *
	 * @param classPK the class p k of this social profile
	 */
	public void setClassPK(long classPK);

	/**
	 * Returns the location of this social profile.
	 *
	 * @return the location of this social profile
	 */
	@AutoEscape
	public String getLocation();

	/**
	 * Sets the location of this social profile.
	 *
	 * @param location the location of this social profile
	 */
	public void setLocation(String location);

	/**
	 * Returns the profile view count of this social profile.
	 *
	 * @return the profile view count of this social profile
	 */
	public int getProfileViewCount();

	/**
	 * Sets the profile view count of this social profile.
	 *
	 * @param profileViewCount the profile view count of this social profile
	 */
	public void setProfileViewCount(int profileViewCount);

	/**
	 * Returns the interest of this social profile.
	 *
	 * @return the interest of this social profile
	 */
	@AutoEscape
	public String getInterest();

	/**
	 * Sets the interest of this social profile.
	 *
	 * @param interest the interest of this social profile
	 */
	public void setInterest(String interest);

	/**
	 * Returns the honors of this social profile.
	 *
	 * @return the honors of this social profile
	 */
	@AutoEscape
	public String getHonors();

	/**
	 * Sets the honors of this social profile.
	 *
	 * @param honors the honors of this social profile
	 */
	public void setHonors(String honors);

	/**
	 * Returns the group association of this social profile.
	 *
	 * @return the group association of this social profile
	 */
	@AutoEscape
	public String getGroupAssociation();

	/**
	 * Sets the group association of this social profile.
	 *
	 * @param groupAssociation the group association of this social profile
	 */
	public void setGroupAssociation(String groupAssociation);

	/**
	 * Returns the skills qualification of this social profile.
	 *
	 * @return the skills qualification of this social profile
	 */
	@AutoEscape
	public String getSkillsQualification();

	/**
	 * Sets the skills qualification of this social profile.
	 *
	 * @param skillsQualification the skills qualification of this social profile
	 */
	public void setSkillsQualification(String skillsQualification);

	/**
	 * Returns the title of this social profile.
	 *
	 * @return the title of this social profile
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this social profile.
	 *
	 * @param title the title of this social profile
	 */
	public void setTitle(String title);

	/**
	 * Returns the training education of this social profile.
	 *
	 * @return the training education of this social profile
	 */
	@AutoEscape
	public String getTrainingEducation();

	/**
	 * Sets the training education of this social profile.
	 *
	 * @param trainingEducation the training education of this social profile
	 */
	public void setTrainingEducation(String trainingEducation);

	/**
	 * Returns the about of this social profile.
	 *
	 * @return the about of this social profile
	 */
	@AutoEscape
	public String getAbout();

	/**
	 * Sets the about of this social profile.
	 *
	 * @param about the about of this social profile
	 */
	public void setAbout(String about);

	/**
	 * Returns the document ID of this social profile.
	 *
	 * @return the document ID of this social profile
	 */
	public long getDocumentId();

	/**
	 * Sets the document ID of this social profile.
	 *
	 * @param documentId the document ID of this social profile
	 */
	public void setDocumentId(long documentId);

	/**
	 * Returns the user info of this social profile.
	 *
	 * @return the user info of this social profile
	 */
	@AutoEscape
	public String getUserInfo();

	/**
	 * Sets the user info of this social profile.
	 *
	 * @param userInfo the user info of this social profile
	 */
	public void setUserInfo(String userInfo);

	/**
	 * Returns the status of this social profile.
	 *
	 * @return the status of this social profile
	 */
	public int getStatus();

	/**
	 * Sets the status of this social profile.
	 *
	 * @param status the status of this social profile
	 */
	public void setStatus(int status);

	/**
	 * Returns the twitter ID of this social profile.
	 *
	 * @return the twitter ID of this social profile
	 */
	@AutoEscape
	public String getTwitterId();

	/**
	 * Sets the twitter ID of this social profile.
	 *
	 * @param twitterId the twitter ID of this social profile
	 */
	public void setTwitterId(String twitterId);

	/**
	 * Returns the linkedin ID of this social profile.
	 *
	 * @return the linkedin ID of this social profile
	 */
	@AutoEscape
	public String getLinkedinId();

	/**
	 * Sets the linkedin ID of this social profile.
	 *
	 * @param linkedinId the linkedin ID of this social profile
	 */
	public void setLinkedinId(String linkedinId);

	/**
	 * Returns the yahoo ID of this social profile.
	 *
	 * @return the yahoo ID of this social profile
	 */
	@AutoEscape
	public String getYahooId();

	/**
	 * Sets the yahoo ID of this social profile.
	 *
	 * @param yahooId the yahoo ID of this social profile
	 */
	public void setYahooId(String yahooId);

	/**
	 * Returns the google ID of this social profile.
	 *
	 * @return the google ID of this social profile
	 */
	@AutoEscape
	public String getGoogleId();

	/**
	 * Sets the google ID of this social profile.
	 *
	 * @param googleId the google ID of this social profile
	 */
	public void setGoogleId(String googleId);

	/**
	 * Returns the facebook auth token of this social profile.
	 *
	 * @return the facebook auth token of this social profile
	 */
	@AutoEscape
	public String getFacebookAuthToken();

	/**
	 * Sets the facebook auth token of this social profile.
	 *
	 * @param facebookAuthToken the facebook auth token of this social profile
	 */
	public void setFacebookAuthToken(String facebookAuthToken);

	/**
	 * Returns the open ID auth token of this social profile.
	 *
	 * @return the open ID auth token of this social profile
	 */
	@AutoEscape
	public String getOpenIdAuthToken();

	/**
	 * Sets the open ID auth token of this social profile.
	 *
	 * @param openIdAuthToken the open ID auth token of this social profile
	 */
	public void setOpenIdAuthToken(String openIdAuthToken);

	/**
	 * Returns the twitter auth token of this social profile.
	 *
	 * @return the twitter auth token of this social profile
	 */
	@AutoEscape
	public String getTwitterAuthToken();

	/**
	 * Sets the twitter auth token of this social profile.
	 *
	 * @param twitterAuthToken the twitter auth token of this social profile
	 */
	public void setTwitterAuthToken(String twitterAuthToken);

	/**
	 * Returns the linkedin auth token of this social profile.
	 *
	 * @return the linkedin auth token of this social profile
	 */
	@AutoEscape
	public String getLinkedinAuthToken();

	/**
	 * Sets the linkedin auth token of this social profile.
	 *
	 * @param linkedinAuthToken the linkedin auth token of this social profile
	 */
	public void setLinkedinAuthToken(String linkedinAuthToken);

	/**
	 * Returns the yahoo auth token of this social profile.
	 *
	 * @return the yahoo auth token of this social profile
	 */
	@AutoEscape
	public String getYahooAuthToken();

	/**
	 * Sets the yahoo auth token of this social profile.
	 *
	 * @param yahooAuthToken the yahoo auth token of this social profile
	 */
	public void setYahooAuthToken(String yahooAuthToken);

	/**
	 * Returns the google auth token of this social profile.
	 *
	 * @return the google auth token of this social profile
	 */
	@AutoEscape
	public String getGoogleAuthToken();

	/**
	 * Sets the google auth token of this social profile.
	 *
	 * @param googleAuthToken the google auth token of this social profile
	 */
	public void setGoogleAuthToken(String googleAuthToken);

	/**
	 * Returns the facebook auth secret of this social profile.
	 *
	 * @return the facebook auth secret of this social profile
	 */
	@AutoEscape
	public String getFacebookAuthSecret();

	/**
	 * Sets the facebook auth secret of this social profile.
	 *
	 * @param facebookAuthSecret the facebook auth secret of this social profile
	 */
	public void setFacebookAuthSecret(String facebookAuthSecret);

	/**
	 * Returns the open ID auth secret of this social profile.
	 *
	 * @return the open ID auth secret of this social profile
	 */
	@AutoEscape
	public String getOpenIdAuthSecret();

	/**
	 * Sets the open ID auth secret of this social profile.
	 *
	 * @param openIdAuthSecret the open ID auth secret of this social profile
	 */
	public void setOpenIdAuthSecret(String openIdAuthSecret);

	/**
	 * Returns the twitter auth secret of this social profile.
	 *
	 * @return the twitter auth secret of this social profile
	 */
	@AutoEscape
	public String getTwitterAuthSecret();

	/**
	 * Sets the twitter auth secret of this social profile.
	 *
	 * @param twitterAuthSecret the twitter auth secret of this social profile
	 */
	public void setTwitterAuthSecret(String twitterAuthSecret);

	/**
	 * Returns the linkedin auth secret of this social profile.
	 *
	 * @return the linkedin auth secret of this social profile
	 */
	@AutoEscape
	public String getLinkedinAuthSecret();

	/**
	 * Sets the linkedin auth secret of this social profile.
	 *
	 * @param linkedinAuthSecret the linkedin auth secret of this social profile
	 */
	public void setLinkedinAuthSecret(String linkedinAuthSecret);

	/**
	 * Returns the yahoo auth secret of this social profile.
	 *
	 * @return the yahoo auth secret of this social profile
	 */
	@AutoEscape
	public String getYahooAuthSecret();

	/**
	 * Sets the yahoo auth secret of this social profile.
	 *
	 * @param yahooAuthSecret the yahoo auth secret of this social profile
	 */
	public void setYahooAuthSecret(String yahooAuthSecret);

	/**
	 * Returns the google auth secret of this social profile.
	 *
	 * @return the google auth secret of this social profile
	 */
	@AutoEscape
	public String getGoogleAuthSecret();

	/**
	 * Sets the google auth secret of this social profile.
	 *
	 * @param googleAuthSecret the google auth secret of this social profile
	 */
	public void setGoogleAuthSecret(String googleAuthSecret);

	/**
	 * Returns the login count of this social profile.
	 *
	 * @return the login count of this social profile
	 */
	public int getLoginCount();

	/**
	 * Sets the login count of this social profile.
	 *
	 * @param loginCount the login count of this social profile
	 */
	public void setLoginCount(int loginCount);

	/**
	 * Returns the update interests status of this social profile.
	 *
	 * @return the update interests status of this social profile
	 */
	public int getUpdateInterestsStatus();

	/**
	 * Sets the update interests status of this social profile.
	 *
	 * @param updateInterestsStatus the update interests status of this social profile
	 */
	public void setUpdateInterestsStatus(int updateInterestsStatus);

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
		com.sambaash.platform.srv.spsocialprofile.model.SocialProfile socialProfile);

	@Override
	public int hashCode();

	@Override
	public CacheModel<com.sambaash.platform.srv.spsocialprofile.model.SocialProfile> toCacheModel();

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile toEscapedModel();

	@Override
	public com.sambaash.platform.srv.spsocialprofile.model.SocialProfile toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}