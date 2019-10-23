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
 * This class is a wrapper for {@link FundingRound}.
 * </p>
 *
 * @author pradeep
 * @see FundingRound
 * @generated
 */
public class FundingRoundWrapper implements FundingRound,
	ModelWrapper<FundingRound> {
	public FundingRoundWrapper(FundingRound fundingRound) {
		_fundingRound = fundingRound;
	}

	@Override
	public Class<?> getModelClass() {
		return FundingRound.class;
	}

	@Override
	public String getModelClassName() {
		return FundingRound.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("fundingRoundId", getFundingRoundId());
		attributes.put("organizationId", getOrganizationId());
		attributes.put("name", getName());
		attributes.put("apiPath", getApiPath());
		attributes.put("imageUrl", getImageUrl());
		attributes.put("announcedOn", getAnnouncedOn());
		attributes.put("moneyRaisedInUsd", getMoneyRaisedInUsd());
		attributes.put("fundingType", getFundingType());
		attributes.put("description", getDescription());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("active", getActive());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long fundingRoundId = (Long)attributes.get("fundingRoundId");

		if (fundingRoundId != null) {
			setFundingRoundId(fundingRoundId);
		}

		Long organizationId = (Long)attributes.get("organizationId");

		if (organizationId != null) {
			setOrganizationId(organizationId);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String apiPath = (String)attributes.get("apiPath");

		if (apiPath != null) {
			setApiPath(apiPath);
		}

		String imageUrl = (String)attributes.get("imageUrl");

		if (imageUrl != null) {
			setImageUrl(imageUrl);
		}

		String announcedOn = (String)attributes.get("announcedOn");

		if (announcedOn != null) {
			setAnnouncedOn(announcedOn);
		}

		String moneyRaisedInUsd = (String)attributes.get("moneyRaisedInUsd");

		if (moneyRaisedInUsd != null) {
			setMoneyRaisedInUsd(moneyRaisedInUsd);
		}

		String fundingType = (String)attributes.get("fundingType");

		if (fundingType != null) {
			setFundingType(fundingType);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
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
	}

	/**
	* Returns the primary key of this funding round.
	*
	* @return the primary key of this funding round
	*/
	@Override
	public long getPrimaryKey() {
		return _fundingRound.getPrimaryKey();
	}

	/**
	* Sets the primary key of this funding round.
	*
	* @param primaryKey the primary key of this funding round
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_fundingRound.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the uuid of this funding round.
	*
	* @return the uuid of this funding round
	*/
	@Override
	public java.lang.String getUuid() {
		return _fundingRound.getUuid();
	}

	/**
	* Sets the uuid of this funding round.
	*
	* @param uuid the uuid of this funding round
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_fundingRound.setUuid(uuid);
	}

	/**
	* Returns the funding round ID of this funding round.
	*
	* @return the funding round ID of this funding round
	*/
	@Override
	public long getFundingRoundId() {
		return _fundingRound.getFundingRoundId();
	}

	/**
	* Sets the funding round ID of this funding round.
	*
	* @param fundingRoundId the funding round ID of this funding round
	*/
	@Override
	public void setFundingRoundId(long fundingRoundId) {
		_fundingRound.setFundingRoundId(fundingRoundId);
	}

	/**
	* Returns the organization ID of this funding round.
	*
	* @return the organization ID of this funding round
	*/
	@Override
	public long getOrganizationId() {
		return _fundingRound.getOrganizationId();
	}

	/**
	* Sets the organization ID of this funding round.
	*
	* @param organizationId the organization ID of this funding round
	*/
	@Override
	public void setOrganizationId(long organizationId) {
		_fundingRound.setOrganizationId(organizationId);
	}

	/**
	* Returns the name of this funding round.
	*
	* @return the name of this funding round
	*/
	@Override
	public java.lang.String getName() {
		return _fundingRound.getName();
	}

	/**
	* Sets the name of this funding round.
	*
	* @param name the name of this funding round
	*/
	@Override
	public void setName(java.lang.String name) {
		_fundingRound.setName(name);
	}

	/**
	* Returns the api path of this funding round.
	*
	* @return the api path of this funding round
	*/
	@Override
	public java.lang.String getApiPath() {
		return _fundingRound.getApiPath();
	}

	/**
	* Sets the api path of this funding round.
	*
	* @param apiPath the api path of this funding round
	*/
	@Override
	public void setApiPath(java.lang.String apiPath) {
		_fundingRound.setApiPath(apiPath);
	}

	/**
	* Returns the image url of this funding round.
	*
	* @return the image url of this funding round
	*/
	@Override
	public java.lang.String getImageUrl() {
		return _fundingRound.getImageUrl();
	}

	/**
	* Sets the image url of this funding round.
	*
	* @param imageUrl the image url of this funding round
	*/
	@Override
	public void setImageUrl(java.lang.String imageUrl) {
		_fundingRound.setImageUrl(imageUrl);
	}

	/**
	* Returns the announced on of this funding round.
	*
	* @return the announced on of this funding round
	*/
	@Override
	public java.lang.String getAnnouncedOn() {
		return _fundingRound.getAnnouncedOn();
	}

	/**
	* Sets the announced on of this funding round.
	*
	* @param announcedOn the announced on of this funding round
	*/
	@Override
	public void setAnnouncedOn(java.lang.String announcedOn) {
		_fundingRound.setAnnouncedOn(announcedOn);
	}

	/**
	* Returns the money raised in usd of this funding round.
	*
	* @return the money raised in usd of this funding round
	*/
	@Override
	public java.lang.String getMoneyRaisedInUsd() {
		return _fundingRound.getMoneyRaisedInUsd();
	}

	/**
	* Sets the money raised in usd of this funding round.
	*
	* @param moneyRaisedInUsd the money raised in usd of this funding round
	*/
	@Override
	public void setMoneyRaisedInUsd(java.lang.String moneyRaisedInUsd) {
		_fundingRound.setMoneyRaisedInUsd(moneyRaisedInUsd);
	}

	/**
	* Returns the funding type of this funding round.
	*
	* @return the funding type of this funding round
	*/
	@Override
	public java.lang.String getFundingType() {
		return _fundingRound.getFundingType();
	}

	/**
	* Sets the funding type of this funding round.
	*
	* @param fundingType the funding type of this funding round
	*/
	@Override
	public void setFundingType(java.lang.String fundingType) {
		_fundingRound.setFundingType(fundingType);
	}

	/**
	* Returns the description of this funding round.
	*
	* @return the description of this funding round
	*/
	@Override
	public java.lang.String getDescription() {
		return _fundingRound.getDescription();
	}

	/**
	* Sets the description of this funding round.
	*
	* @param description the description of this funding round
	*/
	@Override
	public void setDescription(java.lang.String description) {
		_fundingRound.setDescription(description);
	}

	/**
	* Returns the group ID of this funding round.
	*
	* @return the group ID of this funding round
	*/
	@Override
	public long getGroupId() {
		return _fundingRound.getGroupId();
	}

	/**
	* Sets the group ID of this funding round.
	*
	* @param groupId the group ID of this funding round
	*/
	@Override
	public void setGroupId(long groupId) {
		_fundingRound.setGroupId(groupId);
	}

	/**
	* Returns the company ID of this funding round.
	*
	* @return the company ID of this funding round
	*/
	@Override
	public long getCompanyId() {
		return _fundingRound.getCompanyId();
	}

	/**
	* Sets the company ID of this funding round.
	*
	* @param companyId the company ID of this funding round
	*/
	@Override
	public void setCompanyId(long companyId) {
		_fundingRound.setCompanyId(companyId);
	}

	/**
	* Returns the user ID of this funding round.
	*
	* @return the user ID of this funding round
	*/
	@Override
	public long getUserId() {
		return _fundingRound.getUserId();
	}

	/**
	* Sets the user ID of this funding round.
	*
	* @param userId the user ID of this funding round
	*/
	@Override
	public void setUserId(long userId) {
		_fundingRound.setUserId(userId);
	}

	/**
	* Returns the user uuid of this funding round.
	*
	* @return the user uuid of this funding round
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.lang.String getUserUuid()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _fundingRound.getUserUuid();
	}

	/**
	* Sets the user uuid of this funding round.
	*
	* @param userUuid the user uuid of this funding round
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_fundingRound.setUserUuid(userUuid);
	}

	/**
	* Returns the user name of this funding round.
	*
	* @return the user name of this funding round
	*/
	@Override
	public java.lang.String getUserName() {
		return _fundingRound.getUserName();
	}

	/**
	* Sets the user name of this funding round.
	*
	* @param userName the user name of this funding round
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_fundingRound.setUserName(userName);
	}

	/**
	* Returns the create date of this funding round.
	*
	* @return the create date of this funding round
	*/
	@Override
	public java.util.Date getCreateDate() {
		return _fundingRound.getCreateDate();
	}

	/**
	* Sets the create date of this funding round.
	*
	* @param createDate the create date of this funding round
	*/
	@Override
	public void setCreateDate(java.util.Date createDate) {
		_fundingRound.setCreateDate(createDate);
	}

	/**
	* Returns the modified date of this funding round.
	*
	* @return the modified date of this funding round
	*/
	@Override
	public java.util.Date getModifiedDate() {
		return _fundingRound.getModifiedDate();
	}

	/**
	* Sets the modified date of this funding round.
	*
	* @param modifiedDate the modified date of this funding round
	*/
	@Override
	public void setModifiedDate(java.util.Date modifiedDate) {
		_fundingRound.setModifiedDate(modifiedDate);
	}

	/**
	* Returns the active of this funding round.
	*
	* @return the active of this funding round
	*/
	@Override
	public boolean getActive() {
		return _fundingRound.getActive();
	}

	/**
	* Returns <code>true</code> if this funding round is active.
	*
	* @return <code>true</code> if this funding round is active; <code>false</code> otherwise
	*/
	@Override
	public boolean isActive() {
		return _fundingRound.isActive();
	}

	/**
	* Sets whether this funding round is active.
	*
	* @param active the active of this funding round
	*/
	@Override
	public void setActive(boolean active) {
		_fundingRound.setActive(active);
	}

	@Override
	public boolean isNew() {
		return _fundingRound.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_fundingRound.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _fundingRound.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_fundingRound.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _fundingRound.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _fundingRound.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_fundingRound.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _fundingRound.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_fundingRound.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_fundingRound.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_fundingRound.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new FundingRoundWrapper((FundingRound)_fundingRound.clone());
	}

	@Override
	public int compareTo(
		com.sambaash.platform.srv.startupprofile.model.FundingRound fundingRound) {
		return _fundingRound.compareTo(fundingRound);
	}

	@Override
	public int hashCode() {
		return _fundingRound.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.sambaash.platform.srv.startupprofile.model.FundingRound> toCacheModel() {
		return _fundingRound.toCacheModel();
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound toEscapedModel() {
		return new FundingRoundWrapper(_fundingRound.toEscapedModel());
	}

	@Override
	public com.sambaash.platform.srv.startupprofile.model.FundingRound toUnescapedModel() {
		return new FundingRoundWrapper(_fundingRound.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _fundingRound.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _fundingRound.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_fundingRound.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FundingRoundWrapper)) {
			return false;
		}

		FundingRoundWrapper fundingRoundWrapper = (FundingRoundWrapper)obj;

		if (Validator.equals(_fundingRound, fundingRoundWrapper._fundingRound)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _fundingRound.getStagedModelType();
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public FundingRound getWrappedFundingRound() {
		return _fundingRound;
	}

	@Override
	public FundingRound getWrappedModel() {
		return _fundingRound;
	}

	@Override
	public void resetOriginalValues() {
		_fundingRound.resetOriginalValues();
	}

	private FundingRound _fundingRound;
}