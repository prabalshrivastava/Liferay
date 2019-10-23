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

package com.sambaash.platform.srv.spsocialprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.spsocialprofile.model.SocialProfile;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing SocialProfile in entity cache.
 *
 * @author gauravvijayvergia
 * @see SocialProfile
 * @generated
 */
public class SocialProfileCacheModel implements CacheModel<SocialProfile>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(81);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", userType=");
		sb.append(userType);
		sb.append(", memberPackage=");
		sb.append(memberPackage);
		sb.append(", userRegistrationStatus=");
		sb.append(userRegistrationStatus);
		sb.append(", classPK=");
		sb.append(classPK);
		sb.append(", location=");
		sb.append(location);
		sb.append(", profileViewCount=");
		sb.append(profileViewCount);
		sb.append(", interest=");
		sb.append(interest);
		sb.append(", honors=");
		sb.append(honors);
		sb.append(", groupAssociation=");
		sb.append(groupAssociation);
		sb.append(", skillsQualification=");
		sb.append(skillsQualification);
		sb.append(", title=");
		sb.append(title);
		sb.append(", trainingEducation=");
		sb.append(trainingEducation);
		sb.append(", about=");
		sb.append(about);
		sb.append(", documentId=");
		sb.append(documentId);
		sb.append(", userInfo=");
		sb.append(userInfo);
		sb.append(", status=");
		sb.append(status);
		sb.append(", twitterId=");
		sb.append(twitterId);
		sb.append(", linkedinId=");
		sb.append(linkedinId);
		sb.append(", yahooId=");
		sb.append(yahooId);
		sb.append(", googleId=");
		sb.append(googleId);
		sb.append(", facebookAuthToken=");
		sb.append(facebookAuthToken);
		sb.append(", openIdAuthToken=");
		sb.append(openIdAuthToken);
		sb.append(", twitterAuthToken=");
		sb.append(twitterAuthToken);
		sb.append(", linkedinAuthToken=");
		sb.append(linkedinAuthToken);
		sb.append(", yahooAuthToken=");
		sb.append(yahooAuthToken);
		sb.append(", googleAuthToken=");
		sb.append(googleAuthToken);
		sb.append(", facebookAuthSecret=");
		sb.append(facebookAuthSecret);
		sb.append(", openIdAuthSecret=");
		sb.append(openIdAuthSecret);
		sb.append(", twitterAuthSecret=");
		sb.append(twitterAuthSecret);
		sb.append(", linkedinAuthSecret=");
		sb.append(linkedinAuthSecret);
		sb.append(", yahooAuthSecret=");
		sb.append(yahooAuthSecret);
		sb.append(", googleAuthSecret=");
		sb.append(googleAuthSecret);
		sb.append(", loginCount=");
		sb.append(loginCount);
		sb.append(", updateInterestsStatus=");
		sb.append(updateInterestsStatus);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public SocialProfile toEntityModel() {
		SocialProfileImpl socialProfileImpl = new SocialProfileImpl();

		if (uuid == null) {
			socialProfileImpl.setUuid(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setUuid(uuid);
		}

		socialProfileImpl.setUserId(userId);
		socialProfileImpl.setGroupId(groupId);
		socialProfileImpl.setCompanyId(companyId);

		if (createDate == Long.MIN_VALUE) {
			socialProfileImpl.setCreateDate(null);
		}
		else {
			socialProfileImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			socialProfileImpl.setModifiedDate(null);
		}
		else {
			socialProfileImpl.setModifiedDate(new Date(modifiedDate));
		}

		if (userType == null) {
			socialProfileImpl.setUserType(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setUserType(userType);
		}

		socialProfileImpl.setMemberPackage(memberPackage);

		if (userRegistrationStatus == null) {
			socialProfileImpl.setUserRegistrationStatus(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setUserRegistrationStatus(userRegistrationStatus);
		}

		socialProfileImpl.setClassPK(classPK);

		if (location == null) {
			socialProfileImpl.setLocation(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setLocation(location);
		}

		socialProfileImpl.setProfileViewCount(profileViewCount);

		if (interest == null) {
			socialProfileImpl.setInterest(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setInterest(interest);
		}

		if (honors == null) {
			socialProfileImpl.setHonors(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setHonors(honors);
		}

		if (groupAssociation == null) {
			socialProfileImpl.setGroupAssociation(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setGroupAssociation(groupAssociation);
		}

		if (skillsQualification == null) {
			socialProfileImpl.setSkillsQualification(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setSkillsQualification(skillsQualification);
		}

		if (title == null) {
			socialProfileImpl.setTitle(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setTitle(title);
		}

		if (trainingEducation == null) {
			socialProfileImpl.setTrainingEducation(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setTrainingEducation(trainingEducation);
		}

		if (about == null) {
			socialProfileImpl.setAbout(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setAbout(about);
		}

		socialProfileImpl.setDocumentId(documentId);

		if (userInfo == null) {
			socialProfileImpl.setUserInfo(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setUserInfo(userInfo);
		}

		socialProfileImpl.setStatus(status);

		if (twitterId == null) {
			socialProfileImpl.setTwitterId(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setTwitterId(twitterId);
		}

		if (linkedinId == null) {
			socialProfileImpl.setLinkedinId(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setLinkedinId(linkedinId);
		}

		if (yahooId == null) {
			socialProfileImpl.setYahooId(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setYahooId(yahooId);
		}

		if (googleId == null) {
			socialProfileImpl.setGoogleId(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setGoogleId(googleId);
		}

		if (facebookAuthToken == null) {
			socialProfileImpl.setFacebookAuthToken(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setFacebookAuthToken(facebookAuthToken);
		}

		if (openIdAuthToken == null) {
			socialProfileImpl.setOpenIdAuthToken(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setOpenIdAuthToken(openIdAuthToken);
		}

		if (twitterAuthToken == null) {
			socialProfileImpl.setTwitterAuthToken(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setTwitterAuthToken(twitterAuthToken);
		}

		if (linkedinAuthToken == null) {
			socialProfileImpl.setLinkedinAuthToken(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setLinkedinAuthToken(linkedinAuthToken);
		}

		if (yahooAuthToken == null) {
			socialProfileImpl.setYahooAuthToken(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setYahooAuthToken(yahooAuthToken);
		}

		if (googleAuthToken == null) {
			socialProfileImpl.setGoogleAuthToken(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setGoogleAuthToken(googleAuthToken);
		}

		if (facebookAuthSecret == null) {
			socialProfileImpl.setFacebookAuthSecret(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setFacebookAuthSecret(facebookAuthSecret);
		}

		if (openIdAuthSecret == null) {
			socialProfileImpl.setOpenIdAuthSecret(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setOpenIdAuthSecret(openIdAuthSecret);
		}

		if (twitterAuthSecret == null) {
			socialProfileImpl.setTwitterAuthSecret(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setTwitterAuthSecret(twitterAuthSecret);
		}

		if (linkedinAuthSecret == null) {
			socialProfileImpl.setLinkedinAuthSecret(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setLinkedinAuthSecret(linkedinAuthSecret);
		}

		if (yahooAuthSecret == null) {
			socialProfileImpl.setYahooAuthSecret(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setYahooAuthSecret(yahooAuthSecret);
		}

		if (googleAuthSecret == null) {
			socialProfileImpl.setGoogleAuthSecret(StringPool.BLANK);
		}
		else {
			socialProfileImpl.setGoogleAuthSecret(googleAuthSecret);
		}

		socialProfileImpl.setLoginCount(loginCount);
		socialProfileImpl.setUpdateInterestsStatus(updateInterestsStatus);

		socialProfileImpl.resetOriginalValues();

		return socialProfileImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		userId = objectInput.readLong();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		userType = objectInput.readUTF();
		memberPackage = objectInput.readLong();
		userRegistrationStatus = objectInput.readUTF();
		classPK = objectInput.readLong();
		location = objectInput.readUTF();
		profileViewCount = objectInput.readInt();
		interest = objectInput.readUTF();
		honors = objectInput.readUTF();
		groupAssociation = objectInput.readUTF();
		skillsQualification = objectInput.readUTF();
		title = objectInput.readUTF();
		trainingEducation = objectInput.readUTF();
		about = objectInput.readUTF();
		documentId = objectInput.readLong();
		userInfo = objectInput.readUTF();
		status = objectInput.readInt();
		twitterId = objectInput.readUTF();
		linkedinId = objectInput.readUTF();
		yahooId = objectInput.readUTF();
		googleId = objectInput.readUTF();
		facebookAuthToken = objectInput.readUTF();
		openIdAuthToken = objectInput.readUTF();
		twitterAuthToken = objectInput.readUTF();
		linkedinAuthToken = objectInput.readUTF();
		yahooAuthToken = objectInput.readUTF();
		googleAuthToken = objectInput.readUTF();
		facebookAuthSecret = objectInput.readUTF();
		openIdAuthSecret = objectInput.readUTF();
		twitterAuthSecret = objectInput.readUTF();
		linkedinAuthSecret = objectInput.readUTF();
		yahooAuthSecret = objectInput.readUTF();
		googleAuthSecret = objectInput.readUTF();
		loginCount = objectInput.readInt();
		updateInterestsStatus = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(userId);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		if (userType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userType);
		}

		objectOutput.writeLong(memberPackage);

		if (userRegistrationStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userRegistrationStatus);
		}

		objectOutput.writeLong(classPK);

		if (location == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(location);
		}

		objectOutput.writeInt(profileViewCount);

		if (interest == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(interest);
		}

		if (honors == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(honors);
		}

		if (groupAssociation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(groupAssociation);
		}

		if (skillsQualification == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(skillsQualification);
		}

		if (title == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(title);
		}

		if (trainingEducation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(trainingEducation);
		}

		if (about == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(about);
		}

		objectOutput.writeLong(documentId);

		if (userInfo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userInfo);
		}

		objectOutput.writeInt(status);

		if (twitterId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(twitterId);
		}

		if (linkedinId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkedinId);
		}

		if (yahooId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yahooId);
		}

		if (googleId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(googleId);
		}

		if (facebookAuthToken == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(facebookAuthToken);
		}

		if (openIdAuthToken == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(openIdAuthToken);
		}

		if (twitterAuthToken == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(twitterAuthToken);
		}

		if (linkedinAuthToken == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkedinAuthToken);
		}

		if (yahooAuthToken == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yahooAuthToken);
		}

		if (googleAuthToken == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(googleAuthToken);
		}

		if (facebookAuthSecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(facebookAuthSecret);
		}

		if (openIdAuthSecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(openIdAuthSecret);
		}

		if (twitterAuthSecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(twitterAuthSecret);
		}

		if (linkedinAuthSecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkedinAuthSecret);
		}

		if (yahooAuthSecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(yahooAuthSecret);
		}

		if (googleAuthSecret == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(googleAuthSecret);
		}

		objectOutput.writeInt(loginCount);
		objectOutput.writeInt(updateInterestsStatus);
	}

	public String uuid;
	public long userId;
	public long groupId;
	public long companyId;
	public long createDate;
	public long modifiedDate;
	public String userType;
	public long memberPackage;
	public String userRegistrationStatus;
	public long classPK;
	public String location;
	public int profileViewCount;
	public String interest;
	public String honors;
	public String groupAssociation;
	public String skillsQualification;
	public String title;
	public String trainingEducation;
	public String about;
	public long documentId;
	public String userInfo;
	public int status;
	public String twitterId;
	public String linkedinId;
	public String yahooId;
	public String googleId;
	public String facebookAuthToken;
	public String openIdAuthToken;
	public String twitterAuthToken;
	public String linkedinAuthToken;
	public String yahooAuthToken;
	public String googleAuthToken;
	public String facebookAuthSecret;
	public String openIdAuthSecret;
	public String twitterAuthSecret;
	public String linkedinAuthSecret;
	public String yahooAuthSecret;
	public String googleAuthSecret;
	public int loginCount;
	public int updateInterestsStatus;
}