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

package com.sambaash.platform.srv.startupprofile.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.sambaash.platform.srv.startupprofile.model.Organization;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Organization in entity cache.
 *
 * @author pradeep
 * @see Organization
 * @generated
 */
public class OrganizationCacheModel implements CacheModel<Organization>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(121);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", organizationId=");
		sb.append(organizationId);
		sb.append(", name=");
		sb.append(name);
		sb.append(", corporateCode=");
		sb.append(corporateCode);
		sb.append(", corporateType=");
		sb.append(corporateType);
		sb.append(", corporateCategory=");
		sb.append(corporateCategory);
		sb.append(", apiPath=");
		sb.append(apiPath);
		sb.append(", categories=");
		sb.append(categories);
		sb.append(", foundedOn=");
		sb.append(foundedOn);
		sb.append(", noOfEmployees=");
		sb.append(noOfEmployees);
		sb.append(", emailId=");
		sb.append(emailId);
		sb.append(", website=");
		sb.append(website);
		sb.append(", facebook=");
		sb.append(facebook);
		sb.append(", twitter=");
		sb.append(twitter);
		sb.append(", linkedIn=");
		sb.append(linkedIn);
		sb.append(", crunchbase=");
		sb.append(crunchbase);
		sb.append(", mobile=");
		sb.append(mobile);
		sb.append(", totalFunds=");
		sb.append(totalFunds);
		sb.append(", uen=");
		sb.append(uen);
		sb.append(", description=");
		sb.append(description);
		sb.append(", shortPitch=");
		sb.append(shortPitch);
		sb.append(", lifecycleStage=");
		sb.append(lifecycleStage);
		sb.append(", capitalRaised=");
		sb.append(capitalRaised);
		sb.append(", isIncorporated=");
		sb.append(isIncorporated);
		sb.append(", stockSymbol=");
		sb.append(stockSymbol);
		sb.append(", imageUrl=");
		sb.append(imageUrl);
		sb.append(", videos=");
		sb.append(videos);
		sb.append(", profileOutline=");
		sb.append(profileOutline);
		sb.append(", raisingFunds=");
		sb.append(raisingFunds);
		sb.append(", extras=");
		sb.append(extras);
		sb.append(", uniqueDesc=");
		sb.append(uniqueDesc);
		sb.append(", links=");
		sb.append(links);
		sb.append(", isBaseOrg=");
		sb.append(isBaseOrg);
		sb.append(", completeness=");
		sb.append(completeness);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", active=");
		sb.append(active);
		sb.append(", logoId=");
		sb.append(logoId);
		sb.append(", methodologyType=");
		sb.append(methodologyType);
		sb.append(", methodologySubType=");
		sb.append(methodologySubType);
		sb.append(", stage=");
		sb.append(stage);
		sb.append(", feedback=");
		sb.append(feedback);
		sb.append(", videoLinks=");
		sb.append(videoLinks);
		sb.append(", projectsWorkedOn=");
		sb.append(projectsWorkedOn);
		sb.append(", showInBlackbook=");
		sb.append(showInBlackbook);
		sb.append(", faxNumber=");
		sb.append(faxNumber);
		sb.append(", contactName=");
		sb.append(contactName);
		sb.append(", contactDesignation=");
		sb.append(contactDesignation);
		sb.append(", pipelineStatus=");
		sb.append(pipelineStatus);
		sb.append(", businessDevManager=");
		sb.append(businessDevManager);
		sb.append(", prevBusinessDevManager=");
		sb.append(prevBusinessDevManager);
		sb.append(", isATO=");
		sb.append(isATO);
		sb.append(", approvalDate=");
		sb.append(approvalDate);
		sb.append(", status=");
		sb.append(status);
		sb.append(", listedCo=");
		sb.append(listedCo);
		sb.append(", noOfPotentialCandidates=");
		sb.append(noOfPotentialCandidates);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Organization toEntityModel() {
		OrganizationImpl organizationImpl = new OrganizationImpl();

		if (uuid == null) {
			organizationImpl.setUuid(StringPool.BLANK);
		}
		else {
			organizationImpl.setUuid(uuid);
		}

		organizationImpl.setOrganizationId(organizationId);

		if (name == null) {
			organizationImpl.setName(StringPool.BLANK);
		}
		else {
			organizationImpl.setName(name);
		}

		if (corporateCode == null) {
			organizationImpl.setCorporateCode(StringPool.BLANK);
		}
		else {
			organizationImpl.setCorporateCode(corporateCode);
		}

		if (corporateType == null) {
			organizationImpl.setCorporateType(StringPool.BLANK);
		}
		else {
			organizationImpl.setCorporateType(corporateType);
		}

		if (corporateCategory == null) {
			organizationImpl.setCorporateCategory(StringPool.BLANK);
		}
		else {
			organizationImpl.setCorporateCategory(corporateCategory);
		}

		if (apiPath == null) {
			organizationImpl.setApiPath(StringPool.BLANK);
		}
		else {
			organizationImpl.setApiPath(apiPath);
		}

		if (categories == null) {
			organizationImpl.setCategories(StringPool.BLANK);
		}
		else {
			organizationImpl.setCategories(categories);
		}

		if (foundedOn == null) {
			organizationImpl.setFoundedOn(StringPool.BLANK);
		}
		else {
			organizationImpl.setFoundedOn(foundedOn);
		}

		organizationImpl.setNoOfEmployees(noOfEmployees);

		if (emailId == null) {
			organizationImpl.setEmailId(StringPool.BLANK);
		}
		else {
			organizationImpl.setEmailId(emailId);
		}

		if (website == null) {
			organizationImpl.setWebsite(StringPool.BLANK);
		}
		else {
			organizationImpl.setWebsite(website);
		}

		if (facebook == null) {
			organizationImpl.setFacebook(StringPool.BLANK);
		}
		else {
			organizationImpl.setFacebook(facebook);
		}

		if (twitter == null) {
			organizationImpl.setTwitter(StringPool.BLANK);
		}
		else {
			organizationImpl.setTwitter(twitter);
		}

		if (linkedIn == null) {
			organizationImpl.setLinkedIn(StringPool.BLANK);
		}
		else {
			organizationImpl.setLinkedIn(linkedIn);
		}

		if (crunchbase == null) {
			organizationImpl.setCrunchbase(StringPool.BLANK);
		}
		else {
			organizationImpl.setCrunchbase(crunchbase);
		}

		if (mobile == null) {
			organizationImpl.setMobile(StringPool.BLANK);
		}
		else {
			organizationImpl.setMobile(mobile);
		}

		if (totalFunds == null) {
			organizationImpl.setTotalFunds(StringPool.BLANK);
		}
		else {
			organizationImpl.setTotalFunds(totalFunds);
		}

		if (uen == null) {
			organizationImpl.setUen(StringPool.BLANK);
		}
		else {
			organizationImpl.setUen(uen);
		}

		if (description == null) {
			organizationImpl.setDescription(StringPool.BLANK);
		}
		else {
			organizationImpl.setDescription(description);
		}

		if (shortPitch == null) {
			organizationImpl.setShortPitch(StringPool.BLANK);
		}
		else {
			organizationImpl.setShortPitch(shortPitch);
		}

		if (lifecycleStage == null) {
			organizationImpl.setLifecycleStage(StringPool.BLANK);
		}
		else {
			organizationImpl.setLifecycleStage(lifecycleStage);
		}

		if (capitalRaised == null) {
			organizationImpl.setCapitalRaised(StringPool.BLANK);
		}
		else {
			organizationImpl.setCapitalRaised(capitalRaised);
		}

		organizationImpl.setIsIncorporated(isIncorporated);

		if (stockSymbol == null) {
			organizationImpl.setStockSymbol(StringPool.BLANK);
		}
		else {
			organizationImpl.setStockSymbol(stockSymbol);
		}

		if (imageUrl == null) {
			organizationImpl.setImageUrl(StringPool.BLANK);
		}
		else {
			organizationImpl.setImageUrl(imageUrl);
		}

		if (videos == null) {
			organizationImpl.setVideos(StringPool.BLANK);
		}
		else {
			organizationImpl.setVideos(videos);
		}

		if (profileOutline == null) {
			organizationImpl.setProfileOutline(StringPool.BLANK);
		}
		else {
			organizationImpl.setProfileOutline(profileOutline);
		}

		if (raisingFunds == null) {
			organizationImpl.setRaisingFunds(StringPool.BLANK);
		}
		else {
			organizationImpl.setRaisingFunds(raisingFunds);
		}

		if (extras == null) {
			organizationImpl.setExtras(StringPool.BLANK);
		}
		else {
			organizationImpl.setExtras(extras);
		}

		if (uniqueDesc == null) {
			organizationImpl.setUniqueDesc(StringPool.BLANK);
		}
		else {
			organizationImpl.setUniqueDesc(uniqueDesc);
		}

		if (links == null) {
			organizationImpl.setLinks(StringPool.BLANK);
		}
		else {
			organizationImpl.setLinks(links);
		}

		organizationImpl.setIsBaseOrg(isBaseOrg);
		organizationImpl.setCompleteness(completeness);
		organizationImpl.setGroupId(groupId);
		organizationImpl.setCompanyId(companyId);
		organizationImpl.setUserId(userId);

		if (userName == null) {
			organizationImpl.setUserName(StringPool.BLANK);
		}
		else {
			organizationImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			organizationImpl.setCreateDate(null);
		}
		else {
			organizationImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			organizationImpl.setModifiedDate(null);
		}
		else {
			organizationImpl.setModifiedDate(new Date(modifiedDate));
		}

		organizationImpl.setActive(active);
		organizationImpl.setLogoId(logoId);
		organizationImpl.setMethodologyType(methodologyType);
		organizationImpl.setMethodologySubType(methodologySubType);
		organizationImpl.setStage(stage);

		if (feedback == null) {
			organizationImpl.setFeedback(StringPool.BLANK);
		}
		else {
			organizationImpl.setFeedback(feedback);
		}

		if (videoLinks == null) {
			organizationImpl.setVideoLinks(StringPool.BLANK);
		}
		else {
			organizationImpl.setVideoLinks(videoLinks);
		}

		if (projectsWorkedOn == null) {
			organizationImpl.setProjectsWorkedOn(StringPool.BLANK);
		}
		else {
			organizationImpl.setProjectsWorkedOn(projectsWorkedOn);
		}

		organizationImpl.setShowInBlackbook(showInBlackbook);

		if (faxNumber == null) {
			organizationImpl.setFaxNumber(StringPool.BLANK);
		}
		else {
			organizationImpl.setFaxNumber(faxNumber);
		}

		if (contactName == null) {
			organizationImpl.setContactName(StringPool.BLANK);
		}
		else {
			organizationImpl.setContactName(contactName);
		}

		if (contactDesignation == null) {
			organizationImpl.setContactDesignation(StringPool.BLANK);
		}
		else {
			organizationImpl.setContactDesignation(contactDesignation);
		}

		organizationImpl.setPipelineStatus(pipelineStatus);
		organizationImpl.setBusinessDevManager(businessDevManager);
		organizationImpl.setPrevBusinessDevManager(prevBusinessDevManager);
		organizationImpl.setIsATO(isATO);

		if (approvalDate == Long.MIN_VALUE) {
			organizationImpl.setApprovalDate(null);
		}
		else {
			organizationImpl.setApprovalDate(new Date(approvalDate));
		}

		organizationImpl.setStatus(status);

		if (listedCo == null) {
			organizationImpl.setListedCo(StringPool.BLANK);
		}
		else {
			organizationImpl.setListedCo(listedCo);
		}

		organizationImpl.setNoOfPotentialCandidates(noOfPotentialCandidates);

		organizationImpl.resetOriginalValues();

		return organizationImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();
		organizationId = objectInput.readLong();
		name = objectInput.readUTF();
		corporateCode = objectInput.readUTF();
		corporateType = objectInput.readUTF();
		corporateCategory = objectInput.readUTF();
		apiPath = objectInput.readUTF();
		categories = objectInput.readUTF();
		foundedOn = objectInput.readUTF();
		noOfEmployees = objectInput.readInt();
		emailId = objectInput.readUTF();
		website = objectInput.readUTF();
		facebook = objectInput.readUTF();
		twitter = objectInput.readUTF();
		linkedIn = objectInput.readUTF();
		crunchbase = objectInput.readUTF();
		mobile = objectInput.readUTF();
		totalFunds = objectInput.readUTF();
		uen = objectInput.readUTF();
		description = objectInput.readUTF();
		shortPitch = objectInput.readUTF();
		lifecycleStage = objectInput.readUTF();
		capitalRaised = objectInput.readUTF();
		isIncorporated = objectInput.readBoolean();
		stockSymbol = objectInput.readUTF();
		imageUrl = objectInput.readUTF();
		videos = objectInput.readUTF();
		profileOutline = objectInput.readUTF();
		raisingFunds = objectInput.readUTF();
		extras = objectInput.readUTF();
		uniqueDesc = objectInput.readUTF();
		links = objectInput.readUTF();
		isBaseOrg = objectInput.readBoolean();
		completeness = objectInput.readBoolean();
		groupId = objectInput.readLong();
		companyId = objectInput.readLong();
		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();
		active = objectInput.readBoolean();
		logoId = objectInput.readLong();
		methodologyType = objectInput.readLong();
		methodologySubType = objectInput.readLong();
		stage = objectInput.readInt();
		feedback = objectInput.readUTF();
		videoLinks = objectInput.readUTF();
		projectsWorkedOn = objectInput.readUTF();
		showInBlackbook = objectInput.readBoolean();
		faxNumber = objectInput.readUTF();
		contactName = objectInput.readUTF();
		contactDesignation = objectInput.readUTF();
		pipelineStatus = objectInput.readInt();
		businessDevManager = objectInput.readInt();
		prevBusinessDevManager = objectInput.readInt();
		isATO = objectInput.readBoolean();
		approvalDate = objectInput.readLong();
		status = objectInput.readInt();
		listedCo = objectInput.readUTF();
		noOfPotentialCandidates = objectInput.readLong();
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

		objectOutput.writeLong(organizationId);

		if (name == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(name);
		}

		if (corporateCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(corporateCode);
		}

		if (corporateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(corporateType);
		}

		if (corporateCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(corporateCategory);
		}

		if (apiPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(apiPath);
		}

		if (categories == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(categories);
		}

		if (foundedOn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(foundedOn);
		}

		objectOutput.writeInt(noOfEmployees);

		if (emailId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(emailId);
		}

		if (website == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(website);
		}

		if (facebook == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(facebook);
		}

		if (twitter == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(twitter);
		}

		if (linkedIn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(linkedIn);
		}

		if (crunchbase == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(crunchbase);
		}

		if (mobile == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(mobile);
		}

		if (totalFunds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(totalFunds);
		}

		if (uen == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uen);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (shortPitch == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(shortPitch);
		}

		if (lifecycleStage == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lifecycleStage);
		}

		if (capitalRaised == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(capitalRaised);
		}

		objectOutput.writeBoolean(isIncorporated);

		if (stockSymbol == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stockSymbol);
		}

		if (imageUrl == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(imageUrl);
		}

		if (videos == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(videos);
		}

		if (profileOutline == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(profileOutline);
		}

		if (raisingFunds == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(raisingFunds);
		}

		if (extras == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(extras);
		}

		if (uniqueDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uniqueDesc);
		}

		if (links == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(links);
		}

		objectOutput.writeBoolean(isBaseOrg);
		objectOutput.writeBoolean(completeness);
		objectOutput.writeLong(groupId);
		objectOutput.writeLong(companyId);
		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);
		objectOutput.writeBoolean(active);
		objectOutput.writeLong(logoId);
		objectOutput.writeLong(methodologyType);
		objectOutput.writeLong(methodologySubType);
		objectOutput.writeInt(stage);

		if (feedback == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(feedback);
		}

		if (videoLinks == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(videoLinks);
		}

		if (projectsWorkedOn == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(projectsWorkedOn);
		}

		objectOutput.writeBoolean(showInBlackbook);

		if (faxNumber == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(faxNumber);
		}

		if (contactName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactName);
		}

		if (contactDesignation == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(contactDesignation);
		}

		objectOutput.writeInt(pipelineStatus);
		objectOutput.writeInt(businessDevManager);
		objectOutput.writeInt(prevBusinessDevManager);
		objectOutput.writeBoolean(isATO);
		objectOutput.writeLong(approvalDate);
		objectOutput.writeInt(status);

		if (listedCo == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(listedCo);
		}

		objectOutput.writeLong(noOfPotentialCandidates);
	}

	public String uuid;
	public long organizationId;
	public String name;
	public String corporateCode;
	public String corporateType;
	public String corporateCategory;
	public String apiPath;
	public String categories;
	public String foundedOn;
	public int noOfEmployees;
	public String emailId;
	public String website;
	public String facebook;
	public String twitter;
	public String linkedIn;
	public String crunchbase;
	public String mobile;
	public String totalFunds;
	public String uen;
	public String description;
	public String shortPitch;
	public String lifecycleStage;
	public String capitalRaised;
	public boolean isIncorporated;
	public String stockSymbol;
	public String imageUrl;
	public String videos;
	public String profileOutline;
	public String raisingFunds;
	public String extras;
	public String uniqueDesc;
	public String links;
	public boolean isBaseOrg;
	public boolean completeness;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public boolean active;
	public long logoId;
	public long methodologyType;
	public long methodologySubType;
	public int stage;
	public String feedback;
	public String videoLinks;
	public String projectsWorkedOn;
	public boolean showInBlackbook;
	public String faxNumber;
	public String contactName;
	public String contactDesignation;
	public int pipelineStatus;
	public int businessDevManager;
	public int prevBusinessDevManager;
	public boolean isATO;
	public long approvalDate;
	public int status;
	public String listedCo;
	public long noOfPotentialCandidates;
}