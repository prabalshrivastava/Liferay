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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link com.sambaash.platform.srv.startupprofile.service.http.OrganizationServiceSoap}.
 *
 * @author pradeep
 * @see com.sambaash.platform.srv.startupprofile.service.http.OrganizationServiceSoap
 * @generated
 */
public class OrganizationSoap implements Serializable {
	public static OrganizationSoap toSoapModel(Organization model) {
		OrganizationSoap soapModel = new OrganizationSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setOrganizationId(model.getOrganizationId());
		soapModel.setName(model.getName());
		soapModel.setCorporateCode(model.getCorporateCode());
		soapModel.setCorporateType(model.getCorporateType());
		soapModel.setCorporateCategory(model.getCorporateCategory());
		soapModel.setApiPath(model.getApiPath());
		soapModel.setCategories(model.getCategories());
		soapModel.setFoundedOn(model.getFoundedOn());
		soapModel.setNoOfEmployees(model.getNoOfEmployees());
		soapModel.setEmailId(model.getEmailId());
		soapModel.setWebsite(model.getWebsite());
		soapModel.setFacebook(model.getFacebook());
		soapModel.setTwitter(model.getTwitter());
		soapModel.setLinkedIn(model.getLinkedIn());
		soapModel.setCrunchbase(model.getCrunchbase());
		soapModel.setMobile(model.getMobile());
		soapModel.setTotalFunds(model.getTotalFunds());
		soapModel.setUen(model.getUen());
		soapModel.setDescription(model.getDescription());
		soapModel.setShortPitch(model.getShortPitch());
		soapModel.setLifecycleStage(model.getLifecycleStage());
		soapModel.setCapitalRaised(model.getCapitalRaised());
		soapModel.setIsIncorporated(model.getIsIncorporated());
		soapModel.setStockSymbol(model.getStockSymbol());
		soapModel.setImageUrl(model.getImageUrl());
		soapModel.setVideos(model.getVideos());
		soapModel.setProfileOutline(model.getProfileOutline());
		soapModel.setRaisingFunds(model.getRaisingFunds());
		soapModel.setExtras(model.getExtras());
		soapModel.setUniqueDesc(model.getUniqueDesc());
		soapModel.setLinks(model.getLinks());
		soapModel.setIsBaseOrg(model.getIsBaseOrg());
		soapModel.setCompleteness(model.getCompleteness());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setActive(model.getActive());
		soapModel.setLogoId(model.getLogoId());
		soapModel.setMethodologyType(model.getMethodologyType());
		soapModel.setMethodologySubType(model.getMethodologySubType());
		soapModel.setStage(model.getStage());
		soapModel.setFeedback(model.getFeedback());
		soapModel.setVideoLinks(model.getVideoLinks());
		soapModel.setProjectsWorkedOn(model.getProjectsWorkedOn());
		soapModel.setShowInBlackbook(model.getShowInBlackbook());
		soapModel.setFaxNumber(model.getFaxNumber());
		soapModel.setContactName(model.getContactName());
		soapModel.setContactDesignation(model.getContactDesignation());
		soapModel.setPipelineStatus(model.getPipelineStatus());
		soapModel.setBusinessDevManager(model.getBusinessDevManager());
		soapModel.setPrevBusinessDevManager(model.getPrevBusinessDevManager());
		soapModel.setIsATO(model.getIsATO());
		soapModel.setApprovalDate(model.getApprovalDate());
		soapModel.setStatus(model.getStatus());
		soapModel.setListedCo(model.getListedCo());
		soapModel.setNoOfPotentialCandidates(model.getNoOfPotentialCandidates());

		return soapModel;
	}

