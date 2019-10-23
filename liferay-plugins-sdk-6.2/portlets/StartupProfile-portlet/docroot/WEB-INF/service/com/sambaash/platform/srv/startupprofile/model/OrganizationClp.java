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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.util.PortalUtil;

import com.sambaash.platform.srv.startupprofile.service.ClpSerializer;
import com.sambaash.platform.srv.startupprofile.service.OrganizationLocalServiceUtil;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author pradeep
 */
public class OrganizationClp extends BaseModelImpl<Organization>
	implements Organization {
	public OrganizationClp() {
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
	public long getPrimaryKey() {
		return _organizationId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setOrganizationId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _organizationId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
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

	@Override
	public String getUuid() {
		return _uuid;
	}

	@Override
	public void setUuid(String uuid) {
		_uuid = uuid;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setUuid", String.class);

				method.invoke(_organizationRemoteModel, uuid);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrganizationId() {
		return _organizationId;
	}

	@Override
	public void setOrganizationId(long organizationId) {
		_organizationId = organizationId;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setOrganizationId", long.class);

				method.invoke(_organizationRemoteModel, organizationId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getName() {
		return _name;
	}

	@Override
	public void setName(String name) {
		_name = name;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setName", String.class);

				method.invoke(_organizationRemoteModel, name);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCorporateCode() {
		return _corporateCode;
	}

	@Override
	public void setCorporateCode(String corporateCode) {
		_corporateCode = corporateCode;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCorporateCode", String.class);

				method.invoke(_organizationRemoteModel, corporateCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCorporateType() {
		return _corporateType;
	}

	@Override
	public void setCorporateType(String corporateType) {
		_corporateType = corporateType;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCorporateType", String.class);

				method.invoke(_organizationRemoteModel, corporateType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCorporateCategory() {
		return _corporateCategory;
	}

	@Override
	public void setCorporateCategory(String corporateCategory) {
		_corporateCategory = corporateCategory;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCorporateCategory",
						String.class);

				method.invoke(_organizationRemoteModel, corporateCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getApiPath() {
		return _apiPath;
	}

	@Override
	public void setApiPath(String apiPath) {
		_apiPath = apiPath;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setApiPath", String.class);

				method.invoke(_organizationRemoteModel, apiPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategories() {
		return _categories;
	}

	@Override
	public void setCategories(String categories) {
		_categories = categories;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCategories", String.class);

				method.invoke(_organizationRemoteModel, categories);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFoundedOn() {
		return _foundedOn;
	}

	@Override
	public void setFoundedOn(String foundedOn) {
		_foundedOn = foundedOn;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setFoundedOn", String.class);

				method.invoke(_organizationRemoteModel, foundedOn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getNoOfEmployees() {
		return _noOfEmployees;
	}

	@Override
	public void setNoOfEmployees(int noOfEmployees) {
		_noOfEmployees = noOfEmployees;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setNoOfEmployees", int.class);

				method.invoke(_organizationRemoteModel, noOfEmployees);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getEmailId() {
		return _emailId;
	}

	@Override
	public void setEmailId(String emailId) {
		_emailId = emailId;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setEmailId", String.class);

				method.invoke(_organizationRemoteModel, emailId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWebsite() {
		return _website;
	}

	@Override
	public void setWebsite(String website) {
		_website = website;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setWebsite", String.class);

				method.invoke(_organizationRemoteModel, website);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFacebook() {
		return _facebook;
	}

	@Override
	public void setFacebook(String facebook) {
		_facebook = facebook;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setFacebook", String.class);

				method.invoke(_organizationRemoteModel, facebook);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTwitter() {
		return _twitter;
	}

	@Override
	public void setTwitter(String twitter) {
		_twitter = twitter;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setTwitter", String.class);

				method.invoke(_organizationRemoteModel, twitter);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinkedIn() {
		return _linkedIn;
	}

	@Override
	public void setLinkedIn(String linkedIn) {
		_linkedIn = linkedIn;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setLinkedIn", String.class);

				method.invoke(_organizationRemoteModel, linkedIn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCrunchbase() {
		return _crunchbase;
	}

	@Override
	public void setCrunchbase(String crunchbase) {
		_crunchbase = crunchbase;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCrunchbase", String.class);

				method.invoke(_organizationRemoteModel, crunchbase);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getMobile() {
		return _mobile;
	}

	@Override
	public void setMobile(String mobile) {
		_mobile = mobile;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setMobile", String.class);

				method.invoke(_organizationRemoteModel, mobile);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTotalFunds() {
		return _totalFunds;
	}

	@Override
	public void setTotalFunds(String totalFunds) {
		_totalFunds = totalFunds;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setTotalFunds", String.class);

				method.invoke(_organizationRemoteModel, totalFunds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUen() {
		return _uen;
	}

	@Override
	public void setUen(String uen) {
		_uen = uen;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setUen", String.class);

				method.invoke(_organizationRemoteModel, uen);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_organizationRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getShortPitch() {
		return _shortPitch;
	}

	@Override
	public void setShortPitch(String shortPitch) {
		_shortPitch = shortPitch;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setShortPitch", String.class);

				method.invoke(_organizationRemoteModel, shortPitch);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLifecycleStage() {
		return _lifecycleStage;
	}

	@Override
	public void setLifecycleStage(String lifecycleStage) {
		_lifecycleStage = lifecycleStage;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setLifecycleStage",
						String.class);

				method.invoke(_organizationRemoteModel, lifecycleStage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCapitalRaised() {
		return _capitalRaised;
	}

	@Override
	public void setCapitalRaised(String capitalRaised) {
		_capitalRaised = capitalRaised;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCapitalRaised", String.class);

				method.invoke(_organizationRemoteModel, capitalRaised);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsIncorporated() {
		return _isIncorporated;
	}

	@Override
	public boolean isIsIncorporated() {
		return _isIncorporated;
	}

	@Override
	public void setIsIncorporated(boolean isIncorporated) {
		_isIncorporated = isIncorporated;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsIncorporated",
						boolean.class);

				method.invoke(_organizationRemoteModel, isIncorporated);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStockSymbol() {
		return _stockSymbol;
	}

	@Override
	public void setStockSymbol(String stockSymbol) {
		_stockSymbol = stockSymbol;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setStockSymbol", String.class);

				method.invoke(_organizationRemoteModel, stockSymbol);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageUrl() {
		return _imageUrl;
	}

	@Override
	public void setImageUrl(String imageUrl) {
		_imageUrl = imageUrl;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setImageUrl", String.class);

				method.invoke(_organizationRemoteModel, imageUrl);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVideos() {
		return _videos;
	}

	@Override
	public void setVideos(String videos) {
		_videos = videos;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setVideos", String.class);

				method.invoke(_organizationRemoteModel, videos);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProfileOutline() {
		return _profileOutline;
	}

	@Override
	public void setProfileOutline(String profileOutline) {
		_profileOutline = profileOutline;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setProfileOutline",
						String.class);

				method.invoke(_organizationRemoteModel, profileOutline);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRaisingFunds() {
		return _raisingFunds;
	}

	@Override
	public void setRaisingFunds(String raisingFunds) {
		_raisingFunds = raisingFunds;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setRaisingFunds", String.class);

				method.invoke(_organizationRemoteModel, raisingFunds);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExtras() {
		return _extras;
	}

	@Override
	public void setExtras(String extras) {
		_extras = extras;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setExtras", String.class);

				method.invoke(_organizationRemoteModel, extras);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUniqueDesc() {
		return _uniqueDesc;
	}

	@Override
	public void setUniqueDesc(String uniqueDesc) {
		_uniqueDesc = uniqueDesc;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setUniqueDesc", String.class);

				method.invoke(_organizationRemoteModel, uniqueDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getLinks() {
		return _links;
	}

	@Override
	public void setLinks(String links) {
		_links = links;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setLinks", String.class);

				method.invoke(_organizationRemoteModel, links);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsBaseOrg() {
		return _isBaseOrg;
	}

	@Override
	public boolean isIsBaseOrg() {
		return _isBaseOrg;
	}

	@Override
	public void setIsBaseOrg(boolean isBaseOrg) {
		_isBaseOrg = isBaseOrg;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsBaseOrg", boolean.class);

				method.invoke(_organizationRemoteModel, isBaseOrg);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getCompleteness() {
		return _completeness;
	}

	@Override
	public boolean isCompleteness() {
		return _completeness;
	}

	@Override
	public void setCompleteness(boolean completeness) {
		_completeness = completeness;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompleteness", boolean.class);

				method.invoke(_organizationRemoteModel, completeness);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setGroupId", long.class);

				method.invoke(_organizationRemoteModel, groupId);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCompanyId", long.class);

				method.invoke(_organizationRemoteModel, companyId);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserId", long.class);

				method.invoke(_organizationRemoteModel, userId);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setUserName", String.class);

				method.invoke(_organizationRemoteModel, userName);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreateDate", Date.class);

				method.invoke(_organizationRemoteModel, createDate);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setModifiedDate", Date.class);

				method.invoke(_organizationRemoteModel, modifiedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getActive() {
		return _active;
	}

	@Override
	public boolean isActive() {
		return _active;
	}

	@Override
	public void setActive(boolean active) {
		_active = active;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setActive", boolean.class);

				method.invoke(_organizationRemoteModel, active);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLogoId() {
		return _logoId;
	}

	@Override
	public void setLogoId(long logoId) {
		_logoId = logoId;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setLogoId", long.class);

				method.invoke(_organizationRemoteModel, logoId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMethodologyType() {
		return _methodologyType;
	}

	@Override
	public void setMethodologyType(long methodologyType) {
		_methodologyType = methodologyType;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setMethodologyType", long.class);

				method.invoke(_organizationRemoteModel, methodologyType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getMethodologySubType() {
		return _methodologySubType;
	}

	@Override
	public void setMethodologySubType(long methodologySubType) {
		_methodologySubType = methodologySubType;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setMethodologySubType",
						long.class);

				method.invoke(_organizationRemoteModel, methodologySubType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getStage() {
		return _stage;
	}

	@Override
	public void setStage(int stage) {
		_stage = stage;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setStage", int.class);

				method.invoke(_organizationRemoteModel, stage);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFeedback() {
		return _feedback;
	}

	@Override
	public void setFeedback(String feedback) {
		_feedback = feedback;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setFeedback", String.class);

				method.invoke(_organizationRemoteModel, feedback);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getVideoLinks() {
		return _videoLinks;
	}

	@Override
	public void setVideoLinks(String videoLinks) {
		_videoLinks = videoLinks;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setVideoLinks", String.class);

				method.invoke(_organizationRemoteModel, videoLinks);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProjectsWorkedOn() {
		return _projectsWorkedOn;
	}

	@Override
	public void setProjectsWorkedOn(String projectsWorkedOn) {
		_projectsWorkedOn = projectsWorkedOn;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setProjectsWorkedOn",
						String.class);

				method.invoke(_organizationRemoteModel, projectsWorkedOn);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getShowInBlackbook() {
		return _showInBlackbook;
	}

	@Override
	public boolean isShowInBlackbook() {
		return _showInBlackbook;
	}

	@Override
	public void setShowInBlackbook(boolean showInBlackbook) {
		_showInBlackbook = showInBlackbook;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setShowInBlackbook",
						boolean.class);

				method.invoke(_organizationRemoteModel, showInBlackbook);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFaxNumber() {
		return _faxNumber;
	}

	@Override
	public void setFaxNumber(String faxNumber) {
		_faxNumber = faxNumber;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setFaxNumber", String.class);

				method.invoke(_organizationRemoteModel, faxNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactName() {
		return _contactName;
	}

	@Override
	public void setContactName(String contactName) {
		_contactName = contactName;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactName", String.class);

				method.invoke(_organizationRemoteModel, contactName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getContactDesignation() {
		return _contactDesignation;
	}

	@Override
	public void setContactDesignation(String contactDesignation) {
		_contactDesignation = contactDesignation;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setContactDesignation",
						String.class);

				method.invoke(_organizationRemoteModel, contactDesignation);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPipelineStatus() {
		return _pipelineStatus;
	}

	@Override
	public void setPipelineStatus(int pipelineStatus) {
		_pipelineStatus = pipelineStatus;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setPipelineStatus", int.class);

				method.invoke(_organizationRemoteModel, pipelineStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getBusinessDevManager() {
		return _businessDevManager;
	}

	@Override
	public void setBusinessDevManager(int businessDevManager) {
		_businessDevManager = businessDevManager;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessDevManager",
						int.class);

				method.invoke(_organizationRemoteModel, businessDevManager);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPrevBusinessDevManager() {
		return _prevBusinessDevManager;
	}

	@Override
	public void setPrevBusinessDevManager(int prevBusinessDevManager) {
		_prevBusinessDevManager = prevBusinessDevManager;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setPrevBusinessDevManager",
						int.class);

				method.invoke(_organizationRemoteModel, prevBusinessDevManager);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean getIsATO() {
		return _isATO;
	}

	@Override
	public boolean isIsATO() {
		return _isATO;
	}

	@Override
	public void setIsATO(boolean isATO) {
		_isATO = isATO;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setIsATO", boolean.class);

				method.invoke(_organizationRemoteModel, isATO);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getApprovalDate() {
		return _approvalDate;
	}

	@Override
	public void setApprovalDate(Date approvalDate) {
		_approvalDate = approvalDate;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setApprovalDate", Date.class);

				method.invoke(_organizationRemoteModel, approvalDate);
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

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", int.class);

				method.invoke(_organizationRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getListedCo() {
		return _listedCo;
	}

	@Override
	public void setListedCo(String listedCo) {
		_listedCo = listedCo;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setListedCo", String.class);

				method.invoke(_organizationRemoteModel, listedCo);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getNoOfPotentialCandidates() {
		return _noOfPotentialCandidates;
	}

	@Override
	public void setNoOfPotentialCandidates(long noOfPotentialCandidates) {
		_noOfPotentialCandidates = noOfPotentialCandidates;

		if (_organizationRemoteModel != null) {
			try {
				Class<?> clazz = _organizationRemoteModel.getClass();

				Method method = clazz.getMethod("setNoOfPotentialCandidates",
						long.class);

				method.invoke(_organizationRemoteModel, noOfPotentialCandidates);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public StagedModelType getStagedModelType() {
		return new StagedModelType(PortalUtil.getClassNameId(
				Organization.class.getName()));
	}

	public BaseModel<?> getOrganizationRemoteModel() {
		return _organizationRemoteModel;
	}

	public void setOrganizationRemoteModel(BaseModel<?> organizationRemoteModel) {
		_organizationRemoteModel = organizationRemoteModel;
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

		Class<?> remoteModelClass = _organizationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_organizationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			OrganizationLocalServiceUtil.addOrganization(this);
		}
		else {
			OrganizationLocalServiceUtil.updateOrganization(this);
		}
	}

	@Override
	public Organization toEscapedModel() {
		return (Organization)ProxyUtil.newProxyInstance(Organization.class.getClassLoader(),
			new Class[] { Organization.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		OrganizationClp clone = new OrganizationClp();

		clone.setUuid(getUuid());
		clone.setOrganizationId(getOrganizationId());
		clone.setName(getName());
		clone.setCorporateCode(getCorporateCode());
		clone.setCorporateType(getCorporateType());
		clone.setCorporateCategory(getCorporateCategory());
		clone.setApiPath(getApiPath());
		clone.setCategories(getCategories());
		clone.setFoundedOn(getFoundedOn());
		clone.setNoOfEmployees(getNoOfEmployees());
		clone.setEmailId(getEmailId());
		clone.setWebsite(getWebsite());
		clone.setFacebook(getFacebook());
		clone.setTwitter(getTwitter());
		clone.setLinkedIn(getLinkedIn());
		clone.setCrunchbase(getCrunchbase());
		clone.setMobile(getMobile());
		clone.setTotalFunds(getTotalFunds());
		clone.setUen(getUen());
		clone.setDescription(getDescription());
		clone.setShortPitch(getShortPitch());
		clone.setLifecycleStage(getLifecycleStage());
		clone.setCapitalRaised(getCapitalRaised());
		clone.setIsIncorporated(getIsIncorporated());
		clone.setStockSymbol(getStockSymbol());
		clone.setImageUrl(getImageUrl());
		clone.setVideos(getVideos());
		clone.setProfileOutline(getProfileOutline());
		clone.setRaisingFunds(getRaisingFunds());
		clone.setExtras(getExtras());
		clone.setUniqueDesc(getUniqueDesc());
		clone.setLinks(getLinks());
		clone.setIsBaseOrg(getIsBaseOrg());
		clone.setCompleteness(getCompleteness());
		clone.setGroupId(getGroupId());
		clone.setCompanyId(getCompanyId());
		clone.setUserId(getUserId());
		clone.setUserName(getUserName());
		clone.setCreateDate(getCreateDate());
		clone.setModifiedDate(getModifiedDate());
		clone.setActive(getActive());
		clone.setLogoId(getLogoId());
		clone.setMethodologyType(getMethodologyType());
		clone.setMethodologySubType(getMethodologySubType());
		clone.setStage(getStage());
		clone.setFeedback(getFeedback());
		clone.setVideoLinks(getVideoLinks());
		clone.setProjectsWorkedOn(getProjectsWorkedOn());
		clone.setShowInBlackbook(getShowInBlackbook());
		clone.setFaxNumber(getFaxNumber());
		clone.setContactName(getContactName());
		clone.setContactDesignation(getContactDesignation());
		clone.setPipelineStatus(getPipelineStatus());
		clone.setBusinessDevManager(getBusinessDevManager());
		clone.setPrevBusinessDevManager(getPrevBusinessDevManager());
		clone.setIsATO(getIsATO());
		clone.setApprovalDate(getApprovalDate());
		clone.setStatus(getStatus());
		clone.setListedCo(getListedCo());
		clone.setNoOfPotentialCandidates(getNoOfPotentialCandidates());

		return clone;
	}

	@Override
	public int compareTo(Organization organization) {
		int value = 0;

		value = getName().compareToIgnoreCase(organization.getName());

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

		if (!(obj instanceof OrganizationClp)) {
			return false;
		}

		OrganizationClp organization = (OrganizationClp)obj;

		long primaryKey = organization.getPrimaryKey();

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
		StringBundler sb = new StringBundler(121);

		sb.append("{uuid=");
		sb.append(getUuid());
		sb.append(", organizationId=");
		sb.append(getOrganizationId());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", corporateCode=");
		sb.append(getCorporateCode());
		sb.append(", corporateType=");
		sb.append(getCorporateType());
		sb.append(", corporateCategory=");
		sb.append(getCorporateCategory());
		sb.append(", apiPath=");
		sb.append(getApiPath());
		sb.append(", categories=");
		sb.append(getCategories());
		sb.append(", foundedOn=");
		sb.append(getFoundedOn());
		sb.append(", noOfEmployees=");
		sb.append(getNoOfEmployees());
		sb.append(", emailId=");
		sb.append(getEmailId());
		sb.append(", website=");
		sb.append(getWebsite());
		sb.append(", facebook=");
		sb.append(getFacebook());
		sb.append(", twitter=");
		sb.append(getTwitter());
		sb.append(", linkedIn=");
		sb.append(getLinkedIn());
		sb.append(", crunchbase=");
		sb.append(getCrunchbase());
		sb.append(", mobile=");
		sb.append(getMobile());
		sb.append(", totalFunds=");
		sb.append(getTotalFunds());
		sb.append(", uen=");
		sb.append(getUen());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", shortPitch=");
		sb.append(getShortPitch());
		sb.append(", lifecycleStage=");
		sb.append(getLifecycleStage());
		sb.append(", capitalRaised=");
		sb.append(getCapitalRaised());
		sb.append(", isIncorporated=");
		sb.append(getIsIncorporated());
		sb.append(", stockSymbol=");
		sb.append(getStockSymbol());
		sb.append(", imageUrl=");
		sb.append(getImageUrl());
		sb.append(", videos=");
		sb.append(getVideos());
		sb.append(", profileOutline=");
		sb.append(getProfileOutline());
		sb.append(", raisingFunds=");
		sb.append(getRaisingFunds());
		sb.append(", extras=");
		sb.append(getExtras());
		sb.append(", uniqueDesc=");
		sb.append(getUniqueDesc());
		sb.append(", links=");
		sb.append(getLinks());
		sb.append(", isBaseOrg=");
		sb.append(getIsBaseOrg());
		sb.append(", completeness=");
		sb.append(getCompleteness());
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
		sb.append(", active=");
		sb.append(getActive());
		sb.append(", logoId=");
		sb.append(getLogoId());
		sb.append(", methodologyType=");
		sb.append(getMethodologyType());
		sb.append(", methodologySubType=");
		sb.append(getMethodologySubType());
		sb.append(", stage=");
		sb.append(getStage());
		sb.append(", feedback=");
		sb.append(getFeedback());
		sb.append(", videoLinks=");
		sb.append(getVideoLinks());
		sb.append(", projectsWorkedOn=");
		sb.append(getProjectsWorkedOn());
		sb.append(", showInBlackbook=");
		sb.append(getShowInBlackbook());
		sb.append(", faxNumber=");
		sb.append(getFaxNumber());
		sb.append(", contactName=");
		sb.append(getContactName());
		sb.append(", contactDesignation=");
		sb.append(getContactDesignation());
		sb.append(", pipelineStatus=");
		sb.append(getPipelineStatus());
		sb.append(", businessDevManager=");
		sb.append(getBusinessDevManager());
		sb.append(", prevBusinessDevManager=");
		sb.append(getPrevBusinessDevManager());
		sb.append(", isATO=");
		sb.append(getIsATO());
		sb.append(", approvalDate=");
		sb.append(getApprovalDate());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", listedCo=");
		sb.append(getListedCo());
		sb.append(", noOfPotentialCandidates=");
		sb.append(getNoOfPotentialCandidates());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(184);

		sb.append("<model><model-name>");
		sb.append("com.sambaash.platform.srv.startupprofile.model.Organization");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>uuid</column-name><column-value><![CDATA[");
		sb.append(getUuid());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>organizationId</column-name><column-value><![CDATA[");
		sb.append(getOrganizationId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporateCode</column-name><column-value><![CDATA[");
		sb.append(getCorporateCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporateType</column-name><column-value><![CDATA[");
		sb.append(getCorporateType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>corporateCategory</column-name><column-value><![CDATA[");
		sb.append(getCorporateCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>apiPath</column-name><column-value><![CDATA[");
		sb.append(getApiPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>categories</column-name><column-value><![CDATA[");
		sb.append(getCategories());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>foundedOn</column-name><column-value><![CDATA[");
		sb.append(getFoundedOn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noOfEmployees</column-name><column-value><![CDATA[");
		sb.append(getNoOfEmployees());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>emailId</column-name><column-value><![CDATA[");
		sb.append(getEmailId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>website</column-name><column-value><![CDATA[");
		sb.append(getWebsite());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>facebook</column-name><column-value><![CDATA[");
		sb.append(getFacebook());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>twitter</column-name><column-value><![CDATA[");
		sb.append(getTwitter());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>linkedIn</column-name><column-value><![CDATA[");
		sb.append(getLinkedIn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>crunchbase</column-name><column-value><![CDATA[");
		sb.append(getCrunchbase());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>mobile</column-name><column-value><![CDATA[");
		sb.append(getMobile());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>totalFunds</column-name><column-value><![CDATA[");
		sb.append(getTotalFunds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uen</column-name><column-value><![CDATA[");
		sb.append(getUen());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>shortPitch</column-name><column-value><![CDATA[");
		sb.append(getShortPitch());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>lifecycleStage</column-name><column-value><![CDATA[");
		sb.append(getLifecycleStage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>capitalRaised</column-name><column-value><![CDATA[");
		sb.append(getCapitalRaised());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isIncorporated</column-name><column-value><![CDATA[");
		sb.append(getIsIncorporated());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stockSymbol</column-name><column-value><![CDATA[");
		sb.append(getStockSymbol());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageUrl</column-name><column-value><![CDATA[");
		sb.append(getImageUrl());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videos</column-name><column-value><![CDATA[");
		sb.append(getVideos());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profileOutline</column-name><column-value><![CDATA[");
		sb.append(getProfileOutline());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>raisingFunds</column-name><column-value><![CDATA[");
		sb.append(getRaisingFunds());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>extras</column-name><column-value><![CDATA[");
		sb.append(getExtras());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>uniqueDesc</column-name><column-value><![CDATA[");
		sb.append(getUniqueDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>links</column-name><column-value><![CDATA[");
		sb.append(getLinks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isBaseOrg</column-name><column-value><![CDATA[");
		sb.append(getIsBaseOrg());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>completeness</column-name><column-value><![CDATA[");
		sb.append(getCompleteness());
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
			"<column><column-name>active</column-name><column-value><![CDATA[");
		sb.append(getActive());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>logoId</column-name><column-value><![CDATA[");
		sb.append(getLogoId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>methodologyType</column-name><column-value><![CDATA[");
		sb.append(getMethodologyType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>methodologySubType</column-name><column-value><![CDATA[");
		sb.append(getMethodologySubType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stage</column-name><column-value><![CDATA[");
		sb.append(getStage());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>feedback</column-name><column-value><![CDATA[");
		sb.append(getFeedback());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>videoLinks</column-name><column-value><![CDATA[");
		sb.append(getVideoLinks());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>projectsWorkedOn</column-name><column-value><![CDATA[");
		sb.append(getProjectsWorkedOn());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>showInBlackbook</column-name><column-value><![CDATA[");
		sb.append(getShowInBlackbook());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>faxNumber</column-name><column-value><![CDATA[");
		sb.append(getFaxNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactName</column-name><column-value><![CDATA[");
		sb.append(getContactName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>contactDesignation</column-name><column-value><![CDATA[");
		sb.append(getContactDesignation());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pipelineStatus</column-name><column-value><![CDATA[");
		sb.append(getPipelineStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessDevManager</column-name><column-value><![CDATA[");
		sb.append(getBusinessDevManager());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>prevBusinessDevManager</column-name><column-value><![CDATA[");
		sb.append(getPrevBusinessDevManager());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isATO</column-name><column-value><![CDATA[");
		sb.append(getIsATO());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>approvalDate</column-name><column-value><![CDATA[");
		sb.append(getApprovalDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>listedCo</column-name><column-value><![CDATA[");
		sb.append(getListedCo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>noOfPotentialCandidates</column-name><column-value><![CDATA[");
		sb.append(getNoOfPotentialCandidates());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
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
	private String _userUuid;
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
	private BaseModel<?> _organizationRemoteModel;
	private Class<?> _clpSerializerClass = com.sambaash.platform.srv.startupprofile.service.ClpSerializer.class;
}