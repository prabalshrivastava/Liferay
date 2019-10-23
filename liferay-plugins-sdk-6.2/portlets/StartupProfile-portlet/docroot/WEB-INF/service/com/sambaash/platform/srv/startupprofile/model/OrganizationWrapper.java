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

package com.sambaash.platform.srv.startupprofile.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Organization}.
 * </p>
 *
 * @author pradeep
 * @see Organization
 * @generated
 */
public class OrganizationWrapper implements Organization,
	ModelWrapper<Organization> {
	public OrganizationWrapper(Organization organization) {
		_organization = organization;
	}

	@Override
	public Class<?> getModelClass() {
		return Organization.class;
	}

	@Override
	public String getModelClassName() {
		return Organization.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("name", getName());
		attributes.put("corporateCode", getCorporateCode());
		attributes.put("corporateType", getCorporateType());
		attributes.put("corporateCategory", getCorporateCategory());
		attributes.put("apiPath", getApiPath());
		attributes.put("categories", getCategories());
		attributes.put("foundedOn", getFoundedOn());
		attributes.put("noOfEmployees", getNoOfEmployees());
		attributes.put("emailId", getEmailId());
		attributes.put("website", getWebsite());
		attributes.put("facebook", getFacebook());
		attributes.put("twitter", getTwitter());
		attributes.put("linkedIn", getLinkedIn());
		attributes.put("crunchbase", getCrunchbase());
		attributes.put("mobile", getMobile());
		attributes.put("totalFunds", getTotalFunds());
		attributes.put("uen", getUen());
		attributes.put("description", getDescription());
		attributes.put("shortPitch", getShortPitch());
		attributes.put("lifecycleStage", getLifecycleStage());
		attributes.put("capitalRaised", getCapitalRaised());
		attributes.put("isIncorporated", getIsIncorporated());
		attributes.put("stockSymbol", getStockSymbol());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("videos", getVideos());
		attributes.put("profileOutline", getProfileOutline());
		attributes.put("raisingFunds", getRaisingFunds());
		attributes.put("extras", getExtras());
		attributes.put("uniqueDesc", getUniqueDesc());
		attributes.put("links", getLinks());
		attributes.put("isBaseOrg", getIsBaseOrg());
		attributes.put("completeness", getCompleteness());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());
		attributes.put("logoId", getLogoId());
		attributes.put("methodologyType", getMethodologyType());
		attributes.put("methodologySubType", getMethodologySubType());
		attributes.put("stage", getStage());
		attributes.put("feedback", getFeedback());
		attributes.put("videoLinks", getVideoLinks());
		attributes.put("projectsWorkedOn", getProjectsWorkedOn());
		attributes.put("showInBlackbook", getShowInBlackbook());
		attributes.put("faxNumber", getFaxNumber());
		attributes.put("contactName", getContactName());
		attributes.put("contactDesignation", getContactDesignation());
		attributes.put("pipelineStatus", getPipelineStatus());
		attributes.put("businessDevManager", getBusinessDevManager());
		attributes.put("prevBusinessDevManager", getPrevBusinessDevManager());
		attributes.put("isATO", getIsATO());
		attributes.put("approvalDate", getApprovalDate());
		attributes.put("status", getStatus());
		attributes.put("listedCo", getListedCo());
		attributes.put("noOfPotentialCandidates", getNoOfPotentialCandidates());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String corporateCode = (String)attributes.get("corporateCode");

		if (corporateCode != null) {
			setCorporateCode(corporateCode);
		}

		String corporateType = (String)attributes.get("corporateType");

		if (corporateType != null) {
			setCorporateType(corporateType);
		}

		String corporateCategory = (String)attributes.get("corporateCategory");

		if (corporateCategory != null) {
			setCorporateCategory(corporateCategory);
		}

		String apiPath = (String)attributes.get("apiPath");

		if (apiPath != null) {
			setApiPath(apiPath);
		}

		String categories = (String)attributes.get("categories");

		if (categories != null) {
			setCategories(categories);
		}

		String foundedOn = (String)attributes.get("foundedOn");

		if (foundedOn != null) {
			setFoundedOn(foundedOn);
		}

		Integer noOfEmployees = (Integer)attributes.get("noOfEmployees");

		if (noOfEmployees != null) {
			setNoOfEmployees(noOfEmployees);
		}

		String emailId = (String)attributes.get("emailId");

		if (emailId != null) {
			setEmailId(emailId);
		}

		String website = (String)attributes.get("website");

		if (website != null) {
			setWebsite(website);
		}

		String facebook = (String)attributes.get("facebook");

		if (facebook != null) {
			setFacebook(facebook);
		}

		String twitter = (String)attributes.get("twitter");

		if (twitter != null) {
			setTwitter(twitter);
		}

		String linkedIn = (String)attributes.get("linkedIn");

		if (linkedIn != null) {
			setLinkedIn(linkedIn);
		}

		String crunchbase = (String)attributes.get("crunchbase");

		if (crunchbase != null) {
			setCrunchbase(crunchbase);
		}

		String mobile = (String)attributes.get("mobile");

		if (mobile != null) {
			setMobile(mobile);
		}

		String totalFunds = (String)attributes.get("totalFunds");

		if (totalFunds != null) {
			setTotalFunds(totalFunds);
		}

		String uen = (String)attributes.get("uen");

		if (uen != null) {
			setUen(uen);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String shortPitch = (String)attributes.get("shortPitch");

		if (shortPitch != null) {
			setShortPitch(shortPitch);
		}

		String lifecycleStage = (String)attributes.get("lifecycleStage");

		if (lifecycleStage != null) {
			setLifecycleStage(lifecycleStage);
		}

		String capitalRaised = (String)attributes.get("capitalRaised");

		if (capitalRaised != null) {
			setCapitalRaised(capitalRaised);
		}

		Boolean isIncorporated = (Boolean)attributes.get("isIncorporated");

		if (isIncorporated != null) {
			setIsIncorporated(isIncorporated);
		}

		String stockSymbol = (String)attributes.get("stockSymbol");

		if (stockSymbol != null) {
			setStockSymbol(stockSymbol);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String videos = (String)attributes.get("videos");

		if (videos != null) {
			setVideos(videos);
		}

		String profileOutline = (String)attributes.get("profileOutline");

		if (profileOutline != null) {
			setProfileOutline(profileOutline);
		}

		String raisingFunds = (String)attributes.get("raisingFunds");

		if (raisingFunds != null) {
			setRaisingFunds(raisingFunds);
		}

		String extras = (String)attributes.get("extras");

		if (extras != null) {
			setExtras(extras);
		}

		String uniqueDesc = (String)attributes.get("uniqueDesc");

		if (uniqueDesc != null) {
			setUniqueDesc(uniqueDesc);
		}

		String links = (String)attributes.get("links");

		if (links != null) {
			setLinks(links);
		}

		Boolean isBaseOrg = (Boolean)attributes.get("isBaseOrg");

		if (isBaseOrg != null) {
			setIsBaseOrg(isBaseOrg);
		}

		Boolean completeness = (Boolean)attributes.get("completeness");

		if (completeness != null) {
			setCompleteness(completeness);
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

		Boolean active = (Boolean)attributes.get("active");

		if (active != null) {
			setActive(active);
		}

		Long logoId = (Long)attributes.get("logoId");

		if (logoId != null) {
			setLogoId(logoId);
		}

		Long methodologyType = (Long)attributes.get("methodologyType");

		if (methodologyType != null) {
			setMethodologyType(methodologyType);
		}

		Long methodologySubType = (Long)attributes.get("methodologySubType");

		if (methodologySubType != null) {
			setMethodologySubType(methodologySubType);
		}

		Integer stage = (Integer)attributes.get("stage");

		if (stage != null) {
			setStage(stage);
		}

		String feedback = (String)attributes.get("feedback");

		if (feedback != null) {
			setFeedback(feedback);
		}

		String videoLinks = (String)attributes.get("videoLinks");

		if (videoLinks != null) {
			setVideoLinks(videoLinks);
		}

		String projectsWorkedOn = (String)attributes.get("projectsWorkedOn");

		if (projectsWorkedOn != null) {
			setProjectsWorkedOn(projectsWorkedOn);
		}

		Boolean showInBlackbook = (Boolean)attributes.get("showInBlackbook");

		if (showInBlackbook != null) {
			setShowInBlackbook(showInBlackbook);
		}

		String faxNumber = (String)attributes.get("faxNumber");

		if (faxNumber != null) {
			setFaxNumber(faxNumber);
		}

		String contactName = (String)attributes.get("contactName");

		if (contactName != null) {
			setContactName(contactName);
		}

		String contactDesignation = (String)attributes.get("contactDesignation");

		if (contactDesignation != null) {
			setContactDesignation(contactDesignation);
		}

		Integer pipelineStatus = (Integer)attributes.get("pipelineStatus");

		if (pipelineStatus != null) {
			setPipelineStatus(pipelineStatus);
		}

		Integer businessDevManager = (Integer)attributes.get(
				"businessDevManager");

		if (businessDevManager != null) {
			setBusinessDevManager(businessDevManager);
		}

		Integer prevBusinessDevManager = (Integer)attributes.get(
				"prevBusinessDevManager");

		if (prevBusinessDevManager != null) {
			setPrevBusinessDevManager(prevBusinessDevManager);
		}

		Boolean isATO = (Boolean)attributes.get("isATO");

		if (isATO != null) {
			setIsATO(isATO);
		}

		Date approvalDate = (Date)attributes.get("approvalDate");

		if (approvalDate != null) {
			setApprovalDate(approvalDate);
		}

		Integer status = (Integer)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String listedCo = (String)attributes.get("listedCo");

		if (listedCo != null) {
			setListedCo(listedCo);
		}

		Long noOfPotentialCandidates = (Long)attributes.get(
				"noOfPotentialCandidates");

		if (noOfPotentialCandidates != null) {
			setNoOfPotentialCandidates(noOfPotentialCandidates);
		}
	}

	/**
	* Returns the primary key of this organization.
	*
	* @return the primary key of this organization
	*/
	@Override
	public long getPrimaryKey() {
		return _organization.getPrimaryKey();
	}

	/**
	* Sets the primary key of this organization.
	*
	* @param primaryKey the primary key of this organization
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_organization.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this organization.
	*
	* @return the uuid of this organization
	*/
	@Override
	public java.lang.String getUuid() {
		return _organization.getUuid();
	}

	/**
	* Sets the uuid of this organization.
	*
	* @param uuid the uuid of this organization
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_organization.setUuid(uuid);
	}

	/**
	* Returns the organization ID of this organization.
	*
	* @return the organization ID of this organization
	*/
	@Override
	public long getOrganizationId() {
		return _organization.getOrganizationId();
	}

	/**
	* Sets the organization ID of this organization.
	*
	* @param organizationId the organization ID of this organization
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_organization.setOrganizationId(organizationId);
	}

	/**
	* Returns the name of this organization.
	*
	* @return the name of this organization
	*/
	@Override
	public java.lang.String getName() {
		return _organization.getName();
	}

	/**
	* Sets the name of this organization.
	*
	* @param name the name of this organization
	*/
	@Override
	public void setName(java.lang.String name) {
		_organization.setName(name);
	}

	/**
	* Returns the corporate code of this organization.
	*
	* @return the corporate code of this organization
	*/
	@Override
	public java.lang.String getCorporateCode() {
		return _organization.getCorporateCode();
	}

	/**
	* Sets the corporate code of this organization.
	*
	* @param corporateCode the corporate code of this organization
	*/
	@Override
	public void setCorporateCode(java.lang.String corporateCode) {
		_organization.setCorporateCode(corporateCode);
	}

	/**
	* Returns the corporate type of this organization.
	*
	* @return the corporate type of this organization
	*/
	@Override
	public java.lang.String getCorporateType() {
		return _organization.getCorporateType();
	}

	/**
	* Sets the corporate type of this organization.
	*
	* @param corporateType the corporate type of this organization
	*/
	@Override
	public void setCorporateType(java.lang.String corporateType) {
		_organization.setCorporateType(corporateType);
	}

	/**
	* Returns the corporate category of this organization.
	*
	* @return the corporate category of this organization
	*/
	@Override
	public java.lang.String getCorporateCategory() {
		return _organization.getCorporateCategory();
	}

	/**
	* Sets the corporate category of this organization.
	*
	* @param corporateCategory the corporate category of this organization
	*/
	@Override
	public void setCorporateCategory(java.lang.String corporateCategory) {
		_organization.setCorporateCategory(corporateCategory);
	}

	/**
	* Returns the api path of this organization.
	*
	* @return the api path of this organization
	*/
	@Override
	public java.lang.String getApiPath() {
		return _organization.getApiPath();
	}

	/**
	* Sets the api path of this organization.
	*
	* @param apiPath the api path of this organization
	*/
	@Override
	public void setApiPath(java.lang.String apiPath) {
		_organization.setApiPath(apiPath);
	}

	/**
	* Returns the categories of this organization.
	*
	* @return the categories of this organization
	*/
	@Override
	public java.lang.String getCategories() {
		return _organization.getCategories();
	}

	/**
	* Sets the categories of this organization.
	*
	* @param categories the categories of this organization
	*/
	@Override
	public void setCategories(java.lang.String categories) {
		_organization.setCategories(categories);
	}

	/**
	* Returns the founded on of this organization.
	*
	* @return the founded on of this organization
	*/
	@Override
	public java.lang.String getFoundedOn() {
		return _organization.getFoundedOn();
	}

	/**
	* Sets the founded on of this organization.
	*
	* @param foundedOn the founded on of this organization
	*/
	@Override
	public void setFoundedOn(java.lang.String foundedOn) {
		_organization.setFoundedOn(foundedOn);
	}

	/**
	* Returns the no of employees of this organization.
	*
	* @return the no of employees of this organization
	*/
	@Override
	public int getNoOfEmployees() {
		return _organization.getNoOfEmployees();
	}

	/**
	* Sets the no of employees of this organization.
	*
	* @param noOfEmployees the no of employees of this organization
	*/
	@Override
	public void setNoOfEmployees(int noOfEmployees) {
		_organization.setNoOfEmployees(noOfEmployees);
	}

	/**
	* Returns the email ID of this organization.
	*
	* @return the email ID of this organization
	*/
	@Override
	public java.lang.String getEmailId() {
		return _organization.getEmailId();
	}

	/**
	* Sets the email ID of this organization.
	*
	* @param emailId the email ID of this organization
	*/
	@Override
	public void setEmailId(java.lang.String emailId) {
		_organization.setEmailId(emailId);
	}

	/**
	* Returns the website of this organization.
	*
	* @return the website of this organization
	*/
	@Override
	public java.lang.String getWebsite() {
		return _organization.getWebsite();
	}

	/**
	* Sets the website of this organization.
	*
	* @param website the website of this organization
	*/
	@Override
	public void setWebsite(java.lang.String website) {
		_organization.setWebsite(website);
	}

	/**
	* Returns the facebook of this organization.
	*
	* @return the facebook of this organization
	*/
	@Override
	public java.lang.String getFacebook() {
		return _organization.getFacebook();
	}

	/**
	* Sets the facebook of this organization.
	*
	* @param facebook the facebook of this organization
	*/
	@Override
	public void setFacebook(java.lang.String facebook) {
		_organization.setFacebook(facebook);
	}

	/**
	* Returns the twitter of this organization.
	*
	* @return the twitter of this organization
	*/
	@Override
	public java.lang.String getTwitter() {
		return _organization.getTwitter();
	}

	/**
	* Sets the twitter of this organization.
	*
	* @param twitter the twitter of this organization
	*/
	@Override
	public void setTwitter(java.lang.String twitter) {
		_organization.setTwitter(twitter);
	}

	/**
	* Returns the linked in of this organization.
	*
	* @return the linked in of this organization
	*/
	@Override
	public java.lang.String getLinkedIn() {
		return _organization.getLinkedIn();
	}

	/**
	* Sets the linked in of this organization.
	*
	* @param linkedIn the linked in of this organization
	*/
	@Override
	public void setLinkedIn(java.lang.String linkedIn) {
		_organization.setLinkedIn(linkedIn);
	}

	/**
	* Returns the crunchbase of this organization.
	*
	* @return the crunchbase of this organization
	*/
	@Override
	public java.lang.String getCrunchbase() {
		return _organization.getCrunchbase();
	}

	/**
	* Sets the crunchbase of this organization.
	*
	* @param crunchbase the crunchbase of this organization
	*/
	@Override
	public void setCrunchbase(java.lang.String crunchbase) {
		_organization.setCrunchbase(crunchbase);
	}

	/**
	* Returns the mobile of this organization.
	*
	* @return the mobile of this organization
	*/
	@Override
	public java.lang.String getMobile() {
		return _organization.getMobile();
	}

	/**
	* Sets the mobile of this organization.
	*
	* @param mobile the mobile of this organization
	*/
	@Override
	public void setMobile(java.lang.String mobile) {
		_organization.setMobile(mobile);
	}

	/**
	* Returns the total funds of this organization.
	*
	* @return the total funds of this organization
	*/
	@Override
	public java.lang.String getTotalFunds() {
		return _organization.getTotalFunds();
	}

	/**
	* Sets the total funds of this organization.
	*
	* @param totalFunds the total funds of this organization
	*/
	@Override
	public void setTotalFunds(java.lang.String totalFunds) {
		_organization.setTotalFunds(totalFunds);
	}

	/**
	* Returns the uen of this organization.
	*
	* @return the uen of this organization
	*/
	@Override
	public java.lang.String getUen() {
		return _organization.getUen();
	}

	/**
	* Sets the uen of this organization.
	*
	* @param uen the uen of this organization
	*/
	@Override
	public void setUen(java.lang.String uen) {
		_organization.setUen(uen);
	}

	/**
	* Returns the description of this organization.
	*
	* @return the description of this organization
	*/
	@Override
	public java.lang.String getDescription() {
		return _organization.getDescription();
	}

	/**
	* Sets the description of this organization.
	*
	* @param description the description of this organization
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_organization.setDescription(description);
	}

	/**
	* Returns the short pitch of this organization.
	*
	* @return the short pitch of this organization
	*/
	@Override
	public java.lang.String getShortPitch() {
		return _organization.getShortPitch();
	}

	/**
	* Sets the short pitch of this organization.
	*
	* @param shortPitch the short pitch of this organization
	*/
	@Override
	public void setShortPitch(java.lang.String shortPitch) {
		_organization.setShortPitch(shortPitch);
	}

	/**
	* Returns the lifecycle stage of this organization.
	*
	* @return the lifecycle stage of this organization
	*/
	@Override
	public java.lang.String getLifecycleStage() {
		return _organization.getLifecycleStage();
	}

	/**
	* Sets the lifecycle stage of this organization.
	*
	* @param lifecycleStage the lifecycle stage of this organization
	*/
	@Override
	public void setLifecycleStage(java.lang.String lifecycleStage) {
		_organization.setLifecycleStage(lifecycleStage);
	}

	/**
	* Returns the capital raised of this organization.
	*
	* @return the capital raised of this organization
	*/
	@Override
	public java.lang.String getCapitalRaised() {
		return _organization.getCapitalRaised();
	}

	/**
	* Sets the capital raised of this organization.
	*
	* @param capitalRaised the capital raised of this organization
	*/
	@Override
	public void setCapitalRaised(java.lang.String capitalRaised) {
		_organization.setCapitalRaised(capitalRaised);
	}

	/**
	* Returns the is incorporated of this organization.
	*
	* @return the is incorporated of this organization
	*/
	@Override
	public boolean getIsIncorporated() {
		return _organization.getIsIncorporated();
	}

	/**
	* Returns <code>true</code> if this organization is is incorporated.
	*
	* @return <code>true</code> if this organization is is incorporated; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsIncorporated() {
		return _organization.isIsIncorporated();
	}

	/**
	* Sets whether this organization is is incorporated.
	*
	* @param isIncorporated the is incorporated of this organization
	*/
	@Override
	public void setIsIncorporated(boolean isIncorporated) {
		_organization.setIsIncorporated(isIncorporated);
	}

	/**
	* Returns the stock symbol of this organization.
	*
	* @return the stock symbol of this organization
	*/
	@Override
	public java.lang.String getStockSymbol() {
		return _organization.getStockSymbol();
	}

	/**
	* Sets the stock symbol of this organization.
	*
	* @param stockSymbol the stock symbol of this organization
	*/
	@Override
	public void setStockSymbol(java.lang.String stockSymbol) {
		_organization.setStockSymbol(stockSymbol);
	}

	/**
	* Returns the image url of this organization.
	*
	* @return the image url of this organization
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _organization.getImageUrl();
	}

	/**
	* Sets the image url of this organization.
	*
	* @param imageUrl the image url of this organization
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_organization.setImageUrl(imageUrl);
	}

	/**
	* Returns the videos of this organization.
	*
	* @return the videos of this organization
	*/
	@Override
	public java.lang.String getVideos() {
		return _organization.getVideos();
	}

	/**
	* Sets the videos of this organization.
	*
	* @param videos the videos of this organization
	*/
	@Override
	public void setVideos(java.lang.String videos) {
		_organization.setVideos(videos);
	}

	/**
	* Returns the profile outline of this organization.
	*
	* @return the profile outline of this organization
	*/
	@Override
	public java.lang.String getProfileOutline() {
		return _organization.getProfileOutline();
	}

	/**
	* Sets the profile outline of this organization.
	*
	* @param profileOutline the profile outline of this organization
	*/
	@Override
	public void setProfileOutline(java.lang.String profileOutline) {
		_organization.setProfileOutline(profileOutline);
	}

	/**
	* Returns the raising funds of this organization.
	*
	* @return the raising funds of this organization
	*/
	@Override
	public java.lang.String getRaisingFunds() {
		return _organization.getRaisingFunds();
	}

	/**
	* Sets the raising funds of this organization.
	*
	* @param raisingFunds the raising funds of this organization
	*/
	@Override
	public void setRaisingFunds(java.lang.String raisingFunds) {
		_organization.setRaisingFunds(raisingFunds);
	}

	/**
	* Returns the extras of this organization.
	*
	* @return the extras of this organization
	*/
	@Override
	public java.lang.String getExtras() {
		return _organization.getExtras();
	}

	/**
	* Sets the extras of this organization.
	*
	* @param extras the extras of this organization
	*/
	@Override
	public void setExtras(java.lang.String extras) {
		_organization.setExtras(extras);
	}

	/**
	* Returns the unique desc of this organization.
	*
	* @return the unique desc of this organization
	*/
	@Override
	public java.lang.String getUniqueDesc() {
		return _organization.getUniqueDesc();
	}

	/**
	* Sets the unique desc of this organization.
	*
	* @param uniqueDesc the unique desc of this organization
	*/
	@Override
	public void setUniqueDesc(java.lang.String uniqueDesc) {
		_organization.setUniqueDesc(uniqueDesc);
	}

	/**
	* Returns the links of this organization.
	*
	* @return the links of this organization
	*/
	@Override
	public java.lang.String getLinks() {
		return _organization.getLinks();
	}

	/**
	* Sets the links of this organization.
	*
	* @param links the links of this organization
	*/
	@Override
	public void setLinks(java.lang.String links) {
		_organization.setLinks(links);
	}

	/**
	* Returns the is base org of this organization.
	*
	* @return the is base org of this organization
	*/
	@Override
	public boolean getIsBaseOrg() {
		return _organization.getIsBaseOrg();
	}

	/**
	* Returns <code>true</code> if this organization is is base org.
	*
	* @return <code>true</code> if this organization is is base org; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsBaseOrg() {
		return _organization.isIsBaseOrg();
	}

	/**
	* Sets whether this organization is is base org.
	*
	* @param isBaseOrg the is base org of this organization
	*/
	@Override
	public void setIsBaseOrg(boolean isBaseOrg) {
		_organization.setIsBaseOrg(isBaseOrg);
	}

	/**
	* Returns the completeness of this organization.
	*
	* @return the completeness of this organization
	*/
	@Override
	public boolean getCompleteness() {
		return _organization.getCompleteness();
	}

	/**
	* Returns <code>true</code> if this organization is completeness.
	*
	* @return <code>true</code> if this organization is completeness; <code>false</code> otherwise
	*/
	@Override
	public boolean isCompleteness() {
		return _organization.isCompleteness();
	}

	/**
	* Sets whether this organization is completeness.
	*
	* @param completeness the completeness of this organization
	*/
	@Override
	public void setCompleteness(boolean completeness) {
		_organization.setCompleteness(completeness);
	}

	/**
	* Returns the group ID of this organization.
	*
	* @return the group ID of this organization
	*/
	@Override
	public long getGroupId() {
		return _organization.getGroupId();
	}

	/**
	* Sets the group ID of this organization.
	*
	* @param groupId the group ID of this organization
	*/
	@Override
	public void setGroupId(long groupId) {
		_organization.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this organization.
	*
	* @return the company ID of this organization
	*/
	@Override
	public long getCompanyId() {
		return _organization.getCompanyId();
	}

	/**
	* Sets the company ID of this organization.
	*
	* @param companyId the company ID of this organization
	*/
	@Override
	public void setCompanyId(long companyId) {
		_organization.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this organization.
	*
	* @return the user ID of this organization
	*/
	@Override
	public long getUserId() {
		return _organization.getUserId();
	}

	/**
	* Sets the user ID of this organization.
	*
	* @param userId the user ID of this organization
	*/
	@Override
	public void setUserId(long userId) {
		_organization.setUserId(userId);
	}

	/**
	* Returns the user uuid of this organization.
	*
	* @return the user uuid of this organization
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _organization.getUserUuid();
	}

	/**
	* Sets the user uuid of this organization.
	*
	* @param userUuid the user uuid of this organization
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_organization.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this organization.
	*
	* @return the user name of this organization
	*/
	@Override
	public java.lang.String getUserName() {
		return _organization.getUserName();
	}

	/**
	* Sets the user name of this organization.
	*
	* @param userName the user name of this organization
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_organization.setUserName(userName);
	}

	/**
	* Returns the create date of this organization.
	*
	* @return the create date of this organization
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _organization.getCreateDate();
	}

	/**
	* Sets the create date of this organization.
	*
	* @param createDate the create date of this organization
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_organization.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this organization.
	*
	* @return the modified date of this organization
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _organization.getModifiedDate();
	}

	/**
	* Sets the modified date of this organization.
	*
	* @param modifiedDate the modified date of this organization
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_organization.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the active of this organization.
	*
	* @return the active of this organization
	*/
	@Override
	public boolean getActive() {
		return _organization.getActive();
	}

	/**
	* Returns <code>true</code> if this organization is active.
	*
	* @return <code>true</code> if this organization is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _organization.isActive();
	}

	/**
	* Sets whether this organization is active.
	*
	* @param active the active of this organization
	*/
	@Override
	public void setActive(boolean active) {
		_organization.setActive(active);
	}

	/**
	* Returns the logo ID of this organization.
	*
	* @return the logo ID of this organization
	*/
	@Override
	public long getLogoId() {
		return _organization.getLogoId();
	}

	/**
	* Sets the logo ID of this organization.
	*
	* @param logoId the logo ID of this organization
	*/
	@Override
	public void setLogoId(long logoId) {
		_organization.setLogoId(logoId);
	}

	/**
	* Returns the methodology type of this organization.
	*
	* @return the methodology type of this organization
	*/
	@Override
	public long getMethodologyType() {
		return _organization.getMethodologyType();
	}

	/**
	* Sets the methodology type of this organization.
	*
	* @param methodologyType the methodology type of this organization
	*/
	@Override
	public void setMethodologyType(long methodologyType) {
		_organization.setMethodologyType(methodologyType);
	}

	/**
	* Returns the methodology sub type of this organization.
	*
	* @return the methodology sub type of this organization
	*/
	@Override
	public long getMethodologySubType() {
		return _organization.getMethodologySubType();
	}

	/**
	* Sets the methodology sub type of this organization.
	*
	* @param methodologySubType the methodology sub type of this organization
	*/
	@Override
	public void setMethodologySubType(long methodologySubType) {
		_organization.setMethodologySubType(methodologySubType);
	}

	/**
	* Returns the stage of this organization.
	*
	* @return the stage of this organization
	*/
	@Override
	public int getStage() {
		return _organization.getStage();
	}

	/**
	* Sets the stage of this organization.
	*
	* @param stage the stage of this organization
	*/
	@Override
	public void setStage(int stage) {
		_organization.setStage(stage);
	}

	/**
	* Returns the feedback of this organization.
	*
	* @return the feedback of this organization
	*/
	@Override
	public java.lang.String getFeedback() {
		return _organization.getFeedback();
	}

	/**
	* Sets the feedback of this organization.
	*
	* @param feedback the feedback of this organization
	*/
	@Override
	public void setFeedback(java.lang.String feedback) {
		_organization.setFeedback(feedback);
	}

	/**
	* Returns the video links of this organization.
	*
	* @return the video links of this organization
	*/
	@Override
	public java.lang.String getVideoLinks() {
		return _organization.getVideoLinks();
	}

	/**
	* Sets the video links of this organization.
	*
	* @param videoLinks the video links of this organization
	*/
	@Override
	public void setVideoLinks(java.lang.String videoLinks) {
		_organization.setVideoLinks(videoLinks);
	}

	/**
	* Returns the projects worked on of this organization.
	*
	* @return the projects worked on of this organization
	*/
	@Override
	public java.lang.String getProjectsWorkedOn() {
		return _organization.getProjectsWorkedOn();
	}

	/**
	* Sets the projects worked on of this organization.
	*
	* @param projectsWorkedOn the projects worked on of this organization
	*/
	@Override
	public void setProjectsWorkedOn(java.lang.String projectsWorkedOn) {
		_organization.setProjectsWorkedOn(projectsWorkedOn);
	}

	/**
	* Returns the show in blackbook of this organization.
	*
	* @return the show in blackbook of this organization
	*/
	@Override
	public boolean getShowInBlackbook() {
		return _organization.getShowInBlackbook();
	}

	/**
	* Returns <code>true</code> if this organization is show in blackbook.
	*
	* @return <code>true</code> if this organization is show in blackbook; <code>false</code> otherwise
	*/
	@Override
	public boolean isShowInBlackbook() {
		return _organization.isShowInBlackbook();
	}

	/**
	* Sets whether this organization is show in blackbook.
	*
	* @param showInBlackbook the show in blackbook of this organization
	*/
	@Override
	public void setShowInBlackbook(boolean showInBlackbook) {
		_organization.setShowInBlackbook(showInBlackbook);
	}

	/**
	* Returns the fax number of this organization.
	*
	* @return the fax number of this organization
	*/
	@Override
	public java.lang.String getFaxNumber() {
		return _organization.getFaxNumber();
	}

	/**
	* Sets the fax number of this organization.
	*
	* @param faxNumber the fax number of this organization
	*/
	@Override
	public void setFaxNumber(java.lang.String faxNumber) {
		_organization.setFaxNumber(faxNumber);
	}

	/**
	* Returns the contact name of this organization.
	*
	* @return the contact name of this organization
	*/
	@Override
	public java.lang.String getContactName() {
		return _organization.getContactName();
	}

	/**
	* Sets the contact name of this organization.
	*
	* @param contactName the contact name of this organization
	*/
	@Override
	public void setContactName(java.lang.String contactName) {
		_organization.setContactName(contactName);
	}

	/**
	* Returns the contact designation of this organization.
	*
	* @return the contact designation of this organization
	*/
	@Override
	public java.lang.String getContactDesignation() {
		return _organization.getContactDesignation();
	}

	/**
	* Sets the contact designation of this organization.
	*
	* @param contactDesignation the contact designation of this organization
	*/
	@Override
	public void setContactDesignation(java.lang.String contactDesignation) {
		_organization.setContactDesignation(contactDesignation);
	}

	/**
	* Returns the pipeline status of this organization.
	*
	* @return the pipeline status of this organization
	*/
	@Override
	public int getPipelineStatus() {
		return _organization.getPipelineStatus();
	}

	/**
	* Sets the pipeline status of this organization.
	*
	* @param pipelineStatus the pipeline status of this organization
	*/
	@Override
	public void setPipelineStatus(int pipelineStatus) {
		_organization.setPipelineStatus(pipelineStatus);
	}

	/**
	* Returns the business dev manager of this organization.
	*
	* @return the business dev manager of this organization
	*/
	@Override
	public int getBusinessDevManager() {
		return _organization.getBusinessDevManager();
	}

	/**
	* Sets the business dev manager of this organization.
	*
	* @param businessDevManager the business dev manager of this organization
	*/
	@Override
	public void setBusinessDevManager(int businessDevManager) {
		_organization.setBusinessDevManager(businessDevManager);
	}

	/**
	* Returns the prev business dev manager of this organization.
	*
	* @return the prev business dev manager of this organization
	*/
	@Override
	public int getPrevBusinessDevManager() {
		return _organization.getPrevBusinessDevManager();
	}

	/**
	* Sets the prev business dev manager of this organization.
	*
	* @param prevBusinessDevManager the prev business dev manager of this organization
	*/
	@Override
	public void setPrevBusinessDevManager(int prevBusinessDevManager) {
		_organization.setPrevBusinessDevManager(prevBusinessDevManager);
	}

	/**
	* Returns the is a t o of this organization.
	*
	* @return the is a t o of this organization
	*/
	@Override
	public boolean getIsATO() {
		return _organization.getIsATO();
	}

	/**
	* Returns <code>true</code> if this organization is is a t o.
	*
	* @return <code>true</code> if this organization is is a t o; <code>false</code> otherwise
	*/
	@Override
	public boolean isIsATO() {
		return _organization.isIsATO();
	}

	/**
	* Sets whether this organization is is a t o.
	*
	* @param isATO the is a t o of this organization
	*/
	@Override
	public void setIsATO(boolean isATO) {
		_organization.setIsATO(isATO);
	}

	/**
	* Returns the approval date of this organization.
	*
	* @return the approval date of this organization
	*/
	@Override
	public java.util.Date getApprovalDate() {
		return _organization.getApprovalDate();
	}

	/**
	* Sets the approval date of this organization.
	*
	* @param approvalDate the approval date of this organization
	*/
	@Override
	public void setApprovalDate(java.util.Date approvalDate) {
		_organization.setApprovalDate(approvalDate);
	}

	/**
	* Returns the status of this organization.
	*
	* @return the status of this organization
	*/
	@Override
	public int getStatus() {
		return _organization.getStatus();
	}

	/**
	* Sets the status of this organization.
	*
	* @param status the status of this organization
	*/
	@Override
	public void setStatus(int status) {
		_organization.setStatus(status);
	}

	/**
	* Returns the listed co of this organization.
	*
	* @return the listed co of this organization
	*/
	@Override
	public java.lang.String getListedCo() {
		return _organization.getListedCo();
	}

	/**
	* Sets the listed co of this organization.
	*
	* @param listedCo the listed co of this organization
	*/
	@Override
	public void setListedCo(java.lang.String listedCo) {
		_organization.setListedCo(listedCo);
	}

	/**
	* Returns the no of potential candidates of this organization.
	*
	* @return the no of potential candidates of this organization
	*/
	@Override
	public long getNoOfPotentialCandidates() {
		return _organization.getNoOfPotentialCandidates();
	}

	/**
	* Sets the no of potential candidates of this organization.
	*
	* @param noOfPotentialCandidates the no of potential candidates of this organization
	*/
	@Override
	public void setNoOfPotentialCandidates(long noOfPotentialCandidates) {
		_organization.setNoOfPotentialCandidates(noOfPotentialCandidates);
	}

	@Override
	public boolean isNew() {
		return _organization.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_organization.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _organization.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_organization.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _organization.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _organization.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_organization.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _organization.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_organization.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_organization.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_organization.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new OrganizationWrapper((Organization)_organization.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.Organization organization) {
		return _organization.compareTo(organization);
	}

	@Override
	public int hashCode() {
		return _organization.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.Organization> toCacheModel() {
		return _organization.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization toEscapedModel() {
		return new OrganizationWrapper(_organization.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.Organization toUnescapedModel() {
		return new OrganizationWrapper(_organization.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _organization.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _organization.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_organization.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof OrganizationWrapper)) {
			return false;
		}

		OrganizationWrapper organizationWrapper = (OrganizationWrapper)obj;

		if (Validator.equals(_organization, organizationWrapper._organization)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _organization.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public Organization getWrappedOrganization() {
		return _organization;
	}

	@Override
	public Organization getWrappedModel() {
		return _organization;
	}

	@Override
	public void resetOriginalValues() {
		_organization.resetOriginalValues();
	}

	private Organization _organization;
}