	public static OrganizationSoap[] toSoapModels(Organization[] models) {
		OrganizationSoap[] soapModels = new OrganizationSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static OrganizationSoap[][] toSoapModels(Organization[][] models) {
		OrganizationSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new OrganizationSoap[models.length][models[0].length];
		}
		else {
			soapModels = new OrganizationSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static OrganizationSoap[] toSoapModels(List<Organization> models) {
		List<OrganizationSoap> soapModels = new ArrayList<OrganizationSoap>(models.size());

		for (Organization model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new OrganizationSoap[soapModels.size()]);
	}

	public OrganizationSoap() {
	}

	public long getPrimaryKey() {
		return _organizationId;
	}

	public void setPrimaryKey(long pk) {
		setOrganizationId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getOrganizationId() {
		return _organizationId;
	}

	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;
	}

	public String getName() {
		return _name;
	}

	public void setName(String name) {
		_name = name;
	}

	public String getCorporateCode() {
		return _corporateCode;
	}

	public void setCorporateCode(String corporateCode) {
		_corporateCode = corporateCode;
	}

	public String getCorporateType() {
		return _corporateType;
	}

	public void setCorporateType(String corporateType) {
		_corporateType = corporateType;
	}

	public String getCorporateCategory() {
		return _corporateCategory;
	}

	public void setCorporateCategory(String corporateCategory) {
		_corporateCategory = corporateCategory;
	}

	public String getApiPath() {
		return _apiPath;
	}

	public void setApiPath(String apiPath) {
		_apiPath = apiPath;
	}

	public String getCategories() {
		return _categories;
	}

	public void setCategories(String categories) {
		_categories = categories;
	}

	public String getFoundedOn() {
		return _foundedOn;
	}

	public void setFoundedOn(String foundedOn) {
		_foundedOn = foundedOn;
	}

	public int getNoOfEmployees() {
		return _noOfEmployees;
	}

	public void setNoOfEmployees(int noOfEmployees) {
		_noOfEmployees = noOfEmployees;
	}

	public String getEmailId() {
		return _emailId;
	}

	public void setEmailId(String emailId) {
		_emailId = emailId;
	}

	public String getWebsite() {
		return _website;
	}

	public void setWebsite(String website) {
		_website = website;
	}

	public String getFacebook() {
		return _facebook;
	}

	public void setFacebook(String facebook) {
		_facebook = facebook;
	}

	public String getTwitter() {
		return _twitter;
	}

	public void setTwitter(String twitter) {
		_twitter = twitter;
	}

	public String getLinkedIn() {
		return _linkedIn;
	}

	public void setLinkedIn(String linkedIn) {
		_linkedIn = linkedIn;
	}

	public String getCrunchbase() {
		return _crunchbase;
	}

	public void setCrunchbase(String crunchbase) {
		_crunchbase = crunchbase;
	}

	public String getMobile() {
		return _mobile;
	}

	public void setMobile(String mobile) {
		_mobile = mobile;
	}

	public String getTotalFunds() {
		return _totalFunds;
	}

	public void setTotalFunds(String totalFunds) {
		_totalFunds = totalFunds;
	}

	public String getUen() {
		return _uen;
	}

	public void setUen(String uen) {
		_uen = uen;
	}

	public String getDescription() {
		return _description;
	}

	public void setDescription(String description) {
		_description = description;
	}

	public String getShortPitch() {
		return _shortPitch;
	}

	public void setShortPitch(String shortPitch) {
		_shortPitch = shortPitch;
	}

	public String getLifecycleStage() {
		return _lifecycleStage;
	}

	public void setLifecycleStage(String lifecycleStage) {
		_lifecycleStage = lifecycleStage;
	}

	public String getCapitalRaised() {
		return _capitalRaised;
	}

	public void setCapitalRaised(String capitalRaised) {
		_capitalRaised = capitalRaised;
	}

	public boolean getIsIncorporated() {
		return _isIncorporated;
	}

	public boolean isIsIncorporated() {
		return _isIncorporated;
	}

	public void setIsIncorporated(boolean isIncorporated) {
		_isIncorporated = isIncorporated;
	}

	public String getStockSymbol() {
		return _stockSymbol;
	}

	public void setStockSymbol(String stockSymbol) {
		_stockSymbol = stockSymbol;
	}

	public String getImageUrl() {
		return _imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;
	}

	public String getVideos() {
		return _videos;
	}

	public void setVideos(String videos) {
		_videos = videos;
	}

	public String getProfileOutline() {
		return _profileOutline;
	}

	public void setProfileOutline(String profileOutline) {
		_profileOutline = profileOutline;
	}

	public String getRaisingFunds() {
		return _raisingFunds;
	}

	public void setRaisingFunds(String raisingFunds) {
		_raisingFunds = raisingFunds;
	}

	public String getExtras() {
		return _extras;
	}

	public void setExtras(String extras) {
		_extras = extras;
	}

	public String getUniqueDesc() {
		return _uniqueDesc;
	}

	public void setUniqueDesc(String uniqueDesc) {
		_uniqueDesc = uniqueDesc;
	}

	public String getLinks() {
		return _links;
	}

	public void setLinks(String links) {
		_links = links;
	}

	public boolean getIsBaseOrg() {
		return _isBaseOrg;
	}

	public boolean isIsBaseOrg() {
		return _isBaseOrg;
	}

	public void setIsBaseOrg(boolean isBaseOrg) {
		_isBaseOrg = isBaseOrg;
	}

	public boolean getCompleteness() {
		return _completeness;
	}

	public boolean isCompleteness() {
		return _completeness;
	}

	public void setCompleteness(boolean completeness) {
		_completeness = completeness;
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

	public boolean getActive() {
		return _active;
	}

	public boolean isActive() {
		return _active;
	}

	public void setActive(boolean active) {
		_active = active;
	}

	public long getLogoId() {
		return _logoId;
	}

	public void setLogoId(long logoId) {
		_logoId = logoId;
	}

	public long getMethodologyType() {
		return _methodologyType;
	}

	public void setMethodologyType(long methodologyType) {
		_methodologyType = methodologyType;
	}

	public long getMethodologySubType() {
		return _methodologySubType;
	}

	public void setMethodologySubType(long methodologySubType) {
		_methodologySubType = methodologySubType;
	}

	public int getStage() {
		return _stage;
	}

	public void setStage(int stage) {
		_stage = stage;
	}

	public String getFeedback() {
		return _feedback;
	}

	public void setFeedback(String feedback) {
		_feedback = feedback;
	}

	public String getVideoLinks() {
		return _videoLinks;
	}

	public void setVideoLinks(String videoLinks) {
		_videoLinks = videoLinks;
	}

	public String getProjectsWorkedOn() {
		return _projectsWorkedOn;
	}

	public void setProjectsWorkedOn(String projectsWorkedOn) {
		_projectsWorkedOn = projectsWorkedOn;
	}

	public boolean getShowInBlackbook() {
		return _showInBlackbook;
	}

	public boolean isShowInBlackbook() {
		return _showInBlackbook;
	}

	public void setShowInBlackbook(boolean showInBlackbook) {
		_showInBlackbook = showInBlackbook;
	}

	public String getFaxNumber() {
		return _faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		_faxNumber = faxNumber;
	}

	public String getContactName() {
		return _contactName;
	}

	public void setContactName(String contactName) {
		_contactName = contactName;
	}

	public String getContactDesignation() {
		return _contactDesignation;
	}

	public void setContactDesignation(String contactDesignation) {
		_contactDesignation = contactDesignation;
	}

	public int getPipelineStatus() {
		return _pipelineStatus;
	}

	public void setPipelineStatus(int pipelineStatus) {
		_pipelineStatus = pipelineStatus;
	}

	public int getBusinessDevManager() {
		return _businessDevManager;
	}

	public void setBusinessDevManager(int businessDevManager) {
		_businessDevManager = businessDevManager;
	}

	public int getPrevBusinessDevManager() {
		return _prevBusinessDevManager;
	}

	public void setPrevBusinessDevManager(int prevBusinessDevManager) {
		_prevBusinessDevManager = prevBusinessDevManager;
	}

	public boolean getIsATO() {
		return _isATO;
	}

	public boolean isIsATO() {
		return _isATO;
	}

	public void setIsATO(boolean isATO) {
		_isATO = isATO;
	}

	public Date getApprovalDate() {
		return _approvalDate;
	}

	public void setApprovalDate(Date approvalDate) {
		_approvalDate = approvalDate;
	}

	public int getStatus() {
		return _status;
	}

	public void setStatus(int status) {
		_status = status;
	}

	public String getListedCo() {
		return _listedCo;
	}

	public void setListedCo(String listedCo) {
		_listedCo = listedCo;
	}

	public long getNoOfPotentialCandidates() {
		return _noOfPotentialCandidates;
	}

	public void setNoOfPotentialCandidates(long noOfPotentialCandidates) {
		_noOfPotentialCandidates = noOfPotentialCandidates;
	}

	private String _uuid;
	private long _organizationId;
	private String _name;
	private String _corporateCode;
	private String _corporateType;
	private String _corporateCategory;
	private String _apiPath;
	private String _categories;
	private String _foundedOn;
	private int _noOfEmployees;
	private String _emailId;
	private String _website;
	private String _facebook;
	private String _twitter;
	private String _linkedIn;
	private String _crunchbase;
	private String _mobile;
	private String _totalFunds;
	private String _uen;
	private String _description;
	private String _shortPitch;
	private String _lifecycleStage;
	private String _capitalRaised;
	private boolean _isIncorporated;
	private String _stockSymbol;
	private String _imageUrl;
	private String _videos;
	private String _profileOutline;
	private String _raisingFunds;
	private String _extras;
	private String _uniqueDesc;
	private String _links;
	private boolean _isBaseOrg;
	private boolean _completeness;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private boolean _active;
	private long _logoId;
	private long _methodologyType;
	private long _methodologySubType;
	private int _stage;
	private String _feedback;
	private String _videoLinks;
	private String _projectsWorkedOn;
	private boolean _showInBlackbook;
	private String _faxNumber;
	private String _contactName;
	private String _contactDesignation;
	private int _pipelineStatus;
	private int _businessDevManager;
	private int _prevBusinessDevManager;
	private boolean _isATO;
	private Date _approvalDate;
	private int _status;
	private String _listedCo;
	private long _noOfPotentialCandidates;
}